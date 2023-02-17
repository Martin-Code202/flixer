package o;

import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.SignInLogging;
/* renamed from: o.cQ  reason: case insensitive filesystem */
public class C1597cQ extends AbstractC1596cP {

    /* renamed from: ˏ  reason: contains not printable characters */
    private SignInLogging.CredentialService f6241;

    @Override // o.AbstractC1596cP, o.AbstractC1560bi
    /* renamed from: ˋ */
    public /* bridge */ /* synthetic */ String mo5643() {
        return super.mo5643();
    }

    public C1597cQ(SignInLogging.CredentialService credentialService) {
        if (credentialService == null) {
            throw new IllegalStateException("Missing credential service");
        }
        this.f6241 = credentialService;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "credentialRetrieval";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1598cR m5836(IClientLogging.CompletionReason completionReason, Error error) {
        C1598cR cRVar = new C1598cR(completionReason, error, this.f6241);
        cRVar.setCategory(mo5643());
        return cRVar;
    }
}
