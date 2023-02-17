package com.netflix.mediaclient.acquisition.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.kotlinx.ContextKt;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.AUIContextData;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballCallData;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import com.netflix.mediaclient.service.webclient.model.leafs.PhoneCodesData;
import com.netflix.mediaclient.service.webclient.model.leafs.TermsOfUseData;
import java.util.LinkedHashMap;
import java.util.Map;
import o.AbstractC1194;
import o.AbstractC1451Fl;
import o.C1168;
import o.C1457Fr;
import o.C2059ph;
import o.EA;
public abstract class AbstractSignupViewModel extends ViewModel {
    private final String MESSAGES_FIELD = SignupConstants.Field.MESSAGES;
    private String PREV_ACTION_ID;
    private AUIContextData contextData;
    private FlowMode flowMode;
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private ActionField nextAction;
    private ActionField prevAction;

    public abstract String getMODE();

    public abstract String getNEXT_ACTION_ID();

    public final String getMESSAGES_FIELD() {
        return this.MESSAGES_FIELD;
    }

    public String getPREV_ACTION_ID() {
        return this.PREV_ACTION_ID;
    }

    public void setPREV_ACTION_ID(String str) {
        this.PREV_ACTION_ID = str;
    }

    public final ActionField getNextAction() {
        return this.nextAction;
    }

    public final void setNextAction(ActionField actionField) {
        this.nextAction = actionField;
    }

    public final ActionField getPrevAction() {
        return this.prevAction;
    }

    public final void setPrevAction(ActionField actionField) {
        this.prevAction = actionField;
    }

    public final AUIContextData getContextData() {
        return this.contextData;
    }

    public final void setContextData(AUIContextData aUIContextData) {
        this.contextData = aUIContextData;
    }

    public final FlowMode getFlowMode() {
        return this.flowMode;
    }

    public final void setFlowMode(FlowMode flowMode2) {
        this.flowMode = flowMode2;
    }

    public final MutableLiveData<Boolean> isLoading() {
        return this.isLoading;
    }

    public void initActions() {
        Field field;
        if (getNEXT_ACTION_ID().length() > 0) {
            FlowMode flowMode2 = this.flowMode;
            Field field2 = flowMode2 != null ? flowMode2.getField(getNEXT_ACTION_ID()) : null;
            if (!(field2 instanceof ActionField)) {
                field2 = null;
            }
            this.nextAction = (ActionField) field2;
        }
        if (getPREV_ACTION_ID() != null) {
            String prev_action_id = getPREV_ACTION_ID();
            if (prev_action_id == null) {
                C1457Fr.m5019();
            }
            if (prev_action_id.length() > 0) {
                FlowMode flowMode3 = this.flowMode;
                if (flowMode3 != null) {
                    String prev_action_id2 = getPREV_ACTION_ID();
                    if (prev_action_id2 == null) {
                        C1457Fr.m5019();
                    }
                    field = flowMode3.getField(prev_action_id2);
                } else {
                    field = null;
                }
                if (!(field instanceof ActionField)) {
                    field = null;
                }
                this.prevAction = (ActionField) field;
            }
        }
    }

    public final Map<String, String> getMessages() {
        String str;
        FlowMode flowMode2 = this.flowMode;
        if (flowMode2 == null) {
            return null;
        }
        Field field = flowMode2.getField(this.MESSAGES_FIELD);
        if (field == null) {
            field = r6;
            Field field2 = new Field(SignupConstants.Field.MESSAGES, new LinkedHashMap(), flowMode2);
        }
        Map<String, Object> data = field.getData();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : data.entrySet()) {
            Object key = t.getKey();
            Object value = t.getValue();
            if (value instanceof Map) {
                str = (String) ((Map) value).get("string");
                if (str == null) {
                    str = "";
                }
            } else {
                str = value.toString();
            }
            linkedHashMap.put(key, str);
        }
        return linkedHashMap;
    }

    public final String localizedErrorString(Context context) {
        C1457Fr.m5025(context, "context");
        String errorStringKey = getErrorStringKey();
        String stringResource = errorStringKey != null ? ContextKt.getStringResource(context, errorStringKey) : null;
        if (getErrorStringKey() != null) {
            String str = stringResource;
            if (str == null || str.length() == 0) {
                return context.getString(R.string.generic_retryable_failure);
            }
        }
        return stringResource;
    }

    public final String getErrorStringKey() {
        Map<String, Field> fields;
        Field field;
        FlowMode flowMode2 = this.flowMode;
        String value = (flowMode2 == null || (fields = flowMode2.getFields()) == null || (field = fields.get("errorCode")) == null) ? null : field.getValue();
        if (!(value instanceof String)) {
            value = null;
        }
        return value;
    }

    /* access modifiers changed from: private */
    public final void fetch(String str, String str2, C2059ph phVar, AbstractC1451Fl<? super MoneyballData, ? super Status, EA> fl) {
        AbstractC1194 r0;
        if (phVar != null && (r0 = phVar.m9757()) != null) {
            r0.mo16167(str, str2, new AbstractSignupViewModel$fetch$1(fl));
        }
    }

    public final void fetch(C2059ph phVar, AbstractC1451Fl<? super MoneyballData, ? super Status, EA> fl) {
        C1457Fr.m5025(fl, "completion");
        FlowMode flowMode2 = this.flowMode;
        if (flowMode2 != null) {
            fetch(flowMode2.getFlowId(), getMODE(), phVar, fl);
        }
    }

    public final void next(ActionField actionField, C2059ph phVar, AbstractC1451Fl<? super MoneyballData, ? super Status, EA> fl) {
        AbstractC1194 r0;
        C1457Fr.m5025(actionField, "action");
        C1457Fr.m5025(fl, "completion");
        String mode = actionField.getMode();
        if (mode != null) {
            if (mode.length() == 0) {
                MoneyballCallData moneyballCallData = new MoneyballCallData(this.flowMode, actionField);
                if (phVar != null && (r0 = phVar.m9757()) != null) {
                    r0.mo16168(moneyballCallData, new AbstractSignupViewModel$next$1(fl));
                    return;
                }
                return;
            }
        }
        String mode2 = actionField.getMode();
        FlowMode flowMode2 = this.flowMode;
        C1168.m16360(mode2, flowMode2 != null ? flowMode2.getFlowId() : null, new AbstractSignupViewModel$next$2(this, phVar, fl));
    }

    public final void fetchPhoneCodes(C2059ph phVar, AbstractC1451Fl<? super PhoneCodesData, ? super Status, EA> fl) {
        AbstractC1194 r0;
        C1457Fr.m5025(fl, "completion");
        if (phVar != null && (r0 = phVar.m9757()) != null) {
            r0.mo16163(new AbstractSignupViewModel$fetchPhoneCodes$1(fl));
        }
    }

    public final void fetchTermsOfUse(C2059ph phVar, AbstractC1451Fl<? super TermsOfUseData, ? super Status, EA> fl) {
        AbstractC1194 r0;
        C1457Fr.m5025(fl, "completion");
        if (phVar != null && (r0 = phVar.m9757()) != null) {
            r0.mo16166(new AbstractSignupViewModel$fetchTermsOfUse$1(fl));
        }
    }
}
