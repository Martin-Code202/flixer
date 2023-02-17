package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.CharacterIteration;
import com.ibm.icu.text.DictionaryBreakEngine;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
/* access modifiers changed from: package-private */
public class CjkBreakEngine extends DictionaryBreakEngine {
    private static final UnicodeSet fHanWordSet = new UnicodeSet();
    private static final UnicodeSet fHangulWordSet = new UnicodeSet();
    private static final UnicodeSet fHiraganaWordSet = new UnicodeSet();
    private static final UnicodeSet fKatakanaWordSet = new UnicodeSet();
    private DictionaryMatcher fDictionary;

    static {
        fHangulWordSet.applyPattern("[\\uac00-\\ud7a3]");
        fHanWordSet.applyPattern("[:Han:]");
        fKatakanaWordSet.applyPattern("[[:Katakana:]\\uff9e\\uff9f]");
        fHiraganaWordSet.applyPattern("[:Hiragana:]");
        fHangulWordSet.freeze();
        fHanWordSet.freeze();
        fKatakanaWordSet.freeze();
        fHiraganaWordSet.freeze();
    }

    public CjkBreakEngine(boolean z) {
        super(1);
        this.fDictionary = null;
        this.fDictionary = DictionaryData.loadDictionaryFor("Hira");
        if (z) {
            setCharacters(fHangulWordSet);
            return;
        }
        UnicodeSet unicodeSet = new UnicodeSet();
        unicodeSet.addAll(fHanWordSet);
        unicodeSet.addAll(fKatakanaWordSet);
        unicodeSet.addAll(fHiraganaWordSet);
        unicodeSet.add(65392);
        unicodeSet.add(12540);
        setCharacters(unicodeSet);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CjkBreakEngine) {
            return this.fSet.equals(((CjkBreakEngine) obj).fSet);
        }
        return false;
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    private static int getKatakanaCost(int i) {
        int[] iArr = {8192, 984, 408, 240, 204, 252, 300, 372, 480};
        if (i > 8) {
            return 8192;
        }
        return iArr[i];
    }

    private static boolean isKatakana(int i) {
        return (i >= 12449 && i <= 12542 && i != 12539) || (i >= 65382 && i <= 65439);
    }

    @Override // com.ibm.icu.text.DictionaryBreakEngine
    public int divideUpDictionaryRange(CharacterIterator characterIterator, int i, int i2, DictionaryBreakEngine.DequeI dequeI) {
        StringCharacterIterator stringCharacterIterator;
        if (i >= i2) {
            return 0;
        }
        characterIterator.setIndex(i);
        int[] iArr = new int[((i2 - i) + 1)];
        StringBuffer stringBuffer = new StringBuffer("");
        characterIterator.setIndex(i);
        while (characterIterator.getIndex() < i2) {
            stringBuffer.append(characterIterator.current());
            characterIterator.next();
        }
        String stringBuffer2 = stringBuffer.toString();
        int i3 = 0;
        if (Normalizer.quickCheck(stringBuffer2, Normalizer.NFKC) == Normalizer.YES || Normalizer.isNormalized(stringBuffer2, Normalizer.NFKC, 0)) {
            stringCharacterIterator = new StringCharacterIterator(stringBuffer2);
            int i4 = 0;
            iArr[0] = 0;
            while (i4 < stringBuffer2.length()) {
                i4 += Character.charCount(stringBuffer2.codePointAt(i4));
                i3++;
                iArr[i3] = i4;
            }
        } else {
            String normalize = Normalizer.normalize(stringBuffer2, Normalizer.NFKC);
            stringCharacterIterator = new StringCharacterIterator(normalize);
            iArr = new int[(normalize.length() + 1)];
            Normalizer normalizer = new Normalizer(stringBuffer2, Normalizer.NFKC, 0);
            int i5 = 0;
            iArr[0] = 0;
            while (i5 < normalizer.endIndex()) {
                normalizer.next();
                i3++;
                i5 = normalizer.getIndex();
                iArr[i3] = i5;
            }
        }
        int[] iArr2 = new int[(i3 + 1)];
        iArr2[0] = 0;
        for (int i6 = 1; i6 <= i3; i6++) {
            iArr2[i6] = Integer.MAX_VALUE;
        }
        int[] iArr3 = new int[(i3 + 1)];
        for (int i7 = 0; i7 <= i3; i7++) {
            iArr3[i7] = -1;
        }
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        boolean z = false;
        int i8 = 0;
        while (i8 < i3) {
            stringCharacterIterator.setIndex(i8);
            if (iArr2[i8] != Integer.MAX_VALUE) {
                int i9 = i8 + 20 < i3 ? 20 : i3 - i8;
                int[] iArr6 = new int[1];
                this.fDictionary.matches(stringCharacterIterator, i9, iArr5, iArr6, i9, iArr4);
                int i10 = iArr6[0];
                stringCharacterIterator.setIndex(i8);
                if ((i10 == 0 || iArr5[0] != 1) && CharacterIteration.current32(stringCharacterIterator) != Integer.MAX_VALUE && !fHangulWordSet.contains(CharacterIteration.current32(stringCharacterIterator))) {
                    iArr4[i10] = 255;
                    iArr5[i10] = 1;
                    i10++;
                }
                for (int i11 = 0; i11 < i10; i11++) {
                    int i12 = iArr2[i8] + iArr4[i11];
                    if (i12 < iArr2[iArr5[i11] + i8]) {
                        iArr2[iArr5[i11] + i8] = i12;
                        iArr3[iArr5[i11] + i8] = i8;
                    }
                }
                boolean isKatakana = isKatakana(CharacterIteration.current32(stringCharacterIterator));
                if (!z && isKatakana) {
                    int i13 = i8 + 1;
                    CharacterIteration.next32(stringCharacterIterator);
                    while (i13 < i3 && i13 - i8 < 20 && isKatakana(CharacterIteration.current32(stringCharacterIterator))) {
                        CharacterIteration.next32(stringCharacterIterator);
                        i13++;
                    }
                    if (i13 - i8 < 20) {
                        int katakanaCost = iArr2[i8] + getKatakanaCost(i13 - i8);
                        if (katakanaCost < iArr2[i13]) {
                            iArr2[i13] = katakanaCost;
                            iArr3[i13] = i8;
                        }
                    }
                }
                z = isKatakana;
            }
            i8++;
        }
        int[] iArr7 = new int[(i3 + 1)];
        int i14 = 0;
        if (iArr2[i3] == Integer.MAX_VALUE) {
            iArr7[0] = i3;
            i14 = 0 + 1;
        } else {
            for (int i15 = i3; i15 > 0; i15 = iArr3[i15]) {
                iArr7[i14] = i15;
                i14++;
            }
            Assert.assrt(iArr3[iArr7[i14 + -1]] == 0);
        }
        if (dequeI.size() == 0 || dequeI.peek() < i) {
            i14++;
            iArr7[i14] = 0;
        }
        int i16 = 0;
        for (int i17 = i14 - 1; i17 >= 0; i17--) {
            int i18 = iArr[iArr7[i17]] + i;
            if (!dequeI.contains(i18) && i18 != i) {
                dequeI.push(iArr[iArr7[i17]] + i);
                i16++;
            }
        }
        if (!dequeI.isEmpty() && dequeI.peek() == i2) {
            dequeI.pop();
            i16--;
        }
        if (!dequeI.isEmpty()) {
            characterIterator.setIndex(dequeI.peek());
        }
        return i16;
    }
}
