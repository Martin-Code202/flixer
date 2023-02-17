package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.Trie2;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.text.Normalizer2;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ICUException;
import com.ibm.icu.util.VersionInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.MissingResourceException;
import org.linphone.core.Privacy;
public final class UCharacterProperty {
    static final /* synthetic */ boolean $assertionsDisabled = (!UCharacterProperty.class.desiredAssertionStatus());
    private static final int GC_CC_MASK = getMask(15);
    private static final int GC_CN_MASK = getMask(0);
    private static final int GC_CS_MASK = getMask(18);
    private static final int GC_ZL_MASK = getMask(13);
    private static final int GC_ZP_MASK = getMask(14);
    private static final int GC_ZS_MASK = getMask(12);
    private static final int GC_Z_MASK = ((GC_ZS_MASK | GC_ZL_MASK) | GC_ZP_MASK);
    public static final UCharacterProperty INSTANCE;
    private static final int[] gcbToHst = {0, 0, 0, 0, 1, 0, 4, 5, 3, 2};
    BinaryProperty[] binProps = {new BinaryProperty(1, 256), new BinaryProperty(1, 128), new BinaryProperty(5) { // from class: com.ibm.icu.impl.UCharacterProperty.1
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return UBiDiProps.INSTANCE.isBidiControl(i);
        }
    }, new BinaryProperty(5) { // from class: com.ibm.icu.impl.UCharacterProperty.2
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return UBiDiProps.INSTANCE.isMirrored(i);
        }
    }, new BinaryProperty(1, 2), new BinaryProperty(1, 524288), new BinaryProperty(1, 1048576), new BinaryProperty(1, 1024), new BinaryProperty(1, 2048), new BinaryProperty(8) { // from class: com.ibm.icu.impl.UCharacterProperty.3
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            Normalizer2Impl normalizer2Impl = Norm2AllModes.getNFCInstance().impl;
            return normalizer2Impl.isCompNo(normalizer2Impl.getNorm16(i));
        }
    }, new BinaryProperty(1, 67108864), new BinaryProperty(1, 8192), new BinaryProperty(1, 16384), new BinaryProperty(1, 64), new BinaryProperty(1, 4), new BinaryProperty(1, 33554432), new BinaryProperty(1, 16777216), new BinaryProperty(1, 512), new BinaryProperty(1, Privacy.DEFAULT), new BinaryProperty(1, 65536), new BinaryProperty(5) { // from class: com.ibm.icu.impl.UCharacterProperty.4
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return UBiDiProps.INSTANCE.isJoinControl(i);
        }
    }, new BinaryProperty(1, 2097152), new CaseBinaryProperty(22), new BinaryProperty(1, 32), new BinaryProperty(1, 4096), new BinaryProperty(1, 8), new BinaryProperty(1, 131072), new CaseBinaryProperty(27), new BinaryProperty(1, 16), new BinaryProperty(1, 262144), new CaseBinaryProperty(30), new BinaryProperty(1, 1), new BinaryProperty(1, 8388608), new BinaryProperty(1, 4194304), new CaseBinaryProperty(34), new BinaryProperty(1, 134217728), new BinaryProperty(1, 268435456), new NormInertBinaryProperty(8, 37), new NormInertBinaryProperty(9, 38), new NormInertBinaryProperty(8, 39), new NormInertBinaryProperty(9, 40), new BinaryProperty(11) { // from class: com.ibm.icu.impl.UCharacterProperty.5
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return Norm2AllModes.getNFCInstance().impl.ensureCanonIterData().isCanonSegmentStarter(i);
        }
    }, new BinaryProperty(1, 536870912), new BinaryProperty(1, 1073741824), new BinaryProperty(6) { // from class: com.ibm.icu.impl.UCharacterProperty.6
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return UCharacter.isUAlphabetic(i) || UCharacter.isDigit(i);
        }
    }, new BinaryProperty(1) { // from class: com.ibm.icu.impl.UCharacterProperty.7
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return i <= 159 ? i == 9 || i == 32 : UCharacter.getType(i) == 12;
        }
    }, new BinaryProperty(1) { // from class: com.ibm.icu.impl.UCharacterProperty.8
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return UCharacterProperty.isgraphPOSIX(i);
        }
    }, new BinaryProperty(1) { // from class: com.ibm.icu.impl.UCharacterProperty.9
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return UCharacter.getType(i) == 12 || UCharacterProperty.isgraphPOSIX(i);
        }
    }, new BinaryProperty(1) { // from class: com.ibm.icu.impl.UCharacterProperty.10
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            if (i > 102 || i < 65 || (i > 70 && i < 97)) {
                return (i >= 65313 && i <= 65350 && (i <= 65318 || i >= 65345)) || UCharacter.getType(i) == 9;
            }
            return true;
        }
    }, new CaseBinaryProperty(49), new CaseBinaryProperty(50), new CaseBinaryProperty(51), new CaseBinaryProperty(52), new CaseBinaryProperty(53), new BinaryProperty(7) { // from class: com.ibm.icu.impl.UCharacterProperty.11
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            String decomposition = Norm2AllModes.getNFCInstance().impl.getDecomposition(i);
            if (decomposition != null) {
                i = decomposition.codePointAt(0);
                if (Character.charCount(i) != decomposition.length()) {
                    i = -1;
                }
            } else if (i < 0) {
                return false;
            }
            if (i < 0) {
                return !UCharacter.foldCase(decomposition, true).equals(decomposition);
            }
            UCaseProps uCaseProps = UCaseProps.INSTANCE;
            UCaseProps.dummyStringBuilder.setLength(0);
            return uCaseProps.toFullFolding(i, UCaseProps.dummyStringBuilder, 0) >= 0;
        }
    }, new CaseBinaryProperty(55), new BinaryProperty(10) { // from class: com.ibm.icu.impl.UCharacterProperty.12
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            Normalizer2Impl normalizer2Impl = Norm2AllModes.getNFKC_CFInstance().impl;
            String valueOf = UTF16.valueOf(i);
            StringBuilder sb = new StringBuilder();
            normalizer2Impl.compose(valueOf, 0, valueOf.length(), false, true, new Normalizer2Impl.ReorderingBuffer(normalizer2Impl, sb, 5));
            return !Normalizer2Impl.UTF16Plus.equal(sb, valueOf);
        }
    }, new BinaryProperty(2, 268435456), new BinaryProperty(2, 536870912), new BinaryProperty(2, 1073741824), new BinaryProperty(2, Integer.MIN_VALUE)};
    IntProperty[] intProps = {new BiDiIntProperty() { // from class: com.ibm.icu.impl.UCharacterProperty.13
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            return UBiDiProps.INSTANCE.getClass(i);
        }
    }, new IntProperty(0, 130816, 8), new CombiningClassIntProperty(8) { // from class: com.ibm.icu.impl.UCharacterProperty.14
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            return Normalizer2.getNFDInstance().getCombiningClass(i);
        }
    }, new IntProperty(2, 31, 0), new IntProperty(0, 917504, 17), new IntProperty(1) { // from class: com.ibm.icu.impl.UCharacterProperty.15
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            return UCharacterProperty.this.getType(i);
        }
    }, new BiDiIntProperty() { // from class: com.ibm.icu.impl.UCharacterProperty.16
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            return UBiDiProps.INSTANCE.getJoiningGroup(i);
        }
    }, new BiDiIntProperty() { // from class: com.ibm.icu.impl.UCharacterProperty.17
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            return UBiDiProps.INSTANCE.getJoiningType(i);
        }
    }, new IntProperty(2, 66060288, 20), new IntProperty(1) { // from class: com.ibm.icu.impl.UCharacterProperty.18
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            return UCharacterProperty.ntvGetType(UCharacterProperty.getNumericTypeValue(UCharacterProperty.this.getProperty(i)));
        }
    }, new IntProperty(0, 255, 0) { // from class: com.ibm.icu.impl.UCharacterProperty.19
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            return UScript.getScript(i);
        }
    }, new IntProperty(2) { // from class: com.ibm.icu.impl.UCharacterProperty.20
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            int additional = (UCharacterProperty.this.getAdditional(i, 2) & 992) >>> 5;
            if (additional < UCharacterProperty.gcbToHst.length) {
                return UCharacterProperty.gcbToHst[additional];
            }
            return 0;
        }
    }, new NormQuickCheckIntProperty(8, 4108, 1), new NormQuickCheckIntProperty(9, 4109, 1), new NormQuickCheckIntProperty(8, 4110, 2), new NormQuickCheckIntProperty(9, 4111, 2), new CombiningClassIntProperty(8) { // from class: com.ibm.icu.impl.UCharacterProperty.21
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            return Norm2AllModes.getNFCInstance().impl.getFCD16(i) >> 8;
        }
    }, new CombiningClassIntProperty(8) { // from class: com.ibm.icu.impl.UCharacterProperty.22
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            return Norm2AllModes.getNFCInstance().impl.getFCD16(i) & 255;
        }
    }, new IntProperty(2, 992, 5), new IntProperty(2, 1015808, 15), new IntProperty(2, 31744, 10), new BiDiIntProperty() { // from class: com.ibm.icu.impl.UCharacterProperty.23
        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            return UBiDiProps.INSTANCE.getPairedBracketType(i);
        }
    }};
    int m_additionalColumnsCount_;
    Trie2_16 m_additionalTrie_;
    int[] m_additionalVectors_;
    int m_maxBlockScriptValue_;
    int m_maxJTGValue_;
    public char[] m_scriptExtensions_;
    public Trie2_16 m_trie_;
    public VersionInfo m_unicodeVersion_;

    static {
        try {
            INSTANCE = new UCharacterProperty();
        } catch (IOException e) {
            throw new MissingResourceException(e.getMessage(), "", "");
        }
    }

    public final int getProperty(int i) {
        return this.m_trie_.get(i);
    }

    public int getAdditional(int i, int i2) {
        if (!$assertionsDisabled && i2 < 0) {
            throw new AssertionError();
        } else if (i2 >= this.m_additionalColumnsCount_) {
            return 0;
        } else {
            return this.m_additionalVectors_[this.m_additionalTrie_.get(i) + i2];
        }
    }

    public VersionInfo getAge(int i) {
        int additional = getAdditional(i, 0) >> 24;
        return VersionInfo.getInstance((additional >> 4) & 15, additional & 15, 0, 0);
    }

    /* access modifiers changed from: private */
    public static final boolean isgraphPOSIX(int i) {
        return (getMask(UCharacter.getType(i)) & (((GC_CC_MASK | GC_CS_MASK) | GC_CN_MASK) | GC_Z_MASK)) == 0;
    }

    /* access modifiers changed from: package-private */
    public class BinaryProperty {
        int column;
        int mask;

        BinaryProperty(int i, int i2) {
            this.column = i;
            this.mask = i2;
        }

        BinaryProperty(int i) {
            this.column = i;
            this.mask = 0;
        }

        /* access modifiers changed from: package-private */
        public final int getSource() {
            if (this.mask == 0) {
                return this.column;
            }
            return 2;
        }

        /* access modifiers changed from: package-private */
        public boolean contains(int i) {
            return (UCharacterProperty.this.getAdditional(i, this.column) & this.mask) != 0;
        }
    }

    class CaseBinaryProperty extends BinaryProperty {
        int which;

        CaseBinaryProperty(int i) {
            super(4);
            this.which = i;
        }

        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return UCaseProps.INSTANCE.hasBinaryProperty(i, this.which);
        }
    }

    class NormInertBinaryProperty extends BinaryProperty {
        int which;

        NormInertBinaryProperty(int i, int i2) {
            super(i);
            this.which = i2;
        }

        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.BinaryProperty
        public boolean contains(int i) {
            return Norm2AllModes.getN2WithImpl(this.which - 37).isInert(i);
        }
    }

    public boolean hasBinaryProperty(int i, int i2) {
        if (i2 < 0 || 61 <= i2) {
            return false;
        }
        return this.binProps[i2].contains(i);
    }

    public int getType(int i) {
        return getProperty(i) & 31;
    }

    /* access modifiers changed from: package-private */
    public class IntProperty {
        int column;
        int mask;
        int shift;

        IntProperty(int i, int i2, int i3) {
            this.column = i;
            this.mask = i2;
            this.shift = i3;
        }

        IntProperty(int i) {
            this.column = i;
            this.mask = 0;
        }

        /* access modifiers changed from: package-private */
        public final int getSource() {
            if (this.mask == 0) {
                return this.column;
            }
            return 2;
        }

        /* access modifiers changed from: package-private */
        public int getValue(int i) {
            return (UCharacterProperty.this.getAdditional(i, this.column) & this.mask) >>> this.shift;
        }
    }

    class BiDiIntProperty extends IntProperty {
        BiDiIntProperty() {
            super(5);
        }
    }

    class CombiningClassIntProperty extends IntProperty {
        CombiningClassIntProperty(int i) {
            super(i);
        }
    }

    class NormQuickCheckIntProperty extends IntProperty {
        int max;
        int which;

        NormQuickCheckIntProperty(int i, int i2, int i3) {
            super(i);
            this.which = i2;
            this.max = i3;
        }

        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.UCharacterProperty.IntProperty
        public int getValue(int i) {
            return Norm2AllModes.getN2WithImpl(this.which - 4108).getQuickCheck(i);
        }
    }

    public int getIntPropertyValue(int i, int i2) {
        if (i2 < 4096) {
            return (0 > i2 || i2 >= 61 || !this.binProps[i2].contains(i)) ? 0 : 1;
        }
        if (i2 < 4118) {
            return this.intProps[i2 - 4096].getValue(i);
        }
        if (i2 == 8192) {
            return getMask(getType(i));
        }
        return 0;
    }

    public final int getSource(int i) {
        if (i < 0) {
            return 0;
        }
        if (i < 61) {
            return this.binProps[i].getSource();
        }
        if (i < 4096) {
            return 0;
        }
        if (i < 4118) {
            return this.intProps[i - 4096].getSource();
        }
        if (i < 16384) {
            switch (i) {
                case 8192:
                case 12288:
                    return 1;
                default:
                    return 0;
            }
        } else if (i < 16398) {
            switch (i) {
                case 16384:
                    return 2;
                case 16385:
                    return 5;
                case 16386:
                case 16388:
                case 16390:
                case 16391:
                case 16392:
                case 16393:
                case 16394:
                case 16396:
                    return 4;
                case 16387:
                case 16389:
                case 16395:
                    return 3;
                default:
                    return 0;
            }
        } else {
            switch (i) {
                case 28672:
                    return 2;
                default:
                    return 0;
            }
        }
    }

    public static final int getMask(int i) {
        return 1 << i;
    }

    public static int getEuropeanDigit(int i) {
        if ((i > 122 && i < 65313) || i < 65) {
            return -1;
        }
        if ((i > 90 && i < 97) || i > 65370) {
            return -1;
        }
        if (i > 65338 && i < 65345) {
            return -1;
        }
        if (i <= 122) {
            return (i + 10) - (i <= 90 ? 65 : 97);
        } else if (i <= 65338) {
            return (i + 10) - 65313;
        } else {
            return (i + 10) - 65345;
        }
    }

    public int digit(int i) {
        int numericTypeValue = getNumericTypeValue(getProperty(i)) - 1;
        if (numericTypeValue <= 9) {
            return numericTypeValue;
        }
        return -1;
    }

    public double getUnicodeNumericValue(int i) {
        int numericTypeValue = getNumericTypeValue(getProperty(i));
        if (numericTypeValue == 0) {
            return -1.23456789E8d;
        }
        if (numericTypeValue < 11) {
            return (double) (numericTypeValue - 1);
        }
        if (numericTypeValue < 21) {
            return (double) (numericTypeValue - 11);
        }
        if (numericTypeValue < 176) {
            return (double) (numericTypeValue - 21);
        }
        if (numericTypeValue < 480) {
            return ((double) ((numericTypeValue >> 4) - 12)) / ((double) ((numericTypeValue & 15) + 1));
        } else if (numericTypeValue < 768) {
            int i2 = (numericTypeValue & 31) + 2;
            double d = (double) ((numericTypeValue >> 5) - 14);
            while (i2 >= 4) {
                d *= 10000.0d;
                i2 -= 4;
            }
            switch (i2) {
                case 0:
                default:
                    return d;
                case 1:
                    return d * 10.0d;
                case 2:
                    return d * 100.0d;
                case 3:
                    return d * 1000.0d;
            }
        } else if (numericTypeValue < 804) {
            int i3 = (numericTypeValue >> 2) - 191;
            switch ((numericTypeValue & 3) + 1) {
                case 1:
                    i3 *= 60;
                    break;
                case 2:
                    i3 *= 3600;
                    break;
                case 3:
                    i3 *= 216000;
                    break;
                case 4:
                    i3 *= 12960000;
                    break;
            }
            return (double) i3;
        } else if (numericTypeValue >= 828) {
            return -1.23456789E8d;
        } else {
            int i4 = numericTypeValue - 804;
            return ((double) (((i4 & 3) * 2) + 1)) / ((double) (20 << (i4 >> 2)));
        }
    }

    /* access modifiers changed from: private */
    public static final int getNumericTypeValue(int i) {
        return i >> 6;
    }

    /* access modifiers changed from: private */
    public static final int ntvGetType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i < 11) {
            return 1;
        }
        return i < 21 ? 2 : 3;
    }

    private UCharacterProperty() {
        if (this.binProps.length != 61) {
            throw new ICUException("binProps.length!=UProperty.BINARY_LIMIT");
        } else if (this.intProps.length != 22) {
            throw new ICUException("intProps.length!=(UProperty.INT_LIMIT-UProperty.INT_START)");
        } else {
            ByteBuffer requiredData = ICUBinary.getRequiredData("uprops.icu");
            this.m_unicodeVersion_ = ICUBinary.readHeaderAndDataVersion(requiredData, 1431335535, new IsAcceptable());
            int i = requiredData.getInt();
            requiredData.getInt();
            requiredData.getInt();
            int i2 = requiredData.getInt();
            int i3 = requiredData.getInt();
            this.m_additionalColumnsCount_ = requiredData.getInt();
            int i4 = requiredData.getInt();
            int i5 = requiredData.getInt();
            requiredData.getInt();
            requiredData.getInt();
            this.m_maxBlockScriptValue_ = requiredData.getInt();
            this.m_maxJTGValue_ = requiredData.getInt();
            ICUBinary.skipBytes(requiredData, 16);
            this.m_trie_ = Trie2_16.createFromSerialized(requiredData);
            int i6 = (i - 16) * 4;
            int serializedLength = this.m_trie_.getSerializedLength();
            if (serializedLength > i6) {
                throw new IOException("uprops.icu: not enough bytes for main trie");
            }
            ICUBinary.skipBytes(requiredData, i6 - serializedLength);
            ICUBinary.skipBytes(requiredData, (i2 - i) * 4);
            if (this.m_additionalColumnsCount_ > 0) {
                this.m_additionalTrie_ = Trie2_16.createFromSerialized(requiredData);
                int i7 = (i3 - i2) * 4;
                int serializedLength2 = this.m_additionalTrie_.getSerializedLength();
                if (serializedLength2 > i7) {
                    throw new IOException("uprops.icu: not enough bytes for additional-properties trie");
                }
                ICUBinary.skipBytes(requiredData, i7 - serializedLength2);
                this.m_additionalVectors_ = ICUBinary.getInts(requiredData, i4 - i3, 0);
            }
            int i8 = (i5 - i4) * 2;
            if (i8 > 0) {
                this.m_scriptExtensions_ = ICUBinary.getChars(requiredData, i8, 0);
            }
        }
    }

    static final class IsAcceptable implements ICUBinary.Authenticate {
        private IsAcceptable() {
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return bArr[0] == 7;
        }
    }

    public UnicodeSet addPropertyStarts(UnicodeSet unicodeSet) {
        Iterator<Trie2.Range> it = this.m_trie_.iterator();
        while (it.hasNext()) {
            Trie2.Range next = it.next();
            if (next.leadSurrogate) {
                break;
            }
            unicodeSet.add(next.startCodePoint);
        }
        unicodeSet.add(9);
        unicodeSet.add(10);
        unicodeSet.add(14);
        unicodeSet.add(28);
        unicodeSet.add(32);
        unicodeSet.add(133);
        unicodeSet.add(134);
        unicodeSet.add(127);
        unicodeSet.add(8202);
        unicodeSet.add(8208);
        unicodeSet.add(8298);
        unicodeSet.add(8304);
        unicodeSet.add(65279);
        unicodeSet.add(65280);
        unicodeSet.add(160);
        unicodeSet.add(161);
        unicodeSet.add(8199);
        unicodeSet.add(8200);
        unicodeSet.add(8239);
        unicodeSet.add(8240);
        unicodeSet.add(12295);
        unicodeSet.add(12296);
        unicodeSet.add(19968);
        unicodeSet.add(19969);
        unicodeSet.add(20108);
        unicodeSet.add(20109);
        unicodeSet.add(19977);
        unicodeSet.add(19978);
        unicodeSet.add(22235);
        unicodeSet.add(22236);
        unicodeSet.add(20116);
        unicodeSet.add(20117);
        unicodeSet.add(20845);
        unicodeSet.add(20846);
        unicodeSet.add(19971);
        unicodeSet.add(19972);
        unicodeSet.add(20843);
        unicodeSet.add(20844);
        unicodeSet.add(20061);
        unicodeSet.add(20062);
        unicodeSet.add(97);
        unicodeSet.add(123);
        unicodeSet.add(65);
        unicodeSet.add(91);
        unicodeSet.add(65345);
        unicodeSet.add(65371);
        unicodeSet.add(65313);
        unicodeSet.add(65339);
        unicodeSet.add(103);
        unicodeSet.add(71);
        unicodeSet.add(65351);
        unicodeSet.add(65319);
        unicodeSet.add(8288);
        unicodeSet.add(65520);
        unicodeSet.add(65532);
        unicodeSet.add(917504);
        unicodeSet.add(921600);
        unicodeSet.add(847);
        unicodeSet.add(848);
        return unicodeSet;
    }

    public void upropsvec_addPropertyStarts(UnicodeSet unicodeSet) {
        if (this.m_additionalColumnsCount_ > 0) {
            Iterator<Trie2.Range> it = this.m_additionalTrie_.iterator();
            while (it.hasNext()) {
                Trie2.Range next = it.next();
                if (!next.leadSurrogate) {
                    unicodeSet.add(next.startCodePoint);
                } else {
                    return;
                }
            }
        }
    }
}
