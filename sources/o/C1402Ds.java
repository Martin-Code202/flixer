package o;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* renamed from: o.Ds  reason: case insensitive filesystem */
public class C1402Ds extends OutputStream {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final Map<iF, Integer> f5453 = new HashMap(256);

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f5454 = false;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ByteArrayOutputStream f5455 = new ByteArrayOutputStream();

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f5456 = 8;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Map<iF, Integer> f5457 = new HashMap(f5453);

    /* renamed from: ॱ  reason: contains not printable characters */
    private final OutputStream f5458;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final LinkedList<Cif> f5459 = new LinkedList<>();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f5460 = false;

    /* access modifiers changed from: package-private */
    /* renamed from: o.Ds$iF */
    public static class iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final byte[] f5461;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final int f5462;

        public iF(byte[] bArr) {
            this.f5461 = bArr;
            this.f5462 = Arrays.hashCode(bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof iF)) {
                return false;
            }
            return Arrays.equals(this.f5461, ((iF) obj).f5461);
        }

        public int hashCode() {
            return this.f5462;
        }

        public String toString() {
            return Arrays.toString(this.f5461);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.Ds$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final int f5463;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final int f5464;

        public Cif(int i, int i2) {
            this.f5464 = i;
            this.f5463 = i2;
        }

        public String toString() {
            return Integer.toHexString(this.f5464) + " (" + this.f5463 + "b)";
        }
    }

    static {
        for (int i = 0; i < 256; i++) {
            f5453.put(new iF(new byte[]{(byte) i}), Integer.valueOf(i));
        }
    }

    public C1402Ds(OutputStream outputStream) {
        this.f5458 = outputStream;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        close();
        super.finalize();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f5454) {
            m4740();
            this.f5458.close();
            this.f5454 = true;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m4740() {
        if (!this.f5460) {
            this.f5460 = true;
            if (this.f5455.size() > 0) {
                this.f5459.add(new Cif(this.f5457.get(new iF(this.f5455.toByteArray())).intValue(), this.f5456));
                flush();
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        write(new byte[]{(byte) (i & 255)}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.f5454) {
            throw new IOException("Output stream is closed.");
        } else if (i < 0) {
            throw new IndexOutOfBoundsException("Offset cannot be negative.");
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("Length cannot be negative.");
        } else if (i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException("Offset plus length cannot be greater than the array length.");
        } else {
            for (int i3 = i; i3 < i + i2; i3++) {
                byte b = bArr[i3];
                this.f5455.write(b);
                byte[] byteArray = this.f5455.toByteArray();
                iF iFVar = new iF(byteArray);
                if (this.f5457.get(iFVar) == null) {
                    this.f5459.add(new Cif(this.f5457.get(new iF(Arrays.copyOf(byteArray, byteArray.length - 1))).intValue(), this.f5456));
                    int size = this.f5457.size();
                    if ((size >> this.f5456) != 0) {
                        this.f5456++;
                    }
                    this.f5457.put(iFVar, Integer.valueOf(size));
                    this.f5455.reset();
                    this.f5455.write(b);
                    if (this.f5459.size() > 100) {
                        flush();
                    }
                }
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        if (!this.f5459.isEmpty()) {
            int i = 0;
            LinkedList linkedList = new LinkedList();
            while (this.f5459.size() > 0) {
                Cif remove = this.f5459.remove();
                linkedList.add(remove);
                i += remove.f5463;
                if (i % 8 == 0) {
                    this.f5458.write(m4739(linkedList));
                    linkedList.clear();
                    i = 0;
                }
            }
            if (this.f5460) {
                this.f5458.write(m4739(linkedList));
            } else {
                this.f5459.addAll(linkedList);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static byte[] m4739(LinkedList<Cif> linkedList) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte b = 0;
        int i = 8;
        while (linkedList.size() > 0) {
            Cif remove = linkedList.remove();
            int i2 = remove.f5463;
            while (i2 > 0) {
                if (i2 > i) {
                    byteArrayOutputStream.write((byte) (((remove.f5464 >>> (i2 - i)) & 255) | b));
                    i2 -= i;
                    i = 8;
                    b = 0;
                } else if (i2 <= i) {
                    b = (byte) (((((remove.f5464 << (i - i2)) & 255) >>> (8 - i)) & 255) | b);
                    i -= i2;
                    i2 = 0;
                    if (i == 0) {
                        byteArrayOutputStream.write(b);
                        i = 8;
                        b = 0;
                    }
                }
            }
        }
        if (i < 8) {
            byteArrayOutputStream.write(b);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
