package o;

import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.PropertyReference1;
/* renamed from: o.Fu  reason: case insensitive filesystem */
public class C1460Fu {
    /* renamed from: ॱ  reason: contains not printable characters */
    public FN m5032(Class cls) {
        return new C1459Ft(cls);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m5029(Lambda lambda) {
        String obj = lambda.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring("kotlin.jvm.functions.".length()) : obj;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public FP m5030(FunctionReference functionReference) {
        return functionReference;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public FX m5033(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public FR m5031(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }
}
