package com.netflix.mediaclient.android.app;

import com.netflix.mediaclient.android.osp.AsyncTaskCompat;
import o.C1276;
import o.C1283;
public class BackgroundTask {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final iF f846 = new iF();

    /* access modifiers changed from: package-private */
    public static class BackgroundTaskException extends RuntimeException {
        public BackgroundTaskException(Throwable th) {
            super(th);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m285(Runnable runnable) {
        this.f846.m326(AsyncTaskCompat.f870, runnable);
    }

    /* access modifiers changed from: package-private */
    public static class iF extends AsyncTaskCompat<Runnable, Void, Void> {
        private iF() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: ˏ  reason: contains not printable characters */
        public Void mo286(Runnable... runnableArr) {
            try {
                for (Runnable runnable : runnableArr) {
                    Thread.currentThread().setName("BackgroundTask-" + runnable.getClass().getSimpleName());
                    runnable.run();
                }
                return null;
            } catch (Exception e) {
                C1283.m16847("BackgroundTask", "Failed to execute BackgroundTask !", e);
                C1276.m16820().mo5731(new BackgroundTaskException(e));
                return null;
            }
        }
    }
}
