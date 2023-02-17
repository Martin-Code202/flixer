package o;

import android.content.Context;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfigData;
import java.util.ArrayList;
import org.json.JSONException;
/* renamed from: o.ｦ  reason: contains not printable characters */
public class C1240 {

    /* renamed from: ˊ  reason: contains not printable characters */
    static ABTestConfigData f15779;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String f15780 = "nf_ab_test_config";

    /* renamed from: ˎ  reason: contains not printable characters */
    private Long f15781;

    /* renamed from: ॱ  reason: contains not printable characters */
    Context f15782;

    public C1240(Context context) {
        this.f15782 = context;
        try {
            f15779 = ABTestConfigData.fromJsonString(C1339Bl.m4045(this.f15782, "abTestConfig", (String) null));
        } catch (JSONException e) {
        }
        if (f15779 != null) {
            this.f15781 = Long.valueOf(Logger.INSTANCE.m127(new C0381(m16593(f15779))));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16595() {
        C1339Bl.m4039(this.f15782, "abTestConfig", (String) null);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m16594(ABTestConfigData aBTestConfigData) {
        if (aBTestConfigData == null) {
            C1283.m16850(f15780, "abTestConfig object is null - ignore overwrite");
            return;
        }
        C1339Bl.m4039(this.f15782, "abTestConfig", aBTestConfigData.toJsonString());
        f15779 = aBTestConfigData;
        Logger.INSTANCE.m132(this.f15781);
        if (f15779 != null) {
            this.f15781 = Long.valueOf(Logger.INSTANCE.m127(new C0381(m16593(f15779))));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static C0478 m16593(ABTestConfigData aBTestConfigData) {
        if (aBTestConfigData == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : aBTestConfigData.keySet()) {
            ABTestConfig configForId = aBTestConfigData.getConfigForId(str);
            if (configForId != null && configForId.getCell() != null && configForId.isExplicit()) {
                arrayList.add(new C0484(str, configForId.getCell().getCellId()));
            } else if (configForId == null) {
                C1276.m16820().mo5725("AB test is null for ID: " + str);
            } else if (configForId.getCell() == null) {
                C1276.m16820().mo5725("AB test cell is null for ID: " + str);
            }
        }
        return new C0478((C0484[]) arrayList.toArray(new C0484[arrayList.size()]));
    }
}
