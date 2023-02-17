package com.netflix.mediaclient.service.webclient.model.leafs;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.servicemgr.interface_.user.ProfileType;
import java.util.ArrayList;
import java.util.List;
import o.AK;
import o.AbstractC2089qj;
import o.C1283;
import o.C1349Bv;
import org.json.JSONException;
import org.json.JSONObject;
public class UserProfile implements AbstractC2089qj {
    private static final String FIELD_AUTHORIZATION_TOKENS = "tokens";
    private static final String FIELD_AUTOPLAY_ON = "autoPlayOn";
    private static final String FIELD_AVATAR_URL = "avatarUrl";
    private static final String FIELD_EPERIENCE = "experienceType";
    private static final String FIELD_GEO_COUNTRY = "geoCountry";
    private static final String FIELD_IQ_ENABLED = "isIqEnabled";
    private static final String FIELD_IS_DEFAULT_KIDS_PROFILE = "isDefaultKidsProfile";
    private static final String FIELD_IS_PRIMARY = "isPrimaryProfile";
    private static final String FIELD_LANGUAGES = "languages";
    private static final String FIELD_MATURITY_LEVEL = "maturityLevel";
    private static final String FIELD_PROFILE_GUID = "profileId";
    private static final String FIELD_PROFILE_NAME = "profileName";
    private static final String FIELD_PROFILE_TOKEN = "userId";
    private static final String FIELD_REQ_COUNTRY = "reqCountry";
    private static final String TAG = "UserProfile";
    public Operation operation;
    public SubtitlePreference subtitlePreference;
    public Summary summary;

    public class Summary {
        private String avatarUrl;
        public ProfileType enumType;
        private String experienceType;
        private String geoCountry;
        private boolean isAutoPlayEnabled;
        private boolean isDefaultKidsProfile;
        private boolean isIqEnabled;
        private boolean isPrimaryProfile;
        public List<Language> languages;
        private int maturityLevel;
        @SerializedName(UserProfile.FIELD_PROFILE_GUID)
        private String profileGuid;
        private String profileName;
        @SerializedName(UserProfile.FIELD_PROFILE_TOKEN)
        private String profileToken;
        private String reqCountry;

        public Summary() {
        }
    }

    public class Operation {
        public String msg;
        public String status;

        public Operation() {
        }
    }

    public class Language {
        public String code;

        public Language(String str) {
            this.code = str;
        }
    }

    @Override // o.AbstractC2089qj
    public String getProfileName() {
        if (this.summary == null) {
            return null;
        }
        return C1349Bv.m4128(this.summary.profileName);
    }

    public boolean isIQEnabled() {
        return this.summary != null && this.summary.isIqEnabled;
    }

    @Override // o.AbstractC2089qj
    public boolean isPrimaryProfile() {
        return this.summary != null && this.summary.isPrimaryProfile;
    }

    @Override // o.AbstractC2089qj
    public boolean isDefaultKidsProfile() {
        return this.summary != null && this.summary.isDefaultKidsProfile;
    }

    @Override // o.AbstractC2089qj
    public boolean isAutoPlayEnabled() {
        return this.summary != null && this.summary.isAutoPlayEnabled;
    }

    public int getMaturityLevel() {
        if (this.summary == null) {
            return -1;
        }
        return this.summary.maturityLevel;
    }

    public String getEperienceType() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.experienceType;
    }

    public String getProfileToken() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.profileToken;
    }

    @Override // o.AbstractC2089qj
    public String getProfileGuid() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.profileGuid;
    }

    @Override // o.AbstractC2089qj
    public String getAvatarUrl() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.avatarUrl;
    }

    @Override // o.AbstractC2089qj
    public ProfileType getProfileType() {
        if (this.summary == null) {
            return ProfileType.STANDARD;
        }
        if (this.summary.enumType == null) {
            this.summary.enumType = ProfileType.create(this.summary.experienceType);
        }
        return this.summary.enumType;
    }

    @Override // o.AbstractC2089qj
    public boolean isKidsProfile() {
        return getProfileType() == ProfileType.JFK;
    }

    public List<String> getLanguagesList() {
        if (this.summary == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Language language : this.summary.languages) {
            arrayList.add(language.code);
        }
        return arrayList;
    }

    @Override // o.AbstractC2089qj
    public String[] getLanguages() {
        if (this.summary == null) {
            return null;
        }
        String[] strArr = new String[this.summary.languages.size()];
        int i = 0;
        for (Language language : this.summary.languages) {
            strArr[i] = language.code;
            i++;
        }
        return strArr;
    }

    @Override // o.AbstractC2089qj
    public String getLanguagesInCsv() {
        if (this.summary == null) {
            return null;
        }
        return TextUtils.join(",", getLanguagesList());
    }

    @Override // o.AbstractC2089qj
    public String getGeoCountry() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.geoCountry;
    }

    public String getReqCountry() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.reqCountry;
    }

    public SubtitlePreference getSubtitlePreference() {
        return this.subtitlePreference;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FIELD_PROFILE_TOKEN, getProfileToken());
            jSONObject.put(FIELD_PROFILE_GUID, getProfileGuid());
            jSONObject.put(FIELD_PROFILE_NAME, getProfileName());
            jSONObject.put(FIELD_MATURITY_LEVEL, getMaturityLevel());
            jSONObject.put(FIELD_IQ_ENABLED, isIQEnabled());
            jSONObject.put(FIELD_IS_PRIMARY, isPrimaryProfile());
            jSONObject.put(FIELD_IS_DEFAULT_KIDS_PROFILE, isDefaultKidsProfile());
            jSONObject.put(FIELD_AUTOPLAY_ON, isAutoPlayEnabled());
            jSONObject.put(FIELD_EPERIENCE, getEperienceType());
            jSONObject.put(FIELD_AVATAR_URL, getAvatarUrl());
            jSONObject.put(FIELD_LANGUAGES, getLanguagesInCsv());
            jSONObject.put(FIELD_GEO_COUNTRY, getGeoCountry());
            jSONObject.put(FIELD_REQ_COUNTRY, getReqCountry());
            if (this.subtitlePreference != null) {
                jSONObject.put(SubtitlePreference.FIELD_SUBTITLE_OVERRIDE, this.subtitlePreference.toString());
            }
        } catch (JSONException e) {
            C1283.m16854(TAG, "failed in json string " + e);
        }
        C1283.m16854(TAG, "user string=" + jSONObject.toString());
        return jSONObject.toString();
    }

    public UserProfile(String str) {
        this.summary = new Summary();
        this.summary.languages = new ArrayList();
        this.operation = new Operation();
        try {
            JSONObject jSONObject = C1349Bv.m4113(str) ? new JSONObject() : new JSONObject(str);
            this.summary.profileToken = AK.m3376(jSONObject, FIELD_PROFILE_TOKEN, (String) null);
            this.summary.profileGuid = AK.m3376(jSONObject, FIELD_PROFILE_GUID, (String) null);
            this.summary.profileName = AK.m3376(jSONObject, FIELD_PROFILE_NAME, (String) null);
            this.summary.maturityLevel = AK.m3386(jSONObject, FIELD_MATURITY_LEVEL, -1);
            this.summary.isIqEnabled = AK.m3381(jSONObject, FIELD_IQ_ENABLED, false);
            this.summary.isPrimaryProfile = AK.m3381(jSONObject, FIELD_IS_PRIMARY, false);
            this.summary.isDefaultKidsProfile = AK.m3381(jSONObject, FIELD_IS_DEFAULT_KIDS_PROFILE, false);
            this.summary.isAutoPlayEnabled = AK.m3381(jSONObject, FIELD_AUTOPLAY_ON, false);
            this.summary.experienceType = AK.m3376(jSONObject, FIELD_EPERIENCE, (String) null);
            this.summary.avatarUrl = AK.m3376(jSONObject, FIELD_AVATAR_URL, (String) null);
            this.summary.geoCountry = AK.m3376(jSONObject, FIELD_GEO_COUNTRY, (String) null);
            this.summary.reqCountry = AK.m3376(jSONObject, FIELD_REQ_COUNTRY, (String) null);
            String r4 = AK.m3376(jSONObject, FIELD_LANGUAGES, (String) null);
            if (C1349Bv.m4107(r4)) {
                for (String str2 : TextUtils.split(r4, ",")) {
                    this.summary.languages.add(new Language(str2));
                }
            }
            String r5 = AK.m3376(jSONObject, SubtitlePreference.FIELD_SUBTITLE_OVERRIDE, (String) null);
            this.subtitlePreference = C1349Bv.m4113(r5) ? null : new SubtitlePreference(r5);
        } catch (JSONException e) {
            C1283.m16854(TAG, "failed to create json string=" + str + " exception =" + e);
        }
    }

    public UserProfile() {
    }
}
