package o;

import android.os.HandlerThread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.chromium.net.RequestFinishedInfo;
/* renamed from: o.ڽ  reason: contains not printable characters */
class C0623 extends RequestFinishedInfo.Listener {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final BlockingQueue<Runnable> f13932 = new LinkedBlockingQueue(64);

    /* renamed from: ˋ  reason: contains not printable characters */
    private final HandlerThread f13933 = null;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0595 f13934;

    private C0623(Executor executor, C0595 r3) {
        super(executor);
        this.f13934 = r3;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static C0623 m14754(C0595 r8) {
        return new C0623(new ThreadPoolExecutor(1, 4, 5, TimeUnit.SECONDS, f13932), r8);
    }

    @Override // org.chromium.net.RequestFinishedInfo.Listener
    public void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
        if (requestFinishedInfo != null) {
            this.f13934.m14730(requestFinishedInfo);
        }
    }
}
