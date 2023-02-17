package o;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
public final class BE {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3841(String str) {
        if (C1349Bv.m4113(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null || parse.getHost() == null || parse.getScheme() == null) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m3842(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C1283.m16855("UriUtils", "Could not encoded param ", e);
            return URLEncoder.encode(str);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3839(String str, String str2) {
        return "&" + str + "=" + str2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m3843(AbstractC2074pw pwVar, boolean z) {
        String trickplayBigImgBaseUrl = z ? pwVar.getTrickplayBigImgBaseUrl() : pwVar.getTrickplayImgBaseUrl();
        int playableBookmarkPosition = pwVar.getPlayableBookmarkPosition();
        if (C1349Bv.m4113(trickplayBigImgBaseUrl)) {
            return pwVar.getInterestingUrl();
        }
        if (playableBookmarkPosition < pwVar.getLogicalStart() + 10) {
            return pwVar.getInterestingUrl();
        }
        String valueOf = String.valueOf(playableBookmarkPosition / 10);
        StringBuilder append = new StringBuilder(trickplayBigImgBaseUrl).append("/00000");
        append.replace(append.length() - valueOf.length(), append.length(), valueOf);
        append.append(".jpg");
        return append.toString();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3840(CH ch) {
        String trickplayImgBaseUrl = ch.getTrickplayImgBaseUrl();
        int playableBookmarkPosition = ch.getPlayableBookmarkPosition();
        if (C1349Bv.m4113(trickplayImgBaseUrl) || playableBookmarkPosition < ch.getLogicalStart() + 10) {
            return ch.getInterestingSmallUrl();
        }
        String valueOf = String.valueOf(playableBookmarkPosition / 10);
        StringBuilder append = new StringBuilder(trickplayImgBaseUrl).append("/00000");
        append.replace(append.length() - valueOf.length(), append.length(), valueOf);
        append.append(".jpg");
        return append.toString();
    }
}
