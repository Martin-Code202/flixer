package o;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.List;
/* renamed from: o.เ  reason: contains not printable characters */
public class C0700 extends AbstractC0741 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final RectF f14212 = new RectF();

    /* renamed from: ʼ  reason: contains not printable characters */
    private final List<AbstractC0741> f14213 = new ArrayList();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1622coN<Float, Float> f14214;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final RectF f14215 = new RectF();

    public C0700(C1518aux aux, Layer layer, List<Layer> list, C0433 r14) {
        super(aux, layer);
        Layer layer2;
        C0761 r2 = layer.m63();
        if (r2 != null) {
            this.f14214 = r2.mo14241();
            m15134(this.f14214);
            this.f14214.mo5905(this);
        } else {
            this.f14214 = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(r14.m14252().size());
        AbstractC0741 r4 = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            AbstractC0741 r7 = AbstractC0741.m15123(list.get(size), aux, r14);
            if (r7 != null) {
                longSparseArray.put(r7.m15132().m74(), r7);
                if (r4 != null) {
                    r4.m15136(r7);
                    r4 = null;
                } else {
                    this.f14213.add(0, r7);
                    switch (layer2.m72()) {
                        case Add:
                        case Invert:
                            r4 = r7;
                            continue;
                    }
                }
            }
        }
        for (int i = 0; i < longSparseArray.size(); i++) {
            AbstractC0741 r8 = (AbstractC0741) longSparseArray.get(longSparseArray.keyAt(i));
            AbstractC0741 r9 = (AbstractC0741) longSparseArray.get(r8.m15132().m68());
            if (r9 != null) {
                r8.m15133(r9);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC0741
    /* renamed from: ॱ */
    public void mo14760(Canvas canvas, Matrix matrix, int i) {
        C1466If.m5165("CompositionLayer#draw");
        canvas.save();
        this.f14212.set(0.0f, 0.0f, (float) this.f14324.m64(), (float) this.f14324.m62());
        matrix.mapRect(this.f14212);
        for (int size = this.f14213.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.f14212.isEmpty()) {
                z = canvas.clipRect(this.f14212);
            }
            if (z) {
                this.f14213.get(size).mo5647(canvas, matrix, i);
            }
        }
        canvas.restore();
        C1466If.m5166("CompositionLayer#draw");
    }

    @Override // o.AbstractC0741, o.AbstractC0423
    /* renamed from: ॱ */
    public void mo5650(RectF rectF, Matrix matrix) {
        super.mo5650(rectF, matrix);
        this.f14215.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f14213.size() - 1; size >= 0; size--) {
            this.f14213.get(size).mo5650(this.f14215, this.f14319);
            if (rectF.isEmpty()) {
                rectF.set(this.f14215);
            } else {
                rectF.set(Math.min(rectF.left, this.f14215.left), Math.min(rectF.top, this.f14215.top), Math.max(rectF.right, this.f14215.right), Math.max(rectF.bottom, this.f14215.bottom));
            }
        }
    }

    @Override // o.AbstractC0741
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo15013(float f) {
        super.mo15013(f);
        if (this.f14214 != null) {
            f = ((float) ((long) (this.f14214.mo5904().floatValue() * 1000.0f))) / ((float) this.f14321.m5698().m14267());
        }
        if (this.f14324.m70() != 0.0f) {
            f /= this.f14324.m70();
        }
        float r7 = f - this.f14324.m67();
        for (int size = this.f14213.size() - 1; size >= 0; size--) {
            this.f14213.get(size).mo15013(r7);
        }
    }

    @Override // o.AbstractC0741, o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5648(String str, String str2, ColorFilter colorFilter) {
        for (int i = 0; i < this.f14213.size(); i++) {
            AbstractC0741 r3 = this.f14213.get(i);
            String r4 = r3.m15132().m80();
            if (str == null) {
                r3.mo5648((String) null, (String) null, colorFilter);
            } else if (r4.equals(str)) {
                r3.mo5648(str, str2, colorFilter);
            }
        }
    }
}
