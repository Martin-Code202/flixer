package org.chromium.net.urlconnection;

import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
/* access modifiers changed from: package-private */
public class MessageLoop implements Executor {
    static final /* synthetic */ boolean $assertionsDisabled = (!MessageLoop.class.desiredAssertionStatus());
    private boolean mLoopFailed = false;
    private boolean mLoopRunning = false;
    private final BlockingQueue<Runnable> mQueue = new LinkedBlockingQueue();
    private long mThreadId = -1;

    MessageLoop() {
    }

    private boolean calledOnValidThread() {
        if (this.mThreadId != -1) {
            return this.mThreadId == Thread.currentThread().getId();
        }
        this.mThreadId = Thread.currentThread().getId();
        return true;
    }

    private Runnable take(boolean z, long j) {
        Runnable runnable;
        if (!z) {
            try {
                runnable = this.mQueue.take();
            } catch (InterruptedException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException();
                interruptedIOException.initCause(e);
                throw interruptedIOException;
            }
        } else {
            runnable = this.mQueue.poll(j, TimeUnit.NANOSECONDS);
        }
        if (runnable != null) {
            return runnable;
        }
        throw new SocketTimeoutException();
    }

    public void loop() {
        loop(0);
    }

    public void loop(int i) {
        if ($assertionsDisabled || calledOnValidThread()) {
            long nanoTime = System.nanoTime();
            long convert = TimeUnit.NANOSECONDS.convert((long) i, TimeUnit.MILLISECONDS);
            if (this.mLoopFailed) {
                throw new IllegalStateException("Cannot run loop as an exception has occurred previously.");
            } else if (this.mLoopRunning) {
                throw new IllegalStateException("Cannot run loop when it is already running.");
            } else {
                this.mLoopRunning = true;
                while (this.mLoopRunning) {
                    if (i == 0) {
                        try {
                            take(false, 0).run();
                        } catch (InterruptedIOException | RuntimeException e) {
                            this.mLoopRunning = false;
                            this.mLoopFailed = true;
                            throw e;
                        }
                    } else {
                        take(true, (convert - System.nanoTime()) + nanoTime).run();
                    }
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    public void quit() {
        if ($assertionsDisabled || calledOnValidThread()) {
            this.mLoopRunning = false;
            return;
        }
        throw new AssertionError();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.mQueue.put(runnable);
        } catch (InterruptedException e) {
            throw new RejectedExecutionException(e);
        }
    }
}
