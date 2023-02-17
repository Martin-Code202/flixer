package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.NetflixApplication;
import o.AK;
import o.AbstractC2088qi;
import o.C1283;
import o.C1349Bv;
import org.json.JSONException;
import org.json.JSONObject;
public class User implements AbstractC2088qi {
    private static final String FIELD_AGE_VERIFIED = "ageVerified";
    private static final String FIELD_EMAIL = "email";
    private static final String FIELD_FIRST_NAME = "firstName";
    private static final String FIELD_PROFILE_NAME = "profileName";
    private static final String FIELD_USER_TOKEN = "userId";
    private static final String TAG = "User";
    public EogAlert eogAlert;
    public SubtitlePreference subtitleDefaults;
    public Summary summary = new Summary();
    private UmaAlert umaAlert;

    public class Summary {
        private String email;
        private boolean isAgeVerified;
        private String profileName;
        @SerializedName(User.FIELD_USER_TOKEN)
        private String userToken;

        public Summary() {
        }
    }

    @Override // o.AbstractC2088qi
    public String getEmail() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.email;
    }

    public String getProfileName() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.profileName;
    }

    public String getUserToken() {
        if (this.summary == null) {
            return null;
        }
        return this.summary.userToken;
    }

    public SubtitlePreference getSubtitleDefaults() {
        return this.subtitleDefaults;
    }

    public boolean isAgeVerified() {
        if (this.summary == null) {
            return false;
        }
        return this.summary.isAgeVerified;
    }

    public void setUmaAlert(UmaAlert umaAlert2) {
        this.umaAlert = umaAlert2;
    }

    public UmaAlert getUmaAlert() {
        return this.umaAlert;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FIELD_USER_TOKEN, getUserToken());
            jSONObject.put("email", getEmail());
            jSONObject.put("firstName", getProfileName());
            jSONObject.put(FIELD_AGE_VERIFIED, isAgeVerified());
            if (this.subtitleDefaults != null) {
                jSONObject.put(SubtitlePreference.FIELD_SUBTITLE_OVERRIDE, this.subtitleDefaults.toString());
            }
            if (this.umaAlert != null && !this.umaAlert.isConsumed()) {
                jSONObject.put("umaAlert", NetflixApplication.m222().toJson(this.umaAlert));
            }
            if (this.eogAlert != null && !this.eogAlert.isDirty) {
                jSONObject.put("eogAlert", NetflixApplication.m222().toJson(this.eogAlert));
            }
        } catch (JSONException e) {
            C1283.m16854(TAG, "failed in json string " + e);
        }
        C1283.m16854(TAG, "user string=" + jSONObject.toString());
        return jSONObject.toString();
    }

    public User(String str) {
        try {
            JSONObject jSONObject = C1349Bv.m4113(str) ? new JSONObject() : new JSONObject(str);
            this.summary.userToken = AK.m3376(jSONObject, FIELD_USER_TOKEN, (String) null);
            this.summary.email = AK.m3376(jSONObject, "email", (String) null);
            this.summary.profileName = AK.m3376(jSONObject, FIELD_PROFILE_NAME, (String) null);
            if (C1349Bv.m4113(this.summary.profileName) && jSONObject.has("firstName")) {
                this.summary.profileName = AK.m3376(jSONObject, "firstName", (String) null);
            }
            this.summary.isAgeVerified = AK.m3381(jSONObject, FIELD_AGE_VERIFIED, false);
            String r4 = AK.m3376(jSONObject, SubtitlePreference.FIELD_SUBTITLE_OVERRIDE, (String) null);
            this.subtitleDefaults = C1349Bv.m4113(r4) ? null : new SubtitlePreference(r4);
            String r5 = AK.m3376(jSONObject, "umaAlert", (String) null);
            try {
                this.umaAlert = C1349Bv.m4113(r5) ? null : (UmaAlert) NetflixApplication.m222().fromJson(r5, (Class<Object>) UmaAlert.class);
            } catch (JsonSyntaxException e) {
                C1283.m16854(TAG, "failed to parse uma=" + r5 + " exception =" + e);
            }
            String r6 = AK.m3376(jSONObject, "eogAlert", (String) null);
            try {
                this.eogAlert = C1349Bv.m4113(r6) ? null : (EogAlert) NetflixApplication.m222().fromJson(r6, (Class<Object>) EogAlert.class);
            } catch (JsonSyntaxException e2) {
                C1283.m16854(TAG, "failed to parse uma=" + r5 + " exception =" + e2);
            }
        } catch (JSONException e3) {
            C1283.m16854(TAG, "failed to create json string=" + str + " exception =" + e3);
        }
    }

    public User() {
    }
}
