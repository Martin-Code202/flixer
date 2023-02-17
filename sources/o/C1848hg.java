package o;

import com.netflix.mediaclient.service.offline.download.OfflinePlayablePersistentData;
import com.netflix.mediaclient.service.offline.registry.OfflineRegistry;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import o.hI;
/* access modifiers changed from: package-private */
/* renamed from: o.hg  reason: case insensitive filesystem */
public class C1848hg implements hI.AbstractC0112, hI.iF {

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f7229 = 0;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final OfflineRegistry f7230;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<hI> f7231;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final hS f7232;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final If f7233;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f7234 = 0;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AtomicBoolean f7235 = new AtomicBoolean(false);

    /* renamed from: o.hg$If */
    public interface If {
        /* renamed from: ॱॱ  reason: contains not printable characters */
        void mo7053();
    }

    C1848hg(If r3, hS hSVar, List<hI> list, OfflineRegistry offlineRegistry) {
        this.f7230 = offlineRegistry;
        this.f7232 = hSVar;
        this.f7233 = r3;
        this.f7231 = list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7051(AbstractC1863hu huVar) {
        C1283.m16862("nf_MaintenanceJob", "startMaintenanceJob");
        huVar.mo7340(10);
        if (this.f7231.size() > 0) {
            this.f7234 = this.f7231.size();
            for (hI hIVar : this.f7231) {
                hIVar.mo6898(this);
            }
            return;
        }
        m7050();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7052() {
        this.f7235.set(true);
    }

    @Override // o.hI.AbstractC0112
    /* renamed from: ˊ */
    public void mo6944(OfflinePlayablePersistentData offlinePlayablePersistentData) {
        C1283.m16862("nf_MaintenanceJob", "onDeleteCompleted");
        this.f7230.m842(offlinePlayablePersistentData);
        this.f7229--;
        if (this.f7229 == 0 && !this.f7235.get()) {
            this.f7233.mo7053();
        }
    }

    @Override // o.hI.iF
    /* renamed from: ॱ */
    public void mo6942(hI hIVar) {
        C1283.m16862("nf_MaintenanceJob", "onMaintenanceJobDone");
        this.f7234--;
        if (this.f7234 == 0 && !this.f7235.get()) {
            m7050();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7050() {
        C1283.m16862("nf_MaintenanceJob", "processPendingDelete");
        List<OfflinePlayablePersistentData> r2 = this.f7230.m840();
        if (r2.size() > 0) {
            C1283.m16862("nf_MaintenanceJob", "processPendingDelete not calling onAllMaintenanceJobDone");
            this.f7229 = r2.size();
            for (OfflinePlayablePersistentData offlinePlayablePersistentData : r2) {
                hF.m6873(this.f7232, offlinePlayablePersistentData, this, (hJ) null);
            }
            return;
        }
        this.f7233.mo7053();
    }
}
