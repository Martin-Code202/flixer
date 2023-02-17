package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
final class zzag implements OnCompleteListener<Void> {
    private /* synthetic */ zzad zzfkx;
    private zzcv zzfky;

    zzag(zzad zzad, zzcv zzcv) {
        this.zzfkx = zzad;
        this.zzfky = zzcv;
    }

    /* access modifiers changed from: package-private */
    public final void cancel() {
        this.zzfky.zzaak();
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Void> task) {
        this.zzfkx.zzfkd.lock();
        try {
            if (!zzad.zzb(this.zzfkx)) {
                this.zzfky.zzaak();
                return;
            }
            if (task.isSuccessful()) {
                this.zzfkx.zzfku = new ArrayMap(this.zzfkx.zzfkk.size());
                for (zzac zzac : this.zzfkx.zzfkk.values()) {
                    zzad.zzg(this.zzfkx).put(zzac.zzafk(), ConnectionResult.zzffe);
                }
            } else if (task.getException() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) task.getException();
                if (zzad.zze(this.zzfkx)) {
                    this.zzfkx.zzfku = new ArrayMap(this.zzfkx.zzfkk.size());
                    for (zzac zzac2 : this.zzfkx.zzfkk.values()) {
                        zzh zzafk = zzac2.zzafk();
                        ConnectionResult connectionResult = availabilityException.getConnectionResult(zzac2);
                        if (this.zzfkx.zza((zzad) zzac2, (zzac) connectionResult)) {
                            zzad.zzg(this.zzfkx).put(zzafk, new ConnectionResult(16));
                        } else {
                            zzad.zzg(this.zzfkx).put(zzafk, connectionResult);
                        }
                    }
                } else {
                    this.zzfkx.zzfku = availabilityException.zzafh();
                }
            } else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                this.zzfkx.zzfku = Collections.emptyMap();
            }
            if (this.zzfkx.isConnected()) {
                zzad.zzd(this.zzfkx).putAll(zzad.zzg(this.zzfkx));
                if (zzad.zzf(this.zzfkx) == null) {
                    zzad.zzi(this.zzfkx);
                    zzad.zzj(this.zzfkx);
                    zzad.zzl(this.zzfkx).signalAll();
                }
            }
            this.zzfky.zzaak();
            this.zzfkx.zzfkd.unlock();
        } finally {
            this.zzfkx.zzfkd.unlock();
        }
    }
}
