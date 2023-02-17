package org.linphone.tools;

import org.linphone.core.LpConfig;
import org.linphone.mediastream.Log;
public class Xml2Lpc {
    private static boolean mAvailable;
    private long internalPtr = 0;

    enum LogLevel {
        DEBUG,
        MESSAGE,
        WARNING,
        ERROR
    }

    private native void destroy();

    private native void init();

    public native int convert(LpConfig lpConfig);

    public native int setXmlFile(String str);

    public native int setXmlString(String str);

    public native int setXsdFile(String str);

    public native int setXsdString(String str);

    public native int validate();

    public Xml2Lpc() {
        init();
    }

    public void finalize() {
        destroy();
    }

    public void printLog(int i, String str) {
        if (i > 0 && i < LogLevel.values().length) {
            switch (LogLevel.values()[i]) {
                case DEBUG:
                    Log.d(str);
                    return;
                case MESSAGE:
                    Log.i(str);
                    return;
                case WARNING:
                    Log.w(str);
                    return;
                case ERROR:
                    Log.e(str);
                    return;
                default:
                    return;
            }
        }
    }

    public static boolean isAvailable() {
        return mAvailable;
    }

    static {
        try {
            new Xml2Lpc();
            mAvailable = true;
        } catch (Throwable th) {
            mAvailable = false;
        }
    }
}
