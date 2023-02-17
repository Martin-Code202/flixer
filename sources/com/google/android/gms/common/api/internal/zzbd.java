package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzbcr;
import com.google.android.gms.internal.zzcps;
import com.google.android.gms.internal.zzcpt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
public final class zzbd extends GoogleApiClient implements zzce {
    private final Context mContext;
    private final Looper zzakf;
    private final int zzfhi;
    private final GoogleApiAvailability zzfhk;
    private Api.zza<? extends zzcps, zzcpt> zzfhl;
    private boolean zzfho;
    private final Lock zzfkd;
    private zzq zzfki;
    private Map<Api<?>, Boolean> zzfkl;
    final Queue<zzm<?, ?>> zzfkr = new LinkedList();
    private final zzad zzfmf;
    private zzcd zzfmg = null;
    private volatile boolean zzfmh;
    private long zzfmi = 120000;
    private long zzfmj = 5000;
    private final zzbi zzfmk;
    private zzby zzfml;
    final Map<Api.zzc<?>, Api.zze> zzfmm;
    Set<Scope> zzfmn = new HashSet();
    private final zzcn zzfmo = new zzcn();
    private final ArrayList<zzw> zzfmp;
    private Integer zzfmq = null;
    Set<zzdg> zzfmr = null;
    final zzdj zzfms;
    private final zzae zzfmt = new zzbe(this);

    public zzbd(Context context, Lock lock, Looper looper, zzq zzq, GoogleApiAvailability googleApiAvailability, Api.zza<? extends zzcps, zzcpt> zza, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.zzc<?>, Api.zze> map2, int i, int i2, ArrayList<zzw> arrayList, boolean z) {
        this.mContext = context;
        this.zzfkd = lock;
        this.zzfho = false;
        this.zzfmf = new zzad(looper, this.zzfmt);
        this.zzakf = looper;
        this.zzfmk = new zzbi(this, looper);
        this.zzfhk = googleApiAvailability;
        this.zzfhi = i;
        if (this.zzfhi >= 0) {
            this.zzfmq = Integer.valueOf(i2);
        }
        this.zzfkl = map;
        this.zzfmm = map2;
        this.zzfmp = arrayList;
        this.zzfms = new zzdj(this.zzfmm);
        for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : list) {
            this.zzfmf.registerConnectionCallbacks(connectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : list2) {
            this.zzfmf.registerConnectionFailedListener(onConnectionFailedListener);
        }
        this.zzfki = zzq;
        this.zzfhl = zza;
    }

    /* access modifiers changed from: private */
    public final void resume() {
        this.zzfkd.lock();
        try {
            if (this.zzfmh) {
                zzahg();
            }
        } finally {
            this.zzfkd.unlock();
        }
    }

    public static int zza(Iterable<Api.zze> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.zze zze : iterable) {
            if (zze.zzaac()) {
                z2 = true;
            }
            if (zze.zzaal()) {
                z3 = true;
            }
        }
        if (z2) {
            return (!z3 || !z) ? 1 : 2;
        }
        return 3;
    }

    /* access modifiers changed from: private */
    public final void zza(GoogleApiClient googleApiClient, zzda zzda, boolean z) {
        zzbcr.zzfwg.zzd(googleApiClient).setResultCallback(new zzbh(this, zzda, z, googleApiClient));
    }

    private final void zzahg() {
        this.zzfmf.zzakg();
        this.zzfmg.connect();
    }

    /* access modifiers changed from: private */
    public final void zzahh() {
        this.zzfkd.lock();
        try {
            if (zzahi()) {
                zzahg();
            }
        } finally {
            this.zzfkd.unlock();
        }
    }

    private final void zzbt(int i) {
        if (this.zzfmq == null) {
            this.zzfmq = Integer.valueOf(i);
        } else if (this.zzfmq.intValue() != i) {
            String zzbu = zzbu(i);
            String zzbu2 = zzbu(this.zzfmq.intValue());
            throw new IllegalStateException(new StringBuilder(String.valueOf(zzbu2).length() + String.valueOf(zzbu).length() + 51).append("Cannot use sign-in mode: ").append(zzbu).append(". Mode was already set to ").append(zzbu2).toString());
        }
        if (this.zzfmg == null) {
            boolean z = false;
            boolean z2 = false;
            for (Api.zze zze : this.zzfmm.values()) {
                if (zze.zzaac()) {
                    z = true;
                }
                if (zze.zzaal()) {
                    z2 = true;
                }
            }
            switch (this.zzfmq.intValue()) {
                case 1:
                    if (!z) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (z2) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (z) {
                        if (this.zzfho) {
                            this.zzfmg = new zzad(this.mContext, this.zzfkd, this.zzakf, this.zzfhk, this.zzfmm, this.zzfki, this.zzfkl, this.zzfhl, this.zzfmp, this, true);
                            return;
                        } else {
                            this.zzfmg = zzy.zza(this.mContext, this, this.zzfkd, this.zzakf, this.zzfhk, this.zzfmm, this.zzfki, this.zzfkl, this.zzfhl, this.zzfmp);
                            return;
                        }
                    }
                    break;
            }
            if (!this.zzfho || z2) {
                this.zzfmg = new zzbl(this.mContext, this, this.zzfkd, this.zzakf, this.zzfhk, this.zzfmm, this.zzfki, this.zzfkl, this.zzfhl, this.zzfmp, this);
            } else {
                this.zzfmg = new zzad(this.mContext, this.zzfkd, this.zzakf, this.zzfhk, this.zzfmm, this.zzfki, this.zzfkl, this.zzfhl, this.zzfmp, this, false);
            }
        }
    }

    private static String zzbu(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect() {
        zzbp.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zzfkd.lock();
        try {
            if (this.zzfhi >= 0) {
                zzbp.zza(this.zzfmq != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzfmq == null) {
                this.zzfmq = Integer.valueOf(zza(this.zzfmm.values(), false));
            } else if (this.zzfmq.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbt(this.zzfmq.intValue());
            this.zzfmf.zzakg();
            return this.zzfmg.blockingConnect();
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzbp.zza(isConnected(), "GoogleApiClient is not connected yet.");
        zzbp.zza(this.zzfmq.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        zzda zzda = new zzda(this);
        if (this.zzfmm.containsKey(zzbcr.zzdwo)) {
            zza(this, zzda, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(zzbcr.API).addConnectionCallbacks(new zzbf(this, atomicReference, zzda)).addOnConnectionFailedListener(new zzbg(this, zzda)).setHandler(this.zzfmk).build();
            atomicReference.set(build);
            build.connect();
        }
        return zzda;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect() {
        this.zzfkd.lock();
        try {
            if (this.zzfhi >= 0) {
                zzbp.zza(this.zzfmq != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzfmq == null) {
                this.zzfmq = Integer.valueOf(zza(this.zzfmm.values(), false));
            } else if (this.zzfmq.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.zzfmq.intValue());
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect(int i) {
        this.zzfkd.lock();
        try {
            zzbp.zzb(i == 3 || i == 1 || i == 2, new StringBuilder(33).append("Illegal sign-in mode: ").append(i).toString());
            zzbt(i);
            zzahg();
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void disconnect() {
        this.zzfkd.lock();
        try {
            this.zzfms.release();
            if (this.zzfmg != null) {
                this.zzfmg.disconnect();
            }
            this.zzfmo.release();
            for (zzm<?, ?> zzm : this.zzfkr) {
                zzm.zza((zzdm) null);
                zzm.cancel();
            }
            this.zzfkr.clear();
            if (this.zzfmg != null) {
                zzahi();
                this.zzfmf.zzakf();
                this.zzfkd.unlock();
            }
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.mContext);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.zzfmh);
        printWriter.append(" mWorkQueue.size()=").print(this.zzfkr.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zzfms.zzfpr.size());
        if (this.zzfmg != null) {
            this.zzfmg.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return this.zzakf;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnected() {
        return this.zzfmg != null && this.zzfmg.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzfmf.registerConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzfmf.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <C extends Api.zze> C zza(Api.zzc<C> zzc) {
        C c = (C) this.zzfmm.get(zzc);
        zzbp.zzb(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zza(zzdg zzdg) {
        this.zzfkd.lock();
        try {
            if (this.zzfmr == null) {
                this.zzfmr = new HashSet();
            }
            this.zzfmr.add(zzdg);
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean zza(zzcv zzcv) {
        return this.zzfmg != null && this.zzfmg.zza(zzcv);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zzafp() {
        if (this.zzfmg != null) {
            this.zzfmg.zzafp();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzahi() {
        if (!this.zzfmh) {
            return false;
        }
        this.zzfmh = false;
        this.zzfmk.removeMessages(2);
        this.zzfmk.removeMessages(1);
        if (this.zzfml == null) {
            return true;
        }
        this.zzfml.unregister();
        this.zzfml = null;
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final boolean zzahj() {
        this.zzfkd.lock();
        try {
            if (this.zzfmr == null) {
                this.zzfkd.unlock();
                return false;
            }
            boolean z = !this.zzfmr.isEmpty();
            this.zzfkd.unlock();
            return z;
        } catch (Throwable th) {
            this.zzfkd.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzahk() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zzb(zzdg zzdg) {
        this.zzfkd.lock();
        try {
            if (this.zzfmr == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.zzfmr.remove(zzdg)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zzahj()) {
                this.zzfmg.zzagi();
            }
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzce
    public final void zzc(ConnectionResult connectionResult) {
        if (!zze.zze(this.mContext, connectionResult.getErrorCode())) {
            zzahi();
        }
        if (!this.zzfmh) {
            this.zzfmf.zzk(connectionResult);
            this.zzfmf.zzakf();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        zzbp.zzb(t.zzafe() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.zzfmm.containsKey(t.zzafe());
        String name = t.zzafj() != null ? t.zzafj().getName() : "the API";
        zzbp.zzb(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.zzfkd.lock();
        try {
            if (this.zzfmg == null) {
                this.zzfkr.add(t);
                return t;
            }
            T t2 = (T) this.zzfmg.zzd(t);
            this.zzfkd.unlock();
            return t2;
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        zzbp.zzb(t.zzafe() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.zzfmm.containsKey(t.zzafe());
        String name = t.zzafj() != null ? t.zzafj().getName() : "the API";
        zzbp.zzb(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.zzfkd.lock();
        try {
            if (this.zzfmg == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            } else if (this.zzfmh) {
                this.zzfkr.add(t);
                while (!this.zzfkr.isEmpty()) {
                    zzm<?, ?> remove = this.zzfkr.remove();
                    this.zzfms.zzb(remove);
                    remove.zzt(Status.zzfhw);
                }
                return t;
            } else {
                T t2 = (T) this.zzfmg.zze(t);
                this.zzfkd.unlock();
                return t2;
            }
        } finally {
            this.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzce
    public final void zzf(int i, boolean z) {
        if (i == 1 && !z && !this.zzfmh) {
            this.zzfmh = true;
            if (this.zzfml == null) {
                this.zzfml = GoogleApiAvailability.zza(this.mContext.getApplicationContext(), new zzbj(this));
            }
            this.zzfmk.sendMessageDelayed(this.zzfmk.obtainMessage(1), this.zzfmi);
            this.zzfmk.sendMessageDelayed(this.zzfmk.obtainMessage(2), this.zzfmj);
        }
        this.zzfms.zzair();
        this.zzfmf.zzce(i);
        this.zzfmf.zzakf();
        if (i == 2) {
            zzahg();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzce
    public final void zzj(Bundle bundle) {
        while (!this.zzfkr.isEmpty()) {
            zze(this.zzfkr.remove());
        }
        this.zzfmf.zzk(bundle);
    }
}
