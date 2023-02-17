package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.offline.download.OfflinePlayablePersistentData;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.ClientActionFromLase;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import o.AbstractC1853hl;
import o.AbstractC1897iy;
public interface hI extends pV {

    public interface iF {
        /* renamed from: ॱ  reason: contains not printable characters */
        void mo6942(hI hIVar);
    }

    /* renamed from: o.hI$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˊ  reason: contains not printable characters */
        void mo6943(AbstractC1897iy.If v, String str, Status status);
    }

    /* renamed from: o.hI$ˊ  reason: contains not printable characters */
    public interface AbstractC0112 {
        /* renamed from: ˊ  reason: contains not printable characters */
        void mo6944(OfflinePlayablePersistentData offlinePlayablePersistentData);
    }

    /* renamed from: ʻ */
    void mo6880();

    /* renamed from: ʽ */
    String mo6884();

    /* renamed from: ˊ */
    Status mo6889(boolean z);

    /* renamed from: ˊ */
    OfflinePlayablePersistentData mo6890();

    /* renamed from: ˊ */
    void mo6891(ClientActionFromLase clientActionFromLase);

    /* renamed from: ˋ */
    void mo6893();

    /* renamed from: ˋ */
    void mo6894(AbstractC1853hl.Cif ifVar);

    /* renamed from: ˎ */
    void mo6898(iF iFVar);

    /* renamed from: ˎ */
    void mo6899(Cif ifVar);

    /* renamed from: ˎ */
    boolean mo6902();

    /* renamed from: ˏ */
    void mo6903();

    /* renamed from: ˏ */
    void mo6904(IBladeRunnerClient.OfflineRefreshInvoke offlineRefreshInvoke, AbstractC1853hl.AbstractC0115 v);

    /* renamed from: ˏ */
    void mo6905(StopReason stopReason);

    /* renamed from: ॱ */
    void mo6909();
}
