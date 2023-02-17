package o;

import com.netflix.cl.Logger;
/* renamed from: o.ϛ  reason: contains not printable characters */
public abstract class AbstractC0470 extends AbstractC1274 {
    protected AbstractC0470() {
        m14630("Action");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C0389 m14366(Long l, C0510 r6) {
        if (Logger.INSTANCE.m136()) {
            return null;
        }
        AbstractC1274 r4 = Logger.INSTANCE.m135(l);
        if (r4 instanceof AbstractC0470) {
            return new C0389(r4, r6);
        }
        if (l != null) {
            C0441.m14304().mo4535("Action::createActionFailedEvent: sessionId %d does not identifies Action! It should NOT happen!", r4);
            return null;
        }
        C0441.m14304().mo4536("Action::createActionFailedEvent: sessionId is null! It should NOT happen if CLv2 is used for logging!");
        return null;
    }
}
