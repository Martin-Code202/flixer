package o;

import android.content.Context;
import com.google.gson.JsonParser;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Arrays;
import java.util.List;
/* access modifiers changed from: package-private */
public class nN extends AbstractC1189<CL> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC2022nz f9018;

    nN(Context context, NetflixDataRequest.Transport transport, AbstractC2022nz nzVar) {
        super(context, transport);
        this.f9018 = nzVar;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return Arrays.asList("['survey','get']");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˏ */
    public boolean mo9121() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public CL mo9112(String str) {
        try {
            return new CL(new JsonParser().parse(str).getAsJsonObject().getAsJsonObject("value").getAsJsonObject("survey").getAsJsonObject("get"));
        } catch (Exception e) {
            C1283.m16865("FetchSurveyRequest", "FetchSurveyTask got exception trying to parse JSON: " + e + " ... JSON -> " + str);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        if (this.f9018 != null) {
            this.f9018.mo1392((CL) null, status);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo9114(CL cl) {
        if (this.f9018 != null) {
            this.f9018.mo1392(cl, AbstractC0367.f13235);
        }
    }
}
