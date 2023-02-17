package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzam;
import com.google.android.gms.common.internal.zzbs;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzcps;
import com.google.android.gms.internal.zzcpt;
import com.google.android.gms.internal.zzcqf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
public final class zzar implements zzbk {
    private final Context mContext;
    private final Api.zza<? extends zzcps, zzcpt> zzfhl;
    private final Lock zzfkd;
    private final zzq zzfki;
    private final Map<Api<?>, Boolean> zzfkl;
    private final zze zzfkn;
    private ConnectionResult zzfkw;
    private final zzbl zzflg;
    private int zzflj;
    private int zzflk = 0;
    private int zzfll;
    private final Bundle zzflm = new Bundle();
    private final Set<Api.zzc> zzfln = new HashSet();
    private zzcps zzflo;
    private boolean zzflp;
    private boolean zzflq;
    private boolean zzflr;
    private zzam zzfls;
    private boolean zzflt;
    private boolean zzflu;
    private ArrayList<Future<?>> zzflv = new ArrayList<>();

    public zzar(zzbl zzbl, zzq zzq, Map<Api<?>, Boolean> map, zze zze, Api.zza<? extends zzcps, zzcpt> zza, Lock lock, Context context) {
        this.zzflg = zzbl;
        this.zzfki = zzq;
        this.zzfkl = map;
        this.zzfkn = zze;
        this.zzfhl = zza;
        this.zzfkd = lock;
        this.mContext = context;
    }

    static /* synthetic */ void zza(zzar zzar, ConnectionResult connectionResult, Api api, boolean z) {
        zzar.zzb(connectionResult, api, z);
    }

    /* access modifiers changed from: public */
    private final void zza(zzcqf zzcqf) {
        if (zzbr(0)) {
            ConnectionResult zzagd = zzcqf.zzagd();
            if (zzagd.isSuccess()) {
                zzbs zzbcd = zzcqf.zzbcd();
                ConnectionResult zzagd2 = zzbcd.zzagd();
                if (!zzagd2.isSuccess()) {
                    String valueOf = String.valueOf(zzagd2);
                    Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                    zze(zzagd2);
                    return;
                }
                this.zzflr = true;
                this.zzfls = zzbcd.zzakm();
                this.zzflt = zzbcd.zzakn();
                this.zzflu = zzbcd.zzako();
                zzahb();
            } else if (zzd(zzagd)) {
                zzahd();
                zzahb();
            } else {
                zze(zzagd);
            }
        }
    }

    static /* synthetic */ boolean zza(zzar zzar, int i) {
        return zzar.zzbr(0);
    }

    /* access modifiers changed from: public */
    private final boolean zzaha() {
        this.zzfll--;
        if (this.zzfll > 0) {
            return false;
        }
        if (this.zzfll < 0) {
            Log.w("GoogleApiClientConnecting", this.zzflg.zzfjt.zzahk());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zze(new ConnectionResult(8, null));
            return false;
        } else if (this.zzfkw == null) {
            return true;
        } else {
            this.zzflg.zzfne = this.zzflj;
            zze(this.zzfkw);
            return false;
        }
    }

    private final void zzahb() {
        if (this.zzfll == 0) {
            if (!this.zzflq || this.zzflr) {
                ArrayList arrayList = new ArrayList();
                this.zzflk = 1;
                this.zzfll = this.zzflg.zzfmm.size();
                for (Api.zzc<?> zzc : this.zzflg.zzfmm.keySet()) {
                    if (!this.zzflg.zzfnb.containsKey(zzc)) {
                        arrayList.add(this.zzflg.zzfmm.get(zzc));
                    } else if (zzaha()) {
                        zzahc();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.zzflv.add(zzbo.zzahn().submit(new zzax(this, arrayList)));
                }
            }
        }
    }

    private final void zzahc() {
        this.zzflg.zzahm();
        zzbo.zzahn().execute(new zzas(this));
        if (this.zzflo != null) {
            if (this.zzflt) {
                this.zzflo.zza(this.zzfls, this.zzflu);
            }
            zzbf(false);
        }
        for (Api.zzc<?> zzc : this.zzflg.zzfnb.keySet()) {
            this.zzflg.zzfmm.get(zzc).disconnect();
        }
        this.zzflg.zzfnf.zzj(this.zzflm.isEmpty() ? null : this.zzflm);
    }

    private final void zzahd() {
        this.zzflq = false;
        this.zzflg.zzfjt.zzfmn = Collections.emptySet();
        for (Api.zzc<?> zzc : this.zzfln) {
            if (!this.zzflg.zzfnb.containsKey(zzc)) {
                this.zzflg.zzfnb.put(zzc, new ConnectionResult(17, null));
            }
        }
    }

    private final void zzahe() {
        ArrayList<Future<?>> arrayList = this.zzflv;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Future<?> future = arrayList.get(i);
            i++;
            future.cancel(true);
        }
        this.zzflv.clear();
    }

    private final Set<Scope> zzahf() {
        if (this.zzfki == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.zzfki.zzajs());
        Map<Api<?>, zzs> zzaju = this.zzfki.zzaju();
        for (Api<?> api : zzaju.keySet()) {
            if (!this.zzflg.zzfnb.containsKey(api.zzafe())) {
                hashSet.addAll(zzaju.get(api).zzecl);
            }
        }
        return hashSet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        if ((r10.hasResolution() ? true : r9.zzfkn.zzbn(r10.getErrorCode()) != null) != false) goto L_0x0029;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(com.google.android.gms.common.ConnectionResult r10, com.google.android.gms.common.api.Api<?> r11, boolean r12) {
        /*
            r9 = this;
            com.google.android.gms.common.api.Api$zzd r0 = r11.zzafc()
            int r2 = r0.getPriority()
            r6 = r10
            r5 = r12
            r4 = r2
            r3 = r9
            if (r5 == 0) goto L_0x0029
            r8 = r6
            r7 = r3
            boolean r0 = r8.hasResolution()
            if (r0 == 0) goto L_0x0018
            r0 = 1
            goto L_0x0027
        L_0x0018:
            com.google.android.gms.common.zze r0 = r7.zzfkn
            int r1 = r8.getErrorCode()
            android.content.Intent r0 = r0.zzbn(r1)
            if (r0 == 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            if (r0 == 0) goto L_0x0033
        L_0x0029:
            com.google.android.gms.common.ConnectionResult r0 = r3.zzfkw
            if (r0 == 0) goto L_0x0031
            int r0 = r3.zzflj
            if (r4 >= r0) goto L_0x0033
        L_0x0031:
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            if (r0 == 0) goto L_0x003a
            r9.zzfkw = r10
            r9.zzflj = r2
        L_0x003a:
            com.google.android.gms.common.api.internal.zzbl r0 = r9.zzflg
            java.util.Map<com.google.android.gms.common.api.Api$zzc<?>, com.google.android.gms.common.ConnectionResult> r0 = r0.zzfnb
            com.google.android.gms.common.api.Api$zzc r1 = r11.zzafe()
            r0.put(r1, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzar.zzb(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    private final void zzbf(boolean z) {
        if (this.zzflo != null) {
            if (this.zzflo.isConnected() && z) {
                this.zzflo.zzbbw();
            }
            this.zzflo.disconnect();
            this.zzfls = null;
        }
    }

    private final boolean zzbr(int i) {
        if (this.zzflk == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.zzflg.zzfjt.zzahk());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", new StringBuilder(33).append("mRemainingConnections=").append(this.zzfll).toString());
        String zzbs = zzbs(this.zzflk);
        String zzbs2 = zzbs(i);
        Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(zzbs2).length() + String.valueOf(zzbs).length() + 70).append("GoogleApiClient connecting is in step ").append(zzbs).append(" but received callback for step ").append(zzbs2).toString(), new Exception());
        zze(new ConnectionResult(8, null));
        return false;
    }

    private static String zzbs(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private final boolean zzd(ConnectionResult connectionResult) {
        return this.zzflp && !connectionResult.hasResolution();
    }

    private final void zze(ConnectionResult connectionResult) {
        zzahe();
        zzbf(!connectionResult.hasResolution());
        this.zzflg.zzg(connectionResult);
        this.zzflg.zzfnf.zzc(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void begin() {
        this.zzflg.zzfnb.clear();
        this.zzflq = false;
        this.zzfkw = null;
        this.zzflk = 0;
        this.zzflp = true;
        this.zzflr = false;
        this.zzflt = false;
        boolean z = false;
        HashMap hashMap = new HashMap();
        for (Api<?> api : this.zzfkl.keySet()) {
            Api.zze zze = this.zzflg.zzfmm.get(api.zzafe());
            z |= api.zzafc().getPriority() == 1;
            boolean booleanValue = this.zzfkl.get(api).booleanValue();
            if (zze.zzaac()) {
                this.zzflq = true;
                if (booleanValue) {
                    this.zzfln.add(api.zzafe());
                } else {
                    this.zzflp = false;
                }
            }
            hashMap.put(zze, new zzat(this, api, booleanValue));
        }
        if (z) {
            this.zzflq = false;
        }
        if (this.zzflq) {
            this.zzfki.zzc(Integer.valueOf(System.identityHashCode(this.zzflg.zzfjt)));
            zzba zzba = new zzba(this, null);
            this.zzflo = (zzcps) this.zzfhl.zza(this.mContext, this.zzflg.zzfjt.getLooper(), this.zzfki, this.zzfki.zzajy(), zzba, zzba);
        }
        this.zzfll = this.zzflg.zzfmm.size();
        this.zzflv.add(zzbo.zzahn().submit(new zzau(this, hashMap)));
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void connect() {
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final boolean disconnect() {
        zzahe();
        zzbf(true);
        this.zzflg.zzg(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void onConnected(Bundle bundle) {
        if (zzbr(1)) {
            if (bundle != null) {
                this.zzflm.putAll(bundle);
            }
            if (zzaha()) {
                zzahc();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void onConnectionSuspended(int i) {
        zze(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (zzbr(1)) {
            zzb(connectionResult, api, z);
            if (zzaha()) {
                zzahc();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        this.zzflg.zzfjt.zzfkr.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
