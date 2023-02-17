package o;

import android.content.Context;
import com.netflix.mediaclient.StatusCode;
/* access modifiers changed from: package-private */
public class rO extends rF {
    rO() {
    }

    /* access modifiers changed from: package-private */
    @Override // o.rD
    /* renamed from: ॱ */
    public StatusCode mo10143() {
        return StatusCode.DRM_FAILURE_MEDIADRM_KEYS_RESTORE_FAILED;
    }

    @Override // o.AbstractC1578c
    /* renamed from: ॱ */
    public AbstractC1268 mo5807(Context context, Throwable th) {
        C1283.m16854(f9644, "MediaDrm provide key restore failed. Kill app...");
        return m10139(context, th);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static boolean m10151(StatusCode statusCode) {
        return statusCode == StatusCode.DRM_FAILURE_MEDIADRM_KEYS_RESTORE_FAILED;
    }
}
