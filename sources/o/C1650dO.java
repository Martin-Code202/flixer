package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.dO  reason: case insensitive filesystem */
public class C1650dO extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f6417;

    public C1650dO(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, int i) {
        super("addToPlaylist", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6417 = i;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        data.put("titleRank", this.f6417);
        return data;
    }
}
