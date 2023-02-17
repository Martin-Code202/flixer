package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.ui.search.SearchActivity;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.ᖿ  reason: contains not printable characters */
public class C0919 extends AbstractC0907 {
    C0919(NetflixActivity netflixActivity, Map<String, String> map) {
        super(netflixActivity, map);
    }

    @Override // com.netflix.mediaclient.protocol.nflx.NflxHandler
    public NflxHandler.Response c_() {
        String str = (String) this.f1041.get("query");
        if (C1349Bv.m4113(str)) {
            C1283.m16846("NflxHandler", "Could not find query param");
            return NflxHandler.Response.NOT_HANDLING;
        }
        SearchActivity.m2787(this.f1040, str);
        return NflxHandler.Response.HANDLING;
    }
}
