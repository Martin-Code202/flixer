package com.google.android.gms.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import com.google.android.gms.common.util.zzd;
public final class zzcbs extends zzcdu {
    private final zzcbt zzipk = new zzcbt(this, getContext(), zzcax.zzawk());
    private boolean zzipl;

    zzcbs(zzccw zzccw) {
        super(zzccw);
    }

    private final SQLiteDatabase getWritableDatabase() {
        if (this.zzipl) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzipk.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzipl = true;
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0125, code lost:
        r8 = r8 + 1;
     */
    @android.annotation.TargetApi(11)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(int r19, byte[] r20) {
        /*
        // Method dump skipped, instructions count: 312
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcbs.zzb(int, byte[]):boolean");
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final boolean zza(zzcbk zzcbk) {
        Parcel obtain = Parcel.obtain();
        zzcbk.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzb(0, marshall);
        }
        zzaum().zzayg().log("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzcft zzcft) {
        Parcel obtain = Parcel.obtain();
        zzcft.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzb(1, marshall);
        }
        zzaum().zzayg().log("User property too long for local database. Sending directly to service");
        return false;
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

    public final boolean zzc(zzcav zzcav) {
        zzaui();
        byte[] zza = zzcfw.zza(zzcav);
        if (zza.length <= 131072) {
            return zzb(2, zza);
        }
        zzaum().zzayg().log("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0207, code lost:
        r11 = r11 + 1;
     */
    @android.annotation.TargetApi(11)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.zzbck> zzdw(int r25) {
        /*
        // Method dump skipped, instructions count: 538
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcbs.zzdw(int):java.util.List");
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
