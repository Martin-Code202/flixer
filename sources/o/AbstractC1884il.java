package o;

import com.netflix.mediaclient.media.BaseSubtitle;
import com.netflix.mediaclient.media.NccpSubtitle;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import org.json.JSONObject;
/* renamed from: o.il  reason: case insensitive filesystem */
public abstract class AbstractC1884il implements Subtitle {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected String f7760;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected Subtitle f7761;

    /* renamed from: ॱ  reason: contains not printable characters */
    private SubtitleUrl f7762;

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public abstract int mo7684();

    public AbstractC1884il(JSONObject jSONObject) {
        this.f7761 = NccpSubtitle.newInstance(jSONObject);
        this.f7760 = jSONObject.optString("localPath");
        this.f7762 = new SubtitleUrl(jSONObject.getJSONObject("subtitleUrl"));
    }

    protected AbstractC1884il(Subtitle subtitle, SubtitleUrl subtitleUrl, String str) {
        this.f7761 = subtitle;
        this.f7762 = subtitleUrl;
        this.f7760 = str;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public String getId() {
        return this.f7761.getId();
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public String getDownloadableId() {
        return this.f7762.getDownloadableId();
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public String getLanguageCodeIso639_1() {
        return this.f7761.getLanguageCodeIso639_1();
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public String getLanguageCodeIso639_2() {
        return this.f7761.getLanguageCodeIso639_2();
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public String getLanguageDescription() {
        return this.f7761.getLanguageDescription();
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public int getTrackType() {
        return this.f7761.getTrackType();
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public boolean canDeviceRender() {
        return this.f7761.canDeviceRender();
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public int getNccpOrderNumber() {
        return this.f7761.getNccpOrderNumber();
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public boolean isCC() {
        return this.f7761.isCC();
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public boolean isForcedNarrativeOrNone() {
        return this.f7761.isForcedNarrativeOrNone();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public ISubtitleDef.SubtitleProfile m7707() {
        return this.f7762.getProfile();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m7705() {
        return this.f7760;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public SubtitleUrl m7704() {
        return this.f7762;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public JSONObject toJson() {
        JSONObject json = this.f7761.toJson();
        json.put(BaseSubtitle.IMPL, mo7684());
        json.put("localPath", this.f7760);
        json.put("subtitleUrl", this.f7762.toJson());
        return json;
    }

    @Override // java.lang.Object
    public String toString() {
        return getClass().getSimpleName() + "{subtitle=" + this.f7761 + ", SubtitleUrl=" + this.f7762 + ", LocalFilePath='" + this.f7760 + "'}";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static AbstractC1884il m7703(Subtitle subtitle, SubtitleUrl subtitleUrl, String str) {
        if (str == null) {
            str = "";
        }
        if (subtitleUrl.getProfile() == ISubtitleDef.SubtitleProfile.IMAGE || subtitleUrl.getProfile() == ISubtitleDef.SubtitleProfile.IMAGE_ENC) {
            C1283.m16851("nf_subtitles_offline", "OfflineSubtitle::newInstance: image, path %s", str);
            return new C1879ig(subtitle, subtitleUrl, str);
        }
        C1283.m16851("nf_subtitles_offline", "OfflineSubtitle::newInstance: text, path %s", str);
        return new C1887io(subtitle, subtitleUrl, str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int compareTo(Subtitle subtitle) {
        if (subtitle == null || this.f7761 == null || this.f7761.getLanguageDescription() == null) {
            return -1;
        }
        if (subtitle.getLanguageDescription() == null) {
            return 1;
        }
        int compare = String.CASE_INSENSITIVE_ORDER.compare(this.f7761.getLanguageDescription(), subtitle.getLanguageDescription());
        if (compare == 0) {
            return this.f7761.getLanguageDescription().compareTo(subtitle.getLanguageDescription());
        }
        return compare;
    }
}
