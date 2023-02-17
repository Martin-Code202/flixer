package o;

import android.content.Context;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.AudioSubtitleDefaultOrderInfo;
import com.netflix.mediaclient.media.Language;
import com.netflix.mediaclient.media.Subtitle;
import org.json.JSONObject;
/* renamed from: o.Ca  reason: case insensitive filesystem */
public final class C1355Ca {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4328(Context context, Language language) {
        if (language != null && context != null) {
            try {
                C1339Bl.m4039(context, "prefs_user_selected_language", new Cif(language).m4335().toString());
            } catch (Throwable th) {
                C1283.m16856("nf_loc", th, "Unable to save use selection!", new Object[0]);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Cif m4327(Context context) {
        if (context == null) {
            return null;
        }
        String r3 = C1339Bl.m4045(context, "prefs_user_selected_language", (String) null);
        if (C1349Bv.m4113(r3)) {
            return null;
        }
        try {
            return new Cif(new JSONObject(r3));
        } catch (Throwable th) {
            C1283.m16856("nf_loc", th, "Unable to load used selection!", new Object[0]);
            return null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static AN m4334(Cif ifVar, Subtitle[] subtitleArr, AudioSource[] audioSourceArr, AudioSubtitleDefaultOrderInfo[] audioSubtitleDefaultOrderInfoArr) {
        if (ifVar == null) {
            return null;
        }
        long j = 0;
        long j2 = ifVar.f5146;
        if (audioSubtitleDefaultOrderInfoArr == null || audioSubtitleDefaultOrderInfoArr.length < 1) {
            C1283.m16865("nf_loc", "No defaults! User override");
        } else {
            j = audioSubtitleDefaultOrderInfoArr[0].getCreationTimeInMs();
            C1283.m16851("nf_loc", "Manifest creation date %d", Long.valueOf(j));
        }
        C1283.m16851("nf_loc", "Last user override %d", Long.valueOf(j2));
        if (j > j2) {
            C1283.m16854("nf_loc", "Manifest defaults are newer than last user selection, use them...");
            return null;
        }
        C1283.m16854("nf_loc", "Manifest defaults are older than last user selection, use user overrides...");
        AudioSource r11 = m4326(ifVar, audioSourceArr, audioSubtitleDefaultOrderInfoArr, j);
        return new AN(m4330(ifVar, subtitleArr, r11, audioSubtitleDefaultOrderInfoArr, j), r11);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Subtitle m4330(Cif ifVar, Subtitle[] subtitleArr, AudioSource audioSource, AudioSubtitleDefaultOrderInfo[] audioSubtitleDefaultOrderInfoArr, long j) {
        if (C1349Bv.m4113(ifVar.f5147)) {
            C1283.m16865("nf_loc", "Subtitle is off...");
            if (audioSource.isAllowedSubtitle(null)) {
                C1283.m16854("nf_loc", "findSubtitleForUserOverride:: off subtitle is allowed, use it.");
                return null;
            }
            C1283.m16854("nf_loc", "findSubtitleForUserOverride:: off subtitle is NOT allowed, use manifest default");
            return m4332(subtitleArr, audioSubtitleDefaultOrderInfoArr);
        }
        Subtitle subtitle = null;
        for (Subtitle subtitle2 : subtitleArr) {
            if (ifVar.f5147.equals(subtitle2.getLanguageCodeIso639_1())) {
                if (subtitle2.getTrackType() == ifVar.f5145) {
                    C1283.m16854("nf_loc", "findSubtitleForUserOverride:: exact match, use it if it is allowed!");
                    if (audioSource.isAllowedSubtitle(subtitle2)) {
                        C1283.m16854("nf_loc", "findSubtitleForUserOverride:: exact match, it is allowed, use it!");
                        return subtitle2;
                    }
                    C1283.m16865("nf_loc", "findSubtitleForUserOverride:: exact match, it is NOT allowed, skip it!");
                } else if (subtitle == null) {
                    C1283.m16854("nf_loc", "No default subtitle before, save this one.");
                    subtitle = subtitle2;
                } else if (subtitle2.getTrackType() == 1) {
                    C1283.m16854("nf_loc", "Default subtitle track found, save this one.");
                    subtitle = subtitle2;
                }
            }
        }
        if (subtitle != null) {
            if (audioSource.isAllowedSubtitle(subtitle)) {
                C1283.m16854("nf_loc", "findSubtitleForUserOverride:: default subtitle match, it is allowed, use it!");
                return subtitle;
            }
            C1283.m16865("nf_loc", "findSubtitleForUserOverride:: default subtitle match, it is NOT allowed, skip it!");
        }
        C1283.m16854("nf_loc", "Same subtitle as one for user override is not found, use one supplied by manifest.");
        return m4332(subtitleArr, audioSubtitleDefaultOrderInfoArr);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static AudioSource m4326(Cif ifVar, AudioSource[] audioSourceArr, AudioSubtitleDefaultOrderInfo[] audioSubtitleDefaultOrderInfoArr, long j) {
        if (C1349Bv.m4113(ifVar.f5143)) {
            C1283.m16865("nf_loc", "Audio was not selected, use manifest override...");
            return m4329(audioSourceArr, audioSubtitleDefaultOrderInfoArr);
        }
        AudioSource audioSource = null;
        for (AudioSource audioSource2 : audioSourceArr) {
            if (ifVar.f5143.equals(audioSource2.getLanguageCodeIso639_1())) {
                if (audioSource2.getTrackType() == ifVar.f5144) {
                    return audioSource2;
                }
                if (audioSource == null) {
                    C1283.m16854("nf_loc", "No default audio before, save this one.");
                    audioSource = audioSource2;
                } else if (audioSource2.getTrackType() == 0) {
                    C1283.m16854("nf_loc", "Default audio track found, save this one.");
                    audioSource = audioSource2;
                }
            }
        }
        if (audioSource != null) {
            return audioSource;
        }
        C1283.m16854("nf_loc", "Same audio as one for user override is not found, use one supplied by manifest.");
        return m4329(audioSourceArr, audioSubtitleDefaultOrderInfoArr);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Subtitle m4332(Subtitle[] subtitleArr, AudioSubtitleDefaultOrderInfo[] audioSubtitleDefaultOrderInfoArr) {
        if (audioSubtitleDefaultOrderInfoArr != null && audioSubtitleDefaultOrderInfoArr.length >= 1) {
            return m4331(subtitleArr, audioSubtitleDefaultOrderInfoArr[0].getSubtitleTrackId());
        }
        C1283.m16865("nf_loc", "Default order info in manifest does not found, this should not happen!");
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Subtitle m4331(Subtitle[] subtitleArr, String str) {
        for (Subtitle subtitle : subtitleArr) {
            if (!(subtitle == null || subtitle.getId() == null || !subtitle.getId().equals(str))) {
                return subtitle;
            }
        }
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static AudioSource m4329(AudioSource[] audioSourceArr, AudioSubtitleDefaultOrderInfo[] audioSubtitleDefaultOrderInfoArr) {
        if (audioSubtitleDefaultOrderInfoArr != null && audioSubtitleDefaultOrderInfoArr.length >= 1) {
            return m4333(audioSourceArr, audioSubtitleDefaultOrderInfoArr[0].getAudioTrackId());
        }
        C1283.m16865("nf_loc", "Default order info in manifest does not found, this should not happen!");
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static AudioSource m4333(AudioSource[] audioSourceArr, String str) {
        for (AudioSource audioSource : audioSourceArr) {
            if (!(audioSource == null || audioSource.getId() == null || !audioSource.getId().equals(str))) {
                return audioSource;
            }
        }
        return null;
    }

    /* renamed from: o.Ca$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        public String f5143;

        /* renamed from: ˋ  reason: contains not printable characters */
        public int f5144;

        /* renamed from: ˎ  reason: contains not printable characters */
        public int f5145;

        /* renamed from: ˏ  reason: contains not printable characters */
        public long f5146;

        /* renamed from: ॱ  reason: contains not printable characters */
        public String f5147;

        public Cif(Language language) {
            if (language == null) {
                throw new IllegalArgumentException("Selected language is null!");
            }
            this.f5146 = System.currentTimeMillis();
            AudioSource selectedAudio = language.getSelectedAudio();
            if (selectedAudio == null) {
                throw new IllegalArgumentException("Selected audio is null!");
            }
            this.f5143 = selectedAudio.getLanguageCodeIso639_1();
            this.f5144 = selectedAudio.getTrackType();
            Subtitle selectedSubtitle = language.getSelectedSubtitle();
            if (selectedSubtitle != null) {
                this.f5147 = selectedSubtitle.getLanguageCodeIso639_1();
                this.f5145 = selectedSubtitle.getTrackType();
            }
        }

        public Cif(JSONObject jSONObject) {
            if (jSONObject == null) {
                throw new IllegalArgumentException("JSON is null!");
            }
            this.f5143 = jSONObject.getString("audioLanguageCodeIso639_1");
            this.f5144 = jSONObject.getInt("audioTrackType");
            this.f5147 = jSONObject.optString("subtitleLanguageCodeIso639_1", null);
            this.f5145 = jSONObject.optInt("subtitleTrackType", 0);
            this.f5146 = jSONObject.getLong("timestamp");
        }

        public String toString() {
            return "SelectedLanguage{timestamp=" + this.f5146 + ", audioLanguageCodeIso639_1='" + this.f5143 + "', audioTrackType=" + this.f5144 + ", subtitleLanguageCodeIso639_1='" + this.f5147 + "', subtitleTrackType=" + this.f5145 + '}';
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public JSONObject m4335() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", this.f5146);
            jSONObject.put("audioLanguageCodeIso639_1", this.f5143);
            jSONObject.put("audioTrackType", this.f5144);
            if (C1349Bv.m4107(this.f5147)) {
                jSONObject.put("subtitleLanguageCodeIso639_1", this.f5147);
                jSONObject.put("subtitleTrackType", this.f5145);
            }
            return jSONObject;
        }
    }
}
