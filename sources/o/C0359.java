package o;

import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* access modifiers changed from: package-private */
/* renamed from: o.Ƭ  reason: contains not printable characters */
public class C0359 implements Closeable {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Charset f13109;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final InputStream f13110;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f13111;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f13112;

    /* renamed from: ॱ  reason: contains not printable characters */
    private byte[] f13113;

    public C0359(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public C0359(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (!charset.equals(C1280.f15990)) {
            throw new IllegalArgumentException("Unsupported encoding");
        } else {
            this.f13110 = inputStream;
            this.f13109 = charset;
            this.f13113 = new byte[i];
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f13110) {
            if (this.f13113 != null) {
                this.f13113 = null;
                this.f13110.close();
            }
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079 A[Catch:{ all -> 0x00a8 }] */
    /* renamed from: ˎ  reason: contains not printable characters */
    public java.lang.String m13995() {
        /*
            r13 = this;
            java.io.InputStream r4 = r13.f13110
            monitor-enter(r4)
            byte[] r0 = r13.f13113     // Catch:{ all -> 0x00ba }
            if (r0 != 0) goto L_0x000f
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = "LineReader is closed"
            r0.<init>(r1)     // Catch:{ all -> 0x00ba }
            throw r0     // Catch:{ all -> 0x00ba }
        L_0x000f:
            int r0 = r13.f13112     // Catch:{ all -> 0x00ba }
            int r1 = r13.f13111     // Catch:{ all -> 0x00ba }
            if (r0 < r1) goto L_0x0018
            r13.m13994()     // Catch:{ all -> 0x00ba }
        L_0x0018:
            int r5 = r13.f13112     // Catch:{ all -> 0x00ba }
        L_0x001a:
            int r0 = r13.f13111     // Catch:{ all -> 0x00ba }
            if (r5 == r0) goto L_0x0054
            byte[] r0 = r13.f13113     // Catch:{ all -> 0x00ba }
            byte r0 = r0[r5]     // Catch:{ all -> 0x00ba }
            r1 = 10
            if (r0 != r1) goto L_0x0051
            int r0 = r13.f13112     // Catch:{ all -> 0x00ba }
            if (r5 == r0) goto L_0x0037
            byte[] r0 = r13.f13113     // Catch:{ all -> 0x00ba }
            int r1 = r5 + -1
            byte r0 = r0[r1]     // Catch:{ all -> 0x00ba }
            r1 = 13
            if (r0 != r1) goto L_0x0037
            int r6 = r5 + -1
            goto L_0x0038
        L_0x0037:
            r6 = r5
        L_0x0038:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x00ba }
            byte[] r0 = r13.f13113     // Catch:{ all -> 0x00ba }
            int r1 = r13.f13112     // Catch:{ all -> 0x00ba }
            int r2 = r13.f13112     // Catch:{ all -> 0x00ba }
            int r2 = r6 - r2
            java.nio.charset.Charset r3 = r13.f13109     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r3.name()     // Catch:{ all -> 0x00ba }
            r7.<init>(r0, r1, r2, r3)     // Catch:{ all -> 0x00ba }
            int r0 = r5 + 1
            r13.f13112 = r0     // Catch:{ all -> 0x00ba }
            monitor-exit(r4)
            return r7
        L_0x0051:
            int r5 = r5 + 1
            goto L_0x001a
        L_0x0054:
            o.Ƭ$4 r5 = new o.Ƭ$4
            int r0 = r13.f13111
            int r1 = r13.f13112
            int r0 = r0 - r1
            int r0 = r0 + 80
            r5.<init>(r0)
            r6 = 0
        L_0x0061:
            byte[] r0 = r13.f13113     // Catch:{ Throwable -> 0x00a5 }
            int r1 = r13.f13112     // Catch:{ Throwable -> 0x00a5 }
            int r2 = r13.f13111     // Catch:{ Throwable -> 0x00a5 }
            int r3 = r13.f13112     // Catch:{ Throwable -> 0x00a5 }
            int r2 = r2 - r3
            r5.write(r0, r1, r2)     // Catch:{ Throwable -> 0x00a5 }
            r0 = -1
            r13.f13111 = r0     // Catch:{ Throwable -> 0x00a5 }
            r13.m13994()     // Catch:{ Throwable -> 0x00a5 }
            int r7 = r13.f13112     // Catch:{ Throwable -> 0x00a5 }
        L_0x0075:
            int r0 = r13.f13111     // Catch:{ Throwable -> 0x00a5 }
            if (r7 == r0) goto L_0x00a3
            byte[] r0 = r13.f13113     // Catch:{ Throwable -> 0x00a5 }
            byte r0 = r0[r7]     // Catch:{ Throwable -> 0x00a5 }
            r1 = 10
            if (r0 != r1) goto L_0x00a0
            int r0 = r13.f13112     // Catch:{ Throwable -> 0x00a5 }
            if (r7 == r0) goto L_0x0090
            byte[] r0 = r13.f13113     // Catch:{ Throwable -> 0x00a5 }
            int r1 = r13.f13112     // Catch:{ Throwable -> 0x00a5 }
            int r2 = r13.f13112     // Catch:{ Throwable -> 0x00a5 }
            int r2 = r7 - r2
            r5.write(r0, r1, r2)     // Catch:{ Throwable -> 0x00a5 }
        L_0x0090:
            int r0 = r7 + 1
            r13.f13112 = r0     // Catch:{ Throwable -> 0x00a5 }
            java.lang.String r8 = r5.toString()     // Catch:{ Throwable -> 0x00a5 }
            if (r5 == 0) goto L_0x009e
            r5.close()
        L_0x009e:
            monitor-exit(r4)
            return r8
        L_0x00a0:
            int r7 = r7 + 1
            goto L_0x0075
        L_0x00a3:
            goto L_0x0061
        L_0x00a5:
            r7 = move-exception
            r6 = r7
            throw r7     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r10 = move-exception
            if (r5 == 0) goto L_0x00b9
            if (r6 == 0) goto L_0x00b6
            r5.close()     // Catch:{ Throwable -> 0x00b1 }
            goto L_0x00b9
        L_0x00b1:
            r11 = move-exception
            r6.addSuppressed(r11)
            goto L_0x00b9
        L_0x00b6:
            r5.close()
        L_0x00b9:
            throw r10
        L_0x00ba:
            r12 = move-exception
            monitor-exit(r4)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0359.m13995():java.lang.String");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m13996() {
        return this.f13111 == -1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13994() {
        int read = this.f13110.read(this.f13113, 0, this.f13113.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f13112 = 0;
        this.f13111 = read;
    }
}
