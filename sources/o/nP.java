package o;

import android.content.Context;
import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Collections;
import java.util.List;
/* access modifiers changed from: package-private */
public class nP extends AbstractC1189<Boolean> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC2022nz f9021;

    nP(Context context, NetflixDataRequest.Transport transport, AbstractC2022nz nzVar) {
        super(context, transport);
        this.f9021 = nzVar;
    }

    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return Collections.singletonList("['user', 'restartMembership']");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo9156() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public Boolean mo9112(String str) {
        C1283.m16851("RestartMembershipRequest", "parseFalkorResponse for restartMembership request : %s", str);
        if (str == null) {
            return false;
        }
        JsonObject r4 = C0848.m15512("RestartMembershipRequest", str);
        if (C0848.m15504(r4)) {
            return false;
        }
        try {
            JsonObject asJsonObject = r4.getAsJsonObject("user");
            if (asJsonObject.has("restartMembership")) {
                JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("restartMembership");
                if (asJsonObject2.has("status")) {
                    return Boolean.valueOf(asJsonObject2.get("status").getAsString().equals("SUCCESS"));
                }
            }
            return false;
        } catch (Exception e) {
            C1283.m16848("RestartMembershipRequest", "String response to parse = %s", str);
            throw new FalkorException("Status Response missing required fields", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo9114(Boolean bool) {
        this.f9021.mo1389(bool.booleanValue() ? AbstractC0367.f13235 : AbstractC0367.f13261);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        this.f9021.mo1389(status);
    }
}
