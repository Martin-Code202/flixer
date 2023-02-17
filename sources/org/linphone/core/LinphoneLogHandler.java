package org.linphone.core;
public interface LinphoneLogHandler {
    public static final int Debug = 1;
    public static final int Error = 16;
    public static final int Fatal = 32;
    public static final int Info = 4;
    public static final int Trace = 2;
    public static final int Warn = 8;

    void log(String str, int i, String str2, String str3, Throwable th);
}
