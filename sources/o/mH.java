package o;

import java.io.DataInputStream;
import java.util.Arrays;
public class mH extends AbstractC1994my {

    /* renamed from: ʻ  reason: contains not printable characters */
    private iF[] f8702;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f8703;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f8704;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f8705;

    public mH(mA mAVar, DataInputStream dataInputStream) {
        super(mAVar, dataInputStream);
        if (!m8800().m8797()) {
            throw new IllegalStateException("MasterIndex is supposed to be extended type!");
        } else if (!m8800().m8798("com.netflix.midx")) {
            throw new IllegalStateException("MasterIndex does not have expected user type value!");
        } else {
            this.f8703 = dataInputStream.readLong();
            this.f8704 = dataInputStream.readInt();
            this.f8702 = new iF[this.f8704];
            long j = this.f8703;
            for (int i = 0; i < this.f8704; i++) {
                this.f8702[i] = new iF(dataInputStream, j);
                j += (long) this.f8702[i].m8820();
                this.f8705 += this.f8702[i].m8821();
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public long m8817() {
        return this.f8703;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m8819() {
        return this.f8704;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m8818() {
        return this.f8705;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m8816(mA mAVar) {
        if (mAVar != null) {
            return "com.netflix.midx".equals(mAVar.m8796());
        }
        throw new IllegalStateException("Header is null!");
    }

    public static class iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean f8706 = true;

        /* renamed from: ˋ  reason: contains not printable characters */
        private long f8707;

        /* renamed from: ˎ  reason: contains not printable characters */
        private mD f8708;

        /* renamed from: ˏ  reason: contains not printable characters */
        private int f8709;

        /* renamed from: ॱ  reason: contains not printable characters */
        private short f8710;

        public iF(DataInputStream dataInputStream, long j) {
            this.f8709 = dataInputStream.readInt();
            this.f8710 = dataInputStream.readShort();
            this.f8707 = j;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public int m8820() {
            return this.f8709;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public short m8821() {
            return this.f8710;
        }

        public String toString() {
            return "SegmentDescriptor{duration=" + this.f8709 + ", size=" + ((int) this.f8710) + ", startOffset=" + this.f8707 + ", segment=" + this.f8708 + ", downloadSegment=" + this.f8706 + '}';
        }
    }

    @Override // o.AbstractC1994my, o.mB
    public String toString() {
        return "MasterIndex{segmentOffset=" + this.f8703 + ", segmentCount=" + this.f8704 + ", segments=" + Arrays.toString(this.f8702) + ", segmentIndexesSize=" + this.f8705 + "} " + super.toString();
    }
}
