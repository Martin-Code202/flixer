package com.google.android.gms.cast.framework;

import java.util.Locale;
public final class CastState {
    public static String toString(int i) {
        switch (i) {
            case 1:
                return "NO_DEVICES_AVAILABLE";
            case 2:
                return "NOT_CONNECTED";
            case 3:
                return "CONNECTING";
            case 4:
                return "CONNECTED";
            default:
                return String.format(Locale.ROOT, "UNKNOWN_STATE(%d)", Integer.valueOf(i));
        }
    }
}
