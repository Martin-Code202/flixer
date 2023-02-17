package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.ui.search.SearchActivity;
import java.util.List;
/* renamed from: o.ᒴ  reason: contains not printable characters */
public class C0804 implements AbstractC0695 {
    @Override // o.AbstractC0695
    /* renamed from: ˋ */
    public boolean mo14971(List<String> list) {
        return true;
    }

    @Override // o.AbstractC0695
    /* renamed from: ˏ */
    public NflxHandler.Response mo14972(NetflixActivity netflixActivity, List<String> list, String str) {
        String str2 = null;
        if (list.size() > 1) {
            str2 = list.get(1);
        }
        SearchActivity.m2787(netflixActivity, str2);
        return NflxHandler.Response.HANDLING;
    }
}
