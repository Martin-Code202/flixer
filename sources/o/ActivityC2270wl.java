package o;

import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
/* renamed from: o.wl  reason: case insensitive filesystem */
public class ActivityC2270wl extends ActivityC2280wv {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static Intent m12433(Context context, String str, VideoType videoType, oX oXVar) {
        Intent intent = new Intent(context, ActivityC2270wl.class);
        intent.addFlags(131072);
        intent.putExtra(NetflixActivity.EXTRA_VIDEO_ID, str);
        intent.putExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE, videoType.getValue());
        intent.putExtra(NetflixActivity.EXTRA_PLAY_CONTEXT, oXVar);
        return intent;
    }
}
