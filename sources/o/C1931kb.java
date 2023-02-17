package o;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import org.json.JSONObject;
/* renamed from: o.kb  reason: case insensitive filesystem */
public final class C1931kb extends C1934ke {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f8373 = f8373;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0140 f8374 = new C0140(null);

    /* renamed from: ˎ  reason: contains not printable characters */
    private UmaAlert f8375;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1931kb(String str, String str2, JSONObject jSONObject) {
        super(str, str2, jSONObject);
        C1457Fr.m5025(str, "userDisplayErrMsg");
        C1457Fr.m5025(str2, "displayErrorCode");
        C1457Fr.m5025(jSONObject, "extraInfo");
        try {
            C1281 r3 = C1281.f15992;
            Object fromJson = ((Gson) C1281.m16832(Gson.class)).fromJson(jSONObject.toString(), (Class<Object>) JsonElement.class);
            C1457Fr.m5016(fromJson, "Lookup.get<Gson>().fromJ… JsonElement::class.java)");
            this.f8375 = (UmaAlert) C0848.m15506(((JsonElement) fromJson).getAsJsonObject(), "uma", UmaAlert.class);
            C1283.m16854(f8374.m8377(), "created umaAlert = " + this.f8375 + " from extraInfo = " + jSONObject);
        } catch (Exception e) {
            C1276.m16820().mo5727("Error parsing umaAlert = " + this.f8375 + " - exception = " + e);
        }
    }

    /* renamed from: o.kb$ˊ  reason: contains not printable characters */
    public static final class C0140 {
        private C0140() {
        }

        public /* synthetic */ C0140(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private final String m8377() {
            return C1931kb.f8373;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final UmaAlert m8375() {
        return this.f8375;
    }
}
