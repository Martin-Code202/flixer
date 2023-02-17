package com.netflix.model.leafs;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.netflix.model.leafs.PostPlayAction;
import com.netflix.model.leafs.PostPlayAsset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.AbstractC0730;
import o.AbstractC0852;
import o.AbstractC0929;
import o.C1131;
import o.pB;
public class PostPlayItem implements AbstractC0852, pB {
    public static final String POST_PLAY_ITEM_EPISODE = "episode";
    private static final String TAG = "PostPlayItem";
    private final List<PostPlayAction> actions;
    private String ancestorSynopsis;
    private String ancestorTitle;
    private boolean autoPlay;
    private int autoPlaySeconds;
    private String availabilityDateMessaging;
    private PostPlayAsset backgroundAsset;
    private List<String> badgeKeys;
    private Map<String, String> delivery;
    private PostPlayAsset displayArtAsset;
    private boolean episodeNumberHidden;
    private int episodes;
    private String experienceType;
    private String impressionData;
    private boolean isNSRE;
    private PostPlayAsset logoAsset;
    private int matchPercentage;
    private String maturityRating;
    private boolean newForPvr;
    private boolean nextEpisodeAutoPlay;
    private boolean nextEpisodeSeamless;
    AbstractC0929<? extends AbstractC0730> proxy;
    private int runtime;
    private int seamlessStart;
    private String seasonSequenceAbbr;
    private int seasons;
    private String seasonsLabel;
    private String supplementalMessage;
    private String synopsis;
    private String title;
    private String type;
    private int userThumbRating;
    private Integer videoId;
    private Integer year;

    public PostPlayItem() {
        this(null, null);
    }

    public PostPlayItem(JsonElement jsonElement) {
        this(jsonElement, null);
    }

    public PostPlayItem(JsonElement jsonElement, AbstractC0929<? extends AbstractC0730> r4) {
        this.delivery = new HashMap();
        this.actions = new ArrayList(5);
        this.isNSRE = false;
        this.badgeKeys = new ArrayList(2);
        this.proxy = r4;
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
                    case -1681835499:
                        if (key.equals("seasonSequenceAbbr")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case -1408207997:
                        if (key.equals("assets")) {
                            c = 21;
                            break;
                        }
                        break;
                    case -1180295454:
                        if (key.equals("isNSRE")) {
                            c = 17;
                            break;
                        }
                        break;
                    case -1161803523:
                        if (key.equals("actions")) {
                            c = 16;
                            break;
                        }
                        break;
                    case -938102371:
                        if (key.equals("rating")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -694386553:
                        if (key.equals("ancestorSynopsis")) {
                            c = 6;
                            break;
                        }
                        break;
                    case -632946216:
                        if (key.equals("episodes")) {
                            c = '\r';
                            break;
                        }
                        break;
                    case -339520796:
                        if (key.equals("seasonsLabel")) {
                            c = 11;
                            break;
                        }
                        break;
                    case -113850029:
                        if (key.equals("impressionData")) {
                            c = 22;
                            break;
                        }
                        break;
                    case 3575610:
                        if (key.equals("type")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3704893:
                        if (key.equals("year")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 110371416:
                        if (key.equals("title")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 123262021:
                        if (key.equals("ancestorTitle")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 417758403:
                        if (key.equals("supplementalMessage")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 452782838:
                        if (key.equals("videoId")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 823466996:
                        if (key.equals("delivery")) {
                            c = 15;
                            break;
                        }
                        break;
                    case 1034293595:
                        if (key.equals("availabilityDateMessaging")) {
                            c = 19;
                            break;
                        }
                        break;
                    case 1362349198:
                        if (key.equals("maturityRating")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case 1550962648:
                        if (key.equals("runtime")) {
                            c = 14;
                            break;
                        }
                        break;
                    case 1575288857:
                        if (key.equals("hiddenEpisodeNumbers")) {
                            c = 18;
                            break;
                        }
                        break;
                    case 1828656532:
                        if (key.equals("synopsis")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1968370160:
                        if (key.equals("seasons")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case 2112468023:
                        if (key.equals("badgeKeys")) {
                            c = 20;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.videoId = Integer.valueOf(value.getAsInt());
                        continue;
                    case 1:
                        this.type = value.getAsString();
                        continue;
                    case 2:
                        this.title = value.getAsString();
                        continue;
                    case 3:
                        this.ancestorTitle = value.getAsString();
                        continue;
                    case 4:
                        this.supplementalMessage = value.getAsString();
                        continue;
                    case 5:
                        this.synopsis = value.getAsString();
                        continue;
                    case 6:
                        this.ancestorSynopsis = value.getAsString();
                        continue;
                    case 7:
                        this.year = Integer.valueOf(value.getAsInt());
                        continue;
                    case '\b':
                        populateThumbsRating(value);
                        continue;
                    case '\t':
                        this.maturityRating = value.getAsString();
                        continue;
                    case '\n':
                        this.seasonSequenceAbbr = value.getAsString();
                        continue;
                    case 11:
                        this.seasonsLabel = value.getAsString();
                        continue;
                    case '\f':
                        this.seasons = value.getAsInt();
                        continue;
                    case '\r':
                        this.episodes = value.getAsInt();
                        continue;
                    case 14:
                        this.runtime = value.getAsInt();
                        continue;
                    case 15:
                        populateMap(value, this.delivery);
                        continue;
                    case 16:
                        populateCTA(value, this.actions);
                        continue;
                    case 17:
                        this.isNSRE = value.getAsBoolean();
                        continue;
                    case 18:
                        this.episodeNumberHidden = value.getAsBoolean();
                        continue;
                    case 19:
                        this.availabilityDateMessaging = value.getAsString();
                        continue;
                    case 20:
                        if (!value.isJsonNull()) {
                            this.badgeKeys.clear();
                            JsonArray asJsonArray = value.getAsJsonArray();
                            for (int i = 0; i < asJsonArray.size(); i++) {
                                this.badgeKeys.add(asJsonArray.get(i).getAsString());
                            }
                            break;
                        } else {
                            continue;
                        }
                    case 21:
                        for (Map.Entry<String, JsonElement> entry2 : value.getAsJsonObject().entrySet()) {
                            String key2 = entry2.getKey();
                            char c2 = 65535;
                            switch (key2.hashCode()) {
                                case -847101650:
                                    if (key2.equals("BACKGROUND")) {
                                        c2 = 0;
                                        break;
                                    }
                                    break;
                                case -426397402:
                                    if (key2.equals("DISPLAY_ART")) {
                                        c2 = 1;
                                        break;
                                    }
                                    break;
                                case 2342315:
                                    if (key2.equals("LOGO")) {
                                        c2 = 2;
                                        break;
                                    }
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    this.backgroundAsset = new PostPlayAsset(PostPlayAsset.Type.BACKGROUND, entry2.getValue());
                                    break;
                                case 1:
                                    this.displayArtAsset = new PostPlayAsset(PostPlayAsset.Type.DISPLAY_ART, entry2.getValue());
                                    break;
                                case 2:
                                    this.logoAsset = new PostPlayAsset(PostPlayAsset.Type.LOGO, entry2.getValue());
                                    break;
                            }
                        }
                        continue;
                    case 22:
                        this.impressionData = value.getAsString();
                        continue;
                }
            }
        }
    }

    private void populateThumbsRating(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (!asJsonObject.has("matchPercentage") || asJsonObject.get("matchPercentage").isJsonNull()) {
            this.matchPercentage = 0;
        } else {
            this.matchPercentage = asJsonObject.get("matchPercentage").getAsInt();
        }
        if (!asJsonObject.has("userThumbsRating") || asJsonObject.get("userThumbsRating").isJsonNull()) {
            this.userThumbRating = 0;
        } else {
            this.userThumbRating = C1131.m16287(asJsonObject.get("userThumbsRating").getAsString());
        }
        JsonElement jsonElement2 = asJsonObject.get("newForPVR");
        this.newForPvr = jsonElement2 != null && !jsonElement2.isJsonNull() && jsonElement2.getAsBoolean();
    }

    private void populateCTA(JsonElement jsonElement, List<PostPlayAction> list) {
        if (!jsonElement.isJsonNull()) {
            list.clear();
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            for (int i = 0; i < asJsonArray.size(); i++) {
                list.add(new PostPlayAction(asJsonArray.get(i), this.proxy));
            }
        }
    }

    private void populateMap(JsonElement jsonElement, Map<String, String> map) {
        if (!jsonElement.isJsonNull()) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                map.put(entry.getKey(), entry.getValue().getAsString());
            }
        }
    }

    private void populateFloatMap(JsonElement jsonElement, Map<String, Float> map) {
        if (!jsonElement.isJsonNull()) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                if (!entry.getValue().isJsonNull()) {
                    map.put(entry.getKey(), Float.valueOf(entry.getValue().getAsFloat()));
                }
            }
        }
    }

    public Integer getVideoId() {
        return this.videoId;
    }

    public void setVideoId(Integer num) {
        this.videoId = num;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getAncestorTitle() {
        return this.ancestorTitle;
    }

    public void setAncestorTitle(String str) {
        this.ancestorTitle = str;
    }

    public String getSupplementalMessage() {
        return this.supplementalMessage;
    }

    public void setSupplementalMessage(String str) {
        this.supplementalMessage = str;
    }

    public String getSynopsis() {
        return this.synopsis;
    }

    public void setSynopsis(String str) {
        this.synopsis = str;
    }

    public String getAncestorSynopsis() {
        return this.ancestorSynopsis;
    }

    public void setAncestorSynopsis(String str) {
        this.ancestorSynopsis = str;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer num) {
        this.year = num;
    }

    public String getMaturityRating() {
        return this.maturityRating;
    }

    public void setMaturityRating(String str) {
        this.maturityRating = str;
    }

    public String getSeasonSequenceAbbr() {
        return this.seasonSequenceAbbr;
    }

    public void setSeasonSequenceAbbr(String str) {
        this.seasonSequenceAbbr = str;
    }

    public String getSeasonsLabel() {
        return this.seasonsLabel;
    }

    public void setSeasonsLabel(String str) {
        this.seasonsLabel = str;
    }

    public int getSeasons() {
        return this.seasons;
    }

    public void setSeasons(int i) {
        this.seasons = i;
    }

    public int getEpisodes() {
        return this.episodes;
    }

    public void setEpisodes(int i) {
        this.episodes = i;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public void setRuntime(int i) {
        this.runtime = i;
    }

    public Map<String, String> getDelivery() {
        return this.delivery;
    }

    public void setDelivery(Map<String, String> map) {
        this.delivery = map;
    }

    public PostPlayAction getPlayAction() {
        for (int i = 0; i < this.actions.size(); i++) {
            PostPlayAction postPlayAction = this.actions.get(i);
            if (postPlayAction != null && PostPlayAction.CallToActionType.play.equals(postPlayAction.getType())) {
                return postPlayAction;
            }
        }
        return null;
    }

    public PostPlayAction getMoreInfoAction() {
        for (int i = 0; i < this.actions.size(); i++) {
            PostPlayAction postPlayAction = this.actions.get(i);
            if (postPlayAction != null && postPlayAction.getType().equals(PostPlayAction.CallToActionType.mdp)) {
                return postPlayAction;
            }
        }
        return null;
    }

    public List<PostPlayAction> getActions() {
        return this.actions;
    }

    public PostPlayAsset getBackgroundAsset() {
        return this.backgroundAsset;
    }

    public void setBackgroundAsset(PostPlayAsset postPlayAsset) {
        this.backgroundAsset = postPlayAsset;
    }

    public PostPlayAsset getDisplayArtAsset() {
        return this.displayArtAsset;
    }

    public void setDisplayArtAsset(PostPlayAsset postPlayAsset) {
        this.displayArtAsset = postPlayAsset;
    }

    public PostPlayAsset getLogoAsset() {
        return this.logoAsset;
    }

    public void setLogoAsset(PostPlayAsset postPlayAsset) {
        this.logoAsset = postPlayAsset;
    }

    @Override // o.pB
    public int getMatchPercentage() {
        return this.matchPercentage;
    }

    @Override // o.pB
    public int getUserThumbRating() {
        return this.userThumbRating;
    }

    public void setUserThumbRating(int i) {
    }

    @Override // o.pB
    public boolean isNewForPvr() {
        return this.newForPvr;
    }

    public boolean isNSRE() {
        return this.isNSRE;
    }

    public boolean isEpisodeNumberHidden() {
        return this.episodeNumberHidden;
    }

    public void setNSRE(boolean z) {
        this.isNSRE = z;
    }

    public String getAvailabilityDateMessaging() {
        return this.availabilityDateMessaging;
    }

    public void setAvailabilityDateMessaging(String str) {
        this.availabilityDateMessaging = str;
    }

    public String getImpressionData() {
        return this.impressionData;
    }

    public void setImpressionData(String str) {
        this.impressionData = str;
    }

    public List<String> getBadgeKeys() {
        return this.badgeKeys;
    }

    public boolean hasNewBadge() {
        return this.badgeKeys.contains("NEW");
    }

    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    public int getAutoPlaySeconds() {
        return this.autoPlaySeconds;
    }

    public void setAutoPlaySeconds(int i) {
        this.autoPlaySeconds = i;
    }

    public boolean isNextEpisodeAutoPlay() {
        return this.nextEpisodeAutoPlay;
    }

    public void setNextEpisodeAutoPlay(boolean z) {
        this.nextEpisodeAutoPlay = z;
    }

    public String getExperienceType() {
        return this.experienceType;
    }

    public void setExperienceType(String str) {
        this.experienceType = str;
    }

    public boolean isNextEpisodeSeamless() {
        return this.nextEpisodeSeamless;
    }

    public void setNextEpisodeSeamless(boolean z) {
        this.nextEpisodeSeamless = z;
    }

    public void setSeamlessStart(int i) {
        this.seamlessStart = i;
    }

    public int getSeamlessStart() {
        return this.seamlessStart;
    }
}
