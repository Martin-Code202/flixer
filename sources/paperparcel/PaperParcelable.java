package paperparcel;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import o.C1447Fh;
import o.C1457Fr;
import o.C1461Fv;
import o.Ge;
public interface PaperParcelable extends Parcelable {

    static final class Cache {

        /* renamed from: ˊ  reason: contains not printable characters */
        public static final Cache f16009 = null;

        /* renamed from: ˏ  reason: contains not printable characters */
        private static final Map<Class<?>, Method> f16010 = null;

        static {
            new Cache();
        }

        private Cache() {
            f16009 = this;
            f16010 = new LinkedHashMap();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final Map<Class<?>, Method> m16882() {
            return f16010;
        }
    }

    public static final class DefaultImpls {
        public static void writeToParcel(PaperParcelable paperParcelable, Parcel parcel, int i) {
            C1457Fr.m5025(parcel, "dest");
            if (!Cache.f16009.m16882().containsKey(paperParcelable.getClass())) {
                Class<?> r4 = m16883(paperParcelable, paperParcelable.getClass());
                Class<?> cls = Class.forName(m16884(paperParcelable, r4));
                Class[] clsArr = {r4, Parcel.class, C1447Fh.m5005(C1461Fv.m5035(Integer.TYPE))};
                int length = clsArr.length;
                Method declaredMethod = cls.getDeclaredMethod("writeToParcel", (Class[]) Arrays.copyOf(clsArr, 3));
                declaredMethod.setAccessible(true);
                Map<Class<?>, Method> r0 = Cache.f16009.m16882();
                Class<?> cls2 = paperParcelable.getClass();
                C1457Fr.m5016((Object) declaredMethod, "writeMethod");
                r0.put(cls2, declaredMethod);
            }
            Method method = Cache.f16009.m16882().get(paperParcelable.getClass());
            if (method == null) {
                C1457Fr.m5019();
            }
            method.invoke(null, paperParcelable, parcel, Integer.valueOf(i));
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private static Class<?> m16883(PaperParcelable paperParcelable, Class<?> cls) {
            if (cls.isAnnotationPresent(PaperParcel.class)) {
                return cls;
            }
            if (C1457Fr.m5018(cls, Object.class)) {
                throw new IllegalArgumentException("Cannot find @" + PaperParcel.class.getSimpleName() + " on " + paperParcelable.getClass().getName() + ".");
            }
            Class<? super Object> superclass = cls.getSuperclass();
            C1457Fr.m5016((Object) superclass, "type.superclass");
            return m16883(paperParcelable, superclass);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private static String m16884(PaperParcelable paperParcelable, Class<?> cls) {
            String name = cls.getPackage().getName();
            String name2 = cls.getName();
            int length = name.length() + 1;
            if (name2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = name2.substring(length);
            C1457Fr.m5016((Object) substring, "(this as java.lang.String).substring(startIndex)");
            return name + ".PaperParcel" + Ge.m5065(substring, '$', '_', false, 4, (Object) null);
        }
    }
}
