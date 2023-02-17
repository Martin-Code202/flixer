package o;

import android.content.Context;
import com.android.volley.VolleyError;
import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.android.app.NetflixImmutableStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.DeviceCommandHandler;
import com.netflix.mediaclient.service.webclient.model.leafs.NonMemberData;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInData;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.ﻐ  reason: contains not printable characters */
public class C1206 extends AbstractC1084<SignInData> {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final String f15589 = "['signInVerify']";

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1221 f15590;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final String f15591;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1254 f15592;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final String f15593;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private AuthorizationCredentials f15594;

    C1206(Context context, AbstractC1221 r7, String str, String str2, AbstractC1254 r10) {
        super(context, 1);
        this.f15592 = r10;
        this.f15593 = str;
        this.f15591 = str2;
        this.f15590 = r7;
        C1283.m16848("nf_login", "PQL = %s", this.f15589);
    }

    @Override // com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.VERIFY_LOGIN;
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public Map<String, String> getParams() {
        NonMemberData r5 = this.f15590.mo16531();
        SignInConfigData r6 = this.f15590.mo16538();
        HashMap hashMap = new HashMap();
        if (r6 != null) {
            hashMap.put("flwssn", r6.flwssn);
        }
        if (r5 != null && r5.isValid()) {
            hashMap.put(LoggingRequest.NETFLIX_ID, r5.netflixId);
            hashMap.put("secureNetflixId", r5.secureNetflixId);
        }
        if (C1349Bv.m4107(this.f15590.mo16560())) {
            hashMap.put("channelId", this.f15590.mo16560());
        }
        if (C1349Bv.m4107(this.f15590.mo16502())) {
            hashMap.put("gAdvId", this.f15590.mo16502());
        }
        hashMap.put("installType", this.f15590.mo16562());
        hashMap.put(SignupConstants.Field.EMAIL, this.f15593);
        C1283.m16851("nf_login", "signInParams= %s", hashMap.toString());
        hashMap.put(SignupConstants.Field.PASSWORD, this.f15591);
        return hashMap;
    }

    @Override // o.AbstractC2035ok, o.AbstractC2040op, com.android.volley.Request
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        if (headers == null) {
            return new HashMap();
        }
        return headers;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2035ok, o.AbstractC2040op, com.android.volley.Request
    public C0524<SignInData> parseNetworkResponse(C1181 r11) {
        String str;
        if (!(r11 == null || r11.f15530 == null)) {
            this.f9360 = r11.f15530.length;
        }
        C1283.m16851("nf_login", "Response status %d", Integer.valueOf(r11.f15527));
        String str2 = r11.f15528.get("Set-Cookie");
        String r6 = C1376Cs.m4552(str2);
        this.f15594 = C1376Cs.m4548("TEMP_PROFILE_ID", str2);
        if (C1349Bv.m4107(r6)) {
            this.f15590.mo16512().mo4539(r6);
        }
        try {
            str = new String(r11.f15530, C0833.m15448(r11.f15528));
        } catch (UnsupportedEncodingException e) {
            str = new String(r11.f15530);
        }
        try {
            return C0524.m14563((SignInData) mo5785(str), null);
        } catch (Exception e2) {
            if (e2 instanceof VolleyError) {
                return C0524.m14562((VolleyError) e2);
            }
            return C0524.m14562(new VolleyError(e2));
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˏ */
    public boolean mo9692() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ʻ */
    public boolean mo9685() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2035ok
    /* renamed from: ˎ */
    public List<String> mo9668() {
        return Arrays.asList(this.f15589);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public SignInData mo9665(String str) {
        JsonObject r3 = C0848.m15512("nf_login", str);
        if (C0848.m15504(r3)) {
            throw new FalkorException("verifyLogin empty!!!");
        }
        try {
            DeviceCommandHandler.m976(this.f9337, C0848.m15509(r3, "signInVerify"));
            SignInData signInData = (SignInData) C0848.m15506(r3, "signInVerify", SignInData.class);
            signInData.authorizationCredentials = this.f15594;
            return signInData;
        } catch (Exception e) {
            C1283.m16846("nf_login", "String response to parse = " + str);
            throw new FalkorException("response missing json objects", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5640(SignInData signInData) {
        C1283.m16854("nf_login", "login verify: singInData:" + signInData);
        if (this.f15592 != null) {
            NetflixImmutableStatus netflixImmutableStatus = AbstractC0367.f13229;
            if (signInData != null && signInData.isSignInSuccessful()) {
                netflixImmutableStatus = AbstractC0367.f13235;
            }
            this.f15592.mo1406(signInData, netflixImmutableStatus);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5637(Status status) {
        if (this.f15592 != null) {
            this.f15592.mo1406(null, status);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2035ok
    /* renamed from: ʼ */
    public boolean mo9664() {
        return false;
    }
}
