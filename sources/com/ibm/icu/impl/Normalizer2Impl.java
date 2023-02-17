package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.Trie2;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ICUUncheckedIOException;
import com.ibm.icu.util.VersionInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
public final class Normalizer2Impl {
    private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable();
    private static final Trie2.ValueMapper segmentStarterMapper = new Trie2.ValueMapper() { // from class: com.ibm.icu.impl.Normalizer2Impl.1
        @Override // com.ibm.icu.impl.Trie2.ValueMapper
        public int map(int i) {
            return Integer.MIN_VALUE & i;
        }
    };
    private Trie2_32 canonIterData;
    private ArrayList<UnicodeSet> canonStartSets;
    private VersionInfo dataVersion;
    private String extraData;
    private int limitNoNo;
    private String maybeYesCompositions;
    private int minCompNoMaybeCP;
    private int minDecompNoCP;
    private int minMaybeYes;
    private int minNoNo;
    private int minYesNo;
    private int minYesNoMappingsOnly;
    private Trie2_16 normTrie;
    private byte[] smallFCD;
    private int[] tccc180;

    public static final class Hangul {
        public static boolean isHangulWithoutJamoT(char c) {
            char c2 = (char) (c - 44032);
            return c2 < 11172 && c2 % 28 == 0;
        }

        public static int decompose(int i, Appendable appendable) {
            int i2 = i - 44032;
            try {
                int i3 = i2 % 28;
                int i4 = i2 / 28;
                appendable.append((char) ((i4 / 21) + 4352));
                appendable.append((char) ((i4 % 21) + 4449));
                if (i3 == 0) {
                    return 2;
                }
                appendable.append((char) (i3 + 4519));
                return 3;
            } catch (IOException e) {
                throw new ICUUncheckedIOException(e);
            }
        }
    }

    public static final class ReorderingBuffer implements Appendable {
        private final Appendable app;
        private final boolean appIsStringBuilder;
        private int codePointLimit;
        private int codePointStart;
        private final Normalizer2Impl impl;
        private int lastCC;
        private int reorderStart;
        private final StringBuilder str;

        public ReorderingBuffer(Normalizer2Impl normalizer2Impl, Appendable appendable, int i) {
            this.impl = normalizer2Impl;
            this.app = appendable;
            if (this.app instanceof StringBuilder) {
                this.appIsStringBuilder = true;
                this.str = (StringBuilder) appendable;
                this.str.ensureCapacity(i);
                this.reorderStart = 0;
                if (this.str.length() == 0) {
                    this.lastCC = 0;
                    return;
                }
                setIterator();
                this.lastCC = previousCC();
                if (this.lastCC > 1) {
                    do {
                    } while (previousCC() > 1);
                }
                this.reorderStart = this.codePointLimit;
                return;
            }
            this.appIsStringBuilder = false;
            this.str = new StringBuilder();
            this.reorderStart = 0;
            this.lastCC = 0;
        }

        public boolean isEmpty() {
            return this.str.length() == 0;
        }

        public int length() {
            return this.str.length();
        }

        public int getLastCC() {
            return this.lastCC;
        }

        public StringBuilder getStringBuilder() {
            return this.str;
        }

        public boolean equals(CharSequence charSequence, int i, int i2) {
            return UTF16Plus.equal(this.str, 0, this.str.length(), charSequence, i, i2);
        }

        public void setLastChar(char c) {
            this.str.setCharAt(this.str.length() - 1, c);
        }

        public void append(int i, int i2) {
            if (this.lastCC <= i2 || i2 == 0) {
                this.str.appendCodePoint(i);
                this.lastCC = i2;
                if (i2 <= 1) {
                    this.reorderStart = this.str.length();
                    return;
                }
                return;
            }
            insert(i, i2);
        }

        public void append(CharSequence charSequence, int i, int i2, int i3, int i4) {
            int i5;
            if (i != i2) {
                if (this.lastCC <= i3 || i3 == 0) {
                    if (i4 <= 1) {
                        this.reorderStart = this.str.length() + (i2 - i);
                    } else if (i3 <= 1) {
                        this.reorderStart = this.str.length() + 1;
                    }
                    this.str.append(charSequence, i, i2);
                    this.lastCC = i4;
                    return;
                }
                int codePointAt = Character.codePointAt(charSequence, i);
                int charCount = i + Character.charCount(codePointAt);
                insert(codePointAt, i3);
                while (charCount < i2) {
                    int codePointAt2 = Character.codePointAt(charSequence, charCount);
                    charCount += Character.charCount(codePointAt2);
                    if (charCount < i2) {
                        i5 = Normalizer2Impl.getCCFromYesOrMaybe(this.impl.getNorm16(codePointAt2));
                    } else {
                        i5 = i4;
                    }
                    append(codePointAt2, i5);
                }
            }
        }

        @Override // java.lang.Appendable
        public ReorderingBuffer append(char c) {
            this.str.append(c);
            this.lastCC = 0;
            this.reorderStart = this.str.length();
            return this;
        }

        public void appendZeroCC(int i) {
            this.str.appendCodePoint(i);
            this.lastCC = 0;
            this.reorderStart = this.str.length();
        }

        @Override // java.lang.Appendable
        public ReorderingBuffer append(CharSequence charSequence) {
            if (charSequence.length() != 0) {
                this.str.append(charSequence);
                this.lastCC = 0;
                this.reorderStart = this.str.length();
            }
            return this;
        }

        @Override // java.lang.Appendable
        public ReorderingBuffer append(CharSequence charSequence, int i, int i2) {
            if (i != i2) {
                this.str.append(charSequence, i, i2);
                this.lastCC = 0;
                this.reorderStart = this.str.length();
            }
            return this;
        }

        public void flush() {
            if (this.appIsStringBuilder) {
                this.reorderStart = this.str.length();
            } else {
                try {
                    this.app.append(this.str);
                    this.str.setLength(0);
                    this.reorderStart = 0;
                } catch (IOException e) {
                    throw new ICUUncheckedIOException(e);
                }
            }
            this.lastCC = 0;
        }

        public ReorderingBuffer flushAndAppendZeroCC(CharSequence charSequence, int i, int i2) {
            if (this.appIsStringBuilder) {
                this.str.append(charSequence, i, i2);
                this.reorderStart = this.str.length();
            } else {
                try {
                    this.app.append(this.str).append(charSequence, i, i2);
                    this.str.setLength(0);
                    this.reorderStart = 0;
                } catch (IOException e) {
                    throw new ICUUncheckedIOException(e);
                }
            }
            this.lastCC = 0;
            return this;
        }

        public void remove() {
            this.str.setLength(0);
            this.lastCC = 0;
            this.reorderStart = 0;
        }

        public void removeSuffix(int i) {
            int length = this.str.length();
            this.str.delete(length - i, length);
            this.lastCC = 0;
            this.reorderStart = this.str.length();
        }

        private void insert(int i, int i2) {
            setIterator();
            skipPrevious();
            do {
            } while (previousCC() > i2);
            if (i <= 65535) {
                this.str.insert(this.codePointLimit, (char) i);
                if (i2 <= 1) {
                    this.reorderStart = this.codePointLimit + 1;
                    return;
                }
                return;
            }
            this.str.insert(this.codePointLimit, Character.toChars(i));
            if (i2 <= 1) {
                this.reorderStart = this.codePointLimit + 2;
            }
        }

        private void setIterator() {
            this.codePointStart = this.str.length();
        }

        private void skipPrevious() {
            this.codePointLimit = this.codePointStart;
            this.codePointStart = this.str.offsetByCodePoints(this.codePointStart, -1);
        }

        private int previousCC() {
            this.codePointLimit = this.codePointStart;
            if (this.reorderStart >= this.codePointStart) {
                return 0;
            }
            int codePointBefore = this.str.codePointBefore(this.codePointStart);
            this.codePointStart -= Character.charCount(codePointBefore);
            if (codePointBefore < 768) {
                return 0;
            }
            return Normalizer2Impl.getCCFromYesOrMaybe(this.impl.getNorm16(codePointBefore));
        }
    }

    public static final class UTF16Plus {
        public static boolean isSurrogateLead(int i) {
            return (i & 1024) == 0;
        }

        public static boolean equal(CharSequence charSequence, CharSequence charSequence2) {
            if (charSequence == charSequence2) {
                return true;
            }
            int length = charSequence.length();
            if (length != charSequence2.length()) {
                return false;
            }
            for (int i = 0; i < length; i++) {
                if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        public static boolean equal(CharSequence charSequence, int i, int i2, CharSequence charSequence2, int i3, int i4) {
            if (i2 - i != i4 - i3) {
                return false;
            }
            if (charSequence == charSequence2 && i == i3) {
                return true;
            }
            while (i < i2) {
                i++;
                i3++;
                if (charSequence.charAt(i) != charSequence2.charAt(i3)) {
                    return false;
                }
            }
            return true;
        }
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

    public Normalizer2Impl load(ByteBuffer byteBuffer) {
        try {
            this.dataVersion = ICUBinary.readHeaderAndDataVersion(byteBuffer, 1316121906, IS_ACCEPTABLE);
            int i = byteBuffer.getInt() / 4;
            if (i <= 13) {
                throw new ICUUncheckedIOException("Normalizer2 data: not enough indexes");
            }
            int[] iArr = new int[i];
            iArr[0] = i * 4;
            for (int i2 = 1; i2 < i; i2++) {
                iArr[i2] = byteBuffer.getInt();
            }
            this.minDecompNoCP = iArr[8];
            this.minCompNoMaybeCP = iArr[9];
            this.minYesNo = iArr[10];
            this.minYesNoMappingsOnly = iArr[14];
            this.minNoNo = iArr[11];
            this.limitNoNo = iArr[12];
            this.minMaybeYes = iArr[13];
            int i3 = iArr[0];
            int i4 = iArr[1];
            this.normTrie = Trie2_16.createFromSerialized(byteBuffer);
            int serializedLength = this.normTrie.getSerializedLength();
            if (serializedLength > i4 - i3) {
                throw new ICUUncheckedIOException("Normalizer2 data: not enough bytes for normTrie");
            }
            ICUBinary.skipBytes(byteBuffer, (i4 - i3) - serializedLength);
            int i5 = (iArr[2] - i4) / 2;
            if (i5 != 0) {
                this.maybeYesCompositions = ICUBinary.getString(byteBuffer, i5, 0);
                this.extraData = this.maybeYesCompositions.substring(65024 - this.minMaybeYes);
            }
            this.smallFCD = new byte[256];
            byteBuffer.get(this.smallFCD);
            this.tccc180 = new int[384];
            int i6 = 0;
            int i7 = 0;
            while (i7 < 384) {
                int i8 = i6;
                if ((i7 & 255) == 0) {
                    i8 = this.smallFCD[i7 >> 8];
                }
                if ((i8 & 1) != 0) {
                    int i9 = 0;
                    while (i9 < 32) {
                        this.tccc180[i7] = getFCD16FromNormData(i7) & 255;
                        i9++;
                        i7++;
                    }
                } else {
                    i7 += 32;
                }
                i6 = i8 >> 1;
            }
            return this;
        } catch (IOException e) {
            throw new ICUUncheckedIOException(e);
        }
    }

    public Normalizer2Impl load(String str) {
        return load(ICUBinary.getRequiredData(str));
    }

    private void enumLcccRange(int i, int i2, int i3, UnicodeSet unicodeSet) {
        if (isAlgorithmicNoNo(i3)) {
            do {
                if (getFCD16(i) > 255) {
                    unicodeSet.add(i);
                }
                i++;
            } while (i <= i2);
        } else if (getFCD16(i) > 255) {
            unicodeSet.add(i, i2);
        }
    }

    private void enumNorm16PropertyStartsRange(int i, int i2, int i3, UnicodeSet unicodeSet) {
        unicodeSet.add(i);
        if (i != i2 && isAlgorithmicNoNo(i3)) {
            int fcd16 = getFCD16(i);
            while (true) {
                i++;
                if (i <= i2) {
                    int fcd162 = getFCD16(i);
                    if (fcd162 != fcd16) {
                        unicodeSet.add(i);
                        fcd16 = fcd162;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void addLcccChars(UnicodeSet unicodeSet) {
        Iterator<Trie2.Range> it = this.normTrie.iterator();
        while (it.hasNext()) {
            Trie2.Range next = it.next();
            if (!next.leadSurrogate) {
                enumLcccRange(next.startCodePoint, next.endCodePoint, next.value, unicodeSet);
            } else {
                return;
            }
        }
    }

    public void addPropertyStarts(UnicodeSet unicodeSet) {
        Iterator<Trie2.Range> it = this.normTrie.iterator();
        while (it.hasNext()) {
            Trie2.Range next = it.next();
            if (next.leadSurrogate) {
                break;
            }
            enumNorm16PropertyStartsRange(next.startCodePoint, next.endCodePoint, next.value, unicodeSet);
        }
        for (int i = 44032; i < 55204; i += 28) {
            unicodeSet.add(i);
            unicodeSet.add(i + 1);
        }
        unicodeSet.add(55204);
    }

    public void addCanonIterPropertyStarts(UnicodeSet unicodeSet) {
        ensureCanonIterData();
        Iterator<Trie2.Range> it = this.canonIterData.iterator(segmentStarterMapper);
        while (it.hasNext()) {
            Trie2.Range next = it.next();
            if (!next.leadSurrogate) {
                unicodeSet.add(next.startCodePoint);
            } else {
                return;
            }
        }
    }

    public synchronized Normalizer2Impl ensureCanonIterData() {
        if (this.canonIterData == null) {
            Trie2Writable trie2Writable = new Trie2Writable(0, 0);
            this.canonStartSets = new ArrayList<>();
            Iterator<Trie2.Range> it = this.normTrie.iterator();
            while (it.hasNext()) {
                Trie2.Range next = it.next();
                if (next.leadSurrogate) {
                    break;
                }
                int i = next.value;
                if (i != 0) {
                    if (this.minYesNo > i || i >= this.minNoNo) {
                        for (int i2 = next.startCodePoint; i2 <= next.endCodePoint; i2++) {
                            int i3 = trie2Writable.get(i2);
                            int i4 = i3;
                            if (i >= this.minMaybeYes) {
                                i4 |= Integer.MIN_VALUE;
                                if (i < 65024) {
                                    i4 |= 1073741824;
                                }
                            } else if (i < this.minYesNo) {
                                i4 |= 1073741824;
                            } else {
                                int i5 = i2;
                                int i6 = i;
                                while (this.limitNoNo <= i6 && i6 < this.minMaybeYes) {
                                    i5 = mapAlgorithmic(i5, i6);
                                    i6 = getNorm16(i5);
                                }
                                if (this.minYesNo > i6 || i6 >= this.limitNoNo) {
                                    addToStartSet(trie2Writable, i2, i5);
                                } else {
                                    char charAt = this.extraData.charAt(i6);
                                    int i7 = charAt & 31;
                                    if (!((charAt & 128) == 0 || i2 != i5 || (this.extraData.charAt(i6 - 1) & 255) == 0)) {
                                        i4 |= Integer.MIN_VALUE;
                                    }
                                    if (i7 != 0) {
                                        int i8 = i6 + 1;
                                        int i9 = i8 + i7;
                                        int codePointAt = this.extraData.codePointAt(i8);
                                        addToStartSet(trie2Writable, i2, codePointAt);
                                        if (i8 >= this.minNoNo) {
                                            while (true) {
                                                int charCount = Character.charCount(codePointAt) + i8;
                                                i8 = charCount;
                                                if (charCount >= i9) {
                                                    break;
                                                }
                                                codePointAt = this.extraData.codePointAt(i8);
                                                int i10 = trie2Writable.get(codePointAt);
                                                if ((Integer.MIN_VALUE & i10) == 0) {
                                                    trie2Writable.set(codePointAt, Integer.MIN_VALUE | i10);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (i4 != i3) {
                                trie2Writable.set(i2, i4);
                            }
                        }
                    }
                }
            }
            this.canonIterData = trie2Writable.toTrie2_32();
        }
        return this;
    }

    public int getNorm16(int i) {
        return this.normTrie.get(i);
    }

    public int getCompQuickCheck(int i) {
        if (i < this.minNoNo || 65281 <= i) {
            return 1;
        }
        if (this.minMaybeYes <= i) {
            return 2;
        }
        return 0;
    }

    public boolean isAlgorithmicNoNo(int i) {
        return this.limitNoNo <= i && i < this.minMaybeYes;
    }

    public boolean isCompNo(int i) {
        return this.minNoNo <= i && i < this.minMaybeYes;
    }

    public boolean isDecompYes(int i) {
        return i < this.minYesNo || this.minMaybeYes <= i;
    }

    public int getCC(int i) {
        if (i >= 65024) {
            return i & 255;
        }
        if (i < this.minNoNo || this.limitNoNo <= i) {
            return 0;
        }
        return getCCFromNoNo(i);
    }

    public static int getCCFromYesOrMaybe(int i) {
        if (i >= 65024) {
            return i & 255;
        }
        return 0;
    }

    public int getFCD16(int i) {
        if (i < 0) {
            return 0;
        }
        if (i < 384) {
            return this.tccc180[i];
        }
        if (i > 65535 || singleLeadMightHaveNonZeroFCD16(i)) {
            return getFCD16FromNormData(i);
        }
        return 0;
    }

    public boolean singleLeadMightHaveNonZeroFCD16(int i) {
        byte b = this.smallFCD[i >> 8];
        return (b == 0 || ((b >> ((i >> 5) & 7)) & 1) == 0) ? false : true;
    }

    public int getFCD16FromNormData(int i) {
        while (true) {
            int norm16 = getNorm16(i);
            if (norm16 <= this.minYesNo) {
                return 0;
            }
            if (norm16 >= 65024) {
                int i2 = norm16 & 255;
                return (i2 << 8) | i2;
            } else if (norm16 >= this.minMaybeYes) {
                return 0;
            } else {
                if (isDecompNoAlgorithmic(norm16)) {
                    i = mapAlgorithmic(i, norm16);
                } else {
                    char charAt = this.extraData.charAt(norm16);
                    if ((charAt & 31) == 0) {
                        return 511;
                    }
                    int i3 = charAt >> '\b';
                    if ((charAt & 128) != 0) {
                        return i3 | (this.extraData.charAt(norm16 - 1) & 65280);
                    }
                    return i3;
                }
            }
        }
    }

    public String getDecomposition(int i) {
        int i2 = -1;
        while (i >= this.minDecompNoCP) {
            int norm16 = getNorm16(i);
            if (isDecompYes(norm16)) {
                break;
            } else if (isHangul(norm16)) {
                StringBuilder sb = new StringBuilder();
                Hangul.decompose(i, sb);
                return sb.toString();
            } else if (isDecompNoAlgorithmic(norm16)) {
                i2 = mapAlgorithmic(i, norm16);
                i = i2;
            } else {
                int i3 = norm16 + 1;
                return this.extraData.substring(i3, i3 + (this.extraData.charAt(norm16) & 31));
            }
        }
        if (i2 < 0) {
            return null;
        }
        return UTF16.valueOf(i2);
    }

    public boolean isCanonSegmentStarter(int i) {
        return this.canonIterData.get(i) >= 0;
    }

    public void decompose(CharSequence charSequence, int i, int i2, StringBuilder sb, int i3) {
        if (i3 < 0) {
            i3 = i2 - i;
        }
        sb.setLength(0);
        decompose(charSequence, i, i2, new ReorderingBuffer(this, sb, i3));
    }

    public int decompose(CharSequence charSequence, int i, int i2, ReorderingBuffer reorderingBuffer) {
        int cCFromYesOrMaybe;
        int i3 = this.minDecompNoCP;
        int i4 = 0;
        int i5 = 0;
        int i6 = i;
        int i7 = 0;
        while (true) {
            while (i != i2) {
                char charAt = charSequence.charAt(i);
                i4 = charAt;
                if (charAt >= i3) {
                    int fromU16SingleLead = this.normTrie.getFromU16SingleLead((char) i4);
                    i5 = fromU16SingleLead;
                    if (!isMostDecompYesAndZeroCC(fromU16SingleLead)) {
                        if (!UTF16.isSurrogate((char) i4)) {
                            break;
                        }
                        if (UTF16Plus.isSurrogateLead(i4)) {
                            if (i + 1 != i2) {
                                char charAt2 = charSequence.charAt(i + 1);
                                if (Character.isLowSurrogate(charAt2)) {
                                    i4 = Character.toCodePoint((char) i4, charAt2);
                                }
                            }
                        } else if (i < i) {
                            char charAt3 = charSequence.charAt(i - 1);
                            if (Character.isHighSurrogate(charAt3)) {
                                i--;
                                i4 = Character.toCodePoint(charAt3, (char) i4);
                            }
                        }
                        int norm16 = getNorm16(i4);
                        i5 = norm16;
                        if (!isMostDecompYesAndZeroCC(norm16)) {
                            break;
                        }
                        i += Character.charCount(i4);
                    }
                }
                i++;
            }
            if (i != i) {
                if (reorderingBuffer != null) {
                    reorderingBuffer.flushAndAppendZeroCC(charSequence, i, i);
                } else {
                    i7 = 0;
                    i6 = i;
                }
            }
            if (i == i2) {
                return i;
            }
            i += Character.charCount(i4);
            if (reorderingBuffer != null) {
                decompose(i4, i5, reorderingBuffer);
            } else if (!isDecompYes(i5) || (i7 > (cCFromYesOrMaybe = getCCFromYesOrMaybe(i5)) && cCFromYesOrMaybe != 0)) {
                break;
            } else {
                i7 = cCFromYesOrMaybe;
                if (cCFromYesOrMaybe <= 1) {
                    i6 = i;
                }
            }
        }
        return i6;
    }

    public void decomposeAndAppend(CharSequence charSequence, boolean z, ReorderingBuffer reorderingBuffer) {
        int length = charSequence.length();
        if (length != 0) {
            if (z) {
                decompose(charSequence, 0, length, reorderingBuffer);
                return;
            }
            int codePointAt = Character.codePointAt(charSequence, 0);
            int i = 0;
            int cc = getCC(getNorm16(codePointAt));
            int i2 = cc;
            int i3 = cc;
            while (i2 != 0) {
                i3 = i2;
                i += Character.charCount(codePointAt);
                if (i >= length) {
                    break;
                }
                codePointAt = Character.codePointAt(charSequence, i);
                i2 = getCC(getNorm16(codePointAt));
            }
            reorderingBuffer.append(charSequence, 0, i, cc, i3);
            reorderingBuffer.append(charSequence, i, length);
        }
    }

    public boolean compose(CharSequence charSequence, int i, int i2, boolean z, boolean z2, ReorderingBuffer reorderingBuffer) {
        char charAt;
        int i3 = this.minCompNoMaybeCP;
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = i;
            while (i != i2) {
                char charAt2 = charSequence.charAt(i);
                i5 = charAt2;
                if (charAt2 >= i3) {
                    int fromU16SingleLead = this.normTrie.getFromU16SingleLead((char) i5);
                    i6 = fromU16SingleLead;
                    if (!isCompYesAndZeroCC(fromU16SingleLead)) {
                        if (!UTF16.isSurrogate((char) i5)) {
                            break;
                        }
                        if (UTF16Plus.isSurrogateLead(i5)) {
                            if (i + 1 != i2) {
                                char charAt3 = charSequence.charAt(i + 1);
                                if (Character.isLowSurrogate(charAt3)) {
                                    i5 = Character.toCodePoint((char) i5, charAt3);
                                }
                            }
                        } else if (i8 < i) {
                            char charAt4 = charSequence.charAt(i - 1);
                            if (Character.isHighSurrogate(charAt4)) {
                                i--;
                                i5 = Character.toCodePoint(charAt4, (char) i5);
                            }
                        }
                        int norm16 = getNorm16(i5);
                        i6 = norm16;
                        if (!isCompYesAndZeroCC(norm16)) {
                            break;
                        }
                        i += Character.charCount(i5);
                    }
                }
                i++;
            }
            if (i != i8) {
                if (i != i2) {
                    i4 = i - 1;
                    if (Character.isLowSurrogate(charSequence.charAt(i4)) && i8 < i4 && Character.isHighSurrogate(charSequence.charAt(i4 - 1))) {
                        i4--;
                    }
                    if (z2) {
                        reorderingBuffer.flushAndAppendZeroCC(charSequence, i8, i4);
                        reorderingBuffer.append(charSequence, i4, i);
                    } else {
                        i7 = 0;
                    }
                    i8 = i;
                } else if (!z2) {
                    return true;
                } else {
                    reorderingBuffer.flushAndAppendZeroCC(charSequence, i8, i);
                    return true;
                }
            } else if (i == i2) {
                return true;
            }
            i += Character.charCount(i5);
            if (isJamoVT(i6) && i4 != i8) {
                char charAt5 = charSequence.charAt(i8 - 1);
                boolean z3 = false;
                if (i5 < 4519) {
                    char c = (char) (charAt5 - 4352);
                    if (c < 19) {
                        if (!z2) {
                            return false;
                        }
                        char c2 = (char) ((((c * 21) + (i5 - 4449)) * 28) + 44032);
                        if (i == i2 || (charAt = (char) (charSequence.charAt(i) - 4519)) >= 28) {
                            z3 = true;
                        } else {
                            i++;
                            i4 = i;
                            reorderingBuffer.setLastChar((char) (c2 + charAt));
                        }
                    }
                } else if (Hangul.isHangulWithoutJamoT(charAt5)) {
                    if (!z2) {
                        return false;
                    }
                    reorderingBuffer.setLastChar((char) ((charAt5 + i5) - 4519));
                    i4 = i;
                }
                if (!z3) {
                    if (z2) {
                        reorderingBuffer.append((char) i5);
                    } else {
                        i7 = 0;
                    }
                }
            }
            if (i6 >= 65281) {
                int i9 = i6 & 255;
                if (z) {
                    if ((z2 ? reorderingBuffer.getLastCC() : i7) == 0 && i4 < i8 && getTrailCCFromCompYesAndZeroCC(charSequence, i4, i8) > i9) {
                        if (!z2) {
                            return false;
                        }
                    }
                }
                if (z2) {
                    reorderingBuffer.append(i5, i9);
                } else if (i7 > i9) {
                    return false;
                } else {
                    i7 = i9;
                }
            } else if (!z2 && !isMaybeOrNonZeroCC(i6)) {
                return false;
            }
            if (hasCompBoundaryBefore(i5, i6)) {
                i4 = i8;
            } else if (z2) {
                reorderingBuffer.removeSuffix(i8 - i4);
            }
            i = findNextCompBoundary(charSequence, i, i2);
            int length = reorderingBuffer.length();
            decomposeShort(charSequence, i4, i, reorderingBuffer);
            recompose(reorderingBuffer, length, z);
            if (!z2) {
                if (!reorderingBuffer.equals(charSequence, i4, i)) {
                    return false;
                }
                reorderingBuffer.remove();
                i7 = 0;
            }
            i4 = i;
        }
    }

    public int composeQuickCheck(CharSequence charSequence, int i, int i2, boolean z, boolean z2) {
        int i3 = 0;
        int i4 = this.minCompNoMaybeCP;
        int i5 = i;
        int i6 = 0;
        while (true) {
            int i7 = i;
            while (i != i2) {
                char charAt = charSequence.charAt(i);
                int i8 = charAt;
                if (charAt >= i4) {
                    int fromU16SingleLead = this.normTrie.getFromU16SingleLead((char) i8);
                    int i9 = fromU16SingleLead;
                    if (!isCompYesAndZeroCC(fromU16SingleLead)) {
                        if (UTF16.isSurrogate((char) i8)) {
                            if (UTF16Plus.isSurrogateLead(i8)) {
                                if (i + 1 != i2) {
                                    char charAt2 = charSequence.charAt(i + 1);
                                    if (Character.isLowSurrogate(charAt2)) {
                                        i8 = Character.toCodePoint((char) i8, charAt2);
                                    }
                                }
                            } else if (i7 < i) {
                                char charAt3 = charSequence.charAt(i - 1);
                                if (Character.isHighSurrogate(charAt3)) {
                                    i--;
                                    i8 = Character.toCodePoint(charAt3, (char) i8);
                                }
                            }
                            int norm16 = getNorm16(i8);
                            i9 = norm16;
                            if (isCompYesAndZeroCC(norm16)) {
                                i += Character.charCount(i8);
                            }
                        }
                        if (i != i7) {
                            i5 = i - 1;
                            if (Character.isLowSurrogate(charSequence.charAt(i5)) && i7 < i5 && Character.isHighSurrogate(charSequence.charAt(i5 - 1))) {
                                i5--;
                            }
                            i6 = 0;
                            i7 = i;
                        }
                        i += Character.charCount(i8);
                        if (!isMaybeOrNonZeroCC(i9)) {
                            break;
                        }
                        int cCFromYesOrMaybe = getCCFromYesOrMaybe(i9);
                        if ((z && cCFromYesOrMaybe != 0 && i6 == 0 && i5 < i7 && getTrailCCFromCompYesAndZeroCC(charSequence, i5, i7) > cCFromYesOrMaybe) || (i6 > cCFromYesOrMaybe && cCFromYesOrMaybe != 0)) {
                            break;
                        }
                        i6 = cCFromYesOrMaybe;
                        if (i9 < 65281) {
                            if (z2) {
                                return i5 << 1;
                            }
                            i3 = 1;
                        }
                    }
                }
                i++;
            }
            return (i << 1) | i3;
        }
        return i5 << 1;
    }

    public void composeAndAppend(CharSequence charSequence, boolean z, boolean z2, ReorderingBuffer reorderingBuffer) {
        int findNextCompBoundary;
        int i = 0;
        int length = charSequence.length();
        if (!reorderingBuffer.isEmpty() && 0 != (findNextCompBoundary = findNextCompBoundary(charSequence, 0, length))) {
            int findPreviousCompBoundary = findPreviousCompBoundary(reorderingBuffer.getStringBuilder(), reorderingBuffer.length());
            StringBuilder sb = new StringBuilder((reorderingBuffer.length() - findPreviousCompBoundary) + findNextCompBoundary + 16);
            sb.append((CharSequence) reorderingBuffer.getStringBuilder(), findPreviousCompBoundary, reorderingBuffer.length());
            reorderingBuffer.removeSuffix(reorderingBuffer.length() - findPreviousCompBoundary);
            sb.append(charSequence, 0, findNextCompBoundary);
            compose(sb, 0, sb.length(), z2, true, reorderingBuffer);
            i = findNextCompBoundary;
        }
        if (z) {
            compose(charSequence, i, length, z2, true, reorderingBuffer);
        } else {
            reorderingBuffer.append(charSequence, i, length);
        }
    }

    public int makeFCD(CharSequence charSequence, int i, int i2, ReorderingBuffer reorderingBuffer) {
        int i3 = i;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i;
            while (i != i2) {
                char charAt = charSequence.charAt(i);
                i4 = charAt;
                if (charAt >= 768) {
                    if (singleLeadMightHaveNonZeroFCD16(i4)) {
                        if (UTF16.isSurrogate((char) i4)) {
                            if (UTF16Plus.isSurrogateLead(i4)) {
                                if (i + 1 != i2) {
                                    char charAt2 = charSequence.charAt(i + 1);
                                    if (Character.isLowSurrogate(charAt2)) {
                                        i4 = Character.toCodePoint((char) i4, charAt2);
                                    }
                                }
                            } else if (i7 < i) {
                                char charAt3 = charSequence.charAt(i - 1);
                                if (Character.isHighSurrogate(charAt3)) {
                                    i--;
                                    i4 = Character.toCodePoint(charAt3, (char) i4);
                                }
                            }
                        }
                        int fCD16FromNormData = getFCD16FromNormData(i4);
                        i6 = fCD16FromNormData;
                        if (fCD16FromNormData > 255) {
                            break;
                        }
                        i5 = i6;
                        i += Character.charCount(i4);
                    } else {
                        i5 = 0;
                        i++;
                    }
                } else {
                    i5 = i4 ^ -1;
                    i++;
                }
            }
            if (i == i7) {
                if (i == i2) {
                    break;
                }
            } else if (i != i2) {
                i3 = i;
                if (i5 < 0) {
                    int i8 = i5 ^ -1;
                    i5 = i8 < 384 ? this.tccc180[i8] : getFCD16FromNormData(i8);
                    if (i5 > 1) {
                        i3--;
                    }
                } else {
                    int i9 = i - 1;
                    if (Character.isLowSurrogate(charSequence.charAt(i9)) && i7 < i9 && Character.isHighSurrogate(charSequence.charAt(i9 - 1))) {
                        i9--;
                        i5 = getFCD16FromNormData(Character.toCodePoint(charSequence.charAt(i9), charSequence.charAt(i9 + 1)));
                    }
                    if (i5 > 1) {
                        i3 = i9;
                    }
                }
                if (reorderingBuffer != null) {
                    reorderingBuffer.flushAndAppendZeroCC(charSequence, i7, i3);
                    reorderingBuffer.append(charSequence, i3, i);
                }
                i7 = i;
            } else if (reorderingBuffer != null) {
                reorderingBuffer.flushAndAppendZeroCC(charSequence, i7, i);
            }
            i += Character.charCount(i4);
            if ((i5 & 255) <= (i6 >> 8)) {
                if ((i6 & 255) <= 1) {
                    i3 = i;
                }
                if (reorderingBuffer != null) {
                    reorderingBuffer.appendZeroCC(i4);
                }
                i5 = i6;
            } else if (reorderingBuffer == null) {
                return i3;
            } else {
                reorderingBuffer.removeSuffix(i7 - i3);
                i = findNextFCDBoundary(charSequence, i, i2);
                decomposeShort(charSequence, i3, i, reorderingBuffer);
                i3 = i;
                i5 = 0;
            }
        }
        return i;
    }

    public void makeFCDAndAppend(CharSequence charSequence, boolean z, ReorderingBuffer reorderingBuffer) {
        int findNextFCDBoundary;
        int i = 0;
        int length = charSequence.length();
        if (!reorderingBuffer.isEmpty() && 0 != (findNextFCDBoundary = findNextFCDBoundary(charSequence, 0, length))) {
            int findPreviousFCDBoundary = findPreviousFCDBoundary(reorderingBuffer.getStringBuilder(), reorderingBuffer.length());
            StringBuilder sb = new StringBuilder((reorderingBuffer.length() - findPreviousFCDBoundary) + findNextFCDBoundary + 16);
            sb.append((CharSequence) reorderingBuffer.getStringBuilder(), findPreviousFCDBoundary, reorderingBuffer.length());
            reorderingBuffer.removeSuffix(reorderingBuffer.length() - findPreviousFCDBoundary);
            sb.append(charSequence, 0, findNextFCDBoundary);
            makeFCD(sb, 0, sb.length(), reorderingBuffer);
            i = findNextFCDBoundary;
        }
        if (z) {
            makeFCD(charSequence, i, length, reorderingBuffer);
        } else {
            reorderingBuffer.append(charSequence, i, length);
        }
    }

    public boolean hasDecompBoundary(int i, boolean z) {
        while (i >= this.minDecompNoCP) {
            int norm16 = getNorm16(i);
            if (isHangul(norm16) || isDecompYesAndZeroCC(norm16)) {
                return true;
            }
            if (norm16 > 65024) {
                return false;
            }
            if (isDecompNoAlgorithmic(norm16)) {
                i = mapAlgorithmic(i, norm16);
            } else {
                char charAt = this.extraData.charAt(norm16);
                if ((charAt & 31) == 0) {
                    return false;
                }
                if (!z) {
                    if (charAt > 511) {
                        return false;
                    }
                    if (charAt <= 255) {
                        return true;
                    }
                }
                return (charAt & 128) == 0 || (this.extraData.charAt(norm16 + -1) & 65280) == 0;
            }
        }
        return true;
    }

    public boolean isDecompInert(int i) {
        return isDecompYesAndZeroCC(getNorm16(i));
    }

    public boolean hasCompBoundaryBefore(int i) {
        return i < this.minCompNoMaybeCP || hasCompBoundaryBefore(i, getNorm16(i));
    }

    public boolean hasCompBoundaryAfter(int i, boolean z, boolean z2) {
        while (true) {
            int norm16 = getNorm16(i);
            if (isInert(norm16)) {
                return true;
            }
            if (norm16 <= this.minYesNo) {
                return isHangul(norm16) && !Hangul.isHangulWithoutJamoT((char) i);
            }
            if (norm16 >= (z2 ? this.minNoNo : this.minMaybeYes)) {
                return false;
            }
            if (isDecompNoAlgorithmic(norm16)) {
                i = mapAlgorithmic(i, norm16);
            } else {
                char charAt = this.extraData.charAt(norm16);
                return (charAt & ' ') == 0 && (!z || charAt <= 511);
            }
        }
    }

    public boolean hasFCDBoundaryBefore(int i) {
        return i < 768 || getFCD16(i) <= 255;
    }

    public boolean isFCDInert(int i) {
        return getFCD16(i) <= 1;
    }

    private boolean isMaybe(int i) {
        return this.minMaybeYes <= i && i <= 65280;
    }

    private boolean isMaybeOrNonZeroCC(int i) {
        return i >= this.minMaybeYes;
    }

    private static boolean isInert(int i) {
        return i == 0;
    }

    private static boolean isJamoVT(int i) {
        return i == 65280;
    }

    private boolean isHangul(int i) {
        return i == this.minYesNo;
    }

    private boolean isCompYesAndZeroCC(int i) {
        return i < this.minNoNo;
    }

    private boolean isDecompYesAndZeroCC(int i) {
        return i < this.minYesNo || i == 65280 || (this.minMaybeYes <= i && i <= 65024);
    }

    private boolean isMostDecompYesAndZeroCC(int i) {
        return i < this.minYesNo || i == 65024 || i == 65280;
    }

    private boolean isDecompNoAlgorithmic(int i) {
        return i >= this.limitNoNo;
    }

    private int getCCFromNoNo(int i) {
        if ((this.extraData.charAt(i) & 128) != 0) {
            return this.extraData.charAt(i - 1) & 255;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getTrailCCFromCompYesAndZeroCC(CharSequence charSequence, int i, int i2) {
        int i3;
        if (i == i2 - 1) {
            i3 = charSequence.charAt(i);
        } else {
            i3 = Character.codePointAt(charSequence, i);
        }
        int norm16 = getNorm16(i3);
        if (norm16 <= this.minYesNo) {
            return 0;
        }
        return this.extraData.charAt(norm16) >> '\b';
    }

    private int mapAlgorithmic(int i, int i2) {
        return (i + i2) - ((this.minMaybeYes - 64) - 1);
    }

    private int getCompositionsListForDecompYes(int i) {
        if (i == 0 || 65024 <= i) {
            return -1;
        }
        int i2 = i - this.minMaybeYes;
        if (i2 < 0) {
            return i2 + 65024;
        }
        return i2;
    }

    private int getCompositionsListForComposite(int i) {
        return (65024 - this.minMaybeYes) + i + 1 + (this.extraData.charAt(i) & 31);
    }

    public void decomposeShort(CharSequence charSequence, int i, int i2, ReorderingBuffer reorderingBuffer) {
        while (i < i2) {
            int codePointAt = Character.codePointAt(charSequence, i);
            i += Character.charCount(codePointAt);
            decompose(codePointAt, getNorm16(codePointAt), reorderingBuffer);
        }
    }

    private void decompose(int i, int i2, ReorderingBuffer reorderingBuffer) {
        int i3;
        while (!isDecompYes(i2)) {
            if (isHangul(i2)) {
                Hangul.decompose(i, reorderingBuffer);
                return;
            } else if (isDecompNoAlgorithmic(i2)) {
                i = mapAlgorithmic(i, i2);
                i2 = getNorm16(i);
            } else {
                char charAt = this.extraData.charAt(i2);
                int i4 = charAt & 31;
                int i5 = charAt >> '\b';
                if ((charAt & 128) != 0) {
                    i3 = this.extraData.charAt(i2 - 1) >> '\b';
                } else {
                    i3 = 0;
                }
                int i6 = i2 + 1;
                reorderingBuffer.append(this.extraData, i6, i6 + i4, i3, i5);
                return;
            }
        }
        reorderingBuffer.append(i, getCCFromYesOrMaybe(i2));
    }

    private static int combine(String str, int i, int i2) {
        char charAt;
        if (i2 < 13312) {
            int i3 = i2 << 1;
            while (true) {
                charAt = str.charAt(i);
                if (i3 <= charAt) {
                    break;
                }
                i += (charAt & 1) + 2;
            }
            if (i3 == (charAt & 32766)) {
                return (charAt & 1) != 0 ? (str.charAt(i + 1) << 16) | str.charAt(i + 2) : str.charAt(i + 1);
            }
            return -1;
        }
        int i4 = ((i2 >> 9) & -2) + 13312;
        int i5 = (i2 << 6) & 65535;
        while (true) {
            char charAt2 = str.charAt(i);
            if (i4 > charAt2) {
                i += (charAt2 & 1) + 2;
            } else if (i4 != (charAt2 & 32766)) {
                return -1;
            } else {
                char charAt3 = str.charAt(i + 1);
                if (i5 > charAt3) {
                    if ((32768 & charAt2) != 0) {
                        return -1;
                    }
                    i += 3;
                } else if (i5 == (65472 & charAt3)) {
                    return (('?' & charAt3) << 16) | str.charAt(i + 2);
                } else {
                    return -1;
                }
            }
        }
    }

    private void recompose(ReorderingBuffer reorderingBuffer, int i, boolean z) {
        char charAt;
        char charAt2;
        StringBuilder stringBuilder = reorderingBuffer.getStringBuilder();
        int i2 = i;
        if (i2 != stringBuilder.length()) {
            int i3 = -1;
            int i4 = -1;
            boolean z2 = false;
            int i5 = 0;
            while (true) {
                int codePointAt = stringBuilder.codePointAt(i2);
                i2 += Character.charCount(codePointAt);
                int norm16 = getNorm16(codePointAt);
                int cCFromYesOrMaybe = getCCFromYesOrMaybe(norm16);
                if (isMaybe(norm16) && i3 >= 0 && (i5 < cCFromYesOrMaybe || i5 == 0)) {
                    if (isJamoVT(norm16)) {
                        if (codePointAt < 4519 && (charAt = (char) (stringBuilder.charAt(i4) - 4352)) < 19) {
                            int i6 = i2 - 1;
                            char c = (char) ((((charAt * 21) + (codePointAt - 4449)) * 28) + 44032);
                            if (i2 != stringBuilder.length() && (charAt2 = (char) (stringBuilder.charAt(i2) - 4519)) < 28) {
                                i2++;
                                c = (char) (c + charAt2);
                            }
                            stringBuilder.setCharAt(i4, c);
                            stringBuilder.delete(i6, i2);
                            i2 = i6;
                        }
                        if (i2 == stringBuilder.length()) {
                            break;
                        }
                        i3 = -1;
                    } else {
                        int combine = combine(this.maybeYesCompositions, i3, codePointAt);
                        if (combine >= 0) {
                            int i7 = combine >> 1;
                            int charCount = i2 - Character.charCount(codePointAt);
                            stringBuilder.delete(charCount, i2);
                            i2 = charCount;
                            if (z2) {
                                if (i7 > 65535) {
                                    stringBuilder.setCharAt(i4, UTF16.getLeadSurrogate(i7));
                                    stringBuilder.setCharAt(i4 + 1, UTF16.getTrailSurrogate(i7));
                                } else {
                                    stringBuilder.setCharAt(i4, (char) codePointAt);
                                    stringBuilder.deleteCharAt(i4 + 1);
                                    z2 = false;
                                    i2--;
                                }
                            } else if (i7 > 65535) {
                                z2 = true;
                                stringBuilder.setCharAt(i4, UTF16.getLeadSurrogate(i7));
                                stringBuilder.insert(i4 + 1, UTF16.getTrailSurrogate(i7));
                                i2++;
                            } else {
                                stringBuilder.setCharAt(i4, (char) i7);
                            }
                            if (i2 == stringBuilder.length()) {
                                break;
                            }
                            i3 = (combine & 1) != 0 ? getCompositionsListForComposite(getNorm16(i7)) : -1;
                        }
                    }
                }
                i5 = cCFromYesOrMaybe;
                if (i2 == stringBuilder.length()) {
                    break;
                } else if (cCFromYesOrMaybe == 0) {
                    int compositionsListForDecompYes = getCompositionsListForDecompYes(norm16);
                    i3 = compositionsListForDecompYes;
                    if (compositionsListForDecompYes >= 0) {
                        if (codePointAt <= 65535) {
                            z2 = false;
                            i4 = i2 - 1;
                        } else {
                            z2 = true;
                            i4 = i2 - 2;
                        }
                    }
                } else if (z) {
                    i3 = -1;
                }
            }
            reorderingBuffer.flush();
        }
    }

    private boolean hasCompBoundaryBefore(int i, int i2) {
        while (!isCompYesAndZeroCC(i2)) {
            if (isMaybeOrNonZeroCC(i2)) {
                return false;
            }
            if (isDecompNoAlgorithmic(i2)) {
                i = mapAlgorithmic(i, i2);
                i2 = getNorm16(i);
            } else {
                char charAt = this.extraData.charAt(i2);
                if ((charAt & 31) == 0) {
                    return false;
                }
                if ((charAt & 128) == 0 || (this.extraData.charAt(i2 - 1) & 65280) == 0) {
                    return isCompYesAndZeroCC(getNorm16(Character.codePointAt(this.extraData, i2 + 1)));
                }
                return false;
            }
        }
        return true;
    }

    private int findPreviousCompBoundary(CharSequence charSequence, int i) {
        while (i > 0) {
            int codePointBefore = Character.codePointBefore(charSequence, i);
            i -= Character.charCount(codePointBefore);
            if (hasCompBoundaryBefore(codePointBefore)) {
                break;
            }
        }
        return i;
    }

    private int findNextCompBoundary(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            int codePointAt = Character.codePointAt(charSequence, i);
            if (hasCompBoundaryBefore(codePointAt, this.normTrie.get(codePointAt))) {
                break;
            }
            i += Character.charCount(codePointAt);
        }
        return i;
    }

    private int findPreviousFCDBoundary(CharSequence charSequence, int i) {
        while (i > 0) {
            int codePointBefore = Character.codePointBefore(charSequence, i);
            i -= Character.charCount(codePointBefore);
            if (codePointBefore >= 768) {
                if (getFCD16(codePointBefore) <= 255) {
                    break;
                }
            } else {
                break;
            }
        }
        return i;
    }

    private int findNextFCDBoundary(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            int codePointAt = Character.codePointAt(charSequence, i);
            if (codePointAt < 768 || getFCD16(codePointAt) <= 255) {
                break;
            }
            i += Character.charCount(codePointAt);
        }
        return i;
    }

    private void addToStartSet(Trie2Writable trie2Writable, int i, int i2) {
        UnicodeSet unicodeSet;
        int i3 = trie2Writable.get(i2);
        if ((4194303 & i3) != 0 || i == 0) {
            if ((2097152 & i3) == 0) {
                int i4 = i3 & 2097151;
                trie2Writable.set(i2, (-2097152 & i3) | 2097152 | this.canonStartSets.size());
                ArrayList<UnicodeSet> arrayList = this.canonStartSets;
                unicodeSet = new UnicodeSet();
                arrayList.add(unicodeSet);
                if (i4 != 0) {
                    unicodeSet.add(i4);
                }
            } else {
                unicodeSet = this.canonStartSets.get(2097151 & i3);
            }
            unicodeSet.add(i);
            return;
        }
        trie2Writable.set(i2, i3 | i);
    }
}
