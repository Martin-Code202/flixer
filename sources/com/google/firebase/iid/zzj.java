package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Map;
public final class zzj {
    private static Map<String, zzj> zzhtm = new ArrayMap();
    static String zzhts;
    private static zzr zzmlt;
    private static zzl zzmlu;
    private Context mContext;
    private KeyPair zzhtp;
    private String zzhtq = "";

    private zzj(Context context, String str, Bundle bundle) {
        this.mContext = context.getApplicationContext();
        this.zzhtq = str;
    }

    public static synchronized zzj zza(Context context, Bundle bundle) {
        zzj zzj;
        synchronized (zzj.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            if (string == null) {
                string = "";
            }
            Context applicationContext = context.getApplicationContext();
            if (zzmlt == null) {
                zzmlt = new zzr(applicationContext);
                zzmlu = new zzl(applicationContext);
            }
            zzhts = Integer.toString(FirebaseInstanceId.zzej(applicationContext));
            zzj = zzhtm.get(string);
            if (zzj == null) {
                zzj = new zzj(applicationContext, string, bundle);
                zzhtm.put(string, zzj);
            }
        }
        return zzj;
    }

    public static zzr zzbyo() {
        return zzmlt;
    }

    public static zzl zzbyp() {
        return zzmlu;
    }

    public final String getToken(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        boolean z = true;
        if (bundle.getString("ttl") != null || "jwt".equals(bundle.getString("type"))) {
            z = false;
        } else {
            zzs zzo = zzmlt.zzo(this.zzhtq, str, str2);
            if (zzo != null && !zzo.zzqk(zzhts)) {
                return zzo.zzkoo;
            }
        }
        String zzb = zzb(str, str2, bundle);
        if (zzb != null && z) {
            zzmlt.zza(this.zzhtq, str, str2, zzb, zzhts);
        }
        return zzb;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zzmlt.zzf(this.zzhtq, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("delete", "1");
        zzb(str, str2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final KeyPair zzasr() {
        if (this.zzhtp == null) {
            this.zzhtp = zzmlt.zzqi(this.zzhtq);
        }
        if (this.zzhtp == null) {
            this.zzhtp = zzmlt.zzqg(this.zzhtq);
        }
        return this.zzhtp;
    }

    public final void zzass() {
        zzmlt.zzqh(this.zzhtq);
        this.zzhtp = null;
    }

    public final String zzb(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.zzhtq) ? str : this.zzhtq;
        bundle.putString("subtype", str3);
        bundle.putString("X-subtype", str3);
        Intent zza = zzmlu.zza(bundle, zzasr());
        if (zza == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = zza.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = zza.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = zza.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        String valueOf = String.valueOf(zza.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
}
