package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ReplaySubject<T> extends Subject<T> {
    static final ReplayDisposable[] EMPTY = new ReplayDisposable[0];
    private static final Object[] EMPTY_ARRAY = new Object[0];
    static final ReplayDisposable[] TERMINATED = new ReplayDisposable[0];
    final ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ReplayDisposable<T>[]> observers = new AtomicReference<>(EMPTY);

    /* access modifiers changed from: package-private */
    public interface ReplayBuffer<T> {
        void add(T t);

        void addFinal(Object obj);

        boolean compareAndSet(Object obj, Object obj2);

        void replay(ReplayDisposable<T> replayDisposable);
    }

    public static <T> ReplaySubject<T> create() {
        return new ReplaySubject<>(new UnboundedReplayBuffer(16));
    }

    ReplaySubject(ReplayBuffer<T> replayBuffer) {
        this.buffer = replayBuffer;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(observer, this);
        observer.onSubscribe(replayDisposable);
        if (replayDisposable.cancelled) {
            return;
        }
        if (!add(replayDisposable) || !replayDisposable.cancelled) {
            this.buffer.replay(replayDisposable);
        } else {
            remove(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.done) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else if (!this.done) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.add(t);
            for (ReplayDisposable<T> replayDisposable : this.observers.get()) {
                replayBuffer.replay(replayDisposable);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        Object error = NotificationLite.error(th);
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.addFinal(error);
        for (ReplayDisposable<T> replayDisposable : terminate(error)) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.done) {
            this.done = true;
            Object complete = NotificationLite.complete();
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.addFinal(complete);
            for (ReplayDisposable<T> replayDisposable : terminate(complete)) {
                replayBuffer.replay(replayDisposable);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean add(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable<T>[] replayDisposableArr2;
        do {
            replayDisposableArr = this.observers.get();
            if (replayDisposableArr == TERMINATED) {
                return false;
            }
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[(length + 1)];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void remove(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable<T>[] replayDisposableArr2;
        do {
            replayDisposableArr = this.observers.get();
            if (replayDisposableArr != TERMINATED && replayDisposableArr != EMPTY) {
                int length = replayDisposableArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (replayDisposableArr[i2] == replayDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        replayDisposableArr2 = EMPTY;
                    } else {
                        replayDisposableArr2 = new ReplayDisposable[(length - 1)];
                        System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, i);
                        System.arraycopy(replayDisposableArr, i + 1, replayDisposableArr2, i, (length - i) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    public ReplayDisposable<T>[] terminate(Object obj) {
        if (this.buffer.compareAndSet(null, obj)) {
            return this.observers.getAndSet(TERMINATED);
        }
        return TERMINATED;
    }

    /* access modifiers changed from: package-private */
    public static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 466549804534799122L;
        final Observer<? super T> actual;
        volatile boolean cancelled;
        Object index;
        final ReplaySubject<T> state;

        ReplayDisposable(Observer<? super T> observer, ReplaySubject<T> replaySubject) {
            this.actual = observer;
            this.state = replaySubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        UnboundedReplayBuffer(int i) {
            this.buffer = new ArrayList(ObjectHelper.verifyPositive(i, "capacityHint"));
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t) {
            this.buffer.add(t);
            this.size++;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object obj) {
            this.buffer.add(obj);
            this.size++;
            this.done = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            int i;
            if (replayDisposable.getAndIncrement() == 0) {
                int i2 = 1;
                List<Object> list = this.buffer;
                Observer<? super T> observer = replayDisposable.actual;
                Integer num = (Integer) replayDisposable.index;
                if (num != null) {
                    i = num.intValue();
                } else {
                    i = 0;
                    replayDisposable.index = 0;
                }
                while (!replayDisposable.cancelled) {
                    int i3 = this.size;
                    while (i3 != i) {
                        if (replayDisposable.cancelled) {
                            replayDisposable.index = null;
                            return;
                        }
                        Object obj = list.get(i);
                        if (this.done && i + 1 == i3 && i + 1 == (i3 = this.size)) {
                            if (NotificationLite.isComplete(obj)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError(obj));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        observer.onNext(obj);
                        i++;
                    }
                    if (i == this.size) {
                        replayDisposable.index = Integer.valueOf(i);
                        i2 = replayDisposable.addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
            }
        }
    }
}
