package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.em  reason: case insensitive filesystem */
public class C1726em extends AbstractC1653dR {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f6683;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6684;

    public C1726em(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, String str, String str2) {
        super("surveyQuestion", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6684 = str;
        this.f6683 = str2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        data.put("question", this.f6684);
        data.put("response", this.f6683);
        return data;
    }
}
