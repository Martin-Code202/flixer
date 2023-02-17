package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.ᘦ  reason: contains not printable characters */
public class C0937 extends AbstractC0907 {
    public C0937(NetflixActivity netflixActivity, Map<String, String> map) {
        super(netflixActivity, map);
    }

    @Override // com.netflix.mediaclient.protocol.nflx.NflxHandler
    public NflxHandler.Response c_() {
        String r2 = C1328Ba.m3977((String) this.f1041.get("targetid"));
        oG r3 = this.f1040.getServiceManager().m9811();
        if (r3 == null) {
            C1283.m16850("NflxHandler", "Sync action is required, MDX agent is null. This should NOT happen!");
            return NflxHandler.Response.NOT_HANDLING;
        } else if (AU.m3421(this.f1040.getServiceManager(), r2)) {
            C1283.m16854("NflxHandler", "Sync action is required, target is available, sync");
            r3.mo6177(r2);
            return NflxHandler.Response.NOT_HANDLING;
        } else {
            C1283.m16854("NflxHandler", "Sync action is required, target not available, do nothing!");
            return NflxHandler.Response.NOT_HANDLING;
        }
    }
}
