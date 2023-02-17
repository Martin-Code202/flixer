package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.en  reason: case insensitive filesystem */
public class C1727en extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6685;

    public C1727en(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, String str) {
        super("survey", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6685 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        data.put("surveyType", this.f6685);
        return data;
    }
}
