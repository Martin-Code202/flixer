package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.AbstractC1853hl;
import org.json.JSONObject;
/* renamed from: o.cm  reason: case insensitive filesystem */
public class C1619cm implements AbstractC1854hm {

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String f6276 = "errorMessage";

    /* renamed from: ʼ  reason: contains not printable characters */
    private static final String f6277 = C1619cm.class.getSimpleName();

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String f6278 = "errorCode";

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String f6279 = "com.netflix.mediaclient.intent.action.LICENSE_ERROR";

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String f6280 = "com.netflix.mediaclient.intent.action.DOWNLOAD_ERROR";

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String f6281 = "com.netflix.mediaclient.intent.category.PDSLOG_DOWNLOAD";

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String f6282 = "com.netflix.mediaclient.intent.action.MANIFEST_EXPIRED";

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static String f6283 = "playableId";

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private AbstractC1853hl f6284;

    /* renamed from: ʽ  reason: contains not printable characters */
    oQ f6285;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private Object f6286 = new Object();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private IClientLogging f6287;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f6288;

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f6289;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Map<String, C1624cp> f6290 = new HashMap();

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final BroadcastReceiver f6291 = new BroadcastReceiver() { // from class: o.cm.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1283.m16848(C1619cm.f6277, "Received intent %s", intent);
            if (intent != null) {
                String stringExtra = intent.getStringExtra(C1619cm.f6283);
                String stringExtra2 = intent.getStringExtra(C1619cm.f6278);
                String stringExtra3 = intent.getStringExtra(C1619cm.f6276);
                C1624cp r8 = C1619cm.this.m5870(stringExtra);
                if (r8 == null) {
                    C1283.m16844(C1619cm.f6277, "playable: %s - no session, dropping intent %s", stringExtra, intent.getAction());
                    return;
                }
                String action = intent.getAction();
                if (C1619cm.f6279.equals(action)) {
                    r8.m5926(stringExtra2, stringExtra3);
                } else if (C1619cm.f6282.equals(action)) {
                    r8.m5923(stringExtra2, stringExtra3);
                } else if (C1619cm.f6280.equals(action)) {
                    r8.m5921(stringExtra2, stringExtra3);
                } else {
                    C1283.m16851(C1619cm.f6277, "We do not support action :%s ", action);
                }
            }
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    M f6292;

    /* renamed from: o.cm$ˊ  reason: contains not printable characters */
    public interface AbstractC0105 {
        /* renamed from: ˊ */
        void mo5887(C1624cp cpVar);
    }

    public C1619cm(Context context, AbstractC1853hl hlVar, IClientLogging iClientLogging) {
        this.f6287 = iClientLogging;
        this.f6284 = hlVar;
        this.f6285 = iClientLogging.mo1512();
        this.f6292 = iClientLogging.mo1506();
        m5868(context);
        C1283.m16854(f6277, "inited download session manager");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5885() {
        this.f6288 = this.f6287.mo1520();
        this.f6289 = this.f6287.mo1517();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5883(Context context) {
        m5875(context);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5884(String str, String str2, String str3, C1618cl clVar, JSONObject jSONObject) {
        m5877(str);
        C1283.m16851(f6277, "setOfflineManifest playableId: %s, oxid: %s, dxid: %s", str, str2, str3);
        m5865(str, str2, str3, clVar, jSONObject).m5925();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˊ */
    public void mo2173(String str) {
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ॱ */
    public void mo2185(String str, Status status) {
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˏ */
    public void mo2181(pV pVVar, final int i) {
        C1624cp r1 = m5872(pVVar);
        if (r1.m5919()) {
            m5882(r1, new AbstractC0105() { // from class: o.cm.4
                @Override // o.C1619cm.AbstractC0105
                /* renamed from: ˊ  reason: contains not printable characters */
                public void mo5887(C1624cp cpVar) {
                    C1619cm.this.m5879(cpVar, i);
                }
            });
        } else {
            m5879(r1, i);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5879(C1624cp cpVar, int i) {
        if (cpVar.m5934()) {
            cpVar.m5924(false);
            cpVar.m5922();
        }
        cpVar.m5929(i);
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˊ */
    public void mo2174(pV pVVar) {
        C1624cp r1 = m5872(pVVar);
        if (r1.m5919()) {
            m5882(r1, new AbstractC0105() { // from class: o.cm.5
                @Override // o.C1619cm.AbstractC0105
                /* renamed from: ˊ */
                public void mo5887(C1624cp cpVar) {
                    C1619cm.this.m5878(cpVar);
                }
            });
        } else {
            m5878(r1);
        }
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo2175(pV pVVar) {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5878(C1624cp cpVar) {
        cpVar.m5920();
        m5877(cpVar.m5931());
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo2177(pV pVVar, StopReason stopReason) {
        C1624cp r4 = m5870(pVVar.mo6915());
        if (r4 != null) {
            switch (stopReason) {
                case Unknown:
                case WaitingToBeStarted:
                case NetworkError:
                case ManifestError:
                case StorageError:
                case NotEnoughSpace:
                case PlayerStreaming:
                case AccountInActive:
                case EncodesAreNotAvailableAnyMore:
                case GeoCheckError:
                case DownloadLimitRequiresManualResume:
                case EncodesRevoked:
                    return;
                case NoNetworkConnectivity:
                case StoppedFromAgentAPI:
                case NotAllowedOnCurrentNetwork:
                    r4.m5924(true);
                    r4.m5928();
                    return;
                default:
                    C1283.m16851(f6277, " onDownloadStopped stopReason: %s, no-op", stopReason);
                    return;
            }
        }
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˏ */
    public void mo2180(String str, Status status, boolean z) {
        m5873(str, status);
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˎ */
    public void mo2178(List<String> list, Status status) {
        for (String str : list) {
            m5873(str, status);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5873(String str, Status status) {
        m5869(str, status);
        m5877(str);
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo1758(Status status) {
        m5876(status);
        m5874();
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ॱ */
    public void mo2184(Status status) {
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo2176(pV pVVar, Status status) {
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˎ */
    public void mo2179(pV pVVar, Status status) {
    }

    @Override // o.AbstractC1854hm
    /* renamed from: ˏ */
    public void mo2182(boolean z) {
    }

    @Override // o.AbstractC1854hm
    public boolean aa_() {
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private C1624cp m5870(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return this.f6290.get(str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1624cp m5872(pV pVVar) {
        C1624cp r6 = m5870(pVVar.mo6915());
        if (r6 != null) {
            return r6;
        }
        return m5865(pVVar.mo6915(), pVVar.mo6913(), pVVar.mo6882(), C1618cl.m5855(pVVar), null);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5874() {
        synchronized (this.f6286) {
            this.f6290.clear();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5876(Status status) {
        for (C1624cp cpVar : this.f6290.values()) {
            cpVar.m5930(status.mo302().toString(), status.mo307());
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5869(String str, Status status) {
        C1624cp cpVar = this.f6290.get(str);
        if (cpVar != null) {
            cpVar.m5930(status.mo302().toString(), status.mo307());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5877(String str) {
        synchronized (this.f6286) {
            if (this.f6290.containsKey(str)) {
                this.f6290.remove(str);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5871(String str, C1624cp cpVar) {
        synchronized (this.f6286) {
            this.f6290.put(str, cpVar);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private C1624cp m5865(String str, String str2, String str3, C1618cl clVar, JSONObject jSONObject) {
        C1624cp r7 = new C1624cp(str, str2, str3, this.f6288, this.f6289, this.f6292).m5932(clVar).m5927(jSONObject);
        m5871(str, r7);
        return r7;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5882(C1624cp cpVar, final AbstractC0105 r5) {
        cpVar.m5933(true);
        this.f6284.mo7142(cpVar.m5931(), new AbstractC1853hl.Cif() { // from class: o.cm.2
            @Override // o.AbstractC1853hl.Cif
            /* renamed from: ॱ  reason: contains not printable characters */
            public void mo5886(String str, C1862ht htVar, Status status) {
                C1624cp r6 = C1619cm.this.m5870(str);
                if (r6 != null) {
                    r6.m5933(false);
                    if (r6 != null && htVar != null && htVar.m7352() != null) {
                        C1283.m16851(C1619cm.f6277, "got manifestFromCache :%s - setting links and sendng pds resume", str);
                        r6.m5927(htVar.m7352());
                        if (r5 != null) {
                            r5.mo5887(r6);
                        }
                    }
                } else if (htVar != null) {
                    C1619cm.this.m5865(str, htVar.m7350(), htVar.m7349(), htVar.m7351(), htVar.m7352());
                } else {
                    C1283.m16844(C1619cm.f6277, "error receiving manifest from cache movieId=%s status=%s", str, status.toString());
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5868(Context context) {
        C1283.m16854(f6277, "Register receiver");
        AG.m3334(context, this.f6291, f6281, f6280, f6282, f6279);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5875(Context context) {
        AG.m3329(context, this.f6291);
    }
}
