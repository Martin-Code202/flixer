package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
/* access modifiers changed from: package-private */
public final class zzq implements Runnable {
    private final zzp zzfiz;
    final /* synthetic */ zzo zzfja;

    zzq(zzo zzo, zzp zzp) {
        this.zzfja = zzo;
        this.zzfiz = zzp;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzfja.mStarted) {
            ConnectionResult zzagd = this.zzfiz.zzagd();
            if (zzagd.hasResolution()) {
                this.zzfja.zzfon.startActivityForResult(GoogleApiActivity.zza(this.zzfja.getActivity(), zzagd.getResolution(), this.zzfiz.zzagc(), false), 1);
            } else if (this.zzfja.zzfhk.isUserResolvableError(zzagd.getErrorCode())) {
                this.zzfja.zzfhk.zza(this.zzfja.getActivity(), this.zzfja.zzfon, zzagd.getErrorCode(), 2, this.zzfja);
            } else if (zzagd.getErrorCode() == 18) {
                GoogleApiAvailability.zza(this.zzfja.getActivity().getApplicationContext(), new zzr(this, GoogleApiAvailability.zza(this.zzfja.getActivity(), this.zzfja)));
            } else {
                this.zzfja.zza(zzagd, this.zzfiz.zzagc());
            }
        }
    }
}
