package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.net.NetworkRequestType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import o.C0593;
import o.C1170;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.ExperimentalUrlRequest;
import org.chromium.net.UploadDataProviders;
import org.chromium.net.UrlRequest;
/* renamed from: o.ף  reason: contains not printable characters */
public class C0563 extends C1170 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final Executor f13807 = Executors.newFixedThreadPool(6);

    /* renamed from: ˊ  reason: contains not printable characters */
    private Handler f13808 = new Handler(Looper.getMainLooper());

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ExperimentalCronetEngine f13809;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Context f13810;

    public C0563(Context context, ExperimentalCronetEngine experimentalCronetEngine, BlockingQueue<Request> blockingQueue, AbstractC0419 r10, AbstractC1001 r11, AbstractC0450 r12, String str) {
        super(blockingQueue, r10, r11, r12, str);
        this.f13810 = context;
        this.f13809 = experimentalCronetEngine;
    }

    /* access modifiers changed from: protected */
    @Override // o.C1170
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo14648(Request request, C1170.AbstractC1171 r3) {
        m14640(request, new C0564(request, r3));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14647(final gV gVVar, final Map<String, String> map, final C0564 r5) {
        f13807.execute(new Runnable() { // from class: o.ף.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final byte[] r2 = gVVar.mo5788(map);
                    AbstractC0661.f14007.execute(new Runnable() { // from class: o.ף.3.3
                        @Override // java.lang.Runnable
                        public void run() {
                            r5.mo14652(new C1181(200, r2, null, false));
                        }
                    });
                } catch (VolleyError e) {
                    r5.mo14653(e);
                } catch (IOException e2) {
                    r5.mo14653(new VolleyError(e2));
                } catch (Exception e3) {
                    r5.m14654(e3);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m14640(Request request, C0564 r13) {
        HashMap hashMap = new HashMap();
        try {
            request.checkFtlFallback();
            Map<String, String> r5 = C0669.m14867(request.getCacheEntry());
            if (r5 != null) {
                hashMap.putAll(r5);
            }
            if (request instanceof gV) {
                m14647((gV) request, hashMap, r13);
                return;
            }
            byte[] body = request.getBody();
            ExperimentalUrlRequest.Builder newUrlRequestBuilder = this.f13809.newUrlRequestBuilder(request.getUrl(), (UrlRequest.Callback) new C0593(request.getUrl(), r13), AbstractC0661.f14007);
            if (!request.shouldCache()) {
                newUrlRequestBuilder.disableCache();
            }
            String r8 = C0651.m14809(request, body);
            newUrlRequestBuilder.setHttpMethod(r8);
            if ("POST".equals(r8)) {
                newUrlRequestBuilder.setUploadDataProvider(UploadDataProviders.create(body), AbstractC0661.f14007);
                newUrlRequestBuilder.addHeader("Content-Type", request.getBodyContentType());
            }
            Map<String, String> headers = request.getHeaders();
            if (headers != null) {
                hashMap.putAll(headers);
            }
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                newUrlRequestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
            newUrlRequestBuilder.setPriority(C0651.m14810(request.getPriority()));
            if (request.getTag() instanceof NetworkRequestType) {
                newUrlRequestBuilder.addRequestAnnotation(request.getTag());
            }
            newUrlRequestBuilder.build().start();
        } catch (Exception e) {
            r13.m14654(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ף$ˋ  reason: contains not printable characters */
    public class C0564 implements C0593.iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final C1170.AbstractC1171 f13817;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Request f13819;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final long f13820 = SystemClock.elapsedRealtime();

        public C0564(Request request, C1170.AbstractC1171 r5) {
            this.f13819 = request;
            this.f13817 = r5;
        }

        @Override // o.C0593.iF
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo14652(C1181 r9) {
            C0760.m15185(this.f13819, r9.f15530.length, SystemClock.elapsedRealtime() - this.f13820);
            if (r9.f15527 == 410) {
                String r7 = C0669.m14866(r9.f15530);
                C1283.m16851("nf_network", "GONE: redirecting to %s", r7);
                if (r7 != null) {
                    this.f13819.changeHostUrl(r7);
                    C0563.this.m14640(this.f13819, this);
                    return;
                }
                mo14653(new ServerError(r9));
            } else if (r9.f15527 == 301 || r9.f15527 == 302 || r9.f15527 == 307) {
                String str = r9.f15528.get("Location");
                C1283.m16851("nf_network", "REDIRECT: redirecting to %s", str);
                if (str != null) {
                    this.f13819.changeToRedirectedUrl(str);
                    C0563.this.m14640(this.f13819, this);
                    return;
                }
                mo14653(new ServerError(r9));
            } else if (r9.f15527 >= 400 || r9.f15527 < 200) {
                mo14653(new ServerError(r9));
            } else if (r9.f15527 == 304) {
                this.f13817.mo16377(this.f13819, new C1181(r9.f15527, this.f13819.getCacheEntry().f15077, r9.f15528, true), null);
            } else {
                this.f13817.mo16377(this.f13819, r9, null);
            }
        }

        @Override // o.C0593.iF
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo14653(VolleyError volleyError) {
            long r3 = m14649(this.f13819);
            if (this.f13819.isFtlEndpoint() && C0563.this.m14645(volleyError)) {
                C0563.this.m14646((Request<?>) this.f13819, volleyError);
                C0563.this.f13808.post(new Runnable() { // from class: o.ף.ˋ.3
                    @Override // java.lang.Runnable
                    public void run() {
                        C0563.this.m14640(C0564.this.f13819, C0564.this);
                    }
                });
            } else if (m14650(this.f13819, volleyError)) {
                C0563.this.f13808.postDelayed(new Runnable() { // from class: o.ף.ˋ.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C0563.this.m14640(C0564.this.f13819, C0564.this);
                    }
                }, r3);
            } else {
                this.f13817.mo16377(this.f13819, null, volleyError);
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void m14654(Exception exc) {
            if (!(exc instanceof VolleyError)) {
                exc = new VolleyError(exc);
            }
            this.f13817.mo16377(this.f13819, null, (VolleyError) exc);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean m14650(Request request, VolleyError volleyError) {
            AbstractC0573 retryPolicy = request.getRetryPolicy();
            if (retryPolicy == null) {
                return false;
            }
            try {
                retryPolicy.mo14676(volleyError);
                return true;
            } catch (VolleyError e) {
                return false;
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private long m14649(Request request) {
            AbstractC0573 retryPolicy = request.getRetryPolicy();
            if (retryPolicy != null) {
                return (long) (Math.pow(2.0d, (double) retryPolicy.mo14677()) * 100.0d);
            }
            return 100;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m14645(VolleyError volleyError) {
        return C2034oj.m9656(volleyError) != -1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14646(Request<?> request, VolleyError volleyError) {
        C1283.m16865("nf_network", "performing FTL fallback");
        request.setRetryPolicy(BJ.m3867(request.getRetryPolicy().mo14675()));
        request.triggerFtlFallback(volleyError);
    }
}
