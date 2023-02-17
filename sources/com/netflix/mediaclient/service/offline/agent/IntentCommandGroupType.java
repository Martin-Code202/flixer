package com.netflix.mediaclient.service.offline.agent;

import android.content.Intent;
public enum IntentCommandGroupType {
    Unknown(-1),
    DownloadNotification(1);
    

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f1529;

    private IntentCommandGroupType(int i) {
        this.f1529 = i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private int m820() {
        return this.f1529;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static IntentCommandGroupType m818(int i) {
        IntentCommandGroupType[] values = values();
        for (IntentCommandGroupType intentCommandGroupType : values) {
            if (intentCommandGroupType.m820() == i) {
                return intentCommandGroupType;
            }
        }
        return Unknown;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m821(Intent intent, IntentCommandGroupType intentCommandGroupType) {
        intent.putExtra("of_intent_group_type", intentCommandGroupType.m820());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static IntentCommandGroupType m819(Intent intent) {
        return m818(intent.getIntExtra("of_intent_group_type", Unknown.f1529));
    }
}
