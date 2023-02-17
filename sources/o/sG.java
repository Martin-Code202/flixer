package o;

import com.netflix.model.leafs.social.IrisNotificationSummary;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class sG {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final Map<IrisNotificationSummary.NotificationTypes, AbstractC2171tb> f10041;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(IrisNotificationSummary.NotificationTypes.NEW_SEASON_ALERT, new C2170ta());
        hashMap.put(IrisNotificationSummary.NotificationTypes.MULTI_TITLE_ALERT, new C2173td());
        f10041 = Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static AbstractC2171tb m10595(IrisNotificationSummary.NotificationTypes notificationTypes) {
        return f10041.get(notificationTypes);
    }
}
