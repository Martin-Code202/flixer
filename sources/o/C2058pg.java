package o;

import android.content.Intent;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
/* renamed from: o.pg  reason: case insensitive filesystem */
public final class C2058pg {

    /* renamed from: o.pg$If */
    public static class If {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final IPlayer.PlaybackType f9384;

        /* renamed from: ˋ  reason: contains not printable characters */
        public final String f9385;

        /* renamed from: ˎ  reason: contains not printable characters */
        public final int f9386;

        /* renamed from: ˏ  reason: contains not printable characters */
        public final VideoType f9387;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final String f9388;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public final String f9389;

        public If(String str, IPlayer.PlaybackType playbackType, int i, VideoType videoType, String str2, String str3) {
            this.f9388 = str;
            this.f9384 = playbackType;
            this.f9386 = i;
            this.f9387 = videoType;
            this.f9385 = str2;
            this.f9389 = str3;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Intent m9730(String str, String str2, IPlayer.PlaybackType playbackType, VideoType videoType, int i, C2065pn pnVar) {
        Intent intent = new Intent(str);
        intent.putExtra(NetflixActivity.EXTRA_VIDEO_ID, str2);
        intent.putExtra("playbackType", playbackType.m1526());
        intent.putExtra("extra_bookmark_seconds_from_start_param", i);
        intent.putExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE, videoType.getValue());
        intent.putExtra("extra_ui_label_string_value", pnVar.m9854());
        return intent;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static If m9731(Intent intent) {
        return new If(intent.getAction(), IPlayer.PlaybackType.m1525(intent.getStringExtra("playbackType")), intent.getIntExtra("extra_bookmark_seconds_from_start_param", -1), VideoType.create(intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE)), intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_ID), intent.getStringExtra("extra_ui_label_string_value"));
    }
}
