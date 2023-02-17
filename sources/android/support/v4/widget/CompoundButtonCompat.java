package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;
public final class CompoundButtonCompat {
    private static final CompoundButtonCompatBaseImpl IMPL;

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            IMPL = new CompoundButtonCompatApi23Impl();
        } else if (Build.VERSION.SDK_INT >= 21) {
            IMPL = new CompoundButtonCompatApi21Impl();
        } else {
            IMPL = new CompoundButtonCompatBaseImpl();
        }
    }

    static class CompoundButtonCompatBaseImpl {
        private static Field sButtonDrawableField;
        private static boolean sButtonDrawableFieldFetched;

        CompoundButtonCompatBaseImpl() {
        }

        public void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof TintableCompoundButton) {
                ((TintableCompoundButton) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        public void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
            if (compoundButton instanceof TintableCompoundButton) {
                ((TintableCompoundButton) compoundButton).setSupportButtonTintMode(mode);
            }
        }

        public Drawable getButtonDrawable(CompoundButton compoundButton) {
            if (!sButtonDrawableFieldFetched) {
                try {
                    sButtonDrawableField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    sButtonDrawableField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
                }
                sButtonDrawableFieldFetched = true;
            }
            if (sButtonDrawableField == null) {
                return null;
            }
            try {
                return (Drawable) sButtonDrawableField.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                sButtonDrawableField = null;
                return null;
            }
        }
    }

    static class CompoundButtonCompatApi21Impl extends CompoundButtonCompatBaseImpl {
        CompoundButtonCompatApi21Impl() {
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl
        public void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl
        public void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    static class CompoundButtonCompatApi23Impl extends CompoundButtonCompatApi21Impl {
        CompoundButtonCompatApi23Impl() {
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl
        public Drawable getButtonDrawable(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    public static void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
        IMPL.setButtonTintList(compoundButton, colorStateList);
    }

    public static void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
        IMPL.setButtonTintMode(compoundButton, mode);
    }

    public static Drawable getButtonDrawable(CompoundButton compoundButton) {
        return IMPL.getButtonDrawable(compoundButton);
    }
}
