package o;

import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipCallConfigData;
import java.util.List;
import java.util.Map;
/* renamed from: o.ﮌ  reason: contains not printable characters */
public class C1143 extends AbstractC1094<VoipCallConfigData> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private List<String> f15391;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC0477 f15392;

    @Override // o.AbstractC1094, com.android.volley.Request
    public /* bridge */ /* synthetic */ Request.Priority getPriority() {
        return super.getPriority();
    }

    @Override // o.AbstractC1094, com.android.volley.Request
    public /* bridge */ /* synthetic */ Object getTag() {
        return super.getTag();
    }

    @Override // o.AbstractC1094, o.gV
    /* renamed from: ʽ */
    public /* bridge */ /* synthetic */ String mo6586() {
        return super.mo6586();
    }

    public C1143(List<String> list, AbstractC0477 r2) {
        this.f15391 = list;
        this.f15392 = r2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return this.f15391;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1094, o.AbstractC1807gM, com.android.volley.Request
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("supportedSdks", "DIRECT");
        return params;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public VoipCallConfigData mo986(String str) {
        return C1098.m16205(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo992(VoipCallConfigData voipCallConfigData) {
        if (this.f15392 != null) {
            this.f15392.mo3735(voipCallConfigData, AbstractC0367.f13235);
        }
        this.f15392 = null;
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f15392 != null) {
            this.f15392.mo3735(null, status);
        }
        this.f15392 = null;
    }
}
