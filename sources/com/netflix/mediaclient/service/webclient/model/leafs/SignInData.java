package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
import o.C1349Bv;
public class SignInData {
    public static final String ERROR_ACCOUNT_PASSWORD_NOT_SET = "account_password_not_set";
    public static final String ERROR_DVD_MEMBER_REDIRECT = "dvd_member_redirect";
    public static final String ERROR_FORMER_MEMBER_CONSUMPTION = "former_member_consumption_only";
    public static final String ERROR_FORMER_MEMBER_REDIRECT = "former_member_redirect";
    public static final String ERROR_INCORRECT_PASSWORD = "incorrect_password";
    public static final String ERROR_NEVER_MEMBER_CONSUMPTION = "never_member_consumption_only";
    public static final String ERROR_NEVER_MEMBER_REDIRECT = "never_member_redirect";
    public static final String ERROR_THROTTLING = "throttling_failure";
    public static final String ERROR_UNRECOGNIZED_CONSUMPTION = "unrecognized_email_consumption_only";
    public static final String ERROR_UNRECOGNIZED_EMAIL = "unrecognized_email";
    public static final String ERROR_UNRECOGNIZED_REDIRECT = "unrecognized_email_redirect";
    public static final String FIELD_ERROR_CODE = "errorCode";
    public static final String FIELD_FIELDS = "fields";
    public static final String FIELD_FLOW = "flow";
    public static final String FIELD_FLWSSN = "flwssn";
    public static final String FIELD_MODE = "mode";
    public static final String FIELD_VALUE = "value";
    public static final String FLOW_CLIENT = "client";
    public static final String MODE_ENTER_CREDENTIALS = "enterMemberCredentials";
    public static final String MODE_MEMBER_HOME = "memberHome";
    public static final String MODE_WELCOME = "welcome";
    public static final String TAG = "nf_signin";
    public AuthorizationCredentials authorizationCredentials;
    @SerializedName("fields")
    public Fields fields;
    @SerializedName("flow")
    public String flow;
    @SerializedName("flwssn")
    public String flwssn;
    @SerializedName("mode")
    public String mode;

    public String toString() {
        return "SignInData{mode='" + this.mode + "', flow='" + this.flow + "', flwssn='" + this.flwssn + "', fields=" + this.fields + ", authorizationCredentials=" + this.authorizationCredentials + '}';
    }

    /* access modifiers changed from: package-private */
    public class Fields {
        @SerializedName("errorCode")
        public ErrorCode errorCode;

        Fields() {
        }
    }

    /* access modifiers changed from: package-private */
    public class ErrorCode {
        @SerializedName("value")
        public String value;

        ErrorCode() {
        }
    }

    public boolean isSignInSuccessful() {
        return C1349Bv.m4126(FLOW_CLIENT, this.flow) && C1349Bv.m4126("memberHome", this.mode);
    }

    public boolean shouldRetrySignIn() {
        return C1349Bv.m4126("enterMemberCredentials", this.mode);
    }

    public boolean shouldTrySignUp() {
        return C1349Bv.m4126("welcome", this.mode);
    }

    public boolean isThrottled() {
        return (this.fields == null || this.fields.errorCode == null || !ERROR_THROTTLING.equals(this.fields.errorCode.value)) ? false : true;
    }

    public boolean isEmailUnrecognised() {
        return (this.fields == null || this.fields.errorCode == null || !ERROR_UNRECOGNIZED_EMAIL.equals(this.fields.errorCode.value)) ? false : true;
    }

    public boolean isPasswordIncorrect() {
        return (this.fields == null || this.fields.errorCode == null || !ERROR_INCORRECT_PASSWORD.equals(this.fields.errorCode.value)) ? false : true;
    }

    public boolean isAccountWithNoPasswordSet() {
        return (this.fields == null || this.fields.errorCode == null || !ERROR_ACCOUNT_PASSWORD_NOT_SET.equals(this.fields.errorCode.value)) ? false : true;
    }

    public boolean isConsumptionOnlyFormerMember() {
        return (this.fields == null || this.fields.errorCode == null || !ERROR_FORMER_MEMBER_CONSUMPTION.equals(this.fields.errorCode.value)) ? false : true;
    }

    public boolean isRedirectOnlyFormerMember() {
        return (this.fields == null || this.fields.errorCode == null || !ERROR_FORMER_MEMBER_REDIRECT.equals(this.fields.errorCode.value)) ? false : true;
    }

    public boolean isConsumptionOnlyNeverMember() {
        return (this.fields == null || this.fields.errorCode == null || !ERROR_NEVER_MEMBER_CONSUMPTION.equals(this.fields.errorCode.value)) ? false : true;
    }

    public boolean isRedirectOnlyNeverMember() {
        return (this.fields == null || this.fields.errorCode == null || !ERROR_NEVER_MEMBER_REDIRECT.equals(this.fields.errorCode.value)) ? false : true;
    }

    public boolean isRedirectOnlyDVDMember() {
        return (this.fields == null || this.fields.errorCode == null || !ERROR_DVD_MEMBER_REDIRECT.equals(this.fields.errorCode.value)) ? false : true;
    }

    public boolean isConsumptionOnlyUnrecognizedEmail() {
        return (this.fields == null || this.fields.errorCode == null || !ERROR_UNRECOGNIZED_CONSUMPTION.equals(this.fields.errorCode.value)) ? false : true;
    }

    public boolean isRedirectOnlyUnrecognizedEmail() {
        return (this.fields == null || this.fields.errorCode == null || !ERROR_UNRECOGNIZED_REDIRECT.equals(this.fields.errorCode.value)) ? false : true;
    }

    public boolean isValid() {
        return this.authorizationCredentials != null && this.authorizationCredentials.isValid();
    }
}
