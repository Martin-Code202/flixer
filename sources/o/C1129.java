package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.webclient.model.leafs.ConfigData;
import java.net.URLEncoder;
import java.util.List;
/* access modifiers changed from: package-private */
/* renamed from: o.ﭴ  reason: contains not printable characters */
public class C1129 extends AbstractC1084<ConfigData> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1254 f15362;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private AbstractC1221 f15363;

    /* renamed from: ॱ  reason: contains not printable characters */
    private List<String> f15364;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f15365;

    C1129(Context context, AbstractC1221 r2, List<String> list, boolean z, AbstractC1254 r5) {
        super(context);
        this.f15363 = r2;
        this.f15364 = list;
        this.f15365 = z;
        this.f15362 = r5;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˏ */
    public boolean mo9692() {
        return this.f15365;
    }

    @Override // com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.CONFIG;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2035ok
    /* renamed from: ˎ */
    public List<String> mo9668() {
        return this.f15364;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ʻ */
    public boolean mo9685() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public ConfigData mo9665(String str) {
        return C1098.m16204(this.f9337, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5640(ConfigData configData) {
        if (this.f15362 != null) {
            this.f15362.mo1407(configData, AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5637(Status status) {
        if (this.f15362 != null) {
            this.f15362.mo1407(null, status);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2035ok, o.AbstractC2040op
    /* renamed from: ˏ */
    public String mo5784(String str) {
        String r4 = m9671();
        StringBuilder sb = new StringBuilder(str);
        sb.append(BG.m3860("method", mo5781(), "?"));
        if (mo9670()) {
            sb.append(BG.m3860("materialize", "true", "&"));
        }
        sb.append(r4);
        AW aw = (AW) this.f9334.mo1453();
        for (String str2 : aw.keySet()) {
            for (String str3 : aw.mo3487(str2)) {
                sb.append(BG.m3860(str2, URLEncoder.encode(str3), "&"));
            }
        }
        String r7 = mo9695();
        if (C1349Bv.m4107(r7)) {
            sb.append(r7);
        }
        m9666(sb);
        String sb2 = sb.toString();
        C1283.m16848("nf_config_data", "FetchConfigDataWebRequest URL = %s", sb2);
        return sb2;
    }
}
