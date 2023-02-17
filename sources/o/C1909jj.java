package o;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.Arrays;
/* renamed from: o.jj  reason: case insensitive filesystem */
public class C1909jj {
    /* renamed from: ॱ  reason: contains not printable characters */
    static String m8009(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder() && Arrays.asList(codecInfoAt.getSupportedTypes()).indexOf(str) >= 0 && codecInfoAt.getCapabilitiesForType(str).isFeatureSupported("adaptive-playback")) {
                return codecInfoAt.getName();
            }
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m8008() {
        boolean z = m8009("video/avc") != null;
        boolean z2 = false;
        try {
            z2 = "true".equalsIgnoreCase((String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "ro.streaming.video.drs", "false"));
        } catch (Exception e) {
            C1283.m16865("AdaptiveMediaDecoderHelper", "Exception while getting system property: ro.streaming.video.drs");
        }
        return z || z2;
    }
}
