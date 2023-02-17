package org.linphone.mediastream;
public final class Log {
    private static Log logger;

    private native void d(String str);

    private native void e(String str);

    private native void i(String str);

    private native void w(String str);

    private static Log instance() {
        if (logger == null) {
            logger = new Log();
        }
        return logger;
    }

    private Log() {
    }

    @Deprecated
    public Log(String str, boolean z) {
    }

    public static void d(Object... objArr) {
        instance().d(toString(objArr));
    }

    public static void i(Object... objArr) {
        instance().i(toString(objArr));
    }

    public static void w(Object... objArr) {
        instance().w(toString(objArr));
    }

    public static void e(Object... objArr) {
        instance().e(toString(objArr));
    }

    private static String toString(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb.toString();
    }
}
