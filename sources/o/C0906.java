package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.BaseNflxHandler;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import java.util.Map;
import o.C1328Ba;
/* access modifiers changed from: package-private */
/* renamed from: o.ᖧ  reason: contains not printable characters */
public class C0906 extends BaseNflxHandler {
    public C0906(NetflixActivity netflixActivity, Map<String, String> map) {
        super(netflixActivity, map);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.protocol.nflx.BaseNflxHandler
    /* renamed from: ˋ */
    public NflxHandler.Response mo485(String str, String str2, String str3) {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.protocol.nflx.BaseNflxHandler
    /* renamed from: ॱ */
    public NflxHandler.Response mo488(String str, String str2, String str3) {
        return null;
    }

    @Override // com.netflix.mediaclient.protocol.nflx.NflxHandler
    public NflxHandler.Response c_() {
        C1283.m16846("NflxHandler", "handleDownloadAction starts...");
        C1328Ba.C0070 r10 = m489();
        if (r10 == null) {
            C1283.m16850("NflxHandler", "handleDownloadAction fails, no video info found!");
            return NflxHandler.Response.NOT_HANDLING;
        } else if (r10.m4000()) {
            C1283.m16846("NflxHandler", "handleDownloadAction ends, handling with delay.");
            return NflxHandler.Response.HANDLING_WITH_DELAY;
        } else {
            C1283.m16846("NflxHandler", "handleDownloadAction, handling.");
            VideoType r11 = r10.m3999();
            String r12 = r10.m3998();
            DetailsActivity.Action r13 = m15702();
            String r14 = m15701();
            if (r11 == VideoType.EPISODE) {
                C1283.m16854("NflxHandler", "Showing details for episode: " + r12 + ", type: " + r11 + ", show: " + r10.m3997());
                qU.m9968(this.f1040, r10.m3997(), r12, new oB("NflxHandler"), r13, r14);
            } else {
                C1283.m16854("NflxHandler", "Showing details for: " + r12 + ", type: " + r11);
                qU.m9981(this.f1040, r11, r12, "", new oB("NflxHandler"), r13, r14, getClass().getSimpleName() + ":mov");
            }
            return NflxHandler.Response.HANDLING;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m15701() {
        return (String) this.f1041.get("msg_token");
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private DetailsActivity.Action m15702() {
        return DetailsActivity.Action.Download;
    }
}
