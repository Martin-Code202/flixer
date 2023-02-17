package o;

import android.os.Parcelable;
import com.netflix.model.leafs.social.IrisNotificationSummary;
import com.netflix.model.leafs.social.IrisNotificationsListSummary;
import java.util.List;
/* renamed from: o.qc  reason: case insensitive filesystem */
public interface AbstractC2082qc {
    Parcelable getParcelable();

    List<IrisNotificationSummary> getSocialNotifications();

    IrisNotificationsListSummary getSocialNotificationsListSummary();
}
