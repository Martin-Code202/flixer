package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
public final class Loader implements LoaderErrorThrower {
    private LoadTask<? extends Loadable> currentTask;
    private final ExecutorService downloadExecutorService;
    private IOException fatalError;

    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T t, long j, long j2, boolean z);

        void onLoadCompleted(T t, long j, long j2);

        int onLoadError(T t, long j, long j2, IOException iOException);
    }

    public interface Loadable {
        void cancelLoad();

        boolean isLoadCanceled();

        void load();
    }

    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public Loader(String str) {
        this.downloadExecutorService = Util.newSingleThreadExecutor(str);
    }

    public <T extends Loadable> long startLoading(T t, Callback<T> callback, int i) {
        Looper myLooper = Looper.myLooper();
        Assertions.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask(myLooper, t, callback, i, elapsedRealtime).start(0);
        return elapsedRealtime;
    }

    public boolean isLoading() {
        return this.currentTask != null;
    }

    public void cancelLoading() {
        this.currentTask.cancel(false);
    }

    public void release() {
        release(null);
    }

    public boolean release(ReleaseCallback releaseCallback) {
        boolean z = false;
        if (this.currentTask != null) {
            this.currentTask.cancel(true);
            if (releaseCallback != null) {
                this.downloadExecutorService.execute(new ReleaseTask(releaseCallback));
            }
        } else if (releaseCallback != null) {
            releaseCallback.onLoaderReleased();
            z = true;
        }
        this.downloadExecutorService.shutdown();
        return z;
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() {
        maybeThrowError(Integer.MIN_VALUE);
    }

    public void maybeThrowError(int i) {
        if (this.fatalError != null) {
            throw this.fatalError;
        } else if (this.currentTask != null) {
            this.currentTask.maybeThrowError(i == Integer.MIN_VALUE ? this.currentTask.defaultMinRetryCount : i);
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"HandlerLeak"})
    public final class LoadTask<T extends Loadable> extends Handler implements Runnable {
        private final Callback<T> callback;
        private IOException currentError;
        public final int defaultMinRetryCount;
        private int errorCount;
        private volatile Thread executorThread;
        private final T loadable;
        private volatile boolean released;
        private final long startTimeMs;

        public LoadTask(Looper looper, T t, Callback<T> callback2, int i, long j) {
            super(looper);
            this.loadable = t;
            this.callback = callback2;
            this.defaultMinRetryCount = i;
            this.startTimeMs = j;
        }

        public void maybeThrowError(int i) {
            if (this.currentError != null && this.errorCount > i) {
                throw this.currentError;
            }
        }

        public void start(long j) {
            Assertions.checkState(Loader.this.currentTask == null);
            Loader.this.currentTask = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                execute();
            }
        }

        public void cancel(boolean z) {
            this.released = z;
            this.currentError = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.loadable.cancelLoad();
                if (this.executorThread != null) {
                    this.executorThread.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.callback.onLoadCanceled(this.loadable, elapsedRealtime, elapsedRealtime - this.startTimeMs, true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.executorThread = Thread.currentThread();
                if (!this.loadable.isLoadCanceled()) {
                    TraceUtil.beginSection("load:" + this.loadable.getClass().getSimpleName());
                    try {
                        this.loadable.load();
                    } finally {
                        TraceUtil.endSection();
                    }
                }
                if (!this.released) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e) {
                if (!this.released) {
                    obtainMessage(3, e).sendToTarget();
                }
            } catch (InterruptedException e2) {
                Assertions.checkState(this.loadable.isLoadCanceled());
                if (!this.released) {
                    sendEmptyMessage(2);
                }
            } catch (Exception e3) {
                Log.e("LoadTask", "Unexpected exception loading stream", e3);
                if (!this.released) {
                    obtainMessage(3, new UnexpectedLoaderException(e3)).sendToTarget();
                }
            } catch (OutOfMemoryError e4) {
                Log.e("LoadTask", "OutOfMemory error loading stream", e4);
                if (!this.released) {
                    obtainMessage(3, new UnexpectedLoaderException(e4)).sendToTarget();
                }
            } catch (Error e5) {
                Log.e("LoadTask", "Unexpected error loading stream", e5);
                if (!this.released) {
                    obtainMessage(4, e5).sendToTarget();
                }
                throw e5;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!this.released) {
                if (message.what == 0) {
                    execute();
                } else if (message.what == 4) {
                    throw ((Error) message.obj);
                } else {
                    finish();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = elapsedRealtime - this.startTimeMs;
                    if (this.loadable.isLoadCanceled()) {
                        this.callback.onLoadCanceled(this.loadable, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.callback.onLoadCanceled(this.loadable, elapsedRealtime, j, false);
                            return;
                        case 2:
                            this.callback.onLoadCompleted(this.loadable, elapsedRealtime, j);
                            return;
                        case 3:
                            this.currentError = (IOException) message.obj;
                            int onLoadError = this.callback.onLoadError(this.loadable, elapsedRealtime, j, this.currentError);
                            if (onLoadError == 3) {
                                Loader.this.fatalError = this.currentError;
                                return;
                            } else if (onLoadError != 2) {
                                this.errorCount = onLoadError == 1 ? 1 : this.errorCount + 1;
                                start(getRetryDelayMillis());
                                return;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        }

        private void execute() {
            this.currentError = null;
            Loader.this.downloadExecutorService.execute(Loader.this.currentTask);
        }

        private void finish() {
            Loader.this.currentTask = null;
        }

        private long getRetryDelayMillis() {
            return (long) Math.min((this.errorCount - 1) * 1000, 5000);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ReleaseTask extends Handler implements Runnable {
        private final ReleaseCallback callback;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.callback = releaseCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                sendEmptyMessage(0);
            } catch (Throwable th) {
                Log.e("LoadTask", "SPY-14559 " + th);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.callback.onLoaderReleased();
        }
    }
}
