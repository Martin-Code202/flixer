package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
/* access modifiers changed from: package-private */
public final class AutoValue_EogAlert extends C$AutoValue_EogAlert {
    AutoValue_EogAlert(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, boolean z, String str20, String str21, String str22, String str23, boolean z2, String str24, String str25, String str26, String str27, boolean z3, String str28, boolean z4, String str29, String str30) {
        super(i, i2, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, z, str20, str21, str22, str23, z2, str24, str25, str26, str27, z3, str28, z4, str29, str30);
    }

    public static final class GsonTypeAdapter extends TypeAdapter<EogAlert> {
        private final TypeAdapter<Integer> abTestCellAdapter;
        private final TypeAdapter<Integer> abTestIdAdapter;
        private final TypeAdapter<String> bodyAdapter;
        private final TypeAdapter<String> continueBtnTextAdapter;
        private final TypeAdapter<String> currentPlanIdAdapter;
        private final TypeAdapter<String> currentPlanTierAdapter;
        private int defaultAbTestCell = 0;
        private int defaultAbTestId = 0;
        private String defaultBody = null;
        private String defaultContinueBtnText = null;
        private String defaultCurrentPlanId = null;
        private String defaultCurrentPlanTier = null;
        private String defaultDisclaimerText = null;
        private String defaultFooterLinkText = null;
        private String defaultFooterSuffix = null;
        private String defaultFooterText = null;
        private boolean defaultHdPlanIsCurrentPlan = false;
        private String defaultHdPlanPlanId = null;
        private String defaultHdPlanPlanTier = null;
        private String defaultHdPlanPrice = null;
        private String defaultHdPlanText = null;
        private boolean defaultIsBlocking = false;
        private String defaultLocale = null;
        private String defaultMessageName = null;
        private boolean defaultSdPlanIsCurrentPlan = false;
        private String defaultSdPlanPlanId = null;
        private String defaultSdPlanPlanTier = null;
        private String defaultSdPlanPrice = null;
        private String defaultSdPlanText = null;
        private String defaultSeeOtherPlansText = null;
        private String defaultSelectPlanText = null;
        private String defaultSkipBtnImpressionType = null;
        private String defaultSkipBtnText = null;
        private String defaultTemplateId = null;
        private String defaultTitle = null;
        private boolean defaultUhdPlanIsCurrentPlan = false;
        private String defaultUhdPlanPlanId = null;
        private String defaultUhdPlanPlanTier = null;
        private String defaultUhdPlanPrice = null;
        private String defaultUhdPlanText = null;
        private String defaultUrlImage1 = null;
        private String defaultUrlImage2 = null;
        private final TypeAdapter<String> disclaimerTextAdapter;
        private final TypeAdapter<String> footerLinkTextAdapter;
        private final TypeAdapter<String> footerSuffixAdapter;
        private final TypeAdapter<String> footerTextAdapter;
        private final TypeAdapter<Boolean> hdPlanIsCurrentPlanAdapter;
        private final TypeAdapter<String> hdPlanPlanIdAdapter;
        private final TypeAdapter<String> hdPlanPlanTierAdapter;
        private final TypeAdapter<String> hdPlanPriceAdapter;
        private final TypeAdapter<String> hdPlanTextAdapter;
        private final TypeAdapter<Boolean> isBlockingAdapter;
        private final TypeAdapter<String> localeAdapter;
        private final TypeAdapter<String> messageNameAdapter;
        private final TypeAdapter<Boolean> sdPlanIsCurrentPlanAdapter;
        private final TypeAdapter<String> sdPlanPlanIdAdapter;
        private final TypeAdapter<String> sdPlanPlanTierAdapter;
        private final TypeAdapter<String> sdPlanPriceAdapter;
        private final TypeAdapter<String> sdPlanTextAdapter;
        private final TypeAdapter<String> seeOtherPlansTextAdapter;
        private final TypeAdapter<String> selectPlanTextAdapter;
        private final TypeAdapter<String> skipBtnImpressionTypeAdapter;
        private final TypeAdapter<String> skipBtnTextAdapter;
        private final TypeAdapter<String> templateIdAdapter;
        private final TypeAdapter<String> titleAdapter;
        private final TypeAdapter<Boolean> uhdPlanIsCurrentPlanAdapter;
        private final TypeAdapter<String> uhdPlanPlanIdAdapter;
        private final TypeAdapter<String> uhdPlanPlanTierAdapter;
        private final TypeAdapter<String> uhdPlanPriceAdapter;
        private final TypeAdapter<String> uhdPlanTextAdapter;
        private final TypeAdapter<String> urlImage1Adapter;
        private final TypeAdapter<String> urlImage2Adapter;

        public GsonTypeAdapter(Gson gson) {
            this.abTestCellAdapter = gson.getAdapter(Integer.class);
            this.abTestIdAdapter = gson.getAdapter(Integer.class);
            this.localeAdapter = gson.getAdapter(String.class);
            this.messageNameAdapter = gson.getAdapter(String.class);
            this.templateIdAdapter = gson.getAdapter(String.class);
            this.titleAdapter = gson.getAdapter(String.class);
            this.bodyAdapter = gson.getAdapter(String.class);
            this.seeOtherPlansTextAdapter = gson.getAdapter(String.class);
            this.continueBtnTextAdapter = gson.getAdapter(String.class);
            this.currentPlanIdAdapter = gson.getAdapter(String.class);
            this.currentPlanTierAdapter = gson.getAdapter(String.class);
            this.skipBtnTextAdapter = gson.getAdapter(String.class);
            this.skipBtnImpressionTypeAdapter = gson.getAdapter(String.class);
            this.footerTextAdapter = gson.getAdapter(String.class);
            this.footerLinkTextAdapter = gson.getAdapter(String.class);
            this.footerSuffixAdapter = gson.getAdapter(String.class);
            this.selectPlanTextAdapter = gson.getAdapter(String.class);
            this.sdPlanTextAdapter = gson.getAdapter(String.class);
            this.sdPlanPriceAdapter = gson.getAdapter(String.class);
            this.sdPlanPlanIdAdapter = gson.getAdapter(String.class);
            this.sdPlanPlanTierAdapter = gson.getAdapter(String.class);
            this.sdPlanIsCurrentPlanAdapter = gson.getAdapter(Boolean.class);
            this.hdPlanTextAdapter = gson.getAdapter(String.class);
            this.hdPlanPriceAdapter = gson.getAdapter(String.class);
            this.hdPlanPlanIdAdapter = gson.getAdapter(String.class);
            this.hdPlanPlanTierAdapter = gson.getAdapter(String.class);
            this.hdPlanIsCurrentPlanAdapter = gson.getAdapter(Boolean.class);
            this.uhdPlanTextAdapter = gson.getAdapter(String.class);
            this.uhdPlanPriceAdapter = gson.getAdapter(String.class);
            this.uhdPlanPlanIdAdapter = gson.getAdapter(String.class);
            this.uhdPlanPlanTierAdapter = gson.getAdapter(String.class);
            this.uhdPlanIsCurrentPlanAdapter = gson.getAdapter(Boolean.class);
            this.disclaimerTextAdapter = gson.getAdapter(String.class);
            this.isBlockingAdapter = gson.getAdapter(Boolean.class);
            this.urlImage1Adapter = gson.getAdapter(String.class);
            this.urlImage2Adapter = gson.getAdapter(String.class);
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

        public GsonTypeAdapter setDefaultTemplateId(String str) {
            this.defaultTemplateId = str;
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

        public GsonTypeAdapter setDefaultSeeOtherPlansText(String str) {
            this.defaultSeeOtherPlansText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultContinueBtnText(String str) {
            this.defaultContinueBtnText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCurrentPlanId(String str) {
            this.defaultCurrentPlanId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultCurrentPlanTier(String str) {
            this.defaultCurrentPlanTier = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSkipBtnText(String str) {
            this.defaultSkipBtnText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSkipBtnImpressionType(String str) {
            this.defaultSkipBtnImpressionType = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFooterText(String str) {
            this.defaultFooterText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFooterLinkText(String str) {
            this.defaultFooterLinkText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultFooterSuffix(String str) {
            this.defaultFooterSuffix = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSelectPlanText(String str) {
            this.defaultSelectPlanText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSdPlanText(String str) {
            this.defaultSdPlanText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSdPlanPrice(String str) {
            this.defaultSdPlanPrice = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSdPlanPlanId(String str) {
            this.defaultSdPlanPlanId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSdPlanPlanTier(String str) {
            this.defaultSdPlanPlanTier = str;
            return this;
        }

        public GsonTypeAdapter setDefaultSdPlanIsCurrentPlan(boolean z) {
            this.defaultSdPlanIsCurrentPlan = z;
            return this;
        }

        public GsonTypeAdapter setDefaultHdPlanText(String str) {
            this.defaultHdPlanText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultHdPlanPrice(String str) {
            this.defaultHdPlanPrice = str;
            return this;
        }

        public GsonTypeAdapter setDefaultHdPlanPlanId(String str) {
            this.defaultHdPlanPlanId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultHdPlanPlanTier(String str) {
            this.defaultHdPlanPlanTier = str;
            return this;
        }

        public GsonTypeAdapter setDefaultHdPlanIsCurrentPlan(boolean z) {
            this.defaultHdPlanIsCurrentPlan = z;
            return this;
        }

        public GsonTypeAdapter setDefaultUhdPlanText(String str) {
            this.defaultUhdPlanText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUhdPlanPrice(String str) {
            this.defaultUhdPlanPrice = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUhdPlanPlanId(String str) {
            this.defaultUhdPlanPlanId = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUhdPlanPlanTier(String str) {
            this.defaultUhdPlanPlanTier = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUhdPlanIsCurrentPlan(boolean z) {
            this.defaultUhdPlanIsCurrentPlan = z;
            return this;
        }

        public GsonTypeAdapter setDefaultDisclaimerText(String str) {
            this.defaultDisclaimerText = str;
            return this;
        }

        public GsonTypeAdapter setDefaultIsBlocking(boolean z) {
            this.defaultIsBlocking = z;
            return this;
        }

        public GsonTypeAdapter setDefaultUrlImage1(String str) {
            this.defaultUrlImage1 = str;
            return this;
        }

        public GsonTypeAdapter setDefaultUrlImage2(String str) {
            this.defaultUrlImage2 = str;
            return this;
        }

        public void write(JsonWriter jsonWriter, EogAlert eogAlert) {
            if (eogAlert == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("abTestCell");
            this.abTestCellAdapter.write(jsonWriter, Integer.valueOf(eogAlert.abTestCell()));
            jsonWriter.name("abTestId");
            this.abTestIdAdapter.write(jsonWriter, Integer.valueOf(eogAlert.abTestId()));
            jsonWriter.name(LoggingRequest.LOCALE);
            this.localeAdapter.write(jsonWriter, eogAlert.locale());
            jsonWriter.name("messageName");
            this.messageNameAdapter.write(jsonWriter, eogAlert.messageName());
            jsonWriter.name("templateId");
            this.templateIdAdapter.write(jsonWriter, eogAlert.templateId());
            jsonWriter.name("title");
            this.titleAdapter.write(jsonWriter, eogAlert.title());
            jsonWriter.name("body");
            this.bodyAdapter.write(jsonWriter, eogAlert.body());
            jsonWriter.name("seeOtherPlansText");
            this.seeOtherPlansTextAdapter.write(jsonWriter, eogAlert.seeOtherPlansText());
            jsonWriter.name("continueBtnText");
            this.continueBtnTextAdapter.write(jsonWriter, eogAlert.continueBtnText());
            jsonWriter.name("currentPlanId");
            this.currentPlanIdAdapter.write(jsonWriter, eogAlert.currentPlanId());
            jsonWriter.name("currentPlanTier");
            this.currentPlanTierAdapter.write(jsonWriter, eogAlert.currentPlanTier());
            jsonWriter.name("skipBtnText");
            this.skipBtnTextAdapter.write(jsonWriter, eogAlert.skipBtnText());
            jsonWriter.name("skipBtnImpressionType");
            this.skipBtnImpressionTypeAdapter.write(jsonWriter, eogAlert.skipBtnImpressionType());
            jsonWriter.name("footerText");
            this.footerTextAdapter.write(jsonWriter, eogAlert.footerText());
            jsonWriter.name("footerLinkText");
            this.footerLinkTextAdapter.write(jsonWriter, eogAlert.footerLinkText());
            jsonWriter.name("footerSuffix");
            this.footerSuffixAdapter.write(jsonWriter, eogAlert.footerSuffix());
            jsonWriter.name("selectPlanText");
            this.selectPlanTextAdapter.write(jsonWriter, eogAlert.selectPlanText());
            jsonWriter.name("sdPlanText");
            this.sdPlanTextAdapter.write(jsonWriter, eogAlert.sdPlanText());
            jsonWriter.name("sdPlanPrice");
            this.sdPlanPriceAdapter.write(jsonWriter, eogAlert.sdPlanPrice());
            jsonWriter.name("sdPlanPlanId");
            this.sdPlanPlanIdAdapter.write(jsonWriter, eogAlert.sdPlanPlanId());
            jsonWriter.name("sdPlanPlanTier");
            this.sdPlanPlanTierAdapter.write(jsonWriter, eogAlert.sdPlanPlanTier());
            jsonWriter.name("sdPlanIsCurrentPlan");
            this.sdPlanIsCurrentPlanAdapter.write(jsonWriter, Boolean.valueOf(eogAlert.sdPlanIsCurrentPlan()));
            jsonWriter.name("hdPlanText");
            this.hdPlanTextAdapter.write(jsonWriter, eogAlert.hdPlanText());
            jsonWriter.name("hdPlanPrice");
            this.hdPlanPriceAdapter.write(jsonWriter, eogAlert.hdPlanPrice());
            jsonWriter.name("hdPlanPlanId");
            this.hdPlanPlanIdAdapter.write(jsonWriter, eogAlert.hdPlanPlanId());
            jsonWriter.name("hdPlanPlanTier");
            this.hdPlanPlanTierAdapter.write(jsonWriter, eogAlert.hdPlanPlanTier());
            jsonWriter.name("hdPlanIsCurrentPlan");
            this.hdPlanIsCurrentPlanAdapter.write(jsonWriter, Boolean.valueOf(eogAlert.hdPlanIsCurrentPlan()));
            jsonWriter.name("uhdPlanText");
            this.uhdPlanTextAdapter.write(jsonWriter, eogAlert.uhdPlanText());
            jsonWriter.name("uhdPlanPrice");
            this.uhdPlanPriceAdapter.write(jsonWriter, eogAlert.uhdPlanPrice());
            jsonWriter.name("uhdPlanPlanId");
            this.uhdPlanPlanIdAdapter.write(jsonWriter, eogAlert.uhdPlanPlanId());
            jsonWriter.name("uhdPlanPlanTier");
            this.uhdPlanPlanTierAdapter.write(jsonWriter, eogAlert.uhdPlanPlanTier());
            jsonWriter.name("uhdPlanIsCurrentPlan");
            this.uhdPlanIsCurrentPlanAdapter.write(jsonWriter, Boolean.valueOf(eogAlert.uhdPlanIsCurrentPlan()));
            jsonWriter.name("disclaimerText");
            this.disclaimerTextAdapter.write(jsonWriter, eogAlert.disclaimerText());
            jsonWriter.name("isBlocking");
            this.isBlockingAdapter.write(jsonWriter, Boolean.valueOf(eogAlert.isBlocking()));
            jsonWriter.name("urlImage1");
            this.urlImage1Adapter.write(jsonWriter, eogAlert.urlImage1());
            jsonWriter.name("urlImage2");
            this.urlImage2Adapter.write(jsonWriter, eogAlert.urlImage2());
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public EogAlert read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = this.defaultAbTestCell;
            int i2 = this.defaultAbTestId;
            String str = this.defaultLocale;
            String str2 = this.defaultMessageName;
            String str3 = this.defaultTemplateId;
            String str4 = this.defaultTitle;
            String str5 = this.defaultBody;
            String str6 = this.defaultSeeOtherPlansText;
            String str7 = this.defaultContinueBtnText;
            String str8 = this.defaultCurrentPlanId;
            String str9 = this.defaultCurrentPlanTier;
            String str10 = this.defaultSkipBtnText;
            String str11 = this.defaultSkipBtnImpressionType;
            String str12 = this.defaultFooterText;
            String str13 = this.defaultFooterLinkText;
            String str14 = this.defaultFooterSuffix;
            String str15 = this.defaultSelectPlanText;
            String str16 = this.defaultSdPlanText;
            String str17 = this.defaultSdPlanPrice;
            String str18 = this.defaultSdPlanPlanId;
            String str19 = this.defaultSdPlanPlanTier;
            boolean z = this.defaultSdPlanIsCurrentPlan;
            String str20 = this.defaultHdPlanText;
            String str21 = this.defaultHdPlanPrice;
            String str22 = this.defaultHdPlanPlanId;
            String str23 = this.defaultHdPlanPlanTier;
            boolean z2 = this.defaultHdPlanIsCurrentPlan;
            String str24 = this.defaultUhdPlanText;
            String str25 = this.defaultUhdPlanPrice;
            String str26 = this.defaultUhdPlanPlanId;
            String str27 = this.defaultUhdPlanPlanTier;
            boolean z3 = this.defaultUhdPlanIsCurrentPlan;
            String str28 = this.defaultDisclaimerText;
            boolean z4 = this.defaultIsBlocking;
            String str29 = this.defaultUrlImage1;
            String str30 = this.defaultUrlImage2;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    char c = 65535;
                    switch (nextName.hashCode()) {
                        case -2145429251:
                            if (nextName.equals("currentPlanId")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1840923675:
                            if (nextName.equals("sdPlanPlanTier")) {
                                c = 20;
                                break;
                            }
                            break;
                        case -1681113838:
                            if (nextName.equals("hdPlanText")) {
                                c = 22;
                                break;
                            }
                            break;
                        case -1543683650:
                            if (nextName.equals("sdPlanIsCurrentPlan")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -1474075374:
                            if (nextName.equals("selectPlanText")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -1471025337:
                            if (nextName.equals("uhdPlanText")) {
                                c = 27;
                                break;
                            }
                            break;
                        case -1457843329:
                            if (nextName.equals("isBlocking")) {
                                c = '!';
                                break;
                            }
                            break;
                        case -1432221730:
                            if (nextName.equals("uhdPlanIsCurrentPlan")) {
                                c = 31;
                                break;
                            }
                            break;
                        case -1350107350:
                            if (nextName.equals("skipBtnText")) {
                                c = 11;
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
                        case -844427661:
                            if (nextName.equals("hdPlanIsCurrentPlan")) {
                                c = 26;
                                break;
                            }
                            break;
                        case -751435575:
                            if (nextName.equals("hdPlanPlanId")) {
                                c = 24;
                                break;
                            }
                            break;
                        case -719849026:
                            if (nextName.equals("uhdPlanPlanId")) {
                                c = 29;
                                break;
                            }
                            break;
                        case -647251764:
                            if (nextName.equals("footerSuffix")) {
                                c = 15;
                                break;
                            }
                            break;
                        case -647158651:
                            if (nextName.equals("urlImage1")) {
                                c = '\"';
                                break;
                            }
                            break;
                        case -647158650:
                            if (nextName.equals("urlImage2")) {
                                c = '#';
                                break;
                            }
                            break;
                        case -578243068:
                            if (nextName.equals("hdPlanPrice")) {
                                c = 23;
                                break;
                            }
                            break;
                        case -574746096:
                            if (nextName.equals("hdPlanPlanTier")) {
                                c = 25;
                                break;
                            }
                            break;
                        case -540222718:
                            if (nextName.equals("continueBtnText")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -380556542:
                            if (nextName.equals("footerLinkText")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -284843579:
                            if (nextName.equals("uhdPlanPlanTier")) {
                                c = 30;
                                break;
                            }
                            break;
                        case -172872380:
                            if (nextName.equals("currentPlanTier")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 3029410:
                            if (nextName.equals("body")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 110371416:
                            if (nextName.equals("title")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 293496917:
                            if (nextName.equals("abTestCell")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 304471226:
                            if (nextName.equals("seeOtherPlansText")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 452204903:
                            if (nextName.equals("sdPlanText")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 668474334:
                            if (nextName.equals("sdPlanPlanId")) {
                                c = 19;
                                break;
                            }
                            break;
                        case 682813800:
                            if (nextName.equals("disclaimerText")) {
                                c = ' ';
                                break;
                            }
                            break;
                        case 801147552:
                            if (nextName.equals("skipBtnImpressionType")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 831589582:
                            if (nextName.equals("abTestId")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1130128463:
                            if (nextName.equals("sdPlanPrice")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 1304010549:
                            if (nextName.equals("templateId")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1420568936:
                            if (nextName.equals("footerText")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case 1639533167:
                            if (nextName.equals("uhdPlanPrice")) {
                                c = 28;
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
                            str3 = this.templateIdAdapter.read(jsonReader);
                            continue;
                        case 5:
                            str4 = this.titleAdapter.read(jsonReader);
                            continue;
                        case 6:
                            str5 = this.bodyAdapter.read(jsonReader);
                            continue;
                        case 7:
                            str6 = this.seeOtherPlansTextAdapter.read(jsonReader);
                            continue;
                        case '\b':
                            str7 = this.continueBtnTextAdapter.read(jsonReader);
                            continue;
                        case '\t':
                            str8 = this.currentPlanIdAdapter.read(jsonReader);
                            continue;
                        case '\n':
                            str9 = this.currentPlanTierAdapter.read(jsonReader);
                            continue;
                        case 11:
                            str10 = this.skipBtnTextAdapter.read(jsonReader);
                            continue;
                        case '\f':
                            str11 = this.skipBtnImpressionTypeAdapter.read(jsonReader);
                            continue;
                        case '\r':
                            str12 = this.footerTextAdapter.read(jsonReader);
                            continue;
                        case 14:
                            str13 = this.footerLinkTextAdapter.read(jsonReader);
                            continue;
                        case 15:
                            str14 = this.footerSuffixAdapter.read(jsonReader);
                            continue;
                        case 16:
                            str15 = this.selectPlanTextAdapter.read(jsonReader);
                            continue;
                        case 17:
                            str16 = this.sdPlanTextAdapter.read(jsonReader);
                            continue;
                        case 18:
                            str17 = this.sdPlanPriceAdapter.read(jsonReader);
                            continue;
                        case 19:
                            str18 = this.sdPlanPlanIdAdapter.read(jsonReader);
                            continue;
                        case 20:
                            str19 = this.sdPlanPlanTierAdapter.read(jsonReader);
                            continue;
                        case 21:
                            z = this.sdPlanIsCurrentPlanAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 22:
                            str20 = this.hdPlanTextAdapter.read(jsonReader);
                            continue;
                        case 23:
                            str21 = this.hdPlanPriceAdapter.read(jsonReader);
                            continue;
                        case 24:
                            str22 = this.hdPlanPlanIdAdapter.read(jsonReader);
                            continue;
                        case 25:
                            str23 = this.hdPlanPlanTierAdapter.read(jsonReader);
                            continue;
                        case 26:
                            z2 = this.hdPlanIsCurrentPlanAdapter.read(jsonReader).booleanValue();
                            continue;
                        case 27:
                            str24 = this.uhdPlanTextAdapter.read(jsonReader);
                            continue;
                        case 28:
                            str25 = this.uhdPlanPriceAdapter.read(jsonReader);
                            continue;
                        case 29:
                            str26 = this.uhdPlanPlanIdAdapter.read(jsonReader);
                            continue;
                        case 30:
                            str27 = this.uhdPlanPlanTierAdapter.read(jsonReader);
                            continue;
                        case 31:
                            z3 = this.uhdPlanIsCurrentPlanAdapter.read(jsonReader).booleanValue();
                            continue;
                        case ' ':
                            str28 = this.disclaimerTextAdapter.read(jsonReader);
                            continue;
                        case '!':
                            z4 = this.isBlockingAdapter.read(jsonReader).booleanValue();
                            continue;
                        case '\"':
                            str29 = this.urlImage1Adapter.read(jsonReader);
                            continue;
                        case '#':
                            str30 = this.urlImage2Adapter.read(jsonReader);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_EogAlert(i, i2, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, z, str20, str21, str22, str23, z2, str24, str25, str26, str27, z3, str28, z4, str29, str30);
        }
    }
}
