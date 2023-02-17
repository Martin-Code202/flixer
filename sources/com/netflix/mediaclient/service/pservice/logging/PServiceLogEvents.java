package com.netflix.mediaclient.service.pservice.logging;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import java.util.List;
import o.C1281;
import o.C1283;
import o.C1349Bv;
public final class PServiceLogEvents {
    public static final Boolean ENABLE_VERBOSE_LOGGING = false;
    private static final String TAG = "nf_preapp_logevents";
    @SerializedName("widgetLogEvents")
    private List<PServiceWidgetLogEvent> widgetLogEvents = new LinkedList();

    public String toJsonString() {
        String json = ((Gson) C1281.m16832(Gson.class)).toJson(this);
        ENABLE_VERBOSE_LOGGING.booleanValue();
        return json;
    }

    public List<PServiceWidgetLogEvent> getWidgetEvents() {
        return this.widgetLogEvents;
    }

    public static PServiceLogEvents newInstance() {
        return new PServiceLogEvents();
    }

    public static PServiceLogEvents createFromJsonString(String str) {
        if (C1349Bv.m4113(str)) {
            return newInstance();
        }
        ENABLE_VERBOSE_LOGGING.booleanValue();
        return (PServiceLogEvents) ((Gson) C1281.m16832(Gson.class)).fromJson(str, (Class<Object>) PServiceLogEvents.class);
    }

    public void addWidgetEvent(PServiceWidgetLogEvent pServiceWidgetLogEvent) {
        if (this.widgetLogEvents == null) {
            C1283.m16865(TAG, "widgetLogEvents is null");
            this.widgetLogEvents = new LinkedList();
        }
        this.widgetLogEvents.add(pServiceWidgetLogEvent);
    }
}
