package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.AccountData;
import java.util.Arrays;
import java.util.List;
/* access modifiers changed from: package-private */
public class nF extends AbstractC1810gP<AccountData> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f8994 = "['profilesList', 'summary']";

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC2022nz f8995;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final String f8996 = "['user', ['summary', 'subtitleDefaults', 'umaEog', 'uma', 'thumbMessaging']]";

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final String f8997 = ("['profilesList', {'to':5}, ['summary', 'subtitlePreference']]");

    nF(AbstractC2022nz nzVar) {
        this.f8995 = nzVar;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return Arrays.asList(this.f8994, this.f8997, this.f8996);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public AccountData mo6580(CR cr) {
        return (AccountData) super.mo6580(cr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public AccountData mo986(String str) {
        return nX.m9207(str, true);
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f8995 != null) {
            this.f8995.mo1394((AccountData) null, status);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo992(AccountData accountData) {
        if (this.f8995 != null) {
            this.f8995.mo1394(accountData, AbstractC0367.f13235);
        }
    }
}
