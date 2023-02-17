package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.ArraySet;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzcps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
public final class zzbp implements Handler.Callback {
    private static final Object zzaqc = new Object();
    public static final Status zzfnj = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zzfnk = new Status(4, "The user must be signed in to make this API call.");
    private static zzbp zzfnm;
    private final Context mContext;
    private final Handler mHandler;
    private final GoogleApiAvailability zzfhk;
    private final Map<zzh<?>, zzbr<?>> zzfkj = new ConcurrentHashMap(5, 0.75f, 1);
    private long zzfmi = 120000;
    private long zzfmj = 5000;
    private long zzfnl = 10000;
    private int zzfnn = -1;
    private final AtomicInteger zzfno = new AtomicInteger(1);
    private final AtomicInteger zzfnp = new AtomicInteger(0);
    private zzak zzfnq = null;
    private final Set<zzh<?>> zzfnr = new ArraySet();
    private final Set<zzh<?>> zzfns = new ArraySet();

    private zzbp(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.mContext = context;
        this.mHandler = new Handler(looper, this);
        this.zzfhk = googleApiAvailability;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
    }

    public static zzbp zzaho() {
        zzbp zzbp;
        synchronized (zzaqc) {
            com.google.android.gms.common.internal.zzbp.zzb(zzfnm, "Must guarantee manager is non-null before using getInstance");
            zzbp = zzfnm;
        }
        return zzbp;
    }

    public static void zzahp() {
        synchronized (zzaqc) {
            if (zzfnm != null) {
                zzbp zzbp = zzfnm;
                zzbp.zzfnp.incrementAndGet();
                zzbp.mHandler.sendMessageAtFrontOfQueue(zzbp.mHandler.obtainMessage(10));
            }
        }
    }

    private final void zzahr() {
        for (zzh<?> zzh : this.zzfns) {
            this.zzfkj.remove(zzh).signOut();
        }
        this.zzfns.clear();
    }

    private final void zzb(GoogleApi<?> googleApi) {
        zzh<?> zzafk = googleApi.zzafk();
        zzbr<?> zzbr = this.zzfkj.get(zzafk);
        if (zzbr == null) {
            zzbr = new zzbr<>(this, googleApi);
            this.zzfkj.put(zzafk, zzbr);
        }
        if (zzbr.zzaac()) {
            this.zzfns.add(zzafk);
        }
        zzbr.connect();
    }

    public static zzbp zzca(Context context) {
        zzbp zzbp;
        synchronized (zzaqc) {
            if (zzfnm == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                zzfnm = new zzbp(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            zzbp = zzfnm;
        }
        return zzbp;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.zzfnl = ((Boolean) message.obj).booleanValue() ? 10000 : 300000;
                this.mHandler.removeMessages(12);
                for (zzh<?> zzh : this.zzfkj.keySet()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(12, zzh), this.zzfnl);
                }
                return true;
            case 2:
                zzj zzj = (zzj) message.obj;
                for (zzh<?> zzh2 : zzj.zzafx()) {
                    zzbr<?> zzbr = this.zzfkj.get(zzh2);
                    if (zzbr == null) {
                        zzj.zza(zzh2, new ConnectionResult(13));
                        return true;
                    } else if (zzbr.isConnected()) {
                        zzj.zza(zzh2, ConnectionResult.zzffe);
                    } else if (zzbr.zzahy() != null) {
                        zzj.zza(zzh2, zzbr.zzahy());
                    } else {
                        zzbr.zza(zzj);
                    }
                }
                return true;
            case 3:
                for (zzbr<?> zzbr2 : this.zzfkj.values()) {
                    zzbr2.zzahx();
                    zzbr2.connect();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zzcq zzcq = (zzcq) message.obj;
                zzbr<?> zzbr3 = this.zzfkj.get(zzcq.zzfpa.zzafk());
                if (zzbr3 == null) {
                    zzb(zzcq.zzfpa);
                    zzbr3 = this.zzfkj.get(zzcq.zzfpa.zzafk());
                }
                if (!zzbr3.zzaac() || this.zzfnp.get() == zzcq.zzfoz) {
                    zzbr3.zza(zzcq.zzfoy);
                    return true;
                }
                zzcq.zzfoy.zzr(zzfnj);
                zzbr3.signOut();
                return true;
            case 5:
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                zzbr<?> zzbr4 = null;
                Iterator<zzbr<?>> it = this.zzfkj.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        zzbr<?> next = it.next();
                        if (next.getInstanceId() == i) {
                            zzbr4 = next;
                        }
                    }
                }
                if (zzbr4 != null) {
                    String errorString = this.zzfhk.getErrorString(connectionResult.getErrorCode());
                    String errorMessage = connectionResult.getErrorMessage();
                    zzbr4.zzv(new Status(17, new StringBuilder(String.valueOf(errorMessage).length() + String.valueOf(errorString).length() + 69).append("Error resolution was canceled by the user, original error message: ").append(errorString).append(": ").append(errorMessage).toString()));
                    return true;
                }
                Log.wtf("GoogleApiManager", new StringBuilder(76).append("Could not find API instance ").append(i).append(" while trying to fail enqueued calls.").toString(), new Exception());
                return true;
            case 6:
                if (!(this.mContext.getApplicationContext() instanceof Application)) {
                    return true;
                }
                zzk.zza((Application) this.mContext.getApplicationContext());
                zzk.zzafz().zza(new zzbq(this));
                if (zzk.zzafz().zzbd(true)) {
                    return true;
                }
                this.zzfnl = 300000;
                return true;
            case 7:
                zzb((GoogleApi) message.obj);
                return true;
            case 9:
                if (!this.zzfkj.containsKey(message.obj)) {
                    return true;
                }
                this.zzfkj.get(message.obj).resume();
                return true;
            case 10:
                zzahr();
                return true;
            case 11:
                if (!this.zzfkj.containsKey(message.obj)) {
                    return true;
                }
                this.zzfkj.get(message.obj).zzahh();
                return true;
            case 12:
                if (!this.zzfkj.containsKey(message.obj)) {
                    return true;
                }
                this.zzfkj.get(message.obj).zzaib();
                return true;
            default:
                Log.w("GoogleApiManager", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final PendingIntent zza(zzh<?> zzh, int i) {
        zzcps zzaic;
        zzbr<?> zzbr = this.zzfkj.get(zzh);
        if (zzbr == null || (zzaic = zzbr.zzaic()) == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, i, zzaic.zzaam(), 134217728);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<java.lang.Void> zza(java.lang.Iterable<? extends com.google.android.gms.common.api.GoogleApi<?>> r8) {
        /*
            r7 = this;
            com.google.android.gms.common.api.internal.zzj r3 = new com.google.android.gms.common.api.internal.zzj
            r3.<init>(r8)
            java.util.Iterator r4 = r8.iterator()
        L_0x0009:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x003d
            java.lang.Object r0 = r4.next()
            r5 = r0
            com.google.android.gms.common.api.GoogleApi r5 = (com.google.android.gms.common.api.GoogleApi) r5
            java.util.Map<com.google.android.gms.common.api.internal.zzh<?>, com.google.android.gms.common.api.internal.zzbr<?>> r0 = r7.zzfkj
            com.google.android.gms.common.api.internal.zzh r1 = r5.zzafk()
            java.lang.Object r0 = r0.get(r1)
            r6 = r0
            com.google.android.gms.common.api.internal.zzbr r6 = (com.google.android.gms.common.api.internal.zzbr) r6
            if (r6 == 0) goto L_0x002b
            boolean r0 = r6.isConnected()
            if (r0 != 0) goto L_0x003c
        L_0x002b:
            android.os.Handler r0 = r7.mHandler
            android.os.Handler r1 = r7.mHandler
            r2 = 2
            android.os.Message r1 = r1.obtainMessage(r2, r3)
            r0.sendMessage(r1)
            com.google.android.gms.tasks.Task r0 = r3.getTask()
            return r0
        L_0x003c:
            goto L_0x0009
        L_0x003d:
            r3.zzafy()
            com.google.android.gms.tasks.Task r0 = r3.getTask()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzbp.zza(java.lang.Iterable):com.google.android.gms.tasks.Task");
    }

    public final void zza(ConnectionResult connectionResult, int i) {
        if (!zzc(connectionResult, i)) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i, 0, connectionResult));
        }
    }

    public final void zza(GoogleApi<?> googleApi) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, googleApi));
    }

    public final <O extends Api.ApiOptions> void zza(GoogleApi<O> googleApi, int i, zzm<? extends Result, Api.zzb> zzm) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzcq(new zzc(i, zzm), this.zzfnp.get(), googleApi)));
    }

    public final void zza(zzak zzak) {
        synchronized (zzaqc) {
            if (this.zzfnq != zzak) {
                this.zzfnq = zzak;
                this.zzfnr.clear();
                this.zzfnr.addAll(zzak.zzagv());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzafp() {
        this.zzfnp.incrementAndGet();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(10));
    }

    public final void zzafw() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public final int zzahq() {
        return this.zzfno.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzak zzak) {
        synchronized (zzaqc) {
            if (this.zzfnq == zzak) {
                this.zzfnq = null;
                this.zzfnr.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(ConnectionResult connectionResult, int i) {
        return this.zzfhk.zza(this.mContext, connectionResult, i);
    }
}
