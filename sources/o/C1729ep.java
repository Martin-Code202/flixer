package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.ep  reason: case insensitive filesystem */
public final class C1729ep extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private UserActionLogging.Streams f6689;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private UserActionLogging.Streams f6690;

    public C1729ep(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, UserActionLogging.Streams streams, UserActionLogging.Streams streams2) {
        super("upgradeStreams", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6689 = streams;
        this.f6690 = streams2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6689 != null) {
            data.put("currentStreams", this.f6689.m1565());
        }
        if (this.f6690 != null) {
            data.put("endStreams", this.f6690.m1565());
        }
        return data;
    }
}
