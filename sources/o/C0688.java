package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.service.webclient.model.leafs.ListOfGenreSummary;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import java.util.List;
/* renamed from: o.ผ  reason: contains not printable characters */
public class C0688 implements AbstractC0695 {
    @Override // o.AbstractC0695
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo14971(List<String> list) {
        if (list.size() != 1 && !m14968(list) && !m14970(list)) {
            return false;
        }
        return true;
    }

    @Override // o.AbstractC0695
    /* renamed from: ˏ  reason: contains not printable characters */
    public NflxHandler.Response mo14972(NetflixActivity netflixActivity, List<String> list, String str) {
        NflxHandler.Response response = NflxHandler.Response.NOT_HANDLING;
        if (list.size() == 1) {
            C0808.m15373(netflixActivity);
            return NflxHandler.Response.HANDLING;
        } else if (m14968(list)) {
            return m14967(netflixActivity);
        } else {
            if (m14970(list)) {
                return m14969(list.get(2), netflixActivity);
            }
            return response;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ผ$iF */
    public class iF extends AbstractC2061pj {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ String f14179;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ NetflixActivity f14180;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        iF(NetflixActivity netflixActivity, String str) {
            this.f14180 = netflixActivity;
            this.f14179 = str;
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onLoLoMoSummaryFetched(pA pAVar, Status status) {
            if (!status.mo298() || pAVar == null) {
                C1276.m16820().mo5725("handleGenre failed for " + this.f14179);
                C0808.m15373(this.f14180);
            } else {
                ActivityC2153sl.m10769(this.f14180, new ListOfGenreSummary(pAVar.getNumLoMos(), -1, -1, "", pAVar.getTitle(), this.f14179, GenreList.GenreType.LOLOMO.name()));
            }
            C1328Ba.m3984(this.f14180);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private NflxHandler.Response m14969(String str, NetflixActivity netflixActivity) {
        netflixActivity.getServiceManager().m9764().mo9505(str, new iF(netflixActivity, str));
        return NflxHandler.Response.HANDLING_WITH_DELAY;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private NflxHandler.Response m14967(NetflixActivity netflixActivity) {
        if (C0682.m14924() || C0935.m15747()) {
            C1283.m16846("NetflixComBrowseHandler", "Starting trailers feed activity");
            netflixActivity.startActivity(rU.f9685.m10193(netflixActivity));
        } else {
            C1276.m16820().mo5725("User clicked on coming soon deeplink but not allocated to the test");
            C1283.m16846("NetflixComBrowseHandler", "Starting home activity as user is not in test");
            C0808.m15373(netflixActivity);
        }
        return NflxHandler.Response.HANDLING;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m14970(List<String> list) {
        return list.size() > 2 && "genre".equalsIgnoreCase(list.get(1));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m14968(List<String> list) {
        return list.size() > 1 && "coming-soon".equalsIgnoreCase(list.get(1));
    }
}
