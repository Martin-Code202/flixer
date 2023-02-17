package com.ibm.icu.text;

import com.ibm.icu.impl.SimpleFormatterImpl;
public final class SimpleFormatter {
    private final String compiledPattern;

    public int getArgumentLimit() {
        return SimpleFormatterImpl.getArgumentLimit(this.compiledPattern);
    }

    public StringBuilder formatAndAppend(StringBuilder sb, int[] iArr, CharSequence... charSequenceArr) {
        return SimpleFormatterImpl.formatAndAppend(this.compiledPattern, sb, iArr, charSequenceArr);
    }

    public String toString() {
        String[] strArr = new String[getArgumentLimit()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = "{" + i + '}';
        }
        return formatAndAppend(new StringBuilder(), null, strArr).toString();
    }
}
