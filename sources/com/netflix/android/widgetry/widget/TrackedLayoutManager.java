package com.netflix.android.widgetry.widget;

import java.util.Locale;
public interface TrackedLayoutManager {
    /* renamed from: ˊ */
    String mo104();

    /* renamed from: ˏ */
    void mo105(String str);

    public static class TrackedLayoutManagerException extends RuntimeException {
        public TrackedLayoutManagerException(IndexOutOfBoundsException indexOutOfBoundsException, String str) {
            super(String.format(Locale.US, "%s in %s", indexOutOfBoundsException.getMessage(), str), indexOutOfBoundsException);
        }
    }
}
