package o;

import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
/* renamed from: o.bs  reason: case insensitive filesystem */
public final class C1570bs extends AbstractC1571bt {

    /* renamed from: ˎ  reason: contains not printable characters */
    private CustomerServiceLogging.EntryPoint f6174;

    public C1570bs(CustomerServiceLogging.EntryPoint entryPoint) {
        this.f6174 = entryPoint;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "helpRequest";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1577bz m5797(CustomerServiceLogging.Action action, String str, IClientLogging.CompletionReason completionReason, Error error) {
        return new C1577bz(this, this.f6174, action, str, completionReason, error);
    }
}
