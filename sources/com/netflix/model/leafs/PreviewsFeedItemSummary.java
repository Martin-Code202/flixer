package com.netflix.model.leafs;

import android.graphics.Color;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.originals.interactive.MotionBoxart;
import java.util.Locale;
import java.util.Map;
import o.AbstractC0851;
import o.AbstractC0852;
import o.pD;
import o.pT;
public class PreviewsFeedItemSummary implements AbstractC0851, AbstractC0852, pD {
    private static final String TAG = "PreviewsFeedItemSummary";
    private int backgroundColor;
    private long bookmark = 0;
    private int foregroundColor;
    private boolean isOriginal;
    private String panelArtUrl;
    private int position = 0;
    private long supplementVideoDuration = 0;
    private boolean supplementalVideoCanStream = false;
    private String supplementalVideoId;
    private String title;
    private String titleTreatmentUrl;
    private pT videoDetails = null;
    private String videoId;
    private VideoType videoType;

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1464309672:
                    if (key.equals("supplementalDuration")) {
                        c = 4;
                        break;
                    }
                    break;
                case -788538068:
                    if (key.equals("supplementalCanStream")) {
                        c = 5;
                        break;
                    }
                    break;
                case -641062944:
                    if (key.equals("foregroundColor")) {
                        c = 6;
                        break;
                    }
                    break;
                case -634252209:
                    if (key.equals("titleTreatmentUrl")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 3355:
                    if (key.equals("id")) {
                        c = 0;
                        break;
                    }
                    break;
                case 585773339:
                    if (key.equals("isOriginal")) {
                        c = 2;
                        break;
                    }
                    break;
                case 732493616:
                    if (key.equals("panelArtUrl")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1287124693:
                    if (key.equals("backgroundColor")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1332961877:
                    if (key.equals("videoType")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1681951455:
                    if (key.equals("supplementalId")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1714148973:
                    if (key.equals("displayName")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.videoId = value.getAsString();
                    break;
                case 1:
                    this.title = value.getAsString();
                    break;
                case 2:
                    this.isOriginal = value.getAsBoolean();
                    break;
                case 3:
                    this.supplementalVideoId = value.getAsString();
                    break;
                case 4:
                    this.supplementVideoDuration = value.getAsLong();
                    break;
                case 5:
                    this.supplementalVideoCanStream = value.getAsBoolean();
                    break;
                case 6:
                    this.foregroundColor = parseColor(value.getAsJsonObject(), -1);
                    break;
                case 7:
                    this.backgroundColor = parseColor(value.getAsJsonObject(), -16777216);
                    break;
                case '\b':
                    this.panelArtUrl = value.getAsString();
                    break;
                case '\t':
                    this.titleTreatmentUrl = value.getAsString();
                    break;
                case '\n':
                    this.videoType = VideoType.create(value.getAsString());
                    break;
            }
        }
    }

    private static int parseColor(JsonObject jsonObject, int i) {
        if (!jsonObject.has("r") || !jsonObject.has("g") || !jsonObject.has("b")) {
            return i;
        }
        return Color.rgb(jsonObject.get("r").getAsInt(), jsonObject.get("g").getAsInt(), jsonObject.get("b").getAsInt());
    }

    @Override // o.AbstractC2072pu
    public String getTitle() {
        return this.title;
    }

    @Override // o.pD
    public String getTitleTreatmentUrl() {
        return this.titleTreatmentUrl;
    }

    @Override // o.pD
    public String getPanelArtUrl() {
        return this.panelArtUrl;
    }

    @Override // o.AbstractC2072pu
    public String getId() {
        return this.videoId;
    }

    @Override // o.AbstractC2072pu
    public VideoType getType() {
        return this.videoType;
    }

    @Override // o.pD
    public pT getVideoDetails() {
        return this.videoDetails;
    }

    @Override // o.pD
    public void setVideoDetails(pT pTVar) {
        this.videoDetails = pTVar;
    }

    @Override // o.pD
    public String getSupplementalVideoId() {
        return this.supplementalVideoId;
    }

    @Override // o.pD
    public long getSupplementalVideoDuration() {
        return this.supplementVideoDuration;
    }

    public boolean getSupplementalVideoCanStream() {
        return this.supplementalVideoCanStream;
    }

    @Override // o.pD
    public int getForegroundColor() {
        return this.foregroundColor;
    }

    @Override // o.pD
    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public long getBookmark() {
        return this.bookmark;
    }

    @Override // o.pD
    public void setBookmark(long j) {
        if (j >= 0) {
            this.bookmark = j;
        }
    }

    @Override // o.pD
    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        if (this.position >= 0) {
            this.position = i;
        }
    }

    public String toString() {
        return String.format(Locale.US, "TAG: %sid: %s,title: %s,titleTreatmentUrl: %spanelArtUrl: %svideoType: %svideoId: %ssupplementalVideoId: %sbookmark: %dposition: %d", TAG, this.videoId, this.title, this.titleTreatmentUrl, this.panelArtUrl, this.videoType, this.videoId, this.supplementalVideoId, Long.valueOf(this.bookmark), Integer.valueOf(this.position));
    }

    @Override // o.pJ
    public String getBoxshotUrl() {
        return this.panelArtUrl;
    }

    @Override // o.pJ
    public VideoType getErrorType() {
        return VideoType.UNAVAILABLE;
    }

    @Override // o.pJ
    public String getBoxartId() {
        return "";
    }

    public MotionBoxart getMotionBoxart() {
        return null;
    }

    @Override // o.pJ
    public boolean isOriginal() {
        return this.isOriginal;
    }

    @Override // o.pJ
    public boolean isPreRelease() {
        return false;
    }
}
