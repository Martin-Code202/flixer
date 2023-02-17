package o;

import android.content.Context;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.user.UserAgent;
import com.netflix.mediaclient.service.user.UserAgentInterface;
/* renamed from: o.rz  reason: case insensitive filesystem */
public class C2137rz extends rC {

    /* renamed from: ˋ  reason: contains not printable characters */
    private UserAgent f9963;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Context f9964;

    C2137rz(Context context, UserAgentInterface userAgentInterface, C1278 r4) {
        super(r4);
        this.f9964 = context;
        this.f9963 = (UserAgent) userAgentInterface;
    }

    @Override // o.rC, o.AbstractC1268
    /* renamed from: ॱ */
    public Runnable mo10137() {
        return new Runnable() { // from class: o.rz.2
            @Override // java.lang.Runnable
            public void run() {
                if (C2137rz.this.f9963.r_()) {
                    C1283.m16854("nf_appboot_error", "User agent is ready, just logout.");
                    C2137rz.this.f9963.mo1368(true);
                    return;
                }
                C1283.m16850("nf_appboot_error", "User agent is NOT ready, do brute force.");
                C1317As.m3760(C2137rz.this.f9964);
            }
        };
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C2137rz m10499(Context context, oD oDVar, UserAgentInterface userAgentInterface, String str) {
        C1283.m16854("nf_appboot_error", "ActionID 13 Forcelogout");
        if (C1349Bv.m4113(str)) {
            str = context.getString(R.string.APP_ERROR_ACTIONID_13_FORCELOGOUT);
        }
        return new C2137rz(context, userAgentInterface, new C1278("", str, null, new Runnable() { // from class: o.rz.4
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16850("nf_appboot_error", "ActionID 13, reset...");
            }
        }));
    }
}
