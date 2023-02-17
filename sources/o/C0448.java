package o;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
import o.AbstractC1622coN;
/* renamed from: o.ͺ  reason: contains not printable characters */
public class C0448 implements AbstractC0423, AbstractC1622coN.AbstractC0107 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final GradientType f13487;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final RectF f13488 = new RectF();

    /* renamed from: ʽ  reason: contains not printable characters */
    private final List<AUX> f13489 = new ArrayList();

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f13490;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final AbstractC1622coN<Integer, Integer> f13491;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final LongSparseArray<RadialGradient> f13492 = new LongSparseArray<>();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final C1518aux f13493;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Path f13494 = new Path();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final LongSparseArray<LinearGradient> f13495 = new LongSparseArray<>();

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final int f13496;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final AbstractC1622coN<PointF, PointF> f13497;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Matrix f13498 = new Matrix();

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final AbstractC1622coN<PointF, PointF> f13499;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Paint f13500 = new Paint(1);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC1622coN<C1009, C1009> f13501;

    public C0448(C1518aux aux, AbstractC0741 r6, C0996 r7) {
        this.f13490 = r7.m15935();
        this.f13493 = aux;
        this.f13487 = r7.m15939();
        this.f13494.setFillType(r7.m15938());
        this.f13496 = (int) (aux.m5698().m14267() / 32);
        this.f13501 = r7.m15937().mo14241();
        this.f13501.mo5905(this);
        r6.m15134(this.f13501);
        this.f13491 = r7.m15936().mo14241();
        this.f13491.mo5905(this);
        r6.m15134(this.f13491);
        this.f13497 = r7.m15940().mo14241();
        this.f13497.mo5905(this);
        r6.m15134(this.f13497);
        this.f13499 = r7.m15934().mo14241();
        this.f13499.mo5905(this);
        r6.m15134(this.f13499);
    }

    @Override // o.AbstractC1622coN.AbstractC0107
    /* renamed from: ˎ */
    public void mo3789() {
        this.f13493.invalidateSelf();
    }

    @Override // o.AbstractC0420
    /* renamed from: ॱ */
    public void mo3790(List<AbstractC0420> list, List<AbstractC0420> list2) {
        for (int i = 0; i < list2.size(); i++) {
            AbstractC0420 r3 = list2.get(i);
            if (r3 instanceof AUX) {
                this.f13489.add((AUX) r3);
            }
        }
    }

    @Override // o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5647(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        C1466If.m5165("GradientFillContent#draw");
        this.f13494.reset();
        for (int i2 = 0; i2 < this.f13489.size(); i2++) {
            this.f13494.addPath(this.f13489.get(i2).mo3438(), matrix);
        }
        this.f13494.computeBounds(this.f13488, false);
        if (this.f13487 == GradientType.Linear) {
            shader = m14327();
        } else {
            shader = m14329();
        }
        this.f13498.set(matrix);
        shader.setLocalMatrix(this.f13498);
        this.f13500.setShader(shader);
        this.f13500.setAlpha((int) ((((((float) i) / 255.0f) * ((float) this.f13491.mo5904().intValue())) / 100.0f) * 255.0f));
        canvas.drawPath(this.f13494, this.f13500);
        C1466If.m5166("GradientFillContent#draw");
    }

    @Override // o.AbstractC0423
    /* renamed from: ॱ */
    public void mo5650(RectF rectF, Matrix matrix) {
        this.f13494.reset();
        for (int i = 0; i < this.f13489.size(); i++) {
            this.f13494.addPath(this.f13489.get(i).mo3438(), matrix);
        }
        this.f13494.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5648(String str, String str2, ColorFilter colorFilter) {
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ */
    public String mo3788() {
        return this.f13490;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private LinearGradient m14327() {
        int r8 = m14328();
        LinearGradient linearGradient = this.f13495.get((long) r8);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF r10 = this.f13497.mo5904();
        PointF r11 = this.f13499.mo5904();
        C1009 r12 = this.f13501.mo5904();
        LinearGradient linearGradient2 = new LinearGradient(r10.x, r10.y, r11.x, r11.y, r12.m15966(), r12.m15963(), Shader.TileMode.CLAMP);
        this.f13495.put((long) r8, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private RadialGradient m14329() {
        int r7 = m14328();
        RadialGradient radialGradient = this.f13492.get((long) r7);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF r9 = this.f13497.mo5904();
        PointF r10 = this.f13499.mo5904();
        C1009 r11 = this.f13501.mo5904();
        int[] r12 = r11.m15966();
        float[] r13 = r11.m15963();
        float f = r9.x;
        float f2 = r9.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (r10.x - f), (double) (r10.y - f2)), r12, r13, Shader.TileMode.CLAMP);
        this.f13492.put((long) r7, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private int m14328() {
        int round = Math.round(this.f13497.m5908() * ((float) this.f13496));
        int round2 = Math.round(this.f13499.m5908() * ((float) this.f13496));
        int round3 = Math.round(this.f13501.m5908() * ((float) this.f13496));
        int i = 17;
        if (round != 0) {
            i = round * 527;
        }
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        if (round3 != 0) {
            return i * 31 * round3;
        }
        return i;
    }
}
