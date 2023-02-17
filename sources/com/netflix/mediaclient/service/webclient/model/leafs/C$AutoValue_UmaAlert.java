package com.netflix.mediaclient.service.webclient.model.leafs;
/* renamed from: com.netflix.mediaclient.service.webclient.model.leafs.$AutoValue_UmaAlert  reason: invalid class name */
abstract class C$AutoValue_UmaAlert extends UmaAlert {
    private final int abTestCell;
    private final int abTestId;
    private final String backgroundAction;
    private final boolean bannerAlert;
    private final boolean blocking;
    private final String body;
    private final UmaCta cta1;
    private final UmaCta cta2;
    private final String locale;
    private final long messageId;
    private final String messageName;
    private final boolean modalAlert;
    private final boolean showOnBackgroundActionSuccess;
    private final boolean suppressForBackgroundAction;
    private final boolean suppressOnAppLaunch;
    private final long timestamp;
    private final String title;
    private final String trackingInfo;
    private final String umsAlertRenderFeedback;
    private final String viewType;

    C$AutoValue_UmaAlert(int i, int i2, String str, String str2, long j, String str3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str4, String str5, String str6, UmaCta umaCta, UmaCta umaCta2, String str7, String str8, long j2) {
        this.abTestCell = i;
        this.abTestId = i2;
        this.locale = str;
        this.messageName = str2;
        this.messageId = j;
        this.viewType = str3;
        this.blocking = z;
        this.modalAlert = z2;
        this.bannerAlert = z3;
        this.suppressOnAppLaunch = z4;
        this.suppressForBackgroundAction = z5;
        this.showOnBackgroundActionSuccess = z6;
        this.backgroundAction = str4;
        this.title = str5;
        this.body = str6;
        this.cta1 = umaCta;
        this.cta2 = umaCta2;
        this.trackingInfo = str7;
        this.umsAlertRenderFeedback = str8;
        this.timestamp = j2;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public int abTestCell() {
        return this.abTestCell;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public int abTestId() {
        return this.abTestId;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public String locale() {
        return this.locale;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public String messageName() {
        return this.messageName;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public long messageId() {
        return this.messageId;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public String viewType() {
        return this.viewType;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public boolean blocking() {
        return this.blocking;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public boolean modalAlert() {
        return this.modalAlert;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public boolean bannerAlert() {
        return this.bannerAlert;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public boolean suppressOnAppLaunch() {
        return this.suppressOnAppLaunch;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public boolean suppressForBackgroundAction() {
        return this.suppressForBackgroundAction;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public boolean showOnBackgroundActionSuccess() {
        return this.showOnBackgroundActionSuccess;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public String backgroundAction() {
        return this.backgroundAction;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public String title() {
        return this.title;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public String body() {
        return this.body;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public UmaCta cta1() {
        return this.cta1;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public UmaCta cta2() {
        return this.cta2;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public String trackingInfo() {
        return this.trackingInfo;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public String umsAlertRenderFeedback() {
        return this.umsAlertRenderFeedback;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert
    public long timestamp() {
        return this.timestamp;
    }

    public String toString() {
        return "UmaAlert{abTestCell=" + this.abTestCell + ", abTestId=" + this.abTestId + ", locale=" + this.locale + ", messageName=" + this.messageName + ", messageId=" + this.messageId + ", viewType=" + this.viewType + ", blocking=" + this.blocking + ", modalAlert=" + this.modalAlert + ", bannerAlert=" + this.bannerAlert + ", suppressOnAppLaunch=" + this.suppressOnAppLaunch + ", suppressForBackgroundAction=" + this.suppressForBackgroundAction + ", showOnBackgroundActionSuccess=" + this.showOnBackgroundActionSuccess + ", backgroundAction=" + this.backgroundAction + ", title=" + this.title + ", body=" + this.body + ", cta1=" + this.cta1 + ", cta2=" + this.cta2 + ", trackingInfo=" + this.trackingInfo + ", umsAlertRenderFeedback=" + this.umsAlertRenderFeedback + ", timestamp=" + this.timestamp + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UmaAlert)) {
            return false;
        }
        UmaAlert umaAlert = (UmaAlert) obj;
        return this.abTestCell == umaAlert.abTestCell() && this.abTestId == umaAlert.abTestId() && (this.locale != null ? this.locale.equals(umaAlert.locale()) : umaAlert.locale() == null) && (this.messageName != null ? this.messageName.equals(umaAlert.messageName()) : umaAlert.messageName() == null) && this.messageId == umaAlert.messageId() && (this.viewType != null ? this.viewType.equals(umaAlert.viewType()) : umaAlert.viewType() == null) && this.blocking == umaAlert.blocking() && this.modalAlert == umaAlert.modalAlert() && this.bannerAlert == umaAlert.bannerAlert() && this.suppressOnAppLaunch == umaAlert.suppressOnAppLaunch() && this.suppressForBackgroundAction == umaAlert.suppressForBackgroundAction() && this.showOnBackgroundActionSuccess == umaAlert.showOnBackgroundActionSuccess() && (this.backgroundAction != null ? this.backgroundAction.equals(umaAlert.backgroundAction()) : umaAlert.backgroundAction() == null) && (this.title != null ? this.title.equals(umaAlert.title()) : umaAlert.title() == null) && (this.body != null ? this.body.equals(umaAlert.body()) : umaAlert.body() == null) && (this.cta1 != null ? this.cta1.equals(umaAlert.cta1()) : umaAlert.cta1() == null) && (this.cta2 != null ? this.cta2.equals(umaAlert.cta2()) : umaAlert.cta2() == null) && (this.trackingInfo != null ? this.trackingInfo.equals(umaAlert.trackingInfo()) : umaAlert.trackingInfo() == null) && (this.umsAlertRenderFeedback != null ? this.umsAlertRenderFeedback.equals(umaAlert.umsAlertRenderFeedback()) : umaAlert.umsAlertRenderFeedback() == null) && this.timestamp == umaAlert.timestamp();
    }

    public int hashCode() {
        return (int) (((long) (((((((((((((((((((((((((((((((int) (((long) ((((((((1000003 ^ this.abTestCell) * 1000003) ^ this.abTestId) * 1000003) ^ (this.locale == null ? 0 : this.locale.hashCode())) * 1000003) ^ (this.messageName == null ? 0 : this.messageName.hashCode())) * 1000003)) ^ ((this.messageId >>> 32) ^ this.messageId))) * 1000003) ^ (this.viewType == null ? 0 : this.viewType.hashCode())) * 1000003) ^ (this.blocking ? 1231 : 1237)) * 1000003) ^ (this.modalAlert ? 1231 : 1237)) * 1000003) ^ (this.bannerAlert ? 1231 : 1237)) * 1000003) ^ (this.suppressOnAppLaunch ? 1231 : 1237)) * 1000003) ^ (this.suppressForBackgroundAction ? 1231 : 1237)) * 1000003) ^ (this.showOnBackgroundActionSuccess ? 1231 : 1237)) * 1000003) ^ (this.backgroundAction == null ? 0 : this.backgroundAction.hashCode())) * 1000003) ^ (this.title == null ? 0 : this.title.hashCode())) * 1000003) ^ (this.body == null ? 0 : this.body.hashCode())) * 1000003) ^ (this.cta1 == null ? 0 : this.cta1.hashCode())) * 1000003) ^ (this.cta2 == null ? 0 : this.cta2.hashCode())) * 1000003) ^ (this.trackingInfo == null ? 0 : this.trackingInfo.hashCode())) * 1000003) ^ (this.umsAlertRenderFeedback == null ? 0 : this.umsAlertRenderFeedback.hashCode())) * 1000003)) ^ ((this.timestamp >>> 32) ^ this.timestamp));
    }
}
