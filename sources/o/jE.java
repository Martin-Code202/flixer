package o;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.jD;
import org.json.JSONObject;
public class jE implements jF {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f7873 = jE.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Handler f7874;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final HandlerThread f7875;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final iT f7876;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final Map<If, C0129> f7877 = new HashMap();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Handler f7878;

    /* renamed from: ˎ  reason: contains not printable characters */
    private ConnectivityUtils.NetType f7879;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f7880 = 20;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final List<Long> f7881 = new ArrayList();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Context f7882;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Map<If, jG> f7883 = new HashMap();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f7884 = "";

    /* access modifiers changed from: package-private */
    public static class If {

        /* renamed from: ˋ  reason: contains not printable characters */
        final long f7920;

        /* renamed from: ˏ  reason: contains not printable characters */
        final ConnectivityUtils.NetType f7921;

        /* renamed from: ॱ  reason: contains not printable characters */
        final String f7922;

        public If(long j, ConnectivityUtils.NetType netType, String str) {
            this.f7920 = j;
            this.f7921 = netType;
            this.f7922 = str != null ? str : "";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            If r4 = (If) obj;
            return this.f7920 == r4.f7920 && this.f7921 == r4.f7921 && this.f7922.equals(r4.f7922);
        }

        public int hashCode() {
            return ((this.f7921 != null ? (((int) (this.f7920 ^ (this.f7920 >>> 32))) * 31) + this.f7921.hashCode() : 0) * 31) + this.f7922.hashCode();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public static If m7892(List<If> list, long j) {
            for (If r6 : list) {
                C1283.m16863(jE.f7873, "getManifestKey %d", Long.valueOf(r6.f7920));
                if (r6.f7920 == j) {
                    return r6;
                }
            }
            return null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7891() {
        m7886();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m7886() {
        ConnectivityUtils.NetType r5 = ConnectivityUtils.m2958(this.f7882);
        if (r5 != null) {
            this.f7879 = r5;
            switch (this.f7879) {
                case wifi:
                    this.f7884 = ConnectivityUtils.m2962(ConnectivityUtils.m2961(this.f7882));
                    break;
                case mobile:
                    this.f7884 = ConnectivityUtils.m2963((TelephonyManager) this.f7882.getSystemService("phone"));
                    break;
                case wired:
                default:
                    this.f7884 = "";
                    break;
            }
            C1283.m16863(f7873, "updateCurrentNetworkType %s %s", this.f7879, this.f7884);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.jE$ˋ  reason: contains not printable characters */
    public class C0129 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private PlayerPrefetchSource f7923;

        /* renamed from: ˋ  reason: contains not printable characters */
        private List<jD.If> f7924;

        C0129(PlayerPrefetchSource playerPrefetchSource) {
            this.f7923 = playerPrefetchSource;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public void m7895(PlayerPrefetchSource playerPrefetchSource) {
            this.f7923 = playerPrefetchSource;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public void m7894(jD.If r2) {
            if (this.f7924 == null) {
                this.f7924 = new ArrayList();
            }
            if (r2 != null) {
                this.f7924.add(r2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public List<jD.If> m7893() {
            return this.f7924;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ॱ  reason: contains not printable characters */
        public PlayerPrefetchSource m7896() {
            return this.f7923;
        }
    }

    public jE(Context context, Looper looper, iT iTVar, boolean z) {
        this.f7882 = context;
        this.f7878 = new Handler(looper);
        this.f7876 = iTVar;
        this.f7875 = new HandlerThread("NfManifestCacheWorkerThread", 0);
        this.f7875.start();
        this.f7874 = new Handler(this.f7875.getLooper());
        if (z) {
            this.f7880 = 10;
        }
        m7886();
    }

    @Override // o.jD
    /* renamed from: ˋ */
    public void mo7860(final Long l, final jD.If r10, final boolean z) {
        final If r7 = new If(l.longValue(), this.f7879, this.f7884);
        this.f7878.post(new Runnable() { // from class: o.jE.5
            @Override // java.lang.Runnable
            public void run() {
                jE.this.f7881.remove(l);
            }
        });
        this.f7874.post(new Runnable() { // from class: o.jE.8
            @Override // java.lang.Runnable
            public void run() {
                jG jGVar = (jG) jE.this.f7883.get(r7);
                if (jGVar != null && jGVar.m7914() <= 0) {
                    C1283.m16862(jE.f7873, "ignoring expired manifest");
                    jGVar = null;
                }
                if (jGVar != null) {
                    jE.this.m7871(r7, jGVar, r10);
                    jE.this.m7861();
                    C1283.m16851(jE.f7873, "manifest available for %d", l);
                    return;
                }
                jE.this.m7879(r7, r10, z);
            }
        });
    }

    @Override // o.jD
    /* renamed from: ˋ */
    public void mo7859(final Long l) {
        this.f7878.post(new Runnable() { // from class: o.jE.7
            @Override // java.lang.Runnable
            public void run() {
                if (!jE.this.f7881.contains(l)) {
                    jE.this.f7881.add(l);
                }
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7888(final List<C2054pc> list) {
        if (list.size() == 0) {
            C1283.m16854(f7873, "prepare has list contains no movie");
        } else {
            this.f7874.post(new Runnable() { // from class: o.jE.10
                @Override // java.lang.Runnable
                public void run() {
                    jE.this.m7876(list);
                }
            });
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7890() {
        C1283.m16854(f7873, "clear all manifest");
        this.f7874.post(new Runnable() { // from class: o.jE.9
            @Override // java.lang.Runnable
            public void run() {
                jE.this.f7883.clear();
                jE.this.f7877.clear();
            }
        });
        this.f7878.post(new Runnable() { // from class: o.jE.6
            @Override // java.lang.Runnable
            public void run() {
                jE.this.f7881.clear();
            }
        });
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7889() {
        this.f7875.quit();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7887() {
        m7890();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7879(If r8, jD.If r9, boolean z) {
        C0129 r5 = this.f7877.get(r8);
        if (r5 != null) {
            C1283.m16851(f7873, "fetchStreamingManifests is pending %d ...", Long.valueOf(r8.f7920));
            boolean z2 = true;
            if (z) {
                C1283.m16851(f7873, "fetchStreamingManifests is pending %d, try STANDARD request for playback.", Long.valueOf(r8.f7920));
                z2 = !this.f7876.m7569(r8.f7920, m7881(r8, r9));
            }
            if (z2) {
                r5.m7894(r9);
                return;
            }
            return;
        }
        this.f7876.m7572(new Long[]{Long.valueOf(r8.f7920)}, z ? IBladeRunnerClient.ManifestRequestFlavor.STANDARD : IBladeRunnerClient.ManifestRequestFlavor.PREFETCH, m7881(r8, r9));
        this.f7874.post(new Runnable() { // from class: o.jE.15
            @Override // java.lang.Runnable
            public void run() {
                jE.this.m7861();
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC1903jd m7881(final If r2, final jD.If r3) {
        return new AbstractC1903jd() { // from class: o.jE.13
            @Override // o.AbstractC1903jd, o.iX
            /* renamed from: ˊ */
            public void mo7615(final JSONObject jSONObject, final Status status) {
                jE.this.f7874.post(new Runnable() { // from class: o.jE.13.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!status.mo298() || jSONObject == null) {
                            C1283.m16854(jE.f7873, "fetchStreamingManifests failed");
                            jE.this.m7878(r2, r3, status);
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(r2);
                        jE.this.m7863(arrayList, jSONObject);
                        jG jGVar = (jG) jE.this.f7883.get(r2);
                        if (jGVar != null) {
                            jE.this.m7871(r2, jGVar, r3);
                        } else {
                            jE.this.m7878(r2, r3, new NetflixStatus(StatusCode.MANIFEST_PARSE_ERROR));
                        }
                    }
                });
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7876(List<C2054pc> list) {
        final ArrayList<If> arrayList = new ArrayList();
        for (C2054pc pcVar : list) {
            If r8 = new If(pcVar.f9381, this.f7879, this.f7884);
            jG jGVar = this.f7883.get(r8);
            if (jGVar != null) {
                if (jGVar.m7914() > 0) {
                    C1283.m16851(f7873, "skip cached manifest for %d life=%d", Long.valueOf(pcVar.f9381), Long.valueOf(jGVar.m7914()));
                    this.f7883.get(r8).m7923(pcVar.f9380);
                } else {
                    m7861();
                }
            } else if (this.f7877.get(r8) != null) {
                C1283.m16851(f7873, "skip pending manifest for %d", Long.valueOf(pcVar.f9381));
                this.f7877.get(r8).m7895(pcVar.f9380);
            }
            arrayList.add(r8);
            this.f7877.put(r8, new C0129(pcVar.f9380));
            C1283.m16851(f7873, "will fetch manifest for %d", Long.valueOf(pcVar.f9381));
        }
        if (arrayList.size() == 0) {
            C1283.m16854(f7873, "prepare no manifest to fetch");
            return;
        }
        Long[] lArr = new Long[arrayList.size()];
        int i = 0;
        for (If r9 : arrayList) {
            i++;
            lArr[i] = Long.valueOf(r9.f7920);
        }
        this.f7876.m7572(lArr, IBladeRunnerClient.ManifestRequestFlavor.PREFETCH, new AbstractC1903jd() { // from class: o.jE.11
            @Override // o.AbstractC1903jd, o.iX
            /* renamed from: ˊ */
            public void mo7615(final JSONObject jSONObject, final Status status) {
                jE.this.f7874.post(new Runnable() { // from class: o.jE.11.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!status.mo298() || jSONObject == null) {
                            jE.this.m7870(arrayList, status);
                        } else {
                            jE.this.m7877(arrayList, jSONObject);
                        }
                    }
                });
            }
        });
        this.f7874.post(new Runnable() { // from class: o.jE.1
            @Override // java.lang.Runnable
            public void run() {
                jE.this.m7861();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7877(List<If> list, JSONObject jSONObject) {
        m7863(list, jSONObject);
        for (If r2 : list) {
            jG jGVar = this.f7883.get(r2);
            C0129 r4 = this.f7877.get(r2);
            if (r4 != null) {
                if (jGVar != null) {
                    jGVar.m7923(r4.m7896());
                    m7883(r2, jGVar);
                } else {
                    m7882(r2, AbstractC0367.f13258);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7863(List<If> list, JSONObject jSONObject) {
        for (jG jGVar : jG.m7900(jSONObject)) {
            if (jGVar == null) {
                C1283.m16854(f7873, "M-CACHE, processManifestResponse has error");
            } else {
                If r8 = If.m7892(list, jGVar.m7933().longValue());
                if (r8 == null) {
                    C1283.m16844(f7873, "processManifestResponse got a manifest that we didn't request %d", jGVar.m7933());
                    r8 = new If(jGVar.m7933().longValue(), this.f7879, this.f7884);
                }
                this.f7883.put(r8, jGVar);
                C1283.m16851(f7873, "M-CACHE, add %d", jGVar.m7933());
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7870(List<If> list, Status status) {
        for (If r0 : list) {
            m7882(r0, status);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7883(If r6, jG jGVar) {
        List<jD.If> r2;
        C0129 remove = this.f7877.remove(r6);
        if (!(remove == null || (r2 = remove.m7893()) == null)) {
            for (jD.If r0 : r2) {
                m7871(r6, jGVar, r0);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7882(If r6, Status status) {
        List<jD.If> r2;
        C0129 remove = this.f7877.remove(r6);
        if (!(remove == null || (r2 = remove.m7893()) == null)) {
            for (jD.If r0 : r2) {
                m7878(r6, r0, status);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7871(If r10, final jG jGVar, final jD.If r12) {
        final long j = r10.f7920;
        this.f7878.post(new Runnable() { // from class: o.jE.3
            @Override // java.lang.Runnable
            public void run() {
                if (jE.this.f7881.contains(Long.valueOf(j))) {
                    C1283.m16851(jE.f7873, "callback is aborted for movie %d", Long.valueOf(j));
                    jE.this.f7881.remove(Long.valueOf(j));
                    return;
                }
                C1283.m16851(jE.f7873, "manifest success for movie %d", Long.valueOf(j));
                r12.mo7495(jGVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7878(If r10, final jD.If r11, final Status status) {
        final long j = r10.f7920;
        this.f7878.post(new Runnable() { // from class: o.jE.2
            @Override // java.lang.Runnable
            public void run() {
                if (jE.this.f7881.contains(Long.valueOf(j))) {
                    C1283.m16851(jE.f7873, "callback is aborted for movie %d", Long.valueOf(j));
                    jE.this.f7881.remove(Long.valueOf(j));
                    return;
                }
                C1283.m16851(jE.f7873, "manifest error for movie %d", Long.valueOf(j));
                r11.mo7506(Long.valueOf(j), status);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼ  reason: contains not printable characters */
    private void m7861() {
        ArrayList arrayList = new ArrayList(this.f7883.values());
        Collections.sort(arrayList);
        int size = arrayList.size() - this.f7880;
        C1283.m16851(f7873, "M-CACHE, now has %d, excessive entries %d", Integer.valueOf(this.f7883.size()), Integer.valueOf(size));
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            jG jGVar = (jG) it.next();
            if (jGVar.m7914() <= 0 || i < size) {
                m7885(jGVar);
                it.remove();
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7885(jG jGVar) {
        Iterator<Map.Entry<If, jG>> it = this.f7883.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().equals(jGVar)) {
                C1283.m16851(f7873, "M-CACHE, remove %d", jGVar.m7933());
                it.remove();
            }
        }
    }
}
