package o;

import android.content.Context;
import android.media.ResourceBusyException;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.service.error.crypto.ErrorSource;
import com.netflix.mediaclient.ui.error.CryptoErrorManagerImpl;
abstract class rD implements AbstractC1578c {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static String f9637 = "nf_crypto_error_handler";

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract ErrorSource mo10138();

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract StatusCode mo10143();

    rD() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public Runnable m10140(final Context context) {
        final AnonymousClass2 r1 = new Runnable() { // from class: o.rD.2
            @Override // java.lang.Runnable
            public void run() {
                C1317As.m3756(context);
            }
        };
        return new Runnable() { // from class: o.rD.3
            @Override // java.lang.Runnable
            public void run() {
                if (CryptoErrorManagerImpl.INSTANCE.m1757(r1)) {
                    C1283.m16854(rD.f9637, "Offline content removal is IN PROGRESS, do NOT kill app yet");
                    return;
                }
                C1283.m16854(rD.f9637, "Offline content removal is not in progress, kill app!");
                C1317As.m3756(context);
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10142(String str) {
        CryptoErrorManagerImpl.INSTANCE.m1755().mo5714(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public int m10141() {
        return CryptoErrorManagerImpl.INSTANCE.m1756(mo10138(), mo10143());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC1268 m10139(Context context, Throwable th) {
        if (th instanceof ResourceBusyException) {
            m10142(CryptoErrorManagerImpl.m1749(mo10143(), th, C1339Bl.m4037(context, "max_msl_drm_session_count", 0)));
        } else {
            m10142(CryptoErrorManagerImpl.m1752(mo10143(), th));
        }
        return C1061.m16114().mo14162().mo1765(context, mo10143(), m10140(context), m10141());
    }
}
