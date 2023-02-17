package android.support.v4.graphics;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    TypefaceCompatApi21Impl() {
    }

    private File getFile(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
            return null;
        } catch (ErrnoException e) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r8 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        if (r10 != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005d, code lost:
        r10.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0061, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0064, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0073, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0074, code lost:
        if (r5 != null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0076, code lost:
        if (r7 != null) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x007c, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007d, code lost:
        r7.addSuppressed(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0081, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0084, code lost:
        throw r14;
     */
    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r17, android.os.CancellationSignal r18, android.support.v4.provider.FontsContractCompat.FontInfo[] r19, int r20) {
        /*
            r16 = this;
            r0 = r19
            int r0 = r0.length
            r1 = 1
            if (r0 >= r1) goto L_0x0008
            r0 = 0
            return r0
        L_0x0008:
            r0 = r16
            r1 = r19
            r2 = r20
            android.support.v4.provider.FontsContractCompat$FontInfo r3 = r0.findBestInfo(r1, r2)
            android.content.ContentResolver r4 = r17.getContentResolver()
            android.net.Uri r0 = r3.getUri()     // Catch:{ IOException -> 0x0085 }
            java.lang.String r1 = "r"
            r2 = r18
            android.os.ParcelFileDescriptor r5 = r4.openFileDescriptor(r0, r1, r2)     // Catch:{ IOException -> 0x0085 }
            r6 = 0
            r0 = r16
            java.io.File r7 = r0.getFile(r5)     // Catch:{ Throwable -> 0x0070 }
            if (r7 == 0) goto L_0x0031
            boolean r0 = r7.canRead()     // Catch:{ Throwable -> 0x0070 }
            if (r0 != 0) goto L_0x0065
        L_0x0031:
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0070 }
            java.io.FileDescriptor r0 = r5.getFileDescriptor()     // Catch:{ Throwable -> 0x0070 }
            r8.<init>(r0)     // Catch:{ Throwable -> 0x0070 }
            r9 = 0
            r0 = r16
            r1 = r17
            android.graphics.Typeface r10 = super.createFromInputStream(r1, r8)     // Catch:{ Throwable -> 0x0050 }
            if (r8 == 0) goto L_0x0049
            r8.close()
        L_0x0049:
            if (r5 == 0) goto L_0x004f
            r5.close()
        L_0x004f:
            return r10
        L_0x0050:
            r10 = move-exception
            r9 = r10
            throw r10     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r12 = move-exception
            if (r8 == 0) goto L_0x0064
            if (r9 == 0) goto L_0x0061
            r8.close()     // Catch:{ Throwable -> 0x005c }
            goto L_0x0064
        L_0x005c:
            r13 = move-exception
            r9.addSuppressed(r13)
            goto L_0x0064
        L_0x0061:
            r8.close()
        L_0x0064:
            throw r12
        L_0x0065:
            android.graphics.Typeface r8 = android.graphics.Typeface.createFromFile(r7)
            if (r5 == 0) goto L_0x006f
            r5.close()
        L_0x006f:
            return r8
        L_0x0070:
            r7 = move-exception
            r6 = r7
            throw r7     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r14 = move-exception
            if (r5 == 0) goto L_0x0084
            if (r6 == 0) goto L_0x0081
            r5.close()     // Catch:{ Throwable -> 0x007c }
            goto L_0x0084
        L_0x007c:
            r15 = move-exception
            r6.addSuppressed(r15)
            goto L_0x0084
        L_0x0081:
            r5.close()
        L_0x0084:
            throw r14
        L_0x0085:
            r5 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi21Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }
}
