package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import java.util.List;
/* access modifiers changed from: package-private */
/* renamed from: o.Ⴡ  reason: contains not printable characters */
public class C0712 implements AbstractC0695 {
    C0712() {
    }

    @Override // o.AbstractC0695
    /* renamed from: ˋ */
    public boolean mo14971(List<String> list) {
        return true;
    }

    @Override // o.AbstractC0695
    /* renamed from: ˏ */
    public NflxHandler.Response mo14972(NetflixActivity netflixActivity, List<String> list, String str) {
        C1283.m16846("NetflixComHelpHandler", "Starting help activity");
        C0808.m15369(netflixActivity);
        return NflxHandler.Response.HANDLING;
    }
}
