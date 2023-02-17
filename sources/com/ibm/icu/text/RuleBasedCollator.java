package com.ibm.icu.text;

import com.ibm.icu.impl.ClassLoaderUtil;
import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.coll.CollationCompare;
import com.ibm.icu.impl.coll.CollationData;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.impl.coll.CollationRoot;
import com.ibm.icu.impl.coll.CollationSettings;
import com.ibm.icu.impl.coll.CollationTailoring;
import com.ibm.icu.impl.coll.FCDUTF16CollationIterator;
import com.ibm.icu.impl.coll.SharedObject;
import com.ibm.icu.impl.coll.TailoredSet;
import com.ibm.icu.impl.coll.UTF16CollationIterator;
import com.ibm.icu.util.ULocale;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
public final class RuleBasedCollator extends Collator {
    static final /* synthetic */ boolean $assertionsDisabled = (!RuleBasedCollator.class.desiredAssertionStatus());
    private boolean actualLocaleIsSameAsValid;
    private CollationBuffer collationBuffer;
    CollationData data;
    private Lock frozenLock;
    SharedObject.Reference<CollationSettings> settings;
    CollationTailoring tailoring;
    private ULocale validLocale;

    public RuleBasedCollator(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Collation rules can not be null");
        }
        this.validLocale = ULocale.ROOT;
        internalBuildTailoring(str);
    }

    private final void internalBuildTailoring(String str) {
        CollationTailoring root = CollationRoot.getRoot();
        try {
            Class<?> loadClass = ClassLoaderUtil.getClassLoader(getClass()).loadClass("com.ibm.icu.impl.coll.CollationBuilder");
            CollationTailoring collationTailoring = (CollationTailoring) loadClass.getMethod("parseAndBuild", String.class).invoke(loadClass.getConstructor(CollationTailoring.class).newInstance(root), str);
            collationTailoring.actualLocale = null;
            adoptTailoring(collationTailoring);
        } catch (InvocationTargetException e) {
            throw ((Exception) e.getTargetException());
        }
    }

    @Override // com.ibm.icu.text.Collator, java.lang.Object
    public Object clone() {
        if (isFrozen()) {
            return this;
        }
        return cloneAsThawed();
    }

    private final void initMaxExpansions() {
        synchronized (this.tailoring) {
            if (this.tailoring.maxExpansions == null) {
                this.tailoring.maxExpansions = CollationElementIterator.computeMaxExpansions(this.tailoring.data);
            }
        }
    }

    public CollationElementIterator getCollationElementIterator(String str) {
        initMaxExpansions();
        return new CollationElementIterator(str, this);
    }

    @Override // com.ibm.icu.text.Collator
    public boolean isFrozen() {
        return this.frozenLock != null;
    }

    public RuleBasedCollator cloneAsThawed() {
        try {
            RuleBasedCollator ruleBasedCollator = (RuleBasedCollator) super.clone();
            ruleBasedCollator.settings = this.settings.clone();
            ruleBasedCollator.collationBuffer = null;
            ruleBasedCollator.frozenLock = null;
            return ruleBasedCollator;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    private void checkNotFrozen() {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify frozen RuleBasedCollator");
        }
    }

    private final CollationSettings getOwnedSettings() {
        return this.settings.copyOnWrite();
    }

    private final CollationSettings getDefaultSettings() {
        return this.tailoring.settings.readOnly();
    }

    public void setUpperCaseFirst(boolean z) {
        checkNotFrozen();
        if (z != isUpperCaseFirst()) {
            CollationSettings ownedSettings = getOwnedSettings();
            ownedSettings.setCaseFirst(z ? 768 : 0);
            setFastLatinOptions(ownedSettings);
        }
    }

    public void setLowerCaseFirst(boolean z) {
        checkNotFrozen();
        if (z != isLowerCaseFirst()) {
            CollationSettings ownedSettings = getOwnedSettings();
            ownedSettings.setCaseFirst(z ? 512 : 0);
            setFastLatinOptions(ownedSettings);
        }
    }

    public void setFrenchCollation(boolean z) {
        checkNotFrozen();
        if (z != isFrenchCollation()) {
            CollationSettings ownedSettings = getOwnedSettings();
            ownedSettings.setFlag(2048, z);
            setFastLatinOptions(ownedSettings);
        }
    }

    public void setAlternateHandlingShifted(boolean z) {
        checkNotFrozen();
        if (z != isAlternateHandlingShifted()) {
            CollationSettings ownedSettings = getOwnedSettings();
            ownedSettings.setAlternateHandlingShifted(z);
            setFastLatinOptions(ownedSettings);
        }
    }

    public void setCaseLevel(boolean z) {
        checkNotFrozen();
        if (z != isCaseLevel()) {
            CollationSettings ownedSettings = getOwnedSettings();
            ownedSettings.setFlag(1024, z);
            setFastLatinOptions(ownedSettings);
        }
    }

    @Override // com.ibm.icu.text.Collator
    public void setDecomposition(int i) {
        boolean z;
        checkNotFrozen();
        switch (i) {
            case 16:
                z = false;
                break;
            case 17:
                z = true;
                break;
            default:
                throw new IllegalArgumentException("Wrong decomposition mode.");
        }
        if (z != this.settings.readOnly().getFlag(1)) {
            CollationSettings ownedSettings = getOwnedSettings();
            ownedSettings.setFlag(1, z);
            setFastLatinOptions(ownedSettings);
        }
    }

    @Override // com.ibm.icu.text.Collator
    public void setStrength(int i) {
        checkNotFrozen();
        if (i != getStrength()) {
            CollationSettings ownedSettings = getOwnedSettings();
            ownedSettings.setStrength(i);
            setFastLatinOptions(ownedSettings);
        }
    }

    @Override // com.ibm.icu.text.Collator
    public RuleBasedCollator setMaxVariable(int i) {
        int i2;
        if (i == -1) {
            i2 = -1;
        } else if (4096 > i || i > 4099) {
            throw new IllegalArgumentException("illegal max variable group " + i);
        } else {
            i2 = i - 4096;
        }
        if (i2 == this.settings.readOnly().getMaxVariable()) {
            return this;
        }
        CollationSettings defaultSettings = getDefaultSettings();
        if (this.settings.readOnly() == defaultSettings && i2 < 0) {
            return this;
        }
        CollationSettings ownedSettings = getOwnedSettings();
        if (i == -1) {
            i = defaultSettings.getMaxVariable() + 4096;
        }
        long lastPrimaryForGroup = this.data.getLastPrimaryForGroup(i);
        if ($assertionsDisabled || lastPrimaryForGroup != 0) {
            ownedSettings.setMaxVariable(i2, defaultSettings.options);
            ownedSettings.variableTop = lastPrimaryForGroup;
            setFastLatinOptions(ownedSettings);
            return this;
        }
        throw new AssertionError();
    }

    public void setNumericCollation(boolean z) {
        checkNotFrozen();
        if (z != getNumericCollation()) {
            CollationSettings ownedSettings = getOwnedSettings();
            ownedSettings.setFlag(2, z);
            setFastLatinOptions(ownedSettings);
        }
    }

    @Override // com.ibm.icu.text.Collator
    public void setReorderCodes(int... iArr) {
        checkNotFrozen();
        int length = iArr != null ? iArr.length : 0;
        if (length == 1 && iArr[0] == 103) {
            length = 0;
        }
        if (length == 0) {
            if (this.settings.readOnly().reorderCodes.length == 0) {
                return;
            }
        } else if (Arrays.equals(iArr, this.settings.readOnly().reorderCodes)) {
            return;
        }
        CollationSettings defaultSettings = getDefaultSettings();
        if (length != 1 || iArr[0] != -1) {
            CollationSettings ownedSettings = getOwnedSettings();
            if (length == 0) {
                ownedSettings.resetReordering();
            } else {
                ownedSettings.setReordering(this.data, (int[]) iArr.clone());
            }
            setFastLatinOptions(ownedSettings);
        } else if (this.settings.readOnly() != defaultSettings) {
            CollationSettings ownedSettings2 = getOwnedSettings();
            ownedSettings2.copyReorderingFrom(defaultSettings);
            setFastLatinOptions(ownedSettings2);
        }
    }

    private void setFastLatinOptions(CollationSettings collationSettings) {
        collationSettings.fastLatinOptions = CollationFastLatin.getOptions(this.data, collationSettings, collationSettings.fastLatinPrimaries);
    }

    public String getRules() {
        return this.tailoring.getRules();
    }

    @Override // com.ibm.icu.text.Collator
    public UnicodeSet getTailoredSet() {
        UnicodeSet unicodeSet = new UnicodeSet();
        if (this.data.base != null) {
            new TailoredSet(unicodeSet).forData(this.data);
        }
        return unicodeSet;
    }

    @Override // com.ibm.icu.text.Collator
    public int getStrength() {
        return this.settings.readOnly().getStrength();
    }

    public boolean isUpperCaseFirst() {
        return this.settings.readOnly().getCaseFirst() == 768;
    }

    public boolean isLowerCaseFirst() {
        return this.settings.readOnly().getCaseFirst() == 512;
    }

    public boolean isAlternateHandlingShifted() {
        return this.settings.readOnly().getAlternateHandling();
    }

    public boolean isCaseLevel() {
        return (this.settings.readOnly().options & 1024) != 0;
    }

    public boolean isFrenchCollation() {
        return (this.settings.readOnly().options & 2048) != 0;
    }

    public boolean getNumericCollation() {
        return (this.settings.readOnly().options & 2) != 0;
    }

    @Override // com.ibm.icu.text.Collator, java.util.Comparator, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        RuleBasedCollator ruleBasedCollator = (RuleBasedCollator) obj;
        if (!this.settings.readOnly().equals(ruleBasedCollator.settings.readOnly())) {
            return false;
        }
        if (this.data == ruleBasedCollator.data) {
            return true;
        }
        boolean z = this.data.base == null;
        boolean z2 = ruleBasedCollator.data.base == null;
        if (!$assertionsDisabled && z && z2) {
            throw new AssertionError();
        } else if (z != z2) {
            return false;
        } else {
            String rules = this.tailoring.getRules();
            String rules2 = ruleBasedCollator.tailoring.getRules();
            if (((z || rules.length() != 0) && ((z2 || rules2.length() != 0) && rules.equals(rules2))) || getTailoredSet().equals(ruleBasedCollator.getTailoredSet())) {
                return true;
            }
            return false;
        }
    }

    @Override // com.ibm.icu.text.Collator, java.lang.Object
    public int hashCode() {
        int hashCode = this.settings.readOnly().hashCode();
        if (this.data.base == null) {
            return hashCode;
        }
        UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(getTailoredSet());
        while (unicodeSetIterator.next() && unicodeSetIterator.codepoint != UnicodeSetIterator.IS_STRING) {
            hashCode ^= this.data.getCE32(unicodeSetIterator.codepoint);
        }
        return hashCode;
    }

    @Override // com.ibm.icu.text.Collator
    public int compare(String str, String str2) {
        return doCompare(str, str2);
    }

    /* access modifiers changed from: package-private */
    public static abstract class NFDIterator {
        private String decomp;
        private int index;

        /* access modifiers changed from: protected */
        public abstract int nextRawCodePoint();

        NFDIterator() {
        }

        /* access modifiers changed from: package-private */
        public final void reset() {
            this.index = -1;
        }

        /* access modifiers changed from: package-private */
        public final int nextCodePoint() {
            if (this.index >= 0) {
                if (this.index == this.decomp.length()) {
                    this.index = -1;
                } else {
                    int codePointAt = Character.codePointAt(this.decomp, this.index);
                    this.index += Character.charCount(codePointAt);
                    return codePointAt;
                }
            }
            return nextRawCodePoint();
        }

        /* access modifiers changed from: package-private */
        public final int nextDecomposedCodePoint(Normalizer2Impl normalizer2Impl, int i) {
            if (this.index >= 0) {
                return i;
            }
            this.decomp = normalizer2Impl.getDecomposition(i);
            if (this.decomp == null) {
                return i;
            }
            int codePointAt = Character.codePointAt(this.decomp, 0);
            this.index = Character.charCount(codePointAt);
            return codePointAt;
        }
    }

    /* access modifiers changed from: package-private */
    public static class UTF16NFDIterator extends NFDIterator {
        protected int pos;
        protected CharSequence s;

        UTF16NFDIterator() {
        }

        /* access modifiers changed from: package-private */
        public void setText(CharSequence charSequence, int i) {
            reset();
            this.s = charSequence;
            this.pos = i;
        }

        /* access modifiers changed from: protected */
        @Override // com.ibm.icu.text.RuleBasedCollator.NFDIterator
        public int nextRawCodePoint() {
            if (this.pos == this.s.length()) {
                return -1;
            }
            int codePointAt = Character.codePointAt(this.s, this.pos);
            this.pos += Character.charCount(codePointAt);
            return codePointAt;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class FCDUTF16NFDIterator extends UTF16NFDIterator {
        private StringBuilder str;

        FCDUTF16NFDIterator() {
        }

        /* access modifiers changed from: package-private */
        public void setText(Normalizer2Impl normalizer2Impl, CharSequence charSequence, int i) {
            reset();
            int makeFCD = normalizer2Impl.makeFCD(charSequence, i, charSequence.length(), null);
            if (makeFCD == charSequence.length()) {
                this.s = charSequence;
                this.pos = i;
                return;
            }
            if (this.str == null) {
                this.str = new StringBuilder();
            } else {
                this.str.setLength(0);
            }
            this.str.append(charSequence, i, makeFCD);
            normalizer2Impl.makeFCD(charSequence, makeFCD, charSequence.length(), new Normalizer2Impl.ReorderingBuffer(normalizer2Impl, this.str, charSequence.length() - i));
            this.s = this.str;
            this.pos = 0;
        }
    }

    private static final int compareNFDIter(Normalizer2Impl normalizer2Impl, NFDIterator nFDIterator, NFDIterator nFDIterator2) {
        int i;
        int i2;
        while (true) {
            int nextCodePoint = nFDIterator.nextCodePoint();
            int nextCodePoint2 = nFDIterator2.nextCodePoint();
            if (nextCodePoint != nextCodePoint2) {
                if (nextCodePoint < 0) {
                    i = -2;
                } else if (nextCodePoint == 65534) {
                    i = -1;
                } else {
                    i = nFDIterator.nextDecomposedCodePoint(normalizer2Impl, nextCodePoint);
                }
                if (nextCodePoint2 < 0) {
                    i2 = -2;
                } else if (nextCodePoint2 == 65534) {
                    i2 = -1;
                } else {
                    i2 = nFDIterator2.nextDecomposedCodePoint(normalizer2Impl, nextCodePoint2);
                }
                if (i < i2) {
                    return -1;
                }
                if (i > i2) {
                    return 1;
                }
            } else if (nextCodePoint < 0) {
                return 0;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.text.Collator
    @Deprecated
    public int doCompare(CharSequence charSequence, CharSequence charSequence2) {
        int i;
        if (charSequence == charSequence2) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            if (i2 != charSequence.length()) {
                if (i2 == charSequence2.length() || charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                    break;
                }
                i2++;
            } else if (i2 == charSequence2.length()) {
                return 0;
            }
        }
        CollationSettings readOnly = this.settings.readOnly();
        boolean isNumeric = readOnly.isNumeric();
        if (i2 > 0 && ((i2 != charSequence.length() && this.data.isUnsafeBackward(charSequence.charAt(i2), isNumeric)) || (i2 != charSequence2.length() && this.data.isUnsafeBackward(charSequence2.charAt(i2), isNumeric)))) {
            do {
                i2--;
                if (i2 <= 0) {
                    break;
                }
            } while (this.data.isUnsafeBackward(charSequence.charAt(i2), isNumeric));
        }
        int i3 = readOnly.fastLatinOptions;
        if (i3 < 0 || ((i2 != charSequence.length() && charSequence.charAt(i2) > 383) || (i2 != charSequence2.length() && charSequence2.charAt(i2) > 383))) {
            i = -2;
        } else {
            i = CollationFastLatin.compareUTF16(this.data.fastLatinTable, readOnly.fastLatinPrimaries, i3, charSequence, charSequence2, i2);
        }
        if (i == -2) {
            CollationBuffer collationBuffer2 = null;
            try {
                collationBuffer2 = getCollationBuffer();
                if (readOnly.dontCheckFCD()) {
                    collationBuffer2.leftUTF16CollIter.setText(isNumeric, charSequence, i2);
                    collationBuffer2.rightUTF16CollIter.setText(isNumeric, charSequence2, i2);
                    i = CollationCompare.compareUpToQuaternary(collationBuffer2.leftUTF16CollIter, collationBuffer2.rightUTF16CollIter, readOnly);
                } else {
                    collationBuffer2.leftFCDUTF16Iter.setText(isNumeric, charSequence, i2);
                    collationBuffer2.rightFCDUTF16Iter.setText(isNumeric, charSequence2, i2);
                    i = CollationCompare.compareUpToQuaternary(collationBuffer2.leftFCDUTF16Iter, collationBuffer2.rightFCDUTF16Iter, readOnly);
                }
            } finally {
                releaseCollationBuffer(collationBuffer2);
            }
        }
        if (i != 0 || readOnly.getStrength() < 15) {
            return i;
        }
        CollationBuffer collationBuffer3 = null;
        try {
            collationBuffer3 = getCollationBuffer();
            Normalizer2Impl normalizer2Impl = this.data.nfcImpl;
            if (readOnly.dontCheckFCD()) {
                collationBuffer3.leftUTF16NFDIter.setText(charSequence, i2);
                collationBuffer3.rightUTF16NFDIter.setText(charSequence2, i2);
                return compareNFDIter(normalizer2Impl, collationBuffer3.leftUTF16NFDIter, collationBuffer3.rightUTF16NFDIter);
            }
            collationBuffer3.leftFCDUTF16NFDIter.setText(normalizer2Impl, charSequence, i2);
            collationBuffer3.rightFCDUTF16NFDIter.setText(normalizer2Impl, charSequence2, i2);
            int compareNFDIter = compareNFDIter(normalizer2Impl, collationBuffer3.leftFCDUTF16NFDIter, collationBuffer3.rightFCDUTF16NFDIter);
            releaseCollationBuffer(collationBuffer3);
            return compareNFDIter;
        } finally {
            releaseCollationBuffer(collationBuffer3);
        }
    }

    RuleBasedCollator(CollationTailoring collationTailoring, ULocale uLocale) {
        this.data = collationTailoring.data;
        this.settings = collationTailoring.settings.clone();
        this.tailoring = collationTailoring;
        this.validLocale = uLocale;
        this.actualLocaleIsSameAsValid = false;
    }

    private void adoptTailoring(CollationTailoring collationTailoring) {
        if ($assertionsDisabled || (this.settings == null && this.data == null && this.tailoring == null)) {
            this.data = collationTailoring.data;
            this.settings = collationTailoring.settings.clone();
            this.tailoring = collationTailoring;
            this.validLocale = collationTailoring.actualLocale;
            this.actualLocaleIsSameAsValid = false;
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public static final class CollationBuffer {
        FCDUTF16CollationIterator leftFCDUTF16Iter;
        FCDUTF16NFDIterator leftFCDUTF16NFDIter;
        UTF16CollationIterator leftUTF16CollIter;
        UTF16NFDIterator leftUTF16NFDIter;
        FCDUTF16CollationIterator rightFCDUTF16Iter;
        FCDUTF16NFDIterator rightFCDUTF16NFDIter;
        UTF16CollationIterator rightUTF16CollIter;
        UTF16NFDIterator rightUTF16NFDIter;

        private CollationBuffer(CollationData collationData) {
            this.leftUTF16CollIter = new UTF16CollationIterator(collationData);
            this.rightUTF16CollIter = new UTF16CollationIterator(collationData);
            this.leftFCDUTF16Iter = new FCDUTF16CollationIterator(collationData);
            this.rightFCDUTF16Iter = new FCDUTF16CollationIterator(collationData);
            this.leftUTF16NFDIter = new UTF16NFDIterator();
            this.rightUTF16NFDIter = new UTF16NFDIterator();
            this.leftFCDUTF16NFDIter = new FCDUTF16NFDIterator();
            this.rightFCDUTF16NFDIter = new FCDUTF16NFDIterator();
        }
    }

    private final CollationBuffer getCollationBuffer() {
        if (isFrozen()) {
            this.frozenLock.lock();
        } else if (this.collationBuffer == null) {
            this.collationBuffer = new CollationBuffer(this.data);
        }
        return this.collationBuffer;
    }

    private final void releaseCollationBuffer(CollationBuffer collationBuffer2) {
        if (isFrozen()) {
            this.frozenLock.unlock();
        }
    }
}
