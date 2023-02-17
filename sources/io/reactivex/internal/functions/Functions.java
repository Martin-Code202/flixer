package io.reactivex.internal.functions;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Comparator;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;
public final class Functions {
    static final Predicate<Object> ALWAYS_FALSE = new FalsePredicate();
    static final Predicate<Object> ALWAYS_TRUE = new TruePredicate();
    public static final Action EMPTY_ACTION = new EmptyAction();
    static final Consumer<Object> EMPTY_CONSUMER = new EmptyConsumer();
    public static final LongConsumer EMPTY_LONG_CONSUMER = new EmptyLongConsumer();
    public static final Runnable EMPTY_RUNNABLE = new EmptyRunnable();
    public static final Consumer<Throwable> ERROR_CONSUMER = new ErrorConsumer();
    static final Function<Object, Object> IDENTITY = new Identity();
    static final Comparator<Object> NATURAL_COMPARATOR = new NaturalObjectComparator();
    static final Callable<Object> NULL_SUPPLIER = new NullCallable();
    public static final Consumer<Throwable> ON_ERROR_MISSING = new OnErrorMissingConsumer();
    public static final Consumer<Subscription> REQUEST_MAX = new MaxRequestSubscription();

    public static <T1, T2, R> Function<Object[], R> toFunction(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "f is null");
        return new Array2Func(biFunction);
    }

    public static <T1, T2, T3, R> Function<Object[], R> toFunction(Function3<T1, T2, T3, R> function3) {
        ObjectHelper.requireNonNull(function3, "f is null");
        return new Array3Func(function3);
    }

    public static <T> Function<T, T> identity() {
        return (Function<T, T>) IDENTITY;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return (Consumer<T>) EMPTY_CONSUMER;
    }

    /* access modifiers changed from: package-private */
    public static final class JustValue<T, U> implements Callable<U>, Function<T, U> {
        final U value;

        JustValue(U u) {
            this.value = u;
        }

        @Override // java.util.concurrent.Callable
        public U call() {
            return this.value;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T t) {
            return this.value;
        }
    }

    public static <T, U> Function<T, U> justFunction(U u) {
        return new JustValue(u);
    }

    /* access modifiers changed from: package-private */
    public static final class Array2Func<T1, T2, R> implements Function<Object[], R> {
        final BiFunction<? super T1, ? super T2, ? extends R> f;

        Array2Func(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.f = biFunction;
        }

        public R apply(Object[] objArr) {
            if (objArr.length == 2) {
                return (R) this.f.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Array3Func<T1, T2, T3, R> implements Function<Object[], R> {
        final Function3<T1, T2, T3, R> f;

        Array3Func(Function3<T1, T2, T3, R> function3) {
            this.f = function3;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: io.reactivex.functions.Function3<T1, T2, T3, R> */
        /* JADX WARN: Multi-variable type inference failed */
        public R apply(Object[] objArr) {
            if (objArr.length == 3) {
                return (R) this.f.apply(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    static final class Identity implements Function<Object, Object> {
        Identity() {
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class EmptyRunnable implements Runnable {
        EmptyRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        @Override // java.lang.Object
        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class EmptyAction implements Action {
        EmptyAction() {
        }

        @Override // io.reactivex.functions.Action
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class EmptyConsumer implements Consumer<Object> {
        EmptyConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class ErrorConsumer implements Consumer<Throwable> {
        ErrorConsumer() {
        }

        public void accept(Throwable th) {
            RxJavaPlugins.onError(th);
        }
    }

    static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        OnErrorMissingConsumer() {
        }

        public void accept(Throwable th) {
            RxJavaPlugins.onError(new OnErrorNotImplementedException(th));
        }
    }

    static final class EmptyLongConsumer implements LongConsumer {
        EmptyLongConsumer() {
        }
    }

    static final class TruePredicate implements Predicate<Object> {
        TruePredicate() {
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return true;
        }
    }

    static final class FalsePredicate implements Predicate<Object> {
        FalsePredicate() {
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return false;
        }
    }

    static final class NullCallable implements Callable<Object> {
        NullCallable() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    static final class NaturalObjectComparator implements Comparator<Object> {
        NaturalObjectComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class MaxRequestSubscription implements Consumer<Subscription> {
        MaxRequestSubscription() {
        }

        public void accept(Subscription subscription) {
            subscription.request(Long.MAX_VALUE);
        }
    }
}
