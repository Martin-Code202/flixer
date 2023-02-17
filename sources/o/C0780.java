package o;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.model.layer.Layer;
/* renamed from: o.ᒡ  reason: contains not printable characters */
public class C0780 extends AbstractC0741 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Rect f14433 = new Rect();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Paint f14434 = new Paint(3);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final float f14435;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Rect f14436 = new Rect();

    C0780(C1518aux aux, Layer layer, float f) {
        super(aux, layer);
        this.f14435 = f;
    }

    @Override // o.AbstractC0741
    /* renamed from: ॱ */
    public void mo14760(Canvas canvas, Matrix matrix, int i) {
        Bitmap r5 = m15241();
        if (r5 != null) {
            this.f14434.setAlpha(i);
            canvas.save();
            canvas.concat(matrix);
            this.f14433.set(0, 0, r5.getWidth(), r5.getHeight());
            this.f14436.set(0, 0, (int) (((float) r5.getWidth()) * this.f14435), (int) (((float) r5.getHeight()) * this.f14435));
            canvas.drawBitmap(r5, this.f14433, this.f14436, this.f14434);
            canvas.restore();
        }
    }

    @Override // o.AbstractC0741, o.AbstractC0423
    /* renamed from: ॱ */
    public void mo5650(RectF rectF, Matrix matrix) {
        super.mo5650(rectF, matrix);
        Bitmap r5 = m15241();
        if (r5 != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, (float) r5.getWidth()), Math.min(rectF.bottom, (float) r5.getHeight()));
            this.f14319.mapRect(rectF);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private Bitmap m15241() {
        return this.f14321.m5667(this.f14324.m60());
    }

    @Override // o.AbstractC0741, o.AbstractC0423
    /* renamed from: ˎ */
    public void mo5648(String str, String str2, ColorFilter colorFilter) {
        this.f14434.setColorFilter(colorFilter);
    }
}
