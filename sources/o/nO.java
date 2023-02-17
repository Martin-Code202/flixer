package o;

import android.content.Context;
import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitlePreference;
import com.netflix.mediaclient.service.webclient.model.leafs.User;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Arrays;
import java.util.List;
/* access modifiers changed from: package-private */
public class nO extends AbstractC1189<User> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f9019 = "['user', ['summary', 'subtitleDefaults']]";

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC2022nz f9020;

    nO(Context context, NetflixDataRequest.Transport transport, AbstractC2022nz nzVar) {
        super(context, transport);
        this.f9020 = nzVar;
        C1283.m16848("nf_service_user_fetchuserdatarequest", "PQL = %s", this.f9019);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return Arrays.asList(this.f9019);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˏ */
    public boolean mo9121() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public User mo9112(String str) {
        JsonObject r3 = C0848.m15512("nf_service_user_fetchuserdatarequest", str);
        if (C0848.m15504(r3)) {
            throw new FalkorException("UserProfile empty!!!");
        }
        User user = new User();
        try {
            JsonObject asJsonObject = r3.getAsJsonObject("user");
            user.summary = (User.Summary) C0848.m15506(asJsonObject, "summary", User.Summary.class);
            if (user.summary == null || C1349Bv.m4113(user.getUserToken())) {
                throw new FalkorException("response missing summary" + str);
            }
            user.subtitleDefaults = (SubtitlePreference) C0848.m15506(asJsonObject, "subtitleDefaults", SubtitlePreference.class);
            return user;
        } catch (Exception e) {
            C1283.m16846("nf_service_user_fetchuserdatarequest", "String response to parse = " + str);
            throw new FalkorException("response missing user json objects", e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        if (this.f9020 != null) {
            this.f9020.mo1391((User) null, status);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo9114(User user) {
        if (this.f9020 != null) {
            this.f9020.mo1391(user, AbstractC0367.f13235);
        }
    }
}
