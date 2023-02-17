package com.netflix.model.leafs.originals;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.netflix.model.leafs.Delivery;
import com.netflix.model.leafs.Rating;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o.AK;
import o.AbstractC0851;
import o.AbstractC0852;
import o.C1281;
public class BillboardSummary implements AbstractC0851, AbstractC0852 {
    private static final String TAG = "BillboardSummary";
    private String actionToken;
    private List<BillboardCTA> actions;
    private String ancestorId;
    private BillboardAssets assets;
    private BillboardAvailabilityDates availabilityDates;
    private String awardTrackId;
    public List<String> badgeKeys = new ArrayList(3);
    private String billboardTheme;
    private String billboardType;
    private Delivery delivery;
    private String episodes;
    private String hashtag;
    private String id;
    private String imageDescriptor;
    private String impressionToken;
    private boolean isAward;
    private boolean isNSRE;
    private boolean isOriginal;
    private String maturityRating;
    private BillboardPhase phase;
    private Rating rating;
    private String runtime;
    private String seasons;
    private String supplementalMessage;
    private String synopsis;
    public List<ListOfTagSummary> tags;
    private String title;
    private String uiLabel;
    private VideoAssets videoAssets;
    private String year;

    public boolean isOriginal() {
        return this.isOriginal;
    }

    public String getId() {
        return this.id;
    }

    public String getAncestorId() {
        return this.ancestorId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSynopsis() {
        return this.synopsis;
    }

    public String getSupplementalMessage() {
        return this.supplementalMessage;
    }

    public String getImageDescriptor() {
        return this.imageDescriptor;
    }

    public String getYear() {
        return this.year;
    }

    public String getMaturityRating() {
        return this.maturityRating;
    }

    public String getSeasons() {
        return this.seasons;
    }

    public String getEpisodes() {
        return this.episodes;
    }

    public String getRuntime() {
        return this.runtime;
    }

    public boolean isAward() {
        return this.isAward;
    }

    public String getAwardTrackId() {
        return this.awardTrackId;
    }

    public String getBillboardTheme() {
        return this.billboardTheme;
    }

    public String getBillboardType() {
        return this.billboardType;
    }

    public List<String> getBadgeKeys() {
        return this.badgeKeys;
    }

    public List<BillboardCTA> getActions() {
        return this.actions;
    }

    public List<ListOfTagSummary> getTags() {
        return this.tags;
    }

    public Delivery getDelivery() {
        return this.delivery;
    }

    public Rating getRating() {
        return this.rating;
    }

    public String getImpressionToken() {
        return this.impressionToken;
    }

    public String getActionToken() {
        return this.actionToken;
    }

    public BillboardBackground getBackground() {
        if (this.assets == null) {
            return null;
        }
        return this.assets.getBackground();
    }

    public BillboardBackgroundPortrait getBackgroundPortrait() {
        if (this.assets == null) {
            return null;
        }
        return this.assets.getBackgroundPortrait();
    }

    public BillboardLogo getLogo() {
        if (this.assets == null) {
            return null;
        }
        return this.assets.getLogo();
    }

    public BillboardDateBadge getDateBadge() {
        if (this.assets == null) {
            return null;
        }
        return this.assets.getDateBadge();
    }

    public BillboardAwardsHeadline getAwardsHeadline() {
        if (this.assets == null) {
            return null;
        }
        return this.assets.getAwardsHeadline();
    }

    public String getUiLabel() {
        return this.uiLabel;
    }

    public boolean isNSRE() {
        return this.isNSRE;
    }

    public VideoAssets getVideoAssets() {
        return this.videoAssets;
    }

    public BillboardPhase getPhase() {
        return this.phase;
    }

    public BillboardAvailabilityDates getAvailabilityDates() {
        return this.availabilityDates;
    }

    public String getHashtag() {
        return this.hashtag;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -2030197974:
                    if (key.equals("imageDescriptor")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1408207997:
                    if (key.equals("assets")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1180295454:
                    if (key.equals("isNSRE")) {
                        c = 25;
                        break;
                    }
                    break;
                case -1161803523:
                    if (key.equals("actions")) {
                        c = 20;
                        break;
                    }
                    break;
                case -1037500982:
                    if (key.equals("billboardTheme")) {
                        c = 15;
                        break;
                    }
                    break;
                case -938102371:
                    if (key.equals("rating")) {
                        c = 23;
                        break;
                    }
                    break;
                case -457016128:
                    if (key.equals("uiLabel")) {
                        c = 26;
                        break;
                    }
                    break;
                case -404086294:
                    if (key.equals("availabilityDates")) {
                        c = 7;
                        break;
                    }
                    break;
                case -171998439:
                    if (key.equals("billboardType")) {
                        c = 16;
                        break;
                    }
                    break;
                case 3355:
                    if (key.equals("id")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3704893:
                    if (key.equals("year")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 106629499:
                    if (key.equals("phase")) {
                        c = 6;
                        break;
                    }
                    break;
                case 110371416:
                    if (key.equals("title")) {
                        c = 3;
                        break;
                    }
                    break;
                case 417758403:
                    if (key.equals("supplementalMessage")) {
                        c = 5;
                        break;
                    }
                    break;
                case 452553294:
                    if (key.equals("ancestorId")) {
                        c = 1;
                        break;
                    }
                    break;
                case 526707678:
                    if (key.equals("videoAssets")) {
                        c = 27;
                        break;
                    }
                    break;
                case 585773339:
                    if (key.equals("isOriginal")) {
                        c = 2;
                        break;
                    }
                    break;
                case 697547724:
                    if (key.equals("hashtag")) {
                        c = 28;
                        break;
                    }
                    break;
                case 780801392:
                    if (key.equals("impressionToken")) {
                        c = 21;
                        break;
                    }
                    break;
                case 823466996:
                    if (key.equals("delivery")) {
                        c = 19;
                        break;
                    }
                    break;
                case 1362349198:
                    if (key.equals("maturityRating")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1550962648:
                    if (key.equals("runtime")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1573436771:
                    if (key.equals("actionToken")) {
                        c = 22;
                        break;
                    }
                    break;
                case 1828656532:
                    if (key.equals("synopsis")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1853554345:
                    if (key.equals("awardTrackId")) {
                        c = 14;
                        break;
                    }
                    break;
                case 1968370160:
                    if (key.equals("seasons")) {
                        c = 11;
                        break;
                    }
                    break;
                case 2054629203:
                    if (key.equals("isAward")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 2112468023:
                    if (key.equals("badgeKeys")) {
                        c = 17;
                        break;
                    }
                    break;
                case 2130223654:
                    if (key.equals("orderedTags")) {
                        c = 24;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.id = AK.m3375(value);
                    break;
                case 1:
                    this.ancestorId = AK.m3375(value);
                    break;
                case 2:
                    this.isOriginal = AK.m3384(value);
                    break;
                case 3:
                    this.title = AK.m3375(value);
                    break;
                case 4:
                    this.synopsis = AK.m3375(value);
                    break;
                case 5:
                    this.supplementalMessage = AK.m3375(value);
                    break;
                case 6:
                    if (!value.isJsonNull()) {
                        this.phase = (BillboardPhase) ((Gson) C1281.m16832(Gson.class)).fromJson((JsonElement) value.getAsJsonObject(), (Class<Object>) BillboardPhase.class);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (!value.isJsonNull()) {
                        this.availabilityDates = (BillboardAvailabilityDates) ((Gson) C1281.m16832(Gson.class)).fromJson((JsonElement) value.getAsJsonObject(), (Class<Object>) BillboardAvailabilityDates.class);
                        break;
                    } else {
                        break;
                    }
                case '\b':
                    this.imageDescriptor = AK.m3375(value);
                    break;
                case '\t':
                    this.year = AK.m3375(value);
                    break;
                case '\n':
                    this.maturityRating = AK.m3375(value);
                    break;
                case 11:
                    this.seasons = AK.m3375(value);
                    break;
                case '\f':
                    this.runtime = AK.m3375(value);
                    break;
                case '\r':
                    this.isAward = AK.m3384(value);
                    break;
                case 14:
                    this.awardTrackId = AK.m3375(value);
                    break;
                case 15:
                    this.billboardTheme = AK.m3375(value);
                    break;
                case 16:
                    this.billboardType = AK.m3375(value);
                    break;
                case 17:
                    if (!value.isJsonNull()) {
                        JsonArray asJsonArray = value.getAsJsonArray();
                        for (int i = 0; i < asJsonArray.size(); i++) {
                            this.badgeKeys.add(asJsonArray.get(i).getAsString());
                        }
                        break;
                    } else {
                        break;
                    }
                case 18:
                    this.assets = new BillboardAssets(value);
                    break;
                case 19:
                    this.delivery = new Delivery(value);
                    break;
                case 20:
                    this.actions = BillboardCTA.getListOfActions(value);
                    break;
                case 21:
                    this.impressionToken = AK.m3375(value);
                    break;
                case 22:
                    this.actionToken = AK.m3375(value);
                    break;
                case 23:
                    this.rating = new Rating(value);
                    break;
                case 24:
                    this.tags = ListOfTagSummary.getListOfTags(value);
                    break;
                case 25:
                    this.isNSRE = AK.m3384(value);
                    break;
                case 26:
                    this.uiLabel = AK.m3375(value);
                    break;
                case 27:
                    if (!value.isJsonNull()) {
                        this.videoAssets = (VideoAssets) ((Gson) C1281.m16832(Gson.class)).fromJson((JsonElement) value.getAsJsonObject(), (Class<Object>) VideoAssets.class);
                        break;
                    } else {
                        break;
                    }
                case 28:
                    this.hashtag = AK.m3375(value);
                    break;
            }
        }
    }
}
