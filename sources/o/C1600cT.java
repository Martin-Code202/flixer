package o;

import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.SignInLogging;
/* renamed from: o.cT  reason: case insensitive filesystem */
public class C1600cT extends AbstractC1596cP {

    /* renamed from: ˏ  reason: contains not printable characters */
    private SignInLogging.CredentialService f6246;

    @Override // o.AbstractC1596cP, o.AbstractC1560bi
    /* renamed from: ˋ */
    public /* bridge */ /* synthetic */ String mo5643() {
        return super.mo5643();
    }

    public C1600cT(SignInLogging.CredentialService credentialService) {
        if (credentialService == null) {
            throw new IllegalStateException("Missing credential service");
        }
        this.f6246 = credentialService;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "credentialStore";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1602cV m5838(IClientLogging.CompletionReason completionReason, Error error) {
        C1602cV cVVar = new C1602cV(completionReason, error, this.f6246);
        cVVar.setCategory(mo5643());
        return cVVar;
    }
}
