package com.netflix.model.leafs;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.mediaclient.servicemgr.interface_.IconFontGlyph;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.advisory.Advisory;
import com.netflix.model.leafs.blades.CreditMarks;
import com.netflix.model.leafs.originals.interactive.InteractiveFeatures;
import com.netflix.model.leafs.originals.interactive.MotionBoxart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import o.AK;
import o.AbstractC0847;
import o.AbstractC0852;
import o.AbstractC2075px;
import o.C1131;
import o.C1281;
import o.C1283;
import o.pE;
import o.pJ;
public final class Video {
    private Video() {
    }

    public static class CwCleanBoxart implements AbstractC0852, AbstractC2075px {
        private static final String TAG = "CwCleanBoxart";
        public String bannerLessBoxartUrl;

        @Override // o.AbstractC2075px
        public String getCleanBoxshotUrl() {
            return this.bannerLessBoxartUrl;
        }

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            this.bannerLessBoxartUrl = jsonElement.getAsJsonObject().get("cleanBoxartUrl").getAsString();
        }
    }

    public static final class Advisories extends AbstractC0847 implements AbstractC0852 {
        private static final String TAG = "Advisories";
        private List<Advisory> advisories = new ArrayList(0);

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            this.advisories = Advisory.asList(jsonElement.getAsJsonObject().getAsJsonArray("advisory"));
        }

        public List<Advisory> getAdvisoryList() {
            return this.advisories;
        }

        public String toString() {
            return "Advisories [advisory=" + this.advisories + "]";
        }
    }

    public static class Summary extends AbstractC0847 implements pJ, AbstractC0852 {
        private static final String TAG = "Summary";
        public String boxartId;
        public String boxartUrl;
        public VideoType enumType;
        public VideoType errorType;
        public String id;
        public boolean isOriginal;
        public boolean isPreRelease;
        public MotionBoxart motionBoxart;
        public String title;
        public String type;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -2040995853:
                        if (key.equals("boxartId")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1817595890:
                        if (key.equals("motionBoxart")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 3355:
                        if (key.equals("id")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3575610:
                        if (key.equals("type")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 110371416:
                        if (key.equals("title")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 135683246:
                        if (key.equals("isPreRelease")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 329552226:
                        if (key.equals("errorType")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 585773339:
                        if (key.equals("isOriginal")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1153650071:
                        if (key.equals("boxartUrl")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.id = value.getAsString();
                        break;
                    case 1:
                        this.boxartUrl = value.getAsString();
                        break;
                    case 2:
                        this.boxartId = value.getAsString();
                        break;
                    case 3:
                        this.type = value.getAsString();
                        break;
                    case 4:
                        this.title = value.getAsString();
                        break;
                    case 5:
                        this.errorType = VideoType.create(value.getAsString());
                        break;
                    case 6:
                        this.isOriginal = entry.getValue().getAsBoolean();
                        break;
                    case 7:
                        this.isPreRelease = entry.getValue().getAsBoolean();
                        break;
                    case '\b':
                        this.motionBoxart = (MotionBoxart) ((Gson) C1281.m16832(Gson.class)).fromJson((JsonElement) value.getAsJsonObject(), (Class<Object>) MotionBoxart.class);
                        break;
                }
            }
        }

        @Override // o.AbstractC2072pu
        public String getId() {
            return this.id;
        }

        @Override // o.AbstractC2072pu
        public String getTitle() {
            return this.title;
        }

        @Override // o.pJ
        public String getBoxshotUrl() {
            return this.boxartUrl;
        }

        @Override // o.pJ
        public String getBoxartId() {
            return this.boxartId;
        }

        @Override // o.AbstractC2072pu
        public VideoType getType() {
            if (this.enumType == null) {
                this.enumType = VideoType.create(this.type);
            }
            return this.enumType;
        }

        public String toString() {
            return "Summary [id=" + this.id + ", type=" + this.type + ", title=" + this.title + "]";
        }

        @Override // o.pJ
        public VideoType getErrorType() {
            return this.errorType;
        }

        public void setErrorType(VideoType videoType) {
            this.errorType = videoType;
        }

        @Override // o.pJ
        public boolean isOriginal() {
            return this.isOriginal;
        }

        @Override // o.pJ
        public boolean isPreRelease() {
            return this.isPreRelease;
        }

        public MotionBoxart getMotionBoxart() {
            return this.motionBoxart;
        }
    }

    public static final class Bookmark extends AbstractC0847 implements AbstractC0852 {
        private static final String TAG = "Bookmark";
        private int bookmarkPosition;
        private long lastModified;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            int i = this.bookmarkPosition;
            long j = this.lastModified;
            for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1829827457:
                        if (key.equals("bookmarkPosition")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1959003007:
                        if (key.equals("lastModified")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.bookmarkPosition = value.getAsInt();
                        break;
                    case 1:
                        this.lastModified = value.getAsLong();
                        break;
                }
            }
            if (j > this.lastModified) {
                C1283.m16851(TAG, "restoring bookmark and time (%d - %d) to older values (%d - %d)", Integer.valueOf(this.bookmarkPosition), Long.valueOf(this.lastModified), Integer.valueOf(i), Long.valueOf(j));
                this.bookmarkPosition = i;
                this.lastModified = j;
            }
        }

        public void setBookmarkPosition(int i) {
            this.bookmarkPosition = i;
        }

        public int getBookmarkPosition() {
            return this.bookmarkPosition;
        }

        public long getLastModified() {
            return this.lastModified;
        }

        public void setLastModified(long j) {
            this.lastModified = j;
        }

        public String toString() {
            return "Bookmark [bookmarkPosition=" + this.bookmarkPosition + ", lastModified=" + this.lastModified + "]";
        }

        public void deepCopy(Bookmark bookmark) {
            this.bookmarkPosition = bookmark.bookmarkPosition;
            this.lastModified = bookmark.lastModified;
        }
    }

    public static final class InQueue extends AbstractC0847 implements AbstractC0852 {
        private static final String TAG = "InQueue";
        public boolean inQueue;

        public InQueue() {
        }

        public InQueue(boolean z) {
            this.inQueue = z;
        }

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case 1926204140:
                        if (key.equals("inQueue")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.inQueue = value.getAsBoolean();
                        break;
                }
            }
        }

        public String toString() {
            return "InQueue [inQueue=" + this.inQueue + "]";
        }
    }

    public static final class HasWatched extends AbstractC0847 implements AbstractC0852 {
        private static final String TAG = "hasWatched";
        public boolean hasWatched;

        public HasWatched() {
        }

        public HasWatched(boolean z) {
            this.hasWatched = z;
        }

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            C1283.m16848(TAG, "Populating with: %s", asJsonObject);
            for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1136616012:
                        if (key.equals(TAG)) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.hasWatched = value.getAsBoolean();
                        break;
                }
            }
        }

        public String toString() {
            return "hasWatched [hasWatched=" + this.hasWatched + "]";
        }
    }

    public static final class RatingInfo extends AbstractC0847 implements pE, AbstractC0852 {
        private static final String TAG = "RatingInfo";
        public boolean isNewForPvr;
        public int matchPercentage;
        public int userThumbRating;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1588595137:
                        if (key.equals("matchPercentage")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -145025464:
                        if (key.equals("userThumbRating")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 205892953:
                        if (key.equals("isNewForPvr")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.userThumbRating = C1131.m16286(value.getAsInt());
                        break;
                    case 1:
                        this.matchPercentage = value.getAsInt();
                        break;
                    case 2:
                        this.isNewForPvr = value.getAsBoolean();
                        break;
                }
            }
        }

        @Override // o.pE
        public int getUserThumbRating() {
            return this.userThumbRating;
        }

        public int getMatchPercentage() {
            return this.matchPercentage;
        }

        public boolean isNewForPvr() {
            return this.isNewForPvr;
        }

        public String toString() {
            return "Rating [userThumbRating=" + this.userThumbRating + ", matchPercentage=" + this.matchPercentage + ", isNewForPvr=" + this.isNewForPvr + "]";
        }
    }

    public static final class OfflineAvailable extends AbstractC0847 implements AbstractC0852 {
        private static final String TAG = "OfflineAvailable";
        public boolean isAvailableOffline;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1284582364:
                        if (key.equals("isAvailableOffline")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.isAvailableOffline = value.getAsBoolean();
                        break;
                }
            }
        }

        public boolean isAvailableOffline() {
            return this.isAvailableOffline;
        }

        public String toString() {
            return "offlineAvailable [offlineAvailable=" + this.isAvailableOffline + "]";
        }
    }

    public static class Detail extends AbstractC0847 implements AbstractC0852 {
        private static final String TAG = "Detail";
        public String actors;
        public int autoPlayMaxCount = -1;
        public String baseUrl;
        public String baseUrlBig;
        public String bifUrl;
        public String certification;
        public Set<String> characterRoles = new HashSet();
        public String copyright;
        public CreditMarks creditMarks;
        public String directors;
        public int endtime;
        public List<String> episodeBadges = new ArrayList(3);
        public int episodeCount;
        public boolean episodeNumberHidden;
        public long expirationTime;
        public String genres;
        public boolean hasTrailers;
        public String hiResHorzUrl;
        public String horzDispUrl;
        public InteractiveFeatures interactiveFeatures;
        public String interestingUrl;
        public boolean is5dot1Available;
        public boolean isAgeProtected;
        public boolean isAutoPlayEnabled;
        public boolean isAvailableToStream;
        public boolean isDolbyVisionAvailable;
        public boolean isDownloadAvailable;
        public boolean isEpisode;
        public boolean isHdAvailable;
        public boolean isHdr10Avaiable;
        public boolean isNSRE;
        public boolean isNextPlayableEpisode;
        public boolean isOriginal;
        public boolean isPinProtected;
        public boolean isPreRelease;
        public boolean isPreviewProtected;
        public boolean isSupplementalVideo;
        public boolean isUhdAvailable;
        public int logicalStart;
        public int maturityLevel;
        public String mdxVertUrl;
        public String newBadge;
        public float predictedRating;
        public String quality;
        public String restUrl;
        public int runtime;
        public int seasonCount;
        public String seasonNumLabel;
        public String storyImgUrl;
        public String supplementalMessage;
        public boolean supportsPrePlay;
        public String synopsis;
        public String synopsisNarrative;
        public String titleCroppedUrl;
        public String titleUrl;
        public String tvCardUrl;
        public int year;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -2124216975:
                        if (key.equals("isEpisode")) {
                            c = '\r';
                            break;
                        }
                        break;
                    case -1944322078:
                        if (key.equals("isUhdAvailable")) {
                            c = '!';
                            break;
                        }
                        break;
                    case -1931492381:
                        if (key.equals("isPinProtected")) {
                            c = ')';
                            break;
                        }
                        break;
                    case -1870009353:
                        if (key.equals("titleUrl")) {
                            c = '-';
                            break;
                        }
                        break;
                    case -1865391343:
                        if (key.equals("seasonNumLabel")) {
                            c = '/';
                            break;
                        }
                        break;
                    case -1794520227:
                        if (key.equals("tvCardUrl")) {
                            c = 23;
                            break;
                        }
                        break;
                    case -1606289880:
                        if (key.equals("endtime")) {
                            c = 30;
                            break;
                        }
                        break;
                    case -1551264767:
                        if (key.equals("storyImgUrl")) {
                            c = 26;
                            break;
                        }
                        break;
                    case -1422944994:
                        if (key.equals("actors")) {
                            c = 6;
                            break;
                        }
                        break;
                    case -1410856650:
                        if (key.equals("is5dot1Available")) {
                            c = '$';
                            break;
                        }
                        break;
                    case -1389216784:
                        if (key.equals("bifUrl")) {
                            c = 20;
                            break;
                        }
                        break;
                    case -1302288478:
                        if (key.equals("isHdr10Avaiable")) {
                            c = '#';
                            break;
                        }
                        break;
                    case -1249499312:
                        if (key.equals("genres")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -1217996834:
                        if (key.equals("horzDispUrl")) {
                            c = 18;
                            break;
                        }
                        break;
                    case -1180295454:
                        if (key.equals("isNSRE")) {
                            c = '2';
                            break;
                        }
                        break;
                    case -1077707340:
                        if (key.equals("isAutoPlayEnabled")) {
                            c = '%';
                            break;
                        }
                        break;
                    case -962584985:
                        if (key.equals("directors")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -885502996:
                        if (key.equals("seasonCount")) {
                            c = 28;
                            break;
                        }
                        break;
                    case -869395137:
                        if (key.equals("interactiveFeatures")) {
                            c = '7';
                            break;
                        }
                        break;
                    case -802117293:
                        if (key.equals("supportsPrePlay")) {
                            c = '6';
                            break;
                        }
                        break;
                    case -762550462:
                        if (key.equals("baseUrlBig")) {
                            c = 22;
                            break;
                        }
                        break;
                    case -668327396:
                        if (key.equals("expirationTime")) {
                            c = 11;
                            break;
                        }
                        break;
                    case -644524870:
                        if (key.equals("certification")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case -602057255:
                        if (key.equals("logicalStart")) {
                            c = 31;
                            break;
                        }
                        break;
                    case -515828317:
                        if (key.equals("isHdAvailable")) {
                            c = ' ';
                            break;
                        }
                        break;
                    case -496641730:
                        if (key.equals("synopsisNarrative")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -389852269:
                        if (key.equals("isDolbyVisionAvailable")) {
                            c = '\"';
                            break;
                        }
                        break;
                    case -332625698:
                        if (key.equals("baseUrl")) {
                            c = 21;
                            break;
                        }
                        break;
                    case -320459827:
                        if (key.equals("creditMarks")) {
                            c = '5';
                            break;
                        }
                        break;
                    case -263240971:
                        if (key.equals("predictedRating")) {
                            c = ',';
                            break;
                        }
                        break;
                    case -144454054:
                        if (key.equals("hasTrailers")) {
                            c = 16;
                            break;
                        }
                        break;
                    case -23645737:
                        if (key.equals("interestingUrl")) {
                            c = '4';
                            break;
                        }
                        break;
                    case 3704893:
                        if (key.equals("year")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 32546672:
                        if (key.equals("canStream")) {
                            c = '+';
                            break;
                        }
                        break;
                    case 38526579:
                        if (key.equals("maturityLevel")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 113933357:
                        if (key.equals("isSupplementalVideo")) {
                            c = 17;
                            break;
                        }
                        break;
                    case 135683246:
                        if (key.equals("isPreRelease")) {
                            c = 15;
                            break;
                        }
                        break;
                    case 235142126:
                        if (key.equals("episodeNumberHidden")) {
                            c = '3';
                            break;
                        }
                        break;
                    case 344945940:
                        if (key.equals("characterRoles")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 398159229:
                        if (key.equals("mdxVertUrl")) {
                            c = 25;
                            break;
                        }
                        break;
                    case 417758403:
                        if (key.equals("supplementalMessage")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case 585773339:
                        if (key.equals("isOriginal")) {
                            c = 14;
                            break;
                        }
                        break;
                    case 651215103:
                        if (key.equals("quality")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 834414096:
                        if (key.equals("isPreviewProtected")) {
                            c = '*';
                            break;
                        }
                        break;
                    case 1062174849:
                        if (key.equals("hiResHorzUrl")) {
                            c = 24;
                            break;
                        }
                        break;
                    case 1097494779:
                        if (key.equals("restUrl")) {
                            c = 19;
                            break;
                        }
                        break;
                    case 1135089838:
                        if (key.equals("autoPlayMaxCount")) {
                            c = '&';
                            break;
                        }
                        break;
                    case 1349977571:
                        if (key.equals("newBadge")) {
                            c = '1';
                            break;
                        }
                        break;
                    case 1426350736:
                        if (key.equals("isNextPlayableEpisode")) {
                            c = '\'';
                            break;
                        }
                        break;
                    case 1440369896:
                        if (key.equals("titleCroppedUrl")) {
                            c = '.';
                            break;
                        }
                        break;
                    case 1494791097:
                        if (key.equals("isAgeProtected")) {
                            c = '(';
                            break;
                        }
                        break;
                    case 1522889671:
                        if (key.equals("copyright")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1550962648:
                        if (key.equals("runtime")) {
                            c = 29;
                            break;
                        }
                        break;
                    case 1590765524:
                        if (key.equals("episodeCount")) {
                            c = 27;
                            break;
                        }
                        break;
                    case 1828656532:
                        if (key.equals("synopsis")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2027019019:
                        if (key.equals("episodeBadges")) {
                            c = '0';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.year = value.getAsInt();
                        break;
                    case 1:
                        this.synopsis = value.getAsString();
                        break;
                    case 2:
                        this.copyright = value.getAsString();
                        break;
                    case 3:
                        this.synopsisNarrative = value.getAsString();
                        break;
                    case 4:
                        this.quality = value.getAsString();
                        break;
                    case 5:
                        this.directors = value.getAsString();
                        break;
                    case 6:
                        this.actors = value.getAsString();
                        break;
                    case 7:
                        this.characterRoles.clear();
                        if (!value.isJsonNull()) {
                            String asString = value.getAsString();
                            if (!TextUtils.isEmpty(asString)) {
                                Collections.addAll(this.characterRoles, asString.split(","));
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case '\b':
                        this.genres = value.getAsString();
                        break;
                    case '\t':
                        this.certification = value.getAsString();
                        break;
                    case '\n':
                        this.maturityLevel = value.getAsInt();
                        break;
                    case 11:
                        if (value != null && !value.isJsonNull()) {
                            this.expirationTime = value.getAsLong();
                            break;
                        }
                    case '\f':
                        this.supplementalMessage = AK.m3375(value);
                        break;
                    case '\r':
                        this.isEpisode = value.getAsBoolean();
                        break;
                    case 14:
                        this.isOriginal = value.getAsBoolean();
                        break;
                    case 15:
                        this.isPreRelease = value.getAsBoolean();
                        break;
                    case 16:
                        this.hasTrailers = value.getAsBoolean();
                        break;
                    case 17:
                        this.isSupplementalVideo = value.getAsBoolean();
                        break;
                    case 18:
                        if (value != null && !value.isJsonNull()) {
                            this.horzDispUrl = AK.m3375(value);
                            break;
                        }
                    case 19:
                        this.restUrl = value.getAsString();
                        break;
                    case 20:
                        this.bifUrl = value.getAsString();
                        break;
                    case 21:
                        this.baseUrl = value.getAsString();
                        break;
                    case 22:
                        this.baseUrlBig = value.getAsString();
                        break;
                    case 23:
                        this.tvCardUrl = value.getAsString();
                        break;
                    case 24:
                        this.hiResHorzUrl = value.getAsString();
                        break;
                    case 25:
                        this.mdxVertUrl = value.getAsString();
                        break;
                    case 26:
                        this.storyImgUrl = value.getAsString();
                        break;
                    case 27:
                        this.episodeCount = value.getAsInt();
                        break;
                    case 28:
                        this.seasonCount = value.getAsInt();
                        break;
                    case 29:
                        this.runtime = value.getAsInt();
                        break;
                    case 30:
                        this.endtime = value.getAsInt();
                        break;
                    case 31:
                        this.logicalStart = value.getAsInt();
                        break;
                    case ' ':
                        this.isHdAvailable = value.getAsBoolean();
                        break;
                    case '!':
                        this.isUhdAvailable = value.getAsBoolean();
                        break;
                    case '\"':
                        this.isDolbyVisionAvailable = value.getAsBoolean();
                        break;
                    case '#':
                        this.isHdr10Avaiable = value.getAsBoolean();
                        break;
                    case '$':
                        this.is5dot1Available = value.getAsBoolean();
                        break;
                    case '%':
                        this.isAutoPlayEnabled = value.getAsBoolean();
                        break;
                    case '&':
                        this.autoPlayMaxCount = value.getAsInt();
                        break;
                    case '\'':
                        this.isNextPlayableEpisode = value.getAsBoolean();
                        break;
                    case '(':
                        this.isAgeProtected = value.getAsBoolean();
                        break;
                    case ')':
                        this.isPinProtected = value.getAsBoolean();
                        break;
                    case '*':
                        this.isPreviewProtected = value.getAsBoolean();
                        break;
                    case '+':
                        this.isAvailableToStream = value.getAsBoolean();
                        break;
                    case ',':
                        this.predictedRating = value.getAsFloat();
                        break;
                    case '-':
                        this.titleUrl = value.getAsString();
                        break;
                    case '.':
                        this.titleCroppedUrl = value.getAsString();
                        break;
                    case '/':
                        this.seasonNumLabel = AK.m3375(value);
                        break;
                    case '0':
                        JsonArray asJsonArray = value.getAsJsonArray();
                        for (int i = 0; i < asJsonArray.size(); i++) {
                            this.episodeBadges.add(asJsonArray.get(i).getAsString());
                        }
                        break;
                    case '1':
                        if (value != null && !value.isJsonNull()) {
                            this.newBadge = value.getAsString();
                            break;
                        }
                    case '2':
                        this.isNSRE = value.getAsBoolean();
                        break;
                    case '3':
                        this.episodeNumberHidden = value.getAsBoolean();
                        break;
                    case '4':
                        if (value != null && !value.isJsonNull()) {
                            this.interestingUrl = value.getAsString();
                            break;
                        }
                    case '5':
                        this.creditMarks = (CreditMarks) ((Gson) C1281.m16832(Gson.class)).fromJson((JsonElement) value.getAsJsonObject(), (Class<Object>) CreditMarks.class);
                        break;
                    case '6':
                        this.supportsPrePlay = value.getAsBoolean();
                        break;
                    case '7':
                        this.interactiveFeatures = (InteractiveFeatures) ((Gson) C1281.m16832(Gson.class)).fromJson((JsonElement) value.getAsJsonObject(), (Class<Object>) InteractiveFeatures.class);
                        break;
                }
            }
        }

        public String toString() {
            return "Detail{year=" + this.year + ", synopsis='" + this.synopsis + "', synopsisNarrative='" + this.synopsisNarrative + "', quality='" + this.quality + "', directors='" + this.directors + "', actors='" + this.actors + "', characterRoles='" + this.characterRoles.toString() + "', genres='" + this.genres + "', certification='" + this.certification + "', copyright='" + this.copyright + "', horzDispUrl='" + this.horzDispUrl + "', restUrl='" + this.restUrl + "', bifUrl='" + this.bifUrl + "', baseUrl='" + this.baseUrl + "', baseUrlBig='" + this.baseUrlBig + "', tvCardUrl='" + this.tvCardUrl + "', hiResHorzUrl='" + this.hiResHorzUrl + "', mdxVertUrl='" + this.mdxVertUrl + "', storyImgUrl='" + this.storyImgUrl + "', titleUrl='" + this.titleUrl + "', titleCroppedUrl='" + this.titleCroppedUrl + "', seasonNumLabel='" + this.seasonNumLabel + "', episodeCount=" + this.episodeCount + ", seasonCount=" + this.seasonCount + ", predictedRating=" + this.predictedRating + ", maturityLevel=" + this.maturityLevel + ", expirationTime=" + this.expirationTime + ", supplementalMessage='" + this.supplementalMessage + "', isEpisode=" + this.isEpisode + ", isOriginal=" + this.isOriginal + ", isPreRelease=" + this.isPreRelease + ", isAvailableForDownload=" + this.isDownloadAvailable + ", hasTrailers=" + this.hasTrailers + ", isSupplementalVideo=" + this.isSupplementalVideo + ", isNSRE=" + this.isNSRE + ", newBadge=" + this.newBadge + ", episodeNumberHidden=" + this.episodeNumberHidden + ", isHdAvailable=" + this.isHdAvailable + ", isUhdAvailable=" + this.isUhdAvailable + ", isDolbyVisionAvailable=" + this.isDolbyVisionAvailable + ", isHdr10Avaiable=" + this.isHdr10Avaiable + ", is5dot1Available=" + this.is5dot1Available + ", isAutoPlayEnabled=" + this.isAutoPlayEnabled + ", isNextPlayableEpisode=" + this.isNextPlayableEpisode + ", isAgeProtected=" + this.isAgeProtected + ", isPinProtected=" + this.isPinProtected + ", isPreviewProtected=" + this.isPreviewProtected + ", autoPlayMaxCount=" + this.autoPlayMaxCount + ", episodeBadges=" + this.episodeBadges + ", isAvailableToStream=" + this.isAvailableToStream + ", runtime=" + this.runtime + ", endtime=" + this.endtime + ", logicalStart=" + this.logicalStart + ", supportsPrePlay=" + this.supportsPrePlay + ", interactiveFeatures=" + this.interactiveFeatures + '}';
        }

        public String getInterestingUrl() {
            return this.interestingUrl;
        }
    }

    public static final class SearchTitle extends AbstractC0847 implements AbstractC0852 {
        private static final String TAG = "SearchTitle";
        public String certification;
        public String entityId;
        public String horzDispUrl;
        public boolean isOriginal;
        public boolean isPreRelease;
        public int releaseYear;
        public String title;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -2102099874:
                        if (key.equals("entityId")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1217996834:
                        if (key.equals("horzDispUrl")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -644524870:
                        if (key.equals("certification")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 110371416:
                        if (key.equals("title")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 135683246:
                        if (key.equals("isPreRelease")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 213502180:
                        if (key.equals("releaseYear")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 585773339:
                        if (key.equals("isOriginal")) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.title = value.getAsString();
                        break;
                    case 1:
                        this.entityId = value.getAsString();
                        break;
                    case 2:
                        this.certification = value.getAsString();
                        break;
                    case 3:
                        this.horzDispUrl = value.getAsString();
                        break;
                    case 4:
                        this.releaseYear = value.getAsInt();
                        break;
                    case 5:
                        this.isOriginal = value.getAsBoolean();
                        break;
                    case 6:
                        this.isPreRelease = value.getAsBoolean();
                        break;
                }
            }
        }

        public String toString() {
            return this.title;
        }
    }

    public static class Evidence extends AbstractC0847 implements AbstractC0852 {
        private static final String TAG = "Evidence";
        private String kind;
        private String text;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("value");
            if (jsonElement2 != null && jsonElement2.isJsonObject()) {
                for (Map.Entry<String, JsonElement> entry : jsonElement2.getAsJsonObject().entrySet()) {
                    JsonElement value = entry.getValue();
                    String key = entry.getKey();
                    char c = 65535;
                    switch (key.hashCode()) {
                        case 3292052:
                            if (key.equals("kind")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 3556653:
                            if (key.equals("text")) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            this.kind = value.getAsString();
                            break;
                        case 1:
                            this.text = value.getAsString();
                            break;
                    }
                }
            }
        }

        public IconFontGlyph getIconFontGlyph() {
            if (this.kind == null) {
                return null;
            }
            String lowerCase = this.kind.toLowerCase(Locale.US);
            char c = 65535;
            switch (lowerCase.hashCode()) {
                case -1405038154:
                    if (lowerCase.equals("awards")) {
                        c = 0;
                        break;
                    }
                    break;
                case -881086228:
                    if (lowerCase.equals("talent")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1265466804:
                    if (lowerCase.equals("tvratings")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1542977607:
                    if (lowerCase.equals("boxoffice")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return IconFontGlyph.EVIDENCE_AWARDS;
                case 1:
                    return IconFontGlyph.EVIDENCE_BOX_OFFICE;
                case 2:
                    return IconFontGlyph.EVIDENCE_TALENT;
                case 3:
                    return IconFontGlyph.EVIDENCE_TV_RATINGS;
                default:
                    return IconFontGlyph.EVIDENCE_GENERIC;
            }
        }

        public String getText() {
            return this.text;
        }

        public String toString() {
            return "Evidence [kind=" + this.kind + ", text=" + this.text + "]";
        }
    }

    public static class HeroImages extends AbstractC0847 implements AbstractC0852 {
        private static final String TAG = "HeroImages";
        public List<String> heroImgs = new ArrayList(3);

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            JsonArray asJsonArray = jsonElement.getAsJsonObject().getAsJsonArray("heroImgs");
            this.heroImgs.clear();
            for (int i = 0; i < asJsonArray.size(); i++) {
                this.heroImgs.add(asJsonArray.get(i).getAsString());
            }
        }

        public String toString() {
            return "HeroImages [heroImgs=" + this.heroImgs + "]";
        }
    }

    public static class SupplementalVideos extends AbstractC0847 implements AbstractC0852 {
        private static final String TAG = "SupplementalVideos";
        public String defaultTrailer;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            JsonElement jsonElement2;
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject != null && (jsonElement2 = asJsonObject.get("id")) != null) {
                this.defaultTrailer = jsonElement2.getAsString();
            }
        }

        public String toString() {
            return "SupplementalVideos [defaultTrailer=" + this.defaultTrailer + "]";
        }
    }

    public static class TallPanelArt extends AbstractC0847 implements AbstractC0852 {
        private final String TAG = "TallPanelArt";
        private String imageTypeIdentifier;
        private String url;

        public String getUrl() {
            return this.url;
        }

        public String getImageTypeIdentifier() {
            return this.imageTypeIdentifier;
        }

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            if (jsonElement instanceof JsonObject) {
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    JsonElement value = entry.getValue();
                    String key = entry.getKey();
                    char c = 65535;
                    switch (key.hashCode()) {
                        case -576761410:
                            if (key.equals("imageTypeIdentifier")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 116079:
                            if (key.equals("url")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            this.url = AK.m3375(value);
                            break;
                        case 1:
                            this.imageTypeIdentifier = AK.m3375(value);
                            break;
                    }
                }
            }
        }
    }

    public static class VerticalStoryArt extends AbstractC0847 implements AbstractC0852 {
        private static final String TAG = "VerticalStoryArt";
        public String url;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            JsonElement jsonElement2;
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject != null && (jsonElement2 = asJsonObject.get("vertStoryArt")) != null) {
                this.url = jsonElement2.getAsString();
            }
        }

        public String toString() {
            return "VerticalStoryArt [vertStoryArtUrl=" + this.url + "]";
        }
    }

    public static class HorizontalDisplayArt extends VideoArtwork {
        public HorizontalDisplayArt() {
            super("horzDispUrl");
        }
    }

    public static class HorizontalDisplaySmallArt extends VideoArtwork {
        public HorizontalDisplaySmallArt() {
            super("horzDispSmallUrl");
        }
    }

    public static class StoryImgDisplayArt extends VideoArtwork {
        public StoryImgDisplayArt() {
            super("storyImgDispUrl");
        }
    }

    public static class InterestingMomentsUrl extends VideoArtwork {
        public InterestingMomentsUrl() {
            super("interestingUrl");
        }
    }

    public static class TrickPlayBaseUrl extends VideoArtwork {
        public TrickPlayBaseUrl() {
            super("baseUrl");
        }
    }

    public static class TrickPlayBaseBigUrl extends VideoArtwork {
        public TrickPlayBaseBigUrl() {
            super("baseUrlBig");
        }
    }

    public static class TvCardArt extends VideoArtwork {
        public TvCardArt() {
            super("tvCardUrl");
        }
    }

    public static class VideoArtwork extends AbstractC0847 implements AbstractC0852 {
        private String artworkKey = "boxartUrl";
        public String url;

        public VideoArtwork(String str) {
            this.artworkKey = str;
        }

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            JsonElement jsonElement2;
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject != null && (jsonElement2 = asJsonObject.get(this.artworkKey)) != null) {
                this.url = jsonElement2.getAsString();
            }
        }

        public String getUrl() {
            return this.url;
        }

        public String toString() {
            return this.artworkKey + " [url= " + this.url + "]";
        }
    }
}
