package o;

import com.netflix.mediaclient.service.offline.download.DownloadableType;
import java.io.File;
/* renamed from: o.ip  reason: case insensitive filesystem */
public class C1888ip {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m7719(String str, String str2) {
        return str + "/" + str2 + ".manifest";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static File m7716(String str, String str2, DownloadableType downloadableType) {
        return new File(m7720(str, str2, downloadableType));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m7720(String str, String str2, DownloadableType downloadableType) {
        return str + "/" + str2 + "." + downloadableType.m823();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m7721(String str) {
        return str + "/registry.json";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m7717(String str, String str2) {
        return str + "/" + str2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m7718(File file) {
        return file.getAbsolutePath() + "/of_meta_registry.json";
    }
}
