package com.google.firebase.iid;

import android.content.Intent;
import android.os.ConditionVariable;
import android.util.Log;
import java.io.IOException;
/* access modifiers changed from: package-private */
public final class zzo implements zzp {
    private Intent intent;
    private final ConditionVariable zzmly;
    private String zzmlz;

    private zzo() {
        this.zzmly = new ConditionVariable();
    }

    /* synthetic */ zzo(zzm zzm) {
        this();
    }

    @Override // com.google.firebase.iid.zzp
    public final void onError(String str) {
        this.zzmlz = str;
        this.zzmly.open();
    }

    public final Intent zzbyr() {
        if (!this.zzmly.block(30000)) {
            Log.w("InstanceID/Rpc", "No response");
            throw new IOException("TIMEOUT");
        } else if (this.zzmlz == null) {
            return this.intent;
        } else {
            throw new IOException(this.zzmlz);
        }
    }

    @Override // com.google.firebase.iid.zzp
    public final void zzq(Intent intent2) {
        this.intent = intent2;
        this.zzmly.open();
    }
}
