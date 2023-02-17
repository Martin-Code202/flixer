package com.netflix.model.leafs;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.netflix.model.leafs.PostPlayAsset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o.AbstractC0730;
import o.AbstractC0851;
import o.AbstractC0852;
import o.AbstractC0929;
public class PostPlayExperience implements AbstractC0852, AbstractC0851 {
    private static final String TAG = "PostPlayExperience";
    private final List<PostPlayAction> actions;
    private Integer actionsInitialIndex;
    private boolean autoplay;
    private int autoplaySeconds;
    private PostPlayAsset backgroundAsset;
    private final List<PostPlayAction> experienceTitle;
    private String impressionToken;
    private final List<PostPlayItem> items;
    private Integer itemsInitialIndex;
    private PostPlayAsset logoAsset;
    private String promotedSupplementalMessage;
    private String promotedTitle;
    private Integer promotedVideoId;
    AbstractC0929<? extends AbstractC0730> proxy;
    private String requestId;
    private int seamlessCountdownSeconds;
    private int seamlessEnd;
    private String theme;
    private String type;

    public PostPlayExperience() {
        this(null);
    }

    public PostPlayExperience(AbstractC0929<? extends AbstractC0730> r3) {
        this.experienceTitle = new ArrayList(1);
        this.actions = new ArrayList(5);
        this.items = new ArrayList(5);
        this.proxy = r3;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            if (!(value instanceof JsonNull)) {
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1408207997:
                        if (key.equals("assets")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -1161803523:
                        if (key.equals("actions")) {
                            c = 11;
                            break;
                        }
                        break;
                    case -3512370:
                        if (key.equals("itemsInitialIndex")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case 3575610:
                        if (key.equals("type")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 49423260:
                        if (key.equals("autoplaySeconds")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 100526016:
                        if (key.equals("items")) {
                            c = '\r';
                            break;
                        }
                        break;
                    case 110327241:
                        if (key.equals("theme")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 473683339:
                        if (key.equals("actionsInitialIndex")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 693933066:
                        if (key.equals("requestId")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 780801392:
                        if (key.equals("impressionToken")) {
                            c = 15;
                            break;
                        }
                        break;
                    case 1121767444:
                        if (key.equals("promotedTitle")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1439562083:
                        if (key.equals("autoplay")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1668395075:
                        if (key.equals("currentEpisodeSeamlessData")) {
                            c = 14;
                            break;
                        }
                        break;
                    case 1741756850:
                        if (key.equals("promotedVideoId")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 2065592703:
                        if (key.equals("promotedSupplementalMessage")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 2111580942:
                        if (key.equals("experienceTitle")) {
                            c = '\t';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.requestId = value.getAsString();
                        continue;
                    case 1:
                        this.type = value.getAsString();
                        continue;
                    case 2:
                        this.theme = value.getAsString();
                        continue;
                    case 3:
                        this.autoplay = value.getAsBoolean();
                        continue;
                    case 4:
                        this.autoplaySeconds = value.getAsInt();
                        continue;
                    case 5:
                        this.promotedVideoId = Integer.valueOf(value.getAsInt());
                        continue;
                    case 6:
                        this.promotedTitle = value.getAsString();
                        continue;
                    case 7:
                        this.promotedSupplementalMessage = value.getAsString();
                        continue;
                    case '\b':
                        if (!value.isJsonNull()) {
                            for (Map.Entry<String, JsonElement> entry2 : value.getAsJsonObject().entrySet()) {
                                String key2 = entry2.getKey();
                                char c2 = 65535;
                                switch (key2.hashCode()) {
                                    case -1332194002:
                                        if (key2.equals("background")) {
                                            c2 = 0;
                                            break;
                                        }
                                        break;
                                    case 3327403:
                                        if (key2.equals("logo")) {
                                            c2 = 1;
                                            break;
                                        }
                                        break;
                                }
                                switch (c2) {
                                    case 0:
                                        this.backgroundAsset = new PostPlayAsset(PostPlayAsset.Type.BACKGROUND, entry2.getValue());
                                        break;
                                    case 1:
                                        this.logoAsset = new PostPlayAsset(PostPlayAsset.Type.LOGO, entry2.getValue());
                                        break;
                                }
                            }
                            break;
                        } else {
                            continue;
                        }
                    case '\t':
                        populateCTA(value, this.experienceTitle);
                        continue;
                    case '\n':
                        this.actionsInitialIndex = Integer.valueOf(value.getAsInt());
                        continue;
                    case 11:
                        populateCTA(value, this.actions);
                        continue;
                    case '\f':
                        this.itemsInitialIndex = Integer.valueOf(value.getAsInt());
                        continue;
                    case '\r':
                        if (!value.isJsonNull()) {
                            this.items.clear();
                            JsonArray asJsonArray = value.getAsJsonArray();
                            for (int i = 0; i < asJsonArray.size(); i++) {
                                this.items.add(new PostPlayItem(asJsonArray.get(i), this.proxy));
                            }
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        if (value.getAsJsonObject().has("seamlessEnd")) {
                            this.seamlessEnd = value.getAsJsonObject().get("seamlessEnd").getAsInt();
                        }
                        if (value.getAsJsonObject().has("seamlessCountdownSeconds")) {
                            this.seamlessCountdownSeconds = value.getAsJsonObject().get("seamlessCountdownSeconds").getAsInt();
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        this.impressionToken = value.getAsString();
                        continue;
                }
            }
        }
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

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String str) {
        this.theme = str;
    }

    public boolean getAutoplay() {
        return this.autoplay;
    }

    public void setAutoplay(boolean z) {
        this.autoplay = z;
    }

    public int getAutoplaySeconds() {
        return this.autoplaySeconds;
    }

    public void setAutoplaySeconds(int i) {
        this.autoplaySeconds = i;
    }

    public Integer getPromotedVideoId() {
        return this.promotedVideoId;
    }

    public void setPromotedVideoId(Integer num) {
        this.promotedVideoId = num;
    }

    public String getPromotedTitle() {
        return this.promotedTitle;
    }

    public void setPromotedTitle(String str) {
        this.promotedTitle = str;
    }

    public String getPromotedSupplementalMessage() {
        return this.promotedSupplementalMessage;
    }

    public void setPromotedSupplementalMessage(String str) {
        this.promotedSupplementalMessage = str;
    }

    public PostPlayAsset getBackgroundAsset() {
        return this.backgroundAsset;
    }

    public void setBackgroundAsset(PostPlayAsset postPlayAsset) {
        this.backgroundAsset = postPlayAsset;
    }

    public PostPlayAsset getLogoAsset() {
        return this.logoAsset;
    }

    public void setLogoAsset(PostPlayAsset postPlayAsset) {
        this.logoAsset = postPlayAsset;
    }

    public List<PostPlayAction> getExperienceTitle() {
        return this.experienceTitle;
    }

    public Integer getActionsInitialIndex() {
        return this.actionsInitialIndex;
    }

    public void setActionsInitialIndex(Integer num) {
        this.actionsInitialIndex = num;
    }

    public List<PostPlayAction> getActions() {
        return this.actions;
    }

    public Integer getItemsInitialIndex() {
        return this.itemsInitialIndex;
    }

    public void setItemsInitialIndex(Integer num) {
        this.itemsInitialIndex = num;
    }

    public List<PostPlayItem> getItems() {
        return this.items;
    }

    public int getSeamlessCountdownSeconds() {
        return this.seamlessCountdownSeconds;
    }

    public void setSeamlessCountdownSeconds(int i) {
        this.seamlessCountdownSeconds = i;
    }

    public int getSeamlessEnd() {
        return this.seamlessEnd;
    }

    public void setSeamlessEnd(int i) {
        this.seamlessEnd = i;
    }

    public String getImpressionToken() {
        return this.impressionToken;
    }

    public void setImpressionToken(String str) {
        this.impressionToken = str;
    }
}
