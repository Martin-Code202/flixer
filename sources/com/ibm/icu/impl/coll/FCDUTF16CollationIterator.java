package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Normalizer2Impl;
public final class FCDUTF16CollationIterator extends UTF16CollationIterator {
    static final /* synthetic */ boolean $assertionsDisabled = (!FCDUTF16CollationIterator.class.desiredAssertionStatus());
    private int checkDir;
    private final Normalizer2Impl nfcImpl;
    private StringBuilder normalized;
    private int rawLimit;
    private CharSequence rawSeq;
    private int segmentLimit;
    private int segmentStart;

    public FCDUTF16CollationIterator(CollationData collationData) {
        super(collationData);
        this.nfcImpl = collationData.nfcImpl;
    }

    public FCDUTF16CollationIterator(CollationData collationData, boolean z, CharSequence charSequence, int i) {
        super(collationData, z, charSequence, i);
        this.rawSeq = charSequence;
        this.segmentStart = i;
        this.rawLimit = charSequence.length();
        this.nfcImpl = collationData.nfcImpl;
        this.checkDir = 1;
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public boolean equals(Object obj) {
        if (!(obj instanceof CollationIterator) || !equals(obj) || !(obj instanceof FCDUTF16CollationIterator)) {
            return false;
        }
        FCDUTF16CollationIterator fCDUTF16CollationIterator = (FCDUTF16CollationIterator) obj;
        if (this.checkDir != fCDUTF16CollationIterator.checkDir) {
            return false;
        }
        if (this.checkDir == 0) {
            if ((this.seq == this.rawSeq) != (fCDUTF16CollationIterator.seq == fCDUTF16CollationIterator.rawSeq)) {
                return false;
            }
        }
        return (this.checkDir != 0 || this.seq == this.rawSeq) ? this.pos + 0 == fCDUTF16CollationIterator.pos + 0 : this.segmentStart + 0 == fCDUTF16CollationIterator.segmentStart + 0 && this.pos - this.start == fCDUTF16CollationIterator.pos - fCDUTF16CollationIterator.start;
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public int hashCode() {
        if ($assertionsDisabled) {
            return 42;
        }
        throw new AssertionError("hashCode not designed");
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public int getOffset() {
        if (this.checkDir != 0 || this.seq == this.rawSeq) {
            return this.pos + 0;
        }
        if (this.pos == this.start) {
            return this.segmentStart + 0;
        }
        return this.segmentLimit + 0;
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator
    public void setText(boolean z, CharSequence charSequence, int i) {
        super.setText(z, charSequence, i);
        this.rawSeq = charSequence;
        this.segmentStart = i;
        int length = charSequence.length();
        this.limit = length;
        this.rawLimit = length;
        this.checkDir = 1;
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public int nextCodePoint() {
        char charAt;
        while (true) {
            if (this.checkDir <= 0) {
                if (this.checkDir == 0 && this.pos != this.limit) {
                    CharSequence charSequence = this.seq;
                    int i = this.pos;
                    this.pos = i + 1;
                    charAt = charSequence.charAt(i);
                    break;
                }
                switchToForward();
            } else if (this.pos == this.limit) {
                return -1;
            } else {
                CharSequence charSequence2 = this.seq;
                int i2 = this.pos;
                this.pos = i2 + 1;
                charAt = charSequence2.charAt(i2);
                if (CollationFCD.hasTccc(charAt) && (CollationFCD.maybeTibetanCompositeVowel(charAt) || (this.pos != this.limit && CollationFCD.hasLccc(this.seq.charAt(this.pos))))) {
                    this.pos--;
                    nextSegment();
                    CharSequence charSequence3 = this.seq;
                    int i3 = this.pos;
                    this.pos = i3 + 1;
                    charAt = charSequence3.charAt(i3);
                }
            }
        }
        if (Character.isHighSurrogate(charAt) && this.pos != this.limit) {
            char charAt2 = this.seq.charAt(this.pos);
            if (Character.isLowSurrogate(charAt2)) {
                this.pos++;
                return Character.toCodePoint(charAt, charAt2);
            }
        }
        return charAt;
    }

    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public int previousCodePoint() {
        char charAt;
        while (true) {
            if (this.checkDir >= 0) {
                if (this.checkDir == 0 && this.pos != this.start) {
                    CharSequence charSequence = this.seq;
                    int i = this.pos - 1;
                    this.pos = i;
                    charAt = charSequence.charAt(i);
                    break;
                }
                switchToBackward();
            } else if (this.pos == this.start) {
                return -1;
            } else {
                CharSequence charSequence2 = this.seq;
                int i2 = this.pos - 1;
                this.pos = i2;
                charAt = charSequence2.charAt(i2);
                if (CollationFCD.hasLccc(charAt) && (CollationFCD.maybeTibetanCompositeVowel(charAt) || (this.pos != this.start && CollationFCD.hasTccc(this.seq.charAt(this.pos - 1))))) {
                    this.pos++;
                    previousSegment();
                    CharSequence charSequence3 = this.seq;
                    int i3 = this.pos - 1;
                    this.pos = i3;
                    charAt = charSequence3.charAt(i3);
                }
            }
        }
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
    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public long handleNextCE32() {
        char charAt;
        while (true) {
            if (this.checkDir <= 0) {
                if (this.checkDir == 0 && this.pos != this.limit) {
                    CharSequence charSequence = this.seq;
                    int i = this.pos;
                    this.pos = i + 1;
                    charAt = charSequence.charAt(i);
                    break;
                }
                switchToForward();
            } else if (this.pos == this.limit) {
                return -4294967104L;
            } else {
                CharSequence charSequence2 = this.seq;
                int i2 = this.pos;
                this.pos = i2 + 1;
                charAt = charSequence2.charAt(i2);
                if (CollationFCD.hasTccc(charAt) && (CollationFCD.maybeTibetanCompositeVowel(charAt) || (this.pos != this.limit && CollationFCD.hasLccc(this.seq.charAt(this.pos))))) {
                    this.pos--;
                    nextSegment();
                    CharSequence charSequence3 = this.seq;
                    int i3 = this.pos;
                    this.pos = i3 + 1;
                    charAt = charSequence3.charAt(i3);
                }
            }
        }
        return makeCodePointAndCE32Pair(charAt, this.trie.getFromU16SingleLead(charAt));
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public void forwardNumCodePoints(int i) {
        while (i > 0 && nextCodePoint() >= 0) {
            i--;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.coll.UTF16CollationIterator, com.ibm.icu.impl.coll.CollationIterator
    public void backwardNumCodePoints(int i) {
        while (i > 0 && previousCodePoint() >= 0) {
            i--;
        }
    }

    private void switchToForward() {
        if (!$assertionsDisabled && ((this.checkDir >= 0 || this.seq != this.rawSeq) && (this.checkDir != 0 || this.pos != this.limit))) {
            throw new AssertionError();
        } else if (this.checkDir < 0) {
            int i = this.pos;
            this.segmentStart = i;
            this.start = i;
            if (this.pos == this.segmentLimit) {
                this.limit = this.rawLimit;
                this.checkDir = 1;
                return;
            }
            this.checkDir = 0;
        } else {
            if (this.seq != this.rawSeq) {
                this.seq = this.rawSeq;
                int i2 = this.segmentLimit;
                this.segmentStart = i2;
                this.start = i2;
                this.pos = i2;
            }
            this.limit = this.rawLimit;
            this.checkDir = 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r2 != r8.rawLimit) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        r5 = java.lang.Character.codePointAt(r8.seq, r2);
        r2 = r2 + java.lang.Character.charCount(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        if (r8.nfcImpl.getFCD16(r5) > 255) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0061, code lost:
        normalize(r8.pos, r2);
        r8.pos = r8.start;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void nextSegment() {
        /*
            r8 = this;
            boolean r0 = com.ibm.icu.impl.coll.FCDUTF16CollationIterator.$assertionsDisabled
            if (r0 != 0) goto L_0x001a
            int r0 = r8.checkDir
            if (r0 <= 0) goto L_0x0014
            java.lang.CharSequence r0 = r8.seq
            java.lang.CharSequence r1 = r8.rawSeq
            if (r0 != r1) goto L_0x0014
            int r0 = r8.pos
            int r1 = r8.limit
            if (r0 != r1) goto L_0x001a
        L_0x0014:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x001a:
            int r2 = r8.pos
            r3 = 0
        L_0x001d:
            r4 = r2
            java.lang.CharSequence r0 = r8.seq
            int r5 = java.lang.Character.codePointAt(r0, r2)
            int r0 = java.lang.Character.charCount(r5)
            int r2 = r2 + r0
            com.ibm.icu.impl.Normalizer2Impl r0 = r8.nfcImpl
            int r6 = r0.getFCD16(r5)
            int r7 = r6 >> 8
            if (r7 != 0) goto L_0x003c
            int r0 = r8.pos
            if (r4 == r0) goto L_0x003c
            r8.segmentLimit = r4
            r8.limit = r4
            goto L_0x007a
        L_0x003c:
            if (r7 == 0) goto L_0x006b
            if (r3 > r7) goto L_0x0046
            boolean r0 = com.ibm.icu.impl.coll.CollationFCD.isFCD16OfTibetanCompositeVowel(r6)
            if (r0 == 0) goto L_0x006b
        L_0x0046:
            r4 = r2
            int r0 = r8.rawLimit
            if (r2 != r0) goto L_0x004c
            goto L_0x0061
        L_0x004c:
            java.lang.CharSequence r0 = r8.seq
            int r5 = java.lang.Character.codePointAt(r0, r2)
            int r0 = java.lang.Character.charCount(r5)
            int r2 = r2 + r0
            com.ibm.icu.impl.Normalizer2Impl r0 = r8.nfcImpl
            int r0 = r0.getFCD16(r5)
            r1 = 255(0xff, float:3.57E-43)
            if (r0 > r1) goto L_0x0046
        L_0x0061:
            int r0 = r8.pos
            r8.normalize(r0, r4)
            int r0 = r8.start
            r8.pos = r0
            goto L_0x007a
        L_0x006b:
            r3 = r6 & 255(0xff, float:3.57E-43)
            int r0 = r8.rawLimit
            if (r2 == r0) goto L_0x0073
            if (r3 != 0) goto L_0x0078
        L_0x0073:
            r8.segmentLimit = r2
            r8.limit = r2
            goto L_0x007a
        L_0x0078:
            goto L_0x001d
        L_0x007a:
            boolean r0 = com.ibm.icu.impl.coll.FCDUTF16CollationIterator.$assertionsDisabled
            if (r0 != 0) goto L_0x008a
            int r0 = r8.pos
            int r1 = r8.limit
            if (r0 != r1) goto L_0x008a
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x008a:
            r0 = 0
            r8.checkDir = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.FCDUTF16CollationIterator.nextSegment():void");
    }

    private void switchToBackward() {
        if (!$assertionsDisabled && ((this.checkDir <= 0 || this.seq != this.rawSeq) && (this.checkDir != 0 || this.pos != this.start))) {
            throw new AssertionError();
        } else if (this.checkDir > 0) {
            int i = this.pos;
            this.segmentLimit = i;
            this.limit = i;
            if (this.pos == this.segmentStart) {
                this.start = 0;
                this.checkDir = -1;
                return;
            }
            this.checkDir = 0;
        } else {
            if (this.seq != this.rawSeq) {
                this.seq = this.rawSeq;
                int i2 = this.segmentStart;
                this.segmentLimit = i2;
                this.limit = i2;
                this.pos = i2;
            }
            this.start = 0;
            this.checkDir = -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0074, code lost:
        r8.segmentStart = r2;
        r8.start = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void previousSegment() {
        /*
            r8 = this;
            boolean r0 = com.ibm.icu.impl.coll.FCDUTF16CollationIterator.$assertionsDisabled
            if (r0 != 0) goto L_0x001a
            int r0 = r8.checkDir
            if (r0 >= 0) goto L_0x0014
            java.lang.CharSequence r0 = r8.seq
            java.lang.CharSequence r1 = r8.rawSeq
            if (r0 != r1) goto L_0x0014
            int r0 = r8.pos
            int r1 = r8.start
            if (r0 != r1) goto L_0x001a
        L_0x0014:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x001a:
            int r2 = r8.pos
            r3 = 0
        L_0x001d:
            r4 = r2
            java.lang.CharSequence r0 = r8.seq
            int r5 = java.lang.Character.codePointBefore(r0, r2)
            int r0 = java.lang.Character.charCount(r5)
            int r2 = r2 - r0
            com.ibm.icu.impl.Normalizer2Impl r0 = r8.nfcImpl
            int r6 = r0.getFCD16(r5)
            r7 = r6 & 255(0xff, float:3.57E-43)
            if (r7 != 0) goto L_0x003c
            int r0 = r8.pos
            if (r4 == r0) goto L_0x003c
            r8.segmentStart = r4
            r8.start = r4
            goto L_0x007b
        L_0x003c:
            if (r7 == 0) goto L_0x006e
            if (r3 == 0) goto L_0x0042
            if (r7 > r3) goto L_0x0048
        L_0x0042:
            boolean r0 = com.ibm.icu.impl.coll.CollationFCD.isFCD16OfTibetanCompositeVowel(r6)
            if (r0 == 0) goto L_0x006e
        L_0x0048:
            r4 = r2
            r0 = 255(0xff, float:3.57E-43)
            if (r6 <= r0) goto L_0x0064
            if (r2 != 0) goto L_0x0050
            goto L_0x0064
        L_0x0050:
            java.lang.CharSequence r0 = r8.seq
            int r5 = java.lang.Character.codePointBefore(r0, r2)
            int r0 = java.lang.Character.charCount(r5)
            int r2 = r2 - r0
            com.ibm.icu.impl.Normalizer2Impl r0 = r8.nfcImpl
            int r0 = r0.getFCD16(r5)
            r6 = r0
            if (r0 != 0) goto L_0x0048
        L_0x0064:
            int r0 = r8.pos
            r8.normalize(r4, r0)
            int r0 = r8.limit
            r8.pos = r0
            goto L_0x007b
        L_0x006e:
            int r3 = r6 >> 8
            if (r2 == 0) goto L_0x0074
            if (r3 != 0) goto L_0x0079
        L_0x0074:
            r8.segmentStart = r2
            r8.start = r2
            goto L_0x007b
        L_0x0079:
            goto L_0x001d
        L_0x007b:
            boolean r0 = com.ibm.icu.impl.coll.FCDUTF16CollationIterator.$assertionsDisabled
            if (r0 != 0) goto L_0x008b
            int r0 = r8.pos
            int r1 = r8.start
            if (r0 != r1) goto L_0x008b
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x008b:
            r0 = 0
            r8.checkDir = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.FCDUTF16CollationIterator.previousSegment():void");
    }

    private void normalize(int i, int i2) {
        if (this.normalized == null) {
            this.normalized = new StringBuilder();
        }
        this.nfcImpl.decompose(this.rawSeq, i, i2, this.normalized, i2 - i);
        this.segmentStart = i;
        this.segmentLimit = i2;
        this.seq = this.normalized;
        this.start = 0;
        this.limit = this.start + this.normalized.length();
    }
}
