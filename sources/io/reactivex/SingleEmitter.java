package io.reactivex;
public interface SingleEmitter<T> {
    void onError(Throwable th);

    void onSuccess(T t);
}
