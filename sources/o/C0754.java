package o;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import o.C0602;
/* renamed from: o.ᐴ  reason: contains not printable characters */
public class C0754 extends AppCompatButton {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected C0643 f14365;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Rect f14366;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Rect f14367;

    public C0754(Context context) {
        this(context, null);
    }

    public C0754(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0602.C2399If.netflixTextViewStyle);
    }

    public C0754(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14367 = new Rect();
        this.f14366 = new Rect();
        m15173(new C0643(getContext(), attributeSet));
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m15171();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15171() {
        if (this.f14365 != null && this.f14365.f13963) {
            CharSequence text = getText();
            if (TextUtils.isEmpty(text)) {
                this.f14367.setEmpty();
            } else {
                getPaint().getTextBounds(text.toString(), 0, text.length(), this.f14367);
            }
            int width = getWidth() - (getPaddingLeft() + getPaddingRight());
            Drawable[] compoundDrawables = getCompoundDrawables();
            if (compoundDrawables[0] != null) {
                compoundDrawables[0].copyBounds(this.f14366);
                if (width > this.f14367.width() + this.f14366.width()) {
                    this.f14366.offsetTo((((getRightPaddingOffset() + width) - (this.f14367.width() + this.f14366.width())) / 2) - getCompoundDrawablePadding(), 0);
                    compoundDrawables[0].setBounds(this.f14366);
                }
            }
            if (compoundDrawables[2] != null) {
                compoundDrawables[2].copyBounds(this.f14366);
                if (width > this.f14367.width() + this.f14366.width()) {
                    this.f14366.offsetTo((((getLeftPaddingOffset() - width) + (this.f14367.width() + this.f14366.width())) / 2) + getCompoundDrawablePadding(), 0);
                    compoundDrawables[2].setBounds(this.f14366);
                }
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15172(int i) {
        m15173(new C0643(new ContextThemeWrapper(getContext(), i), i));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15173(C0643 r5) {
        this.f14365 = r5;
        setBackground(new C0667(this.f14365));
        setTextColor(this.f14365.f13966);
        if (TextViewCompat.getAutoSizeTextType(this) == 1) {
            TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes(this, new int[]{TextViewCompat.getAutoSizeMinTextSize(this), Math.round(getTextSize())}, 0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        setCompoundDrawablesRelative(getCompoundDrawablesRelative()[0] != null ? getCompoundDrawablesRelative()[0] : getCompoundDrawables()[0], getCompoundDrawablesRelative()[1], getCompoundDrawablesRelative()[2] != null ? getCompoundDrawablesRelative()[2] : getCompoundDrawables()[2], getCompoundDrawablesRelative()[3]);
        super.onFinishInflate();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? ContextCompat.getDrawable(getContext(), i) : null, i2 != 0 ? ContextCompat.getDrawable(getContext(), i2) : null, i3 != 0 ? ContextCompat.getDrawable(getContext(), i3) : null, i4 != 0 ? ContextCompat.getDrawable(getContext(), i4) : null);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? ContextCompat.getDrawable(getContext(), i) : null, i2 != 0 ? ContextCompat.getDrawable(getContext(), i2) : null, i3 != 0 ? ContextCompat.getDrawable(getContext(), i3) : null, i4 != 0 ? ContextCompat.getDrawable(getContext(), i4) : null);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (this.f14365 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            super.setCompoundDrawables(C1004.m15960(drawable, this.f14365.f13973, this.f14365.f13972), C1004.m15960(drawable2, this.f14365.f13973, this.f14365.f13972), C1004.m15960(drawable3, this.f14365.f13973, this.f14365.f13972), C1004.m15960(drawable4, this.f14365.f13973, this.f14365.f13972));
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (this.f14365 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            super.setCompoundDrawablesRelative(C1004.m15960(drawable, this.f14365.f13973, this.f14365.f13972), C1004.m15960(drawable2, this.f14365.f13973, this.f14365.f13972), C1004.m15960(drawable3, this.f14365.f13973, this.f14365.f13972), C1004.m15960(drawable4, this.f14365.f13973, this.f14365.f13972));
        }
    }
}
