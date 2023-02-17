package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;
public final class AvcConfig {
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthAspectRatio;
    public final int width;

    public static AvcConfig parse(ParsableByteArray parsableByteArray) {
        try {
            parsableByteArray.skipBytes(4);
            int readUnsignedByte = (parsableByteArray.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
            for (int i = 0; i < readUnsignedByte2; i++) {
                arrayList.add(buildNalUnitForChild(parsableByteArray));
            }
            int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
            for (int i2 = 0; i2 < readUnsignedByte3; i2++) {
                arrayList.add(buildNalUnitForChild(parsableByteArray));
            }
            int i3 = -1;
            int i4 = -1;
            float f = 1.0f;
            if (readUnsignedByte2 > 0) {
                NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                i3 = parseSpsNalUnit.width;
                i4 = parseSpsNalUnit.height;
                f = parseSpsNalUnit.pixelWidthAspectRatio;
            }
            return new AvcConfig(arrayList, readUnsignedByte, i3, i4, f);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error parsing AVC config", e);
        }
    }

    private AvcConfig(List<byte[]> list, int i, int i2, int i3, float f) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.width = i2;
        this.height = i3;
        this.pixelWidthAspectRatio = f;
    }

    private static byte[] buildNalUnitForChild(ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return CodecSpecificDataUtil.buildNalUnit(parsableByteArray.data, position, readUnsignedShort);
    }
}
