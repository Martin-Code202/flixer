package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
public class TypefaceCompatUtil {
    public static File getTempFile(Context context) {
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(context.getCacheDir(), str + i);
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (IOException e) {
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (r6 != null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r8 != null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        r8.addSuppressed(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        throw r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.nio.ByteBuffer mmap(java.io.File r15) {
        /*
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0034 }
            r6.<init>(r15)     // Catch:{ IOException -> 0x0034 }
            r7 = 0
            java.nio.channels.FileChannel r8 = r6.getChannel()     // Catch:{ Throwable -> 0x001f }
            long r9 = r8.size()     // Catch:{ Throwable -> 0x001f }
            r0 = r8
            java.nio.channels.FileChannel$MapMode r1 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ Throwable -> 0x001f }
            r4 = r9
            r2 = 0
            java.nio.MappedByteBuffer r11 = r0.map(r1, r2, r4)     // Catch:{ Throwable -> 0x001f }
            if (r6 == 0) goto L_0x001e
            r6.close()
        L_0x001e:
            return r11
        L_0x001f:
            r8 = move-exception
            r7 = r8
            throw r8     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r13 = move-exception
            if (r6 == 0) goto L_0x0033
            if (r7 == 0) goto L_0x0030
            r6.close()     // Catch:{ Throwable -> 0x002b }
            goto L_0x0033
        L_0x002b:
            r14 = move-exception
            r7.addSuppressed(r14)
            goto L_0x0033
        L_0x0030:
            r6.close()
        L_0x0033:
            throw r13
        L_0x0034:
            r6 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatUtil.mmap(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        r16 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        if (r9 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r11 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004e, code lost:
        r17 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004f, code lost:
        r11.addSuppressed(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0055, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0058, code lost:
        throw r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005c, code lost:
        r18 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005d, code lost:
        if (r7 != null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005f, code lost:
        if (r9 != null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0065, code lost:
        r19 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0066, code lost:
        r9.addSuppressed(r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006c, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006f, code lost:
        throw r18;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.ByteBuffer mmap(android.content.Context r20, android.os.CancellationSignal r21, android.net.Uri r22) {
        /*
            android.content.ContentResolver r6 = r20.getContentResolver()
            java.lang.String r0 = "r"
            r1 = r22
            r2 = r21
            android.os.ParcelFileDescriptor r7 = r6.openFileDescriptor(r1, r0, r2)     // Catch:{ IOException -> 0x0070 }
            r8 = 0
            if (r7 != 0) goto L_0x0019
            r9 = 0
            if (r7 == 0) goto L_0x0018
            r7.close()
        L_0x0018:
            return r9
        L_0x0019:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0059 }
            java.io.FileDescriptor r0 = r7.getFileDescriptor()     // Catch:{ Throwable -> 0x0059 }
            r9.<init>(r0)     // Catch:{ Throwable -> 0x0059 }
            r10 = 0
            java.nio.channels.FileChannel r11 = r9.getChannel()     // Catch:{ Throwable -> 0x0042 }
            long r12 = r11.size()     // Catch:{ Throwable -> 0x0042 }
            r0 = r11
            java.nio.channels.FileChannel$MapMode r1 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ Throwable -> 0x0042 }
            r4 = r12
            r2 = 0
            java.nio.MappedByteBuffer r14 = r0.map(r1, r2, r4)     // Catch:{ Throwable -> 0x0042 }
            if (r9 == 0) goto L_0x003b
            r9.close()
        L_0x003b:
            if (r7 == 0) goto L_0x0041
            r7.close()
        L_0x0041:
            return r14
        L_0x0042:
            r11 = move-exception
            r10 = r11
            throw r11     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r16 = move-exception
            if (r9 == 0) goto L_0x0058
            if (r10 == 0) goto L_0x0055
            r9.close()     // Catch:{ Throwable -> 0x004e }
            goto L_0x0058
        L_0x004e:
            r17 = move-exception
            r0 = r17
            r10.addSuppressed(r0)
            goto L_0x0058
        L_0x0055:
            r9.close()
        L_0x0058:
            throw r16
        L_0x0059:
            r9 = move-exception
            r8 = r9
            throw r9     // Catch:{ all -> 0x005c }
        L_0x005c:
            r18 = move-exception
            if (r7 == 0) goto L_0x006f
            if (r8 == 0) goto L_0x006c
            r7.close()     // Catch:{ Throwable -> 0x0065 }
            goto L_0x006f
        L_0x0065:
            r19 = move-exception
            r0 = r19
            r8.addSuppressed(r0)
            goto L_0x006f
        L_0x006c:
            r7.close()
        L_0x006f:
            throw r18
        L_0x0070:
            r7 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatUtil.mmap(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    public static ByteBuffer copyToDirectBuffer(Context context, Resources resources, int i) {
        File tempFile = getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!copyToFile(tempFile, resources, i)) {
                return null;
            }
            ByteBuffer mmap = mmap(tempFile);
            tempFile.delete();
            return mmap;
        } finally {
            tempFile.delete();
        }
    }

    public static boolean copyToFile(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, false);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    return true;
                }
            }
        } catch (IOException e) {
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            return false;
        } finally {
            closeQuietly(fileOutputStream);
        }
    }

    public static boolean copyToFile(File file, Resources resources, int i) {
        InputStream inputStream = null;
        try {
            inputStream = resources.openRawResource(i);
            return copyToFile(file, inputStream);
        } finally {
            closeQuietly(inputStream);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
