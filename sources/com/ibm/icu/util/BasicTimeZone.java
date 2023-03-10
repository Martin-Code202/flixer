package com.ibm.icu.util;
public abstract class BasicTimeZone extends TimeZone {
    private static final long serialVersionUID = -3204278532246180932L;

    public abstract TimeZoneTransition getNextTransition(long j, boolean z);

    public abstract TimeZoneTransition getPreviousTransition(long j, boolean z);

    @Deprecated
    public void getOffsetFromLocal(long j, int i, int i2, int[] iArr) {
        throw new IllegalStateException("Not implemented");
    }

    protected BasicTimeZone() {
    }

    @Deprecated
    protected BasicTimeZone(String str) {
        super(str);
    }
}
