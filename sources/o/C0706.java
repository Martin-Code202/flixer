package o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* access modifiers changed from: package-private */
/* renamed from: o.ๅ  reason: contains not printable characters */
public class C0706 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static C0706 f14225;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C0707 f14226;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Handler f14227 = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: o.ๅ.4
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    C0706.this.m15028((C0707) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    });

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Object f14228 = new Object();

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0707 f14229;

    /* access modifiers changed from: package-private */
    /* renamed from: o.ๅ$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˊ  reason: contains not printable characters */
        void mo15034(boolean z);

        /* renamed from: ˋ  reason: contains not printable characters */
        void mo15035(int i);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static C0706 m15022() {
        if (f14225 == null) {
            f14225 = new C0706();
        }
        return f14225;
    }

    private C0706() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15031(int i, Cif ifVar, boolean z) {
        synchronized (this.f14228) {
            if (m15024(ifVar)) {
                this.f14229.f14233 = i;
                this.f14227.removeCallbacksAndMessages(this.f14229);
                m15020(this.f14229);
                return;
            }
            if (m15019(ifVar)) {
                this.f14226.f14233 = i;
            } else {
                this.f14226 = new C0707(i, z, ifVar);
            }
            if (this.f14229 == null || !m15023(this.f14229, 4)) {
                this.f14229 = null;
                m15021(z);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15029(Cif ifVar, int i) {
        synchronized (this.f14228) {
            if (m15024(ifVar)) {
                m15023(this.f14229, i);
            } else if (m15019(ifVar)) {
                m15023(this.f14226, i);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15033(Cif ifVar) {
        synchronized (this.f14228) {
            if (m15024(ifVar)) {
                this.f14229 = null;
                if (this.f14226 != null) {
                    m15021(this.f14226.f14232);
                }
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15027(Cif ifVar) {
        synchronized (this.f14228) {
            if (m15024(ifVar)) {
                m15020(this.f14229);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15032(Cif ifVar) {
        synchronized (this.f14228) {
            if (m15024(ifVar)) {
                this.f14227.removeCallbacksAndMessages(this.f14229);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15026(Cif ifVar) {
        synchronized (this.f14228) {
            if (m15024(ifVar)) {
                m15020(this.f14229);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m15030(Cif ifVar) {
        boolean r0;
        synchronized (this.f14228) {
            r0 = m15024(ifVar);
        }
        return r0;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m15025(Cif ifVar) {
        boolean z;
        synchronized (this.f14228) {
            z = m15024(ifVar) || m15019(ifVar);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ๅ$ˋ  reason: contains not printable characters */
    public static class C0707 {

        /* renamed from: ˊ  reason: contains not printable characters */
        final WeakReference<Cif> f14231;

        /* renamed from: ˎ  reason: contains not printable characters */
        boolean f14232;

        /* renamed from: ॱ  reason: contains not printable characters */
        int f14233;

        C0707(int i, boolean z, Cif ifVar) {
            this.f14231 = new WeakReference<>(ifVar);
            this.f14233 = i;
            this.f14232 = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean m15036(Cif ifVar) {
            return ifVar != null && this.f14231.get() == ifVar;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15021(boolean z) {
        if (this.f14226 != null) {
            this.f14229 = this.f14226;
            this.f14226 = null;
            Cif ifVar = this.f14229.f14231.get();
            if (ifVar != null) {
                ifVar.mo15034(z);
            } else {
                this.f14229 = null;
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m15023(C0707 r3, int i) {
        Cif ifVar = r3.f14231.get();
        if (ifVar == null) {
            return false;
        }
        this.f14227.removeCallbacksAndMessages(r3);
        ifVar.mo15035(i);
        return true;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean m15024(Cif ifVar) {
        return this.f14229 != null && this.f14229.m15036(ifVar);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m15019(Cif ifVar) {
        return this.f14226 != null && this.f14226.m15036(ifVar);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15020(C0707 r6) {
        if (r6.f14233 != -2) {
            int i = 2750;
            if (r6.f14233 > 0) {
                i = r6.f14233;
            } else if (r6.f14233 == -1) {
                i = 1500;
            }
            this.f14227.removeCallbacksAndMessages(r6);
            this.f14227.sendMessageDelayed(Message.obtain(this.f14227, 0, r6), (long) i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15028(C0707 r4) {
        synchronized (this.f14228) {
            if (this.f14229 == r4 || this.f14226 == r4) {
                m15023(r4, 2);
            }
        }
    }
}
