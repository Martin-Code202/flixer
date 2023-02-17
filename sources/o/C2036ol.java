package o;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* renamed from: o.ol  reason: case insensitive filesystem */
public class C2036ol {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static C2036ol f9340 = new C2036ol();

    /* renamed from: ॱ  reason: contains not printable characters */
    private static Object f9341 = new Object();

    /* renamed from: ˊ  reason: contains not printable characters */
    private C2038on f9342;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Context f9343;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C2037om f9344;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Map<C2038on, C2037om> f9345 = new HashMap();

    private C2036ol() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m9676(Context context) {
        f9340.f9343 = context;
        f9340.f9342 = C2038on.m9680(context);
        f9340.f9344 = new C2037om();
        f9340.f9345.put(f9340.f9342, f9340.f9344);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m9673() {
        String r0;
        C2036ol olVar = f9340;
        synchronized (f9341) {
            r0 = f9340.f9344 != null ? f9340.f9344.m9678() : null;
        }
        return r0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m9674(String str) {
        if (!C1349Bv.m4113(str)) {
            C2036ol olVar = f9340;
            synchronized (f9341) {
                if (C1349Bv.m4126(str, f9340.f9344.f9347)) {
                    f9340.f9344.m9679();
                    return;
                }
                C1283.m16851("nf_networkaware", "changing public ip addr from %s to %s", f9340.f9344.f9347, str);
                m9677();
                f9340.f9344.f9347 = str;
                f9340.f9345.put(f9340.f9342, f9340.f9344);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m9675() {
        C2036ol olVar = f9340;
        synchronized (f9341) {
            m9677();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m9677() {
        C2038on r5 = C2038on.m9680(f9340.f9343);
        if (r5.equals(f9340.f9342)) {
            C1283.m16851("nf_networkaware", "no network switch. key %s", r5);
            return;
        }
        f9340.f9345.put(f9340.f9342, f9340.f9344);
        if (f9340.f9345.containsKey(r5)) {
            f9340.f9342 = r5;
            f9340.f9344 = f9340.f9345.get(r5);
            return;
        }
        f9340.f9342 = r5;
        f9340.f9344 = new C2037om();
        f9340.f9345.put(r5, f9340.f9344);
        C1283.m16851("nf_networkaware", "(total: %d) switching to new network, %s", Integer.valueOf(f9340.f9345.size()), r5);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m9672() {
        f9340.f9345.clear();
        f9340.f9342 = null;
        f9340.f9344 = null;
        f9340.f9343 = null;
    }
}
