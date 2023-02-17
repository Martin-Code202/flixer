package o;

import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.media.BaseSubtitle;
import org.json.JSONObject;
public final class uV extends BaseSubtitle {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final boolean f10950;

    protected uV(JSONObject jSONObject, int i) {
        this.canDeviceRender = true;
        this.id = AK.m3376(jSONObject, "id", (String) null);
        this.languageDescription = AK.m3376(jSONObject, SignupConstants.Field.LABEL, "English");
        this.nccpOrderNumber = i;
        this.f10950 = AK.m3381(jSONObject, "selected", false);
        this.trackType = 1;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final uV m11654(JSONObject jSONObject, int i) {
        return new uV(jSONObject, i);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m11655() {
        return this.f10950;
    }

    @Override // com.netflix.mediaclient.media.BaseSubtitle, java.lang.Object
    public String toString() {
        return "MdxSubtitle [mSelected=" + this.f10950 + ", id=" + this.id + ", languageCodeIso639_1=" + this.languageCodeIso639_1 + ", languageCodeIso639_2=" + this.languageCodeIso639_2 + ", languageDescription=" + this.languageDescription + ", trackType=" + this.trackType + ", canDeviceRender=" + this.canDeviceRender + ", nccpOrderNumber=" + this.nccpOrderNumber + "]";
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public String getDownloadableId() {
        return null;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BaseSubtitle.IMPL, 2);
        jSONObject.put("id", this.id);
        jSONObject.put(SignupConstants.Field.LABEL, this.languageDescription);
        jSONObject.put(BaseSubtitle.ATTR_ORDER, this.nccpOrderNumber);
        jSONObject.put("selected", this.f10950);
        return jSONObject;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public boolean isForcedNarrativeOrNone() {
        return false;
    }
}
