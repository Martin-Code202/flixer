package o;

import com.netflix.mediaclient.servicemgr.UiLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.cv  reason: case insensitive filesystem */
public class C1630cv {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String f6385 = "nf_presentation";

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f6386;

    /* renamed from: ʼ  reason: contains not printable characters */
    private long f6387;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f6388;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f6389;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f6390;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<String> f6391;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final List<String> f6392;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6393;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f6394;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6395;

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public String m5979() {
        return this.f6392.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public String m5981() {
        return this.f6391.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public int m5980() {
        return this.f6388;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public int m5982() {
        return this.f6386;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public long m5978() {
        return this.f6387;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʽ  reason: contains not printable characters */
    public String m5977() {
        return this.f6394;
    }

    public String toString() {
        return "PresentationEvent{videoIds=" + this.f6392 + ", videoImageTypeIdentifierIds=" + this.f6391 + ", requestId='" + this.f6393 + "', trackId=" + this.f6389 + ", row=" + this.f6388 + ", rank=" + this.f6386 + ", location='" + this.f6394 + "', impressionToken='" + this.f6395 + "', time=" + this.f6387 + ", isHero=" + this.f6390 + '}';
    }

    private C1630cv() {
        this.f6392 = new ArrayList();
        this.f6391 = new ArrayList();
    }

    public C1630cv(AbstractC2087qh qhVar, List<String> list, List<String> list2, int i, int i2, UiLocation uiLocation) {
        this.f6392 = list;
        this.f6391 = list2;
        this.f6393 = qhVar.getRequestId();
        this.f6395 = qhVar.getImpressionToken();
        this.f6389 = qhVar.isHero() ? qhVar.getHeroTrackId() : qhVar.getTrackId();
        this.f6388 = i;
        this.f6390 = qhVar.isHero();
        this.f6386 = i2;
        if (uiLocation != null) {
            this.f6394 = uiLocation.m1563();
        }
        this.f6387 = System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public JSONArray m5983() {
        JSONArray jSONArray = new JSONArray();
        int i = this.f6386;
        for (int i2 = 0; i2 < this.f6392.size(); i2++) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("video_id", this.f6392.get(i2));
            jSONObject.putOpt("request_id", this.f6393);
            if (this.f6395 != null) {
                jSONObject.putOpt("impression_token", this.f6395);
            }
            jSONObject.putOpt("track_id", Integer.valueOf(this.f6389));
            jSONObject.putOpt("row", Integer.valueOf(this.f6388));
            jSONObject.putOpt("rank", Integer.valueOf(i));
            if (this.f6394 != null) {
                jSONObject.putOpt("location", this.f6394);
            }
            jSONObject.putOpt("time", Long.valueOf(this.f6387));
            jSONObject.putOpt("is_hero", Boolean.valueOf(this.f6390));
            if (this.f6391 != null && this.f6391.size() > i2) {
                String str = this.f6391.get(i2);
                if (C1349Bv.m4107(str)) {
                    jSONObject.putOpt("image_key", str);
                }
            }
            i++;
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static C1630cv m5976(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C1630cv cvVar = new C1630cv();
        try {
            cvVar.f6392.add(AK.m3376(jSONObject, "video_id", (String) null));
            String r7 = AK.m3376(jSONObject, "image_key", (String) null);
            if (cvVar.f6391 != null) {
                cvVar.f6391.add(r7);
            }
            cvVar.f6393 = AK.m3376(jSONObject, "request_id", (String) null);
            cvVar.f6395 = AK.m3376(jSONObject, "impression_token", (String) null);
            cvVar.f6389 = AK.m3386(jSONObject, "track_id", 0);
            cvVar.f6388 = AK.m3386(jSONObject, "row", 0);
            cvVar.f6386 = AK.m3386(jSONObject, "rank", 0);
            cvVar.f6394 = AK.m3376(jSONObject, "location", (String) null);
            cvVar.f6387 = AK.m3388(jSONObject, "time", 0);
            cvVar.f6390 = AK.m3381(jSONObject, "is_hero", false);
            return cvVar;
        } catch (Exception e) {
            C1283.m16854(f6385, String.format("fail to create PT event from json: %s ", jSONObject.toString()));
            return null;
        }
    }
}
