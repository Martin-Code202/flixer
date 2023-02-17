package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.netflix.mediaclient.service.webclient.model.leafs.AutoValue_UmaAlert;
import java.util.concurrent.TimeUnit;
public abstract class UmaAlert {
    static final String FIELD_UMA = "umaAlert";
    public static final String TYPE_ERROR = "ERROR";
    public static final String TYPE_INFO = "INFO";
    public static final String TYPE_WARN = "WARN";
    private static final long UMA_STALE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(10);
    private boolean mConsumed = false;

    public abstract int abTestCell();

    public abstract int abTestId();

    public abstract String backgroundAction();

    public abstract boolean bannerAlert();

    public abstract boolean blocking();

    public abstract String body();

    public abstract UmaCta cta1();

    public abstract UmaCta cta2();

    public abstract String locale();

    public abstract long messageId();

    public abstract String messageName();

    public abstract boolean modalAlert();

    public abstract boolean showOnBackgroundActionSuccess();

    public abstract boolean suppressForBackgroundAction();

    public abstract boolean suppressOnAppLaunch();

    public abstract long timestamp();

    public abstract String title();

    public abstract String trackingInfo();

    public abstract String umsAlertRenderFeedback();

    public abstract String viewType();

    public static TypeAdapter<UmaAlert> typeAdapter(Gson gson) {
        return new AutoValue_UmaAlert.GsonTypeAdapter(gson);
    }

    public void setConsumed(boolean z) {
        this.mConsumed = z;
    }

    public boolean isConsumed() {
        return this.mConsumed;
    }

    public boolean isStale() {
        return System.currentTimeMillis() - timestamp() > UMA_STALE_TIMEOUT_MILLIS;
    }
}
