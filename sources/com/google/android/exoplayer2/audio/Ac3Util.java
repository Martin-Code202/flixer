package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipConfiguration;
import java.nio.ByteBuffer;
public final class Ac3Util {
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = {1, 2, 3, 6};
    private static final int[] CHANNEL_COUNT_BY_ACMOD = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] SAMPLE_RATE_BY_FSCOD = {VoipConfiguration.MAX_SAMPLERATE_48K, 44100, 32000};
    private static final int[] SAMPLE_RATE_BY_FSCOD2 = {24000, 22050, 16000};
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static Format parseAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        int i = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return Format.createAudioSampleFormat(str, "audio/ac3", null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        parsableByteArray.skipBytes(2);
        int i = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return Format.createAudioSampleFormat(str, "audio/eac3", null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static int getAc3SyncframeAudioSampleCount() {
        return 1536;
    }

    public static int parseEAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        int i;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) == 3) {
            i = 6;
        } else {
            i = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }
}
