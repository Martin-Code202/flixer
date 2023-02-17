package io.reactivex.internal.fuseable;
public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(T t);

    T poll();
}
