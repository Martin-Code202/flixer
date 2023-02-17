package o;

import java.util.List;
import o.C0736;
import o.C0987;
import org.json.JSONObject;
/* renamed from: o.ᐪ  reason: contains not printable characters */
public class C0750 extends AbstractC0864<C0736, C0736> {
    private C0750() {
        super(new C0736());
    }

    C0750(List<C1297AUx<C0736>> list, C0736 r2) {
        super(list, r2);
    }

    @Override // o.AbstractC0923
    /* renamed from: ˎ */
    public AbstractC1622coN<C0736, C0736> mo14241() {
        if (!m15557()) {
            return new C0418(this.f14716);
        }
        return new C0983(this.f14717);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᐪ$If */
    public static final class If {
        /* renamed from: ˎ  reason: contains not printable characters */
        static C0750 m15168(JSONObject jSONObject, C0433 r5) {
            C0987.C0988 r3 = C0987.m15927(jSONObject, 1.0f, r5, C0736.If.f14307).m15931();
            return new C0750(r3.f15050, r3.f15049);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        static C0750 m15169() {
            return new C0750();
        }
    }
}
