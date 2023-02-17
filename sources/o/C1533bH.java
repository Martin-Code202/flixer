package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
/* renamed from: o.bH  reason: case insensitive filesystem */
public final class C1533bH extends SessionEndedEvent {
    public C1533bH(DeviceUniqueId deviceUniqueId, long j) {
        super("FtlEligible", deviceUniqueId, j);
    }
}
