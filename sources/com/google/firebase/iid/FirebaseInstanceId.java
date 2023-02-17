package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
public class FirebaseInstanceId {
    private static Map<String, FirebaseInstanceId> zzhtm = new ArrayMap();
    private static zzk zzmlj;
    private final FirebaseApp zzmlk;
    private final zzj zzmll;
    private final String zzmlm;

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzj zzj) {
        String str;
        this.zzmlk = firebaseApp;
        this.zzmll = zzj;
        String gcmSenderId = this.zzmlk.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            str = gcmSenderId;
        } else {
            String applicationId = this.zzmlk.getOptions().getApplicationId();
            if (applicationId.startsWith("1:")) {
                String[] split = applicationId.split(":");
                if (split.length < 2) {
                    str = null;
                } else {
                    String str2 = split[1];
                    str = str2.isEmpty() ? null : str2;
                }
            } else {
                str = applicationId;
            }
        }
        this.zzmlm = str;
        if (this.zzmlm == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.zza(this.zzmlk.getApplicationContext(), this);
    }

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(FirebaseApp firebaseApp) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = zzhtm.get(firebaseApp.getOptions().getApplicationId());
            if (firebaseInstanceId == null) {
                zzj zza = zzj.zza(firebaseApp.getApplicationContext(), null);
                if (zzmlj == null) {
                    zzmlj = new zzk(zzj.zzbyo());
                }
                firebaseInstanceId = new FirebaseInstanceId(firebaseApp, zza);
                zzhtm.put(firebaseApp.getOptions().getApplicationId(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    static String zza(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static void zza(Context context, zzr zzr) {
        zzr.zzasw();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        zzq.zzbys().zze(context, intent);
    }

    private final void zzac(Bundle bundle) {
        bundle.putString("gmp_app_id", this.zzmlk.getOptions().getApplicationId());
    }

    static int zzao(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to find package ").append(valueOf).toString());
            return 0;
        }
    }

    static zzk zzbyn() {
        return zzmlj;
    }

    static String zzdd(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    static int zzej(Context context) {
        return zzao(context, context.getPackageName());
    }

    static void zzek(Context context) {
        Intent intent = new Intent();
        intent.putExtra("CMD", "SYNC");
        zzq.zzbys().zze(context, intent);
    }

    static String zzm(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public String getId() {
        return zza(this.zzmll.zzasr());
    }

    public String getToken() {
        zzs zzbyl = zzbyl();
        if (zzbyl == null || zzbyl.zzqk(zzj.zzhts)) {
            FirebaseInstanceIdService.zzem(this.zzmlk.getApplicationContext());
        }
        if (zzbyl != null) {
            return zzbyl.zzkoo;
        }
        return null;
    }

    public String getToken(String str, String str2) {
        Bundle bundle = new Bundle();
        zzac(bundle);
        return this.zzmll.getToken(str, str2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final zzs zzbyl() {
        return zzj.zzbyo().zzo("", this.zzmlm, "*");
    }

    /* access modifiers changed from: package-private */
    public final String zzbym() {
        return getToken(this.zzmlm, "*");
    }

    /* access modifiers changed from: package-private */
    public final void zzqb(String str) {
        zzs zzbyl = zzbyl();
        if (zzbyl == null || zzbyl.zzqk(zzj.zzhts)) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        String str2 = zzbyl.zzkoo;
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str);
        String concat = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        zzac(bundle);
        this.zzmll.zzb(str2, concat, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zzqc(String str) {
        zzs zzbyl = zzbyl();
        if (zzbyl == null || zzbyl.zzqk(zzj.zzhts)) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        zzj zzj = this.zzmll;
        String str2 = zzbyl.zzkoo;
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str);
        zzj.zza(str2, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle);
    }
}
