package o;

import android.os.SystemClock;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.netflixdatasource.NetflixNetworkError;
import o.AbstractC1952kz;
/* renamed from: o.lk  reason: case insensitive filesystem */
public class C1957lk implements kw {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f8625;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f8626 = "fastselection";

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f8627 = 0;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f8628;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final kF f8629;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private String f8630 = "startup";

    /* renamed from: ˎ  reason: contains not printable characters */
    private long f8631 = 0;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f8632;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final kZ f8633;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f8634 = false;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f8635 = 0;

    public C1957lk(kF kFVar, kZ kZVar, int i, int i2) {
        this.f8629 = kFVar;
        this.f8633 = kZVar;
        this.f8628 = i;
        this.f8632 = i2;
        this.f8625 = kFVar.m8200(kFVar.m8199().iterator().next())[0].m8190();
    }

    @Override // o.kw
    /* renamed from: ॱ */
    public kD mo8455(String str) {
        kD[] r2 = this.f8629.m8200(str);
        if (r2 == null || r2.length <= 0) {
            return null;
        }
        this.f8635 %= r2.length;
        if (!this.f8634) {
            m8745(r2, this.f8635);
        }
        this.f8625 = r2[this.f8635].m8190();
        return r2[this.f8635];
    }

    @Override // o.kw
    /* renamed from: ॱ */
    public String mo8454() {
        return this.f8625;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private synchronized void m8745(kD[] kDVarArr, int i) {
        if (this.f8633 != null && !this.f8634) {
            AbstractC1952kz.AbstractC1953iF r10 = this.f8633.m8356();
            if (r10 != null) {
                AbstractC1952kz.Cif[] ifVarArr = new AbstractC1952kz.Cif[0];
                AbstractC1952kz.C0141[] r12 = new AbstractC1952kz.C0141[kDVarArr.length];
                for (int i2 = 0; i2 < kDVarArr.length; i2++) {
                    kD kDVar = kDVarArr[i2];
                    r12[i2] = new AbstractC1952kz.C0141(kDVar.m8194(), kDVar.m8190(), kDVar.m8195(), kDVar.m8193(), kDVar.m8196(), kDVar.m8197(), kDVar.m8192(), 0, 0);
                }
                r10.mo8461(new AbstractC1952kz.If(ifVarArr, r12, 0, Integer.parseInt(kDVarArr[0].m8194()), 0, Integer.parseInt(kDVarArr[i].m8194()), 0, this.f8626, this.f8630));
            }
            this.f8634 = true;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m8746() {
        this.f8635++;
        this.f8630 = "dlfail";
        this.f8626 = "dlfail";
        this.f8631 = SystemClock.elapsedRealtime();
        this.f8634 = false;
    }

    @Override // o.AbstractC1959lq
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8748(DataSpec dataSpec) {
        this.f8631 = 0;
        this.f8627 = 0;
    }

    @Override // o.AbstractC1959lq
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8747(DataSpec dataSpec, NetflixNetworkError netflixNetworkError) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        switch (((int[]) ((Class) C1958ll.m8751(11519, 6, 0)).getDeclaredField("ˎ").get(null))[netflixNetworkError.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (elapsedRealtime - this.f8631 > ((long) this.f8632)) {
                    m8746();
                    return;
                }
                return;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                if (elapsedRealtime - this.f8631 > ((long) this.f8632)) {
                    this.f8627++;
                    if (this.f8627 >= this.f8628) {
                        this.f8627 = 0;
                        m8746();
                        return;
                    }
                    return;
                }
                return;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            default:
                return;
        }
    }
}
