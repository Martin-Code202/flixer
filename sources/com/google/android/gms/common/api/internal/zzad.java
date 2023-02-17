package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzbdy;
import com.google.android.gms.internal.zzcps;
import com.google.android.gms.internal.zzcpt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
public final class zzad implements zzcd {
    private final Looper zzakf;
    private final zzbp zzfgu;
    private final Lock zzfkd;
    private final zzq zzfki;
    private final Map<Api.zzc<?>, zzac<?>> zzfkj = new HashMap();
    private final Map<Api.zzc<?>, zzac<?>> zzfkk = new HashMap();
    private final Map<Api<?>, Boolean> zzfkl;
    private final zzbd zzfkm;
    private final zze zzfkn;
    private final Condition zzfko;
    private final boolean zzfkp;
    private final boolean zzfkq;
    private final Queue<zzm<?, ?>> zzfkr = new LinkedList();
    private boolean zzfks;
    private Map<zzh<?>, ConnectionResult> zzfkt;
    private Map<zzh<?>, ConnectionResult> zzfku;
    private zzag zzfkv;
    private ConnectionResult zzfkw;

    public zzad(Context context, Lock lock, Looper looper, zze zze, Map<Api.zzc<?>, Api.zze> map, zzq zzq, Map<Api<?>, Boolean> map2, Api.zza<? extends zzcps, zzcpt> zza, ArrayList<zzw> arrayList, zzbd zzbd, boolean z) {
        this.zzfkd = lock;
        this.zzakf = looper;
        this.zzfko = lock.newCondition();
        this.zzfkn = zze;
        this.zzfkm = zzbd;
        this.zzfkl = map2;
        this.zzfki = zzq;
        this.zzfkp = z;
        HashMap hashMap = new HashMap();
        for (Api<?> api : map2.keySet()) {
            hashMap.put(api.zzafe(), api);
        }
        HashMap hashMap2 = new HashMap();
        ArrayList<zzw> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            zzw zzw = arrayList2.get(i);
            i++;
            zzw zzw2 = zzw;
            hashMap2.put(zzw2.zzfdf, zzw2);
        }
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        for (Map.Entry<Api.zzc<?>, Api.zze> entry : map.entrySet()) {
            Api api2 = (Api) hashMap.get(entry.getKey());
            Api.zze value = entry.getValue();
            if (value.zzaff()) {
                z4 = true;
                if (!this.zzfkl.get(api2).booleanValue()) {
                    z2 = true;
                }
            } else {
                z3 = false;
            }
            zzac<?> zzac = new zzac<>(context, api2, looper, value, (zzw) hashMap2.get(api2), zzq, zza);
            this.zzfkj.put(entry.getKey(), zzac);
            if (value.zzaac()) {
                this.zzfkk.put(entry.getKey(), zzac);
            }
        }
        this.zzfkq = z4 && !z3 && !z2;
        this.zzfgu = zzbp.zzaho();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zza(zzac<?> zzac, ConnectionResult connectionResult) {
        return !connectionResult.isSuccess() && !connectionResult.hasResolution() && this.zzfkl.get(zzac.zzafj()).booleanValue() && zzac.zzagn().zzaff() && this.zzfkn.isUserResolvableError(connectionResult.getErrorCode());
    }

    static /* synthetic */ boolean zza(zzad zzad, boolean z) {
        zzad.zzfks = false;
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzago() {
        /*
            r5 = this;
            java.util.concurrent.locks.Lock r0 = r5.zzfkd
            r0.lock()
            boolean r0 = r5.zzfks     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000d
            boolean r0 = r5.zzfkp     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0014
        L_0x000d:
            java.util.concurrent.locks.Lock r0 = r5.zzfkd
            r0.unlock()
            r0 = 0
            return r0
        L_0x0014:
            java.util.Map<com.google.android.gms.common.api.Api$zzc<?>, com.google.android.gms.common.api.internal.zzac<?>> r0 = r5.zzfkk
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r1 = r0.iterator()
        L_0x001e:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x003f
            java.lang.Object r0 = r1.next()
            r2 = r0
            com.google.android.gms.common.api.Api$zzc r2 = (com.google.android.gms.common.api.Api.zzc) r2
            com.google.android.gms.common.ConnectionResult r3 = r5.zzb(r2)
            if (r3 == 0) goto L_0x0037
            boolean r0 = r3.isSuccess()
            if (r0 != 0) goto L_0x003e
        L_0x0037:
            java.util.concurrent.locks.Lock r0 = r5.zzfkd
            r0.unlock()
            r0 = 0
            return r0
        L_0x003e:
            goto L_0x001e
        L_0x003f:
            java.util.concurrent.locks.Lock r0 = r5.zzfkd
            r0.unlock()
            r0 = 1
            return r0
        L_0x0046:
            r4 = move-exception
            java.util.concurrent.locks.Lock r0 = r5.zzfkd
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzad.zzago():boolean");
    }

    private final void zzagp() {
        if (this.zzfki == null) {
            this.zzfkm.zzfmn = Collections.emptySet();
            return;
        }
        HashSet hashSet = new HashSet(this.zzfki.zzajs());
        Map<Api<?>, zzs> zzaju = this.zzfki.zzaju();
        for (Api<?> api : zzaju.keySet()) {
            ConnectionResult connectionResult = getConnectionResult(api);
            if (connectionResult != null && connectionResult.isSuccess()) {
                hashSet.addAll(zzaju.get(api).zzecl);
            }
        }
        this.zzfkm.zzfmn = hashSet;
    }

    private final void zzagq() {
        while (!this.zzfkr.isEmpty()) {
            zze((zzad) this.zzfkr.remove());
        }
        this.zzfkm.zzj(null);
    }

    private final ConnectionResult zzagr() {
        ConnectionResult connectionResult = null;
        int i = 0;
        ConnectionResult connectionResult2 = null;
        int i2 = 0;
        for (zzac<?> zzac : this.zzfkj.values()) {
            Api<?> zzafj = zzac.zzafj();
            ConnectionResult connectionResult3 = this.zzfkt.get(zzac.zzafk());
            if (!connectionResult3.isSuccess() && (!this.zzfkl.get(zzafj).booleanValue() || connectionResult3.hasResolution() || this.zzfkn.isUserResolvableError(connectionResult3.getErrorCode()))) {
                if (connectionResult3.getErrorCode() != 4 || !this.zzfkp) {
                    int priority = zzafj.zzafc().getPriority();
                    if (connectionResult == null || i > priority) {
                        connectionResult = connectionResult3;
                        i = priority;
                    }
                } else {
                    int priority2 = zzafj.zzafc().getPriority();
                    if (connectionResult2 == null || i2 > priority2) {
                        connectionResult2 = connectionResult3;
                        i2 = priority2;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || i <= i2) ? connectionResult : connectionResult2;
    }

    private final ConnectionResult zzb(Api.zzc<?> zzc) {
        this.zzfkd.lock();
        try {
            zzac<?> zzac = this.zzfkj.get(zzc);
            if (this.zzfkt != null && zzac != null) {
                return this.zzfkt.get(zzac.zzafk());
            }
            this.zzfkd.unlock();
            return null;
        } finally {
            this.zzfkd.unlock();
        }
    }

    static /* synthetic */ boolean zzb(zzad zzad) {
        return zzad.zzfks;
    }

    static /* synthetic */ Map zzc(zzad zzad) {
        return zzad.zzfkj;
    }

    static /* synthetic */ Map zzd(zzad zzad) {
        return zzad.zzfkt;
    }

    static /* synthetic */ boolean zze(zzad zzad) {
        return zzad.zzfkq;
    }

    static /* synthetic */ ConnectionResult zzf(zzad zzad) {
        return zzad.zzagr();
    }

    static /* synthetic */ Map zzg(zzad zzad) {
        return zzad.zzfku;
    }

    private final <T extends zzm<? extends Result, ? extends Api.zzb>> boolean zzg(T t) {
        Api.zzc<?> zzafe = t.zzafe();
        ConnectionResult zzb = zzb(zzafe);
        if (zzb == null || zzb.getErrorCode() != 4) {
            return false;
        }
        t.zzt(new Status(4, null, this.zzfgu.zza(this.zzfkj.get(zzafe).zzafk(), System.identityHashCode(this.zzfkm))));
        return true;
    }

    static /* synthetic */ ConnectionResult zzh(zzad zzad) {
        return zzad.zzfkw;
    }

    static /* synthetic */ void zzi(zzad zzad) {
        zzad.zzagp();
    }

    static /* synthetic */ void zzj(zzad zzad) {
        zzad.zzagq();
    }

    static /* synthetic */ zzbd zzk(zzad zzad) {
        return zzad.zzfkm;
    }

    static /* synthetic */ Condition zzl(zzad zzad) {
        return zzad.zzfko;
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zzfko.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return isConnected() ? ConnectionResult.zzffe : this.zzfkw != null ? this.zzfkw : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void connect() {
        this.zzfkd.lock();
        try {
            if (!this.zzfks) {
                this.zzfks = true;
                this.zzfkt = null;
                this.zzfku = null;
                this.zzfkv = null;
                this.zzfkw = null;
                this.zzfgu.zzafw();
                this.zzfgu.zza(this.zzfkj.values()).addOnCompleteListener(new zzbdy(this.zzakf), new zzaf(this));
                this.zzfkd.unlock();
            }
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void disconnect() {
        this.zzfkd.lock();
        try {
            this.zzfks = false;
            this.zzfkt = null;
            this.zzfku = null;
            if (this.zzfkv != null) {
                this.zzfkv.cancel();
                this.zzfkv = null;
            }
            this.zzfkw = null;
            while (!this.zzfkr.isEmpty()) {
                zzm<?, ?> remove = this.zzfkr.remove();
                remove.zza((zzdm) null);
                remove.cancel();
            }
            this.zzfko.signalAll();
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        return zzb(api.zzafe());
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final boolean isConnected() {
        this.zzfkd.lock();
        try {
            return this.zzfkt != null && this.zzfkw == null;
        } finally {
            this.zzfkd.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zzfkd.lock();
        try {
            return this.zzfkt == null && this.zzfks;
        } finally {
            this.zzfkd.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.gms.common.api.internal.zzcd
    public final boolean zza(zzcv zzcv) {
        this.zzfkd.lock();
        try {
            if (!this.zzfks || zzago()) {
                this.zzfkd.unlock();
                return false;
            }
            this.zzfgu.zzafw();
            this.zzfkv = new zzag(this, zzcv);
            this.zzfgu.zza(this.zzfkk.values()).addOnCompleteListener(new zzbdy(this.zzakf), this.zzfkv);
            this.zzfkd.unlock();
            return true;
        } catch (Throwable th) {
            this.zzfkd.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void zzafp() {
        this.zzfkd.lock();
        try {
            this.zzfgu.zzafp();
            if (this.zzfkv != null) {
                this.zzfkv.cancel();
                this.zzfkv = null;
            }
            if (this.zzfku == null) {
                this.zzfku = new ArrayMap(this.zzfkk.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (zzac<?> zzac : this.zzfkk.values()) {
                this.zzfku.put(zzac.zzafk(), connectionResult);
            }
            if (this.zzfkt != null) {
                this.zzfkt.putAll(this.zzfku);
            }
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void zzagi() {
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        if (this.zzfkp && zzg((zzad) t)) {
            return t;
        }
        if (!isConnected()) {
            this.zzfkr.add(t);
            return t;
        }
        this.zzfkm.zzfms.zzb(t);
        return (T) this.zzfkj.get(t.zzafe()).zza(t);
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        Api.zzc<A> zzafe = t.zzafe();
        if (this.zzfkp && zzg((zzad) t)) {
            return t;
        }
        this.zzfkm.zzfms.zzb(t);
        return (T) this.zzfkj.get(zzafe).zzb(t);
    }
}
