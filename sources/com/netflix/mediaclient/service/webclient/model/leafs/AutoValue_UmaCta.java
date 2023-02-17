package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
/* access modifiers changed from: package-private */
public final class AutoValue_UmaCta extends C$AutoValue_UmaCta {
    AutoValue_UmaCta(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, str5, str6, str7, str8, z, z2, z3);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<UmaCta> {
        private final TypeAdapter<String> actionAdapter;
        private final TypeAdapter<String> actionTypeAdapter;
        private final TypeAdapter<Boolean> autoLoginAdapter;
        private final TypeAdapter<String> callbackAdapter;
        private String defaultAction = null;
        private String defaultActionType = null;
        private boolean defaultAutoLogin = false;
        private String defaultCallback = null;
        private String defaultFailureMessage = null;
        private boolean defaultOpenLinkInWebView = false;
        private boolean defaultSelected = false;
        private String defaultSuccessMessage = null;
        private String defaultText = null;
        private String defaultTrackingInfo = null;
        private String defaultUmsAlertCtaFeedback = null;
        private final TypeAdapter<String> failureMessageAdapter;
        private final TypeAdapter<Boolean> openLinkInWebViewAdapter;
        private final TypeAdapter<Boolean> selectedAdapter;
        private final TypeAdapter<String> successMessageAdapter;
        private final TypeAdapter<String> textAdapter;
        private final TypeAdapter<String> trackingInfoAdapter;
        private final TypeAdapter<String> umsAlertCtaFeedbackAdapter;

        public GsonTypeAdapter(Gson gson) {
            this.textAdapter = gson.getAdapter(String.class);
            this.actionAdapter = gson.getAdapter(String.class);
            this.actionTypeAdapter = gson.getAdapter(String.class);
            this.callbackAdapter = gson.getAdapter(String.class);
            this.trackingInfoAdapter = gson.getAdapter(String.class);
            this.successMessageAdapter = gson.getAdapter(String.class);
            this.failureMessageAdapter = gson.getAdapter(String.class);
            this.umsAlertCtaFeedbackAdapter = gson.getAdapter(String.class);
            this.selectedAdapter = gson.getAdapter(Boolean.class);
            this.autoLoginAdapter = gson.getAdapter(Boolean.class);
            this.openLinkInWebViewAdapter = gson.getAdapter(Boolean.class);
        }

        public GsonTypeAdapter setDefaultText(String str) {
            this.defaultText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultAction(String str) {
            this.defaultAction = str;
            return this;
        }

        public GsonTypeAdapter setDefaultActionType(String str) {
            this.defaultActionType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCallback(String str) {
            this.defaultCallback = str;
            return this;
        }

        public GsonTypeAdapter setDefaultTrackingInfo(String str) {
            this.defaultTrackingInfo = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSuccessMessage(String str) {
            this.defaultSuccessMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFailureMessage(String str) {
            this.defaultFailureMessage = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUmsAlertCtaFeedback(String str) {
            this.defaultUmsAlertCtaFeedback = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSelected(boolean z) {
            this.defaultSelected = z;
            return this;
        }

        public GsonTypeAdapter setDefaultAutoLogin(boolean z) {
            this.defaultAutoLogin = z;
            return this;
        }

        public GsonTypeAdapter setDefaultOpenLinkInWebView(boolean z) {
            this.defaultOpenLinkInWebView = z;
            return this;
        }

        public void write(JsonWriter jsonWriter, UmaCta umaCta) {
            if (umaCta == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("text");
            this.textAdapter.write(jsonWriter, umaCta.text());
            jsonWriter.name("action");
            this.actionAdapter.write(jsonWriter, umaCta.action());
            jsonWriter.name("actionType");
            this.actionTypeAdapter.write(jsonWriter, umaCta.actionType());
            jsonWriter.name("callback");
            this.callbackAdapter.write(jsonWriter, umaCta.callback());
            jsonWriter.name("trackingInfo");
            this.trackingInfoAdapter.write(jsonWriter, umaCta.trackingInfo());
            jsonWriter.name("successMessage");
            this.successMessageAdapter.write(jsonWriter, umaCta.successMessage());
            jsonWriter.name("failureMessage");
            this.failureMessageAdapter.write(jsonWriter, umaCta.failureMessage());
            jsonWriter.name("umsAlertCtaFeedback");
            this.umsAlertCtaFeedbackAdapter.write(jsonWriter, umaCta.umsAlertCtaFeedback());
            jsonWriter.name("selected");
            this.selectedAdapter.write(jsonWriter, Boolean.valueOf(umaCta.selected()));
            jsonWriter.name("autoLogin");
            this.autoLoginAdapter.write(jsonWriter, Boolean.valueOf(umaCta.autoLogin()));
            jsonWriter.name("openLinkInWebView");
            this.openLinkInWebViewAdapter.write(jsonWriter, Boolean.valueOf(umaCta.openLinkInWebView()));
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public UmaCta read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = this.defaultText;
            String str2 = this.defaultAction;
            String str3 = this.defaultActionType;
            String str4 = this.defaultCallback;
            String str5 = this.defaultTrackingInfo;
            String str6 = this.defaultSuccessMessage;
            String str7 = this.defaultFailureMessage;
            String str8 = this.defaultUmsAlertCtaFeedback;
            boolean z = this.defaultSelected;
            boolean z2 = this.defaultAutoLogin;
            boolean z3 = this.defaultOpenLinkInWebView;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -1884240891:
                            if (nextName.equals("trackingInfo")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1704954083:
                            if (nextName.equals("failureMessage")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1422950858:
                            if (nextName.equals("action")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1161977420:
                            if (nextName.equals("umsAlertCtaFeedback")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -864423376:
                            if (nextName.equals("openLinkInWebView")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case -172220347:
                            if (nextName.equals("callback")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 3556653:
                            if (nextName.equals("text")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1191572123:
                            if (nextName.equals("selected")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 1219092100:
                            if (nextName.equals("successMessage")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 1643599610:
                            if (nextName.equals("autoLogin")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 1851881104:
                            if (nextName.equals("actionType")) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str = this.textAdapter.read(jsonReader);
                            continue;
                        case 1:
                            str2 = this.actionAdapter.read(jsonReader);
                            continue;
                        case 2:
                            str3 = this.actionTypeAdapter.read(jsonReader);
                            continue;
                        case 3:
                            str4 = this.callbackAdapter.read(jsonReader);
                            continue;
                        case 4:
                            str5 = this.trackingInfoAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str6 = this.successMessageAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str7 = this.failureMessageAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str8 = this.umsAlertCtaFeedbackAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            z = this.selectedAdapter.read(jsonReader).booleanValue();
                            continue;
                        case '\t':
                            z2 = this.autoLoginAdapter.read(jsonReader).booleanValue();
                            continue;
                        case '\n':
                            z3 = this.openLinkInWebViewAdapter.read(jsonReader).booleanValue();
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_UmaCta(str, str2, str3, str4, str5, str6, str7, str8, z, z2, z3);
        }
    }
}
