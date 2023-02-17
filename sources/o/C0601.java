package o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
/* renamed from: o.ڋ  reason: contains not printable characters */
public class C0601 extends ConstraintLayout {

    /* renamed from: ʼ  reason: contains not printable characters */
    protected int f13897;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected int f13898;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected ImageView f13899;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected View f13900;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected C0716 f13901;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected C0754 f13902;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected int f13903;

    public C0601(Context context) {
        super(context);
        m14734();
    }

    public C0601(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14734();
        m14735(attributeSet);
    }

    public C0601(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14734();
        m14735(attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14735(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.C0006.EmptyStateView);
        setIconDrawable(obtainStyledAttributes.getDrawable(1));
        setMessageText(obtainStyledAttributes.getString(2));
        setButtonText(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14734() {
        inflate(getContext(), R.layout.empty_state, this);
        Resources resources = getResources();
        this.f13898 = resources.getDimensionPixelSize(R.dimen.empty_state_icon_size);
        this.f13897 = resources.getDimensionPixelSize(R.dimen.empty_state_icon_size_compressed);
        this.f13903 = resources.getDimensionPixelSize(R.dimen.empty_state_min_height);
        this.f13899 = (ImageView) findViewById(R.id.empty_state_image);
        this.f13900 = findViewById(R.id.empty_state_extra_padding);
        this.f13901 = (C0716) findViewById(R.id.empty_state_text);
        this.f13902 = (C0754) findViewById(R.id.empty_state_button);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.empty_state_side_margin);
        if (getPaddingStart() == 0) {
            C1004.m15952(this, 0, dimensionPixelSize);
        }
        if (getPaddingEnd() == 0) {
            C1004.m15952(this, 2, dimensionPixelSize);
        }
        if (getPaddingBottom() == 0) {
            C1004.m15952(this, 3, getResources().getDimensionPixelSize(R.dimen.empty_state_bottom_margin));
        }
    }

    public void setIconDrawable(Drawable drawable) {
        this.f13899.setImageDrawable(drawable);
    }

    public void setIconDrawable(int i) {
        this.f13899.setImageResource(i);
    }

    public void setMessageText(String str) {
        this.f13901.setText(str);
    }

    public void setButtonText(String str) {
        this.f13902.setText(str);
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        this.f13902.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.constraint.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2) - (getPaddingTop() + getPaddingBottom());
        ViewGroup.LayoutParams layoutParams = this.f13899.getLayoutParams();
        if (size > this.f13903) {
            layoutParams.width = this.f13898;
            layoutParams.height = this.f13898;
            this.f13900.setVisibility(0);
        } else {
            layoutParams.width = this.f13897;
            layoutParams.height = this.f13897;
            this.f13900.setVisibility(8);
        }
        super.onMeasure(i, i2);
    }
}
