package com.ibm.icu.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.NoSuchElementException;
public abstract class Trie2 implements Iterable<Range> {
    private static ValueMapper defaultValueMapper = new ValueMapper() { // from class: com.ibm.icu.impl.Trie2.1
        @Override // com.ibm.icu.impl.Trie2.ValueMapper
        public int map(int i) {
            return i;
        }
    };
    int data16;
    int[] data32;
    int dataLength;
    int dataNullOffset;
    int errorValue;
    int fHash;
    UTrie2Header header;
    int highStart;
    int highValueIndex;
    char[] index;
    int index2NullOffset;
    int indexLength;
    int initialValue;

    public interface ValueMapper {
        int map(int i);
    }

    enum ValueWidth {
        BITS_16,
        BITS_32
    }

    public abstract int get(int i);

    public abstract int getFromU16SingleLead(char c);

    public static Trie2 createFromSerialized(ByteBuffer byteBuffer) {
        Trie2 trie2;
        ValueWidth valueWidth;
        ByteOrder order = byteBuffer.order();
        try {
            UTrie2Header uTrie2Header = new UTrie2Header();
            uTrie2Header.signature = byteBuffer.getInt();
            switch (uTrie2Header.signature) {
                case 845771348:
                    byteBuffer.order(order == ByteOrder.BIG_ENDIAN ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                    uTrie2Header.signature = 1416784178;
                    break;
                case 1416784178:
                    break;
                default:
                    throw new IllegalArgumentException("Buffer does not contain a serialized UTrie2");
            }
            uTrie2Header.options = byteBuffer.getChar();
            uTrie2Header.indexLength = byteBuffer.getChar();
            uTrie2Header.shiftedDataLength = byteBuffer.getChar();
            uTrie2Header.index2NullOffset = byteBuffer.getChar();
            uTrie2Header.dataNullOffset = byteBuffer.getChar();
            uTrie2Header.shiftedHighStart = byteBuffer.getChar();
            if ((uTrie2Header.options & 15) > 1) {
                throw new IllegalArgumentException("UTrie2 serialized format error.");
            }
            if ((uTrie2Header.options & 15) == 0) {
                valueWidth = ValueWidth.BITS_16;
                trie2 = new Trie2_16();
            } else {
                valueWidth = ValueWidth.BITS_32;
                trie2 = new Trie2_32();
            }
            trie2.header = uTrie2Header;
            trie2.indexLength = uTrie2Header.indexLength;
            trie2.dataLength = uTrie2Header.shiftedDataLength << 2;
            trie2.index2NullOffset = uTrie2Header.index2NullOffset;
            trie2.dataNullOffset = uTrie2Header.dataNullOffset;
            trie2.highStart = uTrie2Header.shiftedHighStart << 11;
            trie2.highValueIndex = trie2.dataLength - 4;
            if (valueWidth == ValueWidth.BITS_16) {
                trie2.highValueIndex += trie2.indexLength;
            }
            int i = trie2.indexLength;
            if (valueWidth == ValueWidth.BITS_16) {
                i += trie2.dataLength;
            }
            trie2.index = ICUBinary.getChars(byteBuffer, i, 0);
            if (valueWidth == ValueWidth.BITS_16) {
                trie2.data16 = trie2.indexLength;
            } else {
                trie2.data32 = ICUBinary.getInts(byteBuffer, trie2.dataLength, 0);
            }
            switch (valueWidth) {
                case BITS_16:
                    trie2.data32 = null;
                    trie2.initialValue = trie2.index[trie2.dataNullOffset];
                    trie2.errorValue = trie2.index[trie2.data16 + 128];
                    break;
                case BITS_32:
                    trie2.data16 = 0;
                    trie2.initialValue = trie2.data32[trie2.dataNullOffset];
                    trie2.errorValue = trie2.data32[128];
                    break;
                default:
                    throw new IllegalArgumentException("UTrie2 serialized format error.");
            }
            return trie2;
        } finally {
            byteBuffer.order(order);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0017  */
    @Override // java.lang.Object
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.ibm.icu.impl.Trie2
            if (r0 != 0) goto L_0x0006
            r0 = 0
            return r0
        L_0x0006:
            r2 = r8
            com.ibm.icu.impl.Trie2 r2 = (com.ibm.icu.impl.Trie2) r2
            java.util.Iterator r4 = r2.iterator()
            java.util.Iterator r5 = r7.iterator()
        L_0x0011:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0036
            java.lang.Object r0 = r5.next()
            r6 = r0
            com.ibm.icu.impl.Trie2$Range r6 = (com.ibm.icu.impl.Trie2.Range) r6
            boolean r0 = r4.hasNext()
            if (r0 != 0) goto L_0x0026
            r0 = 0
            return r0
        L_0x0026:
            java.lang.Object r0 = r4.next()
            r3 = r0
            com.ibm.icu.impl.Trie2$Range r3 = (com.ibm.icu.impl.Trie2.Range) r3
            boolean r0 = r6.equals(r3)
            if (r0 != 0) goto L_0x0035
            r0 = 0
            return r0
        L_0x0035:
            goto L_0x0011
        L_0x0036:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x003e
            r0 = 0
            return r0
        L_0x003e:
            int r0 = r7.errorValue
            int r1 = r2.errorValue
            if (r0 != r1) goto L_0x004a
            int r0 = r7.initialValue
            int r1 = r2.initialValue
            if (r0 == r1) goto L_0x004c
        L_0x004a:
            r0 = 0
            return r0
        L_0x004c:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.Trie2.equals(java.lang.Object):boolean");
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.fHash == 0) {
            int initHash = initHash();
            Iterator<Range> it = iterator();
            while (it.hasNext()) {
                initHash = hashInt(initHash, it.next().hashCode());
            }
            if (initHash == 0) {
                initHash = 1;
            }
            this.fHash = initHash;
        }
        return this.fHash;
    }

    public static class Range {
        public int endCodePoint;
        public boolean leadSurrogate;
        public int startCodePoint;
        public int value;

        public boolean equals(Object obj) {
            if (obj == null || !obj.getClass().equals(getClass())) {
                return false;
            }
            Range range = (Range) obj;
            return this.startCodePoint == range.startCodePoint && this.endCodePoint == range.endCodePoint && this.value == range.value && this.leadSurrogate == range.leadSurrogate;
        }

        public int hashCode() {
            return Trie2.hashByte(Trie2.hashInt(Trie2.hashUChar32(Trie2.hashUChar32(Trie2.initHash(), this.startCodePoint), this.endCodePoint), this.value), this.leadSurrogate ? 1 : 0);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Range> iterator() {
        return iterator(defaultValueMapper);
    }

    public Iterator<Range> iterator(ValueMapper valueMapper) {
        return new Trie2Iterator(valueMapper);
    }

    /* access modifiers changed from: package-private */
    public static class UTrie2Header {
        int dataNullOffset;
        int index2NullOffset;
        int indexLength;
        int options;
        int shiftedDataLength;
        int shiftedHighStart;
        int signature;

        UTrie2Header() {
        }
    }

    /* access modifiers changed from: package-private */
    public class Trie2Iterator implements Iterator<Range> {
        private boolean doLeadSurrogates = true;
        private boolean doingCodePoints = true;
        private int limitCP;
        private ValueMapper mapper;
        private int nextStart;
        private Range returnValue = new Range();

        Trie2Iterator(ValueMapper valueMapper) {
            this.mapper = valueMapper;
            this.nextStart = 0;
            this.limitCP = 1114112;
            this.doLeadSurrogates = true;
        }

        @Override // java.util.Iterator
        public Range next() {
            int i;
            int i2;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.nextStart >= this.limitCP) {
                this.doingCodePoints = false;
                this.nextStart = 55296;
            }
            if (this.doingCodePoints) {
                int i3 = Trie2.this.get(this.nextStart);
                i = this.mapper.map(i3);
                i2 = Trie2.this.rangeEnd(this.nextStart, this.limitCP, i3);
                while (i2 < this.limitCP - 1) {
                    int i4 = Trie2.this.get(i2 + 1);
                    if (this.mapper.map(i4) != i) {
                        break;
                    }
                    i2 = Trie2.this.rangeEnd(i2 + 1, this.limitCP, i4);
                }
            } else {
                i = this.mapper.map(Trie2.this.getFromU16SingleLead((char) this.nextStart));
                i2 = rangeEndLS((char) this.nextStart);
                while (i2 < 56319) {
                    if (this.mapper.map(Trie2.this.getFromU16SingleLead((char) (i2 + 1))) != i) {
                        break;
                    }
                    i2 = rangeEndLS((char) (i2 + 1));
                }
            }
            this.returnValue.startCodePoint = this.nextStart;
            this.returnValue.endCodePoint = i2;
            this.returnValue.value = i;
            this.returnValue.leadSurrogate = !this.doingCodePoints;
            this.nextStart = i2 + 1;
            return this.returnValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return (this.doingCodePoints && (this.doLeadSurrogates || this.nextStart < this.limitCP)) || this.nextStart < 56320;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private int rangeEndLS(char c) {
            if (c >= 56319) {
                return 56319;
            }
            int fromU16SingleLead = Trie2.this.getFromU16SingleLead(c);
            int i = c + 1;
            while (i <= 56319 && Trie2.this.getFromU16SingleLead((char) i) == fromU16SingleLead) {
                i++;
            }
            return i - 1;
        }
    }

    /* access modifiers changed from: package-private */
    public int rangeEnd(int i, int i2, int i3) {
        int min = Math.min(this.highStart, i2);
        int i4 = i + 1;
        while (i4 < min && get(i4) == i3) {
            i4++;
        }
        if (i4 >= this.highStart) {
            i4 = i2;
        }
        return i4 - 1;
    }

    /* access modifiers changed from: private */
    public static int initHash() {
        return -2128831035;
    }

    /* access modifiers changed from: private */
    public static int hashByte(int i, int i2) {
        return (i * 16777619) ^ i2;
    }

    /* access modifiers changed from: private */
    public static int hashUChar32(int i, int i2) {
        return hashByte(hashByte(hashByte(i, i2 & 255), (i2 >> 8) & 255), i2 >> 16);
    }

    /* access modifiers changed from: private */
    public static int hashInt(int i, int i2) {
        return hashByte(hashByte(hashByte(hashByte(i, i2 & 255), (i2 >> 8) & 255), (i2 >> 16) & 255), (i2 >> 24) & 255);
    }
}
