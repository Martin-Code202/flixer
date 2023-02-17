package o;

import com.netflix.mediaclient.media.Watermark;
import com.netflix.mediaclient.servicemgr.IPlayer;
import java.util.ArrayList;
import java.util.List;
import o.oM;
public class iG {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f7517 = iE.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private C0122 f7518 = new C0122();

    /* renamed from: ʼ  reason: contains not printable characters */
    private C0125 f7519 = new C0125();

    /* renamed from: ʽ  reason: contains not printable characters */
    private C0124 f7520 = new C0124();

    /* renamed from: ˊ  reason: contains not printable characters */
    private C0126 f7521 = new C0126();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<oM.AbstractC0160> f7522 = new ArrayList();

    /* renamed from: ˏ  reason: contains not printable characters */
    private IF f7523 = new IF();

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1873iF f7524 = new C1873iF();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C1872If f7525 = new C1872If();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Cif f7526 = new Cif();

    /* renamed from: o.iG$ˋ  reason: contains not printable characters */
    public interface AbstractC0123 {
        /* renamed from: ॱ */
        void mo7439(oM.AbstractC0160 v, Object... objArr);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m7435(oM.AbstractC0160 r2) {
        if (r2 != null) {
            if (!this.f7522.contains(r2)) {
                this.f7522.add(r2);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m7432(oM.AbstractC0160 r2) {
        this.f7522.remove(r2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized List<oM.AbstractC0160> m7433() {
        return this.f7522;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.iG$ᐝ  reason: contains not printable characters */
    public class C0126 implements AbstractC0123 {
        private C0126() {
        }

        @Override // o.iG.AbstractC0123
        /* renamed from: ॱ */
        public void mo7439(oM.AbstractC0160 r3, Object... objArr) {
            if (!r3.ae_()) {
                return;
            }
            if (objArr == null || objArr.length < 1 || !(objArr[0] instanceof Watermark)) {
                r3.mo2353((Watermark) null);
            } else {
                r3.mo2353((Watermark) objArr[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.iG$iF  reason: case insensitive filesystem */
    public class C1873iF implements AbstractC0123 {
        private C1873iF() {
        }

        @Override // o.iG.AbstractC0123
        /* renamed from: ॱ */
        public void mo7439(oM.AbstractC0160 r2, Object... objArr) {
            if (r2.ae_()) {
                r2.ad_();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.iG$ˎ  reason: contains not printable characters */
    public class C0124 implements AbstractC0123 {
        private C0124() {
        }

        @Override // o.iG.AbstractC0123
        /* renamed from: ॱ */
        public void mo7439(oM.AbstractC0160 r2, Object... objArr) {
            if (r2.ae_()) {
                r2.ac_();
            }
        }
    }

    /* renamed from: o.iG$if  reason: invalid class name */
    class Cif implements AbstractC0123 {
        private Cif() {
        }

        @Override // o.iG.AbstractC0123
        /* renamed from: ॱ */
        public void mo7439(oM.AbstractC0160 r2, Object... objArr) {
            if (r2.ae_()) {
                r2.mo2351(IPlayer.PlayerStallReason.avStalled);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.iG$ˏ  reason: contains not printable characters */
    public class C0125 implements AbstractC0123 {
        private C0125() {
        }

        @Override // o.iG.AbstractC0123
        /* renamed from: ॱ */
        public void mo7439(oM.AbstractC0160 r3, Object... objArr) {
            if (r3.ae_() && objArr != null && objArr.length >= 1 && (objArr[0] instanceof C1987mr)) {
                r3.mo2354((C1987mr) objArr[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.iG$If  reason: case insensitive filesystem */
    public class C1872If implements AbstractC0123 {
        private C1872If() {
        }

        @Override // o.iG.AbstractC0123
        /* renamed from: ॱ */
        public void mo7439(oM.AbstractC0160 r3, Object... objArr) {
            if (r3.ae_() && objArr != null && objArr.length >= 1 && (objArr[0] instanceof IPlayer.aux)) {
                r3.mo2352((IPlayer.aux) objArr[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class IF implements AbstractC0123 {
        private IF() {
        }

        @Override // o.iG.AbstractC0123
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo7439(oM.AbstractC0160 r3, Object... objArr) {
            if (r3.ae_() && objArr != null && objArr.length >= 1) {
                r3.mo2355((long) ((Integer) objArr[0]).intValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.iG$ˊ  reason: contains not printable characters */
    public class C0122 implements AbstractC0123 {
        private C0122() {
        }

        @Override // o.iG.AbstractC0123
        /* renamed from: ॱ */
        public void mo7439(oM.AbstractC0160 r2, Object... objArr) {
            if (r2.ae_()) {
                r2.mo2356();
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0126 m7437() {
        return this.f7521;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public IF m7436() {
        return this.f7523;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1873iF m7431() {
        return this.f7524;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public Cif m7434() {
        return this.f7526;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public C0124 m7429() {
        return this.f7520;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public C0125 m7438() {
        return this.f7519;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public C1872If m7430() {
        return this.f7525;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public C0122 m7428() {
        return this.f7518;
    }
}
