package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Trie2_32;
import com.ibm.icu.util.BytesTrie;
import com.ibm.icu.util.CharsTrie;
import com.ibm.icu.util.ICUException;
public abstract class CollationIterator {
    static final /* synthetic */ boolean $assertionsDisabled = (!CollationIterator.class.desiredAssertionStatus());
    private CEBuffer ceBuffer;
    private int cesIndex;
    protected final CollationData data;
    private boolean isNumeric;
    private int numCpFwd;
    private SkippedState skipped;
    protected final Trie2_32 trie;

    /* access modifiers changed from: protected */
    public abstract void backwardNumCodePoints(int i);

    /* access modifiers changed from: protected */
    public abstract void forwardNumCodePoints(int i);

    public abstract int getOffset();

    public abstract int nextCodePoint();

    public abstract int previousCodePoint();

    /* access modifiers changed from: package-private */
    public static final class CEBuffer {
        private long[] buffer = new long[40];
        int length = 0;

        CEBuffer() {
        }

        /* access modifiers changed from: package-private */
        public void append(long j) {
            if (this.length >= 40) {
                ensureAppendCapacity(1);
            }
            long[] jArr = this.buffer;
            int i = this.length;
            this.length = i + 1;
            jArr[i] = j;
        }

        /* access modifiers changed from: package-private */
        public void appendUnsafe(long j) {
            long[] jArr = this.buffer;
            int i = this.length;
            this.length = i + 1;
            jArr[i] = j;
        }

        /* access modifiers changed from: package-private */
        public void ensureAppendCapacity(int i) {
            int length2 = this.buffer.length;
            if (this.length + i > length2) {
                do {
                    if (length2 < 1000) {
                        length2 *= 4;
                    } else {
                        length2 *= 2;
                    }
                } while (length2 < this.length + i);
                long[] jArr = new long[length2];
                System.arraycopy(this.buffer, 0, jArr, 0, this.length);
                this.buffer = jArr;
            }
        }

        /* access modifiers changed from: package-private */
        public void incLength() {
            if (this.length >= 40) {
                ensureAppendCapacity(1);
            }
            this.length++;
        }

        /* access modifiers changed from: package-private */
        public long set(int i, long j) {
            this.buffer[i] = j;
            return j;
        }

        /* access modifiers changed from: package-private */
        public long get(int i) {
            return this.buffer[i];
        }

        /* access modifiers changed from: package-private */
        public long[] getCEs() {
            return this.buffer;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class SkippedState {
        static final /* synthetic */ boolean $assertionsDisabled = (!CollationIterator.class.desiredAssertionStatus());
        private final StringBuilder newBuffer = new StringBuilder();
        private final StringBuilder oldBuffer = new StringBuilder();
        private int pos;
        private int skipLengthAtMatch;
        private CharsTrie.State state = new CharsTrie.State();

        SkippedState() {
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.oldBuffer.setLength(0);
            this.pos = 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.oldBuffer.length() == 0;
        }

        /* access modifiers changed from: package-private */
        public boolean hasNext() {
            return this.pos < this.oldBuffer.length();
        }

        /* access modifiers changed from: package-private */
        public int next() {
            int codePointAt = this.oldBuffer.codePointAt(this.pos);
            this.pos += Character.charCount(codePointAt);
            return codePointAt;
        }

        /* access modifiers changed from: package-private */
        public void incBeyond() {
            if ($assertionsDisabled || !hasNext()) {
                this.pos++;
                return;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public int backwardNumCodePoints(int i) {
            int length = this.oldBuffer.length();
            int i2 = this.pos - length;
            if (i2 <= 0) {
                this.pos = this.oldBuffer.offsetByCodePoints(this.pos, -i);
                return 0;
            } else if (i2 >= i) {
                this.pos -= i;
                return i;
            } else {
                this.pos = this.oldBuffer.offsetByCodePoints(length, i2 - i);
                return i2;
            }
        }

        /* access modifiers changed from: package-private */
        public void setFirstSkipped(int i) {
            this.skipLengthAtMatch = 0;
            this.newBuffer.setLength(0);
            this.newBuffer.appendCodePoint(i);
        }

        /* access modifiers changed from: package-private */
        public void skip(int i) {
            this.newBuffer.appendCodePoint(i);
        }

        /* access modifiers changed from: package-private */
        public void recordMatch() {
            this.skipLengthAtMatch = this.newBuffer.length();
        }

        /* access modifiers changed from: package-private */
        public void replaceMatch() {
            int length = this.oldBuffer.length();
            if (this.pos > length) {
                this.pos = length;
            }
            this.oldBuffer.delete(0, this.pos).insert(0, this.newBuffer, 0, this.skipLengthAtMatch);
            this.pos = 0;
        }

        /* access modifiers changed from: package-private */
        public void saveTrieState(CharsTrie charsTrie) {
            charsTrie.saveState(this.state);
        }

        /* access modifiers changed from: package-private */
        public void resetToTrieState(CharsTrie charsTrie) {
            charsTrie.resetToState(this.state);
        }
    }

    public CollationIterator(CollationData collationData) {
        this.trie = collationData.trie;
        this.data = collationData;
        this.numCpFwd = -1;
        this.isNumeric = false;
        this.ceBuffer = null;
    }

    public CollationIterator(CollationData collationData, boolean z) {
        this.trie = collationData.trie;
        this.data = collationData;
        this.numCpFwd = -1;
        this.isNumeric = z;
        this.ceBuffer = new CEBuffer();
    }

    public boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        CollationIterator collationIterator = (CollationIterator) obj;
        if (!(this.ceBuffer.length == collationIterator.ceBuffer.length && this.cesIndex == collationIterator.cesIndex && this.numCpFwd == collationIterator.numCpFwd && this.isNumeric == collationIterator.isNumeric)) {
            return false;
        }
        for (int i = 0; i < this.ceBuffer.length; i++) {
            if (this.ceBuffer.get(i) != collationIterator.ceBuffer.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public final long nextCE() {
        CollationData collationData;
        if (this.cesIndex < this.ceBuffer.length) {
            CEBuffer cEBuffer = this.ceBuffer;
            int i = this.cesIndex;
            this.cesIndex = i + 1;
            return cEBuffer.get(i);
        } else if ($assertionsDisabled || this.cesIndex == this.ceBuffer.length) {
            this.ceBuffer.incLength();
            long handleNextCE32 = handleNextCE32();
            int i2 = (int) (handleNextCE32 >> 32);
            int i3 = (int) handleNextCE32;
            int i4 = i3 & 255;
            if (i4 < 192) {
                CEBuffer cEBuffer2 = this.ceBuffer;
                int i5 = this.cesIndex;
                this.cesIndex = i5 + 1;
                return cEBuffer2.set(i5, (((long) (-65536 & i3)) << 32) | (((long) (65280 & i3)) << 16) | ((long) (i4 << 8)));
            }
            if (i4 != 192) {
                collationData = this.data;
            } else if (i2 < 0) {
                CEBuffer cEBuffer3 = this.ceBuffer;
                int i6 = this.cesIndex;
                this.cesIndex = i6 + 1;
                return cEBuffer3.set(i6, 4311744768L);
            } else {
                collationData = this.data.base;
                i3 = collationData.getCE32(i2);
                i4 = i3 & 255;
                if (i4 < 192) {
                    CEBuffer cEBuffer4 = this.ceBuffer;
                    int i7 = this.cesIndex;
                    this.cesIndex = i7 + 1;
                    return cEBuffer4.set(i7, (((long) (-65536 & i3)) << 32) | (((long) (65280 & i3)) << 16) | ((long) (i4 << 8)));
                }
            }
            if (i4 != 193) {
                return nextCEFromCE32(collationData, i2, i3);
            }
            CEBuffer cEBuffer5 = this.ceBuffer;
            int i8 = this.cesIndex;
            this.cesIndex = i8 + 1;
            return cEBuffer5.set(i8, (((long) (i3 - i4)) << 32) | 83887360);
        } else {
            throw new AssertionError();
        }
    }

    public final int fetchCEs() {
        while (nextCE() != 4311744768L) {
            this.cesIndex = this.ceBuffer.length;
        }
        return this.ceBuffer.length;
    }

    /* access modifiers changed from: package-private */
    public final void setCurrentCE(long j) {
        if ($assertionsDisabled || this.cesIndex > 0) {
            this.ceBuffer.set(this.cesIndex - 1, j);
            return;
        }
        throw new AssertionError();
    }

    public final int getCEsLength() {
        return this.ceBuffer.length;
    }

    public final long getCE(int i) {
        return this.ceBuffer.get(i);
    }

    public final long[] getCEs() {
        return this.ceBuffer.getCEs();
    }

    /* access modifiers changed from: package-private */
    public final void clearCEs() {
        this.ceBuffer.length = 0;
        this.cesIndex = 0;
    }

    public final void clearCEsIfNoneRemaining() {
        if (this.cesIndex == this.ceBuffer.length) {
            clearCEs();
        }
    }

    /* access modifiers changed from: protected */
    public final void reset() {
        this.ceBuffer.length = 0;
        this.cesIndex = 0;
        if (this.skipped != null) {
            this.skipped.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void reset(boolean z) {
        if (this.ceBuffer == null) {
            this.ceBuffer = new CEBuffer();
        }
        reset();
        this.isNumeric = z;
    }

    /* access modifiers changed from: protected */
    public long handleNextCE32() {
        int nextCodePoint = nextCodePoint();
        if (nextCodePoint < 0) {
            return -4294967104L;
        }
        return makeCodePointAndCE32Pair(nextCodePoint, this.data.getCE32(nextCodePoint));
    }

    /* access modifiers changed from: protected */
    public long makeCodePointAndCE32Pair(int i, int i2) {
        return (((long) i) << 32) | (((long) i2) & 4294967295L);
    }

    /* access modifiers changed from: protected */
    public char handleGetTrailSurrogate() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean forbidSurrogateCodePoints() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int getDataCE32(int i) {
        return this.data.getCE32(i);
    }

    /* access modifiers changed from: protected */
    public int getCE32FromBuilderData(int i) {
        throw new ICUException("internal program error: should be unreachable");
    }

    /* access modifiers changed from: protected */
    public final void appendCEsFromCE32(CollationData collationData, int i, int i2, boolean z) {
        int i3;
        while (Collation.isSpecialCE32(i2)) {
            switch (Collation.tagFromCE32(i2)) {
                case 0:
                case 3:
                    throw new ICUException("internal program error: should be unreachable");
                case 1:
                    this.ceBuffer.append(Collation.ceFromLongPrimaryCE32(i2));
                    return;
                case 2:
                    this.ceBuffer.append(Collation.ceFromLongSecondaryCE32(i2));
                    return;
                case 4:
                    this.ceBuffer.ensureAppendCapacity(2);
                    this.ceBuffer.set(this.ceBuffer.length, Collation.latinCE0FromCE32(i2));
                    this.ceBuffer.set(this.ceBuffer.length + 1, Collation.latinCE1FromCE32(i2));
                    this.ceBuffer.length += 2;
                    return;
                case 5:
                    int indexFromCE32 = Collation.indexFromCE32(i2);
                    int lengthFromCE32 = Collation.lengthFromCE32(i2);
                    this.ceBuffer.ensureAppendCapacity(lengthFromCE32);
                    do {
                        indexFromCE32++;
                        this.ceBuffer.appendUnsafe(Collation.ceFromCE32(collationData.ce32s[indexFromCE32]));
                        lengthFromCE32--;
                    } while (lengthFromCE32 > 0);
                    return;
                case 6:
                    int indexFromCE322 = Collation.indexFromCE32(i2);
                    int lengthFromCE322 = Collation.lengthFromCE32(i2);
                    this.ceBuffer.ensureAppendCapacity(lengthFromCE322);
                    do {
                        indexFromCE322++;
                        this.ceBuffer.appendUnsafe(collationData.ces[indexFromCE322]);
                        lengthFromCE322--;
                    } while (lengthFromCE322 > 0);
                    return;
                case 7:
                    i2 = getCE32FromBuilderData(i2);
                    if (i2 != 192) {
                        break;
                    } else {
                        collationData = this.data.base;
                        i2 = collationData.getCE32(i);
                        break;
                    }
                case 8:
                    if (z) {
                        backwardNumCodePoints(1);
                    }
                    i2 = getCE32FromPrefix(collationData, i2);
                    if (!z) {
                        break;
                    } else {
                        forwardNumCodePoints(1);
                        break;
                    }
                case 9:
                    int indexFromCE323 = Collation.indexFromCE32(i2);
                    int cE32FromContexts = collationData.getCE32FromContexts(indexFromCE323);
                    if (z) {
                        if (this.skipped == null && this.numCpFwd < 0) {
                            i3 = nextCodePoint();
                            if (i3 >= 0) {
                                if ((i2 & 512) != 0 && !CollationFCD.mayHaveLccc(i3)) {
                                    backwardNumCodePoints(1);
                                    i2 = cE32FromContexts;
                                    break;
                                }
                            } else {
                                i2 = cE32FromContexts;
                                break;
                            }
                        } else {
                            i3 = nextSkippedCodePoint();
                            if (i3 >= 0) {
                                if ((i2 & 512) != 0 && !CollationFCD.mayHaveLccc(i3)) {
                                    backwardNumSkipped(1);
                                    i2 = cE32FromContexts;
                                    break;
                                }
                            } else {
                                i2 = cE32FromContexts;
                                break;
                            }
                        }
                        i2 = nextCE32FromContraction(collationData, i2, collationData.contexts, indexFromCE323 + 2, cE32FromContexts, i3);
                        if (i2 != 1) {
                            break;
                        } else {
                            return;
                        }
                    } else {
                        i2 = cE32FromContexts;
                        break;
                    }
                case 10:
                    if (!this.isNumeric) {
                        i2 = collationData.ce32s[Collation.indexFromCE32(i2)];
                        break;
                    } else {
                        appendNumericCEs(i2, z);
                        return;
                    }
                case 11:
                    if ($assertionsDisabled || i == 0) {
                        i2 = collationData.ce32s[0];
                        break;
                    } else {
                        throw new AssertionError();
                    }
                case 12:
                    int[] iArr = collationData.jamoCE32s;
                    int i4 = i - 44032;
                    int i5 = i4 % 28;
                    int i6 = i4 / 28;
                    int i7 = i6 % 21;
                    int i8 = i6 / 21;
                    if ((i2 & 256) == 0) {
                        appendCEsFromCE32(collationData, -1, iArr[i8], z);
                        appendCEsFromCE32(collationData, -1, iArr[i7 + 19], z);
                        if (i5 != 0) {
                            i2 = iArr[i5 + 39];
                            i = -1;
                            break;
                        } else {
                            return;
                        }
                    } else {
                        this.ceBuffer.ensureAppendCapacity(i5 == 0 ? 2 : 3);
                        this.ceBuffer.set(this.ceBuffer.length, Collation.ceFromCE32(iArr[i8]));
                        this.ceBuffer.set(this.ceBuffer.length + 1, Collation.ceFromCE32(iArr[i7 + 19]));
                        this.ceBuffer.length += 2;
                        if (i5 != 0) {
                            this.ceBuffer.appendUnsafe(Collation.ceFromCE32(iArr[i5 + 39]));
                            return;
                        }
                        return;
                    }
                case 13:
                    if (!$assertionsDisabled && !z) {
                        throw new AssertionError();
                    } else if ($assertionsDisabled || isLeadSurrogate(i)) {
                        char handleGetTrailSurrogate = handleGetTrailSurrogate();
                        if (!Character.isLowSurrogate(handleGetTrailSurrogate)) {
                            i2 = -1;
                            break;
                        } else {
                            i = Character.toCodePoint((char) i, handleGetTrailSurrogate);
                            int i9 = i2 & 768;
                            if (i9 != 0) {
                                if (i9 != 256) {
                                    int cE32FromSupplementary = collationData.getCE32FromSupplementary(i);
                                    i2 = cE32FromSupplementary;
                                    if (cE32FromSupplementary != 192) {
                                        break;
                                    }
                                }
                                collationData = collationData.base;
                                i2 = collationData.getCE32FromSupplementary(i);
                                break;
                            } else {
                                i2 = -1;
                                break;
                            }
                        }
                    } else {
                        throw new AssertionError();
                    }
                case 14:
                    if ($assertionsDisabled || i >= 0) {
                        this.ceBuffer.append(collationData.getCEFromOffsetCE32(i, i2));
                        return;
                    }
                    throw new AssertionError();
                case 15:
                    if ($assertionsDisabled || i >= 0) {
                        if (isSurrogate(i) && forbidSurrogateCodePoints()) {
                            i2 = -195323;
                            break;
                        } else {
                            this.ceBuffer.append(Collation.unassignedCEFromCodePoint(i));
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
            }
        }
        this.ceBuffer.append(Collation.ceFromSimpleCE32(i2));
    }

    private static final boolean isSurrogate(int i) {
        return (i & -2048) == 55296;
    }

    protected static final boolean isLeadSurrogate(int i) {
        return (i & -1024) == 55296;
    }

    private final long nextCEFromCE32(CollationData collationData, int i, int i2) {
        CEBuffer cEBuffer = this.ceBuffer;
        cEBuffer.length--;
        appendCEsFromCE32(collationData, i, i2, true);
        CEBuffer cEBuffer2 = this.ceBuffer;
        int i3 = this.cesIndex;
        this.cesIndex = i3 + 1;
        return cEBuffer2.get(i3);
    }

    private final int getCE32FromPrefix(CollationData collationData, int i) {
        BytesTrie.Result nextForCodePoint;
        int indexFromCE32 = Collation.indexFromCE32(i);
        int cE32FromContexts = collationData.getCE32FromContexts(indexFromCE32);
        int i2 = 0;
        CharsTrie charsTrie = new CharsTrie(collationData.contexts, indexFromCE32 + 2);
        do {
            int previousCodePoint = previousCodePoint();
            if (previousCodePoint < 0) {
                break;
            }
            i2++;
            nextForCodePoint = charsTrie.nextForCodePoint(previousCodePoint);
            if (nextForCodePoint.hasValue()) {
                cE32FromContexts = charsTrie.getValue();
            }
        } while (nextForCodePoint.hasNext());
        forwardNumCodePoints(i2);
        return cE32FromContexts;
    }

    private final int nextSkippedCodePoint() {
        if (this.skipped != null && this.skipped.hasNext()) {
            return this.skipped.next();
        }
        if (this.numCpFwd == 0) {
            return -1;
        }
        int nextCodePoint = nextCodePoint();
        if (this.skipped != null && !this.skipped.isEmpty() && nextCodePoint >= 0) {
            this.skipped.incBeyond();
        }
        if (this.numCpFwd > 0 && nextCodePoint >= 0) {
            this.numCpFwd--;
        }
        return nextCodePoint;
    }

    private final void backwardNumSkipped(int i) {
        if (this.skipped != null && !this.skipped.isEmpty()) {
            i = this.skipped.backwardNumCodePoints(i);
        }
        backwardNumCodePoints(i);
        if (this.numCpFwd >= 0) {
            this.numCpFwd += i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        if ((r13 & 1024) == 0) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        if ((r13 & 256) == 0) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        if (r7 >= r6) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
        if (r7 <= 1) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0062, code lost:
        backwardNumSkipped(r7);
        r17 = nextSkippedCodePoint();
        r6 = r6 - (r7 - 1);
        r7 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0075, code lost:
        if (r12.getFCD16(r17) <= 255) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
        return nextCE32FromDiscontiguousContraction(r12, r8, r16, r6, r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0092, code lost:
        backwardNumSkipped(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0095, code lost:
        return r16;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int nextCE32FromContraction(com.ibm.icu.impl.coll.CollationData r12, int r13, java.lang.CharSequence r14, int r15, int r16, int r17) {
        /*
            r11 = this;
            r6 = 1
            r7 = 1
            com.ibm.icu.util.CharsTrie r8 = new com.ibm.icu.util.CharsTrie
            r8.<init>(r14, r15)
            com.ibm.icu.impl.coll.CollationIterator$SkippedState r0 = r11.skipped
            if (r0 == 0) goto L_0x0018
            com.ibm.icu.impl.coll.CollationIterator$SkippedState r0 = r11.skipped
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0018
            com.ibm.icu.impl.coll.CollationIterator$SkippedState r0 = r11.skipped
            r0.saveTrieState(r8)
        L_0x0018:
            r0 = r17
            com.ibm.icu.util.BytesTrie$Result r9 = r8.firstForCodePoint(r0)
        L_0x001e:
            boolean r0 = r9.hasValue()
            if (r0 == 0) goto L_0x004a
            int r16 = r8.getValue()
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x0036
            int r0 = r11.nextSkippedCodePoint()
            r17 = r0
            if (r0 >= 0) goto L_0x0037
        L_0x0036:
            return r16
        L_0x0037:
            com.ibm.icu.impl.coll.CollationIterator$SkippedState r0 = r11.skipped
            if (r0 == 0) goto L_0x0048
            com.ibm.icu.impl.coll.CollationIterator$SkippedState r0 = r11.skipped
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0048
            com.ibm.icu.impl.coll.CollationIterator$SkippedState r0 = r11.skipped
            r0.saveTrieState(r8)
        L_0x0048:
            r7 = 1
            goto L_0x0088
        L_0x004a:
            com.ibm.icu.util.BytesTrie$Result r0 = com.ibm.icu.util.BytesTrie.Result.NO_MATCH
            if (r9 == r0) goto L_0x0055
            int r0 = r11.nextSkippedCodePoint()
            r10 = r0
            if (r0 >= 0) goto L_0x0084
        L_0x0055:
            r0 = r13 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0092
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x005f
            if (r7 >= r6) goto L_0x0092
        L_0x005f:
            r0 = 1
            if (r7 <= r0) goto L_0x006d
            r11.backwardNumSkipped(r7)
            int r17 = r11.nextSkippedCodePoint()
            int r0 = r7 + -1
            int r6 = r6 - r0
            r7 = 1
        L_0x006d:
            r0 = r17
            int r0 = r12.getFCD16(r0)
            r1 = 255(0xff, float:3.57E-43)
            if (r0 <= r1) goto L_0x0092
            r0 = r11
            r1 = r12
            r2 = r8
            r3 = r16
            r4 = r6
            r5 = r17
            int r0 = r0.nextCE32FromDiscontiguousContraction(r1, r2, r3, r4, r5)
            return r0
        L_0x0084:
            r17 = r10
            int r7 = r7 + 1
        L_0x0088:
            int r6 = r6 + 1
            r0 = r17
            com.ibm.icu.util.BytesTrie$Result r9 = r8.nextForCodePoint(r0)
            goto L_0x001e
        L_0x0092:
            r11.backwardNumSkipped(r7)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.CollationIterator.nextCE32FromContraction(com.ibm.icu.impl.coll.CollationData, int, java.lang.CharSequence, int, int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bb A[EDGE_INSN: B:57:0x00bb->B:42:0x00bb ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int nextCE32FromDiscontiguousContraction(com.ibm.icu.impl.coll.CollationData r7, com.ibm.icu.util.CharsTrie r8, int r9, int r10, int r11) {
        /*
        // Method dump skipped, instructions count: 258
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.CollationIterator.nextCE32FromDiscontiguousContraction(com.ibm.icu.impl.coll.CollationData, com.ibm.icu.util.CharsTrie, int, int, int):int");
    }

    private final void appendNumericCEs(int i, boolean z) {
        int nextCodePoint;
        StringBuilder sb = new StringBuilder();
        if (z) {
            while (true) {
                sb.append(Collation.digitFromCE32(i));
                if (this.numCpFwd == 0 || (nextCodePoint = nextCodePoint()) < 0) {
                    break;
                }
                i = this.data.getCE32(nextCodePoint);
                if (i == 192) {
                    i = this.data.base.getCE32(nextCodePoint);
                }
                if (!Collation.hasCE32Tag(i, 10)) {
                    backwardNumCodePoints(1);
                    break;
                } else if (this.numCpFwd > 0) {
                    this.numCpFwd--;
                }
            }
        } else {
            while (true) {
                sb.append(Collation.digitFromCE32(i));
                int previousCodePoint = previousCodePoint();
                if (previousCodePoint < 0) {
                    break;
                }
                i = this.data.getCE32(previousCodePoint);
                if (i == 192) {
                    i = this.data.base.getCE32(previousCodePoint);
                }
                if (!Collation.hasCE32Tag(i, 10)) {
                    forwardNumCodePoints(1);
                    break;
                }
            }
            sb.reverse();
        }
        int i2 = 0;
        while (true) {
            if (i2 >= sb.length() - 1 || sb.charAt(i2) != 0) {
                int length = sb.length() - i2;
                if (length > 254) {
                    length = 254;
                }
                appendNumericSegmentCEs(sb.subSequence(i2, i2 + length));
                i2 += length;
                if (i2 >= sb.length()) {
                    return;
                }
            } else {
                i2++;
            }
        }
    }

    private final void appendNumericSegmentCEs(CharSequence charSequence) {
        int i;
        int i2;
        int length = charSequence.length();
        if (!$assertionsDisabled && (1 > length || length > 254)) {
            throw new AssertionError();
        } else if ($assertionsDisabled || length == 1 || charSequence.charAt(0) != 0) {
            long j = this.data.numericPrimary;
            if (length <= 7) {
                int charAt = charSequence.charAt(0);
                for (int i3 = 1; i3 < length; i3++) {
                    charAt = (charAt * 10) + charSequence.charAt(i3);
                }
                if (charAt < 74) {
                    this.ceBuffer.append(Collation.makeCE(j | ((long) ((charAt + 2) << 16))));
                    return;
                }
                int i4 = charAt - 74;
                if (i4 < 10160) {
                    this.ceBuffer.append(Collation.makeCE(((long) (((i4 / 254) + 76) << 16)) | j | ((long) (((i4 % 254) + 2) << 8))));
                    return;
                }
                int i5 = i4 - 10160;
                if (i5 < 1032256) {
                    int i6 = i5 / 254;
                    this.ceBuffer.append(Collation.makeCE(j | ((long) ((i5 % 254) + 2)) | ((long) (((i6 % 254) + 2) << 8)) | ((long) ((((i6 / 254) % 254) + 116) << 16))));
                    return;
                }
            }
            if ($assertionsDisabled || length >= 7) {
                long j2 = j | ((long) ((((length + 1) / 2) + 128) << 16));
                while (charSequence.charAt(length - 1) == 0 && charSequence.charAt(length - 2) == 0) {
                    length -= 2;
                }
                if ((length & 1) != 0) {
                    i2 = charSequence.charAt(0);
                    i = 1;
                } else {
                    i2 = (charSequence.charAt(0) * '\n') + charSequence.charAt(1);
                    i = 2;
                }
                int i7 = (i2 * 2) + 11;
                int i8 = 8;
                while (i < length) {
                    if (i8 == 0) {
                        this.ceBuffer.append(Collation.makeCE(j2 | ((long) i7)));
                        j2 = j;
                        i8 = 16;
                    } else {
                        j2 |= (long) (i7 << i8);
                        i8 -= 8;
                    }
                    i7 = (((charSequence.charAt(i) * '\n') + charSequence.charAt(i + 1)) * 2) + 11;
                    i += 2;
                }
                this.ceBuffer.append(Collation.makeCE(j2 | ((long) ((i7 - 1) << i8))));
                return;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }
}
