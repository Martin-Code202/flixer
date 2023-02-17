package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzby;
import com.google.android.gms.internal.zzcps;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
public final class zzbr<O extends Api.ApiOptions> implements GoogleApiClient.OnConnectionFailedListener, zzx {
    private final zzh<O> zzfgr;
    private final Api.zze zzfkg;
    private boolean zzfmh;
    private /* synthetic */ zzbp zzfnt;
    private final Queue<zza> zzfnu = new LinkedList();
    private final Api.zzb zzfnv;
    private final zzah zzfnw;
    private final Set<zzj> zzfnx = new HashSet();
    private final Map<zzcl<?>, zzcs> zzfny = new HashMap();
    private final int zzfnz;
    private final zzcw zzfoa;
    private ConnectionResult zzfob = null;

    public zzbr(zzbp zzbp, GoogleApi<O> googleApi) {
        this.zzfnt = zzbp;
        this.zzfkg = googleApi.zza(zzbp.mHandler.getLooper(), this);
        if (this.zzfkg instanceof zzby) {
            this.zzfnv = zzby.zzakp();
        } else {
            this.zzfnv = this.zzfkg;
        }
        this.zzfgr = googleApi.zzafk();
        this.zzfnw = new zzah();
        this.zzfnz = googleApi.getInstanceId();
        if (this.zzfkg.zzaac()) {
            this.zzfoa = googleApi.zza(zzbp.mContext, zzbp.mHandler);
        } else {
            this.zzfoa = null;
        }
    }

    /* access modifiers changed from: private */
    public final void zzahu() {
        zzahx();
        zzi(ConnectionResult.zzffe);
        zzahz();
        for (zzcs zzcs : this.zzfny.values()) {
            try {
                zzcs.zzfic.zzb(this.zzfnv, new TaskCompletionSource<>());
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.zzfkg.disconnect();
            } catch (RemoteException unused2) {
            }
        }
        while (this.zzfkg.isConnected() && !this.zzfnu.isEmpty()) {
            zzb(this.zzfnu.remove());
        }
        zzaia();
    }

    /* access modifiers changed from: private */
    public final void zzahv() {
        zzahx();
        this.zzfmh = true;
        this.zzfnw.zzagu();
        this.zzfnt.mHandler.sendMessageDelayed(Message.obtain(this.zzfnt.mHandler, 9, this.zzfgr), this.zzfnt.zzfmj);
        this.zzfnt.mHandler.sendMessageDelayed(Message.obtain(this.zzfnt.mHandler, 11, this.zzfgr), this.zzfnt.zzfmi);
        this.zzfnt.zzfnn = -1;
    }

    private final void zzahz() {
        if (this.zzfmh) {
            this.zzfnt.mHandler.removeMessages(11, this.zzfgr);
            this.zzfnt.mHandler.removeMessages(9, this.zzfgr);
            this.zzfmh = false;
        }
    }

    private final void zzaia() {
        this.zzfnt.mHandler.removeMessages(12, this.zzfgr);
        this.zzfnt.mHandler.sendMessageDelayed(this.zzfnt.mHandler.obtainMessage(12, this.zzfgr), this.zzfnt.zzfnl);
    }

    private final void zzb(zza zza) {
        zza.zza(this.zzfnw, zzaac());
        try {
            zza.zza((zzbr<?>) this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.zzfkg.disconnect();
        }
    }

    private final void zzi(ConnectionResult connectionResult) {
        for (zzj zzj : this.zzfnx) {
            zzj.zza(this.zzfgr, connectionResult);
        }
        this.zzfnx.clear();
    }

    public final void connect() {
        zzbp.zza(this.zzfnt.mHandler);
        if (!this.zzfkg.isConnected() && !this.zzfkg.isConnecting()) {
            if (this.zzfkg.zzaff() && this.zzfnt.zzfnn != 0) {
                this.zzfnt.zzfnn = this.zzfnt.zzfhk.isGooglePlayServicesAvailable(this.zzfnt.mContext);
                if (this.zzfnt.zzfnn != 0) {
                    onConnectionFailed(new ConnectionResult(this.zzfnt.zzfnn, null));
                    return;
                }
            }
            zzbv zzbv = new zzbv(this.zzfnt, this.zzfkg, this.zzfgr);
            if (this.zzfkg.zzaac()) {
                this.zzfoa.zza(zzbv);
            }
            this.zzfkg.zza(zzbv);
        }
    }

    public final int getInstanceId() {
        return this.zzfnz;
    }

    /* access modifiers changed from: package-private */
    public final boolean isConnected() {
        return this.zzfkg.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        if (Looper.myLooper() == this.zzfnt.mHandler.getLooper()) {
            zzahu();
        } else {
            this.zzfnt.mHandler.post(new zzbs(this));
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbp.zza(this.zzfnt.mHandler);
        if (this.zzfoa != null) {
            this.zzfoa.zzain();
        }
        zzahx();
        this.zzfnt.zzfnn = -1;
        zzi(connectionResult);
        if (connectionResult.getErrorCode() == 4) {
            zzv(zzbp.zzfnk);
        } else if (this.zzfnu.isEmpty()) {
            this.zzfob = connectionResult;
        } else {
            synchronized (zzbp.zzaqc) {
                if (this.zzfnt.zzfnq != null && this.zzfnt.zzfnr.contains(this.zzfgr)) {
                    this.zzfnt.zzfnq.zzb(connectionResult, this.zzfnz);
                    return;
                }
            }
            if (!this.zzfnt.zzc(connectionResult, this.zzfnz)) {
                if (connectionResult.getErrorCode() == 18) {
                    this.zzfmh = true;
                }
                if (this.zzfmh) {
                    this.zzfnt.mHandler.sendMessageDelayed(Message.obtain(this.zzfnt.mHandler, 9, this.zzfgr), this.zzfnt.zzfmj);
                    return;
                }
                String zzafv = this.zzfgr.zzafv();
                zzv(new Status(17, new StringBuilder(String.valueOf(zzafv).length() + 38).append("API: ").append(zzafv).append(" is not available on this device.").toString()));
            }
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        if (Looper.myLooper() == this.zzfnt.mHandler.getLooper()) {
            zzahv();
        } else {
            this.zzfnt.mHandler.post(new zzbt(this));
        }
    }

    public final void resume() {
        zzbp.zza(this.zzfnt.mHandler);
        if (this.zzfmh) {
            connect();
        }
    }

    public final void signOut() {
        zzbp.zza(this.zzfnt.mHandler);
        zzv(zzbp.zzfnj);
        this.zzfnw.zzagt();
        for (zzcl<?> zzcl : this.zzfny.keySet()) {
            zza(new zzf(zzcl, new TaskCompletionSource()));
        }
        zzi(new ConnectionResult(4));
        this.zzfkg.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.zzx
    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (Looper.myLooper() == this.zzfnt.mHandler.getLooper()) {
            onConnectionFailed(connectionResult);
        } else {
            this.zzfnt.mHandler.post(new zzbu(this, connectionResult));
        }
    }

    public final void zza(zza zza) {
        zzbp.zza(this.zzfnt.mHandler);
        if (this.zzfkg.isConnected()) {
            zzb(zza);
            zzaia();
            return;
        }
        this.zzfnu.add(zza);
        if (this.zzfob == null || !this.zzfob.hasResolution()) {
            connect();
        } else {
            onConnectionFailed(this.zzfob);
        }
    }

    public final void zza(zzj zzj) {
        zzbp.zza(this.zzfnt.mHandler);
        this.zzfnx.add(zzj);
    }

    public final boolean zzaac() {
        return this.zzfkg.zzaac();
    }

    public final Api.zze zzagn() {
        return this.zzfkg;
    }

    public final void zzahh() {
        zzbp.zza(this.zzfnt.mHandler);
        if (this.zzfmh) {
            zzahz();
            zzv(this.zzfnt.zzfhk.isGooglePlayServicesAvailable(this.zzfnt.mContext) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
            this.zzfkg.disconnect();
        }
    }

    public final Map<zzcl<?>, zzcs> zzahw() {
        return this.zzfny;
    }

    public final void zzahx() {
        zzbp.zza(this.zzfnt.mHandler);
        this.zzfob = null;
    }

    public final ConnectionResult zzahy() {
        zzbp.zza(this.zzfnt.mHandler);
        return this.zzfob;
    }

    public final void zzaib() {
        zzbp.zza(this.zzfnt.mHandler);
        if (this.zzfkg.isConnected() && this.zzfny.size() == 0) {
            if (this.zzfnw.zzags()) {
                zzaia();
            } else {
                this.zzfkg.disconnect();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzcps zzaic() {
        if (this.zzfoa == null) {
            return null;
        }
        return this.zzfoa.zzaic();
    }

    public final void zzh(ConnectionResult connectionResult) {
        zzbp.zza(this.zzfnt.mHandler);
        this.zzfkg.disconnect();
        onConnectionFailed(connectionResult);
    }

    public final void zzv(Status status) {
        zzbp.zza(this.zzfnt.mHandler);
        for (zza zza : this.zzfnu) {
            zza.zzr(status);
        }
        this.zzfnu.clear();
    }
}
