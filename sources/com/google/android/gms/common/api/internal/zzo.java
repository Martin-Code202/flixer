package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.concurrent.atomic.AtomicReference;
public abstract class zzo extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean mStarted;
    protected final GoogleApiAvailability zzfhk;
    protected final AtomicReference<zzp> zzfiv;
    private final Handler zzfiw;

    protected zzo(zzcg zzcg) {
        this(zzcg, GoogleApiAvailability.getInstance());
    }

    private zzo(zzcg zzcg, GoogleApiAvailability googleApiAvailability) {
        super(zzcg);
        this.zzfiv = new AtomicReference<>(null);
        this.zzfiw = new Handler(Looper.getMainLooper());
        this.zzfhk = googleApiAvailability;
    }

    private static int zza(zzp zzp) {
        if (zzp == null) {
            return -1;
        }
        return zzp.zzagc();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        zzp zzp = this.zzfiv.get();
        switch (i) {
            case 1:
                if (i2 != -1) {
                    if (i2 == 0) {
                        int i3 = 13;
                        if (intent != null) {
                            i3 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                        }
                        zzp = new zzp(new ConnectionResult(i3, null), zza(zzp));
                        this.zzfiv.set(zzp);
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
                break;
            case 2:
                int isGooglePlayServicesAvailable = this.zzfhk.isGooglePlayServicesAvailable(getActivity());
                if (isGooglePlayServicesAvailable == 0) {
                    z = true;
                }
                if (zzp != null) {
                    if (zzp.zzagd().getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                        return;
                    }
                } else {
                    return;
                }
        }
        if (z) {
            zzagb();
        } else if (zzp != null) {
            zza(zzp.zzagd(), zzp.zzagc());
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        zza(new ConnectionResult(13, null), zza(this.zzfiv.get()));
        zzagb();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzfiv.set(bundle.getBoolean("resolving_error", false) ? new zzp(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zzp zzp = this.zzfiv.get();
        if (zzp != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zzp.zzagc());
            bundle.putInt("failed_status", zzp.zzagd().getErrorCode());
            bundle.putParcelable("failed_resolution", zzp.zzagd().getResolution());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    /* access modifiers changed from: protected */
    public abstract void zza(ConnectionResult connectionResult, int i);

    /* access modifiers changed from: protected */
    public abstract void zzafw();

    /* access modifiers changed from: protected */
    public final void zzagb() {
        this.zzfiv.set(null);
        zzafw();
    }

    public final void zzb(ConnectionResult connectionResult, int i) {
        zzp zzp = new zzp(connectionResult, i);
        if (this.zzfiv.compareAndSet(null, zzp)) {
            this.zzfiw.post(new zzq(this, zzp));
        }
    }
}
