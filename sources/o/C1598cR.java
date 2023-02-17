package o;

import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.SignInLogging;
import org.json.JSONObject;
/* renamed from: o.cR  reason: case insensitive filesystem */
public class C1598cR extends SessionEndedEvent {

    /* renamed from: ˊ  reason: contains not printable characters */
    private SignInLogging.CredentialService f6242;

    /* renamed from: ˎ  reason: contains not printable characters */
    private IClientLogging.CompletionReason f6243;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Error f6244;

    public C1598cR(IClientLogging.CompletionReason completionReason, Error error, SignInLogging.CredentialService credentialService) {
        super("credentialRetrieval");
        if (completionReason == null) {
            throw new IllegalStateException("Completion reason is missing");
        } else if (credentialService == null) {
            throw new IllegalStateException("Credential service is missing");
        } else {
            this.f6243 = completionReason;
            this.f6244 = error;
            this.f6242 = credentialService;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("reason", this.f6243.name());
        data.put("credentialService", this.f6242);
        if (this.f6244 != null) {
            data.put(ExceptionClEvent.CATEGORY_VALUE, this.f6244.toJSONObject());
        }
        return data;
    }
}
