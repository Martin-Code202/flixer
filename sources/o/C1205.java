package o;

import android.content.Context;
import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.android.app.NetflixImmutableStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.DeviceCommandHandler;
import com.netflix.mediaclient.service.webclient.model.leafs.NonMemberData;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInData;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.ﻏ  reason: contains not printable characters */
public class C1205 extends AbstractC1110<SignInData> {

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final Context f15583;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final String f15584 = "['signInVerify']";

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1254 f15585;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final String f15586;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final AbstractC1221 f15587;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final String f15588;

    C1205(Context context, AbstractC1221 r3, String str, String str2, AbstractC1254 r6) {
        this.f15583 = context;
        this.f15585 = r6;
        this.f15588 = str;
        this.f15586 = str2;
        this.f15587 = r3;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1094, o.AbstractC1807gM, com.android.volley.Request
    public Map<String, String> getParams() {
        NonMemberData r5 = this.f15587.mo16531();
        SignInConfigData r6 = this.f15587.mo16538();
        Map<String, String> params = super.getParams();
        if (r6 != null) {
            params.put("flwssn", r6.flwssn);
        }
        if (r5 != null && r5.isValid()) {
            params.put(LoggingRequest.NETFLIX_ID, r5.netflixId);
            params.put("secureNetflixId", r5.secureNetflixId);
        }
        if (C1349Bv.m4107(this.f15587.mo16560())) {
            params.put("channelId", this.f15587.mo16560());
        }
        if (C1349Bv.m4107(this.f15587.mo16502())) {
            params.put("gAdvId", this.f15587.mo16502());
        }
        params.put("installType", this.f15587.mo16562());
        params.put("installType", this.f15587.mo16562());
        params.put(SignupConstants.Field.EMAIL, this.f15588);
        C1283.m16851("nf_login", "signInParams=%s", params.toString());
        params.put(SignupConstants.Field.PASSWORD, this.f15586);
        return params;
    }

    @Override // o.gV, com.android.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        if (headers == null) {
            return new HashMap();
        }
        return headers;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return Arrays.asList(this.f15584);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public SignInData mo6580(CR cr) {
        this.f15328 = m6569("TEMP_PROFILE_ID", cr.m4300());
        String r2 = m6570("nfvdid", cr.m4300());
        if (C1349Bv.m4107(r2)) {
            this.f15587.mo16512().mo4539(r2);
        }
        return mo986(cr.m4302());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public SignInData mo986(String str) {
        JsonObject r3 = C0848.m15512("nf_login", str);
        if (C0848.m15504(r3)) {
            throw new FalkorException("verifyLogin empty!!!");
        }
        try {
            DeviceCommandHandler.m976(this.f15583, C0848.m15509(r3, "signInVerify"));
            return (SignInData) C0848.m15506(r3, "signInVerify", SignInData.class);
        } catch (Exception e) {
            C1283.m16846("nf_login", "String response to parse = " + str);
            throw new FalkorException("response missing json objects", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo992(SignInData signInData) {
        if (signInData != null) {
            signInData.authorizationCredentials = this.f15328;
        }
        if (this.f15328 != null) {
            this.f15587.mo16517(new NonMemberData(this.f15328.netflixId, this.f15328.secureNetflixId));
        }
        if (this.f15585 != null) {
            NetflixImmutableStatus netflixImmutableStatus = AbstractC0367.f13229;
            if (signInData != null && signInData.isSignInSuccessful()) {
                netflixImmutableStatus = AbstractC0367.f13235;
            }
            this.f15585.mo1406(signInData, netflixImmutableStatus);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f15585 != null) {
            this.f15585.mo1406(null, status);
        }
    }
}
