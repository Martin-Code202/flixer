package com.google.android.gms.common.api.internal;

import android.app.Dialog;
final class zzr extends zzbz {
    private /* synthetic */ Dialog zzfjb;
    private /* synthetic */ zzq zzfjc;

    zzr(zzq zzq, Dialog dialog) {
        this.zzfjc = zzq;
        this.zzfjb = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zzbz
    public final void zzage() {
        this.zzfjc.zzfja.zzagb();
        if (this.zzfjb.isShowing()) {
            this.zzfjb.dismiss();
        }
    }
}
