package io.reactivex.android;

import android.os.Looper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
public abstract class MainThreadDisposable implements Disposable {
    private final AtomicBoolean unsubscribed = new AtomicBoolean();

    public abstract void onDispose();

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.unsubscribed.get();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (!this.unsubscribed.compareAndSet(false, true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            onDispose();
        } else {
            AndroidSchedulers.mainThread().scheduleDirect(new Runnable() { // from class: io.reactivex.android.MainThreadDisposable.1
                @Override // java.lang.Runnable
                public void run() {
                    MainThreadDisposable.this.onDispose();
                }
            });
        }
    }
}
