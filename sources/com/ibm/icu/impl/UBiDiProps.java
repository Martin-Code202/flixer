package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.Trie2;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ICUUncheckedIOException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
public final class UBiDiProps {
    public static final UBiDiProps INSTANCE;
    private int[] indexes;
    private byte[] jgArray;
    private byte[] jgArray2;
    private int[] mirrors;
    private Trie2_16 trie;

    private UBiDiProps() {
        readData(ICUBinary.getData("ubidi.icu"));
    }

    private void readData(ByteBuffer byteBuffer) {
        ICUBinary.readHeader(byteBuffer, 1114195049, new IsAcceptable());
        int i = byteBuffer.getInt();
        if (i < 16) {
            throw new IOException("indexes[0] too small in ubidi.icu");
        }
        this.indexes = new int[i];
        this.indexes[0] = i;
        for (int i2 = 1; i2 < i; i2++) {
            this.indexes[i2] = byteBuffer.getInt();
        }
        this.trie = Trie2_16.createFromSerialized(byteBuffer);
        int i3 = this.indexes[2];
        int serializedLength = this.trie.getSerializedLength();
        if (serializedLength > i3) {
            throw new IOException("ubidi.icu: not enough bytes for the trie");
        }
        ICUBinary.skipBytes(byteBuffer, i3 - serializedLength);
        int i4 = this.indexes[3];
        if (i4 > 0) {
            this.mirrors = ICUBinary.getInts(byteBuffer, i4, 0);
        }
        this.jgArray = new byte[(this.indexes[5] - this.indexes[4])];
        byteBuffer.get(this.jgArray);
        this.jgArray2 = new byte[(this.indexes[7] - this.indexes[6])];
        byteBuffer.get(this.jgArray2);
    }

    /* access modifiers changed from: package-private */
    public static final class IsAcceptable implements ICUBinary.Authenticate {
        private IsAcceptable() {
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return bArr[0] == 2;
        }
    }

    public final void addPropertyStarts(UnicodeSet unicodeSet) {
        Iterator<Trie2.Range> it = this.trie.iterator();
        while (it.hasNext()) {
            Trie2.Range next = it.next();
            if (next.leadSurrogate) {
                break;
            }
            unicodeSet.add(next.startCodePoint);
        }
        int i = this.indexes[3];
        for (int i2 = 0; i2 < i; i2++) {
            int mirrorCodePoint = getMirrorCodePoint(this.mirrors[i2]);
            unicodeSet.add(mirrorCodePoint, mirrorCodePoint + 1);
        }
        int i3 = this.indexes[4];
        int i4 = this.indexes[5];
        byte[] bArr = this.jgArray;
        while (true) {
            int i5 = i4 - i3;
            byte b = 0;
            for (int i6 = 0; i6 < i5; i6++) {
                byte b2 = bArr[i6];
                if (b2 != b) {
                    unicodeSet.add(i3);
                    b = b2;
                }
                i3++;
            }
            if (b != 0) {
                unicodeSet.add(i4);
            }
            if (i4 == this.indexes[5]) {
                i3 = this.indexes[6];
                i4 = this.indexes[7];
                bArr = this.jgArray2;
            } else {
                return;
            }
        }
    }

    public final int getClass(int i) {
        return getClassFromProps(this.trie.get(i));
    }

    public final boolean isMirrored(int i) {
        return getFlagFromProps(this.trie.get(i), 12);
    }

    public final boolean isBidiControl(int i) {
        return getFlagFromProps(this.trie.get(i), 11);
    }

    public final boolean isJoinControl(int i) {
        return getFlagFromProps(this.trie.get(i), 10);
    }

    public final int getJoiningType(int i) {
        return (this.trie.get(i) & 224) >> 5;
    }

    public final int getJoiningGroup(int i) {
        int i2 = this.indexes[4];
        int i3 = this.indexes[5];
        if (i2 <= i && i < i3) {
            return this.jgArray[i - i2] & 255;
        }
        int i4 = this.indexes[6];
        int i5 = this.indexes[7];
        if (i4 > i || i >= i5) {
            return 0;
        }
        return this.jgArray2[i - i4] & 255;
    }

    public final int getPairedBracketType(int i) {
        return (this.trie.get(i) & 768) >> 8;
    }

    private static final int getClassFromProps(int i) {
        return i & 31;
    }

    private static final boolean getFlagFromProps(int i, int i2) {
        return ((i >> i2) & 1) != 0;
    }

    private static final int getMirrorCodePoint(int i) {
        return 2097151 & i;
    }

    static {
        try {
            INSTANCE = new UBiDiProps();
        } catch (IOException e) {
            throw new ICUUncheckedIOException(e);
        }
    }
}
