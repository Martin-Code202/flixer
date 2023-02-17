package com.netflix.model.leafs.originals.interactive;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
/* access modifiers changed from: package-private */
public final class AutoValue_MotionBoxart extends C$AutoValue_MotionBoxart {
    AutoValue_MotionBoxart(String str, String str2) {
        super(str, str2);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<MotionBoxart> {
        private String defaultOverlayUrl = null;
        private String defaultUrl = null;
        private final TypeAdapter<String> overlayUrlAdapter;
        private final TypeAdapter<String> urlAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.urlAdapter = gson.getAdapter(String.class);
            this.overlayUrlAdapter = gson.getAdapter(String.class);
        }

        public GsonTypeAdapter setDefaultUrl(String str) {
            this.defaultUrl = str;
            return this;
        }

        public GsonTypeAdapter setDefaultOverlayUrl(String str) {
            this.defaultOverlayUrl = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, MotionBoxart motionBoxart) {
            if (motionBoxart == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("url");
            this.urlAdapter.write(jsonWriter, motionBoxart.url());
            jsonWriter.name("overlayUrl");
            this.overlayUrlAdapter.write(jsonWriter, motionBoxart.overlayUrl());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public MotionBoxart read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultUrl;
            String str2 = this.defaultOverlayUrl;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1952782593:
                            if (nextName.equals("overlayUrl")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 116079:
                            if (nextName.equals("url")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str = this.urlAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str2 = this.overlayUrlAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_MotionBoxart(str, str2);
        }
    }
}
