package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.dR  reason: case insensitive filesystem */
public abstract class AbstractC1653dR extends SessionEndedEvent {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected IClientLogging.CompletionReason f6420;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected UIError f6421;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected IClientLogging.ModalView f6422;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected UserActionLogging.CommandName f6423;

    public AbstractC1653dR(String str, DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError) {
        super(str, deviceUniqueId, j);
        this.f6422 = modalView;
        this.f6423 = commandName;
        this.f6420 = completionReason;
        this.f6421 = uIError;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        data.put("started", jSONObject);
        if (this.f6423 != null) {
            jSONObject.put("commandName", this.f6423.name());
        }
        if (this.f6422 != null) {
            jSONObject.put(Event.MODAL_VIEW, this.f6422.name());
        }
        if (this.f6420 != null) {
            data.put("reason", this.f6420.name());
        }
        if (this.f6421 != null) {
            data.put(ExceptionClEvent.CATEGORY_VALUE, this.f6421.toJSONObject());
        }
        return data;
    }
}
