package o;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;
import o.C0602;
/* renamed from: o.კ  reason: contains not printable characters */
public class C0716 extends AppCompatTextView {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14242;

    public C0716(Context context) {
        this(context, null);
    }

    public C0716(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0602.C2399If.netflixTextViewStyle);
    }

    public C0716(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14242 = getResources().getInteger(C0602.C0607.netflix_text_view_extra_text_sp);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(BX.m3953(charSequence), bufferType);
    }

    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int i, float f) {
        if (i == 2) {
            super.setTextSize(i, ((float) this.f14242) + f);
        } else {
            super.setTextSize(i, f);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        m15044();
        super.onMeasure(i, i2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15044() {
        int dimensionPixelOffset;
        if (getLineCount() > 1 && (dimensionPixelOffset = getResources().getDimensionPixelOffset(C0602.C0603.netflix_text_view_extra_line_height)) != 0 && getLineSpacingMultiplier() < 1.1f && getLineSpacingExtra() < ((float) (dimensionPixelOffset * 2))) {
            setLineSpacing((float) dimensionPixelOffset, 1.1f);
        }
    }
}
