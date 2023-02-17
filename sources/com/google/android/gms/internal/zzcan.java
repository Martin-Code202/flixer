package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Map;
public final class zzcan extends zzcdt {
    private final Map<String, Long> zzikt = new ArrayMap();
    private final Map<String, Integer> zziku = new ArrayMap();
    private long zzikv;

    public zzcan(zzccw zzccw) {
        super(zzccw);
    }

    private final void zza(long j, AppMeasurement.zzb zzb) {
        if (zzb == null) {
            zzaum().zzayk().log("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            zzaum().zzayk().zzj("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzcek.zza(zzb, bundle);
            zzaua().zzc("am", "_xa", bundle);
        }
    }

    private final void zza(String str, long j, AppMeasurement.zzb zzb) {
        if (zzb == null) {
            zzaum().zzayk().log("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            zzaum().zzayk().zzj("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzcek.zza(zzb, bundle);
            zzaua().zzc("am", "_xu", bundle);
        }
    }

    /* access modifiers changed from: public */
    private final void zzak(long j) {
        for (String str : this.zzikt.keySet()) {
            this.zzikt.put(str, Long.valueOf(j));
        }
        if (!this.zzikt.isEmpty()) {
            this.zzikv = j;
        }
    }

    /* access modifiers changed from: public */
    private final void zzd(String str, long j) {
        zzatw();
        zzuj();
        zzbp.zzgg(str);
        if (this.zziku.isEmpty()) {
            this.zzikv = j;
        }
        Integer num = this.zziku.get(str);
        if (num != null) {
            this.zziku.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.zziku.size() >= 100) {
            zzaum().zzayg().log("Too many ads visible");
        } else {
            this.zziku.put(str, 1);
            this.zzikt.put(str, Long.valueOf(j));
        }
    }

    /* access modifiers changed from: public */
    private final void zze(String str, long j) {
        zzatw();
        zzuj();
        zzbp.zzgg(str);
        Integer num = this.zziku.get(str);
        if (num != null) {
            zzcen zzazo = zzaue().zzazo();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.zziku.remove(str);
                Long l = this.zzikt.get(str);
                if (l == null) {
                    zzaum().zzaye().log("First ad unit exposure time was never set");
                } else {
                    long longValue = j - l.longValue();
                    this.zzikt.remove(str);
                    zza(str, longValue, zzazo);
                }
                if (!this.zziku.isEmpty()) {
                    return;
                }
                if (this.zzikv == 0) {
                    zzaum().zzaye().log("First ad exposure time was never set");
                    return;
                }
                zza(j - this.zzikv, zzazo);
                this.zzikv = 0;
                return;
            }
            this.zziku.put(str, Integer.valueOf(intValue));
            return;
        }
        zzaum().zzaye().zzj("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    public final void beginAdUnitExposure(String str) {
        if (str == null || str.length() == 0) {
            zzaum().zzaye().log("Ad unit id must be a non-empty string");
            return;
        }
        zzaul().zzg(new zzcao(this, str, zzvx().elapsedRealtime()));
    }

    public final void endAdUnitExposure(String str) {
        if (str == null || str.length() == 0) {
            zzaum().zzaye().log("Ad unit id must be a non-empty string");
            return;
        }
        zzaul().zzg(new zzcap(this, str, zzvx().elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final void zzaj(long j) {
        zzcen zzazo = zzaue().zzazo();
        for (String str : this.zzikt.keySet()) {
            zza(str, j - this.zzikt.get(str).longValue(), zzazo);
        }
        if (!this.zzikt.isEmpty()) {
            zza(j - this.zzikv, zzazo);
        }
        zzak(j);
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatv() {
        super.zzatv();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatw() {
        super.zzatw();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatx() {
        super.zzatx();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcan zzaty() {
        return super.zzaty();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcau zzatz() {
        return super.zzatz();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcdw zzaua() {
        return super.zzaua();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbr zzaub() {
        return super.zzaub();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbe zzauc() {
        return super.zzauc();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzceo zzaud() {
        return super.zzaud();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcek zzaue() {
        return super.zzaue();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbs zzauf() {
        return super.zzauf();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcay zzaug() {
        return super.zzaug();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbu zzauh() {
        return super.zzauh();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcfw zzaui() {
        return super.zzaui();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzccq zzauj() {
        return super.zzauj();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcfl zzauk() {
        return super.zzauk();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzccr zzaul() {
        return super.zzaul();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbw zzaum() {
        return super.zzaum();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcch zzaun() {
        return super.zzaun();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcax zzauo() {
        return super.zzauo();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzuj() {
        super.zzuj();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzd zzvx() {
        return super.zzvx();
    }
}
