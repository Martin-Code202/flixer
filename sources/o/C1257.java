package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.CastKeyData;
/* renamed from: o.ｹ  reason: contains not printable characters */
public class C1257 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String f15838 = "nf_cast";

    /* renamed from: ˋ  reason: contains not printable characters */
    CastKeyData f15839 = CastKeyData.fromJsonString(C1339Bl.m4045(this.f15840, "castKeyData", (String) null));

    /* renamed from: ˏ  reason: contains not printable characters */
    Context f15840;

    public C1257(Context context) {
        this.f15840 = context;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16689(CastKeyData castKeyData) {
        C1339Bl.m4039(this.f15840, "castKeyData", castKeyData == null ? "" : castKeyData.toJsonString());
        this.f15839 = castKeyData;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m16690() {
        if (this.f15839 != null) {
            return this.f15839.keyId;
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m16688() {
        if (this.f15839 != null) {
            return this.f15839.key;
        }
        return null;
    }
}
