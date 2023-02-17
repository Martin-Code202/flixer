package o;

import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.BaseSubtitle;
import com.netflix.mediaclient.media.Subtitle;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
public final class uR extends AudioSource {

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f10947;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f10948;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final boolean f10949;

    protected uR(JSONObject jSONObject, int i) {
        this.id = AK.m3376(jSONObject, "id", (String) null);
        this.languageDescription = AK.m3376(jSONObject, SignupConstants.Field.LABEL, "English");
        this.f10949 = AK.m3381(jSONObject, "selected", false);
        this.nccpOrderNumber = i;
        this.isNative = true;
        this.trackType = 0;
        JSONArray r2 = AK.m3377(jSONObject, "disallowedSubtitleTracks");
        if (r2 != null) {
            this.disallowedSubtitles = new String[r2.length()];
            for (int i2 = 0; i2 < r2.length(); i2++) {
                this.disallowedSubtitles[i2] = r2.getString(i2);
            }
            return;
        }
        C1283.m16854("nf_audio_source", "No disallowedSubtitleTracks!");
        this.disallowedSubtitles = new String[0];
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static uR m11649(JSONObject jSONObject, int i) {
        return new uR(jSONObject, i);
    }

    @Override // com.netflix.mediaclient.media.AudioSource
    public boolean isAllowedSubtitle(Subtitle subtitle) {
        if (subtitle == null) {
            return false;
        }
        return super.isAllowedSubtitle(subtitle);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m11650() {
        return this.f10949;
    }

    @Override // com.netflix.mediaclient.media.AudioSource, java.lang.Object
    public String toString() {
        return "MdxAudioSource [mSelected=" + this.f10949 + ", mSupported=" + this.f10947 + ", mAvailable=" + this.f10948 + ", id=" + this.id + ", languageCodeIso639_1=" + this.languageCodeIso639_1 + ", languageCodeIso639_2=" + this.languageCodeIso639_2 + ", languageDescription=" + this.languageDescription + ", trackType=" + this.trackType + ", codecType=" + this.codecType + ", isNative=" + this.isNative + ", numChannels=" + this.numChannels + ", nccpOrderNumber=" + this.nccpOrderNumber + ", disallowedSubtitles=" + Arrays.toString(this.disallowedSubtitles) + "]";
    }

    @Override // com.netflix.mediaclient.media.AudioSource
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BaseSubtitle.IMPL, 2);
        jSONObject.put("id", this.id);
        jSONObject.put(SignupConstants.Field.LABEL, this.languageDescription);
        jSONObject.put(BaseSubtitle.ATTR_ORDER, this.nccpOrderNumber);
        jSONObject.put("selected", this.f10949);
        if (this.disallowedSubtitles != null && this.disallowedSubtitles.length > 0) {
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("disallowedSubtitleTracks", jSONArray);
            for (int i = 0; i < this.disallowedSubtitles.length; i++) {
                jSONArray.put(this.disallowedSubtitles[i]);
            }
        }
        return jSONObject;
    }
}
