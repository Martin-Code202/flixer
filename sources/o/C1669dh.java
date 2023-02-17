package o;

import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
/* renamed from: o.dh  reason: case insensitive filesystem */
public class C1669dh extends SessionEndedEvent {
    public C1669dh(long j) {
        super("backgrounding");
        this.duration = j;
    }
}
