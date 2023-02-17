package o;

import android.graphics.Matrix;
import android.graphics.PointF;
import o.AbstractC1622coN;
/* renamed from: o.ﹶ  reason: contains not printable characters */
public class C1164 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final AbstractC1622coN<Integer, Integer> f15419;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1622coN<C0736, C0736> f15420;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Matrix f15421 = new Matrix();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1622coN<Float, Float> f15422;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1622coN<PointF, PointF> f15423;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1622coN<?, PointF> f15424;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f15425;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f15426;

    public C1164(C0984 r2) {
        this.f15423 = r2.m15916().mo14241();
        this.f15424 = r2.m15917().mo14241();
        this.f15420 = r2.m15915().mo14241();
        this.f15422 = r2.m15918().mo14241();
        this.f15419 = r2.m15919().mo14241();
        if (r2.m15913() != null) {
            this.f15425 = r2.m15913().mo14241();
        } else {
            this.f15425 = null;
        }
        if (r2.m15914() != null) {
            this.f15426 = r2.m15914().mo14241();
        } else {
            this.f15426 = null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16357(AbstractC0741 r2) {
        r2.m15134(this.f15423);
        r2.m15134(this.f15424);
        r2.m15134(this.f15420);
        r2.m15134(this.f15422);
        r2.m15134(this.f15419);
        if (this.f15425 != null) {
            r2.m15134(this.f15425);
        }
        if (this.f15426 != null) {
            r2.m15134(this.f15426);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m16355(AbstractC1622coN.AbstractC0107 r2) {
        this.f15423.mo5905(r2);
        this.f15424.mo5905(r2);
        this.f15420.mo5905(r2);
        this.f15422.mo5905(r2);
        this.f15419.mo5905(r2);
        if (this.f15425 != null) {
            this.f15425.mo5905(r2);
        }
        if (this.f15426 != null) {
            this.f15426.mo5905(r2);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC1622coN<?, Integer> m16356() {
        return this.f15419;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC1622coN<?, Float> m16359() {
        return this.f15425;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public AbstractC1622coN<?, Float> m16358() {
        return this.f15426;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Matrix m16353() {
        this.f15421.reset();
        PointF r3 = this.f15424.mo5904();
        if (!(r3.x == 0.0f && r3.y == 0.0f)) {
            this.f15421.preTranslate(r3.x, r3.y);
        }
        float floatValue = this.f15422.mo5904().floatValue();
        if (floatValue != 0.0f) {
            this.f15421.preRotate(floatValue);
        }
        C0736 r5 = this.f15420.mo5904();
        if (!(r5.m15109() == 1.0f && r5.m15108() == 1.0f)) {
            this.f15421.preScale(r5.m15109(), r5.m15108());
        }
        PointF r6 = this.f15423.mo5904();
        if (!(r6.x == 0.0f && r6.y == 0.0f)) {
            this.f15421.preTranslate(-r6.x, -r6.y);
        }
        return this.f15421;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Matrix m16354(float f) {
        PointF r6 = this.f15424.mo5904();
        PointF r7 = this.f15423.mo5904();
        C0736 r8 = this.f15420.mo5904();
        float floatValue = this.f15422.mo5904().floatValue();
        this.f15421.reset();
        this.f15421.preTranslate(r6.x * f, r6.y * f);
        this.f15421.preScale((float) Math.pow((double) r8.m15109(), (double) f), (float) Math.pow((double) r8.m15108(), (double) f));
        this.f15421.preRotate(floatValue * f, r7.x, r7.y);
        return this.f15421;
    }
}
