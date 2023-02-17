package io.reactivex;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.plugins.RxJavaPlugins;
public abstract class Flowable<T> {
    static final int BUFFER_SIZE = Math.max(16, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int bufferSize() {
        return BUFFER_SIZE;
    }

    public static <T> Flowable<T> create(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        ObjectHelper.requireNonNull(flowableOnSubscribe, "source is null");
        ObjectHelper.requireNonNull(backpressureStrategy, "mode is null");
        return RxJavaPlugins.onAssembly(new FlowableCreate(flowableOnSubscribe, backpressureStrategy));
    }
}
