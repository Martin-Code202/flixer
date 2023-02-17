package o;

import android.content.Context;
import com.netflix.mediaclient.service.configuration.EdgeStack;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
/* renamed from: o.น  reason: contains not printable characters */
public class C0685 extends AbstractC1067 {
    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "8863";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_ab8863";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m14964(Context context) {
        return (context == null || C1272.m16797(C0685.class, context) == ABTestConfig.Cell.CELL_1) ? false : true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m14965(EdgeStack edgeStack) {
        if (edgeStack == EdgeStack.STAGING) {
            switch (C1272.m16803(C0685.class)) {
                case CELL_2:
                    return "android-anycast.staging.ftl.netflix.com";
                case CELL_3:
                    return "android.staging.ftl.netflix.com";
                case CELL_4:
                    return "android-conservative.staging.ftl.netflix.com";
                case CELL_5:
                    return "android-moderate.staging.ftl.netflix.com";
                case CELL_6:
                    return "android-aggressive.staging.ftl.netflix.com";
                default:
                    return "api-staging.netflix.com";
            }
        } else {
            switch (C1272.m16803(C0685.class)) {
                case CELL_2:
                    return "android-anycast.prod.ftl.netflix.com";
                case CELL_3:
                    return "android.prod.ftl.netflix.com";
                case CELL_4:
                    return "android-conservative.prod.ftl.netflix.com";
                case CELL_5:
                    return "android-moderate.prod.ftl.netflix.com";
                case CELL_6:
                    return "android-aggressive.prod.ftl.netflix.com";
                default:
                    return "api-global.netflix.com";
            }
        }
    }
}
