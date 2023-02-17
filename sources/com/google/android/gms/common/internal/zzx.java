package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.zzcg;
/* access modifiers changed from: package-private */
public final class zzx extends zzu {
    private /* synthetic */ Intent val$intent;
    private /* synthetic */ int val$requestCode;
    private /* synthetic */ zzcg zzftw;

    zzx(Intent intent, zzcg zzcg, int i) {
        this.val$intent = intent;
        this.zzftw = zzcg;
        this.val$requestCode = i;
    }

    @Override // com.google.android.gms.common.internal.zzu
    public final void zzakb() {
        if (this.val$intent != null) {
            this.zzftw.startActivityForResult(this.val$intent, this.val$requestCode);
        }
    }
}
