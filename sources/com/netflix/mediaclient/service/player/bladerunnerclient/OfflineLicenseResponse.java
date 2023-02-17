package com.netflix.mediaclient.service.player.bladerunnerclient;

import com.netflix.mediaclient.service.offline.download.OfflinePlayablePersistentData;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import o.C1283;
import o.C1418Ei;
import o.C1889iq;
import org.json.JSONObject;
public class OfflineLicenseResponse {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static String f1650 = "bladerunnerOfflineLicenseResponse";

    /* renamed from: ʼ  reason: contains not printable characters */
    private static String f1651 = "completeDownloadAndActivate";

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private static String f1652 = "activate";

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String f1653 = "refresh";

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private static String f1654 = "deactivate";

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static String f1655 = "convertLicense";

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static String f1656 = "activateAndRefresh";

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private long f1657;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private boolean f1658;

    /* renamed from: ʽ  reason: contains not printable characters */
    public String f1659;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private long f1660;

    /* renamed from: ʾ  reason: contains not printable characters */
    private boolean f1661;

    /* renamed from: ʿ  reason: contains not printable characters */
    private boolean f1662;

    /* renamed from: ˈ  reason: contains not printable characters */
    private boolean f1663;

    /* renamed from: ˊ  reason: contains not printable characters */
    public String f1664;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private byte[] f1665;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private String f1666;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private byte[] f1667;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String f1668;

    /* renamed from: ˏ  reason: contains not printable characters */
    public long f1669;

    /* renamed from: ͺ  reason: contains not printable characters */
    private long f1670;

    /* renamed from: ॱ  reason: contains not printable characters */
    public String f1671;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private long f1672;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private long f1673;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private long f1674;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private LimitationType f1675;

    /* renamed from: ᐝ  reason: contains not printable characters */
    public String f1676;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private int f1677;

    public String toString() {
        return "OfflineLicenseResponse{mExpirationTimeInMs=" + this.f1672 + ", mPlayableWindowInHour=" + this.f1670 + ", mPlayableWindowInMs=" + this.f1674 + ", mPlayWindowResetLimit=" + this.f1657 + ", mRefreshLicenseTimeStamp=" + this.f1673 + ", mLimitationType=" + this.f1675 + ", mAllocationsRemaining=" + this.f1677 + ", mYearlyLimitExpiryDateMillis=" + this.f1669 + ", mShouldUsePlayWindowLimits=" + this.f1661 + ", mPwResettable=" + this.f1658 + ", mShouldRefresh=" + this.f1662 + ", mShouldRefreshByTimestamp=" + this.f1663 + ", mViewingWindow=" + this.f1660 + ", mKeySetId=" + Arrays.toString(this.f1665) + ", mLinkActivate='" + this.f1671 + "', mLinkDownloadAndActivate='" + this.f1664 + "', mLinkDeactivate='" + this.f1668 + "', mLinkRefresh='" + this.f1676 + "', mLinkConvertLicense='" + this.f1659 + "', providerSessionToken='" + this.f1666 + "'}";
    }

    public OfflineLicenseResponse(JSONObject jSONObject) {
        m948(jSONObject);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public byte[] m950() {
        return this.f1667;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m948(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f1666 = jSONObject.optString("providerSessionToken");
            this.f1667 = C1418Ei.m4894(jSONObject.optString("licenseResponseBase64"));
            C1283.m16854(f1650, "parsing license response end.");
            this.f1672 = jSONObject.optLong("absoluteExpirationTimeMillis");
            this.f1660 = jSONObject.optLong("viewingWindowExpiration");
            if (this.f1660 <= 0) {
                this.f1660 = Long.MAX_VALUE;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("playbackLimitations");
            if (optJSONObject != null) {
                this.f1661 = optJSONObject.optBoolean("APPLYPLAYWINDOW");
                this.f1670 = optJSONObject.optLong("PLAYWINDOWHOURS");
                this.f1674 = optJSONObject.optLong("PLAYWINDOWMILLIS");
                this.f1658 = optJSONObject.optBoolean("ALLOWPLAYWINDOWRESET");
                this.f1657 = optJSONObject.optLong("PLAYWINDOWRESETLIMIT");
                this.f1662 = optJSONObject.optBoolean("ALLOWAUTOLICENSEREFRESH");
                this.f1663 = optJSONObject.optBoolean("APPLYLICENSEREFRESHLIMIT");
                this.f1673 = optJSONObject.optLong("REFRESHLICENSETIMESTAMP");
                this.f1675 = LimitationType.m953(optJSONObject.optString("YEARLYLIMITATIONTYPE"));
                this.f1669 = optJSONObject.optLong("YEARLYLIMITEXPIRYDATEMILLIS");
                this.f1677 = optJSONObject.optInt("ALLOCATIONSREMAINING");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("links");
            if (optJSONObject2 != null) {
                this.f1671 = m947(optJSONObject2, f1652);
                this.f1668 = m947(optJSONObject2, f1654);
                this.f1664 = m947(optJSONObject2, f1651);
                this.f1676 = m947(optJSONObject2, f1656);
                this.f1659 = m947(optJSONObject2, f1655);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m947(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        return optJSONObject.toString();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m951(byte[] bArr) {
        this.f1665 = bArr;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m949(OfflinePlayablePersistentData.iF iFVar) {
        iFVar.mExpirationTimeInMs = this.f1672;
        iFVar.mViewingWindow = this.f1660;
        iFVar.mKeySetId = C1889iq.m7730(this.f1665);
        iFVar.mPlayableWindowInMs = m946();
        iFVar.mPwResettable = this.f1658;
        iFVar.mShouldRefresh = this.f1662;
        iFVar.mPlayWindowResetLimit = this.f1657;
        iFVar.mRefreshLicenseTimestamp = this.f1673;
        iFVar.mShouldUsePlayWindowLimits = this.f1661;
        iFVar.mShouldRefreshByTimestamp = this.f1663;
        iFVar.mLinkDeactivate = this.f1668;
        iFVar.mLinkDownloadAndActivate = this.f1664;
        iFVar.mLinkRefresh = this.f1676;
        iFVar.mLinkConvertLicense = this.f1659;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private long m946() {
        if (this.f1674 >= 0) {
            return this.f1674;
        }
        if (this.f1670 >= 0) {
            return TimeUnit.HOURS.toMillis(this.f1670);
        }
        return -1;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m952() {
        return (LimitationType.License == this.f1675 || LimitationType.Download == this.f1675) && this.f1677 == 1 && this.f1669 != -1;
    }

    public enum LimitationType {
        License("license"),
        Download("download"),
        Unlimited("unlimited"),
        UNKNOWN("");
        

        /* renamed from: ˋ  reason: contains not printable characters */
        private String f1683;

        private LimitationType(String str) {
            this.f1683 = str;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public static LimitationType m953(String str) {
            LimitationType[] values = values();
            for (LimitationType limitationType : values) {
                if (limitationType.f1683.equalsIgnoreCase(str)) {
                    return limitationType;
                }
            }
            return UNKNOWN;
        }
    }
}
