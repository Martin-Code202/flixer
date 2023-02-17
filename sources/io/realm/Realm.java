package io.realm;

import android.content.Context;
import android.os.SystemClock;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnIndices;
import io.realm.internal.ObjectServerFacade;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectStore;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmCore;
import io.realm.internal.RealmNotifier;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.async.RealmAsyncTaskImpl;
import io.realm.log.RealmLog;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
public class Realm extends BaseRealm {
    private static RealmConfiguration defaultConfiguration;
    private static final Object defaultConfigurationLock = new Object();
    private final RealmSchema schema;

    public interface Transaction {

        public interface OnError {
            void onError(Throwable th);
        }

        public interface OnSuccess {
            void onSuccess();
        }

        void execute(Realm realm);
    }

    @Override // io.realm.BaseRealm
    public /* bridge */ /* synthetic */ void beginTransaction() {
        super.beginTransaction();
    }

    @Override // io.realm.BaseRealm
    public /* bridge */ /* synthetic */ void cancelTransaction() {
        super.cancelTransaction();
    }

    @Override // io.realm.BaseRealm, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // io.realm.BaseRealm
    public /* bridge */ /* synthetic */ void commitTransaction() {
        super.commitTransaction();
    }

    @Override // io.realm.BaseRealm
    public /* bridge */ /* synthetic */ void deleteAll() {
        super.deleteAll();
    }

    @Override // io.realm.BaseRealm
    public /* bridge */ /* synthetic */ RealmConfiguration getConfiguration() {
        return super.getConfiguration();
    }

    @Override // io.realm.BaseRealm
    public /* bridge */ /* synthetic */ String getPath() {
        return super.getPath();
    }

    @Override // io.realm.BaseRealm
    public /* bridge */ /* synthetic */ boolean isClosed() {
        return super.isClosed();
    }

    @Override // io.realm.BaseRealm
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // io.realm.BaseRealm
    public /* bridge */ /* synthetic */ boolean isInTransaction() {
        return super.isInTransaction();
    }

    private Realm(RealmCache realmCache) {
        super(realmCache, createExpectedSchemaInfo(realmCache.getConfiguration().getSchemaMediator()));
        this.schema = new ImmutableRealmSchema(this, new ColumnIndices(this.configuration.getSchemaMediator(), this.sharedRealm.getSchemaInfo()));
        if (this.configuration.isReadOnly()) {
            RealmProxyMediator schemaMediator = this.configuration.getSchemaMediator();
            for (Class<? extends RealmModel> cls : schemaMediator.getModelClasses()) {
                String tableName = schemaMediator.getTableName(cls);
                if (!this.sharedRealm.hasTable(tableName)) {
                    this.sharedRealm.close();
                    throw new RealmMigrationNeededException(this.configuration.getPath(), String.format(Locale.US, "Cannot open the read only Realm. '%s' is missing.", Table.getClassNameForTable(tableName)));
                }
            }
        }
    }

    private Realm(SharedRealm sharedRealm) {
        super(sharedRealm);
        this.schema = new ImmutableRealmSchema(this, new ColumnIndices(this.configuration.getSchemaMediator(), sharedRealm.getSchemaInfo()));
    }

    private static OsSchemaInfo createExpectedSchemaInfo(RealmProxyMediator realmProxyMediator) {
        return new OsSchemaInfo(realmProxyMediator.getExpectedObjectSchemaInfoMap().values());
    }

    @Override // io.realm.BaseRealm
    public RealmSchema getSchema() {
        return this.schema;
    }

    public static synchronized void init(Context context) {
        synchronized (Realm.class) {
            if (BaseRealm.applicationContext == null) {
                if (context == null) {
                    throw new IllegalArgumentException("Non-null context required.");
                }
                checkFilesDirAvailable(context);
                RealmCore.loadLibrary(context);
                setDefaultConfiguration(new RealmConfiguration.Builder(context).build());
                ObjectServerFacade.getSyncFacadeIfPossible().init(context);
                if (context.getApplicationContext() != null) {
                    BaseRealm.applicationContext = context.getApplicationContext();
                } else {
                    BaseRealm.applicationContext = context;
                }
                SharedRealm.initialize(new File(context.getFilesDir(), ".realm.temp"));
            }
        }
    }

    private static void checkFilesDirAvailable(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            if (!filesDir.exists()) {
                try {
                    filesDir.mkdirs();
                } catch (SecurityException e) {
                }
            } else {
                return;
            }
        }
        if (filesDir == null || !filesDir.exists()) {
            long[] jArr = {1, 2, 5, 10, 16};
            long j = 0;
            int i = -1;
            do {
                if (context.getFilesDir() != null && context.getFilesDir().exists()) {
                    break;
                }
                i++;
                int length = jArr.length;
                long j2 = jArr[Math.min(i, 4)];
                SystemClock.sleep(j2);
                j += j2;
            } while (j <= 200);
        }
        if (context.getFilesDir() == null || !context.getFilesDir().exists()) {
            throw new IllegalStateException("Context.getFilesDir() returns " + context.getFilesDir() + " which is not an existing directory. See https://issuetracker.google.com/issues/36918154");
        }
    }

    public static Realm getInstance(RealmConfiguration realmConfiguration) {
        if (realmConfiguration != null) {
            return (Realm) RealmCache.createRealmOrGetFromCache(realmConfiguration, Realm.class);
        }
        throw new IllegalArgumentException("A non-null RealmConfiguration must be provided");
    }

    public static void setDefaultConfiguration(RealmConfiguration realmConfiguration) {
        if (realmConfiguration == null) {
            throw new IllegalArgumentException("A non-null RealmConfiguration must be provided");
        }
        synchronized (defaultConfigurationLock) {
            defaultConfiguration = realmConfiguration;
        }
    }

    static Realm createInstance(RealmCache realmCache) {
        return new Realm(realmCache);
    }

    static Realm createInstance(SharedRealm sharedRealm) {
        return new Realm(sharedRealm);
    }

    public <E extends RealmModel> E createObject(Class<E> cls) {
        checkIfValid();
        return (E) createObjectInternal(cls, true, Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E createObjectInternal(Class<E> cls, boolean z, List<String> list) {
        Table table = this.schema.getTable(cls);
        if (OsObjectStore.getPrimaryKeyForObject(this.sharedRealm, this.configuration.getSchemaMediator().getSimpleClassName(cls)) == null) {
            return (E) this.configuration.getSchemaMediator().newInstance(cls, this, OsObject.create(table), this.schema.getColumnInfo(cls), z, list);
        }
        throw new RealmException(String.format(Locale.US, "'%s' has a primary key, use 'createObject(Class<E>, Object)' instead.", table.getClassName()));
    }

    public <E extends RealmModel> E createObject(Class<E> cls, Object obj) {
        checkIfValid();
        return (E) createObjectInternal(cls, obj, true, Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    public <E extends RealmModel> E createObjectInternal(Class<E> cls, Object obj, boolean z, List<String> list) {
        return (E) this.configuration.getSchemaMediator().newInstance(cls, this, OsObject.createWithPrimaryKey(this.schema.getTable(cls), obj), this.schema.getColumnInfo(cls), z, list);
    }

    public <E extends RealmModel> E copyToRealm(E e) {
        checkNotNullObject(e);
        return (E) copyOrUpdate(e, false, new HashMap());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.realm.Realm */
    /* JADX WARN: Multi-variable type inference failed */
    public <E extends RealmModel> E copyToRealmOrUpdate(E e) {
        checkNotNullObject(e);
        checkHasPrimaryKey(e.getClass());
        return (E) copyOrUpdate(e, true, new HashMap());
    }

    public <E extends RealmModel> RealmQuery<E> where(Class<E> cls) {
        checkIfValid();
        return RealmQuery.createQuery(this, cls);
    }

    public void executeTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction should not be null");
        }
        beginTransaction();
        try {
            transaction.execute(this);
            commitTransaction();
        } catch (Throwable th) {
            if (isInTransaction()) {
                cancelTransaction();
            } else {
                RealmLog.warn("Could not cancel transaction, not currently in a transaction.", new Object[0]);
            }
            throw th;
        }
    }

    public RealmAsyncTask executeTransactionAsync(Transaction transaction) {
        return executeTransactionAsync(transaction, null, null);
    }

    public RealmAsyncTask executeTransactionAsync(final Transaction transaction, final Transaction.OnSuccess onSuccess, final Transaction.OnError onError) {
        checkIfValid();
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction should not be null");
        }
        final boolean canDeliverNotification = this.sharedRealm.capabilities.canDeliverNotification();
        if (!(onSuccess == null && onError == null)) {
            this.sharedRealm.capabilities.checkCanDeliverNotification("Callback cannot be delivered on current thread.");
        }
        final RealmConfiguration configuration = getConfiguration();
        final RealmNotifier realmNotifier = this.sharedRealm.realmNotifier;
        return new RealmAsyncTaskImpl(asyncTaskExecutor.submitTransaction(new Runnable() { // from class: io.realm.Realm.1
            /* JADX WARNING: Code restructure failed: missing block: B:32:0x0064, code lost:
                r7 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x0068, code lost:
                throw r7;
             */
            @Override // java.lang.Runnable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r10 = this;
                    java.lang.Thread r0 = java.lang.Thread.currentThread()
                    boolean r0 = r0.isInterrupted()
                    if (r0 == 0) goto L_0x000b
                    return
                L_0x000b:
                    r2 = 0
                    r3 = 0
                    io.realm.RealmConfiguration r0 = r10
                    io.realm.Realm r4 = io.realm.Realm.getInstance(r0)
                    r4.beginTransaction()
                    io.realm.Realm$Transaction r0 = r14     // Catch:{ Throwable -> 0x0055, all -> 0x006a }
                    r0.execute(r4)     // Catch:{ Throwable -> 0x0055, all -> 0x006a }
                    java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Throwable -> 0x0055, all -> 0x006a }
                    boolean r0 = r0.isInterrupted()     // Catch:{ Throwable -> 0x0055, all -> 0x006a }
                    if (r0 == 0) goto L_0x0038
                    boolean r0 = r4.isInTransaction()     // Catch:{ all -> 0x0032 }
                    if (r0 == 0) goto L_0x002e
                    r4.cancelTransaction()     // Catch:{ all -> 0x0032 }
                L_0x002e:
                    r4.close()
                    goto L_0x0037
                L_0x0032:
                    r5 = move-exception
                    r4.close()
                    throw r5
                L_0x0037:
                    return
                L_0x0038:
                    r4.commitTransaction()
                    io.realm.internal.SharedRealm r0 = r4.sharedRealm
                    io.realm.internal.SharedRealm$VersionID r0 = r0.getVersionID()
                    r2 = r0
                    boolean r0 = r4.isInTransaction()     // Catch:{ all -> 0x004f }
                    if (r0 == 0) goto L_0x004b
                    r4.cancelTransaction()     // Catch:{ all -> 0x004f }
                L_0x004b:
                    r4.close()
                    goto L_0x0054
                L_0x004f:
                    r6 = move-exception
                    r4.close()
                    throw r6
                L_0x0054:
                    goto L_0x007e
                L_0x0055:
                    r5 = move-exception
                    r3 = r5
                    boolean r0 = r4.isInTransaction()     // Catch:{ all -> 0x0064 }
                    if (r0 == 0) goto L_0x0060
                    r4.cancelTransaction()     // Catch:{ all -> 0x0064 }
                L_0x0060:
                    r4.close()
                    goto L_0x0069
                L_0x0064:
                    r7 = move-exception
                    r4.close()
                    throw r7
                L_0x0069:
                    goto L_0x007e
                L_0x006a:
                    r8 = move-exception
                    boolean r0 = r4.isInTransaction()     // Catch:{ all -> 0x0078 }
                    if (r0 == 0) goto L_0x0074
                    r4.cancelTransaction()     // Catch:{ all -> 0x0078 }
                L_0x0074:
                    r4.close()
                    goto L_0x007d
                L_0x0078:
                    r9 = move-exception
                    r4.close()
                    throw r9
                L_0x007d:
                    throw r8
                L_0x007e:
                    r5 = r3
                    r6 = r2
                    boolean r0 = r9
                    if (r0 == 0) goto L_0x00a2
                    if (r6 == 0) goto L_0x0095
                    io.realm.Realm$Transaction$OnSuccess r0 = r15
                    if (r0 == 0) goto L_0x0095
                    io.realm.internal.RealmNotifier r0 = r11
                    io.realm.Realm$1$1 r1 = new io.realm.Realm$1$1
                    r1.<init>(r6)
                    r0.post(r1)
                    goto L_0x00ac
                L_0x0095:
                    if (r5 == 0) goto L_0x00ac
                    io.realm.internal.RealmNotifier r0 = r11
                    io.realm.Realm$1$2 r1 = new io.realm.Realm$1$2
                    r1.<init>(r5)
                    r0.post(r1)
                    goto L_0x00ac
                L_0x00a2:
                    if (r5 == 0) goto L_0x00ac
                    io.realm.exceptions.RealmException r0 = new io.realm.exceptions.RealmException
                    java.lang.String r1 = "Async transaction failed"
                    r0.<init>(r1, r5)
                    throw r0
                L_0x00ac:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.realm.Realm.AnonymousClass1.run():void");
            }
        }), asyncTaskExecutor);
    }

    public void delete(Class<? extends RealmModel> cls) {
        checkIfValid();
        this.schema.getTable(cls).clear();
    }

    private <E extends RealmModel> E copyOrUpdate(E e, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        checkIfValid();
        return (E) this.configuration.getSchemaMediator().copyOrUpdate(this, e, z, map);
    }

    private <E extends RealmModel> void checkNotNullObject(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Null objects cannot be copied into Realm.");
        }
    }

    private void checkHasPrimaryKey(Class<? extends RealmModel> cls) {
        if (this.sharedRealm.getSchemaInfo().getObjectSchemaInfo(this.configuration.getSchemaMediator().getSimpleClassName(cls)).getPrimaryKeyProperty() == null) {
            throw new IllegalArgumentException("A RealmObject with no @PrimaryKey cannot be updated: " + cls.toString());
        }
    }

    public static boolean deleteRealm(RealmConfiguration realmConfiguration) {
        return BaseRealm.deleteRealm(realmConfiguration);
    }

    /* access modifiers changed from: package-private */
    public Table getTable(Class<? extends RealmModel> cls) {
        return this.schema.getTable(cls);
    }

    public static Object getDefaultModule() {
        try {
            Constructor<?> constructor = Class.forName("io.realm.DefaultRealmModule").getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (InvocationTargetException e2) {
            throw new RealmException("Could not create an instance of io.realm.DefaultRealmModule", e2);
        } catch (InstantiationException e3) {
            throw new RealmException("Could not create an instance of io.realm.DefaultRealmModule", e3);
        } catch (IllegalAccessException e4) {
            throw new RealmException("Could not create an instance of io.realm.DefaultRealmModule", e4);
        }
    }
}
