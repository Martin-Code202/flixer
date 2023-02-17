package io.realm.internal;

import io.realm.RealmConfiguration;
public class OsObjectStore {
    private static native boolean nativeCallWithLock(String str, Runnable runnable);

    private static native boolean nativeDeleteTableForObject(long j, String str);

    private static native String nativeGetPrimaryKeyForObject(long j, String str);

    private static native long nativeGetSchemaVersion(long j);

    private static native void nativeSetPrimaryKeyForObject(long j, String str, String str2);

    private static native void nativeSetSchemaVersion(long j, long j2);

    public static void setPrimaryKeyForObject(SharedRealm sharedRealm, String str, String str2) {
        nativeSetPrimaryKeyForObject(sharedRealm.getNativePtr(), str, str2);
    }

    public static String getPrimaryKeyForObject(SharedRealm sharedRealm, String str) {
        return nativeGetPrimaryKeyForObject(sharedRealm.getNativePtr(), str);
    }

    public static void setSchemaVersion(SharedRealm sharedRealm, long j) {
        nativeSetSchemaVersion(sharedRealm.getNativePtr(), j);
    }

    public static long getSchemaVersion(SharedRealm sharedRealm) {
        return nativeGetSchemaVersion(sharedRealm.getNativePtr());
    }

    public static boolean callWithLock(RealmConfiguration realmConfiguration, Runnable runnable) {
        return nativeCallWithLock(realmConfiguration.getPath(), runnable);
    }
}
