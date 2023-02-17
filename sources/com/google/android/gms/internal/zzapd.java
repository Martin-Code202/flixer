package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzl;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
public final class zzapd {
    private static final char[] zzdul = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static zzalw zza(zzaon zzaon, String str) {
        zzbp.zzu(zzaon);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new HashMap();
        try {
            String valueOf = String.valueOf(str);
            Map<String, String> zza = zzl.zza(new URI(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")), "UTF-8");
            zzalw zzalw = new zzalw();
            zzalw.zzdb(zza.get("utm_content"));
            zzalw.zzcz(zza.get("utm_medium"));
            zzalw.setName(zza.get("utm_campaign"));
            zzalw.zzcy(zza.get("utm_source"));
            zzalw.zzda(zza.get("utm_term"));
            zzalw.zzdc(zza.get("utm_id"));
            zzalw.zzdd(zza.get("anid"));
            zzalw.zzde(zza.get("gclid"));
            zzalw.zzdf(zza.get("dclid"));
            zzalw.zzdg(zza.get("aclid"));
            return zzalw;
        } catch (URISyntaxException e) {
            zzaon.zzd("No valid campaign data found", e);
            return null;
        }
    }

    public static String zza(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(language.toLowerCase());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append("-").append(locale.getCountry().toLowerCase());
        }
        return sb.toString();
    }

    public static boolean zza(double d, String str) {
        if (d <= 0.0d || d >= 100.0d) {
            return false;
        }
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                int i2 = ((i << 6) & 268435455) + charAt + (charAt << 14);
                int i3 = i2 & 266338304;
                i = i3 != 0 ? (i3 >> 21) ^ i2 : i2;
            }
        }
        return ((double) (i % SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS)) >= 100.0d * d;
    }

    public static boolean zza(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 2);
            if (receiverInfo == null || !receiverInfo.enabled) {
                return false;
            }
            return !z || receiverInfo.exported;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void zzb(Map<String, String> map, String str, String str2) {
        if (str2 != null && !map.containsKey(str)) {
            map.put(str, str2);
        }
    }

    public static long zzea(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static MessageDigest zzec(String str) {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static boolean zzed(String str) {
        return TextUtils.isEmpty(str) || !str.startsWith("http:");
    }

    public static boolean zzv(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 4);
            return serviceInfo != null && serviceInfo.enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
