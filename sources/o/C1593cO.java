package o;

import com.netflix.mediaclient.service.logging.client.model.EventType;
import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
/* renamed from: o.cO  reason: case insensitive filesystem */
public class C1593cO extends SessionStartedEvent {
    public C1593cO() {
        super("search");
        m5833();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5833() {
        this.type = EventType.sessionStarted;
        this.sessionName = "search";
        this.modalView = IClientLogging.ModalView.search;
        this.category = "search";
        this.name = "session.started";
    }
}
