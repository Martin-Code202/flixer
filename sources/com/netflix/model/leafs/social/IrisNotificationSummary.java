package com.netflix.model.leafs.social;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.Video;
import com.netflix.model.leafs.social.multititle.NotificationLandingPage;
import java.util.Map;
import o.AbstractC0852;
import o.C1276;
import o.C1349Bv;
import o.CH;
public class IrisNotificationSummary implements AbstractC0852, Parcelable {
    public static final Parcelable.Creator<IrisNotificationSummary> CREATOR = new Parcelable.Creator<IrisNotificationSummary>() { // from class: com.netflix.model.leafs.social.IrisNotificationSummary.1
        @Override // android.os.Parcelable.Creator
        public IrisNotificationSummary createFromParcel(Parcel parcel) {
            return new IrisNotificationSummary(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IrisNotificationSummary[] newArray(int i) {
            return new IrisNotificationSummary[i];
        }
    };
    private static final int NUM_OF_FIELDS = 28;
    private static final String TAG = "SocialNotificationSummary";
    @SerializedName("isRead")
    private boolean bWasRead;
    @SerializedName("isThanked")
    private boolean bWasThanked;
    @SerializedName("body")
    private String bodyText;
    @SerializedName("eventGuid")
    private String eventGuid;
    @SerializedName("fromUser")
    private FriendProfile friendProfile;
    @SerializedName("header")
    private String headerText;
    @SerializedName("id")
    private String id;
    @SerializedName("imageAltText")
    private String imageAltText;
    @SerializedName("imageTarget")
    private String imageTarget;
    @SerializedName("imageUrl")
    private String imageUrl;
    private boolean inQueue;
    private NotificationLandingPage landingPage;
    @SerializedName("msgString")
    private String messageString;
    @SerializedName("showTimestamp")
    private boolean showTimestamp;
    @SerializedName("showType")
    private VideoType showType;
    @SerializedName("storyId")
    private String storyId;
    @SerializedName("textTarget")
    private String textTarget;
    @SerializedName("timestamp")
    private long timestamp;
    private NotificationTrackingInfo trackingInfo;
    private String tvCardUrl;
    @SerializedName("msgType")
    private NotificationTypes type;
    @SerializedName("urlTarget")
    private String urlTarget;
    private String videoId;
    private String videoTitle;
    private VideoType videoType;

    public enum NotificationTypes {
        NEW_SEASON_ALERT,
        MULTI_TITLE_ALERT
    }

    public static NotificationTypes getNotificationType(String str, boolean z) {
        if (z) {
            return NotificationTypes.MULTI_TITLE_ALERT;
        }
        return NotificationTypes.NEW_SEASON_ALERT;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
            JsonElement value = entry.getValue();
            if (!value.isJsonNull()) {
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -2108533044:
                        if (key.equals("imageTarget")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -1933137793:
                        if (key.equals("isThanked")) {
                            c = 15;
                            break;
                        }
                        break;
                    case -1884251920:
                        if (key.equals("storyId")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1884240891:
                        if (key.equals("trackingInfo")) {
                            c = 18;
                            break;
                        }
                        break;
                    case -1473868046:
                        if (key.equals("msgString")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1244622187:
                        if (key.equals("fromUser")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -1221270899:
                        if (key.equals("header")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case -1180158496:
                        if (key.equals("isRead")) {
                            c = 14;
                            break;
                        }
                        break;
                    case -859610604:
                        if (key.equals("imageUrl")) {
                            c = '\r';
                            break;
                        }
                        break;
                    case -586188135:
                        if (key.equals("showTimestamp")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case -342813728:
                        if (key.equals("urlTarget")) {
                            c = 17;
                            break;
                        }
                        break;
                    case -338815017:
                        if (key.equals("showType")) {
                            c = 16;
                            break;
                        }
                        break;
                    case -306513765:
                        if (key.equals("imageAltText")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 3355:
                        if (key.equals("id")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3029410:
                        if (key.equals("body")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 31039555:
                        if (key.equals("eventGuid")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 55126294:
                        if (key.equals("timestamp")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 497102150:
                        if (key.equals("landingPage")) {
                            c = 19;
                            break;
                        }
                        break;
                    case 1343750747:
                        if (key.equals("msgType")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1862946078:
                        if (key.equals("textTarget")) {
                            c = '\f';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.id = value.getAsString();
                        continue;
                    case 1:
                        this.eventGuid = value.getAsString();
                        continue;
                    case 2:
                        this.storyId = value.getAsString();
                        continue;
                    case 3:
                        JsonElement jsonElement2 = asJsonObject.get("landingPage");
                        this.type = getNotificationType(value.getAsString(), jsonElement2 != JsonNull.INSTANCE && jsonElement2.isJsonObject());
                        continue;
                    case 4:
                        this.messageString = value.getAsString();
                        continue;
                    case 5:
                        this.friendProfile = new FriendProfile();
                        this.friendProfile.populate(value.getAsJsonObject());
                        continue;
                    case 6:
                        this.timestamp = value.getAsLong();
                        continue;
                    case 7:
                        this.imageAltText = value.getAsString();
                        continue;
                    case '\b':
                        this.imageTarget = value.getAsString();
                        continue;
                    case '\t':
                        this.showTimestamp = value.getAsBoolean();
                        continue;
                    case '\n':
                        this.headerText = value.getAsString();
                        continue;
                    case 11:
                        this.bodyText = value.getAsString();
                        continue;
                    case '\f':
                        this.textTarget = value.getAsString();
                        continue;
                    case '\r':
                        this.imageUrl = value.getAsString();
                        continue;
                    case 14:
                        this.bWasRead = value.getAsBoolean();
                        continue;
                    case 15:
                        this.bWasThanked = value.getAsBoolean();
                        continue;
                    case 16:
                        this.showType = "movie".equalsIgnoreCase(value.getAsString()) ? VideoType.MOVIE : VideoType.SHOW;
                        continue;
                    case 17:
                        this.urlTarget = value.getAsString();
                        continue;
                    case 18:
                        this.trackingInfo = NotificationTrackingInfo.get(value.toString());
                        continue;
                    case 19:
                        if (value.isJsonObject()) {
                            this.landingPage = new NotificationLandingPage();
                            this.landingPage.populate(value);
                            break;
                        } else {
                            C1276.m16820().mo5725(String.format("%s: JsonElement %s is not a JsonObject", TAG, jsonElement.toString()));
                            continue;
                        }
                }
            }
        }
    }

    public IrisNotificationSummary() {
    }

    public IrisNotificationSummary(String str, String str2) {
        this.id = str;
        this.storyId = str2;
    }

    public void fillVideoDetails(CH ch) {
        Video.Summary summary = (Video.Summary) ch.get("summary");
        this.videoId = summary.getId();
        this.videoType = summary.getType();
        this.videoTitle = summary.getTitle();
        this.inQueue = ((Video.InQueue) ch.get("inQueue")).inQueue;
        Video.TvCardArt tvCardArt = (Video.TvCardArt) ch.get("tvCardArt");
        if (tvCardArt != null) {
            this.tvCardUrl = tvCardArt.getUrl();
        }
    }

    public String getId() {
        return this.id;
    }

    public String getEventGuid() {
        return this.eventGuid;
    }

    public String getStoryId() {
        return this.storyId;
    }

    public String getMessageString() {
        return this.messageString;
    }

    public NotificationTypes getType() {
        return this.type;
    }

    public FriendProfile getFriendProfile() {
        return this.friendProfile;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getImageAltText() {
        return this.imageAltText;
    }

    public boolean getShowTimestamp() {
        return this.showTimestamp;
    }

    public String getHeaderText() {
        return this.headerText;
    }

    public String getBodyText() {
        return this.bodyText;
    }

    public String getImageTarget() {
        return this.imageTarget;
    }

    public String getTextTarget() {
        return this.textTarget;
    }

    public VideoType getVideoType() {
        return this.videoType;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public String getVideoTitle() {
        return this.videoTitle;
    }

    public String getTVCardUrl() {
        return C1349Bv.m4107(this.tvCardUrl) ? this.tvCardUrl : this.imageUrl;
    }

    public boolean getWasRead() {
        return this.bWasRead;
    }

    public void setWasRead(boolean z) {
        this.bWasRead = z;
    }

    public boolean getWasThanked() {
        return this.bWasThanked;
    }

    public void setWasThanked(boolean z) {
        this.bWasThanked = z;
    }

    public boolean getInQueueValue() {
        return this.inQueue;
    }

    public VideoType getShowType() {
        return this.showType;
    }

    public String getUrlTarget() {
        return this.urlTarget;
    }

    public NotificationTrackingInfo getTrackingInfo() {
        return this.trackingInfo;
    }

    public NotificationLandingPage getLandingPage() {
        return this.landingPage;
    }

    @Override // java.lang.Object
    public String toString() {
        return "SocialNotificationSummary [id=" + this.id + ", storyId=" + this.storyId + ", type=" + this.type + ", messageString=" + this.messageString + ", friendProfile=" + this.friendProfile + ", timestamp=" + this.timestamp + ", bWasRead=" + this.bWasRead + ", bWasThanked=" + this.bWasThanked + "]";
    }

    protected IrisNotificationSummary(Parcel parcel) {
        String[] strArr = new String[28];
        parcel.readStringArray(strArr);
        this.bWasRead = Boolean.valueOf(strArr[0]).booleanValue();
        this.bWasThanked = Boolean.valueOf(strArr[1]).booleanValue();
        String str = strArr[2];
        String str2 = strArr[3];
        String str3 = strArr[4];
        String str4 = strArr[5];
        this.friendProfile = new FriendProfile(str, str2, str3, str4, str4);
        this.id = strArr[6];
        this.eventGuid = strArr[7];
        this.storyId = strArr[8];
        if (C1349Bv.m4107(strArr[9])) {
            this.type = NotificationTypes.valueOf(strArr[9]);
        }
        this.messageString = strArr[10];
        this.timestamp = Long.valueOf(strArr[11]).longValue();
        this.imageAltText = strArr[12];
        this.showTimestamp = Boolean.valueOf(strArr[13]).booleanValue();
        this.headerText = strArr[14];
        this.imageUrl = strArr[15];
        this.videoId = strArr[16];
        this.videoType = VideoType.create(strArr[17].concat("s"));
        this.videoTitle = strArr[18];
        this.tvCardUrl = strArr[19];
        this.inQueue = Boolean.valueOf(strArr[20]).booleanValue();
        if (C1349Bv.m4107(strArr[21])) {
            this.showType = VideoType.valueOf(strArr[21]);
        }
        this.bodyText = strArr[22];
        this.imageTarget = strArr[23];
        this.textTarget = strArr[24];
        this.urlTarget = strArr[25];
        if (C1349Bv.m4107(strArr[26])) {
            this.trackingInfo = NotificationTrackingInfo.get(strArr[26]);
        }
        if (C1349Bv.m4107(strArr[27])) {
            this.landingPage = new NotificationLandingPage();
            this.landingPage.populate(strArr[27]);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        String[] strArr = new String[28];
        strArr[0] = String.valueOf(this.bWasRead);
        strArr[1] = String.valueOf(this.bWasThanked);
        if (this.friendProfile != null) {
            strArr[2] = this.friendProfile.getId();
            strArr[3] = this.friendProfile.getFirstName();
            strArr[4] = this.friendProfile.getLastName();
            strArr[5] = this.friendProfile.getImageUrl();
        }
        strArr[6] = this.id;
        strArr[7] = this.eventGuid;
        strArr[8] = this.storyId;
        strArr[10] = this.messageString;
        if (this.type != null) {
            strArr[9] = this.type.name();
        }
        strArr[11] = String.valueOf(this.timestamp);
        strArr[12] = this.imageAltText;
        strArr[13] = String.valueOf(this.showTimestamp);
        strArr[14] = this.headerText;
        strArr[15] = this.imageUrl;
        strArr[16] = this.videoId;
        strArr[17] = this.videoType.getValue();
        strArr[18] = this.videoTitle;
        strArr[19] = this.tvCardUrl;
        strArr[20] = String.valueOf(this.inQueue);
        if (this.showType != null) {
            strArr[21] = this.showType.name();
        }
        strArr[22] = this.bodyText;
        strArr[23] = this.imageTarget;
        strArr[24] = this.textTarget;
        strArr[25] = this.urlTarget;
        if (this.trackingInfo != null) {
            strArr[26] = this.trackingInfo.toString();
        }
        if (this.landingPage != null) {
            strArr[27] = this.landingPage.serializeToJsonString();
        }
        parcel.writeStringArray(strArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getId().hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IrisNotificationSummary irisNotificationSummary = (IrisNotificationSummary) obj;
        if (this.id == null) {
            if (irisNotificationSummary.id != null) {
                return false;
            }
        } else if (!this.id.equals(irisNotificationSummary.id)) {
            return false;
        }
        if (this.bWasRead == irisNotificationSummary.bWasRead && this.bWasThanked == irisNotificationSummary.bWasThanked && C1349Bv.m4126(this.videoId, irisNotificationSummary.videoId) && this.inQueue == irisNotificationSummary.inQueue) {
            return true;
        }
        return false;
    }
}
