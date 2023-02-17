package com.ibm.icu.text;

import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.text.Normalizer;
public abstract class Normalizer2 {
    public abstract StringBuilder append(StringBuilder sb, CharSequence charSequence);

    public abstract boolean hasBoundaryBefore(int i);

    public abstract boolean isInert(int i);

    public abstract boolean isNormalized(CharSequence charSequence);

    public abstract StringBuilder normalize(CharSequence charSequence, StringBuilder sb);

    public abstract StringBuilder normalizeSecondAndAppend(StringBuilder sb, CharSequence charSequence);

    public abstract Normalizer.QuickCheckResult quickCheck(CharSequence charSequence);

    public abstract int spanQuickCheckYes(CharSequence charSequence);

    public static Normalizer2 getNFCInstance() {
        return Norm2AllModes.getNFCInstance().comp;
    }

    public static Normalizer2 getNFDInstance() {
        return Norm2AllModes.getNFCInstance().decomp;
    }

    public static Normalizer2 getNFKCInstance() {
        return Norm2AllModes.getNFKCInstance().comp;
    }

    public static Normalizer2 getNFKDInstance() {
        return Norm2AllModes.getNFKCInstance().decomp;
    }

    public String normalize(CharSequence charSequence) {
        if (!(charSequence instanceof String)) {
            return normalize(charSequence, new StringBuilder(charSequence.length())).toString();
        }
        int spanQuickCheckYes = spanQuickCheckYes(charSequence);
        if (spanQuickCheckYes == charSequence.length()) {
            return (String) charSequence;
        }
        return normalizeSecondAndAppend(new StringBuilder(charSequence.length()).append(charSequence, 0, spanQuickCheckYes), charSequence.subSequence(spanQuickCheckYes, charSequence.length())).toString();
    }

    public int getCombiningClass(int i) {
        return 0;
    }

    @Deprecated
    protected Normalizer2() {
    }
}
