package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.dP  reason: case insensitive filesystem */
public final class C1651dP extends AbstractC1653dR {
    public C1651dP(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError) {
        super("acknowledgeSignup", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
    }
}
