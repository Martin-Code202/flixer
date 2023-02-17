package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
final class zzaf implements OnCompleteListener<Void> {
    private /* synthetic */ zzad zzfkx;

    private zzaf(zzad zzad) {
        this.zzfkx = zzad;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Void> task) {
        this.zzfkx.zzfkd.lock();
        try {
            if (zzad.zzb(this.zzfkx)) {
                if (task.isSuccessful()) {
                    this.zzfkx.zzfkt = new ArrayMap(zzad.zzc(this.zzfkx).size());
                    for (zzac zzac : zzad.zzc(this.zzfkx).values()) {
                        zzad.zzd(this.zzfkx).put(zzac.zzafk(), ConnectionResult.zzffe);
                    }
                } else if (task.getException() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.getException();
                    if (zzad.zze(this.zzfkx)) {
                        this.zzfkx.zzfkt = new ArrayMap(zzad.zzc(this.zzfkx).size());
                        for (zzac zzac2 : zzad.zzc(this.zzfkx).values()) {
                            zzh zzafk = zzac2.zzafk();
                            ConnectionResult connectionResult = availabilityException.getConnectionResult(zzac2);
                            if (this.zzfkx.zza((zzad) zzac2, (zzac) connectionResult)) {
                                zzad.zzd(this.zzfkx).put(zzafk, new ConnectionResult(16));
                            } else {
                                zzad.zzd(this.zzfkx).put(zzafk, connectionResult);
                            }
                        }
                    } else {
                        this.zzfkx.zzfkt = availabilityException.zzafh();
                    }
                    this.zzfkx.zzfkw = zzad.zzf(this.zzfkx);
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                    this.zzfkx.zzfkt = Collections.emptyMap();
                    this.zzfkx.zzfkw = new ConnectionResult(8);
                }
                if (zzad.zzg(this.zzfkx) != null) {
                    zzad.zzd(this.zzfkx).putAll(zzad.zzg(this.zzfkx));
                    this.zzfkx.zzfkw = zzad.zzf(this.zzfkx);
                }
                if (zzad.zzh(this.zzfkx) == null) {
                    zzad.zzi(this.zzfkx);
                    zzad.zzj(this.zzfkx);
                } else {
                    zzad.zza(this.zzfkx, false);
                    zzad.zzk(this.zzfkx).zzc(zzad.zzh(this.zzfkx));
                }
                zzad.zzl(this.zzfkx).signalAll();
                this.zzfkx.zzfkd.unlock();
            }
        } finally {
            this.zzfkx.zzfkd.unlock();
        }
    }
}
