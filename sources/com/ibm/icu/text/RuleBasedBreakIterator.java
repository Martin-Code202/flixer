package com.ibm.icu.text;

import com.ibm.icu.impl.CharTrie;
import com.ibm.icu.impl.CharacterIteration;
import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.DictionaryBreakEngine;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
public class RuleBasedBreakIterator extends BreakIterator {
    static final /* synthetic */ boolean $assertionsDisabled = (!RuleBasedBreakIterator.class.desiredAssertionStatus());
    private static final boolean TRACE = (ICUDebug.enabled("rbbi") && ICUDebug.value("rbbi").indexOf("trace") >= 0);
    static final String fDebugEnv = (ICUDebug.enabled("rbbi") ? ICUDebug.value("rbbi") : null);
    private static final List<LanguageBreakEngine> gAllBreakEngines = new ArrayList();
    private static final UnhandledBreakEngine gUnhandledBreakEngine = new UnhandledBreakEngine();
    private List<LanguageBreakEngine> fBreakEngines;
    private int fBreakType = 2;
    private int[] fCachedBreakPositions;
    private int fDictionaryCharCount = 0;
    private int fLastRuleStatusIndex;
    private boolean fLastStatusIndexValid = true;
    private LookAheadResults fLookAheadMatches = new LookAheadResults();
    private int fPositionInCache;
    RBBIDataWrapper fRData;
    private CharacterIterator fText = new StringCharacterIterator("");

    static {
        gAllBreakEngines.add(gUnhandledBreakEngine);
    }

    private RuleBasedBreakIterator() {
        synchronized (gAllBreakEngines) {
            this.fBreakEngines = new ArrayList(gAllBreakEngines);
        }
    }

    @Deprecated
    public static RuleBasedBreakIterator getInstanceFromCompiledRules(ByteBuffer byteBuffer) {
        RuleBasedBreakIterator ruleBasedBreakIterator = new RuleBasedBreakIterator();
        ruleBasedBreakIterator.fRData = RBBIDataWrapper.get(byteBuffer);
        return ruleBasedBreakIterator;
    }

    @Override // com.ibm.icu.text.BreakIterator, java.lang.Object
    public Object clone() {
        RuleBasedBreakIterator ruleBasedBreakIterator = (RuleBasedBreakIterator) super.clone();
        if (this.fText != null) {
            ruleBasedBreakIterator.fText = (CharacterIterator) this.fText.clone();
        }
        synchronized (gAllBreakEngines) {
            ruleBasedBreakIterator.fBreakEngines = new ArrayList(gAllBreakEngines);
        }
        ruleBasedBreakIterator.fLookAheadMatches = new LookAheadResults();
        if (this.fCachedBreakPositions != null) {
            ruleBasedBreakIterator.fCachedBreakPositions = (int[]) this.fCachedBreakPositions.clone();
        }
        return ruleBasedBreakIterator;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        try {
            RuleBasedBreakIterator ruleBasedBreakIterator = (RuleBasedBreakIterator) obj;
            if (this.fRData != ruleBasedBreakIterator.fRData && (this.fRData == null || ruleBasedBreakIterator.fRData == null)) {
                return false;
            }
            if (this.fRData != null && ruleBasedBreakIterator.fRData != null && !this.fRData.fRuleSource.equals(ruleBasedBreakIterator.fRData.fRuleSource)) {
                return false;
            }
            if (this.fText == null && ruleBasedBreakIterator.fText == null) {
                return true;
            }
            if (this.fText == null || ruleBasedBreakIterator.fText == null) {
                return false;
            }
            return this.fText.equals(ruleBasedBreakIterator.fText);
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override // java.lang.Object
    public String toString() {
        if (this.fRData != null) {
            return this.fRData.fRuleSource;
        }
        return "";
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.fRData.fRuleSource.hashCode();
    }

    private void reset() {
        this.fCachedBreakPositions = null;
        this.fDictionaryCharCount = 0;
        this.fPositionInCache = 0;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int first() {
        this.fCachedBreakPositions = null;
        this.fDictionaryCharCount = 0;
        this.fPositionInCache = 0;
        this.fLastRuleStatusIndex = 0;
        this.fLastStatusIndexValid = true;
        if (this.fText == null) {
            return -1;
        }
        this.fText.first();
        return this.fText.getIndex();
    }

    public int last() {
        this.fCachedBreakPositions = null;
        this.fDictionaryCharCount = 0;
        this.fPositionInCache = 0;
        if (this.fText == null) {
            this.fLastRuleStatusIndex = 0;
            this.fLastStatusIndexValid = true;
            return -1;
        }
        this.fLastStatusIndexValid = false;
        int endIndex = this.fText.getEndIndex();
        this.fText.setIndex(endIndex);
        return endIndex;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int next() {
        if (this.fCachedBreakPositions != null) {
            if (this.fPositionInCache < this.fCachedBreakPositions.length - 1) {
                this.fPositionInCache++;
                int i = this.fCachedBreakPositions[this.fPositionInCache];
                this.fText.setIndex(i);
                return i;
            }
            reset();
        }
        int current = current();
        this.fDictionaryCharCount = 0;
        int handleNext = handleNext(this.fRData.fFTable);
        if (this.fDictionaryCharCount > 0) {
            return checkDictionary(current, handleNext, false);
        }
        return handleNext;
    }

    private int checkDictionary(int i, int i2, boolean z) {
        int previous32;
        short codePointValue;
        int current32;
        short codePointValue2;
        reset();
        if (i2 - i <= 1) {
            return z ? i : i2;
        }
        this.fText.setIndex(z ? i2 : i);
        if (z) {
            CharacterIteration.previous32(this.fText);
        }
        int i3 = i;
        int i4 = i2;
        DictionaryBreakEngine.DequeI dequeI = new DictionaryBreakEngine.DequeI();
        int i5 = 0;
        int current322 = CharacterIteration.current32(this.fText);
        short codePointValue3 = (short) this.fRData.fTrie.getCodePointValue(current322);
        if ((codePointValue3 & 16384) != 0) {
            if (z) {
                do {
                    CharacterIteration.next32(this.fText);
                    current32 = CharacterIteration.current32(this.fText);
                    codePointValue2 = (short) this.fRData.fTrie.getCodePointValue(current32);
                    if (current32 == Integer.MAX_VALUE) {
                        break;
                    }
                } while ((codePointValue2 & 16384) != 0);
                i4 = this.fText.getIndex();
                if (current32 == Integer.MAX_VALUE) {
                    current322 = CharacterIteration.previous32(this.fText);
                } else {
                    current322 = CharacterIteration.previous32(this.fText);
                }
            } else {
                do {
                    previous32 = CharacterIteration.previous32(this.fText);
                    codePointValue = (short) this.fRData.fTrie.getCodePointValue(previous32);
                    if (previous32 == Integer.MAX_VALUE) {
                        break;
                    }
                } while ((codePointValue & 16384) != 0);
                if (previous32 == Integer.MAX_VALUE) {
                    current322 = CharacterIteration.current32(this.fText);
                } else {
                    CharacterIteration.next32(this.fText);
                    current322 = CharacterIteration.current32(this.fText);
                }
                i3 = this.fText.getIndex();
            }
            codePointValue3 = (short) this.fRData.fTrie.getCodePointValue(current322);
        }
        if (z) {
            this.fText.setIndex(i3);
            current322 = CharacterIteration.current32(this.fText);
            codePointValue3 = (short) this.fRData.fTrie.getCodePointValue(current322);
        }
        LanguageBreakEngine languageBreakEngine = null;
        while (true) {
            int index = this.fText.getIndex();
            if (index < i4 && (codePointValue3 & 16384) == 0) {
                CharacterIteration.next32(this.fText);
                current322 = CharacterIteration.current32(this.fText);
                codePointValue3 = (short) this.fRData.fTrie.getCodePointValue(current322);
            } else if (index < i4) {
                languageBreakEngine = getLanguageBreakEngine(current322);
                if (languageBreakEngine != null) {
                    int index2 = this.fText.getIndex();
                    i5 += languageBreakEngine.findBreaks(this.fText, i3, i4, false, this.fBreakType, dequeI);
                    if (!$assertionsDisabled && this.fText.getIndex() <= index2) {
                        throw new AssertionError();
                    }
                }
                current322 = CharacterIteration.current32(this.fText);
                codePointValue3 = (short) this.fRData.fTrie.getCodePointValue(current322);
            } else if (i5 > 0) {
                if (i5 != dequeI.size()) {
                    System.out.println("oops, foundBreakCount != breaks.size().  LBE = " + languageBreakEngine.getClass());
                }
                if ($assertionsDisabled || i5 == dequeI.size()) {
                    if (i < dequeI.peekLast()) {
                        dequeI.offer(i);
                    }
                    if (i2 > dequeI.peek()) {
                        dequeI.push(i2);
                    }
                    this.fCachedBreakPositions = new int[dequeI.size()];
                    int i6 = 0;
                    while (dequeI.size() > 0) {
                        i6++;
                        this.fCachedBreakPositions[i6] = dequeI.pollLast();
                    }
                    if (z) {
                        return preceding(i2);
                    }
                    return following(i);
                }
                throw new AssertionError();
            } else {
                this.fText.setIndex(z ? i : i2);
                return z ? i : i2;
            }
        }
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int previous() {
        CharacterIterator text = getText();
        this.fLastStatusIndexValid = false;
        if (this.fCachedBreakPositions != null) {
            if (this.fPositionInCache > 0) {
                this.fPositionInCache--;
                if (this.fPositionInCache <= 0) {
                    this.fLastStatusIndexValid = false;
                }
                int i = this.fCachedBreakPositions[this.fPositionInCache];
                text.setIndex(i);
                return i;
            }
            reset();
        }
        int current = current();
        if (this.fText == null || current == this.fText.getBeginIndex()) {
            this.fLastRuleStatusIndex = 0;
            this.fLastStatusIndexValid = true;
            return -1;
        } else if (this.fRData.fSRTable == null && this.fRData.fSFTable == null) {
            int current2 = current();
            CharacterIteration.previous32(this.fText);
            int handlePrevious = handlePrevious(this.fRData.fRTable);
            if (handlePrevious == -1) {
                handlePrevious = this.fText.getBeginIndex();
                this.fText.setIndex(handlePrevious);
            }
            int i2 = 0;
            boolean z = false;
            while (true) {
                int next = next();
                if (next == -1 || next >= current2) {
                    break;
                }
                handlePrevious = next;
                i2 = this.fLastRuleStatusIndex;
                z = true;
            }
            this.fText.setIndex(handlePrevious);
            this.fLastRuleStatusIndex = i2;
            this.fLastStatusIndexValid = z;
            return handlePrevious;
        } else {
            int handlePrevious2 = handlePrevious(this.fRData.fRTable);
            if (this.fDictionaryCharCount > 0) {
                return checkDictionary(handlePrevious2, current, true);
            }
            return handlePrevious2;
        }
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int following(int i) {
        CharacterIterator text = getText();
        if (this.fCachedBreakPositions == null || i < this.fCachedBreakPositions[0] || i >= this.fCachedBreakPositions[this.fCachedBreakPositions.length - 1]) {
            this.fCachedBreakPositions = null;
            return rulesFollowing(i);
        }
        this.fPositionInCache = 0;
        while (this.fPositionInCache < this.fCachedBreakPositions.length && i >= this.fCachedBreakPositions[this.fPositionInCache]) {
            this.fPositionInCache++;
        }
        text.setIndex(this.fCachedBreakPositions[this.fPositionInCache]);
        return text.getIndex();
    }

    private int rulesFollowing(int i) {
        this.fLastRuleStatusIndex = 0;
        this.fLastStatusIndexValid = true;
        if (this.fText == null || i >= this.fText.getEndIndex()) {
            last();
            return next();
        } else if (i < this.fText.getBeginIndex()) {
            return first();
        } else {
            if (this.fRData.fSRTable != null) {
                this.fText.setIndex(i);
                CharacterIteration.next32(this.fText);
                handlePrevious(this.fRData.fSRTable);
                int next = next();
                while (next <= i) {
                    next = next();
                }
                return next;
            } else if (this.fRData.fSFTable != null) {
                this.fText.setIndex(i);
                CharacterIteration.previous32(this.fText);
                handleNext(this.fRData.fSFTable);
                int previous = previous();
                while (previous > i) {
                    int previous2 = previous();
                    if (previous2 <= i) {
                        return previous;
                    }
                    previous = previous2;
                }
                int next2 = next();
                if (next2 <= i) {
                    return next();
                }
                return next2;
            } else {
                this.fText.setIndex(i);
                if (i == this.fText.getBeginIndex()) {
                    return next();
                }
                int previous3 = previous();
                while (previous3 != -1 && previous3 <= i) {
                    previous3 = next();
                }
                return previous3;
            }
        }
    }

    @Override // com.ibm.icu.text.BreakIterator
    public int preceding(int i) {
        CharacterIterator text = getText();
        if (this.fCachedBreakPositions == null || i <= this.fCachedBreakPositions[0] || i > this.fCachedBreakPositions[this.fCachedBreakPositions.length - 1]) {
            this.fCachedBreakPositions = null;
            return rulesPreceding(i);
        }
        this.fPositionInCache = 0;
        while (this.fPositionInCache < this.fCachedBreakPositions.length && i > this.fCachedBreakPositions[this.fPositionInCache]) {
            this.fPositionInCache++;
        }
        this.fPositionInCache--;
        text.setIndex(this.fCachedBreakPositions[this.fPositionInCache]);
        return text.getIndex();
    }

    private int rulesPreceding(int i) {
        if (this.fText == null || i > this.fText.getEndIndex()) {
            return last();
        }
        if (i < this.fText.getBeginIndex()) {
            return first();
        }
        if (this.fRData.fSFTable != null) {
            this.fText.setIndex(i);
            CharacterIteration.previous32(this.fText);
            handleNext(this.fRData.fSFTable);
            int previous = previous();
            while (previous >= i) {
                previous = previous();
            }
            return previous;
        } else if (this.fRData.fSRTable != null) {
            this.fText.setIndex(i);
            CharacterIteration.next32(this.fText);
            handlePrevious(this.fRData.fSRTable);
            int next = next();
            while (next < i) {
                int next2 = next();
                if (next2 >= i) {
                    return next;
                }
                next = next2;
            }
            int previous2 = previous();
            if (previous2 >= i) {
                return previous();
            }
            return previous2;
        } else {
            this.fText.setIndex(i);
            return previous();
        }
    }

    public int current() {
        if (this.fText != null) {
            return this.fText.getIndex();
        }
        return -1;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public CharacterIterator getText() {
        return this.fText;
    }

    @Override // com.ibm.icu.text.BreakIterator
    public void setText(CharacterIterator characterIterator) {
        this.fText = characterIterator;
        first();
    }

    /* access modifiers changed from: package-private */
    public void setBreakType(int i) {
        this.fBreakType = i;
    }

    /* access modifiers changed from: package-private */
    public int getBreakType() {
        return this.fBreakType;
    }

    private LanguageBreakEngine getLanguageBreakEngine(int i) {
        LanguageBreakEngine languageBreakEngine;
        for (LanguageBreakEngine languageBreakEngine2 : this.fBreakEngines) {
            if (languageBreakEngine2.handles(i, this.fBreakType)) {
                return languageBreakEngine2;
            }
        }
        synchronized (gAllBreakEngines) {
            for (LanguageBreakEngine languageBreakEngine3 : gAllBreakEngines) {
                if (languageBreakEngine3.handles(i, this.fBreakType)) {
                    this.fBreakEngines.add(languageBreakEngine3);
                    return languageBreakEngine3;
                }
            }
            int intPropertyValue = UCharacter.getIntPropertyValue(i, 4106);
            if (intPropertyValue == 22 || intPropertyValue == 20) {
                intPropertyValue = 17;
            }
            switch (intPropertyValue) {
                case 17:
                    if (getBreakType() == 1) {
                        languageBreakEngine = new CjkBreakEngine(false);
                        break;
                    } else {
                        gUnhandledBreakEngine.handleChar(i, getBreakType());
                        languageBreakEngine = gUnhandledBreakEngine;
                        break;
                    }
                case 18:
                    if (getBreakType() == 1) {
                        languageBreakEngine = new CjkBreakEngine(true);
                        break;
                    } else {
                        gUnhandledBreakEngine.handleChar(i, getBreakType());
                        languageBreakEngine = gUnhandledBreakEngine;
                        break;
                    }
                case 23:
                    languageBreakEngine = new KhmerBreakEngine();
                    break;
                case 24:
                    languageBreakEngine = new LaoBreakEngine();
                    break;
                case 28:
                    languageBreakEngine = new BurmeseBreakEngine();
                    break;
                case 38:
                    try {
                        languageBreakEngine = new ThaiBreakEngine();
                        break;
                    } catch (IOException e) {
                        languageBreakEngine = null;
                        break;
                    }
                default:
                    gUnhandledBreakEngine.handleChar(i, getBreakType());
                    languageBreakEngine = gUnhandledBreakEngine;
                    break;
            }
            if (!(languageBreakEngine == null || languageBreakEngine == gUnhandledBreakEngine)) {
                gAllBreakEngines.add(languageBreakEngine);
                this.fBreakEngines.add(languageBreakEngine);
            }
            return languageBreakEngine;
        }
    }

    /* access modifiers changed from: package-private */
    public static class LookAheadResults {
        static final /* synthetic */ boolean $assertionsDisabled = (!RuleBasedBreakIterator.class.desiredAssertionStatus());
        int[] fKeys = new int[8];
        int[] fPositions = new int[8];
        int fUsedSlotLimit = 0;

        LookAheadResults() {
        }

        /* access modifiers changed from: package-private */
        public int getPosition(int i) {
            for (int i2 = 0; i2 < this.fUsedSlotLimit; i2++) {
                if (this.fKeys[i2] == i) {
                    return this.fPositions[i2];
                }
            }
            if ($assertionsDisabled) {
                return -1;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void setPosition(int i, int i2) {
            int i3 = 0;
            while (i3 < this.fUsedSlotLimit) {
                if (this.fKeys[i3] == i) {
                    this.fPositions[i3] = i2;
                    return;
                }
                i3++;
            }
            if (i3 >= 8) {
                if (!$assertionsDisabled) {
                    throw new AssertionError();
                }
                i3 = 7;
            }
            this.fKeys[i3] = i;
            this.fPositions[i3] = i2;
            if ($assertionsDisabled || this.fUsedSlotLimit == i3) {
                this.fUsedSlotLimit = i3 + 1;
                return;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.fUsedSlotLimit = 0;
        }
    }

    private int handleNext(short[] sArr) {
        int position;
        if (TRACE) {
            System.out.println("Handle Next   pos      char  state category");
        }
        this.fLastStatusIndexValid = true;
        this.fLastRuleStatusIndex = 0;
        CharacterIterator characterIterator = this.fText;
        CharTrie charTrie = this.fRData.fTrie;
        int current = characterIterator.current();
        if (current >= 55296 && (current = CharacterIteration.nextTrail32(characterIterator, current)) == Integer.MAX_VALUE) {
            return -1;
        }
        int index = characterIterator.getIndex();
        int i = index;
        short s = 1;
        int rowIndex = this.fRData.getRowIndex(1);
        short s2 = 3;
        char c = 1;
        if ((this.fRData.getStateTableFlags(sArr) & 2) != 0) {
            s2 = 2;
            c = 0;
            if (TRACE) {
                System.out.print("            " + RBBIDataWrapper.intToString(characterIterator.getIndex(), 5));
                System.out.print(RBBIDataWrapper.intToHexString(current, 10));
                System.out.println(RBBIDataWrapper.intToString(1, 7) + RBBIDataWrapper.intToString(2, 6));
            }
        }
        this.fLookAheadMatches.reset();
        while (s != 0) {
            if (current == Integer.MAX_VALUE) {
                if (c == 2) {
                    break;
                }
                c = 2;
                s2 = 1;
            } else if (c == 1) {
                s2 = (short) charTrie.getCodePointValue(current);
                if ((s2 & 16384) != 0) {
                    this.fDictionaryCharCount++;
                    s2 = (short) (s2 & -16385);
                }
                if (TRACE) {
                    System.out.print("            " + RBBIDataWrapper.intToString(characterIterator.getIndex(), 5));
                    System.out.print(RBBIDataWrapper.intToHexString(current, 10));
                    System.out.println(RBBIDataWrapper.intToString(s, 7) + RBBIDataWrapper.intToString(s2, 6));
                }
                current = characterIterator.next();
                if (current >= 55296) {
                    current = CharacterIteration.nextTrail32(characterIterator, current);
                }
            } else {
                c = 1;
            }
            s = sArr[rowIndex + 4 + s2];
            rowIndex = this.fRData.getRowIndex(s);
            if (sArr[rowIndex + 0] == -1) {
                i = characterIterator.getIndex();
                if (current >= 65536 && current <= 1114111) {
                    i--;
                }
                this.fLastRuleStatusIndex = sArr[rowIndex + 2];
            }
            short s3 = sArr[rowIndex + 0];
            if (s3 <= 0 || (position = this.fLookAheadMatches.getPosition(s3)) < 0) {
                short s4 = sArr[rowIndex + 1];
                if (s4 != 0) {
                    int index2 = characterIterator.getIndex();
                    if (current >= 65536 && current <= 1114111) {
                        index2--;
                    }
                    this.fLookAheadMatches.setPosition(s4, index2);
                }
            } else {
                this.fLastRuleStatusIndex = sArr[rowIndex + 2];
                characterIterator.setIndex(position);
                return position;
            }
        }
        if (i == index) {
            if (TRACE) {
                System.out.println("Iterator did not move. Advancing by 1.");
            }
            characterIterator.setIndex(index);
            CharacterIteration.next32(characterIterator);
            i = characterIterator.getIndex();
        } else {
            characterIterator.setIndex(i);
        }
        if (TRACE) {
            System.out.println("result = " + i);
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        if (r8 != r9) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
        r13.fText.setIndex(r9);
        com.ibm.icu.impl.CharacterIteration.previous32(r13.fText);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handlePrevious(short[] r14) {
        /*
        // Method dump skipped, instructions count: 405
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.RuleBasedBreakIterator.handlePrevious(short[]):int");
    }
}
