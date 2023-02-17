package o;

import android.os.Handler;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.util.concurrent.Executor;
/* renamed from: o.ﹷ  reason: contains not printable characters */
public class C1165 implements AbstractC0450 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Executor f15427;

    public C1165(final Handler handler) {
        this.f15427 = new Executor() { // from class: o.ﹷ.2
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // o.AbstractC0450
    /* renamed from: ˋ */
    public void mo14331(Request<?> request, C0524<?> r3) {
        mo14330(request, r3, null);
    }

    @Override // o.AbstractC0450
    /* renamed from: ˊ */
    public void mo14330(Request<?> request, C0524<?> r4, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f15427.execute(new RunnableC1166(request, r4, runnable));
    }

    @Override // o.AbstractC0450
    /* renamed from: ˎ */
    public void mo14332(Request<?> request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.f15427.execute(new RunnableC1166(request, C0524.m14562(volleyError), null));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ﹷ$ˊ  reason: contains not printable characters */
    public class RunnableC1166 implements Runnable {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final Runnable f15430;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final Request f15431;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final C0524 f15433;

        public RunnableC1166(Request request, C0524 r3, Runnable runnable) {
            this.f15431 = request;
            this.f15433 = r3;
            this.f15430 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15431.isCanceled()) {
                this.f15431.finish("canceled-at-delivery");
                return;
            }
            if (this.f15433.m14564()) {
                this.f15431.deliverResponse(this.f15433.f13674);
            } else {
                this.f15431.deliverError(this.f15433.f13676);
            }
            if (this.f15433.f13675) {
                this.f15431.addMarker("intermediate-response");
            } else {
                this.f15431.finish("done");
            }
            if (this.f15430 != null) {
                this.f15430.run();
            }
        }
    }
}
