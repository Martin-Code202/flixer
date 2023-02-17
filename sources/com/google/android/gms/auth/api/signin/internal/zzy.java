package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzbp;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
public final class zzy {
    private static final Lock zzedk = new ReentrantLock();
    private static zzy zzedl;
    private final Lock zzedm = new ReentrantLock();
    private final SharedPreferences zzedn;

    private zzy(Context context) {
        this.zzedn = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static zzy zzbl(Context context) {
        zzbp.zzu(context);
        zzedk.lock();
        try {
            if (zzedl == null) {
                zzedl = new zzy(context.getApplicationContext());
            }
            return zzedl;
        } finally {
            zzedk.unlock();
        }
    }

    private final GoogleSignInAccount zzep(String str) {
        String zzer;
        if (TextUtils.isEmpty(str) || (zzer = zzer(zzq("googleSignInAccount", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zzem(zzer);
        } catch (JSONException unused) {
            return null;
        }
    }

    private final GoogleSignInOptions zzeq(String str) {
        String zzer;
        if (TextUtils.isEmpty(str) || (zzer = zzer(zzq("googleSignInOptions", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.zzen(zzer);
        } catch (JSONException unused) {
            return null;
        }
    }

    private final String zzer(String str) {
        this.zzedm.lock();
        try {
            return this.zzedn.getString(str, null);
        } finally {
            this.zzedm.unlock();
        }
    }

    private final void zzes(String str) {
        this.zzedm.lock();
        try {
            this.zzedn.edit().remove(str).apply();
        } finally {
            this.zzedm.unlock();
        }
    }

    private final void zzp(String str, String str2) {
        this.zzedm.lock();
        try {
            this.zzedn.edit().putString(str, str2).apply();
        } finally {
            this.zzedm.unlock();
        }
    }

    private static String zzq(String str, String str2) {
        return new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + String.valueOf(":").length()).append(str).append(":").append(str2).toString();
    }

    public final void zza(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzbp.zzu(googleSignInAccount);
        zzbp.zzu(googleSignInOptions);
        zzp("defaultGoogleSignInAccount", googleSignInAccount.zzaae());
        zzbp.zzu(googleSignInAccount);
        zzbp.zzu(googleSignInOptions);
        String zzaae = googleSignInAccount.zzaae();
        zzp(zzq("googleSignInAccount", zzaae), googleSignInAccount.zzaaf());
        zzp(zzq("googleSignInOptions", zzaae), googleSignInOptions.zzaai());
    }

    public final GoogleSignInAccount zzaas() {
        return zzep(zzer("defaultGoogleSignInAccount"));
    }

    public final GoogleSignInOptions zzaat() {
        return zzeq(zzer("defaultGoogleSignInAccount"));
    }

    public final void zzaau() {
        String zzer = zzer("defaultGoogleSignInAccount");
        zzes("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(zzer)) {
            zzes(zzq("googleSignInAccount", zzer));
            zzes(zzq("googleSignInOptions", zzer));
        }
    }
}
