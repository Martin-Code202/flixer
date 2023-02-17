package io.realm.internal;

import io.realm.ObjectChangeSet;
import io.realm.RealmFieldType;
import io.realm.RealmModel;
import io.realm.RealmObjectChangeListener;
import io.realm.exceptions.RealmException;
import io.realm.internal.ObserverPairList;
@Keep
public class OsObject implements NativeObject {
    private static final String OBJECT_ID_COLUMN_NAME = nativeGetObjectIdColumName();
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final long nativePtr;
    private ObserverPairList<ObjectObserverPair> observerPairs = new ObserverPairList<>();

    private static native long nativeCreate(long j, long j2);

    private static native long nativeCreateNewObject(long j, long j2);

    private static native long nativeCreateNewObjectWithLongPrimaryKey(long j, long j2, long j3, long j4, boolean z);

    private static native long nativeCreateNewObjectWithStringPrimaryKey(long j, long j2, long j3, String str);

    private static native long nativeCreateRow(long j, long j2);

    private static native long nativeCreateRowWithLongPrimaryKey(long j, long j2, long j3, long j4, boolean z);

    private static native long nativeCreateRowWithStringPrimaryKey(long j, long j2, long j3, String str);

    private static native long nativeGetFinalizerPtr();

    private static native String nativeGetObjectIdColumName();

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    /* access modifiers changed from: package-private */
    public static class OsObjectChangeSet implements ObjectChangeSet {
        final String[] changedFields;
        final boolean deleted;

        OsObjectChangeSet(String[] strArr, boolean z) {
            this.changedFields = strArr;
            this.deleted = z;
        }
    }

    public static class ObjectObserverPair<T extends RealmModel> extends ObserverPairList.ObserverPair<T, RealmObjectChangeListener<T>> {
        public ObjectObserverPair(T t, RealmObjectChangeListener<T> realmObjectChangeListener) {
            super(t, realmObjectChangeListener);
        }

        public void onChange(T t, ObjectChangeSet objectChangeSet) {
            ((RealmObjectChangeListener) this.listener).onChange(t, objectChangeSet);
        }
    }

    static class Callback implements ObserverPairList.Callback<ObjectObserverPair> {
        private final String[] changedFields;

        Callback(String[] strArr) {
            this.changedFields = strArr;
        }

        private ObjectChangeSet createChangeSet() {
            boolean z = this.changedFields == null;
            return new OsObjectChangeSet(z ? new String[0] : this.changedFields, z);
        }

        public void onCalled(ObjectObserverPair objectObserverPair, Object obj) {
            objectObserverPair.onChange((RealmModel) obj, createChangeSet());
        }
    }

    public OsObject(SharedRealm sharedRealm, UncheckedRow uncheckedRow) {
        this.nativePtr = nativeCreate(sharedRealm.getNativePtr(), uncheckedRow.getNativePtr());
        sharedRealm.context.addReference(this);
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public <T extends RealmModel> void addListener(T t, RealmObjectChangeListener<T> realmObjectChangeListener) {
        if (this.observerPairs.isEmpty()) {
            nativeStartListening(this.nativePtr);
        }
        this.observerPairs.add(new ObjectObserverPair(t, realmObjectChangeListener));
    }

    public <T extends RealmModel> void removeListener(T t) {
        this.observerPairs.removeByObserver(t);
        if (this.observerPairs.isEmpty()) {
            nativeStopListening(this.nativePtr);
        }
    }

    public <T extends RealmModel> void removeListener(T t, RealmObjectChangeListener<T> realmObjectChangeListener) {
        this.observerPairs.remove(t, realmObjectChangeListener);
        if (this.observerPairs.isEmpty()) {
            nativeStopListening(this.nativePtr);
        }
    }

    public void setObserverPairs(ObserverPairList<ObjectObserverPair> observerPairList) {
        if (!this.observerPairs.isEmpty()) {
            throw new IllegalStateException("'observerPairs' is not empty. Listeners have been added before.");
        }
        this.observerPairs = observerPairList;
        if (!observerPairList.isEmpty()) {
            nativeStartListening(this.nativePtr);
        }
    }

    public static UncheckedRow create(Table table) {
        SharedRealm sharedRealm = table.getSharedRealm();
        return new UncheckedRow(sharedRealm.context, table, nativeCreateNewObject(sharedRealm.getNativePtr(), table.getNativePtr()));
    }

    public static long createRow(Table table) {
        return nativeCreateRow(table.getSharedRealm().getNativePtr(), table.getNativePtr());
    }

    private static long getAndVerifyPrimaryKeyColumnIndex(Table table) {
        String primaryKeyForObject = OsObjectStore.getPrimaryKeyForObject(table.getSharedRealm(), table.getClassName());
        if (primaryKeyForObject != null) {
            return table.getColumnIndex(primaryKeyForObject);
        }
        throw new IllegalStateException(table.getName() + " has no primary key defined.");
    }

    public static UncheckedRow createWithPrimaryKey(Table table, Object obj) {
        long andVerifyPrimaryKeyColumnIndex = getAndVerifyPrimaryKeyColumnIndex(table);
        RealmFieldType columnType = table.getColumnType(andVerifyPrimaryKeyColumnIndex);
        SharedRealm sharedRealm = table.getSharedRealm();
        if (columnType == RealmFieldType.STRING) {
            if (obj == null || (obj instanceof String)) {
                return new UncheckedRow(sharedRealm.context, table, nativeCreateNewObjectWithStringPrimaryKey(sharedRealm.getNativePtr(), table.getNativePtr(), andVerifyPrimaryKeyColumnIndex, (String) obj));
            }
            throw new IllegalArgumentException("Primary key value is not a String: " + obj);
        } else if (columnType == RealmFieldType.INTEGER) {
            return new UncheckedRow(sharedRealm.context, table, nativeCreateNewObjectWithLongPrimaryKey(sharedRealm.getNativePtr(), table.getNativePtr(), andVerifyPrimaryKeyColumnIndex, obj == null ? 0 : Long.parseLong(obj.toString()), obj == null));
        } else {
            throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: " + columnType);
        }
    }

    public static long createRowWithPrimaryKey(Table table, long j, Object obj) {
        RealmFieldType columnType = table.getColumnType(j);
        SharedRealm sharedRealm = table.getSharedRealm();
        if (columnType == RealmFieldType.STRING) {
            if (obj == null || (obj instanceof String)) {
                return nativeCreateRowWithStringPrimaryKey(sharedRealm.getNativePtr(), table.getNativePtr(), j, (String) obj);
            }
            throw new IllegalArgumentException("Primary key value is not a String: " + obj);
        } else if (columnType == RealmFieldType.INTEGER) {
            return nativeCreateRowWithLongPrimaryKey(sharedRealm.getNativePtr(), table.getNativePtr(), j, obj == null ? 0 : Long.parseLong(obj.toString()), obj == null);
        } else {
            throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: " + columnType);
        }
    }

    public static boolean isObjectIdColumn(String str) {
        return OBJECT_ID_COLUMN_NAME.equals(str);
    }

    private void notifyChangeListeners(String[] strArr) {
        this.observerPairs.foreach(new Callback(strArr));
    }
}
