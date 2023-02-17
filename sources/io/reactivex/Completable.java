package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableEmpty;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletablePeek;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
public abstract class Completable implements CompletableSource {
    public abstract void subscribeActual(CompletableObserver completableObserver);

    public static Completable complete() {
        return RxJavaPlugins.onAssembly(CompletableEmpty.INSTANCE);
    }

    public static Completable timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableTimer(j, timeUnit, scheduler));
    }

    private static NullPointerException toNpe(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public final Completable delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.computation(), false);
    }

    public final Completable delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableDelay(this, j, timeUnit, scheduler, z));
    }

    public final Completable doOnComplete(Action action) {
        return doOnLifecycle(Functions.emptyConsumer(), Functions.emptyConsumer(), action, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    private Completable doOnLifecycle(Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
        ObjectHelper.requireNonNull(consumer2, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        ObjectHelper.requireNonNull(action2, "onTerminate is null");
        ObjectHelper.requireNonNull(action3, "onAfterTerminate is null");
        ObjectHelper.requireNonNull(action4, "onDispose is null");
        return RxJavaPlugins.onAssembly(new CompletablePeek(this, consumer, consumer2, action, action2, action3, action4));
    }

    public final Completable observeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableObserveOn(this, scheduler));
    }

    public final Disposable subscribe() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        subscribe(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    @Override // io.reactivex.CompletableSource
    public final void subscribe(CompletableObserver completableObserver) {
        ObjectHelper.requireNonNull(completableObserver, "s is null");
        try {
            subscribeActual(RxJavaPlugins.onSubscribe(this, completableObserver));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            throw toNpe(th);
        }
    }

    public final Disposable subscribe(Action action, Consumer<? super Throwable> consumer) {
        ObjectHelper.requireNonNull(consumer, "onError is null");
        ObjectHelper.requireNonNull(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(consumer, action);
        subscribe(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public final Disposable subscribe(Action action) {
        ObjectHelper.requireNonNull(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(action);
        subscribe(callbackCompletableObserver);
        return callbackCompletableObserver;
    }
}
