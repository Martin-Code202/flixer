package o;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
/* renamed from: o.Fr  reason: case insensitive filesystem */
public class C1457Fr {
    private C1457Fr() {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m5015(String str, Object obj) {
        return str + obj;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m5019() {
        throw ((KotlinNullPointerException) m5022(new KotlinNullPointerException()));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m5024(String str) {
        throw ((UninitializedPropertyAccessException) m5022(new UninitializedPropertyAccessException(str)));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m5017(String str) {
        m5024("lateinit property " + str + " has not been initialized");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m5016(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m5022(new IllegalStateException(str + " must not be null")));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m5025(Object obj, String str) {
        if (obj == null) {
            m5020(str);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m5020(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) m5022(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m5021(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m5018(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static <T extends Throwable> T m5022(T t) {
        return (T) m5023(t, C1457Fr.class.getName());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static <T extends Throwable> T m5023(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }
}
