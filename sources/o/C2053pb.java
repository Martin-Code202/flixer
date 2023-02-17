package o;

import android.content.Context;
import android.graphics.Bitmap;
import com.netflix.mediaclient.android.app.Status;
import java.io.File;
/* renamed from: o.pb  reason: case insensitive filesystem */
public class C2053pb {
    /* renamed from: ˏ  reason: contains not printable characters */
    private static String m9726(Context context) {
        return context.getFilesDir() + "/img/of/profiles/";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String m9723(Context context) {
        return context.getFilesDir() + "/img/of/videos/";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m9719(Context context, String str) {
        return m9726(context) + str + ".img";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m9721(Context context, String str) {
        return m9723(context) + str + ".img";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m9722(Context context, AbstractC0933 r2, String str, String str2) {
        AH.m3340(m9726(context));
        m9728(r2, str, m9719(context, str2));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m9720(Context context, AbstractC0933 r2, String str, String str2) {
        AH.m3340(m9723(context));
        m9728(r2, str, m9721(context, str2));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m9724(Context context, String str) {
        File file = new File(m9721(context, str));
        if (file.exists()) {
            C1283.m16863("offlineImageUtils", "deleteVideoDetailsImage result=%b", Boolean.valueOf(file.delete()));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m9728(final AbstractC0933 r3, final String str, final String str2) {
        r3.mo15746(str, 0, 0, new AbstractC0957() { // from class: o.pb.4
            @Override // o.AbstractC0957
            public void onErrorResponse(String str3) {
            }

            @Override // o.AbstractC0957
            public void onResponse(Bitmap bitmap, String str3) {
                if (bitmap != null) {
                    C2053pb.m9727(r3, str, str2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m9727(AbstractC0933 r1, String str, final String str2) {
        r1.mo15745(str, new AbstractC2006nj() { // from class: o.pb.5
            @Override // o.AbstractC2006nj
            /* renamed from: ˎ */
            public void mo8943(String str3, String str4, Status status) {
                if (status.mo298() && C1349Bv.m4107(str4)) {
                    C1283.m16863("offlineImageUtils", "move result=%b", Boolean.valueOf(AH.m3343(str4.replaceFirst("file://", ""), str2)));
                }
            }

            @Override // o.AbstractC2006nj
            /* renamed from: ˎ */
            public void mo7553(String str3, byte[] bArr, Status status) {
            }

            @Override // o.AbstractC2006nj
            /* renamed from: ˎ */
            public void mo9311(String str3, String str4, long j, long j2, Status status) {
            }
        });
    }
}
