package o;

import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.eu  reason: case insensitive filesystem */
public class C1734eu extends AbstractC1730eq {

    /* renamed from: ʼ  reason: contains not printable characters */
    private JSONObject f6698;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6699;

    public C1734eu(IClientLogging.ModalView modalView, String str) {
        this(modalView, str, null);
    }

    public C1734eu(IClientLogging.ModalView modalView, String str, JSONObject jSONObject) {
        super(modalView);
        this.f6699 = str;
        this.f6698 = jSONObject;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "impression";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1737ex m6347(boolean z, Error error) {
        C1737ex exVar = new C1737ex(this.f6158, System.currentTimeMillis() - this.f6160, this.f6691, this.f6699, z, error);
        exVar.setCategory(mo5643());
        exVar.setSessionId(this.f6158);
        if (this.f6698 != null) {
            exVar.m6348(this.f6698);
        }
        return exVar;
    }
}
