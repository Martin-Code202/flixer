package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.internal.zzbed;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class zzw {
    private static final Method zzfzh = zzalm();
    private static final Method zzfzi = zzaln();
    private static final Method zzfzj = zzalo();
    private static final Method zzfzk = zzalp();
    private static final Method zzfzl = zzalq();

    private static int zza(WorkSource workSource) {
        if (zzfzj == null) {
            return 0;
        }
        try {
            return ((Integer) zzfzj.invoke(workSource, new Object[0])).intValue();
        } catch (Exception e) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            return 0;
        }
    }

    private static String zza(WorkSource workSource, int i) {
        if (zzfzl == null) {
            return null;
        }
        try {
            return (String) zzfzl.invoke(workSource, Integer.valueOf(i));
        } catch (Exception e) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            return null;
        }
    }

    public static WorkSource zzac(Context context, String str) {
        if (context == null || context.getPackageManager() == null || str == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = zzbed.zzcr(context).getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return zze(applicationInfo.uid, str);
            }
            String valueOf = String.valueOf(str);
            Log.e("WorkSourceUtil", valueOf.length() != 0 ? "Could not get applicationInfo from package: ".concat(valueOf) : new String("Could not get applicationInfo from package: "));
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf2 = String.valueOf(str);
            Log.e("WorkSourceUtil", valueOf2.length() != 0 ? "Could not find package: ".concat(valueOf2) : new String("Could not find package: "));
            return null;
        }
    }

    private static Method zzalm() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method zzaln() {
        if (!zzp.zzalh()) {
            return null;
        }
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE, String.class);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method zzalo() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method zzalp() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method zzalq() {
        if (!zzp.zzalh()) {
            return null;
        }
        try {
            return WorkSource.class.getMethod("getName", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<String> zzb(WorkSource workSource) {
        int zza = workSource == null ? 0 : zza(workSource);
        if (zza == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < zza; i++) {
            String zza2 = zza(workSource, i);
            if (!zzs.zzgm(zza2)) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }

    public static boolean zzco(Context context) {
        return (context == null || context.getPackageManager() == null || zzbed.zzcr(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    private static WorkSource zze(int i, String str) {
        WorkSource workSource = new WorkSource();
        String str2 = str;
        if (zzfzi != null) {
            if (str2 == null) {
                str2 = "";
            }
            try {
                zzfzi.invoke(workSource, Integer.valueOf(i), str2);
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else if (zzfzh != null) {
            try {
                zzfzh.invoke(workSource, Integer.valueOf(i));
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return workSource;
    }
}
