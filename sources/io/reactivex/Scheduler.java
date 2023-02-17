package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract Worker createWorker();

    public void start() {
    }

    public Disposable scheduleDirect(Runnable runnable) {
        return scheduleDirect(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        DisposeTask disposeTask = new DisposeTask(RxJavaPlugins.onSchedule(runnable), createWorker);
        createWorker.schedule(disposeTask, j, timeUnit);
        return disposeTask;
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.onSchedule(runnable), createWorker);
        Disposable schedulePeriodically = createWorker.schedulePeriodically(periodicDirectTask, j, j2, timeUnit);
        if (schedulePeriodically == EmptyDisposable.INSTANCE) {
            return schedulePeriodically;
        }
        return periodicDirectTask;
    }

    public static abstract class Worker implements Disposable {
        public abstract Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit);

        public Disposable schedule(Runnable runnable) {
            return schedule(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public Disposable schedulePeriodically(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            long nanos = timeUnit.toNanos(j2);
            long now = now(TimeUnit.NANOSECONDS);
            Disposable schedule = schedule(new PeriodicTask(now + timeUnit.toNanos(j), onSchedule, now, sequentialDisposable2, nanos), j, timeUnit);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable.replace(schedule);
            return sequentialDisposable2;
        }

        public long now(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /* access modifiers changed from: package-private */
        public final class PeriodicTask implements Runnable {
            long count;
            final Runnable decoratedRun;
            long lastNowNanoseconds;
            final long periodInNanoseconds;
            final SequentialDisposable sd;
            long startInNanoseconds;

            PeriodicTask(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.decoratedRun = runnable;
                this.sd = sequentialDisposable;
                this.periodInNanoseconds = j3;
                this.lastNowNanoseconds = j2;
                this.startInNanoseconds = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.decoratedRun.run();
                if (!this.sd.isDisposed()) {
                    long now = Worker.this.now(TimeUnit.NANOSECONDS);
                    if (Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS + now < this.lastNowNanoseconds || now >= this.lastNowNanoseconds + this.periodInNanoseconds + Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS) {
                        j = now + this.periodInNanoseconds;
                        long j2 = this.periodInNanoseconds;
                        long j3 = this.count + 1;
                        this.count = j3;
                        this.startInNanoseconds = j - (j2 * j3);
                    } else {
                        long j4 = this.startInNanoseconds;
                        long j5 = this.count + 1;
                        this.count = j5;
                        j = j4 + (j5 * this.periodInNanoseconds);
                    }
                    this.lastNowNanoseconds = now;
                    this.sd.replace(Worker.this.schedule(this, j - now, TimeUnit.NANOSECONDS));
                }
            }
        }
    }

    static class PeriodicDirectTask implements Runnable, Disposable {
        volatile boolean disposed;
        final Runnable run;
        final Worker worker;

        PeriodicDirectTask(Runnable runnable, Worker worker2) {
            this.run = runnable;
            this.worker = worker2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.disposed) {
                try {
                    this.run.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.worker.dispose();
                    throw ExceptionHelper.wrapOrThrow(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class DisposeTask implements Runnable, Disposable {
        final Runnable decoratedRun;
        Thread runner;
        final Worker w;

        DisposeTask(Runnable runnable, Worker worker) {
            this.decoratedRun = runnable;
            this.w = worker;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.decoratedRun.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.runner != Thread.currentThread() || !(this.w instanceof NewThreadWorker)) {
                this.w.dispose();
            } else {
                ((NewThreadWorker) this.w).shutdown();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }
    }
}
