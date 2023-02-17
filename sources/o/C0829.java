package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.service.webclient.model.leafs.ListOfGenreSummary;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.ᓙ  reason: contains not printable characters */
public class C0829 extends AbstractC0907 {
    public C0829(NetflixActivity netflixActivity, Map<String, String> map) {
        super(netflixActivity, map);
    }

    @Override // com.netflix.mediaclient.protocol.nflx.NflxHandler
    public NflxHandler.Response c_() {
        String str = (String) this.f1041.get("genreid");
        if (str == null) {
            C1283.m16846("NflxHandler", "Could not find genre ID");
            return NflxHandler.Response.NOT_HANDLING;
        }
        this.f1040.getServiceManager().m9764().mo9505(str, new C0830(this.f1040, str));
        return NflxHandler.Response.HANDLING_WITH_DELAY;
    }

    /* renamed from: o.ᓙ$ˊ  reason: contains not printable characters */
    class C0830 extends AbstractC2061pj {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final NetflixActivity f14633;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f14635;

        C0830(NetflixActivity netflixActivity, String str) {
            this.f14635 = str;
            this.f14633 = netflixActivity;
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onLoLoMoSummaryFetched(pA pAVar, Status status) {
            if (status.mo298()) {
                ActivityC2153sl.m10769(this.f14633, new ListOfGenreSummary(pAVar.getNumLoMos(), -1, -1, "", pAVar.getTitle(), this.f14635, GenreList.GenreType.LOLOMO.name()));
            }
            C1328Ba.m3984(this.f14633);
        }
    }
}
