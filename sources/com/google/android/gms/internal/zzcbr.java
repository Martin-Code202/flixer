package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzca;
import com.google.android.gms.common.util.zzd;
import com.google.firebase.iid.FirebaseInstanceId;
import java.math.BigInteger;
import java.util.Locale;
public final class zzcbr extends zzcdu {
    private String mAppId;
    private String zzcyd;
    private String zzdma;
    private String zzdmb;
    private String zzile;
    private long zzili;
    private int zziph;
    private long zzipi;
    private int zzipj;

    zzcbr(zzccw zzccw) {
        super(zzccw);
    }

    private final String zzaur() {
        zzuj();
        try {
            return FirebaseInstanceId.getInstance().getId();
        } catch (IllegalStateException unused) {
            zzaum().zzayg().log("Failed to retrieve Firebase Instance Id");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String getAppId() {
        zzwk();
        return this.mAppId;
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: package-private */
    public final String getGmpAppId() {
        zzwk();
        return this.zzcyd;
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

    /* access modifiers changed from: package-private */
    public final String zzayb() {
        byte[] bArr = new byte[16];
        zzaui().zzazz().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* access modifiers changed from: package-private */
    public final int zzayc() {
        zzwk();
        return this.zziph;
    }

    /* access modifiers changed from: package-private */
    public final zzcas zzjb(String str) {
        zzuj();
        String appId = getAppId();
        String gmpAppId = getGmpAppId();
        zzwk();
        String str2 = this.zzdmb;
        long zzayc = (long) zzayc();
        zzwk();
        String str3 = this.zzile;
        long zzauw = zzcax.zzauw();
        zzwk();
        zzuj();
        if (this.zzipi == 0) {
            this.zzipi = this.zzikh.zzaui().zzah(getContext(), getContext().getPackageName());
        }
        long j = this.zzipi;
        boolean isEnabled = this.zzikh.isEnabled();
        boolean z = !zzaun().zzirg;
        String zzaur = zzaur();
        zzwk();
        long zzazf = this.zzikh.zzazf();
        zzwk();
        return new zzcas(appId, gmpAppId, str2, zzayc, str3, zzauw, j, str, isEnabled, z, zzaur, 0, zzazf, this.zzipj);
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzuj() {
        super.zzuj();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzcdu
    public final void zzuk() {
        String str = "unknown";
        String str2 = "Unknown";
        int i = Integer.MIN_VALUE;
        String str3 = "Unknown";
        String packageName = getContext().getPackageName();
        PackageManager packageManager = getContext().getPackageManager();
        if (packageManager == null) {
            zzaum().zzaye().zzj("PackageManager is null, app identity information might be inaccurate. appId", zzcbw.zzjf(packageName));
        } else {
            try {
                str = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                zzaum().zzaye().zzj("Error retrieving app installer package name. appId", zzcbw.zzjf(packageName));
            }
            if (str == null) {
                str = "manual_install";
            } else if ("com.android.vending".equals(str)) {
                str = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        str3 = applicationLabel.toString();
                    }
                    str2 = packageInfo.versionName;
                    i = packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                zzaum().zzaye().zze("Error retrieving package info. appId, appName", zzcbw.zzjf(packageName), str3);
            }
        }
        this.mAppId = packageName;
        this.zzile = str;
        this.zzdmb = str2;
        this.zziph = i;
        this.zzdma = str3;
        this.zzipi = 0;
        zzcax.zzawl();
        Status zzcb = zzca.zzcb(getContext());
        boolean z = zzcb != null && zzcb.isSuccess();
        if (!z) {
            if (zzcb == null) {
                zzaum().zzaye().log("GoogleService failed to initialize (no status)");
            } else {
                zzaum().zzaye().zze("GoogleService failed to initialize, status", Integer.valueOf(zzcb.getStatusCode()), zzcb.getStatusMessage());
            }
        }
        boolean z2 = false;
        if (z) {
            Boolean zzit = zzauo().zzit("firebase_analytics_collection_enabled");
            if (zzauo().zzawm()) {
                zzaum().zzayi().log("Collection disabled with firebase_analytics_collection_deactivated=1");
            } else if (zzit != null && !zzit.booleanValue()) {
                zzaum().zzayi().log("Collection disabled with firebase_analytics_collection_enabled=0");
            } else if (zzit != null || !zzcax.zzaif()) {
                z2 = true;
                zzaum().zzayk().log("Collection enabled");
            } else {
                zzaum().zzayi().log("Collection disabled with google_app_measurement_enable=0");
            }
        }
        this.zzcyd = "";
        this.zzili = 0;
        zzcax.zzawl();
        try {
            String zzaie = zzca.zzaie();
            this.zzcyd = TextUtils.isEmpty(zzaie) ? "" : zzaie;
            if (z2) {
                zzaum().zzayk().zze("App package, google app id", this.mAppId, this.zzcyd);
            }
        } catch (IllegalStateException e) {
            zzaum().zzaye().zze("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzcbw.zzjf(packageName), e);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.zzipj = zzbeb.zzcp(getContext()) ? 1 : 0;
        } else {
            this.zzipj = 0;
        }
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzd zzvx() {
        return super.zzvx();
    }
}
