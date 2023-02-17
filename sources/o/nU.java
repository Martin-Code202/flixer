package o;

import android.content.Context;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
public class nU extends AbstractC1189<Boolean> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC2022nz f9036;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f9037;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AW<String, String> f9038 = new AW<>();

    nU(Context context, NetflixDataRequest.Transport transport, int i, String str, String str2, AbstractC2022nz nzVar) {
        super(context, transport);
        this.f9036 = nzVar;
        this.f9037 = "['updateProductChoice']";
        this.f9038.put("param", String.valueOf(i));
        this.f9038.put("param", "\"" + str + "\"");
        this.f9038.put("param", "\"" + str2 + "\"");
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
        Map<String, String> r1 = super.mo9111();
        r1.putAll(this.f9038);
        return r1;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return Collections.singletonList(this.f9037);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public Boolean mo9112(String str) {
        if (!C0848.m15504(C0848.m15512("UpdatePlanChoiceRequest", str))) {
            return true;
        }
        throw new FalkorException("Failed to set Plan");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo9114(Boolean bool) {
        if (this.f9036 != null) {
            this.f9036.mo1408(AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        C1283.m16850("UpdatePlanChoiceRequest", "Update plan choice failed : " + status);
        if (this.f9036 != null) {
            this.f9036.mo1408(status);
        }
    }
}
