package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.aw  reason: case insensitive filesystem */
public class C1520aw extends AbstractC1515at {

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f6100;

    public C1520aw(String str, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        super(commandName, modalView);
        this.f6100 = str;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "shareSheet";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1519av m5702(IClientLogging.CompletionReason completionReason, UIError uIError, IClientLogging.ModalView modalView) {
        C1519av avVar = new C1519av(this.f6100, this.f6158, System.currentTimeMillis() - this.f6160, this.f6055, this.f6054, completionReason, uIError);
        avVar.setCategory(mo5643());
        avVar.setSessionId(this.f6158);
        return avVar;
    }
}
