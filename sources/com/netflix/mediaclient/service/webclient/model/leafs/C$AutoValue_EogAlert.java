package com.netflix.mediaclient.service.webclient.model.leafs;
/* renamed from: com.netflix.mediaclient.service.webclient.model.leafs.$AutoValue_EogAlert  reason: invalid class name */
abstract class C$AutoValue_EogAlert extends EogAlert {
    private final int abTestCell;
    private final int abTestId;
    private final String body;
    private final String continueBtnText;
    private final String currentPlanId;
    private final String currentPlanTier;
    private final String disclaimerText;
    private final String footerLinkText;
    private final String footerSuffix;
    private final String footerText;
    private final boolean hdPlanIsCurrentPlan;
    private final String hdPlanPlanId;
    private final String hdPlanPlanTier;
    private final String hdPlanPrice;
    private final String hdPlanText;
    private final boolean isBlocking;
    private final String locale;
    private final String messageName;
    private final boolean sdPlanIsCurrentPlan;
    private final String sdPlanPlanId;
    private final String sdPlanPlanTier;
    private final String sdPlanPrice;
    private final String sdPlanText;
    private final String seeOtherPlansText;
    private final String selectPlanText;
    private final String skipBtnImpressionType;
    private final String skipBtnText;
    private final String templateId;
    private final String title;
    private final boolean uhdPlanIsCurrentPlan;
    private final String uhdPlanPlanId;
    private final String uhdPlanPlanTier;
    private final String uhdPlanPrice;
    private final String uhdPlanText;
    private final String urlImage1;
    private final String urlImage2;

    C$AutoValue_EogAlert(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, boolean z, String str20, String str21, String str22, String str23, boolean z2, String str24, String str25, String str26, String str27, boolean z3, String str28, boolean z4, String str29, String str30) {
        this.abTestCell = i;
        this.abTestId = i2;
        this.locale = str;
        this.messageName = str2;
        this.templateId = str3;
        this.title = str4;
        this.body = str5;
        this.seeOtherPlansText = str6;
        this.continueBtnText = str7;
        this.currentPlanId = str8;
        this.currentPlanTier = str9;
        this.skipBtnText = str10;
        this.skipBtnImpressionType = str11;
        this.footerText = str12;
        this.footerLinkText = str13;
        this.footerSuffix = str14;
        this.selectPlanText = str15;
        this.sdPlanText = str16;
        this.sdPlanPrice = str17;
        this.sdPlanPlanId = str18;
        this.sdPlanPlanTier = str19;
        this.sdPlanIsCurrentPlan = z;
        this.hdPlanText = str20;
        this.hdPlanPrice = str21;
        this.hdPlanPlanId = str22;
        this.hdPlanPlanTier = str23;
        this.hdPlanIsCurrentPlan = z2;
        this.uhdPlanText = str24;
        this.uhdPlanPrice = str25;
        this.uhdPlanPlanId = str26;
        this.uhdPlanPlanTier = str27;
        this.uhdPlanIsCurrentPlan = z3;
        this.disclaimerText = str28;
        this.isBlocking = z4;
        this.urlImage1 = str29;
        this.urlImage2 = str30;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public int abTestCell() {
        return this.abTestCell;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public int abTestId() {
        return this.abTestId;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String locale() {
        return this.locale;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String messageName() {
        return this.messageName;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String templateId() {
        return this.templateId;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String title() {
        return this.title;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String body() {
        return this.body;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String seeOtherPlansText() {
        return this.seeOtherPlansText;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String continueBtnText() {
        return this.continueBtnText;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String currentPlanId() {
        return this.currentPlanId;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String currentPlanTier() {
        return this.currentPlanTier;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String skipBtnText() {
        return this.skipBtnText;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String skipBtnImpressionType() {
        return this.skipBtnImpressionType;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String footerText() {
        return this.footerText;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String footerLinkText() {
        return this.footerLinkText;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String footerSuffix() {
        return this.footerSuffix;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String selectPlanText() {
        return this.selectPlanText;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String sdPlanText() {
        return this.sdPlanText;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String sdPlanPrice() {
        return this.sdPlanPrice;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String sdPlanPlanId() {
        return this.sdPlanPlanId;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String sdPlanPlanTier() {
        return this.sdPlanPlanTier;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public boolean sdPlanIsCurrentPlan() {
        return this.sdPlanIsCurrentPlan;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String hdPlanText() {
        return this.hdPlanText;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String hdPlanPrice() {
        return this.hdPlanPrice;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String hdPlanPlanId() {
        return this.hdPlanPlanId;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String hdPlanPlanTier() {
        return this.hdPlanPlanTier;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public boolean hdPlanIsCurrentPlan() {
        return this.hdPlanIsCurrentPlan;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String uhdPlanText() {
        return this.uhdPlanText;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String uhdPlanPrice() {
        return this.uhdPlanPrice;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String uhdPlanPlanId() {
        return this.uhdPlanPlanId;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String uhdPlanPlanTier() {
        return this.uhdPlanPlanTier;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public boolean uhdPlanIsCurrentPlan() {
        return this.uhdPlanIsCurrentPlan;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String disclaimerText() {
        return this.disclaimerText;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public boolean isBlocking() {
        return this.isBlocking;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String urlImage1() {
        return this.urlImage1;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.EogAlert
    public String urlImage2() {
        return this.urlImage2;
    }

    public String toString() {
        return "EogAlert{abTestCell=" + this.abTestCell + ", abTestId=" + this.abTestId + ", locale=" + this.locale + ", messageName=" + this.messageName + ", templateId=" + this.templateId + ", title=" + this.title + ", body=" + this.body + ", seeOtherPlansText=" + this.seeOtherPlansText + ", continueBtnText=" + this.continueBtnText + ", currentPlanId=" + this.currentPlanId + ", currentPlanTier=" + this.currentPlanTier + ", skipBtnText=" + this.skipBtnText + ", skipBtnImpressionType=" + this.skipBtnImpressionType + ", footerText=" + this.footerText + ", footerLinkText=" + this.footerLinkText + ", footerSuffix=" + this.footerSuffix + ", selectPlanText=" + this.selectPlanText + ", sdPlanText=" + this.sdPlanText + ", sdPlanPrice=" + this.sdPlanPrice + ", sdPlanPlanId=" + this.sdPlanPlanId + ", sdPlanPlanTier=" + this.sdPlanPlanTier + ", sdPlanIsCurrentPlan=" + this.sdPlanIsCurrentPlan + ", hdPlanText=" + this.hdPlanText + ", hdPlanPrice=" + this.hdPlanPrice + ", hdPlanPlanId=" + this.hdPlanPlanId + ", hdPlanPlanTier=" + this.hdPlanPlanTier + ", hdPlanIsCurrentPlan=" + this.hdPlanIsCurrentPlan + ", uhdPlanText=" + this.uhdPlanText + ", uhdPlanPrice=" + this.uhdPlanPrice + ", uhdPlanPlanId=" + this.uhdPlanPlanId + ", uhdPlanPlanTier=" + this.uhdPlanPlanTier + ", uhdPlanIsCurrentPlan=" + this.uhdPlanIsCurrentPlan + ", disclaimerText=" + this.disclaimerText + ", isBlocking=" + this.isBlocking + ", urlImage1=" + this.urlImage1 + ", urlImage2=" + this.urlImage2 + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EogAlert)) {
            return false;
        }
        EogAlert eogAlert = (EogAlert) obj;
        return this.abTestCell == eogAlert.abTestCell() && this.abTestId == eogAlert.abTestId() && (this.locale != null ? this.locale.equals(eogAlert.locale()) : eogAlert.locale() == null) && (this.messageName != null ? this.messageName.equals(eogAlert.messageName()) : eogAlert.messageName() == null) && (this.templateId != null ? this.templateId.equals(eogAlert.templateId()) : eogAlert.templateId() == null) && (this.title != null ? this.title.equals(eogAlert.title()) : eogAlert.title() == null) && (this.body != null ? this.body.equals(eogAlert.body()) : eogAlert.body() == null) && (this.seeOtherPlansText != null ? this.seeOtherPlansText.equals(eogAlert.seeOtherPlansText()) : eogAlert.seeOtherPlansText() == null) && (this.continueBtnText != null ? this.continueBtnText.equals(eogAlert.continueBtnText()) : eogAlert.continueBtnText() == null) && (this.currentPlanId != null ? this.currentPlanId.equals(eogAlert.currentPlanId()) : eogAlert.currentPlanId() == null) && (this.currentPlanTier != null ? this.currentPlanTier.equals(eogAlert.currentPlanTier()) : eogAlert.currentPlanTier() == null) && (this.skipBtnText != null ? this.skipBtnText.equals(eogAlert.skipBtnText()) : eogAlert.skipBtnText() == null) && (this.skipBtnImpressionType != null ? this.skipBtnImpressionType.equals(eogAlert.skipBtnImpressionType()) : eogAlert.skipBtnImpressionType() == null) && (this.footerText != null ? this.footerText.equals(eogAlert.footerText()) : eogAlert.footerText() == null) && (this.footerLinkText != null ? this.footerLinkText.equals(eogAlert.footerLinkText()) : eogAlert.footerLinkText() == null) && (this.footerSuffix != null ? this.footerSuffix.equals(eogAlert.footerSuffix()) : eogAlert.footerSuffix() == null) && (this.selectPlanText != null ? this.selectPlanText.equals(eogAlert.selectPlanText()) : eogAlert.selectPlanText() == null) && (this.sdPlanText != null ? this.sdPlanText.equals(eogAlert.sdPlanText()) : eogAlert.sdPlanText() == null) && (this.sdPlanPrice != null ? this.sdPlanPrice.equals(eogAlert.sdPlanPrice()) : eogAlert.sdPlanPrice() == null) && (this.sdPlanPlanId != null ? this.sdPlanPlanId.equals(eogAlert.sdPlanPlanId()) : eogAlert.sdPlanPlanId() == null) && (this.sdPlanPlanTier != null ? this.sdPlanPlanTier.equals(eogAlert.sdPlanPlanTier()) : eogAlert.sdPlanPlanTier() == null) && this.sdPlanIsCurrentPlan == eogAlert.sdPlanIsCurrentPlan() && (this.hdPlanText != null ? this.hdPlanText.equals(eogAlert.hdPlanText()) : eogAlert.hdPlanText() == null) && (this.hdPlanPrice != null ? this.hdPlanPrice.equals(eogAlert.hdPlanPrice()) : eogAlert.hdPlanPrice() == null) && (this.hdPlanPlanId != null ? this.hdPlanPlanId.equals(eogAlert.hdPlanPlanId()) : eogAlert.hdPlanPlanId() == null) && (this.hdPlanPlanTier != null ? this.hdPlanPlanTier.equals(eogAlert.hdPlanPlanTier()) : eogAlert.hdPlanPlanTier() == null) && this.hdPlanIsCurrentPlan == eogAlert.hdPlanIsCurrentPlan() && (this.uhdPlanText != null ? this.uhdPlanText.equals(eogAlert.uhdPlanText()) : eogAlert.uhdPlanText() == null) && (this.uhdPlanPrice != null ? this.uhdPlanPrice.equals(eogAlert.uhdPlanPrice()) : eogAlert.uhdPlanPrice() == null) && (this.uhdPlanPlanId != null ? this.uhdPlanPlanId.equals(eogAlert.uhdPlanPlanId()) : eogAlert.uhdPlanPlanId() == null) && (this.uhdPlanPlanTier != null ? this.uhdPlanPlanTier.equals(eogAlert.uhdPlanPlanTier()) : eogAlert.uhdPlanPlanTier() == null) && this.uhdPlanIsCurrentPlan == eogAlert.uhdPlanIsCurrentPlan() && (this.disclaimerText != null ? this.disclaimerText.equals(eogAlert.disclaimerText()) : eogAlert.disclaimerText() == null) && this.isBlocking == eogAlert.isBlocking() && (this.urlImage1 != null ? this.urlImage1.equals(eogAlert.urlImage1()) : eogAlert.urlImage1() == null) && (this.urlImage2 != null ? this.urlImage2.equals(eogAlert.urlImage2()) : eogAlert.urlImage2() == null);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((1000003 ^ this.abTestCell) * 1000003) ^ this.abTestId) * 1000003) ^ (this.locale == null ? 0 : this.locale.hashCode())) * 1000003) ^ (this.messageName == null ? 0 : this.messageName.hashCode())) * 1000003) ^ (this.templateId == null ? 0 : this.templateId.hashCode())) * 1000003) ^ (this.title == null ? 0 : this.title.hashCode())) * 1000003) ^ (this.body == null ? 0 : this.body.hashCode())) * 1000003) ^ (this.seeOtherPlansText == null ? 0 : this.seeOtherPlansText.hashCode())) * 1000003) ^ (this.continueBtnText == null ? 0 : this.continueBtnText.hashCode())) * 1000003) ^ (this.currentPlanId == null ? 0 : this.currentPlanId.hashCode())) * 1000003) ^ (this.currentPlanTier == null ? 0 : this.currentPlanTier.hashCode())) * 1000003) ^ (this.skipBtnText == null ? 0 : this.skipBtnText.hashCode())) * 1000003) ^ (this.skipBtnImpressionType == null ? 0 : this.skipBtnImpressionType.hashCode())) * 1000003) ^ (this.footerText == null ? 0 : this.footerText.hashCode())) * 1000003) ^ (this.footerLinkText == null ? 0 : this.footerLinkText.hashCode())) * 1000003) ^ (this.footerSuffix == null ? 0 : this.footerSuffix.hashCode())) * 1000003) ^ (this.selectPlanText == null ? 0 : this.selectPlanText.hashCode())) * 1000003) ^ (this.sdPlanText == null ? 0 : this.sdPlanText.hashCode())) * 1000003) ^ (this.sdPlanPrice == null ? 0 : this.sdPlanPrice.hashCode())) * 1000003) ^ (this.sdPlanPlanId == null ? 0 : this.sdPlanPlanId.hashCode())) * 1000003) ^ (this.sdPlanPlanTier == null ? 0 : this.sdPlanPlanTier.hashCode())) * 1000003) ^ (this.sdPlanIsCurrentPlan ? 1231 : 1237)) * 1000003) ^ (this.hdPlanText == null ? 0 : this.hdPlanText.hashCode())) * 1000003) ^ (this.hdPlanPrice == null ? 0 : this.hdPlanPrice.hashCode())) * 1000003) ^ (this.hdPlanPlanId == null ? 0 : this.hdPlanPlanId.hashCode())) * 1000003) ^ (this.hdPlanPlanTier == null ? 0 : this.hdPlanPlanTier.hashCode())) * 1000003) ^ (this.hdPlanIsCurrentPlan ? 1231 : 1237)) * 1000003) ^ (this.uhdPlanText == null ? 0 : this.uhdPlanText.hashCode())) * 1000003) ^ (this.uhdPlanPrice == null ? 0 : this.uhdPlanPrice.hashCode())) * 1000003) ^ (this.uhdPlanPlanId == null ? 0 : this.uhdPlanPlanId.hashCode())) * 1000003) ^ (this.uhdPlanPlanTier == null ? 0 : this.uhdPlanPlanTier.hashCode())) * 1000003) ^ (this.uhdPlanIsCurrentPlan ? 1231 : 1237)) * 1000003) ^ (this.disclaimerText == null ? 0 : this.disclaimerText.hashCode())) * 1000003) ^ (this.isBlocking ? 1231 : 1237)) * 1000003) ^ (this.urlImage1 == null ? 0 : this.urlImage1.hashCode())) * 1000003) ^ (this.urlImage2 == null ? 0 : this.urlImage2.hashCode());
    }
}
