package com.google.android.gms.internal;
public final class zzeid extends zzeha<zzeid> {
    private static volatile zzeid[] zznkg;
    public String zznkh = "";

    public zzeid() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public static zzeid[] zzcfa() {
        if (zznkg == null) {
            synchronized (zzehe.zzngo) {
                if (zznkg == null) {
                    zznkg = new zzeid[0];
                }
            }
        }
        return zznkg;
    }

    @Override // com.google.android.gms.internal.zzehg
    public final /* synthetic */ zzehg zza(zzegx zzegx) {
        while (true) {
            int zzcby = zzegx.zzcby();
            switch (zzcby) {
                case 0:
                    return this;
                case 10:
                    this.zznkh = zzegx.readString();
                    break;
                default:
                    if (super.zza(zzegx, zzcby)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final void zza(zzegy zzegy) {
        if (this.zznkh != null && !this.zznkh.equals("")) {
            zzegy.zzl(1, this.zznkh);
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        return (this.zznkh == null || this.zznkh.equals("")) ? zzn : zzn + zzegy.zzm(1, this.zznkh);
    }
}
