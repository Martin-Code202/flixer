package o;

import android.content.Context;
import android.os.Build;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.ArrayList;
import java.util.List;
public class gU {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static gU f6916;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final List<String> f6917 = new ArrayList();

    /* renamed from: ˊ  reason: contains not printable characters */
    public static gU m6606(Context context) {
        gU gUVar = new gU(context);
        f6916 = gUVar;
        return gUVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static gU m6607() {
        return f6916;
    }

    private gU(Context context) {
        m6608(context);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String[] m6609() {
        String[] strArr;
        synchronized (this.f6917) {
            strArr = (String[]) this.f6917.toArray(new String[0]);
        }
        return strArr;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6608(Context context) {
        synchronized (this.f6917) {
            this.f6917.clear();
            if (Build.VERSION.SDK_INT >= 26) {
                for (String str : ConnectivityUtils.m2968(context)) {
                    C1283.m16851("nf_dns", "dns = %s ", str);
                    this.f6917.add(str);
                }
            } else {
                for (int i = 0; i < 8; i++) {
                    String str2 = "net.dns" + i;
                    String r8 = C1317As.m3748(str2, "");
                    C1283.m16851("nf_dns", "%s = %s", str2, r8);
                    if (C1349Bv.m4107(r8)) {
                        this.f6917.add(r8);
                    }
                }
            }
        }
    }
}
