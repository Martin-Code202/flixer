package o;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
/* renamed from: o.Eo  reason: case insensitive filesystem */
public class C1425Eo implements SensorEventListener {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f5542;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0089 f5543;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1426iF f5544;

    /* renamed from: o.Eo$iF  reason: case insensitive filesystem */
    public interface AbstractC1426iF {
        /* renamed from: ˋ  reason: contains not printable characters */
        void m4907();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean r1 = m4904(sensorEvent);
        this.f5543.m4910(sensorEvent.timestamp, r1);
        if (this.f5543.m4911()) {
            this.f5543.m4908();
            this.f5544.m4907();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m4904(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        return ((double) (((f * f) + (f2 * f2)) + (f3 * f3))) > ((double) (this.f5542 * this.f5542));
    }

    /* renamed from: o.Eo$ˋ  reason: contains not printable characters */
    static class C0089 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private int f5549;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final If f5550 = new If();

        /* renamed from: ˎ  reason: contains not printable characters */
        private Cif f5551;

        /* renamed from: ˏ  reason: contains not printable characters */
        private Cif f5552;

        /* renamed from: ॱ  reason: contains not printable characters */
        private int f5553;

        C0089() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public void m4910(long j, boolean z) {
            m4909(j - 500000000);
            Cif r2 = this.f5550.m4905();
            r2.f5547 = j;
            r2.f5546 = z;
            r2.f5548 = null;
            if (this.f5552 != null) {
                this.f5552.f5548 = r2;
            }
            this.f5552 = r2;
            if (this.f5551 == null) {
                this.f5551 = r2;
            }
            this.f5553++;
            if (z) {
                this.f5549++;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public void m4908() {
            while (this.f5551 != null) {
                Cif ifVar = this.f5551;
                this.f5551 = ifVar.f5548;
                this.f5550.m4906(ifVar);
            }
            this.f5552 = null;
            this.f5553 = 0;
            this.f5549 = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public void m4909(long j) {
            while (this.f5553 >= 4 && this.f5551 != null && j - this.f5551.f5547 > 0) {
                Cif ifVar = this.f5551;
                if (ifVar.f5546) {
                    this.f5549--;
                }
                this.f5553--;
                this.f5551 = ifVar.f5548;
                if (this.f5551 == null) {
                    this.f5552 = null;
                }
                this.f5550.m4906(ifVar);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public boolean m4911() {
            return this.f5552 != null && this.f5551 != null && this.f5552.f5547 - this.f5551.f5547 >= 250000000 && this.f5549 >= (this.f5553 >> 1) + (this.f5553 >> 2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.Eo$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        boolean f5546;

        /* renamed from: ˎ  reason: contains not printable characters */
        long f5547;

        /* renamed from: ˏ  reason: contains not printable characters */
        Cif f5548;

        Cif() {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.Eo$If */
    public static class If {

        /* renamed from: ॱ  reason: contains not printable characters */
        private Cif f5545;

        If() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public Cif m4905() {
            Cif ifVar = this.f5545;
            if (ifVar == null) {
                return new Cif();
            }
            this.f5545 = ifVar.f5548;
            return ifVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public void m4906(Cif ifVar) {
            ifVar.f5548 = this.f5545;
            this.f5545 = ifVar;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
