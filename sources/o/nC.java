package o;

import android.content.Context;
import com.google.gson.JsonParser;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.model.leafs.OnRampEligibility;
import java.util.Arrays;
import java.util.List;
/* access modifiers changed from: package-private */
public class nC extends AbstractC1189<OnRampEligibility> {

    /* renamed from: ˋ  reason: contains not printable characters */
    OnRampEligibility.Action f8987;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC2022nz f8988;

    nC(Context context, NetflixDataRequest.Transport transport, OnRampEligibility.Action action, AbstractC2022nz nzVar) {
        super(context, transport);
        this.f8988 = nzVar;
        this.f8987 = action;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return Arrays.asList("['onramp','" + this.f8987.toString().toLowerCase() + "']");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˏ */
    public boolean mo9121() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public OnRampEligibility mo9112(String str) {
        try {
            return new OnRampEligibility(new JsonParser().parse(str).getAsJsonObject().getAsJsonObject("value").getAsJsonObject("onramp").getAsJsonObject(this.f8987.toString().toLowerCase()));
        } catch (Exception e) {
            String str2 = "DoOnRampEligibilityActionRequest got exception trying to parse JSON: " + e + " ... JSON -> " + str;
            C1283.m16865("DoOnRampEligibilityActionRequest", str2);
            C1276.m16820().mo5727(str2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        if (this.f8988 != null) {
            this.f8988.mo1393((OnRampEligibility) null, status);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo9114(OnRampEligibility onRampEligibility) {
        if (this.f8988 != null) {
            this.f8988.mo1393(onRampEligibility, AbstractC0367.f13235);
        }
    }
}
