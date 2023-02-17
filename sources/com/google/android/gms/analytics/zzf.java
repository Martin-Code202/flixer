package com.google.android.gms.analytics;

import java.util.Comparator;
final class zzf implements Comparator<zzh> {
    zzf(zze zze) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzh zzh, zzh zzh2) {
        return zzh.getClass().getCanonicalName().compareTo(zzh2.getClass().getCanonicalName());
    }
}
