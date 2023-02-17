package com.google.android.gms.internal;

import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
public final class zzccz implements zzccc {
    private /* synthetic */ zzccw zziuc;

    zzccz(zzccw zzccw) {
        this.zziuc = zzccw;
    }

    @Override // com.google.android.gms.internal.zzccc
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zziuc.zza(i, th, bArr);
    }
}
