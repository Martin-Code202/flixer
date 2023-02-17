package o;

import com.netflix.mediaclient.service.player.subtitles.image.v2.SegmentEncryptionInfo;
import java.io.DataInputStream;
public class mD extends mB {

    /* renamed from: ˋ  reason: contains not printable characters */
    private mI f8689;

    /* renamed from: ˎ  reason: contains not printable characters */
    private SegmentEncryptionInfo f8690;

    public mD(mA mAVar, int i, int i2, DataInputStream dataInputStream) {
        super(mAVar);
        if (!m8800().m8798("com.netflix.iseg")) {
            throw new IllegalStateException("ISCSegment does not have expected user type value!");
        }
        m8802(dataInputStream, i, i2);
        m8804();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8802(DataInputStream dataInputStream, int i, int i2) {
        try {
            long j = m8800().f8685;
            boolean z = true;
            while (z) {
                j -= m8803(dataInputStream, i, i2);
                z = j > 0;
            }
            C1283.m16854("nf_subtitles_imv2", "Clean exit for loadBoxes...");
        } catch (Throwable th) {
            C1283.m16855("nf_subtitles_imv2", "Either error or we do not have anything else to read!", th);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m8804() {
        if (this.f8689 == null) {
            throw new IllegalStateException("Segment index is missing!");
        } else if (this.f8690 == null) {
            C1283.m16854("nf_subtitles_imv2", "Encrypted info not found!");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private long m8803(DataInputStream dataInputStream, int i, int i2) {
        mA mAVar = new mA(dataInputStream);
        if (mI.m8822(mAVar)) {
            if (this.f8689 != null) {
                C1283.m16850("nf_subtitles_imv2", "We found segment index and it already exist!");
            }
            this.f8689 = new mI(mAVar, i, i2, dataInputStream, this);
            return this.f8689.m8800().m8795();
        } else if (SegmentEncryptionInfo.m1150(mAVar)) {
            if (this.f8690 != null) {
                C1283.m16850("nf_subtitles_imv2", "We found segment encryption info and it already exist!");
            }
            this.f8690 = new SegmentEncryptionInfo(mAVar, dataInputStream);
            return this.f8690.m8800().m8795();
        } else {
            long r9 = mAVar.m8799();
            long r7 = mAVar.m8795();
            dataInputStream.skip(r9);
            return r7;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public mI m8805() {
        return this.f8689;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public SegmentEncryptionInfo.C0022 m8806(int i) {
        if (this.f8690 == null) {
            C1283.m16854("nf_subtitles_imv2", "Segment encryption info is null, no encryption.");
            return null;
        } else if (this.f8690.m1151() == null || this.f8690.m1151().length < 1) {
            C1283.m16854("nf_subtitles_imv2", "Segment encryption info not found, no encryption.");
            return null;
        } else if (this.f8690.m1151().length <= i) {
            return null;
        } else {
            return this.f8690.m1151()[i];
        }
    }

    @Override // o.mB
    public String toString() {
        return "ISCSegment{segmentIndex=" + this.f8689 + ", segmentEncryptionInfo=" + this.f8690 + "} " + super.toString();
    }
}
