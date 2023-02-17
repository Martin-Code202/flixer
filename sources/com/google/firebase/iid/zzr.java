package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzt;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
/* access modifiers changed from: package-private */
public final class zzr {
    private Context zzahy;
    SharedPreferences zzhuk;

    public zzr(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    private zzr(Context context, String str) {
        this.zzahy = context;
        this.zzhuk = context.getSharedPreferences(str, 0);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        File file = new File(zzt.getNoBackupFilesDir(this.zzahy), valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    FirebaseInstanceId.zza(this.zzahy, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String valueOf3 = String.valueOf(e.getMessage());
                    Log.d("InstanceID/Store", valueOf3.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf3) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    private static String zzbk(String str, String str2) {
        return new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + String.valueOf("|S|").length()).append(str).append("|S|").append(str2).toString();
    }

    private final void zzht(String str) {
        SharedPreferences.Editor edit = this.zzhuk.edit();
        for (String str2 : this.zzhuk.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    private static String zzn(String str, String str2, String str3) {
        return new StringBuilder(String.valueOf(str3).length() + String.valueOf(str).length() + 1 + String.valueOf("|T|").length() + String.valueOf(str2).length()).append(str).append("|T|").append(str2).append("|").append(str3).toString();
    }

    public final synchronized boolean isEmpty() {
        return this.zzhuk.getAll().isEmpty();
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zzc = zzs.zzc(str4, str5, System.currentTimeMillis());
        if (zzc != null) {
            SharedPreferences.Editor edit = this.zzhuk.edit();
            edit.putString(zzn(str, str2, str3), zzc);
            edit.commit();
        }
    }

    public final synchronized void zzasw() {
        this.zzhuk.edit().clear().commit();
    }

    public final synchronized void zzf(String str, String str2, String str3) {
        String zzn = zzn(str, str2, str3);
        SharedPreferences.Editor edit = this.zzhuk.edit();
        edit.remove(zzn);
        edit.commit();
    }

    public final synchronized void zzhu(String str) {
        zzht(String.valueOf(str).concat("|T|"));
    }

    public final synchronized zzs zzo(String str, String str2, String str3) {
        return zzs.zzqj(this.zzhuk.getString(zzn(str, str2, str3), null));
    }

    /* access modifiers changed from: package-private */
    public final synchronized KeyPair zzqg(String str) {
        KeyPair zzasq;
        zzasq = zza.zzasq();
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.zzhuk.edit();
        edit.putString(zzbk(str, "|P|"), FirebaseInstanceId.zzm(zzasq.getPublic().getEncoded()));
        edit.putString(zzbk(str, "|K|"), FirebaseInstanceId.zzm(zzasq.getPrivate().getEncoded()));
        edit.putString(zzbk(str, "cre"), Long.toString(currentTimeMillis));
        edit.commit();
        return zzasq;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzqh(String str) {
        zzht(String.valueOf(str).concat("|"));
    }

    public final synchronized KeyPair zzqi(String str) {
        String string = this.zzhuk.getString(zzbk(str, "|P|"), null);
        String string2 = this.zzhuk.getString(zzbk(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(string, 8);
            byte[] decode2 = Base64.decode(string2, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid key stored ").append(valueOf).toString());
            FirebaseInstanceId.zza(this.zzahy, this);
            return null;
        }
    }
}
