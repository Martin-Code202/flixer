package o;

import android.content.Context;
import android.text.TextUtils;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.AccountData;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
public class nI extends AbstractC1189<AccountData> {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f9005;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f9006;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f9007;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC2022nz f9008;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final boolean f9009;

    nI(Context context, NetflixDataRequest.Transport transport, String str, String str2, boolean z, String str3, AbstractC2022nz nzVar) {
        super(context, transport);
        this.f9008 = nzVar;
        this.f9006 = str2;
        this.f9009 = z;
        this.f9005 = str3;
        this.f9007 = "['profiles', ['" + str + "'], 'edit']";
        C1283.m16848("nf_service_user_adduserprofilerequest", "PQL = %s", this.f9007);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ॱ */
    public String mo9116() {
        return "call";
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ʽ */
    public Map<String, String> mo9111() {
        Map<String, String> r4 = super.mo9111();
        r4.put("param", "'" + this.f9006 + "'");
        r4.put("param", this.f9009 ? "\"jfk\"" : "\"standard\"");
        if (!TextUtils.isEmpty(this.f9005)) {
            r4.put("param", "\"" + this.f9005 + "\"");
        }
        r4.put("pathSuffix", String.format("[{'to':%s}, 'summary']", 5));
        r4.put("pathSuffix", "['summary']");
        return r4;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˏ */
    public boolean mo9121() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return Arrays.asList(this.f9007);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public AccountData mo9112(String str) {
        return nX.m9207(str, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo9114(AccountData accountData) {
        if (this.f9008 != null) {
            this.f9008.mo1409(accountData, AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        if (this.f9008 != null) {
            this.f9008.mo1409((AccountData) null, status);
        }
    }
}
