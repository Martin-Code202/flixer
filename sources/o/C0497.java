package o;

import android.content.Context;
import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import com.netflix.mediaclient.ui.error.CryptoErrorManager;
import o.AbstractC0472;
/* renamed from: o.н  reason: contains not printable characters */
public class C0497 extends AbstractC0499 {
    public C0497(Context context, AbstractC1221 r8, AbstractC0472.AbstractC0473 r9, CryptoErrorManager cryptoErrorManager) {
        super(context, CryptoProvider.WIDEVINE_L3, r8, r9, cryptoErrorManager);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0476
    public void z_() {
        C1283.m16854("nf_msl", "Set security level L3...");
        AV.m3458(this.f13539);
    }
}
