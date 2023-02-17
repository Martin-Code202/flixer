package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
public final class zzcf {
    private final Object zzfom;

    public final boolean zzaig() {
        return this.zzfom instanceof FragmentActivity;
    }

    public final boolean zzaih() {
        return this.zzfom instanceof Activity;
    }

    public final Activity zzaii() {
        return (Activity) this.zzfom;
    }

    public final FragmentActivity zzaij() {
        return (FragmentActivity) this.zzfom;
    }
}
