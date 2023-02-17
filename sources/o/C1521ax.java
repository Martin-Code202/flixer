package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
/* renamed from: o.ax  reason: case insensitive filesystem */
public class C1521ax extends AbstractC1679ds {

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f6101;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f6102;

    public C1521ax(UserActionLogging.CommandName commandName, String str, String str2) {
        super(commandName, null);
        this.f6101 = str;
        this.f6102 = str2;
    }

    @Override // o.AbstractC1679ds, o.AbstractC1560bi
    /* renamed from: ˋ */
    public String mo5643() {
        return "preAppAndroid";
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "androidWidgetCommand";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1516au m5703(IClientLogging.CompletionReason completionReason, UIError uIError) {
        C1516au auVar = new C1516au("androidWidgetCommand", this.f6158, System.currentTimeMillis() - this.f6160, null, this.f6436, completionReason, uIError, this.f6101, this.f6102);
        auVar.setCategory(mo5643());
        auVar.setSessionId(this.f6158);
        return auVar;
    }
}
