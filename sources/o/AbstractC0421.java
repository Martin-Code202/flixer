package o;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
import o.AbstractC1622coN;
/* renamed from: o.ʼ  reason: contains not printable characters */
public abstract class AbstractC0421 implements AbstractC0423, AbstractC1622coN.AbstractC0107 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final List<If> f13386 = new ArrayList();

    /* renamed from: ʼ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Integer> f13387;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final float[] f13388;

    /* renamed from: ˊ  reason: contains not printable characters */
    final Paint f13389 = new Paint(1);

    /* renamed from: ˋ  reason: contains not printable characters */
    private final PathMeasure f13390 = new PathMeasure();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f13391;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Path f13392 = new Path();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Path f13393 = new Path();

    /* renamed from: ͺ  reason: contains not printable characters */
    private final List<AbstractC1622coN<?, Float>> f13394;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final RectF f13395 = new RectF();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f13396;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final C1518aux f13397;

    AbstractC0421(C1518aux aux, AbstractC0741 r5, Paint.Cap cap, Paint.Join join, C0747 r8, C0761 r9, List<C0761> list, C0761 r11) {
        this.f13397 = aux;
        this.f13389.setStyle(Paint.Style.STROKE);
        this.f13389.setStrokeCap(cap);
        this.f13389.setStrokeJoin(join);
        this.f13387 = r8.mo14241();
        this.f13396 = r9.mo14241();
        if (r11 == null) {
            this.f13391 = null;
        } else {
            this.f13391 = r11.mo14241();
        }
        this.f13394 = new ArrayList(list.size());
        this.f13388 = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.f13394.add(list.get(i).mo14241());
        }
        r5.m15134(this.f13387);
        r5.m15134(this.f13396);
        for (int i2 = 0; i2 < this.f13394.size(); i2++) {
            r5.m15134(this.f13394.get(i2));
        }
        if (this.f13391 != null) {
            r5.m15134(this.f13391);
        }
        this.f13387.mo5905(this);
        this.f13396.mo5905(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f13394.get(i3).mo5905(this);
        }
        if (this.f13391 != null) {
            this.f13391.mo5905(this);
        }
    }

    @Override // o.AbstractC1622coN.AbstractC0107
    /* renamed from: ˎ */
    public void mo3789() {
        this.f13397.invalidateSelf();
    }

    @Override // o.AbstractC0420
    /* renamed from: ॱ */
    public void mo3790(List<AbstractC0420> list, List<AbstractC0420> list2) {
        C1354COn cOn = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            AbstractC0420 r4 = list.get(size);
            if ((r4 instanceof C1354COn) && ((C1354COn) r4).m4285() == ShapeTrimPath.Type.Individually) {
                cOn = (C1354COn) r4;
            }
        }
        if (cOn != null) {
            cOn.m4286(this);
        }
        If r3 = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            AbstractC0420 r5 = list2.get(size2);
            if ((r5 instanceof C1354COn) && ((C1354COn) r5).m4285() == ShapeTrimPath.Type.Individually) {
                if (r3 != null) {
                    this.f13386.add(r3);
                }
                r3 = new If((C1354COn) r5);
                ((C1354COn) r5).m4286(this);
            } else if (r5 instanceof AUX) {
                if (r3 == null) {
                    r3 = new If(cOn);
                }
                r3.f13399.add((AUX) r5);
            }
        }
        if (r3 != null) {
            this.f13386.add(r3);
        }
    }

    @Override // o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5647(Canvas canvas, Matrix matrix, int i) {
        C1466If.m5165("StrokeContent#draw");
        this.f13389.setAlpha((int) ((((((float) i) / 255.0f) * ((float) this.f13387.mo5904().intValue())) / 100.0f) * 255.0f));
        this.f13389.setStrokeWidth(this.f13396.mo5904().floatValue() * C1026.m16010(matrix));
        if (this.f13389.getStrokeWidth() <= 0.0f) {
            C1466If.m5166("StrokeContent#draw");
            return;
        }
        m14227(matrix);
        for (int i2 = 0; i2 < this.f13386.size(); i2++) {
            If r5 = this.f13386.get(i2);
            if (r5.f13398 != null) {
                m14226(canvas, r5, matrix);
            } else {
                C1466If.m5165("StrokeContent#buildPath");
                this.f13392.reset();
                for (int size = r5.f13399.size() - 1; size >= 0; size--) {
                    this.f13392.addPath(((AUX) r5.f13399.get(size)).mo3438(), matrix);
                }
                C1466If.m5166("StrokeContent#buildPath");
                C1466If.m5165("StrokeContent#drawPath");
                canvas.drawPath(this.f13392, this.f13389);
                C1466If.m5166("StrokeContent#drawPath");
            }
        }
        C1466If.m5166("StrokeContent#draw");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m14226(Canvas canvas, If r14, Matrix matrix) {
        float f;
        float f2;
        float f3;
        C1466If.m5165("StrokeContent#applyTrimPath");
        if (r14.f13398 == null) {
            C1466If.m5166("StrokeContent#applyTrimPath");
            return;
        }
        this.f13392.reset();
        for (int size = r14.f13399.size() - 1; size >= 0; size--) {
            this.f13392.addPath(((AUX) r14.f13399.get(size)).mo3438(), matrix);
        }
        this.f13390.setPath(this.f13392, false);
        float length = this.f13390.getLength();
        while (this.f13390.nextContour()) {
            length += this.f13390.getLength();
        }
        float floatValue = (r14.f13398.m4289().mo5904().floatValue() * length) / 360.0f;
        float floatValue2 = ((r14.f13398.m4288().mo5904().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((r14.f13398.m4287().mo5904().floatValue() * length) / 100.0f) + floatValue;
        float f4 = 0.0f;
        for (int size2 = r14.f13399.size() - 1; size2 >= 0; size2--) {
            this.f13393.set(((AUX) r14.f13399.get(size2)).mo3438());
            this.f13393.transform(matrix);
            this.f13390.setPath(this.f13393, false);
            float length2 = this.f13390.getLength();
            if (floatValue3 > length && floatValue3 - length < f4 + length2 && f4 < floatValue3 - length) {
                if (floatValue2 > length) {
                    f3 = (floatValue2 - length) / length2;
                } else {
                    f3 = 0.0f;
                }
                C1026.m16014(this.f13393, f3, Math.min((floatValue3 - length) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.f13393, this.f13389);
            } else if (f4 + length2 >= floatValue2 && f4 <= floatValue3) {
                if (f4 + length2 > floatValue3 || floatValue2 >= f4) {
                    if (floatValue2 < f4) {
                        f = 0.0f;
                    } else {
                        f = (floatValue2 - f4) / length2;
                    }
                    if (floatValue3 > f4 + length2) {
                        f2 = 1.0f;
                    } else {
                        f2 = (floatValue3 - f4) / length2;
                    }
                    C1026.m16014(this.f13393, f, f2, 0.0f);
                    canvas.drawPath(this.f13393, this.f13389);
                } else {
                    canvas.drawPath(this.f13393, this.f13389);
                }
            }
            f4 += length2;
        }
        C1466If.m5166("StrokeContent#applyTrimPath");
    }

    @Override // o.AbstractC0423
    /* renamed from: ॱ */
    public void mo5650(RectF rectF, Matrix matrix) {
        C1466If.m5165("StrokeContent#getBounds");
        this.f13392.reset();
        for (int i = 0; i < this.f13386.size(); i++) {
            If r7 = this.f13386.get(i);
            for (int i2 = 0; i2 < r7.f13399.size(); i2++) {
                this.f13392.addPath(((AUX) r7.f13399.get(i2)).mo3438(), matrix);
            }
        }
        this.f13392.computeBounds(this.f13395, false);
        float floatValue = this.f13396.mo5904().floatValue();
        this.f13395.set(this.f13395.left - (floatValue / 2.0f), this.f13395.top - (floatValue / 2.0f), this.f13395.right + (floatValue / 2.0f), this.f13395.bottom + (floatValue / 2.0f));
        rectF.set(this.f13395);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        C1466If.m5166("StrokeContent#getBounds");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14227(Matrix matrix) {
        C1466If.m5165("StrokeContent#applyDashPattern");
        if (this.f13394.isEmpty()) {
            C1466If.m5166("StrokeContent#applyDashPattern");
            return;
        }
        float r3 = C1026.m16010(matrix);
        for (int i = 0; i < this.f13394.size(); i++) {
            this.f13388[i] = this.f13394.get(i).mo5904().floatValue();
            if (i % 2 == 0) {
                if (this.f13388[i] < 1.0f) {
                    this.f13388[i] = 1.0f;
                }
            } else if (this.f13388[i] < 0.1f) {
                this.f13388[i] = 0.1f;
            }
            float[] fArr = this.f13388;
            fArr[i] = fArr[i] * r3;
        }
        this.f13389.setPathEffect(new DashPathEffect(this.f13388, this.f13391 == null ? 0.0f : this.f13391.mo5904().floatValue()));
        C1466If.m5166("StrokeContent#applyDashPattern");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ʼ$If */
    public static final class If {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final C1354COn f13398;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final List<AUX> f13399;

        private If(C1354COn cOn) {
            this.f13399 = new ArrayList();
            this.f13398 = cOn;
        }
    }
}
