package o;

import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import java.util.Arrays;
import java.util.List;
/* access modifiers changed from: package-private */
/* renamed from: o.ﭸ  reason: contains not printable characters */
public class C1130 extends AbstractC1094<String> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1254 f15366;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f15367 = new StringBuilder("['dummy']").toString();

    C1130(AbstractC1254 r6) {
        this.f15366 = r6;
        C1283.m16848("nf_config_fetchdummywebrequest", "PQL = %s", this.f15367);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return Arrays.asList(this.f15367);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo986(String str) {
        return Integer.toString(StatusCode.OK.m271());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo992(String str) {
        if (this.f15366 != null) {
            this.f15366.mo5712(AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f15366 != null) {
            this.f15366.mo5712(status);
        }
    }
}
