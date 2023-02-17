package o;

import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.at  reason: case insensitive filesystem */
public abstract class AbstractC1515at extends AbstractC1560bi {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected UserActionLogging.CommandName f6054;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected IClientLogging.ModalView f6055;

    public AbstractC1515at(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        this.f6054 = commandName;
        this.f6055 = modalView;
    }

    @Override // o.AbstractC1560bi
    /* renamed from: ˋ  reason: contains not printable characters */
    public String mo5643() {
        return "android";
    }
}
