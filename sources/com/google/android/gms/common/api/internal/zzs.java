package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzap;
import com.google.android.gms.common.internal.zzbp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
public abstract class zzs<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> zzfjd = new zzt();
    private Status mStatus;
    private boolean zzaj;
    private final CountDownLatch zzaoe;
    private R zzfhq;
    private final Object zzfje;
    private zzu<R> zzfjf;
    private WeakReference<GoogleApiClient> zzfjg;
    private final ArrayList<PendingResult.zza> zzfjh;
    private ResultCallback<? super R> zzfji;
    private final AtomicReference<zzdm> zzfjj;
    private zzv zzfjk;
    private volatile boolean zzfjl;
    private boolean zzfjm;
    private zzap zzfjn;
    private volatile zzdg<R> zzfjo;
    private boolean zzfjp;

    @Deprecated
    zzs() {
        this.zzfje = new Object();
        this.zzaoe = new CountDownLatch(1);
        this.zzfjh = new ArrayList<>();
        this.zzfjj = new AtomicReference<>();
        this.zzfjp = false;
        this.zzfjf = new zzu<>(Looper.getMainLooper());
        this.zzfjg = new WeakReference<>(null);
    }

    protected zzs(GoogleApiClient googleApiClient) {
        this.zzfje = new Object();
        this.zzaoe = new CountDownLatch(1);
        this.zzfjh = new ArrayList<>();
        this.zzfjj = new AtomicReference<>();
        this.zzfjp = false;
        this.zzfjf = new zzu<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zzfjg = new WeakReference<>(googleApiClient);
    }

    private final R get() {
        R r;
        synchronized (this.zzfje) {
            zzbp.zza(!this.zzfjl, "Result has already been consumed.");
            zzbp.zza(isReady(), "Result is not ready.");
            r = this.zzfhq;
            this.zzfhq = null;
            this.zzfji = null;
            this.zzfjl = true;
        }
        zzdm andSet = this.zzfjj.getAndSet(null);
        if (andSet != null) {
            andSet.zzc(this);
        }
        return r;
    }

    private final void zzc(R r) {
        this.zzfhq = r;
        this.zzfjn = null;
        this.zzaoe.countDown();
        this.mStatus = this.zzfhq.getStatus();
        if (this.zzaj) {
            this.zzfji = null;
        } else if (this.zzfji != null) {
            this.zzfjf.removeMessages(2);
            this.zzfjf.zza(this.zzfji, get());
        } else if (this.zzfhq instanceof Releasable) {
            this.zzfjk = new zzv(this, null);
        }
        ArrayList<PendingResult.zza> arrayList = this.zzfjh;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PendingResult.zza zza = arrayList.get(i);
            i++;
            zza.zzq(this.mStatus);
        }
        this.zzfjh.clear();
    }

    public static void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        synchronized (this.zzfje) {
            if (!this.zzaj && !this.zzfjl) {
                if (this.zzfjn != null) {
                    try {
                        this.zzfjn.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                zzd(this.zzfhq);
                this.zzaj = true;
                zzc(zzb(Status.zzfhy));
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzfje) {
            z = this.zzaj;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzaoe.getCount() == 0;
    }

    public final void setResult(R r) {
        synchronized (this.zzfje) {
            if (this.zzfjm || this.zzaj) {
                zzd(r);
                return;
            }
            if (isReady()) {
            }
            zzbp.zza(!isReady(), "Results have already been set");
            zzbp.zza(!this.zzfjl, "Result has already been consumed");
            zzc(r);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        synchronized (this.zzfje) {
            if (resultCallback == null) {
                this.zzfji = null;
                return;
            }
            zzbp.zza(!this.zzfjl, "Result has already been consumed.");
            zzbp.zza(this.zzfjo == null, "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.zzfjf.zza(resultCallback, get());
                } else {
                    this.zzfji = resultCallback;
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        synchronized (this.zzfje) {
            if (resultCallback == null) {
                this.zzfji = null;
                return;
            }
            zzbp.zza(!this.zzfjl, "Result has already been consumed.");
            zzbp.zza(this.zzfjo == null, "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.zzfjf.zza(resultCallback, get());
                } else {
                    this.zzfji = resultCallback;
                    zzu<R> zzu = this.zzfjf;
                    zzu.sendMessageDelayed(zzu.obtainMessage(2, this), timeUnit.toMillis(j));
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void zza(PendingResult.zza zza) {
        zzbp.zzb(zza != null, "Callback cannot be null.");
        synchronized (this.zzfje) {
            if (isReady()) {
                zza.zzq(this.mStatus);
            } else {
                this.zzfjh.add(zza);
            }
        }
    }

    public final void zza(zzdm zzdm) {
        this.zzfjj.set(zzdm);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final Integer zzafs() {
        return null;
    }

    public final boolean zzagf() {
        boolean isCanceled;
        synchronized (this.zzfje) {
            if (this.zzfjg.get() == null || !this.zzfjp) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zzagg() {
        this.zzfjp = this.zzfjp || zzfjd.get().booleanValue();
    }

    public abstract R zzb(Status status);

    public final void zzu(Status status) {
        synchronized (this.zzfje) {
            if (!isReady()) {
                setResult(zzb(status));
                this.zzfjm = true;
            }
        }
    }
}
