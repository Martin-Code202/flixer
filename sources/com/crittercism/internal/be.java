package com.crittercism.internal;

import java.util.Locale;
public final class be {
    public static final be a = new be();
    private volatile int b = 1;
    private final long c = System.currentTimeMillis();

    private be() {
    }

    private synchronized int b() {
        int i;
        i = this.b;
        this.b = i + 1;
        return i;
    }

    public final String a() {
        return String.format(Locale.US, "%d.%d.%09d", 1, Long.valueOf(this.c), Integer.valueOf(b()));
    }
}
