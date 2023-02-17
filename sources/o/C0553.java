package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
/* renamed from: o.ח  reason: contains not printable characters */
public class C0553 extends ImageView {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f13791 = 1;

    public C0553(Context context) {
        super(context);
    }

    public C0553(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.C0006.AspectRatioImageView);
        this.f13791 = obtainStyledAttributes.getInt(0, 1);
        obtainStyledAttributes.recycle();
    }

    public C0553(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (this.f13791 == 0) {
                i4 = View.MeasureSpec.getSize(i);
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth <= 0) {
                    super.onMeasure(i, i2);
                    return;
                }
                i3 = (drawable.getIntrinsicHeight() * i4) / intrinsicWidth;
            } else {
                i3 = View.MeasureSpec.getSize(i2);
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight <= 0) {
                    super.onMeasure(i, i2);
                    return;
                }
                i4 = (drawable.getIntrinsicWidth() * i3) / intrinsicHeight;
            }
            setMeasuredDimension(i4, i3);
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setMeasureBy(int i) {
        if (i == 1 || i == 0) {
            this.f13791 = i;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("nvalid measureBy type");
    }
}
