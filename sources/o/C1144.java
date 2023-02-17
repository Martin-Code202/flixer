package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipCallConfigData;
import java.util.List;
/* access modifiers changed from: package-private */
/* renamed from: o.ﮐ  reason: contains not printable characters */
public class C1144 extends AbstractC1084<VoipCallConfigData> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC0477 f15393;

    /* renamed from: ॱ  reason: contains not printable characters */
    private List<String> f15394;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f15395;

    C1144(Context context, List<String> list, boolean z, AbstractC0477 r4) {
        super(context);
        this.f15394 = list;
        this.f15395 = z;
        this.f15393 = r4;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˏ */
    public boolean mo9692() {
        return this.f15395;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ॱ */
    public String mo9695() {
        StringBuilder sb = new StringBuilder();
        sb.append(BE.m3839("supportedSdks", "DIRECT"));
        C1283.m16851("nf_voip_config_data", "optional params: %s", sb.toString());
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2035ok
    /* renamed from: ˎ */
    public List<String> mo9668() {
        return this.f15394;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ʻ */
    public boolean mo9685() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public VoipCallConfigData mo9665(String str) {
        return C1098.m16205(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo5640(VoipCallConfigData voipCallConfigData) {
        if (this.f15393 != null) {
            this.f15393.mo3735(voipCallConfigData, AbstractC0367.f13235);
        }
        this.f15393 = null;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5637(Status status) {
        if (this.f15393 != null) {
            this.f15393.mo3735(null, status);
        }
        this.f15393 = null;
    }

    @Override // com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.CONFIG_VOIP;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2035ok, o.AbstractC2040op
    /* renamed from: ˏ */
    public String mo5784(String str) {
        String r4 = m9671();
        StringBuilder sb = new StringBuilder(str);
        sb.append(BG.m3860("method", mo5781(), "?"));
        sb.append(r4);
        AW aw = (AW) this.f9334.mo1453();
        for (String str2 : aw.keySet()) {
            for (String str3 : aw.mo3487(str2)) {
                sb.append(BG.m3860(str2, str3, "&"));
            }
        }
        String r7 = mo9695();
        if (C1349Bv.m4107(r7)) {
            sb.append(r7);
        }
        m9666(sb);
        String sb2 = sb.toString();
        C1283.m16848("nf_voip_config_data", "FetchConfigDataWebRequest URL = %s", sb2);
        return sb2;
    }
}
