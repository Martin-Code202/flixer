package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.analytics.zzj;
public final class zzaor extends zzams {
    private SharedPreferences zzdtp;
    private long zzdtq;
    private long zzdtr = -1;
    private final zzaot zzdts = new zzaot(this, "monitoring", zzaod.zzdsn.get().longValue());

    protected zzaor(zzamu zzamu) {
        super(zzamu);
    }

    public final void zzdx(String str) {
        zzj.zzuj();
        zzwk();
        SharedPreferences.Editor edit = this.zzdtp.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            zzdp("Failed to commit campaign data");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzams
    public final void zzuk() {
        this.zzdtp = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final long zzzb() {
        zzj.zzuj();
        zzwk();
        if (this.zzdtq == 0) {
            long j = this.zzdtp.getLong("first_run", 0);
            if (j != 0) {
                this.zzdtq = j;
            } else {
                long currentTimeMillis = zzvx().currentTimeMillis();
                SharedPreferences.Editor edit = this.zzdtp.edit();
                edit.putLong("first_run", currentTimeMillis);
                if (!edit.commit()) {
                    zzdp("Failed to commit first run time");
                }
                this.zzdtq = currentTimeMillis;
            }
        }
        return this.zzdtq;
    }

    public final zzaoz zzzc() {
        return new zzaoz(zzvx(), zzzb());
    }

    public final long zzzd() {
        zzj.zzuj();
        zzwk();
        if (this.zzdtr == -1) {
            this.zzdtr = this.zzdtp.getLong("last_dispatch", 0);
        }
        return this.zzdtr;
    }

    public final void zzze() {
        zzj.zzuj();
        zzwk();
        long currentTimeMillis = zzvx().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzdtp.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.zzdtr = currentTimeMillis;
    }

    public final String zzzf() {
        zzj.zzuj();
        zzwk();
        String string = this.zzdtp.getString("installation_campaign", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public final zzaot zzzg() {
        return this.zzdts;
    }
}
