package o;

import android.content.Context;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* access modifiers changed from: package-private */
public class nB extends AbstractC1189<C0614> {

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f8984;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f8985;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC2022nz f8986;

    nB(Context context, NetflixDataRequest.Transport transport, String str, AbstractC2022nz nzVar) {
        super(context, transport);
        this.f8986 = nzVar;
        if (str == null) {
            this.f8984 = "";
        } else {
            this.f8984 = str;
        }
        this.f8985 = "['autoLogin','" + this.f8984 + "']";
        C1283.m16848("nf_service_user_autologinrequest", "PQL = %s", this.f8985);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo9121() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ॱ */
    public String mo9116() {
        return "get";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return Arrays.asList(this.f8985);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public C0614 mo9112(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("value").getJSONObject("credentials");
            String string = jSONObject.getString(LoggingRequest.NETFLIX_ID);
            String string2 = jSONObject.getString("secureNetflixId");
            if (!C1349Bv.m4113(string) && !C1349Bv.m4113(string2)) {
                return new C0614(string, string2);
            }
            throw new FalkorException("Empty tokens!");
        } catch (Throwable th) {
            C1283.m16856("nf_service_user_autologinrequest", th, "Failed", new Object[0]);
            throw new FalkorException(th);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo9114(C0614 r3) {
        if (this.f8986 != null) {
            this.f8986.mo1404(r3, AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        if (this.f8986 != null) {
            this.f8986.mo1404((C0614) null, status);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean mo9122() {
        return false;
    }
}
