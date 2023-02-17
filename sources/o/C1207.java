package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
/* renamed from: o.ﻛ  reason: contains not printable characters */
public class C1207 extends AbstractC1084<String> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f15595;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f15596;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final String f15597;

    C1207(Context context, String str, AbstractC2033oi oiVar) {
        super(context, 1);
        this.f15595 = str;
        if (oiVar != null) {
            this.f15596 = oiVar.m9654();
        }
        this.f15597 = "['reportVoipPostCallInfo']";
        C1283.m16848("nf_voip", "PQL = %s", this.f15597);
    }

    @Override // com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.LOG_VOIP;
    }

    /* access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("authtoken", this.f15595);
        hashMap.put("callstats", this.f15596.toString());
        return hashMap;
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
        return Arrays.asList(this.f15597);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public String mo9665(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo5640(String str) {
        C1283.m16854("nf_voip", "VoIP call stats sent successfully");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5637(Status status) {
        C1283.m16865("nf_voip", "Failed to send VoIP call stats");
    }
}
