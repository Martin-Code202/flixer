package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.R;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SnackbarManager;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import java.util.List;
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    private static final boolean USE_OFFSET_API = (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19);
    static final Handler sHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: android.support.design.widget.BaseTransientBottomBar.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((BaseTransientBottomBar) message.obj).showView();
                    return true;
                case 1:
                    ((BaseTransientBottomBar) message.obj).hideView(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    });
    private final AccessibilityManager mAccessibilityManager;
    private List<BaseCallback<B>> mCallbacks;
    private final ContentViewCallback mContentViewCallback;
    private final Context mContext;
    private int mDuration;
    final SnackbarManager.Callback mManagerCallback = new SnackbarManager.Callback() { // from class: android.support.design.widget.BaseTransientBottomBar.3
        @Override // android.support.design.widget.SnackbarManager.Callback
        public void show() {
            BaseTransientBottomBar.sHandler.sendMessage(BaseTransientBottomBar.sHandler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // android.support.design.widget.SnackbarManager.Callback
        public void dismiss(int i) {
            BaseTransientBottomBar.sHandler.sendMessage(BaseTransientBottomBar.sHandler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }
    };
    private final ViewGroup mTargetParent;
    final SnackbarBaseLayout mView;

    public interface ContentViewCallback {
        void animateContentIn(int i, int i2);

        void animateContentOut(int i, int i2);
    }

    /* access modifiers changed from: package-private */
    public interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* access modifiers changed from: package-private */
    public interface OnLayoutChangeListener {
        void onLayoutChange(View view, int i, int i2, int i3, int i4);
    }

    public static abstract class BaseCallback<B> {
        public void onDismissed(B b, int i) {
        }

        public void onShown(B b) {
        }
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (contentViewCallback == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        } else {
            this.mTargetParent = viewGroup;
            this.mContentViewCallback = contentViewCallback;
            this.mContext = viewGroup.getContext();
            ThemeUtils.checkAppCompatTheme(this.mContext);
            this.mView = (SnackbarBaseLayout) LayoutInflater.from(this.mContext).inflate(R.layout.design_layout_snackbar, this.mTargetParent, false);
            this.mView.addView(view);
            ViewCompat.setAccessibilityLiveRegion(this.mView, 1);
            ViewCompat.setImportantForAccessibility(this.mView, 1);
            ViewCompat.setFitsSystemWindows(this.mView, true);
            ViewCompat.setOnApplyWindowInsetsListener(this.mView, new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.BaseTransientBottomBar.2
                @Override // android.support.v4.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                    view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                    return windowInsetsCompat;
                }
            });
            this.mAccessibilityManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        }
    }

    public B setDuration(int i) {
        this.mDuration = i;
        return this;
    }

    public Context getContext() {
        return this.mContext;
    }

    public View getView() {
        return this.mView;
    }

    public void show() {
        SnackbarManager.getInstance().show(this.mDuration, this.mManagerCallback);
    }

    /* access modifiers changed from: package-private */
    public void dispatchDismiss(int i) {
        SnackbarManager.getInstance().dismiss(this.mManagerCallback, i);
    }

    public boolean isShownOrQueued() {
        return SnackbarManager.getInstance().isCurrentOrNext(this.mManagerCallback);
    }

    /* access modifiers changed from: package-private */
    public final void showView() {
        if (this.mView.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                Behavior behavior = new Behavior();
                behavior.setStartAlphaSwipeDistance(0.1f);
                behavior.setEndAlphaSwipeDistance(0.6f);
                behavior.setSwipeDirection(0);
                behavior.setListener(new SwipeDismissBehavior.OnDismissListener() { // from class: android.support.design.widget.BaseTransientBottomBar.4
                    @Override // android.support.design.widget.SwipeDismissBehavior.OnDismissListener
                    public void onDismiss(View view) {
                        view.setVisibility(8);
                        BaseTransientBottomBar.this.dispatchDismiss(0);
                    }

                    @Override // android.support.design.widget.SwipeDismissBehavior.OnDismissListener
                    public void onDragStateChanged(int i) {
                        switch (i) {
                            case 0:
                                SnackbarManager.getInstance().restoreTimeoutIfPaused(BaseTransientBottomBar.this.mManagerCallback);
                                return;
                            case 1:
                            case 2:
                                SnackbarManager.getInstance().pauseTimeout(BaseTransientBottomBar.this.mManagerCallback);
                                return;
                            default:
                                return;
                        }
                    }
                });
                layoutParams2.setBehavior(behavior);
                layoutParams2.insetEdge = 80;
            }
            this.mTargetParent.addView(this.mView);
        }
        this.mView.setOnAttachStateChangeListener(new OnAttachStateChangeListener() { // from class: android.support.design.widget.BaseTransientBottomBar.5
            @Override // android.support.design.widget.BaseTransientBottomBar.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.support.design.widget.BaseTransientBottomBar.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (BaseTransientBottomBar.this.isShownOrQueued()) {
                    BaseTransientBottomBar.sHandler.post(new Runnable() { // from class: android.support.design.widget.BaseTransientBottomBar.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseTransientBottomBar.this.onViewHidden(3);
                        }
                    });
                }
            }
        });
        if (!ViewCompat.isLaidOut(this.mView)) {
            this.mView.setOnLayoutChangeListener(new OnLayoutChangeListener() { // from class: android.support.design.widget.BaseTransientBottomBar.6
                @Override // android.support.design.widget.BaseTransientBottomBar.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4) {
                    BaseTransientBottomBar.this.mView.setOnLayoutChangeListener(null);
                    if (BaseTransientBottomBar.this.shouldAnimate()) {
                        BaseTransientBottomBar.this.animateViewIn();
                    } else {
                        BaseTransientBottomBar.this.onViewShown();
                    }
                }
            });
        } else if (shouldAnimate()) {
            animateViewIn();
        } else {
            onViewShown();
        }
    }

    /* access modifiers changed from: package-private */
    public void animateViewIn() {
        if (Build.VERSION.SDK_INT >= 12) {
            final int height = this.mView.getHeight();
            if (USE_OFFSET_API) {
                ViewCompat.offsetTopAndBottom(this.mView, height);
            } else {
                this.mView.setTranslationY((float) height);
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(height, 0);
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.BaseTransientBottomBar.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    BaseTransientBottomBar.this.mContentViewCallback.animateContentIn(70, 180);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BaseTransientBottomBar.this.onViewShown();
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.BaseTransientBottomBar.8
                private int mPreviousAnimatedIntValue = height;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                    if (BaseTransientBottomBar.USE_OFFSET_API) {
                        ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.mView, intValue - this.mPreviousAnimatedIntValue);
                    } else {
                        BaseTransientBottomBar.this.mView.setTranslationY((float) intValue);
                    }
                    this.mPreviousAnimatedIntValue = intValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mView.getContext(), R.anim.design_snackbar_in);
        loadAnimation.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.design.widget.BaseTransientBottomBar.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BaseTransientBottomBar.this.onViewShown();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mView.startAnimation(loadAnimation);
    }

    private void animateViewOut(final int i) {
        if (Build.VERSION.SDK_INT >= 12) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(0, this.mView.getHeight());
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.BaseTransientBottomBar.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    BaseTransientBottomBar.this.mContentViewCallback.animateContentOut(0, 180);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BaseTransientBottomBar.this.onViewHidden(i);
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.BaseTransientBottomBar.11
                private int mPreviousAnimatedIntValue = 0;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                    if (BaseTransientBottomBar.USE_OFFSET_API) {
                        ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.mView, intValue - this.mPreviousAnimatedIntValue);
                    } else {
                        BaseTransientBottomBar.this.mView.setTranslationY((float) intValue);
                    }
                    this.mPreviousAnimatedIntValue = intValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mView.getContext(), R.anim.design_snackbar_out);
        loadAnimation.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.design.widget.BaseTransientBottomBar.12
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BaseTransientBottomBar.this.onViewHidden(i);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mView.startAnimation(loadAnimation);
    }

    /* access modifiers changed from: package-private */
    public final void hideView(int i) {
        if (!shouldAnimate() || this.mView.getVisibility() != 0) {
            onViewHidden(i);
        } else {
            animateViewOut(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void onViewShown() {
        SnackbarManager.getInstance().onShown(this.mManagerCallback);
        if (this.mCallbacks != null) {
            for (int size = this.mCallbacks.size() - 1; size >= 0; size--) {
                this.mCallbacks.get(size).onShown(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onViewHidden(int i) {
        SnackbarManager.getInstance().onDismissed(this.mManagerCallback);
        if (this.mCallbacks != null) {
            for (int size = this.mCallbacks.size() - 1; size >= 0; size--) {
                this.mCallbacks.get(size).onDismissed(this, i);
            }
        }
        if (Build.VERSION.SDK_INT < 11) {
            this.mView.setVisibility(8);
        }
        ViewParent parent = this.mView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mView);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldAnimate() {
        return !this.mAccessibilityManager.isEnabled();
    }

    /* access modifiers changed from: package-private */
    public static class SnackbarBaseLayout extends FrameLayout {
        private OnAttachStateChangeListener mOnAttachStateChangeListener;
        private OnLayoutChangeListener mOnLayoutChangeListener;

        SnackbarBaseLayout(Context context) {
            this(context, null);
        }

        SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
        }

        /* access modifiers changed from: protected */
        @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.mOnLayoutChangeListener != null) {
                this.mOnLayoutChangeListener.onLayoutChange(this, i, i2, i3, i4);
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.view.View, android.view.ViewGroup
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.mOnAttachStateChangeListener != null) {
                this.mOnAttachStateChangeListener.onViewAttachedToWindow(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        /* access modifiers changed from: protected */
        @Override // android.view.View, android.view.ViewGroup
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.mOnAttachStateChangeListener != null) {
                this.mOnAttachStateChangeListener.onViewDetachedFromWindow(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.mOnLayoutChangeListener = onLayoutChangeListener;
        }

        /* access modifiers changed from: package-private */
        public void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
            this.mOnAttachStateChangeListener = onAttachStateChangeListener;
        }
    }

    /* access modifiers changed from: package-private */
    public final class Behavior extends SwipeDismissBehavior<SnackbarBaseLayout> {
        Behavior() {
        }

        @Override // android.support.design.widget.SwipeDismissBehavior
        public boolean canSwipeDismissView(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, SnackbarBaseLayout snackbarBaseLayout, MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (coordinatorLayout.isPointInChildBounds(snackbarBaseLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        SnackbarManager.getInstance().pauseTimeout(BaseTransientBottomBar.this.mManagerCallback);
                        break;
                    }
                    break;
                case 1:
                case 3:
                    SnackbarManager.getInstance().restoreTimeoutIfPaused(BaseTransientBottomBar.this.mManagerCallback);
                    break;
            }
            return super.onInterceptTouchEvent(coordinatorLayout, (CoordinatorLayout) snackbarBaseLayout, motionEvent);
        }
    }
}
