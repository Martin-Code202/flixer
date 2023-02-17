package o;

import org.json.JSONException;
import org.json.JSONObject;
public class iU extends iV {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean f7657;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f7658;

    public iU(boolean z, String str) {
        this.f7657 = z;
        this.f7658 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.iV
    /* renamed from: ˊ  reason: contains not printable characters */
    public JSONObject mo7577() {
        JSONObject r3 = super.mo7577();
        try {
            r3.put("downloadCompleted", this.f7657);
            if (C1349Bv.m4107(this.f7658)) {
                r3.put("secureStopChallenge", this.f7658);
            }
        } catch (JSONException e) {
            C1283.m16856("nf_msl_volley_bladerunner", e, "error creating params", new Object[0]);
        }
        return r3;
    }

    /* access modifiers changed from: package-private */
    @Override // o.iV
    /* renamed from: ˋ  reason: contains not printable characters */
    public final String mo7578() {
        return m7579(mo7577()).toString();
    }
}
