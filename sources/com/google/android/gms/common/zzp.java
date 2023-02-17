package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzbed;
public class zzp {
    private static zzp zzfgb;
    private final Context mContext;

    private zzp(Context context) {
        this.mContext = context.getApplicationContext();
    }

    static zzg zza(PackageInfo packageInfo, zzg... zzgArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzh zzh = new zzh(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzgArr.length; i++) {
            if (zzgArr[i].equals(zzh)) {
                return zzgArr[i];
            }
        }
        return null;
    }

    private static boolean zza(PackageInfo packageInfo, boolean z) {
        if (packageInfo == null || packageInfo.signatures == null) {
            return false;
        }
        return (z ? zza(packageInfo, zzj.zzffr) : zza(packageInfo, new zzg[]{zzj.zzffr[0]})) != null;
    }

    private static boolean zzb(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        zzh zzh = new zzh(packageInfo.signatures[0].toByteArray());
        String str = packageInfo.packageName;
        boolean zzb = z ? zzf.zzb(str, zzh) : zzf.zza(str, zzh);
        if (!zzb) {
            Log.d("GoogleSignatureVerifier", new StringBuilder(27).append("Cert not in list. atk=").append(z).toString());
        }
        return zzb;
    }

    public static zzp zzbz(Context context) {
        zzbp.zzu(context);
        synchronized (zzp.class) {
            if (zzfgb == null) {
                zzf.zzbx(context);
                zzfgb = new zzp(context);
            }
        }
        return zzfgb;
    }

    private final boolean zzfs(String str) {
        try {
            PackageInfo packageInfo = zzbed.zzcr(this.mContext).getPackageInfo(str, 64);
            if (packageInfo == null) {
                return false;
            }
            if (zzo.zzby(this.mContext)) {
                return zzb(packageInfo, true);
            }
            boolean zzb = zzb(packageInfo, false);
            if (!zzb && zzb(packageInfo, true)) {
                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            }
            return zzb;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Deprecated
    public final boolean zza(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (!zza(packageInfo, true)) {
            return false;
        }
        if (zzo.zzby(this.mContext)) {
            return true;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return false;
    }

    public final boolean zzbo(int i) {
        String[] packagesForUid = zzbed.zzcr(this.mContext).getPackagesForUid(i);
        if (packagesForUid == null || packagesForUid.length == 0) {
            return false;
        }
        for (String str : packagesForUid) {
            if (zzfs(str)) {
                return true;
            }
        }
        return false;
    }
}
