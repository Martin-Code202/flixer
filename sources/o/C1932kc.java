package o;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* renamed from: o.kc  reason: case insensitive filesystem */
public class C1932kc implements oJ {

    /* renamed from: ˋ  reason: contains not printable characters */
    private File f8376;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f8377;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Map<String, File> f8378 = new HashMap();

    public C1932kc(Context context) {
        this.f8377 = context;
        this.f8376 = this.f8377.getDir("player_cache", 0);
        C1283.m16854("nf_subtitles", "Remove cached data for player started... ");
        AH.m3352(this.f8376);
        this.f8376 = this.f8377.getDir("player_cache", 0);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private String m8378(String str, String str2) {
        if (!C1349Bv.m4113(str) && !C1349Bv.m4113(str2)) {
            return str + "_" + str2;
        }
        C1283.m16850("nf_subtitles", "Bad playable id and or language.");
        return null;
    }

    @Override // o.oJ
    /* renamed from: ॱ */
    public String mo7411(String str, String str2) {
        String r2 = m8378(str, str2);
        if (C1349Bv.m4113(str)) {
            C1283.m16850("nf_subtitles", "Playable ID is empty, use temp directory!");
            r2 = String.valueOf(System.currentTimeMillis());
        }
        if (!(this.f8378.get(r2) != null)) {
            File file = new File(this.f8376, r2);
            if (!file.exists()) {
                file.mkdir();
            }
            this.f8378.put(r2, file);
        }
        return r2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        if (r6 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        if (r8 != null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0072, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0073, code lost:
        r8.addSuppressed(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007a, code lost:
        throw r9;
     */
    @Override // o.oJ
    /* renamed from: ॱ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo7412(java.lang.String r12, java.lang.String r13, byte[] r14) {
        /*
            r11 = this;
            boolean r0 = o.C1349Bv.m4113(r12)
            if (r0 != 0) goto L_0x000e
            boolean r0 = o.C1349Bv.m4113(r13)
            if (r0 != 0) goto L_0x000e
            if (r14 != 0) goto L_0x0017
        L_0x000e:
            java.lang.String r0 = "nf_subtitles"
            java.lang.String r1 = "Bad arguments! Key or name are null or bytes are null!"
            o.C1283.m16850(r0, r1)
            r0 = 0
            return r0
        L_0x0017:
            java.util.Map<java.lang.String, java.io.File> r0 = r11.f8378
            java.lang.Object r0 = r0.get(r12)
            r3 = r0
            java.io.File r3 = (java.io.File) r3
            if (r3 != 0) goto L_0x0042
            java.lang.String r0 = "nf_subtitles"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Subtitle cache for "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r12)
            java.lang.String r2 = " does not exist!"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            o.C1283.m16850(r0, r1)
            r0 = 0
            return r0
        L_0x0042:
            java.io.File r4 = new java.io.File
            r4.<init>(r3, r13)
            boolean r5 = r4.createNewFile()     // Catch:{ Throwable -> 0x007c }
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ Throwable -> 0x007c }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x007c }
            r0.<init>(r4)     // Catch:{ Throwable -> 0x007c }
            r6.<init>(r0)     // Catch:{ Throwable -> 0x007c }
            r7 = 0
            r6.write(r14)     // Catch:{ Throwable -> 0x0066 }
            r6.flush()     // Catch:{ Throwable -> 0x0066 }
            r6.close()     // Catch:{ Throwable -> 0x0066 }
            if (r6 == 0) goto L_0x007b
            r6.close()
            goto L_0x007b
        L_0x0066:
            r8 = move-exception
            r7 = r8
            throw r8     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r9 = move-exception
            if (r6 == 0) goto L_0x007a
            if (r7 == 0) goto L_0x0077
            r6.close()     // Catch:{ Throwable -> 0x0072 }
            goto L_0x007a
        L_0x0072:
            r10 = move-exception
            r7.addSuppressed(r10)
            goto L_0x007a
        L_0x0077:
            r6.close()
        L_0x007a:
            throw r9
        L_0x007b:
            goto L_0x0088
        L_0x007c:
            r5 = move-exception
            java.lang.String r0 = "nf_subtitles"
            java.lang.String r1 = "Failed to save file "
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            o.C1283.m16856(r0, r5, r1, r2)
            r4 = 0
        L_0x0088:
            if (r4 == 0) goto L_0x008f
            java.lang.String r0 = r4.getAbsolutePath()
            return r0
        L_0x008f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C1932kc.mo7412(java.lang.String, java.lang.String, byte[]):java.lang.String");
    }

    @Override // o.oJ
    /* renamed from: ˋ */
    public File mo7410(String str, String str2) {
        if (C1349Bv.m4113(str) || C1349Bv.m4113(str2)) {
            C1283.m16865("nf_subtitles", "Bad arguments: key or name not found");
            return null;
        }
        File file = this.f8378.get(str);
        if (file == null) {
            return null;
        }
        File file2 = new File(file, str2);
        if (file2.exists()) {
            C1283.m16854("nf_subtitles", "File exist");
            return file2;
        }
        C1283.m16850("nf_subtitles", "File does NOT exist!");
        return null;
    }
}
