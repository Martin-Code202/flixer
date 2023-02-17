package io.reactivex.plugins;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
public final class RxJavaPlugins {
    static volatile Consumer<? super Throwable> errorHandler;
    static volatile Function<? super Completable, ? extends Completable> onCompletableAssembly;
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> onCompletableSubscribe;
    static volatile Function<? super Scheduler, ? extends Scheduler> onComputationHandler;
    static volatile Function<? super Flowable, ? extends Flowable> onFlowableAssembly;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitComputationHandler;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitIoHandler;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitNewThreadHandler;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitSingleHandler;
    static volatile Function<? super Scheduler, ? extends Scheduler> onIoHandler;
    static volatile Function<? super Observable, ? extends Observable> onObservableAssembly;
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> onObservableSubscribe;
    static volatile Function<? super Runnable, ? extends Runnable> onScheduleHandler;
    static volatile Function<? super Single, ? extends Single> onSingleAssembly;
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> onSingleSubscribe;

    public static Scheduler initComputationScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitComputationHandler;
        if (function == null) {
            return callRequireNonNull(callable);
        }
        return applyRequireNonNull(function, callable);
    }

    public static Scheduler initIoScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitIoHandler;
        if (function == null) {
            return callRequireNonNull(callable);
        }
        return applyRequireNonNull(function, callable);
    }

    public static Scheduler initNewThreadScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitNewThreadHandler;
        if (function == null) {
            return callRequireNonNull(callable);
        }
        return applyRequireNonNull(function, callable);
    }

    public static Scheduler initSingleScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitSingleHandler;
        if (function == null) {
            return callRequireNonNull(callable);
        }
        return applyRequireNonNull(function, callable);
    }

    public static Scheduler onComputationScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = onComputationHandler;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) apply(function, scheduler);
    }

    public static void onError(Throwable th) {
        Consumer<? super Throwable> consumer = errorHandler;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!isBug(th)) {
            th = new UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                uncaught(th2);
            }
        }
        th.printStackTrace();
        uncaught(th);
    }

    static boolean isBug(Throwable th) {
        if (!(th instanceof OnErrorNotImplementedException) && !(th instanceof MissingBackpressureException) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof CompositeException)) {
            return false;
        }
        return true;
    }

    static void uncaught(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static Scheduler onIoScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = onIoHandler;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) apply(function, scheduler);
    }

    public static Runnable onSchedule(Runnable runnable) {
        Function<? super Runnable, ? extends Runnable> function = onScheduleHandler;
        if (function == null) {
            return runnable;
        }
        return (Runnable) apply(function, runnable);
    }

    public static <T> Observer<? super T> onSubscribe(Observable<T> observable, Observer<? super T> observer) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction = onObservableSubscribe;
        if (biFunction != null) {
            return (Observer) apply(biFunction, observable, observer);
        }
        return observer;
    }

    public static <T> SingleObserver<? super T> onSubscribe(Single<T> single, SingleObserver<? super T> singleObserver) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = onSingleSubscribe;
        if (biFunction != null) {
            return (SingleObserver) apply(biFunction, single, singleObserver);
        }
        return singleObserver;
    }

    public static CompletableObserver onSubscribe(Completable completable, CompletableObserver completableObserver) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = onCompletableSubscribe;
        if (biFunction != null) {
            return (CompletableObserver) apply(biFunction, completable, completableObserver);
        }
        return completableObserver;
    }

    public static <T> Flowable<T> onAssembly(Flowable<T> flowable) {
        Function<? super Flowable, ? extends Flowable> function = onFlowableAssembly;
        if (function != null) {
            return (Flowable) apply(function, flowable);
        }
        return flowable;
    }

    public static <T> Observable<T> onAssembly(Observable<T> observable) {
        Function<? super Observable, ? extends Observable> function = onObservableAssembly;
        if (function != null) {
            return (Observable) apply(function, observable);
        }
        return observable;
    }

    public static <T> Single<T> onAssembly(Single<T> single) {
        Function<? super Single, ? extends Single> function = onSingleAssembly;
        if (function != null) {
            return (Single) apply(function, single);
        }
        return single;
    }

    public static Completable onAssembly(Completable completable) {
        Function<? super Completable, ? extends Completable> function = onCompletableAssembly;
        if (function != null) {
            return (Completable) apply(function, completable);
        }
        return completable;
    }

    static <T, R> R apply(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    static <T, U, R> R apply(BiFunction<T, U, R> biFunction, T t, U u) {
        try {
            return biFunction.apply(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    static Scheduler callRequireNonNull(Callable<Scheduler> callable) {
        try {
            return (Scheduler) ObjectHelper.requireNonNull(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    static Scheduler applyRequireNonNull(Function<? super Callable<Scheduler>, ? extends Scheduler> function, Callable<Scheduler> callable) {
        return (Scheduler) ObjectHelper.requireNonNull(apply(function, callable), "Scheduler Callable result can't be null");
    }
}
