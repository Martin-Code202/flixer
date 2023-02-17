package com.netflix.mediaclient.service.webclient.model.leafs;

import com.google.gson.annotations.SerializedName;
import o.C1456Fq;
import o.C1457Fr;
public final class StreamProfileData {
    private static final BwCap BW_CAP_DEFAULT = new BwCap(Companion.getDEFAULT_CELLULAR_AUTO_KBPS(), Companion.getDEFAULT_MANUAL_VIDEO_BITRATE_LOW());
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_CELLULAR_AUTO_KBPS = DEFAULT_CELLULAR_AUTO_KBPS;
    private static final int DEFAULT_MANUAL_VIDEO_BITRATE_LOW = DEFAULT_MANUAL_VIDEO_BITRATE_LOW;
    @SerializedName("al0CellularCap")
    private BwCap al0CellularCap = Companion.getBW_CAP_DEFAULT();
    @SerializedName("al1CellularCap")
    private BwCap al1CellularCap = Companion.getBW_CAP_DEFAULT();
    @SerializedName("ce3CellularCap")
    private BwCap ce3CellularCap = Companion.getBW_CAP_DEFAULT();

    public final BwCap getCe3CellularCap() {
        return this.ce3CellularCap;
    }

    public final void setCe3CellularCap(BwCap bwCap) {
        C1457Fr.m5025(bwCap, "<set-?>");
        this.ce3CellularCap = bwCap;
    }

    public final BwCap getAl0CellularCap() {
        return this.al0CellularCap;
    }

    public final void setAl0CellularCap(BwCap bwCap) {
        C1457Fr.m5025(bwCap, "<set-?>");
        this.al0CellularCap = bwCap;
    }

    public final BwCap getAl1CellularCap() {
        return this.al1CellularCap;
    }

    public final void setAl1CellularCap(BwCap bwCap) {
        C1457Fr.m5025(bwCap, "<set-?>");
        this.al1CellularCap = bwCap;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        public final int getDEFAULT_CELLULAR_AUTO_KBPS() {
            return StreamProfileData.DEFAULT_CELLULAR_AUTO_KBPS;
        }

        public final int getDEFAULT_MANUAL_VIDEO_BITRATE_LOW() {
            return StreamProfileData.DEFAULT_MANUAL_VIDEO_BITRATE_LOW;
        }

        public final BwCap getBW_CAP_DEFAULT() {
            return StreamProfileData.BW_CAP_DEFAULT;
        }
    }
}
