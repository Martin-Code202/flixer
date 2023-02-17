package com.netflix.mediaclient.service.offline.download;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import o.AbstractC0367;
import o.C1349Bv;
import o.oX;
public class OfflinePlayablePersistentData {
    @SerializedName("audioTracks")
    public final List<DownloadablePersistentData> mAudioDownloadablePersistentList;
    private transient DownloadState mDlStateBeforeDelete;
    @SerializedName("dlStateBeforeDelete")
    private int mDlStateBeforeDeleteValue;
    @SerializedName("dcInitTimeMs")
    public final long mDownloadContextInitTimeMs;
    @SerializedName("pcListPos")
    public final int mDownloadContextListPos;
    @SerializedName("dcRequestId")
    public final String mDownloadContextRequestId;
    @SerializedName("pcTrackId")
    public final int mDownloadContextTrackId;
    @SerializedName("pcVideoPos")
    public final int mDownloadContextVideoPos;
    private transient DownloadState mDownloadState;
    @SerializedName("downloadStateValue")
    private int mDownloadStateValue;
    @SerializedName("videoQuality")
    private final String mDownloadVideoQuality;
    @SerializedName("dxId")
    public String mDxId;
    @SerializedName("errorCode")
    private int mErrorCode;
    @SerializedName("errorString")
    private String mErrorString;
    @SerializedName("geoBlocked")
    private boolean mGeoBlocked;
    @SerializedName("licenseData")
    public final iF mLicenseData = new iF();
    @SerializedName("manifestNetworkType")
    private int mManifestNetworkType;
    @SerializedName("oxId")
    public final String mOxId;
    @SerializedName("playStartTime")
    public long mPlayStartTime;
    @SerializedName("playableId")
    public final String mPlayableId;
    @SerializedName("profileGuidList")
    private final List<String> mProfileGuidList = new ArrayList();
    private transient Status mStatus;
    private transient StopReason mStopReason;
    @SerializedName("stopReasonValue")
    private int mStopReasonValue;
    @SerializedName("subtitleTracks")
    public final List<DownloadablePersistentData> mSubtitleDownloadablePersistentList;
    @SerializedName("stateTime")
    public long mTimeStateChanged;
    @SerializedName("trickPlays")
    public final List<DownloadablePersistentData> mTrickPlayDownloadablePersistentList;
    @SerializedName("videoTracks")
    public final List<DownloadablePersistentData> mVideoDownloadablePersistentList;
    @SerializedName("manifestNetworkName")
    private String mWiFiSsidOrNetworkOperatorName;

    public void resetPersistentStatus() {
        this.mErrorCode = 0;
        this.mErrorString = null;
        this.mStatus = null;
    }

    public void setPersistentStatus(Status status) {
        this.mErrorCode = status.mo302().m271();
        this.mErrorString = status.mo307();
        this.mStatus = status;
    }

    private OfflinePlayablePersistentData(String str, oX oXVar, String str2, String str3, String str4) {
        this.mPlayableId = str;
        this.mDownloadContextTrackId = oXVar.getTrackId();
        this.mDownloadContextVideoPos = oXVar.mo9589();
        this.mDownloadContextListPos = oXVar.getListPos();
        this.mDownloadContextRequestId = oXVar.getRequestId();
        this.mDownloadContextInitTimeMs = System.currentTimeMillis();
        this.mOxId = str2;
        this.mProfileGuidList.add(str3);
        this.mDownloadVideoQuality = str4;
        this.mDownloadState = DownloadState.Creating;
        this.mAudioDownloadablePersistentList = new ArrayList();
        this.mVideoDownloadablePersistentList = new ArrayList();
        this.mSubtitleDownloadablePersistentList = new ArrayList();
        this.mTrickPlayDownloadablePersistentList = new ArrayList();
        this.mStopReason = StopReason.WaitingToBeStarted;
        this.mStopReasonValue = this.mStopReason.m1583();
    }

    public static OfflinePlayablePersistentData createOfflineContentPersistentData(String str, oX oXVar, String str2, String str3, String str4) {
        return new OfflinePlayablePersistentData(str, oXVar, str2, str3, str4);
    }

    public void setWarningStatus(Status status) {
        setPersistentStatus(status);
    }

    public Status getPersistentStatus() {
        if (this.mStatus == null) {
            if (this.mErrorCode != 0) {
                StatusCode r1 = StatusCode.m264(this.mErrorCode);
                if (r1 == null) {
                    r1 = StatusCode.UNKNOWN;
                }
                NetflixStatus netflixStatus = new NetflixStatus(r1);
                if (this.mErrorString != null) {
                    netflixStatus.m312(this.mErrorString);
                    netflixStatus.m311(true);
                }
                this.mStatus = netflixStatus;
            } else {
                this.mStatus = AbstractC0367.f13235;
            }
        }
        return this.mStatus;
    }

    public class iF {
        @SerializedName("expirationTime")
        public long mExpirationTimeInMs;
        @SerializedName("keySetId")
        public String mKeySetId;
        @SerializedName("licenseDate")
        public long mLicenseDate;
        @SerializedName("convertLicense")
        public String mLinkConvertLicense;
        @SerializedName("linkDeactivate")
        public String mLinkDeactivate;
        @SerializedName("linkDownloadAndActivate")
        public String mLinkDownloadAndActivate;
        @SerializedName("linkRefresh")
        public String mLinkRefresh;
        @SerializedName("playWindowResetLimit")
        public long mPlayWindowResetLimit;
        @SerializedName("playableWindow")
        @Deprecated
        private long mPlayableWindowInHour;
        @SerializedName("playableWindowMs")
        public long mPlayableWindowInMs;
        @SerializedName("resettable")
        public boolean mPwResettable;
        @SerializedName("refreshLicenseTimestamp")
        public long mRefreshLicenseTimestamp;
        @SerializedName("shouldRefresh")
        public boolean mShouldRefresh;
        @SerializedName("mShouldRefreshByTimestamp")
        public boolean mShouldRefreshByTimestamp;
        @SerializedName("shouldUsePlayWindowLimits")
        public boolean mShouldUsePlayWindowLimits;
        @SerializedName("viewingWindow")
        public long mViewingWindow;

        public iF() {
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public long m824() {
            if (this.mPlayableWindowInMs >= 0) {
                return this.mPlayableWindowInMs;
            }
            if (this.mPlayableWindowInHour >= 0) {
                return TimeUnit.HOURS.toMillis(this.mPlayableWindowInHour);
            }
            return -1;
        }
    }

    public void setDownloadStateComplete() {
        setDownloadState(DownloadState.Complete);
    }

    public void setDownloadStateInProgress() {
        setDownloadState(DownloadState.InProgress);
        resetPersistentStatus();
    }

    public void setDownloadStateDeleted() {
        this.mDlStateBeforeDelete = this.mDownloadState;
        this.mDlStateBeforeDeleteValue = this.mDlStateBeforeDelete.m1577();
        setDownloadState(DownloadState.Deleted);
    }

    public void setDownloadStateDeleteComplete() {
        setDownloadState(DownloadState.DeleteComplete);
    }

    public void setDownloadStateStopped(StopReason stopReason) {
        setDownloadState(DownloadState.Stopped);
        setStopReason(stopReason);
    }

    public void setCreateFailedState() {
        setDownloadState(DownloadState.CreateFailed);
    }

    public long getTimeStateChanged() {
        return this.mTimeStateChanged;
    }

    private void setDownloadState(DownloadState downloadState) {
        this.mDownloadState = downloadState;
        this.mDownloadStateValue = downloadState.m1577();
        this.mTimeStateChanged = System.currentTimeMillis();
    }

    private void setStopReason(StopReason stopReason) {
        this.mStopReason = stopReason;
        this.mStopReasonValue = stopReason.m1583();
    }

    public void setGeoBlocked(boolean z) {
        this.mGeoBlocked = z;
    }

    public DownloadState getDownloadState() {
        if (this.mDownloadState == null) {
            this.mDownloadState = DownloadState.m1576(this.mDownloadStateValue);
            if (this.mDownloadState == DownloadState.Stopped && this.mStopReason == null) {
                this.mStopReason = StopReason.m1580(this.mStopReasonValue);
            }
        }
        if (this.mDownloadState == DownloadState.Deleted && C1349Bv.m4113(this.mLicenseData.mKeySetId)) {
            this.mDownloadState = DownloadState.DeleteComplete;
        }
        return this.mDownloadState;
    }

    public DownloadState getDlStateBeforeDelete() {
        if (this.mDlStateBeforeDelete == null) {
            this.mDlStateBeforeDelete = DownloadState.m1576(this.mDlStateBeforeDeleteValue);
        }
        return this.mDlStateBeforeDelete;
    }

    public StopReason getStopReason() {
        if (getDownloadState() != DownloadState.Stopped || this.mStopReason == null) {
            return StopReason.Unknown;
        }
        return this.mStopReason;
    }

    public List<String> getProfileGuidList() {
        return this.mProfileGuidList;
    }

    public String getDownloadVideoQuality() {
        return this.mDownloadVideoQuality;
    }

    public void setManifestNetworkType(int i) {
        this.mManifestNetworkType = i;
    }

    public int getManifestNetworkType() {
        return this.mManifestNetworkType;
    }

    public String getWiFiSsidOrNetworkOperatorName() {
        return this.mWiFiSsidOrNetworkOperatorName;
    }

    public void setWiFiSsidOrNetworkOperatorName(String str) {
        this.mWiFiSsidOrNetworkOperatorName = str;
    }

    public boolean isGeoBlocked() {
        return this.mGeoBlocked;
    }

    public boolean isOldFatalError() {
        if (this.mDownloadContextInitTimeMs + TimeUnit.DAYS.toMillis(7) > System.currentTimeMillis()) {
            return false;
        }
        if (this.mStopReasonValue == StopReason.EncodesAreNotAvailableAnyMore.m1583() || this.mStopReasonValue == StopReason.ManifestError.m1583() || this.mErrorCode == StatusCode.DL_MANIFEST_NOT_FOUND_IN_CACHE.m271()) {
            return true;
        }
        if (System.currentTimeMillis() - this.mDownloadContextInitTimeMs <= TimeUnit.DAYS.toMillis(60) || System.currentTimeMillis() - this.mDownloadContextInitTimeMs >= TimeUnit.DAYS.toMillis(365) || getDownloadState() == DownloadState.Complete) {
            return false;
        }
        return true;
    }
}
