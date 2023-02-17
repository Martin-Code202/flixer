package o;

import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.ᖽ  reason: contains not printable characters */
public class C0917 extends AbstractC0907 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f14800;

    public C0917(NetflixActivity netflixActivity, Map<String, String> map, long j) {
        super(netflixActivity, map);
        this.f14800 = j;
    }

    @Override // com.netflix.mediaclient.protocol.nflx.NflxHandler
    public NflxHandler.Response c_() {
        C1283.m16854("NflxHandler", "Profile gate is required.");
        C1328Ba.m3980(this.f1040, this.f1041, this.f14800);
        this.f1040.startActivity(ActivityC2383zq.m13742(this.f1040, AppView.browseTitles));
        return NflxHandler.Response.HANDLING;
    }
}
