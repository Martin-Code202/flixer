package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.io.Serializable;
public enum NotificationLite {
    COMPLETE;

    /* access modifiers changed from: package-private */
    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable e;

        ErrorNotification(Throwable th) {
            this.e = th;
        }

        @Override // java.lang.Object
        public String toString() {
            return "NotificationLite.Error[" + this.e + "]";
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.e.hashCode();
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return ObjectHelper.equals(this.e, ((ErrorNotification) obj).e);
            }
            return false;
        }
    }

    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final Disposable d;

        @Override // java.lang.Object
        public String toString() {
            return "NotificationLite.Disposable[" + this.d + "]";
        }
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).e;
    }

    public static <T> boolean accept(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).e);
            return true;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).e);
            return true;
        } else if (obj instanceof DisposableNotification) {
            observer.onSubscribe(((DisposableNotification) obj).d);
            return false;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return "NotificationLite.Complete";
    }
}
