package com.netflix.mediaclient.servicemgr;
public interface CustomerServiceLogging {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final String[] f2419 = {"com.netflix.mediaclient.intent.action.LOG_CS_HELP_SESSION_START", "com.netflix.mediaclient.intent.action.LOG_CS_HELP_SESSION_ENDED", "com.netflix.mediaclient.intent.action.LOG_CS_CALL_SESSION_START", "com.netflix.mediaclient.intent.action.LOG_CS_CALL_SESSION_ENDED", "com.netflix.mediaclient.intent.action.LOG_CS_CALL_SESSION_QUALITY_CHANGED", "com.netflix.mediaclient.intent.action.LOG_CS_CALL_CONNECTED", "com.netflix.mediaclient.intent.action.LOG_CS_CALL_UI_EXIT", "com.netflix.mediaclient.intent.action.LOG_CS_CALL_UI_BACK_TO"};

    public enum Action {
        url,
        dial,
        chat,
        back,
        home,
        up
    }

    public enum CallQuality {
        red,
        yellow,
        green
    }

    public enum EntryPoint {
        nonMemberLanding,
        login,
        appMenu,
        returnTo,
        notification,
        errorDialog,
        profileGate
    }

    public enum ReturnToDialScreenFrom {
        fab,
        notification,
        login,
        nml,
        menu
    }

    public enum Sdk {
        vail,
        direct
    }

    public enum TerminationReason {
        canceledByUserBeforeConnected,
        canceledByUserAfterConnected,
        canceledByNetflix,
        failedBeforeConnected,
        failedAfterConnected
    }
}
