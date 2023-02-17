package org.linphone.tools;

import org.linphone.core.LpConfig;
import org.linphone.mediastream.Log;
public class Lpc2Xml {
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

    public native int convertFile(String str);

    public native int convertString(StringBuffer stringBuffer);

    public native int setLpc(LpConfig lpConfig);

    public Lpc2Xml() {
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

    static boolean isAvailable() {
        return mAvailable;
    }

    static {
        try {
            System.loadLibrary("xml2");
            mAvailable = true;
        } catch (Throwable th) {
            mAvailable = false;
        }
    }
}
