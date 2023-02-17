package o;

import com.netflix.mediaclient.service.logging.client.model.BasicSessionEndedEvent;
import com.netflix.mediaclient.service.logging.client.model.BasicSessionStartedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
/* renamed from: o.cH  reason: case insensitive filesystem */
public class C1586cH extends AbstractC1523az {
    public C1586cH(long j) {
        mo5386(j);
    }

    @Override // o.AbstractC1523az, o.AbstractC1560bi
    /* renamed from: ˋ */
    public String mo5643() {
        return "search";
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "searchThrottle";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public BasicSessionStartedEvent m5822() {
        BasicSessionStartedEvent basicSessionStartedEvent = new BasicSessionStartedEvent("searchThrottle", "search", IClientLogging.ModalView.search);
        basicSessionStartedEvent.setSessionId(this.f6158);
        return basicSessionStartedEvent;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public BasicSessionEndedEvent m5821() {
        BasicSessionEndedEvent basicSessionEndedEvent = new BasicSessionEndedEvent("searchThrottle", "search", System.currentTimeMillis() - this.f6160, IClientLogging.ModalView.search);
        basicSessionEndedEvent.setSessionId(this.f6158);
        return basicSessionEndedEvent;
    }
}
