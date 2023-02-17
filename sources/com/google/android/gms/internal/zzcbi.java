package com.google.android.gms.internal;

import java.util.Iterator;
/* access modifiers changed from: package-private */
public final class zzcbi implements Iterator<String> {
    private Iterator<String> zzino = this.zzinp.zzinn.keySet().iterator();
    private /* synthetic */ zzcbh zzinp;

    zzcbi(zzcbh zzcbh) {
        this.zzinp = zzcbh;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzino.hasNext();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzino.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
