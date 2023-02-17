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
public class nE extends AbstractC1189<AccountData> {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f8989;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f8990 = new StringBuilder("['profilesList', 'add']").toString();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC2022nz f8991;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f8992;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final boolean f8993;

    nE(Context context, NetflixDataRequest.Transport transport, String str, boolean z, String str2, AbstractC2022nz nzVar) {
        super(context, transport);
        this.f8991 = nzVar;
        this.f8989 = str;
        this.f8993 = z;
        this.f8992 = str2;
        C1283.m16848("nf_service_user_adduserprofilerequest", "PQL = %s", this.f8990);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ʽ */
    public Map<String, String> mo9111() {
        Map<String, String> r4 = super.mo9111();
        r4.put("param", "'" + this.f8989 + "'");
        r4.put("param", this.f8993 ? "\"jfk\"" : "\"standard\"");
        if (!TextUtils.isEmpty(this.f8992)) {
            r4.put("param", "\"" + this.f8992 + "\"");
        }
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
        return Arrays.asList(this.f8990);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public AccountData mo9112(String str) {
        return nX.m9207(str, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo9114(AccountData accountData) {
        if (this.f8991 != null) {
            this.f8991.mo1409(accountData, AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        if (this.f8991 != null) {
            this.f8991.mo1409((AccountData) null, status);
        }
    }
}
