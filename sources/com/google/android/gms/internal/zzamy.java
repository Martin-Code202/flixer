package com.google.android.gms.internal;

import android.content.ComponentName;
import android.os.RemoteException;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.stats.zza;
import java.util.Collections;
public final class zzamy extends zzams {
    private final zzana zzdoz = new zzana(this);
    private zzaoj zzdpa;
    private final zzanx zzdpb;
    private final zzaoz zzdpc;

    protected zzamy(zzamu zzamu) {
        super(zzamu);
        this.zzdpc = new zzaoz(zzamu.zzvx());
        this.zzdpb = new zzamz(this, zzamu);
    }

    /* access modifiers changed from: public */
    private final void onServiceDisconnected(ComponentName componentName) {
        zzj.zzuj();
        if (this.zzdpa != null) {
            this.zzdpa = null;
            zza("Disconnected from device AnalyticsService", componentName);
            zzwc().zzvu();
        }
    }

    /* access modifiers changed from: public */
    private final void zza(zzaoj zzaoj) {
        zzj.zzuj();
        this.zzdpa = zzaoj;
        zzww();
        zzwc().onServiceConnected();
    }

    private final void zzww() {
        this.zzdpc.start();
        this.zzdpb.zzs(zzaod.zzdsi.get().longValue());
    }

    /* access modifiers changed from: public */
    private final void zzwx() {
        zzj.zzuj();
        if (isConnected()) {
            zzdm("Inactivity, disconnecting from device AnalyticsService");
            disconnect();
        }
    }

    public final boolean connect() {
        zzj.zzuj();
        zzwk();
        if (this.zzdpa != null) {
            return true;
        }
        zzaoj zzwy = this.zzdoz.zzwy();
        if (zzwy == null) {
            return false;
        }
        this.zzdpa = zzwy;
        zzww();
        return true;
    }

    public final void disconnect() {
        zzj.zzuj();
        zzwk();
        try {
            zza.zzakz();
            getContext().unbindService(this.zzdoz);
        } catch (IllegalStateException unused) {
        } catch (IllegalArgumentException unused2) {
        }
        if (this.zzdpa != null) {
            this.zzdpa = null;
            zzwc().zzvu();
        }
    }

    public final boolean isConnected() {
        zzj.zzuj();
        zzwk();
        return this.zzdpa != null;
    }

    public final boolean zzb(zzaoi zzaoi) {
        zzbp.zzu(zzaoi);
        zzj.zzuj();
        zzwk();
        zzaoj zzaoj = this.zzdpa;
        if (zzaoj == null) {
            return false;
        }
        try {
            zzaoj.zza(zzaoi.zziy(), zzaoi.zzyn(), zzaoi.zzyp() ? zzanv.zzyb() : zzanv.zzyc(), Collections.emptyList());
            zzww();
            return true;
        } catch (RemoteException unused) {
            zzdm("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzams
    public final void zzuk() {
    }
}
