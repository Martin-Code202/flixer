package kotlin.jvm.internal;

import o.FO;
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f4247;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final FO f4248;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f4249;

    public MutablePropertyReference1Impl(FO fo, String str, String str2) {
        this.f4248 = fo;
        this.f4249 = str;
        this.f4247 = str2;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public FO getOwner() {
        return this.f4248;
    }

    @Override // kotlin.jvm.internal.CallableReference, o.FL
    public String getName() {
        return this.f4249;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return this.f4247;
    }

    @Override // o.FX
    /* renamed from: ॱ  reason: contains not printable characters */
    public Object mo3242(Object obj) {
        return mo3241().call(obj);
    }
}
