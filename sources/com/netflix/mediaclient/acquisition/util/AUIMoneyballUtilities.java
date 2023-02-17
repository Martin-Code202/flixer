package com.netflix.mediaclient.acquisition.util;

import android.content.Context;
import android.text.Html;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.kotlinx.ContextKt;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballCallData;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import java.util.Map;
import kotlin.TypeCastException;
import o.AbstractC1194;
import o.AbstractC1451Fl;
import o.C0403;
import o.C1438Ey;
import o.C1457Fr;
import o.C2059ph;
import o.EA;
import o.EI;
import o.ES;
public final class AUIMoneyballUtilities {
    public static final AUIMoneyballUtilities INSTANCE = new AUIMoneyballUtilities();

    private AUIMoneyballUtilities() {
    }

    public final String getStringResourceFromMessages(Context context, String str, Map<String, String> map) {
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(str, "messageKey");
        C1457Fr.m5025(map, SignupConstants.Field.MESSAGES);
        String str2 = map.get(str);
        if (str2 != null) {
            return ContextKt.getStringResource(context, str2);
        }
        return null;
    }

    public final CharSequence stepsFieldToString(Context context, Field field) {
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(field, "stepsField");
        Object attr = field.getAttr(SignupConstants.Key.CURRENT_STEP);
        if (!(attr instanceof Double)) {
            attr = null;
        }
        Double d = (Double) attr;
        Object attr2 = field.getAttr(SignupConstants.Key.TOTAL_STEPS);
        if (!(attr2 instanceof Double)) {
            attr2 = null;
        }
        Double d2 = (Double) attr2;
        if (d == null || d2 == null) {
            return null;
        }
        return Html.fromHtml(C0403.m14185(context, R.string.label_steps_indicator).m14186(SignupConstants.Key.CURRENT_STEP, String.valueOf(((int) d.doubleValue()) + 1)).m14186(SignupConstants.Key.TOTAL_STEPS, String.valueOf((int) d2.doubleValue())).m14188());
    }

    public final String getPlanDescription(Context context, boolean z, boolean z2, int i, String str) {
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(str, "price");
        if (i == 1) {
            String r0 = C0403.m14185(context, R.string.orderfinal_streams_singular).m14186("price", str).m14188();
            C1457Fr.m5016((Object) r0, "ICUMessageFormat.getForm…                .format()");
            return r0;
        } else if (i > 1 && !z && !z2) {
            String r02 = C0403.m14185(context, R.string.orderfinal_streams_plural).m14186("number", Integer.valueOf(i)).m14186("price", str).m14188();
            C1457Fr.m5016((Object) r02, "ICUMessageFormat.getForm…                .format()");
            return r02;
        } else if (i > 1 && z && z2) {
            String r03 = C0403.m14185(context, R.string.orderfinal_streams_uhd).m14186("number", Integer.valueOf(i)).m14186("price", str).m14188();
            C1457Fr.m5016((Object) r03, "ICUMessageFormat.getForm…                .format()");
            return r03;
        } else if (i <= 1 || !z || z2) {
            return "";
        } else {
            String r04 = C0403.m14185(context, R.string.orderfinal_streams_hd).m14186("number", Integer.valueOf(i)).m14186("price", str).m14188();
            C1457Fr.m5016((Object) r04, "ICUMessageFormat.getForm…                .format()");
            return r04;
        }
    }

    public final boolean isFlowModeGooglePlay(FlowMode flowMode) {
        return C1457Fr.m5018((Object) (flowMode != null ? flowMode.getFlowId() : null), (Object) SignupConstants.Flow.SIMPLE_SILVER_SIGN_UP);
    }

    public static /* synthetic */ void sendFallbackRequestToMoneyball$default(AUIMoneyballUtilities aUIMoneyballUtilities, C2059ph phVar, FlowMode flowMode, String str, AbstractC1451Fl fl, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        aUIMoneyballUtilities.sendFallbackRequestToMoneyball(phVar, flowMode, str, fl);
    }

    public final void sendFallbackRequestToMoneyball(C2059ph phVar, FlowMode flowMode, String str, AbstractC1451Fl<? super MoneyballData, ? super Status, EA> fl) {
        AbstractC1194 r0;
        C1457Fr.m5025(flowMode, "flowMode");
        C1457Fr.m5025(str, "fallbackReason");
        C1457Fr.m5025(fl, "cb");
        FlowMode flowMode2 = new FlowMode(ES.m4863(C1438Ey.m4973("flow", flowMode.getFlowId()), C1438Ey.m4973("mode", SignupConstants.Mode.FALLBACK), C1438Ey.m4973("fields", ES.m4862(C1438Ey.m4973(SignupConstants.Action.FALLBACK_ACTION, ES.m4862(C1438Ey.m4973("withFields", EI.m4804(SignupConstants.Field.FALLBACK_TRIGGER_REASON, SignupConstants.Field.FALLBACK_TRIGGER_MODE)), C1438Ey.m4973("type", "Action"))), C1438Ey.m4973(SignupConstants.Field.FALLBACK_TRIGGER_REASON, ES.m4862(C1438Ey.m4973("value", str), C1438Ey.m4973("type", "String"))), C1438Ey.m4973(SignupConstants.Field.FALLBACK_TRIGGER_MODE, ES.m4862(C1438Ey.m4973("value", flowMode.getId()), C1438Ey.m4973("type", "String")))))));
        Field field = flowMode2.getField(SignupConstants.Action.FALLBACK_ACTION);
        if (field == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.android.moneyball.fields.ActionField");
        }
        MoneyballCallData moneyballCallData = new MoneyballCallData(flowMode2, (ActionField) field);
        if (phVar != null && (r0 = phVar.m9757()) != null) {
            r0.mo16168(moneyballCallData, new AUIMoneyballUtilities$sendFallbackRequestToMoneyball$1(fl));
        }
    }

    public static /* synthetic */ void sendRestoreRequestToMoneyball$default(AUIMoneyballUtilities aUIMoneyballUtilities, C2059ph phVar, String str, String str2, String str3, AbstractC1451Fl fl, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = "";
        }
        aUIMoneyballUtilities.sendRestoreRequestToMoneyball(phVar, str, str2, str3, fl);
    }

    public final void sendRestoreRequestToMoneyball(C2059ph phVar, String str, String str2, String str3, AbstractC1451Fl<? super MoneyballData, ? super Status, EA> fl) {
        AbstractC1194 r0;
        C1457Fr.m5025(str, SignupConstants.Field.RECEIPT);
        C1457Fr.m5025(str2, SignupConstants.Field.PARTNER_RESPONSE_SIGNATURE);
        C1457Fr.m5025(str3, SignupConstants.Field.DEV_PAYLOAD);
        C1457Fr.m5025(fl, "cb");
        FlowMode flowMode = new FlowMode(ES.m4863(C1438Ey.m4973("flow", SignupConstants.Flow.SIMPLE_SILVER_SIGN_UP), C1438Ey.m4973("mode", SignupConstants.Mode.RESTORE), C1438Ey.m4973("fields", ES.m4862(C1438Ey.m4973(SignupConstants.Action.RESTORE_ACTION, ES.m4862(C1438Ey.m4973("withFields", EI.m4804(SignupConstants.Field.RECEIPT, SignupConstants.Field.PARTNER_RESPONSE_SIGNATURE, SignupConstants.Field.DEV_PAYLOAD)), C1438Ey.m4973("type", "Action"))), C1438Ey.m4973(SignupConstants.Field.RECEIPT, ES.m4862(C1438Ey.m4973("value", str), C1438Ey.m4973("type", "String"))), C1438Ey.m4973(SignupConstants.Field.PARTNER_RESPONSE_SIGNATURE, ES.m4862(C1438Ey.m4973("value", str2), C1438Ey.m4973("type", "String"))), C1438Ey.m4973(SignupConstants.Field.DEV_PAYLOAD, ES.m4862(C1438Ey.m4973("value", str3), C1438Ey.m4973("type", "String")))))));
        Field field = flowMode.getField(SignupConstants.Action.RESTORE_ACTION);
        if (!(field instanceof ActionField)) {
            field = null;
        }
        MoneyballCallData moneyballCallData = new MoneyballCallData(flowMode, (ActionField) field);
        if (phVar != null && (r0 = phVar.m9757()) != null) {
            r0.mo16168(moneyballCallData, new AUIMoneyballUtilitiesKt$sam$MoneyballAgentWebCallback$58373d51(fl));
        }
    }
}
