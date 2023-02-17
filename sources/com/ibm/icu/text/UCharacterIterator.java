package com.ibm.icu.text;

import com.ibm.icu.impl.CharacterIteratorWrapper;
import com.ibm.icu.impl.ReplaceableUCharacterIterator;
import java.text.CharacterIterator;
public abstract class UCharacterIterator implements Cloneable {
    public abstract int getIndex();

    public abstract int getLength();

    public abstract int next();

    public abstract int previous();

    public abstract void setIndex(int i);

    protected UCharacterIterator() {
    }

    public static final UCharacterIterator getInstance(String str) {
        return new ReplaceableUCharacterIterator(str);
    }

    public static final UCharacterIterator getInstance(CharacterIterator characterIterator) {
        return new CharacterIteratorWrapper(characterIterator);
    }

    public int nextCodePoint() {
        int next = next();
        if (UTF16.isLeadSurrogate((char) next)) {
            int next2 = next();
            if (UTF16.isTrailSurrogate((char) next2)) {
                return Character.toCodePoint((char) next, (char) next2);
            }
            if (next2 != -1) {
                previous();
            }
        }
        return next;
    }

    public int previousCodePoint() {
        int previous = previous();
        if (UTF16.isTrailSurrogate((char) previous)) {
            int previous2 = previous();
            if (UTF16.isLeadSurrogate((char) previous2)) {
                return Character.toCodePoint((char) previous2, (char) previous);
            }
            if (previous2 != -1) {
                next();
            }
        }
        return previous;
    }

    public int moveCodePointIndex(int i) {
        if (i > 0) {
            while (i > 0 && nextCodePoint() != -1) {
                i--;
            }
        } else {
            while (i < 0 && previousCodePoint() != -1) {
                i++;
            }
        }
        if (i == 0) {
            return getIndex();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.lang.Object
    public Object clone() {
        return super.clone();
    }
}
