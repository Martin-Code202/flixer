package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
import com.netflix.android.moneyball.FlowMode;
public class MoneyballData {
    public static final String FIELD_AUI_CONTEXT = "aui_context";
    public static final String FIELD_FLOW = "flow";
    public static final String FIELD_FLOWMODE = "flowmode";
    public static final String FIELD_FLWSSN = "flwssn";
    public static final String FIELD_MODE = "mode";
    static final String FIELD_PHONE_CODES = "phoneCodes";
    static final String FIELD_TERMS_OF_USE = "termsOfUse";
    public static final String TAG = "nf_moneyball";
    @SerializedName(FIELD_AUI_CONTEXT)
    protected AUIContextData contextData;
    @SerializedName("flow")
    protected String flow;
    @SerializedName(FIELD_FLOWMODE)
    protected FlowMode flowMode;
    @SerializedName("flwssn")
    public String flwssn;
    @SerializedName("mode")
    protected String mode;
    @SerializedName(FIELD_PHONE_CODES)
    protected PhoneCodesData phoneCodesData;
    @SerializedName(FIELD_TERMS_OF_USE)
    protected TermsOfUseData termsOfUseData;

    public String toString() {
        return "MoneyballData{mode='" + this.mode + "', flow='" + this.flow + "'}";
    }

    public void setContextData(AUIContextData aUIContextData) {
        if (aUIContextData != null) {
            this.contextData = aUIContextData;
        }
    }

    public void setPhoneCodesData(PhoneCodesData phoneCodesData2) {
        this.phoneCodesData = phoneCodesData2;
    }

    public void setTermsOfUseData(TermsOfUseData termsOfUseData2) {
        this.termsOfUseData = termsOfUseData2;
    }

    public void setFlowMode(FlowMode flowMode2) {
        if (flowMode2 != null) {
            this.flowMode = flowMode2;
            this.flow = flowMode2.getFlowId();
            this.mode = flowMode2.getId();
        }
    }

    public String getMode() {
        return this.mode;
    }

    public String getFlow() {
        return this.flow;
    }

    public FlowMode getFlowMode() {
        return this.flowMode;
    }

    public AUIContextData getContextData() {
        return this.contextData;
    }

    public PhoneCodesData getPhoneCodesData() {
        return this.phoneCodesData;
    }

    public TermsOfUseData getTermsOfUseData() {
        return this.termsOfUseData;
    }

    public boolean isValid() {
        return this.flowMode.getFlowId() != null;
    }
}
