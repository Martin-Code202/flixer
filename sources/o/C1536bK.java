package o;

import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.bK  reason: case insensitive filesystem */
public final class C1536bK extends SessionStartedEvent {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6132;

    public C1536bK(String str) {
        super("FtlConnection");
        if (C1349Bv.m4113(str)) {
            C1276.m16820().mo5729("FtlConnectionSessionStartedEvent: via is missing!", new JSONException("FtlConnectionSessionStartedEvent: via is missing!"));
        } else {
            this.f6132 = str;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (C1349Bv.m4107(this.f6132)) {
            data.put("via", this.f6132);
        }
        return data;
    }
}
