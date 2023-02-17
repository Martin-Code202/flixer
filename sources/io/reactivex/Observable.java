package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSkip;
import io.reactivex.internal.operators.observable.ObservableSkipWhile;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
public abstract class Observable<T> implements ObservableSource<T> {
    public abstract void subscribeActual(Observer<? super T> observer);

    public static int bufferSize() {
        return Flowable.bufferSize();
    }

    public static <T, R> Observable<R> combineLatest(Function<? super Object[], ? extends R> function, int i, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatest(observableSourceArr, function, i);
    }

    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.requireNonNull(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.requireNonNull(function, "combiner is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableCombineLatest(observableSourceArr, null, function, i << 1, false));
    }

    public static <T1, T2, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return combineLatest(Functions.toFunction(biFunction), bufferSize(), observableSource, observableSource2);
    }

    public static <T1, T2, T3, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        ObjectHelper.requireNonNull(observableSource3, "source3 is null");
        return combineLatest(Functions.toFunction(function3), bufferSize(), observableSource, observableSource2, observableSource3);
    }

    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        ObjectHelper.requireNonNull(observableOnSubscribe, "source is null");
        return RxJavaPlugins.onAssembly(new ObservableCreate(observableOnSubscribe));
    }

    public static <T> Observable<T> empty() {
        return RxJavaPlugins.onAssembly(ObservableEmpty.INSTANCE);
    }

    public static <T> Observable<T> fromArray(T... tArr) {
        ObjectHelper.requireNonNull(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return RxJavaPlugins.onAssembly(new ObservableFromArray(tArr));
    }

    public static <T> Observable<T> fromIterable(Iterable<? extends T> iterable) {
        ObjectHelper.requireNonNull(iterable, "source is null");
        return RxJavaPlugins.onAssembly(new ObservableFromIterable(iterable));
    }

    public static Observable<Long> interval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableInterval(Math.max(0L, j), Math.max(0L, j2), timeUnit, scheduler));
    }

    public static Observable<Long> interval(long j, TimeUnit timeUnit) {
        return interval(j, j, timeUnit, Schedulers.computation());
    }

    public static <T> Observable<T> just(T t) {
        ObjectHelper.requireNonNull(t, "The item is null");
        return RxJavaPlugins.onAssembly(new ObservableJust(t));
    }

    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity());
    }

    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.identity(), false, 2);
    }

    public static <T, R> Observable<R> zip(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.onAssembly(new ObservableZip(null, iterable, function, bufferSize(), false));
    }

    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "source1 is null");
        ObjectHelper.requireNonNull(observableSource2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), false, bufferSize(), observableSource, observableSource2);
    }

    public static <T, R> Observable<R> zipArray(Function<? super Object[], ? extends R> function, boolean z, int i, ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.requireNonNull(function, "zipper is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableZip(observableSourceArr, null, function, i, z));
    }

    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMap(function, 2);
    }

    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(this, function, i, ErrorMode.IMMEDIATE));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.scalarXMap(call, function);
    }

    public final <U> Observable<T> debounce(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.requireNonNull(function, "debounceSelector is null");
        return RxJavaPlugins.onAssembly(new ObservableDebounce(this, function));
    }

    public final Observable<T> debounce(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit, Schedulers.computation());
    }

    public final Observable<T> debounce(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableDebounceTimed(this, j, timeUnit, scheduler));
    }

    public final Observable<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.computation(), false);
    }

    public final Observable<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    public final Observable<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableDelay(this, j, timeUnit, scheduler, z));
    }

    public final Observable<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.identity());
    }

    public final <K> Observable<T> distinctUntilChanged(Function<? super T, K> function) {
        ObjectHelper.requireNonNull(function, "keySelector is null");
        return RxJavaPlugins.onAssembly(new ObservableDistinctUntilChanged(this, function, ObjectHelper.equalsPredicate()));
    }

    private Observable<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(action2, "onAfterTerminate is null");
        return RxJavaPlugins.onAssembly(new ObservableDoOnEach(this, consumer, consumer2, action, action2));
    }

    public final Observable<T> doOnNext(Consumer<? super T> consumer) {
        return doOnEach(consumer, Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    public final Observable<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableFilter(this, predicate));
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return flatMap(function, false);
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return flatMap(function, z, Integer.MAX_VALUE);
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i) {
        return flatMap(function, z, i, bufferSize());
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i, int i2) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        ObjectHelper.verifyPositive(i, "maxConcurrency");
        ObjectHelper.verifyPositive(i2, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.onAssembly(new ObservableFlatMap(this, function, z, i, i2));
        }
        Object call = ((ScalarCallable) this).call();
        if (call == null) {
            return empty();
        }
        return ObservableScalarXMap.scalarXMap(call, function);
    }

    public final <R> Observable<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new ObservableMap(this, function));
    }

    public final Observable<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    public final Observable<T> observeOn(Scheduler scheduler, boolean z, int i) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableObserveOn(this, scheduler, z, i));
    }

    public final Observable<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return RxJavaPlugins.onAssembly(new ObservableOnErrorNext(this, function, false));
    }

    public final Observable<T> onErrorResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "next is null");
        return onErrorResumeNext(Functions.justFunction(observableSource));
    }

    public final Observable<T> skip(long j) {
        if (j <= 0) {
            return RxJavaPlugins.onAssembly(this);
        }
        return RxJavaPlugins.onAssembly(new ObservableSkip(this, j));
    }

    public final Observable<T> skipWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new ObservableSkipWhile(this, predicate));
    }

    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return subscribe(consumer, consumer2, action, Functions.emptyConsumer());
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        ObjectHelper.requireNonNull(consumer, "onNext is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(consumer3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, action, consumer3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    @Override // io.reactivex.ObservableSource
    public final void subscribe(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, "observer is null");
        try {
            Observer<? super T> onSubscribe = RxJavaPlugins.onSubscribe(this, observer);
            ObjectHelper.requireNonNull(onSubscribe, "Plugin returned null Observer");
            subscribeActual(onSubscribe);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final <E extends Observer<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final Observable<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableSubscribeOn(this, scheduler));
    }

    public final Observable<T> take(long j) {
        if (j >= 0) {
            return RxJavaPlugins.onAssembly(new ObservableTake(this, j));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j);
    }

    public final <U> Observable<T> takeUntil(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.onAssembly(new ObservableTakeUntil(this, observableSource));
    }

    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, "other is null");
        return zip(this, observableSource, biFunction);
    }
}
