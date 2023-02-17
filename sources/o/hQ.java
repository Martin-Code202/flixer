package o;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.os.Handler;
import com.netflix.mediaclient.android.app.NetflixImmutableStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.OfflineLicenseResponse;
import java.util.HashMap;
public class hQ {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected MediaDrm f7148;

    /* renamed from: ʼ  reason: contains not printable characters */
    final If f7149;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected final iT f7150;

    /* renamed from: ˊ  reason: contains not printable characters */
    final String f7151;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected final HashMap<String, String> f7152 = new HashMap<>();

    /* renamed from: ˋ  reason: contains not printable characters */
    final String f7153;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected byte[] f7154;

    /* renamed from: ˎ  reason: contains not printable characters */
    final String f7155;

    /* renamed from: ˏ  reason: contains not printable characters */
    final hT f7156;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected byte[] f7157;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f7158;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected String f7159;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected final Handler f7160;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected byte[] f7161;

    /* access modifiers changed from: package-private */
    public interface If {
        /* renamed from: ˏ  reason: contains not printable characters */
        void mo6970(hQ hQVar, Status status);
    }

    public hQ(String str, byte[] bArr, String str2, hT hTVar, If r6, iT iTVar, Handler handler, String str3, String str4) {
        this.f7151 = str;
        this.f7156 = hTVar;
        this.f7149 = r6;
        this.f7157 = bArr;
        this.f7159 = str2;
        this.f7150 = iTVar;
        this.f7160 = handler;
        this.f7153 = str3;
        this.f7155 = str4;
    }

    /* renamed from: ˏ */
    public void mo6958() {
        if (m6963()) {
            mo6961();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo6961() {
        NetflixImmutableStatus netflixImmutableStatus;
        NetflixImmutableStatus netflixImmutableStatus2 = AbstractC0367.f13235;
        try {
            C1283.m16862("nf_offlineLicenseMgr", "sendLicenseRequest playableId=" + this.f7151);
            this.f7150.m7566(this.f7159, C1418Ei.m4892(this.f7148.getKeyRequest(this.f7161, this.f7157, "", 2, this.f7152).getData()), new AbstractC1903jd() { // from class: o.hQ.2
                @Override // o.AbstractC1903jd, o.iX
                /* renamed from: ˏ */
                public void mo6962(final OfflineLicenseResponse offlineLicenseResponse, final Status status) {
                    C1283.m16862("nf_offlineLicenseMgr", "sendLicenseRequest onLicenseFetched playableId=" + hQ.this.f7151);
                    hQ.this.f7160.post(new Runnable() { // from class: o.hQ.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            hQ.this.m6969(offlineLicenseResponse, status);
                        }
                    });
                }
            });
        } catch (NotProvisionedException e) {
            netflixImmutableStatus = AbstractC0367.f13215;
            C1283.m16850("nf_offlineLicenseMgr", "deactivate getKeyRequest NotProvisionedException");
            m6967(null, null, netflixImmutableStatus);
        } catch (Exception e2) {
            netflixImmutableStatus = AbstractC0367.f13217;
            C1283.m16850("nf_offlineLicenseMgr", "sendLicenseRequest Exception" + e2);
            m6967(null, null, netflixImmutableStatus);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6969(OfflineLicenseResponse offlineLicenseResponse, Status status) {
        if (m6966()) {
            C1283.m16862("nf_offlineLicenseMgr", "handleLicenseResponse request was aborted.");
            return;
        }
        if (status.mo298()) {
            if (null != offlineLicenseResponse) {
                try {
                    if (offlineLicenseResponse.m950() != null && offlineLicenseResponse.m950().length > 0) {
                        byte[] provideKeyResponse = this.f7148.provideKeyResponse(this.f7161, offlineLicenseResponse.m950());
                        if (this.f7154 == null || this.f7154.length == 0) {
                            this.f7154 = provideKeyResponse;
                        }
                        if (this.f7154 == null || this.f7154.length == 0) {
                            status = AbstractC0367.f13213;
                            C1283.m16850("nf_offlineLicenseMgr", "handleLicenseResponse provideKeyResponse returned null");
                        } else {
                            AV.m3467("nf_offlineLicenseMgr", this.f7148, this.f7161);
                            C1283.m16860("nf_offlineLicenseMgr", "handleLicenseResponse keySetId", this.f7154);
                        }
                    }
                } catch (NotProvisionedException e) {
                    status = AbstractC0367.f13215;
                    C1283.m16850("nf_offlineLicenseMgr", "handleLicenseResponse provideKeyResponse NotProvisionedException");
                } catch (DeniedByServerException e2) {
                    status = AbstractC0367.f13216;
                    C1283.m16850("nf_offlineLicenseMgr", "handleLicenseResponse provideKeyResponse DeniedByServerException");
                } catch (Exception e3) {
                    status = AbstractC0367.f13218;
                    C1283.m16850("nf_offlineLicenseMgr", "handleLicenseResponse provideKeyResponse Exception" + e3);
                }
            }
            status = AbstractC0367.f13224;
            C1283.m16850("nf_offlineLicenseMgr", "handleLicenseResponse license is empty");
        }
        m6967(offlineLicenseResponse, this.f7154, status);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6967(OfflineLicenseResponse offlineLicenseResponse, byte[] bArr, Status status) {
        C1283.m16854("nf_offlineLicenseMgr", "doLicenseResponseCallback " + status);
        m6964();
        if (!m6966()) {
            if (offlineLicenseResponse != null) {
                offlineLicenseResponse.m951(bArr);
                m6965(offlineLicenseResponse, status);
            }
            this.f7156.mo6917(this.f7151, offlineLicenseResponse, status);
            this.f7149.mo6970(this, status);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m6966() {
        return this.f7158;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m6968(byte[] bArr) {
        C1283.m16860("nf_offlineLicenseMgr", "tryCreateDrmSession using keySetId", bArr);
        if (!m6963()) {
            return false;
        }
        try {
            this.f7148.restoreKeys(this.f7161, bArr);
            AV.m3467("nf_offlineLicenseMgr", this.f7148, this.f7161);
            return true;
        } catch (Exception e) {
            C1283.m16850("nf_offlineLicenseMgr", "restorekeys failed " + e);
            m6967(null, null, AbstractC0367.f13217);
            return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m6963() {
        try {
            this.f7148 = AV.m3455((MediaDrm.OnEventListener) null);
            this.f7161 = this.f7148.openSession();
            if (this.f7161 != null && this.f7161.length != 0) {
                return true;
            }
            m6967(null, null, AbstractC0367.f13217);
            C1283.m16850("nf_offlineLicenseMgr", "tryCreateDrmSession DrmSession invalid");
            return false;
        } catch (NotProvisionedException e) {
            C1283.m16850("nf_offlineLicenseMgr", "createDrmSession failed " + e);
            m6967(null, null, AbstractC0367.f13215);
            return false;
        } catch (ResourceBusyException e2) {
            C1283.m16850("nf_offlineLicenseMgr", "createDrmSession failed " + e2);
            m6967(null, null, AbstractC0367.f13221);
            return false;
        } catch (Exception e3) {
            m6967(null, null, AbstractC0367.f13218);
            return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6964() {
        if (this.f7161 != null) {
            try {
                C1283.m16862("nf_offlineLicenseMgr", "closing mediaDrm session for mPlayableId=" + this.f7151);
                this.f7148.closeSession(this.f7161);
            } catch (Exception e) {
                C1283.m16850("nf_offlineLicenseMgr", "error closing mediaDrm Session " + e);
            }
            this.f7161 = null;
        }
        if (this.f7148 != null) {
            this.f7148.release();
            this.f7148 = null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6965(OfflineLicenseResponse offlineLicenseResponse, Status status) {
        if (status.mo301() || offlineLicenseResponse.f1671 == null) {
            C1283.m16851("nf_offlineLicenseMgr", "skip sending activate on error %s", status);
        } else if ((this instanceof hP) || (this instanceof hQ)) {
            this.f7150.m7564(offlineLicenseResponse.f1671);
        }
    }
}
