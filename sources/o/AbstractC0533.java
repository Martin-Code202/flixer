package o;

import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import com.netflix.mediaclient.util.DeviceCategory;
/* renamed from: o.Ԇ  reason: contains not printable characters */
public abstract class AbstractC0533 extends AbstractC0488 {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private byte[] f13739;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected String f13740;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected String f13741;

    AbstractC0533() {
        iF iFVar = new iF(mo14530());
        byte[] r3 = iFVar.m14582();
        this.f13740 = iFVar.m14581();
        this.f13739 = r3;
        if (r3 == null) {
            throw new IllegalArgumentException("MediaDrm.uniqueDeviceId is null! We can not use this ESN implementation!");
        }
        this.f13741 = m14580();
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private String m14580() {
        StringBuilder sb = new StringBuilder("PRV-");
        if (mo14451() == DeviceCategory.PHONE) {
            sb.append("P-");
        } else if (mo14451() == DeviceCategory.TABLET) {
            sb.append("T-");
        } else if (mo14451() == DeviceCategory.CHROME_OS) {
            sb.append("C-");
        } else if (mo14451() == DeviceCategory.ANDROID_STB) {
            sb.append("B-");
        }
        if (mo14530() == CryptoProvider.WIDEVINE_L3) {
            sb.append("L3-");
        }
        String str = Build.MODEL;
        if (str.length() > 45) {
            str = str.substring(0, 45);
        }
        sb.append(m14427(m14440() + C1349Bv.m4110(str, f13572)));
        sb.append("-");
        sb.append(this.f13740);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0488
    /* renamed from: ˏॱ */
    public void mo14448() {
        int lastIndexOf;
        StringBuilder sb = new StringBuilder(f13570);
        sb.append("PRV-");
        if (mo14451() == DeviceCategory.PHONE) {
            sb.append("P-");
        } else if (mo14451() == DeviceCategory.TABLET) {
            sb.append("T-");
        } else if (mo14451() == DeviceCategory.CHROME_OS) {
            sb.append("C-");
        } else if (mo14451() == DeviceCategory.ANDROID_STB) {
            sb.append("B-");
        }
        if (mo14530() == CryptoProvider.WIDEVINE_L3) {
            sb.append("L3-");
        }
        this.f13576 = sb.toString();
        if (this.f13576.endsWith("-") && (lastIndexOf = this.f13576.lastIndexOf("-") + 1) > 0) {
            this.f13576 = this.f13576.substring(0, lastIndexOf);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0488
    /* renamed from: ॱˊ */
    public String mo14450() {
        return this.f13741;
    }

    @Override // o.AbstractC0518
    /* renamed from: ʻ */
    public String mo14537() {
        return this.f13740;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0488
    /* renamed from: ˊ */
    public byte[] mo14443(Context context) {
        return this.f13739;
    }

    /* renamed from: o.Ԇ$iF */
    static class iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f13742;

        /* renamed from: ˏ  reason: contains not printable characters */
        private byte[] f13743;

        public iF(CryptoProvider cryptoProvider) {
            MediaDrm mediaDrm = new MediaDrm(AV.f4319);
            if (cryptoProvider == CryptoProvider.WIDEVINE_L3) {
                C1283.m16854("ESN", "Setting security level to L3");
                AV.m3458(mediaDrm);
            }
            this.f13743 = AV.m3465(mediaDrm);
            this.f13742 = AV.m3470(mediaDrm);
            mediaDrm.release();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public byte[] m14582() {
            return this.f13743;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public String m14581() {
            return this.f13742;
        }
    }
}
