package com.google.android.gms.internal;
/* access modifiers changed from: package-private */
public abstract class zzcdu extends zzcdt {
    private boolean zzdod;

    zzcdu(zzccw zzccw) {
        super(zzccw);
        this.zzikh.zzb(this);
    }

    public final void initialize() {
        if (this.zzdod) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzuk();
        this.zzikh.zzazk();
        this.zzdod = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean isInitialized() {
        return this.zzdod;
    }

    /* access modifiers changed from: protected */
    public abstract void zzuk();

    /* access modifiers changed from: protected */
    public final void zzwk() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
