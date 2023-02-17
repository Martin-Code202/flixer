package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;
import java.util.concurrent.atomic.AtomicReference;
/* access modifiers changed from: package-private */
public final class zzazg extends zzazt {
    private final Handler mHandler;
    private final AtomicReference<zzaze> zzfbp;

    public zzazg(zzaze zzaze) {
        this.zzfbp = new AtomicReference<>(zzaze);
        this.mHandler = new Handler(zzaze.getLooper());
    }

    private static void zza(zzaze zzaze, long j, int i) {
        zzn zzn;
        synchronized (zzaze.zzfbh) {
            zzn = (zzn) zzaze.zzfbh.remove(Long.valueOf(j));
        }
        if (zzn != null) {
            zzn.setResult(new Status(i));
        }
    }

    private static boolean zza(zzaze zzaze, int i) {
        synchronized (zzaze.zzfbl) {
            if (zzaze.zzfbj == null) {
                return false;
            }
            zzaze.zzfbj.setResult(new Status(i));
            zzaze.zzfbj = null;
            return true;
        }
    }

    public final boolean isDisposed() {
        return this.zzfbp.get() == null;
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void onApplicationDisconnected(int i) {
        zzaze zzaze = this.zzfbp.get();
        if (zzaze != null) {
            zzaze.zzfbe = null;
            zzaze.zzfbf = null;
            zza(zzaze, i);
            if (zzaze.zzeij != null) {
                this.mHandler.post(new zzazh(this, zzaze, i));
            }
        }
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
        zzaze zzaze = this.zzfbp.get();
        if (zzaze != null) {
            zzaze.zzfat = applicationMetadata;
            zzaze.zzfbe = applicationMetadata.getApplicationId();
            zzaze.zzfbf = str2;
            zzaze.zzfax = str;
            synchronized (zzaze.zzfbk) {
                if (zzaze.zzfbi != null) {
                    zzaze.zzfbi.setResult(new zzazf(new Status(0), applicationMetadata, str, str2, z));
                    zzaze.zzfbi = null;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void zza(String str, double d, boolean z) {
        zzaze.zzejm.zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void zza(String str, long j, int i) {
        zzaze zzaze = this.zzfbp.get();
        if (zzaze != null) {
            zza(zzaze, j, i);
        }
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void zza(String str, byte[] bArr) {
        if (this.zzfbp.get() != null) {
            zzaze.zzejm.zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
        }
    }

    public final zzaze zzaen() {
        zzaze andSet = this.zzfbp.getAndSet(null);
        if (andSet == null) {
            return null;
        }
        andSet.zzaeg();
        return andSet;
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void zzb(zzays zzays) {
        zzaze zzaze = this.zzfbp.get();
        if (zzaze != null) {
            zzaze.zzejm.zzb("onApplicationStatusChanged", new Object[0]);
            this.mHandler.post(new zzazj(this, zzaze, zzays));
        }
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void zzb(zzazm zzazm) {
        zzaze zzaze = this.zzfbp.get();
        if (zzaze != null) {
            zzaze.zzejm.zzb("onDeviceStatusChanged", new Object[0]);
            this.mHandler.post(new zzazi(this, zzaze, zzazm));
        }
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void zzb(String str, long j) {
        zzaze zzaze = this.zzfbp.get();
        if (zzaze != null) {
            zza(zzaze, j, 0);
        }
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void zzbe(int i) {
        zzaze zzaze = this.zzfbp.get();
        if (zzaze != null) {
            synchronized (zzaze.zzfbk) {
                if (zzaze.zzfbi != null) {
                    zzaze.zzfbi.setResult(new zzazf(new Status(i)));
                    zzaze.zzfbi = null;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void zzbj(int i) {
        zzaze zzaen = zzaen();
        if (zzaen != null) {
            zzaze.zzejm.zzb("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
            if (i != 0) {
                zzaen.zzcc(2);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void zzbk(int i) {
        zzaze zzaze = this.zzfbp.get();
        if (zzaze != null) {
            zza(zzaze, i);
        }
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void zzbl(int i) {
        zzaze zzaze = this.zzfbp.get();
        if (zzaze != null) {
            zza(zzaze, i);
        }
    }

    @Override // com.google.android.gms.internal.zzazs
    public final void zzs(String str, String str2) {
        zzaze zzaze = this.zzfbp.get();
        if (zzaze != null) {
            zzaze.zzejm.zzb("Receive (type=text, ns=%s) %s", str, str2);
            this.mHandler.post(new zzazk(this, zzaze, str, str2));
        }
    }
}
