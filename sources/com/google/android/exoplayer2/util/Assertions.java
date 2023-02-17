package com.google.android.exoplayer2.util;
public final class Assertions {
    public static void checkArgument(boolean z) {
    }

    public static void checkArgument(boolean z, Object obj) {
    }

    public static int checkIndex(int i, int i2, int i3) {
        if (i >= i2 && i < i3) {
            return i;
        }
        throw new IndexOutOfBoundsException();
    }

    public static void checkState(boolean z) {
    }

    public static void checkState(boolean z, Object obj) {
    }

    public static <T> T checkNotNull(T t) {
        return t;
    }

    public static String checkNotEmpty(String str) {
        return str;
    }
}
