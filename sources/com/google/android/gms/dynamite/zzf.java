package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
final class zzf implements DynamiteModule.zzd {
    zzf() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.zzd
    public final zzj zza(Context context, String str, zzi zzi) {
        zzj zzj = new zzj();
        zzj.zzgpx = zzi.zzad(context, str);
        zzj.zzgpy = zzi.zzb(context, str, true);
        if (zzj.zzgpx == 0 && zzj.zzgpy == 0) {
            zzj.zzgpz = 0;
        } else if (zzj.zzgpy >= zzj.zzgpx) {
            zzj.zzgpz = 1;
        } else {
            zzj.zzgpz = -1;
        }
        return zzj;
    }
}
