package o;

import com.google.gson.Gson;
import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.pservice.logging.PreAppWidgetLogData;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.au  reason: case insensitive filesystem */
public class C1516au extends AbstractC1653dR {

    /* renamed from: ʻ  reason: contains not printable characters */
    private PreAppWidgetLogData f6056;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f6057;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6058;

    public C1516au(String str, DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, String str2, String str3) {
        super(str, deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6058 = str2;
        this.f6057 = str3;
        this.f6056 = (PreAppWidgetLogData) ((Gson) C1281.m16832(Gson.class)).fromJson(str2, (Class<Object>) PreAppWidgetLogData.class);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            return new JSONObject();
        }
        return data;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getCustomData() {
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(this.f6058);
            JSONObject jSONObject2 = new JSONObject(this.f6057);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.get(next));
            }
        } catch (JSONException e) {
            C1283.m16847("nf_preapp_actionEndedEvent", "failed to merge widget data", e);
        }
        return jSONObject;
    }
}
