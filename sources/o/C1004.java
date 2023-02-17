package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
/* renamed from: o.ᵇ  reason: contains not printable characters */
public class C1004 {
    @SuppressLint({"netflix.ToastUiUtilsShow"})
    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m15961(Context context, String str, int i) {
        if (context != null) {
            Toast.makeText(C1322Av.m3794(context), str, i).show();
        }
    }

    @SuppressLint({"netflix.ToastUiUtilsShow"})
    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m15958(Context context, int i, int i2) {
        if (context != null) {
            Toast.makeText(C1322Av.m3794(context), context.getText(i), i2).show();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Drawable m15960(Drawable drawable, ColorStateList colorStateList, int i) {
        if (drawable == null) {
            return null;
        }
        Drawable wrap = DrawableCompat.wrap(drawable.mutate());
        if (i > 0) {
            wrap.setBounds(0, 0, i, i);
        }
        if (colorStateList != null) {
            DrawableCompat.setTint(wrap, colorStateList.getDefaultColor());
        }
        return wrap;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Drawable m15955(Drawable drawable, int i) {
        if (drawable == null) {
            return null;
        }
        Drawable wrap = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(wrap, i);
        return wrap;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m15957(View view) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        return ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).getMarginEnd();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m15956(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m15954(Context context, int i) {
        return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m15952(View view, int i, int i2) {
        if (view != null) {
            int paddingStart = view.getPaddingStart();
            int paddingTop = view.getPaddingTop();
            int paddingEnd = view.getPaddingEnd();
            int paddingBottom = view.getPaddingBottom();
            switch (i) {
                case 0:
                    view.setPaddingRelative(i2, paddingTop, paddingEnd, paddingBottom);
                    return;
                case 1:
                    view.setPaddingRelative(paddingStart, i2, paddingEnd, paddingBottom);
                    return;
                case 2:
                    view.setPaddingRelative(paddingStart, paddingTop, i2, paddingBottom);
                    return;
                case 3:
                    view.setPaddingRelative(paddingStart, paddingTop, paddingEnd, i2);
                    return;
                case 4:
                    view.setPaddingRelative(paddingStart, i2, paddingEnd, i2);
                    return;
                case 5:
                    view.setPaddingRelative(i2, paddingTop, i2, paddingBottom);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m15959(View view, int i, int i2) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            switch (i) {
                case 0:
                    marginLayoutParams.setMarginStart(i2);
                    break;
                case 1:
                    marginLayoutParams.topMargin = i2;
                    break;
                case 2:
                    marginLayoutParams.setMarginEnd(i2);
                    break;
                case 3:
                    marginLayoutParams.bottomMargin = i2;
                    break;
                case 4:
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.bottomMargin = i2;
                    break;
                case 5:
                    marginLayoutParams.setMarginStart(i2);
                    marginLayoutParams.setMarginEnd(i2);
                    break;
            }
            view.setLayoutParams(marginLayoutParams);
            return;
        }
        throw new IllegalArgumentException("View must be in a layout that supports margins");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m15953(final View view, final int i, final int i2, final int i3, final int i4) {
        final View view2;
        if (view != null && (view2 = (View) view.getParent()) != null) {
            view2.post(new Runnable() { // from class: o.ᵇ.1
                @Override // java.lang.Runnable
                public void run() {
                    Rect rect = new Rect();
                    view.getHitRect(rect);
                    rect.top -= i;
                    rect.left -= i2;
                    rect.right += i3;
                    rect.bottom += i4;
                    view2.setTouchDelegate(new TouchDelegate(rect, view));
                }
            });
        }
    }
}
