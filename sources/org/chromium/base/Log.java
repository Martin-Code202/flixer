package org.chromium.base;

import java.util.Locale;
import org.chromium.base.annotations.RemovableInRelease;
public class Log {
    private Log() {
    }

    private static String formatLog(String str, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return str;
        }
        return String.format(Locale.US, str, objArr);
    }

    public static String normalizeTag(String str) {
        if (str.startsWith("cr_")) {
            return str;
        }
        int i = 0;
        if (str.startsWith("cr.")) {
            i = "cr.".length();
        }
        return "cr_" + str.substring(i, str.length());
    }

    private static String formatLogWithStack(String str, Object... objArr) {
        return "[" + getCallOrigin() + "] " + formatLog(str, objArr);
    }

    public static boolean isLoggable(String str, int i) {
        return android.util.Log.isLoggable(str, i);
    }

    private static void debug(String str, String str2, Object... objArr) {
        String formatLogWithStack = formatLogWithStack(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.d(normalizeTag(str), formatLogWithStack, throwableToLog);
        } else {
            android.util.Log.d(normalizeTag(str), formatLogWithStack);
        }
    }

    @RemovableInRelease
    public static void d(String str, String str2) {
        debug(str, str2, new Object[0]);
    }

    @RemovableInRelease
    public static void d(String str, String str2, Object obj) {
        debug(str, str2, obj);
    }

    public static void i(String str, String str2, Object... objArr) {
        String formatLog = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.i(normalizeTag(str), formatLog, throwableToLog);
        } else {
            android.util.Log.i(normalizeTag(str), formatLog);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        String formatLog = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.w(normalizeTag(str), formatLog, throwableToLog);
        } else {
            android.util.Log.w(normalizeTag(str), formatLog);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        String formatLog = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.e(normalizeTag(str), formatLog, throwableToLog);
        } else {
            android.util.Log.e(normalizeTag(str), formatLog);
        }
    }

    private static Throwable getThrowableToLog(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (!(obj instanceof Throwable)) {
            return null;
        }
        return (Throwable) obj;
    }

    private static String getCallOrigin() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Log.class.getName();
        int i = 0;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            } else if (stackTrace[i].getClassName().equals(name)) {
                i += 4;
                break;
            } else {
                i++;
            }
        }
        return stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber();
    }
}
