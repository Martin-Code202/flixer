package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* renamed from: o.Er  reason: case insensitive filesystem */
public class C1429Er extends ViewGroup {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Comparator<C1430If> f5572 = new Comparator<C1430If>() { // from class: o.Er.5
        /* renamed from: ˎ  reason: contains not printable characters */
        public int compare(C1430If r3, C1430If r4) {
            return r3.f5635 - r4.f5635;
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final Interpolator f5573 = new Interpolator() { // from class: o.Er.4
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final int[] f5574 = {16842931};

    /* renamed from: ꜟ  reason: contains not printable characters */
    private static final aux f5575 = new aux();

    /* renamed from: ʹ  reason: contains not printable characters */
    private boolean f5576;

    /* renamed from: ʻ  reason: contains not printable characters */
    private PagerAdapter f5577;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private int f5578;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f5579 = -1;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private boolean f5580;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Parcelable f5581 = null;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private int f5582 = 1;

    /* renamed from: ʾ  reason: contains not printable characters */
    private boolean f5583;

    /* renamed from: ʿ  reason: contains not printable characters */
    private int f5584;

    /* renamed from: ˈ  reason: contains not printable characters */
    private boolean f5585;

    /* renamed from: ˉ  reason: contains not printable characters */
    private int f5586;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1430If f5587 = new C1430If();

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private int f5588;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private boolean f5589;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private Drawable f5590;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private boolean f5591;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ArrayList<C1430If> f5592 = new ArrayList<>();

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private int f5593;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private float f5594;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C0092 f5595;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private float f5596;

    /* renamed from: ˌ  reason: contains not printable characters */
    private int f5597 = -1;

    /* renamed from: ˍ  reason: contains not printable characters */
    private float f5598;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private float f5599;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private VelocityTracker f5600;

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private int f5601;

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private int f5602;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f5603;

    /* renamed from: ˑ  reason: contains not printable characters */
    private int f5604;

    /* renamed from: ͺ  reason: contains not printable characters */
    private ClassLoader f5605 = null;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private int f5606;

    /* renamed from: ـ  reason: contains not printable characters */
    private long f5607;

    /* renamed from: ॱʻ  reason: contains not printable characters */
    private boolean f5608;

    /* renamed from: ॱʼ  reason: contains not printable characters */
    private EdgeEffectCompat f5609;

    /* renamed from: ॱʽ  reason: contains not printable characters */
    private EdgeEffectCompat f5610;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Scroller f5611;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private int f5612;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private float f5613 = -3.4028235E38f;

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private boolean f5614 = true;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f5615;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private int f5616;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Rect f5617 = new Rect();

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private int f5618;

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    private boolean f5619;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private float f5620 = Float.MAX_VALUE;

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private AbstractC0091 f5621;

    /* renamed from: ᐧ  reason: contains not printable characters */
    private AbstractC0094 f5622;

    /* renamed from: ᐨ  reason: contains not printable characters */
    private AbstractC0094 f5623;

    /* renamed from: ᶥ  reason: contains not printable characters */
    private ArrayList<View> f5624;

    /* renamed from: ㆍ  reason: contains not printable characters */
    private int f5625;

    /* renamed from: ꓸ  reason: contains not printable characters */
    private Method f5626;

    /* renamed from: ꜞ  reason: contains not printable characters */
    private AbstractC0093 f5627;

    /* renamed from: ꞌ  reason: contains not printable characters */
    private final Runnable f5628 = new Runnable() { // from class: o.Er.2
        @Override // java.lang.Runnable
        public void run() {
            C1429Er.this.m4929(0);
            C1429Er.this.m4957();
        }
    };

    /* renamed from: ﾟ  reason: contains not printable characters */
    private int f5629 = 0;

    /* renamed from: o.Er$If  reason: case insensitive filesystem */
    public static class C1430If {

        /* renamed from: ˊ  reason: contains not printable characters */
        public float f5634;

        /* renamed from: ˋ  reason: contains not printable characters */
        public int f5635;

        /* renamed from: ˎ  reason: contains not printable characters */
        public Object f5636;

        /* renamed from: ˏ  reason: contains not printable characters */
        public boolean f5637;

        /* renamed from: ॱ  reason: contains not printable characters */
        public float f5638;
    }

    /* renamed from: o.Er$ˊ  reason: contains not printable characters */
    interface AbstractC0090 {
    }

    /* renamed from: o.Er$ˋ  reason: contains not printable characters */
    interface AbstractC0091 {
        /* renamed from: ˋ  reason: contains not printable characters */
        void m4969(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* renamed from: o.Er$ˏ  reason: contains not printable characters */
    public interface AbstractC0093 {
        /* renamed from: ˊ  reason: contains not printable characters */
        void m4970(View view, float f);
    }

    /* renamed from: o.Er$ᐝ  reason: contains not printable characters */
    public interface AbstractC0094 {
        /* renamed from: ˎ */
        void mo4914(int i);

        /* renamed from: ˏ */
        void mo4915(int i);

        /* renamed from: ॱ */
        void mo4916(int i, float f, int i2);
    }

    public C1429Er(Context context) {
        super(context);
        m4959();
    }

    public C1429Er(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4959();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m4959() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f5611 = new Scroller(context, f5573);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f5588 = viewConfiguration.getScaledTouchSlop();
        this.f5602 = (int) (400.0f * f);
        this.f5601 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f5610 = new EdgeEffectCompat(context);
        this.f5609 = new EdgeEffectCompat(context);
        this.f5606 = (int) (20.0f * f);
        this.f5604 = (int) (2.0f * f);
        this.f5586 = (int) (16.0f * f);
        ViewCompat.setAccessibilityDelegate(this, new C1431iF());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f5628);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m4929(int i) {
        if (this.f5629 != i) {
            this.f5629 = i;
            if (this.f5627 != null) {
                m4930(i != 0);
            }
            if (this.f5623 != null) {
                this.f5623.mo4915(i);
            }
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.f5577 != null) {
            this.f5577.unregisterDataSetObserver(this.f5595);
            this.f5577.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f5592.size(); i++) {
                C1430If r4 = this.f5592.get(i);
                this.f5577.destroyItem((ViewGroup) this, r4.f5635, r4.f5636);
            }
            this.f5577.finishUpdate((ViewGroup) this);
            this.f5592.clear();
            m4925();
            this.f5615 = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.f5577;
        this.f5577 = pagerAdapter;
        if (this.f5577 != null) {
            if (this.f5595 == null) {
                this.f5595 = new C0092();
            }
            this.f5577.registerDataSetObserver(this.f5595);
            this.f5585 = false;
            this.f5614 = true;
            if (this.f5579 >= 0) {
                this.f5577.restoreState(this.f5581, this.f5605);
                m4950(this.f5579, false, true);
                this.f5579 = -1;
                this.f5581 = null;
                this.f5605 = null;
            } else {
                m4957();
            }
        }
        if (!(this.f5621 == null || pagerAdapter2 == pagerAdapter)) {
            this.f5621.m4969(pagerAdapter2, pagerAdapter);
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m4925() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((Cif) getChildAt(i).getLayoutParams()).f5640) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public PagerAdapter m4942() {
        return this.f5577;
    }

    public void setCurrentItem(int i) {
        this.f5585 = false;
        m4950(i, !this.f5614, false);
    }

    public void setCurrentItem(int i, boolean z) {
        setCurrentItem(i, z, true);
    }

    public void setCurrentItem(int i, boolean z, boolean z2) {
        this.f5585 = false;
        m4952(i, z, true, z2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m4950(int i, boolean z, boolean z2) {
        m4952(i, z, z2, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m4952(int i, boolean z, boolean z2, boolean z3) {
        m4961(i, z, z2, 0, z3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m4961(int i, boolean z, boolean z2, int i2, boolean z3) {
        if (this.f5577 == null || this.f5577.getCount() <= 0) {
            m4926(false);
        } else if (z2 || this.f5615 != i || this.f5592.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f5577.getCount()) {
                i = this.f5577.getCount() - 1;
            }
            int i3 = this.f5582;
            if (i > this.f5615 + i3 || i < this.f5615 - i3) {
                for (int i4 = 0; i4 < this.f5592.size(); i4++) {
                    this.f5592.get(i4).f5637 = true;
                }
            }
            boolean z4 = this.f5615 != i && z3;
            m4943(i);
            m4921(i, z, i2, z4);
        } else {
            m4926(false);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m4921(int i, boolean z, int i2, boolean z2) {
        C1430If r4 = m4955(i);
        int i3 = 0;
        if (r4 != null) {
            i3 = (int) (((float) getWidth()) * Math.max(this.f5613, Math.min(r4.f5638, this.f5620)));
        }
        if (z) {
            m4960(i3, 0, i2);
            if (z2 && this.f5623 != null) {
                this.f5623.mo4914(i);
            }
            if (z2 && this.f5622 != null) {
                this.f5622.mo4914(i);
                return;
            }
            return;
        }
        if (z2 && this.f5623 != null) {
            this.f5623.mo4914(i);
        }
        if (z2 && this.f5622 != null) {
            this.f5622.mo4914(i);
        }
        m4937(false);
        scrollTo(i3, 0);
    }

    public void setOnPageChangeListener(AbstractC0094 r1) {
        this.f5623 = r1;
    }

    public void setPageTransformer(boolean z, AbstractC0093 r5) {
        boolean z2 = r5 != null;
        boolean z3 = z2 != (this.f5627 != null);
        this.f5627 = r5;
        m4944(z2);
        if (z2) {
            this.f5625 = z ? 2 : 1;
        } else {
            this.f5625 = 0;
        }
        if (z3) {
            m4957();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m4944(boolean z) {
        if (this.f5626 == null) {
            try {
                this.f5626 = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e) {
                Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
            }
        }
        try {
            this.f5626.invoke(this, Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.e("ViewPager", "Error changing children drawing order", e2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        return ((Cif) this.f5624.get(this.f5625 == 2 ? (i - 1) - i2 : i2).getLayoutParams()).f5645;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.f5582) {
            this.f5582 = i;
            m4957();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f5603;
        this.f5603 = i;
        int width = getWidth();
        m4936(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f5590 = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setTouchSlop(int i) {
        this.f5588 = i;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5590;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f5590;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public float m4954(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m4960(int i, int i2, int i3) {
        int i4;
        if (getChildCount() == 0) {
            m4926(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i - scrollX;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m4937(false);
            m4957();
            m4929(0);
            return;
        }
        m4926(true);
        m4929(2);
        int width = getWidth();
        int i7 = width / 2;
        float r13 = ((float) i7) + (((float) i7) * m4954(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) width))));
        int abs = Math.abs(i3);
        if (abs > 0) {
            i4 = Math.round(Math.abs(r13 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i4 = (int) ((1.0f + (((float) Math.abs(i5)) / (((float) this.f5603) + (((float) width) * this.f5577.getPageWidth(this.f5615))))) * 100.0f);
        }
        this.f5611.startScroll(scrollX, scrollY, i5, i6, Math.min(i4, 400));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public C1430If m4946(int i, int i2) {
        C1430If r1 = new C1430If();
        r1.f5635 = i;
        r1.f5636 = this.f5577.instantiateItem((ViewGroup) this, i);
        r1.f5634 = this.f5577.getPageWidth(i);
        if (i2 < 0 || i2 >= this.f5592.size()) {
            this.f5592.add(r1);
        } else {
            this.f5592.add(i2, r1);
        }
        return r1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m4947() {
        boolean z = this.f5592.size() < (this.f5582 * 2) + 1 && this.f5592.size() < this.f5577.getCount();
        int i = this.f5615;
        boolean z2 = false;
        int i2 = 0;
        while (i2 < this.f5592.size()) {
            C1430If r7 = this.f5592.get(i2);
            int itemPosition = this.f5577.getItemPosition(r7.f5636);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f5592.remove(i2);
                    i2--;
                    if (!z2) {
                        this.f5577.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.f5577.destroyItem((ViewGroup) this, r7.f5635, r7.f5636);
                    z = true;
                    if (this.f5615 == r7.f5635) {
                        i = Math.max(0, Math.min(this.f5615, this.f5577.getCount() - 1));
                        z = true;
                    }
                } else if (r7.f5635 != itemPosition) {
                    if (r7.f5635 == this.f5615) {
                        i = itemPosition;
                    }
                    r7.f5635 = itemPosition;
                    z = true;
                }
            }
            i2++;
        }
        if (z2) {
            this.f5577.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f5592, f5572);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                Cif ifVar = (Cif) getChildAt(i3).getLayoutParams();
                if (!ifVar.f5640) {
                    ifVar.f5644 = 0.0f;
                }
            }
            m4950(i, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m4957() {
        m4943(this.f5615);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m4943(int i) {
        C1430If r16;
        C1430If r4 = null;
        if (this.f5615 != i) {
            r4 = m4955(this.f5615);
            this.f5615 = i;
        }
        if (!(this.f5577 == null || this.f5585 || getWindowToken() == null)) {
            this.f5577.startUpdate((ViewGroup) this);
            int i2 = this.f5582;
            int max = Math.max(0, this.f5615 - i2);
            int count = this.f5577.getCount();
            int min = Math.min(count - 1, this.f5615 + i2);
            C1430If r10 = null;
            int i3 = 0;
            while (true) {
                if (i3 >= this.f5592.size()) {
                    break;
                }
                C1430If r11 = this.f5592.get(i3);
                if (r11.f5635 < this.f5615) {
                    i3++;
                } else if (r11.f5635 == this.f5615) {
                    r10 = r11;
                }
            }
            if (r10 == null && count > 0) {
                r10 = m4946(this.f5615, i3);
            }
            if (r10 != null) {
                float f = 0.0f;
                int i4 = i3 - 1;
                C1430If r13 = i4 >= 0 ? this.f5592.get(i4) : null;
                float f2 = 2.0f - r10.f5634;
                for (int i5 = this.f5615 - 1; i5 >= 0; i5--) {
                    if (f < f2 || i5 >= max) {
                        if (r13 == null || i5 != r13.f5635) {
                            f += m4946(i5, i4 + 1).f5634;
                            i3++;
                            r13 = i4 >= 0 ? this.f5592.get(i4) : null;
                        } else {
                            f += r13.f5634;
                            i4--;
                            r13 = i4 >= 0 ? this.f5592.get(i4) : null;
                        }
                    } else if (r13 == null) {
                        break;
                    } else if (i5 == r13.f5635 && !r13.f5637) {
                        this.f5592.remove(i4);
                        this.f5577.destroyItem((ViewGroup) this, i5, r13.f5636);
                        i4--;
                        i3--;
                        r13 = i4 >= 0 ? this.f5592.get(i4) : null;
                    }
                }
                float f3 = r10.f5634;
                int i6 = i3 + 1;
                if (f3 < 2.0f) {
                    C1430If r132 = i6 < this.f5592.size() ? this.f5592.get(i6) : null;
                    for (int i7 = this.f5615 + 1; i7 < count; i7++) {
                        if (f3 < 2.0f || i7 <= min) {
                            if (r132 == null || i7 != r132.f5635) {
                                C1430If r133 = m4946(i7, i6);
                                i6++;
                                if (r133 != null) {
                                    f3 += r133.f5634;
                                }
                                r132 = i6 < this.f5592.size() ? this.f5592.get(i6) : null;
                            } else {
                                f3 += r132.f5634;
                                i6++;
                                r132 = i6 < this.f5592.size() ? this.f5592.get(i6) : null;
                            }
                        } else if (r132 == null) {
                            break;
                        } else if (i7 == r132.f5635 && !r132.f5637) {
                            this.f5592.remove(i6);
                            this.f5577.destroyItem((ViewGroup) this, i7, r132.f5636);
                            r132 = i6 < this.f5592.size() ? this.f5592.get(i6) : null;
                        }
                    }
                }
                m4922(r10, i3, r4);
            }
            this.f5577.setPrimaryItem((ViewGroup) this, this.f5615, r10 != null ? r10.f5636 : null);
            this.f5577.finishUpdate((ViewGroup) this);
            boolean z = this.f5625 != 0;
            if (z) {
                if (this.f5624 == null) {
                    this.f5624 = new ArrayList<>();
                } else {
                    this.f5624.clear();
                }
            }
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                Cif ifVar = (Cif) childAt.getLayoutParams();
                ifVar.f5645 = i8;
                if (!ifVar.f5640 && ifVar.f5644 == 0.0f && (r16 = m4956(childAt)) != null) {
                    ifVar.f5644 = r16.f5634;
                    ifVar.f5641 = r16.f5635;
                }
                if (z) {
                    this.f5624.add(childAt);
                }
            }
            if (z) {
                Collections.sort(this.f5624, f5575);
            }
            if (hasFocus()) {
                View findFocus = findFocus();
                C1430If r14 = findFocus != null ? m4958(findFocus) : null;
                if (r14 == null || r14.f5635 != this.f5615) {
                    for (int i9 = 0; i9 < getChildCount(); i9++) {
                        View childAt2 = getChildAt(i9);
                        C1430If r142 = m4956(childAt2);
                        if (r142 != null && r142.f5635 == this.f5615 && childAt2.requestFocus(2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m4922(C1430If r11, int i, C1430If r13) {
        C1430If r7;
        C1430If r72;
        int count = this.f5577.getCount();
        int width = getWidth();
        float f = width > 0 ? ((float) this.f5603) / ((float) width) : 0.0f;
        if (r13 != null) {
            int i2 = r13.f5635;
            if (i2 < r11.f5635) {
                int i3 = 0;
                float f2 = r13.f5638 + r13.f5634 + f;
                int i4 = i2 + 1;
                while (i4 <= r11.f5635 && i3 < this.f5592.size()) {
                    C1430If r0 = this.f5592.get(i3);
                    while (true) {
                        r72 = r0;
                        if (i4 <= r72.f5635 || i3 >= this.f5592.size() - 1) {
                            break;
                        }
                        i3++;
                        r0 = this.f5592.get(i3);
                    }
                    while (i4 < r72.f5635) {
                        f2 += this.f5577.getPageWidth(i4) + f;
                        i4++;
                    }
                    r72.f5638 = f2;
                    f2 += r72.f5634 + f;
                    i4++;
                }
            } else if (i2 > r11.f5635) {
                int size = this.f5592.size() - 1;
                float f3 = r13.f5638;
                int i5 = i2 - 1;
                while (i5 >= r11.f5635 && size >= 0) {
                    C1430If r02 = this.f5592.get(size);
                    while (true) {
                        r7 = r02;
                        if (i5 >= r7.f5635 || size <= 0) {
                            break;
                        }
                        size--;
                        r02 = this.f5592.get(size);
                    }
                    while (i5 > r7.f5635) {
                        f3 -= this.f5577.getPageWidth(i5) + f;
                        i5--;
                    }
                    f3 -= r7.f5634 + f;
                    r7.f5638 = f3;
                    i5--;
                }
            }
        }
        int size2 = this.f5592.size();
        float f4 = r11.f5638;
        int i6 = r11.f5635 - 1;
        this.f5613 = r11.f5635 == 0 ? r11.f5638 : -3.4028235E38f;
        this.f5620 = r11.f5635 == count + -1 ? (r11.f5638 + r11.f5634) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            C1430If r9 = this.f5592.get(i7);
            while (i6 > r9.f5635) {
                i6--;
                f4 -= this.f5577.getPageWidth(i6) + f;
            }
            f4 -= r9.f5634 + f;
            r9.f5638 = f4;
            if (r9.f5635 == 0) {
                this.f5613 = f4;
            }
            i7--;
            i6--;
        }
        float f5 = r11.f5638 + r11.f5634 + f;
        int i8 = r11.f5635 + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            C1430If r92 = this.f5592.get(i9);
            while (i8 < r92.f5635) {
                i8++;
                f5 += this.f5577.getPageWidth(i8) + f;
            }
            if (r92.f5635 == count - 1) {
                this.f5620 = (r92.f5634 + f5) - 1.0f;
            }
            r92.f5638 = f5;
            f5 += r92.f5634 + f;
            i9++;
            i8++;
        }
    }

    /* renamed from: o.Er$IF */
    public static class IF extends View.BaseSavedState {
        public static final Parcelable.Creator<IF> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<IF>() { // from class: o.Er.IF.4
            /* renamed from: ˋ  reason: contains not printable characters */
            public IF createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new IF(parcel, classLoader);
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public IF[] newArray(int i) {
                return new IF[i];
            }
        });

        /* renamed from: ˊ  reason: contains not printable characters */
        Parcelable f5631;

        /* renamed from: ˋ  reason: contains not printable characters */
        int f5632;

        /* renamed from: ˎ  reason: contains not printable characters */
        ClassLoader f5633;

        public IF(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5632);
            parcel.writeParcelable(this.f5631, i);
        }

        @Override // java.lang.Object
        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f5632 + "}";
        }

        IF(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f5632 = parcel.readInt();
            this.f5631 = parcel.readParcelable(classLoader);
            this.f5633 = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        IF r2 = new IF(super.onSaveInstanceState());
        r2.f5632 = this.f5615;
        if (this.f5577 != null) {
            r2.f5631 = this.f5577.saveState();
        }
        return r2;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof IF)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        IF r3 = (IF) parcelable;
        super.onRestoreInstanceState(r3.getSuperState());
        if (this.f5577 != null) {
            this.f5577.restoreState(r3.f5631, r3.f5633);
            m4950(r3.f5632, false, true);
            return;
        }
        this.f5579 = r3.f5632;
        this.f5581 = r3.f5631;
        this.f5605 = r3.f5633;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        Cif ifVar = (Cif) layoutParams;
        ifVar.f5640 |= view instanceof AbstractC0090;
        if (!this.f5583) {
            super.addView(view, i, layoutParams);
        } else if (ifVar == null || !ifVar.f5640) {
            ifVar.f5643 = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f5583) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public C1430If m4956(View view) {
        for (int i = 0; i < this.f5592.size(); i++) {
            C1430If r3 = this.f5592.get(i);
            if (this.f5577.isViewFromObject(view, r3.f5636)) {
                return r3;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public C1430If m4958(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return m4956(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public C1430If m4955(int i) {
        for (int i2 = 0; i2 < this.f5592.size(); i2++) {
            C1430If r2 = this.f5592.get(i2);
            if (r2.f5635 == i) {
                return r2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5614 = true;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Cif ifVar;
        Cif ifVar2;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f5593 = Math.min(measuredWidth / 10, this.f5586);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (!(childAt.getVisibility() == 8 || (ifVar2 = (Cif) childAt.getLayoutParams()) == null || !ifVar2.f5640)) {
                int i4 = ifVar2.f5642 & 7;
                int i5 = ifVar2.f5642 & 112;
                int i6 = Integer.MIN_VALUE;
                int i7 = Integer.MIN_VALUE;
                boolean z = i5 == 48 || i5 == 80;
                boolean z2 = i4 == 3 || i4 == 5;
                if (z) {
                    i6 = 1073741824;
                } else if (z2) {
                    i7 = 1073741824;
                }
                int i8 = paddingLeft;
                int i9 = measuredHeight;
                if (ifVar2.width != -2) {
                    i6 = 1073741824;
                    if (ifVar2.width != -1) {
                        i8 = ifVar2.width;
                    }
                }
                if (ifVar2.height != -2) {
                    i7 = 1073741824;
                    if (ifVar2.height != -1) {
                        i9 = ifVar2.height;
                    }
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i8, i6), View.MeasureSpec.makeMeasureSpec(i9, i7));
                if (z) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
        }
        this.f5578 = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f5584 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f5583 = true;
        m4957();
        this.f5583 = false;
        int childCount2 = getChildCount();
        for (int i10 = 0; i10 < childCount2; i10++) {
            View childAt2 = getChildAt(i10);
            if (childAt2.getVisibility() != 8 && ((ifVar = (Cif) childAt2.getLayoutParams()) == null || !ifVar.f5640)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) paddingLeft) * ifVar.f5644), 1073741824), this.f5584);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m4936(i, i3, this.f5603, this.f5603);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m4936(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f5592.isEmpty()) {
            C1430If r6 = m4955(this.f5615);
            int min = (int) (((float) i) * (r6 != null ? Math.min(r6.f5638, this.f5620) : 0.0f));
            if (min != getScrollX()) {
                m4937(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int scrollX = (int) (((float) (i + i3)) * (((float) getScrollX()) / ((float) (i2 + i4))));
        scrollTo(scrollX, getScrollY());
        if (!this.f5611.isFinished()) {
            this.f5611.startScroll(scrollX, 0, (int) (m4955(this.f5615).f5638 * ((float) i)), 0, this.f5611.getDuration() - this.f5611.timePassed());
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C1430If r16;
        int i5;
        int i6;
        this.f5583 = true;
        m4957();
        this.f5583 = false;
        int childCount = getChildCount();
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                Cif ifVar = (Cif) childAt.getLayoutParams();
                if (ifVar.f5640) {
                    int i11 = ifVar.f5642 & 7;
                    int i12 = ifVar.f5642 & 112;
                    switch (i11) {
                        case 1:
                            i5 = Math.max((i7 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            i5 = paddingLeft;
                            break;
                        case 3:
                            i5 = paddingLeft;
                            paddingLeft += childAt.getMeasuredWidth();
                            break;
                        case 5:
                            i5 = (i7 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            break;
                    }
                    switch (i12) {
                        case 16:
                            i6 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            break;
                        case 48:
                            i6 = paddingTop;
                            paddingTop += childAt.getMeasuredHeight();
                            break;
                        case 80:
                            i6 = (i8 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                            break;
                        default:
                            i6 = paddingTop;
                            break;
                    }
                    int i13 = i5 + scrollX;
                    childAt.layout(i13, i6, childAt.getMeasuredWidth() + i13, childAt.getMeasuredHeight() + i6);
                    i9++;
                }
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt2 = getChildAt(i14);
            if (childAt2.getVisibility() != 8) {
                Cif ifVar2 = (Cif) childAt2.getLayoutParams();
                if (!ifVar2.f5640 && (r16 = m4956(childAt2)) != null) {
                    int i15 = paddingLeft + ((int) (((float) i7) * r16.f5638));
                    if (ifVar2.f5643) {
                        ifVar2.f5643 = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) ((i7 - paddingLeft) - paddingRight)) * ifVar2.f5644), 1073741824), View.MeasureSpec.makeMeasureSpec((i8 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i15, paddingTop, childAt2.getMeasuredWidth() + i15, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.f5616 = paddingTop;
        this.f5612 = i8 - paddingBottom;
        this.f5618 = i9;
        this.f5614 = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f5611.isFinished() || !this.f5611.computeScrollOffset()) {
            m4937(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f5611.getCurrX();
        int currY = this.f5611.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m4927(currX)) {
                this.f5611.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m4927(int i) {
        if (this.f5592.size() == 0) {
            this.f5619 = false;
            m4949(0, 0.0f, 0);
            if (this.f5619) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C1430If r3 = m4928();
        int width = getWidth();
        int i2 = width + this.f5603;
        float f = ((float) this.f5603) / ((float) width);
        int i3 = r3.f5635;
        float f2 = ((((float) i) / ((float) width)) - r3.f5638) / (r3.f5634 + f);
        this.f5619 = false;
        m4949(i3, f2, (int) (((float) i2) * f2));
        if (this.f5619) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m4949(int i, float f, int i2) {
        int i3;
        if (this.f5618 > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                Cif ifVar = (Cif) childAt.getLayoutParams();
                if (ifVar.f5640) {
                    switch (ifVar.f5642 & 7) {
                        case 1:
                            i3 = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            i3 = paddingLeft;
                            break;
                        case 3:
                            i3 = paddingLeft;
                            paddingLeft += childAt.getWidth();
                            break;
                        case 5:
                            i3 = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            break;
                    }
                    int left = (i3 + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                }
            }
        }
        if (this.f5623 != null) {
            this.f5623.mo4916(i, f, i2);
        }
        if (this.f5622 != null) {
            this.f5622.mo4916(i, f, i2);
        }
        if (this.f5627 != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i5 = 0; i5 < childCount2; i5++) {
                View childAt2 = getChildAt(i5);
                if (!((Cif) childAt2.getLayoutParams()).f5640) {
                    this.f5627.m4970(childAt2, ((float) (childAt2.getLeft() - scrollX2)) / ((float) getWidth()));
                }
            }
        }
        this.f5619 = true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m4937(boolean z) {
        boolean z2 = this.f5629 == 2;
        if (z2) {
            m4926(false);
            this.f5611.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f5611.getCurrX();
            int currY = this.f5611.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.f5585 = false;
        for (int i = 0; i < this.f5592.size(); i++) {
            C1430If r4 = this.f5592.get(i);
            if (r4.f5637) {
                z2 = true;
                r4.f5637 = false;
            }
        }
        if (!z2) {
            return;
        }
        if (z) {
            ViewCompat.postOnAnimation(this, this.f5628);
        } else {
            this.f5628.run();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m4924(float f, float f2) {
        return (f < ((float) this.f5593) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f5593)) && f2 < 0.0f);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m4930(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.setLayerType(getChildAt(i), z ? 2 : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return m4939(motionEvent);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m4939(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f5576 = false;
            this.f5589 = false;
            this.f5591 = false;
            this.f5597 = -1;
            if (this.f5600 == null) {
                return false;
            }
            this.f5600.recycle();
            this.f5600 = null;
            return false;
        }
        if (action != 0) {
            if (this.f5589) {
                this.f5576 = false;
                return true;
            } else if (this.f5591) {
                this.f5576 = false;
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f5596 = x;
                this.f5598 = x;
                float y = motionEvent.getY();
                this.f5599 = y;
                this.f5594 = y;
                this.f5597 = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f5591 = false;
                this.f5576 = true;
                this.f5611.computeScrollOffset();
                if (this.f5629 == 2 && Math.abs(this.f5611.getFinalX() - this.f5611.getCurrX()) > this.f5604) {
                    this.f5611.abortAnimation();
                    this.f5585 = false;
                    m4957();
                    this.f5589 = true;
                    m4929(1);
                    break;
                } else {
                    m4937(false);
                    this.f5589 = false;
                    break;
                }
                break;
            case 2:
                int i = this.f5597;
                if (i != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                    float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float f = x2 - this.f5598;
                    float abs = Math.abs(f);
                    float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(y2 - this.f5599);
                    if (f == 0.0f || m4924(this.f5598, f) || !m4945(this, false, (int) f, (int) x2, (int) y2)) {
                        if (abs > ((float) this.f5588) && abs > abs2) {
                            this.f5589 = true;
                            m4929(1);
                            this.f5598 = f > 0.0f ? this.f5596 + ((float) this.f5588) : this.f5596 - ((float) this.f5588);
                            this.f5594 = y2;
                            m4926(true);
                        } else if (abs2 > ((float) this.f5588)) {
                            this.f5591 = true;
                        }
                        if (this.f5589 && m4938(x2)) {
                            ViewCompat.postInvalidateOnAnimation(this);
                            break;
                        }
                    } else {
                        this.f5576 = false;
                        this.f5598 = x2;
                        this.f5594 = y2;
                        this.f5591 = true;
                        return false;
                    }
                }
                break;
            case 6:
                m4931(motionEvent);
                break;
        }
        if (this.f5600 == null) {
            this.f5600 = VelocityTracker.obtain();
        }
        this.f5600.addMovement(motionEvent);
        return this.f5589;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f5608) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.f5577 == null || this.f5577.getCount() == 0) {
            return false;
        }
        if (this.f5600 == null) {
            this.f5600 = VelocityTracker.obtain();
        }
        this.f5600.addMovement(motionEvent);
        boolean z = false;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f5611.abortAnimation();
                this.f5585 = false;
                m4957();
                this.f5589 = true;
                m4929(1);
                float x = motionEvent.getX();
                this.f5596 = x;
                this.f5598 = x;
                float y = motionEvent.getY();
                this.f5599 = y;
                this.f5594 = y;
                this.f5597 = MotionEventCompat.getPointerId(motionEvent, 0);
                break;
            case 1:
                if (this.f5589) {
                    VelocityTracker velocityTracker = this.f5600;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f5601);
                    int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.f5597);
                    this.f5585 = true;
                    int width = getWidth();
                    int scrollX = getScrollX();
                    C1430If r12 = m4928();
                    m4961(m4933(r12.f5635, ((((float) scrollX) / ((float) width)) - r12.f5638) / r12.f5634, xVelocity, (int) (MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f5597)) - this.f5596)), true, true, xVelocity, true);
                    this.f5597 = -1;
                    m4932();
                    z = this.f5610.onRelease() | this.f5609.onRelease();
                    break;
                }
                break;
            case 2:
                if (!this.f5589) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f5597);
                    float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float abs = Math.abs(x2 - this.f5598);
                    float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(y2 - this.f5594);
                    if (abs > ((float) this.f5588) && abs > abs2) {
                        this.f5589 = true;
                        this.f5598 = x2 - this.f5596 > 0.0f ? this.f5596 + ((float) this.f5588) : this.f5596 - ((float) this.f5588);
                        this.f5594 = y2;
                        m4929(1);
                        m4926(true);
                    }
                }
                if (this.f5589) {
                    z = m4938(MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f5597))) | false;
                    break;
                }
                break;
            case 3:
                if (this.f5589) {
                    m4921(this.f5615, true, 0, false);
                    this.f5597 = -1;
                    m4932();
                    z = this.f5610.onRelease() | this.f5609.onRelease();
                    break;
                }
                break;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.f5598 = MotionEventCompat.getX(motionEvent, actionIndex);
                this.f5597 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                break;
            case 6:
                m4931(motionEvent);
                this.f5598 = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f5597));
                break;
        }
        if (!z) {
            return true;
        }
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m4938(float f) {
        boolean z = false;
        float f2 = this.f5598 - f;
        this.f5598 = f;
        float scrollX = ((float) getScrollX()) + f2;
        int width = getWidth();
        float f3 = ((float) width) * this.f5613;
        float f4 = ((float) width) * this.f5620;
        boolean z2 = true;
        boolean z3 = true;
        if (this.f5592.size() <= 0) {
            Log.w("ViewPager", "We have no items to drag - returning early");
            return false;
        }
        C1430If r12 = this.f5592.get(0);
        C1430If r13 = this.f5592.get(this.f5592.size() - 1);
        if (r12.f5635 != 0) {
            z2 = false;
            f3 = r12.f5638 * ((float) width);
        }
        if (r13.f5635 != this.f5577.getCount() - 1) {
            z3 = false;
            f4 = r13.f5638 * ((float) width);
        }
        if (scrollX < f3) {
            if (z2) {
                z = this.f5610.onPull(Math.abs(f3 - scrollX) / ((float) width));
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z3) {
                z = this.f5609.onPull(Math.abs(scrollX - f4) / ((float) width));
            }
            scrollX = f4;
        }
        this.f5598 += scrollX - ((float) ((int) scrollX));
        scrollTo((int) scrollX, getScrollY());
        m4927((int) scrollX);
        return z;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C1430If m4928() {
        int width = getWidth();
        float scrollX = width > 0 ? ((float) getScrollX()) / ((float) width) : 0.0f;
        float f = width > 0 ? ((float) this.f5603) / ((float) width) : 0.0f;
        int i = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        boolean z = true;
        C1430If r9 = null;
        int i2 = 0;
        while (i2 < this.f5592.size()) {
            C1430If r11 = this.f5592.get(i2);
            if (!z && r11.f5635 != i + 1) {
                r11 = this.f5587;
                r11.f5638 = f2 + f3 + f;
                r11.f5635 = i + 1;
                r11.f5634 = this.f5577.getPageWidth(r11.f5635);
                i2--;
            }
            float f4 = r11.f5638;
            float f5 = r11.f5634 + f4 + f;
            if (!z && scrollX < f4) {
                return r9;
            }
            if (scrollX < f5 || i2 == this.f5592.size() - 1) {
                return r11;
            }
            z = false;
            i = r11.f5635;
            f2 = f4;
            f3 = r11.f5634;
            r9 = r11;
            i2++;
        }
        return r9;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private int m4933(int i, float f, int i2, int i3) {
        int i4;
        if (Math.abs(i3) <= this.f5606 || Math.abs(i2) <= this.f5602) {
            i4 = (int) (((float) i) + f + (i >= this.f5615 ? 0.4f : 0.6f));
        } else {
            i4 = i2 > 0 ? i : i + 1;
        }
        if (this.f5592.size() <= 0) {
            return i4;
        }
        return Math.max(this.f5592.get(0).f5635, Math.min(i4, this.f5592.get(this.f5592.size() - 1).f5635));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z = false;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f5577 != null && this.f5577.getCount() > 1)) {
            if (!this.f5610.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f5613 * ((float) width));
                this.f5610.setSize(height, width);
                z = this.f5610.draw(canvas) | false;
                canvas.restoreToCount(save);
            }
            if (!this.f5609.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f5620 + 1.0f)) * ((float) width2));
                this.f5609.setSize(height2, width2);
                z |= this.f5609.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.f5610.finish();
            this.f5609.finish();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.f5603 > 0 && this.f5590 != null && this.f5592.size() > 0 && this.f5577 != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f2 = ((float) this.f5603) / ((float) width);
            int i = 0;
            C1430If r9 = this.f5592.get(0);
            float f3 = r9.f5638;
            int size = this.f5592.size();
            int i2 = r9.f5635;
            int i3 = this.f5592.get(size - 1).f5635;
            for (int i4 = i2; i4 < i3; i4++) {
                while (i4 > r9.f5635 && i < size) {
                    i++;
                    r9 = this.f5592.get(i);
                }
                if (i4 == r9.f5635) {
                    f = (r9.f5638 + r9.f5634) * ((float) width);
                    f3 = r9.f5638 + r9.f5634 + f2;
                } else {
                    float pageWidth = this.f5577.getPageWidth(i4);
                    f = (f3 + pageWidth) * ((float) width);
                    f3 += pageWidth + f2;
                }
                if (((float) this.f5603) + f > ((float) scrollX)) {
                    this.f5590.setBounds((int) f, this.f5616, (int) (((float) this.f5603) + f + 0.5f), this.f5612);
                    this.f5590.draw(canvas);
                }
                if (f > ((float) (scrollX + width))) {
                    return;
                }
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m4953() {
        if (this.f5589) {
            return false;
        }
        this.f5608 = true;
        m4929(1);
        this.f5598 = 0.0f;
        this.f5596 = 0.0f;
        if (this.f5600 == null) {
            this.f5600 = VelocityTracker.obtain();
        } else {
            this.f5600.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.f5600.addMovement(obtain);
        obtain.recycle();
        this.f5607 = uptimeMillis;
        return true;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m4963() {
        if (!this.f5608) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        VelocityTracker velocityTracker = this.f5600;
        velocityTracker.computeCurrentVelocity(1000, (float) this.f5601);
        int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.f5597);
        this.f5585 = true;
        int width = getWidth();
        int scrollX = getScrollX();
        C1430If r10 = m4928();
        m4961(m4933(r10.f5635, ((((float) scrollX) / ((float) width)) - r10.f5638) / r10.f5634, xVelocity, (int) (this.f5598 - this.f5596)), true, true, xVelocity, true);
        m4932();
        this.f5608 = false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m4948(float f) {
        if (!this.f5608) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        this.f5598 += f;
        float scrollX = ((float) getScrollX()) - f;
        int width = getWidth();
        float f2 = ((float) width) * this.f5613;
        float f3 = ((float) width) * this.f5620;
        C1430If r13 = this.f5592.get(0);
        C1430If r14 = this.f5592.get(this.f5592.size() - 1);
        if (r13.f5635 != 0) {
            f2 = r13.f5638 * ((float) width);
        }
        if (r14.f5635 != this.f5577.getCount() - 1) {
            f3 = r14.f5638 * ((float) width);
        }
        if (scrollX < f2) {
            scrollX = f2;
        } else if (scrollX > f3) {
            scrollX = f3;
        }
        this.f5598 += scrollX - ((float) ((int) scrollX));
        scrollTo((int) scrollX, getScrollY());
        m4927((int) scrollX);
        MotionEvent obtain = MotionEvent.obtain(this.f5607, SystemClock.uptimeMillis(), 2, this.f5598, 0.0f, 0);
        this.f5600.addMovement(obtain);
        obtain.recycle();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean m4964() {
        return this.f5608;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m4931(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f5597) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f5598 = MotionEventCompat.getX(motionEvent, i);
            this.f5597 = MotionEventCompat.getPointerId(motionEvent, i);
            if (this.f5600 != null) {
                this.f5600.clear();
            }
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m4932() {
        this.f5589 = false;
        this.f5591 = false;
        if (this.f5600 != null) {
            this.f5600.recycle();
            this.f5600 = null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m4926(boolean z) {
        if (this.f5580 != z) {
            this.f5580 = z;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m4945(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && m4945(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ViewCompat.canScrollHorizontally(view, -i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m4951(keyEvent);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m4951(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return m4962(17);
            case 22:
                return m4962(66);
            case 61:
                if (keyEvent.hasNoModifiers()) {
                    return m4962(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return m4962(1);
                }
                return false;
            default:
                return false;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m4962(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        boolean z = false;
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus == null || findNextFocus == findFocus) {
            if (i == 17 || i == 1) {
                z = m4941();
            } else if (i == 66 || i == 2) {
                z = m4940();
            }
        } else if (i == 17) {
            z = (findFocus == null || m4934(this.f5617, findNextFocus).left < m4934(this.f5617, findFocus).left) ? findNextFocus.requestFocus() : m4941();
        } else if (i == 66) {
            z = (findFocus == null || m4934(this.f5617, findNextFocus).left > m4934(this.f5617, findFocus).left) ? findNextFocus.requestFocus() : m4940();
        }
        if (z) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private Rect m4934(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m4941() {
        if (this.f5615 <= 0) {
            return false;
        }
        setCurrentItem(this.f5615 - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m4940() {
        if (this.f5577 == null || this.f5615 >= this.f5577.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.f5615 + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C1430If r6;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (r6 = m4956(childAt)) != null && r6.f5635 == this.f5615) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        C1430If r4;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (r4 = m4956(childAt)) != null && r4.f5635 == this.f5615) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        C1430If r8;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i4 = 0;
            i3 = 1;
            i2 = childCount;
        } else {
            i4 = childCount - 1;
            i3 = -1;
            i2 = -1;
        }
        for (int i5 = i4; i5 != i2; i5 += i3) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (r8 = m4956(childAt)) != null && r8.f5635 == this.f5615 && childAt.requestFocus(i, rect)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C1430If r5;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (r5 = m4956(childAt)) != null && r5.f5635 == this.f5615 && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new Cif();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof Cif) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new Cif(getContext(), attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.Er$iF  reason: case insensitive filesystem */
    public class C1431iF extends AccessibilityDelegateCompat {
        C1431iF() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(C1429Er.class.getName());
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(C1429Er.class.getName());
            accessibilityNodeInfoCompat.setScrollable(C1429Er.this.f5577 != null && C1429Er.this.f5577.getCount() > 1);
            if (C1429Er.this.f5577 != null && C1429Er.this.f5615 >= 0 && C1429Er.this.f5615 < C1429Er.this.f5577.getCount() - 1) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (C1429Er.this.f5577 != null && C1429Er.this.f5615 > 0 && C1429Er.this.f5615 < C1429Er.this.f5577.getCount()) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (C1429Er.this.f5577 == null || C1429Er.this.f5615 < 0 || C1429Er.this.f5615 >= C1429Er.this.f5577.getCount() - 1) {
                        return false;
                    }
                    C1429Er.this.setCurrentItem(C1429Er.this.f5615 + 1);
                    return true;
                case 8192:
                    if (C1429Er.this.f5577 == null || C1429Er.this.f5615 <= 0 || C1429Er.this.f5615 >= C1429Er.this.f5577.getCount()) {
                        return false;
                    }
                    C1429Er.this.setCurrentItem(C1429Er.this.f5615 - 1);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: o.Er$ˎ  reason: contains not printable characters */
    class C0092 extends DataSetObserver {
        private C0092() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            C1429Er.this.m4947();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            C1429Er.this.m4947();
        }
    }

    /* renamed from: o.Er$if  reason: invalid class name */
    public static class Cif extends ViewGroup.LayoutParams {

        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean f5640;

        /* renamed from: ˋ  reason: contains not printable characters */
        int f5641;

        /* renamed from: ˎ  reason: contains not printable characters */
        public int f5642;

        /* renamed from: ˏ  reason: contains not printable characters */
        boolean f5643;

        /* renamed from: ॱ  reason: contains not printable characters */
        float f5644 = 0.0f;

        /* renamed from: ᐝ  reason: contains not printable characters */
        int f5645;

        public Cif() {
            super(-1, -1);
        }

        public Cif(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1429Er.f5574);
            this.f5642 = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.Er$aux */
    public static class aux implements Comparator<View> {
        aux() {
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public int compare(View view, View view2) {
            Cif ifVar = (Cif) view.getLayoutParams();
            Cif ifVar2 = (Cif) view2.getLayoutParams();
            if (ifVar.f5640 != ifVar2.f5640) {
                return ifVar.f5640 ? 1 : -1;
            }
            return ifVar.f5641 - ifVar2.f5641;
        }
    }
}
