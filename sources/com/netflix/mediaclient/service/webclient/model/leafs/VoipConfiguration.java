package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
public class VoipConfiguration {
    public static final int DEFAULT_SAMPLERATE = 8000;
    public static final VoipConfiguration DEF_VOIP_CONIFG = new VoipConfiguration();
    public static final int MAX_SAMPLERATE_48K = 48000;
    public static final int MIN_SAMPLERATE_8K = 8000;
    private static String TAG = "nf_log";
    @SerializedName("enableVoip")
    private boolean enableVoip = true;
    @SerializedName("enableVoipOverData")
    private boolean enableVoipOverData = true;
    @SerializedName("enableVoipOverWiFi")
    private boolean enableVoipOverWiFi = true;
    @SerializedName("jitterThresholdInMs")
    private Threshold jitterThresholdInMs;
    @SerializedName("openDialpadByDefault")
    private boolean openDialpadByDefault = false;
    @SerializedName("packetLosThresholdInPercent")
    private Threshold packetLosThresholdInPercent;
    @SerializedName("rttThresholdInMs")
    private Threshold rttThresholdInMs;
    @SerializedName("sampleRateInHz")
    private int sampleRateInHz = 8000;
    @SerializedName("showConfirmationDialog")
    private boolean showConfirmationDialog = true;
    @SerializedName("showHelpForNonMember")
    private boolean showHelpForNonMember;
    @SerializedName("sipThresholdInMs")
    private Threshold sipThresholdInMs;

    public boolean isEnableVoip() {
        return this.enableVoip;
    }

    public boolean isEnableVoipOverData() {
        return this.enableVoipOverData;
    }

    public boolean isEnableVoipOverWiFi() {
        return this.enableVoipOverWiFi;
    }

    public Threshold getRttThresholdInMs() {
        return this.rttThresholdInMs;
    }

    public Threshold getJitterThresholdInMs() {
        return this.jitterThresholdInMs;
    }

    public Threshold getSipThresholdInMs() {
        return this.sipThresholdInMs;
    }

    public Threshold getPacketLosThresholdInPercent() {
        return this.packetLosThresholdInPercent;
    }

    public int getSampleRateInHz() {
        return this.sampleRateInHz;
    }

    public boolean isShowHelpForNonMember() {
        return this.showHelpForNonMember;
    }

    public boolean isShowConfirmationDialog() {
        return this.showConfirmationDialog;
    }

    public boolean isOpenDialpadByDefault() {
        return this.openDialpadByDefault;
    }

    public String toString() {
        return "VoipConfiguration{enableVoip=" + this.enableVoip + ", enableVoipOverData=" + this.enableVoipOverData + ", enableVoipOverWiFi=" + this.enableVoipOverWiFi + ", rttThresholdInMs=" + this.rttThresholdInMs + ", jitterThresholdInMs=" + this.jitterThresholdInMs + ", sipThresholdInMs=" + this.sipThresholdInMs + ", packetLosThresholdInPercent=" + this.packetLosThresholdInPercent + ", sampleRateInHz=" + this.sampleRateInHz + ", showHelpForNonMember=" + this.showHelpForNonMember + ", showConfirmationDialog=" + this.showConfirmationDialog + ", openDialpadByDefault=" + this.openDialpadByDefault + '}';
    }
}
