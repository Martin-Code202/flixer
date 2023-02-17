package o;

import android.os.Handler;
import android.os.HandlerThread;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixImmutableStatus;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadVideoQuality;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: o.id  reason: case insensitive filesystem */
public class C1877id implements hX {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1615ci f7719;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final iT f7720;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Map<String, jG> f7721 = new HashMap();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Handler f7722;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map<String, hY> f7723 = new HashMap();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final IClientLogging f7724;

    public C1877id(iT iTVar, HandlerThread handlerThread, AbstractC1615ci ciVar, IClientLogging iClientLogging) {
        this.f7720 = iTVar;
        this.f7719 = ciVar;
        this.f7724 = iClientLogging;
        this.f7722 = new Handler(handlerThread.getLooper());
    }

    @Override // o.hX
    /* renamed from: ˏ */
    public void mo7001(String str, String str2, String str3, String str4, hY hYVar) {
        C1283.m16862("nf_offlineManifestMgr", "requestOfflineManifestFromCache playableId=" + str);
        Status status = AbstractC0367.f13235;
        jG r4 = m7671(str, str2, str3, str4);
        if (r4 == null) {
            status = new NetflixStatus(StatusCode.DL_MANIFEST_NOT_FOUND_IN_CACHE);
        }
        if (hYVar != null) {
            hYVar.mo6918(r4, status);
        }
    }

    @Override // o.hX
    /* renamed from: ˏ */
    public void mo7002(final String str, final String str2, final String str3, final C1618cl clVar, final String str4, DownloadVideoQuality downloadVideoQuality, hY hYVar) {
        C1283.m16862("nf_offlineManifestMgr", "requestOfflineManifestFromServer playableId=" + str);
        this.f7721.remove(str);
        this.f7723.put(str, hYVar);
        this.f7720.m7565(str, str2, str3, downloadVideoQuality, new AbstractC1903jd() { // from class: o.id.2
            @Override // o.AbstractC1903jd, o.iX
            /* renamed from: ˊ */
            public void mo7615(final JSONObject jSONObject, final Status status) {
                C1877id.this.f7722.post(new Runnable() { // from class: o.id.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        C1877id.this.m7675(status, str, str4, true, jSONObject, str2, str3, clVar);
                    }
                });
            }
        });
    }

    @Override // o.hX
    /* renamed from: ˊ */
    public void mo6999(final String str, final String str2, final String str3, final String str4, final String str5, final DownloadVideoQuality downloadVideoQuality, final hY hYVar) {
        C1283.m16862("nf_offlineManifestMgr", "requestOfflineManifestRefreshFromServer playableId=" + str);
        mo7001(str, str2, str3, str4, new hY() { // from class: o.id.1
            @Override // o.hY
            /* renamed from: ˊ */
            public void mo6918(jG jGVar, final Status status) {
                C1877id.this.f7721.remove(str);
                C1877id.this.f7723.put(str, hYVar);
                if (!status.mo298() || jGVar == null) {
                    C1877id.this.f7722.post(new Runnable() { // from class: o.id.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            C1877id.this.m7675(status, str, str4, false, null, str2, str3, null);
                        }
                    });
                } else {
                    C1877id.this.f7720.m7571(str, str2, str3, str5, downloadVideoQuality, jGVar, new AbstractC1903jd() { // from class: o.id.1.4
                        @Override // o.AbstractC1903jd, o.iX
                        /* renamed from: ˊ */
                        public void mo7615(final JSONObject jSONObject, final Status status2) {
                            C1877id.this.f7722.post(new Runnable() { // from class: o.id.1.4.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    C1877id.this.m7675(status2, str, str4, false, jSONObject, str2, str3, null);
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7675(Status status, String str, String str2, boolean z, JSONObject jSONObject, String str3, String str4, C1618cl clVar) {
        Status status2 = status;
        hY remove = this.f7723.remove(str);
        if (remove == null) {
            C1283.m16862("nf_offlineManifestMgr", "onManifestsFetched but no callback");
            return;
        }
        jG jGVar = null;
        if (status2.mo298()) {
            C0127 r9 = m7667(jSONObject);
            status2 = r9.f7750;
            jGVar = r9.f7751;
            if (status2.mo298()) {
                status2 = m7666(str, str3, str4, str2, jSONObject);
            }
            if (status2.mo298()) {
                if (!new File(C1888ip.m7719(str2, str)).exists()) {
                    C1276.m16820().mo5731(new Throwable("handleManifestResponse manifest gone:"));
                }
                m7676(str, r9.f7751);
                if (z) {
                    this.f7719.mo5846(str, str3, str4, clVar, r9.f7751.mo7915());
                }
            }
        }
        if (status2.mo301()) {
            hW.m6997(this.f7724.mo1512(), str, str3, str4, status2);
        }
        remove.mo6918(jGVar, status2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Status m7666(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        NetflixImmutableStatus netflixImmutableStatus = AbstractC0367.f13235;
        String r5 = C1888ip.m7719(str4, str);
        C1283.m16863("nf_offlineManifestMgr", "filepath for manifest=%s", r5);
        String jSONObject2 = jSONObject.toString();
        boolean z = false;
        try {
            z = AH.m3349(r5, jSONObject2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            C1276.m16820().mo5731(new Throwable("persistManifest unsupported encoding"));
        }
        if (!z) {
            return new NetflixStatus(StatusCode.DL_CANT_PERSIST_MANIFEST);
        }
        hW.m6992(this.f7724.mo1512(), str, str2, str3, r5 + ", inputLen=" + jSONObject2.length() + ", fileLength=" + new File(r5).length());
        return netflixImmutableStatus;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private C0127 m7667(JSONObject jSONObject) {
        C0127 r2 = new C0127();
        List<jG> r3 = jG.m7904(jSONObject);
        if (r3 == null || r3.size() <= 0) {
            C1283.m16850("nf_offlineManifestMgr", "manifest parse error");
            r2.f7750 = new NetflixStatus(StatusCode.RESPONSE_PARSE_ERROR);
        } else {
            r2.f7750 = AbstractC0367.f13235;
            r2.f7751 = r3.get(0);
        }
        return r2;
    }

    @Override // o.hX
    /* renamed from: ˎ */
    public void mo7000(String str) {
        this.f7723.remove(str);
        this.f7721.remove(str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private jG m7671(String str, String str2, String str3, String str4) {
        jG jGVar = this.f7721.get(str);
        if (jGVar == null && (jGVar = m7668(str, str2, str3, str4)) != null) {
            m7676(str, jGVar);
        }
        return jGVar;
    }

    @Override // o.hX
    /* renamed from: ॱ */
    public void mo7004(String str) {
        this.f7721.remove(str);
        this.f7723.remove(str);
    }

    @Override // o.hX
    /* renamed from: ॱ */
    public void mo7003(int i) {
        if (i >= 60) {
            this.f7722.post(new Runnable() { // from class: o.id.5
                @Override // java.lang.Runnable
                public void run() {
                    C1877id.this.f7721.clear();
                }
            });
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private jG m7668(String str, String str2, String str3, String str4) {
        File file = new File(C1888ip.m7719(str4, str));
        if (!file.exists()) {
            C1276.m16820().mo5731(new Throwable("oxId=" + str2 + " readManifestFromPersistentStore file not found " + file.getAbsolutePath()));
            C1283.m16850("nf_offlineManifestMgr", "readManifestFromPersistentStore file not found=" + file.getAbsolutePath());
            hW.m6990(this.f7724.mo1512(), str, str2, str3, file.getAbsolutePath());
            return null;
        }
        try {
            List<jG> r9 = jG.m7904(new JSONObject(C1349Bv.m4111(AH.m3345(file), "utf-8")));
            if (r9 != null && r9.size() > 0) {
                return r9.get(0);
            }
            C1276.m16820().mo5731(new Throwable(r9 == null ? "nfManifestList is null" : "nfManifestList size=" + r9.size()));
            return null;
        } catch (Exception e) {
            C1276.m16820().mo5731(new Throwable("readManifestFromPersistentStore Exception:", e));
            C1283.m16847("nf_offlineManifestMgr", "readManifestFromPersistentStore read error", e);
            return null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7676(String str, jG jGVar) {
        if (this.f7721.size() >= 10) {
            m7669();
        }
        this.f7721.put(str, jGVar);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7669() {
        String str = null;
        long j = 2147483647L;
        for (Map.Entry<String, jG> entry : this.f7721.entrySet()) {
            if (str == null) {
                str = entry.getKey();
            }
            long r7 = entry.getValue().m7912();
            if (entry.getValue().m7912() < j) {
                j = r7;
                str = entry.getKey();
            }
        }
        if (str != null) {
            this.f7721.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.id$ˊ  reason: contains not printable characters */
    public class C0127 {

        /* renamed from: ˏ  reason: contains not printable characters */
        public Status f7750 = AbstractC0367.f13235;

        /* renamed from: ॱ  reason: contains not printable characters */
        public jG f7751 = null;

        C0127() {
        }
    }
}
