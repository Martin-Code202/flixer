package com.netflix.mediaclient.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.Pair;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import o.BX;
import o.C0810;
import o.C1004;
import o.C1276;
import o.C1283;
import o.C1317As;
import o.C1349Bv;
public class ViewUtils {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final Comparator<C0049> f4009 = new Comparator<C0049>() { // from class: com.netflix.mediaclient.util.ViewUtils.3
        /* renamed from: ˊ  reason: contains not printable characters */
        public int compare(C0049 r5, C0049 r6) {
            Rect r2 = ViewUtils.m3008(r5.m3040(), true);
            Rect r3 = ViewUtils.m3008(r6.m3040(), true);
            if (r2.bottom < r3.bottom) {
                return 1;
            }
            if (r2.bottom > r3.bottom) {
                return -1;
            }
            return 0;
        }
    };

    public enum Visibility {
        VISIBLE,
        INVISIBLE,
        GONE
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3017(DialogFragment dialogFragment, FragmentManager fragmentManager, FragmentTransaction fragmentTransaction, String str) {
        if (dialogFragment != null && fragmentManager != null && !C1349Bv.m4113(str) && fragmentTransaction != null) {
            fragmentManager.executePendingTransactions();
            if (!dialogFragment.isAdded()) {
                if (fragmentManager.findFragmentByTag(str) == null) {
                    dialogFragment.show(fragmentTransaction, str);
                    return;
                }
                m3031(str, dialogFragment);
                fragmentTransaction.commitAllowingStateLoss();
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m3031(String str, DialogFragment dialogFragment) {
        String format = String.format("SPY-8702, tried to add %s frag %s twice", dialogFragment.getClass().getName(), str);
        C1283.m16850("ViewUtils", format);
        C1276.m16820().mo5727(format);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Rect m3007(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3002(View view, boolean z) {
        m3010(view, z ? Visibility.VISIBLE : Visibility.GONE);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3020(View view, boolean z) {
        m3010(view, z ? Visibility.VISIBLE : Visibility.INVISIBLE);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3018(MenuItem menuItem, boolean z) {
        if (menuItem != null) {
            menuItem.setVisible(z);
        }
    }

    @Deprecated
    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3010(View view, Visibility visibility) {
        if (view != null && visibility != null) {
            int i = 8;
            if (visibility == Visibility.VISIBLE) {
                i = 0;
            } else if (visibility == Visibility.INVISIBLE) {
                i = 4;
            }
            view.setVisibility(i);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3019(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3005(View view) {
        Context context = view.getContext();
        if (context instanceof Activity) {
            return C1317As.m3750((Activity) context);
        }
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3022(TextView textView, int i) {
        textView.setTextColor(textView.getResources().getColor(i));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static NetflixActivity m3026(View view) {
        if (view == null) {
            return null;
        }
        Context context = view.getContext();
        if (context instanceof NetflixActivity) {
            return (NetflixActivity) context;
        }
        if (!(context instanceof ContextThemeWrapper)) {
            return null;
        }
        Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
        if (baseContext instanceof NetflixActivity) {
            return (NetflixActivity) baseContext;
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3009(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Bitmap m3024(Bitmap bitmap) {
        int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(max, max, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        canvas.drawBitmap(bitmap, (float) ((max - bitmap.getWidth()) / 2), (float) ((max - bitmap.getHeight()) / 2), (Paint) null);
        return createBitmap;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3001(View view, Rect rect) {
        rect.left = (int) view.getX();
        rect.top = (int) view.getY();
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Rect m3008(View view, boolean z) {
        C1283.m16854("ViewUtils", "getRect");
        if (z) {
            Object tag = view.getTag();
            if (tag instanceof Rect) {
                C1283.m16854("ViewUtils", "Rectangle was known from before, use it");
                return (Rect) tag;
            }
            C1283.m16854("ViewUtils", "Rectangle was NOT known from before, calculate");
            Rect rect = new Rect();
            m3001(view, rect);
            view.setTag(rect);
            return rect;
        }
        Rect rect2 = new Rect();
        m3001(view, rect2);
        return rect2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3035(final View view) {
        final CharSequence contentDescription = view.getContentDescription();
        if (C1349Bv.m4112(contentDescription)) {
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.netflix.mediaclient.util.ViewUtils.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    C1004.m15961(view.getContext(), contentDescription.toString(), 0);
                    return true;
                }
            });
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m3035(viewGroup.getChildAt(i));
            }
        }
    }

    /* renamed from: com.netflix.mediaclient.util.ViewUtils$ˋ  reason: contains not printable characters */
    public static class C0049 implements Comparable<C0049> {

        /* renamed from: ˊ  reason: contains not printable characters */
        public static final Comparator<C0049> f4016 = new Comparator<C0049>() { // from class: com.netflix.mediaclient.util.ViewUtils.ˋ.1
            /* renamed from: ˋ  reason: contains not printable characters */
            public int compare(C0049 r5, C0049 r6) {
                Rect r2 = ViewUtils.m3008(r5.m3040(), true);
                Rect r3 = ViewUtils.m3008(r6.m3040(), true);
                if (r2.bottom < r3.bottom) {
                    return -1;
                }
                if (r2.bottom > r3.bottom) {
                    return 1;
                }
                return 0;
            }
        };

        /* renamed from: ˋ  reason: contains not printable characters */
        public static final Comparator<C0049> f4017 = new Comparator<C0049>() { // from class: com.netflix.mediaclient.util.ViewUtils.ˋ.3
            /* renamed from: ˎ  reason: contains not printable characters */
            public int compare(C0049 r5, C0049 r6) {
                Rect r2 = ViewUtils.m3008(r5.m3040(), true);
                Rect r3 = ViewUtils.m3008(r6.m3040(), true);
                if (r2.top < r3.top) {
                    return -1;
                }
                if (r2.top > r3.top) {
                    return 1;
                }
                return 0;
            }
        };

        /* renamed from: ˎ  reason: contains not printable characters */
        public static final Comparator<C0049> f4018 = new Comparator<C0049>() { // from class: com.netflix.mediaclient.util.ViewUtils.ˋ.5
            /* renamed from: ˏ  reason: contains not printable characters */
            public int compare(C0049 r5, C0049 r6) {
                Rect r2 = ViewUtils.m3008(r5.m3040(), true);
                Rect r3 = ViewUtils.m3008(r6.m3040(), true);
                if (r2.top < r3.top) {
                    return 1;
                }
                if (r2.top > r3.top) {
                    return -1;
                }
                return 0;
            }
        };

        /* renamed from: ˏ  reason: contains not printable characters */
        private final View f4019;

        public C0049(View view) {
            if (view == null) {
                throw new IllegalArgumentException("View can not be null");
            }
            this.f4019 = view;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public View m3040() {
            return this.f4019;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public int compareTo(C0049 r5) {
            Rect r2 = ViewUtils.m3008(this.f4019, true);
            Rect r3 = ViewUtils.m3008(r5.m3040(), true);
            if (r2.bottom < r3.bottom) {
                return -1;
            }
            if (r2.bottom > r3.bottom) {
                return 1;
            }
            return 0;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static List<View> m3034(View view, Integer... numArr) {
        View findViewById;
        ArrayList arrayList = new ArrayList();
        for (Integer num : numArr) {
            if (!(num == null || (findViewById = view.findViewById(num.intValue())) == null)) {
                arrayList.add(findViewById);
            }
        }
        return arrayList;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3013(Collection<View> collection) {
        if (collection != null) {
            for (View view : collection) {
                if (view != null) {
                    view.setVisibility(0);
                }
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3037(ListView listView) {
        if (listView.getContext() instanceof NetflixActivity) {
            listView.addHeaderView(m3033((NetflixActivity) listView.getContext()));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static View m3033(NetflixActivity netflixActivity) {
        return m3025(netflixActivity, netflixActivity.getActionBarHeight());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static View m3025(NetflixActivity netflixActivity, int i) {
        View view = new View(netflixActivity);
        view.setId(R.id.action_bar_dummy_view);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, i));
        return view;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m3006(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.netflixActionBarSize});
        int dimension = (int) obtainStyledAttributes.getDimension(0, 0.0f);
        obtainStyledAttributes.recycle();
        return dimension;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3011(TextView textView) {
        textView.setTypeface(Typeface.create(textView.getTypeface(), 1));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3021(TextView textView) {
        textView.setTypeface(Typeface.create(textView.getTypeface(), 0));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3012(TextView textView, int i) {
        textView.setTextSize(0, (float) textView.getResources().getDimensionPixelOffset(i));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3036(View view, int i) {
        if (BX.m3957()) {
            view.setPadding(view.getPaddingRight(), view.getPaddingTop(), i, view.getPaddingBottom());
        } else {
            view.setPadding(i, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3029(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Pair<Integer, Integer> m3016(C0810 r9, ScrollView scrollView) {
        if (r9 == null || r9.getChildCount() == 0 || scrollView == null || scrollView.getChildCount() == 0) {
            return null;
        }
        Rect rect = new Rect();
        scrollView.getHitRect(rect);
        int childCount = r9.getChildCount();
        int i = -1;
        int i2 = 0;
        while (i2 < childCount) {
            boolean localVisibleRect = r9.getChildAt(i2).getLocalVisibleRect(rect);
            if (!localVisibleRect || i != -1) {
                if (!localVisibleRect && i != -1) {
                    break;
                }
            } else {
                i = i2;
            }
            i2++;
        }
        int i3 = i2 - 1;
        if (i == -1 || i3 == -1) {
            return null;
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i3));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3004(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity can not be null");
        }
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return activity.getResources().getDisplayMetrics().heightPixels == rect.bottom;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3032(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity can not be null");
        }
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return activity.getResources().getDisplayMetrics().widthPixels == rect.right;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m3015(Context context, boolean z) {
        int identifier = context.getResources().getIdentifier(z ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        C1283.m16850("ViewUtils", "Nav bar height uknown!");
        return 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m3014(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        C1283.m16850("ViewUtils", "Status bar height uknown!");
        return 0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3030(TextView textView) {
        textView.setAlpha(1.0f);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3038(TextView textView) {
        textView.setAlpha(0.7f);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3023(View view) {
        return view != null && view.getVisibility() == 0;
    }

    /* renamed from: com.netflix.mediaclient.util.ViewUtils$if  reason: invalid class name */
    public static class Cif extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3027(Drawable drawable, int i) {
        DrawableCompat.setTint(DrawableCompat.wrap(drawable), i);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3028(View.OnTouchListener onTouchListener, View... viewArr) {
        for (View view : viewArr) {
            view.setOnTouchListener(onTouchListener);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3003(Button button) {
        if (button != null && button.getParent() != null && (button.getParent() instanceof View)) {
            button.setVisibility(0);
            ((View) button.getParent()).setVisibility(0);
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m3000(View view) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof View)) {
            view.setVisibility(0);
            ((View) view.getParent()).setVisibility(0);
        }
    }
}
