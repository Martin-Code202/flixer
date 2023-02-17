package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
/* access modifiers changed from: package-private */
/* renamed from: o.oa  reason: case insensitive filesystem */
public final class C2025oa extends nY {
    C2025oa(String str, String str2, int i, float f, float f2, long j, long j2, long j3, long j4, float f3, float f4, long j5, long j6, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        super(str, str2, i, f, f2, j, j2, j3, j4, f3, f4, j5, j6, f5, f6, f7, f8, f9, f10, f11, f12, f13);
    }

    /* renamed from: o.oa$if  reason: invalid class name */
    public static final class Cif extends TypeAdapter<AbstractC2033oi> {

        /* renamed from: ʻ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9242;

        /* renamed from: ʻॱ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9243;

        /* renamed from: ʼ  reason: contains not printable characters */
        private final TypeAdapter<Long> f9244;

        /* renamed from: ʼॱ  reason: contains not printable characters */
        private int f9245 = 0;

        /* renamed from: ʽ  reason: contains not printable characters */
        private final TypeAdapter<Long> f9246;

        /* renamed from: ʽॱ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9247;

        /* renamed from: ʾ  reason: contains not printable characters */
        private String f9248 = null;

        /* renamed from: ʿ  reason: contains not printable characters */
        private String f9249 = null;

        /* renamed from: ˈ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9250;

        /* renamed from: ˉ  reason: contains not printable characters */
        private long f9251 = 0;

        /* renamed from: ˊ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9252;

        /* renamed from: ˊˊ  reason: contains not printable characters */
        private float f9253 = 0.0f;

        /* renamed from: ˊˋ  reason: contains not printable characters */
        private long f9254 = 0;

        /* renamed from: ˊॱ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9255;

        /* renamed from: ˊᐝ  reason: contains not printable characters */
        private float f9256 = 0.0f;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9257;

        /* renamed from: ˋˊ  reason: contains not printable characters */
        private long f9258 = 0;

        /* renamed from: ˋˋ  reason: contains not printable characters */
        private long f9259 = 0;

        /* renamed from: ˋॱ  reason: contains not printable characters */
        private final TypeAdapter<Long> f9260;

        /* renamed from: ˋᐝ  reason: contains not printable characters */
        private float f9261 = 0.0f;

        /* renamed from: ˌ  reason: contains not printable characters */
        private float f9262 = 0.0f;

        /* renamed from: ˍ  reason: contains not printable characters */
        private long f9263 = 0;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final TypeAdapter<Integer> f9264;

        /* renamed from: ˎˎ  reason: contains not printable characters */
        private long f9265 = 0;

        /* renamed from: ˎˏ  reason: contains not printable characters */
        private float f9266 = 0.0f;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final TypeAdapter<String> f9267;

        /* renamed from: ˏˎ  reason: contains not printable characters */
        private float f9268 = 0.0f;

        /* renamed from: ˏˏ  reason: contains not printable characters */
        private float f9269 = 0.0f;

        /* renamed from: ˏॱ  reason: contains not printable characters */
        private final TypeAdapter<Long> f9270;

        /* renamed from: ˑ  reason: contains not printable characters */
        private float f9271 = 0.0f;

        /* renamed from: ͺ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9272;

        /* renamed from: ͺॱ  reason: contains not printable characters */
        private float f9273 = 0.0f;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final TypeAdapter<String> f9274;

        /* renamed from: ॱʻ  reason: contains not printable characters */
        private float f9275 = 0.0f;

        /* renamed from: ॱʼ  reason: contains not printable characters */
        private float f9276 = 0.0f;

        /* renamed from: ॱʽ  reason: contains not printable characters */
        private float f9277 = 0.0f;

        /* renamed from: ॱˊ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9278;

        /* renamed from: ॱˋ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9279;

        /* renamed from: ॱˎ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9280;

        /* renamed from: ॱͺ  reason: contains not printable characters */
        private float f9281 = 0.0f;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private final TypeAdapter<Long> f9282;

        /* renamed from: ॱᐝ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9283;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final TypeAdapter<Long> f9284;

        /* renamed from: ᐝॱ  reason: contains not printable characters */
        private final TypeAdapter<Float> f9285;

        public Cif(Gson gson) {
            this.f9267 = gson.getAdapter(String.class);
            this.f9274 = gson.getAdapter(String.class);
            this.f9264 = gson.getAdapter(Integer.class);
            this.f9257 = gson.getAdapter(Float.class);
            this.f9252 = gson.getAdapter(Float.class);
            this.f9282 = gson.getAdapter(Long.class);
            this.f9244 = gson.getAdapter(Long.class);
            this.f9246 = gson.getAdapter(Long.class);
            this.f9284 = gson.getAdapter(Long.class);
            this.f9242 = gson.getAdapter(Float.class);
            this.f9278 = gson.getAdapter(Float.class);
            this.f9270 = gson.getAdapter(Long.class);
            this.f9260 = gson.getAdapter(Long.class);
            this.f9255 = gson.getAdapter(Float.class);
            this.f9272 = gson.getAdapter(Float.class);
            this.f9280 = gson.getAdapter(Float.class);
            this.f9243 = gson.getAdapter(Float.class);
            this.f9285 = gson.getAdapter(Float.class);
            this.f9283 = gson.getAdapter(Float.class);
            this.f9279 = gson.getAdapter(Float.class);
            this.f9247 = gson.getAdapter(Float.class);
            this.f9250 = gson.getAdapter(Float.class);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void write(JsonWriter jsonWriter, AbstractC2033oi oiVar) {
            if (oiVar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("sdk");
            this.f9267.write(jsonWriter, oiVar.mo9223());
            jsonWriter.name("codec");
            this.f9274.write(jsonWriter, oiVar.mo9215());
            jsonWriter.name("rate");
            this.f9264.write(jsonWriter, Integer.valueOf(oiVar.mo9219()));
            jsonWriter.name("downloadBw");
            this.f9257.write(jsonWriter, Float.valueOf(oiVar.mo9220()));
            jsonWriter.name("uploadBw");
            this.f9252.write(jsonWriter, Float.valueOf(oiVar.mo9217()));
            jsonWriter.name("packetsSent");
            this.f9282.write(jsonWriter, Long.valueOf(oiVar.mo9227()));
            jsonWriter.name("packetsReceived");
            this.f9244.write(jsonWriter, Long.valueOf(oiVar.mo9213()));
            jsonWriter.name("bytesSent");
            this.f9246.write(jsonWriter, Long.valueOf(oiVar.mo9229()));
            jsonWriter.name("bytesReceived");
            this.f9284.write(jsonWriter, Long.valueOf(oiVar.mo9209()));
            jsonWriter.name("sendLossRate");
            this.f9242.write(jsonWriter, Float.valueOf(oiVar.mo9211()));
            jsonWriter.name("recvLossRate");
            this.f9278.write(jsonWriter, Float.valueOf(oiVar.mo9224()));
            jsonWriter.name("incomingTooLate");
            this.f9270.write(jsonWriter, Long.valueOf(oiVar.mo9222()));
            jsonWriter.name("incomingPacketsLost");
            this.f9260.write(jsonWriter, Long.valueOf(oiVar.mo9218()));
            jsonWriter.name("averageJitterRx");
            this.f9255.write(jsonWriter, Float.valueOf(oiVar.mo9216()));
            jsonWriter.name("minJitterRx");
            this.f9272.write(jsonWriter, Float.valueOf(oiVar.mo9221()));
            jsonWriter.name("maxJitterRx");
            this.f9280.write(jsonWriter, Float.valueOf(oiVar.mo9228()));
            jsonWriter.name("averageJitterTx");
            this.f9243.write(jsonWriter, Float.valueOf(oiVar.mo9230()));
            jsonWriter.name("minJitterTx");
            this.f9285.write(jsonWriter, Float.valueOf(oiVar.mo9226()));
            jsonWriter.name("maxJitterTx");
            this.f9283.write(jsonWriter, Float.valueOf(oiVar.mo9210()));
            jsonWriter.name("averageRtt");
            this.f9279.write(jsonWriter, Float.valueOf(oiVar.mo9225()));
            jsonWriter.name("minRtt");
            this.f9247.write(jsonWriter, Float.valueOf(oiVar.mo9214()));
            jsonWriter.name("maxRtt");
            this.f9250.write(jsonWriter, Float.valueOf(oiVar.mo9212()));
            jsonWriter.endObject();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public AbstractC2033oi read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.f9249;
            String str2 = this.f9248;
            int i = this.f9245;
            float f = this.f9256;
            float f2 = this.f9253;
            long j = this.f9254;
            long j2 = this.f9258;
            long j3 = this.f9251;
            long j4 = this.f9259;
            float f3 = this.f9261;
            float f4 = this.f9262;
            long j5 = this.f9265;
            long j6 = this.f9263;
            float f5 = this.f9266;
            float f6 = this.f9271;
            float f7 = this.f9273;
            float f8 = this.f9268;
            float f9 = this.f9269;
            float f10 = this.f9277;
            float f11 = this.f9275;
            float f12 = this.f9281;
            float f13 = this.f9276;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -2033658205:
                            if (nextName.equals("bytesSent")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1934772567:
                            if (nextName.equals("recvLossRate")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -1497929141:
                            if (nextName.equals("sendLossRate")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1296873708:
                            if (nextName.equals("incomingTooLate")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -1081150866:
                            if (nextName.equals("maxRtt")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -1074060608:
                            if (nextName.equals("minRtt")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -791916887:
                            if (nextName.equals("incomingPacketsLost")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -755963708:
                            if (nextName.equals("minJitterRx")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -755963646:
                            if (nextName.equals("minJitterTx")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -78531114:
                            if (nextName.equals("maxJitterRx")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -78531052:
                            if (nextName.equals("maxJitterTx")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 113722:
                            if (nextName.equals("sdk")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 3493088:
                            if (nextName.equals("rate")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 94834710:
                            if (nextName.equals("codec")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 488428309:
                            if (nextName.equals("averageRtt")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 549067555:
                            if (nextName.equals("packetsSent")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 920221676:
                            if (nextName.equals("packetsReceived")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 941519724:
                            if (nextName.equals("bytesReceived")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 1563990582:
                            if (nextName.equals("uploadBw")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1751721359:
                            if (nextName.equals("averageJitterRx")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 1751721421:
                            if (nextName.equals("averageJitterTx")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 2039140093:
                            if (nextName.equals("downloadBw")) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str = this.f9267.read(jsonReader);
                            continue;
                        case 1:
                            str2 = this.f9274.read(jsonReader);
                            continue;
                        case 2:
                            i = this.f9264.read(jsonReader).intValue();
                            continue;
                        case 3:
                            f = this.f9257.read(jsonReader).floatValue();
                            continue;
                        case 4:
                            f2 = this.f9252.read(jsonReader).floatValue();
                            continue;
                        case 5:
                            j = this.f9282.read(jsonReader).longValue();
                            continue;
                        case 6:
                            j2 = this.f9244.read(jsonReader).longValue();
                            continue;
                        case 7:
                            j3 = this.f9246.read(jsonReader).longValue();
                            continue;
                        case '\b':
                            j4 = this.f9284.read(jsonReader).longValue();
                            continue;
                        case '\t':
                            f3 = this.f9242.read(jsonReader).floatValue();
                            continue;
                        case '\n':
                            f4 = this.f9278.read(jsonReader).floatValue();
                            continue;
                        case 11:
                            j5 = this.f9270.read(jsonReader).longValue();
                            continue;
                        case '\f':
                            j6 = this.f9260.read(jsonReader).longValue();
                            continue;
                        case '\r':
                            f5 = this.f9255.read(jsonReader).floatValue();
                            continue;
                        case 14:
                            f6 = this.f9272.read(jsonReader).floatValue();
                            continue;
                        case 15:
                            f7 = this.f9280.read(jsonReader).floatValue();
                            continue;
                        case 16:
                            f8 = this.f9243.read(jsonReader).floatValue();
                            continue;
                        case 17:
                            f9 = this.f9285.read(jsonReader).floatValue();
                            continue;
                        case 18:
                            f10 = this.f9283.read(jsonReader).floatValue();
                            continue;
                        case 19:
                            f11 = this.f9279.read(jsonReader).floatValue();
                            continue;
                        case 20:
                            f12 = this.f9247.read(jsonReader).floatValue();
                            continue;
                        case 21:
                            f13 = this.f9250.read(jsonReader).floatValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new C2025oa(str, str2, i, f, f2, j, j2, j3, j4, f3, f4, j5, j6, f5, f6, f7, f8, f9, f10, f11, f12, f13);
        }
    }
}
