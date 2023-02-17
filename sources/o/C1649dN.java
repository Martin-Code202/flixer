package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.dN  reason: case insensitive filesystem */
public class C1649dN extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private UserActionLogging.C0029 f6416;

    public C1649dN(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, UserActionLogging.C0029 r18) {
        super("addProfile", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        if (r18 == null) {
            C1276.m16820().mo5729("AddProfileEndedEvent: Profile object missing!", new JSONException("AddProfileEndedEvent: Profile object missing!"));
        } else {
            this.f6416 = r18;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6416 != null) {
            data.put("profile", this.f6416.m1567());
        }
        return data;
    }
}
