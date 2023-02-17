package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.av  reason: case insensitive filesystem */
public class C1519av extends AbstractC1653dR {

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6099;

    public C1519av(String str, DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError) {
        super("shareSheet", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6099 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        data.put("url", this.f6099);
        return data;
    }
}
