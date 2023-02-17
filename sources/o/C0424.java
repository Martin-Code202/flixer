package o;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
/* renamed from: o.ʿ  reason: contains not printable characters */
public class C0424 extends AbstractC0421 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final AbstractC1622coN<PointF, PointF> f13407;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final AbstractC1622coN<PointF, PointF> f13408;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final int f13409;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final LongSparseArray<LinearGradient> f13410 = new LongSparseArray<>();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f13411;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final RectF f13412 = new RectF();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final LongSparseArray<RadialGradient> f13413 = new LongSparseArray<>();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AbstractC1622coN<C1009, C1009> f13414;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final GradientType f13415;

    public C0424(C1518aux aux, AbstractC0741 r11, C1287 r12) {
        super(aux, r11, r12.m16870().m50(), r12.m16871().m51(), r12.m16878(), r12.m16879(), r12.m16872(), r12.m16875());
        this.f13411 = r12.m16874();
        this.f13415 = r12.m16876();
        this.f13409 = (int) (aux.m5698().m14267() / 32);
        this.f13414 = r12.m16873().mo14241();
        this.f13414.mo5905(this);
        r11.m15134(this.f13414);
        this.f13407 = r12.m16877().mo14241();
        this.f13407.mo5905(this);
        r11.m15134(this.f13407);
        this.f13408 = r12.m16880().mo14241();
        this.f13408.mo5905(this);
        r11.m15134(this.f13408);
    }

    @Override // o.AbstractC0421, o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5647(Canvas canvas, Matrix matrix, int i) {
        mo5650(this.f13412, matrix);
        if (this.f13415 == GradientType.Linear) {
            this.f13389.setShader(m14231());
        } else {
            this.f13389.setShader(m14232());
        }
        super.mo5647(canvas, matrix, i);
    }

    @Override // o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5648(String str, String str2, ColorFilter colorFilter) {
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ */
    public String mo3788() {
        return this.f13411;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private LinearGradient m14231() {
        int r8 = m14230();
        LinearGradient linearGradient = this.f13410.get((long) r8);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF r10 = this.f13407.mo5904();
        PointF r11 = this.f13408.mo5904();
        C1009 r12 = this.f13414.mo5904();
        LinearGradient linearGradient2 = new LinearGradient((float) ((int) (this.f13412.left + (this.f13412.width() / 2.0f) + r10.x)), (float) ((int) (this.f13412.top + (this.f13412.height() / 2.0f) + r10.y)), (float) ((int) (this.f13412.left + (this.f13412.width() / 2.0f) + r11.x)), (float) ((int) (this.f13412.top + (this.f13412.height() / 2.0f) + r11.y)), r12.m15966(), r12.m15963(), Shader.TileMode.CLAMP);
        this.f13410.put((long) r8, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private RadialGradient m14232() {
        int r7 = m14230();
        RadialGradient radialGradient = this.f13413.get((long) r7);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF r9 = this.f13407.mo5904();
        PointF r10 = this.f13408.mo5904();
        C1009 r11 = this.f13414.mo5904();
        int[] r12 = r11.m15966();
        float[] r13 = r11.m15963();
        int width = (int) (this.f13412.left + (this.f13412.width() / 2.0f) + r9.x);
        int height = (int) (this.f13412.top + (this.f13412.height() / 2.0f) + r9.y);
        float f = (float) width;
        float f2 = (float) height;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (((int) ((this.f13412.left + (this.f13412.width() / 2.0f)) + r10.x)) - width), (double) (((int) ((this.f13412.top + (this.f13412.height() / 2.0f)) + r10.y)) - height)), r12, r13, Shader.TileMode.CLAMP);
        this.f13413.put((long) r7, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private int m14230() {
        int round = Math.round(this.f13407.m5908() * ((float) this.f13409));
        int round2 = Math.round(this.f13408.m5908() * ((float) this.f13409));
        int round3 = Math.round(this.f13414.m5908() * ((float) this.f13409));
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
