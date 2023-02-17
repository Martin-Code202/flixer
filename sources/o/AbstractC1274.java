package o;

import com.netflix.cl.Logger;
/* renamed from: o.ﾌ  reason: contains not printable characters */
public abstract class AbstractC1274 extends AbstractC0723 {
    protected AbstractC1274() {
        m14630("Session");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m16817() {
        return (String) this.f13794.get(0);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final long m16816() {
        return this.f13795;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C1275 m16815(Long l) {
        if (Logger.INSTANCE.m136()) {
            return null;
        }
        AbstractC1274 r3 = Logger.INSTANCE.m135(l);
        if (r3 != null) {
            return new C1275(r3);
        }
        C0441.m14304().mo4536("Session::createSessionEndedEvent: %d does not identifies Session! It should NOT happen!");
        if (!C0441.m14304().mo4534()) {
            return null;
        }
        throw new IllegalStateException(l + " does not identifies Session! It should NOT happen!");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0386 m16814(Long l) {
        if (Logger.INSTANCE.m136()) {
            return null;
        }
        AbstractC1274 r4 = Logger.INSTANCE.m135(l);
        if (r4 != null) {
            return new C0386(r4);
        }
        C0441.m14304().mo4535("Session::createSessionCanceledEvent: %d does not identifies Session! It should NOT happen!", l);
        if (!C0441.m14304().mo4534()) {
            return null;
        }
        throw new IllegalStateException(l + " does not identifies Session! It should NOT happen!");
    }
}
