package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableCombineLatest<T, R> extends Observable<R> {
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayError;
    final ObservableSource<? extends T>[] sources;
    final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.sources = observableSourceArr;
        this.sourcesIterable = iterable;
        this.combiner = function;
        this.bufferSize = i;
        this.delayError = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        ObservableSource<? extends T>[] observableSourceArr = this.sources;
        int i = 0;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            for (ObservableSource<? extends T> observableSource : this.sourcesIterable) {
                if (i == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i >> 2) + i)];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i);
                    observableSourceArr = observableSourceArr2;
                }
                i++;
                observableSourceArr[i] = observableSource;
            }
        } else {
            i = observableSourceArr.length;
        }
        if (i == 0) {
            EmptyDisposable.complete(observer);
        } else {
            new LatestCoordinator(observer, this.combiner, i, this.bufferSize, this.delayError).subscribe(observableSourceArr);
        }
    }

    static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final Observer<? super R> actual;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final AtomicThrowable errors = new AtomicThrowable();
        final T[] latest;
        final CombinerObserver<T, R>[] observers;
        final SpscLinkedArrayQueue<Object> queue;

        LatestCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.actual = observer;
            this.combiner = function;
            this.delayError = z;
            this.latest = (T[]) new Object[i];
            this.observers = new CombinerObserver[i];
            this.queue = new SpscLinkedArrayQueue<>(i2);
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.observers;
            int length = combinerObserverArr.length;
            for (int i = 0; i < length; i++) {
                combinerObserverArr[i] = new CombinerObserver<>(this, i);
            }
            lazySet(0);
            this.actual.onSubscribe(this);
            for (int i2 = 0; i2 < length && !this.done && !this.cancelled; i2++) {
                observableSourceArr[i2].subscribe(combinerObserverArr[i2]);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelSources();
                if (getAndIncrement() == 0) {
                    clear(this.queue);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void cancel(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            clear(spscLinkedArrayQueue);
            cancelSources();
        }

        /* access modifiers changed from: package-private */
        public void cancelSources() {
            for (CombinerObserver<T, R> combinerObserver : this.observers) {
                combinerObserver.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void clear(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                Arrays.fill(this.latest, (Object) null);
            }
            spscLinkedArrayQueue.clear();
        }

        /* access modifiers changed from: package-private */
        public void combine(T t, int i) {
            boolean z;
            CombinerObserver<T, R> combinerObserver = this.observers[i];
            synchronized (this) {
                if (!this.cancelled) {
                    int length = this.latest.length;
                    T t2 = this.latest[i];
                    int i2 = this.active;
                    if (t2 == null) {
                        i2++;
                        this.active = i2;
                    }
                    int i3 = this.complete;
                    if (t == null) {
                        i3++;
                        this.complete = i3;
                    } else {
                        this.latest[i] = t;
                    }
                    z = i2 == length;
                    if (i3 == length || (t == null && t2 == null)) {
                        this.done = true;
                    } else if (t != null && z) {
                        this.queue.offer(combinerObserver, this.latest.clone());
                    } else if (t == null && this.errors.get() != null) {
                        this.done = true;
                    }
                } else {
                    return;
                }
            }
            if (z || t == null) {
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.queue;
                Observer<? super R> observer = this.actual;
                boolean z = this.delayError;
                int i = 1;
                while (!checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), observer, spscLinkedArrayQueue, z)) {
                    while (true) {
                        boolean z2 = this.done;
                        boolean z3 = ((CombinerObserver) spscLinkedArrayQueue.poll()) == null;
                        if (!checkTerminated(z2, z3, observer, spscLinkedArrayQueue, z)) {
                            if (z3) {
                                i = addAndGet(-i);
                                if (i == 0) {
                                    return;
                                }
                            } else {
                                try {
                                    observer.onNext((Object) ObjectHelper.requireNonNull(this.combiner.apply((Object[]) spscLinkedArrayQueue.poll()), "The combiner returned a null"));
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.cancelled = true;
                                    cancel(spscLinkedArrayQueue);
                                    observer.onError(th);
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean z, boolean z2, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue, boolean z3) {
            if (this.cancelled) {
                cancel(spscLinkedArrayQueue);
                return true;
            } else if (!z) {
                return false;
            } else {
                if (z3) {
                    if (!z2) {
                        return false;
                    }
                    cancel(spscLinkedArrayQueue);
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null) {
                        observer.onError(terminate);
                        return true;
                    }
                    observer.onComplete();
                    return true;
                } else if (((Throwable) this.errors.get()) != null) {
                    cancel(spscLinkedArrayQueue);
                    observer.onError(this.errors.terminate());
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    clear(this.queue);
                    observer.onComplete();
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class CombinerObserver<T, R> implements Observer<T> {
        final int index;
        final LatestCoordinator<T, R> parent;
        final AtomicReference<Disposable> s = new AtomicReference<>();

        CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.parent = latestCoordinator;
            this.index = i;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.s, disposable);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.parent.combine(t, this.index);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.parent.onError(th);
            this.parent.combine(null, this.index);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.combine(null, this.index);
        }

        public void dispose() {
            DisposableHelper.dispose(this.s);
        }
    }
}
