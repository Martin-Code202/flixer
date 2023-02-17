package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.ee  reason: case insensitive filesystem */
public class C1718ee extends AbstractC1653dR {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f6667;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f6668;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6669;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f6670;

    public C1718ee(String str, boolean z, boolean z2, DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, String str2) {
        super("RegisterForPushNotifications", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6669 = str;
        this.f6670 = str2;
        this.f6667 = z;
        this.f6668 = z2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6669 != null) {
            data.put("deviceToken", this.f6669);
        }
        if (this.f6670 != null) {
            data.put("oldDeviceToken", this.f6670);
        }
        data.put("infoOptStatus", this.f6668);
        data.put("pushOptStatus", this.f6667);
        return data;
    }
}
