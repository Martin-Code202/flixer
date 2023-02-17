package com.google.android.gms.internal;
public abstract class zzams extends zzamr {
    private boolean zzdod;

    protected zzams(zzamu zzamu) {
        super(zzamu);
    }

    public final void initialize() {
        zzuk();
        this.zzdod = true;
    }

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
