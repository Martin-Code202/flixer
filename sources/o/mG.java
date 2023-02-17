package o;

import java.io.DataInputStream;
public class mG extends mB {

    /* renamed from: ˋ  reason: contains not printable characters */
    private mH f8699;

    /* renamed from: ˎ  reason: contains not printable characters */
    private mF f8700;

    /* renamed from: ˏ  reason: contains not printable characters */
    private mL f8701;

    public mG(mA mAVar, DataInputStream dataInputStream) {
        super(mAVar);
        if (!m8800().m8798("com.netflix.itrk")) {
            throw new IllegalStateException("ISCTrack does not have expected user type value!");
        }
        m8811(dataInputStream);
        C1283.m16854("nf_subtitles_imv2", "All boxes loaded...");
        m8812();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m8811(DataInputStream dataInputStream) {
        try {
            long j = m8800().f8685;
            boolean z = true;
            while (z) {
                j -= m8813(dataInputStream);
                z = j > 0;
            }
            C1283.m16854("nf_subtitles_imv2", "Clean exit for loadBoxes...");
        } catch (Throwable th) {
            C1283.m16855("nf_subtitles_imv2", "Either error or we do not have anything else to read!", th);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private long m8813(DataInputStream dataInputStream) {
        mA mAVar = new mA(dataInputStream);
        if (mF.m8808(mAVar)) {
            if (this.f8700 != null) {
                C1283.m16850("nf_subtitles_imv2", "We found ISC header and it already exist!");
            }
            this.f8700 = new mF(mAVar, dataInputStream);
            return this.f8700.m8800().m8795();
        } else if (mL.m8846(mAVar)) {
            if (this.f8701 != null) {
                C1283.m16850("nf_subtitles_imv2", "We found version info and it already exist!");
            }
            this.f8701 = new mL(mAVar, dataInputStream);
            return this.f8701.m8800().m8795();
        } else if (mH.m8816(mAVar)) {
            if (this.f8699 != null) {
                C1283.m16850("nf_subtitles_imv2", "We found master index and it already exist!");
            }
            this.f8699 = new mH(mAVar, dataInputStream);
            return this.f8699.m8800().m8795();
        } else {
            long r5 = mAVar.m8799();
            long r3 = mAVar.m8795();
            dataInputStream.skip(r5);
            return r3;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8812() {
        if (this.f8700 == null) {
            throw new IllegalStateException("ISCHeader is missing!");
        } else if (this.f8701 == null) {
            throw new IllegalStateException("VersionInfo is missing!");
        } else if (this.f8699 == null) {
            throw new IllegalStateException("MasterIndex is missing!");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public mF m8815() {
        return this.f8700;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public mH m8814() {
        return this.f8699;
    }

    @Override // o.mB
    public String toString() {
        return "ISCTrack{iscHeader=" + this.f8700 + ", versionInfo=" + this.f8701 + ", masterIndex=" + this.f8699 + "} " + super.toString();
    }
}
