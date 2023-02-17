package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.SystemClock;
import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import java.util.UUID;
public class AV {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static CryptoProvider f4315;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String f4316 = "MediaDrmUtils";

    /* renamed from: ˎ  reason: contains not printable characters */
    private static CryptoProvider f4317;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final iF f4318 = new iF();

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final UUID f4319 = new UUID(-1301668207276963122L, -6645017420763422227L);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static String f4320;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m3451() {
        if (!f4318.m3484()) {
            return CryptoProvider.LEGACY.f1089;
        }
        if (f4318.m3485()) {
            return CryptoProvider.WIDEVINE_L1.f1089;
        }
        return CryptoProvider.WIDEVINE_L3.f1089;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3459() {
        return f4318.f4321;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3468() {
        return f4318.f4325;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m3464(AbstractC1221 r7) {
        String str = f4318.f4323;
        C1283.m16851(f4316, "MediaDrm system ID is: %s", str);
        if (C1349Bv.m4113(str)) {
            return false;
        }
        if ("4266".equals(str)) {
            if (r7 != null) {
                C1283.m16855(f4316, "Device is using Widevine L3 4266! Valid %b per config", Boolean.valueOf(r7.mo16550()));
                return r7.mo16550();
            }
            C1283.m16865(f4316, "Device is using Widevine L3 4266! Not valid, config is missing! Go with allowed.");
            return true;
        } else if (C1349Bv.m4113(str) || str.trim().length() > 5) {
            return false;
        } else {
            C1283.m16854(f4316, "Valid System ID.");
            return true;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m3469(Context context) {
        return C1339Bl.m4051(context, "disable_widevine", false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m3462(Context context) {
        return C1339Bl.m4051(context, "nf_disable_widevine_l3_v3", false);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static synchronized CryptoProvider m3456(Context context, AbstractC1221 r3) {
        CryptoProvider cryptoProvider;
        synchronized (AV.class) {
            if (f4315 == null) {
                f4315 = m3452(context, r3);
            }
            cryptoProvider = f4315;
        }
        return cryptoProvider;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static synchronized CryptoProvider m3452(Context context, AbstractC1221 r8) {
        synchronized (AV.class) {
            if (!m3468()) {
                C1283.m16865(f4316, "getCryptoProvider: Widevine is NOT supported on this device.");
                return CryptoProvider.LEGACY;
            }
            if (r8.g_()) {
                C1283.m16854(f4316, "Widevine L1 is enabled, check if we failed before");
                if (m3469(context)) {
                    C1283.m16865(f4316, "Widevine L1 was whitelisted, but it failed on this device, see fallback option.");
                } else {
                    C1283.m16851(f4316, "Widevine L1 did not failed on this device and L1 was whitelisted, check if device really supports L1. PlayerRequiredAdaptivePlayback : %b", true);
                    if (!m3459() || 1 == 0) {
                        C1283.m16865(f4316, "getCryptoProvider:Widevine L1 is not supported on device or it has problem in playback, go for fallback");
                    } else {
                        C1283.m16854(f4316, "getCryptoProvider:Widevine L1 will be used");
                        return CryptoProvider.WIDEVINE_L1;
                    }
                }
            } else {
                C1283.m16865(f4316, "Widevine L1 is NOT enabled, see fallback option.");
            }
            if (m3462(context)) {
                C1283.m16865(f4316, "Widevine L3 failed on this device, fallback to MGK.");
            } else if (m3464(r8)) {
                C1283.m16854(f4316, "getCryptoProvider: for kitkat: Widevine L3");
                return CryptoProvider.WIDEVINE_L3;
            } else {
                C1283.m16854(f4316, "getCryptoProvider: use legacy crypto because KK device can not support L3!");
            }
            return CryptoProvider.LEGACY;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3461() {
        return "flo".equals(Build.DEVICE) || "deb".equals(Build.DEVICE);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m3454(MediaDrm mediaDrm) {
        if (C0480.m14408().mo14358() == CryptoProvider.WIDEVINE_L3) {
            m3458(mediaDrm);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3458(MediaDrm mediaDrm) {
        if (mediaDrm == null) {
            throw new IllegalStateException("MediaDrm is null");
        }
        C1283.m16854(f4316, "Forcing L3 security level...");
        mediaDrm.setPropertyString("securityLevel", "L3");
        f4318.m3483();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m3466(MediaDrm mediaDrm) {
        if (C1317As.m3758() >= 22) {
            try {
                mediaDrm.setPropertyString("appId", C1061.m16114().mo14160());
            } catch (Exception e) {
                C1283.m16847("WidevineMediaDrm", "ignore exceptions", e);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static MediaDrm m3455(MediaDrm.OnEventListener onEventListener) {
        MediaDrm mediaDrm = new MediaDrm(f4319);
        if (onEventListener != null) {
            mediaDrm.setOnEventListener(onEventListener);
        }
        m3454(mediaDrm);
        m3466(mediaDrm);
        return mediaDrm;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3467(String str, MediaDrm mediaDrm, byte[] bArr) {
        String[] strArr = {"LicenseType", "PersistAllowed", "RenewalServerUrl", "LicenseDurationRemaining", "RenewAllowed", "PlaybackDurationRemaining", "PlayAllowed"};
        C1283.m16860(str, "SessionId", bArr);
        C1283.m16854(str, "===== key status ======");
        try {
            C1283.m16854(str, mediaDrm.queryKeyStatus(bArr).toString());
        } catch (Exception e) {
            C1283.m16865(str, "failed to queryKeyStatus()");
        }
        C1283.m16854(str, "===== end of key status ======");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static byte[] m3465(MediaDrm mediaDrm) {
        if (mediaDrm == null) {
            C1283.m16850(f4316, "Session MediaDrm is null! It should NOT happen!");
            return null;
        }
        byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
        if (propertyByteArray == null) {
            C1283.m16850(f4316, "MediaDrm device ID is null! It should NOT happen!");
        }
        return propertyByteArray;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m3470(MediaDrm mediaDrm) {
        if (mediaDrm != null) {
            return mediaDrm.getPropertyString("systemId");
        }
        C1283.m16850(f4316, "Session MediaDrm is null! It should NOT happen!");
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3474(String str) {
        return C1349Bv.m4113(str) || "LEGACY".equals(str) || "FORCE_LEGACY".equals(str) || "M_PLUS_MGK".equals(str);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0037: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v1 java.lang.String) */
    /* renamed from: ˋ  reason: contains not printable characters */
    private static final void m3457(Context context) {
        if (f4317 != null) {
            C1283.m16850(f4316, "This should not be called twice, we already found previous DRM!");
            return;
        }
        f4320 = C1339Bl.m4045(context, "nf_drm_system_id", (String) null);
        f4317 = CryptoProvider.m503(C1339Bl.m4045(context, "nf_drm_crypto_provider", (String) null));
        String str = f4316;
        Object[] objArr = new Object[2];
        objArr[0] = f4315 != null ? f4315.name() : "N/A";
        objArr[1] = f4317 != null ? f4317.name() : "N/A";
        C1283.m16851(str, "currentDrmSystem: %s, previousDrmSystem: %s", objArr);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3463(Context context, AbstractC0518 r2) {
        boolean r0 = m3460(context, r2);
        m3453(context);
        return r0;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean m3460(Context context, AbstractC0518 r8) {
        if (r8 == null) {
            return false;
        }
        String r5 = r8.mo14441();
        String r6 = r8.mo14449();
        if (r5 == null) {
            if (r5 == null) {
                C1283.m16854(f4316, "We do NOT have old ESN, new installation...");
            }
            m3457(context);
            if (f4317 == null) {
                return false;
            }
            if (m3474(f4320)) {
                C1283.m16854(f4316, "Previous DRM is legacy, ESN is changed");
                return true;
            } else if (!f4318.m3486().equals(f4320)) {
                C1283.m16854(f4316, "Widevine System ID changed, ESN is changed");
                return true;
            } else {
                C1283.m16854(f4316, "Widevine System ID is NOT changed, verify if security level is changed");
                if (f4315 == f4317) {
                    C1283.m16851(f4316, "Same crypto provider %s. No change!", f4317.name());
                    return false;
                }
                C1283.m16851(f4316, "Crypto provider is changed from %s to %s", f4317.name(), f4315.name());
                return true;
            }
        } else if (r5.equals(r6)) {
            C1283.m16854(f4316, "Cached ESN is same as existing ESN");
            return false;
        } else {
            C1283.m16855(f4316, "Cached ESN %s is NOT same as existing ESN: %s", r5, r6);
            return true;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3472() {
        return f4318.f4321;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m3453(Context context) {
        C1339Bl.m4039(context, "nf_drm_system_id", f4318.m3486());
        if (f4315 != null) {
            C1339Bl.m4039(context, "nf_drm_crypto_provider", f4315.name());
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3471(Context context) {
        C1339Bl.m4041(context, "disable_widevine");
        C1339Bl.m4041(context, "nf_disable_widevine_l3_v3");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3473(Context context, AbstractC1221 r2) {
        if (r2 == null || !r2.g_()) {
            return m3450(context);
        }
        return true;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private static boolean m3450(Context context) {
        if (!C1349Bv.m4107(C1339Bl.m4045(context, "nf_drm_acckeymap", (String) null)) && !C1349Bv.m4107(C1339Bl.m4045(context, "nf_msl_store_json", (String) null))) {
            return false;
        }
        return true;
    }

    public static class iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean f4321;

        /* renamed from: ˋ  reason: contains not printable characters */
        private boolean f4322;

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f4323;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f4324;

        /* renamed from: ॱ  reason: contains not printable characters */
        private boolean f4325;

        private iF() {
            this.f4323 = "";
            this.f4325 = m3476();
            C1283.m16851(AV.f4316, "System capabilities: %s", toString());
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m3483() {
            this.f4321 = false;
            this.f4322 = true;
        }

        /* renamed from: ʽ  reason: contains not printable characters */
        private boolean m3476() {
            BL.f4583 = SystemClock.elapsedRealtime();
            if (!m3477()) {
                return BL.m3877(false);
            }
            try {
                MediaDrm mediaDrm = new MediaDrm(AV.f4319);
                try {
                    this.f4324 = mediaDrm.getPropertyString("securityLevel");
                    try {
                        this.f4323 = mediaDrm.getPropertyString("systemId");
                        m3481(mediaDrm);
                        this.f4321 = m3480(this.f4324);
                        this.f4322 = !this.f4321;
                        return BL.m3877(true);
                    } catch (Throwable th) {
                        C1283.m16847(AV.f4316, "Failed to get system ID from MediaDrm", th);
                        this.f4323 = "SYSTEMID_GET_FAILURE";
                        C1276.m16820().mo5731(th);
                        m3481(mediaDrm);
                        return BL.m3877(false);
                    }
                } catch (Throwable th2) {
                    C1283.m16847(AV.f4316, "Failed to get property security level", th2);
                    this.f4323 = "SECURITY_LEVEL_GET_FAILURE";
                    C1276.m16820().mo5731(th2);
                    m3481(mediaDrm);
                    return BL.m3877(false);
                }
            } catch (Throwable th3) {
                C1283.m16847(AV.f4316, "Failed to create MediaDrm with Widevine scheme", th3);
                C1276.m16820().mo5731(th3);
                return BL.m3877(false);
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private static boolean m3481(MediaDrm mediaDrm) {
            if (mediaDrm == null) {
                return true;
            }
            try {
                mediaDrm.release();
                return true;
            } catch (Throwable th) {
                C1283.m16847(AV.f4316, "Failed to release MediaDrm", th);
                C1283.m16850(AV.f4316, (String) null);
                C1276.m16820().mo5731(th);
                return false;
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public boolean m3484() {
            return this.f4325;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public boolean m3485() {
            return this.f4321;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m3486() {
            return this.f4323;
        }

        public String toString() {
            return "WidevineSupport{, supported=" + this.f4325 + ", isL1=" + this.f4321 + ", isL3=" + this.f4322 + ", securityLevel='" + this.f4324 + "', systemId='" + this.f4323 + "'}";
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private static boolean m3480(String str) {
            return "L1".equalsIgnoreCase(str);
        }

        @SuppressLint({"NewApi"})
        /* renamed from: ˊ  reason: contains not printable characters */
        static boolean m3477() {
            if (C1317As.m3758() >= 18) {
                return MediaDrm.isCryptoSchemeSupported(AV.f4319);
            }
            return false;
        }
    }
}
