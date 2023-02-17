package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.bz  reason: case insensitive filesystem */
public class C1577bz extends SessionEndedEvent {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6201;

    /* renamed from: ˋ  reason: contains not printable characters */
    private CustomerServiceLogging.Action f6202;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Error f6203;

    /* renamed from: ˏ  reason: contains not printable characters */
    private IClientLogging.CompletionReason f6204;

    /* renamed from: ॱ  reason: contains not printable characters */
    private CustomerServiceLogging.EntryPoint f6205;

    public C1577bz(C1570bs bsVar, CustomerServiceLogging.EntryPoint entryPoint, CustomerServiceLogging.Action action, String str, IClientLogging.CompletionReason completionReason, Error error) {
        super("helpRequest", bsVar.m5779(), System.currentTimeMillis() - bsVar.m5777());
        this.f6205 = entryPoint;
        this.f6202 = action;
        this.f6201 = str;
        this.f6204 = completionReason;
        this.f6203 = error;
        this.category = bsVar.mo5643();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6202 != null) {
            data.put("action", this.f6202.name());
        }
        if (this.f6205 != null) {
            data.put(NetflixActivity.EXTRA_ENTRY, this.f6205.name());
        }
        if (C1349Bv.m4107(this.f6201)) {
            data.put("url", this.f6201);
        }
        if (this.f6204 != null) {
            data.put("reason", this.f6204.name());
        }
        if (this.f6203 != null) {
            data.put(ExceptionClEvent.CATEGORY_VALUE, this.f6203.toJSONObject());
        }
        return data;
    }
}
