package o;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* renamed from: o.Do  reason: case insensitive filesystem */
public class C1398Do extends InputStream {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final Map<Integer, byte[]> f5443 = new HashMap(256);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final LinkedList<Byte> f5444 = new LinkedList<>();

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f5445 = 8;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Map<Integer, byte[]> f5446 = new HashMap(f5443);

    /* renamed from: ˋ  reason: contains not printable characters */
    private final LinkedList<Byte> f5447 = new LinkedList<>();

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f5448 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final InputStream f5449;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final ByteArrayOutputStream f5450 = new ByteArrayOutputStream();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f5451 = false;

    static {
        for (int i = 0; i < 256; i++) {
            f5443.put(Integer.valueOf(i), new byte[]{(byte) i});
        }
    }

    public C1398Do(InputStream inputStream) {
        this.f5449 = inputStream;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        close();
        super.finalize();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f5451) {
            this.f5451 = true;
            this.f5449.close();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f5451) {
            throw new IOException("Input stream is closed.");
        } else if (this.f5444.size() != 0) {
            return this.f5444.remove().byteValue();
        } else {
            byte[] bArr = new byte[1];
            if (m4722(bArr, 0, 1) == -1) {
                return -1;
            }
            return bArr[0];
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.f5451) {
            throw new IOException("Input stream is closed.");
        } else if (i > 0) {
            throw new IndexOutOfBoundsException("Specified offset cannot be negative.");
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("Specified length cannot be negative.");
        } else if (i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("Requested length exceeds buffer size at offset.");
        } else {
            int i3 = i;
            int i4 = i2;
            while (i4 > 0 && this.f5444.size() > 0) {
                i3++;
                bArr[i3] = this.f5444.remove().byteValue();
                i4--;
            }
            if (i4 == 0) {
                return i2;
            }
            int r4 = m4722(bArr, i3, i4);
            if (r4 != -1) {
                return i2 - (i4 - r4);
            }
            if (i4 == i2) {
                return -1;
            }
            return i2 - i4;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private int m4722(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int size = this.f5445 - ((this.f5447.size() * 8) - this.f5448);
            int i4 = (size / 8) + (size % 8 != 0 ? 1 : 0);
            byte[] bArr2 = new byte[i4];
            int i5 = 0;
            while (i5 < i4) {
                int read = this.f5449.read(bArr2, i5, bArr2.length - i5);
                if (read != -1) {
                    i5 += read;
                } else if (i3 == 0) {
                    return -1;
                } else {
                    return i3;
                }
            }
            for (byte b : bArr2) {
                this.f5447.add(Byte.valueOf(b));
            }
            int i6 = 0;
            int i7 = 0;
            while (i7 < this.f5445) {
                int min = Math.min(this.f5445 - i7, 8 - this.f5448);
                int byteValue = ((this.f5447.peek().byteValue() << this.f5448) & 255) >>> (8 - min);
                i7 += min;
                this.f5448 += min;
                if (this.f5448 == 8) {
                    this.f5448 = 0;
                    this.f5447.remove();
                }
                i6 |= (byteValue & 255) << (this.f5445 - i7);
            }
            byte[] bArr3 = this.f5446.get(Integer.valueOf(i6));
            if (this.f5450.size() == 0) {
                this.f5445++;
            } else {
                if (bArr3 == null) {
                    this.f5450.write(this.f5450.toByteArray()[0]);
                } else {
                    this.f5450.write(bArr3[0]);
                }
                this.f5446.put(Integer.valueOf(this.f5446.size()), this.f5450.toByteArray());
                this.f5450.reset();
                if (this.f5446.size() == (1 << this.f5445)) {
                    this.f5445++;
                }
                if (bArr3 == null) {
                    bArr3 = this.f5446.get(Integer.valueOf(i6));
                }
            }
            for (byte b2 : bArr3) {
                if (i3 < i2) {
                    i3++;
                    bArr[i3 + i] = b2;
                } else {
                    this.f5444.add(Byte.valueOf(b2));
                }
            }
            this.f5450.write(bArr3);
        }
        return i3;
    }
}
