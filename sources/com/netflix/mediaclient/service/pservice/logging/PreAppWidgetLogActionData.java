package com.netflix.mediaclient.service.pservice.logging;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import o.C1281;
public class PreAppWidgetLogActionData {
    public static final String EXTRA_WIDGET_ACTION_DATA = "widgetActionData";
    private static final String INPUT_GESTURE = "gesture";
    private static final String TAG = "nf_preapp_widgetLogActionData";
    @SerializedName("inputMethod")
    private String inputMethod = INPUT_GESTURE;
    @SerializedName("inputValue")
    private String inputValue;
    @SerializedName("isHotKey")
    private boolean isHotKey = false;
    @SerializedName("name")
    private String name;

    public PreAppWidgetLogActionData(PreAppWidgetActionName preAppWidgetActionName) {
        this.name = preAppWidgetActionName.getValue();
        this.inputValue = preAppWidgetActionName.getValue();
    }

    public static PreAppWidgetLogActionData createInstance(String str) {
        return new PreAppWidgetLogActionData(PreAppWidgetActionName.create(str));
    }

    public String toJsonString() {
        return ((Gson) C1281.m16832(Gson.class)).toJson(this);
    }

    public String getName() {
        return this.name;
    }

    public enum PreAppWidgetActionName {
        INSTALL("install"),
        DELETE("delete"),
        HOME("home"),
        START_PLAY("startPlay"),
        GO_TO_NEXT(SignupConstants.Message.NEXT),
        VIEW_TITLE_DETAILS("viewTitleDetails"),
        SW_HOME("stub_widget_home"),
        SW_DETAIL("stub_widget_viewTitleDetails"),
        SW_PLAY("stub_widget_play"),
        SW_GO_TO_NEXT("stub_widget_next"),
        SW_GO_TO_NEXT_STATIC_IMAGES("stub_widget_next_static"),
        UNKNOWN("unknown");
        
        @SerializedName("value")
        private String value;

        private PreAppWidgetActionName(String str) {
            this.value = str;
        }

        public static PreAppWidgetActionName create(String str) {
            PreAppWidgetActionName[] values = values();
            for (PreAppWidgetActionName preAppWidgetActionName : values) {
                if (preAppWidgetActionName.value.equalsIgnoreCase(str)) {
                    return preAppWidgetActionName;
                }
            }
            return UNKNOWN;
        }

        public String getValue() {
            return this.value;
        }
    }
}
