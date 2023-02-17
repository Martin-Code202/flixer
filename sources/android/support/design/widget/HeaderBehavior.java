package android.support.design.widget;

import android.content.Context;
import android.support.v4.math.MathUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private int mActivePointerId = -1;
    private Runnable mFlingRunnable;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    OverScroller mScroller;
    private int mTouchSlop = -1;
    private VelocityTracker mVelocityTracker;

    public HeaderBehavior() {
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.mIsBeingDragged) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.mIsBeingDragged = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (canDragView(v) && coordinatorLayout.isPointInChildBounds(v, x, y)) {
                    this.mLastMotionY = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    ensureVelocityTracker();
                    break;
                }
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
            case 2:
                int i = this.mActivePointerId;
                if (!(i == -1 || (findPointerIndex = motionEvent.findPointerIndex(i)) == -1)) {
                    int y2 = (int) motionEvent.getY(findPointerIndex);
                    if (Math.abs(y2 - this.mLastMotionY) > this.mTouchSlop) {
                        this.mIsBeingDragged = true;
                        this.mLastMotionY = y2;
                        break;
                    }
                }
                break;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af  */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.support.design.widget.CoordinatorLayout r10, V r11, android.view.MotionEvent r12) {
        /*
            r9 = this;
            int r0 = r9.mTouchSlop
            if (r0 >= 0) goto L_0x0012
            android.content.Context r0 = r10.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r9.mTouchSlop = r0
        L_0x0012:
            int r0 = r12.getActionMasked()
            switch(r0) {
                case 0: goto L_0x001b;
                case 1: goto L_0x0080;
                case 2: goto L_0x0041;
                case 3: goto L_0x00a5;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x00b7
        L_0x001b:
            float r0 = r12.getX()
            int r6 = (int) r0
            float r0 = r12.getY()
            int r7 = (int) r0
            boolean r0 = r10.isPointInChildBounds(r11, r6, r7)
            if (r0 == 0) goto L_0x003f
            boolean r0 = r9.canDragView(r11)
            if (r0 == 0) goto L_0x003f
            r9.mLastMotionY = r7
            r0 = 0
            int r0 = r12.getPointerId(r0)
            r9.mActivePointerId = r0
            r9.ensureVelocityTracker()
            goto L_0x00b7
        L_0x003f:
            r0 = 0
            return r0
        L_0x0041:
            int r0 = r9.mActivePointerId
            int r6 = r12.findPointerIndex(r0)
            r0 = -1
            if (r6 != r0) goto L_0x004c
            r0 = 0
            return r0
        L_0x004c:
            float r0 = r12.getY(r6)
            int r7 = (int) r0
            int r0 = r9.mLastMotionY
            int r8 = r0 - r7
            boolean r0 = r9.mIsBeingDragged
            if (r0 != 0) goto L_0x006d
            int r0 = java.lang.Math.abs(r8)
            int r1 = r9.mTouchSlop
            if (r0 <= r1) goto L_0x006d
            r0 = 1
            r9.mIsBeingDragged = r0
            if (r8 <= 0) goto L_0x006a
            int r0 = r9.mTouchSlop
            int r8 = r8 - r0
            goto L_0x006d
        L_0x006a:
            int r0 = r9.mTouchSlop
            int r8 = r8 + r0
        L_0x006d:
            boolean r0 = r9.mIsBeingDragged
            if (r0 == 0) goto L_0x00b7
            r9.mLastMotionY = r7
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r8
            int r4 = r9.getMaxDragOffset(r11)
            r5 = 0
            r0.scroll(r1, r2, r3, r4, r5)
            goto L_0x00b7
        L_0x0080:
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            if (r0 == 0) goto L_0x00a5
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            r1 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r1)
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            int r1 = r9.mActivePointerId
            float r6 = r0.getYVelocity(r1)
            r0 = r9
            r1 = r10
            r2 = r11
            int r3 = r9.getScrollRangeForDragFling(r11)
            int r3 = -r3
            r5 = r6
            r4 = 0
            r0.fling(r1, r2, r3, r4, r5)
        L_0x00a5:
            r0 = 0
            r9.mIsBeingDragged = r0
            r0 = -1
            r9.mActivePointerId = r0
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            if (r0 == 0) goto L_0x00b7
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            r0.recycle()
            r0 = 0
            r9.mVelocityTracker = r0
        L_0x00b7:
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            if (r0 == 0) goto L_0x00c0
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            r0.addMovement(r12)
        L_0x00c0:
            r0 = 1
            return r0
            switch-data {0->0x001b, 1->0x0080, 2->0x0041, 3->0x00a5, }
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.HeaderBehavior.onTouchEvent(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int clamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3 || topAndBottomOffset == (clamp = MathUtils.clamp(i, i2, i3))) {
            return 0;
        }
        setTopAndBottomOffset(clamp);
        return topAndBottomOffset - clamp;
    }

    /* access modifiers changed from: package-private */
    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    /* access modifiers changed from: package-private */
    public final int scroll(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final boolean fling(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.mFlingRunnable != null) {
            v.removeCallbacks(this.mFlingRunnable);
            this.mFlingRunnable = null;
        }
        if (this.mScroller == null) {
            this.mScroller = new OverScroller(v.getContext());
        }
        this.mScroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f), 0, 0, i, i2);
        if (this.mScroller.computeScrollOffset()) {
            this.mFlingRunnable = new FlingRunnable(coordinatorLayout, v);
            ViewCompat.postOnAnimation(v, this.mFlingRunnable);
            return true;
        }
        onFlingFinished(coordinatorLayout, v);
        return false;
    }

    /* access modifiers changed from: package-private */
    public void onFlingFinished(CoordinatorLayout coordinatorLayout, V v) {
    }

    /* access modifiers changed from: package-private */
    public boolean canDragView(V v) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getMaxDragOffset(V v) {
        return -v.getHeight();
    }

    /* access modifiers changed from: package-private */
    public int getScrollRangeForDragFling(V v) {
        return v.getHeight();
    }

    private void ensureVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    /* access modifiers changed from: package-private */
    public class FlingRunnable implements Runnable {
        private final V mLayout;
        private final CoordinatorLayout mParent;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.mParent = coordinatorLayout;
            this.mLayout = v;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: android.support.design.widget.HeaderBehavior */
        /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: android.support.design.widget.HeaderBehavior */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (this.mLayout != null && HeaderBehavior.this.mScroller != null) {
                if (HeaderBehavior.this.mScroller.computeScrollOffset()) {
                    HeaderBehavior.this.setHeaderTopBottomOffset(this.mParent, this.mLayout, HeaderBehavior.this.mScroller.getCurrY());
                    ViewCompat.postOnAnimation(this.mLayout, this);
                    return;
                }
                HeaderBehavior.this.onFlingFinished(this.mParent, this.mLayout);
            }
        }
    }
}
