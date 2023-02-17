package com.netflix.mediaclient.acquisition.viewmodels;

import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.mediaclient.acquisition.kotlinx.KeyPathEvaluationKt;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1433Et;
import o.C1435Ev;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.EI;
import o.FQ;
public final class WelcomeSlidingDoorsViewModel extends AbstractSignupViewModel {
    static final /* synthetic */ FQ[] $$delegatedProperties = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(WelcomeSlidingDoorsViewModel.class), SignupConstants.Field.CARDS, "getCards()Ljava/util/List;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(WelcomeSlidingDoorsViewModel.class), "ctaButtonStringKey", "getCtaButtonStringKey()Ljava/lang/String;"))};
    public static final Companion Companion = new Companion(null);
    private final String MODE = "welcome";
    private final String NEXT_ACTION_ID = "startAction";
    private String PREV_ACTION_ID = "signInAction";
    private final AbstractC1433Et cards$delegate = C1435Ev.m4972(new WelcomeSlidingDoorsViewModel$cards$2(this));
    private final AbstractC1433Et ctaButtonStringKey$delegate = C1435Ev.m4972(new WelcomeSlidingDoorsViewModel$ctaButtonStringKey$2(this));

    public final List<SlidingDoorsTitleCard> getCards() {
        AbstractC1433Et et = this.cards$delegate;
        FQ fq = $$delegatedProperties[0];
        return (List) et.mo3220();
    }

    public final String getCtaButtonStringKey() {
        AbstractC1433Et et = this.ctaButtonStringKey$delegate;
        FQ fq = $$delegatedProperties[1];
        return (String) et.mo3220();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        public final boolean isFlowModeSlidingDoors(FlowMode flowMode) {
            C1457Fr.m5025(flowMode, "flowMode");
            return KeyPathEvaluationKt.getPathValue(flowMode.getData(), EI.m4804(new String[]{SignupConstants.Field.ADAPTIVE_FIELDS, SignupConstants.Field.SLIDING_DOORS})) != null;
        }

        public final List<SlidingDoorsTitleCard> cardsFromFlowMode(FlowMode flowMode) {
            Map<String, Object> data;
            Object pathValue = (flowMode == null || (data = flowMode.getData()) == null) ? null : KeyPathEvaluationKt.getPathValue((Object) data, (List<String>) EI.m4804(SignupConstants.Field.ADAPTIVE_FIELDS, SignupConstants.Field.SLIDING_DOORS, SignupConstants.Field.CARDS));
            if (pathValue == null || !(pathValue instanceof List)) {
                return EI.m4805();
            }
            Iterable iterable = (Iterable) pathValue;
            ArrayList arrayList = new ArrayList(EI.m4812(iterable, 10));
            for (Object obj : iterable) {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                }
                arrayList.add((Map) obj);
            }
            ArrayList<Map<String, ? extends Object>> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(EI.m4812((Iterable) arrayList2, 10));
            for (Map<String, ? extends Object> map : arrayList2) {
                arrayList3.add(SlidingDoorsTitleCard.Companion.fromJson(map));
            }
            return EI.m4838((Iterable) arrayList3);
        }
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getMODE() {
        return this.MODE;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getNEXT_ACTION_ID() {
        return this.NEXT_ACTION_ID;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public String getPREV_ACTION_ID() {
        return this.PREV_ACTION_ID;
    }

    @Override // com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel
    public void setPREV_ACTION_ID(String str) {
        this.PREV_ACTION_ID = str;
    }

    public final String getVlvImageUrl() {
        FlowMode flowMode = getFlowMode();
        String cdnUrl = flowMode != null ? WelcomeViewModelKt.getCdnUrl(flowMode) : null;
        if (cdnUrl != null) {
            return cdnUrl;
        }
        return "";
    }

    public final boolean hasFreeTrial() {
        Field field;
        FlowMode flowMode = getFlowMode();
        Object value = (flowMode == null || (field = flowMode.getField(SignupConstants.Field.HAS_FREE_TRIAL)) == null) ? null : field.getValue();
        if (!(value instanceof Boolean)) {
            value = null;
        }
        Boolean bool = (Boolean) value;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isRecognisedFormerMember() {
        Field field;
        FlowMode flowMode = getFlowMode();
        Object value = (flowMode == null || (field = flowMode.getField(SignupConstants.Field.RECOGNIZED_FORMER_MEMBER)) == null) ? null : field.getValue();
        if (!(value instanceof Boolean)) {
            value = null;
        }
        Boolean bool = (Boolean) value;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isRecognisedNeverMember() {
        Field field;
        FlowMode flowMode = getFlowMode();
        Object value = (flowMode == null || (field = flowMode.getField(SignupConstants.Field.RECOGNIZED_NEVER_MEMBER)) == null) ? null : field.getValue();
        if (!(value instanceof Boolean)) {
            value = null;
        }
        Boolean bool = (Boolean) value;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
