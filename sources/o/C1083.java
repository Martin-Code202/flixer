package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.webclient.AUIApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import com.netflix.mediaclient.service.webclient.model.leafs.NonMemberData;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInConfigData;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.ッ  reason: contains not printable characters */
public class C1083 extends AbstractC1111<MoneyballData> {

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected AUIApiEndpointRegistry f15258 = this.f15288.mo16162();

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private List<String> f15259;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final AbstractC1113 f15260;

    C1083(Context context, AbstractC1194 r3, AbstractC1221 r4, List<String> list, AbstractC1113 r6) {
        super(context, r4);
        this.f15288 = r3;
        this.f15259 = list;
        this.f15260 = r6;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1103
    /* renamed from: ʼ  reason: contains not printable characters */
    public List<String> mo16174() {
        return this.f15259;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public MoneyballData mo16175(String str) {
        return C1121.m16270(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo5640(MoneyballData moneyballData) {
        if (this.f15260 != null) {
            this.f15260.onDataFetched(moneyballData, AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5637(Status status) {
        if (this.f15260 != null) {
            this.f15260.onDataFetched(null, status);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap();
        NonMemberData r6 = this.f15291.mo16531();
        SignInConfigData r7 = this.f15291.mo16538();
        if (r7 != null) {
            hashMap.put("flwssn", r7.flwssn);
        }
        if (r6 != null && r6.isValid()) {
            hashMap.put(LoggingRequest.NETFLIX_ID, r6.netflixId);
            hashMap.put("secureNetflixId", r6.secureNetflixId);
        }
        if (C1349Bv.m4107(this.f15291.mo16560())) {
            hashMap.put("channelId", this.f15291.mo16560());
        }
        String r8 = this.f15291.mo16502();
        if (C1349Bv.m4107(r8)) {
            hashMap.put("gAdvId", r8);
        }
        C1283.m16851("nf_moneyball_data", "fetchParams: %s", hashMap.toString());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1103, o.AbstractC2040op, com.android.volley.Request
    public C0524<MoneyballData> parseNetworkResponse(C1181 r5) {
        String r3 = C1376Cs.m4552(r5.f15528.get("Set-Cookie"));
        if (C1349Bv.m4107(r3)) {
            this.f15291.mo16512().mo4539(r3);
        }
        return super.parseNetworkResponse(r5);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1103, o.AbstractC2040op
    /* renamed from: ˏ */
    public String mo5784(String str) {
        String r4 = m16213();
        StringBuilder sb = new StringBuilder(str);
        sb.append(BG.m3860("method", mo5781(), "?"));
        if (m16210()) {
            sb.append(BG.m3860("materialize", "true", "&"));
        }
        sb.append(r4);
        AW aw = (AW) this.f15258.mo1448();
        for (String str2 : aw.keySet()) {
            for (String str3 : aw.mo3487(str2)) {
                sb.append(BG.m3860(str2, URLEncoder.encode(str3), "&"));
            }
        }
        String r7 = mo9695();
        if (C1349Bv.m4107(r7)) {
            sb.append(r7);
        }
        m16211(sb);
        String sb2 = sb.toString();
        C1283.m16848("nf_moneyball_data", "FetchMoneyballModeRequest URL = %s", sb2);
        return sb2;
    }
}
