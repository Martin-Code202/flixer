package com.netflix.model.leafs.blades;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
/* access modifiers changed from: package-private */
/* renamed from: com.netflix.model.leafs.blades.$AutoValue_CreditMarks  reason: invalid class name */
public abstract class C$AutoValue_CreditMarks extends C$$AutoValue_CreditMarks {
    C$AutoValue_CreditMarks(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    /* renamed from: com.netflix.model.leafs.blades.$AutoValue_CreditMarks$GsonTypeAdapter */
    public static final class GsonTypeAdapter extends TypeAdapter<CreditMarks> {
        private int defaultEndCredit = 0;
        private int defaultEndRecap = 0;
        private int defaultStartCredit = 0;
        private int defaultStartRecap = 0;
        private final TypeAdapter<Integer> endCreditAdapter;
        private final TypeAdapter<Integer> endRecapAdapter;
        private final TypeAdapter<Integer> startCreditAdapter;
        private final TypeAdapter<Integer> startRecapAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.startCreditAdapter = gson.getAdapter(Integer.class);
            this.endCreditAdapter = gson.getAdapter(Integer.class);
            this.startRecapAdapter = gson.getAdapter(Integer.class);
            this.endRecapAdapter = gson.getAdapter(Integer.class);
        }

        public GsonTypeAdapter setDefaultStartCredit(int i) {
            this.defaultStartCredit = i;
            return this;
        }

        public GsonTypeAdapter setDefaultEndCredit(int i) {
            this.defaultEndCredit = i;
            return this;
        }

        public GsonTypeAdapter setDefaultStartRecap(int i) {
            this.defaultStartRecap = i;
            return this;
        }

        public GsonTypeAdapter setDefaultEndRecap(int i) {
            this.defaultEndRecap = i;
            return this;
        }

        public void write(JsonWriter jsonWriter, CreditMarks creditMarks) {
            if (creditMarks == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("startcredit");
            this.startCreditAdapter.write(jsonWriter, Integer.valueOf(creditMarks.startCredit()));
            jsonWriter.name("endcredit");
            this.endCreditAdapter.write(jsonWriter, Integer.valueOf(creditMarks.endCredit()));
            jsonWriter.name("startrecap");
            this.startRecapAdapter.write(jsonWriter, Integer.valueOf(creditMarks.startRecap()));
            jsonWriter.name("endrecap");
            this.endRecapAdapter.write(jsonWriter, Integer.valueOf(creditMarks.endRecap()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public CreditMarks read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = this.defaultStartCredit;
            int i2 = this.defaultEndCredit;
            int i3 = this.defaultStartRecap;
            int i4 = this.defaultEndRecap;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1556051555:
                            if (nextName.equals("startrecap")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1410327077:
                            if (nextName.equals("startcredit")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1742645444:
                            if (nextName.equals("endrecap")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 2065032084:
                            if (nextName.equals("endcredit")) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            i = this.startCreditAdapter.read(jsonReader).intValue();
                            continue;
                        case 1:
                            i2 = this.endCreditAdapter.read(jsonReader).intValue();
                            continue;
                        case 2:
                            i3 = this.startRecapAdapter.read(jsonReader).intValue();
                            continue;
                        case 3:
                            i4 = this.endRecapAdapter.read(jsonReader).intValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_CreditMarks(i, i2, i3, i4);
        }
    }
}
