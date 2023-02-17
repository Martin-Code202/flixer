package o;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
public class mI extends AbstractC1994my {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f8711;

    /* renamed from: ʼ  reason: contains not printable characters */
    private long f8712;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f8713;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f8714;

    /* renamed from: ˋ  reason: contains not printable characters */
    private UUID f8715;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private AbstractC1992mw[] f8716;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f8717;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f8718;

    /* renamed from: ͺ  reason: contains not printable characters */
    private mD f8719;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private int f8720;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f8721 = true;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f8722 = false;

    public mI(mA mAVar, int i, int i2, DataInputStream dataInputStream, mD mDVar) {
        super(mAVar, dataInputStream);
        if (!m8800().m8798("com.netflix.sidx")) {
            throw new IllegalStateException("SegmentIndex does not have expected user type value!");
        }
        this.f8719 = mDVar;
        this.f8715 = mK.m8838(dataInputStream);
        this.f8717 = dataInputStream.readInt();
        this.f8711 = dataInputStream.readInt();
        this.f8720 = i;
        this.f8714 = this.f8720 + this.f8717;
        this.f8716 = new Cif[this.f8711];
        for (int i3 = 0; i3 < this.f8711; i3++) {
            C1283.m16854("nf_subtitles_imv2", "Parsing image " + i3 + " metadata.");
            this.f8716[i3] = new Cif(dataInputStream);
            i2++;
            this.f8716[i3].mo9079(i2);
            C1283.m16854("nf_subtitles_imv2", "Parsing image " + i3 + " metadata done.");
        }
        if (this.f8711 > 0) {
            this.f8713 = this.f8716[0].mo9071();
            int length = this.f8716.length - 1;
            this.f8712 = (this.f8716[length].mo9071() - this.f8713) + ((long) this.f8716[length].mo9070());
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m8827() {
        return this.f8717;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m8832() {
        return this.f8711;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public long m8826() {
        return this.f8712;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m8830() {
        return this.f8718;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8833(int i) {
        this.f8718 = i;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public AbstractC1992mw[] m8835() {
        return this.f8716;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public synchronized boolean m8823() {
        return this.f8721;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public synchronized boolean m8824() {
        return this.f8722;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public synchronized void m8825() {
        this.f8721 = false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m8834(boolean z) {
        this.f8722 = z;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public long m8836() {
        return this.f8713;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m8828(long j) {
        return ((long) this.f8720) <= j && ((long) this.f8714) > j;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public List<AbstractC1976mg> m8831(long j) {
        ArrayList arrayList = new ArrayList();
        if (m8828(j) && this.f8716 != null) {
            AbstractC1992mw[] mwVarArr = this.f8716;
            for (AbstractC1992mw mwVar : mwVarArr) {
                if (mwVar.mo9083(j)) {
                    arrayList.add(new C1988ms(mwVar));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public mD m8829() {
        return this.f8719;
    }

    @Override // o.AbstractC1994my, o.mB
    public String toString() {
        return "SegmentIndex{assetID=" + this.f8715 + ", duration=" + this.f8717 + ", sampleCount=" + this.f8711 + ", mDownloadSegment=" + this.f8721 + ", mSegmentStartPosition=" + this.f8713 + ", mSegmentSize=" + this.f8712 + ", mIndex=" + this.f8718 + ", mStartTime=" + this.f8720 + ", mEndTime=" + this.f8714 + ", mImages=" + Arrays.toString(this.f8716) + "} " + super.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        mI mIVar = (mI) obj;
        if (this.f8718 != mIVar.f8718) {
            return false;
        }
        if (this.f8715 == null) {
            if (mIVar.f8715 != null) {
                return false;
            }
            return true;
        } else if (!this.f8715.equals(mIVar.f8715)) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return ((this.f8718 + 31) * 31) + (this.f8715 == null ? 0 : this.f8715.hashCode());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m8822(mA mAVar) {
        if (mAVar != null) {
            return "com.netflix.sidx".equals(mAVar.m8796());
        }
        throw new IllegalStateException("Header is null!");
    }

    /* renamed from: o.mI$if  reason: invalid class name */
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
            return "ImageDescriptorV2 [mStartTime=" + this.f8940 + ", mDuration=" + this.f8937 + ", mEndTime=" + this.f8936 + ", mOriginX=" + ((int) this.f8935) + ", mOriginY=" + ((int) this.f8933) + ", mWidth=" + ((int) this.f8932) + ", mHeight=" + ((int) this.f8930) + ", mImageStartPosition=" + this.f8942 + ", mSize=" + this.f8943 + ", mLocalImagePath=" + this.f8931 + ", mName=" + this.f8934 + ", mTotalIndex=" + this.f8939 + "]";
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
