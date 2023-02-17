package com.netflix.mediaclient.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o.C1283;
import o.C1346Bs;
import o.uR;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class Language {
    private static final String JSON_AUDIO_ARRAY = "audio_array";
    private static final String JSON_CURRENT_NCCP_AUDIO_INDEX = "CurrentNccpAudioIndex";
    private static final String JSON_CURRENT_NCCP_SUBTITLE_INDEX = "CurrentNccpSubtitleIndex";
    private static final String JSON_PREVIOUS_NCCP_AUDIO_INDEX = "PreviousNccpAudioIndex";
    private static final String JSON_PREVIOUS_NCCP_SUBTITLE_INDEX = "PreviousNccpSubtitleIndex";
    private static final String JSON_SUBTITLE_ARRAY = "subtitle_array";
    private static final String JSON_SUBTITLE_VISIBLE = "subtitle_visible";
    private static final String OFF_SUBTITLE_TRACK_DESC = "Off";
    private static final String TAG = "nf_language";
    private AudioSource[] mAltAudios;
    private int mCurrentNccpAudioIndex;
    private int mCurrentNccpSubtitleIndex;
    private int mPreviousNccpAudioIndex = 0;
    private int mPreviousNccpSubtitleIndex = -1;
    private AudioSource mSelectedAudio;
    private Subtitle mSelectedSubtitle;
    private boolean mSubtitleVisible;
    private Subtitle[] mSubtitles;
    private final List<Subtitle> mUsedSubtitles = new ArrayList();

    public Language(AudioSource[] audioSourceArr, int i, Subtitle[] subtitleArr, int i2, boolean z) {
        this.mCurrentNccpAudioIndex = i;
        if (audioSourceArr != null) {
            dedupAudioTrackOnLanguageDescription(audioSourceArr, i);
        } else {
            this.mAltAudios = new AudioSource[0];
        }
        if (subtitleArr != null) {
            this.mSubtitles = subtitleArr;
        } else {
            this.mSubtitles = new Subtitle[0];
        }
        this.mSubtitleVisible = z;
        this.mCurrentNccpSubtitleIndex = i2;
    }

    private void dedupAudioTrackOnLanguageDescription(AudioSource[] audioSourceArr, int i) {
        Arrays.sort(audioSourceArr);
        ArrayList arrayList = new ArrayList();
        String str = new String();
        int i2 = -1;
        for (AudioSource audioSource : audioSourceArr) {
            audioSource.getLanguageDescription();
            if (!str.equals(audioSource.getLanguageDescription())) {
                arrayList.add(audioSource);
                str = audioSource.getLanguageDescription();
                i2 = audioSource.getNccpOrderNumber();
            }
            if (i2 != -1 && audioSource.nccpOrderNumber == i) {
                this.mCurrentNccpAudioIndex = i2;
            }
        }
        this.mAltAudios = (AudioSource[]) arrayList.toArray(new AudioSource[0]);
    }

    public Subtitle[] getSubtitles() {
        return this.mSubtitles;
    }

    public AudioSource[] getAltAudios() {
        return this.mAltAudios;
    }

    public boolean isSubtitleVisible() {
        return this.mSubtitleVisible;
    }

    public int getCurrentNccpSubtitleIndex() {
        return this.mCurrentNccpSubtitleIndex;
    }

    public int getCurrentNccpAudioIndex() {
        return this.mCurrentNccpAudioIndex;
    }

    public boolean isLanguageSwitchEnabled() {
        if (this.mSubtitles != null && this.mSubtitles.length > 0) {
            return true;
        }
        if (this.mAltAudios == null || this.mAltAudios.length <= 1) {
            return false;
        }
        return true;
    }

    private static AudioSource getAudioSource(AudioSource[] audioSourceArr, int i) {
        if (audioSourceArr == null) {
            C1283.m16850(TAG, "Audios are null!");
            return null;
        }
        for (AudioSource audioSource : audioSourceArr) {
            if (audioSource.getNccpOrderNumber() == i) {
                C1283.m16854(TAG, "Found!");
                return audioSource;
            }
        }
        return null;
    }

    public Subtitle getCurrentSubtitle() {
        if (this.mSubtitleVisible || this.mCurrentNccpSubtitleIndex != -1) {
            return getSubtitle(this.mSubtitles, this.mCurrentNccpSubtitleIndex);
        }
        return null;
    }

    public AudioSource getCurrentAudioSource() {
        return getAudioSource(this.mAltAudios, this.mCurrentNccpAudioIndex);
    }

    private AudioSource getAudioSourceByPosition(int i) {
        if (i >= 0 && i < this.mAltAudios.length) {
            return this.mAltAudios[i];
        }
        C1283.m16850(TAG, "getAudioSourceByIndex: position invalid: " + i);
        return null;
    }

    private static Subtitle getSubtitle(Subtitle[] subtitleArr, int i) {
        if (subtitleArr == null) {
            C1283.m16850(TAG, "Subtitles are null!");
            return null;
        }
        for (Subtitle subtitle : subtitleArr) {
            if (subtitle.getNccpOrderNumber() == i) {
                C1283.m16854(TAG, "Found!");
                return subtitle;
            }
        }
        return null;
    }

    public AudioSource getSelectedAudio() {
        return this.mSelectedAudio;
    }

    public AudioSource setSelectedAudio(AudioSource audioSource) {
        this.mSelectedAudio = audioSource;
        updateUsedSubtitles(this.mSelectedAudio);
        return this.mSelectedAudio;
    }

    private void updateUsedSubtitles(AudioSource audioSource) {
        this.mUsedSubtitles.clear();
        if (audioSource == null || (!isOffSubtitleAvailable(audioSource) && audioSource.isAllowedSubtitle(null))) {
            this.mUsedSubtitles.add(null);
        } else if (this.mSubtitles == null || countAllowedSubtitles(this.mSubtitles, audioSource) < 1) {
            this.mUsedSubtitles.add(null);
        }
        if (this.mSubtitles != null) {
            Subtitle[] subtitleArr = this.mSubtitles;
            for (Subtitle subtitle : subtitleArr) {
                if (audioSource == null || audioSource.isAllowedSubtitle(subtitle)) {
                    this.mUsedSubtitles.add(subtitle);
                }
            }
        }
    }

    public Subtitle getSelectedSubtitle() {
        return this.mSelectedSubtitle;
    }

    public Subtitle setSelectedSubtitle(Subtitle subtitle) {
        for (int i = 0; i < this.mUsedSubtitles.size(); i++) {
            if (this.mUsedSubtitles.get(i) == null && subtitle == null) {
                this.mSelectedSubtitle = null;
                return null;
            } else if (this.mUsedSubtitles.get(i) == subtitle) {
                this.mSelectedSubtitle = subtitle;
                return this.mSelectedSubtitle;
            }
        }
        C1283.m16865(TAG, "We tried to select subtitle that is NOT in list of used subtitles!");
        return null;
    }

    public void commit() {
        this.mPreviousNccpAudioIndex = this.mCurrentNccpAudioIndex;
        if (this.mSelectedAudio != null) {
            this.mCurrentNccpAudioIndex = this.mSelectedAudio.getNccpOrderNumber();
        }
        this.mPreviousNccpSubtitleIndex = this.mCurrentNccpSubtitleIndex;
        if (this.mSelectedSubtitle != null) {
            this.mCurrentNccpSubtitleIndex = this.mSelectedSubtitle.getNccpOrderNumber();
            if (this.mSelectedSubtitle.getLanguageDescription().equals(OFF_SUBTITLE_TRACK_DESC)) {
                this.mSubtitleVisible = false;
            } else {
                this.mSubtitleVisible = true;
            }
        } else {
            this.mCurrentNccpSubtitleIndex = -1;
            this.mSubtitleVisible = false;
        }
    }

    public List<Subtitle> getUsedSubtitles() {
        return this.mUsedSubtitles;
    }

    private static int countAllowedSubtitles(Subtitle[] subtitleArr, AudioSource audioSource) {
        if (audioSource == null || subtitleArr == null || subtitleArr.length < 1) {
            return 0;
        }
        int i = 0;
        for (Subtitle subtitle : subtitleArr) {
            if (audioSource.isAllowedSubtitle(subtitle)) {
                i++;
            }
        }
        return i;
    }

    public void restorePreviousSubtitle() {
        Subtitle subtitle = null;
        if (this.mPreviousNccpSubtitleIndex > -1) {
            subtitle = getSubtitle(getSubtitles(), this.mPreviousNccpSubtitleIndex);
        }
        this.mSelectedSubtitle = subtitle;
        this.mPreviousNccpSubtitleIndex = -1;
    }

    public void restorePreviousAudio() {
        if (this.mPreviousNccpAudioIndex < 0) {
            C1283.m16850(TAG, "This should not happen!");
        } else if (setSelectedAudio(getAudioSource(getAltAudios(), this.mPreviousNccpAudioIndex)) == null) {
            C1283.m16865(TAG, "Unable to restore to previous audio. Not allowed!");
        } else {
            this.mPreviousNccpAudioIndex = 0;
        }
    }

    public String toString() {
        return "Language [mSubtitles=" + Arrays.toString(this.mSubtitles) + ", mAltAudios=" + Arrays.toString(this.mAltAudios) + ", mSubtitleVisible=" + this.mSubtitleVisible + ", mCurrentNccpSubtitleIndex=" + this.mCurrentNccpSubtitleIndex + ", mCurrentNccpAudioIndex=" + this.mCurrentNccpAudioIndex + ", mPreviousNccpSubtitleIndex=" + this.mPreviousNccpSubtitleIndex + ", mPreviousNccpAudioIndex=" + this.mPreviousNccpAudioIndex + ", mUsedSubtitles=" + this.mUsedSubtitles + ", mSelectedAudio=" + this.mSelectedAudio + ", mSelectedSubtitle=" + this.mSelectedSubtitle + "]";
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JSON_CURRENT_NCCP_AUDIO_INDEX, this.mCurrentNccpAudioIndex);
        jSONObject.put(JSON_CURRENT_NCCP_SUBTITLE_INDEX, this.mCurrentNccpSubtitleIndex);
        jSONObject.put(JSON_PREVIOUS_NCCP_AUDIO_INDEX, this.mPreviousNccpAudioIndex);
        jSONObject.put(JSON_PREVIOUS_NCCP_SUBTITLE_INDEX, this.mPreviousNccpSubtitleIndex);
        jSONObject.put(JSON_SUBTITLE_VISIBLE, this.mSubtitleVisible);
        if (this.mSubtitles != null && this.mSubtitles.length > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.mSubtitles.length; i++) {
                jSONArray.put(this.mSubtitles[i].toJson());
            }
            jSONObject.put(JSON_SUBTITLE_ARRAY, jSONArray);
        }
        if (this.mAltAudios != null && this.mAltAudios.length > 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < this.mAltAudios.length; i2++) {
                jSONArray2.put(this.mAltAudios[i2].toJson());
            }
            jSONObject.put(JSON_AUDIO_ARRAY, jSONArray2);
        }
        return jSONObject.toString();
    }

    public static Language restoreLanguage(String str) {
        JSONObject jSONObject = new JSONObject(str);
        int i = jSONObject.getInt(JSON_CURRENT_NCCP_SUBTITLE_INDEX);
        int i2 = jSONObject.getInt(JSON_CURRENT_NCCP_AUDIO_INDEX);
        int i3 = jSONObject.getInt(JSON_CURRENT_NCCP_SUBTITLE_INDEX);
        int i4 = jSONObject.getInt(JSON_CURRENT_NCCP_AUDIO_INDEX);
        boolean z = jSONObject.getBoolean(JSON_SUBTITLE_VISIBLE);
        JSONArray optJSONArray = jSONObject.optJSONArray(JSON_AUDIO_ARRAY);
        JSONArray optJSONArray2 = jSONObject.optJSONArray(JSON_SUBTITLE_ARRAY);
        Subtitle[] subtitleArr = null;
        AudioSource[] audioSourceArr = null;
        if (optJSONArray2 != null) {
            subtitleArr = new Subtitle[optJSONArray2.length()];
            for (int i5 = 0; i5 < subtitleArr.length; i5++) {
                subtitleArr[i5] = C1346Bs.m4083(optJSONArray2.getJSONObject(i5));
            }
        }
        if (optJSONArray != null) {
            audioSourceArr = new AudioSource[optJSONArray.length()];
            for (int i6 = 0; i6 < audioSourceArr.length; i6++) {
                audioSourceArr[i6] = restore(optJSONArray.getJSONObject(i6));
            }
        }
        Language language = new Language(audioSourceArr, i2, subtitleArr, i, z);
        language.mPreviousNccpAudioIndex = i4;
        language.mPreviousNccpSubtitleIndex = i3;
        return language;
    }

    private boolean isOffSubtitleAvailable(AudioSource audioSource) {
        Subtitle[] subtitleArr = this.mSubtitles;
        for (Subtitle subtitle : subtitleArr) {
            if (subtitle.isForcedNarrativeOrNone() && audioSource.isAllowedSubtitle(subtitle)) {
                return true;
            }
        }
        return false;
    }

    private static AudioSource restore(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt(BaseSubtitle.IMPL, -1);
        if (optInt == 2) {
            return uR.m11649(jSONObject, jSONObject.getInt(BaseSubtitle.ATTR_ORDER));
        }
        if (optInt == 1) {
            return NccpAudioSource.newInstance(jSONObject, jSONObject.getInt(BaseSubtitle.ATTR_ORDER));
        }
        throw new JSONException("Implementation does not support restore " + optInt);
    }
}
