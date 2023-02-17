package o;

import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import com.netflix.mediaclient.util.DeviceCategory;
/* renamed from: o.Ғ  reason: contains not printable characters */
public class C0515 extends AbstractC0533 {
    C0515() {
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0533, o.AbstractC0488
    /* renamed from: ˏॱ */
    public void mo14448() {
        this.f13576 = f13570 + "PRV-";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0533, o.AbstractC0488
    /* renamed from: ॱˊ */
    public String mo14450() {
        return "PRV-" + this.f13740;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0488
    /* renamed from: ॱॱ */
    public DeviceCategory mo14451() {
        return DeviceCategory.TABLET;
    }

    @Override // o.AbstractC0518
    /* renamed from: ʽ  reason: contains not printable characters */
    public CryptoProvider mo14530() {
        return CryptoProvider.WIDEVINE_L1;
    }
}
