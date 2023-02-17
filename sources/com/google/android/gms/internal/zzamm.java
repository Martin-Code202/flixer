package com.google.android.gms.internal;
/* access modifiers changed from: package-private */
public final class zzamm implements Runnable {
    private /* synthetic */ zzamj zzdnw;
    private /* synthetic */ String zzdny;
    private /* synthetic */ Runnable zzdnz;

    zzamm(zzamj zzamj, String str, Runnable runnable) {
        this.zzdnw = zzamj;
        this.zzdny = str;
        this.zzdnz = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdnw.zzdnu.zzdu(this.zzdny);
        if (this.zzdnz != null) {
            this.zzdnz.run();
        }
    }
}
