package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONObject;
/* renamed from: o.eg  reason: case insensitive filesystem */
public final class C1720eg extends AbstractC1653dR {

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f6671;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f6672;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Integer f6673;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f6674;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6675;

    public C1720eg(DeviceUniqueId deviceUniqueId, long j, IClientLogging.ModalView modalView, UserActionLogging.CommandName commandName, IClientLogging.CompletionReason completionReason, UIError uIError, Integer num, int i, String str, int i2, boolean z) {
        super("rateTitle", deviceUniqueId, j, modalView, commandName, completionReason, uIError);
        this.f6674 = i;
        this.f6673 = num;
        this.f6675 = str;
        this.f6671 = i2;
        this.f6672 = z;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1653dR, com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (this.f6673 != null) {
            data.put("rankTitle", this.f6673.intValue());
        }
        if (this.f6675 != null) {
            data.put("ratingType", this.f6675);
        }
        if (this.f6671 != -1) {
            data.put("matchScore", this.f6671);
        }
        if (this.f6672) {
            data.put("isNewMS", 1);
        }
        data.put("rating", this.f6674);
        return data;
    }
}
