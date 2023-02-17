package o;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.LruCache;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.offline.agent.IntentCommandGroupType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import com.netflix.mediaclient.util.l10n.BidiMarker;
import java.util.List;
/* access modifiers changed from: package-private */
public abstract class vC extends AbstractC2068pq implements AbstractC1852hk {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final AbstractC1853hl f11109;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final oS f11110;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f11111 = 0;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f11112 = 101;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f11113 = 103;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f11114 = 102;

    /* renamed from: ˏ  reason: contains not printable characters */
    final Context f11115;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final LruCache<String, If> f11116;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC0933 f11117;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f11118 = 192;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f11119 = 192;

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract int mo11869();

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract void mo11870(Notification.Builder builder);

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract void mo11871(Notification.Builder builder, pV pVVar);

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract int mo11872();

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract String mo11874(pV pVVar, If v);

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract void mo11875(Notification.Builder builder, pV pVVar);

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract void mo11878(Notification.Builder builder);

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract void mo11879(Notification.Builder builder, pV pVVar);

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract void mo11880(Notification.Builder builder, pV pVVar, VideoType videoType);

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract String mo11883(pV pVVar, If v);

    /* access modifiers changed from: package-private */
    public class If {

        /* renamed from: ˊ  reason: contains not printable characters */
        CharSequence f11125 = "";

        /* renamed from: ˋ  reason: contains not printable characters */
        CharSequence f11126 = "";

        /* renamed from: ˎ  reason: contains not printable characters */
        Bitmap f11127 = null;

        /* renamed from: ˏ  reason: contains not printable characters */
        VideoType f11128 = null;

        /* renamed from: ॱ  reason: contains not printable characters */
        boolean f11129 = false;

        If() {
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static vC m11851(Handler handler, Context context, oS oSVar, AbstractC0933 r10, boolean z, AbstractC1853hl hlVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new vG(handler, context, oSVar, r10, z, hlVar);
        }
        return new vE(handler, context, oSVar, r10, z, hlVar);
    }

    vC(Handler handler, Context context, oS oSVar, AbstractC0933 r6, boolean z, AbstractC1853hl hlVar) {
        this.f11110 = oSVar;
        this.f11117 = r6;
        this.f11115 = context;
        this.f11109 = hlVar;
        this.f11116 = new LruCache<>(z ? 2 : 4);
        handler.post(new Runnable() { // from class: o.vC.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    vC.this.f11118 = vC.this.f11115.getResources().getDimensionPixelSize(17104901);
                    vC.this.f11119 = vC.this.f11115.getResources().getDimensionPixelSize(17104902);
                } catch (Exception e) {
                    C1276.m16820().mo5730(e);
                }
                vC.this.f11109.mo7124(vC.this);
            }
        });
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ॱ */
    public void mo2185(String str, Status status) {
        pV r1;
        if (status.mo298() && (r1 = vO.m12029(this.f11109).mo11976(str)) != null) {
            m11868(r1);
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˏ */
    public void mo2180(String str, Status status, boolean z) {
        if (!m11843(str)) {
            this.f11111 = 0;
            m11847();
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˎ */
    public void mo2178(List<String> list, Status status) {
        this.f11111 = 0;
        m11847();
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo1758(Status status) {
        C1283.m16862("nf_downloadNotification", "onAllPlayablesDeleted status=" + status);
        m11847();
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ॱ */
    public void mo2184(Status status) {
        m11847();
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo2176(pV pVVar, Status status) {
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˎ */
    public void mo2179(pV pVVar, Status status) {
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˏ */
    public void mo2182(boolean z) {
        m11847();
    }

    @Override // o.AbstractC1854hm
    public boolean aa_() {
        return false;
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˏ */
    public void mo2181(pV pVVar, int i) {
        NotificationManager notificationManager;
        C1283.m16862("nf_downloadNotification", "onOfflinePlayableProgress");
        If r2 = m11868(pVVar);
        Notification.Builder builder = new Notification.Builder(this.f11115);
        builder.setProgress(100, i, false);
        mo11875(builder, pVVar);
        mo11871(builder, pVVar);
        builder.setContentText(m11866(pVVar)).setShowWhen(false).setOngoing(true).setAutoCancel(false);
        mo11870(builder);
        String r4 = mo11883(pVVar, r2);
        CharSequence string = r2.f11129 ? this.f11115.getString(R.string.label_notification_smart_download_progress_title) : r2.f11126;
        Notification.BigTextStyle bigContentTitle = new Notification.BigTextStyle().setBigContentTitle(string);
        bigContentTitle.bigText(r4);
        builder.setContentTitle(string).setStyle(bigContentTitle);
        builder.setContentIntent(m11854(pVVar.mo6915()));
        Notification r7 = m11861(builder, r2.f11127);
        if (r7 != null && (notificationManager = (NotificationManager) this.f11115.getSystemService("notification")) != null) {
            m11867(notificationManager);
            this.f11110.mo9579(101, r7);
            try {
                notificationManager.notify(101, r7);
            } catch (Exception e) {
                C1276.m16820().mo5730(e);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private String m11866(pV pVVar) {
        return BG.m3854(pVVar.mo6916());
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˊ */
    public void mo2174(pV pVVar) {
        If r2 = m11868(pVVar);
        C1283.m16861("download completed. ");
        if (r2.f11128 != null) {
            m11863(pVVar);
            return;
        }
        C1283.m16850("nf_downloadNotification", "mVideoType is not available.");
        m11847();
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo2175(pV pVVar) {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11863(pV pVVar) {
        Notification notification;
        NotificationManager notificationManager;
        CharSequence charSequence;
        CharSequence charSequence2;
        If r3 = m11868(pVVar);
        this.f11111++;
        Notification.Builder builder = new Notification.Builder(this.f11115);
        builder.setDeleteIntent(m11862());
        builder.setShowWhen(true).setOngoing(false).setSmallIcon(mo11872()).setAutoCancel(true);
        CharSequence string = r3.f11129 ? this.f11115.getString(R.string.label_notification_smart_download_complete_title) : this.f11115.getString(R.string.label_notification_download_complete);
        builder.setContentTitle(string).setTicker(string);
        if (this.f11111 <= 1) {
            if (r3.f11129) {
                charSequence2 = m11855(pVVar, this.f11111);
            } else {
                charSequence2 = C1349Bv.m4112(r3.f11125) ? ((Object) r3.f11126) + "\n" + ((Object) r3.f11125) : r3.f11126;
            }
            builder.setContentText(charSequence2);
            Notification.BigTextStyle bigContentTitle = new Notification.BigTextStyle().setBigContentTitle(string);
            bigContentTitle.bigText(charSequence2);
            builder.setStyle(bigContentTitle);
            mo11880(builder, pVVar, r3.f11128);
            builder.setContentIntent(m11854(pVVar.mo6915()));
            notification = m11861(builder, r3.f11127);
        } else {
            int i = this.f11111 - 1;
            if (r3.f11129) {
                charSequence = m11855(pVVar, this.f11111);
            } else {
                charSequence = C0403.m14185(this.f11115, R.string.label_notification_n_other_titles).m14187(i).m14186("showOrMovieName", r3.f11126).m14188();
            }
            builder.setContentText(charSequence);
            builder.setStyle(new Notification.BigTextStyle().bigText(charSequence));
            builder.setContentIntent(m11854((String) null));
            notification = m11861(builder, r3.f11127);
        }
        if (notification != null && (notificationManager = (NotificationManager) this.f11115.getSystemService("notification")) != null) {
            m11867(notificationManager);
            if (!r3.f11129 || !C0880.m15596()) {
                this.f11110.mo9578(103, false);
                notificationManager.notify(103, notification);
            }
            m11849(notificationManager);
        }
    }

    @Override // o.AbstractC2068pq, o.AbstractC1854hm
    /* renamed from: ˋ */
    public void mo2177(pV pVVar, StopReason stopReason) {
        String str;
        if (stopReason == StopReason.StoppedFromAgentAPI) {
            m11858(pVVar);
            return;
        }
        if (stopReason == StopReason.NoNetworkConnectivity || stopReason == StopReason.NotAllowedOnCurrentNetwork) {
            if (this.f11109.mo7131()) {
                str = this.f11115.getString(R.string.label_notification_requires_wifi_network);
            } else {
                str = this.f11115.getString(R.string.label_notification_requires_some_network);
            }
        } else if (stopReason == StopReason.NotEnoughSpace) {
            str = this.f11115.getString(R.string.label_notification_not_enough_free_space);
        } else if (stopReason == StopReason.EncodesAreNotAvailableAnyMore || stopReason == StopReason.GeoCheckError) {
            String r3 = BF.m3844(BF.m3846(stopReason));
            String string = this.f11115.getString(R.string.label_notification_download_error);
            str = BX.m3956(string, BidiMarker.FORCED_RTL) + BX.m3956(r3, BidiMarker.FORCED_RTL);
        } else {
            m11847();
            return;
        }
        m11864(pVVar, str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private CharSequence m11855(pV pVVar, int i) {
        pF playable;
        String str;
        C2098qr r4 = C2093qn.m10096(pVVar.mo6915());
        if (r4 == null || (playable = r4.getPlayable()) == null) {
            return "";
        }
        if (r4.isEpisodeNumberHidden()) {
            str = playable.getParentTitle();
        } else {
            str = this.f11115.getString(R.string.label_showTitleSeasonEpisode, playable.getParentTitle(), playable.getSeasonAbbrSeqLabel(), Integer.valueOf(playable.getEpisodeNumber()));
        }
        if (i <= 1) {
            return this.f11115.getString(R.string.label_notification_smart_downloads_complete_text, str);
        }
        return C0403.m14185(this.f11115, R.string.label_notification_smart_downloads_n_other_titles).m14187(this.f11111 - 1).m14186("showOrMovieName", str).m14188();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11864(pV pVVar, String str) {
        If r2 = m11868(pVVar);
        Notification.Builder builder = new Notification.Builder(this.f11115);
        builder.setContentText(str).setShowWhen(true).setOngoing(false).setSmallIcon(mo11869()).setAutoCancel(true);
        Notification.BigTextStyle bigContentTitle = new Notification.BigTextStyle().setBigContentTitle(r2.f11126);
        bigContentTitle.bigText(str);
        builder.setContentTitle(r2.f11126).setStyle(bigContentTitle).setContentText(str);
        builder.setContentIntent(m11854(pVVar.mo6915()));
        Notification r5 = m11861(builder, r2.f11127);
        if (r5 != null) {
            r5.priority = 2;
            NotificationManager notificationManager = (NotificationManager) this.f11115.getSystemService("notification");
            if (notificationManager != null) {
                m11849(notificationManager);
                notificationManager.notify(102, r5);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11858(pV pVVar) {
        NotificationManager notificationManager;
        If r3 = m11868(pVVar);
        Notification.Builder builder = new Notification.Builder(this.f11115);
        builder.setProgress(100, pVVar.mo6916(), false);
        mo11879(builder, pVVar);
        mo11871(builder, pVVar);
        builder.setContentText(m11866(pVVar));
        builder.setShowWhen(false).setOngoing(false).setAutoCancel(false);
        mo11878(builder);
        String r5 = mo11874(pVVar, r3);
        Notification.BigTextStyle bigContentTitle = new Notification.BigTextStyle().setBigContentTitle(r3.f11126);
        bigContentTitle.bigText(r5);
        builder.setContentTitle(r3.f11126).setStyle(bigContentTitle);
        builder.setContentIntent(m11854(pVVar.mo6915()));
        Notification r7 = m11861(builder, r3.f11127);
        if (r7 != null && (notificationManager = (NotificationManager) this.f11115.getSystemService("notification")) != null) {
            m11867(notificationManager);
            this.f11110.mo9578(101, false);
            notificationManager.notify(101, r7);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public String m11877(pV pVVar, If r12) {
        long r2 = pVVar.mo6914();
        long r4 = pVVar.mo6887();
        StringBuilder sb = new StringBuilder();
        if (r12.f11129 && C1349Bv.m4112(r12.f11126)) {
            sb.append(r12.f11126).append(" ");
        }
        if (C1349Bv.m4112(r12.f11125)) {
            sb.append(r12.f11125).append("\n");
        }
        String r7 = m11866(pVVar);
        String r8 = BG.m3861(this.f11115, r2);
        sb.append(C0403.m14185(this.f11115, R.string.label_notification_download_progress).m14186("percentage", r7).m14186("currentRatio", r8).m14186("totalRatio", BG.m3861(this.f11115, r4)).m14188());
        return sb.toString();
    }

    @Override // o.AbstractC1852hk
    /* renamed from: ˏ */
    public void mo7116(Intent intent) {
        C1283.m16862("nf_downloadNotification", "intent=" + intent);
        String stringExtra = intent.getStringExtra("playable_id");
        VideoType create = VideoType.create(intent.getStringExtra("videoType"));
        String action = intent.getAction();
        if (action != null) {
            char c = 65535;
            switch (action.hashCode()) {
                case -1115604265:
                    if (action.equals("com.netflix.mediaclient.intent.action.offline.watch_playable")) {
                        c = 2;
                        break;
                    }
                    break;
                case -387641117:
                    if (action.equals("com.netflix.mediaclient.intent.action.offline.delete_download")) {
                        c = 3;
                        break;
                    }
                    break;
                case -334911956:
                    if (action.equals("com.netflix.mediaclient.intent.action.offline.stop_download")) {
                        c = 0;
                        break;
                    }
                    break;
                case -78267907:
                    if (action.equals("com.netflix.mediaclient.intent.action.offline.download_complete_notification_dismissed")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1770353310:
                    if (action.equals("com.netflix.mediaclient.intent.action.offline.start_download")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.f11109.mo7123(stringExtra);
                    break;
                case 1:
                    this.f11109.mo7128(stringExtra);
                    break;
                case 2:
                    m11847();
                    m11844();
                    m11852(stringExtra, create);
                    break;
                case 3:
                    m11847();
                    this.f11109.mo7140(stringExtra);
                    break;
                case 4:
                    this.f11111 = 0;
                    break;
                default:
                    C1283.m16862("nf_downloadNotification", "no action done.");
                    break;
            }
        }
        if (intent.getAction().equals("com.netflix.mediaclient.intent.action.offline.launch_offline_activity")) {
            this.f11111 = 0;
            m11845(stringExtra);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private Notification m11861(Notification.Builder builder, Bitmap bitmap) {
        C1283.m16862("nf_downloadNotification", "buildNotification");
        builder.setOnlyAlertOnce(true);
        if (Build.VERSION.SDK_INT >= 21) {
            builder.setVisibility(1);
            builder.setColor(ContextCompat.getColor(this.f11115, R.color.brand_red));
        }
        if (bitmap != null) {
            builder.setLargeIcon(bitmap);
        }
        if (C1317As.m3774()) {
            builder.setChannelId("download_notification_channel");
        }
        try {
            return builder.build();
        } catch (Exception e) {
            C1276.m16820().mo5730(e);
            return null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11850(pV pVVar, final If r11) {
        pF playable;
        String str;
        C2098qr r5 = C2093qn.m10096(pVVar.mo6915());
        if (r5 != null && (playable = r5.getPlayable()) != null) {
            String str2 = "";
            r11.f11128 = r5.getType();
            if (r11.f11128 == VideoType.EPISODE) {
                str = new String(playable.getParentTitle());
                if (r5.isEpisodeNumberHidden()) {
                    str2 = this.f11115.getString(R.string.label_episodeTitleBasicQuoted, r5.getTitle());
                } else {
                    str2 = this.f11115.getString(R.string.label_episodeTitle, playable.getSeasonAbbrSeqLabel(), Integer.valueOf(playable.getEpisodeNumber()), r5.getTitle());
                }
            } else {
                str = new String(r5.getTitle());
            }
            r11.f11126 = BX.m3956(str, BidiMarker.FORCED_RTL);
            r11.f11125 = BX.m3956(str2, BidiMarker.FORCED_RTL);
            this.f11117.mo15746(r5.getBoxshotUrl(), 0, 0, new AbstractC0957() { // from class: o.vC.2
                @Override // o.AbstractC0957
                public void onErrorResponse(String str3) {
                    r11.f11127 = null;
                }

                /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0011: APUT  
                  (r2v1 java.lang.Object[])
                  (0 ??[int, short, byte, char])
                  (wrap: java.lang.Boolean : 0x000c: INVOKE  (r3v1 java.lang.Boolean) = (r3v0 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
                 */
                @Override // o.AbstractC0957
                public void onResponse(final Bitmap bitmap, String str3) {
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(bitmap != null);
                    C1283.m16863("nf_downloadNotification", "fetchNotificationData onResponse gotImage=%b", objArr);
                    if (bitmap != null) {
                        new BackgroundTask().m285(new Runnable() { // from class: o.vC.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                r11.f11127 = C1317As.m3764(bitmap, vC.this.f11118, vC.this.f11119, true);
                            }
                        });
                    }
                }
            });
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private If m11868(pV pVVar) {
        If r2 = this.f11116.get(pVVar.mo6915());
        if (r2 == null) {
            r2 = new If();
            this.f11116.put(pVVar.mo6915(), r2);
            m11850(pVVar, r2);
        }
        r2.f11129 = m11846(pVVar);
        return r2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public PendingIntent m11873(String str) {
        return m11853(new Intent("com.netflix.mediaclient.intent.action.offline.stop_download"), str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public PendingIntent m11882(String str) {
        return m11853(new Intent("com.netflix.mediaclient.intent.action.offline.start_download"), str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public PendingIntent m11876(String str, VideoType videoType) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.offline.watch_playable");
        intent.putExtra("videoType", videoType.getValue());
        return m11853(intent, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public PendingIntent m11881(String str) {
        return m11853(new Intent("com.netflix.mediaclient.intent.action.offline.delete_download"), str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private PendingIntent m11854(String str) {
        return m11853(new Intent("com.netflix.mediaclient.intent.action.offline.launch_offline_activity"), str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private PendingIntent m11862() {
        return m11853(new Intent("com.netflix.mediaclient.intent.action.offline.download_complete_notification_dismissed"), (String) null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private PendingIntent m11853(Intent intent, String str) {
        intent.setClass(this.f11115, ServiceC0966.class).addCategory("com.netflix.mediaclient.intent.category.offline");
        if (str != null) {
            intent.putExtra("playable_id", str);
        }
        IntentCommandGroupType.m821(intent, IntentCommandGroupType.DownloadNotification);
        return PendingIntent.getService(this.f11115, 0, intent, 134217728);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m11845(String str) {
        Intent intent;
        if (str != null) {
            intent = vH.m11928(this.f11115, str, true);
        } else {
            intent = vH.m11930(this.f11115, true);
        }
        this.f11115.startActivity(intent);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11852(String str, VideoType videoType) {
        Intent r2 = ActivityC2280wv.m12564(this.f11115, str, videoType, qN.f9495);
        r2.addFlags(268435456);
        this.f11115.startActivity(r2);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m11847() {
        C1283.m16862("nf_downloadNotification", "removeAllNotifications");
        NotificationManager notificationManager = (NotificationManager) this.f11115.getSystemService("notification");
        if (notificationManager != null) {
            m11849(notificationManager);
            m11867(notificationManager);
            m11857(notificationManager);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11857(NotificationManager notificationManager) {
        C1283.m16854("nf_downloadNotification", "cancelAndRemoveDownloadProgressNotification");
        notificationManager.cancel(103);
        this.f11110.mo9578(103, true);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11849(NotificationManager notificationManager) {
        C1283.m16854("nf_downloadNotification", "cancelAndRemoveDownloadProgressNotification");
        notificationManager.cancel(101);
        this.f11110.mo9578(101, true);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11867(NotificationManager notificationManager) {
        C1283.m16854("nf_downloadNotification", "cancelAndRemoveErrorNotification");
        notificationManager.cancel(102);
    }

    @Override // o.AbstractC1852hk
    /* renamed from: ॱ */
    public void mo7117() {
        C1348Bu.m4093();
        m11847();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m11844() {
        this.f11115.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m11843(String str) {
        if (this.f11116 == null || this.f11116.size() == 0 || str == null || str.equals(this.f11116.snapshot().keySet().toArray()[this.f11116.size() - 1])) {
            return false;
        }
        return ((If) this.f11116.snapshot().values().toArray()[this.f11116.size() - 1]).f11129;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private static boolean m11846(pV pVVar) {
        return pVVar.mo6907() == qN.f9513.getTrackId();
    }
}
