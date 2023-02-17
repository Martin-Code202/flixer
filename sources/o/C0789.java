package o;

import com.netflix.cl.Logger;
/* renamed from: o.ᒫ  reason: contains not printable characters */
public final class C0789 extends AbstractC0470 {
    public C0789() {
        m14630("Share");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C0930 m15264(Long l, C0609[] r5) {
        if (Logger.INSTANCE.m136() && l == null) {
            return null;
        }
        AbstractC1274 r3 = Logger.INSTANCE.m135(l);
        if (r3 instanceof C0789) {
            return new C0930((C0789) r3, r5);
        }
        C0441.m14304().mo4536("ShareEnded::createSessionEndedEvent: %d does not identifies Share! It should NOT happen!");
        if (!C0441.m14304().mo4534()) {
            return null;
        }
        throw new IllegalStateException(l + " does not identifies Share! It should NOT happen!");
    }
}
