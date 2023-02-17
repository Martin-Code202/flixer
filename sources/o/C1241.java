package o;

import com.netflix.cl.Logger;
/* renamed from: o.ｧ  reason: contains not printable characters */
public final class C1241 extends AbstractC1274 implements AbstractC0514 {
    public C1241() {
        m14630("UserInteraction");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C0464 m16596(long j) {
        AbstractC1274 r4 = Logger.INSTANCE.m148("UserInteraction");
        if (Logger.INSTANCE.m136() && r4 == null) {
            return null;
        }
        if (r4 instanceof C1241) {
            return new C0464((C1241) r4, j);
        }
        C0441.m14304().mo4536("UserInteraction::createSessionEndedEvent: %d does not identifies UserInteraction! It should NOT happen!");
        if (!C0441.m14304().mo4534()) {
            return null;
        }
        throw new IllegalStateException(r4.m16816() + " does not identifies UserInteraction! It should NOT happen!");
    }
}
