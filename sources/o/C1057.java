package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.netflix.mediaclient.R;
/* renamed from: o.Ⅴ  reason: contains not printable characters */
public class C1057 extends TextView {

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f15209;

    public C1057(Context context) {
        super(context);
    }

    public C1057(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16112(attributeSet);
    }

    public C1057(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16112(attributeSet);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m16112(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.C0006.UnderlineTextView);
        if (obtainStyledAttributes != null) {
            for (int i = 0; i < obtainStyledAttributes.getIndexCount(); i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (index) {
                    case 0:
                        this.f15209 = obtainStyledAttributes.getBoolean(index, false);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence == null || !this.f15209) {
            super.setText(charSequence, bufferType);
            return;
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new UnderlineSpan(), 0, charSequence.length(), 0);
        super.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    public void setUnderline(boolean z) {
        this.f15209 = z;
    }
}
