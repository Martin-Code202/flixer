package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import java.util.List;
/* renamed from: o.ᒹ  reason: contains not printable characters */
public class C0809 implements AbstractC0695 {
    @Override // o.AbstractC0695
    /* renamed from: ˋ */
    public boolean mo14971(List<String> list) {
        return list.size() > 1;
    }

    @Override // o.AbstractC0695
    /* renamed from: ˏ */
    public NflxHandler.Response mo14972(NetflixActivity netflixActivity, List<String> list, String str) {
        String str2 = list.get(1);
        oG r3 = netflixActivity.getServiceManager().m9811();
        if (r3 == null) {
            C1283.m16850("NetflixComSyncHandler", "Sync action is required, MDX agent is null. This should NOT happen!");
        }
        if (AU.m3421(netflixActivity.getServiceManager(), str2)) {
            C1283.m16854("NetflixComSyncHandler", "Sync action is required, target is available, sync");
            r3.mo6177(str2);
        } else {
            C1283.m16865("NetflixComSyncHandler", "Sync action is required, target not available, do nothing!");
        }
        C0808.m15373(netflixActivity);
        return NflxHandler.Response.HANDLING;
    }
}
