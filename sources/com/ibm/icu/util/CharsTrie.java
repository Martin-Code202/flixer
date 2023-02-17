package com.ibm.icu.util;

import com.ibm.icu.text.UTF16;
import com.ibm.icu.util.BytesTrie;
import java.util.ArrayList;
import java.util.NoSuchElementException;
public final class CharsTrie implements Cloneable, Iterable<Entry> {
    static final /* synthetic */ boolean $assertionsDisabled = (!CharsTrie.class.desiredAssertionStatus());
    private static BytesTrie.Result[] valueResults_ = {BytesTrie.Result.INTERMEDIATE_VALUE, BytesTrie.Result.FINAL_VALUE};
    private CharSequence chars_;
    private int pos_;
    private int remainingMatchLength_ = -1;
    private int root_;

    public static final class State {
        private CharSequence chars;
        private int pos;
        private int remainingMatchLength;
        private int root;
    }

    public CharsTrie(CharSequence charSequence, int i) {
        this.chars_ = charSequence;
        this.root_ = i;
        this.pos_ = i;
    }

    @Override // java.lang.Object
    public Object clone() {
        return super.clone();
    }

    public CharsTrie reset() {
        this.pos_ = this.root_;
        this.remainingMatchLength_ = -1;
        return this;
    }

    public CharsTrie saveState(State state) {
        state.chars = this.chars_;
        state.root = this.root_;
        state.pos = this.pos_;
        state.remainingMatchLength = this.remainingMatchLength_;
        return this;
    }

    public CharsTrie resetToState(State state) {
        if (this.chars_ == state.chars && this.chars_ != null && this.root_ == state.root) {
            this.pos_ = state.pos;
            this.remainingMatchLength_ = state.remainingMatchLength;
            return this;
        }
        throw new IllegalArgumentException("incompatible trie state");
    }

    public BytesTrie.Result first(int i) {
        this.remainingMatchLength_ = -1;
        return nextImpl(this.root_, i);
    }

    public BytesTrie.Result firstForCodePoint(int i) {
        if (i <= 65535) {
            return first(i);
        }
        return first(UTF16.getLeadSurrogate(i)).hasNext() ? next(UTF16.getTrailSurrogate(i)) : BytesTrie.Result.NO_MATCH;
    }

    public BytesTrie.Result next(int i) {
        char charAt;
        int i2 = this.pos_;
        if (i2 < 0) {
            return BytesTrie.Result.NO_MATCH;
        }
        int i3 = this.remainingMatchLength_;
        if (i3 < 0) {
            return nextImpl(i2, i);
        }
        int i4 = i2 + 1;
        if (i == this.chars_.charAt(i2)) {
            int i5 = i3 - 1;
            this.remainingMatchLength_ = i5;
            this.pos_ = i4;
            return (i5 >= 0 || (charAt = this.chars_.charAt(i4)) < '@') ? BytesTrie.Result.NO_VALUE : valueResults_[charAt >> 15];
        }
        stop();
        return BytesTrie.Result.NO_MATCH;
    }

    public BytesTrie.Result nextForCodePoint(int i) {
        if (i <= 65535) {
            return next(i);
        }
        return next(UTF16.getLeadSurrogate(i)).hasNext() ? next(UTF16.getTrailSurrogate(i)) : BytesTrie.Result.NO_MATCH;
    }

    public int getValue() {
        int i = this.pos_;
        int i2 = i + 1;
        char charAt = this.chars_.charAt(i);
        if ($assertionsDisabled || charAt >= '@') {
            return (32768 & charAt) != 0 ? readValue(this.chars_, i2, charAt & 32767) : readNodeValue(this.chars_, i2, charAt);
        }
        throw new AssertionError();
    }

    /* Return type fixed from 'com.ibm.icu.util.CharsTrie$Iterator' to match base method */
    @Override // java.lang.Iterable
    public java.util.Iterator<Entry> iterator() {
        return new Iterator(this.chars_, this.pos_, this.remainingMatchLength_, 0);
    }

    public static final class Entry {
        public CharSequence chars;
        public int value;

        private Entry() {
        }
    }

    public static final class Iterator implements java.util.Iterator<Entry> {
        private CharSequence chars_;
        private Entry entry_;
        private int initialPos_;
        private int initialRemainingMatchLength_;
        private int maxLength_;
        private int pos_;
        private int remainingMatchLength_;
        private boolean skipValue_;
        private ArrayList<Long> stack_;
        private StringBuilder str_;

        private Iterator(CharSequence charSequence, int i, int i2, int i3) {
            this.str_ = new StringBuilder();
            this.entry_ = new Entry();
            this.stack_ = new ArrayList<>();
            this.chars_ = charSequence;
            this.initialPos_ = i;
            this.pos_ = i;
            this.initialRemainingMatchLength_ = i2;
            this.remainingMatchLength_ = i2;
            this.maxLength_ = i3;
            int i4 = this.remainingMatchLength_;
            if (i4 >= 0) {
                int i5 = i4 + 1;
                if (this.maxLength_ > 0 && i5 > this.maxLength_) {
                    i5 = this.maxLength_;
                }
                this.str_.append(this.chars_, this.pos_, this.pos_ + i5);
                this.pos_ += i5;
                this.remainingMatchLength_ -= i5;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos_ >= 0 || !this.stack_.isEmpty();
        }

        @Override // java.util.Iterator
        public Entry next() {
            int i = this.pos_;
            if (i < 0) {
                if (this.stack_.isEmpty()) {
                    throw new NoSuchElementException();
                }
                long longValue = this.stack_.remove(this.stack_.size() - 1).longValue();
                int i2 = (int) longValue;
                int i3 = (int) (longValue >> 32);
                this.str_.setLength(65535 & i2);
                int i4 = i2 >>> 16;
                if (i4 > 1) {
                    i = branchNext(i3, i4);
                    if (i < 0) {
                        return this.entry_;
                    }
                } else {
                    i = i3 + 1;
                    this.str_.append(this.chars_.charAt(i3));
                }
            }
            if (this.remainingMatchLength_ >= 0) {
                return truncateAndStop();
            }
            while (true) {
                int i5 = i + 1;
                char charAt = this.chars_.charAt(i);
                if (charAt >= 64) {
                    if (this.skipValue_) {
                        i5 = CharsTrie.skipNodeValue(i5, charAt);
                        charAt &= 63;
                        this.skipValue_ = false;
                    } else {
                        boolean z = (32768 & charAt) != 0;
                        if (z) {
                            this.entry_.value = CharsTrie.readValue(this.chars_, i5, charAt & 32767);
                        } else {
                            this.entry_.value = CharsTrie.readNodeValue(this.chars_, i5, charAt);
                        }
                        if (z || (this.maxLength_ > 0 && this.str_.length() == this.maxLength_)) {
                            this.pos_ = -1;
                        } else {
                            this.pos_ = i5 - 1;
                            this.skipValue_ = true;
                        }
                        this.entry_.chars = this.str_;
                        return this.entry_;
                    }
                }
                if (this.maxLength_ > 0 && this.str_.length() == this.maxLength_) {
                    return truncateAndStop();
                }
                if (charAt < 48) {
                    if (charAt == 0) {
                        i5++;
                        charAt = this.chars_.charAt(i5);
                    }
                    i = branchNext(i5, charAt + 1);
                    if (i < 0) {
                        return this.entry_;
                    }
                } else {
                    int i6 = (charAt - 48) + 1;
                    if (this.maxLength_ <= 0 || this.str_.length() + i6 <= this.maxLength_) {
                        this.str_.append(this.chars_, i5, i5 + i6);
                        i = i5 + i6;
                    } else {
                        this.str_.append(this.chars_, i5, (this.maxLength_ + i5) - this.str_.length());
                        return truncateAndStop();
                    }
                }
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private Entry truncateAndStop() {
            this.pos_ = -1;
            this.entry_.chars = this.str_;
            this.entry_.value = -1;
            return this.entry_;
        }

        private int branchNext(int i, int i2) {
            while (i2 > 5) {
                int i3 = i + 1;
                this.stack_.add(Long.valueOf((((long) CharsTrie.skipDelta(this.chars_, i3)) << 32) | ((long) ((i2 - (i2 >> 1)) << 16)) | ((long) this.str_.length())));
                i2 >>= 1;
                i = CharsTrie.jumpByDelta(this.chars_, i3);
            }
            int i4 = i + 1;
            char charAt = this.chars_.charAt(i);
            int i5 = i4 + 1;
            char charAt2 = this.chars_.charAt(i4);
            boolean z = (32768 & charAt2) != 0;
            int i6 = charAt2 & 32767;
            int readValue = CharsTrie.readValue(this.chars_, i5, i6);
            int skipValue = CharsTrie.skipValue(i5, i6);
            this.stack_.add(Long.valueOf((((long) skipValue) << 32) | ((long) ((i2 - 1) << 16)) | ((long) this.str_.length())));
            this.str_.append(charAt);
            if (!z) {
                return skipValue + readValue;
            }
            this.pos_ = -1;
            this.entry_.chars = this.str_;
            this.entry_.value = readValue;
            return -1;
        }
    }

    private void stop() {
        this.pos_ = -1;
    }

    /* access modifiers changed from: private */
    public static int readValue(CharSequence charSequence, int i, int i2) {
        if (i2 < 16384) {
            return i2;
        }
        if (i2 < 32767) {
            return ((i2 - 16384) << 16) | charSequence.charAt(i);
        }
        return (charSequence.charAt(i) << 16) | charSequence.charAt(i + 1);
    }

    /* access modifiers changed from: private */
    public static int skipValue(int i, int i2) {
        if (i2 < 16384) {
            return i;
        }
        if (i2 < 32767) {
            return i + 1;
        }
        return i + 2;
    }

    private static int skipValue(CharSequence charSequence, int i) {
        return skipValue(i + 1, charSequence.charAt(i) & 32767);
    }

    /* access modifiers changed from: private */
    public static int readNodeValue(CharSequence charSequence, int i, int i2) {
        if (!$assertionsDisabled && (64 > i2 || i2 >= 32768)) {
            throw new AssertionError();
        } else if (i2 < 16448) {
            return (i2 >> 6) - 1;
        } else {
            if (i2 < 32704) {
                return (((i2 & 32704) - 16448) << 10) | charSequence.charAt(i);
            }
            return (charSequence.charAt(i) << 16) | charSequence.charAt(i + 1);
        }
    }

    /* access modifiers changed from: private */
    public static int skipNodeValue(int i, int i2) {
        if (!$assertionsDisabled && (64 > i2 || i2 >= 32768)) {
            throw new AssertionError();
        } else if (i2 < 16448) {
            return i;
        } else {
            if (i2 < 32704) {
                return i + 1;
            }
            return i + 2;
        }
    }

    /* access modifiers changed from: private */
    public static int jumpByDelta(CharSequence charSequence, int i) {
        int i2 = i + 1;
        int charAt = charSequence.charAt(i);
        if (charAt >= 64512) {
            if (charAt == 65535) {
                charAt = (charSequence.charAt(i2) << 16) | charSequence.charAt(i2 + 1);
                i2 += 2;
            } else {
                i2++;
                charAt = ((charAt - 64512) << 16) | charSequence.charAt(i2);
            }
        }
        return i2 + charAt;
    }

    /* access modifiers changed from: private */
    public static int skipDelta(CharSequence charSequence, int i) {
        int i2 = i + 1;
        char charAt = charSequence.charAt(i);
        if (charAt < 64512) {
            return i2;
        }
        if (charAt == 65535) {
            return i2 + 2;
        }
        return i2 + 1;
    }

    private BytesTrie.Result branchNext(int i, int i2, int i3) {
        BytesTrie.Result result;
        int i4;
        if (i2 == 0) {
            i++;
            i2 = this.chars_.charAt(i);
        }
        int i5 = i2 + 1;
        while (i5 > 5) {
            int i6 = i + 1;
            if (i3 < this.chars_.charAt(i)) {
                i5 >>= 1;
                i = jumpByDelta(this.chars_, i6);
            } else {
                i5 -= i5 >> 1;
                i = skipDelta(this.chars_, i6);
            }
        }
        do {
            int i7 = i + 1;
            if (i3 == this.chars_.charAt(i)) {
                char charAt = this.chars_.charAt(i7);
                if ((32768 & charAt) != 0) {
                    result = BytesTrie.Result.FINAL_VALUE;
                } else {
                    int i8 = i7 + 1;
                    if (charAt < 16384) {
                        i4 = charAt;
                    } else if (charAt < 32767) {
                        i8++;
                        i4 = ((charAt - 16384) << 16) | this.chars_.charAt(i8);
                    } else {
                        i4 = (this.chars_.charAt(i8) << 16) | this.chars_.charAt(i8 + 1);
                        i8 += 2;
                    }
                    i7 = i8 + i4;
                    char charAt2 = this.chars_.charAt(i7);
                    result = charAt2 >= '@' ? valueResults_[charAt2 >> 15] : BytesTrie.Result.NO_VALUE;
                }
                this.pos_ = i7;
                return result;
            }
            i5--;
            i = skipValue(this.chars_, i7);
        } while (i5 > 1);
        int i9 = i + 1;
        if (i3 == this.chars_.charAt(i)) {
            this.pos_ = i9;
            char charAt3 = this.chars_.charAt(i9);
            return charAt3 >= '@' ? valueResults_[charAt3 >> 15] : BytesTrie.Result.NO_VALUE;
        }
        stop();
        return BytesTrie.Result.NO_MATCH;
    }

    private BytesTrie.Result nextImpl(int i, int i2) {
        char charAt;
        int i3 = i + 1;
        int charAt2 = this.chars_.charAt(i);
        while (charAt2 >= 48) {
            if (charAt2 < 64) {
                int i4 = charAt2 - 48;
                int i5 = i3 + 1;
                if (i2 == this.chars_.charAt(i3)) {
                    int i6 = i4 - 1;
                    this.remainingMatchLength_ = i6;
                    this.pos_ = i5;
                    return (i6 >= 0 || (charAt = this.chars_.charAt(i5)) < '@') ? BytesTrie.Result.NO_VALUE : valueResults_[charAt >> 15];
                }
            } else if ((32768 & charAt2) == 0) {
                i3 = skipNodeValue(i3, charAt2);
                charAt2 &= 63;
            }
            stop();
            return BytesTrie.Result.NO_MATCH;
        }
        return branchNext(i3, charAt2, i2);
    }
}
