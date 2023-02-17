package com.crittercism.app;

import android.content.Context;
import com.crittercism.internal.cf;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
public class CrittercismNDK {
    private static final String[] LEGACY_SO_FILE_NAMES = {"libcrittercism-ndk.so", "libcrittercism-v3.so"};
    private static boolean isNdkInstalled = false;

    public static native boolean installNdk(String str);

    public static File crashDumpDirectory(Context context) {
        return new File(context.getFilesDir().getAbsolutePath(), "/com.crittercism/dumps");
    }

    public static void installNdkLib(Context context) {
        boolean z;
        if (doNdkSharedLibrariesExist(context)) {
            z = loadLibraryFromAssets(context);
        } else {
            try {
                System.loadLibrary("64libcrittercism-v3");
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
        }
        if (!z) {
            cf.d("did not load NDK library.");
            return;
        }
        cf.d("loaded NDK library.");
        try {
            File crashDumpDirectory = crashDumpDirectory(context);
            if (installNdk(crashDumpDirectory.getAbsolutePath())) {
                crashDumpDirectory.mkdirs();
                isNdkInstalled = true;
                cf.c("initialized NDK crash reporting.");
                return;
            }
            cf.b("Unable to initialize NDK crash reporting.");
        } catch (Throwable th) {
            cf.a(th);
        }
    }

    public static boolean loadLibraryFromAssets(Context context) {
        File file = new File(context.getFilesDir(), "/com.crittercism/lib/");
        File file2 = new File(file, "lib64libcrittercism-v3.so");
        if (!file2.exists()) {
            if (!copyLibFromAssets(context, file2)) {
                file2.delete();
                return false;
            }
            for (int i = 0; i < LEGACY_SO_FILE_NAMES.length; i++) {
                File file3 = new File(file, LEGACY_SO_FILE_NAMES[i]);
                cf.d("legacy lib: " + file3.getAbsolutePath() + ": " + (file3.exists() ? "deleting" : "not found"));
                file3.delete();
            }
        }
        try {
            System.load(file2.getAbsolutePath());
            return true;
        } catch (Throwable th) {
            cf.a("Unable to install NDK library: " + th.getMessage());
            cf.a(th);
            file2.delete();
            return false;
        }
    }

    public static boolean doNdkSharedLibrariesExist(Context context) {
        try {
            getJarredLibFileStream(context);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static InputStream getJarredLibFileStream(Context context) {
        String str = "armeabi";
        String property = System.getProperty("os.arch");
        cf.d("getJarredLibFileStream: os.arch: " + property);
        if (property.contains("v7")) {
            str = str + "-v7a";
        } else if (property.equals("aarch64")) {
            str = "arm64-v8a";
        }
        String str2 = str + "/lib64libcrittercism-v3.crt";
        cf.d("getJarredLibFileStream: openning input stream from: " + str2);
        return context.getAssets().open(str2);
    }

    public static boolean copyLibFromAssets(Context context, File file) {
        try {
            File parentFile = file.getParentFile();
            cf.d("copyLibFromAssets: creating dir: " + parentFile.getAbsolutePath());
            parentFile.mkdirs();
            cf.d("copyLibFromAssets: installing library into: " + file.getAbsolutePath());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            InputStream jarredLibFileStream = getJarredLibFileStream(context);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = jarredLibFileStream.read(bArr);
                if (read >= 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    jarredLibFileStream.close();
                    fileOutputStream.close();
                    cf.d("copyLibFromAssets: successful");
                    return true;
                }
            }
        } catch (Exception e) {
            cf.a("Could not install breakpad library: " + e.toString());
            return false;
        }
    }
}
