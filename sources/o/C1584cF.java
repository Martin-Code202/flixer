package o;

import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import com.netflix.mediaclient.service.logging.client.model.EventType;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.ISearchLogging;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.cF  reason: case insensitive filesystem */
public class C1584cF extends DiscreteEvent {

    /* renamed from: ˋ  reason: contains not printable characters */
    private ISearchLogging.InputMode f6219;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6220;

    /* renamed from: ˏ  reason: contains not printable characters */
    private ISearchLogging.SearchType f6221;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f6222;

    public C1584cF(String str, ISearchLogging.InputMode inputMode, ISearchLogging.SearchType searchType, boolean z) {
        this.f6220 = str;
        this.f6219 = inputMode;
        this.f6221 = searchType;
        this.f6222 = z;
        m5818();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5818() {
        this.modalView = IClientLogging.ModalView.search;
        this.type = EventType.edit;
        this.category = "uiView";
        this.name = "edit";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put(FalkorPathResult.PATH, new JSONArray("['" + this.f6221.name() + "']"));
        data.put("value", this.f6220);
        if (this.f6219 == null) {
            this.f6219 = ISearchLogging.InputMode.keyboard;
        }
        data.put("mode", this.f6219.toString());
        if (this.f6222) {
            data.put("isPreQuery", true);
        }
        return data;
    }
}
