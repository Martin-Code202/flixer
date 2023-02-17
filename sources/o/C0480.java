package o;

import android.content.Context;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import com.netflix.mediaclient.service.error.crypto.ErrorSource;
import com.netflix.mediaclient.ui.error.CryptoErrorManager;
import java.util.concurrent.atomic.AtomicBoolean;
import o.AbstractC0472;
/* renamed from: o.ϵ  reason: contains not printable characters */
public final class C0480 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static AtomicBoolean f13545 = new AtomicBoolean(false);

    /* renamed from: ˋ  reason: contains not printable characters */
    private static AbstractC0472 f13546;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static synchronized void m14406(CryptoProvider cryptoProvider) {
        synchronized (C0480.class) {
            f13545.set(true);
            f13546 = new C0468(cryptoProvider);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static synchronized void m14407(Context context, CryptoErrorManager cryptoErrorManager, AbstractC1221 r7, AbstractC0472.AbstractC0473 r8) {
        synchronized (C0480.class) {
            if (f13546 == null || f13545.get()) {
                CryptoProvider r3 = r7.d_().mo14530();
                switch (r3) {
                    case LEGACY:
                        if (AV.m3473(context, r7)) {
                            C1283.m16865("nf_msl", "Legacy crypto provider, unable to create Crypto, but Widevine was used before, we may be able to recover");
                            cryptoErrorManager.mo1737(ErrorSource.msl, StatusCode.MSL_LEGACY_CRYPTO_BUT_USED_WIDEVINE_BEFORE, null);
                            r8.mo14373(AbstractC0367.f13230);
                        } else {
                            C1283.m16865("nf_msl", "Legacy crypto provider, unable to create Crypto");
                            r8.mo14373(AbstractC0367.f13227);
                        }
                        return;
                    case WIDEVINE_L1:
                        C1283.m16854("nf_msl", "CryptoManagerRegistry::createCryptoInstance: create CryptoManager Widevine L1 starts...");
                        f13546 = new C0481(context, r7, r8, cryptoErrorManager);
                        break;
                    case WIDEVINE_L3:
                        C1283.m16854("nf_msl", "CryptoManagerRegistry::createCryptoInstance: create CryptoManager Widevine L3 starts...");
                        f13546 = new C0497(context, r7, r8, cryptoErrorManager);
                        break;
                    default:
                        C1283.m16850("nf_msl", "Not supported crypto: " + r3);
                        r8.mo14373(AbstractC0367.f13259);
                        return;
                }
                f13546.mo14355();
                f13545.set(false);
                C1283.m16854("nf_msl", "CryptoManagerRegistry::createCryptoInstance: create CryptoManager done.");
                return;
            }
            C1283.m16850("nf_msl", "CryptoManagerRegistry::createCryptoInstance: CryptoManager can not be instantiated more than once!");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static synchronized AbstractC0472 m14408() {
        AbstractC0472 r0;
        synchronized (C0480.class) {
            r0 = f13546;
        }
        return r0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static synchronized CryptoProvider m14409() {
        synchronized (C0480.class) {
            if (f13546 == null) {
                C1276.m16820().mo5727("CryptoManagerRegistry:: crypto manager is NULL!");
                return null;
            }
            return f13546.mo14358();
        }
    }
}
