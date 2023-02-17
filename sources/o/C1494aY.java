package o;

import com.netflix.mediaclient.service.logging.apm.model.Orientation;
import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.aY  reason: case insensitive filesystem */
public final class C1494aY extends SessionStartedEvent {

    /* renamed from: ˋ  reason: contains not printable characters */
    private IClientLogging.ModalView f5944;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Orientation f5945;

    public C1494aY(boolean z, IClientLogging.ModalView modalView) {
        super("uiModelessView");
        this.f5945 = z ? Orientation.portrait : Orientation.landscape;
        this.modalView = modalView;
        this.f5944 = modalView;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("orientation", this.f5945.name());
        if (this.f5944 != null) {
            data.put("modelessView", this.f5944.name());
        }
        return data;
    }
}
