package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* renamed from: o.ﾊ  reason: contains not printable characters */
public final class C1272 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static iF f15955;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static HashMap<Class<? extends AbstractC1067>, AbstractC1067> f15956 = new HashMap<>();

    /* renamed from: o.ﾊ$iF */
    public interface iF {
        /* renamed from: ˊ */
        void mo3578(Context context, ABTestConfig aBTestConfig, AbstractC1067 v);
    }

    @SafeVarargs
    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m16798(Class<? extends AbstractC1067>... clsArr) {
        System.nanoTime();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (Class<? extends AbstractC1067> cls : clsArr) {
            try {
                AbstractC1067 r11 = (AbstractC1067) cls.newInstance();
                m16799("prefKey", r11.mo510(), hashMap, cls);
                m16799("testId", r11.mo511(), hashMap2, cls);
                f15956.put(cls, r11);
            } catch (IllegalAccessException | InstantiationException e) {
                throw new RuntimeException("Unable to instantiate " + cls.getName() + ", make sure it is has a default constructor");
            }
        }
        System.nanoTime();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m16799(String str, String str2, Map<String, String> map, Class<? extends AbstractC1067> cls) {
        if (map.containsKey(str2)) {
            throw new RuntimeException(String.format(Locale.ENGLISH, "Unable to register %s, same %s as %s", cls.getName(), str, map.get(str2)));
        }
        map.put(str2, cls.getName());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Collection<AbstractC1067> m16804() {
        return f15956.values();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m16802(Context context, AbstractC1221 r4) {
        if (r4 != null) {
            for (AbstractC1067 r0 : f15956.values()) {
                r0.m16130(context, r4, f15955);
            }
        }
    }

    @Deprecated
    /* renamed from: ˊ  reason: contains not printable characters */
    public static ABTestConfig.Cell m16797(Class<? extends AbstractC1067> cls, Context context) {
        return m16800((Class<AbstractC1067>) cls).e_(context);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static ABTestConfig.Cell m16803(Class<? extends AbstractC1067> cls) {
        return m16800((Class<AbstractC1067>) cls).e_(AbstractApplicationC1258.m16692());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static <T extends AbstractC1067> T m16800(Class<T> cls) {
        T t = (T) f15956.get(cls);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("You forgot to add " + cls.getSimpleName() + " to sConfigs in PersistentConfig!!!");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m16801(Context context) {
        for (AbstractC1067 r0 : f15956.values()) {
            r0.m16125(context);
        }
    }
}
