package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import o.C2025oa;
import o.nY;
/* renamed from: o.oi  reason: case insensitive filesystem */
public abstract class AbstractC2033oi {

    /* renamed from: o.oi$iF */
    public static abstract class iF {
        /* renamed from: ʻ */
        public abstract iF mo9231(float f);

        /* renamed from: ʼ */
        public abstract iF mo9232(float f);

        /* renamed from: ʼ */
        public abstract iF mo9233(long j);

        /* renamed from: ʽ */
        public abstract iF mo9234(float f);

        /* renamed from: ˊ */
        public abstract iF mo9235(float f);

        /* renamed from: ˊ */
        public abstract iF mo9236(int i);

        /* renamed from: ˊ */
        public abstract iF mo9237(long j);

        /* renamed from: ˊ */
        public abstract iF mo9238(String str);

        /* renamed from: ˊॱ */
        public abstract iF mo9239(float f);

        /* renamed from: ˋ */
        public abstract iF mo9240(float f);

        /* renamed from: ˋ */
        public abstract iF mo9241(long j);

        /* renamed from: ˎ */
        public abstract iF mo9242(float f);

        /* renamed from: ˎ */
        public abstract iF mo9243(long j);

        /* renamed from: ˏ */
        public abstract iF mo9244(float f);

        /* renamed from: ˏ */
        public abstract iF mo9245(long j);

        /* renamed from: ˏॱ */
        public abstract iF mo9246(float f);

        /* renamed from: ͺ */
        public abstract iF mo9247(float f);

        /* renamed from: ॱ */
        public abstract iF mo9248(float f);

        /* renamed from: ॱ */
        public abstract iF mo9249(long j);

        /* renamed from: ॱ */
        public abstract iF mo9250(String str);

        /* renamed from: ॱ */
        public abstract AbstractC2033oi mo9251();

        /* renamed from: ॱॱ */
        public abstract iF mo9252(float f);

        /* renamed from: ᐝ */
        public abstract iF mo9253(float f);
    }

    /* renamed from: ʻ */
    public abstract long mo9209();

    /* renamed from: ʻॱ */
    public abstract float mo9210();

    /* renamed from: ʼ */
    public abstract float mo9211();

    /* renamed from: ʼॱ */
    public abstract float mo9212();

    /* renamed from: ʽ */
    public abstract long mo9213();

    /* renamed from: ˈ */
    public abstract float mo9214();

    /* renamed from: ˊ */
    public abstract String mo9215();

    /* renamed from: ˊॱ */
    public abstract float mo9216();

    /* renamed from: ˋ */
    public abstract float mo9217();

    /* renamed from: ˋॱ */
    public abstract long mo9218();

    /* renamed from: ˎ */
    public abstract int mo9219();

    /* renamed from: ˏ */
    public abstract float mo9220();

    /* renamed from: ˏॱ */
    public abstract float mo9221();

    /* renamed from: ͺ */
    public abstract long mo9222();

    /* renamed from: ॱ */
    public abstract String mo9223();

    /* renamed from: ॱˊ */
    public abstract float mo9224();

    /* renamed from: ॱˋ */
    public abstract float mo9225();

    /* renamed from: ॱˎ */
    public abstract float mo9226();

    /* renamed from: ॱॱ */
    public abstract long mo9227();

    /* renamed from: ॱᐝ */
    public abstract float mo9228();

    /* renamed from: ᐝ */
    public abstract long mo9229();

    /* renamed from: ᐝॱ */
    public abstract float mo9230();

    /* renamed from: ʽॱ  reason: contains not printable characters */
    static iF m9652() {
        return new nY.C0152();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static TypeAdapter<AbstractC2033oi> m9653(Gson gson) {
        return new C2025oa.Cif(gson);
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public String m9654() {
        return AE.m3322().toJson(this, AbstractC2033oi.class);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public AbstractC2033oi m9655(float f, float f2, long j, long j2, long j3, long j4, long j5, long j6, float f3, float f4, float f5, float f6, float f7) {
        long r5 = mo9229();
        long r7 = mo9209();
        iF r9 = m9652();
        if (j2 > 0) {
            r9.mo9248((float) (((double) Math.round(((double) (100.0f * (((mo9220() * ((float) r7)) + (((float) (j2 - r7)) * f)) / ((float) j2)))) + 0.005d)) / 100.0d)).mo9242((float) (((double) Math.round(((double) (100.0f * (((mo9224() * ((float) r7)) + (((float) (j2 - r7)) * f4)) / ((float) j2)))) + 0.005d)) / 100.0d)).mo9253((float) (((double) Math.round(((double) (100.0f * (((mo9230() * ((float) r7)) + (((float) (j2 - r7)) * f5)) / ((float) j2)))) + 0.005d)) / 100.0d)).mo9247((float) (((double) Math.round(((double) (100.0f * (((mo9225() * ((float) r7)) + (((float) (j2 - r7)) * f7)) / ((float) j2)))) + 0.005d)) / 100.0d));
        }
        if (j > 0) {
            float r10 = ((mo9217() * ((float) r5)) + (((float) (j - r5)) * f2)) / ((float) j);
            float r11 = ((mo9211() * ((float) r5)) + (((float) (j - r5)) * f3)) / ((float) j);
            r9.mo9240((float) (((double) Math.round(((double) (100.0f * r10)) + 0.005d)) / 100.0d)).mo9244((float) (((double) Math.round(((double) (100.0f * (((mo9216() * ((float) r5)) + (((float) (j - r5)) * f6)) / ((float) j)))) + 0.005d)) / 100.0d)).mo9235((float) (((double) Math.round(((double) (100.0f * r11)) + 0.005d)) / 100.0d));
        }
        r9.mo9250(mo9223()).mo9238(mo9215()).mo9236(mo9219()).mo9237(j).mo9241(j2).mo9249(j3).mo9245(j4).mo9243(j5).mo9233(j6).mo9234(Math.min(mo9226(), f5)).mo9232(Math.max(mo9210(), f5)).mo9231(Math.min(mo9221(), f6)).mo9252(Math.max(mo9228(), f6)).mo9239(Math.min(mo9214(), f7)).mo9246(Math.max(mo9212(), f7));
        return r9.mo9251();
    }
}
