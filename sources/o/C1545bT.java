package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.bT  reason: case insensitive filesystem */
public final class C1545bT extends AbstractC1679ds {

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f6141;

    public C1545bT(String str, UserActionLogging.CommandName commandName) {
        super(commandName, null);
        this.f6141 = str;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "AddCachedVideo";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1550bY m5762(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView) {
        C1550bY bYVar = new C1550bY(this.f6158, System.currentTimeMillis() - this.f6160, this.f6141, modalView, this.f6436, completionReason, uIError);
        bYVar.setCategory(mo5643());
        bYVar.setSessionId(this.f6158);
        return bYVar;
    }
}
