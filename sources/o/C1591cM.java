package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.EventType;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
/* renamed from: o.cM  reason: case insensitive filesystem */
public final class C1591cM extends SessionEndedEvent {
    public C1591cM(long j) {
        super("search", new DeviceUniqueId(), j);
        m5831();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5831() {
        this.type = EventType.sessionEnded;
        this.sessionName = "search";
        this.modalView = IClientLogging.ModalView.search;
        this.category = "search";
        this.name = "session.ended";
    }
}
