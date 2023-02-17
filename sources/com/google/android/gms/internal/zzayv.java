package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.zzd;
public abstract class zzayv extends zzazd {
    private Handler mHandler = new Handler(Looper.getMainLooper());
    protected final zzd zzasb;
    private long zzfan;
    private Runnable zzfao;
    protected boolean zzfap;

    public zzayv(String str, zzd zzd, String str2, String str3, long j) {
        super(str, str2, str3);
        this.zzasb = zzd;
        this.zzfao = new zzayx(this);
        this.zzfan = 1000;
        zzbb(false);
    }

    @Override // com.google.android.gms.internal.zzazd
    public void zzaee() {
        zzbb(false);
    }

    /* access modifiers changed from: protected */
    public final void zzbb(boolean z) {
        if (this.zzfap != z) {
            this.zzfap = z;
            if (z) {
                this.mHandler.postDelayed(this.zzfao, this.zzfan);
            } else {
                this.mHandler.removeCallbacks(this.zzfao);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzz(long j);
}
