package o;

import android.graphics.Path;
import java.util.List;
import o.C0445;
import o.C0987;
import org.json.JSONObject;
/* renamed from: o.ᒽ  reason: contains not printable characters */
public class C0814 extends AbstractC0864<C0445, Path> {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Path f14570;

    private C0814(List<C1297AUx<C0445>> list, C0445 r3) {
        super(list, r3);
        this.f14570 = new Path();
    }

    @Override // o.AbstractC0923
    /* renamed from: ˎ */
    public AbstractC1622coN<C0445, Path> mo14241() {
        if (!m15557()) {
            return new C0418(mo15382((C0445) this.f14716));
        }
        return new C0555(this.f14717);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public Path mo15382(C0445 r2) {
        this.f14570.reset();
        C1150.m16327(r2, this.f14570);
        return this.f14570;
    }

    /* renamed from: o.ᒽ$iF */
    public static final class iF {
        /* renamed from: ˊ  reason: contains not printable characters */
        public static C0814 m15384(JSONObject jSONObject, C0433 r6) {
            C0987.C0988 r4 = C0987.m15927(jSONObject, r6.m14266(), r6, C0445.Cif.f13483).m15931();
            return new C0814(r4.f15050, r4.f15049);
        }
    }
}
