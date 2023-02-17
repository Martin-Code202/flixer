package o;

import android.media.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.netflix.mediaclient.util.MediaUtils;
import java.util.List;
/* renamed from: o.jo  reason: case insensitive filesystem */
public class C1914jo implements MediaCodecSelector {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static boolean f8025 = false;

    /* renamed from: ʼ  reason: contains not printable characters */
    private static final boolean f8026 = m8024("video/hevc", f8034);

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final boolean f8027 = m8026("video/hevc");

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final MediaCodecInfo f8028 = m8016("video/x-vnd.on2.vp9");

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final boolean f8029 = m8020("video/x-vnd.on2.vp9");

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final boolean f8030 = m8020("video/hevc");

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f8031 = C1914jo.class.getSimpleName();

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static final boolean f8032 = m8020("video/avc");

    /* renamed from: ͺ  reason: contains not printable characters */
    private static final boolean f8033 = m8017();

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final MediaCodecInfo f8034 = m8016("video/hevc");

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static final boolean f8035 = m8020("video/dolby-vision");

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static final boolean f8036 = m8023("video/x-vnd.on2.vp9");

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static final boolean f8037 = m8024("video/x-vnd.on2.vp9", f8028);

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m8017() {
        try {
            for (MediaCodecInfo mediaCodecInfo : MediaCodecUtil.getDecoderInfos("video/avc", f8032)) {
                if (mediaCodecInfo.adaptive && MediaUtils.m2973(mediaCodecInfo.getProfileLevels(), 8) >= 2048) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m8026(String str) {
        return m8020(str) && m8018(str, 4096);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m8018(String str, int i) {
        try {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : MediaCodecUtil.getDecoderInfo(str, true).getProfileLevels()) {
                if (codecProfileLevel.level >= i) {
                    return true;
                }
            }
            return false;
        } catch (MediaCodecUtil.DecoderQueryException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean m8020(String str) {
        try {
            if (MediaCodecUtil.getDecoderInfo(str, true) != null) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static com.google.android.exoplayer2.mediacodec.MediaCodecInfo m8016(String str) {
        try {
            List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> decoderInfos = MediaCodecUtil.getDecoderInfos(str, false);
            if (decoderInfos == null) {
                return null;
            }
            for (com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo : decoderInfos) {
                if (mediaCodecInfo.name.toLowerCase().contains(".google.")) {
                    return mediaCodecInfo;
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m8023(String str) {
        try {
            if (MediaCodecUtil.getDecoderInfo(str, false) != null) {
                return true;
            }
            return false;
        } catch (MediaCodecUtil.DecoderQueryException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m8024(String str, com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        try {
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo decoderInfo = MediaCodecUtil.getDecoderInfo(str, false);
            if (decoderInfo != null) {
                return mediaCodecInfo == null || !decoderInfo.name.equals(mediaCodecInfo.name);
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
    public com.google.android.exoplayer2.mediacodec.MediaCodecInfo getDecoderInfo(String str, boolean z) {
        if ("video/x-vnd.on2.vp9".equals(str)) {
            if (f8025) {
                return f8028;
            }
            z = z && f8029;
        } else if ("video/hevc".equals(str)) {
            if (f8025) {
                return f8034;
            }
            z = z && f8030;
        }
        return MediaCodecUtil.getDecoderInfo(str, z);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
    public com.google.android.exoplayer2.mediacodec.MediaCodecInfo getPassthroughDecoderInfo() {
        return MediaCodecUtil.getPassthroughDecoderInfo();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m8019() {
        return f8029;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m8022() {
        return f8030;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m8025() {
        return f8037;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m8021() {
        return f8026;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static boolean m8028() {
        return f8035;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static boolean m8027() {
        return f8027;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m8014() {
        return f8032;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m8015() {
        return f8033;
    }
}
