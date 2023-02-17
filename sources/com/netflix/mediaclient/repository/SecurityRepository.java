package com.netflix.mediaclient.repository;

import android.content.Context;
import o.AD;
import o.C1283;
import o.C1323Aw;
import org.json.JSONObject;
public final class SecurityRepository {
    private static final String CONSTANT_CRITTERCISM_APP_ID = "4ea666553f5b3166a700072f";
    private static final String CONSTANT_DEVICE_ID_TOKEN = "20MNetflix2010";
    private static final String ESN_DELIM = "-";
    private static final String MODEL_DELIM = "_";
    private static final String MSL_STORE_FILE_NAME = "ms.dat";
    private static final String SECURE_STORE_FILE_NAME = "kf.dat";
    private static final String TAG = "SEC";
    private static String esnPrefix = null;
    private static boolean sLoaded = false;

    private static final native String native_getConstant(int i);

    private static final native int native_getLibraryVersion();

    private static native String native_getSystemProperty(String str);

    private static final native void native_init(byte[] bArr);

    private static native String native_loadGenericStore(String str);

    private static native String native_loadOldSecureStore(String str);

    private static native void native_saveGenericStore(String str, String str2);

    private static native void native_setLog(boolean z);

    private SecurityRepository() {
    }

    public static String getDeviceIdToken() {
        return CONSTANT_DEVICE_ID_TOKEN;
    }

    public static String getEsnPrefix() {
        return esnPrefix;
    }

    public static String getEsnDelim() {
        return ESN_DELIM;
    }

    public static String getModelDelim() {
        return MODEL_DELIM;
    }

    public static String getCrittercismAppId() {
        return CONSTANT_CRITTERCISM_APP_ID;
    }

    private static String getPath(Context context, String str) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (absolutePath.endsWith("/")) {
            return absolutePath + str;
        }
        return absolutePath + "/" + str;
    }

    public static JSONObject getOldSecureStore(Context context) {
        String native_loadOldSecureStore = native_loadOldSecureStore(getPath(context, SECURE_STORE_FILE_NAME));
        C1283.m16851(TAG, "Received %s ", native_loadOldSecureStore);
        return new JSONObject(native_loadOldSecureStore);
    }

    public static String getSecureStore(Context context) {
        C1283.m16854(TAG, "getSecureStore started...");
        String native_loadGenericStore = native_loadGenericStore(getPath(context, MSL_STORE_FILE_NAME));
        C1283.m16851(TAG, "Received %s ", native_loadGenericStore);
        if ("{}".equals(native_loadGenericStore)) {
            return null;
        }
        String str = new String(C1323Aw.m3800(native_loadGenericStore), "UTF-8");
        C1283.m16851(TAG, "Received as JSON %s ", str);
        return str;
    }

    public static void saveSecureStore(Context context, String str) {
        C1283.m16854(TAG, "saveSecureStore started...");
        native_saveGenericStore(getPath(context, MSL_STORE_FILE_NAME), C1323Aw.m3795(str.getBytes()));
        C1283.m16854(TAG, "saveSecureStore done.");
    }

    public static boolean isLoaded() {
        return sLoaded;
    }

    public static final int getLibraryVersion() {
        return native_getLibraryVersion();
    }

    public static synchronized boolean loadLibraries(Context context) {
        synchronized (SecurityRepository.class) {
            if (sLoaded) {
                C1283.m16865(TAG, "We already loaded native libraries!");
                return true;
            }
            sLoaded = AD.m3304(context, "netflixss_jni");
            if (sLoaded) {
                native_init(new byte[0]);
            }
            return sLoaded;
        }
    }

    public static String getSystemPropety(String str) {
        return native_getSystemProperty(str);
    }

    public static void setNativeLogging(boolean z) {
        native_setLog(z);
    }
}
