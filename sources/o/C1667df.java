package o;

import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
/* renamed from: o.df  reason: case insensitive filesystem */
public class C1667df extends SessionEndedEvent {
    public C1667df(long j) {
        super("foreground");
        this.duration = j;
    }
}
