package o;

import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import com.netflix.mediaclient.util.DeviceCategory;
/* renamed from: o.յ  reason: contains not printable characters */
public class C0540 extends AbstractC0533 {
    C0540() {
        C1283.m16854("ESN", "Widevine L1 SetupBox ESN Provider created...");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0488
    /* renamed from: ॱॱ */
    public DeviceCategory mo14451() {
        return DeviceCategory.ANDROID_STB;
    }

    @Override // o.AbstractC0518
    /* renamed from: ʽ */
    public CryptoProvider mo14530() {
        return CryptoProvider.WIDEVINE_L1;
    }
}
