package o;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import o.AbstractC1622coN;
/* renamed from: o.ʽ  reason: contains not printable characters */
public class C0422 implements AbstractC0423, AbstractC1622coN.AbstractC0107 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C1518aux f13400;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final List<AUX> f13401 = new ArrayList();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Path f13402 = new Path();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Paint f13403 = new Paint(1);

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f13404;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1622coN<Integer, Integer> f13405;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AbstractC1622coN<Integer, Integer> f13406;

    public C0422(C1518aux aux, AbstractC0741 r4, C0410 r5) {
        this.f13404 = r5.m14211();
        this.f13400 = aux;
        if (r5.m14214() == null || r5.m14212() == null) {
            this.f13405 = null;
            this.f13406 = null;
            return;
        }
        this.f13402.setFillType(r5.m14213());
        this.f13405 = r5.m14214().mo14241();
        this.f13405.mo5905(this);
        r4.m15134(this.f13405);
        this.f13406 = r5.m14212().mo14241();
        this.f13406.mo5905(this);
        r4.m15134(this.f13406);
    }

    @Override // o.AbstractC1622coN.AbstractC0107
    /* renamed from: ˎ */
    public void mo3789() {
        this.f13400.invalidateSelf();
    }

    @Override // o.AbstractC0420
    /* renamed from: ॱ */
    public void mo3790(List<AbstractC0420> list, List<AbstractC0420> list2) {
        for (int i = 0; i < list2.size(); i++) {
            AbstractC0420 r3 = list2.get(i);
            if (r3 instanceof AUX) {
                this.f13401.add((AUX) r3);
            }
        }
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ */
    public String mo3788() {
        return this.f13404;
    }

    @Override // o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5648(String str, String str2, ColorFilter colorFilter) {
        this.f13403.setColorFilter(colorFilter);
    }

    @Override // o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5647(Canvas canvas, Matrix matrix, int i) {
        C1466If.m5165("FillContent#draw");
        this.f13403.setColor(this.f13405.mo5904().intValue());
        this.f13403.setAlpha((int) ((((((float) i) / 255.0f) * ((float) this.f13406.mo5904().intValue())) / 100.0f) * 255.0f));
        this.f13402.reset();
        for (int i2 = 0; i2 < this.f13401.size(); i2++) {
            this.f13402.addPath(this.f13401.get(i2).mo3438(), matrix);
        }
        canvas.drawPath(this.f13402, this.f13403);
        C1466If.m5166("FillContent#draw");
    }

    @Override // o.AbstractC0423
    /* renamed from: ॱ */
    public void mo5650(RectF rectF, Matrix matrix) {
        this.f13402.reset();
        for (int i = 0; i < this.f13401.size(); i++) {
            this.f13402.addPath(this.f13401.get(i).mo3438(), matrix);
        }
        this.f13402.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
