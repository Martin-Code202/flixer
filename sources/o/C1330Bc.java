package o;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.StatFs;
import android.support.v4.os.EnvironmentCompat;
import android.webkit.ValueCallback;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: o.Bc  reason: case insensitive filesystem */
public class C1330Bc {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static AtomicInteger f4643;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static AtomicInteger f4644;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Map<String, String> m4004(int i) {
        HashMap hashMap = new HashMap();
        AbstractApplicationC1258 instance = AbstractApplicationC1258.getInstance();
        if (instance == null) {
            return hashMap;
        }
        ActivityManager activityManager = (ActivityManager) instance.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        Runtime runtime = Runtime.getRuntime();
        long r10 = C1317As.m3753(runtime.totalMemory() - runtime.freeMemory());
        long r12 = C1317As.m3753(runtime.maxMemory());
        hashMap.put("trimLevel", String.valueOf(i));
        hashMap.put("availRam", String.valueOf(C1317As.m3753(memoryInfo.availMem)));
        hashMap.put("lowThreshold", String.valueOf(C1317As.m3753(memoryInfo.threshold)));
        hashMap.put("totalRam", String.valueOf(C1317As.m3753(memoryInfo.totalMem)));
        hashMap.put("isLowMem", String.valueOf(memoryInfo.lowMemory));
        hashMap.put("impGroup", String.valueOf(runningAppProcessInfo.importance));
        hashMap.put("lastTrimLevel", String.valueOf(runningAppProcessInfo.lastTrimLevel));
        hashMap.put("lruPos", String.valueOf(runningAppProcessInfo.lru));
        hashMap.put("memClass", String.valueOf(activityManager.getMemoryClass()));
        hashMap.put("maxHeap", String.valueOf(r12));
        hashMap.put("usedHeap", String.valueOf(r10));
        hashMap.put("activityCount", String.valueOf(AbstractApplicationC1258.getInstance().mo234().mo14200()));
        hashMap.put("bmpCacheSize", String.valueOf(C1317As.m3753(AbstractApplicationC1258.getInstance().mo256())));
        return hashMap;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m4002(Context context) {
        if (context == null) {
            return false;
        }
        return AbstractApplicationC1258.getInstance().mo234().mo14205();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m4006() {
        return AbstractApplicationC1258.getInstance().mo234().mo14209();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4007(Context context, String str) {
        m4005(context);
        AbstractApplicationC1258.getInstance().mo252(context, str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4005(Context context) {
        C1376Cs.m4555(context, (ValueCallback<Boolean>) null);
        C1317As.m3760(context);
        C1339Bl.m4046(context);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static StatFs m4008(File file) {
        try {
            if (!file.exists() || !"mounted".equals(EnvironmentCompat.getStorageState(file))) {
                return null;
            }
            return new StatFs(file.getPath());
        } catch (IllegalArgumentException e) {
            return null;
        } catch (Exception e2) {
            C1276.m16820().mo5725("getStatFsForExternalStorageDir " + file.getAbsolutePath() + " exception " + e2);
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static synchronized int m4003(Context context) {
        synchronized (C1330Bc.class) {
            if (f4644 != null) {
                return f4644.get();
            }
            int r5 = C1339Bl.m4037(context, "disk_cache_size", 0);
            if (r5 == 0) {
                long r6 = C1317As.m3769();
                r5 = Math.max((int) Math.min(((float) r6) * 0.25f, 2.62144E7f), 5242880);
                C1339Bl.m4042(context, "disk_cache_size", r5);
                C1283.m16851("nf_utils", "Available disk space in bytes = %d Saving disk Cache Size = %d", Long.valueOf(r6), Integer.valueOf(r5));
            }
            f4644 = new AtomicInteger(r5);
            return r5;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static synchronized int m4001() {
        synchronized (C1330Bc.class) {
            if (f4643 != null) {
                return f4643.get();
            }
            long r5 = C1317As.m3769();
            int max = (int) Math.max(((float) r5) * 0.25f, 1.048576E8f);
            if (max < 10485760) {
                max = 0;
            }
            C1283.m16851("nf_utils", "Available disk space in bytes = %d Saving fragment Cache Size = %d", Long.valueOf(r5), Integer.valueOf(max));
            f4643 = new AtomicInteger(max);
            return max;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Map<String, String> m4009(Uri uri) {
        HashMap hashMap = new HashMap();
        if (uri == null) {
            return hashMap;
        }
        for (String str : uri.getQueryParameterNames()) {
            if (C1349Bv.m4107(str)) {
                String queryParameter = uri.getQueryParameter(str);
                if (C1349Bv.m4107(queryParameter)) {
                    hashMap.put(str, queryParameter);
                }
            }
        }
        return hashMap;
    }
}
