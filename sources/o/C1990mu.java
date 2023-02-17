package o;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
/* renamed from: o.mu  reason: case insensitive filesystem */
public class C1990mu {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final byte[] f8944 = {115, 105, 100, 120};

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f8945;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f8946 = false;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Cif[] f8947;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f8948;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f8949 = 0;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f8950;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f8951;

    /* renamed from: ˏ  reason: contains not printable characters */
    private short f8952;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private long f8953;

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f8954;

    /* renamed from: ॱ  reason: contains not printable characters */
    private UUID f8955;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f8956 = true;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private long f8957;

    public C1990mu(DataInputStream dataInputStream, int i, int i2) {
        if (dataInputStream == null) {
            throw new IllegalArgumentException("Segment index is null!");
        }
        byte[] bArr = {dataInputStream.readByte(), dataInputStream.readByte(), dataInputStream.readByte(), dataInputStream.readByte()};
        int i3 = 0;
        while (true) {
            int length = bArr.length;
            if (i3 >= 4) {
                this.f8950 = (bArr[0] << 24) | (bArr[1] << 16) | (bArr[2] << 8) | bArr[3];
                byte[] bArr2 = new byte[36];
                dataInputStream.read(bArr2);
                this.f8955 = UUID.fromString(new String(bArr2));
                this.f8948 = dataInputStream.readInt();
                this.f8954 = i;
                this.f8949 = this.f8954 + this.f8948;
                this.f8952 = dataInputStream.readShort();
                this.f8945 = (this.f8952 * 28) + 46;
                this.f8947 = new Cif[this.f8952];
                for (int i4 = 0; i4 < this.f8952; i4++) {
                    C1283.m16854("nf_subtitles", "Parsing image " + i4 + " metadata.");
                    this.f8947[i4] = new Cif(dataInputStream);
                    i2++;
                    this.f8947[i4].mo9079(i2);
                    C1283.m16854("nf_subtitles", "Parsing image " + i4 + " metadata done.");
                }
                if (this.f8952 > 0) {
                    this.f8957 = this.f8947[0].mo9071();
                    int length2 = this.f8947.length - 1;
                    this.f8953 = (this.f8947[length2].mo9071() - this.f8957) + ((long) this.f8947[length2].mo9070());
                    return;
                }
                return;
            } else if (bArr[i3] != f8944[i3]) {
                throw new IllegalArgumentException("Identifier  is NOT 'sidx'");
            } else {
                i3++;
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m9091() {
        return this.f8948;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public short m9096() {
        return this.f8952;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC1992mw[] m9090() {
        return this.f8947;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized boolean m9097() {
        return this.f8956;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m9094() {
        this.f8956 = false;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public synchronized boolean m9088() {
        return this.f8946;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m9093(boolean z) {
        this.f8946 = z;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public long m9099() {
        return this.f8957;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public long m9098() {
        return this.f8953;
    }

    public String toString() {
        return "SegmentIndex [mIdentifier=" + this.f8950 + ", mIndexID=" + this.f8955 + ", mDuration=" + this.f8948 + ", mEntryCount=" + ((int) this.f8952) + ", mSize=" + this.f8945 + ", mImages=" + Arrays.toString(this.f8947) + ", mDownloadSegment=" + this.f8956 + ", mSegmentStartPosition=" + this.f8957 + ", mSegmentSize=" + this.f8953 + ", mStartTime=" + this.f8954 + ", mEndTime=" + this.f8949 + "]";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m9095(long j) {
        return ((long) this.f8954) <= j && ((long) this.f8949) > j;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public List<AbstractC1976mg> m9092(long j) {
        ArrayList arrayList = new ArrayList();
        if (m9095(j) && this.f8947 != null) {
            Cif[] ifVarArr = this.f8947;
            for (Cif ifVar : ifVarArr) {
                if (ifVar.mo9083(j)) {
                    arrayList.add(new C1988ms(ifVar));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m9087() {
        return this.f8951;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9089(int i) {
        this.f8951 = i;
    }

    public int hashCode() {
        return ((this.f8951 + 31) * 31) + (this.f8955 == null ? 0 : this.f8955.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1990mu muVar = (C1990mu) obj;
        if (this.f8951 != muVar.f8951) {
            return false;
        }
        if (this.f8955 == null) {
            if (muVar.f8955 != null) {
                return false;
            }
            return true;
        } else if (!this.f8955.equals(muVar.f8955)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: o.mu$if  reason: invalid class name */
    public static class Cif extends AbstractC1989mt {
        private Cif(DataInputStream dataInputStream) {
            this.f8940 = dataInputStream.readInt();
            this.f8937 = dataInputStream.readInt();
            this.f8936 = this.f8940 + this.f8937;
            this.f8935 = dataInputStream.readShort();
            this.f8933 = dataInputStream.readShort();
            this.f8932 = dataInputStream.readShort();
            this.f8930 = dataInputStream.readShort();
            this.f8942 = dataInputStream.readLong();
            this.f8943 = dataInputStream.readInt();
        }

        public String toString() {
            return "ImageDescriptorV1 [mStartTime=" + this.f8940 + ", mDuration=" + this.f8937 + ", mEndTime=" + this.f8936 + ", mOriginX=" + ((int) this.f8935) + ", mOriginY=" + ((int) this.f8933) + ", mWidth=" + ((int) this.f8932) + ", mHeight=" + ((int) this.f8930) + ", mImageStartPosition=" + this.f8942 + ", mSize=" + this.f8943 + ", mLocalImagePath=" + this.f8931 + ", mName=" + this.f8934 + ", mTotalIndex=" + this.f8939 + "]";
        }

        public int hashCode() {
            return this.f8939 + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass() && this.f8939 == ((Cif) obj).f8939) {
                return true;
            }
            return false;
        }
    }
}
