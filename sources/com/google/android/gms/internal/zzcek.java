package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
public final class zzcek extends zzcdu {
    protected zzcen zzivi;
    private volatile AppMeasurement.zzb zzivj;
    private AppMeasurement.zzb zzivk;
    private long zzivl;
    private final Map<Activity, zzcen> zzivm = new ArrayMap();
    private final CopyOnWriteArrayList<AppMeasurement.zza> zzivn = new CopyOnWriteArrayList<>();
    private boolean zzivo;
    private AppMeasurement.zzb zzivp;
    private String zzivq;

    public zzcek(zzccw zzccw) {
        super(zzccw);
    }

    private final void zza(Activity activity, zzcen zzcen, boolean z) {
        AppMeasurement.zzb zzb = null;
        if (this.zzivj != null) {
            zzb = this.zzivj;
        } else if (this.zzivk != null && Math.abs(zzvx().elapsedRealtime() - this.zzivl) < 1000) {
            zzb = this.zzivk;
        }
        AppMeasurement.zzb zzb2 = null;
        if (zzb != null) {
            zzb2 = new AppMeasurement.zzb(zzb);
        }
        boolean z2 = true;
        this.zzivo = true;
        try {
            Iterator<AppMeasurement.zza> it = this.zzivn.iterator();
            while (it.hasNext()) {
                try {
                    z2 = it.next().zza(zzb2, zzcen) & z2;
                } catch (Exception e) {
                    zzaum().zzaye().zzj("onScreenChangeCallback threw exception", e);
                }
            }
        } catch (Exception e2) {
            zzaum().zzaye().zzj("onScreenChangeCallback loop threw exception", e2);
        } finally {
            this.zzivo = false;
        }
        AppMeasurement.zzb zzb3 = this.zzivj == null ? this.zzivk : this.zzivj;
        if (z2) {
            if (zzcen.zzikn == null) {
                zzcen.zzikn = zzjt(activity.getClass().getCanonicalName());
            }
            zzcen zzcen2 = new zzcen(zzcen);
            this.zzivk = this.zzivj;
            this.zzivl = zzvx().elapsedRealtime();
            this.zzivj = zzcen2;
            zzaul().zzg(new zzcel(this, z, zzb3, zzcen2));
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzcen zzcen) {
        zzaty().zzaj(zzvx().elapsedRealtime());
        if (zzauk().zzbs(zzcen.zzivw)) {
            zzcen.zzivw = false;
        }
    }

    public static void zza(AppMeasurement.zzb zzb, Bundle bundle) {
        if (bundle != null && zzb != null && !bundle.containsKey("_sc")) {
            if (zzb.zzikm != null) {
                bundle.putString("_sn", zzb.zzikm);
            }
            bundle.putString("_sc", zzb.zzikn);
            bundle.putLong("_si", zzb.zziko);
        }
    }

    private static String zzjt(String str) {
        String[] split = str.split("\\.");
        if (split.length == 0) {
            return str.substring(0, 36);
        }
        String str2 = split[split.length - 1];
        return str2.length() > 36 ? str2.substring(0, 36) : str2;
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zzivm.remove(activity);
    }

    public final void onActivityPaused(Activity activity) {
        zzcen zzq = zzq(activity);
        this.zzivk = this.zzivj;
        this.zzivl = zzvx().elapsedRealtime();
        this.zzivj = null;
        zzaul().zzg(new zzcem(this, zzq));
    }

    public final void onActivityResumed(Activity activity) {
        zza(activity, zzq(activity), false);
        zzcan zzaty = zzaty();
        zzaty.zzaul().zzg(new zzcaq(zzaty, zzaty.zzvx().elapsedRealtime()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzcen zzcen;
        if (bundle != null && (zzcen = this.zzivm.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzcen.zziko);
            bundle2.putString("name", zzcen.zzikm);
            bundle2.putString("referrer_name", zzcen.zzikn);
            bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
        }
    }

    public final void registerOnScreenChangeCallback(AppMeasurement.zza zza) {
        zzatw();
        if (zza == null) {
            zzaum().zzayg().log("Attempting to register null OnScreenChangeCallback");
            return;
        }
        this.zzivn.remove(zza);
        this.zzivn.add(zza);
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (activity == null) {
            zzaum().zzayg().log("setCurrentScreen must be called with a non-null activity");
            return;
        }
        zzaul();
        if (!zzccr.zzaq()) {
            zzaum().zzayg().log("setCurrentScreen must be called from the main thread");
        } else if (this.zzivo) {
            zzaum().zzayg().log("Cannot call setCurrentScreen from onScreenChangeCallback");
        } else if (this.zzivj == null) {
            zzaum().zzayg().log("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzivm.get(activity) == null) {
            zzaum().zzayg().log("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zzjt(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzivj.zzikn.equals(str2);
            boolean zzas = zzcfw.zzas(this.zzivj.zzikm, str);
            if (equals && zzas) {
                zzaum().zzayh().log("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > zzcax.zzavr())) {
                zzaum().zzayg().zzj("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= zzcax.zzavr())) {
                zzaum().zzayk().zze("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzcen zzcen = new zzcen(str, str2, zzaui().zzazy());
                this.zzivm.put(activity, zzcen);
                zza(activity, zzcen, true);
            } else {
                zzaum().zzayg().zzj("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final void unregisterOnScreenChangeCallback(AppMeasurement.zza zza) {
        zzatw();
        this.zzivn.remove(zza);
    }

    public final void zza(String str, AppMeasurement.zzb zzb) {
        zzuj();
        synchronized (this) {
            if (this.zzivq == null || this.zzivq.equals(str) || zzb != null) {
                this.zzivq = str;
                this.zzivp = zzb;
            }
        }
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

    public final zzcen zzazo() {
        zzwk();
        zzuj();
        return this.zzivi;
    }

    public final AppMeasurement.zzb zzazp() {
        zzatw();
        AppMeasurement.zzb zzb = this.zzivj;
        if (zzb == null) {
            return null;
        }
        return new AppMeasurement.zzb(zzb);
    }

    /* access modifiers changed from: package-private */
    public final zzcen zzq(Activity activity) {
        zzbp.zzu(activity);
        zzcen zzcen = this.zzivm.get(activity);
        if (zzcen != null) {
            return zzcen;
        }
        zzcen zzcen2 = new zzcen(null, zzjt(activity.getClass().getCanonicalName()), zzaui().zzazy());
        this.zzivm.put(activity, zzcen2);
        return zzcen2;
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
