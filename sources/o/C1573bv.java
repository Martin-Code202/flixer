package o;

import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* renamed from: o.bv  reason: case insensitive filesystem */
public final class C1573bv extends AbstractC1571bt {

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f6178;

    /* renamed from: ʼ  reason: contains not printable characters */
    private CustomerServiceLogging.CallQuality f6179;

    /* renamed from: ʽ  reason: contains not printable characters */
    private CustomerServiceLogging.Sdk f6180;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private List<iF> f6181 = new ArrayList();

    /* renamed from: ˎ  reason: contains not printable characters */
    private long f6182;

    /* renamed from: ˏ  reason: contains not printable characters */
    private long f6183 = System.currentTimeMillis();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f6184;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f6185;

    public C1573bv(String str, CustomerServiceLogging.Sdk sdk, boolean z) {
        this.f6184 = str;
        this.f6180 = sdk;
        this.f6185 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5803(CustomerServiceLogging.CallQuality callQuality) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f6182 = currentTimeMillis;
        this.f6178 = currentTimeMillis;
        this.f6179 = callQuality;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5799(CustomerServiceLogging.CallQuality callQuality) {
        if (this.f6179 != callQuality) {
            m5798();
            this.f6179 = callQuality;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m5798() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f6178 == 0 || this.f6179 == null) {
            C1283.m16865("customerSupportCall", "Call connected did not called yet!");
            this.f6178 = currentTimeMillis;
            return;
        }
        this.f6181.add(new iF((int) (currentTimeMillis - this.f6178), this.f6179));
        this.f6178 = currentTimeMillis;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "customerSupportCall";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m5802() {
        return this.f6184;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m5801() {
        return this.f6185;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1576by m5800(CustomerServiceLogging.TerminationReason terminationReason, IClientLogging.CompletionReason completionReason, Error error) {
        m5798();
        int i = (int) ((this.f6182 - this.f6183) / 1000);
        if (i < 0) {
            i = 0;
            if (terminationReason == CustomerServiceLogging.TerminationReason.canceledByUserAfterConnected) {
                terminationReason = CustomerServiceLogging.TerminationReason.canceledByUserBeforeConnected;
            }
        }
        int r9 = (int) ((BA.m3835() - this.f6182) / 1000);
        if (r9 < 0) {
            r9 = 0;
        }
        return new C1576by(this, this.f6180, i, r9, terminationReason, completionReason, error);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public List<iF> m5804() {
        return this.f6181;
    }

    /* renamed from: o.bv$iF */
    public static class iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        public int f6186;

        /* renamed from: ˏ  reason: contains not printable characters */
        public CustomerServiceLogging.CallQuality f6187;

        public iF(int i, CustomerServiceLogging.CallQuality callQuality) {
            this.f6186 = i;
            this.f6187 = callQuality;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public JSONObject m5805() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segmentDuration", this.f6186);
            jSONObject.put("quality", this.f6187);
            return jSONObject;
        }
    }
}
