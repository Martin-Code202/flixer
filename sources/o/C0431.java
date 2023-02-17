package o;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.model.content.ShapeStroke;
/* renamed from: o.ˉ  reason: contains not printable characters */
public class C0431 extends AbstractC0421 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1622coN<Integer, Integer> f13434;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f13435;

    public C0431(C1518aux aux, AbstractC0741 r11, ShapeStroke shapeStroke) {
        super(aux, r11, shapeStroke.m42().m50(), shapeStroke.m43().m51(), shapeStroke.m44(), shapeStroke.m46(), shapeStroke.m48(), shapeStroke.m49());
        this.f13435 = shapeStroke.m45();
        this.f13434 = shapeStroke.m47().mo14241();
        this.f13434.mo5905(this);
        r11.m15134(this.f13434);
    }

    @Override // o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5648(String str, String str2, ColorFilter colorFilter) {
        this.f13389.setColorFilter(colorFilter);
    }

    @Override // o.AbstractC0421, o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5647(Canvas canvas, Matrix matrix, int i) {
        this.f13389.setColor(this.f13434.mo5904().intValue());
        super.mo5647(canvas, matrix, i);
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ */
    public String mo3788() {
        return this.f13435;
    }
}
