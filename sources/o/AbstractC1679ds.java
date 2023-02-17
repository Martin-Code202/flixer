package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.ds  reason: case insensitive filesystem */
public abstract class AbstractC1679ds extends AbstractC1560bi {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected UserActionLogging.CommandName f6436;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected IClientLogging.ModalView f6437;

    public AbstractC1679ds(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        this.f6436 = commandName;
        this.f6437 = modalView;
    }

    @Override // o.AbstractC1560bi
    /* renamed from: ˋ */
    public String mo5643() {
        return UIError.UI_ACTION;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public IClientLogging.ModalView m6021() {
        return this.f6437;
    }
}
