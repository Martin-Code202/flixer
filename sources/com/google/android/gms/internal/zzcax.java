package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.zzca;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.common.zze;
import java.lang.reflect.InvocationTargetException;
public final class zzcax extends zzcdt {
    private static String zzimp = String.valueOf(zze.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean zzdqn;

    zzcax(zzccw zzccw) {
        super(zzccw);
    }

    public static boolean zzaif() {
        return zzca.zzaif();
    }

    public static long zzauw() {
        return 11400;
    }

    static String zzavm() {
        return zzcbm.zzioa.get();
    }

    public static int zzavn() {
        return 25;
    }

    public static int zzavo() {
        return 40;
    }

    public static int zzavp() {
        return 24;
    }

    static int zzavq() {
        return 40;
    }

    static int zzavr() {
        return 100;
    }

    static int zzavs() {
        return 256;
    }

    static int zzavt() {
        return 1000;
    }

    public static int zzavu() {
        return 36;
    }

    public static int zzavv() {
        return 2048;
    }

    static int zzavw() {
        return 500;
    }

    public static long zzavx() {
        return (long) zzcbm.zziok.get().intValue();
    }

    public static long zzavy() {
        return (long) zzcbm.zziom.get().intValue();
    }

    static int zzavz() {
        return 25;
    }

    static int zzawa() {
        return 1000;
    }

    static int zzawb() {
        return 25;
    }

    static int zzawc() {
        return 1000;
    }

    static long zzawd() {
        return 15552000000L;
    }

    static long zzawe() {
        return 15552000000L;
    }

    static long zzawf() {
        return 3600000;
    }

    static long zzawg() {
        return 60000;
    }

    static long zzawh() {
        return 61000;
    }

    static long zzawi() {
        return zzcbm.zzipg.get().longValue();
    }

    public static String zzawj() {
        return "google_app_measurement.db";
    }

    static String zzawk() {
        return "google_app_measurement_local.db";
    }

    public static boolean zzawl() {
        return false;
    }

    public static long zzawn() {
        return zzcbm.zzipd.get().longValue();
    }

    public static long zzawo() {
        return zzcbm.zzioy.get().longValue();
    }

    public static long zzawp() {
        return zzcbm.zzioz.get().longValue();
    }

    public static long zzawq() {
        return 1000;
    }

    public static long zzawr() {
        return Math.max(0L, zzcbm.zzioc.get().longValue());
    }

    public static int zzaws() {
        return Math.max(0, zzcbm.zzioi.get().intValue());
    }

    public static int zzawt() {
        return Math.max(1, zzcbm.zzioj.get().intValue());
    }

    public static int zzawu() {
        return 100000;
    }

    public static String zzawv() {
        return zzcbm.zzioq.get();
    }

    public static long zzaww() {
        return zzcbm.zziod.get().longValue();
    }

    public static long zzawx() {
        return Math.max(0L, zzcbm.zzior.get().longValue());
    }

    public static long zzawy() {
        return Math.max(0L, zzcbm.zziot.get().longValue());
    }

    public static long zzawz() {
        return Math.max(0L, zzcbm.zziou.get().longValue());
    }

    public static long zzaxa() {
        return Math.max(0L, zzcbm.zziov.get().longValue());
    }

    public static long zzaxb() {
        return Math.max(0L, zzcbm.zziow.get().longValue());
    }

    public static long zzaxc() {
        return Math.max(0L, zzcbm.zziox.get().longValue());
    }

    public static long zzaxd() {
        return zzcbm.zzios.get().longValue();
    }

    public static long zzaxe() {
        return Math.max(0L, zzcbm.zzipa.get().longValue());
    }

    public static long zzaxf() {
        return Math.max(0L, zzcbm.zzipb.get().longValue());
    }

    public static int zzaxg() {
        return Math.min(20, Math.max(0, zzcbm.zzipc.get().intValue()));
    }

    public static boolean zzaxi() {
        return zzcbm.zziny.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final long zza(String str, zzcbn<Long> zzcbn) {
        if (str == null) {
            return zzcbn.get().longValue();
        }
        String zzan = zzauj().zzan(str, zzcbn.getKey());
        if (TextUtils.isEmpty(zzan)) {
            return zzcbn.get().longValue();
        }
        try {
            return zzcbn.get(Long.valueOf(Long.valueOf(zzan).longValue())).longValue();
        } catch (NumberFormatException unused) {
            return zzcbn.get().longValue();
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

    public final boolean zzawm() {
        Boolean zzit = zzit("firebase_analytics_collection_deactivated");
        return zzit != null && zzit.booleanValue();
    }

    public final String zzaxh() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "debug.firebase.analytics.app", "");
        } catch (ClassNotFoundException e) {
            zzaum().zzaye().zzj("Could not find SystemProperties class", e);
            return "";
        } catch (NoSuchMethodException e2) {
            zzaum().zzaye().zzj("Could not find SystemProperties.get() method", e2);
            return "";
        } catch (IllegalAccessException e3) {
            zzaum().zzaye().zzj("Could not access SystemProperties.get()", e3);
            return "";
        } catch (InvocationTargetException e4) {
            zzaum().zzaye().zzj("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public final int zzb(String str, zzcbn<Integer> zzcbn) {
        if (str == null) {
            return zzcbn.get().intValue();
        }
        String zzan = zzauj().zzan(str, zzcbn.getKey());
        if (TextUtils.isEmpty(zzan)) {
            return zzcbn.get().intValue();
        }
        try {
            return zzcbn.get(Integer.valueOf(Integer.valueOf(zzan).intValue())).intValue();
        } catch (NumberFormatException unused) {
            return zzcbn.get().intValue();
        }
    }

    public final int zzis(String str) {
        return zzb(str, zzcbm.zzioo);
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzit(String str) {
        zzbp.zzgg(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzaum().zzaye().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = zzbed.zzcr(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzaum().zzaye().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData == null) {
                zzaum().zzaye().log("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (!applicationInfo.metaData.containsKey(str)) {
                return null;
            } else {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzaum().zzaye().zzj("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final boolean zziu(String str) {
        return "1".equals(zzauj().zzan(str, "gaia_collection_enabled"));
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzuj() {
        super.zzuj();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzd zzvx() {
        return super.zzvx();
    }

    public final boolean zzxu() {
        if (this.zzdqn == null) {
            synchronized (this) {
                if (this.zzdqn == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String zzall = zzq.zzall();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzdqn = Boolean.valueOf(str != null && str.equals(zzall));
                    }
                    if (this.zzdqn == null) {
                        this.zzdqn = Boolean.TRUE;
                        zzaum().zzaye().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzdqn.booleanValue();
    }
}
