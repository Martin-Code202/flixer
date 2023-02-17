package o;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import o.AbstractC1622coN;
/* renamed from: o.con  reason: case insensitive filesystem */
public class C1623con implements AUX, AbstractC1622coN.AbstractC0107 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final AbstractC1622coN<?, PointF> f6322;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f6323;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f6324;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final PolystarShape.Type f6325;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C1354COn f6326;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C1518aux f6327;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f6328;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f6329;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f6330;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Path f6331 = new Path();

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f6332;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f6333;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC1622coN<?, Float> f6334;

    public C1623con(C1518aux aux, AbstractC0741 r4, PolystarShape polystarShape) {
        this.f6327 = aux;
        this.f6330 = polystarShape.m37();
        this.f6325 = polystarShape.m34();
        this.f6329 = polystarShape.m33().mo14241();
        this.f6322 = polystarShape.m35().mo14241();
        this.f6333 = polystarShape.m36().mo14241();
        this.f6323 = polystarShape.m32().mo14241();
        this.f6332 = polystarShape.m31().mo14241();
        if (this.f6325 == PolystarShape.Type.Star) {
            this.f6324 = polystarShape.m39().mo14241();
            this.f6334 = polystarShape.m38().mo14241();
        } else {
            this.f6324 = null;
            this.f6334 = null;
        }
        r4.m15134(this.f6329);
        r4.m15134(this.f6322);
        r4.m15134(this.f6333);
        r4.m15134(this.f6323);
        r4.m15134(this.f6332);
        if (this.f6325 == PolystarShape.Type.Star) {
            r4.m15134(this.f6324);
            r4.m15134(this.f6334);
        }
        this.f6329.mo5905(this);
        this.f6322.mo5905(this);
        this.f6333.mo5905(this);
        this.f6323.mo5905(this);
        this.f6332.mo5905(this);
        if (this.f6325 == PolystarShape.Type.Star) {
            this.f6323.mo5905(this);
            this.f6332.mo5905(this);
        }
    }

    @Override // o.AbstractC1622coN.AbstractC0107
    /* renamed from: ˎ */
    public void mo3789() {
        m5911();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5911() {
        this.f6328 = false;
        this.f6327.invalidateSelf();
    }

    @Override // o.AbstractC0420
    /* renamed from: ॱ */
    public void mo3790(List<AbstractC0420> list, List<AbstractC0420> list2) {
        for (int i = 0; i < list.size(); i++) {
            AbstractC0420 r3 = list.get(i);
            if ((r3 instanceof C1354COn) && ((C1354COn) r3).m4285() == ShapeTrimPath.Type.Simultaneously) {
                this.f6326 = (C1354COn) r3;
                this.f6326.m4286(this);
            }
        }
    }

    @Override // o.AUX
    /* renamed from: ˏ */
    public Path mo3438() {
        if (this.f6328) {
            return this.f6331;
        }
        this.f6331.reset();
        switch (this.f6325) {
            case Star:
                m5910();
                break;
            case Polygon:
                m5909();
                break;
        }
        this.f6331.close();
        C1026.m16011(this.f6331, this.f6326);
        this.f6328 = true;
        return this.f6331;
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ */
    public String mo3788() {
        return this.f6330;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5910() {
        float f;
        float f2;
        double d;
        float floatValue = this.f6329.mo5904().floatValue();
        double radians = Math.toRadians((this.f6333 == null ? 0.0d : (double) this.f6333.mo5904().floatValue()) - 90.0d);
        float f3 = (float) (6.283185307179586d / ((double) floatValue));
        float f4 = f3 / 2.0f;
        float f5 = floatValue - ((float) ((int) floatValue));
        if (f5 != 0.0f) {
            radians += (double) ((1.0f - f5) * f4);
        }
        float floatValue2 = this.f6323.mo5904().floatValue();
        float floatValue3 = this.f6324.mo5904().floatValue();
        float f6 = 0.0f;
        if (this.f6334 != null) {
            f6 = this.f6334.mo5904().floatValue() / 100.0f;
        }
        float f7 = 0.0f;
        if (this.f6332 != null) {
            f7 = this.f6332.mo5904().floatValue() / 100.0f;
        }
        float f8 = 0.0f;
        if (f5 != 0.0f) {
            f8 = floatValue3 + ((floatValue2 - floatValue3) * f5);
            f2 = (float) (((double) f8) * Math.cos(radians));
            f = (float) (((double) f8) * Math.sin(radians));
            this.f6331.moveTo(f2, f);
            d = radians + ((double) ((f3 * f5) / 2.0f));
        } else {
            f2 = (float) (((double) floatValue2) * Math.cos(radians));
            f = (float) (((double) floatValue2) * Math.sin(radians));
            this.f6331.moveTo(f2, f);
            d = radians + ((double) f4);
        }
        boolean z = false;
        double ceil = Math.ceil((double) floatValue) * 2.0d;
        for (int i = 0; ((double) i) < ceil; i++) {
            float f9 = z ? floatValue2 : floatValue3;
            float f10 = f4;
            if (f8 != 0.0f && ((double) i) == ceil - 2.0d) {
                f10 = (f3 * f5) / 2.0f;
            }
            if (f8 != 0.0f && ((double) i) == ceil - 1.0d) {
                f9 = f8;
            }
            f2 = (float) (((double) f9) * Math.cos(d));
            f = (float) (((double) f9) * Math.sin(d));
            if (f6 == 0.0f && f7 == 0.0f) {
                this.f6331.lineTo(f2, f);
            } else {
                float atan2 = (float) (Math.atan2((double) f, (double) f2) - 1.5707963267948966d);
                float cos = (float) Math.cos((double) atan2);
                float sin = (float) Math.sin((double) atan2);
                float atan22 = (float) (Math.atan2((double) f, (double) f2) - 1.5707963267948966d);
                float cos2 = (float) Math.cos((double) atan22);
                float sin2 = (float) Math.sin((double) atan22);
                float f11 = z ? f6 : f7;
                float f12 = z ? f7 : f6;
                float f13 = z ? floatValue3 : floatValue2;
                float f14 = z ? floatValue2 : floatValue3;
                float f15 = f13 * f11 * 0.47829f * cos;
                float f16 = f13 * f11 * 0.47829f * sin;
                float f17 = f14 * f12 * 0.47829f * cos2;
                float f18 = f14 * f12 * 0.47829f * sin2;
                if (f5 != 0.0f) {
                    if (i == 0) {
                        f15 *= f5;
                        f16 *= f5;
                    } else if (((double) i) == ceil - 1.0d) {
                        f17 *= f5;
                        f18 *= f5;
                    }
                }
                this.f6331.cubicTo(f2 - f15, f - f16, f2 + f17, f + f18, f2, f);
            }
            d += (double) f10;
            z = !z;
        }
        PointF r25 = this.f6322.mo5904();
        this.f6331.offset(r25.x, r25.y);
        this.f6331.close();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m5909() {
        int floor = (int) Math.floor((double) this.f6329.mo5904().floatValue());
        double radians = Math.toRadians((this.f6333 == null ? 0.0d : (double) this.f6333.mo5904().floatValue()) - 90.0d);
        float f = (float) (6.283185307179586d / ((double) floor));
        float floatValue = this.f6332.mo5904().floatValue() / 100.0f;
        float floatValue2 = this.f6323.mo5904().floatValue();
        float cos = (float) (((double) floatValue2) * Math.cos(radians));
        float sin = (float) (((double) floatValue2) * Math.sin(radians));
        this.f6331.moveTo(cos, sin);
        double d = radians + ((double) f);
        double ceil = Math.ceil((double) floor);
        for (int i = 0; ((double) i) < ceil; i++) {
            cos = (float) (((double) floatValue2) * Math.cos(d));
            sin = (float) (((double) floatValue2) * Math.sin(d));
            if (floatValue != 0.0f) {
                float atan2 = (float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d);
                float cos2 = (float) Math.cos((double) atan2);
                float sin2 = (float) Math.sin((double) atan2);
                float atan22 = (float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d);
                this.f6331.cubicTo(cos - (((floatValue2 * floatValue) * 0.25f) * cos2), sin - (((floatValue2 * floatValue) * 0.25f) * sin2), cos + (floatValue2 * floatValue * 0.25f * ((float) Math.cos((double) atan22))), sin + (floatValue2 * floatValue * 0.25f * ((float) Math.sin((double) atan22))), cos, sin);
            } else {
                this.f6331.lineTo(cos, sin);
            }
            d += (double) f;
        }
        PointF r19 = this.f6322.mo5904();
        this.f6331.offset(r19.x, r19.y);
        this.f6331.close();
    }
}
