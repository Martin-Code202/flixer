package com.netflix.mediaclient.service.logging.logblob;
public enum LogBlobType {
    OFFLINE_CDN_URL_DOWNLOAD("offlinedlreport"),
    OFFLINE_LOGBLOB_TYPE("offline"),
    MDX_LOGBLOB_TYPE("mdx"),
    NETWORK_DIAGNOSIS("NetworkDiagnostics"),
    MAINTENANCE_JOB("maintenance"),
    FTL_SESSION("ftlsession"),
    CRONET_DISABLED("cronet_disabled"),
    FTL_RECOVERY("ftlerror");
    

    /* renamed from: ʽ  reason: contains not printable characters */
    private final String f1173;

    private LogBlobType(String str) {
        this.f1173 = str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m602() {
        return this.f1173;
    }
}
