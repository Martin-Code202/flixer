package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.IOException;
import java.util.Map;
public final class zzccq extends zzcdu {
    private final Map<String, Map<String, String>> zziru = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzirv = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzirw = new ArrayMap();
    private final Map<String, zzcge> zzirx = new ArrayMap();
    private final Map<String, String> zziry = new ArrayMap();

    zzccq(zzccw zzccw) {
        super(zzccw);
    }

    private static Map<String, String> zza(zzcge zzcge) {
        ArrayMap arrayMap = new ArrayMap();
        if (!(zzcge == null || zzcge.zziyn == null)) {
            zzcgf[] zzcgfArr = zzcge.zziyn;
            for (zzcgf zzcgf : zzcgfArr) {
                if (zzcgf != null) {
                    arrayMap.put(zzcgf.key, zzcgf.value);
                }
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzcge zzcge) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        if (!(zzcge == null || zzcge.zziyo == null)) {
            zzcgd[] zzcgdArr = zzcge.zziyo;
            for (zzcgd zzcgd : zzcgdArr) {
                if (zzcgd != null) {
                    String zzil = AppMeasurement.Event.zzil(zzcgd.name);
                    if (zzil != null) {
                        zzcgd.name = zzil;
                    }
                    arrayMap.put(zzcgd.name, zzcgd.zziyj);
                    arrayMap2.put(zzcgd.name, zzcgd.zziyk);
                }
            }
        }
        this.zzirv.put(str, arrayMap);
        this.zzirw.put(str, arrayMap2);
    }

    private final zzcge zzc(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzcge();
        }
        zzegx zzh = zzegx.zzh(bArr, 0, bArr.length);
        zzcge zzcge = new zzcge();
        try {
            zzcge.zza(zzh);
            zzaum().zzayk().zze("Parsed config. version, gmp_app_id", zzcge.zziyl, zzcge.zzilt);
            return zzcge;
        } catch (IOException e) {
            zzaum().zzayg().zze("Unable to merge remote config. appId", zzcbw.zzjf(str), e);
            return new zzcge();
        }
    }

    private final void zzjm(String str) {
        zzwk();
        zzuj();
        zzbp.zzgg(str);
        if (this.zzirx.get(str) == null) {
            byte[] zziy = zzaug().zziy(str);
            if (zziy == null) {
                this.zziru.put(str, null);
                this.zzirv.put(str, null);
                this.zzirw.put(str, null);
                this.zzirx.put(str, null);
                this.zziry.put(str, null);
                return;
            }
            zzcge zzc = zzc(str, zziy);
            this.zziru.put(str, zza(zzc));
            zza(str, zzc);
            this.zzirx.put(str, zzc);
            this.zziry.put(str, null);
        }
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: package-private */
    public final String zzan(String str, String str2) {
        zzuj();
        zzjm(str);
        Map<String, String> map = this.zziru.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzao(String str, String str2) {
        Boolean bool;
        zzuj();
        zzjm(str);
        if (zzaui().zzkg(str) && zzcfw.zzkd(str2)) {
            return true;
        }
        if (zzaui().zzkh(str) && zzcfw.zzju(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzirv.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzap(String str, String str2) {
        Boolean bool;
        zzuj();
        zzjm(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzirw.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
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
    public final boolean zzb(String str, byte[] bArr, String str2) {
        zzwk();
        zzuj();
        zzbp.zzgg(str);
        zzcge zzc = zzc(str, bArr);
        if (zzc == null) {
            return false;
        }
        zza(str, zzc);
        this.zzirx.put(str, zzc);
        this.zziry.put(str, str2);
        this.zziru.put(str, zza(zzc));
        zzcau zzatz = zzatz();
        zzcfx[] zzcfxArr = zzc.zziyp;
        zzbp.zzu(zzcfxArr);
        for (zzcfx zzcfx : zzcfxArr) {
            zzcfy[] zzcfyArr = zzcfx.zzixk;
            int length = zzcfyArr.length;
            for (int i = 0; i < length; i++) {
                zzcfy zzcfy = zzcfyArr[i];
                String zzil = AppMeasurement.Event.zzil(zzcfy.zzixn);
                if (zzil != null) {
                    zzcfy.zzixn = zzil;
                }
                zzcfz[] zzcfzArr = zzcfy.zzixo;
                int length2 = zzcfzArr.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    zzcfz zzcfz = zzcfzArr[i2];
                    String zzil2 = AppMeasurement.Param.zzil(zzcfz.zzixv);
                    if (zzil2 != null) {
                        zzcfz.zzixv = zzil2;
                    }
                }
            }
            zzcgb[] zzcgbArr = zzcfx.zzixj;
            int length3 = zzcgbArr.length;
            for (int i3 = 0; i3 < length3; i3++) {
                zzcgb zzcgb = zzcgbArr[i3];
                String zzil3 = AppMeasurement.UserProperty.zzil(zzcgb.zziyc);
                if (zzil3 != null) {
                    zzcgb.zziyc = zzil3;
                }
            }
        }
        zzatz.zzaug().zza(str, zzcfxArr);
        try {
            zzc.zziyp = null;
            byte[] bArr2 = new byte[zzc.zzhi()];
            zzc.zza(zzegy.zzi(bArr2, 0, bArr2.length));
            bArr = bArr2;
        } catch (IOException e) {
            zzaum().zzayg().zze("Unable to serialize reduced-size config. Storing full config instead. appId", zzcbw.zzjf(str), e);
        }
        zzcay zzaug = zzaug();
        zzbp.zzgg(str);
        zzaug.zzuj();
        zzaug.zzwk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) zzaug.getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str})) != 0) {
                return true;
            }
            zzaug.zzaum().zzaye().zzj("Failed to update remote config (got 0). appId", zzcbw.zzjf(str));
            return true;
        } catch (SQLiteException e2) {
            zzaug.zzaum().zzaye().zze("Error storing remote config. appId", zzcbw.zzjf(str), e2);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final zzcge zzjn(String str) {
        zzwk();
        zzuj();
        zzbp.zzgg(str);
        zzjm(str);
        return this.zzirx.get(str);
    }

    /* access modifiers changed from: protected */
    public final String zzjo(String str) {
        zzuj();
        return this.zziry.get(str);
    }

    /* access modifiers changed from: protected */
    public final void zzjp(String str) {
        zzuj();
        this.zziry.put(str, null);
    }

    /* access modifiers changed from: package-private */
    public final void zzjq(String str) {
        zzuj();
        this.zzirx.remove(str);
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
