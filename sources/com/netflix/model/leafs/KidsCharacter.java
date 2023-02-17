package com.netflix.model.leafs;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.netflix.model.leafs.Video;
import com.netflix.model.leafs.originals.interactive.CharacterMotion;
import java.util.Map;
import o.AbstractC0847;
import o.AbstractC0852;
import o.C1281;
public final class KidsCharacter {
    private KidsCharacter() {
    }

    public static final class Summary extends Video.Summary {
        private static final String TAG = "KidsCharacter.Summary";
        public String characterImageUrl;
        public CharacterMotion characterMotion;

        @Override // com.netflix.model.leafs.Video.Summary, o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            super.populate(jsonElement);
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case 1843715893:
                        if (key.equals("characterImgUrl")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1960485951:
                        if (key.equals("characterMotion")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.characterImageUrl = value.getAsString();
                        break;
                    case 1:
                        this.characterMotion = (CharacterMotion) ((Gson) C1281.m16832(Gson.class)).fromJson((JsonElement) value.getAsJsonObject(), (Class<Object>) CharacterMotion.class);
                        break;
                }
            }
        }

        @Override // com.netflix.model.leafs.Video.Summary
        public String toString() {
            return "KidsCharacter Summary{characterImageUrl=" + this.characterImageUrl + '}';
        }

        public String getCharacterImageUrl() {
            return this.characterImageUrl;
        }
    }

    public static final class Detail extends AbstractC0847 implements AbstractC0852 {
        private static final String TAG = "KidsCharacter.Detail";
        public boolean hasWatchedRecently;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -2011547908:
                        if (key.equals("hasWatchedRecently")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.hasWatchedRecently = value.getAsBoolean();
                        break;
                }
            }
        }

        public String toString() {
            return "Detail{hasWatchedRecently=" + this.hasWatchedRecently + '}';
        }
    }
}
