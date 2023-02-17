package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcv;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
public final class zzb extends AsyncTaskLoader<Void> implements zzcv {
    private Semaphore zzecp = new Semaphore(0);
    private Set<GoogleApiClient> zzecq;

    public zzb(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.zzecq = set;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzaaj */
    public final Void loadInBackground() {
        int i = 0;
        for (GoogleApiClient googleApiClient : this.zzecq) {
            if (googleApiClient.zza(this)) {
                i++;
            }
        }
        try {
            this.zzecp.tryAcquire(i, 5, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.content.Loader
    public final void onStartLoading() {
        this.zzecp.drainPermits();
        forceLoad();
    }

    @Override // com.google.android.gms.common.api.internal.zzcv
    public final void zzaak() {
        this.zzecp.release();
    }
}
