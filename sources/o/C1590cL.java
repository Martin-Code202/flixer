package o;

import android.annotation.SuppressLint;
import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import com.netflix.mediaclient.service.logging.client.model.EventType;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONArray;
import org.json.JSONObject;
@SuppressLint({"DefaultLocale"})
/* renamed from: o.cL  reason: case insensitive filesystem */
public class C1590cL extends DiscreteEvent {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6227;

    /* renamed from: ˋ  reason: contains not printable characters */
    private IClientLogging.ModalView f6228;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f6229;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String[] f6230;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f6231;

    public C1590cL(String str, int i, int i2, String[] strArr, IClientLogging.ModalView modalView, IClientLogging.ModalView modalView2) {
        m5829(str, i, i2, strArr, modalView, modalView2);
        m5830(modalView);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5829(String str, int i, int i2, String[] strArr, IClientLogging.ModalView modalView, IClientLogging.ModalView modalView2) {
        this.modalView = modalView;
        this.f6230 = strArr;
        this.f6227 = str;
        this.f6231 = i;
        this.f6228 = modalView2;
        this.f6229 = i2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5830(IClientLogging.ModalView modalView) {
        this.modalView = modalView;
        this.type = EventType.event;
        this.category = "uiView";
        this.name = getName();
        this.name = "impression";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        String str;
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6230 == null || this.f6230.length <= 0) {
            str = String.format("['search', 'lists', '%s',{'from': %d, 'to': %d}]", this.f6227, Integer.valueOf(this.f6231), Integer.valueOf(this.f6229));
        } else {
            str = String.format("['search', 'lists', '%s',{'from': %d, 'to': %d,'ids':[%s]}]", this.f6227, Integer.valueOf(this.f6231), Integer.valueOf(this.f6229), m5828());
        }
        data.put(FalkorPathResult.PATH, new JSONArray(str));
        if (this.f6228 != null) {
            data.put("view", this.f6228.name());
        }
        return data;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private String m5828() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f6230.length; i++) {
            sb.append('\'').append(this.f6230[i]).append('\'');
            if (i == this.f6230.length - 1) {
                break;
            }
            sb.append(',');
        }
        return sb.toString();
    }
}
