package o;

import android.net.Uri;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* renamed from: o.sm  reason: case insensitive filesystem */
public class C2154sm {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final NetflixActivity f10225;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f10226;

    public C2154sm(NetflixActivity netflixActivity) {
        this.f10225 = netflixActivity;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m10803(String str, Status status, String str2) {
        if (this.f10226) {
            C1283.m16865("AccountHandler", "Account handler already executed because of timeout. Do nothing...");
            return;
        }
        this.f10226 = true;
        if (!status.mo298() || !C1349Bv.m4107(str)) {
            this.f10225.getHandler().post(new Runnable() { // from class: o.sm.2
                @Override // java.lang.Runnable
                public void run() {
                    C2154sm.this.f10225.showDialog(C2157sp.m10806(C2154sm.this.f10225));
                }
            });
        } else {
            this.f10225.getHandler().post(new AQ(this.f10225, m10802(str2, str)));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m10804(String str, Status status) {
        m10803(str, status, "https://www.netflix.com/youraccount");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m10802(String str, String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        try {
            buildUpon.appendQueryParameter("nftoken", URLDecoder.decode(str2, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            C1276.m16820().mo5729("should not happen", e);
        }
        return buildUpon.build().toString();
    }
}
