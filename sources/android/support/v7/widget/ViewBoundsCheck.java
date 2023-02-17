package android.support.v7.widget;

import android.view.View;
/* access modifiers changed from: package-private */
public class ViewBoundsCheck {
    BoundFlags mBoundFlags = new BoundFlags();
    final Callback mCallback;

    /* access modifiers changed from: package-private */
    public interface Callback {
        View getChildAt(int i);

        int getChildEnd(View view);

        int getChildStart(View view);

        int getParentEnd();

        int getParentStart();
    }

    ViewBoundsCheck(Callback callback) {
        this.mCallback = callback;
    }

    /* access modifiers changed from: package-private */
    public static class BoundFlags {
        int mBoundFlags = 0;
        int mChildEnd;
        int mChildStart;
        int mRvEnd;
        int mRvStart;

        BoundFlags() {
        }

        /* access modifiers changed from: package-private */
        public void setBounds(int i, int i2, int i3, int i4) {
            this.mRvStart = i;
            this.mRvEnd = i2;
            this.mChildStart = i3;
            this.mChildEnd = i4;
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int i) {
            this.mBoundFlags |= i;
        }

        /* access modifiers changed from: package-private */
        public void resetFlags() {
            this.mBoundFlags = 0;
        }

        /* access modifiers changed from: package-private */
        public int compare(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            if (i == i2) {
                return 2;
            }
            return 4;
        }

        /* access modifiers changed from: package-private */
        public boolean boundsMatch() {
            if ((this.mBoundFlags & 7) != 0 && (this.mBoundFlags & (compare(this.mChildStart, this.mRvStart) << 0)) == 0) {
                return false;
            }
            if ((this.mBoundFlags & 112) != 0 && (this.mBoundFlags & (compare(this.mChildStart, this.mRvEnd) << 4)) == 0) {
                return false;
            }
            if ((this.mBoundFlags & 1792) != 0 && (this.mBoundFlags & (compare(this.mChildEnd, this.mRvStart) << 8)) == 0) {
                return false;
            }
            if ((this.mBoundFlags & 28672) == 0 || (this.mBoundFlags & (compare(this.mChildEnd, this.mRvEnd) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public View findOneViewWithinBoundFlags(int i, int i2, int i3, int i4) {
        int parentStart = this.mCallback.getParentStart();
        int parentEnd = this.mCallback.getParentEnd();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        for (int i6 = i; i6 != i2; i6 += i5) {
            View childAt = this.mCallback.getChildAt(i6);
            this.mBoundFlags.setBounds(parentStart, parentEnd, this.mCallback.getChildStart(childAt), this.mCallback.getChildEnd(childAt));
            if (i3 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i3);
                if (this.mBoundFlags.boundsMatch()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i4);
                if (this.mBoundFlags.boundsMatch()) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public boolean isViewWithinBoundFlags(View view, int i) {
        this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(view), this.mCallback.getChildEnd(view));
        if (i == 0) {
            return false;
        }
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(i);
        return this.mBoundFlags.boundsMatch();
    }
}
