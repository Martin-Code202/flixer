package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.eh  reason: case insensitive filesystem */
public final class C1721eh extends AbstractC1653dR {

    /* renamed from: ʻ  reason: contains not printable characters */
    private PlayLocationType f6676;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Integer f6677;

    public C1721eh(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, Integer num, PlayLocationType playLocationType) {
        super("startPlay", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6677 = num;
        this.f6676 = playLocationType;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6677 != null) {
            data.put("rankTitle", this.f6677.intValue());
        }
        data.put("playerType", "JPLAYER2");
        if (this.f6676 != null) {
            data.put("playLocation", this.f6676.m1559());
        }
        return data;
    }
}
