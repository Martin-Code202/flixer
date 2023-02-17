package o;

import org.json.JSONObject;
/* renamed from: o.ɭ  reason: contains not printable characters */
public final class C0381 extends AbstractC0675 implements AbstractC0514 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private C0478 f13330;

    public C0381(C0478 r2) {
        m14630("TestAllocations");
        this.f13330 = r2;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14624(jSONObject, "cells", this.f13330);
        return jSONObject;
    }
}
