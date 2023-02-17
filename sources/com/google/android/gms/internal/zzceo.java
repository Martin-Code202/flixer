package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.zze;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
public final class zzceo extends zzcdu {
    private final zzcfb zzivx;
    private zzcbo zzivy;
    private Boolean zzivz;
    private final zzcbc zziwa;
    private final zzcfq zziwb;
    private final List<Runnable> zziwc = new ArrayList();
    private final zzcbc zziwd;

    protected zzceo(zzccw zzccw) {
        super(zzccw);
        this.zziwb = new zzcfq(zzccw.zzvx());
        this.zzivx = new zzcfb(this);
        this.zziwa = new zzcep(this, zzccw);
        this.zziwd = new zzcet(this, zzccw);
    }

    /* access modifiers changed from: private */
    public final void onServiceDisconnected(ComponentName componentName) {
        zzuj();
        if (this.zzivy != null) {
            this.zzivy = null;
            zzaum().zzayk().zzj("Disconnected from device MeasurementService", componentName);
            zzuj();
            zzxh();
        }
    }

    /* access modifiers changed from: private */
    public final void zzazs() {
        zzuj();
        zzaum().zzayk().zzj("Processing queued up service tasks", Integer.valueOf(this.zziwc.size()));
        for (Runnable runnable : this.zziwc) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzaum().zzaye().zzj("Task exception while flushing queue", th);
            }
        }
        this.zziwc.clear();
        this.zziwd.cancel();
    }

    private final zzcas zzbr(boolean z) {
        zzcax.zzawl();
        return zzaub().zzjb(z ? zzaum().zzayl() : null);
    }

    private final void zzj(Runnable runnable) {
        zzuj();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zziwc.size()) >= zzcax.zzawq()) {
            zzaum().zzaye().log("Discarding data. Max runnable queue size reached");
        } else {
            this.zziwc.add(runnable);
            this.zziwd.zzs(60000);
            zzxh();
        }
    }

    /* access modifiers changed from: private */
    public final void zzww() {
        zzuj();
        this.zziwb.start();
        this.zziwa.zzs(zzcax.zzawi());
    }

    /* access modifiers changed from: private */
    public final void zzwx() {
        zzuj();
        if (isConnected()) {
            zzaum().zzayk().log("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    public final void disconnect() {
        zzuj();
        zzwk();
        try {
            zza.zzakz();
            getContext().unbindService(this.zzivx);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzivy = null;
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final boolean isConnected() {
        zzuj();
        zzwk();
        return this.zzivy != null;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzcbo zzcbo) {
        zzuj();
        zzbp.zzu(zzcbo);
        this.zzivy = zzcbo;
        zzww();
        zzazs();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzcbo zzcbo, zzbck zzbck, zzcas zzcas) {
        zzuj();
        zzatw();
        zzwk();
        zzcax.zzawl();
        ArrayList arrayList = new ArrayList();
        int i = 100;
        zzcax.zzawu();
        for (int i2 = 0; i2 < 1001 && i == 100; i2++) {
            i = 0;
            List<zzbck> zzdw = zzauf().zzdw(100);
            if (zzdw != null) {
                arrayList.addAll(zzdw);
                i = zzdw.size();
            }
            if (zzbck != null && i < 100) {
                arrayList.add(zzbck);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                zzbck zzbck2 = (zzbck) obj;
                if (zzbck2 instanceof zzcbk) {
                    try {
                        zzcbo.zza((zzcbk) zzbck2, zzcas);
                    } catch (RemoteException e) {
                        zzaum().zzaye().zzj("Failed to send event to the service", e);
                    }
                } else if (zzbck2 instanceof zzcft) {
                    try {
                        zzcbo.zza((zzcft) zzbck2, zzcas);
                    } catch (RemoteException e2) {
                        zzaum().zzaye().zzj("Failed to send attribute to the service", e2);
                    }
                } else if (zzbck2 instanceof zzcav) {
                    try {
                        zzcbo.zza((zzcav) zzbck2, zzcas);
                    } catch (RemoteException e3) {
                        zzaum().zzaye().zzj("Failed to send conditional property to the service", e3);
                    }
                } else {
                    zzaum().zzaye().log("Discarding data. Unrecognized parcel type.");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(AppMeasurement.zzb zzb) {
        zzuj();
        zzwk();
        zzj(new zzces(this, zzb));
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzuj();
        zzwk();
        zzj(new zzceq(this, atomicReference, zzbr(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzcav>> atomicReference, String str, String str2, String str3) {
        zzuj();
        zzwk();
        zzj(new zzcex(this, atomicReference, str, str2, str3, zzbr(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzcft>> atomicReference, String str, String str2, String str3, boolean z) {
        zzuj();
        zzwk();
        zzj(new zzcey(this, atomicReference, str, str2, str3, z, zzbr(false)));
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

    /* access modifiers changed from: protected */
    public final void zzazq() {
        zzuj();
        zzwk();
        zzj(new zzceu(this, zzbr(true)));
    }

    /* access modifiers changed from: protected */
    public final void zzazr() {
        zzuj();
        zzwk();
        zzj(new zzcer(this, zzbr(true)));
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzcft zzcft) {
        zzuj();
        zzwk();
        zzcax.zzawl();
        zzj(new zzcez(this, zzauf().zza(zzcft), zzcft, zzbr(true)));
    }

    /* access modifiers changed from: protected */
    public final void zzc(zzcbk zzcbk, String str) {
        zzbp.zzu(zzcbk);
        zzuj();
        zzwk();
        zzcax.zzawl();
        zzj(new zzcev(this, true, zzauf().zza(zzcbk), zzcbk, zzbr(true), str));
    }

    /* access modifiers changed from: protected */
    public final void zzf(zzcav zzcav) {
        zzbp.zzu(zzcav);
        zzuj();
        zzwk();
        zzcax.zzawl();
        zzj(new zzcew(this, true, zzauf().zzc(zzcav), new zzcav(zzcav), zzbr(true), zzcav));
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

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void zzxh() {
        boolean z;
        zzuj();
        zzwk();
        if (!isConnected()) {
            if (this.zzivz == null) {
                this.zzivz = zzaun().zzayp();
                if (this.zzivz == null) {
                    zzaum().zzayk().log("State of service unknown");
                    zzuj();
                    zzwk();
                    zzcax.zzawl();
                    zzaum().zzayk().log("Checking service availability");
                    switch (zze.zzaex().isGooglePlayServicesAvailable(getContext())) {
                        case 0:
                            zzaum().zzayk().log("Service available");
                            z = true;
                            break;
                        case 1:
                            zzaum().zzayk().log("Service missing");
                            z = false;
                            break;
                        case 2:
                            zzaum().zzayj().log("Service container out of date");
                            z = true;
                            break;
                        case 3:
                            zzaum().zzayg().log("Service disabled");
                            z = false;
                            break;
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        default:
                            z = false;
                            break;
                        case 9:
                            zzaum().zzayg().log("Service invalid");
                            z = false;
                            break;
                        case 18:
                            zzaum().zzayg().log("Service updating");
                            z = true;
                            break;
                    }
                    this.zzivz = Boolean.valueOf(z);
                    zzaun().zzbm(this.zzivz.booleanValue());
                }
            }
            if (this.zzivz.booleanValue()) {
                zzaum().zzayk().log("Using measurement service");
                this.zzivx.zzazt();
                return;
            }
            zzcax.zzawl();
            List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                zzaum().zzayk().log("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context context = getContext();
                zzcax.zzawl();
                intent.setComponent(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
                this.zzivx.zzk(intent);
                return;
            }
            zzaum().zzaye().log("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
        }
    }
}
