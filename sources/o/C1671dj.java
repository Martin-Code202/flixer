package o;

import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
/* renamed from: o.dj  reason: case insensitive filesystem */
public class C1671dj extends SessionEndedEvent {
    public C1671dj(long j) {
        super("suspend");
        this.duration = j;
    }
}
