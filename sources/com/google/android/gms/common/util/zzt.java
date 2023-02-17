package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import java.io.File;
public final class zzt {
    @TargetApi(21)
    public static File getNoBackupFilesDir(Context context) {
        return zzp.zzalk() ? context.getNoBackupFilesDir() : zzd(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File zzd(File file) {
        synchronized (zzt.class) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            if (file.exists()) {
                return file;
            }
            String valueOf = String.valueOf(file.getPath());
            Log.w("SupportV4Utils", valueOf.length() != 0 ? "Unable to create no-backup dir ".concat(valueOf) : new String("Unable to create no-backup dir "));
            return null;
        }
    }
}
