package o;

import android.content.Context;
import com.netflix.mediaclient.StatusCode;
/* access modifiers changed from: package-private */
public class rQ extends rF {
    rQ() {
    }

    /* access modifiers changed from: package-private */
    @Override // o.rD
    /* renamed from: ॱ */
    public StatusCode mo10143() {
        return StatusCode.DRM_FAILURE_MEDIADRM_PROVIDE_KEY_RESPONSE;
    }

    @Override // o.AbstractC1578c
    /* renamed from: ॱ */
    public AbstractC1268 mo5807(Context context, Throwable th) {
        C1283.m16854(f9644, "MediaDrm provide key update failed. Unregister device, logout user, and kill app process after error is displayed.");
        return m10139(context, th);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static boolean m10156(StatusCode statusCode) {
        return statusCode == StatusCode.DRM_FAILURE_MEDIADRM_PROVIDE_KEY_RESPONSE;
    }
}
