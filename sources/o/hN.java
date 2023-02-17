package o;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.os.Handler;
import com.netflix.mediaclient.android.app.NetflixImmutableStatus;
import com.netflix.mediaclient.android.app.Status;
import o.hQ;
public final class hN extends hQ {

    /* renamed from: ॱ  reason: contains not printable characters */
    static final boolean f7133 = C1317As.m3774();

    /* renamed from: ͺ  reason: contains not printable characters */
    private final boolean f7134;

    public hN(String str, byte[] bArr, boolean z, hT hTVar, hQ.If r15, iT iTVar, String str2, Handler handler, String str3, String str4) {
        super(str, null, str2, hTVar, r15, iTVar, handler, str3, str4);
        this.f7154 = bArr;
        this.f7134 = z;
    }

    @Override // o.hQ
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6958() {
        NetflixImmutableStatus netflixImmutableStatus;
        String str;
        try {
            C1283.m16862("nf_offlineLicenseMgr", "deactivate playableId=" + this.f7151);
            if (this.f7154 == null || this.f7154.length == 0) {
                m6967(null, null, AbstractC0367.f13235);
                return;
            }
            C1283.m16860("nf_offlineLicenseMgr", "handleLicenseRequest keySetId", this.f7154);
            if (f7133) {
                this.f7148 = AV.m3455((MediaDrm.OnEventListener) null);
                str = C1418Ei.m4892(this.f7148.getKeyRequest(this.f7154, null, "", 3, this.f7152).getData());
            } else {
                str = "";
            }
            final boolean r8 = C1349Bv.m4107(str);
            this.f7150.m7567(this.f7159, str, this.f7134, new AbstractC1903jd() { // from class: o.hN.5
                @Override // o.AbstractC1903jd, o.iX
                /* renamed from: ॱ  reason: contains not printable characters */
                public void mo6959(final Status status, final String str2) {
                    hN.this.f7160.post(new Runnable() { // from class: o.hN.5.4
                        @Override // java.lang.Runnable
                        public void run() {
                            C1283.m16863("nf_offlineLicenseMgr", "DeactivateOfflineLicenseRequest onLicenseDeactivated playableId=%s", hN.this.f7151);
                            hN.this.m6956(str2, status, r8);
                        }
                    });
                }
            });
        } catch (NotProvisionedException e) {
            netflixImmutableStatus = AbstractC0367.f13215;
            C1283.m16850("nf_offlineLicenseMgr", "deactivate getKeyRequest NotProvisionedException");
            m6967(null, null, netflixImmutableStatus);
        } catch (Exception e2) {
            netflixImmutableStatus = AbstractC0367.f13218;
            C1283.m16850("nf_offlineLicenseMgr", "DeactivateOfflineLicenseRequest Exception " + e2);
            m6967(null, null, netflixImmutableStatus);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6956(String str, Status status, boolean z) {
        if (status.mo298() && z) {
            try {
                if (C1349Bv.m4107(str)) {
                    this.f7148.provideKeyResponse(this.f7154, C1418Ei.m4894(str));
                    C1283.m16862("nf_offlineLicenseMgr", "handleDeactivateResponse license released successfully.");
                } else {
                    status = AbstractC0367.f13260;
                    C1283.m16850("nf_offlineLicenseMgr", "handleDeactivateResponse licenseRelease is empty");
                }
            } catch (NotProvisionedException e) {
                status = AbstractC0367.f13215;
                C1283.m16850("nf_offlineLicenseMgr", "handleDeactivateResponse provideKeyResponse NotProvisionedException");
            } catch (DeniedByServerException e2) {
                status = AbstractC0367.f13216;
                C1283.m16850("nf_offlineLicenseMgr", "handleDeactivateResponse provideKeyResponse DeniedByServerException");
            } catch (Exception e3) {
                status = AbstractC0367.f13218;
                C1283.m16850("nf_offlineLicenseMgr", "handleDeactivateResponse provideKeyResponse Exception" + e3);
            }
        }
        m6967(null, null, status);
    }
}
