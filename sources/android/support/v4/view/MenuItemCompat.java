package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
public final class MenuItemCompat {
    static final MenuVersionImpl IMPL;

    interface MenuVersionImpl {
        void setAlphabeticShortcut(MenuItem menuItem, char c, int i);

        void setContentDescription(MenuItem menuItem, CharSequence charSequence);

        void setIconTintList(MenuItem menuItem, ColorStateList colorStateList);

        void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode);

        void setNumericShortcut(MenuItem menuItem, char c, int i);

        void setTooltipText(MenuItem menuItem, CharSequence charSequence);
    }

    static class MenuItemCompatBaseImpl implements MenuVersionImpl {
        MenuItemCompatBaseImpl() {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setAlphabeticShortcut(MenuItem menuItem, char c, int i) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setNumericShortcut(MenuItem menuItem, char c, int i) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
        }
    }

    static class MenuItemCompatApi26Impl extends MenuItemCompatBaseImpl {
        MenuItemCompatApi26Impl() {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setAlphabeticShortcut(MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setNumericShortcut(MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        public void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
            menuItem.setIconTintMode(mode);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            IMPL = new MenuItemCompatApi26Impl();
        } else {
            IMPL = new MenuItemCompatBaseImpl();
        }
    }

    public static MenuItem setActionProvider(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setSupportActionProvider(actionProvider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setContentDescription(charSequence);
        } else {
            IMPL.setContentDescription(menuItem, charSequence);
        }
    }

    public static void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setTooltipText(charSequence);
        } else {
            IMPL.setTooltipText(menuItem, charSequence);
        }
    }

    public static void setNumericShortcut(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setNumericShortcut(c, i);
        } else {
            IMPL.setNumericShortcut(menuItem, c, i);
        }
    }

    public static void setAlphabeticShortcut(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setAlphabeticShortcut(c, i);
        } else {
            IMPL.setAlphabeticShortcut(menuItem, c, i);
        }
    }

    public static void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else {
            IMPL.setIconTintList(menuItem, colorStateList);
        }
    }

    public static void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintMode(mode);
        } else {
            IMPL.setIconTintMode(menuItem, mode);
        }
    }
}
