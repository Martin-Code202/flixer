package com.netflix.mediaclient.service.webclient.model.leafs;
/* renamed from: com.netflix.mediaclient.service.webclient.model.leafs.$AutoValue_UmaCta  reason: invalid class name */
abstract class C$AutoValue_UmaCta extends UmaCta {
    private final String action;
    private final String actionType;
    private final boolean autoLogin;
    private final String callback;
    private final String failureMessage;
    private final boolean openLinkInWebView;
    private final boolean selected;
    private final String successMessage;
    private final String text;
    private final String trackingInfo;
    private final String umsAlertCtaFeedback;

    C$AutoValue_UmaCta(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, boolean z3) {
        this.text = str;
        this.action = str2;
        this.actionType = str3;
        this.callback = str4;
        this.trackingInfo = str5;
        this.successMessage = str6;
        this.failureMessage = str7;
        this.umsAlertCtaFeedback = str8;
        this.selected = z;
        this.autoLogin = z2;
        this.openLinkInWebView = z3;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaCta
    public String text() {
        return this.text;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaCta
    public String action() {
        return this.action;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaCta
    public String actionType() {
        return this.actionType;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaCta
    public String callback() {
        return this.callback;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaCta
    public String trackingInfo() {
        return this.trackingInfo;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaCta
    public String successMessage() {
        return this.successMessage;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaCta
    public String failureMessage() {
        return this.failureMessage;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaCta
    public String umsAlertCtaFeedback() {
        return this.umsAlertCtaFeedback;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaCta
    public boolean selected() {
        return this.selected;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaCta
    public boolean autoLogin() {
        return this.autoLogin;
    }

    @Override // com.netflix.mediaclient.service.webclient.model.leafs.UmaCta
    public boolean openLinkInWebView() {
        return this.openLinkInWebView;
    }

    public String toString() {
        return "UmaCta{text=" + this.text + ", action=" + this.action + ", actionType=" + this.actionType + ", callback=" + this.callback + ", trackingInfo=" + this.trackingInfo + ", successMessage=" + this.successMessage + ", failureMessage=" + this.failureMessage + ", umsAlertCtaFeedback=" + this.umsAlertCtaFeedback + ", selected=" + this.selected + ", autoLogin=" + this.autoLogin + ", openLinkInWebView=" + this.openLinkInWebView + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UmaCta)) {
            return false;
        }
        UmaCta umaCta = (UmaCta) obj;
        if (this.text != null ? this.text.equals(umaCta.text()) : umaCta.text() == null) {
            if (this.action != null ? this.action.equals(umaCta.action()) : umaCta.action() == null) {
                if (this.actionType != null ? this.actionType.equals(umaCta.actionType()) : umaCta.actionType() == null) {
                    if (this.callback != null ? this.callback.equals(umaCta.callback()) : umaCta.callback() == null) {
                        if (this.trackingInfo != null ? this.trackingInfo.equals(umaCta.trackingInfo()) : umaCta.trackingInfo() == null) {
                            if (this.successMessage != null ? this.successMessage.equals(umaCta.successMessage()) : umaCta.successMessage() == null) {
                                if (this.failureMessage != null ? this.failureMessage.equals(umaCta.failureMessage()) : umaCta.failureMessage() == null) {
                                    if (this.umsAlertCtaFeedback != null ? this.umsAlertCtaFeedback.equals(umaCta.umsAlertCtaFeedback()) : umaCta.umsAlertCtaFeedback() == null) {
                                        if (this.selected == umaCta.selected() && this.autoLogin == umaCta.autoLogin() && this.openLinkInWebView == umaCta.openLinkInWebView()) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((1000003 ^ (this.text == null ? 0 : this.text.hashCode())) * 1000003) ^ (this.action == null ? 0 : this.action.hashCode())) * 1000003) ^ (this.actionType == null ? 0 : this.actionType.hashCode())) * 1000003) ^ (this.callback == null ? 0 : this.callback.hashCode())) * 1000003) ^ (this.trackingInfo == null ? 0 : this.trackingInfo.hashCode())) * 1000003) ^ (this.successMessage == null ? 0 : this.successMessage.hashCode())) * 1000003) ^ (this.failureMessage == null ? 0 : this.failureMessage.hashCode())) * 1000003) ^ (this.umsAlertCtaFeedback == null ? 0 : this.umsAlertCtaFeedback.hashCode())) * 1000003) ^ (this.selected ? 1231 : 1237)) * 1000003) ^ (this.autoLogin ? 1231 : 1237)) * 1000003) ^ (this.openLinkInWebView ? 1231 : 1237);
    }
}
