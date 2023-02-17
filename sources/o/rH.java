package o;

import android.content.Context;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.ui.error.CryptoErrorManagerImpl;
/* access modifiers changed from: package-private */
public class rH extends rF {
    rH() {
    }

    /* access modifiers changed from: package-private */
    @Override // o.rD
    /* renamed from: ॱ */
    public StatusCode mo10143() {
        return StatusCode.MSL_LEGACY_CRYPTO_BUT_USED_WIDEVINE_BEFORE;
    }

    @Override // o.AbstractC1578c
    /* renamed from: ॱ */
    public AbstractC1268 mo5807(Context context, Throwable th) {
        C1283.m16854(f9644, "Device is unable to used Widevine, but we detected that Widevine was used in past.");
        m10142(CryptoErrorManagerImpl.m1752(mo10143(), th));
        return m10139(context, th);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static boolean m10146(StatusCode statusCode) {
        return statusCode == StatusCode.MSL_LEGACY_CRYPTO_BUT_USED_WIDEVINE_BEFORE;
    }
}
