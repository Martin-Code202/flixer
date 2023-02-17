package o;

import com.android.volley.VolleyError;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
import java.util.Arrays;
import java.util.List;
public class nH extends AbstractC1810gP<AuthorizationCredentials> {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f9000 = nH.class.getSimpleName();

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC2022nz f9001;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final String f9002 = "['bind']";

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private AuthorizationCredentials f9003;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private String f9004;

    nH(String str, AbstractC2022nz nzVar) {
        this.f9001 = nzVar;
        this.f9004 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return Arrays.asList("['bind']");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public AuthorizationCredentials mo6580(CR cr) {
        this.f9003 = m6569(m6621().mo1403(), cr.m4300());
        if (this.f9003 != null) {
            return (AuthorizationCredentials) super.mo6580(cr);
        }
        C1283.m16850(f9000, "Cookies are missing in bind call, profile switch fail");
        C1276.m16820().mo5727("Cookies are missing in bind call, profile switch fail");
        throw new VolleyError("Cookies are missing in bind call, profile switch fail");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public AuthorizationCredentials mo986(String str) {
        C1283.m16848(f9000, "String response to parse = %s", str);
        return this.f9003;
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f9001 != null) {
            this.f9001.mo1402((AuthorizationCredentials) null, status);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo992(AuthorizationCredentials authorizationCredentials) {
        if (this.f9001 != null) {
            authorizationCredentials.userId = this.f9004;
            this.f9001.mo1402(authorizationCredentials, AbstractC0367.f13235);
        }
    }
}
