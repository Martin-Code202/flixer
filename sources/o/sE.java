package o;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.pushnotification.NotificationReceiver;
import com.netflix.mediaclient.service.pushnotification.Payload;
import com.netflix.mediaclient.service.pushnotification.UserFeedbackOnReceivedPushNotification;
import com.netflix.mediaclient.util.NotificationUtils;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.Locale;
public abstract class sE {
    sE() {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    protected static PendingIntent m10524(Context context, Payload payload, int i) {
        String scheme;
        Uri r2 = payload.m1197();
        if (r2 == null || (scheme = r2.getScheme()) == null || (!"https".equals(scheme.toLowerCase(Locale.US)) && !"http".equals(scheme.toLowerCase(Locale.US)))) {
            C1283.m16854("nf_push", "Target destination is our application");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(r2);
            NotificationUtils.m2986(intent);
            intent.setFlags(872415232);
            intent.putExtra("notificationId", i);
            if (!C1349Bv.m4113(payload.f2152)) {
                intent.putExtra("guid", payload.f2152);
            }
            if (!C1349Bv.m4113(payload.f2158)) {
                intent.putExtra("messageGuid", payload.f2158);
            }
            if (C1349Bv.m4107(payload.f2154)) {
                intent.putExtra("originator", payload.f2154);
            }
            return PendingIntent.getActivity(context, 0, intent, 134217728);
        }
        C1283.m16854("nf_push", "Target destination is web site https or http");
        return m10536(context, r2, payload);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static PendingIntent m10531(Context context, Payload payload) {
        Intent intent = new Intent(context, NotificationReceiver.class);
        intent.setAction("com.netflix.mediaclient.intent.action.NOTIFICATION_CANCELED");
        if (!C1349Bv.m4113(payload.f2152)) {
            intent.putExtra("guid", payload.f2152);
        }
        if (!C1349Bv.m4113(payload.f2158)) {
            intent.putExtra("messageGuid", payload.f2158);
        }
        if (C1349Bv.m4107(payload.f2154)) {
            intent.putExtra("originator", payload.f2154);
        }
        return PendingIntent.getBroadcast(context, 0, intent, 268435456);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Uri m10537(String str) {
        if (str != null && str.trim().toLowerCase(Locale.US).startsWith("http")) {
            return Uri.parse(str);
        }
        C1283.m16854("nf_push", "default sound");
        return Uri.parse("android.resource://com.netflix.mediaclient/2131820548");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    protected static PendingIntent m10534(Context context, Uri uri, Payload payload, Payload.If r8, int i) {
        String str = r8.f2165;
        String str2 = r8.f2167;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setFlags(872415232);
        if (!C1349Bv.m4113(str)) {
            intent.putExtra("notificationAction", str);
        }
        if (!C1349Bv.m4113(str2)) {
            intent.putExtra("notificationActionTrackingInfo", str2);
        }
        intent.putExtra("notificationId", i);
        if (!C1349Bv.m4113(payload.f2152)) {
            intent.putExtra("guid", payload.f2152);
        }
        if (!C1349Bv.m4113(payload.f2158)) {
            intent.putExtra("messageGuid", payload.f2158);
        }
        if (C1349Bv.m4107(payload.f2154)) {
            intent.putExtra("originator", payload.f2154);
        }
        return PendingIntent.getActivity(context, 0, intent, 134217728);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static PendingIntent m10530(Context context, Uri uri, Payload payload) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", AJ.m3361(context.getResources(), payload.m1198(""), uri.toString()));
        intent.putExtra("playable_id", payload.m1194());
        intent.setFlags(268435456);
        if (!C1349Bv.m4113(payload.f2152)) {
            intent.putExtra("guid", payload.f2152);
        }
        if (!C1349Bv.m4113(payload.f2158)) {
            intent.putExtra("messageGuid", payload.f2158);
        }
        if (C1349Bv.m4107(payload.f2154)) {
            intent.putExtra("originator", payload.f2154);
        }
        return PendingIntent.getActivity(context, 0, Intent.createChooser(intent, context.getResources().getString(R.string.share_dialog_title)), 134217728);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    protected static PendingIntent m10536(Context context, Uri uri, Payload payload) {
        Intent intent = new Intent(context, NotificationReceiver.class);
        intent.setAction("com.netflix.mediaclient.intent.action.NOTIFICATION_BROWSER_REDIRECT");
        intent.putExtra("target_url", uri.toString());
        if (!C1349Bv.m4113(payload.f2152)) {
            intent.putExtra("guid", payload.f2152);
        }
        if (!C1349Bv.m4113(payload.f2158)) {
            intent.putExtra("messageGuid", payload.f2158);
        }
        if (C1349Bv.m4107(payload.f2154)) {
            intent.putExtra("originator", payload.f2154);
        }
        return PendingIntent.getBroadcast(context, 0, intent, 268435456);
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m10525(Context context, Notification notification, int i, Payload payload) {
        if (context == null || notification == null || payload == null) {
            C1276.m16820().mo5725("Inside NotificationBuilder.addBigViewIfAvailableAndSend(). Either context or notification or payload is null");
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        boolean r3 = NotificationUtils.m2990(context);
        if (C1317As.m3743()) {
            r3 = r3 && NotificationUtils.m2989(notificationManager, notification.getChannelId());
        } else {
            C1317As.m3745();
        }
        Logger.INSTANCE.m131(new C1042(SystemClock.currentThreadTimeMillis(), r3, new C2000nd(payload)));
        C1361Cg.m4376(context, new C1579cA(new C1583cE(payload)));
        if (notificationManager != null) {
            try {
                notificationManager.notify(i, notification);
            } catch (SecurityException e) {
                C1283.m16847("nf_push", "We are missing privilege?", e);
            } catch (Throwable th) {
                C1283.m16847("nf_push", "Unexpected failure when trying to send notification", th);
            }
        } else {
            C1283.m16850("nf_push", "Notification manager is not available!");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m10533(final Context context, final Payload payload, final AbstractC0933 r22, final int i) {
        Uri r19;
        long r7 = payload.m1193();
        String r9 = payload.m1195(context.getString(R.string.app_name));
        String r10 = payload.m1199(r9);
        final Notification.Builder builder = new Notification.Builder(context);
        NotificationUtils.m2984(builder, context, payload.f2142);
        builder.setContentIntent(m10524(context, payload, i));
        builder.setDeleteIntent(m10531(context, payload));
        builder.setTicker(r10);
        builder.setAutoCancel(true);
        builder.setContentTitle(r9);
        builder.setContentText(payload.f2137);
        builder.setSmallIcon(R.drawable.ic_sb_netflix_n);
        builder.setWhen(r7);
        builder.setSubText(payload.f2147);
        builder.setColor(context.getResources().getColor(R.color.brand_red));
        Payload.If[] r14 = payload.m1196();
        int length = r14.length;
        for (int i2 = 0; i2 < length; i2++) {
            Payload.If r18 = r14[i2];
            if (!(r18 == null || (r19 = r18.m1204()) == null)) {
                if ("SHARE".equals(r18.f2165)) {
                    builder.addAction(R.color.transparent, r18.f2169, m10530(context, r19, payload));
                } else {
                    builder.addAction(R.color.transparent, r18.f2169, m10534(context, r19, payload, r18, i));
                }
            }
        }
        if (C1349Bv.m4113(payload.f2131) || r22 == null) {
            C1283.m16854("nf_push", "Icon was not set");
            m10535(context, payload, builder, i, r22);
            return;
        }
        r22.mo15746(payload.f2131, 0, 0, new AbstractC0957() { // from class: o.sE.5
            @Override // o.AbstractC0957
            @SuppressLint({"NewApi"})
            public void onResponse(Bitmap bitmap, String str) {
                if (bitmap != null) {
                    if (C1317As.m3758() >= 21) {
                        builder.setLargeIcon(ViewUtils.m3024(bitmap));
                    } else {
                        builder.setLargeIcon(bitmap);
                    }
                    sE.m10535(context, payload, builder, i, r22);
                    C1283.m16854("nf_push", "Large icon image set!");
                }
            }

            @Override // o.AbstractC0957
            public void onErrorResponse(String str) {
                sE.m10535(context, payload, builder, i, r22);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m10535(Context context, Payload payload, Notification.Builder builder, int i, AbstractC0933 r6) {
        if (context == null || payload == null || builder == null) {
            C1276.m16820().mo5725("Inside NotificationBuilder.addBigViewIfAvailableAndSend(). Either payload or context or builder is null");
        } else if (C1349Bv.m4113(payload.f2155) || r6 == null) {
            m10529(context, payload, builder, i);
        } else {
            m10532(context, payload, builder, i, r6);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m10532(final Context context, final Payload payload, final Notification.Builder builder, final int i, AbstractC0933 r9) {
        if (context == null || payload == null || builder == null) {
            C1276.m16820().mo5725("Inside NotificationBuilder.addBigPictureIfAvailableAndSend(). Either payload or context or builder is null");
        } else if (C1349Bv.m4113(payload.f2155) || r9 == null) {
            C1283.m16854("nf_push", "Large picture view was not set");
            m10525(context, builder.build(), i, payload);
        } else {
            r9.mo15744(payload.f2155, 0, 0, new AbstractC0957() { // from class: o.sE.1
                @Override // o.AbstractC0957
                public void onResponse(Bitmap bitmap, String str) {
                    if (bitmap != null) {
                        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(builder);
                        bigPictureStyle.bigPicture(bitmap);
                        C1283.m16854("nf_push", "Big picture image is set");
                        if (!C1349Bv.m4113(payload.f2150)) {
                            bigPictureStyle.setSummaryText(payload.f2150);
                        }
                        if (!C1349Bv.m4113(payload.f2144)) {
                            bigPictureStyle.setBigContentTitle(payload.f2144);
                        }
                        sE.m10525(context, bigPictureStyle.build(), i, payload);
                    }
                }

                @Override // o.AbstractC0957
                public void onErrorResponse(String str) {
                    sE.m10529(context, payload, builder, i);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m10529(Context context, Payload payload, Notification.Builder builder, int i) {
        Notification notification;
        if (context == null || payload == null || builder == null) {
            C1276.m16820().mo5725("Inside NotificationBuilder.addBigTextViewIfAvailableAndSend(). Either context or payload or builder is null");
            return;
        }
        if (!C1349Bv.m4113(payload.f2129)) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle(builder);
            bigTextStyle.bigText(payload.f2129);
            if (!C1349Bv.m4113(payload.f2150)) {
                bigTextStyle.setSummaryText(payload.f2150);
            }
            if (!C1349Bv.m4113(payload.f2144)) {
                bigTextStyle.setBigContentTitle(payload.f2144);
            }
            notification = bigTextStyle.build();
        } else {
            notification = builder.build();
        }
        m10525(context, notification, i, payload);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m10528(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("notificationId", -1);
        if (intExtra != -1 && !C1349Bv.m4113(intent.getStringExtra("messageGuid"))) {
            String stringExtra = intent.getStringExtra("notificationAction");
            String stringExtra2 = intent.getStringExtra("notificationActionTrackingInfo");
            if (C1349Bv.m4113(stringExtra)) {
                stringExtra = UserFeedbackOnReceivedPushNotification.opened.m1248();
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(intExtra);
            }
            C1999nc r9 = C1999nc.m9278(intent);
            if (r9 != null) {
                Logger.INSTANCE.m131(new C1032(new C2000nd(r9), 0));
                C1361Cg.m4378(context, new C1582cD(new C1583cE(r9), stringExtra, stringExtra2));
            }
        }
    }
}
