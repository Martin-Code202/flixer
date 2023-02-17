package o;

import android.content.Context;
import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import com.netflix.mediaclient.service.configuration.esn.WidevineNotSupportedException;
import com.netflix.mediaclient.util.DeviceCategory;
/* renamed from: o.ѵ  reason: contains not printable characters */
public final class C0511 {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static AbstractC0518 m14529(Context context, AbstractC1221 r7) {
        AbstractC0488 r3;
        C1283.m16854("nf_esn", "Create ESN");
        C1283.m16854("nf_esn", "JB MR2+ device with Widewine support, return ESN CDM implementation!");
        CryptoProvider r4 = AV.m3456(context, r7);
        if (AV.m3461()) {
            C1283.m16854("nf_esn", "JB MR2+ device with legacy Widewine support, return ESN CDM Nexus 7 implementation!");
            r3 = new C0515();
        } else {
            DeviceCategory r5 = r7.mo16541();
            if (r4 == CryptoProvider.LEGACY) {
                throw new WidevineNotSupportedException();
            } else if (r4 == CryptoProvider.WIDEVINE_L1) {
                r3 = m14527(r5);
            } else if (r4 == CryptoProvider.WIDEVINE_L3) {
                r3 = m14528(r5);
            } else {
                throw new IllegalStateException("Not able to create ESN provider for not supported combination. Device category: " + r5 + ", Crypto provider: " + r4);
            }
        }
        r3.m14446(context);
        return r3;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static AbstractC0488 m14527(DeviceCategory deviceCategory) {
        if (deviceCategory == DeviceCategory.PHONE) {
            return new C0568();
        }
        if (deviceCategory == DeviceCategory.TABLET) {
            return new C0565();
        }
        if (deviceCategory == DeviceCategory.CHROME_OS) {
            return new C0541();
        }
        if (deviceCategory == DeviceCategory.ANDROID_STB || deviceCategory == DeviceCategory.ANDROID_TV) {
            return new C0540();
        }
        throw new IllegalStateException("Not able to create ESN provider for not supported combination. Device category: " + deviceCategory + ", Crypto provider: Widevine L1");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static AbstractC0488 m14528(DeviceCategory deviceCategory) {
        if (deviceCategory == DeviceCategory.PHONE) {
            return new C0570();
        }
        if (deviceCategory == DeviceCategory.TABLET) {
            return new C0596();
        }
        if (deviceCategory == DeviceCategory.CHROME_OS) {
            return new C0543();
        }
        if (deviceCategory == DeviceCategory.ANDROID_STB || deviceCategory == DeviceCategory.ANDROID_TV) {
            return new C0612();
        }
        throw new IllegalStateException("Not able to create ESN provider for not supported combination. Device category: " + deviceCategory + ", Crypto provider: Widevine L1");
    }
}
