package o;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
/* renamed from: o.ﹽ  reason: contains not printable characters */
public class C1173 extends AppCompatImageView {
    public C1173(Context context) {
        super(context);
    }

    public C1173(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16380();
    }

    public C1173(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16380();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m16380() {
        setAdjustViewBounds(false);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
