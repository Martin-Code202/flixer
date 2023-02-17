package o;

import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.cb  reason: case insensitive filesystem */
public final class C1608cb extends SessionStartedEvent {

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6254;

    public C1608cb(String str) {
        super("Download");
        if (C1349Bv.m4113(str)) {
            C1276.m16820().mo5729("DownloadSessionStartedEvent: dxid is missing!", new JSONException("DownloadSessionStartedEvent: dxid is missing!"));
        } else {
            this.f6254 = str;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (C1349Bv.m4107(this.f6254)) {
            data.put("dxid", this.f6254);
        }
        return data;
    }
}
