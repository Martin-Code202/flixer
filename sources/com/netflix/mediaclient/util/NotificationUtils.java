package com.netflix.mediaclient.util;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import com.netflix.mediaclient.R;
import o.C1276;
import o.C1283;
import o.C1317As;
import o.C1349Bv;
import o.sE;
public final class NotificationUtils {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean f4002;

    public enum NotificationMessageChannelIds {
        OLD_DEFAULT_MESSAGES_CHANNEL("messages_notitication_channel", R.raw.notification),
        NO_SOUND("MESSAGE_SOUND_SILENCE.mp3", -1),
        BOOM_BOOM_SOUND("MESSAGE_SOUND_BOOM_BOOM.mp3", R.raw.message_sound_boom_boom);
        

        /* renamed from: ˎ  reason: contains not printable characters */
        private final String f4007;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final int f4008;

        private NotificationMessageChannelIds(String str, int i) {
            this.f4007 = str;
            this.f4008 = i;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public String m2997() {
            return this.f4007;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public int m2998() {
            return this.f4008;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static NotificationMessageChannelIds m2996(String str) {
            NotificationMessageChannelIds[] values = values();
            for (NotificationMessageChannelIds notificationMessageChannelIds : values) {
                if (notificationMessageChannelIds.m2997().equals(str)) {
                    return notificationMessageChannelIds;
                }
            }
            return null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m2993(Intent intent) {
        if (intent == null) {
            return false;
        }
        if ("true".equals(intent.getStringExtra("nflx_from_push_notification"))) {
            C1283.m16846("nf_notification", "From push notification, report.");
            return true;
        }
        C1283.m16854("nf_notification", "Not from push notification, do not report.");
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m2986(Intent intent) {
        if (intent != null) {
            intent.putExtra("nflx_from_push_notification", "true");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m2995(Context context) {
        if (C1317As.m3774()) {
            m2985(context);
        }
    }

    @TargetApi(26)
    /* renamed from: ˊ  reason: contains not printable characters */
    private static synchronized void m2985(Context context) {
        synchronized (NotificationUtils.class) {
            if (!f4002) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                NotificationChannel notificationChannel = new NotificationChannel("playback_notification_channel", context.getString(R.string.playback_notification_channel_name), 2);
                notificationChannel.setShowBadge(false);
                notificationManager.createNotificationChannel(notificationChannel);
                notificationManager.createNotificationChannel(new NotificationChannel("download_notification_channel", context.getString(R.string.downloads_notification_channel_name), 2));
                notificationManager.createNotificationChannel(new NotificationChannel("messages_notitication_channel", context.getString(R.string.messages_notification_channel_name), 3));
                notificationManager.createNotificationChannel(new NotificationChannel("help_notification_channel", context.getString(R.string.help_notification_channel_name), 2));
                notificationManager.createNotificationChannel(new NotificationChannel("autologin_notification_channel", context.getString(R.string.autologin_notification_channel_name), 2));
                notificationManager.createNotificationChannel(new NotificationChannel("appwidget_notification_channel", context.getString(R.string.preapp_notification_channel_name), 2));
                notificationManager.createNotificationChannel(new NotificationChannel("mdx_notification_channel", context.getString(R.string.mdx_notification_channel_name), 2));
                notificationManager.createNotificationChannel(new NotificationChannel("mdx_important_notification_channel", context.getString(R.string.mdx_important_notification_channel_name), 4));
                f4002 = true;
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Notification m2994(Context context) {
        return m2987(context, context.getText(R.string.label_notification_preapp_data), "appwidget_notification_channel");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Notification m2991(Context context) {
        return m2987(context, context.getText(R.string.label_notification_autologin), "autologin_notification_channel");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Notification m2987(Context context, CharSequence charSequence, String str) {
        return new NotificationCompat.Builder(context, str).setSmallIcon(R.drawable.ic_sb_netflix_n).setAutoCancel(false).setOnlyAlertOnce(true).setContentTitle(context.getString(R.string.app_name)).setColor(context.getResources().getColor(R.color.brand_red)).setContentText(charSequence).build();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Notification.Builder m2984(Notification.Builder builder, Context context, String str) {
        if (!C1317As.m3774()) {
            NotificationMessageChannelIds r2 = NotificationMessageChannelIds.m2996(str);
            if (r2 != null) {
                int r3 = r2.m2998();
                if (r3 == -1) {
                    builder.setSound((Uri) null, 5);
                } else {
                    builder.setSound(Uri.parse("android.resource://com.netflix.mediaclient/" + r3), 5);
                }
            } else if (C1349Bv.m4107(str)) {
                try {
                    builder.setSound(sE.m10537(str), 5);
                } catch (Throwable th) {
                    C1276.m16820().mo5729("Notification Utils - Failed to get notification sound URL from payload", th);
                }
            }
        } else if (context == null) {
            C1276.m16820().mo5725("Notification Utils.configureNotificationWithSound() - Context is null");
            return builder;
        } else {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager == null) {
                C1276.m16820().mo5725("Notification Utils.configureNotificationWithSound() - NotificationManager is null");
                return builder;
            }
            builder.setChannelId(m2988(notificationManager, context, str));
        }
        return builder;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m2992(NotificationManager notificationManager, Context context, String str) {
        if (!C1317As.m3774() || notificationManager == null || context == null) {
            return null;
        }
        return m2988(notificationManager, context, str);
    }

    @TargetApi(26)
    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m2988(NotificationManager notificationManager, Context context, String str) {
        String str2 = str;
        NotificationMessageChannelIds r3 = NotificationMessageChannelIds.m2996(str2);
        if (r3 == null) {
            str2 = NotificationMessageChannelIds.OLD_DEFAULT_MESSAGES_CHANNEL.m2997();
            if (notificationManager.getNotificationChannel(str2) == null) {
                notificationManager.createNotificationChannel(new NotificationChannel(str2, context.getString(R.string.messages_notification_channel_name), 3));
            }
        } else if (notificationManager.getNotificationChannel(str2) == null) {
            NotificationChannel notificationChannel = new NotificationChannel(str2, context.getString(R.string.messages_notification_channel_name), 3);
            int r5 = r3.m2998();
            if (r5 == -1) {
                notificationChannel.setSound(null, null);
            } else {
                notificationChannel.setSound(Uri.parse("android.resource://com.netflix.mediaclient/" + r5), new AudioAttributes.Builder().setContentType(4).setUsage(5).build());
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationMessageChannelIds[] values = NotificationMessageChannelIds.values();
        for (NotificationMessageChannelIds notificationMessageChannelIds : values) {
            if (!notificationMessageChannelIds.m2997().equals(str2)) {
                notificationManager.deleteNotificationChannel(notificationMessageChannelIds.m2997());
            }
        }
        return str2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m2990(Context context) {
        if (context == null) {
            C1276.m16820().mo5725("NotificationUtils.isSoundEnabledOnDevice() context is null. Returning false");
            return false;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            return audioManager.getRingerMode() == 2;
        }
        C1276.m16820().mo5725("NotificationUtils.isSoundEnabledOnDevice() AudioManager is null. Returning false");
        return false;
    }

    @TargetApi(26)
    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m2989(NotificationManager notificationManager, String str) {
        if (notificationManager == null || C1349Bv.m4113(str)) {
            C1276.m16820().mo5725("NotificationUtils.isNotificationSoundEnabled() NotificationManager is null or notificationChannelId is null. Returning false");
            return false;
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
        return (notificationChannel == null || notificationChannel.getSound() == null || (3 != notificationChannel.getImportance() && 4 != notificationChannel.getImportance())) ? false : true;
    }
}
