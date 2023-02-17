package o;

import android.content.Context;
import android.os.Handler;
/* renamed from: o.iw  reason: case insensitive filesystem */
public class C1895iw {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String f7804 = C1895iw.class.getSimpleName();

    /* renamed from: ʽ  reason: contains not printable characters */
    private iR f7805;

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f7806;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f7807;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final lV f7808;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Handler f7809;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private If f7810;

    public C1895iw(Handler handler, lV lVVar) {
        this.f7809 = handler;
        this.f7808 = lVVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7780(Context context, C2003ng ngVar, jM[] jMVarArr) {
        if (jMVarArr == null || jMVarArr.length == 0) {
            C1283.m16865(f7804, " bif url is not valid");
            return;
        }
        this.f7806 = System.currentTimeMillis();
        C1283.m16851(f7804, "DelayedBifHandler - mStartTimeInMs :%d", Long.valueOf(this.f7806));
        if (this.f7810 == null) {
            this.f7810 = new If(context, ngVar, jMVarArr);
            this.f7809.postDelayed(this.f7810, 5000);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m7777(int i) {
        return i >= 500 || System.currentTimeMillis() >= this.f7806 + 30000;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public iR m7781() {
        return this.f7805;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7779() {
        this.f7807 = true;
        if (this.f7805 != null) {
            this.f7805.mo7539();
            this.f7805 = null;
        }
        if (this.f7810 != null) {
            this.f7809.removeCallbacks(this.f7810);
            this.f7810 = null;
        }
    }

    /* renamed from: o.iw$If */
    class If implements Runnable {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final Context f7811;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final jM[] f7813;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final C2003ng f7814;

        public If(Context context, C2003ng ngVar, jM[] jMVarArr) {
            this.f7811 = context;
            this.f7814 = ngVar;
            this.f7813 = jMVarArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C1895iw.this.f7807) {
                if (C1895iw.this.m7777(C1895iw.this.f7808.mo8608())) {
                    C1283.m16851(C1895iw.f7804, "availableBandwidth: %d, downloading bif ...", Integer.valueOf(C1895iw.this.f7808.mo8608()));
                    C1895iw.this.f7805 = new iR(this.f7811, this.f7814, this.f7813);
                }
                if (C1895iw.this.f7805 == null) {
                    C1895iw.this.f7809.postDelayed(this, 5000);
                }
            }
        }
    }
}
