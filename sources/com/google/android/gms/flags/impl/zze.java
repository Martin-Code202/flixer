package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* access modifiers changed from: package-private */
public final class zze implements Callable<Integer> {
    private /* synthetic */ SharedPreferences zzhbb;
    private /* synthetic */ String zzhbc;
    private /* synthetic */ Integer zzhbe;

    zze(SharedPreferences sharedPreferences, String str, Integer num) {
        this.zzhbb = sharedPreferences;
        this.zzhbc = str;
        this.zzhbe = num;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Integer call() {
        return Integer.valueOf(this.zzhbb.getInt(this.zzhbc, this.zzhbe.intValue()));
    }
}
