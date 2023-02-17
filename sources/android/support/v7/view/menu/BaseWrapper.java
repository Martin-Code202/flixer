package android.support.v7.view.menu;
/* access modifiers changed from: package-private */
public class BaseWrapper<T> {
    final T mWrappedObject;

    BaseWrapper(T t) {
        if (null == t) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.mWrappedObject = t;
    }
}
