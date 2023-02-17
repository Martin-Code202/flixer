package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzaz;
import com.google.android.gms.common.internal.zzba;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamite.DynamiteModule;
/* access modifiers changed from: package-private */
public final class zzf {
    private static zzaz zzffk;
    private static final Object zzffl = new Object();
    private static Context zzffm;

    static boolean zza(String str, zzg zzg) {
        return zza(str, zzg, false);
    }

    private static boolean zza(String str, zzg zzg, boolean z) {
        if (!zzaey()) {
            return false;
        }
        zzbp.zzu(zzffm);
        try {
            return zzffk.zza(new zzm(str, zzg, z), zzn.zzw(zzffm.getPackageManager()));
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    private static boolean zzaey() {
        if (zzffk != null) {
            return true;
        }
        zzbp.zzu(zzffm);
        synchronized (zzffl) {
            if (zzffk == null) {
                try {
                    zzffk = zzba.zzal(DynamiteModule.zza(zzffm, DynamiteModule.zzgpq, "com.google.android.gms.googlecertificates").zzgv("com.google.android.gms.common.GoogleCertificatesImpl"));
                } catch (DynamiteModule.zzc e) {
                    Log.e("GoogleCertificates", "Failed to load com.google.android.gms.googlecertificates", e);
                    return false;
                }
            }
        }
        return true;
    }

    static boolean zzb(String str, zzg zzg) {
        return zza(str, zzg, true);
    }

    static synchronized void zzbx(Context context) {
        synchronized (zzf.class) {
            if (zzffm != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzffm = context.getApplicationContext();
            }
        }
    }
}
