package com.netflix.mediaclient.android.osp;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import o.C1337Bj;
public abstract class AsyncTaskCompat<Params, Progress, Result> {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final Cif f866 = new Cif();

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final ThreadFactory f867 = new ThreadFactory() { // from class: com.netflix.mediaclient.android.osp.AsyncTaskCompat.3

        /* renamed from: ˊ  reason: contains not printable characters */
        private final AtomicInteger f880 = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AsyncTask #" + this.f880.getAndIncrement());
            thread.setPriority(5);
            return thread;
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final int f868 = (C1337Bj.m4029() ? 8 : 16);

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final Executor f869 = Executors.newSingleThreadExecutor();

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Executor f870 = new ThreadPoolExecutor(4, f868, 1, TimeUnit.SECONDS, f871, f867, new ThreadPoolExecutor.DiscardOldestPolicy());

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final BlockingQueue<Runnable> f871 = new LinkedBlockingQueue(64);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static volatile Executor f872 = f869;

    /* renamed from: ʻ  reason: contains not printable characters */
    private final FutureTask<Result> f873 = new FutureTask<Result>(this.f874) { // from class: com.netflix.mediaclient.android.osp.AsyncTaskCompat.5
        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                AsyncTaskCompat.this.m318((AsyncTaskCompat) get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                AsyncTaskCompat.this.m318((AsyncTaskCompat) null);
            }
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    private final AbstractCallableC0008<Params, Result> f874 = new AbstractCallableC0008<Params, Result>() { // from class: com.netflix.mediaclient.android.osp.AsyncTaskCompat.2
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.netflix.mediaclient.android.osp.AsyncTaskCompat */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        public Result call() {
            AsyncTaskCompat.this.f875.set(true);
            Process.setThreadPriority(10);
            return (Result) AsyncTaskCompat.this.m314(AsyncTaskCompat.this.mo286(this.f886));
        }
    };

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final AtomicBoolean f875 = new AtomicBoolean();

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final AtomicBoolean f876 = new AtomicBoolean();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private volatile Status f877 = Status.PENDING;

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public abstract Result mo286(Params... paramsArr);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m318(Result result) {
        if (!this.f875.get()) {
            m314(result);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private Result m314(Result result) {
        f866.obtainMessage(1, new C0009(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m324() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m325(Result result) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m321(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m327(Result result) {
        m323();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m323() {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final boolean m322() {
        return this.f876.get();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final AsyncTaskCompat<Params, Progress, Result> m326(Executor executor, Params... paramsArr) {
        if (this.f877 != Status.PENDING) {
            switch (this.f877) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f877 = Status.RUNNING;
        m324();
        this.f874.f886 = paramsArr;
        executor.execute(this.f873);
        return this;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m316(Result result) {
        if (m322()) {
            m327(result);
        } else {
            m325(result);
        }
        this.f877 = Status.FINISHED;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.android.osp.AsyncTaskCompat$if  reason: invalid class name */
    public static class Cif extends Handler {
        private Cif() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0009 r3 = (C0009) message.obj;
            switch (message.what) {
                case 1:
                    r3.f888.m316(r3.f887[0]);
                    return;
                case 2:
                    r3.f888.m321((Object[]) r3.f887);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.netflix.mediaclient.android.osp.AsyncTaskCompat$ˊ  reason: contains not printable characters */
    static abstract class AbstractCallableC0008<Params, Result> implements Callable<Result> {

        /* renamed from: ˋ  reason: contains not printable characters */
        Params[] f886;

        private AbstractCallableC0008() {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.android.osp.AsyncTaskCompat$ˋ  reason: contains not printable characters */
    public static class C0009<Data> {

        /* renamed from: ˏ  reason: contains not printable characters */
        final Data[] f887;

        /* renamed from: ॱ  reason: contains not printable characters */
        final AsyncTaskCompat f888;

        C0009(AsyncTaskCompat asyncTaskCompat, Data... dataArr) {
            this.f888 = asyncTaskCompat;
            this.f887 = dataArr;
        }
    }
}
