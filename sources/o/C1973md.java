package o;

import android.os.Handler;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.io.File;
import o.AbstractC1979mj;
/* renamed from: o.md  reason: case insensitive filesystem */
public class C1973md extends lY {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected String f8888 = mo7687();

    public C1973md(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, SubtitleUrl subtitleUrl, mP mPVar, mP mPVar2, float f, AbstractC1979mj.iF iFVar, long j, long j2, AbstractC2055pd pdVar) {
        super(handler, mhVar, mlVar, subtitleUrl, mPVar, mPVar2, f, iFVar, j, j2, pdVar);
        C1283.m16854("nf_subtitles", "Create text based subtitle parser");
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ˎ */
    public void mo7692() {
        this.f8879.post(new Runnable() { // from class: o.md.1
            @Override // java.lang.Runnable
            public void run() {
                if (!C1973md.this.mo9004()) {
                    C1973md.this.m9005(C1973md.this.f8868.getDownloadUrl());
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo9004() {
        C1283.m16854("nf_subtitles", "Check if cache exist!");
        File r3 = this.f8872.mo7759().mo7410(this.f8888, "manifest_ttml.xml");
        if (r3 == null) {
            return false;
        }
        try {
            m8728(AH.m3350(r3.getAbsolutePath()));
            C1283.m16854("nf_subtitles", "Imported data from existing cache!");
            return true;
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles", "We failed to parse subtitle metadata from cached file", th);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m9005(final String str) {
        final String[] r3 = gU.m6607().m6609();
        m8990().mo9310(str, AssetType.subtitles, new C2005ni() { // from class: o.md.3
            @Override // o.C2005ni, o.AbstractC2006nj
            /* renamed from: ˎ */
            public void mo7553(String str2, byte[] bArr, Status status) {
                if (status.mo298()) {
                    C1973md.this.m9003(bArr, str, r3);
                } else if (!C1973md.this.m8988(str2, r3, ISubtitleDef.SubtitleFailure.download, status)) {
                    C1973md.this.m8987(ISubtitleDef.SubtitleFailure.download, status);
                }
            }
        });
        C1283.m16854("nf_subtitles", "Subtitles download start done.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9003(final byte[] bArr, final String str, final String[] strArr) {
        C1283.m16854("nf_subtitles", "MEDIA_SUBTITLE_DATA 100");
        new BackgroundTask().m285(new Runnable() { // from class: o.md.4
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16854("nf_subtitles", "Subtitles metadata update started.");
                try {
                    C1973md.this.mo9006(bArr);
                } catch (Throwable th) {
                    C1283.m16847("nf_subtitles", "We failed to parse subtitle metadata", th);
                    long j = C1973md.this.f8878;
                    Subtitle r8 = C1973md.this.f8872.mo891();
                    if (j == 0 || r8 == null) {
                        C1283.m16854("nf_subtitles", "Current playableId is 0 or subtitle track is null");
                        return;
                    }
                    StringBuilder sb = new StringBuilder("We failed to parse subtitle metadata with Playable Id ");
                    sb.append(C1973md.this.f8878);
                    sb.append(", on subtitle ");
                    if (C1973md.this.f8872.mo891() != null) {
                        sb.append(C1973md.this.f8872.mo891().getLanguageDescription());
                    } else {
                        sb.append("null");
                    }
                    C1276.m16820().mo5731(new RuntimeException(sb.toString(), th));
                    if (!C1973md.this.m8988(str, strArr, ISubtitleDef.SubtitleFailure.parsing, null)) {
                        C1973md.this.m8987(ISubtitleDef.SubtitleFailure.parsing, null);
                    }
                }
                C1283.m16854("nf_subtitles", "Subtitles metadata updated.");
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo9006(byte[] bArr) {
        String str;
        m8728(new String(bArr, "UTF-8"));
        if (this.f8872.mo7759().mo7412(this.f8888, "manifest_ttml.xml", bArr) != null) {
            C1283.m16854("nf_subtitles", "Text subtitle xml saved to cache.");
            return;
        }
        C1283.m16865("nf_subtitles", "Failed to cache text subtitle xml!!!");
        String str2 = "Failed to cache text subtitle xml with name " + this.f8888;
        if (bArr != null) {
            str = str2 + bArr.length;
        } else {
            str = str2 + 0;
        }
        C1276.m16820().mo5731(new RuntimeException(str));
    }
}
