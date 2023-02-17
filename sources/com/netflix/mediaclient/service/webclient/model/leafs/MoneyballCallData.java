package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.android.moneyball.fields.Field;
import com.netflix.android.moneyball.fields.FieldValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.C1281;
import o.C1349Bv;
public class MoneyballCallData {
    private static final String TAG = "nf_aui_moneyballcall";
    @SerializedName("flowMode")
    public FlowMode flowMode;
    @SerializedName("nextAction")
    public ActionField nextAction;
    @SerializedName("withFields")
    public List<Field> withFields;

    public boolean isValid() {
        if (this.withFields == null || this.withFields.size() <= 0) {
            return true;
        }
        for (Field field : this.withFields) {
            if ((field instanceof FieldValidator) && !((FieldValidator) field).isValid()) {
                return false;
            }
        }
        return true;
    }

    public MoneyballCallData(FlowMode flowMode2, ActionField actionField) {
        this.flowMode = flowMode2;
        this.nextAction = actionField;
        if (actionField != null) {
            this.withFields = actionField.getRequiredFields();
        }
    }

    public Map<String, Map<String, String>> getFieldValueMap() {
        HashMap hashMap = new HashMap();
        for (Field field : this.withFields) {
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("value", field.getValue().toString());
            hashMap.put(field.getId(), hashMap2);
        }
        return hashMap;
    }

    public static MoneyballCallData fromJsonString(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return (MoneyballCallData) ((Gson) C1281.m16832(Gson.class)).fromJson(str, (Class<Object>) MoneyballCallData.class);
    }

    public String toJsonString() {
        HashMap hashMap = new HashMap();
        hashMap.put("flow", this.flowMode.getFlowId());
        hashMap.put("mode", this.flowMode.getId());
        if (this.nextAction != null) {
            hashMap.put("action", this.nextAction.getId());
        }
        hashMap.put("fields", getFieldValueMap());
        return ((Gson) C1281.m16832(Gson.class)).toJson(hashMap);
    }
}
