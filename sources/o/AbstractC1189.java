package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
/* renamed from: o.ﺙ  reason: contains not printable characters */
public abstract class AbstractC1189<T> extends AbstractC1230<T> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f15562 = AbstractC1189.class.getSimpleName();

    /* renamed from: ˏ  reason: contains not printable characters */
    protected Context f15563;

    public AbstractC1189(Context context, NetflixDataRequest.Transport transport) {
        super(transport);
        this.f15563 = context;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ  reason: contains not printable characters */
    public NetflixDataRequest mo16451() {
        if (this.f15756 == NetflixDataRequest.Transport.msl) {
            C1283.m16854(f15562, "Create MSL transport for");
            return new AbstractC1810gP<T>() { // from class: o.ﺙ.3
                /* access modifiers changed from: protected */
                @Override // o.AbstractC1807gM
                /* renamed from: ˎ */
                public List<String> mo989() {
                    return AbstractC1189.this.mo9118();
                }

                /* access modifiers changed from: protected */
                @Override // o.gV
                /* renamed from: ˏ */
                public void mo992(T t) {
                    AbstractC1189.this.mo9114((AbstractC1189) t);
                }

                /* access modifiers changed from: protected */
                @Override // o.gV
                /* renamed from: ˏ */
                public void mo991(Status status) {
                    AbstractC1189.this.mo9113(status);
                }

                /* access modifiers changed from: protected */
                @Override // o.AbstractC1807gM
                /* renamed from: ˊ */
                public T mo986(String str) {
                    return (T) AbstractC1189.this.mo9112(str);
                }

                /* access modifiers changed from: protected */
                @Override // o.AbstractC1807gM
                /* renamed from: ॱ */
                public String mo6583() {
                    return AbstractC1189.this.mo9116();
                }

                /* access modifiers changed from: protected */
                @Override // o.gV
                /* renamed from: ˋ */
                public boolean mo6620() {
                    return AbstractC1189.this.mo9156();
                }

                /* access modifiers changed from: protected */
                @Override // o.AbstractC1810gP, o.AbstractC1807gM, com.android.volley.Request
                public Map<String, String> getParams() {
                    Map<String, String> params = super.getParams();
                    Map<String, String> r2 = AbstractC1189.this.mo9111();
                    if (r2 != null || r2.size() > 0) {
                        params.putAll(r2);
                    }
                    return params;
                }
            };
        } else if (this.f15756 == NetflixDataRequest.Transport.web) {
            C1283.m16854(f15562, "Create Web transport for");
            return new AbstractC2035ok<T>(this.f15563) { // from class: o.ﺙ.5
                /* access modifiers changed from: protected */
                @Override // o.AbstractC2035ok
                /* renamed from: ˎ */
                public List<String> mo9668() {
                    return AbstractC1189.this.mo9118();
                }

                /* access modifiers changed from: protected */
                @Override // o.AbstractC2040op
                /* renamed from: ˏ */
                public void mo5640(T t) {
                    AbstractC1189.this.mo9114((AbstractC1189) t);
                }

                /* access modifiers changed from: protected */
                @Override // o.AbstractC2040op
                /* renamed from: ˋ */
                public void mo5637(Status status) {
                    AbstractC1189.this.mo9113(status);
                }

                /* access modifiers changed from: protected */
                @Override // o.AbstractC2035ok
                /* renamed from: ˊ */
                public T mo9665(String str) {
                    return (T) AbstractC1189.this.mo9112(str);
                }

                /* access modifiers changed from: protected */
                @Override // o.AbstractC2035ok, o.AbstractC2040op
                /* renamed from: ˊ */
                public String mo5781() {
                    return AbstractC1189.this.mo9116();
                }

                /* access modifiers changed from: protected */
                @Override // o.AbstractC2040op
                /* renamed from: ʻ */
                public boolean mo9685() {
                    return AbstractC1189.this.mo9121();
                }

                /* access modifiers changed from: protected */
                @Override // o.AbstractC2040op
                /* renamed from: ˏ */
                public boolean mo9692() {
                    return AbstractC1189.this.mo9122();
                }

                /* access modifiers changed from: protected */
                @Override // o.AbstractC2040op
                /* renamed from: ʽ */
                public boolean mo9686() {
                    return AbstractC1189.this.mo9156();
                }

                /* access modifiers changed from: protected */
                @Override // o.AbstractC2040op
                /* renamed from: ॱ */
                public String mo9695() {
                    StringBuilder sb = new StringBuilder();
                    Map<String, String> r3 = AbstractC1189.this.mo9111();
                    if (r3 != null || r3.size() > 0) {
                        try {
                            for (Map.Entry<String, String> entry : r3.entrySet()) {
                                if (entry.getValue() != null) {
                                    sb.append('&');
                                    sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                                    sb.append('=');
                                    sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                                }
                            }
                        } catch (UnsupportedEncodingException e) {
                        }
                    }
                    return sb.toString();
                }
            };
        } else {
            throw new IllegalStateException("Uknown transport type " + this.f15756);
        }
    }
}
