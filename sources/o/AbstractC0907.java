package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.BaseNflxHandler;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.ᖨ  reason: contains not printable characters */
public abstract class AbstractC0907 extends BaseNflxHandler {
    public AbstractC0907(NetflixActivity netflixActivity, Map<String, String> map) {
        super(netflixActivity, map);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.protocol.nflx.BaseNflxHandler
    /* renamed from: ˋ */
    public NflxHandler.Response mo485(String str, String str2, String str3) {
        C1283.m16854("NflxHandler", "handleMovieFromTinyUrl");
        return NflxHandler.Response.NOT_HANDLING;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.protocol.nflx.BaseNflxHandler
    /* renamed from: ॱ */
    public NflxHandler.Response mo488(String str, String str2, String str3) {
        C1283.m16854("NflxHandler", "handleEpisodeFromTinyUrl");
        return NflxHandler.Response.NOT_HANDLING;
    }
}
