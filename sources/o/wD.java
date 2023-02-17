package o;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.concurrent.atomic.AtomicBoolean;
public final class wD implements iH {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f11421 = wD.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private AbstractC0933 f11422;

    /* renamed from: ʼ  reason: contains not printable characters */
    private pT f11423;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AtomicBoolean f11424 = new AtomicBoolean(false);

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f11425;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f11426;

    /* renamed from: ॱ  reason: contains not printable characters */
    private oS f11427;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f11428;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f11429;

    public wD(Context context) {
        this.f11425 = context;
    }

    @Override // o.iH
    /* renamed from: ˊ */
    public void mo7440(String str) {
        if (!C1349Bv.m4113(str) && this.f11423 != null) {
            this.f11429 = str;
            this.f11424.set(true);
            pF playable = this.f11423.getPlayable();
            if (playable != null && this.f11423.getPlayable().getPlayableId().equals(str)) {
                if (this.f11423.getType() == VideoType.EPISODE) {
                    this.f11428 = this.f11425.getApplicationContext().getString(R.string.label_episodeTitle, playable.getSeasonAbbrSeqLabel(), Integer.valueOf(playable.getEpisodeNumber()), playable.getPlayableTitle());
                    if (playable.isEpisodeNumberHidden()) {
                        this.f11428 = this.f11425.getApplicationContext().getString(R.string.label_episodeTitleBasicQuoted, this.f11423.getTitle());
                    }
                    this.f11426 = playable.getParentTitle();
                    C1283.m16863(f11421, "%s is episode %s : %s", str, this.f11426, this.f11428);
                } else {
                    this.f11428 = null;
                    this.f11426 = playable.getPlayableTitle();
                    C1283.m16863(f11421, "%s is movie %s ", str, this.f11426);
                }
                m12267(this.f11423.getHighResolutionPortraitBoxArtUrl());
            }
        }
    }

    @Override // o.iH
    /* renamed from: ˋ */
    public void mo7441() {
        this.f11424.set(false);
        if (this.f11427 != null) {
            this.f11427.mo9578(2, true);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12267(String str) {
        if (C1349Bv.m4113(str)) {
            C1283.m16850(f11421, "Loader url empty");
        } else if (null != this.f11422) {
            this.f11422.mo15746(str, 0, 0, new AbstractC0957() { // from class: o.wD.2
                @Override // o.AbstractC0957
                public void onResponse(Bitmap bitmap, String str2) {
                    if (null != bitmap && !bitmap.isRecycled()) {
                        C1283.m16851(wD.f11421, "downloaded image from %s", str2);
                        wD.this.m12272(bitmap.copy(bitmap.getConfig(), bitmap.isMutable()));
                    }
                }

                @Override // o.AbstractC0957
                public void onErrorResponse(String str2) {
                    C1283.m16844(wD.f11421, "failed to downlod %s", str2);
                    wD.this.m12272(null);
                }
            });
        } else {
            C1283.m16850(f11421, "ImageLoader is null!");
            m12272(null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12272(Bitmap bitmap) {
        try {
            if (this.f11424.get()) {
                int color = this.f11425.getResources().getColor(R.color.brand_red);
                String string = this.f11425.getResources().getString(R.string.label_suspendplayer_notification_header);
                if (C1317As.m3758() >= 24) {
                    string = this.f11425.getResources().getString(R.string.label_suspendplayer_notification_header_24);
                }
                NotificationCompat.Builder visibility = new NotificationCompat.Builder(this.f11425, "playback_notification_channel").addAction(new NotificationCompat.Action(R.drawable.notif_stop, this.f11425.getApplicationContext().getString(R.string.label_suspendplayer_stopWatching), m12271())).setOnlyAlertOnce(true).setSmallIcon(R.drawable.ic_sb_netflix_n).setTicker(this.f11426).setContentTitle(this.f11426).setColor(color).setContentIntent(m12266()).setDeleteIntent(m12271()).setWhen(System.currentTimeMillis()).setVisibility(-1);
                if (bitmap != null) {
                    visibility.setLargeIcon(bitmap);
                }
                if (TextUtils.isEmpty(this.f11428)) {
                    visibility.setContentText(string);
                } else {
                    visibility.setContentText(this.f11428);
                    visibility.setSubText(string);
                }
                this.f11427.mo9579(2, visibility.build());
            }
        } catch (VerifyError e) {
            C1276.m16820().mo5730(e);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private PendingIntent m12266() {
        return PendingIntent.getActivity(this.f11425, 0, new Intent(this.f11425, ActivityC2280wv.class).addFlags(536870912).putExtra(NetflixActivity.EXTRA_VIDEO_ID, C1333Bf.m4017(this.f11429)), 268435456);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private PendingIntent m12271() {
        return PendingIntent.getBroadcast(this.f11425, 0, new Intent("com.netflix.mediaclient.intent.action.PLAYER_DELETE"), 134217728);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static IntentFilter m12273() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.netflix.mediaclient.intent.action.PLAYER_DELETE");
        return intentFilter;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m12270(String str) {
        return "com.netflix.mediaclient.intent.action.PLAYER_DELETE".equalsIgnoreCase(str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m12274(Context context) {
        context.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.PLAYER_DELETE"));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12275(pT pTVar, AbstractC0933 r2, oS oSVar) {
        this.f11423 = pTVar;
        this.f11422 = r2;
        this.f11427 = oSVar;
    }
}
