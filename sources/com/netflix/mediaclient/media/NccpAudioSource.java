package com.netflix.mediaclient.media;

import com.netflix.mediaclient.media.manifest.Stream;
import o.AK;
import o.C1283;
import o.jK;
import org.json.JSONArray;
import org.json.JSONObject;
public class NccpAudioSource extends AudioSource {
    public static final int IMPL_VALUE = 1;
    private static final String TRACK_TYPE_ASSISTIVE = "ASSISTIVE";
    private static final String TRACK_TYPE_COMMENTARY = "COMMENTARY";
    private static final String TRACK_TYPE_PRIMARY = "PRIMARY";

    protected NccpAudioSource(JSONObject jSONObject, int i) {
        this.id = AK.m3376(jSONObject, "id", (String) null);
        this.dlid = AK.m3376(jSONObject, "downloadable_id", (String) null);
        this.bitrate = AK.m3386(jSONObject, "bitrate", 0);
        this.numChannels = AK.m3386(jSONObject, "channels", 0);
        this.languageCodeIso639_1 = AK.m3376(jSONObject, "language", "en");
        this.languageDescription = AK.m3376(jSONObject, "languageDescription", "English");
        this.nccpOrderNumber = i;
        String r3 = AK.m3376(jSONObject, "trackType", (String) null);
        this.isNative = AK.m3381(jSONObject, "isNative", true);
        if (TRACK_TYPE_ASSISTIVE.equalsIgnoreCase(r3)) {
            this.trackType = 2;
        } else if (TRACK_TYPE_COMMENTARY.equalsIgnoreCase(r3)) {
            this.trackType = 1;
        } else if (TRACK_TYPE_PRIMARY.equalsIgnoreCase(r3)) {
            this.trackType = 0;
        } else {
            this.trackType = -1;
        }
        JSONArray r4 = AK.m3377(jSONObject, "disallowedSubtitleTracks");
        if (r4 != null) {
            C1283.m16854("nf_audio_source", "DisallowedSubtitleTracks found: " + r4.length());
            this.disallowedSubtitles = new String[r4.length()];
            for (int i2 = 0; i2 < r4.length(); i2++) {
                this.disallowedSubtitles[i2] = r4.getString(i2);
            }
        } else {
            C1283.m16854("nf_audio_source", "No disallowedSubtitleTracks!");
            this.disallowedSubtitles = new String[0];
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("streams");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                Stream r7 = jK.m7946((JSONObject) optJSONArray.opt(i3));
                if (r7 != null) {
                    this.streams.add(r7);
                }
            }
        }
    }

    public static AudioSource newInstance(JSONObject jSONObject, int i) {
        return new NccpAudioSource(jSONObject, i);
    }

    @Override // com.netflix.mediaclient.media.AudioSource
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BaseSubtitle.IMPL, 1);
        jSONObject.put("id", this.id);
        jSONObject.put("languageDescription", this.languageDescription);
        jSONObject.put(BaseSubtitle.ATTR_ORDER, this.nccpOrderNumber);
        jSONObject.put("channels", this.numChannels);
        jSONObject.put("language", this.languageCodeIso639_1);
        jSONObject.put("languageDescription", this.languageDescription);
        jSONObject.put("isNative", this.isNative);
        String str = null;
        if (this.trackType == 2) {
            str = TRACK_TYPE_ASSISTIVE;
        } else if (this.trackType == 1) {
            str = TRACK_TYPE_COMMENTARY;
        } else if (this.trackType == 0) {
            str = TRACK_TYPE_PRIMARY;
        }
        jSONObject.put("trackType", str);
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
