package o;

import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import java.util.List;
import o.C1573bv;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.by  reason: case insensitive filesystem */
public class C1576by extends SessionEndedEvent {

    /* renamed from: ʻ  reason: contains not printable characters */
    private CustomerServiceLogging.TerminationReason f6192;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f6193;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f6194;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f6195;

    /* renamed from: ˎ  reason: contains not printable characters */
    private IClientLogging.CompletionReason f6196;

    /* renamed from: ˏ  reason: contains not printable characters */
    private List<C1573bv.iF> f6197;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Error f6198;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private CustomerServiceLogging.Sdk f6199;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6200;

    public C1576by(C1573bv bvVar, CustomerServiceLogging.Sdk sdk, int i, int i2, CustomerServiceLogging.TerminationReason terminationReason, IClientLogging.CompletionReason completionReason, Error error) {
        super("customerSupportCall", bvVar.m5779(), System.currentTimeMillis() - bvVar.m5777());
        this.f6199 = sdk;
        this.f6192 = terminationReason;
        this.f6196 = completionReason;
        this.f6198 = error;
        this.category = bvVar.mo5643();
        this.f6195 = i;
        this.f6194 = i2;
        this.f6197 = bvVar.m5804();
        this.f6200 = bvVar.m5802();
        this.f6193 = bvVar.m5801();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6192 != null) {
            data.put("terminationReason", this.f6192.name());
        }
        if (this.f6196 != null) {
            data.put("reason", this.f6196.name());
        }
        if (this.f6198 != null) {
            data.put(ExceptionClEvent.CATEGORY_VALUE, this.f6198.toJSONObject());
        }
        data.put("connectionTime", this.f6195);
        data.put("callDuration", this.f6194);
        data.put("dialConfirmationDialogDisplayed", this.f6193);
        data.put("sdk", this.f6199);
        if (C1349Bv.m4107(this.f6200)) {
            data.put("sessionID", this.f6200);
        }
        if (this.f6197 != null) {
            JSONArray jSONArray = new JSONArray();
            data.put("callQuality", jSONArray);
            for (C1573bv.iF iFVar : this.f6197) {
                jSONArray.put(iFVar.m5805());
            }
        }
        return data;
    }
}
