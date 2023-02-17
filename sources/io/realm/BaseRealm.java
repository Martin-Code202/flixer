package io.realm;

import android.content.Context;
import io.realm.Realm;
import io.realm.internal.CheckedRow;
import io.realm.internal.ColumnInfo;
import io.realm.internal.InvalidRow;
import io.realm.internal.OsObjectStore;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.UncheckedRow;
import io.realm.internal.Util;
import io.realm.internal.async.RealmThreadPoolExecutor;
import io.realm.log.RealmLog;
import java.io.Closeable;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* access modifiers changed from: package-private */
public abstract class BaseRealm implements Closeable {
    static volatile Context applicationContext;
    static final RealmThreadPoolExecutor asyncTaskExecutor = RealmThreadPoolExecutor.newDefaultExecutor();
    public static final ThreadLocalRealmObjectContext objectContext = new ThreadLocalRealmObjectContext();
    protected final RealmConfiguration configuration;
    private RealmCache realmCache;
    private SharedRealm.SchemaChangedCallback schemaChangedCallback;
    public SharedRealm sharedRealm;
    private boolean shouldCloseSharedRealm;
    final long threadId;

    public abstract RealmSchema getSchema();

    BaseRealm(RealmCache realmCache2, OsSchemaInfo osSchemaInfo) {
        this(realmCache2.getConfiguration(), osSchemaInfo);
        this.realmCache = realmCache2;
    }

    BaseRealm(RealmConfiguration realmConfiguration, OsSchemaInfo osSchemaInfo) {
        this.schemaChangedCallback = new SharedRealm.SchemaChangedCallback() { // from class: io.realm.BaseRealm.1
            @Override // io.realm.internal.SharedRealm.SchemaChangedCallback
            public void onSchemaChanged() {
                RealmSchema schema = BaseRealm.this.getSchema();
                if (schema != null) {
                    schema.refresh();
                }
            }
        };
        this.threadId = Thread.currentThread().getId();
        this.configuration = realmConfiguration;
        this.realmCache = null;
        SharedRealm.MigrationCallback migrationCallback = null;
        if (!(osSchemaInfo == null || realmConfiguration.getMigration() == null)) {
            migrationCallback = createMigrationCallback(realmConfiguration.getMigration());
        }
        AnonymousClass2 r3 = null;
        final Realm.Transaction initialDataTransaction = realmConfiguration.getInitialDataTransaction();
        this.sharedRealm = SharedRealm.getInstance(new OsRealmConfig.Builder(realmConfiguration).autoUpdateNotification(true).migrationCallback(migrationCallback).schemaInfo(osSchemaInfo).initializationCallback(initialDataTransaction != null ? new SharedRealm.InitializationCallback() { // from class: io.realm.BaseRealm.2
            @Override // io.realm.internal.SharedRealm.InitializationCallback
            public void onInit(SharedRealm sharedRealm2) {
                initialDataTransaction.execute(Realm.createInstance(sharedRealm2));
            }
        } : r3));
        this.shouldCloseSharedRealm = true;
        this.sharedRealm.registerSchemaChangedCallback(this.schemaChangedCallback);
    }

    BaseRealm(SharedRealm sharedRealm2) {
        this.schemaChangedCallback = new SharedRealm.SchemaChangedCallback() { // from class: io.realm.BaseRealm.1
            @Override // io.realm.internal.SharedRealm.SchemaChangedCallback
            public void onSchemaChanged() {
                RealmSchema schema = BaseRealm.this.getSchema();
                if (schema != null) {
                    schema.refresh();
                }
            }
        };
        this.threadId = Thread.currentThread().getId();
        this.configuration = sharedRealm2.getConfiguration();
        this.realmCache = null;
        this.sharedRealm = sharedRealm2;
        this.shouldCloseSharedRealm = false;
    }

    public boolean isInTransaction() {
        checkIfValid();
        return this.sharedRealm.isInTransaction();
    }

    public void beginTransaction() {
        checkIfValid();
        this.sharedRealm.beginTransaction();
    }

    public void commitTransaction() {
        checkIfValid();
        this.sharedRealm.commitTransaction();
    }

    public void cancelTransaction() {
        checkIfValid();
        this.sharedRealm.cancelTransaction();
    }

    /* access modifiers changed from: protected */
    public void checkIfValid() {
        if (this.sharedRealm == null || this.sharedRealm.isClosed()) {
            throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
        } else if (this.threadId != Thread.currentThread().getId()) {
            throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
        }
    }

    /* access modifiers changed from: package-private */
    public void checkNotInSync() {
        if (this.configuration.isSyncConfiguration()) {
            throw new IllegalArgumentException("You cannot perform changes to a schema. Please update app and restart.");
        }
    }

    public String getPath() {
        return this.configuration.getPath();
    }

    public RealmConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.threadId != Thread.currentThread().getId()) {
            throw new IllegalStateException("Realm access from incorrect thread. Realm instance can only be closed on the thread it was created.");
        } else if (this.realmCache != null) {
            this.realmCache.release(this);
        } else {
            doClose();
        }
    }

    /* access modifiers changed from: package-private */
    public void doClose() {
        this.realmCache = null;
        if (this.sharedRealm != null && this.shouldCloseSharedRealm) {
            this.sharedRealm.close();
            this.sharedRealm = null;
        }
    }

    public boolean isClosed() {
        if (this.threadId == Thread.currentThread().getId()) {
            return this.sharedRealm == null || this.sharedRealm.isClosed();
        }
        throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
    }

    public boolean isEmpty() {
        checkIfValid();
        return this.sharedRealm.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E get(Class<E> cls, String str, UncheckedRow uncheckedRow) {
        return str != null ? new DynamicRealmObject(this, CheckedRow.getFromRow(uncheckedRow)) : (E) this.configuration.getSchemaMediator().newInstance(cls, this, uncheckedRow, getSchema().getColumnInfo(cls), false, Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E get(Class<E> cls, long j, boolean z, List<String> list) {
        return (E) this.configuration.getSchemaMediator().newInstance(cls, this, getSchema().getTable(cls).getUncheckedRow(j), getSchema().getColumnInfo(cls), z, list);
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E get(Class<E> cls, String str, long j) {
        boolean z = str != null;
        Table table = z ? getSchema().getTable(str) : getSchema().getTable(cls);
        if (z) {
            return new DynamicRealmObject(this, j != -1 ? table.getCheckedRow(j) : InvalidRow.INSTANCE);
        }
        return (E) this.configuration.getSchemaMediator().newInstance(cls, this, j != -1 ? table.getUncheckedRow(j) : InvalidRow.INSTANCE, getSchema().getColumnInfo(cls), false, Collections.emptyList());
    }

    public void deleteAll() {
        checkIfValid();
        for (RealmObjectSchema realmObjectSchema : getSchema().getAll()) {
            getSchema().getTable(realmObjectSchema.getClassName()).clear();
        }
    }

    static boolean deleteRealm(final RealmConfiguration realmConfiguration) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        if (OsObjectStore.callWithLock(realmConfiguration, new Runnable() { // from class: io.realm.BaseRealm.4
            @Override // java.lang.Runnable
            public void run() {
                atomicBoolean.set(Util.deleteRealm(RealmConfiguration.this.getPath(), RealmConfiguration.this.getRealmDirectory(), RealmConfiguration.this.getRealmFileName()));
            }
        })) {
            return atomicBoolean.get();
        }
        throw new IllegalStateException("It's not allowed to delete the file associated with an open Realm. Remember to close() all the instances of the Realm before deleting its file: " + realmConfiguration.getPath());
    }

    private static SharedRealm.MigrationCallback createMigrationCallback(final RealmMigration realmMigration) {
        return new SharedRealm.MigrationCallback() { // from class: io.realm.BaseRealm.6
            @Override // io.realm.internal.SharedRealm.MigrationCallback
            public void onMigrationNeeded(SharedRealm sharedRealm2, long j, long j2) {
                RealmMigration.this.migrate(DynamicRealm.createInstance(sharedRealm2), j, j2);
            }
        };
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        if (this.shouldCloseSharedRealm && this.sharedRealm != null && !this.sharedRealm.isClosed()) {
            RealmLog.warn("Remember to call close() on all Realm instances. Realm %s is being finalized without being closed, this can lead to running out of native memory.", this.configuration.getPath());
            if (this.realmCache != null) {
                this.realmCache.leak();
            }
        }
        super.finalize();
    }

    /* access modifiers changed from: package-private */
    public SharedRealm getSharedRealm() {
        return this.sharedRealm;
    }

    public static final class RealmObjectContext {
        private boolean acceptDefaultValue;
        private ColumnInfo columnInfo;
        private List<String> excludeFields;
        private BaseRealm realm;
        private Row row;

        public void set(BaseRealm baseRealm, Row row2, ColumnInfo columnInfo2, boolean z, List<String> list) {
            this.realm = baseRealm;
            this.row = row2;
            this.columnInfo = columnInfo2;
            this.acceptDefaultValue = z;
            this.excludeFields = list;
        }

        /* access modifiers changed from: package-private */
        public BaseRealm getRealm() {
            return this.realm;
        }

        public Row getRow() {
            return this.row;
        }

        public ColumnInfo getColumnInfo() {
            return this.columnInfo;
        }

        public boolean getAcceptDefaultValue() {
            return this.acceptDefaultValue;
        }

        public List<String> getExcludeFields() {
            return this.excludeFields;
        }

        public void clear() {
            this.realm = null;
            this.row = null;
            this.columnInfo = null;
            this.acceptDefaultValue = false;
            this.excludeFields = null;
        }
    }

    static final class ThreadLocalRealmObjectContext extends ThreadLocal<RealmObjectContext> {
        ThreadLocalRealmObjectContext() {
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public RealmObjectContext initialValue() {
            return new RealmObjectContext();
        }
    }
}
