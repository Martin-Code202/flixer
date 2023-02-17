package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzbp;
import java.io.FileDescriptor;
import java.io.PrintWriter;
public class zzi extends zzo {
    private final SparseArray<zza> zzfij = new SparseArray<>();

    /* access modifiers changed from: package-private */
    public class zza implements GoogleApiClient.OnConnectionFailedListener {
        public final int zzfik;
        public final GoogleApiClient zzfil;
        public final GoogleApiClient.OnConnectionFailedListener zzfim;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zzfik = i;
            this.zzfil = googleApiClient;
            this.zzfim = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
            zzi.this.zzb(connectionResult, this.zzfik);
        }
    }

    private zzi(zzcg zzcg) {
        super(zzcg);
        this.zzfon.zza("AutoManageHelper", this);
    }

    public static zzi zza(zzcf zzcf) {
        zzcg zzb = zzb(zzcf);
        zzi zzi = (zzi) zzb.zza("AutoManageHelper", zzi.class);
        return zzi != null ? zzi : new zzi(zzb);
    }

    private final zza zzbq(int i) {
        if (this.zzfij.size() <= i) {
            return null;
        }
        return this.zzfij.get(this.zzfij.keyAt(i));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.zzfij.size(); i++) {
            zza zzbq = zzbq(i);
            if (zzbq != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(zzbq.zzfik);
                printWriter.println(":");
                zzbq.zzfil.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzo, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(this.zzfij);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf).toString());
        if (this.zzfiv.get() == null) {
            for (int i = 0; i < this.zzfij.size(); i++) {
                zza zzbq = zzbq(i);
                if (zzbq != null) {
                    zzbq.zzfil.connect();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzo, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        for (int i = 0; i < this.zzfij.size(); i++) {
            zza zzbq = zzbq(i);
            if (zzbq != null) {
                zzbq.zzfil.disconnect();
            }
        }
    }

    public final void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzbp.zzb(googleApiClient, "GoogleApiClient instance cannot be null");
        zzbp.zza(this.zzfij.indexOfKey(i) < 0, new StringBuilder(54).append("Already managing a GoogleApiClient with id ").append(i).toString());
        zzp zzp = (zzp) this.zzfiv.get();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(zzp);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 49).append("starting AutoManage for client ").append(i).append(" ").append(z).append(" ").append(valueOf).toString());
        this.zzfij.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && zzp == null) {
            String valueOf2 = String.valueOf(googleApiClient);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf2).length() + 11).append("connecting ").append(valueOf2).toString());
            googleApiClient.connect();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzo
    public final void zza(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zza zza2 = this.zzfij.get(i);
        if (zza2 != null) {
            zzbp(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zza2.zzfim;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzo
    public final void zzafw() {
        for (int i = 0; i < this.zzfij.size(); i++) {
            zza zzbq = zzbq(i);
            if (zzbq != null) {
                zzbq.zzfil.connect();
            }
        }
    }

    public final void zzbp(int i) {
        zza zza2 = this.zzfij.get(i);
        this.zzfij.remove(i);
        if (zza2 != null) {
            zza2.zzfil.unregisterConnectionFailedListener(zza2);
            zza2.zzfil.disconnect();
        }
    }
}
