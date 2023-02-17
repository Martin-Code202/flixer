package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzcps;
import com.google.android.gms.internal.zzcpt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
public final class zzbl implements zzcd, zzx {
    private final Context mContext;
    private Api.zza<? extends zzcps, zzcpt> zzfhl;
    final zzbd zzfjt;
    private final Lock zzfkd;
    private zzq zzfki;
    private Map<Api<?>, Boolean> zzfkl;
    private final zze zzfkn;
    final Map<Api.zzc<?>, Api.zze> zzfmm;
    private final Condition zzfmz;
    private final zzbn zzfna;
    final Map<Api.zzc<?>, ConnectionResult> zzfnb = new HashMap();
    private volatile zzbk zzfnc;
    private ConnectionResult zzfnd = null;
    int zzfne;
    final zzce zzfnf;

    public zzbl(Context context, zzbd zzbd, Lock lock, Looper looper, zze zze, Map<Api.zzc<?>, Api.zze> map, zzq zzq, Map<Api<?>, Boolean> map2, Api.zza<? extends zzcps, zzcpt> zza, ArrayList<zzw> arrayList, zzce zzce) {
        this.mContext = context;
        this.zzfkd = lock;
        this.zzfkn = zze;
        this.zzfmm = map;
        this.zzfki = zzq;
        this.zzfkl = map2;
        this.zzfhl = zza;
        this.zzfjt = zzbd;
        this.zzfnf = zzce;
        ArrayList<zzw> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            zzw zzw = arrayList2.get(i);
            i++;
            zzw.zza(this);
        }
        this.zzfna = new zzbn(this, looper);
        this.zzfmz = lock.newCondition();
        this.zzfnc = new zzbc(this);
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zzfmz.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return isConnected() ? ConnectionResult.zzffe : this.zzfnd != null ? this.zzfnd : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void connect() {
        this.zzfnc.connect();
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void disconnect() {
        if (this.zzfnc.disconnect()) {
            this.zzfnb.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.zzfnc);
        for (Api<?> api : this.zzfkl.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.getName()).println(":");
            this.zzfmm.get(api.zzafe()).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final boolean isConnected() {
        return this.zzfnc instanceof zzao;
    }

    public final boolean isConnecting() {
        return this.zzfnc instanceof zzar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zzfkd.lock();
        try {
            this.zzfnc.onConnected(bundle);
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zzfkd.lock();
        try {
            this.zzfnc.onConnectionSuspended(i);
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzx
    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        this.zzfkd.lock();
        try {
            this.zzfnc.zza(connectionResult, api, z);
        } finally {
            this.zzfkd.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbm zzbm) {
        this.zzfna.sendMessage(this.zzfna.obtainMessage(1, zzbm));
    }

    /* access modifiers changed from: package-private */
    public final void zza(RuntimeException runtimeException) {
        this.zzfna.sendMessage(this.zzfna.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final boolean zza(zzcv zzcv) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void zzafp() {
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void zzagi() {
        if (isConnected()) {
            ((zzao) this.zzfnc).zzagy();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzahl() {
        this.zzfkd.lock();
        try {
            this.zzfnc = new zzar(this, this.zzfki, this.zzfkl, this.zzfkn, this.zzfhl, this.zzfkd, this.mContext);
            this.zzfnc.begin();
            this.zzfmz.signalAll();
        } finally {
            this.zzfkd.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzahm() {
        this.zzfkd.lock();
        try {
            this.zzfjt.zzahi();
            this.zzfnc = new zzao(this);
            this.zzfnc.begin();
            this.zzfmz.signalAll();
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        t.zzagg();
        return (T) this.zzfnc.zzd(t);
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        t.zzagg();
        return (T) this.zzfnc.zze(t);
    }

    /* access modifiers changed from: package-private */
    public final void zzg(ConnectionResult connectionResult) {
        this.zzfkd.lock();
        try {
            this.zzfnd = connectionResult;
            this.zzfnc = new zzbc(this);
            this.zzfnc.begin();
            this.zzfmz.signalAll();
        } finally {
            this.zzfkd.unlock();
        }
    }
}
