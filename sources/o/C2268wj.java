package o;

import android.content.Context;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.offline.OfflinePostPlayExperience;
import io.realm.RealmModel;
import io.realm.RealmObject;
/* renamed from: o.wj  reason: case insensitive filesystem */
public final class C2268wj extends wK {

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private C2098qr f11614;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2268wj(IPlayerFragment iPlayerFragment) {
        super(iPlayerFragment);
        C1457Fr.m5025(iPlayerFragment, "playerFragment");
    }

    /* access modifiers changed from: protected */
    @Override // o.wK, com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ˎ */
    public boolean mo2577() {
        C2098qr r2 = m12431();
        if (r2 == null || !RealmObject.isValid(r2)) {
            return false;
        }
        NetflixActivity netflixActivity = this.f3616;
        C1457Fr.m5016((Object) netflixActivity, "mNetflixActivity");
        return vO.m12022(netflixActivity.getServiceManager(), r2.getNextEpisodeId());
    }

    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ॱ */
    public void mo2585(String str, VideoType videoType, PlayLocationType playLocationType) {
        C2098qr r4 = m12431();
        if (r4 == null || r4.getNextEpisodeId() == null) {
            C1276.m16820().mo5727("The videoDetails or nextEpisodeId was null for OfflinePostPlayForPlayer#fetchPostPlayVideos");
            return;
        }
        C2098qr r5 = C2093qn.m10096(r4.getNextEpisodeId());
        if (!(r5 == null || r5.getPlayable() == null)) {
            pF playable = r5.getPlayable();
            C1457Fr.m5016((Object) playable, "nextVideoDetails.playable");
            if (playable.getPlayableId() != null) {
                m2584(new OfflinePostPlayExperience(r5.getPlayable(), r5.getRealmHorzDispUrl((Context) C1281.m16832(Context.class)), m2588()));
                return;
            }
        }
        C1276.m16820().mo5727("The NEXT videoDetails or playableId was null for OfflinePostPlayForPlayer#fetchPostPlayVideos");
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    private final C2098qr m12431() {
        if (this.f11614 == null) {
            IPlayerFragment iPlayerFragment = this.f3618;
            pF r1 = iPlayerFragment != null ? iPlayerFragment.mo2268() : null;
            if ((r1 instanceof RealmModel) && RealmObject.isValid((RealmModel) r1) && r1.isPlayableEpisode() && r1.getPlayableId() != null) {
                this.f11614 = C2093qn.m10096(r1.getPlayableId());
            }
        }
        return this.f11614;
    }
}
