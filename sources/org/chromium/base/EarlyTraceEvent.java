package org.chromium.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.List;
import java.util.Map;
public class EarlyTraceEvent {
    static List<Event> sCompletedEvents;
    private static final Object sLock = new Object();
    static Map<String, Event> sPendingEvents;
    static volatile int sState = 0;

    private static native void nativeRecordEarlyEvent(String str, long j, long j2, int i, long j3);

    /* access modifiers changed from: package-private */
    public static final class Event {
        static final /* synthetic */ boolean $assertionsDisabled = (!EarlyTraceEvent.class.desiredAssertionStatus());
        final long mBeginThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        final long mBeginTimeNanos = elapsedRealtimeNanos();
        long mEndThreadTimeMillis;
        long mEndTimeNanos;
        final String mName;
        final int mThreadId = Process.myTid();

        Event(String str) {
            this.mName = str;
        }

        /* access modifiers changed from: package-private */
        public void end() {
            if (!$assertionsDisabled && this.mEndTimeNanos != 0) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.mEndThreadTimeMillis == 0) {
                this.mEndTimeNanos = elapsedRealtimeNanos();
                this.mEndThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: private */
        @SuppressLint({"NewApi"})
        public static long elapsedRealtimeNanos() {
            if (Build.VERSION.SDK_INT >= 17) {
                return SystemClock.elapsedRealtimeNanos();
            }
            return SystemClock.elapsedRealtime() * 1000000;
        }
    }

    static void disable() {
        synchronized (sLock) {
            if (sState == 1) {
                sState = 2;
                maybeFinishLocked();
            }
        }
    }

    static boolean isActive() {
        int i = sState;
        return i == 1 || i == 2;
    }

    public static void begin(String str) {
        Event put;
        if (sState == 1) {
            Event event = new Event(str);
            synchronized (sLock) {
                if (sState == 1) {
                    put = sPendingEvents.put(str, event);
                } else {
                    return;
                }
            }
            if (put != null) {
                throw new IllegalArgumentException("Multiple pending trace events can't have the same name");
            }
        }
    }

    public static void end(String str) {
        if (isActive()) {
            synchronized (sLock) {
                if (isActive()) {
                    Event remove = sPendingEvents.remove(str);
                    if (remove != null) {
                        remove.end();
                        sCompletedEvents.add(remove);
                        if (sState == 2) {
                            maybeFinishLocked();
                        }
                    }
                }
            }
        }
    }

    private static void maybeFinishLocked() {
        if (sPendingEvents.isEmpty()) {
            sState = 3;
            dumpEvents(sCompletedEvents);
            sCompletedEvents = null;
            sPendingEvents = null;
        }
    }

    private static void dumpEvents(List<Event> list) {
        long nativeGetTimeTicksNowUs = (TimeUtils.nativeGetTimeTicksNowUs() * 1000) - Event.elapsedRealtimeNanos();
        for (Event event : list) {
            nativeRecordEarlyEvent(event.mName, event.mBeginTimeNanos + nativeGetTimeTicksNowUs, event.mEndTimeNanos + nativeGetTimeTicksNowUs, event.mThreadId, event.mEndThreadTimeMillis - event.mBeginThreadTimeMillis);
        }
    }
}
