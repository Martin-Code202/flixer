package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballCallData;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import com.netflix.mediaclient.service.webclient.model.leafs.NonMemberData;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInConfigData;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* renamed from: o.ﺟ  reason: contains not printable characters */
public class C1192 extends AbstractC1111<MoneyballData> {

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final AbstractC1113 f15574;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private MoneyballCallData f15575;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final List<String> f15576 = Arrays.asList("['" + f15329 + "', 'next']", "['" + f15329 + "', 'context']");

    @Override // o.AbstractC1111, com.android.volley.Request
    public /* bridge */ /* synthetic */ Object getTag() {
        return super.getTag();
    }

    @Override // o.AbstractC1111, o.AbstractC2040op
    /* renamed from: ˋ */
    public /* bridge */ /* synthetic */ void mo5783(ApiEndpointRegistry apiEndpointRegistry) {
        super.mo5783(apiEndpointRegistry);
    }

    C1192(Context context, AbstractC1194 r5, AbstractC1221 r6, MoneyballCallData moneyballCallData, AbstractC1113 r8) {
        super(context, r6, 1);
        this.f15288 = r5;
        this.f15574 = r8;
        this.f15575 = moneyballCallData;
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
        C1283.m16851("nf_moneyball_data", "nextParams: %s", hashMap.toString());
        C1283.m16851("nf_moneyball_data", "nextKeys: %s", this.f15575.getFieldValueMap().keySet().toString());
        hashMap.put("param", this.f15575.toJsonString());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1103
    /* renamed from: ʼ */
    public List<String> mo16174() {
        return this.f15576;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public MoneyballData mo16175(String str) {
        return C1121.m16270(str);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1103, o.AbstractC2040op
    /* renamed from: ˊ */
    public String mo5781() {
        return "call";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo5640(MoneyballData moneyballData) {
        if (this.f15574 != null) {
            this.f15574.onDataFetched(moneyballData, AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5637(Status status) {
        if (this.f15574 != null) {
            this.f15574.onDataFetched(null, status);
        }
    }
}
