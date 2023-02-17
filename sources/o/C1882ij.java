package o;

import java.io.File;
/* renamed from: o.ij  reason: case insensitive filesystem */
public class C1882ij {
    C1882ij() {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m7701(File file, String str) {
        File file2 = new File(file.getAbsolutePath() + ".new");
        boolean r6 = AH.m3349(file2.getAbsolutePath(), str.getBytes());
        if (r6) {
            C1283.m16863("nf_offline_registry", "deleteOldResult=%b moving %s to %s", Boolean.valueOf(file.delete()), file2.getAbsolutePath(), file.getAbsolutePath());
            r6 = AH.m3343(file2.getAbsolutePath(), file.getAbsolutePath());
        }
        C1283.m16863("nf_offline_registry", "writeRegistryFileRecoverable isSuccess=%b", Boolean.valueOf(r6));
        return r6;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m7702(File file) {
        File file2 = new File(file.getAbsolutePath() + ".new");
        if (file2.exists() && file2.length() > 0) {
            C1283.m16863("nf_offline_registry", "recovering result=%b newSize=%d oldSize=%d", Boolean.valueOf(file.delete()), Long.valueOf(file2.length()), Long.valueOf(file.length()));
            AH.m3343(file2.getAbsolutePath(), file.getAbsolutePath());
        }
    }
}
