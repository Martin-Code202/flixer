package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
public class ConsolidatedLoggingSessionSpecification {
    @SerializedName("disableChancePercentagePerUserSession")
    private int disableChancePercentagePerUserSession;
    @SerializedName("session")
    private String session;
    @SerializedName("suppressPercentagePerEvent")
    private int suppressPercentagePerEvent;

    public String getSession() {
        return this.session;
    }

    public int getDisableChancePercentagePerUserSession() {
        return this.disableChancePercentagePerUserSession;
    }

    public int getSuppressPercentagePerEvent() {
        return this.suppressPercentagePerEvent;
    }

    public String toString() {
        return "ConsolidatedLoggingSpecification [session=" + this.session + ", disableChancePercentagePerUserSession=" + this.disableChancePercentagePerUserSession + ", suppressPercentagePerEvent=" + this.suppressPercentagePerEvent + "]";
    }
}
