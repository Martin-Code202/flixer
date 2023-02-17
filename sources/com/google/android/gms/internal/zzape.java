package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
public final class zzape extends zzams {
    private boolean zzdjy;
    private String zzdma;
    private String zzdmb;
    private int zzdqq;
    protected int zzdst;
    protected boolean zzdum;
    private boolean zzdun;

    public zzape(zzamu zzamu) {
        super(zzamu);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzams
    public final void zzuk() {
        int i;
        zzaoh zzaoh;
        ApplicationInfo applicationInfo = null;
        Context context = getContext();
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 129);
        } catch (PackageManager.NameNotFoundException e) {
            zzd("PackageManager doesn't know about the app package", e);
        }
        if (applicationInfo == null) {
            zzdp("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) > 0 && (zzaoh = (zzaoh) new zzaof(zzvw()).zzat(i)) != null) {
            zzdm("Loading global XML config values");
            if (zzaoh.zzdma != null) {
                String str = zzaoh.zzdma;
                this.zzdma = str;
                zzb("XML config - app name", str);
            }
            if (zzaoh.zzdmb != null) {
                String str2 = zzaoh.zzdmb;
                this.zzdmb = str2;
                zzb("XML config - app version", str2);
            }
            if (zzaoh.zzdss != null) {
                String lowerCase = zzaoh.zzdss.toLowerCase();
                int i2 = "verbose".equals(lowerCase) ? 0 : "info".equals(lowerCase) ? 1 : "warning".equals(lowerCase) ? 2 : ExceptionClEvent.CATEGORY_VALUE.equals(lowerCase) ? 3 : -1;
                if (i2 >= 0) {
                    this.zzdqq = i2;
                    zza("XML config - log level", Integer.valueOf(i2));
                }
            }
            if (zzaoh.zzdst >= 0) {
                int i3 = zzaoh.zzdst;
                this.zzdst = i3;
                this.zzdum = true;
                zzb("XML config - dispatch period (sec)", Integer.valueOf(i3));
            }
            if (zzaoh.zzdsu != -1) {
                boolean z = zzaoh.zzdsu == 1;
                this.zzdjy = z;
                this.zzdun = true;
                zzb("XML config - dry run", Boolean.valueOf(z));
            }
        }
    }

    public final String zzun() {
        zzwk();
        return this.zzdma;
    }

    public final String zzuo() {
        zzwk();
        return this.zzdmb;
    }

    public final boolean zzzn() {
        zzwk();
        return false;
    }

    public final boolean zzzo() {
        zzwk();
        return this.zzdun;
    }

    public final boolean zzzp() {
        zzwk();
        return this.zzdjy;
    }
}
