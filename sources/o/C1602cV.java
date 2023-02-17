package o;

import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.SignInLogging;
import org.json.JSONObject;
/* renamed from: o.cV  reason: case insensitive filesystem */
public class C1602cV extends SessionEndedEvent {

    /* renamed from: ˋ  reason: contains not printable characters */
    private SignInLogging.CredentialService f6247;

    /* renamed from: ˏ  reason: contains not printable characters */
    private IClientLogging.CompletionReason f6248;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Error f6249;

    public C1602cV(IClientLogging.CompletionReason completionReason, Error error, SignInLogging.CredentialService credentialService) {
        super("credentialRetrieval");
        if (completionReason == null) {
            throw new IllegalStateException("Completion reason is missing");
        } else if (credentialService == null) {
            throw new IllegalStateException("Credential service is missing");
        } else {
            this.f6248 = completionReason;
            this.f6249 = error;
            this.f6247 = credentialService;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("reason", this.f6248.name());
        data.put("credentialService", this.f6247);
        if (this.f6249 != null) {
            data.put(ExceptionClEvent.CATEGORY_VALUE, this.f6249.toJSONObject());
        }
        return data;
    }
}
