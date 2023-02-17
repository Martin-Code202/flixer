package o;

import com.android.volley.Request;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o.AbstractC1403Dt;
/* renamed from: o.gC  reason: case insensitive filesystem */
public class C1797gC implements AbstractC1403Dt {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Object f6851;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final URL f6852;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Request.Priority f6853;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC0661 f6854;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final List<AbstractC0644> f6855;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map<String, String> f6856;

    public C1797gC(AbstractC0661 r2, URL url) {
        this(r2, url, null);
    }

    public C1797gC(AbstractC0661 r7, URL url, Map<String, String> map) {
        this(r7, url, map, Request.Priority.NORMAL, null);
    }

    public C1797gC(AbstractC0661 r3, URL url, Map<String, String> map, Request.Priority priority, Object obj) {
        this.f6855 = new ArrayList();
        if (url == null) {
            throw new IllegalArgumentException("URL is null!");
        }
        this.f6854 = r3;
        this.f6852 = url;
        this.f6856 = map;
        this.f6853 = priority;
        this.f6851 = obj;
    }

    @Override // o.AbstractC1403Dt
    /* renamed from: ˏ */
    public void mo4742(int i) {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6516() {
        synchronized (this.f6855) {
            for (AbstractC0644 r0 : this.f6855) {
                r0.mo14781();
            }
        }
    }

    @Override // o.AbstractC1403Dt
    /* renamed from: ˊ */
    public AbstractC1403Dt.If mo4741() {
        final AbstractC0644 r5 = this.f6854.mo14822(this.f6852.toString(), this.f6853, this.f6856, this.f6851);
        synchronized (this.f6855) {
            this.f6855.add(r5);
        }
        return new AbstractC1403Dt.If() { // from class: o.gC.3
            @Override // o.AbstractC1403Dt.If
            /* renamed from: ˊ */
            public InputStream mo4743() {
                try {
                    return r5.mo14782();
                } catch (IOException e) {
                    if (r5.mo14780() >= 400) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Connection attempt to: ");
                        sb.append(C1797gC.this.f6852);
                        sb.append(" returned HTTP error code: ");
                        sb.append(r5.mo14780());
                        if (r5.mo14784() != null) {
                            sb.append(" and error msg: ");
                            sb.append(r5.mo14784());
                        }
                        throw new IOException(sb.toString(), e.getCause());
                    }
                    throw e;
                }
            }

            @Override // o.AbstractC1403Dt.If
            /* renamed from: ॱ */
            public OutputStream mo4744() {
                return r5.mo14783();
            }
        };
    }
}
