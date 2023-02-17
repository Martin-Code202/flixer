package o;

import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.cc  reason: case insensitive filesystem */
public class C1609cc extends SessionStartedEvent {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f6255;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6256;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6257;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f6258;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f6259;

    public C1609cc(String str, String str2, int i, int i2, int i3) {
        super("CachedPlay");
        this.f6256 = str2;
        this.f6259 = i;
        this.f6255 = i2;
        this.f6258 = i3;
        if (C1349Bv.m4113(str)) {
            C1276.m16820().mo5729("CachedPlaySessionEndedEvent: oxid is missing!", new JSONException("CachedPlaySessionEndedEvent: oxid is missing!"));
        } else {
            this.f6257 = str;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (C1349Bv.m4107(this.f6257)) {
            data.put("oxid", this.f6257);
        }
        if (C1349Bv.m4107(this.f6256)) {
            data.put("videoId", this.f6256);
        }
        data.put("runtime", this.f6259);
        data.put("logicalStart", this.f6255);
        data.put("logicalEnd", this.f6258);
        return data;
    }
}
