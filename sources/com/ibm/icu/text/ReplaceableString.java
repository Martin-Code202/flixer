package com.ibm.icu.text;
public class ReplaceableString implements Replaceable {
    private StringBuffer buf;

    public ReplaceableString(String str) {
        this.buf = new StringBuffer(str);
    }

    public ReplaceableString() {
        this.buf = new StringBuffer();
    }

    public String toString() {
        return this.buf.toString();
    }

    @Override // com.ibm.icu.text.Replaceable
    public int length() {
        return this.buf.length();
    }

    @Override // com.ibm.icu.text.Replaceable
    public char charAt(int i) {
        return this.buf.charAt(i);
    }
}
