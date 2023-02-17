package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
public final class AG {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f4279 = AG.class.getSimpleName();

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3334(Context context, BroadcastReceiver broadcastReceiver, String str, String... strArr) {
        return m3330(context, broadcastReceiver, str, 999, strArr);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3330(Context context, BroadcastReceiver broadcastReceiver, String str, int i, String... strArr) {
        if (strArr == null || strArr.length < 1) {
            throw new IllegalArgumentException("No actions!");
        }
        IntentFilter intentFilter = new IntentFilter();
        if (str != null) {
            intentFilter.addCategory(str);
        }
        for (String str2 : strArr) {
            if (C1349Bv.m4107(str2)) {
                intentFilter.addAction(str2);
            }
        }
        return m3337(context, broadcastReceiver, intentFilter);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3337(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (context == null) {
            throw new IllegalArgumentException("Context is null");
        } else if (broadcastReceiver == null) {
            throw new IllegalArgumentException("Receiver is null");
        } else if (intentFilter == null) {
            throw new IllegalArgumentException("No filter!");
        } else {
            try {
                LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, intentFilter);
                return true;
            } catch (Throwable th) {
                C1283.m16847(f4279, "Failed to register ", th);
                return false;
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3329(Context context, BroadcastReceiver broadcastReceiver) {
        if (context == null) {
            C1283.m16850(f4279, "Context is null");
            return false;
        } else if (broadcastReceiver == null) {
            C1283.m16850(f4279, "Receiver is null");
            return false;
        } else {
            try {
                LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
                return true;
            } catch (Throwable th) {
                C1283.m16847(f4279, "Failed to unregister ", th);
                return false;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3331(Context context, BroadcastReceiver broadcastReceiver, String str, String... strArr) {
        return m3333(context, broadcastReceiver, str, 999, strArr);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3333(Context context, BroadcastReceiver broadcastReceiver, String str, int i, String... strArr) {
        if (context == null) {
            throw new IllegalArgumentException("Context is null");
        } else if (broadcastReceiver == null) {
            throw new IllegalArgumentException("Receiver is null");
        } else if (strArr == null || strArr.length < 1) {
            throw new IllegalArgumentException("No actions!");
        } else {
            IntentFilter intentFilter = new IntentFilter();
            if (str != null) {
                intentFilter.addCategory(str);
            }
            for (String str2 : strArr) {
                if (C1349Bv.m4107(str2)) {
                    intentFilter.addAction(str2);
                }
            }
            intentFilter.setPriority(m3328(i));
            try {
                context.registerReceiver(broadcastReceiver, intentFilter);
                return true;
            } catch (Throwable th) {
                C1283.m16847(f4279, "Failed to register ", th);
                return false;
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int m3328(int i) {
        if (i < -1000) {
            return -999;
        }
        if (i > 1000) {
            return 999;
        }
        return i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3336(Context context, BroadcastReceiver broadcastReceiver) {
        if (context == null) {
            C1283.m16850(f4279, "Context is null");
            return false;
        } else if (broadcastReceiver == null) {
            C1283.m16850(f4279, "Receiver is null");
            return false;
        } else {
            try {
                context.unregisterReceiver(broadcastReceiver);
                return true;
            } catch (Throwable th) {
                C1283.m16847(f4279, "Failed to unregister ", th);
                return false;
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m3332(Intent intent) {
        if (intent != null) {
            return intent.getAction();
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static IntentFilter m3335(String... strArr) {
        IntentFilter intentFilter = new IntentFilter();
        for (String str : strArr) {
            intentFilter.addAction(str);
        }
        return intentFilter;
    }
}
