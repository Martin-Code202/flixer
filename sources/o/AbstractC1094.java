package o;

import com.android.volley.Request;
import com.netflix.mediaclient.net.NetworkRequestType;
import java.util.Map;
/* renamed from: o.丫  reason: contains not printable characters */
abstract class AbstractC1094<T> extends AbstractC1807gM<T> {
    AbstractC1094() {
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.HIGH;
    }

    @Override // com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.CONFIG;
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˊ */
    public void mo5787() {
        m6615(m6614().m6490());
    }

    @Override // o.gV
    /* renamed from: ʽ */
    public String mo6586() {
        return "/android/samurai/config";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM, com.android.volley.Request
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        Map<String, String> r2 = m6614().m6495().mo1453();
        if (params == null) {
            return r2;
        }
        params.putAll(r2);
        return params;
    }
}
