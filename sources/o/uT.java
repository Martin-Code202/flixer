package o;

import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import o.BJ;
public class uT {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m11651(NetflixActivity netflixActivity, pF pFVar, VideoType videoType, oX oXVar, int i, boolean z) {
        return m11653(netflixActivity, pFVar.getPlayableId(), videoType, pFVar.isPreviewProtected(), oXVar, i, z);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m11653(NetflixActivity netflixActivity, String str, VideoType videoType, boolean z, oX oXVar, int i, boolean z2) {
        C2269wk.m12432(oXVar);
        if (!C1349Bv.m4103(str)) {
            C1276.m16820().mo5725("Non numeric videoId passed in Mdx PlayVideo");
            return false;
        }
        oG r3 = C1298Aa.m3506(netflixActivity.getServiceManager());
        if (r3 == null) {
            C1283.m16865("MdxAgentApi", "MDX agent not available - can't play video");
            return false;
        }
        BJ.C0067 r4 = r3.mo6172();
        if (!z2 && r4 != null && C1349Bv.m4126(r4.f4579, str)) {
            return false;
        }
        String r5 = r3.mo6171();
        Intent r6 = m11652(netflixActivity, "com.netflix.mediaclient.intent.action.MDX_ACTION_PLAY_VIDEOIDS", r5);
        if (videoType == VideoType.MOVIE) {
            r6.putExtra("catalogId", str);
        } else if (videoType == VideoType.EPISODE) {
            r6.putExtra("episodeId", str);
        }
        r6.putExtra("trackId", oXVar.getTrackId());
        r6.putExtra("time", i);
        if (z) {
            r6.putExtra("previewPinProtected", true);
        }
        netflixActivity.sendIntentToNetflixService(r6);
        C1283.m16846("MdxAgentApi", "play done");
        netflixActivity.sendIntentToNetflixService(m11652(netflixActivity, "com.netflix.mediaclient.intent.action.MDX_ACTION_GETCAPABILITY", r5));
        return true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Intent m11652(Context context, String str, String str2) {
        Intent intent = new Intent(str);
        intent.setClass(context, ServiceC0966.class);
        intent.addCategory("com.netflix.mediaclient.intent.category.MDX");
        intent.putExtra("uuid", str2);
        return intent;
    }
}
