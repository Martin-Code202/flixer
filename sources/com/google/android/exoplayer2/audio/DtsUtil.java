package com.google.android.exoplayer2.audio;

import com.netflix.mediaclient.service.webclient.model.leafs.VoipConfiguration;
import java.nio.ByteBuffer;
public final class DtsUtil {
    private static final int[] CHANNELS_BY_AMODE = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] SAMPLE_RATE_BY_SFREQ = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, VoipConfiguration.MAX_SAMPLERATE_48K, -1, -1};
    private static final int[] TWICE_BITRATE_KBPS_BY_RATE = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static int parseDtsAudioSampleCount(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 4) & 1) << 6) | ((byteBuffer.get(position + 5) & 252) >> 2)) + 1) * 32;
    }
}
