package com.ibm.icu.impl;

import com.ibm.icu.impl.Trie;
import java.nio.ByteBuffer;
public class CharTrie extends Trie {
    static final /* synthetic */ boolean $assertionsDisabled = (!CharTrie.class.desiredAssertionStatus());
    private char[] m_data_;
    private char m_initialValue_;

    public CharTrie(ByteBuffer byteBuffer, Trie.DataManipulate dataManipulate) {
        super(byteBuffer, dataManipulate);
        if (!isCharTrie()) {
            throw new IllegalArgumentException("Data given does not belong to a char trie.");
        }
    }

    public final char getCodePointValue(int i) {
        if (0 > i || i >= 55296) {
            int codePointOffset = getCodePointOffset(i);
            return codePointOffset >= 0 ? this.m_data_[codePointOffset] : this.m_initialValue_;
        }
        return this.m_data_[(this.m_index_[i >> 5] << 2) + (i & 31)];
    }

    public final char getLeadValue(char c) {
        return this.m_data_[getLeadOffset(c)];
    }

    @Override // com.ibm.icu.impl.Trie
    public boolean equals(Object obj) {
        return super.equals(obj) && (obj instanceof CharTrie) && this.m_initialValue_ == ((CharTrie) obj).m_initialValue_;
    }

    @Override // com.ibm.icu.impl.Trie
    public int hashCode() {
        if ($assertionsDisabled) {
            return 42;
        }
        throw new AssertionError("hashCode not designed");
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.Trie
    public final void unserialize(ByteBuffer byteBuffer) {
        this.m_index_ = ICUBinary.getChars(byteBuffer, this.m_dataOffset_ + this.m_dataLength_, 0);
        this.m_data_ = this.m_index_;
        this.m_initialValue_ = this.m_data_[this.m_dataOffset_];
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.Trie
    public final int getSurrogateOffset(char c, char c2) {
        if (this.m_dataManipulate_ == null) {
            throw new NullPointerException("The field DataManipulate in this Trie is null");
        }
        int foldingOffset = this.m_dataManipulate_.getFoldingOffset(getLeadValue(c));
        if (foldingOffset > 0) {
            return getRawOffset(foldingOffset, (char) (c2 & 1023));
        }
        return -1;
    }
}
