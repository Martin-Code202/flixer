package io.reactivex.android.plugins;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
public final class RxAndroidPlugins {
    private static volatile Function<Callable<Scheduler>, Scheduler> onInitMainThreadHandler;
    private static volatile Function<Scheduler, Scheduler> onMainThreadHandler;

    public static Scheduler initMainThreadScheduler(Callable<Scheduler> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        Function<Callable<Scheduler>, Scheduler> function = onInitMainThreadHandler;
        if (function == null) {
            return callRequireNonNull(callable);
        }
        return applyRequireNonNull(function, callable);
    }

    public static Scheduler onMainThreadScheduler(Scheduler scheduler) {
        if (scheduler == null) {
            throw new NullPointerException("scheduler == null");
        }
        Function<Scheduler, Scheduler> function = onMainThreadHandler;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) apply(function, scheduler);
    }

    static Scheduler callRequireNonNull(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    static Scheduler applyRequireNonNull(Function<Callable<Scheduler>, Scheduler> function, Callable<Scheduler> callable) {
        Scheduler scheduler = (Scheduler) apply(function, callable);
        if (scheduler != null) {
            return scheduler;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static <T, R> R apply(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }
}
