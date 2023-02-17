package com.crittercism.internal;
public enum ce {
    StrictModeDeviceId,
    StrictModeSessionId,
    NoTLSContext,
    TLSContextInit,
    NegativeLifecycleUserflowTime;
    
    private static String f = ("5.8.7".replace(".", "-") + "-");

    public final String a() {
        return "error " + (f + Integer.toString(ordinal())) + "; Please report this to support@apteligent.com.";
    }
}
