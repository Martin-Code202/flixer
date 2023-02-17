package com.netflix.model.leafs.originals;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.List;
/* access modifiers changed from: package-private */
public final class AutoValue_BillboardPhase extends C$AutoValue_BillboardPhase {
    AutoValue_BillboardPhase(String str, List<BillboardCTA> list) {
        super(str, list);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<BillboardPhase> {
        private final TypeAdapter<List<BillboardCTA>> actionsAdapter;
        private List<BillboardCTA> defaultActions = null;
        private String defaultSupplementalMessage = null;
        private final TypeAdapter<String> supplementalMessageAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.supplementalMessageAdapter = gson.getAdapter(String.class);
            this.actionsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, BillboardCTA.class));
        }

        public GsonTypeAdapter setDefaultSupplementalMessage(String str) {
            this.defaultSupplementalMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultActions(List<BillboardCTA> list) {
            this.defaultActions = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, BillboardPhase billboardPhase) {
            if (billboardPhase == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("supplementalMessage");
            this.supplementalMessageAdapter.write(jsonWriter, billboardPhase.supplementalMessage());
            jsonWriter.name("actions");
            this.actionsAdapter.write(jsonWriter, billboardPhase.actions());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public BillboardPhase read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultSupplementalMessage;
            List<BillboardCTA> list = this.defaultActions;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1161803523:
                            if (nextName.equals("actions")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 417758403:
                            if (nextName.equals("supplementalMessage")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str = this.supplementalMessageAdapter.read(jsonReader);
                            continue;
                        case 1:
                            list = this.actionsAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_BillboardPhase(str, list);
        }
    }
}
