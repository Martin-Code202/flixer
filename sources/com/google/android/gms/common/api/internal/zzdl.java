package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.zze;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;
/* access modifiers changed from: package-private */
public final class zzdl implements IBinder.DeathRecipient, zzdm {
    private final WeakReference<zzs<?>> zzfpu;
    private final WeakReference<zze> zzfpv;
    private final WeakReference<IBinder> zzfpw;

    private zzdl(zzs<?> zzs, zze zze, IBinder iBinder) {
        this.zzfpv = new WeakReference<>(zze);
        this.zzfpu = new WeakReference<>(zzs);
        this.zzfpw = new WeakReference<>(iBinder);
    }

    /* synthetic */ zzdl(zzs zzs, zze zze, IBinder iBinder, zzdk zzdk) {
        this(zzs, null, iBinder);
    }

    private final void zzais() {
        zzs<?> zzs = this.zzfpu.get();
        zze zze = this.zzfpv.get();
        if (!(zze == null || zzs == null)) {
            zze.remove(zzs.zzafs().intValue());
        }
        IBinder iBinder = this.zzfpw.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        zzais();
    }

    @Override // com.google.android.gms.common.api.internal.zzdm
    public final void zzc(zzs<?> zzs) {
        zzais();
    }
}
