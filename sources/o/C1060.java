package o;

import java.io.ByteArrayOutputStream;
/* renamed from: o.ⅰ  reason: contains not printable characters */
public class C1060 extends ByteArrayOutputStream {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0815 f15210;

    public C1060(C0815 r3, int i) {
        this.f15210 = r3;
        this.buf = this.f15210.m15386(Math.max(i, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15210.m15387(this.buf);
        this.buf = null;
        super.close();
    }

    @Override // java.lang.Object
    public void finalize() {
        this.f15210.m15387(this.buf);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m16113(int i) {
        if (this.count + i > this.buf.length) {
            byte[] r4 = this.f15210.m15386((this.count + i) * 2);
            System.arraycopy(this.buf, 0, r4, 0, this.count);
            this.f15210.m15387(this.buf);
            this.buf = r4;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        m16113(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        m16113(1);
        super.write(i);
    }
}
