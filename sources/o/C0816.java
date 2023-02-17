package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.appcompat.R;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import o.C0602;
import o.C0706;
@SuppressLint({"PrivateResource"})
/* renamed from: o.ᓐ  reason: contains not printable characters */
public class C0816 {

    /* renamed from: ˊ  reason: contains not printable characters */
    static final Handler f14576 = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: o.ᓐ.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((C0816) message.obj).m15398(true);
                    return true;
                case 1:
                    ((C0816) message.obj).m15409(message.arg1);
                    return true;
                case 2:
                    ((C0816) message.obj).m15398(false);
                    return true;
                default:
                    return false;
            }
        }
    });

    /* renamed from: ˋ  reason: contains not printable characters */
    static final Interpolator f14577 = new FastOutSlowInInterpolator();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static final int[] f14578 = {R.attr.colorPrimary};

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Context f14579;

    /* renamed from: ʼ  reason: contains not printable characters */
    private iF f14580;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final ViewGroup f14581;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f14582 = true;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private AbstractC0819 f14583;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected int f14584;

    /* renamed from: ˏ  reason: contains not printable characters */
    final C0706.Cif f14585 = new C0706.Cif() { // from class: o.ᓐ.4
        @Override // o.C0706.Cif
        /* renamed from: ˊ */
        public void mo15034(boolean z) {
            C0816.f14576.sendMessage(C0816.f14576.obtainMessage(z ? 0 : 2, C0816.this));
        }

        @Override // o.C0706.Cif
        /* renamed from: ˋ */
        public void mo15035(int i) {
            C0816.f14576.sendMessage(C0816.f14576.obtainMessage(1, i, 0, C0816.this));
        }
    };

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final AccessibilityManager f14586;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f14587 = -1;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f14588;

    /* renamed from: o.ᓐ$ˋ  reason: contains not printable characters */
    public static abstract class AbstractC0819 {
        /* renamed from: ˋ */
        public abstract View mo11814();

        /* renamed from: ˏ */
        public abstract boolean mo11816();

        /* renamed from: ॱ */
        public abstract View mo11817();

        /* renamed from: ˋ */
        public void mo11815(C0816 r1, int i) {
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void m15428(C0816 r1) {
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static void m15390(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f14578);
        boolean z = !obtainStyledAttributes.hasValue(0);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public ViewGroup m15411() {
        return this.f14581;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public iF m15407() {
        return this.f14580;
    }

    public C0816(ViewGroup viewGroup) {
        this.f14581 = viewGroup;
        this.f14579 = viewGroup.getContext();
        m15390(this.f14579);
        this.f14580 = (iF) LayoutInflater.from(this.f14579).inflate(C0602.C0606.design_layout_buffet, this.f14581, false);
        this.f14586 = (AccessibilityManager) this.f14579.getSystemService("accessibility");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    protected static ViewGroup m15389(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0816 m15408(int i, View.OnClickListener onClickListener) {
        return m15404(this.f14579.getText(i), onClickListener);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0816 m15404(CharSequence charSequence, final View.OnClickListener onClickListener) {
        C0716 r2 = this.f14580.m15419();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            r2.setVisibility(8);
            r2.setOnClickListener(null);
        } else {
            r2.setVisibility(0);
            r2.setText(charSequence);
            this.f14580.setOnClickListener(new View.OnClickListener() { // from class: o.ᓐ.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    C0816.this.m15406(1);
                }
            });
        }
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0816 m15413(Typeface typeface) {
        this.f14580.m15419().setTypeface(typeface);
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0816 m15397(int i) {
        if (this.f14587 != i) {
            this.f14580.setBackgroundColor(i);
            this.f14587 = i;
        }
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0816 m15412(int i) {
        this.f14584 = i;
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0816 m15403(CharSequence charSequence) {
        this.f14580.m15421().setText(charSequence);
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0816 m15400(int i) {
        this.f14588 = i;
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15410(boolean z) {
        C0706.m15022().m15031(this.f14588, this.f14585, z);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15405() {
        m15406(3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15406(int i) {
        C0706.m15022().m15029(this.f14585, i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0816 m15401(AbstractC0819 r1) {
        this.f14583 = r1;
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m15402() {
        return C0706.m15022().m15030(this.f14585);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m15399() {
        return C0706.m15022().m15025(this.f14585);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m15398(final boolean z) {
        if (this.f14580.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f14580.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                Cif ifVar = new Cif();
                ifVar.setListener(new SwipeDismissBehavior.OnDismissListener() { // from class: o.ᓐ.2
                    @Override // android.support.design.widget.SwipeDismissBehavior.OnDismissListener
                    public void onDismiss(View view) {
                        view.setVisibility(8);
                        C0816.this.m15406(0);
                    }

                    @Override // android.support.design.widget.SwipeDismissBehavior.OnDismissListener
                    public void onDragStateChanged(int i) {
                        switch (i) {
                            case 0:
                                C0706.m15022().m15026(C0816.this.f14585);
                                return;
                            case 1:
                            case 2:
                                C0706.m15022().m15032(C0816.this.f14585);
                                return;
                            default:
                                return;
                        }
                    }
                });
                layoutParams2.setBehavior(ifVar);
                layoutParams2.insetEdge = 80;
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.f14584;
            }
            this.f14581.addView(this.f14580);
        }
        this.f14580.m15423(new iF.AbstractC0818() { // from class: o.ᓐ.5
            @Override // o.C0816.iF.AbstractC0818
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo15417(View view) {
            }

            @Override // o.C0816.iF.AbstractC0818
            /* renamed from: ॱ  reason: contains not printable characters */
            public void mo15418(View view) {
                if (C0816.this.m15399()) {
                    C0816.f14576.post(new Runnable() { // from class: o.ᓐ.5.2
                        @Override // java.lang.Runnable
                        public void run() {
                            C0816.this.m15395(3);
                        }
                    });
                }
            }
        });
        if (!ViewCompat.isLaidOut(this.f14580)) {
            this.f14580.m15425(new iF.AbstractC0817iF() { // from class: o.ᓐ.10
                @Override // o.C0816.iF.AbstractC0817iF
                /* renamed from: ˊ  reason: contains not printable characters */
                public void mo15416(View view, int i, int i2, int i3, int i4) {
                    C0816.this.f14580.m15425(null);
                    if (!z || !C0816.this.m15396()) {
                        C0816.this.f14580.post(new Runnable() { // from class: o.ᓐ.10.5
                            @Override // java.lang.Runnable
                            public void run() {
                                C0816.this.m15415();
                            }
                        });
                    } else {
                        C0816.this.m15414();
                    }
                }
            });
        } else if (!z || !m15396()) {
            m15415();
        } else {
            m15414();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m15414() {
        ViewCompat.setTranslationY(this.f14580, (float) this.f14580.getHeight());
        ViewCompat.animate(this.f14580).translationY(0.0f).setInterpolator(f14577).setDuration(250).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: o.ᓐ.9
            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                C0816.this.f14580.m15420(70, 180);
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                C0816.this.m15415();
            }
        }).start();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m15394(final int i) {
        ViewCompat.animate(this.f14580).translationY((float) this.f14580.getHeight()).setInterpolator(f14577).setDuration(250).setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: o.ᓐ.8
            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                C0816.this.f14580.m15422(0, 180);
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                C0816.this.m15395(i);
            }
        }).start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m15409(int i) {
        if (!m15396() || this.f14580.getVisibility() != 0) {
            m15395(i);
        } else {
            m15394(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m15415() {
        C0706.m15022().m15027(this.f14585);
        if (this.f14583 != null) {
            this.f14583.m15428(this);
        }
        m15393(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʻ  reason: contains not printable characters */
    public void m15395(int i) {
        m15393(false);
        C0706.m15022().m15033(this.f14585);
        if (this.f14583 != null) {
            this.f14583.mo11815(this, i);
        }
        final ViewParent parent = this.f14580.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).postDelayed(new Runnable() { // from class: o.ᓐ.7
                @Override // java.lang.Runnable
                public void run() {
                    ((ViewGroup) parent).removeView(C0816.this.f14580);
                }
            }, 250);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15393(boolean z) {
        if (this.f14583 != null && this.f14583.mo11816()) {
            View r4 = this.f14583.mo11814();
            if (r4 != null) {
                r4.setPadding(0, 0, 0, z ? m15411().getResources().getDimensionPixelOffset(C0602.C0603.buffetbar_height) : 0);
            }
            View r5 = this.f14583.mo11817();
            if (r5 != null) {
                r5.setPadding(0, 0, 0, z ? m15411().getResources().getDimensionPixelOffset(C0602.C0603.buffetbar_height) : 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m15396() {
        return !this.f14586.isEnabled();
    }

    /* renamed from: o.ᓐ$iF */
    public static class iF extends RelativeLayout {

        /* renamed from: ʻ  reason: contains not printable characters */
        private AbstractC0818 f14603;

        /* renamed from: ʼ  reason: contains not printable characters */
        private AbstractC0817iF f14604;

        /* renamed from: ˊ  reason: contains not printable characters */
        private C0716 f14605;

        /* renamed from: ˋ  reason: contains not printable characters */
        private ViewGroup f14606;

        /* renamed from: ˎ  reason: contains not printable characters */
        private int f14607;

        /* renamed from: ˏ  reason: contains not printable characters */
        private C0716 f14608;

        /* renamed from: ॱ  reason: contains not printable characters */
        private int f14609;

        /* access modifiers changed from: package-private */
        /* renamed from: o.ᓐ$iF$iF  reason: collision with other inner class name */
        public interface AbstractC0817iF {
            /* renamed from: ˊ */
            void mo15416(View view, int i, int i2, int i3, int i4);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.ᓐ$iF$ˋ  reason: contains not printable characters */
        public interface AbstractC0818 {
            /* renamed from: ˎ */
            void mo15417(View view);

            /* renamed from: ॱ */
            void mo15418(View view);
        }

        public iF(Context context) {
            this(context, null);
        }

        public iF(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0602.aux.SnackbarLayout);
            this.f14607 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.SnackbarLayout_android_maxWidth, -1);
            this.f14609 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.SnackbarLayout_maxActionInlineWidth, -1);
            if (obtainStyledAttributes.hasValue(C0602.aux.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(C0602.aux.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(C0602.C0606.design_layout_buffet_include, this);
            ViewCompat.setAccessibilityLiveRegion(this, 1);
            ViewCompat.setImportantForAccessibility(this, 1);
            ViewCompat.setFitsSystemWindows(this, true);
            ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: o.ᓐ.iF.4
                @Override // android.support.v4.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                    return windowInsetsCompat;
                }
            });
        }

        /* access modifiers changed from: protected */
        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            this.f14605 = (C0716) findViewById(C0602.IF.snackbar_text);
            this.f14606 = (ViewGroup) findViewById(C0602.IF.snackbar_text_group);
            this.f14608 = (C0716) findViewById(C0602.IF.snackbar_action);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public C0716 m15421() {
            return this.f14605;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public ViewGroup m15424() {
            return this.f14606;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public C0716 m15419() {
            return this.f14608;
        }

        /* access modifiers changed from: protected */
        @Override // android.widget.RelativeLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f14607 > 0 && getMeasuredWidth() > this.f14607) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f14607, 1073741824), i2);
            }
        }

        public void setMaxWidth(int i) {
            if (i < 0) {
                this.f14607 = i;
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public int m15426() {
            return this.f14607;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public void m15420(int i, int i2) {
            ViewCompat.setAlpha(this.f14606, 0.0f);
            ViewCompat.animate(this.f14606).alpha(1.0f).setDuration((long) i2).setStartDelay((long) i).start();
            if (this.f14608.getVisibility() == 0) {
                ViewCompat.setAlpha(this.f14608, 0.0f);
                ViewCompat.animate(this.f14608).alpha(1.0f).setDuration((long) i2).setStartDelay((long) i).start();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public void m15422(int i, int i2) {
            ViewCompat.setAlpha(this.f14606, 1.0f);
            ViewCompat.animate(this.f14606).alpha(0.0f).setDuration((long) i2).setStartDelay((long) i).start();
            if (this.f14608.getVisibility() == 0) {
                ViewCompat.setAlpha(this.f14608, 1.0f);
                ViewCompat.animate(this.f14608).alpha(0.0f).setDuration((long) i2).setStartDelay((long) i).start();
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.widget.RelativeLayout, android.view.View, android.view.ViewGroup
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f14604 != null) {
                this.f14604.mo15416(this, i, i2, i3, i4);
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.view.View, android.view.ViewGroup
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f14603 != null) {
                this.f14603.mo15417(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        /* access modifiers changed from: protected */
        @Override // android.view.View, android.view.ViewGroup
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f14603 != null) {
                this.f14603.mo15418(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public void m15425(AbstractC0817iF iFVar) {
            this.f14604 = iFVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public void m15423(AbstractC0818 r1) {
            this.f14603 = r1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᓐ$if  reason: invalid class name */
    public final class Cif extends SwipeDismissBehavior<iF> {
        public Cif() {
            setDragDismissDistance(0.33f);
            setSensitivity(0.3f);
            setStartAlphaSwipeDistance(0.1f);
            setEndAlphaSwipeDistance(0.6f);
            setSwipeDirection(2);
        }

        @Override // android.support.design.widget.SwipeDismissBehavior
        public boolean canSwipeDismissView(View view) {
            return (view instanceof iF) && C0816.this.f14582;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, iF iFVar, MotionEvent motionEvent) {
            if (coordinatorLayout.isPointInChildBounds(iFVar, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        C0706.m15022().m15032(C0816.this.f14585);
                        break;
                    case 1:
                    case 3:
                        C0706.m15022().m15026(C0816.this.f14585);
                        break;
                }
            }
            return super.onInterceptTouchEvent(coordinatorLayout, iFVar, motionEvent);
        }
    }
}
