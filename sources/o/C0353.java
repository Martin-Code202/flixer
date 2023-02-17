package o;

import com.firebase.jobdispatcher.ValidationEnforcer;
import o.C0552;
import o.C0986;
/* renamed from: o.Ɩ  reason: contains not printable characters */
public final class C0353 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1219 f13104;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ValidationEnforcer f13105 = new ValidationEnforcer(this.f13104.mo14590());

    /* renamed from: ॱ  reason: contains not printable characters */
    private C0986.If f13106 = new C0986.If(this.f13105);

    public C0353(AbstractC1219 r3) {
        this.f13104 = r3;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m13959(C0552 r2) {
        if (!this.f13104.mo14591()) {
            return 2;
        }
        return this.f13104.mo14592(r2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0552.Cif m13958() {
        return new C0552.Cif(this.f13105);
    }
}
