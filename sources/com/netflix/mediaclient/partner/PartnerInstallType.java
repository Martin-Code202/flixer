package com.netflix.mediaclient.partner;

import o.C1349Bv;
public final class PartnerInstallType {

    public enum InstallType {
        PRELAOD("preload"),
        POSTLOAD("postload"),
        REGULAR("regular");
        

        /* renamed from: ˊ  reason: contains not printable characters */
        private final String f1039;

        private InstallType(String str) {
            this.f1039 = str;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public String m483() {
            return this.f1039;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static InstallType m481(boolean z, boolean z2) {
        if (z) {
            return InstallType.PRELAOD;
        }
        if (z2) {
            return InstallType.POSTLOAD;
        }
        return InstallType.REGULAR;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m482(String str) {
        return !C1349Bv.m4113(str) && !C1349Bv.m4126(str, InstallType.REGULAR.m483());
    }
}
