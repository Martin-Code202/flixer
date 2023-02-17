package com.netflix.mediaclient.servicemgr;

import o.C1349Bv;
public interface ISubtitleDef {

    public enum SubtitleFailure {
        download,
        dnsResolution,
        parsing,
        parsingCachedMasterIndex,
        badMasterIndex,
        timedOut
    }

    public enum SubtitleProfile {
        SIMPLE(0, "simplesdh", false),
        ENHANCED(1, "dfxp-ls-sdh", false),
        IMAGE(2, "nflx-cmisc", false),
        SIMPLE_ENC(3, "simplesdh-enc", true),
        ENHANCED_ENC(4, "dfxp-ls-sdh-enc", true),
        IMAGE_ENC(5, "nflx-cmisc-enc", true);
        

        /* renamed from: ʻ  reason: contains not printable characters */
        private final boolean f2610;

        /* renamed from: ʼ  reason: contains not printable characters */
        private final String f2611;

        /* renamed from: ʽ  reason: contains not printable characters */
        private final int f2612;

        private SubtitleProfile(int i, String str, boolean z) {
            this.f2612 = i;
            this.f2611 = str;
            this.f2610 = z;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final int m1535() {
            return this.f2612;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m1536() {
            return this.f2611;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static SubtitleProfile m1534(String str) {
            if (C1349Bv.m4113(str)) {
                return SIMPLE;
            }
            String trim = str.trim();
            SubtitleProfile[] values = values();
            for (SubtitleProfile subtitleProfile : values) {
                if (subtitleProfile.m1536().equalsIgnoreCase(trim)) {
                    return subtitleProfile;
                }
            }
            return SIMPLE;
        }
    }
}
