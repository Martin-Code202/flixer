package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
public class PreviewContentConfigData {
    private static final String TAG = "nf_previewcontent";
    @SerializedName("encryptedDolbyDigitalPlus20Enabled")
    private boolean encryptedDolbyDigitalPlus20Enabled = true;
    @SerializedName("encryptedDolbyDigitalPlus51Enabled")
    private boolean encryptedDolbyDigitalPlus51Enabled = true;
    @SerializedName("encryptedHEAAC2Enabled")
    private boolean encryptedHEAAC2Enabled = true;
    @SerializedName("encryptedImageSubtitlesEnabled")
    private boolean encryptedImageSubtitlesEnabled = true;
    @SerializedName("encryptedTextSubtitlesEnabled")
    private boolean encryptedTextSubtitlesEnabled = true;
    @SerializedName("previewContentEnabled")
    private boolean previewContentEnabled = true;

    public boolean isPreviewContentEnabled() {
        return this.previewContentEnabled;
    }

    public boolean isEncryptedTextSubtitlesEnabled() {
        return this.encryptedTextSubtitlesEnabled;
    }

    public boolean isEncryptedImageSubtitlesEnabled() {
        return this.encryptedImageSubtitlesEnabled;
    }

    public boolean isEncryptedDolbyDigitalPlus51Enabled() {
        return this.encryptedDolbyDigitalPlus51Enabled;
    }

    public boolean isEncryptedDolbyDigitalPlus20Enabled() {
        return this.encryptedDolbyDigitalPlus20Enabled;
    }

    public boolean isEncryptedHEAAC2Enabled() {
        return this.encryptedHEAAC2Enabled;
    }

    public String toString() {
        return "PreviewContentConfigData{previewContentEnabled=" + this.previewContentEnabled + ", encryptedTextSubtitlesEnabled=" + this.encryptedTextSubtitlesEnabled + ", encryptedImageSubtitlesEnabled=" + this.encryptedImageSubtitlesEnabled + ", encryptedDolbyDigitalPlus51Enabled=" + this.encryptedDolbyDigitalPlus51Enabled + ", encryptedDolbyDigitalPlus20Enabled=" + this.encryptedDolbyDigitalPlus20Enabled + ", encryptedHEAAC2Enabled=" + this.encryptedHEAAC2Enabled + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PreviewContentConfigData previewContentConfigData = (PreviewContentConfigData) obj;
        return this.previewContentEnabled == previewContentConfigData.previewContentEnabled && this.encryptedTextSubtitlesEnabled == previewContentConfigData.encryptedTextSubtitlesEnabled && this.encryptedImageSubtitlesEnabled == previewContentConfigData.encryptedImageSubtitlesEnabled && this.encryptedDolbyDigitalPlus51Enabled == previewContentConfigData.encryptedDolbyDigitalPlus51Enabled && this.encryptedDolbyDigitalPlus20Enabled == previewContentConfigData.encryptedDolbyDigitalPlus20Enabled && this.encryptedHEAAC2Enabled == previewContentConfigData.encryptedHEAAC2Enabled;
    }

    public int hashCode() {
        return ((((((((((this.previewContentEnabled ? 1 : 0) * 31) + (this.encryptedTextSubtitlesEnabled ? 1 : 0)) * 31) + (this.encryptedImageSubtitlesEnabled ? 1 : 0)) * 31) + (this.encryptedDolbyDigitalPlus51Enabled ? 1 : 0)) * 31) + (this.encryptedDolbyDigitalPlus20Enabled ? 1 : 0)) * 31) + (this.encryptedHEAAC2Enabled ? 1 : 0);
    }

    public static PreviewContentConfigData getDefault() {
        return new PreviewContentConfigData();
    }

    public static PreviewContentConfigData getDisabledConfig() {
        PreviewContentConfigData previewContentConfigData = new PreviewContentConfigData();
        previewContentConfigData.previewContentEnabled = false;
        previewContentConfigData.encryptedTextSubtitlesEnabled = false;
        previewContentConfigData.encryptedImageSubtitlesEnabled = false;
        previewContentConfigData.encryptedDolbyDigitalPlus51Enabled = false;
        previewContentConfigData.encryptedDolbyDigitalPlus20Enabled = false;
        previewContentConfigData.encryptedHEAAC2Enabled = false;
        return previewContentConfigData;
    }
}
