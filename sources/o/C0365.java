package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInConfigData;
/* renamed from: o.ȝ  reason: contains not printable characters */
public class C0365 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String f13192 = "nf_config_signin";

    /* renamed from: ˊ  reason: contains not printable characters */
    Context f13193;

    /* renamed from: ˏ  reason: contains not printable characters */
    SignInConfigData f13194 = SignInConfigData.fromJsonString(C1339Bl.m4045(this.f13193, "signInConfigData", (String) null));

    public C0365(Context context) {
        this.f13193 = context;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public SignInConfigData m14067() {
        return this.f13194;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14068(SignInConfigData signInConfigData) {
        if (signInConfigData == null) {
            C1283.m16850(f13192, "signInConfigData object is null - ignore overwrite");
            return;
        }
        C1339Bl.m4039(this.f13193, "signInConfigData", signInConfigData.toJsonString());
        this.f13194 = signInConfigData;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m14066(Context context) {
        return C1349Bv.m4107(C1339Bl.m4045(context, "signInConfigData", (String) null));
    }
}
