package o;

import com.android.volley.Request;
import o.C0524;
/* renamed from: o.nq  reason: case insensitive filesystem */
public class C2013nq extends Request<byte[]> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Request.Priority f9203;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC2006nj f9204;

    public C2013nq(String str, AbstractC2006nj njVar, C0524.AbstractC2398iF iFVar, int i, Request.Priority priority) {
        super(0, str, iFVar);
        this.f9204 = njVar;
        this.f9203 = priority;
        setShouldCache(false);
        setRetryPolicy(new C1040(i, 2, 2.0f));
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return this.f9203;
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public C0524<byte[]> parseNetworkResponse(C1181 r4) {
        getUrl();
        return C0524.m14563(r4.f15530, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void deliverResponse(byte[] bArr) {
        if (this.f9204 != null) {
            this.f9204.mo7553(getUrl(), bArr, AbstractC0367.f13235);
        }
    }
}
