package android.support.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
class ObjectAnimatorUtilsApi21 implements ObjectAnimatorUtilsImpl {
    ObjectAnimatorUtilsApi21() {
    }

    @Override // android.support.transition.ObjectAnimatorUtilsImpl
    public <T> ObjectAnimator ofPointF(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
    }
}
