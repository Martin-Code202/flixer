package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
/* renamed from: o.bN  reason: case insensitive filesystem */
public final class C1539bN extends SessionEndedEvent {
    public C1539bN(DeviceUniqueId deviceUniqueId, long j) {
        super("FtlFallbackMode", deviceUniqueId, j);
    }
}
