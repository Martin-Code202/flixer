package o;

import android.app.Notification;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import com.netflix.mediaclient.service.preapp.PreAppAgentEventType;
import com.netflix.mediaclient.service.pservice.PDiskData;
import com.netflix.mediaclient.ui.preapp.PServiceWidgetProvider;
import com.netflix.mediaclient.util.NotificationUtils;
public class yI implements AbstractC2104qx {
    @Override // o.AbstractC2104qx
    /* renamed from: ˊ */
    public Notification mo10122(Context context) {
        return NotificationUtils.m2994(context);
    }

    @Override // o.AbstractC2104qx
    /* renamed from: ˏ */
    public void mo10124(Context context, PreAppAgentEventType preAppAgentEventType, PDiskData pDiskData) {
        yK.m13188(context, preAppAgentEventType, pDiskData);
    }

    @Override // o.AbstractC2104qx
    /* renamed from: ˎ */
    public boolean mo10123(Context context) {
        boolean z = false;
        try {
            if (AppWidgetManager.getInstance(context) != null) {
                z = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, PServiceWidgetProvider.class)).length > 0;
            }
            if (z || AppWidgetManager.getInstance(context) == null) {
                return z;
            }
            return AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, com.netflix.mediaclient.service.pservice.PServiceWidgetProvider.class)).length > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
