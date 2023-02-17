package com.netflix.mediaclient.acquisition.viewmodels;

import android.content.Context;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.mediaclient.acquisition.kotlinx.KeyPathEvaluationKt;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.List;
import o.AD;
import o.C1457Fr;
import o.EI;
import o.Ge;
import o.zN;
public final class WelcomeViewModelKt {
    public static final String getSizedCdnUrl(FlowMode flowMode, Context context) {
        C1457Fr.m5025(flowMode, "$receiver");
        C1457Fr.m5025(context, "context");
        Object pathValue = KeyPathEvaluationKt.getPathValue((Object) flowMode.getData(), (List<String>) EI.m4804(SignupConstants.Field.ADAPTIVE_FIELDS, "customizations", "0", "image", "imageSet", "0", "cdnUrl"));
        if (!(pathValue instanceof String)) {
            pathValue = null;
        }
        String str = (String) pathValue;
        if (str != null) {
            return Ge.m5068(str, "{size}", getVlvImageSizeString(context), false, 4, (Object) null);
        }
        return null;
    }

    public static final String getCdnUrl(FlowMode flowMode) {
        C1457Fr.m5025(flowMode, "$receiver");
        Object pathValue = KeyPathEvaluationKt.getPathValue((Object) flowMode.getData(), (List<String>) EI.m4804(SignupConstants.Field.ADAPTIVE_FIELDS, "customizations", "0", "image", "imageSet", "0", "cdnUrl"));
        if (!(pathValue instanceof String)) {
            pathValue = null;
        }
        String str = (String) pathValue;
        String str2 = zN.f12697.m13526() ? "large" : "medium";
        if (str != null) {
            return Ge.m5068(str, "{size}", str2, false, 4, (Object) null);
        }
        return null;
    }

    public static final String getVlvImageSizeString(Context context) {
        C1457Fr.m5025(context, "context");
        if (zN.f12697.m13526()) {
            return "large";
        }
        switch (AD.m3308(context)) {
            case 120:
                return "small";
            case 160:
                return "medium";
            default:
                return "large";
        }
    }
}
