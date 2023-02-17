package o;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import com.netflix.mediaclient.ui.error.CryptoErrorManager;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import o.AbstractC0472;
@TargetApi(18)
/* renamed from: o.п  reason: contains not printable characters */
public abstract class AbstractC0499 extends AbstractC0476 {

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public static final UUID f13619 = AV.f4319;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private AtomicBoolean f13620 = new AtomicBoolean(false);

    /* renamed from: o.п$iF */
    public interface iF {
        /* renamed from: ˏ */
        void mo8078();

        /* renamed from: ˏ */
        void mo8079(byte[] bArr);
    }

    AbstractC0499(Context context, CryptoProvider cryptoProvider, AbstractC1221 r5, AbstractC0472.AbstractC0473 r6, CryptoErrorManager cryptoErrorManager) {
        super(context, cryptoProvider, r5, r6, cryptoErrorManager);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0476
    /* renamed from: ॱ */
    public void mo14405() {
    }

    @Override // o.AbstractC0472
    /* renamed from: ˊ */
    public void mo14355() {
        C1283.m16854("nf_msl", "MSLWidevineCryptoManager::init:");
        if (m14478()) {
            C1283.m16854("nf_msl", "MSLWidevineCryptoManager::init: Widevine is provisioned");
        }
    }

    @Override // o.AbstractC0472
    /* renamed from: ˎ */
    public CryptoProvider mo14358() {
        return this.f13531;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean m14478() {
        try {
            this.f13539.closeSession(this.f13539.openSession());
        } catch (NotProvisionedException e) {
            C1283.m16856("nf_msl", e, "Device is not provisioned, start provisioning workflow!", new Object[0]);
            m14477();
            return false;
        } catch (Throwable th) {
            C1283.m16856("nf_msl", th, "Fatal error, can not recover!", new Object[0]);
            this.f13534.mo14373(AbstractC0367.f13217);
            return false;
        }
        C1283.m16854("nf_msl", "Ready!");
        this.f13534.mo14374();
        return true;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m14477() {
        MediaDrm.ProvisionRequest provisionRequest;
        synchronized (this.f13620) {
            this.f13620.set(false);
        }
        try {
            provisionRequest = this.f13539.getProvisionRequest();
        } catch (Throwable th) {
            if (m14403(th)) {
                provisionRequest = this.f13539.getProvisionRequest();
            } else {
                throw th;
            }
        }
        final String defaultUrl = provisionRequest.getDefaultUrl();
        new AsyncTaskC0486(provisionRequest.getData(), new iF() { // from class: o.п.5
            @Override // o.AbstractC0499.iF
            /* renamed from: ˏ */
            public void mo8079(byte[] bArr) {
                if (bArr != null) {
                    try {
                        AbstractC0499.this.f13539.provideProvisionResponse(bArr);
                        AbstractC0499.this.mo14355();
                    } catch (DeniedByServerException e) {
                        C1283.m16856("nf_msl", e, "Server declined Widewine provisioning request. Server URL: " + defaultUrl, new Object[0]);
                        AbstractC0499.this.f13534.mo14373(AbstractC0367.f13226);
                    } catch (Throwable th2) {
                        C1283.m16856("nf_msl", th2, "Fatal error on seting Widewine provisioning response", new Object[0]);
                        if (AbstractC0499.this.f13534 != null) {
                            AbstractC0499.this.f13534.mo14373(AbstractC0367.f13217);
                        }
                    }
                } else {
                    C1283.m16850("nf_msl", "Failed to get provisiong certificate");
                    AbstractC0499.this.f13534.mo14373(AbstractC0367.f13217);
                }
            }

            @Override // o.AbstractC0499.iF
            /* renamed from: ˏ */
            public void mo8078() {
                C1283.m16850("nf_msl", "Blacklisted Widevine plugin? Do NOT use it!");
                AbstractC0499.this.m14479();
                AbstractC0499.this.f13534.mo14373(AbstractC0367.f13233);
                C1276.m16820().mo5727("15002. Provisiong failed with status code 400 " + defaultUrl);
            }
        }).execute(provisionRequest.getDefaultUrl());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺ  reason: contains not printable characters */
    private void m14479() {
        if (mo14358() == CryptoProvider.WIDEVINE_L1) {
            C1283.m16854("nf_msl", "MediaDrm failed for Widevine L1, fail back to Widevine L3");
            C1339Bl.m4048(this.f13538, "disable_widevine", true);
        } else if (mo14358() == CryptoProvider.WIDEVINE_L3) {
            C1283.m16854("nf_msl", "MediaDrm failed for Widevine L3, fail back to legacy crypto scheme ");
            C1339Bl.m4048(this.f13538, "nf_disable_widevine_l3_v3", true);
        } else {
            C1283.m16850("nf_msl", "Crypto provider was not supported for this error " + mo14358());
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0476
    /* renamed from: ˋ */
    public String mo14398() {
        return "nf_msl";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0476
    public UUID y_() {
        return f13619;
    }
}
