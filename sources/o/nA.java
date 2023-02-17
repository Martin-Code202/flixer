package o;

import android.content.Context;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* access modifiers changed from: package-private */
public class nA extends AbstractC1189<String> {

    /* renamed from: ʼ  reason: contains not printable characters */
    private long f8981;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f8982 = "['createAutoLoginToken']";

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC2022nz f8983;

    nA(Context context, NetflixDataRequest.Transport transport, long j, AbstractC2022nz nzVar) {
        super(context, transport);
        this.f8983 = nzVar;
        this.f8981 = j;
        C1283.m16848("nf_service_user_autologinrequest", "PQL = %s", this.f8982);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ʽ  reason: contains not printable characters */
    public Map<String, String> mo9111() {
        Map<String, String> r4 = super.mo9111();
        r4.put("param", "\"" + this.f8981 + "\"");
        return r4;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo9116() {
        return "get";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ  reason: contains not printable characters */
    public List<String> mo9118() {
        return Arrays.asList(this.f8982);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public String mo9112(String str) {
        C1283.m16851("nf_service_user_autologinrequest", "String response to parse = %s", str);
        try {
            String string = new JSONObject(str).getJSONObject("value").getString("token");
            if (!C1349Bv.m4113(string)) {
                return string;
            }
            throw new FalkorException("Empty token!");
        } catch (Throwable th) {
            C1283.m16856("nf_service_user_autologinrequest", th, "Failed", new Object[0]);
            throw new FalkorException(th);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo9114(String str) {
        if (this.f8983 != null) {
            this.f8983.mo1405(str, AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo9113(Status status) {
        if (this.f8983 != null) {
            this.f8983.mo1405(null, status);
        }
    }
}
