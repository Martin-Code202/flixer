package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.zzd;
public final class zzcfl extends zzcdu {
    private Handler mHandler;
    private long zziws = zzvx().elapsedRealtime();
    private final zzcbc zziwt = new zzcfm(this, this.zzikh);
    private final zzcbc zziwu = new zzcfn(this, this.zzikh);

    zzcfl(zzccw zzccw) {
        super(zzccw);
    }

    private final void zzazu() {
        synchronized (this) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzazv() {
        zzuj();
        zzbs(false);
        zzaty().zzaj(zzvx().elapsedRealtime());
    }

    /* access modifiers changed from: private */
    public final void zzbd(long j) {
        zzuj();
        zzazu();
        this.zziwt.cancel();
        this.zziwu.cancel();
        zzaum().zzayk().zzj("Activity resumed, time", Long.valueOf(j));
        this.zziws = j;
        if (zzvx().currentTimeMillis() - zzaun().zzirc.get() > zzaun().zzire.get()) {
            zzaun().zzird.set(true);
            zzaun().zzirf.set(0);
        }
        if (zzaun().zzird.get()) {
            this.zziwt.zzs(Math.max(0L, zzaun().zzirb.get() - zzaun().zzirf.get()));
        } else {
            this.zziwu.zzs(Math.max(0L, 3600000 - zzaun().zzirf.get()));
        }
    }

    /* access modifiers changed from: private */
    public final void zzbe(long j) {
        zzuj();
        zzazu();
        this.zziwt.cancel();
        this.zziwu.cancel();
        zzaum().zzayk().zzj("Activity paused, time", Long.valueOf(j));
        if (this.zziws != 0) {
            zzaun().zzirf.set(zzaun().zzirf.get() + (j - this.zziws));
        }
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
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

    public final boolean zzbs(boolean z) {
        zzuj();
        zzwk();
        long elapsedRealtime = zzvx().elapsedRealtime();
        zzaun().zzire.set(zzvx().currentTimeMillis());
        long j = elapsedRealtime - this.zziws;
        if (z || j >= 1000) {
            zzaun().zzirf.set(j);
            zzaum().zzayk().zzj("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzcek.zza(zzaue().zzazo(), bundle);
            zzaua().zzc("auto", "_e", bundle);
            this.zziws = elapsedRealtime;
            this.zziwu.cancel();
            this.zziwu.zzs(Math.max(0L, 3600000 - zzaun().zzirf.get()));
            return true;
        }
        zzaum().zzayk().zzj("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzuj() {
        super.zzuj();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzcdu
    public final void zzuk() {
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzd zzvx() {
        return super.zzvx();
    }
}
