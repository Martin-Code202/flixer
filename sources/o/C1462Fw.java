package o;

import java.util.Collection;
import java.util.List;
import java.util.Map;
/* renamed from: o.Fw  reason: case insensitive filesystem */
public class C1462Fw {
    /* renamed from: ˊ  reason: contains not printable characters */
    private static <T extends Throwable> T m5040(T t) {
        return (T) C1457Fr.m5023(t, C1462Fw.class.getName());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m5046(Object obj, String str) {
        m5047((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m5047(String str) {
        throw m5044(new ClassCastException(str));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static ClassCastException m5044(ClassCastException classCastException) {
        throw ((ClassCastException) m5040(classCastException));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Collection m5043(Object obj) {
        if ((obj instanceof AbstractC1463Fx) && !(obj instanceof AbstractC1465Fz)) {
            m5046(obj, "kotlin.collections.MutableCollection");
        }
        return m5042(obj);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Collection m5042(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw m5044(e);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static List m5045(Object obj) {
        if ((obj instanceof AbstractC1463Fx) && !(obj instanceof FB)) {
            m5046(obj, "kotlin.collections.MutableList");
        }
        return m5048(obj);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static List m5048(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw m5044(e);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Map m5041(Object obj) {
        if ((obj instanceof AbstractC1463Fx) && !(obj instanceof FC)) {
            m5046(obj, "kotlin.collections.MutableMap");
        }
        return m5039(obj);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static Map m5039(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw m5044(e);
        }
    }
}
