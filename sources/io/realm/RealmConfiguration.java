package io.realm;

import android.content.Context;
import io.realm.Realm;
import io.realm.annotations.RealmModule;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmFileException;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.RealmCore;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Util;
import io.realm.internal.modules.CompositeMediator;
import io.realm.internal.modules.FilterableMediator;
import io.realm.rx.RealmObservableFactory;
import io.realm.rx.RxObservableFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
public class RealmConfiguration {
    private static final Object DEFAULT_MODULE = Realm.getDefaultModule();
    protected static final RealmProxyMediator DEFAULT_MODULE_MEDIATOR;
    private static Boolean rxJavaAvailable;
    private final String assetFilePath;
    private final String canonicalPath;
    private final CompactOnLaunchCallback compactOnLaunch;
    private final boolean deleteRealmIfMigrationNeeded;
    private final OsRealmConfig.Durability durability;
    private final Realm.Transaction initialDataTransaction;
    private final boolean isRecoveryConfiguration;
    private final byte[] key;
    private final RealmMigration migration;
    private final boolean readOnly;
    private final File realmDirectory;
    private final String realmFileName;
    private final RxObservableFactory rxObservableFactory;
    private final RealmProxyMediator schemaMediator;
    private final long schemaVersion;

    static {
        if (DEFAULT_MODULE != null) {
            RealmProxyMediator moduleMediator = getModuleMediator(DEFAULT_MODULE.getClass().getCanonicalName());
            if (!moduleMediator.transformerApplied()) {
                throw new ExceptionInInitializerError("RealmTransformer doesn't seem to be applied. Please update the project configuration to use the Realm Gradle plugin. See https://realm.io/news/android-installation-change/");
            }
            DEFAULT_MODULE_MEDIATOR = moduleMediator;
            return;
        }
        DEFAULT_MODULE_MEDIATOR = null;
    }

    protected RealmConfiguration(File file, String str, String str2, String str3, byte[] bArr, long j, RealmMigration realmMigration, boolean z, OsRealmConfig.Durability durability2, RealmProxyMediator realmProxyMediator, RxObservableFactory rxObservableFactory2, Realm.Transaction transaction, boolean z2, CompactOnLaunchCallback compactOnLaunchCallback, boolean z3) {
        this.realmDirectory = file;
        this.realmFileName = str;
        this.canonicalPath = str2;
        this.assetFilePath = str3;
        this.key = bArr;
        this.schemaVersion = j;
        this.migration = realmMigration;
        this.deleteRealmIfMigrationNeeded = z;
        this.durability = durability2;
        this.schemaMediator = realmProxyMediator;
        this.rxObservableFactory = rxObservableFactory2;
        this.initialDataTransaction = transaction;
        this.readOnly = z2;
        this.compactOnLaunch = compactOnLaunchCallback;
        this.isRecoveryConfiguration = z3;
    }

    public File getRealmDirectory() {
        return this.realmDirectory;
    }

    public String getRealmFileName() {
        return this.realmFileName;
    }

    public byte[] getEncryptionKey() {
        if (this.key == null) {
            return null;
        }
        return Arrays.copyOf(this.key, this.key.length);
    }

    public long getSchemaVersion() {
        return this.schemaVersion;
    }

    public RealmMigration getMigration() {
        return this.migration;
    }

    public boolean shouldDeleteRealmIfMigrationNeeded() {
        return this.deleteRealmIfMigrationNeeded;
    }

    public OsRealmConfig.Durability getDurability() {
        return this.durability;
    }

    /* access modifiers changed from: protected */
    public RealmProxyMediator getSchemaMediator() {
        return this.schemaMediator;
    }

    /* access modifiers changed from: package-private */
    public Realm.Transaction getInitialDataTransaction() {
        return this.initialDataTransaction;
    }

    /* access modifiers changed from: package-private */
    public boolean hasAssetFile() {
        return !Util.isEmptyString(this.assetFilePath);
    }

    /* access modifiers changed from: package-private */
    public String getAssetFilePath() {
        return this.assetFilePath;
    }

    public CompactOnLaunchCallback getCompactOnLaunchCallback() {
        return this.compactOnLaunch;
    }

    public String getPath() {
        return this.canonicalPath;
    }

    /* access modifiers changed from: package-private */
    public boolean realmExists() {
        return new File(this.canonicalPath).exists();
    }

    public RxObservableFactory getRxFactory() {
        if (this.rxObservableFactory != null) {
            return this.rxObservableFactory;
        }
        throw new UnsupportedOperationException("RxJava seems to be missing from the classpath. Remember to add it as a compile dependency. See https://realm.io/docs/java/latest/#rxjava for more details.");
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public boolean isRecoveryConfiguration() {
        return this.isRecoveryConfiguration;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RealmConfiguration realmConfiguration = (RealmConfiguration) obj;
        if (this.schemaVersion != realmConfiguration.schemaVersion || this.deleteRealmIfMigrationNeeded != realmConfiguration.deleteRealmIfMigrationNeeded || this.readOnly != realmConfiguration.readOnly || this.isRecoveryConfiguration != realmConfiguration.isRecoveryConfiguration) {
            return false;
        }
        if (this.realmDirectory != null) {
            if (!this.realmDirectory.equals(realmConfiguration.realmDirectory)) {
                return false;
            }
        } else if (realmConfiguration.realmDirectory != null) {
            return false;
        }
        if (this.realmFileName != null) {
            if (!this.realmFileName.equals(realmConfiguration.realmFileName)) {
                return false;
            }
        } else if (realmConfiguration.realmFileName != null) {
            return false;
        }
        if (!this.canonicalPath.equals(realmConfiguration.canonicalPath)) {
            return false;
        }
        if (this.assetFilePath != null) {
            if (!this.assetFilePath.equals(realmConfiguration.assetFilePath)) {
                return false;
            }
        } else if (realmConfiguration.assetFilePath != null) {
            return false;
        }
        if (!Arrays.equals(this.key, realmConfiguration.key)) {
            return false;
        }
        if (this.migration != null) {
            if (!this.migration.equals(realmConfiguration.migration)) {
                return false;
            }
        } else if (realmConfiguration.migration != null) {
            return false;
        }
        if (this.durability != realmConfiguration.durability || !this.schemaMediator.equals(realmConfiguration.schemaMediator)) {
            return false;
        }
        if (this.rxObservableFactory != null) {
            if (!this.rxObservableFactory.equals(realmConfiguration.rxObservableFactory)) {
                return false;
            }
        } else if (realmConfiguration.rxObservableFactory != null) {
            return false;
        }
        if (this.initialDataTransaction != null) {
            if (!this.initialDataTransaction.equals(realmConfiguration.initialDataTransaction)) {
                return false;
            }
        } else if (realmConfiguration.initialDataTransaction != null) {
            return false;
        }
        if (this.compactOnLaunch != null) {
            return this.compactOnLaunch.equals(realmConfiguration.compactOnLaunch);
        }
        return realmConfiguration.compactOnLaunch == null;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((this.realmDirectory != null ? this.realmDirectory.hashCode() : 0) * 31) + (this.realmFileName != null ? this.realmFileName.hashCode() : 0)) * 31) + this.canonicalPath.hashCode()) * 31) + (this.assetFilePath != null ? this.assetFilePath.hashCode() : 0)) * 31) + Arrays.hashCode(this.key)) * 31) + ((int) (this.schemaVersion ^ (this.schemaVersion >>> 32)))) * 31) + (this.migration != null ? this.migration.hashCode() : 0)) * 31) + (this.deleteRealmIfMigrationNeeded ? 1 : 0)) * 31) + this.durability.hashCode()) * 31) + this.schemaMediator.hashCode()) * 31) + (this.rxObservableFactory != null ? this.rxObservableFactory.hashCode() : 0)) * 31) + (this.initialDataTransaction != null ? this.initialDataTransaction.hashCode() : 0)) * 31) + (this.readOnly ? 1 : 0)) * 31) + (this.compactOnLaunch != null ? this.compactOnLaunch.hashCode() : 0)) * 31) + (this.isRecoveryConfiguration ? 1 : 0);
    }

    protected static RealmProxyMediator createSchemaMediator(Set<Object> set, Set<Class<? extends RealmModel>> set2) {
        if (set2.size() > 0) {
            return new FilterableMediator(DEFAULT_MODULE_MEDIATOR, set2);
        }
        if (set.size() == 1) {
            return getModuleMediator(set.iterator().next().getClass().getCanonicalName());
        }
        RealmProxyMediator[] realmProxyMediatorArr = new RealmProxyMediator[set.size()];
        int i = 0;
        for (Object obj : set) {
            realmProxyMediatorArr[i] = getModuleMediator(obj.getClass().getCanonicalName());
            i++;
        }
        return new CompositeMediator(realmProxyMediatorArr);
    }

    private static RealmProxyMediator getModuleMediator(String str) {
        String[] split = str.split("\\.");
        String format = String.format(Locale.US, "io.realm.%s%s", split[split.length - 1], "Mediator");
        try {
            Constructor<?> constructor = Class.forName(format).getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return (RealmProxyMediator) constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            throw new RealmException("Could not find " + format, e);
        } catch (InvocationTargetException e2) {
            throw new RealmException("Could not create an instance of " + format, e2);
        } catch (InstantiationException e3) {
            throw new RealmException("Could not create an instance of " + format, e3);
        } catch (IllegalAccessException e4) {
            throw new RealmException("Could not create an instance of " + format, e4);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("realmDirectory: ").append(this.realmDirectory != null ? this.realmDirectory.toString() : "");
        sb.append("\n");
        sb.append("realmFileName : ").append(this.realmFileName);
        sb.append("\n");
        sb.append("canonicalPath: ").append(this.canonicalPath);
        sb.append("\n");
        sb.append("key: ").append("[length: ").append(this.key == null ? 0 : 64).append("]");
        sb.append("\n");
        sb.append("schemaVersion: ").append(Long.toString(this.schemaVersion));
        sb.append("\n");
        sb.append("migration: ").append(this.migration);
        sb.append("\n");
        sb.append("deleteRealmIfMigrationNeeded: ").append(this.deleteRealmIfMigrationNeeded);
        sb.append("\n");
        sb.append("durability: ").append(this.durability);
        sb.append("\n");
        sb.append("schemaMediator: ").append(this.schemaMediator);
        sb.append("\n");
        sb.append("readOnly: ").append(this.readOnly);
        sb.append("\n");
        sb.append("compactOnLaunch: ").append(this.compactOnLaunch);
        return sb.toString();
    }

    static synchronized boolean isRxJavaAvailable() {
        boolean booleanValue;
        synchronized (RealmConfiguration.class) {
            if (rxJavaAvailable == null) {
                try {
                    Class.forName("io.reactivex.Flowable");
                    rxJavaAvailable = true;
                } catch (ClassNotFoundException e) {
                    rxJavaAvailable = false;
                }
            }
            booleanValue = rxJavaAvailable.booleanValue();
        }
        return booleanValue;
    }

    protected static String getCanonicalPath(File file) {
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            throw new RealmFileException(RealmFileException.Kind.ACCESS_ERROR, "Could not resolve the canonical path to the Realm file: " + file.getAbsolutePath(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isSyncConfiguration() {
        return false;
    }

    public static class Builder {
        private String assetFilePath;
        private CompactOnLaunchCallback compactOnLaunch;
        private HashSet<Class<? extends RealmModel>> debugSchema;
        private boolean deleteRealmIfMigrationNeeded;
        private File directory;
        private OsRealmConfig.Durability durability;
        private String fileName;
        private Realm.Transaction initialDataTransaction;
        private byte[] key;
        private RealmMigration migration;
        private HashSet<Object> modules;
        private boolean readOnly;
        private RxObservableFactory rxFactory;
        private long schemaVersion;

        public Builder() {
            this(BaseRealm.applicationContext);
        }

        Builder(Context context) {
            this.modules = new HashSet<>();
            this.debugSchema = new HashSet<>();
            if (context == null) {
                throw new IllegalStateException("Call `Realm.init(Context)` before creating a RealmConfiguration");
            }
            RealmCore.loadLibrary(context);
            initializeBuilder(context);
        }

        private void initializeBuilder(Context context) {
            this.directory = context.getFilesDir();
            this.fileName = "default.realm";
            this.key = null;
            this.schemaVersion = 0;
            this.migration = null;
            this.deleteRealmIfMigrationNeeded = false;
            this.durability = OsRealmConfig.Durability.FULL;
            this.readOnly = false;
            this.compactOnLaunch = null;
            if (RealmConfiguration.DEFAULT_MODULE != null) {
                this.modules.add(RealmConfiguration.DEFAULT_MODULE);
            }
        }

        public Builder name(String str) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("A non-empty filename must be provided");
            }
            this.fileName = str;
            return this;
        }

        public Builder schemaVersion(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("Realm schema version numbers must be 0 (zero) or higher. Yours was: " + j);
            }
            this.schemaVersion = j;
            return this;
        }

        public Builder migration(RealmMigration realmMigration) {
            if (realmMigration == null) {
                throw new IllegalArgumentException("A non-null migration must be provided");
            }
            this.migration = realmMigration;
            return this;
        }

        public Builder deleteRealmIfMigrationNeeded() {
            if (this.assetFilePath == null || this.assetFilePath.length() == 0) {
                this.deleteRealmIfMigrationNeeded = true;
                return this;
            }
            throw new IllegalStateException("Realm cannot clear its schema when previously configured to use an asset file by calling assetFile().");
        }

        public Builder modules(Object obj, Object... objArr) {
            this.modules.clear();
            addModule(obj);
            if (objArr != null) {
                for (Object obj2 : objArr) {
                    addModule(obj2);
                }
            }
            return this;
        }

        private void addModule(Object obj) {
            if (obj != null) {
                checkModule(obj);
                this.modules.add(obj);
            }
        }

        public RealmConfiguration build() {
            if (this.readOnly) {
                if (this.initialDataTransaction != null) {
                    throw new IllegalStateException("This Realm is marked as read-only. Read-only Realms cannot use initialData(Realm.Transaction).");
                } else if (this.assetFilePath == null) {
                    throw new IllegalStateException("Only Realms provided using 'assetFile(path)' can be marked read-only. No such Realm was provided.");
                } else if (this.deleteRealmIfMigrationNeeded) {
                    throw new IllegalStateException("'deleteRealmIfMigrationNeeded()' and read-only Realms cannot be combined");
                } else if (this.compactOnLaunch != null) {
                    throw new IllegalStateException("'compactOnLaunch()' and read-only Realms cannot be combined");
                }
            }
            if (this.rxFactory == null && RealmConfiguration.isRxJavaAvailable()) {
                this.rxFactory = new RealmObservableFactory();
            }
            return new RealmConfiguration(this.directory, this.fileName, RealmConfiguration.getCanonicalPath(new File(this.directory, this.fileName)), this.assetFilePath, this.key, this.schemaVersion, this.migration, this.deleteRealmIfMigrationNeeded, this.durability, RealmConfiguration.createSchemaMediator(this.modules, this.debugSchema), this.rxFactory, this.initialDataTransaction, this.readOnly, this.compactOnLaunch, false);
        }

        private void checkModule(Object obj) {
            if (!obj.getClass().isAnnotationPresent(RealmModule.class)) {
                throw new IllegalArgumentException(obj.getClass().getCanonicalName() + " is not a RealmModule. Add @RealmModule to the class definition.");
            }
        }
    }
}
