package io.realm.internal;

import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmException;
import io.realm.internal.Collection;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.android.AndroidCapabilities;
import io.realm.internal.android.AndroidRealmNotifier;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Keep
public final class SharedRealm implements Closeable, NativeObject {
    public static final byte FILE_EXCEPTION_INCOMPATIBLE_SYNC_FILE = 7;
    public static final byte FILE_EXCEPTION_KIND_ACCESS_ERROR = 0;
    public static final byte FILE_EXCEPTION_KIND_BAD_HISTORY = 1;
    public static final byte FILE_EXCEPTION_KIND_EXISTS = 3;
    public static final byte FILE_EXCEPTION_KIND_FORMAT_UPGRADE_REQUIRED = 6;
    public static final byte FILE_EXCEPTION_KIND_INCOMPATIBLE_LOCK_FILE = 5;
    public static final byte FILE_EXCEPTION_KIND_NOT_FOUND = 4;
    public static final byte FILE_EXCEPTION_KIND_PERMISSION_DENIED = 2;
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private static volatile File temporaryDirectory = null;
    public final Capabilities capabilities;
    public final List<WeakReference<Collection>> collections = new CopyOnWriteArrayList();
    final NativeContext context;
    public final List<WeakReference<Collection.Iterator>> iterators = new ArrayList();
    private final long nativePtr;
    private final OsRealmConfig osRealmConfig;
    private final List<WeakReference<PendingRow>> pendingRows = new CopyOnWriteArrayList();
    public final RealmNotifier realmNotifier;
    private final OsSchemaInfo schemaInfo;

    @Keep
    public interface InitializationCallback {
        void onInit(SharedRealm sharedRealm);
    }

    @Keep
    public interface MigrationCallback {
        void onMigrationNeeded(SharedRealm sharedRealm, long j, long j2);
    }

    @Keep
    public interface SchemaChangedCallback {
        void onSchemaChanged();
    }

    private static native void nativeBeginTransaction(long j);

    private static native void nativeCancelTransaction(long j);

    private static native void nativeCloseSharedRealm(long j);

    private static native void nativeCommitTransaction(long j);

    private static native boolean nativeCompact(long j);

    private static native long nativeCreateTable(long j, String str);

    private static native long nativeCreateTableWithPrimaryKeyField(long j, String str, String str2, boolean z, boolean z2);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetSchemaInfo(long j);

    private static native long nativeGetSharedRealm(long j, RealmNotifier realmNotifier2);

    private static native long nativeGetTable(long j, String str);

    private static native String nativeGetTableName(long j, int i);

    private static native long[] nativeGetVersionID(long j);

    private static native boolean nativeHasTable(long j, String str);

    private static native void nativeInit(String str);

    private static native boolean nativeIsAutoRefresh(long j);

    private static native boolean nativeIsClosed(long j);

    private static native boolean nativeIsEmpty(long j);

    private static native boolean nativeIsInTransaction(long j);

    private static native void nativeRefresh(long j);

    private native void nativeRegisterPartialSyncQuery(long j, String str, String str2, PartialSyncCallback partialSyncCallback);

    private static native void nativeRegisterSchemaChangedCallback(long j, SchemaChangedCallback schemaChangedCallback);

    private static native void nativeRenameTable(long j, String str, String str2);

    private static native void nativeSetAutoRefresh(long j, boolean z);

    private static native long nativeSize(long j);

    private static native void nativeStopWaitForChange(long j);

    private static native boolean nativeWaitForChange(long j);

    private static native void nativeWriteCopy(long j, String str, byte[] bArr);

    public static void initialize(File file) {
        if (temporaryDirectory == null) {
            String absolutePath = file.getAbsolutePath();
            if (file.isDirectory() || file.mkdirs() || file.isDirectory()) {
                if (!absolutePath.endsWith("/")) {
                    absolutePath = absolutePath + "/";
                }
                nativeInit(absolutePath);
                temporaryDirectory = file;
                return;
            }
            throw new IOException("failed to create temporary directory: " + absolutePath);
        }
    }

    public static File getTemporaryDirectory() {
        return temporaryDirectory;
    }

    public static class VersionID implements Comparable<VersionID> {
        public final long index;
        public final long version;

        VersionID(long j, long j2) {
            this.version = j;
            this.index = j2;
        }

        public int compareTo(VersionID versionID) {
            if (versionID == null) {
                throw new IllegalArgumentException("Version cannot be compared to a null value.");
            } else if (this.version > versionID.version) {
                return 1;
            } else {
                if (this.version < versionID.version) {
                    return -1;
                }
                return 0;
            }
        }

        @Override // java.lang.Object
        public String toString() {
            return "VersionID{version=" + this.version + ", index=" + this.index + '}';
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            VersionID versionID = (VersionID) obj;
            return this.version == versionID.version && this.index == versionID.index;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (((super.hashCode() * 31) + ((int) (this.version ^ (this.version >>> 32)))) * 31) + ((int) (this.index ^ (this.index >>> 32)));
        }
    }

    @Keep
    public static abstract class PartialSyncCallback {
        private final String className;

        public abstract void onError(RealmException realmException);

        public abstract void onSuccess(Collection collection);

        protected PartialSyncCallback(String str) {
            this.className = str;
        }
    }

    private SharedRealm(OsRealmConfig osRealmConfig2) {
        AndroidCapabilities androidCapabilities = new AndroidCapabilities();
        AndroidRealmNotifier androidRealmNotifier = new AndroidRealmNotifier(this, androidCapabilities);
        this.nativePtr = nativeGetSharedRealm(osRealmConfig2.getNativePtr(), androidRealmNotifier);
        this.osRealmConfig = osRealmConfig2;
        this.schemaInfo = new OsSchemaInfo(nativeGetSchemaInfo(this.nativePtr), this);
        this.context = osRealmConfig2.getContext();
        this.context.addReference(this);
        this.capabilities = androidCapabilities;
        this.realmNotifier = androidRealmNotifier;
        nativeSetAutoRefresh(this.nativePtr, androidCapabilities.canDeliverNotification());
    }

    private SharedRealm(long j, OsRealmConfig osRealmConfig2) {
        this.nativePtr = j;
        this.osRealmConfig = osRealmConfig2;
        this.schemaInfo = new OsSchemaInfo(nativeGetSchemaInfo(this.nativePtr), this);
        this.context = osRealmConfig2.getContext();
        this.context.addReference(this);
        this.capabilities = new AndroidCapabilities();
        this.realmNotifier = null;
        nativeSetAutoRefresh(this.nativePtr, false);
    }

    public static SharedRealm getInstance(RealmConfiguration realmConfiguration) {
        return getInstance(new OsRealmConfig.Builder(realmConfiguration));
    }

    public static SharedRealm getInstance(OsRealmConfig.Builder builder) {
        OsRealmConfig build = builder.build();
        ObjectServerFacade.getSyncFacadeIfPossible().wrapObjectStoreSessionIfRequired(build);
        return new SharedRealm(build);
    }

    public void beginTransaction() {
        detachIterators();
        executePendingRowQueries();
        nativeBeginTransaction(this.nativePtr);
    }

    public void commitTransaction() {
        nativeCommitTransaction(this.nativePtr);
    }

    public void cancelTransaction() {
        nativeCancelTransaction(this.nativePtr);
    }

    public boolean isInTransaction() {
        return nativeIsInTransaction(this.nativePtr);
    }

    public boolean hasTable(String str) {
        return nativeHasTable(this.nativePtr, str);
    }

    public Table getTable(String str) {
        return new Table(this, nativeGetTable(this.nativePtr, str));
    }

    public Table createTable(String str) {
        return new Table(this, nativeCreateTable(this.nativePtr, str));
    }

    public Table createTableWithPrimaryKey(String str, String str2, boolean z, boolean z2) {
        return new Table(this, nativeCreateTableWithPrimaryKeyField(this.nativePtr, str, str2, z, z2));
    }

    public void renameTable(String str, String str2) {
        nativeRenameTable(this.nativePtr, str, str2);
    }

    public String getTableName(int i) {
        return nativeGetTableName(this.nativePtr, i);
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }

    public String getPath() {
        return this.osRealmConfig.getRealmConfiguration().getPath();
    }

    public boolean isEmpty() {
        return nativeIsEmpty(this.nativePtr);
    }

    public void refresh() {
        nativeRefresh(this.nativePtr);
    }

    public VersionID getVersionID() {
        long[] nativeGetVersionID = nativeGetVersionID(this.nativePtr);
        return new VersionID(nativeGetVersionID[0], nativeGetVersionID[1]);
    }

    public boolean isClosed() {
        return nativeIsClosed(this.nativePtr);
    }

    public void writeCopy(File file, byte[] bArr) {
        if (!file.isFile() || !file.exists()) {
            nativeWriteCopy(this.nativePtr, file.getAbsolutePath(), bArr);
            return;
        }
        throw new IllegalArgumentException("The destination file must not exist");
    }

    public boolean waitForChange() {
        return nativeWaitForChange(this.nativePtr);
    }

    public void stopWaitForChange() {
        nativeStopWaitForChange(this.nativePtr);
    }

    public boolean compact() {
        return nativeCompact(this.nativePtr);
    }

    public void setAutoRefresh(boolean z) {
        this.capabilities.checkCanDeliverNotification(null);
        nativeSetAutoRefresh(this.nativePtr, z);
    }

    public boolean isAutoRefresh() {
        return nativeIsAutoRefresh(this.nativePtr);
    }

    public void registerPartialSyncQuery(String str, PartialSyncCallback partialSyncCallback) {
        nativeRegisterPartialSyncQuery(this.nativePtr, partialSyncCallback.className, str, partialSyncCallback);
    }

    public RealmConfiguration getConfiguration() {
        return this.osRealmConfig.getRealmConfiguration();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.realmNotifier != null) {
            this.realmNotifier.close();
        }
        synchronized (this.context) {
            nativeCloseSharedRealm(this.nativePtr);
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

    public OsSchemaInfo getSchemaInfo() {
        return this.schemaInfo;
    }

    public void registerSchemaChangedCallback(SchemaChangedCallback schemaChangedCallback) {
        nativeRegisterSchemaChangedCallback(this.nativePtr, schemaChangedCallback);
    }

    /* access modifiers changed from: package-private */
    public void addIterator(Collection.Iterator iterator) {
        this.iterators.add(new WeakReference<>(iterator));
    }

    /* access modifiers changed from: package-private */
    public void detachIterators() {
        for (WeakReference<Collection.Iterator> weakReference : this.iterators) {
            Collection.Iterator iterator = weakReference.get();
            if (iterator != null) {
                iterator.detach();
            }
        }
        this.iterators.clear();
    }

    /* access modifiers changed from: package-private */
    public void invalidateIterators() {
        for (WeakReference<Collection.Iterator> weakReference : this.iterators) {
            Collection.Iterator iterator = weakReference.get();
            if (iterator != null) {
                iterator.invalidate();
            }
        }
        this.iterators.clear();
    }

    /* access modifiers changed from: package-private */
    public void addPendingRow(PendingRow pendingRow) {
        this.pendingRows.add(new WeakReference<>(pendingRow));
    }

    /* access modifiers changed from: package-private */
    public void removePendingRow(PendingRow pendingRow) {
        for (WeakReference<PendingRow> weakReference : this.pendingRows) {
            PendingRow pendingRow2 = weakReference.get();
            if (pendingRow2 == null || pendingRow2 == pendingRow) {
                this.pendingRows.remove(weakReference);
            }
        }
    }

    private void executePendingRowQueries() {
        for (WeakReference<PendingRow> weakReference : this.pendingRows) {
            PendingRow pendingRow = weakReference.get();
            if (pendingRow != null) {
                pendingRow.executeQuery();
            }
        }
        this.pendingRows.clear();
    }

    private static void runMigrationCallback(long j, OsRealmConfig osRealmConfig2, MigrationCallback migrationCallback, long j2) {
        migrationCallback.onMigrationNeeded(new SharedRealm(j, osRealmConfig2), j2, osRealmConfig2.getRealmConfiguration().getSchemaVersion());
    }

    private static void runInitializationCallback(long j, OsRealmConfig osRealmConfig2, InitializationCallback initializationCallback) {
        initializationCallback.onInit(new SharedRealm(j, osRealmConfig2));
    }

    private void runPartialSyncRegistrationCallback(String str, long j, PartialSyncCallback partialSyncCallback) {
        if (str != null) {
            partialSyncCallback.onError(new RealmException(str));
        } else {
            partialSyncCallback.onSuccess(new Collection(this, getTable(Table.getTableNameForClass(partialSyncCallback.className)), j, true));
        }
    }
}
