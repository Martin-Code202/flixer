package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.BladeRunnerPrefetchResponseHandler;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import org.json.JSONObject;
/* renamed from: o.jk  reason: case insensitive filesystem */
public class C1910jk extends C1906jg {

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final Long[] f8021;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final BladeRunnerPrefetchResponseHandler f8022;

    public C1910jk(Context context, String str, IBladeRunnerClient.ManifestRequestFlavor manifestRequestFlavor, iX iXVar, BladeRunnerPrefetchResponseHandler bladeRunnerPrefetchResponseHandler, Long[] lArr) {
        super(context, str, manifestRequestFlavor, iXVar);
        this.f8022 = bladeRunnerPrefetchResponseHandler;
        this.f8021 = lArr;
    }

    /* access modifiers changed from: protected */
    @Override // o.C1906jg
    /* renamed from: ˋ */
    public void mo8001(JSONObject jSONObject, Status status) {
        if (IBladeRunnerClient.ManifestRequestFlavor.PREFETCH == this.f8013) {
            this.f8022.m937(this.f8021);
        }
        super.mo8001(jSONObject, status);
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public Long[] m8010() {
        return this.f8021;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public void m8011() {
        super.mo8001((JSONObject) null, AbstractC0367.f13257);
    }
}
