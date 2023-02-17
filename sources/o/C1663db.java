package o;

import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
/* renamed from: o.db  reason: case insensitive filesystem */
public class C1663db extends SessionEndedEvent {
    public C1663db(long j) {
        super("background");
        this.duration = j;
    }
}
