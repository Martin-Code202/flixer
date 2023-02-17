package o;

import android.os.Handler;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.service.player.subtitles.BaseImageSubtitleParser;
import com.netflix.mediaclient.service.player.subtitles.image.v2.SegmentEncryptionInfo;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o.AbstractC1979mj;
/* renamed from: o.mf  reason: case insensitive filesystem */
public class C1975mf extends BaseImageSubtitleParser implements AbstractC1971mb {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected mG f8897;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected mD[] f8898;

    public C1975mf(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, SubtitleUrl subtitleUrl, long j, AbstractC1979mj.iF iFVar, long j2, long j3, AbstractC2055pd pdVar) {
        super(handler, mhVar, mlVar, subtitleUrl, j, iFVar, j2, j3, pdVar);
        C1283.m16854("nf_subtitles_imv2", "Create image V2 based subtitle parser");
    }

    @Override // o.AbstractC1979mj
    public ISubtitleDef.SubtitleProfile D_() {
        return ISubtitleDef.SubtitleProfile.IMAGE_ENC;
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ˎ */
    public void mo7692() {
        mo1134();
        if (m9011()) {
            C1283.m16854("nf_subtitles_imv2", "Sucesfully imported cached data!");
            return;
        }
        C1283.m16854("nf_subtitles_imv2", "Unable to import from cached data, go and start downloading itrk!");
        m9020();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.player.subtitles.BaseImageSubtitleParser
    /* renamed from: ʻ */
    public String mo1134() {
        this.f1976 = mo7687();
        return this.f1976;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m9011() {
        C1283.m16854("nf_subtitles_imv2", "Try to import data from existing cache!");
        if (!m9015()) {
            C1283.m16850("nf_subtitles_imv2", "Failed to parse master index container from cache");
            return false;
        }
        C1283.m16854("nf_subtitles_imv2", "Parsed master index container from cache");
        if (m9018()) {
            C1283.m16854("nf_subtitles_imv2", "Parsed segment index containers from cache");
            C1283.m16854("nf_subtitles_imv2", "Ready to serve subtitles...");
            this.f8870 = true;
            m1139(m9023());
            return true;
        }
        C1283.m16850("nf_subtitles_imv2", "Failed to parse segment index file from cache");
        return false;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m9018() {
        File r3 = this.f8872.mo7759().mo7410(this.f1976, "segment.idx");
        if (r3 == null || !r3.exists()) {
            return false;
        }
        try {
            return m9026(AH.m3345(r3), this.f8897.m8814().m8818());
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles_imv2", "Failed to load and parse segment index from cache", th);
            return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m9015() {
        File r3 = this.f8872.mo7759().mo7410(this.f1976, "master.idx");
        if (r3 == null || !r3.exists()) {
            return false;
        }
        try {
            return m9025(AH.m3345(r3));
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles_imv2", "Failed to load and parse Master index from cache", th);
            return false;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m9020() {
        if (this.f8868 == null || this.f8868.getDownloadUrl() == null) {
            C1283.m16850("nf_subtitles_imv2", "Subtitle data is null!");
            return;
        }
        final String[] r8 = gU.m6607().m6609();
        if (C1349Bv.m4113(this.f8868.getDownloadUrl())) {
            C1283.m16850("nf_subtitles_imv2", "Subtitle URL is empty!");
            m8988("", r8, ISubtitleDef.SubtitleFailure.badMasterIndex, null);
        } else if (this.f8868.getMasterIndexSize() > 0) {
            m8990().mo9302(this.f8868.getDownloadUrl(), AssetType.imageSubtitlesMasterIndex, (long) this.f8868.getMasterIndexOffset(), (long) this.f8868.getMasterIndexSize(), new C2005ni() { // from class: o.mf.4
                @Override // o.C2005ni, o.AbstractC2006nj
                /* renamed from: ˎ */
                public void mo7553(String str, byte[] bArr, Status status) {
                    super.mo7553(str, bArr, status);
                    if (status.mo301()) {
                        if (C1975mf.this.m8988(str, r8, ISubtitleDef.SubtitleFailure.download, status)) {
                            C1975mf.this.m8987(ISubtitleDef.SubtitleFailure.download, status);
                        }
                    } else if (C1975mf.this.m9025(bArr)) {
                        C1975mf.this.m9019();
                    } else if (!C1975mf.this.m8988(str, r8, ISubtitleDef.SubtitleFailure.parsing, null)) {
                        C1975mf.this.m8987(ISubtitleDef.SubtitleFailure.parsing, null);
                    }
                }
            });
        } else if (!m8988(this.f8868.getDownloadUrl(), r8, ISubtitleDef.SubtitleFailure.badMasterIndex, null)) {
            m8987(ISubtitleDef.SubtitleFailure.badMasterIndex, null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m9025(byte[] bArr) {
        C1283.m16854("nf_subtitles_imv2", "Master index received, parse it...");
        boolean z = false;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            this.f8897 = new mG(new mA(dataInputStream), dataInputStream);
            z = true;
            dataInputStream.close();
            byteArrayInputStream.close();
            mo1138("master.idx", bArr);
            return true;
        } catch (Throwable th) {
            if (z) {
                C1283.m16847("nf_subtitles_imv2", "Failed to close master index input stream", th);
                return z;
            }
            C1283.m16847("nf_subtitles_imv2", "Failed to parse master index", th);
            return z;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m9019() {
        C1283.m16854("nf_subtitles_imv2", "Start to download segment indexes");
        final int r8 = this.f8897.m8814().m8818();
        m8990().mo9302(this.f8868.getDownloadUrl(), AssetType.imageSubtitlesSegmentIndex, this.f8897.m8814().m8817(), (long) r8, new C2005ni() { // from class: o.mf.1
            @Override // o.C2005ni, o.AbstractC2006nj
            /* renamed from: ˎ */
            public void mo7553(String str, byte[] bArr, Status status) {
                super.mo7553(str, bArr, status);
                if (!status.mo301()) {
                    C1283.m16854("nf_subtitles_imv2", "Segment indexes received, parse it...");
                    C1975mf.this.m9026(bArr, r8);
                    C1283.m16854("nf_subtitles_imv2", "Ready to serve subtitles...");
                    C1975mf.this.f8870 = true;
                    C1975mf.this.mo1138("segment.idx", bArr);
                    C1975mf.this.m1139(C1975mf.this.m9023());
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.player.subtitles.BaseImageSubtitleParser
    /* renamed from: ˎ */
    public void mo1136(int i) {
        if (i < 0 || this.f8898 == null || i >= this.f8898.length) {
            C1283.m16865("nf_subtitles_imv2", "Invalid index requested!");
            return;
        }
        mI r2 = this.f8898[i].m8805();
        if (r2 == null) {
            C1283.m16850("nf_subtitles_imv2", "Segment index is null, this should NOT happen!");
        } else if (m9012(r2)) {
            r2.m8834(true);
            if (m1135() == BaseImageSubtitleParser.StreamingSubtitleState.UNLOADED) {
                m1137(BaseImageSubtitleParser.StreamingSubtitleState.STREAMING);
                C1283.m16854("nf_subtitles_imv2", "image based subtitle loaded");
                mo7696();
            } else if (m1135() == BaseImageSubtitleParser.StreamingSubtitleState.STALLED) {
                m1137(BaseImageSubtitleParser.StreamingSubtitleState.STREAMING);
                C1283.m16854("nf_subtitles_imv2", "Image based subtitle buffering ended");
                mo7688(this.f1977);
            }
            C1283.m16854("nf_subtitles_imv2", "No need to download segment images, succesfully loaded from cache");
        } else {
            C1283.m16854("nf_subtitles_imv2", "Image(s) missing, go and download...");
            m9013(r2);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m9012(mI mIVar) {
        try {
            AbstractC1992mw[] r4 = mIVar.m8835();
            for (AbstractC1992mw mwVar : r4) {
                File r3 = this.f8872.mo7759().mo7410(this.f1976, mwVar.mo9086());
                if (r3 == null || !r3.exists()) {
                    return false;
                }
                mwVar.mo9080(r3.getAbsolutePath());
            }
            mIVar.m8825();
            return true;
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles_imv2", "Failed to parse segment", th);
            return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m9013(final mI mIVar) {
        if (mIVar == null) {
            C1283.m16850("nf_subtitles_imv2", "Segment is null!");
        } else if (!mIVar.m8823()) {
            C1283.m16865("nf_subtitles_imv2", "Segment is already downloaded");
        } else {
            final String downloadUrl = this.f8868.getDownloadUrl();
            final String decryptionKey = this.f8868.getDecryptionKey();
            mIVar.m8825();
            AbstractC2007nk r10 = m8990();
            if (r10 == null) {
                m8987(ISubtitleDef.SubtitleFailure.download, null);
            } else {
                r10.mo9302(downloadUrl, AssetType.imageSubtitlesSegment, mIVar.m8836(), mIVar.m8826(), new C2005ni() { // from class: o.mf.3
                    @Override // o.C2005ni, o.AbstractC2006nj
                    /* renamed from: ˎ */
                    public void mo7553(String str, byte[] bArr, Status status) {
                        super.mo7553(str, bArr, status);
                        if (status.mo301()) {
                            C1975mf.this.m8987(ISubtitleDef.SubtitleFailure.download, status);
                            return;
                        }
                        C1975mf.this.m9024(bArr, mIVar, downloadUrl, decryptionKey);
                        mIVar.m8834(true);
                        if (C1975mf.this.m1135() == BaseImageSubtitleParser.StreamingSubtitleState.UNLOADED) {
                            C1975mf.this.m1137(BaseImageSubtitleParser.StreamingSubtitleState.STREAMING);
                            C1975mf.this.mo7696();
                        } else if (C1975mf.this.m1135() == BaseImageSubtitleParser.StreamingSubtitleState.STALLED && mIVar.m8828(C1975mf.this.f1977)) {
                            C1975mf.this.m1137(BaseImageSubtitleParser.StreamingSubtitleState.STREAMING);
                            C1283.m16854("nf_subtitles_imv2", "image subtitle buffering complete on " + C1975mf.this.f1977);
                            C1975mf.this.mo7688(mIVar.m8836());
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9024(byte[] bArr, mI mIVar, String str, String str2) {
        if (bArr == null) {
            C1283.m16850("nf_subtitles_imv2", "Response data for segment is NULL");
            return;
        }
        C1283.m16854("nf_subtitles_imv2", "Segment received, parse it...");
        try {
            long r6 = mIVar.m8836();
            for (int i = 0; i < mIVar.m8835().length; i++) {
                AbstractC1992mw mwVar = mIVar.m8835()[i];
                int r10 = (int) (mwVar.mo9071() - r6);
                int r11 = r10 + mwVar.mo9070();
                int r12 = r10 + mwVar.mo9070();
                byte[] r14 = m9022(Arrays.copyOfRange(bArr, r10, r11), mIVar.m8829(), i, str2, mwVar.mo9084());
                if (r14 != null) {
                    mwVar.mo9080(this.f8872.mo7759().mo7412(this.f1976, mwVar.mo9086(), r14));
                }
            }
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles_imv2", "Failed to parse segment", th);
            m8988(str, gU.m6607().m6609(), ISubtitleDef.SubtitleFailure.parsing, null);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private byte[] m9022(byte[] bArr, mD mDVar, int i, String str, int i2) {
        try {
            SegmentEncryptionInfo.C0022 r2 = mDVar.m8806(i);
            return mC.m8801(r2).mo8807(bArr, r2, str, i2);
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles_imv2", "Failed to decrypt image", th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m9026(byte[] bArr, int i) {
        if (bArr == null) {
            C1283.m16850("nf_subtitles_imv2", "Response data for segment indexes is NULL");
            return false;
        }
        if (bArr.length != i) {
            C1283.m16850("nf_subtitles_imv2", "Size mismatch!");
            if (bArr.length < i) {
                C1283.m16850("nf_subtitles_imv2", "Not enough data, abort parsing");
                return false;
            }
            C1283.m16865("nf_subtitles_imv2", "More data than expected, start parsing...");
        } else {
            C1283.m16854("nf_subtitles_imv2", "Expected data, start parsing...");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        int r5 = this.f8897.m8814().m8819();
        this.f8898 = new mD[r5];
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 0; i4 < r5; i4++) {
            try {
                mD mDVar = new mD(new mA(dataInputStream), i2, i3, dataInputStream);
                this.f8898[i4] = mDVar;
                i2 += mDVar.m8805().m8827();
                i3 += mDVar.m8805().m8832();
                mDVar.m8805().m8833(i4);
            } catch (Throwable th) {
                if (0 != 0) {
                    C1283.m16847("nf_subtitles_imv2", "Failed to close segment indexes input stream", th);
                    return false;
                }
                C1283.m16847("nf_subtitles_imv2", "Failed to parse segment index", th);
                return false;
            }
        }
        dataInputStream.close();
        byteArrayInputStream.close();
        return true;
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ˏ */
    public C1987mr mo8732(long j) {
        this.f1977 = j;
        List<AbstractC1976mg> list = null;
        mI r8 = m9017(j);
        if (r8 != null) {
            list = r8.m8831(j);
            m9021(r8);
            if (!r8.m8824()) {
                C1283.m16854("nf_subtitles_imv2", "current segment is not donwloaded, start buffering");
                if (m1135() == BaseImageSubtitleParser.StreamingSubtitleState.STREAMING) {
                    m1137(BaseImageSubtitleParser.StreamingSubtitleState.STALLED);
                    mo7695();
                }
            }
        } else {
            C1283.m16854("nf_subtitles_imv2", "Segment not found");
        }
        return new C1987mr(this, list, null, 2000, j);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m9021(mI mIVar) {
        if (mIVar != null) {
            if (mIVar.m8823()) {
                C1283.m16854("nf_subtitles_imv2", "Current segment is not downloaded yet, go and fetch current range (this and next segment)...");
                m1139(mIVar.m8830());
                return;
            }
            C1283.m16854("nf_subtitles_imv2", "Current segment is not downloaded, go and fetch next range (2 segments after current one)...");
            m1139(mIVar.m8830() + 1);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private mI m9017(long j) {
        int i = this.f8875;
        if (i < 0) {
            i = 0;
        }
        if (this.f8898 == null) {
            C1283.m16854("nf_subtitles_imv2", "Indexes not available yet!");
            return null;
        }
        for (int i2 = i; i2 < this.f8898.length; i2++) {
            mD mDVar = this.f8898[i2];
            if (mDVar != null && mDVar.m8805() != null && mDVar.m8805().m8828(j)) {
                this.f8875 = i2;
                return mDVar.m8805();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    private int m9023() {
        if (this.f8898 == null) {
            C1283.m16854("nf_subtitles_imv2", "Indexes not available yet!");
            return 0;
        }
        for (int i = 0; i < this.f8898.length; i++) {
            if (!(this.f8898[i] == null || this.f8898[i].m8805() == null || !this.f8898[i].m8805().m8828(this.f1977))) {
                return i;
            }
        }
        return 0;
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ॱᐝ */
    public synchronized int mo8737() {
        if (this.f8875 == -1) {
            return this.f8876;
        }
        int i = 0;
        ArrayList arrayList = new ArrayList();
        if (this.f8898 != null) {
            for (int i2 = 0; i2 < this.f8898.length; i2++) {
                AbstractC1992mw[] r8 = this.f8898[i2].m8805().m8835();
                for (AbstractC1992mw mwVar : r8) {
                    if (mwVar.mo9074(this.f8869, this.f8871) && !arrayList.contains(mwVar)) {
                        arrayList.add(mwVar);
                        i++;
                    }
                }
            }
        }
        return this.f8876 + i;
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ʻॱ */
    public synchronized int mo8727() {
        int i;
        i = 0;
        new ArrayList();
        if (this.f8898 != null) {
            for (int i2 = 0; i2 < this.f8898.length; i2++) {
                for (AbstractC1992mw mwVar : this.f8898[i2].m8805().m8835()) {
                    i += mwVar.mo9075();
                }
            }
        }
        return i;
    }

    @Override // o.AbstractC1970ma, o.AbstractC1979mj
    /* renamed from: ˏ */
    public void mo8733(int i) {
        super.mo8733(i);
        this.f1977 = (long) i;
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        if (this.f8898 != null) {
            for (int i3 = 0; i3 < this.f8898.length; i3++) {
                AbstractC1992mw[] r8 = this.f8898[i3].m8805().m8835();
                for (AbstractC1992mw mwVar : r8) {
                    if (mwVar.mo9074(this.f8869, this.f8871) && !arrayList.contains(mwVar)) {
                        arrayList.add(mwVar);
                        i2++;
                        mwVar.mo9073((long) i);
                    }
                }
            }
        }
        this.f8876 += i2;
        this.f8869 = (long) i;
        m9021(m9017(this.f1977));
    }

    @Override // o.AbstractC1971mb
    /* renamed from: ˊॱ */
    public short mo8991() {
        if (this.f8897 == null || this.f8897.m8815() == null) {
            return 0;
        }
        return this.f8897.m8815().m8810();
    }

    @Override // o.AbstractC1971mb
    /* renamed from: ॱˊ */
    public short mo8992() {
        if (this.f8897 == null || this.f8897.m8815() == null) {
            return 0;
        }
        return this.f8897.m8815().m8809();
    }
}
