package io.realm.internal;

import io.realm.OrderedCollectionChangeSet;
public class OsCollectionChangeSet implements OrderedCollectionChangeSet, NativeObject {
    private static long finalizerPtr = nativeGetFinalizerPtr();
    private final long nativePtr;

    private static native long nativeGetFinalizerPtr();

    private static native int[] nativeGetIndices(long j, int i);

    private static native int[] nativeGetRanges(long j, int i);

    public OsCollectionChangeSet(long j) {
        this.nativePtr = j;
        NativeContext.dummyContext.addReference(this);
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return finalizerPtr;
    }
}
