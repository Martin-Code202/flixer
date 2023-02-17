package o;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import o.AbstractC0835;
/* renamed from: o.ug  reason: case insensitive filesystem */
public class C2207ug extends AbstractC0835.AbstractC2404iF {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final FrameLayout f10986;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C2207ug m11702(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new C2207ug(frameLayout);
    }

    private C2207ug(FrameLayout frameLayout) {
        super(frameLayout);
        this.f10986 = frameLayout;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11703(View view) {
        if (this.f10986.getChildAt(0) != view) {
            this.f10986.removeAllViews();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                this.f10986.addView(view, new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height));
            } else {
                this.f10986.addView(view, new FrameLayout.LayoutParams(-1, -2));
            }
        }
    }
}
