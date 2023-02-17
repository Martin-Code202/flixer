package o;

import android.media.MediaCrypto;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.os.Handler;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.drm.NfDrmManagerInterface;
import java.util.HashMap;
import java.util.UUID;
public class jA implements Comparable<jA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final UUID f7854 = AV.f4319;

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f7855;

    /* renamed from: ʼ  reason: contains not printable characters */
    private MediaCrypto f7856;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Long f7857;

    /* renamed from: ˊ  reason: contains not printable characters */
    private MediaDrm f7858;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f7859;

    /* renamed from: ˋ  reason: contains not printable characters */
    private byte[] f7860;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private If f7861;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Handler f7862;

    /* renamed from: ˏ  reason: contains not printable characters */
    private NfDrmManagerInterface.LicenseType f7863;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private Exception f7864;

    /* renamed from: ͺ  reason: contains not printable characters */
    private long f7865;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C1923jx f7866;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f7867;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f7868 = 1;

    public interface If {
        /* renamed from: ˊ */
        void mo7494(Status status);

        /* renamed from: ˎ */
        void mo7499(Long l);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static jA m7826(Handler handler, MediaDrm mediaDrm, Long l, C1923jx jxVar) {
        return new jA(handler, mediaDrm, l, jxVar);
    }

    public jA(Handler handler, MediaDrm mediaDrm, Long l, C1923jx jxVar) {
        this.f7862 = handler;
        this.f7858 = mediaDrm;
        this.f7857 = l;
        this.f7867 = (int) (l.longValue() & -1);
        this.f7855 = (int) ((l.longValue() >> 32) & -1);
        this.f7863 = jxVar.m8085();
        this.f7866 = jxVar;
        this.f7868 = 2;
        this.f7865 = System.currentTimeMillis();
        try {
            m7828();
        } catch (NotProvisionedException e) {
            m7822();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public MediaCrypto m7834() {
        return this.f7856;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m7842() {
        return this.f7868;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Exception m7832() {
        return this.f7864;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7837(If r3) {
        C1283.m16854("NfPlayerDrmManager", "set listener and use LDL.");
        m7825(r3);
        m7827();
        m7823(true);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7825(If r1) {
        this.f7861 = r1;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m7827() {
        if (this.f7866.m8097()) {
            m7845(this.f7866.m8096());
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7823(boolean z) {
        this.f7859 = z;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1923jx m7836() {
        return this.f7866;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7838(C1923jx jxVar) {
        if (jxVar != null && jxVar != this.f7866) {
            C1283.m16854("NfPlayerDrmManager", "updateLicenseContex");
            this.f7866.m8091(jxVar.m8094());
            this.f7863 = jxVar.m8085();
            this.f7866.m8088(this.f7863);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7839() {
        this.f7859 = false;
        if (this.f7868 == 3 || this.f7868 == 4 || this.f7868 == 0) {
            try {
                this.f7858.closeSession(this.f7860);
            } catch (Exception e) {
            }
        }
        this.f7861 = null;
        this.f7868 = 1;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m7831() {
        return this.f7868 == 4;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m7828() {
        this.f7860 = this.f7858.openSession();
        this.f7856 = new MediaCrypto(f7854, this.f7860);
        this.f7868 = 3;
        m7847();
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m7822() {
        C1283.m16854("NfPlayerDrmManager", "postProvisionRequest ...");
        this.f7862.obtainMessage(1, this.f7855, this.f7867, this.f7858.getProvisionRequest()).sendToTarget();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m7847() {
        C1283.m16854("NfPlayerDrmManager", "postKeyRequest start.");
        int i = 2;
        int i2 = 1;
        if (this.f7863.equals(NfDrmManagerInterface.LicenseType.LICENSE_TYPE_OFFLINE)) {
            i2 = 2;
            i = 4;
        } else if (this.f7868 == 4 || !this.f7863.equals(NfDrmManagerInterface.LicenseType.LICENSE_TYPE_LDL)) {
            this.f7866.m8088(NfDrmManagerInterface.LicenseType.LICENSE_TYPE_STANDARD);
            C1283.m16854("NfPlayerDrmManager", "request STANDARD.");
        } else {
            i = 3;
            this.f7866.m8088(NfDrmManagerInterface.LicenseType.LICENSE_TYPE_LDL);
            C1283.m16854("NfPlayerDrmManager", "request LDL.");
        }
        try {
            this.f7866.m8095(this.f7858.getKeyRequest(this.f7860, this.f7866.m8086(), new String(), i2, new HashMap<>()).getData());
            this.f7862.obtainMessage(i, this.f7855, this.f7867, this.f7866).sendToTarget();
            C1283.m16854("NfPlayerDrmManager", "postKeyRequest succeeds.");
        } catch (NotProvisionedException e) {
            C1283.m16854("NfPlayerDrmManager", "keyRequest has NotProvisionedException.");
            throw e;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m7829() {
        C1283.m16854("NfPlayerDrmManager", "postReleaseLicenseRequest start.");
        this.f7862.obtainMessage(5, this.f7855, this.f7867, this.f7866).sendToTarget();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7824(StatusCode statusCode, Exception exc) {
        this.f7864 = exc;
        if (this.f7861 != null) {
            this.f7861.mo7494(new NetflixStatus(statusCode, exc.getCause()));
        }
        this.f7868 = 0;
        this.f7862.obtainMessage(0, this.f7855, this.f7867, this.f7864).sendToTarget();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public byte[] m7846() {
        return this.f7860;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7845(byte[] bArr) {
        C1283.m16854("NfPlayerDrmManager", "provideKeyResponse start.");
        try {
            this.f7858.provideKeyResponse(this.f7860, bArr);
            this.f7868 = 4;
            C1283.m16854("NfPlayerDrmManager", "provideKeyResponse succeeds.");
            if (this.f7861 != null) {
                this.f7861.mo7499(this.f7857);
            }
        } catch (Exception e) {
            m7824(StatusCode.DRM_FAILURE_MEDIADRM_PROVIDE_KEY_RESPONSE, e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7844(Status status, boolean z) {
        if (z) {
            try {
                if (this.f7863.equals(NfDrmManagerInterface.LicenseType.LICENSE_TYPE_STANDARD)) {
                    C1283.m16854("NfPlayerDrmManager", "LicenseRequestFailed, retry with standard license.");
                    m7847();
                    return;
                }
            } catch (Exception e) {
                C1283.m16854("NfPlayerDrmManager", "LicenseRequestFailed NotProvisionedException.");
            }
        }
        this.f7868 = 0;
        if (this.f7861 != null) {
            this.f7861.mo7494(status);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m7830() {
        return this.f7868 == 1 || this.f7868 == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public int m7833() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ͺ  reason: contains not printable characters */
    public boolean m7841() {
        return this.f7859;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public long m7835() {
        return System.currentTimeMillis() - this.f7865;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public Long m7840() {
        return this.f7857;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int compareTo(jA jAVar) {
        long r2 = m7835();
        long r4 = jAVar.m7835();
        if (this.f7859 && !jAVar.f7859) {
            return 1;
        }
        if ((!this.f7859 && jAVar.f7859) || m7833() > jAVar.m7833()) {
            return -1;
        }
        if (m7833() < jAVar.m7833()) {
            return 1;
        }
        if (r2 > r4) {
            return -1;
        }
        if (r2 < r4) {
            return 1;
        }
        return 0;
    }
}
