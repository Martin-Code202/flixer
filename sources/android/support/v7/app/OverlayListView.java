package android.support.v7.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
final class OverlayListView extends ListView {
    private final List<OverlayObject> mOverlayObjects = new ArrayList();

    public OverlayListView(Context context) {
        super(context);
    }

    public OverlayListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OverlayListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mOverlayObjects.size() > 0) {
            Iterator<OverlayObject> it = this.mOverlayObjects.iterator();
            while (it.hasNext()) {
                OverlayObject next = it.next();
                BitmapDrawable bitmapDrawable = next.getBitmapDrawable();
                if (bitmapDrawable != null) {
                    bitmapDrawable.draw(canvas);
                }
                if (!next.update(getDrawingTime())) {
                    it.remove();
                }
            }
        }
    }

    public static class OverlayObject {
        private BitmapDrawable mBitmap;
        private float mCurrentAlpha;
        private Rect mCurrentBounds;
        private int mDeltaY;
        private long mDuration;
        private float mEndAlpha;
        private Interpolator mInterpolator;
        private boolean mIsAnimationEnded;
        private boolean mIsAnimationStarted;
        private OnAnimationEndListener mListener;
        private float mStartAlpha;
        private Rect mStartRect;
        private long mStartTime;

        public interface OnAnimationEndListener {
            void onAnimationEnd();
        }

        public BitmapDrawable getBitmapDrawable() {
            return this.mBitmap;
        }

        public boolean update(long j) {
            float f;
            if (this.mIsAnimationEnded) {
                return false;
            }
            float max = Math.max(0.0f, Math.min(1.0f, ((float) (j - this.mStartTime)) / ((float) this.mDuration)));
            if (!this.mIsAnimationStarted) {
                max = 0.0f;
            }
            if (this.mInterpolator == null) {
                f = max;
            } else {
                f = this.mInterpolator.getInterpolation(max);
            }
            int i = (int) (((float) this.mDeltaY) * f);
            this.mCurrentBounds.top = this.mStartRect.top + i;
            this.mCurrentBounds.bottom = this.mStartRect.bottom + i;
            this.mCurrentAlpha = this.mStartAlpha + ((this.mEndAlpha - this.mStartAlpha) * f);
            if (!(this.mBitmap == null || this.mCurrentBounds == null)) {
                this.mBitmap.setAlpha((int) (this.mCurrentAlpha * 255.0f));
                this.mBitmap.setBounds(this.mCurrentBounds);
            }
            if (this.mIsAnimationStarted && max >= 1.0f) {
                this.mIsAnimationEnded = true;
                if (this.mListener != null) {
                    this.mListener.onAnimationEnd();
                }
            }
            return !this.mIsAnimationEnded;
        }
    }
}
