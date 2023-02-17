package com.netflix.mediaclient.ui.error;

import android.content.Context;
import android.media.MediaDrm;
import android.os.SystemClock;
import android.util.Log;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import com.netflix.mediaclient.service.error.crypto.ErrorSource;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.ui.error.CryptoErrorManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import o.AV;
import o.AbstractC0476;
import o.AbstractC1268;
import o.AbstractC1578c;
import o.AbstractC1853hl;
import o.AbstractC2049oy;
import o.AbstractC2068pq;
import o.C0480;
import o.C1061;
import o.C1283;
import o.C1317As;
import o.C1339Bl;
import o.C1349Bv;
import o.oH;
import o.rG;
import o.vO;
import org.json.JSONArray;
import org.json.JSONObject;
public enum CryptoErrorManagerImpl implements CryptoErrorManager {
    INSTANCE;
    

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String f2987 = "nf_crypto_error";

    /* renamed from: ˏ  reason: contains not printable characters */
    private static long f2988 = 3600000;

    /* renamed from: ʻ  reason: contains not printable characters */
    private AbstractC2049oy f2990;

    /* renamed from: ʼ  reason: contains not printable characters */
    private AbstractC1853hl f2991;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f2992;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private AtomicBoolean f2993 = new AtomicBoolean(false);

    /* renamed from: ˎ  reason: contains not printable characters */
    private UserAgentInterface f2994;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private Runnable f2995;

    /* renamed from: ͺ  reason: contains not printable characters */
    private List<Cif> f2996 = new ArrayList();

    /* renamed from: ॱ  reason: contains not printable characters */
    private Context f2997;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private oH f2998;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AtomicBoolean f2999 = new AtomicBoolean(false);

    private CryptoErrorManagerImpl() {
    }

    @Override // com.netflix.mediaclient.ui.error.CryptoErrorManager
    /* renamed from: ॱ */
    public synchronized void mo1739(Context context, long j, UserAgentInterface userAgentInterface, AbstractC1853hl hlVar, oH oHVar, AbstractC2049oy oyVar) {
        if (hlVar == null) {
            throw new IllegalArgumentException("CryptoErrorManagerImpl can not be initialized with null offline agent!");
        } else if (oHVar == null) {
            throw new IllegalArgumentException("CryptoErrorManagerImpl can not be initialized with null error handler!");
        } else if (oyVar == null) {
            throw new IllegalArgumentException("CryptoErrorManagerImpl can not be initialized with null error logger!");
        } else {
            this.f2997 = context;
            this.f2994 = userAgentInterface;
            this.f2998 = oHVar;
            this.f2990 = oyVar;
            this.f2992 = j;
            this.f2991 = hlVar;
            m1754();
        }
    }

    @Override // com.netflix.mediaclient.ui.error.CryptoErrorManager
    /* renamed from: ˏ */
    public synchronized void mo1737(ErrorSource errorSource, StatusCode statusCode, Throwable th) {
        AbstractC1578c r2 = rG.m10145(errorSource, statusCode);
        if (r2 == null) {
            this.f2990.mo5714(m1752(statusCode, th));
            return;
        }
        AbstractC1268 r3 = r2.mo5807(this.f2997, th);
        if (r3 != null) {
            if (this.f2998 != null) {
                this.f2998.mo5362(r3);
            }
        }
    }

    @Override // com.netflix.mediaclient.ui.error.CryptoErrorManager
    /* renamed from: ॱ */
    public CryptoErrorManager.CryptoFailback mo1738() {
        CryptoErrorManager.CryptoFailback cryptoFailback;
        String str;
        CryptoProvider r5 = C0480.m14409();
        if (r5 == CryptoProvider.WIDEVINE_L1) {
            cryptoFailback = CryptoErrorManager.CryptoFailback.widevineL3;
            str = "MediaDrm failed for Widevine L1, fail back to Widevine L3 crypto scheme";
            C1283.m16854(f2987, str);
            C1339Bl.m4048(this.f2997, "disable_widevine", true);
            m1753();
            m1748();
        } else if (r5 == CryptoProvider.WIDEVINE_L3) {
            str = "MediaDrm failed for Widevine L3, there is nothing to fail back to anymore";
            C1283.m16854(f2987, str);
            m1753();
            cryptoFailback = CryptoErrorManager.CryptoFailback.widevineL3Failed;
        } else {
            str = "Crypto provider was not supported for this error " + r5;
            C1283.m16850(f2987, str);
            cryptoFailback = CryptoErrorManager.CryptoFailback.uknown;
        }
        this.f2990.mo5714(str);
        return cryptoFailback;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1748() {
        if (m1741()) {
            this.f2991.mo7124(new AbstractC2068pq() { // from class: com.netflix.mediaclient.ui.error.CryptoErrorManagerImpl.2
                @Override // o.AbstractC2068pq, o.AbstractC1854hm
                /* renamed from: ˋ  reason: contains not printable characters */
                public void mo1758(Status status) {
                    if (status.mo298()) {
                        C1283.m16854(CryptoErrorManagerImpl.f2987, "Offline content removed!");
                    } else {
                        C1283.m16850(CryptoErrorManagerImpl.f2987, "Failed to remove offline content!");
                    }
                    synchronized (CryptoErrorManagerImpl.this.f2993) {
                        CryptoErrorManagerImpl.this.f2991.mo7135(this);
                        if (CryptoErrorManagerImpl.this.f2995 != null) {
                            CryptoErrorManagerImpl.this.f2995.run();
                            CryptoErrorManagerImpl.this.f2995 = null;
                        }
                        CryptoErrorManagerImpl.this.f2993.set(false);
                    }
                }

                @Override // o.AbstractC1854hm
                public boolean aa_() {
                    return false;
                }
            });
            this.f2993.set(true);
            this.f2991.mo7125();
            C1061.m16114().mo14165();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m1757(Runnable runnable) {
        synchronized (this.f2993) {
            if (this.f2993.get()) {
                this.f2995 = runnable;
            }
        }
        return this.f2993.get();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean m1741() {
        return vO.m12029(this.f2991).mo4074() > 0;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m1753() {
        this.f2996.clear();
        C1339Bl.m4041(this.f2997, "prefs_crypto_fatal_errors");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC2049oy m1755() {
        return this.f2990;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m1752(StatusCode statusCode, Throwable th) {
        StringBuilder sb = new StringBuilder("MediaDrm failure: ");
        sb.append(statusCode.name()).append(". Exception: ");
        if (th == null) {
            sb.append(" init failure: security level changed");
        } else {
            sb.append(Log.getStackTraceString(th));
        }
        return sb.toString();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m1749(StatusCode statusCode, Throwable th, int i) {
        StringBuilder sb = new StringBuilder("MediaDrm failure: ");
        sb.append(statusCode.name()).append(". ResourceBusyException: SPY-12568");
        sb.append("MaxMslSessionOpened [").append(i).append("] ");
        sb.append("CurrentOpenedMslDrmSessionCount [").append(AbstractC0476.f13528).append("] ");
        if (C1317As.m3766()) {
            try {
                MediaDrm r4 = AV.m3455((MediaDrm.OnEventListener) null);
                sb.append("maxNumberOfSessions [").append(Integer.valueOf(r4.getPropertyString("maxNumberOfSessions")).intValue()).append("] ");
                sb.append("numberOfOpenSessions [").append(Integer.valueOf(r4.getPropertyString("numberOfOpenSessions")).intValue()).append("] ");
                r4.release();
            } catch (Exception e) {
                C1283.m16856(f2987, e, "ignore exception when createResourceBusyExceptionErrorMessage.", new Object[0]);
            }
        }
        return sb.toString();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m1754() {
        String r5 = C1339Bl.m4045(this.f2997, "prefs_crypto_fatal_errors", (String) null);
        if (!C1349Bv.m4113(r5)) {
            try {
                JSONArray jSONArray = new JSONArray(r5);
                int i = 0;
                while (i < jSONArray.length()) {
                    Cif ifVar = new Cif(jSONArray.getJSONObject(i));
                    if (ifVar.m1761()) {
                        this.f2996.add(ifVar);
                    } else {
                        i++;
                        C1283.m16851(f2987, "Ignore, occured to long ago: %s: ", Integer.valueOf(i), ifVar.toString());
                    }
                    i++;
                }
            } catch (Throwable th) {
                C1283.m16856(f2987, th, "Fail to restore crypto error state.", new Object[0]);
            }
            m1742();
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m1742() {
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m1740() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (Cif ifVar : this.f2996) {
                jSONArray.put(ifVar.m1760());
            }
            C1339Bl.m4039(this.f2997, "prefs_crypto_fatal_errors", jSONArray.toString());
        } catch (Throwable th) {
            C1283.m16856(f2987, th, "Fail to save crypto error state!", new Object[0]);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized int m1756(ErrorSource errorSource, StatusCode statusCode) {
        if (this.f2999.get()) {
            C1283.m16865(f2987, "Crypto fallback in progress. We should not see this. Do not add error. Return crypto failback message. Next app start will see different crypto...");
            return R.string.label_drm_failed_fallback;
        }
        Cif r4 = m1745();
        int i = R.string.label_drm_failed_restart_app;
        if (r4 == null || !r4.m1761()) {
            C1283.m16854(f2987, "Did not had previous valid fatal error, just tell user to start app again");
            i = R.string.label_drm_failed_restart_app;
        } else if (this.f2996.size() < 1) {
            C1283.m16854(f2987, "Did not had previous valid fatal error, just tell user to start app again");
            i = R.string.label_drm_failed_restart_app;
        } else if (this.f2996.size() == 1) {
            if (r4.m1759(this.f2992)) {
                C1283.m16865(f2987, "Found previous valid fatal error, but it from this same app instance, do not add it again. It should NOT happen. Return message to start app again.");
                return R.string.label_drm_failed_restart_app;
            }
            C1283.m16865(f2987, "Found previous valid fatal error, app was restarted and we failed again, Tell user to restart device.");
            i = R.string.label_drm_failed_restart_device;
        } else if (this.f2996.size() >= 2) {
            if (r4.m1759(this.f2992)) {
                C1283.m16865(f2987, "Found previous valid fatal error, but it from this same app instance, do not add it again. It should NOT happen. Return message to start app again.");
                return R.string.label_drm_failed_restart_device;
            }
            C1283.m16865(f2987, "Found previous valid fatal error, app was restarted and than rebooted and each time we failed again, Fallback...");
            if (mo1738() == CryptoErrorManager.CryptoFailback.widevineL3) {
                C1283.m16854(f2987, "Failback to Widevine L3.");
                return R.string.label_drm_failed_fallback_w3;
            }
            C1283.m16854(f2987, "Widenvine L3 failed, noshere to fail back...");
            return R.string.label_drm_failed_fallback_legacy;
        }
        this.f2996.add(new Cif(errorSource, statusCode, this.f2992));
        m1740();
        return i;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private synchronized Cif m1745() {
        if (this.f2996.size() < 1) {
            return null;
        }
        return this.f2996.get(this.f2996.size() - 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.ui.error.CryptoErrorManagerImpl$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        StatusCode f3001;

        /* renamed from: ˋ  reason: contains not printable characters */
        long f3002;

        /* renamed from: ˎ  reason: contains not printable characters */
        long f3003;

        /* renamed from: ˏ  reason: contains not printable characters */
        long f3004;

        /* renamed from: ॱ  reason: contains not printable characters */
        ErrorSource f3005;

        Cif(ErrorSource errorSource, StatusCode statusCode, long j) {
            this.f3005 = errorSource;
            this.f3001 = statusCode;
            this.f3004 = System.currentTimeMillis();
            this.f3003 = SystemClock.elapsedRealtime();
            this.f3002 = j;
        }

        Cif(JSONObject jSONObject) {
            this.f3004 = jSONObject.getLong("ts");
            this.f3003 = jSONObject.getLong("up");
            this.f3002 = jSONObject.getLong("appStartupTime");
            this.f3005 = ErrorSource.valueOf(jSONObject.getString("src"));
            this.f3001 = StatusCode.m264(jSONObject.getInt("cause"));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public JSONObject m1760() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", this.f3004);
            jSONObject.put("appStartupTime", this.f3002);
            jSONObject.put("up", this.f3003);
            jSONObject.put("src", this.f3005.name());
            jSONObject.put("cause", this.f3001.m271());
            return jSONObject;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean m1759(long j) {
            return this.f3002 == j;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public boolean m1761() {
            return this.f3004 + CryptoErrorManagerImpl.f2988 > System.currentTimeMillis();
        }

        public String toString() {
            return "FatalCryptoError{timestamp=" + this.f3004 + ", howLongDeviceWasUpInMs=" + this.f3003 + ", appStartupTimeInMs=" + this.f3002 + ", errorSource=" + this.f3005 + ", statusCode=" + this.f3001 + '}';
        }
    }
}
