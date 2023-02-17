package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.bY  reason: case insensitive filesystem */
public final class C1550bY extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6148;

    public C1550bY(DeviceUniqueId deviceUniqueId, long j, String str, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError) {
        super("AddCachedVideo", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        if (C1349Bv.m4113(str)) {
            C1276.m16820().mo5729("AddCachedVideoSessionEndedEvent: oxid is missing!", new JSONException("AddCachedVideoSessionEndedEvent: oxid is missing!"));
        } else {
            this.f6148 = str;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (C1349Bv.m4107(this.f6148)) {
            data.put("oxid", this.f6148);
        }
        return data;
    }
}
