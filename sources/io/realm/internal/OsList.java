package io.realm.internal;

import io.realm.internal.ObservableCollection;
import java.util.Date;
public class OsList implements NativeObject, ObservableCollection {
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final NativeContext context;
    private final long nativePtr;
    private final ObserverPairList<ObservableCollection.CollectionObserverPair> observerPairs = new ObserverPairList<>();
    private final Table targetTable;

    private static native void nativeAddBinary(long j, byte[] bArr);

    private static native void nativeAddBoolean(long j, boolean z);

    private static native void nativeAddDate(long j, long j2);

    private static native void nativeAddDouble(long j, double d);

    private static native void nativeAddFloat(long j, float f);

    private static native void nativeAddLong(long j, long j2);

    private static native void nativeAddNull(long j);

    private static native void nativeAddRow(long j, long j2);

    private static native void nativeAddString(long j, String str);

    private static native long[] nativeCreate(long j, long j2, long j3);

    private static native void nativeDelete(long j, long j2);

    private static native void nativeDeleteAll(long j);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetQuery(long j);

    private static native long nativeGetRow(long j, long j2);

    private static native Object nativeGetValue(long j, long j2);

    private static native void nativeInsertBinary(long j, long j2, byte[] bArr);

    private static native void nativeInsertBoolean(long j, long j2, boolean z);

    private static native void nativeInsertDate(long j, long j2, long j3);

    private static native void nativeInsertDouble(long j, long j2, double d);

    private static native void nativeInsertFloat(long j, long j2, float f);

    private static native void nativeInsertLong(long j, long j2, long j3);

    private static native void nativeInsertNull(long j, long j2);

    private static native void nativeInsertRow(long j, long j2, long j3);

    private static native void nativeInsertString(long j, long j2, String str);

    private static native boolean nativeIsValid(long j);

    private static native void nativeMove(long j, long j2, long j3);

    private static native void nativeRemove(long j, long j2);

    private static native void nativeRemoveAll(long j);

    private static native void nativeSetBinary(long j, long j2, byte[] bArr);

    private static native void nativeSetBoolean(long j, long j2, boolean z);

    private static native void nativeSetDate(long j, long j2, long j3);

    private static native void nativeSetDouble(long j, long j2, double d);

    private static native void nativeSetFloat(long j, long j2, float f);

    private static native void nativeSetLong(long j, long j2, long j3);

    private static native void nativeSetNull(long j, long j2);

    private static native void nativeSetRow(long j, long j2, long j3);

    private static native void nativeSetString(long j, long j2, String str);

    private static native long nativeSize(long j);

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    public OsList(UncheckedRow uncheckedRow, long j) {
        SharedRealm sharedRealm = uncheckedRow.getTable().getSharedRealm();
        long[] nativeCreate = nativeCreate(sharedRealm.getNativePtr(), uncheckedRow.getNativePtr(), j);
        this.nativePtr = nativeCreate[0];
        this.context = sharedRealm.context;
        this.context.addReference(this);
        if (nativeCreate[1] != 0) {
            this.targetTable = new Table(sharedRealm, nativeCreate[1]);
        } else {
            this.targetTable = null;
        }
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public UncheckedRow getUncheckedRow(long j) {
        return this.targetTable.getUncheckedRowByPointer(nativeGetRow(this.nativePtr, j));
    }

    public void addRow(long j) {
        nativeAddRow(this.nativePtr, j);
    }

    public void insertRow(long j, long j2) {
        nativeInsertRow(this.nativePtr, j, j2);
    }

    public void setRow(long j, long j2) {
        nativeSetRow(this.nativePtr, j, j2);
    }

    public void addNull() {
        nativeAddNull(this.nativePtr);
    }

    public void insertNull(long j) {
        nativeInsertNull(this.nativePtr, j);
    }

    public void setNull(long j) {
        nativeSetNull(this.nativePtr, j);
    }

    public void addLong(long j) {
        nativeAddLong(this.nativePtr, j);
    }

    public void insertLong(long j, long j2) {
        nativeInsertLong(this.nativePtr, j, j2);
    }

    public void setLong(long j, long j2) {
        nativeSetLong(this.nativePtr, j, j2);
    }

    public void addDouble(double d) {
        nativeAddDouble(this.nativePtr, d);
    }

    public void insertDouble(long j, double d) {
        nativeInsertDouble(this.nativePtr, j, d);
    }

    public void setDouble(long j, double d) {
        nativeSetDouble(this.nativePtr, j, d);
    }

    public void addFloat(float f) {
        nativeAddFloat(this.nativePtr, f);
    }

    public void insertFloat(long j, float f) {
        nativeInsertFloat(this.nativePtr, j, f);
    }

    public void setFloat(long j, float f) {
        nativeSetFloat(this.nativePtr, j, f);
    }

    public void addBoolean(boolean z) {
        nativeAddBoolean(this.nativePtr, z);
    }

    public void insertBoolean(long j, boolean z) {
        nativeInsertBoolean(this.nativePtr, j, z);
    }

    public void setBoolean(long j, boolean z) {
        nativeSetBoolean(this.nativePtr, j, z);
    }

    public void addBinary(byte[] bArr) {
        nativeAddBinary(this.nativePtr, bArr);
    }

    public void insertBinary(long j, byte[] bArr) {
        nativeInsertBinary(this.nativePtr, j, bArr);
    }

    public void setBinary(long j, byte[] bArr) {
        nativeSetBinary(this.nativePtr, j, bArr);
    }

    public void addString(String str) {
        nativeAddString(this.nativePtr, str);
    }

    public void insertString(long j, String str) {
        nativeInsertString(this.nativePtr, j, str);
    }

    public void setString(long j, String str) {
        nativeSetString(this.nativePtr, j, str);
    }

    public void addDate(Date date) {
        if (date == null) {
            nativeAddNull(this.nativePtr);
        } else {
            nativeAddDate(this.nativePtr, date.getTime());
        }
    }

    public void insertDate(long j, Date date) {
        if (date == null) {
            nativeInsertNull(this.nativePtr, j);
        } else {
            nativeInsertDate(this.nativePtr, j, date.getTime());
        }
    }

    public void setDate(long j, Date date) {
        if (date == null) {
            nativeSetNull(this.nativePtr, j);
        } else {
            nativeSetDate(this.nativePtr, j, date.getTime());
        }
    }

    public Object getValue(long j) {
        return nativeGetValue(this.nativePtr, j);
    }

    public void remove(long j) {
        nativeRemove(this.nativePtr, j);
    }

    public void removeAll() {
        nativeRemoveAll(this.nativePtr);
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }

    public boolean isValid() {
        return nativeIsValid(this.nativePtr);
    }

    @Override // io.realm.internal.ObservableCollection
    public void notifyChangeListeners(long j) {
        if (j != 0) {
            this.observerPairs.foreach(new ObservableCollection.Callback(new OsCollectionChangeSet(j)));
        }
    }
}
