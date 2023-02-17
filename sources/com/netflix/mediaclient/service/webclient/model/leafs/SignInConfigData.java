package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.HashMap;
import o.AE;
import o.C1349Bv;
public class SignInConfigData {
    private static final int MAX_EMAIL_LEN = 50;
    private static final int MAX_PWD_LEN = 50;
    private static final int MIN_EMAIL_LEN = 5;
    private static final int MIN_PWD_LEN = 4;
    private static final String TAG = "nf_config_signin";
    @SerializedName("fields")
    public Fields fields;
    @SerializedName("flwssn")
    public String flwssn;
    @SerializedName("mode")
    public String nextStep;

    public class Fields {
        @SerializedName("backAction")
        public CachedMode backAction;
        @SerializedName(SignupConstants.Field.EMAIL)
        public Rules email;
        @SerializedName("isPortraitLocked")
        public BooleanField isPortraitLocked;
        @SerializedName(SignupConstants.Field.PASSWORD)
        public Rules password;
        @SerializedName(SignupConstants.Mode.SIGNUP_BLOCKED)
        public BooleanField signupBlocked;
        @SerializedName("useAndroidNative")
        public BooleanField useAndroidNative;
        @SerializedName("useDarkHeader")
        public BooleanField useDarkHeader;

        public Fields() {
        }
    }

    public class Rules {
        @SerializedName("fieldType")
        public String fieldType;
        @SerializedName("maxLength")
        public int maxLength;
        @SerializedName("minLength")
        public int minLength;

        public Rules() {
        }
    }

    public class BooleanField {
        @SerializedName("value")
        public Boolean value;

        public BooleanField() {
        }
    }

    public class CachedMode {
        @SerializedName("cached")
        public HashMap<String, Object> cached;
        @SerializedName("hidden")
        public boolean hidden;

        public CachedMode() {
        }
    }

    public static SignInConfigData fromJsonString(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return (SignInConfigData) AE.m3322().fromJson(str, (Class<Object>) SignInConfigData.class);
    }

    public String toJsonString() {
        return AE.m3322().toJson(this);
    }

    private int getMinEmailLen() {
        if (this.fields == null || this.fields.email == null || this.fields.email.minLength <= 0) {
            return 5;
        }
        return this.fields.email.minLength;
    }

    private int getMaxEmailLen() {
        if (this.fields == null || this.fields.email == null || this.fields.email.maxLength <= 0) {
            return 50;
        }
        return this.fields.email.maxLength;
    }

    private int getMinPwdLen() {
        if (this.fields == null || this.fields.password == null || this.fields.password.minLength <= 0) {
            return 4;
        }
        return this.fields.password.minLength;
    }

    private int getMaxPwdLen() {
        if (this.fields == null || this.fields.password == null || this.fields.password.maxLength <= 0) {
            return 50;
        }
        return this.fields.password.maxLength;
    }

    public boolean isEmailValid(String str) {
        return !C1349Bv.m4113(str) && str.length() >= getMinEmailLen();
    }

    public boolean isPasswordValid(String str) {
        return !C1349Bv.m4113(str) && str.length() >= getMinPwdLen();
    }

    public boolean isPortraitLocked() {
        if (this.fields == null || this.fields.isPortraitLocked == null || this.fields.isPortraitLocked.value == null) {
            return false;
        }
        return this.fields.isPortraitLocked.value.booleanValue();
    }

    public boolean isAndroidNative() {
        if (this.fields == null || this.fields.useAndroidNative == null || this.fields.useAndroidNative.value == null) {
            return false;
        }
        return this.fields.useAndroidNative.value.booleanValue();
    }

    public boolean useDarkHeader() {
        if (this.fields == null || this.fields.useDarkHeader == null || this.fields.useDarkHeader.value == null) {
            return false;
        }
        return this.fields.useDarkHeader.value.booleanValue();
    }

    public boolean isSignupBlocked() {
        if (this.fields == null || this.fields.signupBlocked == null || this.fields.signupBlocked.value == null) {
            return false;
        }
        return this.fields.signupBlocked.value.booleanValue();
    }
}
