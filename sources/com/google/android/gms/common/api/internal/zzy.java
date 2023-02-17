package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzcps;
import com.google.android.gms.internal.zzcpt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
/* access modifiers changed from: package-private */
public final class zzy implements zzcd {
    private final Context mContext;
    private final Looper zzakf;
    private final zzbd zzfjt;
    private final zzbl zzfju;
    private final zzbl zzfjv;
    private final Map<Api.zzc<?>, zzbl> zzfjw;
    private final Set<zzcv> zzfjx = Collections.newSetFromMap(new WeakHashMap());
    private final Api.zze zzfjy;
    private Bundle zzfjz;
    private ConnectionResult zzfka = null;
    private ConnectionResult zzfkb = null;
    private boolean zzfkc = false;
    private final Lock zzfkd;
    private int zzfke = 0;

    private zzy(Context context, zzbd zzbd, Lock lock, Looper looper, zze zze, Map<Api.zzc<?>, Api.zze> map, Map<Api.zzc<?>, Api.zze> map2, zzq zzq, Api.zza<? extends zzcps, zzcpt> zza, Api.zze zze2, ArrayList<zzw> arrayList, ArrayList<zzw> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.mContext = context;
        this.zzfjt = zzbd;
        this.zzfkd = lock;
        this.zzakf = looper;
        this.zzfjy = zze2;
        this.zzfju = new zzbl(context, this.zzfjt, lock, looper, zze, map2, null, map4, null, arrayList2, new zzaa(this, null));
        this.zzfjv = new zzbl(context, this.zzfjt, lock, looper, zze, map, zzq, map3, zza, arrayList, new zzab(this, null));
        ArrayMap arrayMap = new ArrayMap();
        for (Api.zzc<?> zzc : map2.keySet()) {
            arrayMap.put(zzc, this.zzfju);
        }
        for (Api.zzc<?> zzc2 : map.keySet()) {
            arrayMap.put(zzc2, this.zzfjv);
        }
        this.zzfjw = Collections.unmodifiableMap(arrayMap);
    }

    public static zzy zza(Context context, zzbd zzbd, Lock lock, Looper looper, zze zze, Map<Api.zzc<?>, Api.zze> map, zzq zzq, Map<Api<?>, Boolean> map2, Api.zza<? extends zzcps, zzcpt> zza, ArrayList<zzw> arrayList) {
        Api.zze zze2 = null;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        for (Map.Entry<Api.zzc<?>, Api.zze> entry : map.entrySet()) {
            Api.zze value = entry.getValue();
            if (value.zzaal()) {
                zze2 = value;
            }
            if (value.zzaac()) {
                arrayMap.put(entry.getKey(), value);
            } else {
                arrayMap2.put(entry.getKey(), value);
            }
        }
        zzbp.zza(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api<?> api : map2.keySet()) {
            Api.zzc<?> zzafe = api.zzafe();
            if (arrayMap.containsKey(zzafe)) {
                arrayMap3.put(api, map2.get(api));
            } else if (arrayMap2.containsKey(zzafe)) {
                arrayMap4.put(api, map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<zzw> arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            zzw zzw = arrayList4.get(i);
            i++;
            zzw zzw2 = zzw;
            if (arrayMap3.containsKey(zzw2.zzfdf)) {
                arrayList2.add(zzw2);
            } else if (arrayMap4.containsKey(zzw2.zzfdf)) {
                arrayList3.add(zzw2);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zzy(context, zzbd, lock, looper, zze, arrayMap, arrayMap2, zzq, zza, zze2, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private final void zza(ConnectionResult connectionResult) {
        switch (this.zzfke) {
            case 2:
                this.zzfjt.zzc(connectionResult);
            case 1:
                zzagk();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        this.zzfke = 0;
    }

    /* access modifiers changed from: private */
    public final void zzagj() {
        if (zzb(this.zzfka)) {
            if (zzb(this.zzfkb) || zzagl()) {
                switch (this.zzfke) {
                    case 2:
                        this.zzfjt.zzj(this.zzfjz);
                    case 1:
                        zzagk();
                        break;
                    default:
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        break;
                }
                this.zzfke = 0;
            } else if (this.zzfkb == null) {
            } else {
                if (this.zzfke == 1) {
                    zzagk();
                    return;
                }
                zza(this.zzfkb);
                this.zzfju.disconnect();
            }
        } else if (this.zzfka != null && zzb(this.zzfkb)) {
            this.zzfjv.disconnect();
            zza(this.zzfka);
        } else if (this.zzfka != null && this.zzfkb != null) {
            ConnectionResult connectionResult = this.zzfka;
            if (this.zzfjv.zzfne < this.zzfju.zzfne) {
                connectionResult = this.zzfkb;
            }
            zza(connectionResult);
        }
    }

    private final void zzagk() {
        for (zzcv zzcv : this.zzfjx) {
            zzcv.zzaak();
        }
        this.zzfjx.clear();
    }

    private final boolean zzagl() {
        return this.zzfkb != null && this.zzfkb.getErrorCode() == 4;
    }

    private final PendingIntent zzagm() {
        if (this.zzfjy == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zzfjt), this.zzfjy.zzaam(), 134217728);
    }

    private static boolean zzb(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    /* access modifiers changed from: private */
    public final void zze(int i, boolean z) {
        this.zzfjt.zzf(i, z);
        this.zzfkb = null;
        this.zzfka = null;
    }

    private final boolean zzf(zzm<? extends Result, ? extends Api.zzb> zzm) {
        Api.zzc<? extends Api.zzb> zzafe = zzm.zzafe();
        zzbp.zzb(this.zzfjw.containsKey(zzafe), "GoogleApiClient is not configured to use the API required for this call.");
        return this.zzfjw.get(zzafe).equals(this.zzfjv);
    }

    /* access modifiers changed from: private */
    public final void zzi(Bundle bundle) {
        if (this.zzfjz == null) {
            this.zzfjz = bundle;
        } else if (bundle != null) {
            this.zzfjz.putAll(bundle);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void connect() {
        this.zzfke = 2;
        this.zzfkc = false;
        this.zzfkb = null;
        this.zzfka = null;
        this.zzfju.connect();
        this.zzfjv.connect();
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void disconnect() {
        this.zzfkb = null;
        this.zzfka = null;
        this.zzfke = 0;
        this.zzfju.disconnect();
        this.zzfjv.disconnect();
        zzagk();
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.zzfjv.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.zzfju.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final boolean isConnected() {
        this.zzfkd.lock();
        try {
            return this.zzfju.isConnected() && (this.zzfjv.isConnected() || zzagl() || this.zzfke == 1);
        } finally {
            this.zzfkd.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zzfkd.lock();
        try {
            return this.zzfke == 2;
        } finally {
            this.zzfkd.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.gms.common.api.internal.zzcd
    public final boolean zza(zzcv zzcv) {
        this.zzfkd.lock();
        try {
            if ((isConnecting() || isConnected()) && !this.zzfjv.isConnected()) {
                this.zzfjx.add(zzcv);
                if (this.zzfke == 0) {
                    this.zzfke = 1;
                }
                this.zzfkb = null;
                this.zzfjv.connect();
                this.zzfkd.unlock();
                return true;
            }
            this.zzfkd.unlock();
            return false;
        } catch (Throwable th) {
            this.zzfkd.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void zzafp() {
        this.zzfkd.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zzfjv.disconnect();
            this.zzfkb = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzakf).post(new zzz(this));
            } else {
                zzagk();
            }
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final void zzagi() {
        this.zzfju.zzagi();
        this.zzfjv.zzagi();
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        if (!zzf(t)) {
            return (T) this.zzfju.zzd(t);
        }
        if (!zzagl()) {
            return (T) this.zzfjv.zzd(t);
        }
        t.zzt(new Status(4, null, zzagm()));
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        if (!zzf(t)) {
            return (T) this.zzfju.zze(t);
        }
        if (!zzagl()) {
            return (T) this.zzfjv.zze(t);
        }
        t.zzt(new Status(4, null, zzagm()));
        return t;
    }
}
