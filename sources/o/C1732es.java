package o;

import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import org.json.JSONObject;
/* renamed from: o.es  reason: case insensitive filesystem */
public final class C1732es extends AbstractC1730eq {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected CommandEndedEvent.InputValue f6692;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected JSONObject f6693;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected JSONObject f6694;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected UIViewLogging.UIViewCommandName f6695;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected String f6696;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected CommandEndedEvent.InputMethod f6697;

    public C1732es(UIViewLogging.UIViewCommandName uIViewCommandName, IClientLogging.ModalView modalView, String str, CommandEndedEvent.InputValue inputValue, JSONObject jSONObject) {
        this(uIViewCommandName, modalView, str, null, inputValue, jSONObject, null);
    }

    public C1732es(UIViewLogging.UIViewCommandName uIViewCommandName, IClientLogging.ModalView modalView, String str, CommandEndedEvent.InputMethod inputMethod, CommandEndedEvent.InputValue inputValue, JSONObject jSONObject, JSONObject jSONObject2) {
        super(modalView);
        this.f6695 = uIViewCommandName;
        this.f6696 = str;
        this.f6697 = inputMethod;
        this.f6692 = inputValue;
        this.f6694 = jSONObject;
        this.f6693 = jSONObject2;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "command";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public CommandEndedEvent m6344() {
        CommandEndedEvent commandEndedEvent = new CommandEndedEvent(this.f6158, System.currentTimeMillis() - this.f6160, m6343(), this.f6696);
        commandEndedEvent.setCategory(mo5643());
        commandEndedEvent.setSessionId(this.f6158);
        commandEndedEvent.m675(this.f6697);
        commandEndedEvent.m676(this.f6692);
        commandEndedEvent.m678(this.f6694);
        commandEndedEvent.m677(this.f6693);
        return commandEndedEvent;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public UIViewLogging.UIViewCommandName m6343() {
        return this.f6695;
    }
}
