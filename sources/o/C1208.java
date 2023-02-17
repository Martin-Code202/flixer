package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.netflix.android.widgetry.widget.tabs.BadgeView;
import o.C0602;
/* renamed from: o.ﻟ  reason: contains not printable characters */
public class C1208 extends FrameLayout {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final int[] f15598 = {16842912};

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f15599;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final TextView f15600;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0383 f15601;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ImageView f15602;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private ColorStateList f15603;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private BadgeView f15604;

    public C1208(Context context) {
        this(context, null);
    }

    public C1208(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1208(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15599 = -1;
        LayoutInflater.from(context).inflate(C0602.C0606.bottom_tab_layout, (ViewGroup) this, true);
        setBackgroundResource(C0602.C0604.tab_background);
        this.f15602 = (ImageView) findViewById(C0602.IF.icon);
        this.f15600 = (TextView) findViewById(C0602.IF.label);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16490(C0383 r2) {
        this.f15601 = r2;
        setSelected(r2.m14146());
        setEnabled(r2.m14150());
        setIcon(r2.m14149(getContext()));
        setTitle(r2.m14147());
        setId(r2.m14144());
    }

    public void setItemPosition(int i) {
        this.f15599 = i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0383 m16491() {
        return this.f15601;
    }

    public void setTitle(CharSequence charSequence) {
        this.f15600.setText(charSequence);
        setContentDescription(charSequence);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        this.f15601.m14148(z);
        ViewCompat.setPivotX(this.f15600, (float) (this.f15600.getWidth() / 2));
        ViewCompat.setPivotY(this.f15600, (float) this.f15600.getBaseline());
        refreshDrawableState();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f15600.setEnabled(z);
        this.f15602.setEnabled(z);
        if (z) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f15601 != null && this.f15601.m14146()) {
            mergeDrawableStates(onCreateDrawableState, f15598);
        }
        return onCreateDrawableState;
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            drawable = DrawableCompat.wrap(constantState == null ? drawable : constantState.newDrawable()).mutate();
            DrawableCompat.setTintList(drawable, this.f15603);
        }
        this.f15602.setImageDrawable(drawable);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f15603 = colorStateList;
        if (this.f15601 != null) {
            setIcon(this.f15601.m14149(getContext()));
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f15600.setTextColor(colorStateList);
    }

    public void setLabelVisibility(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15602.getLayoutParams();
        if (z) {
            this.f15600.setVisibility(0);
            layoutParams.gravity = 49;
        } else {
            this.f15600.setVisibility(8);
            layoutParams.gravity = 17;
        }
        this.f15602.setLayoutParams(layoutParams);
    }

    public void setItemBackground(int i) {
        Drawable drawable;
        if (i == 0) {
            drawable = null;
        } else {
            drawable = ContextCompat.getDrawable(getContext(), i);
        }
        ViewCompat.setBackground(this, drawable);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public BadgeView m16489() {
        if (this.f15604 == null) {
            this.f15604 = (BadgeView) ((ViewStub) findViewById(C0602.IF.badge_stub)).inflate().findViewById(C0602.IF.badge_view);
        }
        return this.f15604;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m16492(int i) {
        this.f15600.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.f15600.getMeasuredWidth() <= i;
    }
}
