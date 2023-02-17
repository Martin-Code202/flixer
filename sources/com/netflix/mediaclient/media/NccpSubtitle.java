package com.netflix.mediaclient.media;

import o.AK;
import org.json.JSONObject;
public final class NccpSubtitle extends BaseSubtitle {
    public static final int IMPL_VALUE = 1;
    private static final String TRACK_TYPE_ASSISTIVE = "ASSISTIVE";
    private static final String TRACK_TYPE_FORCED_NARRATIVE_SUBTITLE = "FORCED_NARRATIVE_SUBTITLE";
    private static final String TRACK_TYPE_NONE = "None";
    private static final String TRACK_TYPE_PRIMARY = "PRIMARY";

    protected NccpSubtitle(JSONObject jSONObject) {
        if (jSONObject.has(BaseSubtitle.ATTR_ORDER)) {
            this.nccpOrderNumber = jSONObject.getInt(BaseSubtitle.ATTR_ORDER);
        }
        this.canDeviceRender = AK.m3381(jSONObject, "canDeviceRender", false);
        this.id = AK.m3376(jSONObject, "id", (String) null);
        this.languageCodeIso639_1 = AK.m3376(jSONObject, "language", "en");
        this.languageDescription = AK.m3376(jSONObject, "languageDescription", "English");
        String r2 = AK.m3376(jSONObject, "trackType", (String) null);
        this.isForcedNarrative = AK.m3381(jSONObject, "isForcedNarrative", false);
        this.isNone = this.id.equalsIgnoreCase(TRACK_TYPE_NONE);
        if (r2 == null) {
            this.trackType = 0;
        } else if (TRACK_TYPE_ASSISTIVE.equalsIgnoreCase(r2)) {
            this.trackType = 2;
        } else if (TRACK_TYPE_PRIMARY.equalsIgnoreCase(r2)) {
            this.trackType = 1;
        } else if (TRACK_TYPE_FORCED_NARRATIVE_SUBTITLE.equalsIgnoreCase(r2)) {
            this.trackType = 6;
        }
        if (this.isForcedNarrative) {
            this.trackType = 6;
        }
        if (this.isNone) {
            this.trackType = 7;
        }
    }

    public static final Subtitle newInstance(JSONObject jSONObject) {
        return new NccpSubtitle(jSONObject);
    }

    public static final Subtitle newInstance(JSONObject jSONObject, int i) {
        NccpSubtitle nccpSubtitle = new NccpSubtitle(jSONObject);
        nccpSubtitle.nccpOrderNumber = i;
        return nccpSubtitle;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public String getDownloadableId() {
        return null;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BaseSubtitle.IMPL, 1);
        jSONObject.put("id", this.id);
        jSONObject.put(BaseSubtitle.ATTR_ORDER, this.nccpOrderNumber);
        jSONObject.put("canDeviceRender", this.canDeviceRender);
        jSONObject.put("language", this.languageCodeIso639_1);
        jSONObject.put("languageDescription", this.languageDescription);
        String str = null;
        if (this.trackType == 2) {
            str = TRACK_TYPE_ASSISTIVE;
        } else if (this.trackType == 1) {
            str = TRACK_TYPE_PRIMARY;
        }
        jSONObject.put("trackType", str);
        return jSONObject;
    }

    @Override // com.netflix.mediaclient.media.Subtitle
    public boolean isForcedNarrativeOrNone() {
        return this.isForcedNarrative || this.isNone;
    }

    @Override // com.netflix.mediaclient.media.BaseSubtitle, java.lang.Object
    public String toString() {
        return "NccpSubtitle[id=" + this.id + ", languageCodeIso639_1=" + this.languageCodeIso639_1 + ", languageCodeIso639_2=" + this.languageCodeIso639_2 + ", languageDescription=" + this.languageDescription + ", trackType=" + this.trackType + ", canDeviceRender=" + this.canDeviceRender + ", nccpOrderNumber=" + this.nccpOrderNumber + "]";
    }
}
