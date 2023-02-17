package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
/* renamed from: o.aM  reason: case insensitive filesystem */
public final class C1481aM extends SessionEndedEvent {
    public C1481aM(long j) {
        super("appSession", new DeviceUniqueId(), j);
    }
}
