package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbp;
/* access modifiers changed from: package-private */
public final class zzcar {
    private final String mAppId;
    private String zzcyd;
    private String zzdmb;
    private String zzgam;
    private final zzccw zzikh;
    private String zziky;
    private String zzikz;
    private long zzila;
    private long zzilb;
    private long zzilc;
    private long zzild;
    private String zzile;
    private long zzilf;
    private long zzilg;
    private boolean zzilh;
    private long zzili;
    private long zzilj;
    private long zzilk;
    private long zzill;
    private long zzilm;
    private long zziln;
    private long zzilo;
    private String zzilp;
    private boolean zzilq;
    private long zzilr;
    private long zzils;

    zzcar(zzccw zzccw, String str) {
        zzbp.zzu(zzccw);
        zzbp.zzgg(str);
        this.zzikh = zzccw;
        this.mAppId = str;
        this.zzikh.zzaul().zzuj();
    }

    public final String getAppId() {
        this.zzikh.zzaul().zzuj();
        return this.mAppId;
    }

    public final String getAppInstanceId() {
        this.zzikh.zzaul().zzuj();
        return this.zzgam;
    }

    public final String getGmpAppId() {
        this.zzikh.zzaul().zzuj();
        return this.zzcyd;
    }

    public final void setAppVersion(String str) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= !zzcfw.zzas(this.zzdmb, str);
        this.zzdmb = str;
    }

    public final void setMeasurementEnabled(boolean z) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzilh != z;
        this.zzilh = z;
    }

    public final void zzal(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzilb != j;
        this.zzilb = j;
    }

    public final void zzam(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzilc != j;
        this.zzilc = j;
    }

    public final void zzan(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzild != j;
        this.zzild = j;
    }

    public final void zzao(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzilf != j;
        this.zzilf = j;
    }

    public final void zzap(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzilg != j;
        this.zzilg = j;
    }

    public final void zzaq(long j) {
        zzbp.zzbh(j >= 0);
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzila != j;
        this.zzila = j;
    }

    public final void zzar(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzilr != j;
        this.zzilr = j;
    }

    public final void zzas(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzils != j;
        this.zzils = j;
    }

    public final void zzat(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzilj != j;
        this.zzilj = j;
    }

    public final void zzau(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzilk != j;
        this.zzilk = j;
    }

    public final void zzaup() {
        this.zzikh.zzaul().zzuj();
        this.zzilq = false;
    }

    public final String zzauq() {
        this.zzikh.zzaul().zzuj();
        return this.zziky;
    }

    public final String zzaur() {
        this.zzikh.zzaul().zzuj();
        return this.zzikz;
    }

    public final long zzaus() {
        this.zzikh.zzaul().zzuj();
        return this.zzilb;
    }

    public final long zzaut() {
        this.zzikh.zzaul().zzuj();
        return this.zzilc;
    }

    public final long zzauu() {
        this.zzikh.zzaul().zzuj();
        return this.zzild;
    }

    public final String zzauv() {
        this.zzikh.zzaul().zzuj();
        return this.zzile;
    }

    public final long zzauw() {
        this.zzikh.zzaul().zzuj();
        return this.zzilf;
    }

    public final long zzaux() {
        this.zzikh.zzaul().zzuj();
        return this.zzilg;
    }

    public final boolean zzauy() {
        this.zzikh.zzaul().zzuj();
        return this.zzilh;
    }

    public final long zzauz() {
        this.zzikh.zzaul().zzuj();
        return this.zzila;
    }

    public final void zzav(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzill != j;
        this.zzill = j;
    }

    public final long zzava() {
        this.zzikh.zzaul().zzuj();
        return this.zzilr;
    }

    public final long zzavb() {
        this.zzikh.zzaul().zzuj();
        return this.zzils;
    }

    public final void zzavc() {
        this.zzikh.zzaul().zzuj();
        long j = this.zzila + 1;
        long j2 = j;
        if (j > 2147483647L) {
            this.zzikh.zzaum().zzayg().zzj("Bundle index overflow. appId", zzcbw.zzjf(this.mAppId));
            j2 = 0;
        }
        this.zzilq = true;
        this.zzila = j2;
    }

    public final long zzavd() {
        this.zzikh.zzaul().zzuj();
        return this.zzilj;
    }

    public final long zzave() {
        this.zzikh.zzaul().zzuj();
        return this.zzilk;
    }

    public final long zzavf() {
        this.zzikh.zzaul().zzuj();
        return this.zzill;
    }

    public final long zzavg() {
        this.zzikh.zzaul().zzuj();
        return this.zzilm;
    }

    public final long zzavh() {
        this.zzikh.zzaul().zzuj();
        return this.zzilo;
    }

    public final long zzavi() {
        this.zzikh.zzaul().zzuj();
        return this.zziln;
    }

    public final String zzavj() {
        this.zzikh.zzaul().zzuj();
        return this.zzilp;
    }

    public final String zzavk() {
        this.zzikh.zzaul().zzuj();
        String str = this.zzilp;
        zzir(null);
        return str;
    }

    public final long zzavl() {
        this.zzikh.zzaul().zzuj();
        return this.zzili;
    }

    public final void zzaw(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzilm != j;
        this.zzilm = j;
    }

    public final void zzax(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzilo != j;
        this.zzilo = j;
    }

    public final void zzay(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zziln != j;
        this.zziln = j;
    }

    public final void zzaz(long j) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= this.zzili != j;
        this.zzili = j;
    }

    public final void zzim(String str) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= !zzcfw.zzas(this.zzgam, str);
        this.zzgam = str;
    }

    public final void zzin(String str) {
        this.zzikh.zzaul().zzuj();
        String str2 = TextUtils.isEmpty(str) ? null : str;
        this.zzilq |= !zzcfw.zzas(this.zzcyd, str2);
        this.zzcyd = str2;
    }

    public final void zzio(String str) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= !zzcfw.zzas(this.zziky, str);
        this.zziky = str;
    }

    public final void zzip(String str) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= !zzcfw.zzas(this.zzikz, str);
        this.zzikz = str;
    }

    public final void zziq(String str) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= !zzcfw.zzas(this.zzile, str);
        this.zzile = str;
    }

    public final void zzir(String str) {
        this.zzikh.zzaul().zzuj();
        this.zzilq |= !zzcfw.zzas(this.zzilp, str);
        this.zzilp = str;
    }

    public final String zzuo() {
        this.zzikh.zzaul().zzuj();
        return this.zzdmb;
    }
}
