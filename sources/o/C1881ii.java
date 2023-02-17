package o;

import android.os.Handler;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.io.File;
import o.AbstractC1979mj;
/* renamed from: o.ii  reason: case insensitive filesystem */
public class C1881ii extends C1975mf implements AbstractC1883ik {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected File f7757;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected C1879ig f7758;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f7759;

    public C1881ii(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, C1879ig igVar, long j, AbstractC1979mj.iF iFVar, long j2, long j3, AbstractC2055pd pdVar, boolean z) {
        super(handler, mhVar, mlVar, igVar.m7704(), j, iFVar, j2, j3, pdVar);
        C1283.m16854("nf_subtitles_imv2", "Create image V2 based offline subtitle parser");
        this.f7758 = igVar;
        this.f7757 = new File(igVar.m7705());
        this.f7759 = z;
    }

    @Override // o.AbstractC1883ik
    /* renamed from: ˏ */
    public Subtitle mo7693() {
        return this.f7758;
    }

    @Override // o.C1975mf, o.AbstractC1979mj
    /* renamed from: ˎ */
    public void mo7692() {
        mo1134();
        m7700();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m7700() {
        C1283.m16854("nf_subtitles_imv2", "Try to import data from existing cache!");
        if (!m7698()) {
            C1283.m16850("nf_subtitles_imv2", "Failed to parse master index file from cache");
            m8987(ISubtitleDef.SubtitleFailure.badMasterIndex, null);
            return false;
        }
        C1283.m16854("nf_subtitles_imv2", "Parsed master index file from cache");
        if (m7697()) {
            C1283.m16854("nf_subtitles_imv2", "Parsed segment index file from cache");
            C1283.m16854("nf_subtitles_imv2", "Ready to serve subtitles...");
            this.f8870 = true;
            C1283.m16854("nf_subtitles_imv2", "Import all segments on start");
            for (mD mDVar : this.f8898) {
                m7699(mDVar);
            }
            return true;
        }
        C1283.m16850("nf_subtitles_imv2", "Failed to parse segment index file from cache");
        m8987(ISubtitleDef.SubtitleFailure.parsing, null);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.player.subtitles.BaseImageSubtitleParser
    /* renamed from: ˏ */
    public void mo1138(String str, byte[] bArr) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m7698() {
        if (this.f7757 == null || !this.f7757.exists()) {
            return false;
        }
        try {
            C1283.m16851("nf_subtitles_imv2", "Reading master index file from downloaded file %s from position %d for %d bytes.", this.f7757.getAbsolutePath(), Integer.valueOf(this.f7758.m7685()), Integer.valueOf(this.f7758.m7686()));
            boolean r6 = m9025(AH.m3353(this.f7757, this.f7758.m7685(), this.f7758.m7686()));
            C1283.m16851("nf_subtitles_imv2", "Loading master index file from cache %s was success %b", this.f7757.getAbsolutePath(), Boolean.valueOf(r6));
            return r6;
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles_imv2", "Failed to load and parse Master index from cache", th);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m7697() {
        try {
            C1283.m16851("nf_subtitles_imv2", "Reading segment index file from cache %s", this.f7757.getAbsolutePath());
            int r5 = this.f8897.m8814().m8818();
            m9026(AH.m3353(this.f7757, (int) this.f8897.m8814().m8817(), r5), r5);
            C1283.m16851("nf_subtitles_imv2", "Loaded segment index file from cache %s", this.f7757.getAbsolutePath());
            return true;
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles_imv2", "Failed to load and parse segment index from cache", th);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m7699(mD mDVar) {
        try {
            C1283.m16851("nf_subtitles_imv2", "Reading segment file from cache %s", this.f7757.getAbsolutePath());
            m9024(AH.m3353(this.f7757, (int) mDVar.m8805().m8836(), (int) mDVar.m8805().m8826()), mDVar.m8805(), this.f8868.getDownloadUrl(), this.f8868.getDecryptionKey());
            C1283.m16851("nf_subtitles_imv2", "Loaded segment file from cache %s", this.f7757.getAbsolutePath());
            return true;
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles_imv2", "Failed to load and parse segment index from cache", th);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1970ma
    /* renamed from: ʽ */
    public String mo7687() {
        try {
            return this.f8872.mo7759().mo7411(String.valueOf(this.f8878), this.f7758.getLanguageCodeIso639_1() + "_" + this.f7758.getTrackType());
        } catch (Throwable th) {
            C1283.m16850("nf_subtitles_imv2", "Failed to create cache " + th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1970ma
    /* renamed from: ᐝ */
    public void mo7696() {
        if (!this.f7759) {
            super.mo7696();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1970ma
    /* renamed from: ॱॱ */
    public void mo7695() {
        if (!this.f7759) {
            super.mo7695();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1970ma
    /* renamed from: ˊ */
    public void mo7688(long j) {
        if (!this.f7759) {
            super.mo7688(j);
        }
    }
}
