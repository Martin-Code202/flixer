package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zze;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
public final class zzdj {
    public static final Status zzfpp = new Status(8, "The connection to Google Play services was lost");
    private static final zzs<?>[] zzfpq = new zzs[0];
    private final Map<Api.zzc<?>, Api.zze> zzfmm;
    final Set<zzs<?>> zzfpr = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zzdm zzfps = new zzdk(this);

    public zzdj(Map<Api.zzc<?>, Api.zze> map) {
        this.zzfmm = map;
    }

    public final void release() {
        zzs[] zzsArr = (zzs[]) this.zzfpr.toArray(zzfpq);
        for (zzs zzs : zzsArr) {
            zzs.zza((zzdm) null);
            if (zzs.zzafs() != null) {
                zzs.setResultCallback(null);
                IBinder zzafg = this.zzfmm.get(((zzm) zzs).zzafe()).zzafg();
                if (zzs.isReady()) {
                    zzs.zza(new zzdl(zzs, null, zzafg, null));
                } else if (zzafg == null || !zzafg.isBinderAlive()) {
                    zzs.zza((zzdm) null);
                    zzs.cancel();
                    zze zze = null;
                    zze.remove(zzs.zzafs().intValue());
                } else {
                    zzdl zzdl = new zzdl(zzs, null, zzafg, null);
                    zzs.zza(zzdl);
                    try {
                        zzafg.linkToDeath(zzdl, 0);
                    } catch (RemoteException unused) {
                        zzs.cancel();
                        zze zze2 = null;
                        zze2.remove(zzs.zzafs().intValue());
                    }
                }
                this.zzfpr.remove(zzs);
            } else if (zzs.zzagf()) {
                this.zzfpr.remove(zzs);
            }
        }
    }

    public final void zzair() {
        for (zzs zzs : (zzs[]) this.zzfpr.toArray(zzfpq)) {
            zzs.zzu(zzfpp);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzs<? extends Result> zzs) {
        this.zzfpr.add(zzs);
        zzs.zza(this.zzfps);
    }
}
