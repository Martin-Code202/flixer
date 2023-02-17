package com.netflix.mediaclient.service.logging.android.preapp.model;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import org.json.JSONObject;
public class PreAppWidgetInstallEvent extends DiscreteEvent {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f1137;

    public PreAppWidgetInstallEvent(WidgetInstallAction widgetInstallAction, String str, long j) {
        this.category = "preAppAndroid";
        this.name = widgetInstallAction.m593();
        this.f1137 = str;
        setTime(j);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            return new JSONObject();
        }
        return data;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getCustomData() {
        return new JSONObject(this.f1137);
    }

    public enum WidgetInstallAction {
        ADD("androidAddWidget"),
        DELETE("androidDeleteWidget"),
        UNKNOWN("");
        
        @SerializedName("value")
        private String value;

        private WidgetInstallAction(String str) {
            this.value = str;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public String m593() {
            return this.value;
        }
    }
}
