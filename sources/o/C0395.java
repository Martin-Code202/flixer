package o;

import com.netflix.cl.Logger;
/* renamed from: o.ʌ  reason: contains not printable characters */
public final class C0395 extends AbstractC0470 {
    public C0395() {
        m14630("AddCachedVideo");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C0571 m14179(Long l, long j) {
        if (Logger.INSTANCE.m136() && l == null) {
            return null;
        }
        AbstractC1274 r3 = Logger.INSTANCE.m135(l);
        if (r3 instanceof C0395) {
            return new C0571((C0395) r3, j);
        }
        C0441.m14304().mo4536("AddCachedVideoEnded::createSessionEndedEvent: %d does not identifies AddCachedVideo! It should NOT happen!");
        if (!C0441.m14304().mo4534()) {
            return null;
        }
        throw new IllegalStateException(l + " does not identifies AddCachedVideo! It should NOT happen!");
    }
}
