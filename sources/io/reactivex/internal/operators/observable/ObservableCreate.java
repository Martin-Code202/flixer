package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableCreate<T> extends Observable<T> {
    final ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.source = observableOnSubscribe;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        CreateEmitter createEmitter = new CreateEmitter(observer);
        observer.onSubscribe(createEmitter);
        try {
            this.source.subscribe(createEmitter);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            createEmitter.onError(th);
        }
    }

    static final class CreateEmitter<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {
        private static final long serialVersionUID = -3434801548987643227L;
        final Observer<? super T> observer;

        CreateEmitter(Observer<? super T> observer2) {
            this.observer = observer2;
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (!isDisposed()) {
                this.observer.onNext(t);
            }
        }

        public void onError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (!isDisposed()) {
                try {
                    this.observer.onError(th);
                } finally {
                    dispose();
                }
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.ObservableEmitter
        public void setDisposable(Disposable disposable) {
            DisposableHelper.set(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.ObservableEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }
    }
}
