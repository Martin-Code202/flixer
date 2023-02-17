package com.netflix.mediaclient.service.pservice.logging;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.util.DeviceCategory;
import o.AD;
import o.C1281;
public final class PreAppWidgetLogData {
    public static final String EXTRA_WIDGET_LOG_DATA = "logData";
    public static final boolean PRINT_LOG_DATA = false;
    private static final String TAG = "nf_preapp_widgetLogData";
    @SerializedName("deviceType")
    private String deviceCategroy;
    @SerializedName("isMember")
    private boolean isMember;
    @SerializedName("widgetSize")
    private String widgetSize;
    @SerializedName("widgetType")
    private String widgetType;

    public PreAppWidgetLogData(String str, String str2, String str3, boolean z) {
        this.widgetType = str;
        this.widgetSize = str2;
        this.deviceCategroy = str3;
        this.isMember = z;
    }

    public static PreAppWidgetLogData createInstance(Context context, PreAppWidgetSize preAppWidgetSize, boolean z) {
        return new PreAppWidgetLogData("default", preAppWidgetSize.toJsonString(), AD.m3299() ? DeviceCategory.TABLET.m2972() : DeviceCategory.PHONE.m2972(), z);
    }

    public static PreAppWidgetLogData createInstance(Context context, int i, boolean z) {
        return createInstance(context, PServiceLogging.getWidgetSize(context, i), z);
    }

    public String toJsonString() {
        return ((Gson) C1281.m16832(Gson.class)).toJson(this);
    }

    public boolean isMember() {
        return this.isMember;
    }
}
