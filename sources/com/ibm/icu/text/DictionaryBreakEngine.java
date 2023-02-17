package com.ibm.icu.text;

import com.ibm.icu.impl.CharacterIteration;
import java.text.CharacterIterator;
import java.util.BitSet;
abstract class DictionaryBreakEngine implements LanguageBreakEngine {
    UnicodeSet fSet = new UnicodeSet();
    private BitSet fTypes = new BitSet(32);

    /* access modifiers changed from: package-private */
    public abstract int divideUpDictionaryRange(CharacterIterator characterIterator, int i, int i2, DequeI dequeI);

    static class PossibleWord {
        private int[] count = new int[1];
        private int current;
        private int[] lengths = new int[20];
        private int mark;
        private int offset = -1;
        private int prefix;

        public int candidates(CharacterIterator characterIterator, DictionaryMatcher dictionaryMatcher, int i) {
            int index = characterIterator.getIndex();
            if (index != this.offset) {
                this.offset = index;
                this.prefix = dictionaryMatcher.matches(characterIterator, i - index, this.lengths, this.count, this.lengths.length);
                if (this.count[0] <= 0) {
                    characterIterator.setIndex(index);
                }
            }
            if (this.count[0] > 0) {
                characterIterator.setIndex(this.lengths[this.count[0] - 1] + index);
            }
            this.current = this.count[0] - 1;
            this.mark = this.current;
            return this.count[0];
        }

        public int acceptMarked(CharacterIterator characterIterator) {
            characterIterator.setIndex(this.offset + this.lengths[this.mark]);
            return this.lengths[this.mark];
        }

        public boolean backUp(CharacterIterator characterIterator) {
            if (this.current <= 0) {
                return false;
            }
            int i = this.offset;
            int[] iArr = this.lengths;
            int i2 = this.current - 1;
            this.current = i2;
            characterIterator.setIndex(i + iArr[i2]);
            return true;
        }

        public int longestPrefix() {
            return this.prefix;
        }

        public void markCurrent() {
            this.mark = this.current;
        }
    }

    /* access modifiers changed from: package-private */
    public static class DequeI {
        static final /* synthetic */ boolean $assertionsDisabled = (!DictionaryBreakEngine.class.desiredAssertionStatus());
        private int[] data = new int[50];
        private int firstIdx = 4;
        private int lastIdx = 4;

        DequeI() {
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return this.firstIdx - this.lastIdx;
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return size() == 0;
        }

        private void grow() {
            int[] iArr = new int[(this.data.length * 2)];
            System.arraycopy(this.data, 0, iArr, 0, this.data.length);
            this.data = iArr;
        }

        /* access modifiers changed from: package-private */
        public void offer(int i) {
            if ($assertionsDisabled || this.lastIdx > 0) {
                int[] iArr = this.data;
                int i2 = this.lastIdx - 1;
                this.lastIdx = i2;
                iArr[i2] = i;
                return;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void push(int i) {
            if (this.firstIdx >= this.data.length) {
                grow();
            }
            int[] iArr = this.data;
            int i2 = this.firstIdx;
            this.firstIdx = i2 + 1;
            iArr[i2] = i;
        }

        /* access modifiers changed from: package-private */
        public int pop() {
            if ($assertionsDisabled || size() > 0) {
                int[] iArr = this.data;
                int i = this.firstIdx - 1;
                this.firstIdx = i;
                return iArr[i];
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public int peek() {
            if ($assertionsDisabled || size() > 0) {
                return this.data[this.firstIdx - 1];
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public int peekLast() {
            if ($assertionsDisabled || size() > 0) {
                return this.data[this.lastIdx];
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public int pollLast() {
            if ($assertionsDisabled || size() > 0) {
                int[] iArr = this.data;
                int i = this.lastIdx;
                this.lastIdx = i + 1;
                return iArr[i];
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public boolean contains(int i) {
            for (int i2 = this.lastIdx; i2 < this.firstIdx; i2++) {
                if (this.data[i2] == i) {
                    return true;
                }
            }
            return false;
        }
    }

    public DictionaryBreakEngine(Integer... numArr) {
        for (Integer num : numArr) {
            this.fTypes.set(num.intValue());
        }
    }

    @Override // com.ibm.icu.text.LanguageBreakEngine
    public boolean handles(int i, int i2) {
        return this.fTypes.get(i2) && this.fSet.contains(i);
    }

    @Override // com.ibm.icu.text.LanguageBreakEngine
    public int findBreaks(CharacterIterator characterIterator, int i, int i2, boolean z, int i3, DequeI dequeI) {
        int i4;
        int i5;
        int i6;
        int index = characterIterator.getIndex();
        int current32 = CharacterIteration.current32(characterIterator);
        if (z) {
            boolean contains = this.fSet.contains(current32);
            while (true) {
                int index2 = characterIterator.getIndex();
                i6 = index2;
                if (index2 <= i || !contains) {
                    break;
                }
                contains = this.fSet.contains(CharacterIteration.previous32(characterIterator));
            }
            if (i6 < i) {
                i5 = i;
            } else {
                i5 = i6 + (contains ? 0 : 1);
            }
            i4 = index + 1;
        } else {
            while (true) {
                int index3 = characterIterator.getIndex();
                i6 = index3;
                if (index3 >= i2 || !this.fSet.contains(current32)) {
                    break;
                }
                CharacterIteration.next32(characterIterator);
                current32 = CharacterIteration.current32(characterIterator);
            }
            i5 = index;
            i4 = i6;
        }
        int divideUpDictionaryRange = divideUpDictionaryRange(characterIterator, i5, i4, dequeI);
        characterIterator.setIndex(i6);
        return divideUpDictionaryRange;
    }

    /* access modifiers changed from: package-private */
    public void setCharacters(UnicodeSet unicodeSet) {
        this.fSet = new UnicodeSet(unicodeSet);
        this.fSet.compact();
    }
}
