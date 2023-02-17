package o;

import android.content.Context;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.ui.error.CryptoErrorManagerImpl;
/* access modifiers changed from: package-private */
public class rJ extends rF {
    rJ() {
    }

    /* access modifiers changed from: package-private */
    @Override // o.rD
    /* renamed from: ॱ */
    public StatusCode mo10143() {
        return StatusCode.DRM_FAILURE_MEDIADRM_WIDEVINE_PLUGIN_CHANGED;
    }

    @Override // o.AbstractC1578c
    /* renamed from: ॱ */
    public AbstractC1268 mo5807(Context context, Throwable th) {
        C1283.m16854(f9644, "MediaDrm Widevine plugin changed, unregister device and logout user");
        m10142(CryptoErrorManagerImpl.m1752(mo10143(), th));
        return C1061.m16114().mo14162().mo1765(context, mo10143(), m10140(context), R.string.label_drm_failed);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static boolean m10148(StatusCode statusCode) {
        return statusCode == StatusCode.DRM_FAILURE_MEDIADRM_WIDEVINE_PLUGIN_CHANGED;
    }
}
