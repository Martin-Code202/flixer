package android.support.v4.view.animation;

import android.view.animation.Interpolator;
/* access modifiers changed from: package-private */
public abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize = (1.0f / ((float) (this.mValues.length - 1)));
    private final float[] mValues;

    protected LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.mValues.length - 1)) * f), this.mValues.length - 2);
        return this.mValues[min] + ((this.mValues[min + 1] - this.mValues[min]) * ((f - (((float) min) * this.mStepSize)) / this.mStepSize));
    }
}
