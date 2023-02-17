package com.netflix.model.leafs.originals;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
/* access modifiers changed from: package-private */
public final class AutoValue_VideoAssets extends C$AutoValue_VideoAssets {
    AutoValue_VideoAssets(BillboardVideo billboardVideo) {
        super(billboardVideo);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<VideoAssets> {
        private BillboardVideo defaultHorizontalBackground = null;
        private final TypeAdapter<BillboardVideo> horizontalBackgroundAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.horizontalBackgroundAdapter = gson.getAdapter(BillboardVideo.class);
        }

        public GsonTypeAdapter setDefaultHorizontalBackground(BillboardVideo billboardVideo) {
            this.defaultHorizontalBackground = billboardVideo;
            return this;
        }

        public void write(JsonWriter jsonWriter, VideoAssets videoAssets) {
            if (videoAssets == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("horizontalBackground");
            this.horizontalBackgroundAdapter.write(jsonWriter, videoAssets.horizontalBackground());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public VideoAssets read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            BillboardVideo billboardVideo = this.defaultHorizontalBackground;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case 1573511282:
                            if (nextName.equals("horizontalBackground")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            billboardVideo = this.horizontalBackgroundAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_VideoAssets(billboardVideo);
        }
    }
}
