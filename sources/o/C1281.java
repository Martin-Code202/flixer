package o;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
/* renamed from: o.ﾗ  reason: contains not printable characters */
public final class C1281 {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C1281 f15992 = new C1281();

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final ConcurrentHashMap<Class<?>, Object> f15993 = new ConcurrentHashMap<>(8, 0.9f, 1);

    private C1281() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final synchronized <T> void m16833(Class<? super T> cls, T t) {
        synchronized (C1281.class) {
            C1457Fr.m5025(cls, "clazz");
            C1457Fr.m5025(t, "instance");
            if (f15993.containsKey(cls)) {
                throw new IllegalArgumentException("Registry already contains instance for " + cls + " - " + f15993.get(cls) + ' ');
            }
            f15993.put(cls, t);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final <T> T m16832(Class<T> cls) {
        C1457Fr.m5025(cls, "clazz");
        T t = (T) f15993.get(cls);
        if (!cls.isInstance(t)) {
            throw new IllegalArgumentException("No object associated with " + cls);
        } else if (t != null) {
            return t;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type T");
        }
    }
}
