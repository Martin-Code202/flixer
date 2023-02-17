package o;

import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfigData;
/* renamed from: o.fd  reason: case insensitive filesystem */
public class C1770fd {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m6380(ABTestConfigData aBTestConfigData) {
        StringBuilder sb = new StringBuilder();
        if (aBTestConfigData != null) {
            for (String str : aBTestConfigData.keySet()) {
                ABTestConfig configForId = aBTestConfigData.getConfigForId(str);
                if (!(configForId == null || !configForId.isExplicit() || configForId.getCell() == null)) {
                    sb.append(String.format("Test%s.Cell%s|", str, Integer.valueOf(configForId.getCell().getCellId())));
                }
            }
        }
        return sb.toString();
    }
}
