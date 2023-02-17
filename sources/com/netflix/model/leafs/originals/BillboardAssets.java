package com.netflix.model.leafs.originals;

import com.google.gson.JsonElement;
import java.util.Map;
import o.AbstractC0852;
public class BillboardAssets implements AbstractC0852 {
    private static final String TAG = "Assets";
    private BillboardAwardsHeadline awardsHeadline;
    private BillboardBackground background;
    private BillboardBackgroundPortrait backgroundPortrait;
    private BillboardDateBadge dateBadge;
    private BillboardLogo logo;

    public BillboardAssets(JsonElement jsonElement) {
        populate(jsonElement);
    }

    public BillboardBackground getBackground() {
        return this.background;
    }

    public BillboardBackgroundPortrait getBackgroundPortrait() {
        return this.backgroundPortrait;
    }

    public BillboardLogo getLogo() {
        return this.logo;
    }

    public BillboardDateBadge getDateBadge() {
        return this.dateBadge;
    }

    public BillboardAwardsHeadline getAwardsHeadline() {
        return this.awardsHeadline;
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            JsonElement value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            switch (key.hashCode()) {
                case -1332194002:
                    if (key.equals("background")) {
                        c = 1;
                        break;
                    }
                    break;
                case -276211563:
                    if (key.equals("dateBadge")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3327403:
                    if (key.equals("logo")) {
                        c = 0;
                        break;
                    }
                    break;
                case 621897449:
                    if (key.equals("backgroundPortrait")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1961536938:
                    if (key.equals("awardsHeadline")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.logo = new BillboardLogo(value);
                    break;
                case 1:
                    this.background = new BillboardBackground(value);
                    break;
                case 2:
                    this.backgroundPortrait = new BillboardBackgroundPortrait(value);
                    break;
                case 3:
                    this.dateBadge = new BillboardDateBadge(value);
                    break;
                case 4:
                    this.awardsHeadline = new BillboardAwardsHeadline(value);
                    break;
            }
        }
    }
}
