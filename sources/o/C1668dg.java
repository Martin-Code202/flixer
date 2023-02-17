package o;

import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
/* renamed from: o.dg  reason: case insensitive filesystem */
public class C1668dg extends SessionEndedEvent {
    public C1668dg(long j) {
        super("resuming");
        this.duration = j;
    }
}
