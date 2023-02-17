package o;

import android.os.Handler;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.service.player.subtitles.BaseImageSubtitleParser;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o.AbstractC1979mj;
/* renamed from: o.mc  reason: case insensitive filesystem */
public class C1972mc extends BaseImageSubtitleParser implements AbstractC1971mb {

    /* renamed from: ˏ  reason: contains not printable characters */
    protected C1991mv f8880;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected C1990mu[] f8881;

    public C1972mc(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, SubtitleUrl subtitleUrl, long j, AbstractC1979mj.iF iFVar, long j2, long j3, AbstractC2055pd pdVar) {
        super(handler, mhVar, mlVar, subtitleUrl, j, iFVar, j2, j3, pdVar);
        C1283.m16854("nf_subtitles", "Create image based subtitle parser");
    }

    @Override // o.AbstractC1979mj
    public ISubtitleDef.SubtitleProfile D_() {
        return ISubtitleDef.SubtitleProfile.IMAGE;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.player.subtitles.BaseImageSubtitleParser
    /* renamed from: ʻ */
    public String mo1134() {
        this.f1976 = mo7687();
        return this.f1976;
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ˎ */
    public void mo7692() {
        mo1134();
        if (!mo7691()) {
            m8995();
        } else {
            C1283.m16854("nf_subtitles", "Succesfully loaded master index.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public boolean mo7691() {
        C1283.m16854("nf_subtitles", "Try to import data from existing cache!");
        if (!mo7689()) {
            C1283.m16850("nf_subtitles", "Failed to parse master index file from cache");
            return false;
        }
        C1283.m16854("nf_subtitles", "Parsed master index file from cache");
        if (mo7694()) {
            C1283.m16854("nf_subtitles", "Parsed segment index file from cache. Ready to serve subtitles...");
            this.f8870 = true;
            int r5 = m9001();
            C1283.m16851("nf_subtitles", "Download segment %d on start", Integer.valueOf(r5));
            m1139(r5);
            return true;
        }
        C1283.m16850("nf_subtitles", "Failed to parse segment index file from cache");
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public boolean mo7694() {
        File r5 = this.f8872.mo7759().mo7410(this.f1976, "segment.idx");
        if (r5 == null || !r5.exists()) {
            return false;
        }
        try {
            C1283.m16851("nf_subtitles", "Reading segment index file from cache %s", r5.getAbsolutePath());
            m9000(AH.m3345(r5), this.f8880.m9100());
            C1283.m16851("nf_subtitles", "Loaded segment index file from cache %s", r5.getAbsolutePath());
            return true;
        } catch (Throwable th) {
            C1283.m16856("nf_subtitles", th, "Failed to load and parse Master index from cache", new Object[0]);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public boolean mo7689() {
        File r5 = this.f8872.mo7759().mo7410(this.f1976, "master.idx");
        if (r5 == null || !r5.exists()) {
            return false;
        }
        try {
            C1283.m16851("nf_subtitles", "Reading master index file from cache %s", r5.getAbsolutePath());
            boolean r7 = m9002(AH.m3345(r5));
            C1283.m16851("nf_subtitles", "Loading master index file from cache %s was success %b", r5.getAbsolutePath(), Boolean.valueOf(r7));
            return r7;
        } catch (Throwable th) {
            C1283.m16856("nf_subtitles", th, "Failed to load and parse Master index from cache", new Object[0]);
            return false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8995() {
        if (this.f8868 == null || this.f8868.getDownloadUrl() == null) {
            C1283.m16850("nf_subtitles", "Subtitle data is null!");
            return;
        }
        final String[] r8 = gU.m6607().m6609();
        if (C1349Bv.m4113(this.f8868.getDownloadUrl())) {
            C1283.m16850("nf_subtitles", "Subtitle URL is empty!");
            if (!m8988("", r8, ISubtitleDef.SubtitleFailure.badMasterIndex, null)) {
                m8987(ISubtitleDef.SubtitleFailure.badMasterIndex, (Status) null);
            }
        } else if (this.f8868.getMasterIndexSize() <= 0) {
            C1283.m16844("nf_subtitles", "Subtitle master index size is wrong %d", Integer.valueOf(this.f8868.getMasterIndexSize()));
            if (!m8988(this.f8868.getDownloadUrl(), r8, ISubtitleDef.SubtitleFailure.badMasterIndex, null)) {
                m8987(ISubtitleDef.SubtitleFailure.badMasterIndex, (Status) null);
            }
        } else {
            m8990().mo9302(this.f8868.getDownloadUrl(), AssetType.imageSubtitlesMasterIndex, (long) this.f8868.getMasterIndexOffset(), (long) this.f8868.getMasterIndexSize(), new C2005ni() { // from class: o.mc.1
                @Override // o.C2005ni, o.AbstractC2006nj
                /* renamed from: ˎ */
                public void mo7553(String str, byte[] bArr, Status status) {
                    super.mo7553(str, bArr, status);
                    if (status.mo301()) {
                        if (!C1972mc.this.m8988(str, r8, ISubtitleDef.SubtitleFailure.download, status)) {
                            C1972mc.this.m8987(ISubtitleDef.SubtitleFailure.download, status);
                        }
                    } else if (C1972mc.this.m9002(bArr)) {
                        C1972mc.this.m8998();
                    } else if (!C1972mc.this.m8988(str, r8, ISubtitleDef.SubtitleFailure.parsing, null)) {
                        C1972mc.this.m8987(ISubtitleDef.SubtitleFailure.parsing, (Status) null);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m9002(byte[] bArr) {
        C1283.m16854("nf_subtitles", "Master index received, parse it...");
        boolean z = false;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            this.f8880 = new C1991mv(dataInputStream);
            z = true;
            dataInputStream.close();
            byteArrayInputStream.close();
            mo1138("master.idx", bArr);
            return true;
        } catch (Throwable th) {
            if (z) {
                C1283.m16856("nf_subtitles", th, "Failed to close master index input stream", new Object[0]);
                return z;
            }
            C1283.m16856("nf_subtitles", th, "Failed to parse master index", new Object[0]);
            return z;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m8998() {
        C1283.m16854("nf_subtitles", "Start to download segment indexes");
        final int r8 = this.f8880.m9100();
        m8990().mo9302(this.f8868.getDownloadUrl(), AssetType.imageSubtitlesSegmentIndex, this.f8880.m9102(), (long) r8, new C2005ni() { // from class: o.mc.5
            @Override // o.C2005ni, o.AbstractC2006nj
            /* renamed from: ˎ */
            public void mo7553(String str, byte[] bArr, Status status) {
                super.mo7553(str, bArr, status);
                if (!status.mo301()) {
                    C1283.m16854("nf_subtitles", "Segment indexes received, parse it...");
                    C1972mc.this.m9000(bArr, r8);
                    C1283.m16854("nf_subtitles", "Ready to serve subtitles...");
                    C1972mc.this.f8870 = true;
                    C1972mc.this.mo1138("segment.idx", bArr);
                    int r5 = C1972mc.this.m9001();
                    C1283.m16851("nf_subtitles", "Download segment %d on start", Integer.valueOf(r5));
                    C1972mc.this.m1139(r5);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.player.subtitles.BaseImageSubtitleParser
    /* renamed from: ˎ */
    public void mo1136(int i) {
        C1283.m16851("nf_subtitles", "Download segment %d if needed", Integer.valueOf(i));
        if (i < 0 || this.f8881 == null || i >= this.f8881.length) {
            C1283.m16865("nf_subtitles", "Invalid index requested!");
            return;
        }
        C1990mu muVar = this.f8881[i];
        if (muVar == null) {
            C1283.m16850("nf_subtitles", "Segment index is null, this should NOT happen!");
        } else if (mo7690(muVar)) {
            muVar.m9093(true);
            if (m1135() == BaseImageSubtitleParser.StreamingSubtitleState.UNLOADED) {
                m1137(BaseImageSubtitleParser.StreamingSubtitleState.STREAMING);
                C1283.m16854("nf_subtitles", "image based subtitle loaded");
                mo7696();
            } else if (m1135() == BaseImageSubtitleParser.StreamingSubtitleState.STALLED) {
                m1137(BaseImageSubtitleParser.StreamingSubtitleState.STREAMING);
                C1283.m16854("nf_subtitles", "Image based subtitle buffering ended");
                mo7688(this.f1977);
            }
            C1283.m16854("nf_subtitles", "No need to download segment images, succesfully loaded from cache");
        } else {
            C1283.m16854("nf_subtitles", "Image(s) missing, go and download...");
            m8994(muVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public boolean mo7690(C1990mu muVar) {
        try {
            AbstractC1992mw[] r4 = muVar.m9090();
            for (AbstractC1992mw mwVar : r4) {
                File r3 = this.f8872.mo7759().mo7410(this.f1976, mwVar.mo9086());
                if (r3 == null || !r3.exists()) {
                    return false;
                }
                mwVar.mo9080(r3.getAbsolutePath());
            }
            muVar.m9094();
            return true;
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles", "Failed to parse segment", th);
            return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m8994(final C1990mu muVar) {
        if (muVar == null) {
            C1283.m16850("nf_subtitles", "Segment is null!");
        } else if (!muVar.m9097()) {
            C1283.m16865("nf_subtitles", "Segment is already downloaded");
        } else {
            muVar.m9094();
            AbstractC2007nk r8 = m8990();
            if (r8 == null) {
                m8987(ISubtitleDef.SubtitleFailure.download, (Status) null);
            } else {
                r8.mo9302(this.f8868.getDownloadUrl(), AssetType.imageSubtitlesSegment, muVar.m9099(), muVar.m9098(), new C2005ni() { // from class: o.mc.2
                    @Override // o.C2005ni, o.AbstractC2006nj
                    /* renamed from: ˎ */
                    public void mo7553(String str, byte[] bArr, Status status) {
                        super.mo7553(str, bArr, status);
                        if (status.mo301()) {
                            C1972mc.this.m8987(ISubtitleDef.SubtitleFailure.download, status);
                            return;
                        }
                        muVar.m9093(true);
                        C1972mc.this.m8999(bArr, muVar);
                        if (C1972mc.this.m1135() == BaseImageSubtitleParser.StreamingSubtitleState.UNLOADED) {
                            C1972mc.this.m1137(BaseImageSubtitleParser.StreamingSubtitleState.STREAMING);
                            C1283.m16854("nf_subtitles", "image subtitle loaded");
                            C1972mc.this.mo7696();
                        } else if (C1972mc.this.m1135() == BaseImageSubtitleParser.StreamingSubtitleState.STALLED && muVar.m9095(C1972mc.this.f1977)) {
                            C1972mc.this.m1137(BaseImageSubtitleParser.StreamingSubtitleState.STREAMING);
                            C1283.m16854("nf_subtitles", "image subtitle buffering complete on " + C1972mc.this.f1977);
                            C1972mc.this.mo7688(muVar.m9099());
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8999(byte[] bArr, C1990mu muVar) {
        if (bArr == null) {
            C1283.m16850("nf_subtitles", "Response data for segment is NULL");
            return;
        }
        C1283.m16854("nf_subtitles", "Segment received, parse it...");
        try {
            long r3 = muVar.m9099();
            AbstractC1992mw[] r5 = muVar.m9090();
            for (AbstractC1992mw mwVar : r5) {
                int r9 = (int) (mwVar.mo9071() - r3);
                mwVar.mo9080(this.f8872.mo7759().mo7412(this.f1976, mwVar.mo9086(), Arrays.copyOfRange(bArr, r9, r9 + mwVar.mo9070())));
            }
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles", "Failed to parse segment", th);
            m8988(this.f8868.getDownloadUrl(), gU.m6607().m6609(), ISubtitleDef.SubtitleFailure.parsing, null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9000(byte[] bArr, int i) {
        if (bArr == null) {
            C1283.m16850("nf_subtitles", "Response data for segment indexes is NULL");
            return;
        }
        if (bArr.length != i) {
            C1283.m16850("nf_subtitles", "Size mismatch!");
            if (bArr.length < i) {
                C1283.m16850("nf_subtitles", "Not enough data, abort parsing");
                return;
            }
            C1283.m16865("nf_subtitles", "More data than expected, start parsing...");
        } else {
            C1283.m16854("nf_subtitles", "Expected data, start parsing...");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        this.f8881 = new C1990mu[this.f8880.m9101()];
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f8880.m9101(); i4++) {
            try {
                C1990mu muVar = new C1990mu(dataInputStream, i2, i3);
                this.f8881[i4] = muVar;
                i2 += muVar.m9091();
                i3 += muVar.m9096();
                muVar.m9089(i4);
            } catch (Throwable th) {
                if (0 != 0) {
                    C1283.m16847("nf_subtitles", "Failed to close segment indexes input stream", th);
                    return;
                } else {
                    C1283.m16847("nf_subtitles", "Failed to parse segment index", th);
                    return;
                }
            }
        }
        dataInputStream.close();
        byteArrayInputStream.close();
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ˏ */
    public C1987mr mo8732(long j) {
        this.f1977 = j;
        List<AbstractC1976mg> list = null;
        C1990mu r8 = m8997(j);
        if (r8 != null) {
            list = r8.m9092(j);
            m8993(r8);
            if (!r8.m9088()) {
                C1283.m16854("nf_subtitles", "current segment is not downloaded, start buffering");
                if (m1135() == BaseImageSubtitleParser.StreamingSubtitleState.STREAMING) {
                    m1137(BaseImageSubtitleParser.StreamingSubtitleState.STALLED);
                    mo7695();
                }
            }
        } else {
            C1283.m16854("nf_subtitles", "Segment not found");
        }
        return new C1987mr(this, list, null, 2000, j);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8993(C1990mu muVar) {
        if (muVar != null) {
            if (muVar.m9097()) {
                C1283.m16854("nf_subtitles", "Current segment download has not start yet, go and fetch current range (this and next segment)...");
                m1139(muVar.m9087());
                return;
            }
            C1283.m16854("nf_subtitles", "Current segment is being downloaded, go and fetch next range (2 segments after current one)...");
            m1139(muVar.m9087() + 1);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1990mu m8997(long j) {
        int i = this.f8875;
        if (i < 0) {
            i = 0;
        }
        if (this.f8881 == null) {
            C1283.m16854("nf_subtitles", "Indexes not available yet!");
            return null;
        }
        for (int i2 = i; i2 < this.f8881.length; i2++) {
            C1990mu muVar = this.f8881[i2];
            if (muVar != null && muVar.m9095(j)) {
                this.f8875 = i2;
                return muVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public int m9001() {
        if (this.f8881 == null) {
            C1283.m16854("nf_subtitles", "Indexes not available yet!");
            return 0;
        }
        for (int i = 0; i < this.f8881.length; i++) {
            C1990mu muVar = this.f8881[i];
            if (muVar == null) {
                C1276.m16820().mo5727("Image based subtitles: Segment index is null, this should NOT happen! It may happen only if current segment was requested BEFORE we finish parsing segment indexes.");
                C1283.m16850("nf_subtitles", "Image based subtitles: Segment index is null, this should NOT happen! It may happen only if current segment was requested BEFORE we finish parsing segment indexes.");
                return 0;
            } else if (muVar.m9095(this.f1977)) {
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
        if (this.f8881 != null) {
            for (int i2 = 0; i2 < this.f8881.length; i2++) {
                AbstractC1992mw[] r9 = this.f8881[i2].m9090();
                for (AbstractC1992mw mwVar : r9) {
                    if (mwVar.mo9074(this.f8869, this.f8871) && !arrayList.contains(mwVar)) {
                        arrayList.add(mwVar);
                        i++;
                    }
                }
            }
        }
        int i3 = this.f8876 + i;
        C1283.m16851("nf_subtitles", "%d where supposed to be visible between %d and %d for total of %d", Integer.valueOf(i), Long.valueOf(this.f8869), Long.valueOf(this.f8871), Integer.valueOf(i3));
        return i3;
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ʻॱ */
    public synchronized int mo8727() {
        int i;
        i = 0;
        if (this.f8881 != null) {
            for (int i2 = 0; i2 < this.f8881.length; i2++) {
                C1990mu muVar = this.f8881[i2];
                if (muVar != null) {
                    AbstractC1992mw[] r4 = muVar.m9090();
                    for (AbstractC1992mw mwVar : r4) {
                        if (mwVar != null) {
                            i += mwVar.mo9075();
                        }
                    }
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
        if (this.f8881 != null) {
            for (int i3 = 0; i3 < this.f8881.length; i3++) {
                C1990mu muVar = this.f8881[i3];
                if (muVar != null) {
                    AbstractC1992mw[] r9 = muVar.m9090();
                    for (AbstractC1992mw mwVar : r9) {
                        if (mwVar != null && mwVar.mo9074(this.f8869, this.f8871) && !arrayList.contains(mwVar)) {
                            arrayList.add(mwVar);
                            i2++;
                            mwVar.mo9073((long) i);
                        }
                    }
                }
            }
        }
        this.f8876 += i2;
        this.f8869 = (long) i;
        C1283.m16851("nf_subtitles", "%d where supposed to be visible between %d and %d for total of %d", Integer.valueOf(i2), Long.valueOf(this.f8869), Long.valueOf(this.f8871), Integer.valueOf(this.f8876));
        C1990mu r7 = m8997(this.f1977);
        if (r7 != null) {
            m8993(r7);
            if (!r7.m9088()) {
                C1283.m16854("nf_subtitles", "current segment is not downloaded in seek, start buffering");
                if (m1135() == BaseImageSubtitleParser.StreamingSubtitleState.STREAMING) {
                    m1137(BaseImageSubtitleParser.StreamingSubtitleState.STALLED);
                    mo7695();
                }
            }
        }
    }

    @Override // o.AbstractC1971mb
    /* renamed from: ˊॱ */
    public short mo8991() {
        if (this.f8880 != null) {
            return this.f8880.m9104();
        }
        return 0;
    }

    @Override // o.AbstractC1971mb
    /* renamed from: ॱˊ */
    public short mo8992() {
        if (this.f8880 != null) {
            return this.f8880.m9103();
        }
        return 0;
    }
}
