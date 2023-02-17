package o;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.netflix.mediaclient.R;
import kotlin.TypeCastException;
/* renamed from: o.sb  reason: case insensitive filesystem */
public final class C2140sb extends ConstraintLayout {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0197 f10134 = new C0197(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private Drawable f10135;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f10136;

    public C2140sb(Context context) {
        this(context, null, 0, 6, null);
    }

    public C2140sb(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2140sb(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        if (Build.VERSION.SDK_INT < 23) {
            setWillNotDraw(false);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2140sb(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: o.sb$ˊ  reason: contains not printable characters */
    public static final class C0197 {
        private C0197() {
        }

        public /* synthetic */ C0197(C1456Fq fq) {
            this();
        }
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 23) {
            Drawable drawable2 = this.f10135;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.f10135 = drawable;
            Drawable drawable3 = this.f10135;
            if (drawable3 != null) {
                drawable3.setCallback(this);
                return;
            }
            return;
        }
        super.setForeground(drawable);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        C1457Fr.m5025(drawable, "who");
        if (Build.VERSION.SDK_INT < 23) {
            return super.verifyDrawable(drawable) || C1457Fr.m5018(drawable, this.f10135);
        }
        return super.verifyDrawable(drawable);
    }

    @Override // android.view.View
    public Drawable getForeground() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.f10135;
        }
        return super.getForeground();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onSizeChanged(i, i2, i3, i4);
        if (Build.VERSION.SDK_INT < 23 && (drawable = this.f10135) != null) {
            drawable.setBounds(0, 0, i, i2);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (Build.VERSION.SDK_INT < 23 && (drawable = this.f10135) != null) {
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.constraint.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m10698();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m10698() {
        ViewParent parent = getParent();
        if (parent instanceof rY) {
            if (((rY) parent).m10232() == -1) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.bottomMargin = 0;
                int measuredHeight = getMeasuredHeight();
                int measuredHeight2 = ((rY) parent).getMeasuredHeight();
                Context context = getContext();
                C1457Fr.m5016((Object) context, "context");
                ((rY) parent).setArtificialPaddingBottom(((measuredHeight2 - measuredHeight) / 2) - context.getResources().getDimensionPixelSize(R.dimen.trailers_item_loading_more_height));
            }
        } else if (!isInEditMode()) {
            C1276.m16820().mo5725("Unexpected parent, it should be a TrailersFeedRecyclerView but found " + parent);
        }
    }

    public final void setItemMode(int i) {
        this.f10136 = i;
    }
}
