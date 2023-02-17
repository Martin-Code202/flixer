package o;

import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.SubtitleUrl;
import org.json.JSONObject;
/* renamed from: o.ig  reason: case insensitive filesystem */
public class C1879ig extends AbstractC1884il {

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f7752;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f7753;

    public C1879ig(JSONObject jSONObject) {
        super(jSONObject);
        this.f7752 = jSONObject.getInt("masterIndexSize");
        this.f7753 = jSONObject.getInt("masterIndexOffset");
    }

    public C1879ig(Subtitle subtitle, SubtitleUrl subtitleUrl, String str) {
        super(subtitle, subtitleUrl, str);
        this.f7753 = subtitleUrl.getMasterIndexOffset();
        this.f7752 = subtitleUrl.getMasterIndexSize();
    }

    @Override // o.AbstractC1884il, com.netflix.mediaclient.media.Subtitle
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        json.put("masterIndexOffset", this.f7753);
        json.put("masterIndexSize", this.f7752);
        return json;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m7686() {
        return this.f7752;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m7685() {
        return this.f7753;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1884il
    /* renamed from: ˋ  reason: contains not printable characters */
    public int mo7684() {
        return 4;
    }
}
