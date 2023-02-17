package o;

import android.content.Context;
import com.netflix.mediaclient.service.configuration.EdgeStack;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
/* renamed from: o.ฑ  reason: contains not printable characters */
public class C0681 extends AbstractC1067 {
    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "8508";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_ab8508";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m14920(Context context) {
        if (context == null) {
            return false;
        }
        ABTestConfig.Cell r1 = C1272.m16797(C0681.class, context);
        return r1 == ABTestConfig.Cell.CELL_2 || r1 == ABTestConfig.Cell.CELL_3;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m14919(EdgeStack edgeStack) {
        if (edgeStack == EdgeStack.STAGING) {
            switch (C1272.m16803(C0685.class)) {
                case CELL_2:
                    return "android-anycast.staging.ftl.netflix.com";
                case CELL_3:
                    return "android.staging.ftl.netflix.com";
                default:
                    return "api-staging.netflix.com";
            }
        } else {
            switch (C1272.m16803(C0685.class)) {
                case CELL_2:
                    return "android-anycast.prod.ftl.netflix.com";
                case CELL_3:
                    return "android.prod.ftl.netflix.com";
                default:
                    return "api-global.netflix.com";
            }
        }
    }
}
