package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
public class zzamu {
    private static volatile zzamu zzdof;
    private final Context mContext;
    private final zzd zzasb = zzh.zzald();
    private final Context zzdog;
    private final zzanv zzdoh = new zzanv(this);
    private final zzaon zzdoi;
    private final zzj zzdoj;
    private final zzamj zzdok;
    private final zzaoa zzdol;
    private final zzape zzdom;
    private final zzaor zzdon;
    private final GoogleAnalytics zzdoo;
    private final zzanm zzdop;
    private final zzami zzdoq;
    private final zzanf zzdor;
    private final zzanz zzdos;

    private zzamu(zzamw zzamw) {
        Context applicationContext = zzamw.getApplicationContext();
        zzbp.zzb(applicationContext, "Application context can't be null");
        Context zzwl = zzamw.zzwl();
        zzbp.zzu(zzwl);
        this.mContext = applicationContext;
        this.zzdog = zzwl;
        zzaon zzaon = new zzaon(this);
        zzaon.initialize();
        this.zzdoi = zzaon;
        zzaon zzvy = zzvy();
        String str = zzamt.VERSION;
        zzvy.zzdo(new StringBuilder(String.valueOf(str).length() + 134).append("Google Analytics ").append(str).append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4").toString());
        zzaor zzaor = new zzaor(this);
        zzaor.initialize();
        this.zzdon = zzaor;
        zzape zzape = new zzape(this);
        zzape.initialize();
        this.zzdom = zzape;
        zzamj zzamj = new zzamj(this, zzamw);
        zzanm zzanm = new zzanm(this);
        zzami zzami = new zzami(this);
        zzanf zzanf = new zzanf(this);
        zzanz zzanz = new zzanz(this);
        zzj zzbf = zzj.zzbf(applicationContext);
        zzbf.zza(new zzamv(this));
        this.zzdoj = zzbf;
        GoogleAnalytics googleAnalytics = new GoogleAnalytics(this);
        zzanm.initialize();
        this.zzdop = zzanm;
        zzami.initialize();
        this.zzdoq = zzami;
        zzanf.initialize();
        this.zzdor = zzanf;
        zzanz.initialize();
        this.zzdos = zzanz;
        zzaoa zzaoa = new zzaoa(this);
        zzaoa.initialize();
        this.zzdol = zzaoa;
        zzamj.initialize();
        this.zzdok = zzamj;
        googleAnalytics.initialize();
        this.zzdoo = googleAnalytics;
        zzamj.start();
    }

    private static void zza(zzams zzams) {
        zzbp.zzb(zzams, "Analytics service not created/initialized");
        zzbp.zzb(zzams.isInitialized(), "Analytics service not initialized");
    }

    public static zzamu zzbg(Context context) {
        zzbp.zzu(context);
        if (zzdof == null) {
            synchronized (zzamu.class) {
                if (zzdof == null) {
                    zzd zzald = zzh.zzald();
                    long elapsedRealtime = zzald.elapsedRealtime();
                    zzamu zzamu = new zzamu(new zzamw(context));
                    zzdof = zzamu;
                    GoogleAnalytics.zztw();
                    long elapsedRealtime2 = zzald.elapsedRealtime() - elapsedRealtime;
                    long longValue = zzaod.zzdso.get().longValue();
                    if (elapsedRealtime2 > longValue) {
                        zzamu.zzvy().zzc("Slow initialization (ms)", Long.valueOf(elapsedRealtime2), Long.valueOf(longValue));
                    }
                }
            }
        }
        return zzdof;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final zzd zzvx() {
        return this.zzasb;
    }

    public final zzaon zzvy() {
        zza(this.zzdoi);
        return this.zzdoi;
    }

    public final zzanv zzvz() {
        return this.zzdoh;
    }

    public final zzj zzwa() {
        zzbp.zzu(this.zzdoj);
        return this.zzdoj;
    }

    public final zzamj zzwc() {
        zza(this.zzdok);
        return this.zzdok;
    }

    public final zzaoa zzwd() {
        zza(this.zzdol);
        return this.zzdol;
    }

    public final zzape zzwe() {
        zza(this.zzdom);
        return this.zzdom;
    }

    public final zzaor zzwf() {
        zza(this.zzdon);
        return this.zzdon;
    }

    public final zzanf zzwi() {
        zza(this.zzdor);
        return this.zzdor;
    }

    public final zzanz zzwj() {
        return this.zzdos;
    }

    public final Context zzwl() {
        return this.zzdog;
    }

    public final zzaon zzwm() {
        return this.zzdoi;
    }

    public final GoogleAnalytics zzwn() {
        zzbp.zzu(this.zzdoo);
        zzbp.zzb(this.zzdoo.isInitialized(), "Analytics instance not initialized");
        return this.zzdoo;
    }

    public final zzaor zzwo() {
        if (this.zzdon == null || !this.zzdon.isInitialized()) {
            return null;
        }
        return this.zzdon;
    }

    public final zzami zzwp() {
        zza(this.zzdoq);
        return this.zzdoq;
    }

    public final zzanm zzwq() {
        zza(this.zzdop);
        return this.zzdop;
    }
}
