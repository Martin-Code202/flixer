package com.ibm.icu.impl.coll;
public class UTF16CollationIterator extends CollationIterator {
    static final /* synthetic */ boolean $assertionsDisabled = (!UTF16CollationIterator.class.desiredAssertionStatus());
    protected int limit;
    protected int pos;
    protected CharSequence seq;
    protected int start;

    public UTF16CollationIterator(CollationData collationData) {
        super(collationData);
    }

    public UTF16CollationIterator(CollationData collationData, boolean z, CharSequence charSequence, int i) {
        super(collationData, z);
        this.seq = charSequence;
        this.start = 0;
        this.pos = i;
        this.limit = charSequence.length();
    }

    @Override // com.ibm.icu.impl.coll.CollationIterator
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        UTF16CollationIterator uTF16CollationIterator = (UTF16CollationIterator) obj;
        return this.pos - this.start == uTF16CollationIterator.pos - uTF16CollationIterator.start;
    }

    @Override // com.ibm.icu.impl.coll.CollationIterator
    public int hashCode() {
        if ($assertionsDisabled) {
            return 42;
        }
        throw new AssertionError("hashCode not designed");
    }

    @Override // com.ibm.icu.impl.coll.CollationIterator
    public int getOffset() {
        return this.pos - this.start;
    }

    public void setText(boolean z, CharSequence charSequence, int i) {
        reset(z);
        this.seq = charSequence;
        this.start = 0;
        this.pos = i;
        this.limit = charSequence.length();
    }

    @Override // com.ibm.icu.impl.coll.CollationIterator
    public int nextCodePoint() {
        if (this.pos == this.limit) {
            return -1;
        }
        CharSequence charSequence = this.seq;
        int i = this.pos;
        this.pos = i + 1;
        char charAt = charSequence.charAt(i);
        if (Character.isHighSurrogate(charAt) && this.pos != this.limit) {
            char charAt2 = this.seq.charAt(this.pos);
            if (Character.isLowSurrogate(charAt2)) {
                this.pos++;
                return Character.toCodePoint(charAt, charAt2);
            }
        }
        return charAt;
    }

    @Override // com.ibm.icu.impl.coll.CollationIterator
    public int previousCodePoint() {
        if (this.pos == this.start) {
            return -1;
        }
        CharSequence charSequence = this.seq;
        int i = this.pos - 1;
        this.pos = i;
        char charAt = charSequence.charAt(i);
        if (Character.isLowSurrogate(charAt) && this.pos != this.start) {
            char charAt2 = this.seq.charAt(this.pos - 1);
            if (Character.isHighSurrogate(charAt2)) {
                this.pos--;
                return Character.toCodePoint(charAt2, charAt);
            }
        }
        return charAt;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.coll.CollationIterator
    public long handleNextCE32() {
        if (this.pos == this.limit) {
            return -4294967104L;
        }
        CharSequence charSequence = this.seq;
        int i = this.pos;
        this.pos = i + 1;
        char charAt = charSequence.charAt(i);
        return makeCodePointAndCE32Pair(charAt, this.trie.getFromU16SingleLead(charAt));
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.coll.CollationIterator
    public char handleGetTrailSurrogate() {
        if (this.pos == this.limit) {
            return 0;
        }
        char charAt = this.seq.charAt(this.pos);
        if (Character.isLowSurrogate(charAt)) {
            this.pos++;
        }
        return charAt;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.coll.CollationIterator
    public void forwardNumCodePoints(int i) {
        while (i > 0 && this.pos != this.limit) {
            CharSequence charSequence = this.seq;
            int i2 = this.pos;
            this.pos = i2 + 1;
            i--;
            if (Character.isHighSurrogate(charSequence.charAt(i2)) && this.pos != this.limit && Character.isLowSurrogate(this.seq.charAt(this.pos))) {
                this.pos++;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.coll.CollationIterator
    public void backwardNumCodePoints(int i) {
        while (i > 0 && this.pos != this.start) {
            CharSequence charSequence = this.seq;
            int i2 = this.pos - 1;
            this.pos = i2;
            i--;
            if (Character.isLowSurrogate(charSequence.charAt(i2)) && this.pos != this.start && Character.isHighSurrogate(this.seq.charAt(this.pos - 1))) {
                this.pos--;
            }
        }
    }
}
