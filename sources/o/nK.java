package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
public class nK extends AbstractC1189<String> {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f9013;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f9014;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f9015 = "['ums', 'selectPlan']";

    nK(Context context, NetflixDataRequest.Transport transport, String str, String str2) {
        super(context, transport);
        this.f9013 = str2;
        this.f9014 = str;
        C1283.m16848("eog_RecordPlanSelection", "PQL = %s", "['ums', 'selectPlan']");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return Arrays.asList("['ums', 'selectPlan']");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ॱ */
    public String mo9116() {
        return "call";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ʽ */
    public Map<String, String> mo9111() {
        Map<String, String> r5 = super.mo9111();
        r5.put("param", String.format("'%s'", this.f9014));
        r5.put("param", String.format("'%s'", this.f9013));
        return r5;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˏ */
    public boolean mo9121() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo9112(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo9114(String str) {
    }
}
