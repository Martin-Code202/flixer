package o;

import android.media.MediaCodecList;
import android.media.MediaFormat;
/* renamed from: o.jp  reason: case insensitive filesystem */
public final class C1915jp {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f8038 = C1915jp.class.getSimpleName();

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m8029() {
        MediaCodecList mediaCodecList = new MediaCodecList(1);
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", "audio/eac3");
        return C1349Bv.m4107(mediaCodecList.findDecoderForFormat(mediaFormat));
    }
}
