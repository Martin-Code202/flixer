package io.reactivex;

import io.reactivex.disposables.Disposable;
public interface ObservableEmitter<T> extends Emitter<T> {
    @Override // io.reactivex.disposables.Disposable
    boolean isDisposed();

    void setDisposable(Disposable disposable);
}
