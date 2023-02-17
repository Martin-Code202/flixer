package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzbp;
public final class zzamw {
    private final Context mApplicationContext;
    private final Context zzdou;

    public zzamw(Context context) {
        zzbp.zzu(context);
        Context applicationContext = context.getApplicationContext();
        zzbp.zzb(applicationContext, "Application context can't be null");
        this.mApplicationContext = applicationContext;
        this.zzdou = applicationContext;
    }

    public final Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public final Context zzwl() {
        return this.zzdou;
    }
}
