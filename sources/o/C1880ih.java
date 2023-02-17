package o;

import android.os.Handler;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.io.File;
import o.AbstractC1979mj;
/* renamed from: o.ih  reason: case insensitive filesystem */
public class C1880ih extends C1972mc implements AbstractC1883ik {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected File f7754;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected C1879ig f7755;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f7756;

    public C1880ih(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, C1879ig igVar, long j, AbstractC1979mj.iF iFVar, long j2, long j3, AbstractC2055pd pdVar, boolean z) {
        super(handler, mhVar, mlVar, igVar.m7704(), j, iFVar, j2, j3, pdVar);
        C1283.m16854("nf_subtitles", "Create image based offline subtitle parser");
        this.f7755 = igVar;
        this.f7754 = new File(igVar.m7705());
        this.f7756 = z;
    }

    @Override // o.C1972mc, o.AbstractC1979mj
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo7692() {
        mo1134();
        mo7691();
    }

    @Override // o.AbstractC1883ik
    /* renamed from: ˏ  reason: contains not printable characters */
    public Subtitle mo7693() {
        return this.f7755;
    }

    /* access modifiers changed from: protected */
    @Override // o.C1972mc
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo7691() {
        C1283.m16854("nf_subtitles", "Try to import data from existing cache!");
        if (!mo7689()) {
            C1283.m16850("nf_subtitles", "Failed to parse master index file from cache");
            m8987(ISubtitleDef.SubtitleFailure.badMasterIndex, (Status) null);
            return false;
        }
        C1283.m16854("nf_subtitles", "Parsed master index file from cache");
        if (mo7694()) {
            C1283.m16854("nf_subtitles", "Parsed segment index file from cache");
            C1283.m16854("nf_subtitles", "Ready to serve subtitles...");
            this.f8870 = true;
            mo7696();
            C1283.m16854("nf_subtitles", "Import all segments on start");
            for (C1990mu muVar : this.f8881) {
                mo7690(muVar);
            }
            return true;
        }
        C1283.m16850("nf_subtitles", "Failed to parse segment index file from cache");
        m8987(ISubtitleDef.SubtitleFailure.parsing, (Status) null);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.player.subtitles.BaseImageSubtitleParser
    /* renamed from: ˏ */
    public void mo1138(String str, byte[] bArr) {
    }

    /* access modifiers changed from: protected */
    @Override // o.C1972mc
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo7689() {
        if (this.f7754 == null || !this.f7754.exists()) {
            return false;
        }
        try {
            C1283.m16851("nf_subtitles", "Reading master index file from downloaded file %s from position %d for %d bytes.", this.f7754.getAbsolutePath(), Integer.valueOf(this.f7755.m7685()), Integer.valueOf(this.f7755.m7686()));
            boolean r6 = m9002(AH.m3353(this.f7754, this.f7755.m7685(), this.f7755.m7686()));
            C1283.m16851("nf_subtitles", "Loading master index file from cache %s was success %b", this.f7754.getAbsolutePath(), Boolean.valueOf(r6));
            return r6;
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles", "Failed to load and parse Master index from cache", th);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C1972mc
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo7694() {
        try {
            C1283.m16851("nf_subtitles", "Reading segment index file from cache %s", this.f7754.getAbsolutePath());
            int r5 = this.f8880.m9100();
            m9000(AH.m3353(this.f7754, (int) this.f8880.m9102(), r5), r5);
            C1283.m16851("nf_subtitles", "Loaded segment index file from cache %s", this.f7754.getAbsolutePath());
            return true;
        } catch (Throwable th) {
            C1283.m16856("nf_subtitles", th, "Failed to load and parse segment index from cache", new Object[0]);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C1972mc
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo7690(C1990mu muVar) {
        try {
            C1283.m16851("nf_subtitles", "Reading segment file from cache %s", this.f7754.getAbsolutePath());
            m8999(AH.m3353(this.f7754, (int) muVar.m9099(), (int) muVar.m9098()), muVar);
            C1283.m16851("nf_subtitles", "Loaded segment file from cache %s", this.f7754.getAbsolutePath());
            return true;
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles", "Failed to load and parse segment index from cache", th);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1970ma
    /* renamed from: ʽ  reason: contains not printable characters */
    public String mo7687() {
        String str = null;
        try {
            String str2 = this.f7755.getLanguageCodeIso639_1() + "_" + this.f7755.getTrackType();
            C1283.m16851("nf_subtitles", "Cache for playable id %d and language %s", Long.valueOf(this.f8878), str2);
            str = this.f8872.mo7759().mo7411(String.valueOf(this.f8878), str2);
            C1283.m16851("nf_subtitles", "Cache created for playable %d, cache name: %s", Long.valueOf(this.f8878), str);
        } catch (Throwable th) {
            C1283.m16856("nf_subtitles", th, "Failed to create cache ", new Object[0]);
        }
        C1283.m16851("nf_subtitles", "Cache name: %s", str);
        return str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1970ma
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void mo7696() {
        if (!this.f7756) {
            super.mo7696();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1970ma
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void mo7695() {
        if (!this.f7756) {
            super.mo7695();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1970ma
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo7688(long j) {
        if (!this.f7756) {
            super.mo7688(j);
        }
    }
}
