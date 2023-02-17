package o;

import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
/* renamed from: o.Ⅰ  reason: contains not printable characters */
public abstract class AbstractC1055 extends Request<Void> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final byte[] f15200 = new byte[8192];

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Request.Priority f15201;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC1151 f15202;

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public abstract void mo6936(long j);

    public AbstractC1055(String str, Request.Priority priority) {
        super(0, str, null);
        this.f15201 = priority;
        setShouldCache(false);
        setRetryPolicy(new C1040(SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS, 0, 1.0f));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m16104(AbstractC1151 r1) {
        this.f15202 = r1;
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return this.f15201;
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public C0524<Void> parseNetworkResponse(C1181 r10) {
        C0524<Void> r4;
        AbstractC1151 r5;
        if (isCanceled()) {
            m16102(r10);
            return C0524.m14563(null, null);
        }
        if (r10 == null) {
            r4 = C0524.m14562(new VolleyError("Network response is null"));
        } else if (!(r10 instanceof C1023)) {
            r4 = C0524.m14562(new VolleyError("Expecting ProgressiveNetworkResponse but got=" + r10));
        } else {
            HttpEntity r52 = ((C1023) r10).m15993();
            mo6936(r52.getContentLength());
            try {
                InputStream content = r52.getContent();
                while (true) {
                    if (isCanceled()) {
                        break;
                    }
                    int read = content.read(this.f15200);
                    AbstractC1151 r8 = this.f15202;
                    if (r8 != null) {
                        r8.mo6932(this.f15200, read);
                    }
                    if (read < 0) {
                        break;
                    }
                }
                if (content != null) {
                    content.close();
                }
                r4 = C0524.m14563(null, null);
            } catch (IOException e) {
                C0509.m14519("nf_download_prog_req", "parseNetworkResponse I/O error " + e.toString());
                r4 = C0524.m14562(new VolleyError(new NetworkError(e)));
            }
        }
        if (isCanceled() && (r5 = this.f15202) != null) {
            r5.mo6935();
        }
        m16102(r10);
        return r4;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m16102(C1181 r4) {
        try {
            ((C1023) r4).m15993().consumeContent();
            releaseResources();
        } catch (IOException e) {
            C0509.m14519("Error occurred when calling consumingContent", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void deliverResponse(Void r1) {
    }

    @Override // com.android.volley.Request
    public void deliverError(VolleyError volleyError) {
        AbstractC1151 r0 = this.f15202;
        if (r0 != null) {
            r0.mo6934(volleyError);
        }
    }
}
