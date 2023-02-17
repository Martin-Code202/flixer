package o;

import android.content.Context;
import com.netflix.mediaclient.service.player.StreamProfileType;
/* renamed from: o.it  reason: case insensitive filesystem */
public abstract class AbstractC1892it implements AbstractC1936kg {

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f7798 = -1;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Context f7799;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC2056pe f7800;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f7801 = -1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f7802 = -1;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1221 f7803;

    /* renamed from: ˏ  reason: contains not printable characters */
    public abstract void mo7765(int i);

    public AbstractC1892it(Context context, AbstractC1221 r3, AbstractC2056pe peVar) {
        this.f7799 = context;
        this.f7803 = r3;
        this.f7800 = peVar;
    }

    @Override // o.AbstractC1936kg
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7766(StreamProfileType streamProfileType) {
        int r2 = m7764() ? this.f7802 : C0577.m14686(this.f7799, this.f7803.mo16540(streamProfileType), streamProfileType);
        m7762(m7764() ? this.f7801 : 0, r2);
        mo7765(m7763() ? this.f7798 : r2 < 20000 ? 150000 : 300000);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m7764() {
        return this.f7802 > 0 && this.f7801 >= 0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m7763() {
        return this.f7798 > 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7762(int i, int i2) {
        oM r1 = this.f7800.mo7799();
        if (r1 != null && (r1 instanceof iM)) {
            ((iM) r1).m7493(i, i2);
        }
    }
}
