package o;

import android.os.Handler;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.NetflixPowerManager;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: o.hn  reason: case insensitive filesystem */
public class C1855hn {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<AbstractC1854hm> f7278 = new ArrayList();

    /* renamed from: ˎ  reason: contains not printable characters */
    private NetflixPowerManager f7279;

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7163(Handler handler, final String str) {
        handler.post(new Runnable() { // from class: o.hn.5
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7145();
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo2173(str);
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7152(Handler handler, final String str, final Status status) {
        handler.post(new Runnable() { // from class: o.hn.6
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7145();
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo2185(str, status);
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7155(Handler handler, final pV pVVar, final int i) {
        handler.post(new Runnable() { // from class: o.hn.10
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7147();
                C1855hn.this.m7145();
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo2181(pVVar, i);
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7154(Handler handler, final pV pVVar) {
        C1283.m16863("nf_offlineAgent", "onDownloadCompleted playableId=%s", pVVar.mo6915());
        handler.post(new Runnable() { // from class: o.hn.8
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7144();
                C1855hn.this.m7145();
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo2174(pVVar);
                }
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7160(Handler handler, final pV pVVar, final StopReason stopReason) {
        C1283.m16863("nf_offlineAgent", "onDownloadStopped playableId=%s", pVVar.mo6915());
        handler.post(new Runnable() { // from class: o.hn.11
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7144();
                C1855hn.this.m7145();
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo2177(pVVar, stopReason);
                }
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7165(Handler handler, final pV pVVar) {
        C1283.m16863("nf_offlineAgent", "onDownloadResumedByUser playableId=%s", pVVar.mo6915());
        handler.post(new Runnable() { // from class: o.hn.14
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7147();
                C1855hn.this.m7145();
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo2175(pVVar);
                }
            }
        });
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7162(final Handler handler, final String str, final Status status, final AbstractC1853hl hlVar, final C1847hf hfVar) {
        handler.post(new Runnable() { // from class: o.hn.12
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7144();
                C1855hn.this.m7145();
                boolean z = status.mo298() && hfVar != null;
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo2180(str, status, z);
                }
                if (z) {
                    handler.post(new Runnable() { // from class: o.hn.12.4
                        @Override // java.lang.Runnable
                        public void run() {
                            hlVar.mo7141(hfVar.f7227, hfVar.f7226, hfVar.f7225);
                        }
                    });
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7153(Handler handler, final List<String> list, final Status status) {
        handler.post(new Runnable() { // from class: o.hn.15
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7144();
                C1855hn.this.m7145();
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo2178(list, status);
                }
            }
        });
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7161(Handler handler, final Status status) {
        handler.post(new Runnable() { // from class: o.hn.13
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7144();
                C1855hn.this.m7145();
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo1758(status);
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7151(Handler handler, final Status status) {
        handler.post(new Runnable() { // from class: o.hn.2
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7144();
                C1855hn.this.m7145();
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo2184(status);
                }
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m7166(Handler handler, final pV pVVar, final Status status) {
        handler.post(new Runnable() { // from class: o.hn.3
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7145();
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo2176(pVVar, status);
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7156(Handler handler, final pV pVVar, final Status status) {
        handler.post(new Runnable() { // from class: o.hn.1
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7145();
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo2179(pVVar, status);
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7157(Handler handler, final boolean z) {
        handler.post(new Runnable() { // from class: o.hn.4
            @Override // java.lang.Runnable
            public void run() {
                C1855hn.this.m7145();
                for (AbstractC1854hm hmVar : C1855hn.this.f7278) {
                    hmVar.mo2182(z);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m7147() {
        if (this.f7279 != null) {
            this.f7279.m495(NetflixPowerManager.PartialWakeLockReason.DownloadGoingOn);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7144() {
        if (this.f7279 != null) {
            this.f7279.m493(NetflixPowerManager.PartialWakeLockReason.DownloadGoingOn);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7158(NetflixPowerManager netflixPowerManager) {
        this.f7279 = netflixPowerManager;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7164(Handler handler, final AbstractC1854hm hmVar) {
        if (handler != null && hmVar != null) {
            handler.post(new Runnable() { // from class: o.hn.7
                @Override // java.lang.Runnable
                public void run() {
                    C1855hn.this.m7145();
                    if (!C1855hn.this.f7278.contains(hmVar)) {
                        C1855hn.this.f7278.add(hmVar);
                        C1283.m16863("nf_offlineAgent", "addOfflineAgentListener after count=%d", Integer.valueOf(C1855hn.this.f7278.size()));
                        return;
                    }
                    C1283.m16862("nf_offlineAgent", "already added addOfflineAgentListener");
                }
            });
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7159(Handler handler, final AbstractC1854hm hmVar) {
        if (handler != null && hmVar != null) {
            C1283.m16862("nf_offlineAgent", "removeOfflineAgentListener before listener=" + hmVar.getClass().getName() + " count=" + this.f7278.size());
            handler.post(new Runnable() { // from class: o.hn.9
                @Override // java.lang.Runnable
                public void run() {
                    C1855hn.this.f7278.remove(hmVar);
                    C1855hn.this.m7145();
                    C1283.m16863("nf_offlineAgent", "removeOfflineAgentListener after count=%d", Integer.valueOf(C1855hn.this.f7278.size()));
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m7145() {
        Iterator<AbstractC1854hm> it = this.f7278.iterator();
        while (it.hasNext()) {
            AbstractC1854hm next = it.next();
            if (next != null && next.aa_()) {
                C1283.m16862("nf_offlineAgent", "...removing deadListener... " + next.getClass().getName());
                it.remove();
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7150() {
        m7144();
        this.f7279 = null;
    }
}
