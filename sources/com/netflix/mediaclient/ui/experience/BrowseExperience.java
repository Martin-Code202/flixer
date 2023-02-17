package com.netflix.mediaclient.ui.experience;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.util.TypedValue;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import o.AbstractC2089qj;
import o.AbstractC2159sr;
import o.C1004;
import o.C1276;
import o.C1322Av;
import o.C1492aW;
import o.C1529bE;
import o.C2160ss;
import o.C2182tl;
import o.rM;
public enum BrowseExperience implements rM {
    STANDARD {
        @Override // o.rM
        /* renamed from: ˋ  reason: contains not printable characters */
        public AbstractC2159sr mo1781(NetflixActivity netflixActivity, DrawerLayout drawerLayout) {
            return new C2160ss(netflixActivity, drawerLayout, true);
        }
    },
    KIDS_THEME {
        @Override // o.rM
        /* renamed from: ˋ */
        public AbstractC2159sr mo1781(NetflixActivity netflixActivity, DrawerLayout drawerLayout) {
            return new C2182tl(netflixActivity, drawerLayout);
        }
    };
    

    /* renamed from: ˊ  reason: contains not printable characters */
    private static BrowseExperience f3010 = STANDARD;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final TypedValue f3011 = new TypedValue();

    /* renamed from: ˏ  reason: contains not printable characters */
    public static BrowseExperience m1775() {
        return f3010;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m1770(AbstractC2089qj qjVar) {
        if (qjVar != null && qjVar.isKidsProfile()) {
            f3010 = KIDS_THEME;
        } else {
            f3010 = STANDARD;
        }
        String valueOf = String.valueOf(f3010);
        C1529bE.m5722(valueOf);
        C1492aW.m5405(valueOf);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m1780() {
        return f3010 == KIDS_THEME;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static ImageLoader.If m1769() {
        return m1780() ? StaticImgConfig.LIGHT : StaticImgConfig.DARK;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m1774(Activity activity, int i) {
        if (activity != null) {
            return m1768(activity.getTheme(), i);
        }
        C1276.m16820().mo5725("Context was null or not wrapping an Activity on getResourceIdFromTheme");
        return R.color.transparent;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int m1768(Resources.Theme theme, int i) {
        if (theme.resolveAttribute(i, f3011, true)) {
            return f3011.resourceId;
        }
        C1276.m16820().mo5728("Requesting theme's resource id. Theme was kid? " + m1780());
        C1276.m16820().mo5725("Requested a Theme resource id that was not existing");
        return R.color.transparent;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m1767(Activity activity, int i) {
        if (activity != null) {
            return m1773(activity.getTheme(), i);
        }
        C1276.m16820().mo5725("Context was null or not wrapping an Activity on getColorFromTheme");
        return 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int m1773(Resources.Theme theme, int i) {
        if (theme.resolveAttribute(i, f3011, true)) {
            return f3011.data;
        }
        C1276.m16820().mo5728("Requesting theme's color. Theme was kid? " + m1780());
        C1276.m16820().mo5725("Requested a Theme color attribute that was not existing");
        return 0;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m1771(Activity activity, int i) {
        if (activity != null) {
            return m1772(activity.getTheme(), i);
        }
        C1276.m16820().mo5725("Context was null or not wrapping an Activity on getBooleanFromTheme");
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean m1772(Resources.Theme theme, int i) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{i});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Drawable m1778(Drawable drawable, Activity activity, int i) {
        if (activity != null) {
            return m1779(drawable, activity.getTheme(), i);
        }
        C1276.m16820().mo5725("Activity was null on getTintedDrawableForTheme");
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static Drawable m1779(Drawable drawable, Resources.Theme theme, int i) {
        int r1 = m1773(theme, i);
        if (r1 != 0) {
            return C1004.m15955(drawable, r1);
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m1776(ImageView imageView, Drawable drawable, int i) {
        Activity activity;
        Context context = imageView.getContext();
        if (context == null || (activity = (Activity) C1322Av.m3791(context, Activity.class)) == null) {
            C1276.m16820().mo5725("Activity was null on setTintedDrawableForTheme");
        } else {
            m1777(imageView, drawable, activity.getTheme(), i);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m1777(ImageView imageView, Drawable drawable, Resources.Theme theme, int i) {
        int r1 = m1773(theme, i);
        if (r1 != 0) {
            imageView.setImageDrawable(C1004.m15955(drawable, r1));
        }
    }
}
