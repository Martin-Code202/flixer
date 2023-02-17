package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dE  reason: case insensitive filesystem */
public final class C1640dE extends AbstractC1679ds {

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f6411;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private long f6412;

    public C1640dE(long j, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView, String str) {
        super(commandName, modalView);
        this.f6411 = str;
        this.f6412 = j;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "search";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1724ek m6000(IClientLogging.CompletionReason completionReason, UIError uIError) {
        C1724ek ekVar = new C1724ek(this.f6158, System.currentTimeMillis() - this.f6160, this.f6437, this.f6436, completionReason, uIError, this.f6411);
        ekVar.setCategory(mo5643());
        ekVar.setSessionId(this.f6158);
        return ekVar;
    }
}
