package com.ibm.icu.impl;

import com.ibm.icu.text.UTF16;
import java.nio.ByteBuffer;
import java.util.Arrays;
public abstract class Trie {
    static final /* synthetic */ boolean $assertionsDisabled = (!Trie.class.desiredAssertionStatus());
    protected int m_dataLength_;
    protected DataManipulate m_dataManipulate_;
    protected int m_dataOffset_;
    protected char[] m_index_;
    private boolean m_isLatin1Linear_;
    private int m_options_;

    public interface DataManipulate {
        int getFoldingOffset(int i);
    }

    /* access modifiers changed from: protected */
    public abstract int getSurrogateOffset(char c, char c2);

    static class DefaultGetFoldingOffset implements DataManipulate {
        private DefaultGetFoldingOffset() {
        }

        @Override // com.ibm.icu.impl.Trie.DataManipulate
        public int getFoldingOffset(int i) {
            return i;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Trie)) {
            return false;
        }
        Trie trie = (Trie) obj;
        return this.m_isLatin1Linear_ == trie.m_isLatin1Linear_ && this.m_options_ == trie.m_options_ && this.m_dataLength_ == trie.m_dataLength_ && Arrays.equals(this.m_index_, trie.m_index_);
    }

    public int hashCode() {
        if ($assertionsDisabled) {
            return 42;
        }
        throw new AssertionError("hashCode not designed");
    }

    protected Trie(ByteBuffer byteBuffer, DataManipulate dataManipulate) {
        int i = byteBuffer.getInt();
        this.m_options_ = byteBuffer.getInt();
        if (!checkHeader(i)) {
            throw new IllegalArgumentException("ICU data file error: Trie header authentication failed, please check if you have the most updated ICU data file");
        }
        if (dataManipulate != null) {
            this.m_dataManipulate_ = dataManipulate;
        } else {
            this.m_dataManipulate_ = new DefaultGetFoldingOffset();
        }
        this.m_isLatin1Linear_ = (this.m_options_ & 512) != 0;
        this.m_dataOffset_ = byteBuffer.getInt();
        this.m_dataLength_ = byteBuffer.getInt();
        unserialize(byteBuffer);
    }

    /* access modifiers changed from: protected */
    public final int getRawOffset(int i, char c) {
        return (this.m_index_[(c >> 5) + i] << 2) + (c & 31);
    }

    /* access modifiers changed from: protected */
    public final int getBMPOffset(char c) {
        if (c < 55296 || c > 56319) {
            return getRawOffset(0, c);
        }
        return getRawOffset(320, c);
    }

    /* access modifiers changed from: protected */
    public final int getLeadOffset(char c) {
        return getRawOffset(0, c);
    }

    /* access modifiers changed from: protected */
    public final int getCodePointOffset(int i) {
        if (i < 0) {
            return -1;
        }
        if (i < 55296) {
            return getRawOffset(0, (char) i);
        }
        if (i < 65536) {
            return getBMPOffset((char) i);
        }
        if (i <= 1114111) {
            return getSurrogateOffset(UTF16.getLeadSurrogate(i), (char) (i & 1023));
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void unserialize(ByteBuffer byteBuffer) {
        this.m_index_ = ICUBinary.getChars(byteBuffer, this.m_dataOffset_, 0);
    }

    /* access modifiers changed from: protected */
    public final boolean isCharTrie() {
        return (this.m_options_ & 256) == 0;
    }

    private final boolean checkHeader(int i) {
        if (i == 1416784229 && (this.m_options_ & 15) == 5 && ((this.m_options_ >> 4) & 15) == 2) {
            return true;
        }
        return false;
    }
}
