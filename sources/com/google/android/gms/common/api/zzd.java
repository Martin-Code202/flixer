package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zzcz;
import com.google.android.gms.common.api.internal.zzg;
public final class zzd {
    private Looper zzakf;
    private zzcz zzfgt;

    public final GoogleApi.zza zzafn() {
        if (this.zzfgt == null) {
            this.zzfgt = new zzg();
        }
        if (this.zzakf == null) {
            if (Looper.myLooper() != null) {
                this.zzakf = Looper.myLooper();
            } else {
                this.zzakf = Looper.getMainLooper();
            }
        }
        return new GoogleApi.zza(this.zzfgt, this.zzakf);
    }
}
