package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
public class ChangeBounds extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "bottomRight") { // from class: android.support.transition.ChangeBounds.4
        public void set(View view, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }

        public PointF get(View view) {
            return null;
        }
    };
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") { // from class: android.support.transition.ChangeBounds.3
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setBottomRight(pointF);
        }

        public PointF get(ViewBounds viewBounds) {
            return null;
        }
    };
    private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: android.support.transition.ChangeBounds.1
        private Rect mBounds = new Rect();

        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.mBounds);
            this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.mBounds);
        }

        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.mBounds);
            return new PointF((float) this.mBounds.left, (float) this.mBounds.top);
        }
    };
    private static final Property<View, PointF> POSITION_PROPERTY = new Property<View, PointF>(PointF.class, "position") { // from class: android.support.transition.ChangeBounds.6
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ViewUtils.setLeftTopRightBottom(view, round, round2, round + view.getWidth(), round2 + view.getHeight());
        }

        public PointF get(View view) {
            return null;
        }
    };
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "topLeft") { // from class: android.support.transition.ChangeBounds.5
        public void set(View view, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }

        public PointF get(View view) {
            return null;
        }
    };
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "topLeft") { // from class: android.support.transition.ChangeBounds.2
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setTopLeft(pointF);
        }

        public PointF get(ViewBounds viewBounds) {
            return null;
        }
    };
    private static RectEvaluator sRectEvaluator = new RectEvaluator();
    private static final String[] sTransitionProperties = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private boolean mReparent;
    private boolean mResizeClip;
    private int[] mTempLocation;

    public ChangeBounds() {
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }

    @Override // android.support.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean z) {
        this.mResizeClip = z;
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (ViewCompat.isLaidOut(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.values.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.values.put("android:changeBounds:parent", transitionValues.view.getParent());
            if (this.mReparent) {
                transitionValues.view.getLocationInWindow(this.mTempLocation);
                transitionValues.values.put("android:changeBounds:windowX", Integer.valueOf(this.mTempLocation[0]));
                transitionValues.values.put("android:changeBounds:windowY", Integer.valueOf(this.mTempLocation[1]));
            }
            if (this.mResizeClip) {
                transitionValues.values.put("android:changeBounds:clip", ViewCompat.getClipBounds(view));
            }
        }
    }

    @Override // android.support.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.support.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    private boolean parentMatches(View view, View view2) {
        if (!this.mReparent) {
            return true;
        }
        TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
        return matchedTransitionValues == null ? view == view2 : view2 == matchedTransitionValues.view;
    }

    @Override // android.support.transition.Transition
    public Animator createAnimator(final ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Animator animator;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view = transitionValues2.view;
        if (parentMatches(viewGroup2, viewGroup3)) {
            Rect rect = (Rect) transitionValues.values.get("android:changeBounds:bounds");
            Rect rect2 = (Rect) transitionValues2.values.get("android:changeBounds:bounds");
            int i = rect.left;
            final int i2 = rect2.left;
            int i3 = rect.top;
            final int i4 = rect2.top;
            int i5 = rect.right;
            final int i6 = rect2.right;
            int i7 = rect.bottom;
            final int i8 = rect2.bottom;
            int i9 = i5 - i;
            int i10 = i7 - i3;
            int i11 = i6 - i2;
            int i12 = i8 - i4;
            Rect rect3 = (Rect) transitionValues.values.get("android:changeBounds:clip");
            final Rect rect4 = (Rect) transitionValues2.values.get("android:changeBounds:clip");
            int i13 = 0;
            if (!((i9 == 0 || i10 == 0) && (i11 == 0 || i12 == 0))) {
                if (!(i == i2 && i3 == i4)) {
                    i13 = 0 + 1;
                }
                if (!(i5 == i6 && i7 == i8)) {
                    i13++;
                }
            }
            if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                i13++;
            }
            if (i13 <= 0) {
                return null;
            }
            if (!this.mResizeClip) {
                ViewUtils.setLeftTopRightBottom(view, i, i3, i5, i7);
                if (i13 == 2) {
                    if (i9 == i11 && i10 == i12) {
                        animator = ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, getPathMotion().getPath((float) i, (float) i3, (float) i2, (float) i4));
                    } else {
                        final ViewBounds viewBounds = new ViewBounds(view);
                        ObjectAnimator ofPointF = ObjectAnimatorUtils.ofPointF(viewBounds, TOP_LEFT_PROPERTY, getPathMotion().getPath((float) i, (float) i3, (float) i2, (float) i4));
                        ObjectAnimator ofPointF2 = ObjectAnimatorUtils.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath((float) i5, (float) i7, (float) i6, (float) i8));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(ofPointF, ofPointF2);
                        animator = animatorSet;
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeBounds.7
                            private ViewBounds mViewBounds = viewBounds;
                        });
                    }
                } else if (i == i2 && i3 == i4) {
                    animator = ObjectAnimatorUtils.ofPointF(view, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath((float) i5, (float) i7, (float) i6, (float) i8));
                } else {
                    animator = ObjectAnimatorUtils.ofPointF(view, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath((float) i, (float) i3, (float) i2, (float) i4));
                }
            } else {
                ViewUtils.setLeftTopRightBottom(view, i, i3, i + Math.max(i9, i11), i3 + Math.max(i10, i12));
                ObjectAnimator objectAnimator = null;
                if (!(i == i2 && i3 == i4)) {
                    objectAnimator = ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, getPathMotion().getPath((float) i, (float) i3, (float) i2, (float) i4));
                }
                if (rect3 == null) {
                    rect3 = new Rect(0, 0, i9, i10);
                }
                if (rect4 == null) {
                    rect4 = new Rect(0, 0, i11, i12);
                }
                ObjectAnimator objectAnimator2 = null;
                if (!rect3.equals(rect4)) {
                    ViewCompat.setClipBounds(view, rect3);
                    objectAnimator2 = ObjectAnimator.ofObject(view, "clipBounds", sRectEvaluator, rect3, rect4);
                    objectAnimator2.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeBounds.8
                        private boolean mIsCanceled;

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator2) {
                            this.mIsCanceled = true;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator2) {
                            if (!this.mIsCanceled) {
                                ViewCompat.setClipBounds(view, rect4);
                                ViewUtils.setLeftTopRightBottom(view, i2, i4, i6, i8);
                            }
                        }
                    });
                }
                animator = TransitionUtils.mergeAnimators(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                ViewGroupUtils.suppressLayout(viewGroup4, true);
                addListener(new TransitionListenerAdapter() { // from class: android.support.transition.ChangeBounds.9
                    boolean mCanceled = false;

                    @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition) {
                        if (!this.mCanceled) {
                            ViewGroupUtils.suppressLayout(viewGroup4, false);
                        }
                        transition.removeListener(this);
                    }

                    @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
                    public void onTransitionPause(Transition transition) {
                        ViewGroupUtils.suppressLayout(viewGroup4, false);
                    }

                    @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
                    public void onTransitionResume(Transition transition) {
                        ViewGroupUtils.suppressLayout(viewGroup4, true);
                    }
                });
            }
            return animator;
        }
        int intValue = ((Integer) transitionValues.values.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) transitionValues.values.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) transitionValues2.values.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) transitionValues2.values.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.mTempLocation);
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        final float transitionAlpha = ViewUtils.getTransitionAlpha(view);
        ViewUtils.setTransitionAlpha(view, 0.0f);
        ViewUtils.getOverlay(viewGroup).add(bitmapDrawable);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, getPathMotion().getPath((float) (intValue - this.mTempLocation[0]), (float) (intValue2 - this.mTempLocation[1]), (float) (intValue3 - this.mTempLocation[0]), (float) (intValue4 - this.mTempLocation[1]))));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeBounds.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                ViewUtils.getOverlay(viewGroup).remove(bitmapDrawable);
                ViewUtils.setTransitionAlpha(view, transitionAlpha);
            }
        });
        return ofPropertyValuesHolder;
    }

    /* access modifiers changed from: package-private */
    public static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private View mView;

        ViewBounds(View view) {
            this.mView = view;
        }

        /* access modifiers changed from: package-private */
        public void setTopLeft(PointF pointF) {
            this.mLeft = Math.round(pointF.x);
            this.mTop = Math.round(pointF.y);
            this.mTopLeftCalls++;
            if (this.mTopLeftCalls == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }

        /* access modifiers changed from: package-private */
        public void setBottomRight(PointF pointF) {
            this.mRight = Math.round(pointF.x);
            this.mBottom = Math.round(pointF.y);
            this.mBottomRightCalls++;
            if (this.mTopLeftCalls == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }
    }
}
