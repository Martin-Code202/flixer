package o;

import android.media.NotProvisionedException;
import android.os.Handler;
import com.netflix.mediaclient.android.app.NetflixImmutableStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.player.bladerunnerclient.OfflineLicenseResponse;
import o.hQ;
/* access modifiers changed from: package-private */
public class hP extends hQ {

    /* renamed from: ॱ  reason: contains not printable characters */
    IBladeRunnerClient.OfflineRefreshInvoke f7143;

    public hP(IBladeRunnerClient.OfflineRefreshInvoke offlineRefreshInvoke, String str, byte[] bArr, String str2, hT hTVar, hQ.If r16, iT iTVar, Handler handler, byte[] bArr2, String str3, String str4) {
        super(str, bArr, str2, hTVar, r16, iTVar, handler, str3, str4);
        this.f7154 = bArr2;
        this.f7143 = offlineRefreshInvoke;
    }

    @Override // o.hQ
    /* renamed from: ˏ */
    public void mo6958() {
        if (m6968(this.f7154)) {
            mo6961();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.hQ
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo6961() {
        NetflixImmutableStatus netflixImmutableStatus;
        try {
            C1283.m16862("nf_offlineLicenseMgr", "RefreshOfflineLicenseRequest sendLicenseRequest playableId=" + this.f7151);
            this.f7150.m7570(this.f7143, this.f7159, C1418Ei.m4892(this.f7148.getKeyRequest(this.f7161, this.f7157, "", 2, this.f7152).getData()), new AbstractC1903jd() { // from class: o.hP.2
                @Override // o.AbstractC1903jd, o.iX
                /* renamed from: ˏ  reason: contains not printable characters */
                public void mo6962(final OfflineLicenseResponse offlineLicenseResponse, final Status status) {
                    C1283.m16862("nf_offlineLicenseMgr", "RefreshOfflineLicenseRequest onLicenseFetched playableId=" + hP.this.f7151);
                    hP.this.f7160.post(new Runnable() { // from class: o.hP.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            hP.this.m6969(offlineLicenseResponse, status);
                        }
                    });
                }
            });
        } catch (NotProvisionedException e) {
            netflixImmutableStatus = AbstractC0367.f13215;
            C1283.m16850("nf_offlineLicenseMgr", "RefreshOfflineLicenseRequest getKeyRequest NotProvisionedException");
            m6967(null, null, netflixImmutableStatus);
        } catch (Exception e2) {
            netflixImmutableStatus = AbstractC0367.f13217;
            C1283.m16850("nf_offlineLicenseMgr", "RefreshOfflineLicenseRequest Exception " + e2);
            m6967(null, null, netflixImmutableStatus);
        }
    }
}
