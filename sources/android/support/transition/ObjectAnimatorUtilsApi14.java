package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
class ObjectAnimatorUtilsApi14 implements ObjectAnimatorUtilsImpl {
    ObjectAnimatorUtilsApi14() {
    }

    @Override // android.support.transition.ObjectAnimatorUtilsImpl
    public <T> ObjectAnimator ofPointF(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofFloat(t, new PathProperty(property, path), 0.0f, 1.0f);
    }
}
