package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    private static final Object HAS_NEXT = new Object();
    static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    AtomicReferenceArray<Object> consumerBuffer;
    final AtomicLong consumerIndex = new AtomicLong();
    final int consumerMask;
    AtomicReferenceArray<Object> producerBuffer;
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;
    int producerLookAheadStep;
    final int producerMask;

    public SpscLinkedArrayQueue(int i) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, i));
        int i2 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = i2;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = i2;
        this.producerLookAhead = (long) (i2 - 1);
        soProducerIndex(0);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t) {
        if (null == t) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lpProducerIndex = lpProducerIndex();
        int i = this.producerMask;
        int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i);
        if (lpProducerIndex < this.producerLookAhead) {
            return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
        }
        int i2 = this.producerLookAheadStep;
        if (null == lvElement(atomicReferenceArray, calcWrappedOffset(((long) i2) + lpProducerIndex, i))) {
            this.producerLookAhead = (((long) i2) + lpProducerIndex) - 1;
            return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
        } else if (null == lvElement(atomicReferenceArray, calcWrappedOffset(1 + lpProducerIndex, i))) {
            return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
        } else {
            resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, t, (long) i);
            return true;
        }
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        soElement(atomicReferenceArray, i, t);
        soProducerIndex(1 + j);
        return true;
    }

    private void resize(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soElement(atomicReferenceArray2, i, t);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, i, HAS_NEXT);
        soProducerIndex(1 + j);
    }

    private void soNext(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        soElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> lvNext(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) lvElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1));
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i = this.consumerMask;
        int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i);
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        boolean z = t == HAS_NEXT;
        if (null != t && !z) {
            soElement(atomicReferenceArray, calcWrappedOffset, null);
            soConsumerIndex(1 + lpConsumerIndex);
            return t;
        } else if (z) {
            return newBufferPoll(lvNext(atomicReferenceArray), lpConsumerIndex, i);
        } else {
            return null;
        }
    }

    private T newBufferPoll(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.consumerBuffer = atomicReferenceArray;
        int calcWrappedOffset = calcWrappedOffset(j, i);
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        if (null != t) {
            soElement(atomicReferenceArray, calcWrappedOffset, null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    private void adjustLookAheadStep(int i) {
        this.producerLookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP);
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lpProducerIndex() {
        return this.producerIndex.get();
    }

    private long lpConsumerIndex() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int calcWrappedOffset(long j, int i) {
        return calcDirectOffset(((int) j) & i);
    }

    private static int calcDirectOffset(int i) {
        return i;
    }

    private static void soElement(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object lvElement(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lvProducerIndex = lvProducerIndex();
        int i = this.producerMask;
        if (null == lvElement(atomicReferenceArray, calcWrappedOffset(2 + lvProducerIndex, i))) {
            int calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i);
            soElement(atomicReferenceArray, calcWrappedOffset + 1, t2);
            soElement(atomicReferenceArray, calcWrappedOffset, t);
            soProducerIndex(2 + lvProducerIndex);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        int calcWrappedOffset2 = calcWrappedOffset(lvProducerIndex, i);
        soElement(atomicReferenceArray2, calcWrappedOffset2 + 1, t2);
        soElement(atomicReferenceArray2, calcWrappedOffset2, t);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, calcWrappedOffset2, HAS_NEXT);
        soProducerIndex(2 + lvProducerIndex);
        return true;
    }
}
