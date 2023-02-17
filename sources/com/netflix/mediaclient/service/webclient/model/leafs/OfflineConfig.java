package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
public class OfflineConfig {
    private static final int DEFAULT_MAINTENANCE_JOB_PERIOD_IN_HRS = 24;
    private static final String TAG = "nf_log";
    @SerializedName("disableOfflineFeature")
    private boolean disableOfflineFeature;
    @SerializedName("maintenanceJobPeriodInHrs")
    private int maintenanceJobPeriodInHrs;

    public boolean isOfflineFeatureDisabled() {
        return this.disableOfflineFeature;
    }

    public int getMaintenanceJobPeriodInHrs() {
        return this.maintenanceJobPeriodInHrs;
    }

    private OfflineConfig() {
    }

    public static OfflineConfig createDefault() {
        OfflineConfig offlineConfig = new OfflineConfig();
        offlineConfig.disableOfflineFeature = false;
        offlineConfig.maintenanceJobPeriodInHrs = 24;
        return offlineConfig;
    }
}
