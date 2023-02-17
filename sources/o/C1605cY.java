package o;

import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.SignInLogging;
import org.json.JSONObject;
/* renamed from: o.cY  reason: case insensitive filesystem */
public class C1605cY extends SessionEndedEvent {

    /* renamed from: ˊ  reason: contains not printable characters */
    private IClientLogging.CompletionReason f6250;

    /* renamed from: ˋ  reason: contains not printable characters */
    private SignInLogging.CredentialSaved f6251;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Error f6252;

    /* renamed from: ˏ  reason: contains not printable characters */
    private SignInLogging.SignInType f6253;

    public C1605cY(SignInLogging.SignInType signInType, IClientLogging.CompletionReason completionReason, Error error, SignInLogging.CredentialSaved credentialSaved) {
        super("signInRequest");
        if (completionReason == null) {
            throw new IllegalStateException("Completion reason is missing");
        } else if (signInType == null) {
            throw new IllegalStateException("SignIn type is missing");
        } else {
            this.f6250 = completionReason;
            this.f6252 = error;
            this.f6253 = signInType;
            this.f6251 = credentialSaved;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("signInType", this.f6253);
        data.put("reason", this.f6250.name());
        if (this.f6252 != null) {
            data.put(ExceptionClEvent.CATEGORY_VALUE, this.f6252.toJSONObject());
        }
        if (this.f6251 != null) {
            data.put("credentialSaved", this.f6251);
        }
        return data;
    }
}
