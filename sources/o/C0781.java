package o;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.airbnb.lottie.model.layer.Layer;
/* renamed from: o.ᒢ  reason: contains not printable characters */
public class C0781 extends AbstractC0741 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Layer f14437;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final RectF f14438 = new RectF();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Paint f14439 = new Paint();

    C0781(C1518aux aux, Layer layer) {
        super(aux, layer);
        this.f14437 = layer;
        this.f14439.setAlpha(0);
        this.f14439.setStyle(Paint.Style.FILL);
        this.f14439.setColor(layer.m77());
    }

    @Override // o.AbstractC0741
    /* renamed from: ॱ */
    public void mo14760(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.f14437.m77());
        if (alpha != 0) {
            int intValue = (int) ((((float) i) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) this.f14327.m16356().mo5904().intValue())) / 100.0f) * 255.0f);
            this.f14439.setAlpha(intValue);
            if (intValue > 0) {
                m15242(matrix);
                canvas.drawRect(this.f14438, this.f14439);
            }
        }
    }

    @Override // o.AbstractC0741, o.AbstractC0423
    /* renamed from: ॱ */
    public void mo5650(RectF rectF, Matrix matrix) {
        super.mo5650(rectF, matrix);
        m15242(this.f14319);
        rectF.set(this.f14438);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15242(Matrix matrix) {
        this.f14438.set(0.0f, 0.0f, (float) this.f14437.m61(), (float) this.f14437.m79());
        matrix.mapRect(this.f14438);
    }

    @Override // o.AbstractC0741, o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5648(String str, String str2, ColorFilter colorFilter) {
        this.f14439.setColorFilter(colorFilter);
    }
}
