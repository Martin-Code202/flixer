package o;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
/* renamed from: o.ڒ  reason: contains not printable characters */
public class C0613 extends C1050 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private float f13916 = 0.0f;

    public C0613(Context context) {
        super(context);
    }

    public C0613(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C0613(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setCropPointXOffsetPercent(float f) {
        this.f13916 = f;
        mo14745();
    }

    @Override // o.C1050
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void mo14745() {
        float f;
        Matrix matrix = new Matrix(getImageMatrix());
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int intrinsicWidth = getDrawable() == null ? 0 : getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable() == null ? 0 : getDrawable().getIntrinsicHeight();
        if (intrinsicWidth * height > intrinsicHeight * width) {
            f = ((float) height) / ((float) intrinsicHeight);
        } else {
            f = ((float) width) / ((float) intrinsicWidth);
        }
        float width2 = (((float) intrinsicWidth) * f * this.f13916) + (this.f13916 * (((float) getWidth()) - (((float) intrinsicWidth) * f)));
        float height2 = (((float) intrinsicHeight) * f * this.f13916) + (this.f13916 * (((float) getHeight()) - (((float) intrinsicHeight) * f)));
        matrix.reset();
        matrix.postTranslate(((float) (-intrinsicWidth)) * this.f13916, ((float) (-intrinsicHeight)) * this.f13916);
        matrix.postScale(f, f);
        matrix.postTranslate(width2, height2);
        setImageMatrix(matrix);
    }
}
