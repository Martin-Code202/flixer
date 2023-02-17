package com.netflix.model.leafs.originals.interactive;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
/* access modifiers changed from: package-private */
public final class AutoValue_InteractiveFeatures extends C$AutoValue_InteractiveFeatures {
    AutoValue_InteractiveFeatures(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        super(z, z2, z3, z4, z5, z6, z7, z8);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<InteractiveFeatures> {
        private final TypeAdapter<Boolean> customBookmarkAdapter;
        private boolean defaultCustomBookmark = false;
        private boolean defaultFallbackTutorial = false;
        private boolean defaultHideDetailedDurations = false;
        private boolean defaultInteractiveTrailer = false;
        private boolean defaultIpp = false;
        private boolean defaultPlaybackGraph = false;
        private boolean defaultPlaybackNotifications = false;
        private boolean defaultPrePlay = false;
        private final TypeAdapter<Boolean> fallbackTutorialAdapter;
        private final TypeAdapter<Boolean> hideDetailedDurationsAdapter;
        private final TypeAdapter<Boolean> interactiveTrailerAdapter;
        private final TypeAdapter<Boolean> ippAdapter;
        private final TypeAdapter<Boolean> playbackGraphAdapter;
        private final TypeAdapter<Boolean> playbackNotificationsAdapter;
        private final TypeAdapter<Boolean> prePlayAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.playbackGraphAdapter = gson.getAdapter(Boolean.class);
            this.playbackNotificationsAdapter = gson.getAdapter(Boolean.class);
            this.ippAdapter = gson.getAdapter(Boolean.class);
            this.prePlayAdapter = gson.getAdapter(Boolean.class);
            this.customBookmarkAdapter = gson.getAdapter(Boolean.class);
            this.fallbackTutorialAdapter = gson.getAdapter(Boolean.class);
            this.interactiveTrailerAdapter = gson.getAdapter(Boolean.class);
            this.hideDetailedDurationsAdapter = gson.getAdapter(Boolean.class);
        }

        public GsonTypeAdapter setDefaultPlaybackGraph(boolean z) {
            this.defaultPlaybackGraph = z;
            return this;
        }

        public GsonTypeAdapter setDefaultPlaybackNotifications(boolean z) {
            this.defaultPlaybackNotifications = z;
            return this;
        }

        public GsonTypeAdapter setDefaultIpp(boolean z) {
            this.defaultIpp = z;
            return this;
        }

        public GsonTypeAdapter setDefaultPrePlay(boolean z) {
            this.defaultPrePlay = z;
            return this;
        }

        public GsonTypeAdapter setDefaultCustomBookmark(boolean z) {
            this.defaultCustomBookmark = z;
            return this;
        }

        public GsonTypeAdapter setDefaultFallbackTutorial(boolean z) {
            this.defaultFallbackTutorial = z;
            return this;
        }

        public GsonTypeAdapter setDefaultInteractiveTrailer(boolean z) {
            this.defaultInteractiveTrailer = z;
            return this;
        }

        public GsonTypeAdapter setDefaultHideDetailedDurations(boolean z) {
            this.defaultHideDetailedDurations = z;
            return this;
        }

        public void write(JsonWriter jsonWriter, InteractiveFeatures interactiveFeatures) {
            if (interactiveFeatures == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("playbackGraph");
            this.playbackGraphAdapter.write(jsonWriter, Boolean.valueOf(interactiveFeatures.playbackGraph()));
            jsonWriter.name("playbackNotifications");
            this.playbackNotificationsAdapter.write(jsonWriter, Boolean.valueOf(interactiveFeatures.playbackNotifications()));
            jsonWriter.name("ipp");
            this.ippAdapter.write(jsonWriter, Boolean.valueOf(interactiveFeatures.ipp()));
            jsonWriter.name("prePlay");
            this.prePlayAdapter.write(jsonWriter, Boolean.valueOf(interactiveFeatures.prePlay()));
            jsonWriter.name("customBookmark");
            this.customBookmarkAdapter.write(jsonWriter, Boolean.valueOf(interactiveFeatures.customBookmark()));
            jsonWriter.name("fallbackTutorial");
            this.fallbackTutorialAdapter.write(jsonWriter, Boolean.valueOf(interactiveFeatures.fallbackTutorial()));
            jsonWriter.name("interactiveTrailer");
            this.interactiveTrailerAdapter.write(jsonWriter, Boolean.valueOf(interactiveFeatures.interactiveTrailer()));
            jsonWriter.name("hideDetailedDurations");
            this.hideDetailedDurationsAdapter.write(jsonWriter, Boolean.valueOf(interactiveFeatures.hideDetailedDurations()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public InteractiveFeatures read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            boolean z = this.defaultPlaybackGraph;
            boolean z2 = this.defaultPlaybackNotifications;
            boolean z3 = this.defaultIpp;
            boolean z4 = this.defaultPrePlay;
            boolean z5 = this.defaultCustomBookmark;
            boolean z6 = this.defaultFallbackTutorial;
            boolean z7 = this.defaultInteractiveTrailer;
            boolean z8 = this.defaultHideDetailedDurations;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1306315680:
                            if (nextName.equals("fallbackTutorial")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -941321229:
                            if (nextName.equals("playbackGraph")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -814574649:
                            if (nextName.equals("customBookmark")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -319313801:
                            if (nextName.equals("prePlay")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 104489:
                            if (nextName.equals("ipp")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 22494193:
                            if (nextName.equals("interactiveTrailer")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 235139725:
                            if (nextName.equals("playbackNotifications")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 269731181:
                            if (nextName.equals("hideDetailedDurations")) {
                                c = 7;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            z = this.playbackGraphAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 1:
                            z2 = this.playbackNotificationsAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 2:
                            z3 = this.ippAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 3:
                            z4 = this.prePlayAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 4:
                            z5 = this.customBookmarkAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 5:
                            z6 = this.fallbackTutorialAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 6:
                            z7 = this.interactiveTrailerAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 7:
                            z8 = this.hideDetailedDurationsAdapter.read(jsonReader).booleanValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_InteractiveFeatures(z, z2, z3, z4, z5, z6, z7, z8);
        }
    }
}
