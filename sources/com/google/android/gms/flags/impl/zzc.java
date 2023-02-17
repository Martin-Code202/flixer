package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* access modifiers changed from: package-private */
public final class zzc implements Callable<Boolean> {
    private /* synthetic */ SharedPreferences zzhbb;
    private /* synthetic */ String zzhbc;
    private /* synthetic */ Boolean zzhbd;

    zzc(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.zzhbb = sharedPreferences;
        this.zzhbc = str;
        this.zzhbd = bool;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() {
        return Boolean.valueOf(this.zzhbb.getBoolean(this.zzhbc, this.zzhbd.booleanValue()));
    }
}
