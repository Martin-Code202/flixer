package com.ibm.icu.impl;

import com.ibm.icu.text.Replaceable;
import com.ibm.icu.text.ReplaceableString;
import com.ibm.icu.text.UCharacterIterator;
public class ReplaceableUCharacterIterator extends UCharacterIterator {
    private int currentIndex;
    private Replaceable replaceable;

    public ReplaceableUCharacterIterator(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.replaceable = new ReplaceableString(str);
        this.currentIndex = 0;
    }

    @Override // com.ibm.icu.text.UCharacterIterator, java.lang.Object
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int getLength() {
        return this.replaceable.length();
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int getIndex() {
        return this.currentIndex;
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int next() {
        if (this.currentIndex >= this.replaceable.length()) {
            return -1;
        }
        Replaceable replaceable2 = this.replaceable;
        int i = this.currentIndex;
        this.currentIndex = i + 1;
        return replaceable2.charAt(i);
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int previous() {
        if (this.currentIndex <= 0) {
            return -1;
        }
        Replaceable replaceable2 = this.replaceable;
        int i = this.currentIndex - 1;
        this.currentIndex = i;
        return replaceable2.charAt(i);
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public void setIndex(int i) {
        if (i < 0 || i > this.replaceable.length()) {
            throw new IndexOutOfBoundsException();
        }
        this.currentIndex = i;
    }
}
