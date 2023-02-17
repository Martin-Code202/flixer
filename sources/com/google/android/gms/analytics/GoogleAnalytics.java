package com.google.android.gms.analytics;

import com.google.android.gms.internal.zzamu;
import com.google.android.gms.internal.zzape;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public final class GoogleAnalytics extends zza {
    private static List<Runnable> zzdjv = new ArrayList();
    private boolean zzaqe;
    private Set<Object> zzdjw = new HashSet();
    private boolean zzdjy;
    private volatile boolean zzdjz;

    public GoogleAnalytics(zzamu zzamu) {
        super(zzamu);
    }

    public static void zztw() {
        synchronized (GoogleAnalytics.class) {
            if (zzdjv != null) {
                for (Runnable runnable : zzdjv) {
                    runnable.run();
                }
                zzdjv = null;
            }
        }
    }

    public final boolean getAppOptOut() {
        return this.zzdjz;
    }

    public final void initialize() {
        zzape zzwe = zztr().zzwe();
        zzwe.zzzn();
        if (zzwe.zzzo()) {
            setDryRun(zzwe.zzzp());
        }
        zzwe.zzzn();
        this.zzaqe = true;
    }

    public final boolean isDryRunEnabled() {
        return this.zzdjy;
    }

    public final boolean isInitialized() {
        return this.zzaqe;
    }

    public final void setDryRun(boolean z) {
        this.zzdjy = z;
    }
}
