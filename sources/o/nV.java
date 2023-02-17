package o;

import android.content.Context;
import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Arrays;
import java.util.List;
/* access modifiers changed from: package-private */
public class nV extends AbstractC1189<Boolean> {

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f9039;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f9040;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC2022nz f9041;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f9042;

    nV(Context context, NetflixDataRequest.Transport transport, String str, UserAgentInterface.PinType pinType, String str2, AbstractC2022nz nzVar) {
        super(context, transport);
        String str3;
        this.f9041 = nzVar;
        this.f9040 = str;
        boolean z = UserAgentInterface.PinType.MATURITY_PIN == pinType;
        this.f9039 = z ? "verifyPin" : "verifyPreviewPin";
        if (z) {
            str3 = String.format("['user', '%s', '%s']", this.f9039, str);
        } else {
            str3 = String.format("['user', '%s', '%s', '%s']", this.f9039, str, str2);
        }
        this.f9042 = str3;
        C1283.m16848("nf_pin", "PQL = %s", this.f9042);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return Arrays.asList(this.f9042);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public Boolean mo9112(String str) {
        C1283.m16848("nf_pin", "String response to parse = %s", str);
        JsonObject r4 = C0848.m15512("nf_pin", str);
        if (C0848.m15504(r4)) {
            throw new FalkorException("verifyPinResponse empty!!!");
        }
        try {
            return Boolean.valueOf(r4.getAsJsonObject("user").getAsJsonObject(this.f9039).getAsJsonObject(this.f9040).get("isPinValid").getAsBoolean());
        } catch (Exception e) {
            C1283.m16846("nf_pin", "String response to parse = " + str);
            throw new FalkorException("response missing user json objects", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo9114(Boolean bool) {
        if (this.f9041 != null) {
            this.f9041.mo1390(bool.booleanValue(), AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        if (this.f9041 != null) {
            this.f9041.mo1390(false, status);
        }
    }
}
