package io.realm.internal;

import android.content.Context;
import java.io.File;
import o.C1064;
public class RealmCore {
    private static final String BINARIES_PATH = ("lib" + PATH_SEP + ".." + FILE_SEP + "lib");
    private static final String FILE_SEP = File.separator;
    private static final String PATH_SEP = File.pathSeparator;
    private static volatile boolean libraryIsLoaded = false;

    public static synchronized void loadLibrary(Context context) {
        synchronized (RealmCore.class) {
            if (!libraryIsLoaded) {
                C1064.m16115(context, "realm-jni", "4.1.0");
                libraryIsLoaded = true;
            }
        }
    }
}
