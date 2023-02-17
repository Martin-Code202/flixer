package o;

import android.graphics.ColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.WeakHashMap;
/* renamed from: o.з  reason: contains not printable characters */
public abstract class AbstractC0491 extends Drawable {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final WeakHashMap<View, String> f13596 = new WeakHashMap<>();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final RectF f13597 = new RectF();

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        for (View view : this.f13596.keySet()) {
            if (view != null) {
                view.invalidate();
            }
        }
    }
}
