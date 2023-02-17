package o;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.mediaclient.android.app.Status;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* renamed from: o.օ  reason: contains not printable characters */
public class C0545 extends AbstractC0454 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f13756 = false;

    @Override // o.AbstractC0487
    /* renamed from: ˊ */
    public void mo14421(List<C0859> list) {
        list.add(C0859.m15528("lolomo", "bigRow", "getRowImpression"));
    }

    @Override // o.AbstractC0487
    /* renamed from: ॱ */
    public void mo14423(C0498 r3, AbstractC1203 r4, C0856 r5) {
        r4.mo8523(this.f13756, AbstractC0367.f13235);
    }

    @Override // o.AbstractC0487
    /* renamed from: ˋ */
    public void mo14422(AbstractC1203 r2, Status status) {
        r2.mo8523(this.f13756, status);
    }

    @Override // o.AbstractC0454, o.AbstractC0487
    /* renamed from: ॱ */
    public boolean mo14341() {
        return true;
    }

    @Override // o.AbstractC0454, o.AbstractC0487
    /* renamed from: ˎ */
    public void mo14337(JsonObject jsonObject) {
        JsonObject asJsonObject;
        JsonObject asJsonObject2;
        Set<Map.Entry<String, JsonElement>> entrySet;
        JsonObject asJsonObject3;
        this.f13756 = true;
        if (!(jsonObject == null || (asJsonObject = jsonObject.getAsJsonObject("value")) == null || (asJsonObject2 = asJsonObject.getAsJsonObject("lists")) == null || (entrySet = asJsonObject2.entrySet()) == null)) {
            for (Map.Entry<String, JsonElement> entry : entrySet) {
                if (entry.getValue().isJsonObject() && (asJsonObject3 = entry.getValue().getAsJsonObject().getAsJsonObject("getRowImpression")) != null && asJsonObject3.has("listContext")) {
                    this.f13756 = asJsonObject3.get("listContext").getAsBoolean();
                    return;
                }
            }
        }
    }
}
