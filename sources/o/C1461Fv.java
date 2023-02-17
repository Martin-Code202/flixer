package o;

import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.PropertyReference1;
/* renamed from: o.Fv  reason: case insensitive filesystem */
public class C1461Fv {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final C1460Fu f5680;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final FN[] f5681 = new FN[0];

    static {
        C1460Fu fu;
        try {
            fu = (C1460Fu) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException e) {
            fu = null;
        } catch (ClassNotFoundException e2) {
            fu = null;
        } catch (InstantiationException e3) {
            fu = null;
        } catch (IllegalAccessException e4) {
            fu = null;
        }
        f5680 = fu != null ? fu : new C1460Fu();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static FN m5035(Class cls) {
        return f5680.m5032(cls);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m5036(Lambda lambda) {
        return f5680.m5029(lambda);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static FP m5034(FunctionReference functionReference) {
        return f5680.m5030(functionReference);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static FX m5038(PropertyReference1 propertyReference1) {
        return f5680.m5033(propertyReference1);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static FR m5037(MutablePropertyReference1 mutablePropertyReference1) {
        return f5680.m5031(mutablePropertyReference1);
    }
}
