package com.netflix.mediaclient.service.preapp;
public enum PreAppAgentEventType {
    ALL_MEMBER_UPDATED,
    CW_UPDATED,
    IQ_UPDATED,
    NON_MEMBER_UPDATED,
    ACCOUNT_DEACTIVATED;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m1184(PreAppAgentEventType preAppAgentEventType) {
        return ALL_MEMBER_UPDATED.equals(preAppAgentEventType);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m1182(PreAppAgentEventType preAppAgentEventType) {
        return NON_MEMBER_UPDATED.equals(preAppAgentEventType);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m1185(PreAppAgentEventType preAppAgentEventType) {
        return ALL_MEMBER_UPDATED.equals(preAppAgentEventType);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m1183(PreAppAgentEventType preAppAgentEventType) {
        return ALL_MEMBER_UPDATED.equals(preAppAgentEventType);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m1181(PreAppAgentEventType preAppAgentEventType) {
        return CW_UPDATED.equals(preAppAgentEventType) || ALL_MEMBER_UPDATED.equals(preAppAgentEventType);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static boolean m1187(PreAppAgentEventType preAppAgentEventType) {
        return IQ_UPDATED.equals(preAppAgentEventType) || ALL_MEMBER_UPDATED.equals(preAppAgentEventType);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static boolean m1186(PreAppAgentEventType preAppAgentEventType) {
        return ACCOUNT_DEACTIVATED.equals(preAppAgentEventType);
    }
}
