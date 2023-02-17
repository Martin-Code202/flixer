package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.os.Build;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class zzg {
    private final zzd zzasb;
    private final zzi zzdkj;
    private boolean zzdkk;
    private long zzdkl;
    private long zzdkm;
    private long zzdkn;
    private long zzdko;
    private long zzdkp;
    private boolean zzdkq;
    private final Map<Class<? extends zzh>, zzh> zzdkr;
    private final List<zzm> zzdks;

    private zzg(zzg zzg) {
        this.zzdkj = zzg.zzdkj;
        this.zzasb = zzg.zzasb;
        this.zzdkl = zzg.zzdkl;
        this.zzdkm = zzg.zzdkm;
        this.zzdkn = zzg.zzdkn;
        this.zzdko = zzg.zzdko;
        this.zzdkp = zzg.zzdkp;
        this.zzdks = new ArrayList(zzg.zzdks);
        this.zzdkr = new HashMap(zzg.zzdkr.size());
        for (Map.Entry<Class<? extends zzh>, zzh> entry : zzg.zzdkr.entrySet()) {
            zzh zzc = zzc(entry.getKey());
            entry.getValue().zzb(zzc);
            this.zzdkr.put(entry.getKey(), zzc);
        }
    }

    zzg(zzi zzi, zzd zzd) {
        zzbp.zzu(zzi);
        zzbp.zzu(zzd);
        this.zzdkj = zzi;
        this.zzasb = zzd;
        this.zzdko = 1800000;
        this.zzdkp = 3024000000L;
        this.zzdkr = new HashMap();
        this.zzdks = new ArrayList();
    }

    @TargetApi(19)
    private static <T extends zzh> T zzc(Class<T> cls) {
        try {
            return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            if (e instanceof InstantiationException) {
                throw new IllegalArgumentException("dataType doesn't have default constructor", e);
            } else if (e instanceof IllegalAccessException) {
                throw new IllegalArgumentException("dataType default constructor is not accessible", e);
            } else if (Build.VERSION.SDK_INT < 19 || !(e instanceof ReflectiveOperationException)) {
                throw new RuntimeException(e);
            } else {
                throw new IllegalArgumentException("Linkage exception", e);
            }
        }
    }

    public final List<zzm> getTransports() {
        return this.zzdks;
    }

    public final <T extends zzh> T zza(Class<T> cls) {
        return (T) this.zzdkr.get(cls);
    }

    public final void zza(zzh zzh) {
        zzbp.zzu(zzh);
        Class<?> cls = zzh.getClass();
        if (cls.getSuperclass() != zzh.class) {
            throw new IllegalArgumentException();
        }
        zzh.zzb(zzb(cls));
    }

    public final <T extends zzh> T zzb(Class<T> cls) {
        T t = (T) this.zzdkr.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) zzc(cls);
        this.zzdkr.put(cls, t2);
        return t2;
    }

    public final void zzl(long j) {
        this.zzdkm = j;
    }

    public final zzg zztx() {
        return new zzg(this);
    }

    public final Collection<zzh> zzty() {
        return this.zzdkr.values();
    }

    public final long zztz() {
        return this.zzdkl;
    }

    public final void zzua() {
        this.zzdkj.zzug().zze(this);
    }

    public final boolean zzub() {
        return this.zzdkk;
    }

    /* access modifiers changed from: package-private */
    public final void zzuc() {
        this.zzdkn = this.zzasb.elapsedRealtime();
        if (this.zzdkm != 0) {
            this.zzdkl = this.zzdkm;
        } else {
            this.zzdkl = this.zzasb.currentTimeMillis();
        }
        this.zzdkk = true;
    }

    /* access modifiers changed from: package-private */
    public final zzi zzud() {
        return this.zzdkj;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzue() {
        return this.zzdkq;
    }

    /* access modifiers changed from: package-private */
    public final void zzuf() {
        this.zzdkq = true;
    }
}
