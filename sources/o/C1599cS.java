package o;

import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.SignInLogging;
/* renamed from: o.cS  reason: case insensitive filesystem */
public class C1599cS extends AbstractC1596cP {

    /* renamed from: ˎ  reason: contains not printable characters */
    private SignInLogging.SignInType f6245;

    @Override // o.AbstractC1596cP, o.AbstractC1560bi
    /* renamed from: ˋ */
    public /* bridge */ /* synthetic */ String mo5643() {
        return super.mo5643();
    }

    public C1599cS(SignInLogging.SignInType signInType) {
        if (signInType == null) {
            throw new IllegalStateException("SignIn type is missing");
        }
        this.f6245 = signInType;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "signInRequest";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1605cY m5837(IClientLogging.CompletionReason completionReason, Error error, SignInLogging.CredentialSaved credentialSaved) {
        C1605cY cYVar = new C1605cY(this.f6245, completionReason, error, credentialSaved);
        cYVar.setCategory(mo5643());
        return cYVar;
    }
}
