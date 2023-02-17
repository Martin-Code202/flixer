package o;

import android.os.Handler;
/* renamed from: o.eH  reason: case insensitive filesystem */
public class C1695eH {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Runnable f6466 = new Runnable() { // from class: o.eH.5
        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - Long.valueOf(C1695eH.this.f6468.mo6079()).longValue() > 300000) {
                C1283.m16854("nf_mdxSessionWatchDog", "MdxSessionWatchDog:  expired");
                C1695eH.this.f6468.mo6080();
                return;
            }
            C1283.m16854("nf_mdxSessionWatchDog", "MdxSessionWatchDog: check if session still alive");
            C1695eH.this.f6467.postDelayed(C1695eH.this.f6466, 300000);
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Handler f6467;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC0108 f6468;

    /* renamed from: o.eH$ˊ  reason: contains not printable characters */
    public interface AbstractC0108 {
        /* renamed from: ͺॱ  reason: contains not printable characters */
        long mo6079();

        /* renamed from: ॱʻ  reason: contains not printable characters */
        void mo6080();
    }

    C1695eH(AbstractC0108 r2, Handler handler) {
        this.f6468 = r2;
        this.f6467 = handler;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6078() {
        C1283.m16854("nf_mdxSessionWatchDog", "MdxSessionWatchDog: start");
        this.f6467.removeCallbacks(this.f6466);
        this.f6467.postDelayed(this.f6466, 300000);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6077() {
        C1283.m16854("nf_mdxSessionWatchDog", "MdxSessionWatchDog: stop");
        this.f6467.removeCallbacks(this.f6466);
    }
}
