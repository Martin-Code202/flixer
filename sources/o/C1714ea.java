package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.ea  reason: case insensitive filesystem */
public class C1714ea extends AbstractC1653dR {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f6657;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f6658;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Integer f6659;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private UserActionLogging.PostPlayExperience f6660;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f6661;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f6662;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Integer f6663;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f6664;

    public C1714ea(DeviceUniqueId deviceUniqueId, long j, IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError, boolean z, int i, UserActionLogging.PostPlayExperience postPlayExperience, boolean z2, boolean z3, Integer num, Integer num2, int i2) {
        super("postPlay", deviceUniqueId, j, modalView, null, completionReason, uIError);
        this.f6657 = z;
        this.f6662 = i;
        this.f6660 = postPlayExperience;
        this.f6661 = z2;
        this.f6658 = z3;
        this.f6659 = num;
        this.f6663 = num2;
        this.f6664 = i2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        data.put("isAutoPlayCountdownEnabled", this.f6657);
        data.put("lengthOfAutoPlayCountdown", this.f6662);
        if (this.f6660 != null) {
            data.put("postPlayExperience", this.f6660.toString());
        }
        data.put("wasAutoPlayCountdownInterrupted", this.f6661);
        data.put("didUserContinueWatching", this.f6658);
        if (this.f6659 != null) {
            data.put("chosenVideoId", this.f6659.intValue());
        }
        if (this.f6663 != null) {
            data.put("chosenIndex", this.f6663.intValue());
        }
        data.put("trackId", this.f6664);
        return data;
    }
}
