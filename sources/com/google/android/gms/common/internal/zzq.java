package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzcpt;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public final class zzq {
    private final Account zzduy;
    private final String zzdxb;
    private final Set<Scope> zzfha;
    private final int zzfhc;
    private final View zzfhd;
    private final String zzfhe;
    private final Set<Scope> zzftq;
    private final Map<Api<?>, zzs> zzftr;
    private final zzcpt zzfts;
    private Integer zzftt;

    public zzq(Account account, Set<Scope> set, Map<Api<?>, zzs> map, int i, View view, String str, String str2, zzcpt zzcpt) {
        this.zzduy = account;
        this.zzfha = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.zzftr = map == null ? Collections.EMPTY_MAP : map;
        this.zzfhd = view;
        this.zzfhc = i;
        this.zzdxb = str;
        this.zzfhe = str2;
        this.zzfts = zzcpt;
        HashSet hashSet = new HashSet(this.zzfha);
        for (zzs zzs : this.zzftr.values()) {
            hashSet.addAll(zzs.zzecl);
        }
        this.zzftq = Collections.unmodifiableSet(hashSet);
    }

    public static zzq zzcc(Context context) {
        return new GoogleApiClient.Builder(context).zzafr();
    }

    public final Account getAccount() {
        return this.zzduy;
    }

    @Deprecated
    public final String getAccountName() {
        if (this.zzduy != null) {
            return this.zzduy.name;
        }
        return null;
    }

    public final Account zzajq() {
        return this.zzduy != null ? this.zzduy : new Account("<<default account>>", "com.google");
    }

    public final Set<Scope> zzajs() {
        return this.zzfha;
    }

    public final Set<Scope> zzajt() {
        return this.zzftq;
    }

    public final Map<Api<?>, zzs> zzaju() {
        return this.zzftr;
    }

    public final String zzajv() {
        return this.zzdxb;
    }

    public final String zzajw() {
        return this.zzfhe;
    }

    public final zzcpt zzajy() {
        return this.zzfts;
    }

    public final Integer zzajz() {
        return this.zzftt;
    }

    public final Set<Scope> zzc(Api<?> api) {
        zzs zzs = this.zzftr.get(api);
        if (zzs == null || zzs.zzecl.isEmpty()) {
            return this.zzfha;
        }
        HashSet hashSet = new HashSet(this.zzfha);
        hashSet.addAll(zzs.zzecl);
        return hashSet;
    }

    public final void zzc(Integer num) {
        this.zzftt = num;
    }
}
