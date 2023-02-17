package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzcpt;
import java.util.Collection;
public final class zzr {
    private Account zzduy;
    private String zzdxb;
    private int zzfhc = 0;
    private String zzfhe;
    private zzcpt zzfts = zzcpt.zzjno;
    private ArraySet<Scope> zzftu;

    public final zzq zzaka() {
        return new zzq(this.zzduy, this.zzftu, null, 0, null, this.zzdxb, this.zzfhe, this.zzfts);
    }

    public final zzr zze(Account account) {
        this.zzduy = account;
        return this;
    }

    public final zzr zze(Collection<Scope> collection) {
        if (this.zzftu == null) {
            this.zzftu = new ArraySet<>();
        }
        this.zzftu.addAll(collection);
        return this;
    }

    public final zzr zzfz(String str) {
        this.zzdxb = str;
        return this;
    }

    public final zzr zzga(String str) {
        this.zzfhe = str;
        return this;
    }
}
