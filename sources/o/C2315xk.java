package o;

import android.os.Process;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
/* renamed from: o.xk  reason: case insensitive filesystem */
public class C2315xk extends C2318xn {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f12193 = 12;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final int f12194 = 12;

    /* renamed from: ͺ  reason: contains not printable characters */
    private Thread f12195;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final int f12196 = 300;

    public C2315xk(IPlayerFragment iPlayerFragment) {
        super(iPlayerFragment);
        C1283.m16854(f12213, "PostPlayWithAnimation");
        m12939();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m12939() {
        int r8 = AD.m3317(this.f12222.mo2269());
        this.f12216 = new Cif(500, 0, 0, 1.0f, C1004.m15954(this.f12222.mo2269(), 12), C1004.m15954(this.f12222.mo2269(), 12), ((float) C1004.m15954(this.f12222.mo2269(), 300)) / ((float) r8));
    }

    /* access modifiers changed from: protected */
    @Override // o.C2318xn
    /* renamed from: ˏ  reason: contains not printable characters */
    public Cif mo12940() {
        return this.f12216;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o.xk$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ʻ  reason: contains not printable characters */
        private int f12202;

        /* renamed from: ˊ  reason: contains not printable characters */
        private int f12203;

        /* renamed from: ˋ  reason: contains not printable characters */
        private int f12204;

        /* renamed from: ˎ  reason: contains not printable characters */
        private int f12205;

        /* renamed from: ˏ  reason: contains not printable characters */
        private float f12206;

        /* renamed from: ॱ  reason: contains not printable characters */
        private int f12207;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private float f12208;

        public Cif(int i, int i2, int i3, float f, int i4, int i5, float f2) {
            this.f12203 = i;
            this.f12205 = i2;
            this.f12207 = i3;
            this.f12206 = f;
            this.f12204 = i4;
            this.f12202 = i5;
            this.f12208 = f2;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public int m12943() {
            return this.f12203;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public int m12947() {
            return this.f12205;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public int m12944() {
            return this.f12207;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public float m12945() {
            return this.f12206;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public int m12946() {
            return this.f12204;
        }

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public int m12948() {
            return this.f12202;
        }

        /* renamed from: ʻ  reason: contains not printable characters */
        public float m12942() {
            return this.f12208;
        }
    }

    /* renamed from: o.xk$If */
    class If implements Runnable {

        /* renamed from: ˊ  reason: contains not printable characters */
        private Cif f12197;

        /* renamed from: ˋ  reason: contains not printable characters */
        private Runnable f12198;

        /* renamed from: ˎ  reason: contains not printable characters */
        private boolean f12199;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final int f12200;

        private If(Cif ifVar, Runnable runnable) {
            this.f12200 = 20;
            if (ifVar == null) {
                throw new IllegalArgumentException("Parameters can not be null");
            }
            this.f12197 = ifVar;
            this.f12198 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-1);
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            int r7 = this.f12197.m12943() / 20;
            float abs = ((float) Math.abs(this.f12197.m12944() - this.f12197.m12948())) / ((float) r7);
            float abs2 = ((float) Math.abs(this.f12197.m12947() - this.f12197.m12946())) / ((float) r7);
            float abs3 = Math.abs(this.f12197.m12945() - this.f12197.m12942()) / ((float) r7);
            int i2 = 1;
            if (this.f12197.m12944() > this.f12197.m12948()) {
                i2 = -1;
            }
            int i3 = 1;
            if (this.f12197.m12947() > this.f12197.m12946()) {
                i3 = -1;
            }
            int i4 = 1;
            if (this.f12197.m12945() < this.f12197.m12942()) {
                i4 = -1;
            }
            this.f12199 = true;
            while (this.f12199) {
                C1283.m16854(C2318xn.f12213, "in loop");
                if (System.currentTimeMillis() - currentTimeMillis >= ((long) this.f12197.m12943())) {
                    C1283.m16854(C2318xn.f12213, "Exit!");
                    this.f12199 = false;
                } else {
                    i++;
                    C2315xk.this.m12952(this.f12197.m12947() + ((int) m12941(abs2, (float) i, (float) i3)), this.f12197.m12944() + ((int) m12941(abs, (float) i, (float) i2)), this.f12197.m12945() - ((((float) i) * abs3) * ((float) i4)));
                    try {
                        C1283.m16854(C2318xn.f12213, "Sleep");
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        C1283.m16854(C2318xn.f12213, "Interupped");
                        this.f12199 = false;
                    }
                }
            }
            C2315xk.this.m12952(this.f12197.m12946(), this.f12197.m12948(), this.f12197.m12942());
            if (this.f12198 != null) {
                C2315xk.this.f12222.mo2235(this.f12198);
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private float m12941(float f, float f2, float f3) {
            return f * f2 * f3;
        }
    }

    @Override // o.C2318xn, o.AbstractC2311xg
    /* renamed from: ˊ */
    public void mo12926() {
        m12951(this.f12219.mo15742());
        m12951(this.f12220);
        if (this.f12219 != null) {
            this.f12219.mo15742().setBackgroundResource(R.drawable.post_play_video_border);
            this.f12219.mo15742().setPadding(1, 1, 1, 1);
        }
        this.f12218 = m12954();
        this.f12195 = new Thread(new If(mo12940(), null));
        this.f12195.start();
    }
}
