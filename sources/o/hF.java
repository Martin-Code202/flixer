package o;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.offline.download.DownloadablePersistentData;
import com.netflix.mediaclient.service.offline.download.DownloadableType;
import com.netflix.mediaclient.service.offline.download.OfflinePlayablePersistentData;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.player.bladerunnerclient.OfflineLicenseResponse;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.ClientActionFromLase;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadVideoQuality;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import com.netflix.mediaclient.servicemgr.interface_.offline.WatchState;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import o.AbstractC1853hl;
import o.hI;
public class hF implements hI, AbstractC1866hx {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final hJ f7068;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final hG f7069;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C0482 f7070;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final OfflinePlayablePersistentData f7071;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final iF f7072 = new iF();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final HandlerThread f7073;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f7074;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final List<C1867hy> f7075 = new ArrayList();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final File f7076;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private HandlerC0111 f7077;

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f7078;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f7079;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final IClientLogging f7080;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final Context f7081;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private boolean f7082;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final hX f7083;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final hS f7084;

    public hF(Context context, OfflinePlayablePersistentData offlinePlayablePersistentData, hG hGVar, String str, C0482 r8, hX hXVar, hS hSVar, hJ hJVar, HandlerThread handlerThread, IClientLogging iClientLogging) {
        this.f7081 = context;
        this.f7071 = offlinePlayablePersistentData;
        this.f7069 = hGVar;
        this.f7079 = str;
        this.f7076 = new File(str);
        this.f7070 = r8;
        this.f7083 = hXVar;
        this.f7084 = hSVar;
        this.f7068 = hJVar;
        this.f7077 = new HandlerC0111(handlerThread.getLooper());
        this.f7073 = handlerThread;
        this.f7080 = iClientLogging;
        if (this.f7071.getDownloadState() == DownloadState.InProgress) {
            C1283.m16862("nf_offlinePlayable", "OfflinePlayableImpl constructor marking item stopped");
            this.f7071.setDownloadStateStopped(StopReason.WaitingToBeStarted);
        }
        boolean z = false;
        if (!(((this.f7071.getDownloadState() == DownloadState.Stopped && this.f7071.getStopReason() == StopReason.DownloadLimitRequiresManualResume) || mo6885().mo302() == StatusCode.DL_ENCODES_DELETE_ON_REVOCATION) ? true : z) && !m6849()) {
            C1283.m16850("nf_offlinePlayable", "OfflinePlayableImpl checkAllDownloadablesExists false");
            this.f7071.setDownloadStateStopped(StopReason.WaitingToBeStarted);
            this.f7071.resetPersistentStatus();
        }
        m6864();
        if (this.f7083 == null || this.f7084 == null) {
            throw new RuntimeException("mOfflineManifestManager or mOfflineLicenseManager can't be null");
        }
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private void m6822() {
        this.f7077.removeCallbacks(this.f7072);
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private void m6832() {
        this.f7077.postDelayed(this.f7072, 0);
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private void m6823() {
        this.f7077.postDelayed(this.f7072, 2000);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6850(int i, Object obj) {
        if (this.f7077 != null) {
            this.f7077.obtainMessage(i, obj).sendToTarget();
        } else {
            C1283.m16850("nf_offlinePlayable", "sendMessageToHandler after handler is gone");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6845(jG jGVar, Status status) {
        if (status.mo298()) {
            status = m6866(jGVar);
            if (status.mo298()) {
                if (m6833()) {
                    m6865();
                    if (jGVar.m7910()) {
                        this.f7084.mo6973(mo6915(), jGVar.m7935(), jGVar.m7913().toString(), mo6913(), mo6882(), new hT() { // from class: o.hF.2
                            @Override // o.hT
                            /* renamed from: ˊ */
                            public void mo6917(String str, OfflineLicenseResponse offlineLicenseResponse, Status status2) {
                                hF.this.m6840(str, offlineLicenseResponse, status2);
                            }
                        });
                        return;
                    } else {
                        m6814();
                        return;
                    }
                } else {
                    NetflixStatus netflixStatus = new NetflixStatus(StatusCode.DL_NOT_ENOUGH_FREE_SPACE);
                    netflixStatus.m299(m6861());
                    hW.m6988(this.f7080.mo1512(), mo6915(), mo6913(), mo6882(), netflixStatus);
                    status = netflixStatus;
                    C1283.m16850("nf_offlinePlayable", "handleFirstTimeManifestReceived not enough space");
                }
            }
        }
        this.f7068.mo6947(this, status);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m6831(jG jGVar) {
        if (!m6847(jGVar)) {
            m6835();
        } else if (m6833()) {
            m6848();
            this.f7068.mo6945();
        } else {
            m6852(new NetflixStatus(StatusCode.DL_NOT_ENOUGH_FREE_SPACE), StopReason.NotEnoughSpace);
        }
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private void m6814() {
        this.f7068.mo6947(this, AbstractC0367.f13235);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6840(String str, OfflineLicenseResponse offlineLicenseResponse, Status status) {
        if (status.mo298()) {
            offlineLicenseResponse.m949(this.f7071.mLicenseData);
            this.f7071.resetPersistentStatus();
        } else {
            this.f7071.setPersistentStatus(status);
        }
        this.f7068.mo6947(this, status);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m6824() {
        m6852(new NetflixStatus(StatusCode.DL_URL_DOWNLOAD_DISK_IO_ERROR), StopReason.StorageError);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6852(Status status, StopReason stopReason) {
        m6834();
        m6816(status, stopReason);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6818(C1867hy hyVar, Status status) {
        StopReason stopReason = StopReason.NetworkError;
        m6836();
        if (ConnectivityUtils.m2970(this.f7081)) {
            C1283.m16862("nf_offlinePlayable", "handleNetworkError networkConnected");
            if (this.f7074 > 0) {
                return;
            }
        } else {
            stopReason = StopReason.NoNetworkConnectivity;
            C1283.m16862("nf_offlinePlayable", "handleNetworkError noNetwork");
        }
        m6839(status, stopReason);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6838(Status status) {
        m6834();
        if (m6833()) {
            m6862();
        } else {
            m6852(new NetflixStatus(StatusCode.DL_NOT_ENOUGH_FREE_SPACE), StopReason.NotEnoughSpace);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6851(Status status) {
        m6839(status, StopReason.GeoCheckError);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6839(Status status, StopReason stopReason) {
        m6834();
        m6867(status, stopReason);
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    private void m6835() {
        m6834();
        this.f7071.setDownloadStateStopped(StopReason.EncodesAreNotAvailableAnyMore);
        this.f7068.mo6952(this, new NetflixStatus(StatusCode.DL_ENCODES_ARE_NOT_AVAILABLE));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6817(C1867hy hyVar) {
        m6836();
        C1283.m16863("nf_offlinePlayable", " completeTrackCount=%d activeTrackCount=%d downloadableId=%s", Integer.valueOf(this.f7078), Integer.valueOf(this.f7074), hyVar.m7372());
        boolean z = true;
        if (this.f7078 == this.f7075.size()) {
            C1283.m16862("nf_offlinePlayable", "all tracks downloaded");
            this.f7071.setDownloadStateComplete();
            this.f7069.m6922();
            this.f7068.mo6946(this);
        } else {
            C1283.m16863("nf_offlinePlayable", "completeTrackCount=%d activeTrackCount=%d", Integer.valueOf(this.f7078), Integer.valueOf(this.f7074));
            z = m6833();
        }
        if (z) {
            this.f7068.mo6945();
            C1860hr.m7330(this.f7081);
            return;
        }
        m6852(new NetflixStatus(StatusCode.DL_NOT_ENOUGH_FREE_SPACE), StopReason.NotEnoughSpace);
    }

    @Override // o.hI
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6893() {
        C1283.m16863("nf_offlinePlayable", "initialize playableId=%s", this.f7071.mPlayableId);
        C1348Bu.m4094();
        if (m6876()) {
            this.f7068.mo6947(this, new NetflixStatus(StatusCode.DL_CANT_CREATE_VIEWABLE_DIRECTORY));
            return;
        }
        C1365Ck.m4457(this.f7071.mDxId, false);
        this.f7083.mo7002(this.f7071.mPlayableId, this.f7071.mOxId, this.f7071.mDxId, C1889iq.m7732(this.f7071), this.f7079, DownloadVideoQuality.m1578(this.f7071.getDownloadVideoQuality()), new hY() { // from class: o.hF.10
            @Override // o.hY
            /* renamed from: ˊ  reason: contains not printable characters */
            public void mo6918(jG jGVar, Status status) {
                hF.this.m6845(jGVar, status);
            }
        });
    }

    @Override // o.hI
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6903() {
        C1348Bu.m4094();
        C1283.m16862("nf_offlinePlayable", "startDownload");
        if (this.f7071.getDownloadState() != DownloadState.Complete && this.f7071.getDownloadState() != DownloadState.InProgress) {
            if (!mo6902()) {
                C1283.m16850("nf_offlinePlayable", "Download is not resume-able without user action");
            } else if (!AH.m3348(this.f7079)) {
                this.f7071.setDownloadStateStopped(StopReason.StorageError);
                this.f7068.mo6948(this, new NetflixStatus(StatusCode.DL_VIEWABLE_DIRECTORY_MISSING));
            } else {
                this.f7071.setDownloadStateInProgress();
                if (!m6833()) {
                    m6852(new NetflixStatus(StatusCode.DL_NOT_ENOUGH_FREE_SPACE), StopReason.NotEnoughSpace);
                    return;
                }
                m6834();
                this.f7083.mo7001(mo6915(), mo6913(), mo6882(), this.f7079, new hY() { // from class: o.hF.9
                    @Override // o.hY
                    /* renamed from: ˊ */
                    public void mo6918(jG jGVar, Status status) {
                        if (status.mo301() || C1889iq.m7736(jGVar) || hF.this.m6875()) {
                            hF.this.m6862();
                        } else {
                            hF.this.m6831(jGVar);
                        }
                    }
                });
            }
        }
    }

    @Override // o.hI
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6905(StopReason stopReason) {
        C1348Bu.m4094();
        m6834();
        this.f7071.setDownloadStateStopped(stopReason);
    }

    @Override // o.hI
    /* renamed from: ˊ  reason: contains not printable characters */
    public Status mo6889(boolean z) {
        C1348Bu.m4094();
        return m6825(z);
    }

    @Override // o.hI
    /* renamed from: ˊ  reason: contains not printable characters */
    public OfflinePlayablePersistentData mo6890() {
        return this.f7071;
    }

    @Override // o.hI
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo6899(final hI.Cif ifVar) {
        this.f7083.mo7001(mo6915(), mo6913(), mo6882(), this.f7079, new hY() { // from class: o.hF.7
            @Override // o.hY
            /* renamed from: ˊ */
            public void mo6918(jG jGVar, Status status) {
                hF.this.m6820(jGVar, status, ifVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6820(jG jGVar, Status status, hI.Cif ifVar) {
        C1874ia iaVar = null;
        if (status.mo298()) {
            try {
                iaVar = new C1874ia(this.f7081, this.f7079, jGVar, C1889iq.m7740(this.f7071), this.f7071.mLicenseData.mLinkConvertLicense, C1889iq.m7722(this.f7071.mAudioDownloadablePersistentList), C1889iq.m7722(this.f7071.mVideoDownloadablePersistentList), C1889iq.m7722(this.f7071.mSubtitleDownloadablePersistentList), C1889iq.m7722(this.f7071.mTrickPlayDownloadablePersistentList), this.f7071.mOxId, this.f7071.mDxId, C1889iq.m7732(this.f7071));
            } catch (Exception e) {
                int i = -1;
                int i2 = -1;
                int i3 = -1;
                int i4 = 0;
                int i5 = 0;
                try {
                    i = new File(C1888ip.m7719(this.f7079, mo6915())).exists() ? 0 : 1;
                    int i6 = 0;
                    for (DownloadablePersistentData downloadablePersistentData : this.f7071.mAudioDownloadablePersistentList) {
                        File r23 = C1888ip.m7716(this.f7079, downloadablePersistentData.mDownloadableId, DownloadableType.Audio);
                        if (!r23.exists()) {
                            i6++;
                        } else if (hV.m6983(r23.getAbsolutePath())) {
                            i4++;
                            C1283.m16844("nf_offlinePlayable", "failed audio track deleted=%b %s", Boolean.valueOf(r23.delete()), r23.getAbsolutePath());
                        }
                    }
                    i2 = i6;
                    int i7 = 0;
                    for (DownloadablePersistentData downloadablePersistentData2 : this.f7071.mVideoDownloadablePersistentList) {
                        File r232 = C1888ip.m7716(this.f7079, downloadablePersistentData2.mDownloadableId, DownloadableType.Video);
                        if (!r232.exists()) {
                            i7++;
                        } else if (hV.m6983(r232.getAbsolutePath())) {
                            i5++;
                            C1283.m16844("nf_offlinePlayable", "failed video track deleted=%b %s", Boolean.valueOf(r232.delete()), r232.getAbsolutePath());
                        }
                    }
                    i3 = i7;
                } catch (Exception e2) {
                    C1283.m16863("nf_offlinePlayable", "exception", e2);
                }
                String str = "OfflinePlayableManifestImpl DL_MANIFEST_DATA_MISSING oxid=" + mo6913() + " manifestCount=" + i + " audioCounts=" + i2 + " videoCounts=" + i3 + " failedAudio=" + i4 + " failedVideo=" + i5 + " allExists=" + m6849();
                C1283.m16847("nf_offlinePlayable", str, e);
                Throwable th = new Throwable(str, e);
                NetflixStatus netflixStatus = new NetflixStatus(StatusCode.DL_MANIFEST_DATA_MISSING);
                this.f7071.setDownloadStateStopped(StopReason.WaitingToBeStarted);
                netflixStatus.m300(th);
                status = netflixStatus;
                C1276.m16820().mo5731(th);
            }
        } else if (status.mo302().m271() == StatusCode.DL_MANIFEST_NOT_FOUND_IN_CACHE.m271()) {
            this.f7071.setPersistentStatus(status);
            this.f7071.setDownloadStateStopped(StopReason.ManifestError);
        }
        ifVar.mo6943(iaVar, mo6913(), status);
    }

    @Override // o.hI
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo6898(final hI.iF iFVar) {
        if (this.f7071.mLicenseData.mShouldRefresh) {
            C1283.m16851("nf_offlinePlayable", "attempt auto refresh playableId=%s", mo6915());
            mo6904(IBladeRunnerClient.OfflineRefreshInvoke.MAINTENANCE, new AbstractC1853hl.AbstractC0115() { // from class: o.hF.6
                @Override // o.AbstractC1853hl.AbstractC0115
                /* renamed from: ॱ  reason: contains not printable characters */
                public void mo6919(Status status) {
                    if (iFVar != null) {
                        iFVar.mo6942(hF.this);
                    }
                }
            });
            C1283.m16851("nf_offlinePlayable", "does not allow auto refresh playableId=%s", mo6915());
            if (iFVar != null) {
                iFVar.mo6942(this);
            }
        } else if (iFVar != null) {
            iFVar.mo6942(this);
        }
    }

    @Override // o.hI
    /* renamed from: ʻ  reason: contains not printable characters */
    public void mo6880() {
        if (this.f7077 != null) {
            this.f7077.removeCallbacksAndMessages(null);
            this.f7077 = null;
        }
        this.f7083.mo7000(mo6915());
    }

    @Override // o.pV
    /* renamed from: ᐝ  reason: contains not printable characters */
    public String mo6915() {
        return this.f7071.mPlayableId;
    }

    @Override // o.pV
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String mo6913() {
        return this.f7071.mOxId;
    }

    @Override // o.pV
    /* renamed from: ʼ  reason: contains not printable characters */
    public String mo6882() {
        return this.f7071.mDxId;
    }

    @Override // o.pV
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public int mo6907() {
        return this.f7071.mDownloadContextTrackId;
    }

    @Override // o.pV
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public int mo6897() {
        return this.f7071.mDownloadContextVideoPos;
    }

    @Override // o.pV
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public String mo6910() {
        return this.f7071.mDownloadContextRequestId;
    }

    @Override // o.pV
    /* renamed from: ͺ  reason: contains not printable characters */
    public long mo6908() {
        return this.f7071.mDownloadContextInitTimeMs;
    }

    @Override // o.pV
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public int mo6892() {
        return this.f7071.mDownloadContextListPos;
    }

    @Override // o.pV
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public int mo6916() {
        return this.f7069.m6920();
    }

    @Override // o.pV
    /* renamed from: ॱˎ  reason: contains not printable characters */
    public WatchState mo6912() {
        if (!this.f7071.getDownloadState().equals(DownloadState.Complete)) {
            return WatchState.NOT_WATCHABLE_DUE_TO_NOT_ENOUGH_DATA;
        }
        if (this.f7071.isGeoBlocked() && ConnectivityUtils.m2954(this.f7081)) {
            return WatchState.GEO_BLOCKED;
        }
        WatchState watchState = WatchState.WATCHING_ALLOWED;
        OfflinePlayablePersistentData.iF iFVar = this.f7071.mLicenseData;
        if (iFVar == null || iFVar.mKeySetId == null) {
            return watchState;
        }
        if (!C1860hr.m7333(iFVar)) {
            return WatchState.VIEW_WINDOW_EXPIRED;
        }
        if (C1860hr.m7329(iFVar)) {
            return WatchState.LICENSE_EXPIRED;
        }
        long j = iFVar.mPlayWindowResetLimit;
        if (C1860hr.m7331(this.f7081, this.f7071, iFVar)) {
            long j2 = iFVar.mPlayWindowResetLimit;
            if (!this.f7071.mLicenseData.mShouldUsePlayWindowLimits || j2 == j) {
                return watchState;
            }
            this.f7077.post(new Runnable() { // from class: o.hF.8
                @Override // java.lang.Runnable
                public void run() {
                    hF.this.f7068.mo6945();
                }
            });
            return watchState;
        } else if (!iFVar.mPwResettable || iFVar.mPlayWindowResetLimit <= 0) {
            return WatchState.PLAY_WINDOW_EXPIRED_FINAL;
        } else {
            return WatchState.PLAY_WINDOW_EXPIRED_BUT_RENEWABLE;
        }
    }

    @Override // o.pV
    /* renamed from: ʻॱ  reason: contains not printable characters */
    public DownloadState mo6881() {
        return this.f7071.getDownloadState();
    }

    @Override // o.pV
    /* renamed from: ॱˋ  reason: contains not printable characters */
    public StopReason mo6911() {
        return this.f7071.getStopReason();
    }

    @Override // o.pV
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public long mo6914() {
        if (mo6881() == DownloadState.Complete) {
            return this.f7069.m6925(this.f7076);
        }
        return this.f7069.m6924();
    }

    @Override // o.pV
    /* renamed from: ʿ  reason: contains not printable characters */
    public long mo6887() {
        if (mo6881() == DownloadState.Complete) {
            return this.f7069.m6925(this.f7076);
        }
        return this.f7069.m6923();
    }

    @Override // o.pV
    /* renamed from: ʼॱ  reason: contains not printable characters */
    public String mo6883() {
        if (this.f7071.getProfileGuidList() != null && this.f7071.getProfileGuidList().size() > 0) {
            return this.f7071.getProfileGuidList().get(0);
        }
        C1283.m16850("nf_offlinePlayable", "getProfileGuidOfDownloadRequester error");
        return "";
    }

    @Override // o.pV
    /* renamed from: ʾ  reason: contains not printable characters */
    public long mo6886() {
        if (!this.f7071.mLicenseData.mShouldUsePlayWindowLimits) {
            return -1;
        }
        long j = this.f7071.mPlayStartTime;
        long j2 = this.f7071.mLicenseData.mPlayWindowResetLimit;
        long r6 = this.f7071.mLicenseData.m824();
        if (j <= 0 || j2 > 0 || r6 <= 0) {
            return -1;
        }
        return r6 - (System.currentTimeMillis() - j);
    }

    @Override // o.pV
    /* renamed from: ˈ  reason: contains not printable characters */
    public long mo6888() {
        return this.f7071.getTimeStateChanged();
    }

    @Override // o.pV
    /* renamed from: ʽॱ  reason: contains not printable characters */
    public Status mo6885() {
        return this.f7071.getPersistentStatus();
    }

    @Override // o.hI
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo6902() {
        return this.f7071.getStopReason().m1582();
    }

    @Override // o.hI
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo6909() {
        if (C1860hr.m7327(this.f7081)) {
            C1283.m16862("nf_offlinePlayable", "notifyOfflinePlayStarted not starting playWindow");
        } else if (this.f7071.mPlayStartTime <= 0) {
            synchronized (this.f7071) {
                this.f7071.mPlayStartTime = System.currentTimeMillis();
            }
            if (this.f7071.mLicenseData.mShouldUsePlayWindowLimits) {
                this.f7068.mo6945();
            }
        }
    }

    @Override // o.AbstractC1866hx
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6895(C1867hy hyVar) {
        C1283.m16863("nf_offlinePlayable", "onCdnUrlDownloadSessionEnd downloadableId=%s", hyVar.m7372());
        m6850(4, new C0110(AbstractC0367.f13235, hyVar));
    }

    @Override // o.AbstractC1866hx
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6906(C1867hy hyVar, Status status) {
        m6850(2, new C0110(status, hyVar));
    }

    @Override // o.AbstractC1866hx
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo6900(C1867hy hyVar) {
        C1283.m16862("nf_offlinePlayable", "onUrlDownloadDiskIOError");
        m6850(1, new C0110(new NetflixStatus(StatusCode.DL_URL_DOWNLOAD_DISK_IO_ERROR), hyVar));
    }

    @Override // o.AbstractC1866hx
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo6901(C1867hy hyVar, Status status) {
        C1283.m16863("nf_offlinePlayable", "onCdnUrlExpiredOrMoved downloadableId=%s", hyVar.m7372());
        m6850(3, new C0110(status, hyVar));
    }

    @Override // o.AbstractC1866hx
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6896(C1867hy hyVar, Status status) {
        C1283.m16863("nf_offlinePlayable", "onCdnUrlExpiredOrMoved downloadableId=%s", hyVar.m7372());
        m6850(5, new C0110(status, hyVar));
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    private void m6836() {
        this.f7078 = 0;
        this.f7074 = 0;
        for (C1867hy hyVar : this.f7075) {
            if (hyVar.m7371()) {
                this.f7078++;
            }
            if (hyVar.m7370()) {
                this.f7074++;
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1867hy m6827(DownloadablePersistentData downloadablePersistentData, hD hDVar, String str) {
        return new C1867hy(this.f7081, this.f7073.getLooper(), downloadablePersistentData, hDVar, m6815(downloadablePersistentData, hDVar.mo6811()), C1888ip.m7716(this.f7079, downloadablePersistentData.mDownloadableId, hDVar.mo6811()), this.f7070, hA.m6802(this.f7071, hDVar, str), this.f7080, this);
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m6848() {
        boolean z = false;
        C1283.m16862("nf_offlinePlayable", "startCdnUrlDownloaders");
        for (C1867hy hyVar : this.f7075) {
            if (!hyVar.m7371()) {
                hyVar.m7368();
                z = true;
            } else {
                C1283.m16863("nf_offlinePlayable", "download was complete downloadableId=%s", hyVar.m7372());
            }
        }
        if (z) {
            m6822();
            this.f7071.setDownloadStateInProgress();
            m6832();
            return;
        }
        C1283.m16850("nf_offlinePlayable", "startCdnUrlDownloaders not running progress watcher.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m6847(jG jGVar) {
        C1283.m16862("nf_offlinePlayable", "createCdnUrlDownloadersFromUpdatedManifest");
        List<C1864hv> r3 = hC.m6806(jGVar, C1889iq.m7722(this.f7071.mAudioDownloadablePersistentList));
        List<hK> r5 = hC.m6803(jGVar, C1889iq.m7722(this.f7071.mVideoDownloadablePersistentList));
        List<hM> r7 = hC.m6804(jGVar, C1889iq.m7722(this.f7071.mSubtitleDownloadablePersistentList));
        List<hO> r9 = hC.m6805(jGVar, C1889iq.m7722(this.f7071.mTrickPlayDownloadablePersistentList));
        if (!C1889iq.m7734(this.f7071, r3, r5, r7, r9)) {
            return false;
        }
        this.f7075.clear();
        String r10 = jGVar.m7906();
        for (DownloadablePersistentData downloadablePersistentData : this.f7071.mAudioDownloadablePersistentList) {
            m6841(r3, downloadablePersistentData, this.f7075, r10);
        }
        for (DownloadablePersistentData downloadablePersistentData2 : this.f7071.mVideoDownloadablePersistentList) {
            m6841(r5, downloadablePersistentData2, this.f7075, r10);
        }
        for (DownloadablePersistentData downloadablePersistentData3 : this.f7071.mSubtitleDownloadablePersistentList) {
            m6841(r7, downloadablePersistentData3, this.f7075, r10);
        }
        for (DownloadablePersistentData downloadablePersistentData4 : this.f7071.mTrickPlayDownloadablePersistentList) {
            m6841(r9, downloadablePersistentData4, this.f7075, r10);
        }
        m6864();
        return true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private Status m6866(jG jGVar) {
        C1283.m16862("nf_offlinePlayable", "createFreshCdnUrlDownloadersFromManifest");
        List<C1864hv> r2 = hC.m6806(jGVar, null);
        List<hK> r3 = hC.m6803(jGVar, null);
        List<hM> r4 = hC.m6804(jGVar, null);
        List<hO> r5 = hC.m6805(jGVar, null);
        this.f7075.clear();
        String r6 = jGVar.m7906();
        this.f7071.mAudioDownloadablePersistentList.clear();
        for (C1864hv hvVar : r2) {
            m6868(hvVar, this.f7075, this.f7071.mAudioDownloadablePersistentList, r6);
        }
        this.f7071.mVideoDownloadablePersistentList.clear();
        for (hK hKVar : r3) {
            m6868(hKVar, this.f7075, this.f7071.mVideoDownloadablePersistentList, r6);
        }
        this.f7071.mSubtitleDownloadablePersistentList.clear();
        for (hM hMVar : r4) {
            m6868(hMVar, this.f7075, this.f7071.mSubtitleDownloadablePersistentList, r6);
        }
        this.f7071.mTrickPlayDownloadablePersistentList.clear();
        for (hO hOVar : r5) {
            m6868(hOVar, this.f7075, this.f7071.mTrickPlayDownloadablePersistentList, r6);
        }
        m6864();
        return m6863();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6868(hD hDVar, List<C1867hy> list, List<DownloadablePersistentData> list2, String str) {
        if (hDVar != null) {
            DownloadablePersistentData downloadablePersistentData = new DownloadablePersistentData(hDVar);
            list.add(m6827(downloadablePersistentData, hDVar, str));
            list2.add(downloadablePersistentData);
        }
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private void m6834() {
        C1348Bu.m4094();
        for (C1867hy hyVar : this.f7075) {
            hyVar.m7369();
        }
        this.f7077.removeCallbacksAndMessages(null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Status m6825(boolean z) {
        C1348Bu.m4094();
        m6834();
        hW.m6998(this.f7080.mo1512(), mo6915(), mo6913(), mo6882(), "Delete");
        this.f7083.mo7004(mo6915());
        this.f7071.setDownloadStateDeleted();
        if (m6878() && !z) {
            m6873(this.f7084, this.f7071, (hI.AbstractC0112) null, this.f7068);
        }
        if (C1889iq.m7729(this.f7079)) {
            return AbstractC0367.f13235;
        }
        C1276.m16820().mo5725("deletePlayableDirectory failed:" + this.f7079);
        return new NetflixStatus(StatusCode.DL_CANT_DELETE_PLAYABLE_DIRECTORY);
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private boolean m6833() {
        long r5 = (mo6887() - mo6914()) + 25000000;
        long r7 = C1317As.m3763(this.f7076);
        if (r5 <= r7) {
            return true;
        }
        C1283.m16844("nf_offlinePlayable", "hasEnoughFreeSpace freeSpaceNeeded=%d freeSpaceOnFileSystem=%d", Long.valueOf(r5), Long.valueOf(r7));
        return false;
    }

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private String m6861() {
        return "freeSpaceOnFileSystem=" + C1317As.m3763(this.f7076) + " freeSpaceNeeded=" + ((mo6887() - mo6914()) + 25000000);
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    private Status m6863() {
        if (this.f7075.size() > 0) {
            return AbstractC0367.f13235;
        }
        return new NetflixStatus(StatusCode.DL_MANIFEST_NO_TRACKS_TO_DOWNLOAD);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6867(Status status, StopReason stopReason) {
        if (mo6881() == DownloadState.Stopped) {
            C1283.m16862("nf_offlinePlayable", "sendNetworkError already in stopped state.");
            return;
        }
        C1283.m16862("nf_offlinePlayable", "sendNetworkError sending error to mOfflinePlayableListener.");
        this.f7071.setDownloadStateStopped(stopReason);
        this.f7068.mo6950(this, status);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6816(Status status, StopReason stopReason) {
        if (25000000 > C1317As.m3763(this.f7076)) {
            C1283.m16850("nf_offlinePlayable", "sendStorageError overriding error to not enough space");
            status = new NetflixStatus(StatusCode.DL_NOT_ENOUGH_FREE_SPACE);
            stopReason = StopReason.NotEnoughSpace;
        }
        if (mo6881() == DownloadState.Stopped) {
            this.f7071.setDownloadStateStopped(stopReason);
            C1283.m16862("nf_offlinePlayable", "sendStorageError already in stopped state.");
            return;
        }
        this.f7071.setDownloadStateStopped(stopReason);
        this.f7068.mo6948(this, status);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏˏ  reason: contains not printable characters */
    private void m6862() {
        C1283.m16862("nf_offlinePlayable", "refreshManifestFromServerAndContinue");
        List<DownloadablePersistentData> list = this.f7071.mVideoDownloadablePersistentList;
        this.f7083.mo6999(mo6915(), mo6913(), mo6882(), this.f7079, list.size() > 0 ? list.get(0).mDownloadableId : null, DownloadVideoQuality.m1578(this.f7071.getDownloadVideoQuality()), new hY() { // from class: o.hF.11
            @Override // o.hY
            /* renamed from: ˊ */
            public void mo6918(jG jGVar, Status status) {
                hF.this.m6819(jGVar, status);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6819(jG jGVar, Status status) {
        if (status.mo298()) {
            m6865();
            m6831(jGVar);
            return;
        }
        m6839(status, status.mo304() ? StopReason.NetworkError : StopReason.ManifestError);
        this.f7071.setPersistentStatus(status);
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private boolean m6849() {
        boolean z = true;
        for (DownloadablePersistentData downloadablePersistentData : this.f7071.mAudioDownloadablePersistentList) {
            File r7 = C1888ip.m7716(this.f7079, downloadablePersistentData.mDownloadableId, DownloadableType.Audio);
            if (!r7.exists() || r7.length() == 0) {
                z = false;
                downloadablePersistentData.mIsComplete = false;
            } else if (m6846(downloadablePersistentData, r7)) {
                C1283.m16850("nf_offlinePlayable", "audio downloadable marking complete.");
                downloadablePersistentData.mIsComplete = true;
            }
        }
        for (DownloadablePersistentData downloadablePersistentData2 : this.f7071.mVideoDownloadablePersistentList) {
            File r72 = C1888ip.m7716(this.f7079, downloadablePersistentData2.mDownloadableId, DownloadableType.Video);
            if (!r72.exists() || r72.length() == 0) {
                z = false;
                downloadablePersistentData2.mIsComplete = false;
            } else if (m6846(downloadablePersistentData2, r72)) {
                C1283.m16850("nf_offlinePlayable", "video downloadable marking complete.");
                downloadablePersistentData2.mIsComplete = true;
            }
        }
        for (DownloadablePersistentData downloadablePersistentData3 : this.f7071.mSubtitleDownloadablePersistentList) {
            File r73 = C1888ip.m7716(this.f7079, downloadablePersistentData3.mDownloadableId, DownloadableType.Subtitle);
            if (!r73.exists() || r73.length() == 0) {
                z = false;
                downloadablePersistentData3.mIsComplete = false;
            } else if (m6846(downloadablePersistentData3, r73)) {
                C1283.m16850("nf_offlinePlayable", "subtitle downloadable marking complete.");
                downloadablePersistentData3.mIsComplete = true;
            }
        }
        for (DownloadablePersistentData downloadablePersistentData4 : this.f7071.mTrickPlayDownloadablePersistentList) {
            File r74 = C1888ip.m7716(this.f7079, downloadablePersistentData4.mDownloadableId, DownloadableType.TrickPlay);
            if (!r74.exists() || r74.length() == 0) {
                z = false;
                downloadablePersistentData4.mIsComplete = false;
            } else if (m6846(downloadablePersistentData4, r74)) {
                C1283.m16850("nf_offlinePlayable", "trickplay downloadable marking complete.");
                downloadablePersistentData4.mIsComplete = true;
            }
        }
        return z;
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private void m6864() {
        for (DownloadablePersistentData downloadablePersistentData : this.f7071.mAudioDownloadablePersistentList) {
            m6815(downloadablePersistentData, DownloadableType.Audio);
        }
        for (DownloadablePersistentData downloadablePersistentData2 : this.f7071.mVideoDownloadablePersistentList) {
            m6815(downloadablePersistentData2, DownloadableType.Video);
        }
        for (DownloadablePersistentData downloadablePersistentData3 : this.f7071.mSubtitleDownloadablePersistentList) {
            m6815(downloadablePersistentData3, DownloadableType.Subtitle);
        }
        for (DownloadablePersistentData downloadablePersistentData4 : this.f7071.mTrickPlayDownloadablePersistentList) {
            m6815(downloadablePersistentData4, DownloadableType.TrickPlay);
        }
        this.f7069.m6921();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private hB m6815(DownloadablePersistentData downloadablePersistentData, DownloadableType downloadableType) {
        hB hBVar = this.f7069.f7115.get(downloadablePersistentData.mDownloadableId);
        if (hBVar == null) {
            hBVar = new hB();
        }
        hBVar.f7061 = C1888ip.m7716(this.f7079, downloadablePersistentData.mDownloadableId, downloadableType).length();
        if (downloadablePersistentData.mIsComplete) {
            hBVar.f7060 = hBVar.f7061;
        } else {
            hBVar.f7060 = downloadablePersistentData.mSizeOfDownloadable;
        }
        C1283.m16844("nf_offlinePlayable", "getProgressInfoForDownloadable complete=%b downloadableId=%s  mBytesOnTheDisk=%d mTotalBytesToDownload=%d", Boolean.valueOf(downloadablePersistentData.mIsComplete), downloadablePersistentData.mDownloadableId, Long.valueOf(hBVar.f7061), Long.valueOf(hBVar.f7060));
        this.f7069.f7115.put(downloadablePersistentData.mDownloadableId, hBVar);
        return hBVar;
    }

    /* access modifiers changed from: package-private */
    public class iF implements Runnable {
        private iF() {
        }

        @Override // java.lang.Runnable
        public void run() {
            hF.this.m6877();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱʽ  reason: contains not printable characters */
    private void m6877() {
        switch (this.f7071.getDownloadState()) {
            case InProgress:
                this.f7069.m6921();
                m6823();
                this.f7068.mo6949(this);
                break;
        }
        C1283.m16863("nf_offlinePlayable", "ProgressWatchRunnable playableId=%s PlayablePercentageProgress=%d", mo6915(), Integer.valueOf(this.f7069.m6920()));
    }

    /* renamed from: ॱʼ  reason: contains not printable characters */
    private boolean m6876() {
        return !AH.m3340(this.f7079);
    }

    /* renamed from: o.hF$ˊ  reason: contains not printable characters */
    class C0110 {

        /* renamed from: ˋ  reason: contains not printable characters */
        final C1867hy f7110;

        /* renamed from: ˎ  reason: contains not printable characters */
        final Status f7111;

        C0110(Status status, C1867hy hyVar) {
            this.f7111 = status;
            this.f7110 = hyVar;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.hF$ˋ  reason: contains not printable characters */
    public class HandlerC0111 extends Handler {
        HandlerC0111(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1283.m16863("nf_offlinePlayable", "handleMessage cmd=%d", Integer.valueOf(message.what));
            C0110 r5 = (C0110) message.obj;
            switch (message.what) {
                case 1:
                    hF.this.m6824();
                    return;
                case 2:
                    hF.this.m6818(r5.f7110, r5.f7111);
                    return;
                case 3:
                    hF.this.m6838(r5.f7111);
                    return;
                case 4:
                    hF.this.m6817(r5.f7110);
                    return;
                case 5:
                    hF.this.m6851(r5.f7111);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6841(List<? extends hD> list, DownloadablePersistentData downloadablePersistentData, List<C1867hy> list2, String str) {
        hD r1 = m6826(list, downloadablePersistentData.mDownloadableId);
        if (r1 != null) {
            list2.add(m6827(downloadablePersistentData, r1, str));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private hD m6826(List<? extends hD> list, String str) {
        for (hD hDVar : list) {
            if (hDVar.mo6809().equals(str)) {
                return hDVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱʻ  reason: contains not printable characters */
    private boolean m6875() {
        return false;
    }

    /* renamed from: ـ  reason: contains not printable characters */
    private void m6865() {
        int r2 = ConnectivityUtils.m2971(this.f7081);
        this.f7071.setManifestNetworkType(r2);
        String str = "";
        if (r2 != -1) {
            switch (r2) {
                case 0:
                    str = ConnectivityUtils.m2963((TelephonyManager) this.f7081.getSystemService("phone"));
                    break;
                case 1:
                    str = ConnectivityUtils.m2962(ConnectivityUtils.m2961(this.f7081));
                    break;
            }
        }
        this.f7071.setWiFiSsidOrNetworkOperatorName(str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m6846(DownloadablePersistentData downloadablePersistentData, File file) {
        return !downloadablePersistentData.mIsComplete && file.length() > 0 && file.length() == downloadablePersistentData.mSizeOfDownloadable;
    }

    @Override // o.hI
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6904(final IBladeRunnerClient.OfflineRefreshInvoke offlineRefreshInvoke, final AbstractC1853hl.AbstractC0115 r8) {
        if (!C1860hr.m7332(this.f7071.mLicenseData) || !m6878()) {
            C1283.m16862("nf_offlinePlayable", "refreshLicenseIfNeeded not refreshing");
            if (r8 != null) {
                r8.mo6919(AbstractC0367.f13235);
                return;
            }
            return;
        }
        C1283.m16863("nf_offlinePlayable", "refreshLicenseIfNeeded playableId=%s", mo6915());
        this.f7083.mo7001(mo6915(), mo6913(), mo6882(), this.f7079, new hY() { // from class: o.hF.14
            @Override // o.hY
            /* renamed from: ˊ */
            public void mo6918(jG jGVar, Status status) {
                if (status.mo298()) {
                    hF.this.m6853(offlineRefreshInvoke, jGVar, r8);
                } else if (r8 != null) {
                    r8.mo6919(status);
                }
            }
        });
    }

    @Override // o.hI
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo6891(ClientActionFromLase clientActionFromLase) {
        switch (clientActionFromLase) {
            case NO_ACTION:
            case ACQUIRE_NEW_LICENSE:
            case DELETE_LICENSES:
            case MARK_PLAYABLE:
            default:
                return;
            case DELETE_CONTENT_ON_REVOCATION:
                NetflixStatus netflixStatus = new NetflixStatus(StatusCode.DL_ENCODES_DELETE_ON_REVOCATION);
                boolean r6 = C1889iq.m7727(this.f7079, this.f7071);
                this.f7071.setPersistentStatus(netflixStatus);
                this.f7071.setDownloadStateStopped(StopReason.EncodesRevoked);
                C1283.m16863("nf_offlinePlayable", "onLicenseSync encodes deleted=%b", Boolean.valueOf(r6));
                return;
        }
    }

    @Override // o.hI
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6894(final AbstractC1853hl.Cif ifVar) {
        this.f7083.mo7001(mo6915(), mo6913(), mo6882(), this.f7079, new hY() { // from class: o.hF.15
            @Override // o.hY
            /* renamed from: ˊ */
            public void mo6918(jG jGVar, Status status) {
                C1862ht htVar = null;
                if (status.mo298()) {
                    htVar = new C1862ht(jGVar.mo7915(), hF.this.mo6913(), hF.this.mo6882(), C1889iq.m7732(hF.this.mo6890()));
                }
                ifVar.mo5886(hF.this.mo6915(), htVar, status);
            }
        });
    }

    @Override // o.hI
    /* renamed from: ʽ  reason: contains not printable characters */
    public String mo6884() {
        return this.f7079;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6853(IBladeRunnerClient.OfflineRefreshInvoke offlineRefreshInvoke, final jG jGVar, final AbstractC1853hl.AbstractC0115 r12) {
        if (m6878() && C1860hr.m7332(this.f7071.mLicenseData)) {
            C1283.m16851("nf_offlinePlayable", "refreshing license for %s", mo6915());
            m6874(true);
            this.f7084.mo6974(offlineRefreshInvoke, mo6915(), jGVar.m7935(), C1889iq.m7740(this.f7071), this.f7071.mLicenseData.mLinkRefresh, mo6913(), mo6913(), new hT() { // from class: o.hF.1
                @Override // o.hT
                /* renamed from: ˊ  reason: contains not printable characters */
                public void mo6917(String str, OfflineLicenseResponse offlineLicenseResponse, Status status) {
                    if (status.mo302() == StatusCode.OFFLINE_LICENSE_FETCH_NEW) {
                        hF.this.m6860(jGVar, r12);
                        return;
                    }
                    if (status.mo302() == StatusCode.DL_ENCODES_DELETE_ON_REVOCATION) {
                        boolean r5 = C1889iq.m7727(hF.this.f7079, hF.this.f7071);
                        hF.this.f7071.setDownloadStateStopped(StopReason.EncodesRevoked);
                        C1283.m16863("nf_offlinePlayable", "refreshLicense DL_ENCODES_DELETE_ON_REVOCATION deleted encodes=%b", Boolean.valueOf(r5));
                    }
                    hF.this.m6854(offlineLicenseResponse, status, r12);
                }
            });
        } else if (r12 != null) {
            r12.mo6919(AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6854(OfflineLicenseResponse offlineLicenseResponse, Status status, AbstractC1853hl.AbstractC0115 r7) {
        if (status.mo298()) {
            offlineLicenseResponse.m949(this.f7071.mLicenseData);
            this.f7071.resetPersistentStatus();
        } else {
            C1283.m16863("nf_offlinePlayable", "refreshLicense failed %s", status);
            if (C1860hr.m7329(this.f7071.mLicenseData)) {
                this.f7071.setPersistentStatus(status);
            }
        }
        m6874(false);
        this.f7068.mo6945();
        if (r7 != null) {
            r7.mo6919(status);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6860(jG jGVar, final AbstractC1853hl.AbstractC0115 r9) {
        C1283.m16854("nf_offlinePlayable", "Fetching fresh license on refresh failure");
        this.f7084.mo6973(mo6915(), jGVar.m7935(), jGVar.m7913().toString(), mo6913(), mo6882(), new hT() { // from class: o.hF.5
            @Override // o.hT
            /* renamed from: ˊ */
            public void mo6917(String str, OfflineLicenseResponse offlineLicenseResponse, Status status) {
                C1283.m16863("nf_offlinePlayable", "onOfflineLicenseRequestDone status= %s", status);
                hF.this.m6854(offlineLicenseResponse, status, r9);
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m6873(hS hSVar, final OfflinePlayablePersistentData offlinePlayablePersistentData, final hI.AbstractC0112 r11, final hJ hJVar) {
        byte[] r8 = C1889iq.m7740(offlinePlayablePersistentData);
        if (r8 != null && r8.length != 0) {
            hSVar.mo6976(offlinePlayablePersistentData.mPlayableId, r8, offlinePlayablePersistentData.getDlStateBeforeDelete() == DownloadState.Complete, offlinePlayablePersistentData.mLicenseData.mLinkDeactivate, offlinePlayablePersistentData.mOxId, offlinePlayablePersistentData.mDxId, new hT() { // from class: o.hF.3
                @Override // o.hT
                /* renamed from: ˊ */
                public void mo6917(String str, OfflineLicenseResponse offlineLicenseResponse, Status status) {
                    boolean z = r11 != null;
                    if (status.mo298() || (z && !status.mo302().equals(StatusCode.NETWORK_ERROR))) {
                        offlinePlayablePersistentData.setDownloadStateDeleteComplete();
                    }
                    if (r11 != null) {
                        r11.mo6944(offlinePlayablePersistentData);
                    }
                    if (hJVar != null && status.mo298()) {
                        hJVar.mo6951(offlinePlayablePersistentData);
                    }
                }
            });
        } else if (r11 != null) {
            r11.mo6944(offlinePlayablePersistentData);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6874(boolean z) {
        this.f7082 = z;
    }

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private boolean m6878() {
        return !this.f7082 && ConnectivityUtils.m2954(this.f7081);
    }
}
