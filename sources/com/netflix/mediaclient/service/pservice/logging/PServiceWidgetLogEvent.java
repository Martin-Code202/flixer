package com.netflix.mediaclient.service.pservice.logging;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.pservice.logging.PreAppWidgetLogActionData;
import o.C1281;
import o.C1349Bv;
public class PServiceWidgetLogEvent {
    private static String TAG = "nf_preapp_widgetlogevent";
    @SerializedName("action")
    public PreAppWidgetLogActionData.PreAppWidgetActionName action;
    @SerializedName("timeInMs")
    public long timeInMs = System.currentTimeMillis();
    @SerializedName("widgetSize")
    public PreAppWidgetSize widgetSize;

    public PServiceWidgetLogEvent(PreAppWidgetLogActionData.PreAppWidgetActionName preAppWidgetActionName, PreAppWidgetSize preAppWidgetSize) {
        this.action = preAppWidgetActionName;
        this.widgetSize = preAppWidgetSize;
    }

    public static PServiceWidgetLogEvent fromJsonString(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return (PServiceWidgetLogEvent) ((Gson) C1281.m16832(Gson.class)).fromJson(str, (Class<Object>) PServiceWidgetLogEvent.class);
    }

    public String toJsonString() {
        return ((Gson) C1281.m16832(Gson.class)).toJson(this);
    }
}
