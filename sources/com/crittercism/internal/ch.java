package com.crittercism.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
public final class ch implements ScheduledExecutorService {
    private ScheduledThreadPoolExecutor a;
    private String b;

    private ch(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, String str) {
        this.a = scheduledThreadPoolExecutor;
        this.b = str;
    }

    public static ScheduledExecutorService a(String str) {
        return new ch(new ScheduledThreadPoolExecutor(3, new a(str)), str);
    }

    public static ScheduledExecutorService b(String str) {
        return new ch(new ScheduledThreadPoolExecutor(1, new a(str)), str);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.a.schedule(new c(runnable), j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return this.a.schedule(new b(callable), j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.a.scheduleAtFixedRate(new c(runnable), j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.a.scheduleWithFixedDelay(new c(runnable), j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        cf.a("Shutting down queue. " + toString());
        this.a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.a.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> callable) {
        return this.a.submit(new b(callable));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable runnable, T t) {
        return this.a.submit(new c(runnable), t);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable runnable) {
        return this.a.submit(new c(runnable));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.execute(new c(runnable));
    }

    @Override // java.lang.Object
    public final String toString() {
        BlockingQueue<Runnable> queue = this.a.getQueue();
        Iterator it = queue.iterator();
        String str = "ProtectedExecutorService(" + this.b + ") size = " + queue.size() + "\n";
        while (it.hasNext()) {
            str = str + ((Runnable) it.next()).toString() + "\n";
        }
        return str;
    }

    static class c implements Runnable {
        private Runnable a;
        private String b;

        public c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.a.run();
            } catch (ThreadDeath e) {
                throw e;
            } catch (Throwable th) {
                cf.b(th);
            }
        }

        @Override // java.lang.Object
        public final String toString() {
            if (this.b != null) {
                return this.b;
            }
            return this.a.toString();
        }
    }

    static class b<T> implements Callable<T> {
        private Callable<T> a;

        public b(Callable<T> callable) {
            this.a = callable;
        }

        @Override // java.util.concurrent.Callable
        public final T call() {
            try {
                return this.a.call();
            } catch (ThreadDeath e) {
                throw e;
            } catch (Throwable th) {
                cf.b(th);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements ThreadFactory {
        private String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.a);
        }
    }
}
