package o;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.util.Pair;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.util.ViewUtils;
/* renamed from: o.vw  reason: case insensitive filesystem */
public final class C2253vw implements AbstractC1778fk {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f11354;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f11355;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final AbstractC1284 f11356;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Cif f11357 = new Cif();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private String f11358;

    /* renamed from: ˋ  reason: contains not printable characters */
    private NotificationManager f11359;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final Context f11360;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Notification f11361;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f11362 = 201;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private Bitmap f11363;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final AbstractC0358 f11364;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f11365 = 1;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Notification.Builder f11366;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f11367;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private int f11368;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f11369;

    public C2253vw(Context context, boolean z, AbstractC1284 r6, AbstractC0358 r7) {
        C1283.m16854("nf_mdxnotification", "is episode " + z);
        this.f11369 = z;
        this.f11360 = context;
        this.f11356 = r6;
        this.f11364 = r7;
        m12179();
        m12186();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12179() {
        this.f11359 = (NotificationManager) this.f11360.getSystemService("notification");
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ॱ */
    public boolean mo6406() {
        return this.f11355;
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ॱ */
    public void mo6402(Notification notification, oS oSVar, boolean z) {
        if (notification != null) {
            if (1 != this.f11368) {
                oSVar.mo9579(1, notification);
                this.f11368 = 1;
            }
            this.f11355 = z;
            this.f11354 = true;
        }
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ॱ */
    public void mo6404(oS oSVar) {
        mo6397();
        oSVar.mo9578(1, true);
        this.f11368 = 0;
        this.f11354 = false;
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ˊ */
    public void mo6396(oS oSVar) {
        if (this.f11355) {
            oSVar.mo9578(1, true);
            this.f11368 = 0;
            this.f11354 = false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12186() {
        this.f11366 = this.f11357.m12192(false, false, false);
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ॱ */
    public Pair<Integer, Notification> mo6401(boolean z) {
        this.f11355 = z;
        this.f11366 = this.f11357.m12192(z, false, false);
        if (this.f11366 != null) {
            if (C1317As.m3774()) {
                this.f11366.setChannelId("mdx_notification_channel");
            }
            this.f11361 = this.f11366.build();
        }
        return Pair.create(1, this.f11361);
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ॱ */
    public void mo6405(boolean z, String str, String str2) {
        this.f11369 = z;
        m12180(str, str2);
        m12176();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private Bitmap m12185() {
        return BitmapFactory.decodeResource(this.f11360.getResources(), R.drawable.icon);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m12176() {
        if (this.f11366 != null) {
            if (this.f11363 == null) {
                this.f11363 = m12185();
            }
            if (this.f11363 == null) {
                C1283.m16850("nf_mdxnotification", "We failed to decode resource!");
            } else {
                this.f11366.setLargeIcon(ViewUtils.m3024(this.f11363));
            }
            if (this.f11358 != null) {
                this.f11366.setContentText(this.f11358);
            }
            if (this.f11367 != null) {
                this.f11366.setSubText(this.f11367);
            }
            if (this.f11355) {
                this.f11366.setContentTitle(this.f11360.getResources().getString(R.string.label_mdx_notification_up_next));
            } else {
                this.f11366.setContentTitle(this.f11360.getResources().getString(R.string.now_playing));
            }
            this.f11366.setSmallIcon(R.drawable.ic_sb_netflix_n);
            if (C1317As.m3774()) {
                this.f11366.setChannelId("mdx_notification_channel");
            }
            this.f11361 = this.f11366.build();
            this.f11359.notify(1, this.f11361);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12180(String str, String str2) {
        if (this.f11366 != null) {
            this.f11358 = str;
            this.f11367 = str2;
            if (this.f11369) {
                this.f11366.setTicker(str2);
            } else {
                this.f11366.setTicker(str);
            }
        }
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ॱ */
    public void mo6403(Bitmap bitmap) {
        if (bitmap != null) {
            this.f11363 = bitmap;
        }
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ˎ */
    public void mo6398(Bitmap bitmap) {
        if (bitmap != null) {
            mo6403(bitmap);
            m12176();
        }
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ˏ */
    public void mo6400(boolean z, boolean z2, boolean z3, String str) {
        m12182(z, z2, z3, str, false);
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ˎ */
    public void mo6399(boolean z, boolean z2, boolean z3) {
        if (z3) {
            m12181(z, z2, z3);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private PendingIntent m12175() {
        if (this.f11360 == null) {
            return null;
        }
        return PendingIntent.getBroadcast(this.f11360, 0, ServiceC0966.m15817(), 134217728);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12181(boolean z, boolean z2, boolean z3) {
        m12182(z, z2, false, "", z3);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12182(boolean z, boolean z2, boolean z3, String str, boolean z4) {
        if (this.f11366 != null && this.f11359 != null && this.f11354) {
            if (m12183(z3)) {
                String str2 = this.f11358;
                if (C1349Bv.m4107(this.f11367)) {
                    C0403 r5 = C0403.m14185(this.f11360, R.string.skip_intro_notification_text);
                    r5.m14186("showName", this.f11358);
                    r5.m14186("episodeName", this.f11367);
                    str2 = r5.toString();
                }
                Notification.Builder contentText = new Notification.Builder(this.f11360).setOngoing(true).setVisibility(1).setShowWhen(false).setOnlyAlertOnce(true).setSmallIcon(R.drawable.ic_sb_netflix_n).setColor(this.f11360.getResources().getColor(R.color.brand_red)).setContentTitle(String.format(this.f11360.getString(R.string.skip_intro_notification_title), str)).setContentText(str2);
                contentText.setContentIntent(this.f11356.mo6164());
                if (Build.VERSION.SDK_INT >= 23) {
                    contentText.setLargeIcon(Icon.createWithResource(this.f11360, (int) R.drawable.ic_skip_intro).setTint(this.f11360.getColor(R.color.dark_grey)));
                }
                if (C1317As.m3774()) {
                    contentText.setChannelId("mdx_important_notification_channel");
                }
                this.f11359.notify(201, contentText.build());
            } else {
                this.f11359.cancel(201);
            }
            this.f11355 = z4;
            this.f11366 = this.f11357.m12192(z4, z, z3);
            this.f11366.setContentIntent(m12175());
            m12176();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m12183(boolean z) {
        return z && C0908.m15703();
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ˋ */
    public void mo6397() {
        if (this.f11359 != null) {
            this.f11359.cancel(1);
            this.f11359.cancel(201);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.vw$if  reason: invalid class name */
    public class Cif {
        private Cif() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ॱ  reason: contains not printable characters */
        public Notification.Builder m12192(boolean z, boolean z2, boolean z3) {
            if (z) {
                return m12191();
            }
            if (z2) {
                return m12188(z3);
            }
            return m12190(z3);
        }

        @SuppressLint({"InlinedApi"})
        /* renamed from: ॱ  reason: contains not printable characters */
        private Notification.Builder m12191() {
            return new Notification.Builder(C2253vw.this.f11360).setOngoing(true).setVisibility(1).setShowWhen(false).setOnlyAlertOnce(true).setSmallIcon(R.drawable.ic_sb_netflix_n).setStyle(C2253vw.this.m12184(false)).addAction(R.drawable.notif_play, "Play", C2253vw.this.f11356.B_()).addAction(R.drawable.notif_stop, "Stop", C2253vw.this.f11356.mo6186());
        }

        @SuppressLint({"InlinedApi"})
        /* renamed from: ˏ  reason: contains not printable characters */
        private Notification.Builder m12190(boolean z) {
            C1283.m16862("nf_mdxnotification", "createPlayerPausedBuilder");
            boolean r4 = m12189(z);
            Notification.Builder style = new Notification.Builder(C2253vw.this.f11360).setOngoing(true).setVisibility(1).setOnlyAlertOnce(true).setShowWhen(false).setSmallIcon(R.drawable.ic_sb_netflix_n).setStyle(C2253vw.this.m12184(r4));
            style.addAction(R.drawable.notif_back30, "Rewind", C2253vw.this.f11356.mo6176(-30)).addAction(R.drawable.notif_pause, "Play", C2253vw.this.f11356.mo6168()).addAction(R.drawable.notif_stop, "Stop", C2253vw.this.f11356.mo6186());
            if (r4) {
                style.addAction(R.drawable.ic_skip_intro, "Skip Intro", C2253vw.this.f11356.mo6164());
            }
            return style;
        }

        @SuppressLint({"InlinedApi"})
        /* renamed from: ˋ  reason: contains not printable characters */
        private Notification.Builder m12188(boolean z) {
            C1283.m16862("nf_mdxnotification", "createPlayerBuilder");
            boolean r4 = m12189(z);
            Notification.Builder style = new Notification.Builder(C2253vw.this.f11360).setOngoing(true).setVisibility(1).setOnlyAlertOnce(true).setShowWhen(false).setSmallIcon(R.drawable.ic_sb_netflix_n).setStyle(C2253vw.this.m12184(r4));
            style.addAction(R.drawable.notif_back30, "Rewind", C2253vw.this.f11356.mo6176(-30)).addAction(R.drawable.notif_play, "Pause", C2253vw.this.f11356.mo6175()).addAction(R.drawable.notif_stop, "Stop", C2253vw.this.f11356.mo6186());
            if (r4) {
                style.addAction(R.drawable.ic_skip_intro, "Skip Intro", C2253vw.this.f11356.mo6164());
            }
            return style;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private boolean m12189(boolean z) {
            return z && C0908.m15704();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private Notification.MediaStyle m12184(boolean z) {
        Notification.MediaStyle showActionsInCompactView = new Notification.MediaStyle().setShowActionsInCompactView(0, 1);
        if (z) {
            showActionsInCompactView.setShowActionsInCompactView(0, 1, 3);
        }
        if (this.f11364 == null || this.f11364.mo6242() == null) {
            C1276.m16820().mo5731(new Throwable("SPY-7597 - Got null mMediaSessionTokenProvider for MdxNotificationManagerLollipop"));
        } else {
            showActionsInCompactView.setMediaSession(this.f11364.mo6242());
        }
        return showActionsInCompactView;
    }
}
