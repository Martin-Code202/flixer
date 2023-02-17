package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.dQ  reason: case insensitive filesystem */
public class C1652dQ extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final String f6418 = (UIViewLogging.UIViewCommandName.changeValue + ".ended");

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f6419;

    public C1652dQ(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, String str) {
        super("command", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6419 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        data.put("newValue", this.f6419);
        data.put("name", f6418);
        return data;
    }
}
