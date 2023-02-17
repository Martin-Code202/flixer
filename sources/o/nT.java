package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
public class nT extends AbstractC1189<String> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f9033;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f9034 = "['ums', 'setImpression']";

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f9035;

    nT(Context context, NetflixDataRequest.Transport transport, String str, String str2) {
        super(context, transport);
        this.f9035 = str2;
        this.f9033 = str;
        C1283.m16848("eog_RecordEogImpression", "PQL = %s", "['ums', 'setImpression']");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ॱ */
    public String mo9116() {
        return "call";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return Arrays.asList("['ums', 'setImpression']");
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002c: APUT  (r2v3 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v3 java.lang.String) */
    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ʽ */
    public Map<String, String> mo9111() {
        Map<String, String> r5 = super.mo9111();
        r5.put("param", String.format("'%s'", this.f9033));
        Object[] objArr = new Object[1];
        objArr[0] = C1349Bv.m4113(this.f9035) ? "back" : this.f9035;
        r5.put("param", String.format("'%s'", objArr));
        return r5;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˏ */
    public boolean mo9121() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo9112(String str) {
        C1283.m16848("eog_RecordEogImpression", "String response to parse = %s", str);
        return str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo9114(String str) {
    }
}
