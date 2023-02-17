package o;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
/* renamed from: o.ঢ  reason: contains not printable characters */
public class C0656 extends AppCompatImageButton {

    /* renamed from: ˏ  reason: contains not printable characters */
    protected C0643 f13997;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f13998;

    public C0656(Context context) {
        this(context, null);
    }

    public C0656(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0656(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13998 = false;
        m14820(new C0643(getContext(), attributeSet));
        if (this.f13998) {
            setImageDrawable(getDrawable());
            this.f13998 = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14820(C0643 r3) {
        this.f13997 = r3;
        setBackground(new C0667(this.f13997));
        setImageDrawable(getDrawable());
    }

    @Override // android.support.v7.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f13997 == null) {
            super.setImageDrawable(drawable);
        } else {
            super.setImageDrawable(C1004.m15960(drawable, this.f13997.f13973, this.f13997.f13972));
        }
    }
}
