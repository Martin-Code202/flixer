package com.netflix.mediaclient.servicemgr;
public interface SignInLogging {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final String[] f2660 = {"com.netflix.mediaclient.intent.action.LOG_SIGNIN_START", "com.netflix.mediaclient.intent.action.LOG_SIGNIN_ENDED", "com.netflix.mediaclient.intent.action.LOG_SIGNIN_CREDENTIAL_RETRIEVAL_START", "com.netflix.mediaclient.intent.action.LOG_SIGNIN_CREDENTIAL_RETRIEVAL_ENDED", "com.netflix.mediaclient.intent.action.LOG_SIGNIN_CREDENTIAL_SAVE_START", "com.netflix.mediaclient.intent.action.LOG_SIGNIN_CREDENTIAL_SAVE_ENDED"};

    public enum CredentialSaved {
        notSupported,
        userDeclined,
        saved,
        failed
    }

    public enum CredentialService {
        GooglePlayService
    }

    public enum SignInType {
        emailPassword,
        tokenActivate,
        smartLock,
        autologin
    }
}
