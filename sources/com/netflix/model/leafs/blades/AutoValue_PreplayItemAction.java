package com.netflix.model.leafs.blades;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
/* access modifiers changed from: package-private */
public final class AutoValue_PreplayItemAction extends C$AutoValue_PreplayItemAction {
    AutoValue_PreplayItemAction(int i, String str, String str2, String str3, int i2, boolean z, boolean z2) {
        super(i, str, str2, str3, i2, z, z2);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<PreplayItemAction> {
        private final TypeAdapter<Integer> bookmarkPositionAdapter;
        private int defaultBookmarkPosition = 0;
        private boolean defaultDoNotIncrementInterrupter = false;
        private boolean defaultIgnoreBookmark = false;
        private String defaultName = null;
        private int defaultTrackId = 0;
        private String defaultType = null;
        private String defaultVideoId = null;
        private final TypeAdapter<Boolean> doNotIncrementInterrupterAdapter;
        private final TypeAdapter<Boolean> ignoreBookmarkAdapter;
        private final TypeAdapter<String> nameAdapter;
        private final TypeAdapter<Integer> trackIdAdapter;
        private final TypeAdapter<String> typeAdapter;
        private final TypeAdapter<String> videoIdAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.bookmarkPositionAdapter = gson.getAdapter(Integer.class);
            this.typeAdapter = gson.getAdapter(String.class);
            this.nameAdapter = gson.getAdapter(String.class);
            this.videoIdAdapter = gson.getAdapter(String.class);
            this.trackIdAdapter = gson.getAdapter(Integer.class);
            this.doNotIncrementInterrupterAdapter = gson.getAdapter(Boolean.class);
            this.ignoreBookmarkAdapter = gson.getAdapter(Boolean.class);
        }

        public GsonTypeAdapter setDefaultBookmarkPosition(int i) {
            this.defaultBookmarkPosition = i;
            return this;
        }

        public GsonTypeAdapter setDefaultType(String str) {
            this.defaultType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultName(String str) {
            this.defaultName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultVideoId(String str) {
            this.defaultVideoId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTrackId(int i) {
            this.defaultTrackId = i;
            return this;
        }

        public GsonTypeAdapter setDefaultDoNotIncrementInterrupter(boolean z) {
            this.defaultDoNotIncrementInterrupter = z;
            return this;
        }

        public GsonTypeAdapter setDefaultIgnoreBookmark(boolean z) {
            this.defaultIgnoreBookmark = z;
            return this;
        }

        public void write(JsonWriter jsonWriter, PreplayItemAction preplayItemAction) {
            if (preplayItemAction == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("bookmarkPosition");
            this.bookmarkPositionAdapter.write(jsonWriter, Integer.valueOf(preplayItemAction.bookmarkPosition()));
            jsonWriter.name("type");
            this.typeAdapter.write(jsonWriter, preplayItemAction.type());
            jsonWriter.name("name");
            this.nameAdapter.write(jsonWriter, preplayItemAction.name());
            jsonWriter.name("videoId");
            this.videoIdAdapter.write(jsonWriter, preplayItemAction.videoId());
            jsonWriter.name("trackId");
            this.trackIdAdapter.write(jsonWriter, Integer.valueOf(preplayItemAction.trackId()));
            jsonWriter.name("doNotIncrementInterrupter");
            this.doNotIncrementInterrupterAdapter.write(jsonWriter, Boolean.valueOf(preplayItemAction.doNotIncrementInterrupter()));
            jsonWriter.name("ignoreBookmark");
            this.ignoreBookmarkAdapter.write(jsonWriter, Boolean.valueOf(preplayItemAction.ignoreBookmark()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public PreplayItemAction read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = this.defaultBookmarkPosition;
            String str = this.defaultType;
            String str2 = this.defaultName;
            String str3 = this.defaultVideoId;
            int i2 = this.defaultTrackId;
            boolean z = this.defaultDoNotIncrementInterrupter;
            boolean z2 = this.defaultIgnoreBookmark;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1829827457:
                            if (nextName.equals("bookmarkPosition")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1067396154:
                            if (nextName.equals("trackId")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 3373707:
                            if (nextName.equals("name")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 3575610:
                            if (nextName.equals("type")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 452782838:
                            if (nextName.equals("videoId")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 771110345:
                            if (nextName.equals("doNotIncrementInterrupter")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 994317608:
                            if (nextName.equals("ignoreBookmark")) {
                                c = 6;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            i = this.bookmarkPositionAdapter.read(jsonReader).intValue();
                            continue;
                        case 1:
                            str = this.typeAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str2 = this.nameAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str3 = this.videoIdAdapter.read(jsonReader);
                            continue;
                        case 4:
                            i2 = this.trackIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 5:
                            z = this.doNotIncrementInterrupterAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 6:
                            z2 = this.ignoreBookmarkAdapter.read(jsonReader).booleanValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_PreplayItemAction(i, str, str2, str3, i2, z, z2);
        }
    }
}
