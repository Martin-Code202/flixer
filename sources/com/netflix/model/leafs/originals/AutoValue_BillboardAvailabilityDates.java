package com.netflix.model.leafs.originals;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
/* access modifiers changed from: package-private */
public final class AutoValue_BillboardAvailabilityDates extends C$AutoValue_BillboardAvailabilityDates {
    AutoValue_BillboardAvailabilityDates(Long l) {
        super(l);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<BillboardAvailabilityDates> {
        private Long defaultStart = null;
        private final TypeAdapter<Long> startAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.startAdapter = gson.getAdapter(Long.class);
        }

        public GsonTypeAdapter setDefaultStart(Long l) {
            this.defaultStart = l;
            return this;
        }

        public void write(JsonWriter jsonWriter, BillboardAvailabilityDates billboardAvailabilityDates) {
            if (billboardAvailabilityDates == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("start");
            this.startAdapter.write(jsonWriter, billboardAvailabilityDates.start());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public BillboardAvailabilityDates read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            Long l = this.defaultStart;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case 109757538:
                            if (nextName.equals("start")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            l = this.startAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_BillboardAvailabilityDates(l);
        }
    }
}
