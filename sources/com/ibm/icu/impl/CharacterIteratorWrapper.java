package com.ibm.icu.impl;

import com.ibm.icu.text.UCharacterIterator;
import java.text.CharacterIterator;
public class CharacterIteratorWrapper extends UCharacterIterator {
    private CharacterIterator iterator;

    public CharacterIteratorWrapper(CharacterIterator characterIterator) {
        if (characterIterator == null) {
            throw new IllegalArgumentException();
        }
        this.iterator = characterIterator;
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int getLength() {
        return this.iterator.getEndIndex() - this.iterator.getBeginIndex();
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int getIndex() {
        return this.iterator.getIndex();
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int next() {
        char current = this.iterator.current();
        this.iterator.next();
        if (current == 65535) {
            return -1;
        }
        return current;
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public int previous() {
        char previous = this.iterator.previous();
        if (previous == 65535) {
            return -1;
        }
        return previous;
    }

    @Override // com.ibm.icu.text.UCharacterIterator
    public void setIndex(int i) {
        try {
            this.iterator.setIndex(i);
        } catch (IllegalArgumentException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // com.ibm.icu.text.UCharacterIterator, java.lang.Object
    public Object clone() {
        try {
            CharacterIteratorWrapper characterIteratorWrapper = (CharacterIteratorWrapper) super.clone();
            characterIteratorWrapper.iterator = (CharacterIterator) this.iterator.clone();
            return characterIteratorWrapper;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
