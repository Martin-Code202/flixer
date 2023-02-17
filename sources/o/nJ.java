package o;

import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitlePreference;
import com.netflix.mediaclient.service.webclient.model.leafs.UserProfile;
import java.util.Arrays;
import java.util.List;
public class nJ extends AbstractC1810gP<UserProfile> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC2022nz f9010;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f9011;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final String f9012;

    nJ(String str, AbstractC2022nz nzVar) {
        this.f9010 = nzVar;
        this.f9012 = str;
        this.f9011 = "['profiles','" + str + "',['summary', 'subtitlePreference']]";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return Arrays.asList(this.f9011);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public UserProfile mo6580(CR cr) {
        return (UserProfile) super.mo6580(cr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public UserProfile mo986(String str) {
        C1283.m16848("nf_service_user_fetchprofiledatarequest", "String response to parse = %s", str);
        JsonObject r4 = C0848.m15512("nf_service_user_fetchprofiledatarequest", str);
        if (C0848.m15504(r4)) {
            throw new FalkorException("UserProfile empty!!!");
        }
        try {
            JsonObject asJsonObject = r4.getAsJsonObject("profiles").getAsJsonObject(this.f9012);
            UserProfile userProfile = new UserProfile();
            userProfile.summary = (UserProfile.Summary) C0848.m15506(asJsonObject, "summary", UserProfile.Summary.class);
            if (userProfile.summary == null || C1349Bv.m4113(userProfile.getProfileToken())) {
                throw new FalkorException("response missing summary" + str);
            }
            userProfile.subtitlePreference = (SubtitlePreference) C0848.m15506(asJsonObject, "subtitlePreference", SubtitlePreference.class);
            return userProfile;
        } catch (Exception e) {
            C1283.m16848("nf_service_user_fetchprofiledatarequest", "String response to parse = %s", str);
            throw new FalkorException("response missing profiles json objects", e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f9010 != null) {
            this.f9010.mo1386((UserProfile) null, status);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo992(UserProfile userProfile) {
        if (this.f9010 != null) {
            this.f9010.mo1386(userProfile, AbstractC0367.f13235);
        }
    }
}
