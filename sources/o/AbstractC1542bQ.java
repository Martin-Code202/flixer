package o;

import android.content.Context;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.servicemgr.Logblob;
import java.util.UUID;
import org.json.JSONObject;
/* renamed from: o.bQ  reason: case insensitive filesystem */
public abstract class AbstractC1542bQ implements Logblob {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected JSONObject f6134 = new JSONObject();

    /* renamed from: ˏ  reason: contains not printable characters */
    protected Logblob.Severity f6135 = Logblob.Severity.info;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected final long f6136 = System.currentTimeMillis();

    protected AbstractC1542bQ() {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5757(Context context, AbstractC1221 r6, String str, String str2) {
        this.f6134.put("clver", C1318At.m3777(context));
        if (mo5755() != null) {
            this.f6134.put("sev", mo5755().name());
        }
        String r3 = mo680();
        if (C1349Bv.m4107(r3)) {
            this.f6134.put("type", r3);
        }
        m5752(str);
        m5754(str2);
        m5753(context, r6);
        m5751();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5752(String str) {
        if (C1349Bv.m4107(str)) {
            this.f6134.put("appid", str);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5754(String str) {
        if (C1349Bv.m4107(str)) {
            this.f6134.put("sessionid", str);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5753(Context context, AbstractC1221 r11) {
        AbstractC2039oo r3 = r11.mo16547().mo1457();
        boolean r4 = r3.mo1467();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enabled", r4);
        if (r4) {
            boolean z = !r3.mo1471();
            C2043os r7 = r3.mo1472();
            String r8 = r3.mo1470(context);
            jSONObject.put(SignupConstants.Mode.FALLBACK, z);
            jSONObject.put("hostname", r8);
            if (r7 != null) {
                jSONObject.put("via", r7.m9710());
            }
            if (z) {
                jSONObject.put("error_code", r3.mo1465());
            }
        }
        this.f6134.put("ftlstatus", jSONObject);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m5751() {
        this.f6134.put("uniqueLogId", UUID.randomUUID().toString());
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˏ */
    public boolean mo1556() {
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Logblob.Severity mo5755() {
        return this.f6135;
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˎ */
    public JSONObject mo1555() {
        return this.f6134;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo5756() {
        return this.f6134.toString();
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ᐝ */
    public long mo1557() {
        return this.f6136;
    }
}
