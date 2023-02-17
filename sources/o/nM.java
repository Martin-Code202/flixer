package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
public final class nM extends AbstractC1189<String> {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final iF f9016 = new iF(null);

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f9017;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public nM(Context context, NetflixDataRequest.Transport transport, String str) {
        super(context, transport);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(transport, "transport");
        C1457Fr.m5025(str, "alertFeedback");
        this.f9017 = str;
        C1283.m16846("RecordUmsAlertFeedbackRequest", "PQL = ['ums', 'sendAlertFeedback'] (alertFeedback = " + this.f9017);
    }

    public static final class iF {
        private iF() {
        }

        public /* synthetic */ iF(C1456Fq fq) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ॱ */
    public String mo9116() {
        return "call";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        List<String> asList = Arrays.asList("['ums', 'sendAlertFeedback']");
        C1457Fr.m5016((Object) asList, "Arrays.asList(pqlQuery)");
        return asList;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ʽ */
    public Map<String, String> mo9111() {
        Map<String, String> r3 = super.mo9111();
        r3.put("param", '\'' + this.f9017 + '\'');
        C1457Fr.m5016((Object) r3, "params");
        return r3;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˏ */
    public boolean mo9121() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public String mo9112(String str) {
        C1457Fr.m5025(str, "response");
        C1283.m16846("RecordUmsAlertFeedbackRequest", "String response to parse = " + str);
        return str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        C1457Fr.m5025(status, "statusCode");
        C1276.m16820().mo5727("failed to record ums alert feedback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo9114(String str) {
        C1457Fr.m5025(str, "parsedResponse");
    }
}
