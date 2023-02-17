package com.google.android.gms.common.api.internal;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
public final class zzcn {
    private final Set<zzcj<?>> zzeuj = Collections.newSetFromMap(new WeakHashMap());

    public final void release() {
        for (zzcj<?> zzcj : this.zzeuj) {
            zzcj.clear();
        }
        this.zzeuj.clear();
    }
}
