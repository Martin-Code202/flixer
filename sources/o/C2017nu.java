package o;

import android.graphics.Bitmap;
import com.android.volley.Request;
import o.C0524;
/* renamed from: o.nu  reason: case insensitive filesystem */
public class C2017nu extends C0896 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Request.Priority f9208;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final long f9209;

    public C2017nu(String str, C0524.If<Bitmap> r5, int i, int i2, Bitmap.Config config, C0524.AbstractC2398iF iFVar, Request.Priority priority, int i3, long j) {
        super(str, r5, i, i2, config, iFVar);
        if (priority != null) {
            this.f9208 = priority;
        } else {
            this.f9208 = Request.Priority.LOW;
        }
        if (i3 > 0) {
            setRetryPolicy(new C1040(i3, 2, 2.0f));
        }
        this.f9209 = j;
    }

    @Override // o.C0896, com.android.volley.Request
    public Request.Priority getPriority() {
        return this.f9208;
    }

    @Override // com.android.volley.Request
    public String getCacheKey() {
        return C2011no.m9327(getUrl());
    }

    /* access modifiers changed from: protected */
    @Override // o.C0896, com.android.volley.Request
    public C0524<Bitmap> parseNetworkResponse(C1181 r8) {
        C0524<Bitmap> parseNetworkResponse = super.parseNetworkResponse(r8);
        if (parseNetworkResponse == null || parseNetworkResponse.f13676 != null || parseNetworkResponse.f13677 == null || this.f9209 <= 0) {
            return parseNetworkResponse;
        }
        long currentTimeMillis = System.currentTimeMillis() + this.f9209;
        if (currentTimeMillis > parseNetworkResponse.f13677.f15076) {
            parseNetworkResponse.f13677.f15076 = currentTimeMillis;
            parseNetworkResponse.f13677.f15080 = currentTimeMillis;
        }
        return parseNetworkResponse;
    }
}
