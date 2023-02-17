package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
/* renamed from: o.ℓ  reason: contains not printable characters */
public class C1050 extends C0522 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f15186 = false;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f15187 = true;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f15188;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f15189;

    public C1050(Context context) {
        super(context);
        m16081(null);
    }

    public C1050(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16081(attributeSet);
    }

    public C1050(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16081(attributeSet);
    }

    public void setCutomCroppingEnabled(boolean z) {
        this.f15187 = z;
        if (z) {
            setScaleType(ImageView.ScaleType.MATRIX);
            mo14745();
        } else if (!C1349Bv.m4113(this.f15188)) {
            setScaleType(ImageView.ScaleType.values()[Integer.valueOf(this.f15188).intValue()]);
        }
    }

    public void setCenterHorizontally(boolean z) {
        this.f15186 = z;
        mo14745();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m16081(AttributeSet attributeSet) {
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleType");
        if (C1349Bv.m4113(attributeValue)) {
            setScaleType(ImageView.ScaleType.MATRIX);
            this.f15187 = true;
        } else {
            this.f15188 = attributeValue;
            this.f15187 = false;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.C0006.TopCropImageView, 0, 0);
        try {
            this.f15189 = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setCropPointYOffsetPx(int i) {
        this.f15189 = i;
        mo14745();
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        mo14745();
        return super.setFrame(i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        mo14745();
    }

    /* renamed from: ॱॱ */
    public void mo14745() {
        float f;
        if (this.f15187) {
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
            matrix.setScale(f, f, 0.0f, (float) this.f15189);
            if (this.f15186 && ((float) intrinsicWidth) * f > ((float) width)) {
                matrix.postTranslate(-(((((float) intrinsicWidth) * f) - ((float) width)) / 2.0f), 0.0f);
            }
            setImageMatrix(matrix);
        }
    }
}
