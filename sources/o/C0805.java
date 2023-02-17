package o;

import android.text.TextUtils;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import java.util.List;
/* renamed from: o.ᒵ  reason: contains not printable characters */
public class C0805 implements AbstractC0695 {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final String f14538 = String.format("%s://%s/%s/", "http", "www.netflix.com", "title");

    @Override // o.AbstractC0695
    /* renamed from: ˋ */
    public boolean mo14971(List<String> list) {
        return list.size() > 1;
    }

    @Override // o.AbstractC0695
    /* renamed from: ˏ */
    public NflxHandler.Response mo14972(NetflixActivity netflixActivity, List<String> list, String str) {
        C1283.m16846("NetflixComVideoDetailsHandler", "Starting Details activity");
        m15361(mo15297(list), netflixActivity, str);
        return NflxHandler.Response.HANDLING_WITH_DELAY;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public String mo15297(List<String> list) {
        return list.get(1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m15360(final String str, final NetflixActivity netflixActivity, final String str2) {
        netflixActivity.getServiceManager().m9764().mo9514(str, new AbstractC2061pj() { // from class: o.ᒵ.2
            @Override // o.AbstractC2061pj, o.oU
            public void onFalkorVideoFetched(CH ch, Status status) {
                if (!status.mo298() || ch == null) {
                    C1276.m16820().mo5731(new Throwable("SPY-7518 - got error trying to fetch video summary for: " + str));
                } else if (ch.getType() == VideoType.SEASON || ch.getType() == VideoType.EPISODE) {
                    String topLevelId = ch.getTopLevelId();
                    if (TextUtils.isEmpty(topLevelId) || topLevelId.equals(str)) {
                        C1276.m16820().mo5731(new Throwable("Ancestor is null for: " + str));
                    } else {
                        C0805.this.m15360(topLevelId, netflixActivity, str2);
                        return;
                    }
                } else {
                    if (!(netflixActivity == null || netflixActivity.getServiceManager() == null)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("trkid").append('=').append(str2);
                        sb.append('&');
                        sb.append("movieid").append('=').append(str);
                        Logger.INSTANCE.m127(new C0711(1.0f, sb.toString()));
                        C1364Cj.m4436(UIViewLogging.UIViewCommandName.deepLink, IClientLogging.ModalView.movieDetails, (C1359Ce) null, sb.toString());
                        C1364Cj.m4432();
                    }
                    qU.m9970(netflixActivity, ch, C1328Ba.m3992(str2), C0805.this.mo14973(), C0805.this.m15363(), "DeepLink");
                }
                C1328Ba.m3984(netflixActivity);
            }
        });
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private NflxHandler.Response m15361(String str, NetflixActivity netflixActivity, String str2) {
        m15360(str, netflixActivity, str2);
        return NflxHandler.Response.HANDLING_WITH_DELAY;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public DetailsActivity.Action mo14973() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public String m15363() {
        return null;
    }
}
