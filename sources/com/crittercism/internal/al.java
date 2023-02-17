package com.crittercism.internal;

import java.lang.Thread;
public abstract class al implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;

    public abstract void a(Throwable th);

    public al(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            a(th);
            if (this.a != null) {
                this.a.uncaughtException(thread, th);
            }
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable th2) {
            if (this.a != null) {
                this.a.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
