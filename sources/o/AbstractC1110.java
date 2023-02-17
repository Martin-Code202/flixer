package o;

import com.android.volley.Request;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
/* renamed from: o.ﬤ  reason: contains not printable characters */
public abstract class AbstractC1110<T> extends AbstractC1094<T> {

    /* renamed from: ˋ  reason: contains not printable characters */
    protected AuthorizationCredentials f15328;

    @Override // o.AbstractC1094, com.android.volley.Request
    public /* bridge */ /* synthetic */ Request.Priority getPriority() {
        return super.getPriority();
    }

    @Override // o.AbstractC1094, com.android.volley.Request
    public /* bridge */ /* synthetic */ Object getTag() {
        return super.getTag();
    }

    @Override // o.AbstractC1094, o.gV
    /* renamed from: ʽ */
    public /* bridge */ /* synthetic */ String mo6586() {
        return super.mo6586();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1094, o.gV
    /* renamed from: ˊ */
    public void mo5787() {
        String r4 = m6614().m6490();
        C1283.m16851("nf_dynecom", "Dynecom configuration uRL: %s", r4);
        m6615(r4);
    }
}
