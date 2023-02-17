package o;

import com.netflix.cl.Logger;
import com.netflix.cl.model.PushNotificationType;
/* renamed from: o.Ꮁ  reason: contains not printable characters */
public final class C0724 extends AbstractC0470 implements AbstractC0514 {
    public C0724() {
        m14630("RegisterForPushNotifications");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C0722 m15061(Long l, String str, PushNotificationType[] pushNotificationTypeArr, boolean z, boolean z2, String str2) {
        if (Logger.INSTANCE.m136() && l == null) {
            return null;
        }
        AbstractC1274 r7 = Logger.INSTANCE.m135(l);
        if (r7 instanceof C0724) {
            return new C0722((C0724) r7, str, pushNotificationTypeArr, z, z2, str2);
        }
        C0441.m14304().mo4536("RegisterForPushNotificationsEnded::createSessionEndedEvent: %d does not identifies RegisterForPushNotifications! It should NOT happen!");
        if (!C0441.m14304().mo4534()) {
            return null;
        }
        throw new IllegalStateException(l + " does not identifies RegisterForPushNotifications! It should NOT happen!");
    }
}
