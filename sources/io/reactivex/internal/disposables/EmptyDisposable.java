package io.reactivex.internal.disposables;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.QueueDisposable;
public enum EmptyDisposable implements QueueDisposable<Object> {
    INSTANCE,
    NEVER;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public static void complete(Observer<?> observer) {
        observer.onSubscribe(INSTANCE);
        observer.onComplete();
    }

    public static void error(Throwable th, Observer<?> observer) {
        observer.onSubscribe(INSTANCE);
        observer.onError(th);
    }

    public static void complete(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(INSTANCE);
        completableObserver.onComplete();
    }

    public static void error(Throwable th, CompletableObserver completableObserver) {
        completableObserver.onSubscribe(INSTANCE);
        completableObserver.onError(th);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        return null;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int i) {
        return i & 2;
    }
}
