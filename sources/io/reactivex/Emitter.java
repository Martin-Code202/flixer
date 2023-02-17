package io.reactivex;
public interface Emitter<T> {
    void onNext(T t);
}
