package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.BladeRunnerPrefetchResponseHandler;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.FetchLicenseRequest;
import org.json.JSONObject;
/* renamed from: o.je  reason: case insensitive filesystem */
public class C1904je extends FetchLicenseRequest {

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final Long f8008;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final BladeRunnerPrefetchResponseHandler f8009;

    public C1904je(Context context, String str, boolean z, IBladeRunnerClient.LicenseRequestFlavor licenseRequestFlavor, iX iXVar, BladeRunnerPrefetchResponseHandler bladeRunnerPrefetchResponseHandler, Long l) {
        super(context, FetchLicenseRequest.LicenseReqType.STREAMING, str, z, licenseRequestFlavor, iXVar);
        this.f8009 = bladeRunnerPrefetchResponseHandler;
        this.f8008 = l;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.player.bladerunnerclient.volley.FetchLicenseRequest
    /* renamed from: ˎ */
    public void mo990(JSONObject jSONObject, Status status) {
        if (m993() && IBladeRunnerClient.LicenseRequestFlavor.LIMITED == this.f1735) {
            this.f8009.m941(this.f8008);
        }
        super.mo990(jSONObject, status);
    }
}
