package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.netflix.mediaclient.service.webclient.model.leafs.AutoValue_UmaCta;
public abstract class UmaCta {
    public static final String ACTION_DISMISS = "DISMISS";
    public static final String ACTION_NOT_NOW = "NOT_NOW";
    public static final String ACTION_RESTART_MEMBERSHIP = "RESTART_MEMBERSHIP";
    public static final String ACTION_RETRY_PAYMENT = "RETRY_PAYMENT";
    public static final String ACTION_TYPE_BACKGROUND_CALL = "BACKGROUND_CALL";
    public static final String ACTION_TYPE_LINK = "LINK";
    public static final String ACTION_TYPE_UMS_IMPRESSION = "UMS_IMPRESSION";
    public static final String CALLBACK_ACKNOWLEDGED = "ACKNOWLEDGED";

    public abstract String action();

    public abstract String actionType();

    public abstract boolean autoLogin();

    public abstract String callback();

    public abstract String failureMessage();

    public abstract boolean openLinkInWebView();

    public abstract boolean selected();

    public abstract String successMessage();

    public abstract String text();

    public abstract String trackingInfo();

    public abstract String umsAlertCtaFeedback();

    public static TypeAdapter<UmaCta> typeAdapter(Gson gson) {
        return new AutoValue_UmaCta.GsonTypeAdapter(gson);
    }
}
