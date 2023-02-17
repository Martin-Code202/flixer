package com.netflix.model.leafs.originals;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
/* access modifiers changed from: package-private */
public final class AutoValue_BillboardVideo extends C$AutoValue_BillboardVideo {
    AutoValue_BillboardVideo(String str, String str2, boolean z, boolean z2, boolean z3) {
        super(str, str2, z, z2, z3);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<BillboardVideo> {
        private final TypeAdapter<Boolean> autoPlayAdapter;
        private boolean defaultAutoPlay = false;
        private boolean defaultIsTrailer = false;
        private String defaultMotionId = null;
        private boolean defaultMotionShouldLoop = false;
        private String defaultMotionUrl = null;
        private final TypeAdapter<Boolean> isTrailerAdapter;
        private final TypeAdapter<String> motionIdAdapter;
        private final TypeAdapter<Boolean> motionShouldLoopAdapter;
        private final TypeAdapter<String> motionUrlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.motionIdAdapter = gson.getAdapter(String.class);
            this.motionUrlAdapter = gson.getAdapter(String.class);
            this.motionShouldLoopAdapter = gson.getAdapter(Boolean.class);
            this.isTrailerAdapter = gson.getAdapter(Boolean.class);
            this.autoPlayAdapter = gson.getAdapter(Boolean.class);
        }

        public GsonTypeAdapter setDefaultMotionId(String str) {
            this.defaultMotionId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMotionUrl(String str) {
            this.defaultMotionUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMotionShouldLoop(boolean z) {
            this.defaultMotionShouldLoop = z;
            return this;
        }

        public GsonTypeAdapter setDefaultIsTrailer(boolean z) {
            this.defaultIsTrailer = z;
            return this;
        }

        public GsonTypeAdapter setDefaultAutoPlay(boolean z) {
            this.defaultAutoPlay = z;
            return this;
        }

        public void write(JsonWriter jsonWriter, BillboardVideo billboardVideo) {
            if (billboardVideo == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("motionId");
            this.motionIdAdapter.write(jsonWriter, billboardVideo.motionId());
            jsonWriter.name("motionUrl");
            this.motionUrlAdapter.write(jsonWriter, billboardVideo.motionUrl());
            jsonWriter.name("motionShouldLoop");
            this.motionShouldLoopAdapter.write(jsonWriter, Boolean.valueOf(billboardVideo.motionShouldLoop()));
            jsonWriter.name("isTrailer");
            this.isTrailerAdapter.write(jsonWriter, Boolean.valueOf(billboardVideo.isTrailer()));
            jsonWriter.name("autoPlay");
            this.autoPlayAdapter.write(jsonWriter, Boolean.valueOf(billboardVideo.autoPlay()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public BillboardVideo read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultMotionId;
            String str2 = this.defaultMotionUrl;
            boolean z = this.defaultMotionShouldLoop;
            boolean z2 = this.defaultIsTrailer;
            boolean z3 = this.defaultAutoPlay;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1646994263:
                            if (nextName.equals("isTrailer")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -577443367:
                            if (nextName.equals("motionUrl")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -483381427:
                            if (nextName.equals("motionShouldLoop")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -157174927:
                            if (nextName.equals("motionId")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1438608771:
                            if (nextName.equals("autoPlay")) {
                                c = 4;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str = this.motionIdAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str2 = this.motionUrlAdapter.read(jsonReader);
                            continue;
                        case 2:
                            z = this.motionShouldLoopAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 3:
                            z2 = this.isTrailerAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 4:
                            z3 = this.autoPlayAdapter.read(jsonReader).booleanValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_BillboardVideo(str, str2, z, z2, z3);
        }
    }
}
