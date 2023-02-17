package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
import o.C1456Fq;
public final class PdsAndLogblobConfig {
    public static final Companion Companion = new Companion(null);
    private static final PdsAndLogblobConfig DEFAULT = new PdsAndLogblobConfig();
    @SerializedName("disableOfflineLogblobs")
    private boolean disableOfflineLogblobs;
    @SerializedName("disableOfflinePdsEvents")
    private boolean disableOfflinePdsEvents;
    @SerializedName("disableStreamingLogblobs")
    private boolean disableStreamingLogblobs;
    @SerializedName("disableStreamingPdsEvents")
    private boolean disableStreamingPdsEvents;

    public final boolean getDisableStreamingPdsEvents() {
        return this.disableStreamingPdsEvents;
    }

    public final void setDisableStreamingPdsEvents(boolean z) {
        this.disableStreamingPdsEvents = z;
    }

    public final boolean getDisableStreamingLogblobs() {
        return this.disableStreamingLogblobs;
    }

    public final void setDisableStreamingLogblobs(boolean z) {
        this.disableStreamingLogblobs = z;
    }

    public final boolean getDisableOfflinePdsEvents() {
        return this.disableOfflinePdsEvents;
    }

    public final void setDisableOfflinePdsEvents(boolean z) {
        this.disableOfflinePdsEvents = z;
    }

    public final boolean getDisableOfflineLogblobs() {
        return this.disableOfflineLogblobs;
    }

    public final void setDisableOfflineLogblobs(boolean z) {
        this.disableOfflineLogblobs = z;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        public final PdsAndLogblobConfig getDEFAULT() {
            return PdsAndLogblobConfig.DEFAULT;
        }
    }
}
