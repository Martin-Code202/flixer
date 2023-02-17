package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.Video;
import java.util.List;
import java.util.Map;
import o.AK;
public final class Episode {
    private Episode() {
    }

    public static final class Detail extends Video.Detail {
        private static final String TAG = "Episode.Detail";
        public String abbrSeqLabel;
        private String availabilityDateMsg;
        private String boxartUrl;
        private VideoType enumType;
        private int episodeNumber;
        private VideoType errorType;
        private String id;
        public String interestingSmallUrl;
        public boolean isNSRE;
        private String nextEpisodeId;
        private String nextEpisodeTitle;
        private String seasonId;
        private int seasonNumber;
        private String showId;
        private String showRestUrl;
        private String showTitle;
        private String title;
        private String type;

        @Override // com.netflix.model.leafs.Video.Detail, o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            super.populate(jsonElement);
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1913803429:
                        if (key.equals("showTitle")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1905664732:
                        if (key.equals("episodeNumber")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case -1779904744:
                        if (key.equals("availabilityDateMsg")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case -1360577524:
                        if (key.equals("seasonNumber")) {
                            c = 11;
                            break;
                        }
                        break;
                    case -1354835072:
                        if (key.equals("interestingSmallUrl")) {
                            c = 16;
                            break;
                        }
                        break;
                    case -1180295454:
                        if (key.equals("isNSRE")) {
                            c = 15;
                            break;
                        }
                        break;
                    case -1122171984:
                        if (key.equals("nextEpisodeTitle")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case -965087962:
                        if (key.equals("abbrSeqLabel")) {
                            c = 14;
                            break;
                        }
                        break;
                    case -903145224:
                        if (key.equals("showId")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -406164797:
                        if (key.equals("nextEpisodeId")) {
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
                            c = 1;
                            break;
                        }
                        break;
                    case 110371416:
                        if (key.equals("title")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 329552226:
                        if (key.equals("errorType")) {
                            c = '\r';
                            break;
                        }
                        break;
                    case 889931614:
                        if (key.equals("seasonId")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1153650071:
                        if (key.equals("boxartUrl")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1485653822:
                        if (key.equals("showRestUrl")) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.id = value.getAsString();
                        break;
                    case 1:
                        this.type = value.getAsString();
                        break;
                    case 2:
                        this.seasonId = value.getAsString();
                        break;
                    case 3:
                        this.showId = value.getAsString();
                        break;
                    case 4:
                        this.showTitle = value.getAsString();
                        break;
                    case 5:
                        this.showRestUrl = value.getAsString();
                        break;
                    case 6:
                        this.title = value.getAsString();
                        break;
                    case 7:
                        this.boxartUrl = value.getAsString();
                        break;
                    case '\b':
                        this.nextEpisodeId = value.getAsString();
                        break;
                    case '\t':
                        this.nextEpisodeTitle = value.getAsString();
                        break;
                    case '\n':
                        this.episodeNumber = value.getAsInt();
                        break;
                    case 11:
                        this.seasonNumber = value.getAsInt();
                        break;
                    case '\f':
                        this.availabilityDateMsg = AK.m3375(value);
                        break;
                    case '\r':
                        this.errorType = VideoType.create(value.getAsString());
                        break;
                    case 14:
                        this.abbrSeqLabel = AK.m3375(value);
                        break;
                    case 15:
                        this.isNSRE = value.getAsBoolean();
                        break;
                    case 16:
                        if (value != null && !value.isJsonNull()) {
                            this.interestingSmallUrl = value.getAsString();
                            break;
                        }
                }
            }
        }

        public String getTitle() {
            return this.title;
        }

        public String getSynopsis() {
            return this.synopsis;
        }

        public String getSoryImgUrl() {
            return this.storyImgUrl;
        }

        public String getHorzDispUrl() {
            return this.horzDispUrl;
        }

        public String getId() {
            return this.id;
        }

        public VideoType getType() {
            if (this.enumType == null) {
                this.enumType = VideoType.create(this.type);
            }
            return this.enumType;
        }

        public String getSeasonId() {
            return this.seasonId;
        }

        public String getShowId() {
            return this.showId;
        }

        public String getShowTitle() {
            return this.showTitle;
        }

        public String getShowRestUrl() {
            return this.showRestUrl;
        }

        public String getInterestingSmallUrl() {
            return this.interestingSmallUrl;
        }

        public int getEpisodeNumber() {
            return this.episodeNumber;
        }

        public int getSeasonNumber() {
            return this.seasonNumber;
        }

        public String getNextEpisodeTitle() {
            return this.nextEpisodeTitle;
        }

        public String getNextEpisodeId() {
            return this.nextEpisodeId;
        }

        public boolean isAutoPlayEnabled() {
            return this.isAutoPlayEnabled;
        }

        public int getAutoPlayMaxCount() {
            return this.autoPlayMaxCount;
        }

        public boolean isNextPlayableEpisode() {
            return this.isNextPlayableEpisode;
        }

        public boolean isPinProtected() {
            return this.isPinProtected;
        }

        public boolean isPreviewProtected() {
            return this.isPreviewProtected;
        }

        public boolean isAgeProtected() {
            return this.isAgeProtected;
        }

        public String getAvailabilityDateMessage() {
            return this.availabilityDateMsg;
        }

        public List<String> getEpisodeBadges() {
            return this.episodeBadges;
        }

        public boolean isNSRE() {
            return this.isNSRE;
        }

        public String getNewBadge() {
            return this.newBadge;
        }

        @Override // com.netflix.model.leafs.Video.Detail
        public String toString() {
            return "Detail [id=" + this.id + ", type=" + this.type + ", seasonId=" + this.seasonId + ", showId=" + this.showId + ", showTitle=" + this.showTitle + ", interestingUrl=" + this.interestingUrl + ", interestingSmallUrl=" + this.interestingSmallUrl + ", showRestUrl=" + this.showRestUrl + ", title=" + this.title + ", boxartUrl=" + this.boxartUrl + ", nextEpisodeId=" + this.nextEpisodeId + ", nextEpisodeTitle=" + this.nextEpisodeTitle + ", availabilityDateMsg=" + this.availabilityDateMsg + ", newBadges=" + this.newBadge + ", episodeNumber=" + this.episodeNumber + ", seasonNumber=" + this.seasonNumber + ", errorType=" + this.errorType + ", enumType=" + this.enumType + "]";
        }
    }
}
