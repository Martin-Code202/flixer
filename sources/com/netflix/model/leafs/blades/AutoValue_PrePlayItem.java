package com.netflix.model.leafs.blades;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.List;
/* access modifiers changed from: package-private */
public final class AutoValue_PrePlayItem extends C$AutoValue_PrePlayItem {
    AutoValue_PrePlayItem(String str, String str2, String str3, String str4, List<PreplayItemAction> list) {
        super(str, str2, str3, str4, list);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<PrePlayItem> {
        private final TypeAdapter<List<PreplayItemAction>> actionsAdapter;
        private List<PreplayItemAction> defaultActions = null;
        private String defaultImpressionData = null;
        private String defaultSupplementalMessage = null;
        private String defaultTitle = null;
        private String defaultType = null;
        private final TypeAdapter<String> impressionDataAdapter;
        private final TypeAdapter<String> supplementalMessageAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> typeAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.impressionDataAdapter = gson.getAdapter(String.class);
            this.typeAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.supplementalMessageAdapter = gson.getAdapter(String.class);
            this.actionsAdapter = gson.getAdapter(TypeToken.getParameterized(List.class, PreplayItemAction.class));
        }

        public GsonTypeAdapter setDefaultImpressionData(String str) {
            this.defaultImpressionData = str;
            return this;
        }

        public GsonTypeAdapter setDefaultType(String str) {
            this.defaultType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSupplementalMessage(String str) {
            this.defaultSupplementalMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultActions(List<PreplayItemAction> list) {
            this.defaultActions = list;
            return this;
        }

        public void write(JsonWriter jsonWriter, PrePlayItem prePlayItem) {
            if (prePlayItem == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("impressionData");
            this.impressionDataAdapter.write(jsonWriter, prePlayItem.impressionData());
            jsonWriter.name("type");
            this.typeAdapter.write(jsonWriter, prePlayItem.type());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, prePlayItem.title());
            jsonWriter.name("supplementalMessage");
            this.supplementalMessageAdapter.write(jsonWriter, prePlayItem.supplementalMessage());
            jsonWriter.name("actions");
            this.actionsAdapter.write(jsonWriter, prePlayItem.actions());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public PrePlayItem read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultImpressionData;
            String str2 = this.defaultType;
            String str3 = this.defaultTitle;
            String str4 = this.defaultSupplementalMessage;
            List<PreplayItemAction> list = this.defaultActions;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1161803523:
                            if (nextName.equals("actions")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -113850029:
                            if (nextName.equals("impressionData")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 3575610:
                            if (nextName.equals("type")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 417758403:
                            if (nextName.equals("supplementalMessage")) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str = this.impressionDataAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str2 = this.typeAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str3 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str4 = this.supplementalMessageAdapter.read(jsonReader);
                            continue;
                        case 4:
                            list = this.actionsAdapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_PrePlayItem(str, str2, str3, str4, list);
        }
    }
}
