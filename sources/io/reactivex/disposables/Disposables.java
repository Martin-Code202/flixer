package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
public final class Disposables {
    public static Disposable fromRunnable(Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static Disposable disposed() {
        return EmptyDisposable.INSTANCE;
    }
}
