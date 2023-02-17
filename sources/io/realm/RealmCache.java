package io.realm;

import io.realm.exceptions.RealmFileException;
import io.realm.internal.ObjectServerFacade;
import io.realm.internal.OsObjectStore;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.Util;
import io.realm.log.RealmLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
/* access modifiers changed from: package-private */
public final class RealmCache {
    private static final List<WeakReference<RealmCache>> cachesList = new LinkedList();
    private static final Collection<RealmCache> leakedCaches = new ConcurrentLinkedQueue();
    private RealmConfiguration configuration;
    private final AtomicBoolean isLeaked = new AtomicBoolean(false);
    private final String realmPath;
    private final EnumMap<RealmCacheType, RefAndCount> refAndCountMap;

    /* access modifiers changed from: package-private */
    public interface Callback {
        void onResult(int i);
    }

    /* access modifiers changed from: package-private */
    public static class RefAndCount {
        private int globalCount;
        private final ThreadLocal<Integer> localCount;
        private final ThreadLocal<BaseRealm> localRealm;

        private RefAndCount() {
            this.localRealm = new ThreadLocal<>();
            this.localCount = new ThreadLocal<>();
            this.globalCount = 0;
        }

        static /* synthetic */ int access$808(RefAndCount refAndCount) {
            int i = refAndCount.globalCount;
            refAndCount.globalCount = i + 1;
            return i;
        }

        static /* synthetic */ int access$810(RefAndCount refAndCount) {
            int i = refAndCount.globalCount;
            refAndCount.globalCount = i - 1;
            return i;
        }
    }

    /* access modifiers changed from: package-private */
    public enum RealmCacheType {
        TYPED_REALM,
        DYNAMIC_REALM;

        static RealmCacheType valueOf(Class<? extends BaseRealm> cls) {
            if (cls == Realm.class) {
                return TYPED_REALM;
            }
            if (cls == DynamicRealm.class) {
                return DYNAMIC_REALM;
            }
            throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
        }
    }

    private RealmCache(String str) {
        this.realmPath = str;
        this.refAndCountMap = new EnumMap<>(RealmCacheType.class);
        for (RealmCacheType realmCacheType : RealmCacheType.values()) {
            this.refAndCountMap.put((EnumMap<RealmCacheType, RefAndCount>) realmCacheType, (RealmCacheType) new RefAndCount());
        }
    }

    private static RealmCache getCache(String str, boolean z) {
        RealmCache realmCache = null;
        synchronized (cachesList) {
            Iterator<WeakReference<RealmCache>> it = cachesList.iterator();
            while (it.hasNext()) {
                RealmCache realmCache2 = it.next().get();
                if (realmCache2 == null) {
                    it.remove();
                } else if (realmCache2.realmPath.equals(str)) {
                    realmCache = realmCache2;
                }
            }
            if (realmCache == null && z) {
                realmCache = new RealmCache(str);
                cachesList.add(new WeakReference<>(realmCache));
            }
        }
        return realmCache;
    }

    static <E extends BaseRealm> E createRealmOrGetFromCache(RealmConfiguration realmConfiguration, Class<E> cls) {
        return (E) getCache(realmConfiguration.getPath(), true).doCreateRealmOrGetFromCache(realmConfiguration, cls);
    }

    private synchronized <E extends BaseRealm> E doCreateRealmOrGetFromCache(RealmConfiguration realmConfiguration, Class<E> cls) {
        RefAndCount refAndCount;
        Object obj;
        refAndCount = this.refAndCountMap.get(RealmCacheType.valueOf(cls));
        if (getTotalGlobalRefCount() == 0) {
            copyAssetFileIfNeeded(realmConfiguration);
            boolean realmExists = realmConfiguration.realmExists();
            SharedRealm sharedRealm = null;
            try {
                if (realmConfiguration.isSyncConfiguration()) {
                    if (!realmExists) {
                        sharedRealm = SharedRealm.getInstance(realmConfiguration);
                        try {
                            ObjectServerFacade.getSyncFacadeIfPossible().downloadRemoteChanges(realmConfiguration);
                        } catch (Throwable th) {
                            sharedRealm.close();
                            BaseRealm.deleteRealm(realmConfiguration);
                            throw th;
                        }
                    }
                } else if (realmExists) {
                    sharedRealm = SharedRealm.getInstance(realmConfiguration);
                    Table.migratePrimaryKeyTableIfNeeded(sharedRealm);
                }
                this.configuration = realmConfiguration;
            } finally {
                if (sharedRealm != null) {
                    sharedRealm.close();
                }
            }
        } else {
            validateConfiguration(realmConfiguration);
        }
        if (refAndCount.localRealm.get() == null) {
            if (cls == Realm.class) {
                obj = Realm.createInstance(this);
            } else if (cls == DynamicRealm.class) {
                obj = DynamicRealm.createInstance(this);
            } else {
                throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
            }
            refAndCount.localRealm.set(obj);
            refAndCount.localCount.set(0);
            RefAndCount.access$808(refAndCount);
        }
        refAndCount.localCount.set(Integer.valueOf(((Integer) refAndCount.localCount.get()).intValue() + 1));
        return (E) ((BaseRealm) refAndCount.localRealm.get());
    }

    /* access modifiers changed from: package-private */
    public synchronized void release(BaseRealm baseRealm) {
        String path = baseRealm.getPath();
        RefAndCount refAndCount = this.refAndCountMap.get(RealmCacheType.valueOf((Class<? extends BaseRealm>) baseRealm.getClass()));
        Integer num = (Integer) refAndCount.localCount.get();
        if (num == null) {
            num = 0;
        }
        if (num.intValue() <= 0) {
            RealmLog.warn("%s has been closed already. refCount is %s", path, num);
            return;
        }
        Integer valueOf = Integer.valueOf(num.intValue() - 1);
        if (valueOf.intValue() == 0) {
            refAndCount.localCount.set(null);
            refAndCount.localRealm.set(null);
            RefAndCount.access$810(refAndCount);
            if (refAndCount.globalCount < 0) {
                throw new IllegalStateException("Global reference counter of Realm" + path + " got corrupted.");
            }
            baseRealm.doClose();
            if (getTotalGlobalRefCount() == 0) {
                this.configuration = null;
                ObjectServerFacade.getFacade(baseRealm.getConfiguration().isSyncConfiguration()).realmClosed(baseRealm.getConfiguration());
            }
        } else {
            refAndCount.localCount.set(valueOf);
        }
    }

    private void validateConfiguration(RealmConfiguration realmConfiguration) {
        if (!this.configuration.equals(realmConfiguration)) {
            if (!Arrays.equals(this.configuration.getEncryptionKey(), realmConfiguration.getEncryptionKey())) {
                throw new IllegalArgumentException("Wrong key used to decrypt Realm.");
            }
            RealmMigration migration = realmConfiguration.getMigration();
            RealmMigration migration2 = this.configuration.getMigration();
            if (migration2 == null || migration == null || !migration2.getClass().equals(migration.getClass()) || migration.equals(migration2)) {
                throw new IllegalArgumentException("Configurations cannot be different if used to open the same file. \nCached configuration: \n" + this.configuration + "\n\nNew configuration: \n" + realmConfiguration);
            }
            throw new IllegalArgumentException("Configurations cannot be different if used to open the same file. The most likely cause is that equals() and hashCode() are not overridden in the migration class: " + realmConfiguration.getMigration().getClass().getCanonicalName());
        }
    }

    static void invokeWithGlobalRefCount(RealmConfiguration realmConfiguration, Callback callback) {
        synchronized (cachesList) {
            RealmCache cache = getCache(realmConfiguration.getPath(), false);
            if (cache == null) {
                callback.onResult(0);
            } else {
                cache.doInvokeWithGlobalRefCount(callback);
            }
        }
    }

    private synchronized void doInvokeWithGlobalRefCount(Callback callback) {
        callback.onResult(getTotalGlobalRefCount());
    }

    private static void copyAssetFileIfNeeded(final RealmConfiguration realmConfiguration) {
        final File file;
        if (realmConfiguration.hasAssetFile()) {
            file = new File(realmConfiguration.getRealmDirectory(), realmConfiguration.getRealmFileName());
        } else {
            file = null;
        }
        final String syncServerCertificateAssetName = ObjectServerFacade.getFacade(realmConfiguration.isSyncConfiguration()).getSyncServerCertificateAssetName(realmConfiguration);
        final boolean z = !Util.isEmptyString(syncServerCertificateAssetName);
        if (file != null || z) {
            OsObjectStore.callWithLock(realmConfiguration, new Runnable() { // from class: io.realm.RealmCache.1
                @Override // java.lang.Runnable
                public void run() {
                    if (file != null) {
                        RealmCache.copyFileIfNeeded(realmConfiguration.getAssetFilePath(), file);
                    }
                    if (z) {
                        RealmCache.copyFileIfNeeded(syncServerCertificateAssetName, new File(ObjectServerFacade.getFacade(realmConfiguration.isSyncConfiguration()).getSyncServerCertificateFilePath(realmConfiguration)));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void copyFileIfNeeded(String str, File file) {
        if (!file.exists()) {
            IOException iOException = null;
            InputStream inputStream = null;
            FileOutputStream fileOutputStream = null;
            try {
                InputStream open = BaseRealm.applicationContext.getAssets().open(str);
                if (open == null) {
                    throw new RealmFileException(RealmFileException.Kind.ACCESS_ERROR, "Invalid input stream to the asset file: " + str);
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = open.read(bArr);
                    if (read <= -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e) {
                        iOException = e;
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        if (iOException == null) {
                            iOException = e2;
                        }
                    }
                }
                if (iOException != null) {
                    throw new RealmFileException(RealmFileException.Kind.ACCESS_ERROR, iOException);
                }
            } catch (IOException e3) {
                throw new RealmFileException(RealmFileException.Kind.ACCESS_ERROR, "Could not resolve the path to the asset file: " + str, e3);
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        iOException = e4;
                    }
                }
                if (0 != 0) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        if (iOException == null) {
                        }
                    }
                }
                throw th;
            }
        }
    }

    public RealmConfiguration getConfiguration() {
        return this.configuration;
    }

    private int getTotalGlobalRefCount() {
        int i = 0;
        for (RefAndCount refAndCount : this.refAndCountMap.values()) {
            i += refAndCount.globalCount;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public void leak() {
        if (!this.isLeaked.getAndSet(true)) {
            leakedCaches.add(this);
        }
    }
}
