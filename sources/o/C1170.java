package o;

import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
/* renamed from: o.ﹻ  reason: contains not printable characters */
public class C1170 extends Thread implements AbstractC1215 {

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static final WeakHashMap<iF, iF> f15438 = new WeakHashMap<>();

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f15439;

    /* renamed from: ˊ  reason: contains not printable characters */
    private volatile boolean f15440;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final BlockingQueue<Request> f15441;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC0419 f15442;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1001 f15443;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC0450 f15444;

    /* renamed from: o.ﹻ$iF */
    public interface iF {
        /* renamed from: ˋ  reason: contains not printable characters */
        void m16378(Request request, Throwable th);

        /* renamed from: ॱ  reason: contains not printable characters */
        void m16379(Request request);
    }

    /* renamed from: o.ﹻ$ˊ  reason: contains not printable characters */
    public interface AbstractC1171 {
        /* renamed from: ˎ */
        void mo16377(Request request, C1181 v, VolleyError volleyError);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1170(BlockingQueue<Request> blockingQueue, AbstractC0419 r4, AbstractC1001 r5, AbstractC0450 r6, String str) {
        super(str == null ? "NetworkDispatcher" : "NetworkDispatcher-" + str);
        this.f15440 = false;
        this.f15441 = blockingQueue;
        this.f15442 = r4;
        this.f15443 = r5;
        this.f15444 = r6;
        this.f15439 = str;
    }

    @Override // o.AbstractC1215
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo16376() {
        this.f15440 = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                Request take = this.f15441.take();
                if (this.f15441.size() > 0) {
                    Log.i("RequestQueue_Blocked", this.f15439 + " Http request is blocked ?- queue size: " + this.f15441.size());
                }
                try {
                    synchronized (take) {
                        take.addMarker("network-queue-take");
                        if (take.isCanceled()) {
                            take.finish("network-discard-cancelled");
                        } else {
                            m16367(take);
                            if (Build.VERSION.SDK_INT >= 14) {
                                TrafficStats.setThreadStatsTag(take.getTrafficStatsTag());
                            }
                            if (take.getUrl().startsWith("file://")) {
                                m16373(take, new C1181(200, C1095.m16187(take.getUrl()), Collections.emptyMap(), false));
                            } else {
                                mo14648(take, new AbstractC1171() { // from class: o.ﹻ.4
                                    @Override // o.C1170.AbstractC1171
                                    /* renamed from: ˎ  reason: contains not printable characters */
                                    public void mo16377(Request request, C1181 r5, VolleyError volleyError) {
                                        if (volleyError != null) {
                                            try {
                                                throw volleyError;
                                            } catch (VolleyError e) {
                                                C1170.this.m16374(request, e);
                                            } catch (Exception e2) {
                                                C0509.m14522(e2, "unhandled error on request finish", new Object[0]);
                                                C1170.this.m16375(request, e2);
                                            }
                                        } else {
                                            C1170.this.m16373(request, r5);
                                        }
                                    }
                                });
                            }
                        }
                    }
                } catch (VolleyError e) {
                    m16374(take, e);
                } catch (Exception e2) {
                    m16375(take, e2);
                }
            } catch (InterruptedException e3) {
                if (this.f15440) {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public void mo14648(Request request, AbstractC1171 r4) {
        r4.mo16377(request, this.f15442.mo6603(request), null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m16373(Request request, C1181 r6) {
        request.addMarker("network-http-complete");
        if (!r6.f15529 || !request.hasHadResponseDelivered()) {
            C0524<?> parseNetworkResponse = request.parseNetworkResponse(r6);
            request.addMarker("network-parse-complete");
            if (request.shouldCache() && parseNetworkResponse.f13677 != null) {
                this.f15443.mo15201(request.getCacheKey(), parseNetworkResponse.f13677);
                request.addMarker("network-cache-written");
            }
            request.markDelivered();
            this.f15444.mo14331(request, parseNetworkResponse);
            m16370(request);
            return;
        }
        request.finish("not-modified");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16374(Request request, VolleyError volleyError) {
        m16368(request, volleyError);
        m16371(request, (Throwable) volleyError);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16375(Request request, Exception exc) {
        C0509.m14522(exc, "Unhandled exception %s", exc.toString());
        this.f15444.mo14332(request, new VolleyError(exc));
        m16371(request, (Throwable) exc);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m16367(Request request) {
        Set<iF> keySet;
        request.markInFlight(true);
        request.setResourceLocationType(Request.ResourceLocationType.NETWORK);
        synchronized (f15438) {
            keySet = f15438.keySet();
        }
        for (iF iFVar : keySet) {
            if (iFVar != null) {
                iFVar.m16379(request);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m16370(Request request) {
        m16372(request, null);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m16371(Request request, Throwable th) {
        m16372(request, th);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m16372(Request request, Throwable th) {
        Set<iF> keySet;
        request.markInFlight(false);
        synchronized (f15438) {
            keySet = f15438.keySet();
        }
        for (iF iFVar : keySet) {
            if (iFVar != null) {
                iFVar.m16378(request, th);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m16368(Request<?> request, VolleyError volleyError) {
        this.f15444.mo14332(request, request.parseNetworkError(volleyError));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m16369(iF iFVar) {
        synchronized (f15438) {
            f15438.remove(iFVar);
        }
    }
}
