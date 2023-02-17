package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import java.util.Map;
/* renamed from: o.ᔬ  reason: contains not printable characters */
public class C0875 extends AbstractC0907 {
    public C0875(NetflixActivity netflixActivity, Map<String, String> map) {
        super(netflixActivity, map);
    }

    @Override // com.netflix.mediaclient.protocol.nflx.NflxHandler
    public NflxHandler.Response c_() {
        C1283.m16846("NflxHandler", "Starting home activity");
        this.f1040.startActivity(ActivityC2153sl.m10779(this.f1040));
        this.f1040.overridePendingTransition(0, 0);
        return NflxHandler.Response.HANDLING;
    }
}
