package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* access modifiers changed from: package-private */
public final class zzk implements Callable<SharedPreferences> {
    private /* synthetic */ Context zzanz;

    zzk(Context context) {
        this.zzanz = context;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ SharedPreferences call() {
        return this.zzanz.getSharedPreferences("google_sdk_flags", 0);
    }
}
