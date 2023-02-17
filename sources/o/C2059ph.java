package o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.TextView;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.media.BookmarkStore;
import com.netflix.mediaclient.service.api.diagnostics.IDiagnosis;
import com.netflix.mediaclient.service.job.NetflixJob;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.model.leafs.AccountData;
import com.netflix.mediaclient.service.webclient.model.leafs.AvatarInfo;
import com.netflix.mediaclient.service.webclient.model.leafs.EogAlert;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.servicemgr.AddToListData;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IVoip;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.util.DeviceCategory;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import com.netflix.model.leafs.FlatGenreListOfVideosSummary;
import com.netflix.model.leafs.LoLoMoSummary;
import com.netflix.model.leafs.OnRampEligibility;
import com.netflix.model.leafs.PrePlayExperiences;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import com.netflix.model.leafs.Video;
import com.netflix.model.leafs.advisory.Advisory;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.ServiceC0966;
/* renamed from: o.ph  reason: case insensitive filesystem */
public final class C2059ph implements oK {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final oF f9390 = new C2046ov(this);

    /* renamed from: ʼ  reason: contains not printable characters */
    private C2042or f9391;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C0164 f9392 = new C0164();

    /* renamed from: ˊ  reason: contains not printable characters */
    private oE f9393;

    /* renamed from: ˋ  reason: contains not printable characters */
    private oV f9394;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f9395 = AbstractApplicationC1258.m16692();

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f9396 = -1;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final ServiceConnection f9397 = new ServiceConnection() { // from class: o.ph.4
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1283.m16854("ServiceManager", "ServiceConnected with IBinder: " + iBinder);
            ServiceC0966.BinderC0967 r4 = (ServiceC0966.BinderC0967) iBinder;
            C2059ph.this.f9393 = r4.m15872();
            C2059ph.this.f9391 = new C2042or(C2059ph.this);
            C2059ph.this.f9399 = r4.m15872();
            if (C2059ph.this.f9400 == null) {
                C2059ph.this.f9400 = new If();
            }
            C2059ph.this.f9393.mo9448(C2059ph.this.f9400);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            C1283.m16854("ServiceManager", "onServiceDisconnected");
            if (C2059ph.this.f9394 != null) {
                C2059ph.this.f9394.onManagerUnavailable(C2059ph.this, AbstractC0367.f13242);
                C2059ph.this.f9394 = null;
            }
            C2059ph.this.f9399 = null;
            C2059ph.this.f9393 = null;
            C2059ph.this.f9401 = false;
            C2059ph.this.f9396 = -1;
        }
    };

    /* renamed from: ͺ  reason: contains not printable characters */
    private volatile boolean f9398 = false;

    /* renamed from: ॱ  reason: contains not printable characters */
    private oE f9399;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private If f9400;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f9401 = false;

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m9769(oV oVVar) {
        if (oVVar == null) {
            throw new IllegalStateException("listener is null");
        } else if (this.f9398) {
            throw new IllegalStateException("ServiceManager can only be initialized once");
        } else {
            C1283.m16854("ServiceManager", "ServiceManager created");
            this.f9394 = oVVar;
            if (Build.VERSION.SDK_INT <= 25) {
                this.f9395.startService(new Intent(this.f9395, ServiceC0966.class));
            }
            if (!this.f9395.bindService(m9752(), this.f9397, 1)) {
                C1283.m16850("ServiceManager", "ServiceManager could not bind to NetflixService!");
            }
            this.f9398 = true;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m9799() {
        if (this.f9393 != null) {
            if (this.f9400 != null) {
                C1283.m16854("ServiceManager", "ServiceManager unregisterCallback");
                this.f9393.mo9418(this.f9400);
            }
            C1283.m16854("ServiceManager", "ServiceManager unbindService");
            this.f9395.unbindService(this.f9397);
            if (this.f9392 != null) {
                this.f9392.m9842();
            }
            this.f9396 = -1;
            this.f9401 = false;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Context m9814() {
        return this.f9395;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public ImageLoader m9829() {
        if (m9753()) {
            return this.f9399.mo9404();
        }
        C1283.m16865("ServiceManager", "getImageLoader:: Netflix service is not available or not ready, return null.");
        return null;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m9754() {
        C1348Bu.m4093();
        ImageLoader r2 = m9829();
        if (r2 != null) {
            C1283.m16854("ServiceManager", "Cancelling all pending image requests");
            r2.mo3058();
            return true;
        }
        C1283.m16865("ServiceManager", "Failed to cancell all pending image requests. Image loader not available!");
        return false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m9816(Object obj) {
        if (this.f9393 != null && this.f9393.mo9455() != null) {
            this.f9393.mo9455().m9306(obj);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public AbstractC2056pe m9759() {
        oE oEVar = this.f9393;
        if (oEVar != null) {
            return oEVar.mo9460();
        }
        C1283.m16865("ServiceManager", "getPlaybackSessionManager service is not available");
        return null;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public AbstractC1221 m9827() {
        oE oEVar = this.f9393;
        if (oEVar != null) {
            return oEVar.mo9424();
        }
        C1283.m16865("ServiceManager", "getConfiguration: service is not available");
        return null;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public AbstractC1194 m9757() {
        oE oEVar = this.f9393;
        if (oEVar != null) {
            return oEVar.mo9421();
        }
        C1283.m16865("ServiceManager", "getAUIAgent: service is not available");
        return null;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public oG m9811() {
        oE oEVar = this.f9393;
        if (oEVar != null) {
            return oEVar.mo9411();
        }
        C1283.m16865("ServiceManager", "getMdx:: service is not available");
        return null;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public IVoip m9787() {
        oE oEVar = this.f9393;
        if (oEVar != null) {
            return oEVar.mo9442();
        }
        C1283.m16865("ServiceManager", "getVoip:: voip engine is not available");
        return null;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public AbstractC1156 m9823() {
        oE oEVar = this.f9393;
        if (oEVar != null) {
            return oEVar.mo9451();
        }
        C1283.m16865("ServiceManager", "getVoipAgent: voip agent is not available");
        return null;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public AbstractC0518 m9777() {
        oE oEVar = this.f9393;
        if (oEVar != null) {
            return oEVar.mo9425();
        }
        C1283.m16865("ServiceManager", "getESNProvider:: service is not available");
        return null;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public oI m9809() {
        oE oEVar = this.f9393;
        if (oEVar != null) {
            return oEVar.mo9423();
        }
        C1283.m16865("ServiceManager", "getPushNotification:: service is not available");
        return null;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public IClientLogging m9825() {
        oE oEVar = this.f9393;
        if (oEVar != null) {
            return oEVar.mo9431();
        }
        C1283.m16865("ServiceManager", "getClientLogging:: service is not available");
        return null;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public oH m9756() {
        oE oEVar = this.f9393;
        if (oEVar != null) {
            return oEVar.mo9441();
        }
        C1283.m16865("ServiceManager", "getErrorHandler:: service is not available");
        return null;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public boolean m9824() {
        return m9832() != null;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public AbstractC1853hl m9832() {
        oE oEVar = this.f9393;
        if (oEVar == null) {
            C1283.m16865("ServiceManager", "getOfflineAgent:: service is not available");
            return null;
        }
        AbstractC1853hl r3 = oEVar.mo9438();
        if (r3 == null) {
            C1283.m16865("ServiceManager", "getOfflineAgent:: is null");
            return null;
        } else if (r3.mo7118()) {
            return r3;
        } else {
            C1283.m16865("ServiceManager", "getOfflineAgent:: not available ");
            return null;
        }
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public AbstractC1849hh m9828() {
        oE oEVar = this.f9393;
        if (oEVar == null) {
            C1283.m16865("ServiceManager", "getSmartDownloadController:: service is not available");
            return null;
        }
        AbstractC1853hl r3 = oEVar.mo9438();
        if (r3 == null) {
            C1283.m16865("ServiceManager", "getOfflineAgent:: is null");
            return null;
        } else if (r3.mo7118()) {
            return r3.mo7138();
        } else {
            C1283.m16865("ServiceManager", "getOfflineAgent:: not available ");
            return null;
        }
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public oF m9764() {
        return this.f9390;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized boolean m9770(String str, AssetType assetType, oU oUVar) {
        if (str == null) {
            C1283.m16854("ServiceManager", "fetchAndCacheResource:: resourceUrl is null");
            return false;
        }
        int r2 = m9751(oUVar);
        if (m9753()) {
            this.f9393.mo9434(str, assetType, this.f9396, r2);
            return true;
        }
        C1283.m16865("ServiceManager", "fetchAndCacheResource:: service is not available");
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9783(oU oUVar) {
        if (m9753()) {
            this.f9393.mo9414(this.f9396, m9751(oUVar));
            return;
        }
        C1283.m16865("ServiceManager", "fetchSurvey:: service is not available");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9805(oU oUVar) {
        if (m9753()) {
            this.f9393.mo9405(this.f9396, m9751(oUVar));
            return;
        }
        C1283.m16865("ServiceManager", "fetchSurvey:: service is not available");
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public void m9761() {
        if (m9753()) {
            this.f9393.mo9397();
        } else {
            C1283.m16865("ServiceManager", "markSurveysAsRead:: service is not available");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9793(OnRampEligibility.Action action, oU oUVar) {
        if (m9753()) {
            this.f9393.mo9407(action, this.f9396, m9751(oUVar));
            return;
        }
        C1283.m16865("ServiceManager", "doOnRampEligibilityAction:: service is not available");
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public String m9763() {
        if (m9753()) {
            return this.f9393.mo9458();
        }
        C1283.m16865("ServiceManager", "getCurrentAppLocale:: service is not available");
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m9794(String str) {
        if (m9753()) {
            this.f9393.mo9429(str);
            return true;
        }
        C1283.m16865("ServiceManager", "setCurrentAppLocale:: service is not available");
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m9795(boolean z) {
        if (m9753()) {
            this.f9393.mo9449(z);
            return true;
        }
        C1283.m16865("ServiceManager", "setNonMemberPlayback:: service is not available");
        return false;
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public boolean m9758() {
        if (m9753()) {
            return this.f9393.mo9394();
        }
        C1283.m16865("ServiceManager", "isNonMemberPlayback:: service is not available");
        return false;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public boolean m9762() {
        if (m9753()) {
            return this.f9393.mo9395();
        }
        C1283.m16865("ServiceManager", "isProfileSwitchingDisabled:: service is not available");
        return false;
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    public void m9765() {
        if (m9753()) {
            this.f9393.mo9402();
        } else {
            C1283.m16865("ServiceManager", "refreshProfileSwitchingStatus:: service is not available");
        }
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public DeviceCategory m9778() {
        if (m9753()) {
            return this.f9393.mo9400();
        }
        C1283.m16865("ServiceManager", "getDeviceCategory:: service is not available");
        return null;
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    public String m9775() {
        if (m9753()) {
            return this.f9393.mo9401();
        }
        C1283.m16865("ServiceManager", "getSoftwareVersion:: service is not available");
        return null;
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    public boolean m9776() {
        if (m9753()) {
            return this.f9393.mo9399();
        }
        C1283.m16865("ServiceManager", "isDeviceHd:: service is not available");
        return false;
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    public boolean m9785() {
        if (m9753()) {
            return this.f9393.mo9424().h_();
        }
        return false;
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    public boolean m9788() {
        if (m9753()) {
            return this.f9393.mo9410();
        }
        C1283.m16865("ServiceManager", "isHdr10Supported:: service is not available");
        return false;
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    public boolean m9790() {
        if (m9753()) {
            return this.f9393.mo9420();
        }
        C1283.m16865("ServiceManager", "isDolbyVisionSupported: service is not available");
        return false;
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    public AbstractC2060pi m9786() {
        if (m9753()) {
            return this.f9393.mo9403();
        }
        C1283.m16865("ServiceManager", "getSignUpParams:: service is not available");
        return null;
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    public boolean m9796() {
        if (m9753()) {
            return this.f9393.mo9424().mo16529();
        }
        C1283.m16865("ServiceManager", "shouldAlertForMissingLocale:: service is not available");
        return false;
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    public boolean m9789() {
        if (m9753()) {
            return this.f9393.mo9456();
        }
        C1283.m16865("ServiceManager", "isUserLoggedIn:: service is not available");
        return false;
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    public boolean m9812() {
        if (m9753()) {
            return this.f9393.mo9457();
        }
        C1283.m16865("ServiceManager", "isUserAgeVerified:: service is not available");
        return false;
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    public String m9810() {
        if (m9753()) {
            return this.f9393.mo9398();
        }
        C1283.m16865("ServiceManager", "getUserEmail:: service is not available");
        return null;
    }

    /* renamed from: ˏˏ  reason: contains not printable characters */
    public EogAlert m9808() {
        if (m9753()) {
            return this.f9393.mo9396();
        }
        C1283.m16865("ServiceManager", "getEndOfGrandfatheringAlert:: service is not available");
        return null;
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    public Single<Status> m9797() {
        if (m9753()) {
            return this.f9393.mo9452();
        }
        C1283.m16865("ServiceManager", "restartMembership:: service is not available");
        return null;
    }

    /* renamed from: ˏˎ  reason: contains not printable characters */
    public Observable<Status> m9807() {
        if (m9753()) {
            return this.f9393.mo9422();
        }
        C1283.m16865("ServiceManager", "retryPayment:: service is not available");
        return null;
    }

    /* renamed from: ॱʼ  reason: contains not printable characters */
    public void m9821() {
        if (m9753()) {
            this.f9393.mo9439();
        } else {
            C1283.m16865("ServiceManager", "refreshUserMessage:: service is not available");
        }
    }

    /* renamed from: ॱʻ  reason: contains not printable characters */
    public UmaAlert m9820() {
        if (m9753()) {
            return this.f9393.mo9440();
        }
        C1283.m16865("ServiceManager", "getUserMessageAlert:: service is not available");
        return null;
    }

    /* renamed from: ـ  reason: contains not printable characters */
    public void m9813() {
        if (m9753()) {
            this.f9393.mo9412();
        } else {
            C1283.m16865("ServiceManager", "recordUserMessageImpression:: service is not available");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9803(String str, String str2) {
        if (m9753()) {
            this.f9393.mo9409(str, str2);
        } else {
            C1283.m16865("ServiceManager", "recordUserMessageImpression:: service is not available");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9780(String str) {
        if (m9753()) {
            this.f9393.mo9408(str);
        } else {
            C1283.m16865("ServiceManager", "recordUmsAlertFeedback:: service is not available");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9782(String str, String str2) {
        if (m9753()) {
            this.f9393.mo9435(str, str2);
        } else {
            C1283.m16865("ServiceManager", "recordPlanSelection:: service is not available");
        }
    }

    /* renamed from: ॱʽ  reason: contains not printable characters */
    public boolean m9822() {
        if (m9753()) {
            return this.f9393.mo9454();
        }
        C1283.m16865("ServiceManager", "isCurrentProfileInstantQueueEnabled:: service is not available");
        return false;
    }

    /* renamed from: ॱͺ  reason: contains not printable characters */
    public AbstractC2089qj m9826() {
        if (m9753()) {
            return this.f9393.mo9453();
        }
        C1283.m16865("ServiceManager", "getCurrentProfile:: service is not available");
        return null;
    }

    /* renamed from: ᐨ  reason: contains not printable characters */
    public String m9835() {
        AbstractC2089qj r1 = m9826();
        if (r1 != null) {
            return r1.getProfileGuid();
        }
        return null;
    }

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    public List<? extends AbstractC2089qj> m9833() {
        if (m9753()) {
            return this.f9393.mo9461();
        }
        C1283.m16865("ServiceManager", "getAllProfiles:: service is not available");
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9801(String str) {
        if (m9753()) {
            this.f9393.mo9446(str);
        } else {
            C1283.m16865("ServiceManager", "selectProfile:: service is not available");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9804(String str, boolean z, String str2, oU oUVar) {
        if (m9753()) {
            this.f9393.mo9436(str, z, str2, this.f9396, m9751(oUVar));
            return;
        }
        C1283.m16865("ServiceManager", "addProfile:: service is not available");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9768(String str, String str2, boolean z, String str3, oU oUVar) {
        if (m9753()) {
            this.f9393.mo9417(str, str2, z, str3, this.f9396, m9751(oUVar));
            return;
        }
        C1283.m16865("ServiceManager", "editProfile:: service is not available");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m9817(String str, oU oUVar) {
        if (m9753()) {
            this.f9393.mo9416(str, this.f9396, m9751(oUVar));
            return;
        }
        C1283.m16865("ServiceManager", "removeProfile:: service is not available");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m9819(oU oUVar) {
        if (m9753()) {
            this.f9393.mo9443(this.f9396, m9751(oUVar));
            return true;
        }
        C1283.m16865("ServiceManager", "fetchAvailableAvatarsList:: service is not available");
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m9771(String str, UserAgentInterface.PinType pinType, String str2, oU oUVar) {
        if (m9753()) {
            this.f9393.mo9430(str, pinType, str2, this.f9396, m9751(oUVar));
            return true;
        }
        C1283.m16865("ServiceManager", "verifyPin:: service is not available");
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m9773(oU oUVar) {
        if (m9753()) {
            this.f9393.mo9433(this.f9396, m9751(oUVar));
            return true;
        }
        C1283.m16865("ServiceManager", "verifyAge:: service is not available");
        return false;
    }

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    public IDiagnosis m9830() {
        if (m9753()) {
            return this.f9393.mo9413();
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m9772(String str, String str2, oU oUVar) {
        if (m9753()) {
            this.f9393.mo9447(str, str2, this.f9396, m9751(oUVar));
            return true;
        }
        C1283.m16865("ServiceManager", "loginUser:: service is not available");
        return false;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m9760(oU oUVar) {
        if (m9753()) {
            this.f9393.mo9427(this.f9396, m9751(oUVar));
            return true;
        }
        C1283.m16865("ServiceManager", "logoutUser:: service is not available");
        return false;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m9806(C0614 r4, oU oUVar) {
        if (m9753()) {
            this.f9393.mo9419(r4, this.f9396, m9751(oUVar));
            return true;
        }
        C1283.m16865("ServiceManager", "loginUserByTokens:: service is not available");
        return false;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m9755(oU oUVar) {
        if (m9753()) {
            this.f9393.mo9459(this.f9396, m9751(oUVar));
            return true;
        }
        C1283.m16865("ServiceManager", "loginUserWithExistingTokens:: service is not available");
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m9784(long j, oU oUVar) {
        if (m9753()) {
            this.f9393.mo9428(j, this.f9396, m9751(oUVar));
            return true;
        }
        C1283.m16865("ServiceManager", "createAutoLoginToken:: service is not available");
        return false;
    }

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    public BookmarkStore m9831() {
        if (m9753()) {
            return this.f9393.mo9450();
        }
        return null;
    }

    /* renamed from: ᐧ  reason: contains not printable characters */
    public AbstractC2057pf m9834() {
        if (m9753()) {
            return this.f9393.mo9462();
        }
        C1283.m16865("ServiceManager", "getPrepareHelper:: service is not available");
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9779(int i, String str, String str2, oU oUVar) {
        if (m9753()) {
            this.f9393.mo9406(i, str, str2, this.f9396, m9751(oUVar));
            return;
        }
        C1283.m16865("ServiceManager", "updatePlan:: service is not available");
    }

    /* renamed from: ꜟ  reason: contains not printable characters */
    public oS m9839() {
        if (m9753()) {
            return this.f9393;
        }
        C1283.m16865("ServiceManager", "getServiceNotificationHelper:: service is not available");
        return null;
    }

    /* renamed from: ꜞ  reason: contains not printable characters */
    public AbstractC0933 m9838() {
        if (m9753()) {
            return this.f9393.mo9426();
        }
        C1283.m16865("ServiceManager", "getImageHelper:: service is not available");
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ph$If */
    public class If implements oL {
        private If() {
        }

        @Override // o.oL
        /* renamed from: ॱ */
        public void mo563(int i, Status status) {
            C2059ph.this.f9396 = i;
            oV oVVar = C2059ph.this.f9394;
            if (oVVar == null) {
                return;
            }
            if (status.mo298()) {
                C2059ph.this.f9401 = true;
                oVVar.onManagerReady(C2059ph.this, status);
                return;
            }
            oVVar.onManagerUnavailable(C2059ph.this, status);
        }

        @Override // o.oL
        /* renamed from: ॱ */
        public void mo9556(int i, LoLoMoSummary loLoMoSummary, Status status) {
            m9840(status, i);
            oU r1 = C2059ph.this.m9737(i);
            if (r1 != null) {
                r1.onLoLoMoPrefetched(loLoMoSummary, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˋ */
        public void mo9532(int i, LoLoMoSummary loLoMoSummary, Status status) {
            m9840(status, i);
            oU r1 = C2059ph.this.m9737(i);
            if (r1 != null) {
                r1.onGenreLoLoMoPrefetched(loLoMoSummary, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˊ */
        public void mo9525(int i, List<pC> list, Status status) {
            m9840(status, i);
            oU r1 = C2059ph.this.m9737(i);
            if (r1 != null) {
                r1.onLoMosFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˏ */
        public void mo9551(int i, List<pJ> list, Status status) {
            m9840(status, i);
            oU r1 = C2059ph.this.m9737(i);
            if (r1 != null) {
                r1.onVideosFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˏ */
        public void mo9550(int i, FlatGenreListOfVideosSummary flatGenreListOfVideosSummary, List<pJ> list, Status status) {
            m9840(status, i);
            C1283.m16851("ServiceManager", "onFlatGenreVideosFetched requestId=%s, errorCode=%s, requestedVideos=%s", Integer.valueOf(i), status.mo302(), list);
            oU r5 = C2059ph.this.m9737(i);
            if (r5 == null) {
                C1283.m16851("ServiceManager", "No callback for onVideosFetched requestId %s", Integer.valueOf(i));
            } else {
                r5.onFlatGenreVideosFetched(flatGenreListOfVideosSummary, list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˏ */
        public void mo9552(int i, pA pAVar, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onLoLoMoSummaryFetched requestId " + i);
            } else {
                r3.onLoLoMoSummaryFetched(pAVar, status);
            }
        }

        @Override // o.oL
        /* renamed from: ॱ */
        public void mo9559(int i, String str, String str2, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.f9392.m9841(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onResourceFetched requestId " + i);
            } else {
                r3.onResourceFetched(str, str2, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˎ */
        public void mo9544(int i, String str, String str2, long j, long j2, Status status) {
            m9840(status, i);
            oU r8 = C2059ph.this.f9392.m9841(i);
            if (r8 == null) {
                C1283.m16854("ServiceManager", "No callback for onResourceCached requestId " + i);
            } else {
                r8.onResourceCached(str, str2, j, j2, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˏ */
        public void mo9549(int i, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onLoginComplete requestId " + i);
            } else {
                r3.onLoginComplete(status);
            }
        }

        @Override // o.oL
        /* renamed from: ˎ */
        public void mo9541(int i, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onLogoutComplete requestId " + i);
            } else {
                r3.onLogoutComplete(status);
            }
        }

        @Override // o.oL
        /* renamed from: ˋ */
        public void mo9534(int i, Video.Summary summary, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onVideoSummaryFetched requestId " + i);
            } else {
                r3.onVideoSummaryFetched(summary, status);
            }
        }

        @Override // o.oL
        /* renamed from: ॱ */
        public void mo9561(int i, CH ch, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onFalkorVideoFetched requestId " + i);
            } else {
                r3.onFalkorVideoFetched(ch, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˋ */
        public void mo9537(int i, pP pPVar, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onMovieDetailsFetched requestId " + i);
            } else {
                r3.onMovieDetailsFetched(pPVar, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˋ */
        public void mo9530(int i, int i2, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onScenePositionFetched requestId " + i);
            } else {
                r3.onScenePositionFetched(i2, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˊ */
        public void mo9526(int i, pL pLVar, Boolean bool, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onKidsCharacterDetailsFetched requestId " + i);
            } else {
                r3.onKidsCharacterDetailsFetched(pLVar, bool, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˏ */
        public void mo9553(int i, pI pIVar, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onEpisodeDetailsFetched requestId " + i);
            } else {
                r3.onEpisodeDetailsFetched(pIVar, status);
            }
        }

        @Override // o.oL
        /* renamed from: ʼ */
        public void mo9522(int i, List<AbstractC2074pw> list, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onCWVideosFetched requestId " + i);
            } else {
                r3.onCWVideosFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ʽ */
        public void mo9523(int i, List<Object> list, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onShortFormVideosFetched requestId " + i);
            } else {
                r3.onShortFormVideosFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ʻ */
        public void mo9521(int i, List<pD> list, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onPreviewsFetched requestId " + i);
            } else {
                r3.onPreviewsFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˋ */
        public void mo9536(int i, pO pOVar, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onPostPlayVideoFetched requestId " + i);
            } else {
                r3.onPostPlayVideosFetched(pOVar, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˊ */
        public void mo9528(int i, boolean z, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onPostPlayImpressionLogged requestId " + i);
            } else {
                r3.onPostPlayImpressionLogged(z, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˋ */
        public void mo9535(int i, List<pI> list, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onEpisodesFetched requestId " + i);
            } else {
                r3.onEpisodesFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ॱ */
        public void mo9560(int i, List<pS> list, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onSeasonsFetched requestId " + i);
            } else {
                r3.onSeasonsFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ॱ */
        public void mo9563(int i, pR pRVar, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onShowDetailsFetched requestId " + i);
            } else {
                r3.onShowDetailsFetched(pRVar, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˋ */
        public void mo9538(int i, pR pRVar, List<pS> list, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onShowDetailsAndSeasonsFetched requestId " + i);
            } else {
                r3.onShowDetailsAndSeasonsFetched(pRVar, list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ॱˊ */
        public void mo9565(int i, List<GenreList> list, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onGenreListsFetched requestId " + i);
            } else {
                r3.onGenreListsFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˋॱ */
        public void mo9540(int i, List<pW> list, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onGenresFetched requestId " + i);
            } else {
                r3.onGenresFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˎ */
        public void mo9546(int i, pE pEVar, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onVideoRatingSet requestId " + i);
            } else {
                r3.onVideoRatingSet(pEVar, status);
            }
        }

        @Override // o.oL
        /* renamed from: ॱ */
        public void mo9562(int i, CL cl, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onSurveyFetched requestId " + i);
            } else {
                r3.onSurveyFetched(cl, status);
            }
        }

        @Override // o.oL
        /* renamed from: ᐝ */
        public void mo9569(int i, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onUpdatePlanCompleted requestId " + i);
            } else {
                r3.onUpdatePlanCompleted(status);
            }
        }

        @Override // o.oL
        /* renamed from: ˊॱ */
        public void mo9529(int i, List<Advisory> list, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onAdvisoriesFetched requestId " + i);
            } else {
                r3.onAdvisoriesFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ॱ */
        public void mo9557(int i, PrePlayExperiences prePlayExperiences, Status status) {
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onPrePlayExperienceFetched requestId " + i);
            } else {
                r3.onPreplayVideoFetched(prePlayExperiences, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˎ */
        public void mo9548(int i, boolean z, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onPrePlayImpressionLogged requestId " + i);
            } else {
                r3.onPrePlayImpressionLogged(z, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˏॱ */
        public void mo9554(int i, List<AbstractC2070ps> list, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onBigRowVideoFetched requestId " + i);
                return;
            }
            oP oPVar = new oP("ServiceManager");
            r3.onBigRowVideofetched(list, status);
            for (AbstractC2070ps psVar : list) {
                if (psVar.getBigRowSummary() != null && C1349Bv.m4107(psVar.getBigRowSummary().getId())) {
                    switch (psVar.getType()) {
                        case MOVIE:
                            C2059ph.this.m9764().mo9513(psVar.getBigRowSummary().getId(), (String) null, oPVar);
                            break;
                        case EPISODE:
                            C2059ph.this.m9764().mo9484(psVar.getBigRowSummary().getId(), null, oPVar);
                            break;
                        case SHOW:
                            C2059ph.this.m9764().mo9503(psVar.getBigRowSummary().getId(), (String) null, oPVar);
                            break;
                        default:
                            C1283.m16865("ServiceManager", "fetch not implemented");
                            break;
                    }
                    if (psVar.getBigRowSummary().getVideo() != null) {
                        String motionId = psVar.getBigRowSummary().getVideo().motionId();
                        if (C1349Bv.m4107(motionId)) {
                            C2059ph.this.m9764().mo9513(motionId, (String) null, oPVar);
                        }
                    }
                }
            }
        }

        @Override // o.oL
        /* renamed from: ॱ */
        public void mo9564(int i, boolean z, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onBigRowYellowSquareValueFetched requestId " + i);
            } else {
                r3.onBigRowYellowSquareValueFetched(z, status);
            }
        }

        @Override // o.oL
        /* renamed from: ॱᐝ */
        public void mo9568(int i, List<CH> list, Status status) {
            m9840(status, i);
            oU r1 = C2059ph.this.m9737(i);
            if (r1 != null) {
                r1.onSimsFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˋ */
        public void mo9533(int i, OnRampEligibility onRampEligibility, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for doOnRampEligibilityAction requestId " + i);
            } else {
                r3.onOnRampEligibilityAction(onRampEligibility, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˊ */
        public void mo9524(int i, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onQueueAdd requestId " + i);
            } else {
                r3.onQueueAdd(status);
            }
        }

        @Override // o.oL
        /* renamed from: ˋ */
        public void mo9531(int i, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onQueueRemove requestId " + i);
            } else {
                r3.onQueueRemove(status);
            }
        }

        @Override // o.oL
        /* renamed from: ॱॱ */
        public void mo9566(int i, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onVideoHide requestId " + i);
            } else {
                r3.onVideoHide(status);
            }
        }

        @Override // o.oL
        /* renamed from: ˊ */
        public void mo9527(int i, AbstractC2080qa qaVar, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onSearchResultsFetched requestId " + i);
            } else {
                r3.onSearchResultsFetched(qaVar, status);
            }
        }

        public int hashCode() {
            int hashCode = super.hashCode();
            if (hashCode < 0) {
                return -hashCode;
            }
            return hashCode;
        }

        @Override // o.oL
        /* renamed from: ˋ */
        public void mo9539(int i, boolean z, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onVerified requestId " + i);
            } else {
                r3.onVerified(z, status);
            }
        }

        @Override // o.oL
        /* renamed from: ᐝ */
        public void mo9570(int i, List<AbstractC2077pz> list, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onBBVideosFetched requestId " + i);
            } else {
                r3.onBBVideosFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˎ */
        public void mo9545(int i, List<pK> list, Status status) {
            m9840(status, i);
            C1283.m16851("ServiceManager", "onTallPanelVideosFetched requestId=%d errorCode=%s", Integer.valueOf(i), status.mo302());
            C1283.m16851("ServiceManager", "onTallPanelVideosFetched requestedVideos=%s", list);
            oU r5 = C2059ph.this.m9737(i);
            if (r5 == null) {
                C1283.m16851("ServiceManager", "No callback for onTallPanelVideosFetched requestId %d", Integer.valueOf(i));
            } else {
                r5.onTallPanelVideosFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ॱॱ */
        public void mo9567(int i, List<CH> list, Status status) {
            m9840(status, i);
            C1283.m16851("ServiceManager", "onWatchHistoryVideosFetched requestId=%d errorCode=%s", Integer.valueOf(i), status.mo302());
            C1283.m16851("ServiceManager", "onWatchHistoryVideosFetched requestedVideos=%s", list);
            oU r5 = C2059ph.this.m9737(i);
            if (r5 == null) {
                C1283.m16851("ServiceManager", "No callback for onWatchHistoryVideosFetched requestId %d", Integer.valueOf(i));
            } else {
                r5.onWatchHistoryVideosFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ॱ */
        public void mo9558(int i, TrailersFeedItemSummary trailersFeedItemSummary, List<pH> list, Status status) {
            m9840(status, i);
            C1283.m16851("ServiceManager", "onTrailersFetched requestId=%d errorCode=%s", Integer.valueOf(i), status.mo302());
            C1283.m16851("ServiceManager", "onTrailersFetched requestedVideos=%s", list);
            oU r5 = C2059ph.this.m9737(i);
            if (r5 == null) {
                C1283.m16851("ServiceManager", "No callback for onTrailersFetched requestId %d", Integer.valueOf(i));
            } else {
                r5.onTrailersFetched(trailersFeedItemSummary, list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ͺ */
        public void mo9555(int i, List<AvatarInfo> list, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onAvailableAvatarsListFetched requestId " + i);
            } else {
                r3.onAvailableAvatarsListFetched(list, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˎ */
        public void mo9547(int i, AbstractC2082qc qcVar, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onIrisNotificationsListFetched requestId " + i);
            } else {
                r3.onNotificationsListFetched(qcVar, status);
            }
        }

        @Override // o.oL
        /* renamed from: ʻ */
        public void mo9520(int i, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onProfileListUpdateStatus requestId " + i);
            } else {
                r3.onProfileListUpdateStatus(status);
            }
        }

        @Override // o.oL
        /* renamed from: ˎ */
        public void mo9542(int i, AccountData accountData, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onAccountDataFetched requestId " + i);
            } else {
                r3.onAccountDataFetched(accountData, status);
            }
        }

        @Override // o.oL
        /* renamed from: ˎ */
        public void mo9543(int i, String str, Status status) {
            m9840(status, i);
            oU r3 = C2059ph.this.m9737(i);
            if (r3 == null) {
                C1283.m16854("ServiceManager", "No callback for onAutoLoginTokenCreated requestId " + i);
            } else {
                r3.onAutoLoginTokenCreated(str, status);
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private void m9840(Status status, int i) {
            if (status instanceof NetflixStatus) {
                ((NetflixStatus) status).m308(i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ph$ˊ  reason: contains not printable characters */
    public static class C0164 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final ArrayList<If> f9405;

        private C0164() {
            this.f9405 = new ArrayList<>();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public synchronized int m9843(oU oUVar) {
            If r1;
            r1 = new If(oUVar);
            this.f9405.add(r1);
            return r1.m9845();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public synchronized oU m9841(int i) {
            Iterator<If> it = this.f9405.iterator();
            while (it.hasNext()) {
                If next = it.next();
                if (next.m9845() == i) {
                    this.f9405.remove(next);
                    return next.m9844();
                }
            }
            return null;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public synchronized void m9842() {
            this.f9405.clear();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.ph$ˊ$If */
        public static class If {

            /* renamed from: ˎ  reason: contains not printable characters */
            private static int f9406 = 0;

            /* renamed from: ˊ  reason: contains not printable characters */
            private final oU f9407;

            /* renamed from: ˏ  reason: contains not printable characters */
            private final int f9408 = f9406;

            public If(oU oUVar) {
                f9406++;
                this.f9407 = oUVar;
            }

            /* renamed from: ॱ  reason: contains not printable characters */
            public int m9845() {
                return this.f9408;
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public oU m9844() {
                return this.f9407;
            }
        }
    }

    /* renamed from: ᶥ  reason: contains not printable characters */
    private Intent m9752() {
        return new Intent(this.f9395, ServiceC0966.class);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AddToListData.Cif m9791(NetflixActivity netflixActivity, TextView textView, TextView textView2, String str, VideoType videoType, int i, boolean z) {
        return this.f9391.m9699(netflixActivity, textView, textView2, str, videoType, i, z);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public AddToListData.Cif m9798(NetflixActivity netflixActivity, TextView textView, String str, VideoType videoType, int i) {
        return this.f9391.m9700(netflixActivity, textView, str, videoType, i);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AddToListData.Cif m9792(NetflixActivity netflixActivity, TextView textView, String str, VideoType videoType, int i, boolean z) {
        return this.f9391.m9707(netflixActivity, textView, str, videoType, i, z);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C2059ph m9741(NetflixActivity netflixActivity) {
        if (netflixActivity == null || netflixActivity.isFinishing()) {
            return null;
        }
        C2059ph serviceManager = netflixActivity.getServiceManager();
        if (serviceManager.mo9519()) {
            return serviceManager;
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9802(String str, AddToListData.Cif ifVar) {
        C2042or orVar = this.f9391;
        if (orVar != null) {
            orVar.m9702(str, ifVar);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9781(String str, AddToListData.Cif ifVar) {
        C2042or orVar = this.f9391;
        if (orVar != null) {
            orVar.m9705(str, ifVar);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m9818(String str, boolean z) {
        if (this.f9391 != null) {
            this.f9391.m9708(str, z);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private oU m9745(oU oUVar, String str) {
        return new C0165(oUVar, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ph$ˋ  reason: contains not printable characters */
    public class C0165 extends AbstractC2061pj {

        /* renamed from: ˏ  reason: contains not printable characters */
        private final oU f9410;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f9411;

        public C0165(oU oUVar, String str) {
            this.f9410 = oUVar;
            this.f9411 = str;
            C2042or orVar = C2059ph.this.f9391;
            if (orVar != null) {
                orVar.m9704(str);
            }
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            super.onMovieDetailsFetched(pPVar, status);
            this.f9410.onMovieDetailsFetched(pPVar, status);
            m9846(status, pPVar != null && pPVar.isInQueue(), false);
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onShowDetailsFetched(pR pRVar, Status status) {
            super.onShowDetailsFetched(pRVar, status);
            this.f9410.onShowDetailsFetched(pRVar, status);
            m9846(status, pRVar != null && pRVar.isInQueue(), false);
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onShowDetailsAndSeasonsFetched(pR pRVar, List<pS> list, Status status) {
            super.onShowDetailsAndSeasonsFetched(pRVar, list, status);
            this.f9410.onShowDetailsAndSeasonsFetched(pRVar, list, status);
            m9846(status, pRVar != null && pRVar.isInQueue(), false);
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onQueueAdd(Status status) {
            super.onQueueAdd(status);
            this.f9410.onQueueAdd(status);
            m9846(status, true, true);
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onQueueRemove(Status status) {
            super.onQueueRemove(status);
            this.f9410.onQueueRemove(status);
            m9846(status, false, true);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m9846(Status status, boolean z, boolean z2) {
            C2042or orVar = C2059ph.this.f9391;
            if (orVar != null) {
                if (status.mo298()) {
                    orVar.m9708(this.f9411, z);
                } else {
                    orVar.m9701(status, this.f9411, z, z2);
                }
            }
        }
    }

    /* renamed from: ꓸ  reason: contains not printable characters */
    public boolean m9837() {
        return this.f9398;
    }

    @Override // o.oK
    /* renamed from: ˎ */
    public boolean mo9519() {
        return this.f9393 != null && this.f9401;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int m9751(oU oUVar) {
        if (oUVar != null) {
            return this.f9392.m9843(oUVar);
        }
        C1283.m16850("ServiceManager", "Callback that is added is null!");
        return 0;
    }

    /* renamed from: ﹳ  reason: contains not printable characters */
    private boolean m9753() {
        if (mo9519() && this.f9396 >= 0) {
            return true;
        }
        C1276.m16820().mo5727("SPY-8020 - ServiceMgr called before NetflixService is ready " + this.f9393);
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private oU m9737(int i) {
        return this.f9392.m9841(i);
    }

    @Override // o.oK
    /* renamed from: ˎ */
    public int mo9518(oU oUVar) {
        return m9751(oUVar);
    }

    @Override // o.oK
    /* renamed from: ˋ */
    public int mo9516(oU oUVar, String str) {
        return m9751(m9745(oUVar, str));
    }

    @Override // o.oK
    /* renamed from: ˋ */
    public AbstractC2050oz mo9517() {
        m9753();
        return this.f9393.mo9432();
    }

    @Override // o.oK
    /* renamed from: ˊ */
    public int mo9515() {
        return this.f9396;
    }

    /* renamed from: ㆍ  reason: contains not printable characters */
    public void m9836() {
        if (this.f9393 != null) {
            this.f9393.mo9437();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9800(NetflixJob.NetflixJobId netflixJobId) {
        if (mo9519()) {
            this.f9393.mo9445(netflixJobId);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9767(NetflixJob.NetflixJobId netflixJobId) {
        if (mo9519()) {
            this.f9393.mo9415(netflixJobId);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m9742(Context context, String str) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.REFRESH_HOME_LOLOMO");
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("renoMessageId", str);
        }
        context.sendBroadcast(intent);
        C1283.m16846("ServiceManager", "Intent REFRESH_HOME sent");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m9750(Context context) {
        context.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.BA_WH_REFRESH"));
        C1283.m16846("ServiceManager", "Intent WH_REFRESH sent");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m9734(Context context, String str) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.BA_LIST_REFRESH");
        intent.addCategory(str);
        context.sendBroadcast(intent);
        C1283.m16848("ServiceManager", "Intent BROWSE_AGENT_LIST_REFRESH sent for category %s", str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public pV m9766(String str) {
        AbstractC1853hl r1;
        if (!mo9519() || (r1 = m9832()) == null) {
            return null;
        }
        return vO.m12029(r1).mo11976(str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m9774(pV pVVar) {
        return pVVar != null && pVVar.mo6881() == DownloadState.Complete;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m9815(Intent intent) {
        if (this.f9393 == null) {
            C1283.m16850("ServiceManager", "sendIntentToNetflixService mService is null");
        } else {
            this.f9393.mo9444(intent);
        }
    }
}
