package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dy  reason: case insensitive filesystem */
public class C1685dy extends AbstractC1679ds {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f6439;

    /* renamed from: ʽ  reason: contains not printable characters */
    private UserActionLogging.PostPlayExperience f6440;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f6441;

    public C1685dy(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView, boolean z, int i, UserActionLogging.PostPlayExperience postPlayExperience) {
        super(commandName, modalView);
        this.f6441 = z;
        this.f6439 = i;
        this.f6440 = postPlayExperience;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "postPlay";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1714ea m6029(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError, boolean z, boolean z2, Integer num, Integer num2, int i) {
        C1714ea eaVar = new C1714ea(this.f6158, System.currentTimeMillis() - this.f6160, completionReason, modalView, uIError, this.f6441, this.f6439, this.f6440, z, z2, num, num2, i);
        eaVar.setCategory(mo5643());
        eaVar.setSessionId(this.f6158);
        return eaVar;
    }
}
