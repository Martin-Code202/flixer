package com.netflix.mediaclient.acquisition.viewmodels;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.mediaclient.acquisition.kotlinx.KeyPathEvaluationKt;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1449Fj;
import o.EI;
final class WelcomeSlidingDoorsViewModel$ctaButtonStringKey$2 extends Lambda implements AbstractC1449Fj<String> {
    final /* synthetic */ WelcomeSlidingDoorsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WelcomeSlidingDoorsViewModel$ctaButtonStringKey$2(WelcomeSlidingDoorsViewModel welcomeSlidingDoorsViewModel) {
        super(0);
        this.this$0 = welcomeSlidingDoorsViewModel;
    }

    @Override // o.AbstractC1449Fj
    public final String invoke() {
        Map<String, Object> data;
        FlowMode flowMode = this.this$0.getFlowMode();
        Object pathValue = (flowMode == null || (data = flowMode.getData()) == null) ? null : KeyPathEvaluationKt.getPathValue((Object) data, (List<String>) EI.m4804(SignupConstants.Field.ADAPTIVE_FIELDS, SignupConstants.Field.SLIDING_DOORS, SignupConstants.Field.MESSAGES, SignupConstants.Message.CTA, "string"));
        if (!(pathValue instanceof String)) {
            pathValue = null;
        }
        return (String) pathValue;
    }
}
