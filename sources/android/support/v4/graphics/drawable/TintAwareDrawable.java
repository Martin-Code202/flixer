package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
public interface TintAwareDrawable {
    @Override // android.support.v4.graphics.drawable.TintAwareDrawable
    void setTint(int i);

    @Override // android.support.v4.graphics.drawable.TintAwareDrawable
    void setTintList(ColorStateList colorStateList);

    @Override // android.support.v4.graphics.drawable.TintAwareDrawable
    void setTintMode(PorterDuff.Mode mode);
}
