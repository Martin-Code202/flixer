package com.netflix.mediaclient.service.webclient.model.leafs;

import java.util.Map;
import o.C1456Fq;
import o.C1457Fr;
public final class AUIContextData {
    public static final Companion Companion = new Companion(null);
    private static final String GEO_KEY = GEO_KEY;
    private static final String USERINFO_KEY = USERINFO_KEY;
    private final String TAG = "nf_aui_context";
    private final Map<String, ?> geo;
    private final Map<String, ?> userInfo;

    public static final String getGEO_KEY() {
        return Companion.getGEO_KEY();
    }

    public static final String getUSERINFO_KEY() {
        return Companion.getUSERINFO_KEY();
    }

    public AUIContextData(Map<String, ?> map, Map<String, ?> map2) {
        C1457Fr.m5025(map, GEO_KEY);
        C1457Fr.m5025(map2, USERINFO_KEY);
        this.geo = map;
        this.userInfo = map2;
    }

    public final Map<String, ?> getGeo() {
        return this.geo;
    }

    public final Map<String, ?> getUserInfo() {
        return this.userInfo;
    }

    public static final class Companion {
        public static /* synthetic */ void GEO_KEY$annotations() {
        }

        public static /* synthetic */ void USERINFO_KEY$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        public final String getGEO_KEY() {
            return AUIContextData.GEO_KEY;
        }

        public final String getUSERINFO_KEY() {
            return AUIContextData.USERINFO_KEY;
        }
    }

    public final String getTAG() {
        return this.TAG;
    }

    public String toString() {
        return "AUIContextData(geo=" + this.geo + ", userInfo=" + this.userInfo + ')';
    }
}
