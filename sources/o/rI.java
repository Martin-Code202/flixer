package o;

import android.content.Context;
import com.netflix.mediaclient.StatusCode;
/* access modifiers changed from: package-private */
public class rI extends rF {
    rI() {
    }

    /* access modifiers changed from: package-private */
    @Override // o.rD
    /* renamed from: ॱ */
    public StatusCode mo10143() {
        return StatusCode.DRM_FAILURE_MEDIADRM_GET_KEY_REQUEST;
    }

    @Override // o.AbstractC1578c
    /* renamed from: ॱ */
    public AbstractC1268 mo5807(Context context, Throwable th) {
        C1283.m16854(f9644, "MSL get key request failed. Device may recover on its own");
        return m10139(context, th);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static boolean m10147(StatusCode statusCode) {
        return statusCode == StatusCode.DRM_FAILURE_MEDIADRM_GET_KEY_REQUEST;
    }
}
