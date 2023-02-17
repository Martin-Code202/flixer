package com.google.android.gms.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzv;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
public final class zzcdb extends zzcbp {
    private final zzccw zzikh;
    private Boolean zziug;
    private String zziuh;

    public zzcdb(zzccw zzccw) {
        this(zzccw, null);
    }

    private zzcdb(zzccw zzccw, String str) {
        zzbp.zzu(zzccw);
        this.zzikh = zzccw;
        this.zziuh = null;
    }

    static /* synthetic */ zzccw zza(zzcdb zzcdb) {
        return zzcdb.zzikh;
    }

    private final void zzb(zzcas zzcas, boolean z) {
        zzbp.zzu(zzcas);
        zzf(zzcas.packageName, false);
        this.zzikh.zzaui().zzkb(zzcas.zzilt);
    }

    private final void zzf(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.zzikh.zzaum().zzaye().log("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zziug == null) {
                    this.zziug = Boolean.valueOf("com.google.android.gms".equals(this.zziuh) || zzv.zzf(this.zzikh.getContext(), Binder.getCallingUid()) || zzp.zzbz(this.zzikh.getContext()).zzbo(Binder.getCallingUid()));
                }
                if (this.zziug.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zzikh.zzaum().zzaye().zzj("Measurement Service called with invalid calling package. appId", zzcbw.zzjf(str));
                throw e;
            }
        }
        if (this.zziuh == null && zzo.zzb(this.zzikh.getContext(), Binder.getCallingUid(), str)) {
            this.zziuh = str;
        }
        if (!str.equals(this.zziuh)) {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final List<zzcft> zza(zzcas zzcas, boolean z) {
        zzb(zzcas, false);
        try {
            List<zzcfv> list = (List) this.zzikh.zzaul().zzd(new zzcdq(this, zzcas)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzcfv zzcfv : list) {
                if (z || !zzcfw.zzkd(zzcfv.mName)) {
                    arrayList.add(new zzcft(zzcfv));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzikh.zzaum().zzaye().zze("Failed to get user attributes. appId", zzcbw.zzjf(zzcas.packageName), e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final List<zzcav> zza(String str, String str2, zzcas zzcas) {
        zzb(zzcas, false);
        try {
            return (List) this.zzikh.zzaul().zzd(new zzcdj(this, zzcas, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zzikh.zzaum().zzaye().zzj("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final List<zzcft> zza(String str, String str2, String str3, boolean z) {
        zzf(str, true);
        try {
            List<zzcfv> list = (List) this.zzikh.zzaul().zzd(new zzcdi(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzcfv zzcfv : list) {
                if (z || !zzcfw.zzkd(zzcfv.mName)) {
                    arrayList.add(new zzcft(zzcfv));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzikh.zzaum().zzaye().zze("Failed to get user attributes. appId", zzcbw.zzjf(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final List<zzcft> zza(String str, String str2, boolean z, zzcas zzcas) {
        zzb(zzcas, false);
        try {
            List<zzcfv> list = (List) this.zzikh.zzaul().zzd(new zzcdh(this, zzcas, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzcfv zzcfv : list) {
                if (z || !zzcfw.zzkd(zzcfv.mName)) {
                    arrayList.add(new zzcft(zzcfv));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzikh.zzaum().zzaye().zze("Failed to get user attributes. appId", zzcbw.zzjf(zzcas.packageName), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zza(long j, String str, String str2, String str3) {
        this.zzikh.zzaul().zzg(new zzcds(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zza(zzcas zzcas) {
        zzb(zzcas, false);
        zzcdr zzcdr = new zzcdr(this, zzcas);
        if (this.zzikh.zzaul().zzayt()) {
            zzcdr.run();
        } else {
            this.zzikh.zzaul().zzg(zzcdr);
        }
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zza(zzcav zzcav, zzcas zzcas) {
        zzbp.zzu(zzcav);
        zzbp.zzu(zzcav.zzimg);
        zzb(zzcas, false);
        zzcav zzcav2 = new zzcav(zzcav);
        zzcav2.packageName = zzcas.packageName;
        if (zzcav.zzimg.getValue() == null) {
            this.zzikh.zzaul().zzg(new zzcdd(this, zzcav2, zzcas));
        } else {
            this.zzikh.zzaul().zzg(new zzcde(this, zzcav2, zzcas));
        }
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zza(zzcbk zzcbk, zzcas zzcas) {
        zzbp.zzu(zzcbk);
        zzb(zzcas, false);
        this.zzikh.zzaul().zzg(new zzcdl(this, zzcbk, zzcas));
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zza(zzcbk zzcbk, String str, String str2) {
        zzbp.zzu(zzcbk);
        zzbp.zzgg(str);
        zzf(str, true);
        this.zzikh.zzaul().zzg(new zzcdm(this, zzcbk, str));
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zza(zzcft zzcft, zzcas zzcas) {
        zzbp.zzu(zzcft);
        zzb(zzcas, false);
        if (zzcft.getValue() == null) {
            this.zzikh.zzaul().zzg(new zzcdo(this, zzcft, zzcas));
        } else {
            this.zzikh.zzaul().zzg(new zzcdp(this, zzcft, zzcas));
        }
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final byte[] zza(zzcbk zzcbk, String str) {
        zzbp.zzgg(str);
        zzbp.zzu(zzcbk);
        zzf(str, true);
        this.zzikh.zzaum().zzayj().zzj("Log and bundle. event", this.zzikh.zzauh().zzjc(zzcbk.name));
        long nanoTime = this.zzikh.zzvx().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zzikh.zzaul().zze(new zzcdn(this, zzcbk, str)).get();
            if (bArr == null) {
                this.zzikh.zzaum().zzaye().zzj("Log and bundle returned null. appId", zzcbw.zzjf(str));
                bArr = new byte[0];
            }
            this.zzikh.zzaum().zzayj().zzd("Log and bundle processed. event, size, time_ms", this.zzikh.zzauh().zzjc(zzcbk.name), Integer.valueOf(bArr.length), Long.valueOf((this.zzikh.zzvx().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zzikh.zzaum().zzaye().zzd("Failed to log and bundle. appId, event, error", zzcbw.zzjf(str), this.zzikh.zzauh().zzjc(zzcbk.name), e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zzb(zzcas zzcas) {
        zzb(zzcas, false);
        this.zzikh.zzaul().zzg(new zzcdc(this, zzcas));
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final void zzb(zzcav zzcav) {
        zzbp.zzu(zzcav);
        zzbp.zzu(zzcav.zzimg);
        zzf(zzcav.packageName, true);
        zzcav zzcav2 = new zzcav(zzcav);
        if (zzcav.zzimg.getValue() == null) {
            this.zzikh.zzaul().zzg(new zzcdf(this, zzcav2));
        } else {
            this.zzikh.zzaul().zzg(new zzcdg(this, zzcav2));
        }
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final String zzc(zzcas zzcas) {
        zzb(zzcas, false);
        return this.zzikh.zzjs(zzcas.packageName);
    }

    @Override // com.google.android.gms.internal.zzcbo
    public final List<zzcav> zzj(String str, String str2, String str3) {
        zzf(str, true);
        try {
            return (List) this.zzikh.zzaul().zzd(new zzcdk(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zzikh.zzaum().zzaye().zzj("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }
}
