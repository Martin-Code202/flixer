package o;

import java.io.DataInputStream;
import java.util.Arrays;
import java.util.UUID;
/* renamed from: o.mv  reason: case insensitive filesystem */
public class C1991mv {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final byte[] f8958 = {109, 105, 100, 120};

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f8959;

    /* renamed from: ʼ  reason: contains not printable characters */
    private short f8960;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f8961;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f8962;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private short f8963;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f8964;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f8965;

    /* renamed from: ˏ  reason: contains not printable characters */
    private UUID f8966;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private long f8967;

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f8968;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f8969;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private int f8970;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f8971;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private Cif[] f8972;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private short f8973;

    public C1991mv(DataInputStream dataInputStream) {
        if (dataInputStream == null) {
            throw new IllegalArgumentException("Master index is null!");
        }
        byte[] bArr = {dataInputStream.readByte(), dataInputStream.readByte(), dataInputStream.readByte(), dataInputStream.readByte()};
        int i = 0;
        while (true) {
            int length = bArr.length;
            if (i >= 4) {
                this.f8969 = (bArr[0] << 24) | (bArr[1] << 16) | (bArr[2] << 8) | bArr[3];
                this.f8962 = dataInputStream.readInt();
                byte[] bArr2 = new byte[36];
                dataInputStream.read(bArr2);
                this.f8966 = UUID.fromString(new String(bArr2));
                this.f8964 = dataInputStream.readLong();
                this.f8959 = dataInputStream.readLong();
                this.f8961 = dataInputStream.readLong();
                this.f8960 = dataInputStream.readShort();
                this.f8973 = dataInputStream.readShort();
                byte[] bArr3 = new byte[16];
                dataInputStream.read(bArr3);
                this.f8971 = new String(bArr3);
                byte[] bArr4 = new byte[16];
                dataInputStream.read(bArr4);
                this.f8968 = new String(bArr4);
                this.f8967 = dataInputStream.readLong();
                this.f8963 = dataInputStream.readShort();
                this.f8972 = new Cif[this.f8963];
                this.f8965 = (this.f8963 * 6) + 114;
                long j = this.f8967;
                for (int i2 = 0; i2 < this.f8963; i2++) {
                    this.f8972[i2] = new Cif(dataInputStream, j);
                    j += (long) this.f8972[i2].m9106();
                    this.f8970 += this.f8972[i2].f8974;
                }
                return;
            } else if (bArr[i] != f8958[i]) {
                throw new IllegalArgumentException("Identifier  is NOT 'midx'");
            } else {
                i++;
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public short m9104() {
        return this.f8960;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public short m9103() {
        return this.f8973;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public long m9102() {
        return this.f8967;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public short m9101() {
        return this.f8963;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m9100() {
        return this.f8970;
    }

    public String toString() {
        return "MasterIndex [mIdentifier=" + this.f8969 + ", mVersion=" + this.f8962 + ", mIndexID=" + this.f8966 + ", mCreationTime=" + this.f8964 + ", mPackageID=" + this.f8959 + ", mMovieID=" + this.f8961 + ", mRootContainerExtentX=" + ((int) this.f8960) + ", mRootContainerExtentY=" + ((int) this.f8973) + ", mLanguageCode=" + this.f8971 + ", mTextType=" + this.f8968 + ", mStartOffset=" + this.f8967 + ", mEntryCount=" + ((int) this.f8963) + ", mSize=" + this.f8965 + ", mSegmentIndexesSize=" + this.f8970 + ", mSegments=" + Arrays.toString(this.f8972) + "]";
    }

    /* renamed from: o.mv$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        private short f8974;

        /* renamed from: ˋ  reason: contains not printable characters */
        private C1990mu f8975;

        /* renamed from: ˎ  reason: contains not printable characters */
        private long f8976;

        /* renamed from: ˏ  reason: contains not printable characters */
        private int f8977;

        /* renamed from: ॱ  reason: contains not printable characters */
        private boolean f8978 = true;

        public Cif(DataInputStream dataInputStream, long j) {
            this.f8977 = dataInputStream.readInt();
            this.f8974 = dataInputStream.readShort();
            this.f8976 = j;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public int m9106() {
            return this.f8977;
        }

        public String toString() {
            return "SegmentDesciptor [mDuration=" + this.f8977 + ", mSize=" + ((int) this.f8974) + ", mStartOffset=" + this.f8976 + ", mSegment=" + this.f8975 + ", mDownloadSegment=" + this.f8978 + "]";
        }
    }
}
