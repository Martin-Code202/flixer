package o;

import android.os.Handler;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import o.AbstractC1979mj;
/* renamed from: o.ma  reason: case insensitive filesystem */
public abstract class AbstractC1970ma implements AbstractC1979mj {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected SubtitleUrl f8868;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected long f8869;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected boolean f8870;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected long f8871;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected AbstractC1977mh f8872;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected AbstractC1981ml f8873;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected AbstractC1979mj.iF f8874;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected int f8875 = -1;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    protected int f8876;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected AbstractC2055pd f8877;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected final long f8878;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected Handler f8879;

    public AbstractC1970ma(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, SubtitleUrl subtitleUrl, AbstractC1979mj.iF iFVar, long j, long j2, AbstractC2055pd pdVar) {
        this.f8879 = handler;
        this.f8872 = mhVar;
        this.f8873 = mlVar;
        this.f8874 = iFVar;
        this.f8869 = j;
        this.f8871 = j;
        this.f8868 = subtitleUrl;
        this.f8878 = j2;
        this.f8877 = pdVar;
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public boolean mo8989() {
        return this.f8870;
    }

    @Override // o.AbstractC1979mj
    /* renamed from: ˏ */
    public synchronized void mo8733(int i) {
        C1283.m16854("nf_subtitles", "Seeked to...");
        this.f8875 = -1;
    }

    @Override // o.AbstractC1979mj
    public SubtitleUrl E_() {
        return this.f8868;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m8988(String str, String[] strArr, ISubtitleDef.SubtitleFailure subtitleFailure, Status status) {
        boolean z = false;
        if (this.f8874 != null) {
            C1283.m16854("nf_subtitles", "onError: callback");
            z = this.f8874.mo1148(this.f8868, subtitleFailure, str);
        } else {
            C1283.m16865("nf_subtitles", "onError: no callback");
        }
        this.f8872.mo7755(str, this.f8868, subtitleFailure, z, status, strArr);
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽ */
    public String mo7687() {
        try {
            return this.f8872.mo7759().mo7411(String.valueOf(this.f8878), this.f8872.mo891().getLanguageCodeIso639_1() + "_" + this.f8872.mo891().getTrackType());
        } catch (Throwable th) {
            C1283.m16850("nf_subtitles", "Failed to create cache " + th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺ  reason: contains not printable characters */
    public AbstractC2007nk m8990() {
        AbstractC2007nk r1 = this.f8872.mo7747();
        if (r1 == null) {
            return null;
        }
        return r1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ */
    public void mo7696() {
        if (this.f8877.mo9712() && this.f8873 != null) {
            this.f8873.mo910();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8987(ISubtitleDef.SubtitleFailure subtitleFailure, Status status) {
        if (!this.f8877.mo9712() || this.f8873 == null) {
            C1283.m16851("nf_subtitles", "subtitle error occured %s", subtitleFailure.name());
        } else {
            this.f8873.mo925(subtitleFailure, status);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ */
    public void mo7695() {
        if (this.f8877.mo9712() && this.f8873 != null) {
            this.f8873.mo911();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo7688(long j) {
        if (this.f8877.mo9712() && this.f8873 != null) {
            this.f8873.mo916(j);
        }
    }
}
