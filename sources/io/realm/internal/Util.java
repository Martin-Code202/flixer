package io.realm.internal;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.log.RealmLog;
import java.io.File;
import java.util.Locale;
public class Util {
    static native String nativeGetTablePrefix();

    public static String getTablePrefix() {
        return nativeGetTablePrefix();
    }

    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: java.lang.Class<? super ? extends io.realm.RealmModel>, java.lang.Object, java.lang.Class<? extends io.realm.RealmModel> */
    public static Class<? extends RealmModel> getOriginalModelClass(Class<? extends RealmModel> cls) {
        Class superclass = cls.getSuperclass();
        return (superclass.equals(Object.class) || superclass.equals(RealmObject.class)) ? cls : superclass;
    }

    public static boolean isEmptyString(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean deleteRealm(String str, File file, String str2) {
        File file2 = new File(file, str2 + ".management");
        File file3 = new File(str);
        File[] listFiles = file2.listFiles();
        if (listFiles != null) {
            for (File file4 : listFiles) {
                if (!file4.delete()) {
                    RealmLog.warn(String.format(Locale.ENGLISH, "Realm temporary file at %s cannot be deleted", file4.getAbsolutePath()), new Object[0]);
                }
            }
        }
        if (file2.exists() && !file2.delete()) {
            RealmLog.warn(String.format(Locale.ENGLISH, "Realm temporary folder at %s cannot be deleted", file2.getAbsolutePath()), new Object[0]);
        }
        if (!file3.exists()) {
            return true;
        }
        boolean delete = file3.delete();
        if (delete) {
            return delete;
        }
        RealmLog.warn(String.format(Locale.ENGLISH, "Realm file at %s cannot be deleted", file3.getAbsolutePath()), new Object[0]);
        return delete;
    }
}
