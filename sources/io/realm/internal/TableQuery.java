package io.realm.internal;

import io.realm.Case;
import java.util.Date;
public class TableQuery implements NativeObject {
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final NativeContext context;
    private final long nativePtr;
    private boolean queryValidated = true;
    private final Table table;

    private native double nativeAverageDouble(long j, long j2, long j3, long j4, long j5);

    private native double nativeAverageFloat(long j, long j2, long j3, long j4, long j5);

    private native double nativeAverageInt(long j, long j2, long j3, long j4, long j5);

    private native void nativeBeginsWith(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native void nativeBetween(long j, long[] jArr, double d, double d2);

    private native void nativeBetween(long j, long[] jArr, float f, float f2);

    private native void nativeBetween(long j, long[] jArr, long j2, long j3);

    private native void nativeBetweenTimestamp(long j, long[] jArr, long j2, long j3);

    private native void nativeContains(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native long nativeCount(long j, long j2, long j3, long j4);

    private native void nativeEndGroup(long j);

    private native void nativeEndsWith(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, double d);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, float f);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, boolean z);

    private native void nativeEqual(long j, long[] jArr, long[] jArr2, byte[] bArr);

    private native void nativeEqualTimestamp(long j, long[] jArr, long[] jArr2, long j2);

    private native long nativeFind(long j, long j2);

    private native long nativeFindAll(long j, long j2, long j3, long j4);

    private static native long nativeGetFinalizerPtr();

    private native void nativeGreater(long j, long[] jArr, long[] jArr2, double d);

    private native void nativeGreater(long j, long[] jArr, long[] jArr2, float f);

    private native void nativeGreater(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeGreaterEqual(long j, long[] jArr, long[] jArr2, double d);

    private native void nativeGreaterEqual(long j, long[] jArr, long[] jArr2, float f);

    private native void nativeGreaterEqual(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeGreaterEqualTimestamp(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeGreaterTimestamp(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeGroup(long j);

    private native void nativeIsEmpty(long j, long[] jArr, long[] jArr2);

    private native void nativeIsNotEmpty(long j, long[] jArr, long[] jArr2);

    private native void nativeIsNotNull(long j, long[] jArr, long[] jArr2);

    private native void nativeIsNull(long j, long[] jArr, long[] jArr2);

    private native void nativeLess(long j, long[] jArr, long[] jArr2, double d);

    private native void nativeLess(long j, long[] jArr, long[] jArr2, float f);

    private native void nativeLess(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeLessEqual(long j, long[] jArr, long[] jArr2, double d);

    private native void nativeLessEqual(long j, long[] jArr, long[] jArr2, float f);

    private native void nativeLessEqual(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeLessEqualTimestamp(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeLessTimestamp(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeLike(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native Double nativeMaximumDouble(long j, long j2, long j3, long j4, long j5);

    private native Float nativeMaximumFloat(long j, long j2, long j3, long j4, long j5);

    private native Long nativeMaximumInt(long j, long j2, long j3, long j4, long j5);

    private native Long nativeMaximumTimestamp(long j, long j2, long j3, long j4, long j5);

    private native Double nativeMinimumDouble(long j, long j2, long j3, long j4, long j5);

    private native Float nativeMinimumFloat(long j, long j2, long j3, long j4, long j5);

    private native Long nativeMinimumInt(long j, long j2, long j3, long j4, long j5);

    private native Long nativeMinimumTimestamp(long j, long j2, long j3, long j4, long j5);

    private native void nativeNot(long j);

    private native void nativeNotEqual(long j, long[] jArr, long[] jArr2, double d);

    private native void nativeNotEqual(long j, long[] jArr, long[] jArr2, float f);

    private native void nativeNotEqual(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeNotEqual(long j, long[] jArr, long[] jArr2, String str, boolean z);

    private native void nativeNotEqual(long j, long[] jArr, long[] jArr2, byte[] bArr);

    private native void nativeNotEqualTimestamp(long j, long[] jArr, long[] jArr2, long j2);

    private native void nativeOr(long j);

    private native long nativeRemove(long j);

    private native double nativeSumDouble(long j, long j2, long j3, long j4, long j5);

    private native double nativeSumFloat(long j, long j2, long j3, long j4, long j5);

    private native long nativeSumInt(long j, long j2, long j3, long j4, long j5);

    private native String nativeValidateQuery(long j);

    public TableQuery(NativeContext nativeContext, Table table2, long j) {
        this.context = nativeContext;
        this.table = table2;
        this.nativePtr = j;
        nativeContext.addReference(this);
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public Table getTable() {
        return this.table;
    }

    /* access modifiers changed from: package-private */
    public void validateQuery() {
        if (!this.queryValidated) {
            String nativeValidateQuery = nativeValidateQuery(this.nativePtr);
            if (nativeValidateQuery.equals("")) {
                this.queryValidated = true;
                return;
            }
            throw new UnsupportedOperationException(nativeValidateQuery);
        }
    }

    public TableQuery equalTo(long[] jArr, long[] jArr2, long j) {
        nativeEqual(this.nativePtr, jArr, jArr2, j);
        this.queryValidated = false;
        return this;
    }

    public TableQuery notEqualTo(long[] jArr, long[] jArr2, long j) {
        nativeNotEqual(this.nativePtr, jArr, jArr2, j);
        this.queryValidated = false;
        return this;
    }

    public TableQuery greaterThan(long[] jArr, long[] jArr2, Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date value in query criteria must not be null.");
        }
        nativeGreaterTimestamp(this.nativePtr, jArr, jArr2, date.getTime());
        this.queryValidated = false;
        return this;
    }

    public TableQuery lessThan(long[] jArr, long[] jArr2, Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date value in query criteria must not be null.");
        }
        nativeLessTimestamp(this.nativePtr, jArr, jArr2, date.getTime());
        this.queryValidated = false;
        return this;
    }

    public TableQuery equalTo(long[] jArr, long[] jArr2, String str, Case r11) {
        nativeEqual(this.nativePtr, jArr, jArr2, str, r11.getValue());
        this.queryValidated = false;
        return this;
    }

    public TableQuery beginsWith(long[] jArr, long[] jArr2, String str, Case r11) {
        nativeBeginsWith(this.nativePtr, jArr, jArr2, str, r11.getValue());
        this.queryValidated = false;
        return this;
    }

    public long find() {
        validateQuery();
        return nativeFind(this.nativePtr, 0);
    }

    public TableQuery isNull(long[] jArr, long[] jArr2) {
        nativeIsNull(this.nativePtr, jArr, jArr2);
        this.queryValidated = false;
        return this;
    }

    public TableQuery isNotNull(long[] jArr, long[] jArr2) {
        nativeIsNotNull(this.nativePtr, jArr, jArr2);
        this.queryValidated = false;
        return this;
    }

    public long count() {
        validateQuery();
        return nativeCount(this.nativePtr, 0, -1, -1);
    }
}
