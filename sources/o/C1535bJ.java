package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
/* renamed from: o.bJ  reason: case insensitive filesystem */
public final class C1535bJ extends SessionEndedEvent {
    public C1535bJ(DeviceUniqueId deviceUniqueId, long j) {
        super("FtlConnection", deviceUniqueId, j);
    }
}
