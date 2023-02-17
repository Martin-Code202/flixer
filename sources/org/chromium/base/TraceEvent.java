package org.chromium.base;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import org.chromium.base.annotations.CalledByNative;
public class TraceEvent {
    private static volatile boolean sATraceEnabled;
    private static volatile boolean sEnabled;

    static final class LooperMonitorHolder {
        private static final BasicLooperMonitor sInstance = (CommandLine.getInstance().hasSwitch("enable-idle-tracing") ? new IdleTracingLooperMonitor() : new BasicLooperMonitor());
    }

    private static native void nativeBegin(String str, String str2);

    /* access modifiers changed from: private */
    public static native void nativeBeginToplevel(String str);

    private static native void nativeEnd(String str, String str2);

    /* access modifiers changed from: private */
    public static native void nativeEndToplevel();

    private static native void nativeFinishAsync(String str, long j);

    private static native void nativeInstant(String str, String str2);

    private static native void nativeRegisterEnabledObserver();

    private static native void nativeStartATrace();

    private static native void nativeStartAsync(String str, long j);

    private static native void nativeStopATrace();

    /* access modifiers changed from: package-private */
    public static class BasicLooperMonitor implements Printer {
        static final /* synthetic */ boolean $assertionsDisabled = (!TraceEvent.class.desiredAssertionStatus());

        private BasicLooperMonitor() {
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (str.startsWith(">")) {
                beginHandling(str);
            } else if ($assertionsDisabled || str.startsWith("<")) {
                endHandling(str);
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public void beginHandling(String str) {
            boolean isActive = EarlyTraceEvent.isActive();
            if (TraceEvent.sEnabled || isActive) {
                String target = getTarget(str);
                if (TraceEvent.sEnabled) {
                    TraceEvent.nativeBeginToplevel(target);
                } else if (isActive) {
                    EarlyTraceEvent.begin("Looper.dispatchMessage: " + target);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void endHandling(String str) {
            if (EarlyTraceEvent.isActive()) {
                EarlyTraceEvent.end("Looper.dispatchMessage: " + getTarget(str));
            }
            if (TraceEvent.sEnabled) {
                TraceEvent.nativeEndToplevel();
            }
        }

        private static String getTarget(String str) {
            int indexOf = str.indexOf(40, 21);
            int indexOf2 = indexOf == -1 ? -1 : str.indexOf(41, indexOf);
            return indexOf2 != -1 ? str.substring(indexOf + 1, indexOf2) : "";
        }
    }

    static final class IdleTracingLooperMonitor extends BasicLooperMonitor implements MessageQueue.IdleHandler {
        private boolean mIdleMonitorAttached;
        private long mLastIdleStartedAt;
        private long mLastWorkStartedAt;
        private int mNumIdlesSeen;
        private int mNumTasksSeen;
        private int mNumTasksSinceLastIdle;

        private IdleTracingLooperMonitor() {
            super();
        }

        private final void syncIdleMonitoring() {
            if (TraceEvent.sEnabled && !this.mIdleMonitorAttached) {
                this.mLastIdleStartedAt = SystemClock.elapsedRealtime();
                Looper.myQueue().addIdleHandler(this);
                this.mIdleMonitorAttached = true;
                Log.v("TraceEvent.LooperMonitor", "attached idle handler");
            } else if (this.mIdleMonitorAttached && !TraceEvent.sEnabled) {
                Looper.myQueue().removeIdleHandler(this);
                this.mIdleMonitorAttached = false;
                Log.v("TraceEvent.LooperMonitor", "detached idle handler");
            }
        }

        /* access modifiers changed from: package-private */
        @Override // org.chromium.base.TraceEvent.BasicLooperMonitor
        public final void beginHandling(String str) {
            if (this.mNumTasksSinceLastIdle == 0) {
                TraceEvent.end("Looper.queueIdle");
            }
            this.mLastWorkStartedAt = SystemClock.elapsedRealtime();
            syncIdleMonitoring();
            super.beginHandling(str);
        }

        /* access modifiers changed from: package-private */
        @Override // org.chromium.base.TraceEvent.BasicLooperMonitor
        public final void endHandling(String str) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mLastWorkStartedAt;
            if (elapsedRealtime > 16) {
                traceAndLog(5, "observed a task that took " + elapsedRealtime + "ms: " + str);
            }
            super.endHandling(str);
            syncIdleMonitoring();
            this.mNumTasksSeen++;
            this.mNumTasksSinceLastIdle++;
        }

        private static void traceAndLog(int i, String str) {
            TraceEvent.instant("TraceEvent.LooperMonitor:IdleStats", str);
            Log.println(i, "TraceEvent.LooperMonitor", str);
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.mLastIdleStartedAt == 0) {
                this.mLastIdleStartedAt = elapsedRealtime;
            }
            long j = elapsedRealtime - this.mLastIdleStartedAt;
            this.mNumIdlesSeen++;
            TraceEvent.begin("Looper.queueIdle", this.mNumTasksSinceLastIdle + " tasks since last idle.");
            if (j > 48) {
                traceAndLog(3, this.mNumTasksSeen + " tasks and " + this.mNumIdlesSeen + " idles processed so far, " + this.mNumTasksSinceLastIdle + " tasks bursted and " + j + "ms elapsed since last idle");
            }
            this.mLastIdleStartedAt = elapsedRealtime;
            this.mNumTasksSinceLastIdle = 0;
            return true;
        }
    }

    @CalledByNative
    public static void setEnabled(boolean z) {
        if (z) {
            EarlyTraceEvent.disable();
        }
        if (sEnabled != z) {
            sEnabled = z;
            if (!sATraceEnabled) {
                ThreadUtils.getUiThreadLooper().setMessageLogging(z ? LooperMonitorHolder.sInstance : null);
            }
        }
    }

    public static void instant(String str, String str2) {
        if (sEnabled) {
            nativeInstant(str, str2);
        }
    }

    public static void begin(String str, String str2) {
        EarlyTraceEvent.begin(str);
        if (sEnabled) {
            nativeBegin(str, str2);
        }
    }

    public static void end(String str) {
        end(str, null);
    }

    public static void end(String str, String str2) {
        EarlyTraceEvent.end(str);
        if (sEnabled) {
            nativeEnd(str, str2);
        }
    }
}
