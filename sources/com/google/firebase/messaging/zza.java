package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.common.util.zzp;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
final class zza {
    private static zza zzmmg;
    private final Context mContext;
    private Bundle zzfqn;
    private Method zzhqr;
    private Method zzhqs;
    private final AtomicInteger zzmmh = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private zza(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @TargetApi(26)
    private final Notification zza(CharSequence charSequence, String str, int i, Integer num, Uri uri, PendingIntent pendingIntent, PendingIntent pendingIntent2, String str2) {
        Notification.Builder smallIcon = new Notification.Builder(this.mContext).setAutoCancel(true).setSmallIcon(i);
        if (!TextUtils.isEmpty(charSequence)) {
            smallIcon.setContentTitle(charSequence);
        }
        if (!TextUtils.isEmpty(str)) {
            smallIcon.setContentText(str);
            smallIcon.setStyle(new Notification.BigTextStyle().bigText(str));
        }
        if (num != null) {
            smallIcon.setColor(num.intValue());
        }
        if (uri != null) {
            smallIcon.setSound(uri);
        }
        if (pendingIntent != null) {
            smallIcon.setContentIntent(pendingIntent);
        }
        if (pendingIntent2 != null) {
            smallIcon.setDeleteIntent(pendingIntent2);
        }
        if (str2 != null) {
            if (this.zzhqr == null) {
                this.zzhqr = zzhq("setChannelId");
            }
            if (this.zzhqr == null) {
                this.zzhqr = zzhq("setChannel");
            }
            if (this.zzhqr == null) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel");
            } else {
                try {
                    this.zzhqr.invoke(smallIcon, str2);
                } catch (IllegalAccessException e) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
                } catch (InvocationTargetException e2) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e2);
                } catch (SecurityException e3) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e3);
                } catch (IllegalArgumentException e4) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e4);
                }
            }
        }
        return smallIcon.build();
    }

    private static void zza(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals(NetflixActivity.EXTRA_FROM)) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    static boolean zzad(Bundle bundle) {
        return "1".equals(zze(bundle, "gcm.n.e")) || zze(bundle, "gcm.n.icon") != null;
    }

    static Uri zzae(Bundle bundle) {
        String zze = zze(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(zze)) {
            zze = zze(bundle, "gcm.n.link");
        }
        if (!TextUtils.isEmpty(zze)) {
            return Uri.parse(zze);
        }
        return null;
    }

    static String zzaf(Bundle bundle) {
        String zze = zze(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(zze) ? zze(bundle, "gcm.n.sound") : zze;
    }

    private final Bundle zzasi() {
        if (this.zzfqn != null) {
            return this.zzfqn;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return Bundle.EMPTY;
        }
        this.zzfqn = applicationInfo.metaData;
        return this.zzfqn;
    }

    static String zze(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    static synchronized zza zzeq(Context context) {
        zza zza;
        synchronized (zza.class) {
            if (zzmmg == null) {
                zzmmg = new zza(context);
            }
            zza = zzmmg;
        }
        return zza;
    }

    static String zzh(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        return zze(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    @TargetApi(26)
    private static Method zzhq(String str) {
        try {
            return Notification.Builder.class.getMethod(str, String.class);
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (SecurityException unused2) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String[] */
    /* JADX WARN: Multi-variable type inference failed */
    static Object[] zzi(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_args");
        String zze = zze(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(zze)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(zze);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return strArr;
        } catch (JSONException unused) {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf("_loc_args");
            String substring = (valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).substring(6);
            Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(zze).length() + String.valueOf(substring).length() + 41).append("Malformed ").append(substring).append(": ").append(zze).append("  Default value will be used.").toString());
            return null;
        }
    }

    private final String zzj(Bundle bundle, String str) {
        String zze = zze(bundle, str);
        if (!TextUtils.isEmpty(zze)) {
            return zze;
        }
        String zzh = zzh(bundle, str);
        if (TextUtils.isEmpty(zzh)) {
            return null;
        }
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(zzh, "string", this.mContext.getPackageName());
        if (identifier == 0) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf("_loc_key");
            String substring = (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).substring(6);
            Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(zzh).length() + String.valueOf(substring).length() + 49).append(substring).append(" resource not found: ").append(zzh).append(" Default value will be used.").toString());
            return null;
        }
        Object[] zzi = zzi(bundle, str);
        if (zzi == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, zzi);
        } catch (MissingFormatArgumentException e) {
            String arrays = Arrays.toString(zzi);
            Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(arrays).length() + String.valueOf(zzh).length() + 58).append("Missing format argument for ").append(zzh).append(": ").append(arrays).append(" Default value will be used.").toString(), e);
            return null;
        }
    }

    private final Integer zzqm(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(str).length() + 54).append("Color ").append(str).append(" not valid. Notification will use default color.").toString());
            }
        }
        int i = zzasi().getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i == 0) {
            return null;
        }
        try {
            return Integer.valueOf(ContextCompat.getColor(this.mContext, i));
        } catch (Resources.NotFoundException unused2) {
            Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            return null;
        }
    }

    @TargetApi(26)
    private final String zzqn(String str) {
        if (!zzp.isAtLeastO()) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        try {
            if (this.zzhqs == null) {
                this.zzhqs = notificationManager.getClass().getMethod("getNotificationChannel", String.class);
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.zzhqs.invoke(notificationManager, str) != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(str).length() + 122).append("Notification Channel requested (").append(str).append(") has not been created by the app. Manifest configuration, or default, value will be used.").toString());
            }
            String string = zzasi().getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else if (this.zzhqs.invoke(notificationManager, string) != null) {
                return string;
            } else {
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            if (this.zzhqs.invoke(notificationManager, "fcm_fallback_notification_channel") != null) {
                return "fcm_fallback_notification_channel";
            }
            Class<?> cls = Class.forName("android.app.NotificationChannel");
            notificationManager.getClass().getMethod("createNotificationChannel", cls).invoke(notificationManager, cls.getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance("fcm_fallback_notification_channel", this.mContext.getString(R.string.fcm_fallback_notification_channel_label), 3));
            return "fcm_fallback_notification_channel";
        } catch (InstantiationException e) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
            return null;
        } catch (InvocationTargetException e2) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e3);
            return null;
        } catch (IllegalAccessException e4) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e4);
            return null;
        } catch (ClassNotFoundException e5) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e5);
            return null;
        } catch (SecurityException e6) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e6);
            return null;
        } catch (IllegalArgumentException e7) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e7);
            return null;
        } catch (LinkageError e8) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e8);
            return null;
        }
    }

    private final PendingIntent zzt(Bundle bundle) {
        Intent intent;
        String zze = zze(bundle, "gcm.n.click_action");
        if (!TextUtils.isEmpty(zze)) {
            Intent intent2 = new Intent(zze);
            intent2.setPackage(this.mContext.getPackageName());
            intent2.setFlags(268435456);
            intent = intent2;
        } else {
            Uri zzae = zzae(bundle);
            if (zzae != null) {
                Intent intent3 = new Intent("android.intent.action.VIEW");
                intent3.setPackage(this.mContext.getPackageName());
                intent3.setData(zzae);
                intent = intent3;
            } else {
                Intent launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(this.mContext.getPackageName());
                if (launchIntentForPackage == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
                intent = launchIntentForPackage;
            }
        }
        if (intent == null) {
            return null;
        }
        intent.addFlags(67108864);
        Bundle bundle2 = new Bundle(bundle);
        FirebaseMessagingService.zzq(bundle2);
        intent.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.mContext, this.zzmmh.incrementAndGet(), intent, 1073741824);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzs(android.os.Bundle r30) {
        /*
        // Method dump skipped, instructions count: 782
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zza.zzs(android.os.Bundle):boolean");
    }
}
