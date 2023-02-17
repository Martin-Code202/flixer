package com.google.android.gms.tasks;
final class zzf implements Runnable {
    private /* synthetic */ Task zzkfw;
    private /* synthetic */ zze zzkga;

    zzf(zze zze, Task task) {
        this.zzkga = zze;
        this.zzkfw = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (zze.zza(this.zzkga)) {
            if (zze.zzb(this.zzkga) != null) {
                zze.zzb(this.zzkga).onComplete(this.zzkfw);
            }
        }
    }
}
