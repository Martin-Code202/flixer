package o;

import com.netflix.mediaclient.service.pushnotification.Payload;
import org.json.JSONObject;
/* renamed from: o.nd  reason: case insensitive filesystem */
public class C2000nd implements AbstractC0574 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f9120;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f9121;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f9122;

    public C2000nd(C1999nc ncVar) {
        if (ncVar != null) {
            this.f9122 = ncVar.m9282();
            this.f9120 = ncVar.m9281();
            this.f9121 = ncVar.m9282();
        }
    }

    public C2000nd(Payload payload) {
        if (payload != null) {
            this.f9122 = payload.f2152;
            this.f9120 = payload.f2158;
            this.f9121 = payload.f2152;
        }
    }

    @Override // o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (C1349Bv.m4107(this.f9122)) {
            jSONObject.put("messageId", this.f9122);
        }
        if (C1349Bv.m4107(this.f9120)) {
            jSONObject.put("messageGuid:", this.f9120);
        }
        if (C1349Bv.m4107(this.f9121)) {
            jSONObject.put("eventGuid", this.f9121);
        }
        return jSONObject;
    }

    public String toString() {
        return "TrackingInfo{messageId='" + this.f9122 + "', messageGuid='" + this.f9120 + "', eventGuid='" + this.f9121 + "'}";
    }
}
