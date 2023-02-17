package kotlin.jvm.internal;

import o.FO;
public class PropertyReference1Impl extends PropertyReference1 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f4250;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f4251;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final FO f4252;

    public PropertyReference1Impl(FO fo, String str, String str2) {
        this.f4252 = fo;
        this.f4250 = str;
        this.f4251 = str2;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public FO getOwner() {
        return this.f4252;
    }

    @Override // kotlin.jvm.internal.CallableReference, o.FL
    public String getName() {
        return this.f4250;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return this.f4251;
    }

    @Override // o.FX
    /* renamed from: ॱ */
    public Object mo3242(Object obj) {
        return mo3241().call(obj);
    }
}
