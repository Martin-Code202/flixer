package io.realm.internal;

import io.realm.CompactOnLaunchCallback;
import io.realm.RealmConfiguration;
import io.realm.internal.SharedRealm;
import io.realm.log.RealmLog;
import java.net.URI;
import java.net.URISyntaxException;
public class OsRealmConfig implements NativeObject {
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final CompactOnLaunchCallback compactOnLaunchCallback;
    private final NativeContext context;
    private final SharedRealm.InitializationCallback initializationCallback;
    private final SharedRealm.MigrationCallback migrationCallback;
    private final long nativePtr;
    private final RealmConfiguration realmConfiguration;
    private final URI resolvedRealmURI;

    private static native long nativeCreate(String str, boolean z, boolean z2);

    private static native String nativeCreateAndSetSyncConfig(long j, String str, String str2, String str3, String str4, boolean z, byte b);

    private static native void nativeEnableChangeNotification(long j, boolean z);

    private static native long nativeGetFinalizerPtr();

    private static native void nativeSetCompactOnLaunchCallback(long j, CompactOnLaunchCallback compactOnLaunchCallback2);

    private static native void nativeSetEncryptionKey(long j, byte[] bArr);

    private static native void nativeSetInMemory(long j, boolean z);

    private native void nativeSetInitializationCallback(long j, SharedRealm.InitializationCallback initializationCallback2);

    private native void nativeSetSchemaConfig(long j, byte b, long j2, long j3, SharedRealm.MigrationCallback migrationCallback2);

    private static native void nativeSetSyncConfigSslSettings(long j, boolean z, String str);

    public enum Durability {
        FULL(0),
        MEM_ONLY(1);
        
        final int value;

        private Durability(int i) {
            this.value = i;
        }
    }

    public enum SchemaMode {
        SCHEMA_MODE_AUTOMATIC((byte) 0),
        SCHEMA_MODE_IMMUTABLE((byte) 1),
        SCHEMA_MODE_READONLY((byte) 2),
        SCHEMA_MODE_RESET_FILE((byte) 3),
        SCHEMA_MODE_ADDITIVE((byte) 4),
        SCHEMA_MODE_MANUAL((byte) 5);
        
        final byte value;

        private SchemaMode(byte b) {
            this.value = b;
        }

        public byte getNativeValue() {
            return this.value;
        }
    }

    public static class Builder {
        private boolean autoUpdateNotification = false;
        private RealmConfiguration configuration;
        private SharedRealm.InitializationCallback initializationCallback = null;
        private SharedRealm.MigrationCallback migrationCallback = null;
        private OsSchemaInfo schemaInfo = null;

        public Builder(RealmConfiguration realmConfiguration) {
            this.configuration = realmConfiguration;
        }

        public Builder schemaInfo(OsSchemaInfo osSchemaInfo) {
            this.schemaInfo = osSchemaInfo;
            return this;
        }

        public Builder migrationCallback(SharedRealm.MigrationCallback migrationCallback2) {
            this.migrationCallback = migrationCallback2;
            return this;
        }

        public Builder initializationCallback(SharedRealm.InitializationCallback initializationCallback2) {
            this.initializationCallback = initializationCallback2;
            return this;
        }

        public Builder autoUpdateNotification(boolean z) {
            this.autoUpdateNotification = z;
            return this;
        }

        /* access modifiers changed from: package-private */
        public OsRealmConfig build() {
            return new OsRealmConfig(this.configuration, this.autoUpdateNotification, this.schemaInfo, this.migrationCallback, this.initializationCallback);
        }
    }

    private OsRealmConfig(RealmConfiguration realmConfiguration2, boolean z, OsSchemaInfo osSchemaInfo, SharedRealm.MigrationCallback migrationCallback2, SharedRealm.InitializationCallback initializationCallback2) {
        this.context = new NativeContext();
        this.realmConfiguration = realmConfiguration2;
        this.nativePtr = nativeCreate(realmConfiguration2.getPath(), false, true);
        NativeContext.dummyContext.addReference(this);
        Object[] userAndServerUrl = ObjectServerFacade.getSyncFacadeIfPossible().getUserAndServerUrl(this.realmConfiguration);
        String str = (String) userAndServerUrl[0];
        String str2 = (String) userAndServerUrl[1];
        String str3 = (String) userAndServerUrl[2];
        String str4 = (String) userAndServerUrl[3];
        boolean equals = Boolean.TRUE.equals(userAndServerUrl[4]);
        String str5 = (String) userAndServerUrl[5];
        Byte b = (Byte) userAndServerUrl[6];
        boolean equals2 = Boolean.TRUE.equals(userAndServerUrl[7]);
        byte[] encryptionKey = realmConfiguration2.getEncryptionKey();
        if (encryptionKey != null) {
            nativeSetEncryptionKey(this.nativePtr, encryptionKey);
        }
        nativeSetInMemory(this.nativePtr, realmConfiguration2.getDurability() == Durability.MEM_ONLY);
        nativeEnableChangeNotification(this.nativePtr, z);
        SchemaMode schemaMode = SchemaMode.SCHEMA_MODE_MANUAL;
        if (realmConfiguration2.isRecoveryConfiguration()) {
            schemaMode = SchemaMode.SCHEMA_MODE_IMMUTABLE;
        } else if (realmConfiguration2.isReadOnly()) {
            schemaMode = SchemaMode.SCHEMA_MODE_READONLY;
        } else if (str2 != null) {
            schemaMode = SchemaMode.SCHEMA_MODE_ADDITIVE;
        } else if (realmConfiguration2.shouldDeleteRealmIfMigrationNeeded()) {
            schemaMode = SchemaMode.SCHEMA_MODE_RESET_FILE;
        }
        long schemaVersion = realmConfiguration2.getSchemaVersion();
        long nativePtr2 = osSchemaInfo == null ? 0 : osSchemaInfo.getNativePtr();
        this.migrationCallback = migrationCallback2;
        nativeSetSchemaConfig(this.nativePtr, schemaMode.getNativeValue(), schemaVersion, nativePtr2, migrationCallback2);
        this.compactOnLaunchCallback = realmConfiguration2.getCompactOnLaunchCallback();
        if (this.compactOnLaunchCallback != null) {
            nativeSetCompactOnLaunchCallback(this.nativePtr, this.compactOnLaunchCallback);
        }
        this.initializationCallback = initializationCallback2;
        if (initializationCallback2 != null) {
            nativeSetInitializationCallback(this.nativePtr, initializationCallback2);
        }
        URI uri = null;
        if (str2 != null) {
            try {
                uri = new URI(nativeCreateAndSetSyncConfig(this.nativePtr, str2, str3, str, str4, equals2, b.byteValue()));
            } catch (URISyntaxException e) {
                RealmLog.error(e, "Cannot create a URI from the Realm URL address", new Object[0]);
            }
            nativeSetSyncConfigSslSettings(this.nativePtr, equals, str5);
        }
        this.resolvedRealmURI = uri;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativePtr() {
        return this.nativePtr;
    }

    @Override // io.realm.internal.NativeObject
    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public RealmConfiguration getRealmConfiguration() {
        return this.realmConfiguration;
    }

    /* access modifiers changed from: package-private */
    public NativeContext getContext() {
        return this.context;
    }
}
