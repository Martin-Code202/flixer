package com.netflix.mediaclient.service.player.bladerunnerclient.volley;

import android.content.Context;
import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.player.bladerunnerclient.OfflineLicenseResponse;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import o.AbstractC0367;
import o.AbstractC1907jh;
import o.C1283;
import o.C1905jf;
import o.iT;
import o.iX;
import org.json.JSONException;
import org.json.JSONObject;
public class FetchLicenseRequest extends AbstractC1907jh {

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private static final String f1729 = iT.f7647;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final String f1730;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final boolean f1731;

    /* renamed from: ʿ  reason: contains not printable characters */
    private final String f1732 = "['license']";

    /* renamed from: ˈ  reason: contains not printable characters */
    private final LicenseReqType f1733;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final iX f1734;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected final IBladeRunnerClient.LicenseRequestFlavor f1735;

    public enum LicenseReqType {
        STREAMING,
        OFFLINE
    }

    public FetchLicenseRequest(Context context, LicenseReqType licenseReqType, String str, boolean z, IBladeRunnerClient.LicenseRequestFlavor licenseRequestFlavor, iX iXVar) {
        super(context);
        this.f1733 = licenseReqType;
        this.f1730 = str;
        this.f1734 = iXVar;
        this.f1731 = z;
        this.f1735 = licenseRequestFlavor;
    }

    @Override // o.AbstractC1810gP, com.android.volley.Request
    public Request.Priority getPriority() {
        return IBladeRunnerClient.LicenseRequestFlavor.LIMITED == this.f1735 ? Request.Priority.NORMAL : Request.Priority.IMMEDIATE;
    }

    @Override // o.AbstractC1810gP, com.android.volley.Request
    public Object getTag() {
        return IBladeRunnerClient.LicenseRequestFlavor.LIMITED == this.f1735 ? NetworkRequestType.PLAY_PREFETCH_LICENSE : NetworkRequestType.PLAY_LICENSE;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1810gP, o.AbstractC1807gM, com.android.volley.Request
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("bladerunnerParams", this.f1730);
        return params;
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public Boolean mo987() {
        return Boolean.TRUE;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ  reason: contains not printable characters */
    public List<String> mo989() {
        return Arrays.asList(this.f1732);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public JSONObject mo986(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            C1283.m16847(f1729, "error parsing json", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo992(JSONObject jSONObject) {
        JSONObject r2 = C1905jf.m7998(f1729, "license", jSONObject);
        JSONObject jSONObject2 = r2;
        if (r2 != null) {
            jSONObject2 = r2.optJSONObject("result");
        }
        Status r4 = C1905jf.m7995(this.f8016, r2, m985());
        if (r4.mo298() && !m984(jSONObject2)) {
            r4 = AbstractC0367.f13231;
        }
        if (this.f1734 != null) {
            mo990(jSONObject2, r4);
        } else {
            C1283.m16865(f1729, "callback null?");
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo991(Status status) {
        if (this.f1734 != null) {
            mo990((JSONObject) null, status);
        } else {
            C1283.m16865(f1729, "callback null?");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public boolean m993() {
        return this.f1733 == LicenseReqType.STREAMING;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m984(JSONObject jSONObject) {
        return BladerunnerErrorStatus.m958(jSONObject);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo990(JSONObject jSONObject, Status status) {
        if (m993()) {
            this.f1734.mo7616(jSONObject, status);
            return;
        }
        OfflineLicenseResponse offlineLicenseResponse = new OfflineLicenseResponse(jSONObject);
        C1283.m16851(f1729, "onLicenseFetched type:%s, licenseResponse: %s", this.f1733, offlineLicenseResponse);
        this.f1734.mo6962(offlineLicenseResponse, status);
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private BladerunnerErrorStatus.BrRequestType m985() {
        if (this.f1733 == LicenseReqType.STREAMING) {
            return BladerunnerErrorStatus.BrRequestType.StreamingLicense;
        }
        return this.f1731 ? BladerunnerErrorStatus.BrRequestType.OfflineLicenseRefresh : BladerunnerErrorStatus.BrRequestType.OfflineLicense;
    }
}
