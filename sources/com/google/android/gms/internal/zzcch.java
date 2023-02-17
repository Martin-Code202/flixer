package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
/* access modifiers changed from: package-private */
public final class zzcch extends zzcdu {
    static final Pair<String, Long> zziqm = new Pair<>("", 0L);
    private SharedPreferences zzdtp;
    public final zzccl zziqn = new zzccl(this, "health_monitor", zzcax.zzawr());
    public final zzcck zziqo = new zzcck(this, "last_upload", 0);
    public final zzcck zziqp = new zzcck(this, "last_upload_attempt", 0);
    public final zzcck zziqq = new zzcck(this, "backoff", 0);
    public final zzcck zziqr = new zzcck(this, "last_delete_stale", 0);
    public final zzcck zziqs = new zzcck(this, "midnight_offset", 0);
    public final zzcck zziqt = new zzcck(this, "first_open_time", 0);
    public final zzccm zziqu = new zzccm(this, "app_instance_id", null);
    private String zziqv;
    private boolean zziqw;
    private long zziqx;
    private final Object zzira = new Object();
    public final zzcck zzirb = new zzcck(this, "time_before_start", 10000);
    public final zzcck zzirc = new zzcck(this, "session_timeout", 1800000);
    public final zzccj zzird = new zzccj(this, "start_new_session", true);
    public final zzcck zzire = new zzcck(this, "last_pause_time", 0);
    public final zzcck zzirf = new zzcck(this, "time_active", 0);
    public boolean zzirg;

    zzcch(zzccw zzccw) {
        super(zzccw);
    }

    /* access modifiers changed from: private */
    public final SharedPreferences zzaym() {
        zzuj();
        zzwk();
        return this.zzdtp;
    }

    /* access modifiers changed from: package-private */
    public final void setMeasurementEnabled(boolean z) {
        zzuj();
        zzaum().zzayk().zzj("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzaym().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final String zzayn() {
        zzuj();
        return zzaym().getString("gmp_app_id", null);
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzayp() {
        zzuj();
        if (!zzaym().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzaym().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    public final void zzayq() {
        zzuj();
        zzaum().zzayk().log("Clearing collection preferences.");
        boolean contains = zzaym().contains("measurement_enabled");
        boolean z = true;
        if (contains) {
            z = zzbn(true);
        }
        SharedPreferences.Editor edit = zzaym().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
    }

    /* access modifiers changed from: protected */
    public final String zzayr() {
        zzuj();
        String string = zzaym().getString("previous_os_version", null);
        zzauc().zzwk();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzaym().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    public final void zzbm(boolean z) {
        zzuj();
        zzaum().zzayk().zzj("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzaym().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbn(boolean z) {
        zzuj();
        return zzaym().getBoolean("measurement_enabled", z);
    }

    /* access modifiers changed from: package-private */
    public final Pair<String, Boolean> zzjh(String str) {
        zzuj();
        long elapsedRealtime = zzvx().elapsedRealtime();
        if (this.zziqv != null && elapsedRealtime < this.zziqx) {
            return new Pair<>(this.zziqv, Boolean.valueOf(this.zziqw));
        }
        this.zziqx = zzauo().zza(str, zzcbm.zziob) + elapsedRealtime;
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            if (advertisingIdInfo != null) {
                this.zziqv = advertisingIdInfo.getId();
                this.zziqw = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zziqv == null) {
                this.zziqv = "";
            }
        } catch (Throwable th) {
            zzaum().zzayj().zzj("Unable to get advertising id", th);
            this.zziqv = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zziqv, Boolean.valueOf(this.zziqw));
    }

    /* access modifiers changed from: package-private */
    public final String zzji(String str) {
        zzuj();
        String str2 = (String) zzjh(str).first;
        MessageDigest zzec = zzcfw.zzec("MD5");
        if (zzec == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzec.digest(str2.getBytes())));
    }

    /* access modifiers changed from: package-private */
    public final void zzjj(String str) {
        zzuj();
        SharedPreferences.Editor edit = zzaym().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzcdu
    public final void zzuk() {
        this.zzdtp = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzirg = this.zzdtp.getBoolean("has_been_opened", false);
        if (!this.zzirg) {
            SharedPreferences.Editor edit = this.zzdtp.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }
}
