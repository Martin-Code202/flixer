package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.AbstractC0730;
import o.AbstractC0852;
import o.AbstractC0929;
import o.AbstractC2087qh;
import o.C0859;
import o.pN;
public class PostPlayAction implements AbstractC0852, AbstractC2087qh {
    private static final String TAG = "PostPlayAction";
    private final Map<String, Integer> additionalTrackIds;
    private String ancestorTitle;
    private int bookmarkPosition;
    private String displayText;
    private boolean doNotIncrementInterrupter;
    private int episode;
    private boolean forceInterrupt;
    private boolean inMyList;
    private String interruptDisplayText;
    private int interruptThreshold;
    private int itemIndex;
    private long logicalStart;
    private long minutesRemaining;
    private String name;
    private AbstractC0929<? extends AbstractC0730> proxy;
    private String requestId;
    private int seamlessStart;
    private int season;
    private String seasonSequenceAbbr;
    private String seasonSequenceLong;
    private int trackId;
    private CallToActionType type;
    private int videoId;
    private VideoType videoType;

    public enum CallToActionType {
        play,
        mdp,
        playlist,
        videoMerch
    }

    public PostPlayAction() {
        this(null, null);
    }

    public PostPlayAction(JsonElement jsonElement) {
        this(jsonElement, null);
    }

    public PostPlayAction(JsonElement jsonElement, AbstractC0929<? extends AbstractC0730> r3) {
        this.additionalTrackIds = new HashMap();
        this.inMyList = false;
        this.doNotIncrementInterrupter = false;
        this.seamlessStart = -1;
        this.proxy = r3;
        if (jsonElement != null) {
            populate(jsonElement);
        }
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            if (!(value instanceof JsonNull)) {
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1829827457:
                        if (key.equals("bookmarkPosition")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -1775808852:
                        if (key.equals("interruptDisplayText")) {
                            c = 14;
                            break;
                        }
                        break;
                    case -1739932713:
                        if (key.equals("minutesRemaining")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case -1681835499:
                        if (key.equals("seasonSequenceAbbr")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -1681494944:
                        if (key.equals("seasonSequenceLong")) {
                            c = 6;
                            break;
                        }
                        break;
                    case -1544438277:
                        if (key.equals(PostPlayItem.POST_PLAY_ITEM_EPISODE)) {
                            c = 7;
                            break;
                        }
                        break;
                    case -1324983797:
                        if (key.equals("seamlessStart")) {
                            c = 19;
                            break;
                        }
                        break;
                    case -1067396154:
                        if (key.equals("trackId")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -906335517:
                        if (key.equals("season")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -602057255:
                        if (key.equals("logicalStart")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case -563483980:
                        if (key.equals("additionalTrackIds")) {
                            c = 15;
                            break;
                        }
                        break;
                    case -528792081:
                        if (key.equals("inMyList")) {
                            c = 16;
                            break;
                        }
                        break;
                    case 3373707:
                        if (key.equals("name")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3575610:
                        if (key.equals("type")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 452782838:
                        if (key.equals("videoId")) {
                            c = 18;
                            break;
                        }
                        break;
                    case 771110345:
                        if (key.equals("doNotIncrementInterrupter")) {
                            c = 17;
                            break;
                        }
                        break;
                    case 846419272:
                        if (key.equals("interruptThreshold")) {
                            c = '\r';
                            break;
                        }
                        break;
                    case 1332961877:
                        if (key.equals("videoType")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 1629608888:
                        if (key.equals("forceInterrupt")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case 1714331919:
                        if (key.equals("displayText")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.displayText = value.getAsString();
                        continue;
                    case 1:
                        this.name = value.getAsString();
                        continue;
                    case 2:
                        this.type = CallToActionType.valueOf(value.getAsString());
                        continue;
                    case 3:
                        this.trackId = value.getAsInt();
                        continue;
                    case 4:
                        this.season = value.getAsInt();
                        continue;
                    case 5:
                        this.seasonSequenceAbbr = value.getAsString();
                        continue;
                    case 6:
                        this.seasonSequenceLong = value.getAsString();
                        continue;
                    case 7:
                        this.episode = value.getAsInt();
                        continue;
                    case '\b':
                        this.bookmarkPosition = value.getAsInt();
                        continue;
                    case '\t':
                        this.minutesRemaining = (long) value.getAsInt();
                        continue;
                    case '\n':
                        this.logicalStart = (long) value.getAsInt();
                        continue;
                    case 11:
                        this.videoType = VideoType.create(value.getAsString());
                        continue;
                    case '\f':
                        this.forceInterrupt = value.getAsBoolean();
                        continue;
                    case '\r':
                        this.interruptThreshold = value.getAsInt();
                        continue;
                    case 14:
                        this.interruptDisplayText = value.getAsString();
                        continue;
                    case 15:
                        if (!value.isJsonNull()) {
                            for (Map.Entry<String, JsonElement> entry2 : value.getAsJsonObject().entrySet()) {
                                this.additionalTrackIds.put(entry2.getKey(), Integer.valueOf(entry2.getValue().getAsInt()));
                            }
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        this.inMyList = value.getAsBoolean();
                        continue;
                    case 17:
                        this.doNotIncrementInterrupter = value.getAsBoolean();
                        continue;
                    case 18:
                        this.videoId = value.getAsInt();
                        continue;
                    case 19:
                        this.seamlessStart = value.getAsInt();
                        continue;
                }
            }
        }
    }

    public pN getPlayBackVideo() {
        List<I> r4 = this.proxy.mo15259(C0859.m15528("videos", Integer.valueOf(this.videoId), "summary"));
        if (r4.size() <= 0) {
            return null;
        }
        I i = r4.get(0);
        if (i instanceof pN) {
            return (pN) i;
        }
        return null;
    }

    public String getDisplayText() {
        return this.displayText;
    }

    public void setDisplayText(String str) {
        this.displayText = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public CallToActionType getType() {
        return this.type;
    }

    public void setType(CallToActionType callToActionType) {
        this.type = callToActionType;
    }

    @Override // o.AbstractC2087qh
    public int getTrackId() {
        return this.trackId;
    }

    public void setTrackId(int i) {
        this.trackId = i;
    }

    public int getSeason() {
        return this.season;
    }

    public void setSeason(int i) {
        this.season = i;
    }

    public int getBookmarkPosition() {
        return this.bookmarkPosition;
    }

    public void setBookmarkPosition(int i) {
        this.bookmarkPosition = i;
    }

    public long getMinutesRemaining() {
        return this.minutesRemaining;
    }

    public void setMinutesRemaining(long j) {
        this.minutesRemaining = j;
    }

    public long getLogicalStart() {
        return this.logicalStart;
    }

    public void setLogicalStart(long j) {
        this.logicalStart = j;
    }

    public VideoType getVideoType() {
        return this.videoType;
    }

    public void setVideoType(VideoType videoType2) {
        this.videoType = videoType2;
    }

    public boolean isForceInterrupt() {
        return this.forceInterrupt;
    }

    public void setForceInterrupt(boolean z) {
        this.forceInterrupt = z;
    }

    public int getInterruptThreshold() {
        return this.interruptThreshold;
    }

    public void setInterruptThreshold(int i) {
        this.interruptThreshold = i;
    }

    public String getInterruptDisplayText() {
        return this.interruptDisplayText;
    }

    public void setInterruptDisplayText(String str) {
        this.interruptDisplayText = str;
    }

    public Map<String, Integer> getAdditionalTrackIds() {
        return this.additionalTrackIds;
    }

    public boolean isInMyList() {
        return this.inMyList;
    }

    public void setInMyList(boolean z) {
        this.inMyList = z;
    }

    public boolean isDoNotIncrementInterrupter() {
        return this.doNotIncrementInterrupter;
    }

    public void setDoNotIncrementInterrupter(boolean z) {
        this.doNotIncrementInterrupter = z;
    }

    public int getVideoId() {
        return this.videoId;
    }

    public void setVideoId(int i) {
        this.videoId = i;
    }

    public int getItemIndex() {
        return this.itemIndex;
    }

    public void setItemIndex(int i) {
        this.itemIndex = i;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    @Override // o.AbstractC2087qh
    public int getListPos() {
        return this.itemIndex;
    }

    @Override // o.AbstractC2087qh
    public String getRequestId() {
        return this.requestId;
    }

    @Override // o.AbstractC2087qh
    public String getImpressionToken() {
        return null;
    }

    @Override // o.AbstractC2087qh
    public int getHeroTrackId() {
        return 0;
    }

    @Override // o.AbstractC2087qh
    public boolean isHero() {
        return false;
    }

    public String getAncestorTitle() {
        return this.ancestorTitle;
    }

    public void setAncestorTitle(String str) {
        this.ancestorTitle = str;
    }

    public String getSeasonSequenceAbbr() {
        return this.seasonSequenceAbbr;
    }

    public void setSeasonSequenceAbbr(String str) {
        this.seasonSequenceAbbr = str;
    }

    public String getSeasonSequenceLong() {
        return this.seasonSequenceLong;
    }

    public void setSeasonSequenceLong(String str) {
        this.seasonSequenceLong = str;
    }

    public int getEpisode() {
        return this.episode;
    }

    public void setEpisode(int i) {
        this.episode = i;
    }

    public int getSeamlessStart() {
        return this.seamlessStart;
    }

    public void setSeamlessStart(int i) {
        this.seamlessStart = i;
    }
}
