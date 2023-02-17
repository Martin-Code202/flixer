package org.chromium.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StrictMode;
import android.os.SystemClock;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.metrics.RecordHistogram;
public abstract class PathUtils {
    static final /* synthetic */ boolean $assertionsDisabled = (!PathUtils.class.desiredAssertionStatus());
    private static String sDataDirectorySuffix;
    private static AsyncTask<Void, Void, String[]> sDirPathFetchTask;
    private static final AtomicBoolean sInitializationStarted = new AtomicBoolean();

    /* access modifiers changed from: package-private */
    public static class Holder {
        private static final String[] DIRECTORY_PATHS = PathUtils.getOrComputeDirectoryPaths();
    }

    private PathUtils() {
    }

    /* access modifiers changed from: private */
    public static String[] getOrComputeDirectoryPaths() {
        try {
            if (!sDirPathFetchTask.cancel(false)) {
                return sDirPathFetchTask.get();
            }
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            try {
                return setPrivateDataDirectorySuffixInternal();
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
            }
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    private static String[] setPrivateDataDirectorySuffixInternal() {
        String[] strArr = new String[5];
        Context applicationContext = ContextUtils.getApplicationContext();
        strArr[0] = applicationContext.getDir(sDataDirectorySuffix, 0).getPath();
        strArr[1] = applicationContext.getDir("textures", 0).getPath();
        strArr[4] = applicationContext.getDir("download_internal", 0).getPath();
        strArr[2] = applicationContext.getDatabasePath("foo").getParent();
        if (applicationContext.getCacheDir() != null) {
            strArr[3] = applicationContext.getCacheDir().getPath();
        }
        return strArr;
    }

    private static String getDirectoryPath(int i) {
        return Holder.DIRECTORY_PATHS[i];
    }

    @CalledByNative
    public static String getDataDirectory() {
        if ($assertionsDisabled || sDirPathFetchTask != null) {
            return getDirectoryPath(0);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getDatabaseDirectory() {
        if ($assertionsDisabled || sDirPathFetchTask != null) {
            return getDirectoryPath(2);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getCacheDirectory() {
        if ($assertionsDisabled || sDirPathFetchTask != null) {
            return getDirectoryPath(3);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory() {
        if ($assertionsDisabled || sDirPathFetchTask != null) {
            return getDirectoryPath(1);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    public static String getDownloadInternalDirectory() {
        if ($assertionsDisabled || sDirPathFetchTask != null) {
            return getDirectoryPath(4);
        }
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    }

    @CalledByNative
    private static String getDownloadsDirectory() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            RecordHistogram.recordTimesHistogram("Android.StrictMode.DownloadsDir", SystemClock.elapsedRealtime() - elapsedRealtime, TimeUnit.MILLISECONDS);
            return path;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @CalledByNative
    private static String getNativeLibraryDirectory() {
        ApplicationInfo applicationInfo = ContextUtils.getApplicationContext().getApplicationInfo();
        if ((applicationInfo.flags & 128) != 0 || (applicationInfo.flags & 1) == 0) {
            return applicationInfo.nativeLibraryDir;
        }
        return "/system/lib/";
    }

    @CalledByNative
    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
}
