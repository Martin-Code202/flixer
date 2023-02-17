package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.BaseNflxHandler;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import java.util.Map;
import o.C1328Ba;
/* access modifiers changed from: package-private */
/* renamed from: o.ᴉ  reason: contains not printable characters */
public class C0946 extends BaseNflxHandler {
    public C0946(NetflixActivity netflixActivity, Map<String, String> map) {
        super(netflixActivity, map);
    }

    @Override // com.netflix.mediaclient.protocol.nflx.NflxHandler
    public NflxHandler.Response c_() {
        C1283.m16846("NflxHandler", "handleViewDetailsAction starts...");
        C1328Ba.C0070 r9 = m489();
        if (r9 == null) {
            C1283.m16850("NflxHandler", "handleViewDetailsAction fails, no video info found!");
            return NflxHandler.Response.NOT_HANDLING;
        } else if (r9.m4000()) {
            C1283.m16846("NflxHandler", "handleViewDetailsAction ends, handling with delay.");
            return NflxHandler.Response.HANDLING_WITH_DELAY;
        } else {
            VideoType r10 = r9.m3999();
            String r11 = r9.m3998();
            String r12 = C1328Ba.m3990(this.f1041);
            DetailsActivity.Action r13 = mo15707();
            String r14 = mo15706();
            if (r10 == VideoType.EPISODE) {
                qU.m9968(this.f1040, r9.m3997(), r11, C1328Ba.m3992(r12), r13, r14);
            } else {
                qU.m9981(this.f1040, r10, r11, "", C1328Ba.m3992(r12), r13, r14, getClass().getSimpleName() + ":mov");
            }
            return NflxHandler.Response.HANDLING;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.protocol.nflx.BaseNflxHandler
    /* renamed from: ˋ */
    public NflxHandler.Response mo485(String str, String str2, String str3) {
        qU.m9981(this.f1040, VideoType.MOVIE, str, "", C1328Ba.m3992(str3), mo15707(), mo15706(), getClass().getSimpleName() + ":tinyUrlMov");
        return NflxHandler.Response.HANDLING;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.protocol.nflx.BaseNflxHandler
    /* renamed from: ॱ */
    public NflxHandler.Response mo488(String str, String str2, String str3) {
        qU.m9981(this.f1040, VideoType.SHOW, str, "", C1328Ba.m3992(str3), mo15707(), mo15706(), getClass().getSimpleName() + ":tinyUrlEp");
        return NflxHandler.Response.HANDLING;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public DetailsActivity.Action mo15707() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public String mo15706() {
        return null;
    }
}
