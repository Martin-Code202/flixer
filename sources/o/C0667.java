package o;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
/* access modifiers changed from: package-private */
/* renamed from: o.শ  reason: contains not printable characters */
public class C0667 extends RippleDrawable {
    C0667(C0643 r4) {
        super(m14864(r4), m14865(r4), m14863(r4));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Drawable m14863(C0643 r6) {
        if (r6.f13971) {
            return null;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        float f = (float) r6.f13968;
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        return shapeDrawable;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static Drawable m14865(C0643 r3) {
        if (r3.f13971) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (r3.f13962 > 0) {
            gradientDrawable.setStroke(r3.f13962, r3.f13967);
        }
        gradientDrawable.setColor(r3.f13965);
        gradientDrawable.setCornerRadius((float) r3.f13968);
        return gradientDrawable;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static ColorStateList m14864(C0643 r1) {
        return ColorStateList.valueOf(r1.f13970);
    }
}
