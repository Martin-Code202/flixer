package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.AccountData;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* access modifiers changed from: package-private */
public class nQ extends AbstractC1189<AccountData> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f9022;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC2022nz f9023;

    nQ(Context context, NetflixDataRequest.Transport transport, String str, AbstractC2022nz nzVar) {
        super(context, transport);
        this.f9023 = nzVar;
        this.f9022 = "['profiles', ['" + str + "'], 'remove']";
        C1283.m16851("nf_service_user_removeuserprofilerequest", "PQL = %s", this.f9022);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ʽ */
    public Map<String, String> mo9111() {
        Map<String, String> r4 = super.mo9111();
        r4.put("pathSuffix", String.format("[{'to':%s}, 'summary']", 5));
        r4.put("pathSuffix", "['summary']");
        return r4;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ॱ */
    public String mo9116() {
        return "call";
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
        return Arrays.asList(this.f9022);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public AccountData mo9112(String str) {
        return nX.m9207(str, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo9114(AccountData accountData) {
        if (this.f9023 != null) {
            this.f9023.mo1409(accountData, AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        if (this.f9023 != null) {
            this.f9023.mo1409((AccountData) null, status);
        }
    }
}
