package o;

import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import com.netflix.mediaclient.service.player.drm.NfDrmManagerInterface;
import com.netflix.mediaclient.servicemgr.IPlayer;
import java.util.HashMap;
import o.AbstractC1897iy;
import org.json.JSONObject;
public class jL implements MediaDrm.OnEventListener {

    /* renamed from: ʻ  reason: contains not printable characters */
    private byte[] f7957;

    /* renamed from: ʽ  reason: contains not printable characters */
    private MediaDrm f7958;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1897iy.If f7959;

    /* renamed from: ˋ  reason: contains not printable characters */
    private JSONObject f7960;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1613cg f7961;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final iT f7962;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final P f7963;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final iF f7964;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f7965;

    public interface iF {
        /* renamed from: ˎ */
        void mo917(IPlayer.aux aux);
    }

    public jL(AbstractC1897iy.If r1, iT iTVar, P p, String str, AbstractC1613cg cgVar, iF iFVar) {
        this.f7965 = str;
        this.f7959 = r1;
        this.f7961 = cgVar;
        this.f7962 = iTVar;
        this.f7963 = p;
        this.f7964 = iFVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7958() {
        if (!m7956()) {
            C1283.m16850("OfflineHybridLicenseManager", "bad hybrid link - failed hybrid license");
            m7949();
            return;
        }
        m7957();
        if (!m7951()) {
            C1283.m16850("OfflineHybridLicenseManager", "failed to init drm resources for hybrid license");
            m7949();
            m7953();
            return;
        }
        C1923jx jxVar = new C1923jx(Long.toString(System.nanoTime()), this.f7959.mo7643(), this.f7959.mo7630().optString("href"), null, this.f7959.mo7634());
        jxVar.m8088(NfDrmManagerInterface.LicenseType.LICENSE_TYPE_STANDARD);
        MediaDrm.KeyRequest keyRequest = null;
        try {
            keyRequest = this.f7958.getKeyRequest(this.f7957, jxVar.m8086(), "", 1, new HashMap<>());
        } catch (NotProvisionedException e) {
        }
        if (keyRequest == null) {
            C1283.m16854("OfflineHybridLicenseManager", "failed to build challenge for hybrid license");
            m7949();
            m7953();
            return;
        }
        jxVar.m8095(keyRequest.getData());
        m7953();
        m7955(jxVar);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m7951() {
        return (this.f7958 == null || this.f7957 == null || this.f7957.length <= 0) ? false : true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7953() {
        if (this.f7957 != null && this.f7957.length > 0) {
            this.f7958.closeSession(this.f7957);
            this.f7957 = null;
        }
        this.f7958.release();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m7956() {
        return this.f7959.mo7630() != null && C1349Bv.m4107(this.f7959.mo7630().optString("href"));
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m7949() {
        this.f7961.mo610(false);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7955(C1923jx jxVar) {
        this.f7961.mo608();
        C1283.m16854("OfflineHybridLicenseManager", "fetching hybrid license");
        this.f7962.m7575(jxVar, new AbstractC1903jd() { // from class: o.jL.1
            @Override // o.AbstractC1903jd, o.iX
            /* renamed from: ॱ */
            public void mo7616(JSONObject jSONObject, Status status) {
                jL.this.f7960 = jSONObject;
                if ((status instanceof BladerunnerErrorStatus) && "CONCURRENT_STREAM_QUOTA_EXCEEDED_FAULT".equals(((BladerunnerErrorStatus) status).m968())) {
                    BladerunnerErrorStatus bladerunnerErrorStatus = (BladerunnerErrorStatus) status;
                    jL.this.f7964.mo917(new C1935kf(bladerunnerErrorStatus.m961(), bladerunnerErrorStatus.m963(), bladerunnerErrorStatus.m967()));
                }
                jL.this.f7961.mo610(status.mo298());
            }
        });
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m7957() {
        try {
            this.f7958 = AV.m3455(this);
        } catch (NotProvisionedException | UnsupportedSchemeException e) {
            C1283.m16847("OfflineHybridLicenseManager", "fail to instantiate MediaDrm %s", e);
        }
        if (this.f7958 != null) {
            try {
                this.f7957 = this.f7958.openSession();
            } catch (ResourceBusyException e2) {
                C1276.m16820().mo5729("RESOURCE_BUSY", e2);
            } catch (NotProvisionedException e3) {
                C1276.m16820().mo5729("Not provisioned", e3);
            }
        }
    }

    @Override // android.media.MediaDrm.OnEventListener
    public void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        C1283.m16860("OfflineHybridLicenseManager", "onEvent [" + i + "]", bArr);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7959() {
        if (this.f7960 != null) {
            JSONObject optJSONObject = this.f7960.optJSONObject("links");
            if (optJSONObject == null) {
                this.f7960 = null;
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("releaseLicense");
            if (optJSONObject2 != null) {
                this.f7963.mo5229(iT.m7555(optJSONObject2.toString(), this.f7965));
                this.f7960 = null;
            }
        }
    }
}
