package o;

import org.json.JSONObject;
/* renamed from: o.fY  reason: case insensitive filesystem */
public final class C1765fY extends AbstractC1824gj {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6730;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6731;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6732;

    public C1765fY(JSONObject jSONObject) {
        super("META_DATA_CHANGED");
        this.f6730 = jSONObject.getString("catalogId");
        this.f6732 = jSONObject.optString("episodeId", null);
        this.f6731 = jSONObject.getString("type");
        this.f6980 = jSONObject;
    }
}
