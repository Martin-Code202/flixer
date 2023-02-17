package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzq;
import java.util.HashSet;
import java.util.Set;
public final class zzanv {
    private final zzamu zzdji;
    private volatile Boolean zzdqn;
    private String zzdqo;
    private Set<Integer> zzdqp;

    protected zzanv(zzamu zzamu) {
        zzbp.zzu(zzamu);
        this.zzdji = zzamu;
    }

    public static boolean zzxv() {
        return zzaod.zzdqz.get().booleanValue();
    }

    public static int zzxw() {
        return zzaod.zzdrw.get().intValue();
    }

    public static long zzxx() {
        return zzaod.zzdrh.get().longValue();
    }

    public static long zzxy() {
        return zzaod.zzdrk.get().longValue();
    }

    public static int zzxz() {
        return zzaod.zzdrm.get().intValue();
    }

    public static int zzya() {
        return zzaod.zzdrn.get().intValue();
    }

    public static String zzyb() {
        return zzaod.zzdrp.get();
    }

    public static String zzyc() {
        return zzaod.zzdro.get();
    }

    public static String zzyd() {
        return zzaod.zzdrq.get();
    }

    public static long zzyf() {
        return zzaod.zzdse.get().longValue();
    }

    public final boolean zzxu() {
        if (this.zzdqn == null) {
            synchronized (this) {
                if (this.zzdqn == null) {
                    ApplicationInfo applicationInfo = this.zzdji.getContext().getApplicationInfo();
                    String zzall = zzq.zzall();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzdqn = Boolean.valueOf(str != null && str.equals(zzall));
                    }
                    if ((this.zzdqn == null || !this.zzdqn.booleanValue()) && "com.google.android.gms.analytics".equals(zzall)) {
                        this.zzdqn = Boolean.TRUE;
                    }
                    if (this.zzdqn == null) {
                        this.zzdqn = Boolean.TRUE;
                        this.zzdji.zzvy().zzdq("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzdqn.booleanValue();
    }

    public final Set<Integer> zzye() {
        String str = zzaod.zzdrz.get();
        if (this.zzdqp == null || this.zzdqo == null || !this.zzdqo.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            HashSet hashSet = new HashSet();
            for (String str2 : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
                } catch (NumberFormatException unused) {
                }
            }
            this.zzdqo = str;
            this.zzdqp = hashSet;
        }
        return this.zzdqp;
    }
}
