package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import com.netflix.model.leafs.Video;
import java.util.Map;
public final class Season {
    private Season() {
    }

    public static final class Detail extends Video.Summary {
        private static final String TAG = "Season.Detail";
        public int episodeCount;
        public int number;
        public String showId;
        public int year;

        @Override // com.netflix.model.leafs.Video.Summary, o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            super.populate(jsonElement);
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1034364087:
                        if (key.equals("number")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -903145224:
                        if (key.equals("showId")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 3704893:
                        if (key.equals("year")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1590765524:
                        if (key.equals("episodeCount")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.number = value.getAsInt();
                        break;
                    case 1:
                        this.episodeCount = value.getAsInt();
                        break;
                    case 2:
                        this.year = value.getAsInt();
                        break;
                    case 3:
                        this.showId = value.getAsString();
                        break;
                }
            }
        }
    }
}
