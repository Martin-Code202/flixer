package o;

import android.content.Context;
import android.util.Log;
import com.netflix.mediaclient.StatusCode;
/* access modifiers changed from: package-private */
public class rL extends rF {

    /* renamed from: ˋ  reason: contains not printable characters */
    private StatusCode f9650;

    rL(StatusCode statusCode) {
        this.f9650 = statusCode;
    }

    /* access modifiers changed from: package-private */
    @Override // o.rD
    /* renamed from: ॱ */
    public StatusCode mo10143() {
        return this.f9650;
    }

    @Override // o.AbstractC1578c
    /* renamed from: ॱ */
    public AbstractC1268 mo5807(Context context, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(C0480.m14408().mo14358().name()).append(": ");
        sb.append(this.f9650.toString());
        if (th != null) {
            sb.append(Log.getStackTraceString(th));
        }
        m10142(sb.toString());
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static boolean m10150(StatusCode statusCode) {
        return statusCode == StatusCode.DRM_FAILURE_MEDIADRM_DECRYPT || statusCode == StatusCode.DRM_FAILURE_MEDIADRM_ENCRYPT || statusCode == StatusCode.DRM_FAILURE_MEDIADRM_SIGN || statusCode == StatusCode.DRM_FAILURE_MEDIADRM_VERIFY || statusCode == StatusCode.DRM_FAILURE_MEDIADRM_RESET;
    }
}
