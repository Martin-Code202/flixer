package com.netflix.mediaclient.service.pservice.logging;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import o.C1281;
public class PreAppWidgetSize {
    private static final String TAG = "nf_preapp_widgetsize";
    @SerializedName("maxHeight")
    public int maxHeight;
    @SerializedName("maxWidth")
    public int maxWidth;
    @SerializedName("minHeight")
    public int minHeight;
    @SerializedName("minWidth")
    public int minWidth;

    public PreAppWidgetSize() {
        this.minWidth = 0;
        this.maxWidth = 0;
        this.minHeight = 0;
        this.maxHeight = 0;
    }

    public PreAppWidgetSize(int i, int i2, int i3, int i4) {
        this.minWidth = i;
        this.maxWidth = i2;
        this.minHeight = i3;
        this.maxHeight = i4;
    }

    public String toJsonString() {
        return ((Gson) C1281.m16832(Gson.class)).toJson(this);
    }
}
