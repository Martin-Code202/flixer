package com.google.android.gms.internal;
public final class zzeie extends zzeha<zzeie> {
    public long zzgcb = 0;
    public String zznkh = "";
    public String zznki = "";
    public long zznkj = 0;
    public String zznkk = "";
    public long zznkl = 0;
    public String zznkm = "";
    public String zznkn = "";
    public String zznko = "";
    public String zznkp = "";
    public String zznkq = "";
    public int zznkr = 0;
    public zzeid[] zznks = zzeid.zzcfa();

    public zzeie() {
        this.zzngg = null;
        this.zzngp = -1;
    }

    public static zzeie zzaz(byte[] bArr) {
        return (zzeie) zzehg.zza(new zzeie(), bArr);
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
                case 18:
                    this.zznki = zzegx.readString();
                    break;
                case 24:
                    this.zznkj = zzegx.zzcbz();
                    break;
                case 34:
                    this.zznkk = zzegx.readString();
                    break;
                case 40:
                    this.zznkl = zzegx.zzcbz();
                    break;
                case 48:
                    this.zzgcb = zzegx.zzcbz();
                    break;
                case 58:
                    this.zznkm = zzegx.readString();
                    break;
                case 66:
                    this.zznkn = zzegx.readString();
                    break;
                case 74:
                    this.zznko = zzegx.readString();
                    break;
                case 82:
                    this.zznkp = zzegx.readString();
                    break;
                case 90:
                    this.zznkq = zzegx.readString();
                    break;
                case 96:
                    this.zznkr = zzegx.zzcdz();
                    break;
                case 106:
                    int zzb = zzehj.zzb(zzegx, 106);
                    int length = this.zznks == null ? 0 : this.zznks.length;
                    int i = length;
                    zzeid[] zzeidArr = new zzeid[(length + zzb)];
                    if (i != 0) {
                        System.arraycopy(this.zznks, 0, zzeidArr, 0, i);
                    }
                    while (i < zzeidArr.length - 1) {
                        zzeidArr[i] = new zzeid();
                        zzegx.zza(zzeidArr[i]);
                        zzegx.zzcby();
                        i++;
                    }
                    zzeidArr[i] = new zzeid();
                    zzegx.zza(zzeidArr[i]);
                    this.zznks = zzeidArr;
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
        if (this.zznki != null && !this.zznki.equals("")) {
            zzegy.zzl(2, this.zznki);
        }
        if (this.zznkj != 0) {
            zzegy.zze(3, this.zznkj);
        }
        if (this.zznkk != null && !this.zznkk.equals("")) {
            zzegy.zzl(4, this.zznkk);
        }
        if (this.zznkl != 0) {
            zzegy.zze(5, this.zznkl);
        }
        if (this.zzgcb != 0) {
            zzegy.zze(6, this.zzgcb);
        }
        if (this.zznkm != null && !this.zznkm.equals("")) {
            zzegy.zzl(7, this.zznkm);
        }
        if (this.zznkn != null && !this.zznkn.equals("")) {
            zzegy.zzl(8, this.zznkn);
        }
        if (this.zznko != null && !this.zznko.equals("")) {
            zzegy.zzl(9, this.zznko);
        }
        if (this.zznkp != null && !this.zznkp.equals("")) {
            zzegy.zzl(10, this.zznkp);
        }
        if (this.zznkq != null && !this.zznkq.equals("")) {
            zzegy.zzl(11, this.zznkq);
        }
        if (this.zznkr != 0) {
            zzegy.zzv(12, this.zznkr);
        }
        if (this.zznks != null && this.zznks.length > 0) {
            for (int i = 0; i < this.zznks.length; i++) {
                zzeid zzeid = this.zznks[i];
                if (zzeid != null) {
                    zzegy.zza(13, zzeid);
                }
            }
        }
        super.zza(zzegy);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzeha, com.google.android.gms.internal.zzehg
    public final int zzn() {
        int zzn = super.zzn();
        if (this.zznkh != null && !this.zznkh.equals("")) {
            zzn += zzegy.zzm(1, this.zznkh);
        }
        if (this.zznki != null && !this.zznki.equals("")) {
            zzn += zzegy.zzm(2, this.zznki);
        }
        if (this.zznkj != 0) {
            zzn += zzegy.zzg(3, this.zznkj);
        }
        if (this.zznkk != null && !this.zznkk.equals("")) {
            zzn += zzegy.zzm(4, this.zznkk);
        }
        if (this.zznkl != 0) {
            zzn += zzegy.zzg(5, this.zznkl);
        }
        if (this.zzgcb != 0) {
            zzn += zzegy.zzg(6, this.zzgcb);
        }
        if (this.zznkm != null && !this.zznkm.equals("")) {
            zzn += zzegy.zzm(7, this.zznkm);
        }
        if (this.zznkn != null && !this.zznkn.equals("")) {
            zzn += zzegy.zzm(8, this.zznkn);
        }
        if (this.zznko != null && !this.zznko.equals("")) {
            zzn += zzegy.zzm(9, this.zznko);
        }
        if (this.zznkp != null && !this.zznkp.equals("")) {
            zzn += zzegy.zzm(10, this.zznkp);
        }
        if (this.zznkq != null && !this.zznkq.equals("")) {
            zzn += zzegy.zzm(11, this.zznkq);
        }
        if (this.zznkr != 0) {
            zzn += zzegy.zzaf(12, this.zznkr);
        }
        if (this.zznks != null && this.zznks.length > 0) {
            for (int i = 0; i < this.zznks.length; i++) {
                zzeid zzeid = this.zznks[i];
                if (zzeid != null) {
                    zzn += zzegy.zzb(13, zzeid);
                }
            }
        }
        return zzn;
    }
}
