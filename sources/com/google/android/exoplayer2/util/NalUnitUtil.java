package com.google.android.exoplayer2.util;

import java.nio.ByteBuffer;
import java.util.Arrays;
public final class NalUnitUtil {
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static int[] scratchEscapePositions = new int[10];
    private static final Object scratchEscapePositionsLock = new Object();

    public static final class SpsData {
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.seqParameterSetId = i;
            this.width = i2;
            this.height = i3;
            this.pixelWidthAspectRatio = f;
            this.separateColorPlaneFlag = z;
            this.frameMbsOnlyFlag = z2;
            this.frameNumLength = i4;
            this.picOrderCountType = i5;
            this.picOrderCntLsbLength = i6;
            this.deltaPicOrderAlwaysZeroFlag = z3;
        }
    }

    public static int unescapeStream(byte[] bArr, int i) {
        int i2;
        synchronized (scratchEscapePositionsLock) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                i3 = findNextUnescapeIndex(bArr, i3, i);
                if (i3 < i) {
                    if (scratchEscapePositions.length <= i4) {
                        scratchEscapePositions = Arrays.copyOf(scratchEscapePositions, scratchEscapePositions.length * 2);
                    }
                    i4++;
                    scratchEscapePositions[i4] = i3;
                    i3 += 3;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = scratchEscapePositions[i7] - i5;
                System.arraycopy(bArr, i5, bArr, i6, i8);
                int i9 = i6 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i6 = i10 + 1;
                bArr[i10] = 0;
                i5 += i8 + 3;
            }
            System.arraycopy(bArr, i5, bArr, i6, i2 - i6);
        }
        return i2;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        for (int i2 = 0; i2 + 1 < position; i2++) {
            int i3 = byteBuffer.get(i2) & 255;
            if (i == 3) {
                if (i3 == 1 && (byteBuffer.get(i2 + 1) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i2 - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i3 == 0) {
                i++;
            }
            if (i3 != 0) {
                i = 0;
            }
        }
        byteBuffer.clear();
    }

    public static boolean isNalUnitSei(String str, byte b) {
        return ("video/avc".equals(str) && (b & 31) == 6) || ("video/hevc".equals(str) && ((b & 126) >> 1) == 39);
    }

    public static SpsData parseSpsNalUnit(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.skipBits(8);
        int readBits = parsableNalUnitBitArray.readBits(8);
        parsableNalUnitBitArray.skipBits(16);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int i5 = 1;
        boolean z = false;
        if (readBits == 100 || readBits == 110 || readBits == 122 || readBits == 244 || readBits == 44 || readBits == 83 || readBits == 86 || readBits == 118 || readBits == 128 || readBits == 138) {
            i5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (i5 == 3) {
                z = parsableNalUnitBitArray.readBit();
            }
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                int i6 = i5 != 3 ? 8 : 12;
                int i7 = 0;
                while (i7 < i6) {
                    if (parsableNalUnitBitArray.readBit()) {
                        skipScalingList(parsableNalUnitBitArray, i7 < 6 ? 16 : 64);
                    }
                    i7++;
                }
            }
        }
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int i8 = 0;
        boolean z2 = false;
        if (readUnsignedExpGolombCodedInt3 == 0) {
            i8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        } else if (readUnsignedExpGolombCodedInt3 == 1) {
            z2 = parsableNalUnitBitArray.readBit();
            parsableNalUnitBitArray.readSignedExpGolombCodedInt();
            parsableNalUnitBitArray.readSignedExpGolombCodedInt();
            long readUnsignedExpGolombCodedInt4 = (long) parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            for (int i9 = 0; ((long) i9) < readUnsignedExpGolombCodedInt4; i9++) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        boolean readBit = parsableNalUnitBitArray.readBit();
        int i10 = (2 - (readBit ? 1 : 0)) * readUnsignedExpGolombCodedInt6;
        if (!readBit) {
            parsableNalUnitBitArray.skipBit();
        }
        parsableNalUnitBitArray.skipBit();
        int i11 = readUnsignedExpGolombCodedInt5 * 16;
        int i12 = i10 * 16;
        if (parsableNalUnitBitArray.readBit()) {
            int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (i5 == 0) {
                i4 = 1;
                i3 = 2 - (readBit ? 1 : 0);
            } else {
                i4 = i5 == 3 ? 1 : 2;
                i3 = (i5 == 1 ? 2 : 1) * (2 - (readBit ? 1 : 0));
            }
            i11 -= (readUnsignedExpGolombCodedInt7 + readUnsignedExpGolombCodedInt8) * i4;
            i12 -= (readUnsignedExpGolombCodedInt9 + readUnsignedExpGolombCodedInt10) * i3;
        }
        float f = 1.0f;
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            int readBits2 = parsableNalUnitBitArray.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = parsableNalUnitBitArray.readBits(16);
                int readBits4 = parsableNalUnitBitArray.readBits(16);
                if (!(readBits3 == 0 || readBits4 == 0)) {
                    f = ((float) readBits3) / ((float) readBits4);
                }
            } else if (readBits2 < ASPECT_RATIO_IDC_VALUES.length) {
                f = ASPECT_RATIO_IDC_VALUES[readBits2];
            } else {
                Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + readBits2);
            }
        }
        return new SpsData(readUnsignedExpGolombCodedInt, i11, i12, f, z, readBit, readUnsignedExpGolombCodedInt2, readUnsignedExpGolombCodedInt3, i8, z2);
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i, int i2) {
        for (int i3 = i; i3 < i2 - 2; i3++) {
            if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                return i3;
            }
        }
        return i2;
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i3 != 0) {
                i3 = ((i2 + parsableNalUnitBitArray.readSignedExpGolombCodedInt()) + 256) % 256;
            }
            if (i3 != 0) {
                i2 = i3;
            }
        }
    }
}
