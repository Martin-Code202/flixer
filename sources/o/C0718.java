package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import java.util.List;
/* access modifiers changed from: package-private */
/* renamed from: o.ძ  reason: contains not printable characters */
public class C0718 implements AbstractC0695 {
    C0718() {
    }

    @Override // o.AbstractC0695
    /* renamed from: ˋ */
    public boolean mo14971(List<String> list) {
        return true;
    }

    @Override // o.AbstractC0695
    /* renamed from: ˏ */
    public NflxHandler.Response mo14972(NetflixActivity netflixActivity, List<String> list, String str) {
        C1283.m16846("NetflixComLaunchHandler", "Starting launch activity");
        C0808.m15371(netflixActivity);
        return NflxHandler.Response.HANDLING;
    }
}
