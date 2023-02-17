package com.google.android.exoplayer2.util;

import java.util.Locale;
public class NetflixExoLogUtil {
    public static void Log(String str, Object... objArr) {
        Log.d("NfExo", toMessage(str, objArr));
    }

    private static String toMessage(String str, Object... objArr) {
        if (objArr == null || objArr.length < 1) {
            return str;
        }
        return String.format(Locale.US, str, objArr);
    }

    public static String getTrackType(int i) {
        switch (i) {
            case 1:
                return "Audio";
            case 2:
                return "Video";
            default:
                return "UnknownTrackType(" + i + ")";
        }
    }
}
