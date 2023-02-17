package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
/* access modifiers changed from: package-private */
public final class AutoValue_UmaAlert extends C$AutoValue_UmaAlert {
    AutoValue_UmaAlert(int i, int i2, String str, String str2, long j, String str3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str4, String str5, String str6, UmaCta umaCta, UmaCta umaCta2, String str7, String str8, long j2) {
        super(i, i2, str, str2, j, str3, z, z2, z3, z4, z5, z6, str4, str5, str6, umaCta, umaCta2, str7, str8, j2);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<UmaAlert> {
        private final TypeAdapter<Integer> abTestCellAdapter;
        private final TypeAdapter<Integer> abTestIdAdapter;
        private final TypeAdapter<String> backgroundActionAdapter;
        private final TypeAdapter<Boolean> bannerAlertAdapter;
        private final TypeAdapter<Boolean> blockingAdapter;
        private final TypeAdapter<String> bodyAdapter;
        private final TypeAdapter<UmaCta> cta1Adapter;
        private final TypeAdapter<UmaCta> cta2Adapter;
        private int defaultAbTestCell = 0;
        private int defaultAbTestId = 0;
        private String defaultBackgroundAction = null;
        private boolean defaultBannerAlert = false;
        private boolean defaultBlocking = false;
        private String defaultBody = null;
        private UmaCta defaultCta1 = null;
        private UmaCta defaultCta2 = null;
        private String defaultLocale = null;
        private long defaultMessageId = 0;
        private String defaultMessageName = null;
        private boolean defaultModalAlert = false;
        private boolean defaultShowOnBackgroundActionSuccess = false;
        private boolean defaultSuppressForBackgroundAction = false;
        private boolean defaultSuppressOnAppLaunch = false;
        private long defaultTimestamp = 0;
        private String defaultTitle = null;
        private String defaultTrackingInfo = null;
        private String defaultUmsAlertRenderFeedback = null;
        private String defaultViewType = null;
        private final TypeAdapter<String> localeAdapter;
        private final TypeAdapter<Long> messageIdAdapter;
        private final TypeAdapter<String> messageNameAdapter;
        private final TypeAdapter<Boolean> modalAlertAdapter;
        private final TypeAdapter<Boolean> showOnBackgroundActionSuccessAdapter;
        private final TypeAdapter<Boolean> suppressForBackgroundActionAdapter;
        private final TypeAdapter<Boolean> suppressOnAppLaunchAdapter;
        private final TypeAdapter<Long> timestampAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<String> trackingInfoAdapter;
        private final TypeAdapter<String> umsAlertRenderFeedbackAdapter;
        private final TypeAdapter<String> viewTypeAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.abTestCellAdapter = gson.getAdapter(Integer.class);
            this.abTestIdAdapter = gson.getAdapter(Integer.class);
            this.localeAdapter = gson.getAdapter(String.class);
            this.messageNameAdapter = gson.getAdapter(String.class);
            this.messageIdAdapter = gson.getAdapter(Long.class);
            this.viewTypeAdapter = gson.getAdapter(String.class);
            this.blockingAdapter = gson.getAdapter(Boolean.class);
            this.modalAlertAdapter = gson.getAdapter(Boolean.class);
            this.bannerAlertAdapter = gson.getAdapter(Boolean.class);
            this.suppressOnAppLaunchAdapter = gson.getAdapter(Boolean.class);
            this.suppressForBackgroundActionAdapter = gson.getAdapter(Boolean.class);
            this.showOnBackgroundActionSuccessAdapter = gson.getAdapter(Boolean.class);
            this.backgroundActionAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.bodyAdapter = gson.getAdapter(String.class);
            this.cta1Adapter = gson.getAdapter(UmaCta.class);
            this.cta2Adapter = gson.getAdapter(UmaCta.class);
            this.trackingInfoAdapter = gson.getAdapter(String.class);
            this.umsAlertRenderFeedbackAdapter = gson.getAdapter(String.class);
            this.timestampAdapter = gson.getAdapter(Long.class);
        }

        public GsonTypeAdapter setDefaultAbTestCell(int i) {
            this.defaultAbTestCell = i;
            return this;
        }

        public GsonTypeAdapter setDefaultAbTestId(int i) {
            this.defaultAbTestId = i;
            return this;
        }

        public GsonTypeAdapter setDefaultLocale(String str) {
            this.defaultLocale = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageName(String str) {
            this.defaultMessageName = str;
            return this;
        }

        public GsonTypeAdapter setDefaultMessageId(long j) {
            this.defaultMessageId = j;
            return this;
        }

        public GsonTypeAdapter setDefaultViewType(String str) {
            this.defaultViewType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultBlocking(boolean z) {
            this.defaultBlocking = z;
            return this;
        }

        public GsonTypeAdapter setDefaultModalAlert(boolean z) {
            this.defaultModalAlert = z;
            return this;
        }

        public GsonTypeAdapter setDefaultBannerAlert(boolean z) {
            this.defaultBannerAlert = z;
            return this;
        }

        public GsonTypeAdapter setDefaultSuppressOnAppLaunch(boolean z) {
            this.defaultSuppressOnAppLaunch = z;
            return this;
        }

        public GsonTypeAdapter setDefaultSuppressForBackgroundAction(boolean z) {
            this.defaultSuppressForBackgroundAction = z;
            return this;
        }

        public GsonTypeAdapter setDefaultShowOnBackgroundActionSuccess(boolean z) {
            this.defaultShowOnBackgroundActionSuccess = z;
            return this;
        }

        public GsonTypeAdapter setDefaultBackgroundAction(String str) {
            this.defaultBackgroundAction = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTitle(String str) {
            this.defaultTitle = str;
            return this;
        }

        public GsonTypeAdapter setDefaultBody(String str) {
            this.defaultBody = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCta1(UmaCta umaCta) {
            this.defaultCta1 = umaCta;
            return this;
        }

        public GsonTypeAdapter setDefaultCta2(UmaCta umaCta) {
            this.defaultCta2 = umaCta;
            return this;
        }

        public GsonTypeAdapter setDefaultTrackingInfo(String str) {
            this.defaultTrackingInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUmsAlertRenderFeedback(String str) {
            this.defaultUmsAlertRenderFeedback = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTimestamp(long j) {
            this.defaultTimestamp = j;
            return this;
        }

        public void write(JsonWriter jsonWriter, UmaAlert umaAlert) {
            if (umaAlert == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("abTestCell");
            this.abTestCellAdapter.write(jsonWriter, Integer.valueOf(umaAlert.abTestCell()));
            jsonWriter.name("abTestId");
            this.abTestIdAdapter.write(jsonWriter, Integer.valueOf(umaAlert.abTestId()));
            jsonWriter.name(LoggingRequest.LOCALE);
            this.localeAdapter.write(jsonWriter, umaAlert.locale());
            jsonWriter.name("messageName");
            this.messageNameAdapter.write(jsonWriter, umaAlert.messageName());
            jsonWriter.name("messageId");
            this.messageIdAdapter.write(jsonWriter, Long.valueOf(umaAlert.messageId()));
            jsonWriter.name("viewType");
            this.viewTypeAdapter.write(jsonWriter, umaAlert.viewType());
            jsonWriter.name("blocking");
            this.blockingAdapter.write(jsonWriter, Boolean.valueOf(umaAlert.blocking()));
            jsonWriter.name("modalAlert");
            this.modalAlertAdapter.write(jsonWriter, Boolean.valueOf(umaAlert.modalAlert()));
            jsonWriter.name("bannerAlert");
            this.bannerAlertAdapter.write(jsonWriter, Boolean.valueOf(umaAlert.bannerAlert()));
            jsonWriter.name("suppressOnAppLaunch");
            this.suppressOnAppLaunchAdapter.write(jsonWriter, Boolean.valueOf(umaAlert.suppressOnAppLaunch()));
            jsonWriter.name("suppressForBackgroundAction");
            this.suppressForBackgroundActionAdapter.write(jsonWriter, Boolean.valueOf(umaAlert.suppressForBackgroundAction()));
            jsonWriter.name("showOnBackgroundActionSuccess");
            this.showOnBackgroundActionSuccessAdapter.write(jsonWriter, Boolean.valueOf(umaAlert.showOnBackgroundActionSuccess()));
            jsonWriter.name("backgroundAction");
            this.backgroundActionAdapter.write(jsonWriter, umaAlert.backgroundAction());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, umaAlert.title());
            jsonWriter.name("body");
            this.bodyAdapter.write(jsonWriter, umaAlert.body());
            jsonWriter.name("cta1");
            this.cta1Adapter.write(jsonWriter, umaAlert.cta1());
            jsonWriter.name("cta2");
            this.cta2Adapter.write(jsonWriter, umaAlert.cta2());
            jsonWriter.name("trackingInfo");
            this.trackingInfoAdapter.write(jsonWriter, umaAlert.trackingInfo());
            jsonWriter.name("umsAlertRenderFeedback");
            this.umsAlertRenderFeedbackAdapter.write(jsonWriter, umaAlert.umsAlertRenderFeedback());
            jsonWriter.name("timestamp");
            this.timestampAdapter.write(jsonWriter, Long.valueOf(umaAlert.timestamp()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public UmaAlert read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = this.defaultAbTestCell;
            int i2 = this.defaultAbTestId;
            String str = this.defaultLocale;
            String str2 = this.defaultMessageName;
            long j = this.defaultMessageId;
            String str3 = this.defaultViewType;
            boolean z = this.defaultBlocking;
            boolean z2 = this.defaultModalAlert;
            boolean z3 = this.defaultBannerAlert;
            boolean z4 = this.defaultSuppressOnAppLaunch;
            boolean z5 = this.defaultSuppressForBackgroundAction;
            boolean z6 = this.defaultShowOnBackgroundActionSuccess;
            String str4 = this.defaultBackgroundAction;
            String str5 = this.defaultTitle;
            String str6 = this.defaultBody;
            UmaCta umaCta = this.defaultCta1;
            UmaCta umaCta2 = this.defaultCta2;
            String str7 = this.defaultTrackingInfo;
            String str8 = this.defaultUmsAlertRenderFeedback;
            long j2 = this.defaultTimestamp;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1934772848:
                            if (nextName.equals("bannerAlert")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1884240891:
                            if (nextName.equals("trackingInfo")) {
                                c = 17;
                                break;
                            }
                            break;
                        case -1674242016:
                            if (nextName.equals("suppressOnAppLaunch")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1472904529:
                            if (nextName.equals("modalAlert")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -1440013438:
                            if (nextName.equals("messageId")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1097462182:
                            if (nextName.equals(LoggingRequest.LOCALE)) {
                                c = 2;
                                break;
                            }
                            break;
                        case -873295054:
                            if (nextName.equals("messageName")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -664572875:
                            if (nextName.equals("blocking")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -129452296:
                            if (nextName.equals("suppressForBackgroundAction")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 3029410:
                            if (nextName.equals("body")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 3063841:
                            if (nextName.equals("cta1")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 3063842:
                            if (nextName.equals("cta2")) {
                                c = 16;
                                break;
                            }
                            break;
                        case 55126294:
                            if (nextName.equals("timestamp")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 293496917:
                            if (nextName.equals("abTestCell")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 831589582:
                            if (nextName.equals("abTestId")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 983683331:
                            if (nextName.equals("showOnBackgroundActionSuccess")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 1178051844:
                            if (nextName.equals("backgroundAction")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 1195860863:
                            if (nextName.equals("viewType")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 1399867100:
                            if (nextName.equals("umsAlertRenderFeedback")) {
                                c = 18;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            i = this.abTestCellAdapter.read(jsonReader).intValue();
                            continue;
                        case 1:
                            i2 = this.abTestIdAdapter.read(jsonReader).intValue();
                            continue;
                        case 2:
                            str = this.localeAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str2 = this.messageNameAdapter.read(jsonReader);
                            continue;
                        case 4:
                            j = this.messageIdAdapter.read(jsonReader).longValue();
                            continue;
                        case 5:
                            str3 = this.viewTypeAdapter.read(jsonReader);
                            continue;
                        case 6:
                            z = this.blockingAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 7:
                            z2 = this.modalAlertAdapter.read(jsonReader).booleanValue();
                            continue;
                        case '\b':
                            z3 = this.bannerAlertAdapter.read(jsonReader).booleanValue();
                            continue;
                        case '\t':
                            z4 = this.suppressOnAppLaunchAdapter.read(jsonReader).booleanValue();
                            continue;
                        case '\n':
                            z5 = this.suppressForBackgroundActionAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 11:
                            z6 = this.showOnBackgroundActionSuccessAdapter.read(jsonReader).booleanValue();
                            continue;
                        case '\f':
                            str4 = this.backgroundActionAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str5 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str6 = this.bodyAdapter.read(jsonReader);
                            continue;
                        case 15:
                            umaCta = this.cta1Adapter.read(jsonReader);
                            continue;
                        case 16:
                            umaCta2 = this.cta2Adapter.read(jsonReader);
                            continue;
                        case 17:
                            str7 = this.trackingInfoAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str8 = this.umsAlertRenderFeedbackAdapter.read(jsonReader);
                            continue;
                        case 19:
                            j2 = this.timestampAdapter.read(jsonReader).longValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_UmaAlert(i, i2, str, str2, j, str3, z, z2, z3, z4, z5, z6, str4, str5, str6, umaCta, umaCta2, str7, str8, j2);
        }
    }
}
