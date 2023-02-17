package o;

import android.os.Process;
import com.android.volley.Request;
import java.util.concurrent.BlockingQueue;
import o.AbstractC1001;
/* renamed from: o.ﹲ  reason: contains not printable characters */
public class C1160 extends Thread {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final BlockingQueue<Request> f15409;

    /* renamed from: ˋ  reason: contains not printable characters */
    private volatile boolean f15410 = false;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC0450 f15411;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1001 f15412;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final BlockingQueue<Request> f15413;

    public C1160(BlockingQueue<Request> blockingQueue, BlockingQueue<Request> blockingQueue2, AbstractC1001 r4, AbstractC0450 r5) {
        this.f15409 = blockingQueue;
        this.f15413 = blockingQueue2;
        this.f15412 = r4;
        this.f15411 = r5;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16348() {
        this.f15410 = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.f15412.mo15203();
        while (true) {
            try {
                final Request<?> take = this.f15409.take();
                take.addMarker("cache-queue-take");
                if (take.isCanceled()) {
                    take.finish("cache-discard-canceled");
                } else {
                    AbstractC1001.Cif r4 = this.f15412.mo15202(take.getCacheKey());
                    if (r4 == null) {
                        take.addMarker("cache-miss");
                        this.f15413.put(take);
                    } else if (r4.m15947()) {
                        take.addMarker("cache-hit-expired");
                        take.setCacheEntry(r4);
                        this.f15413.put(take);
                    } else {
                        take.addMarker("cache-hit");
                        C0524<?> parseNetworkResponse = take.parseNetworkResponse(new C1181(r4.f15077, r4.f15075));
                        take.addMarker("cache-hit-parsed");
                        if (!r4.m15946()) {
                            take.setResourceLocationType(Request.ResourceLocationType.CACHE);
                            this.f15411.mo14331(take, parseNetworkResponse);
                        } else {
                            take.addMarker("cache-hit-refresh-needed");
                            take.setCacheEntry(r4);
                            parseNetworkResponse.f13675 = true;
                            this.f15411.mo14330(take, parseNetworkResponse, new Runnable() { // from class: o.ﹲ.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        C1160.this.f15413.put(take);
                                    } catch (InterruptedException e) {
                                    }
                                }
                            });
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f15410) {
                    return;
                }
            }
        }
    }
}
