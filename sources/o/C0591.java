package o;

import android.graphics.PointF;
import java.util.Collections;
import o.AbstractC1622coN;
/* renamed from: o.ٴ  reason: contains not printable characters */
public class C0591 extends AbstractC1622coN<PointF, PointF> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1622coN<Float, Float> f13865;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final PointF f13866 = new PointF();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1622coN<Float, Float> f13867;

    public C0591(AbstractC1622coN<Float, Float> con, AbstractC1622coN<Float, Float> con2) {
        super(Collections.emptyList());
        this.f13867 = con;
        this.f13865 = con2;
    }

    @Override // o.AbstractC1622coN
    /* renamed from: ˎ */
    public void mo5907(float f) {
        this.f13867.mo5907(f);
        this.f13865.mo5907(f);
        this.f13866.set(this.f13867.mo5904().floatValue(), this.f13865.mo5904().floatValue());
        for (int i = 0; i < this.f6318.size(); i++) {
            ((AbstractC1622coN.AbstractC0107) this.f6318.get(i)).mo3789();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public PointF mo5904() {
        return mo4283(null, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public PointF mo4283(C1297AUx<PointF> aUx, float f) {
        return this.f13866;
    }
}
