package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
public final class Schedulers {
    static final Scheduler COMPUTATION = RxJavaPlugins.initComputationScheduler(new ComputationTask());
    static final Scheduler IO = RxJavaPlugins.initIoScheduler(new IOTask());
    static final Scheduler NEW_THREAD = RxJavaPlugins.initNewThreadScheduler(new NewThreadTask());
    static final Scheduler SINGLE = RxJavaPlugins.initSingleScheduler(new SingleTask());
    static final Scheduler TRAMPOLINE = TrampolineScheduler.instance();

    /* access modifiers changed from: package-private */
    public static final class SingleHolder {
        static final Scheduler DEFAULT = new SingleScheduler();

        SingleHolder() {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ComputationHolder {
        static final Scheduler DEFAULT = new ComputationScheduler();

        ComputationHolder() {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class IoHolder {
        static final Scheduler DEFAULT = new IoScheduler();

        IoHolder() {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class NewThreadHolder {
        static final Scheduler DEFAULT = new NewThreadScheduler();

        NewThreadHolder() {
        }
    }

    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(COMPUTATION);
    }

    public static Scheduler io() {
        return RxJavaPlugins.onIoScheduler(IO);
    }

    static final class IOTask implements Callable<Scheduler> {
        IOTask() {
        }

        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return IoHolder.DEFAULT;
        }
    }

    static final class NewThreadTask implements Callable<Scheduler> {
        NewThreadTask() {
        }

        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return NewThreadHolder.DEFAULT;
        }
    }

    static final class SingleTask implements Callable<Scheduler> {
        SingleTask() {
        }

        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return SingleHolder.DEFAULT;
        }
    }

    static final class ComputationTask implements Callable<Scheduler> {
        ComputationTask() {
        }

        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return ComputationHolder.DEFAULT;
        }
    }
}
