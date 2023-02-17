package org.chromium.base;

import java.lang.Thread;
import org.chromium.base.annotations.CalledByNative;
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {
    static final /* synthetic */ boolean $assertionsDisabled = (!JavaExceptionReporter.class.desiredAssertionStatus());
    private final boolean mCrashAfterReport;
    private boolean mHandlingException;
    private final Thread.UncaughtExceptionHandler mParent;

    private static native void nativeReportJavaException(boolean z, Throwable th);

    private static native void nativeReportJavaStackTrace(String str);

    private JavaExceptionReporter(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z) {
        this.mParent = uncaughtExceptionHandler;
        this.mCrashAfterReport = z;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!this.mHandlingException) {
            this.mHandlingException = true;
            nativeReportJavaException(this.mCrashAfterReport, th);
        }
        if (this.mParent != null) {
            this.mParent.uncaughtException(thread, th);
        }
    }

    @CalledByNative
    private static void installHandler(boolean z) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), z));
    }
}
