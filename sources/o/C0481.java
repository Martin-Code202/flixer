package o;

import android.content.Context;
import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import com.netflix.mediaclient.ui.error.CryptoErrorManager;
import o.AbstractC0472;
/* renamed from: o.Ϲ  reason: contains not printable characters */
public class C0481 extends AbstractC0499 {
    public C0481(Context context, AbstractC1221 r8, AbstractC0472.AbstractC0473 r9, CryptoErrorManager cryptoErrorManager) {
        super(context, CryptoProvider.WIDEVINE_L1, r8, r9, cryptoErrorManager);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0476
    public void z_() {
        C1283.m16854("nf_msl", "No need to set security level L1...");
    }
}
