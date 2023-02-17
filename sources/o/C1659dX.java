package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.dX  reason: case insensitive filesystem */
public final class C1659dX extends AbstractC1653dR {

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f6427;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f6428;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f6429;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6430;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6431;

    public C1659dX(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, String str, String str2, long j2, String str3, String str4) {
        super("NewLolomo", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6430 = str;
        this.f6429 = str2;
        this.f6427 = j2;
        this.f6431 = str3;
        this.f6428 = str4;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (C1349Bv.m4107(this.f6430)) {
            data.put("cause", this.f6430);
        }
        if (C1349Bv.m4107(this.f6429)) {
            data.put("messageGUID", this.f6429);
        }
        data.put("creationTS", this.f6427);
        if (C1349Bv.m4107(this.f6431)) {
            data.put("mercuryMessageGUID", this.f6431);
        }
        if (C1349Bv.m4107(this.f6428)) {
            data.put("mercuryEventGUID", this.f6428);
        }
        return data;
    }
}
