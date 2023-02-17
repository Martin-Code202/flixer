package o;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.util.Map;
/* renamed from: o.gT  reason: case insensitive filesystem */
public abstract class AbstractC1814gT extends C0760 implements gX {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final Context f6915;

    public AbstractC1814gT(Context context, AbstractC0894 r3) {
        super(r3);
        this.f6915 = context.getApplicationContext();
    }

    @Override // o.C0760, o.AbstractC0419
    /* renamed from: ˎ  reason: contains not printable characters */
    public C1181 mo6603(Request<?> request) {
        request.checkFtlFallback();
        if (request.isFtlEndpoint()) {
            try {
                return m6604(request);
            } catch (VolleyError e) {
                if (m6601(e)) {
                    m6600(request, e);
                } else {
                    throw e;
                }
            }
        }
        return m6604(request);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1181 m6604(Request<?> request) {
        try {
            mo6598(request);
            C1181 r0 = super.mo6603(request);
            mo6597(request, r0);
            return r0;
        } catch (VolleyError e) {
            mo6599(request, e);
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C0760
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6602(Request request, Map<String, String> map) {
        m6605(request, map);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6605(Request<?> request, Map<String, String> map) {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m6601(VolleyError volleyError) {
        return C2034oj.m9656(volleyError) != -1;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6600(Request<?> request, VolleyError volleyError) {
        C1283.m16865("NetflixNetwork", "performing FTL fallback");
        request.setRetryPolicy(BJ.m3867(request.getRetryPolicy().mo14675()));
        request.triggerFtlFallback(volleyError);
    }
}
