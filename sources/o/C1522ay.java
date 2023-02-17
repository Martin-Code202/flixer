package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.ay  reason: case insensitive filesystem */
public class C1522ay extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6103;

    public C1522ay(String str, DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError) {
        super("shareOpenSheet", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6103 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        data.put("url", this.f6103);
        return data;
    }
}
