package o;

import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
/* renamed from: o.dn  reason: case insensitive filesystem */
public class C1675dn extends SessionEndedEvent {
    public C1675dn(long j) {
        super("unfocused");
        this.duration = j;
    }
}
