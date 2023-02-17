package o;

import android.os.Handler;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.io.File;
/* renamed from: o.im  reason: case insensitive filesystem */
public class C1885im extends lY implements AbstractC1883ik {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected AbstractC1884il f7763;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private boolean f7764;

    public C1885im(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, AbstractC1884il ilVar, mP mPVar, mP mPVar2, float f, long j, AbstractC2055pd pdVar, Boolean bool) {
        super(handler, mhVar, mlVar, ilVar.m7704(), mPVar, mPVar2, f, null, 0, j, pdVar);
        C1283.m16854("nf_subtitles", "Create text based offline subtitle parser");
        this.f7763 = ilVar;
        this.f7764 = bool.booleanValue();
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ˎ */
    public void mo7692() {
        mo7681();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public boolean mo7681() {
        C1283.m16854("nf_subtitles", "Check if cache exist!");
        File file = new File(this.f7763.m7705());
        if (file == null || !file.exists()) {
            C1283.m16850("nf_subtitles", "Offline text subtitle NOT found at " + this.f7763.m7705());
            m8987(ISubtitleDef.SubtitleFailure.download, null);
            return false;
        }
        C1283.m16851("nf_subtitles", "File %s exist", file.getAbsolutePath());
        try {
            String r6 = AH.m3350(file.getAbsolutePath());
            C1283.m16851("nf_subtitles", "Importing subtitles metadata from offline directory %s :\n%s ", file.getAbsolutePath(), r6);
            m8728(r6);
            C1283.m16854("nf_subtitles", "Imported data from offline directory!");
            return true;
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles", "We failed to parse subtitle metadata from cached file", th);
            m8987(ISubtitleDef.SubtitleFailure.parsing, null);
            return false;
        }
    }

    @Override // o.AbstractC1883ik
    /* renamed from: ˏ */
    public Subtitle mo7693() {
        return this.f7763;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1970ma
    /* renamed from: ᐝ */
    public void mo7696() {
        if (!this.f7764) {
            super.mo7696();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1970ma
    /* renamed from: ॱॱ */
    public void mo7695() {
        if (!this.f7764) {
            super.mo7695();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1970ma
    /* renamed from: ˊ */
    public void mo7688(long j) {
        if (!this.f7764) {
            super.mo7688(j);
        }
    }
}
