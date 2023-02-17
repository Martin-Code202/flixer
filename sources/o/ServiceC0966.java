package o;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.util.SparseArray;
import com.crittercism.app.Crittercism;
import com.netflix.mediaclient.InstallReferrerReceiver;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.media.BookmarkStore;
import com.netflix.mediaclient.net.NetworkRequestLogger;
import com.netflix.mediaclient.service.NetflixPowerManager;
import com.netflix.mediaclient.service.NetflixService$1;
import com.netflix.mediaclient.service.NetflixService$2$1;
import com.netflix.mediaclient.service.NetflixService$2$2;
import com.netflix.mediaclient.service.NetflixService$2$3;
import com.netflix.mediaclient.service.api.diagnostics.IDiagnosis;
import com.netflix.mediaclient.service.job.NetflixJob;
import com.netflix.mediaclient.service.logging.perf.Events;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.service.mdx.logging.connection.MdxConnectionLogblobLogger;
import com.netflix.mediaclient.service.pservice.logging.PServiceLogging;
import com.netflix.mediaclient.service.pushnotification.PushNotificationAgent;
import com.netflix.mediaclient.service.user.UserAgent;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.model.leafs.AccountData;
import com.netflix.mediaclient.service.webclient.model.leafs.AvatarInfo;
import com.netflix.mediaclient.service.webclient.model.leafs.ConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.EogAlert;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IVoip;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.error.CryptoErrorManager;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.DeviceCategory;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import com.netflix.model.leafs.OnRampEligibility;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.AbstractC1052;
/* renamed from: o.ᴭ  reason: contains not printable characters */
public final class ServiceC0966 extends Service implements oE, AbstractC0933 {

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private static boolean f14889;

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1698eK f14890;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private AbstractC2228v f14891;

    /* renamed from: ʼ  reason: contains not printable characters */
    private PushNotificationAgent f14892;

    /* renamed from: ʽ  reason: contains not printable characters */
    private iE f14893;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final Cif f14894 = new Cif();

    /* renamed from: ʾ  reason: contains not printable characters */
    private final ArrayList<AbstractC2406iF> f14895 = new ArrayList<>();

    /* renamed from: ʿ  reason: contains not printable characters */
    private Status f14896 = AbstractC0367.f13212;

    /* renamed from: ˈ  reason: contains not printable characters */
    private volatile boolean f14897 = false;

    /* renamed from: ˉ  reason: contains not printable characters */
    private String f14898 = null;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1079 f14899;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private long f14900;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private boolean f14901 = false;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private mV f14902;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private NetflixPowerManager f14903;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1926k f14904;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private final Set<Integer> f14905 = new HashSet();

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private BookmarkStore f14906;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C2029oe f14907;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private C1068 f14908;

    /* renamed from: ˌ  reason: contains not printable characters */
    private C0955 f14909;

    /* renamed from: ˍ  reason: contains not printable characters */
    private C1968m f14910;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Map<NetflixJob.NetflixJobId, AbstractC2051p> f14911 = new HashMap();

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private C0961 f14912;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private C1869i f14913;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1260 f14914;

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private List<NetflixDataRequest> f14915 = new ArrayList();

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private C0658 f14916;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private C1468a f14917;

    /* renamed from: ˑ  reason: contains not printable characters */
    private C1861hs f14918;

    /* renamed from: ͺ  reason: contains not printable characters */
    private C1954l f14919;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private CryptoErrorManager f14920;

    /* renamed from: ـ  reason: contains not printable characters */
    private final BroadcastReceiver f14921 = new BroadcastReceiver() { // from class: o.ᴭ.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1283.m16862("NetflixService", "mNetworkChangeReceiver onReceive");
            ServiceC0966.this.f14928.removeCallbacks(ServiceC0966.this.f14934);
            ServiceC0966.this.f14928.postDelayed(ServiceC0966.this.f14934, 1000);
        }
    };

    /* renamed from: ॱ  reason: contains not printable characters */
    private UserAgent f14922;

    /* renamed from: ॱʻ  reason: contains not printable characters */
    private final IBinder f14923 = new BinderC0967();

    /* renamed from: ॱʼ  reason: contains not printable characters */
    private final BroadcastReceiver f14924 = new BroadcastReceiver() { // from class: o.ᴭ.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            boolean z2 = false;
            String action = intent.getAction();
            if (action == null) {
                C1283.m16862("NetflixService", "intent action is not set.");
                return;
            }
            pF r8 = m15868();
            VideoType r9 = m15867();
            char c = 65535;
            switch (action.hashCode()) {
                case -1622678632:
                    if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_STATE")) {
                        c = 2;
                        break;
                    }
                    break;
                case -675501401:
                    if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_PLAYBACKEND")) {
                        c = 0;
                        break;
                    }
                    break;
                case -603676882:
                    if (action.equals("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_PLAYBACKSTART")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    C1283.m16851("NetflixService", "mdx exit, stop service in %sms", 28800000L);
                    ServiceC0966.this.m15797(28800000);
                    if (r8 != null) {
                        z = r8.isPinProtected();
                        z2 = r8.isPreviewProtected();
                    }
                    C1061.m16114().mo14167(z, z2);
                    if (intent.getBooleanExtra("updateCW", true)) {
                        C1283.m16854("NetflixService", "Refreshing CW for MDX_ACTION_UPDATE_PLAYBACKEND...");
                        C1276.m16820().mo5728("mdx.cw.refresh");
                        ServiceC0966.this.mo9432().mo8494(false, null);
                        ServiceC0966.this.mo9432().mo8473();
                        return;
                    }
                    return;
                case 1:
                    if (null == ServiceC0966.this.f14890 || !ServiceC0966.this.f14890.m6178()) {
                        C1283.m16850("NetflixService", "false MDX_ACTION_UPDATE_PLAYBACKSTART");
                        return;
                    }
                    C1283.m16862("NetflixService", "start mdx notification");
                    ServiceC0966.this.m15832();
                    if (r8 != null) {
                        C1283.m16854("NetflixService", "refreshing episodes data on play start");
                        ServiceC0966.this.mo9432().mo8470(r8.getPlayableId(), r9);
                        return;
                    }
                    return;
                case 2:
                    int intExtra = intent.getIntExtra("time", -1);
                    C1283.m16846("NetflixService", "on MDX state update - received updated mdx position: " + intExtra);
                    if (r8 != null) {
                        C1283.m16846("NetflixService", "updating cached video position");
                        ServiceC0966.this.mo9432().mo8471(r8.getPlayableId(), r9, intExtra);
                        z = r8.isPinProtected();
                        z2 = r8.isPreviewProtected();
                    }
                    C1061.m16114().mo14167(z, z2);
                    return;
                default:
                    C1283.m16850("NetflixService", "invalid action type.");
                    return;
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private pF m15868() {
            pF playable = ServiceC0966.this.f14890.mo6183() != null ? ServiceC0966.this.f14890.mo6183().getPlayable() : null;
            if (playable == null || !C1349Bv.m4107(playable.getPlayableId())) {
                return null;
            }
            return playable;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private VideoType m15867() {
            return ServiceC0966.this.f14890.mo6183() != null ? ServiceC0966.this.f14890.mo6183().getType() : VideoType.UNKNOWN;
        }
    };

    /* renamed from: ॱʽ  reason: contains not printable characters */
    private final AbstractC1052.If f14925 = new AbstractC1052.If() { // from class: o.ᴭ.13
        @Override // o.AbstractC1052.If
        /* renamed from: ˋ  reason: contains not printable characters */
        public Context mo15853() {
            return ServiceC0966.this.getApplicationContext();
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ˏ  reason: contains not printable characters */
        public UserAgentInterface mo15856() {
            return ServiceC0966.this.f14922;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ˎ  reason: contains not printable characters */
        public AbstractC1221 mo15855() {
            return ServiceC0966.this.f14914;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ॱ  reason: contains not printable characters */
        public AbstractC1194 mo15859() {
            return ServiceC0966.this.f14899;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ˊ  reason: contains not printable characters */
        public C2003ng mo15851() {
            return ServiceC0966.this.f14930;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ᐝ  reason: contains not printable characters */
        public AbstractC1899j mo15863() {
            return ServiceC0966.this.f14904;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ʼ  reason: contains not printable characters */
        public mU mo15849() {
            return ServiceC0966.this.f14902;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ॱॱ  reason: contains not printable characters */
        public oH mo15862() {
            return ServiceC0966.this.f14917;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ʻ  reason: contains not printable characters */
        public IClientLogging mo15847() {
            return ServiceC0966.this.f14932;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ʽ  reason: contains not printable characters */
        public oD mo15850() {
            return ServiceC0966.this.f14927;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ͺ  reason: contains not printable characters */
        public AbstractC1853hl mo15858() {
            return ServiceC0966.this.f14931;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ॱˊ  reason: contains not printable characters */
        public AbstractC1897iy mo15860() {
            return ServiceC0966.this.f14931;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ˋॱ  reason: contains not printable characters */
        public AbstractC2064pm mo15854() {
            return ServiceC0966.this.f14927;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ˊॱ  reason: contains not printable characters */
        public AbstractC1250 mo15852() {
            return ServiceC0966.this;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ˏॱ  reason: contains not printable characters */
        public oS mo15857() {
            return ServiceC0966.this;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ʻॱ  reason: contains not printable characters */
        public AbstractC0933 mo15848() {
            return ServiceC0966.this;
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ॱˎ  reason: contains not printable characters */
        public BookmarkStore mo15861() {
            return ServiceC0966.this.mo9450();
        }

        @Override // o.AbstractC1052.If
        /* renamed from: ᐝॱ  reason: contains not printable characters */
        public ImageLoader mo15864() {
            return ServiceC0966.this.mo9404();
        }
    };

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C1524b f14926;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private C1838gx f14927;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private Handler f14928;

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private final Runnable f14929 = new Runnable() { // from class: o.ᴭ.2
        @Override // java.lang.Runnable
        public void run() {
            ServiceC0966.this.m15836();
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C2003ng f14930;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C1856ho f14931;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private N f14932;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private C1842ha f14933;

    /* renamed from: ᐨ  reason: contains not printable characters */
    private final Runnable f14934 = new Runnable() { // from class: o.ᴭ.1
        @Override // java.lang.Runnable
        public void run() {
            ServiceC0966.this.m15840();
        }
    };

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᴭ$iF  reason: case insensitive filesystem */
    public interface AbstractC2406iF {
        /* renamed from: ˊ  reason: contains not printable characters */
        void mo15869();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m15814() {
        return f14889;
    }

    @Override // android.app.Service
    public void onCreate() {
        C1283.m16862("NetflixService", "NetflixService.onCreate.");
        PerformanceProfiler.INSTANCE.m663(Sessions.NETFLIX_SERVICE_LOADED);
        super.onCreate();
        Context applicationContext = getApplicationContext();
        f14889 = true;
        this.f14900 = System.currentTimeMillis();
        MdxConnectionLogblobLogger.m690();
        this.f14928 = new Handler();
        C1318At.m3775(applicationContext);
        this.f14891 = AbstractApplicationC1258.getInstance().mo258();
        this.f14920 = (CryptoErrorManager) C1281.m16832(CryptoErrorManager.class);
        this.f14916 = new C0658(getApplicationContext());
        NetworkRequestLogger.INSTANCE.m476(this.f14925, this.f14900);
        this.f14916.m14827(NetworkRequestLogger.INSTANCE);
        this.f14914 = new C1260(getApplicationContext(), this.f14920);
        this.f14899 = new C1079(getApplicationContext(), this.f14914);
        this.f14927 = new C1838gx(this.f14916, this.f14920);
        this.f14906 = new BookmarkStore(applicationContext);
        this.f14922 = new UserAgent(applicationContext, this.f14906);
        this.f14930 = new C2003ng(applicationContext, this.f14916);
        iT iTVar = new iT(this, getApplicationContext(), this.f14914, this.f14922);
        this.f14893 = new iE(getApplicationContext(), iTVar, this.f14914, this.f14922, this.f14916);
        this.f14892 = new PushNotificationAgent(applicationContext, this.f14922);
        this.f14932 = new N(applicationContext, this.f14914, this.f14922);
        this.f14926 = new C1524b();
        this.f14904 = new C1926k(this.f14914, this.f14922, this.f14892);
        this.f14918 = new C1861hs(this.f14904, this.f14906);
        this.f14919 = new C1954l(this.f14904, this.f14894);
        this.f14917 = new C1468a();
        this.f14907 = new C2029oe(this.f14914, this.f14922);
        this.f14910 = new C1968m(applicationContext, this.f14891, this.f14914, this.f14932);
        mo15841(NetflixJob.NetflixJobId.NETFLIX_MAINTENANCE, this.f14910);
        this.f14913 = new C1869i(this.f14891, this.f14930, this.f14904, this.f14922);
        mo15841(NetflixJob.NetflixJobId.INSOMNIA, this.f14913);
        this.f14903 = new NetflixPowerManager(applicationContext);
        this.f14931 = new C1856ho(applicationContext, iTVar, this.f14914, this.f14922, this.f14918, this.f14910, this.f14916, this.f14903, this.f14906);
        this.f14902 = new mV(this.f14910, this.f14922);
        this.f14908 = new C1068(applicationContext, this, this.f14893);
        this.f14933 = new C1842ha(this.f14916);
        this.f14920.mo1739(applicationContext, m15846(), this.f14922, this.f14931, this.f14917, this.f14932.mo1515());
        m15831();
    }

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    private void m15828() {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15809(Intent intent) {
        if (C1317As.m3774() && intent.getBooleanExtra("start_foreground", false)) {
            C1283.m16854("NetflixService", "Start service foreground...");
            int i = 30;
            Notification notification = null;
            switch (intent.getIntExtra("start_requester", -1)) {
                case 1:
                    notification = InstallReferrerReceiver.m215(getApplicationContext());
                    break;
                case 2:
                    i = 32;
                    notification = mV.m8966(getApplicationContext());
                    break;
            }
            if (notification != null) {
                C1283.m16854("NetflixService", "sending foreground notification");
                mo9579(i, notification);
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        PerformanceProfiler.INSTANCE.m669(Events.NETFLIX_SERVICE_STARTED_COMMAND, (Map<String, String>) null);
        if (intent == null) {
            return 2;
        }
        m15809(intent);
        if (this.f14897) {
            m15798(intent);
            return 2;
        }
        this.f14895.add(new C0969(intent, i, i2));
        return 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m15798(Intent intent) {
        C1283.m16853("NetflixService", "Received start command intent ", intent);
        String action = intent.getAction();
        if (!C1349Bv.m4113(action)) {
            if ("com.netflix.mediaclient.service.ACTION_SHUTDOWN_SERVICE".equals(action)) {
                C1283.m16862("NetflixService", "Stopping service via shutdown intent...");
                f14889 = false;
                stopSelf();
                return;
            }
            m15832();
            if (intent.hasCategory("com.netflix.mediaclient.intent.category.offline")) {
                C1283.m16854("NetflixService", "Offline command intent ");
                if (!this.f14931.r_() || !this.f14931.mo7118()) {
                    C1283.m16850("NetflixService", "received a command while offline agent is not ready");
                } else {
                    this.f14931.m7283().mo7288(intent);
                }
            }
            if (intent.hasCategory("com.netflix.mediaclient.intent.category.MDX") && this.f14901) {
                C1283.m16854("NetflixService", "MDX command intent ");
                this.f14890.m6166(intent);
            }
            if (intent.hasCategory("com.netflix.mediaclient.intent.category.PUSH") && (this.f14892.m1239() || intent.hasExtra("swiped_notification_id"))) {
                C1283.m16854("NetflixService", "Push notification command intent ");
                this.f14892.m1247(intent);
            }
            if (intent.hasCategory("com.netflix.mediaclient.intent.category.LOGGING")) {
                C1283.m16854("NetflixService", "Client logging command intent ");
                this.f14932.m5202(intent);
            }
            if (intent.hasCategory("com.netflix.mediaclient.intent.category.USER")) {
                C1283.m16854("NetflixService", "User agent command intent ");
                this.f14922.m1370(intent);
            }
            if (intent.hasCategory("com.netflix.mediaclient.intent.category.CATEGORY_FROM_WIDGET_PROVIDER")) {
                C1283.m16854("NetflixService", "app widget command intent ");
                this.f14902.m8967(intent);
            }
        }
    }

    /* renamed from: o.ᴭ$ˎ  reason: contains not printable characters */
    final class C0969 implements AbstractC2406iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final int f14969;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final int f14970;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final Intent f14971;

        public C0969(Intent intent, int i, int i2) {
            this.f14971 = intent;
            this.f14970 = i;
            this.f14969 = i2;
        }

        @Override // o.ServiceC0966.AbstractC2406iF
        /* renamed from: ˊ */
        public void mo15869() {
            if (ServiceC0966.this.f14896.mo298()) {
                ServiceC0966.this.m15798(this.f14971);
            }
        }
    }

    /* renamed from: ᐨ  reason: contains not printable characters */
    private synchronized void m15831() {
        AbstractApplicationC1258.getInstance().mo245();
        final NetflixService$1 netflixService$1 = new NetflixService$1(this);
        final AnonymousClass4 r5 = new AbstractC1052.AbstractC1053() { // from class: o.ᴭ.4

            /* renamed from: ˊ  reason: contains not printable characters */
            private final ArrayList<AbstractC1052> f14944 = new NetflixService$2$2(this);

            /* renamed from: ˋ  reason: contains not printable characters */
            final ArrayList<AbstractC1052> f14945 = new NetflixService$2$3(this);

            /* renamed from: ॱ  reason: contains not printable characters */
            private final ArrayList<AbstractC1052> f14948 = new NetflixService$2$1(this);

            @Override // o.AbstractC1052.AbstractC1053
            /* renamed from: ˏ  reason: contains not printable characters */
            public void mo15866(AbstractC1052 r8, Status status) {
                C1348Bu.m4093();
                if (!ServiceC0966.this.m15811(r8, status, netflixService$1, this)) {
                    C1283.m16851("NetflixService", "NetflixService successfully initiated ServiceAgent %s", r8.getClass().getSimpleName());
                    if (r8 == ServiceC0966.this.f14927) {
                        C1283.m16854("NetflixService", "Go for batch1!");
                        Iterator<AbstractC1052> it = this.f14948.iterator();
                        while (it.hasNext()) {
                            AbstractC1052 next = it.next();
                            if (!next.x_()) {
                                next.m16091(ServiceC0966.this.f14925, this);
                            } else {
                                C1283.m16855("NetflixService", "Agent %s from batch1 already initialized!", next.getClass().getSimpleName());
                            }
                        }
                    } else if (this.f14948.contains(r8)) {
                        C1283.m16851("NetflixService", "Remove %s from batch1", r8.getClass().getSimpleName());
                        this.f14948.remove(r8);
                        if (this.f14948.isEmpty()) {
                            C1283.m16854("NetflixService", "NetflixService successfully inited batch1 of ServiceAgents");
                            Iterator<AbstractC1052> it2 = this.f14944.iterator();
                            while (it2.hasNext()) {
                                AbstractC1052 next2 = it2.next();
                                if (!next2.x_()) {
                                    next2.m16091(ServiceC0966.this.f14925, this);
                                } else {
                                    C1283.m16855("NetflixService", "Agent %s from batch2 already initialized!", next2.getClass().getSimpleName());
                                }
                            }
                        }
                    } else {
                        C1283.m16851("NetflixService", "Remove %s from batch2", r8.getClass().getSimpleName());
                        m15865(r8);
                        this.f14944.remove(r8);
                        if (this.f14944.isEmpty()) {
                            C1283.m16862("NetflixService", "NetflixService successfully inited all ServiceAgents ");
                            ServiceC0966.this.f14896 = status;
                            if (ServiceC0966.this.f14896.mo298()) {
                                if (ServiceC0966.this.f14914.m16745()) {
                                    ServiceC0966.this.f14896 = AbstractC0367.f13243;
                                    C1283.m16865("NetflixService", "Current app is obsolete. It should not run!");
                                } else if (!ServiceC0966.this.f14914.m16742()) {
                                    C1283.m16865("NetflixService", "Current app is not recommended. User should be warned!");
                                    ServiceC0966.this.f14896 = AbstractC0367.f13225;
                                }
                            }
                            ServiceC0966.this.m15834();
                        }
                        Iterator<AbstractC1052> it3 = this.f14944.iterator();
                        while (it3.hasNext()) {
                            AbstractC1052 next3 = it3.next();
                            if (!next3.r_()) {
                                C1283.m16851("NetflixService", "NetflixService still waiting for init of ServiceAgent %s", next3.getClass().getSimpleName());
                            }
                        }
                    }
                }
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            private void m15865(AbstractC1052 r4) {
                boolean remove = this.f14945.remove(r4);
                if (remove) {
                    boolean isEmpty = this.f14945.isEmpty();
                    if (remove && isEmpty) {
                        ServiceC0966.this.m15830();
                    }
                }
            }
        };
        final AnonymousClass8 r6 = new AbstractC1052.AbstractC1053() { // from class: o.ᴭ.8
            @Override // o.AbstractC1052.AbstractC1053
            /* renamed from: ˏ */
            public void mo15866(AbstractC1052 r62, Status status) {
                C1283.m16851("NetflixService", "agentsToInitOnErrorCallback agent inited: %s ", r62.getClass().getSimpleName());
            }
        };
        final AnonymousClass7 r7 = new AbstractC1052.AbstractC1053() { // from class: o.ᴭ.7
            @Override // o.AbstractC1052.AbstractC1053
            /* renamed from: ˏ */
            public void mo15866(AbstractC1052 r62, Status status) {
                C1348Bu.m4093();
                if (!ServiceC0966.this.m15811(r62, status, netflixService$1, r6)) {
                    C1283.m16863("NetflixService", "NetflixService successfully inited ServiceAgent %s", r62.getClass().getSimpleName());
                    ServiceC0966.this.f14927.m16091(ServiceC0966.this.f14925, r5);
                }
            }
        };
        AnonymousClass6 r8 = new AbstractC1052.AbstractC1053() { // from class: o.ᴭ.6
            @Override // o.AbstractC1052.AbstractC1053
            /* renamed from: ˏ */
            public void mo15866(AbstractC1052 r62, Status status) {
                C1348Bu.m4093();
                if (!ServiceC0966.this.m15811(r62, status, netflixService$1, r6)) {
                    C1283.m16863("NetflixService", "NetflixService successfully inited ServiceAgent %s", r62.getClass().getSimpleName());
                    ServiceC0966.this.f14914.m16091(ServiceC0966.this.f14925, r7);
                }
            }
        };
        C1283.m16862("NetflixService", "NetflixService initing...");
        this.f14930.m16091(this.f14925, r8);
        C0938.f14820.m15750(this.f14915, this.f14930, this.f14914);
        this.f14928.postDelayed(this.f14929, 90000);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐧ  reason: contains not printable characters */
    private void m15830() {
        if (m15833() && mo9456()) {
            this.f14904.m8162(0, (String) null, false, (AbstractC1203) null);
        }
    }

    /* renamed from: ㆍ  reason: contains not printable characters */
    private boolean m15833() {
        int r5 = C0406.m14192().mo14200();
        C1283.m16851("NetflixService", "Number of activities count = %d", Integer.valueOf(r5));
        return r5 > 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m15811(AbstractC1052 r8, Status status, List<AbstractC1052> list, AbstractC1052.AbstractC1053 r11) {
        if (!status.mo301()) {
            return false;
        }
        C1283.m16850("NetflixService", "NetflixService init failed with ServiceAgent " + r8.getClass().getSimpleName() + " statusCode=" + status.mo302());
        this.f14896 = status;
        for (AbstractC1052 r6 : list) {
            if (!r6.x_()) {
                r6.m16091(this.f14925, r11);
            } else {
                C1283.m16855("NetflixService", "Agent %s from error batch already initialized!", r6.getClass().getSimpleName());
            }
        }
        m15834();
        stopSelf();
        return true;
    }

    /* renamed from: ꜞ  reason: contains not printable characters */
    private void m15835() {
        PServiceLogging.reportStoredLogEvents(getApplicationContext(), mo9456());
        boolean r2 = C1339Bl.m4040();
        BW.m3935(!r2, C1339Bl.m4050());
        BW.m3941(ApplicationPerformanceMetricsLogging.Trigger.appStart);
        BW.m3940(getApplicationContext());
        C0684.m14963(getApplicationContext());
        C1360Cf.m4369();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ꓸ  reason: contains not printable characters */
    private void m15834() {
        C1348Bu.m4093();
        PerformanceProfiler.INSTANCE.m672(Sessions.NETFLIX_SERVICE_LOADED);
        this.f14928.removeCallbacks(this.f14929);
        this.f14908.m16140();
        m15835();
        C1283.m16854("NetflixService", "Invoking InitCallbacks...");
        Iterator<AbstractC2406iF> it = this.f14895.iterator();
        while (it.hasNext()) {
            it.next().mo15869();
        }
        this.f14895.clear();
        this.f14897 = true;
        if (this.f14896.mo298()) {
            getApplicationContext().registerReceiver(this.f14921, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f14892.m1244();
            this.f14931.m7285();
            this.f14930.m9301();
            C1283.m16854("NetflixService", "Send local intent that Netflix service is ready");
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.NETFLIX_SERVICE_INIT_COMPLETE");
            intent.putExtra("status_code", this.f14896.mo302());
            intent.addCategory("com.netflix.mediaclient.intent.category.NETFLIX_SERVICE");
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
            this.f14898 = this.f14931.mo7118() ? "user_flow_offline" : null;
            if (this.f14898 != null) {
                C1283.m16851("NetflixService", "begin user flow %s", this.f14898);
                Crittercism.beginUserflow(this.f14898);
            }
            m15821(this.f14925, new AbstractC1052.AbstractC1053() { // from class: o.ᴭ.9
                @Override // o.AbstractC1052.AbstractC1053
                /* renamed from: ˏ */
                public void mo15866(AbstractC1052 r3, Status status) {
                    if (status.mo301()) {
                        ServiceC0966.this.f14890 = null;
                    }
                }
            });
            m15837();
        }
        m15828();
        int i = SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS / 1000;
        C1283.m16851("NetflixService", "StopService runnable posted - service will die in %d seconds unless bound to or started...", 60);
        m15797(60000);
        C1283.m16866("NetflixService", "NetflixService init took=%d", Long.valueOf(System.currentTimeMillis() - this.f14900));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ꜟ  reason: contains not printable characters */
    private void m15836() {
        C1283.m16862("NetflixService", "Service init has timed out");
        this.f14896 = AbstractC0367.f13223;
        m15834();
        stopSelf();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C1283.m16862("NetflixService", "NetflixService.onDestroy.");
        m15832();
        C1283.m16854("NetflixService", "Send local intent that Netflix service is destroyed");
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.NETFLIX_SERVICE_DESTROYED");
        intent.addCategory("com.netflix.mediaclient.intent.category.NETFLIX_SERVICE");
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        if (this.f14909 != null) {
            m15805(this.f14909, "PartnerOfflineBroadcastReceiver");
        }
        if (this.f14912 != null) {
            m15805(this.f14912, "PartnerUserAgentBroadcastReceiver");
        }
        if (this.f14901) {
            m15805(this.f14924, "MDX receiver");
        }
        m15805(this.f14921, "network receiver");
        this.f14894.clear();
        if (this.f14901 && this.f14890 != null) {
            this.f14890.mo1236();
        }
        if (this.f14904 != null) {
            this.f14904.mo1236();
        }
        if (this.f14893 != null) {
            this.f14893.mo1236();
        }
        if (this.f14922 != null) {
            this.f14922.mo1236();
        }
        if (this.f14914 != null) {
            this.f14914.mo1236();
        }
        if (this.f14899 != null) {
            this.f14899.mo1236();
        }
        if (this.f14930 != null) {
            this.f14930.mo1236();
        }
        if (this.f14932 != null) {
            this.f14932.mo1236();
        }
        if (this.f14926 != null) {
            this.f14926.mo1236();
        }
        if (this.f14907 != null) {
            this.f14907.mo1236();
        }
        if (this.f14931 != null) {
            this.f14931.mo1236();
        }
        if (this.f14927 != null) {
            this.f14927.mo1236();
        }
        if (this.f14903 != null) {
            this.f14903.m494();
        }
        if (this.f14910 != null) {
            this.f14910.m8792();
        }
        if (this.f14908 != null) {
            this.f14908.m16139();
        }
        if (this.f14933 != null) {
            this.f14933.mo1236();
        }
        if (this.f14913 != null) {
            this.f14913.m7391();
        }
        this.f14891 = null;
        this.f14911.clear();
        f14889 = false;
        int myPid = Process.myPid();
        C1283.m16854("NetflixService", "Destroying app process " + myPid + "...");
        Process.killProcess(myPid);
        C1283.m16854("NetflixService", "Destroying app process " + myPid + " done.");
    }

    @Override // o.oE
    /* renamed from: ˊ */
    public ImageLoader mo9404() {
        return this.f14930.m9305(getApplicationContext());
    }

    @Override // o.oE
    /* renamed from: ˎ */
    public AbstractC0933 mo9426() {
        return this;
    }

    @Override // o.AbstractC0933
    /* renamed from: ˏ */
    public void mo15746(String str, int i, int i2, AbstractC0957 r10) {
        mo9404().mo3059(str, AssetType.boxArt, i, i2, r10);
    }

    @Override // o.AbstractC0933
    /* renamed from: ˋ */
    public void mo15744(String str, int i, int i2, AbstractC0957 r10) {
        mo9404().mo3059(str, AssetType.merchStill, i, i2, r10);
    }

    @Override // o.AbstractC0933
    /* renamed from: ˎ */
    public void mo15745(String str, AbstractC2006nj njVar) {
        this.f14930.m9309(str, AssetType.boxArt, njVar);
    }

    @Override // o.oE
    /* renamed from: ˏ */
    public void mo9434(String str, AssetType assetType, int i, int i2) {
        this.f14930.m9307(str, assetType, new C2405If(i, i2));
    }

    /* renamed from: o.ᴭ$If  reason: case insensitive filesystem */
    class C2405If extends C2005ni {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final int f14963;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final int f14964;

        C2405If(int i, int i2) {
            this.f14963 = i;
            this.f14964 = i2;
        }

        @Override // o.C2005ni, o.AbstractC2006nj
        /* renamed from: ˎ */
        public void mo8943(String str, String str2, Status status) {
            super.mo8943(str, str2, status);
            oL oLVar = (oL) ServiceC0966.this.f14894.get(this.f14963);
            if (oLVar == null) {
                C1283.m16865("NetflixService", "No client callback found for onResourceFetched");
                return;
            }
            oLVar.mo9559(this.f14964, str, str2, status);
            C1860hr.m7330(ServiceC0966.this.getApplicationContext());
        }

        @Override // o.C2005ni, o.AbstractC2006nj
        /* renamed from: ˎ */
        public void mo9311(String str, String str2, long j, long j2, Status status) {
            super.mo9311(str, str2, j, j2, status);
            oL oLVar = (oL) ServiceC0966.this.f14894.get(this.f14963);
            if (oLVar == null) {
                C1283.m16865("NetflixService", "No client callback found for onResourceCached");
            } else {
                oLVar.mo9544(this.f14964, str, str2, j, j2, status);
            }
        }
    }

    @Override // o.oE
    /* renamed from: ᐝ */
    public String mo9458() {
        return this.f14922.mo1328().m3973();
    }

    @Override // o.oE
    /* renamed from: ˎ */
    public void mo9429(String str) {
        this.f14922.m1330(str);
    }

    @Override // o.oE
    /* renamed from: ॱ */
    public void mo9449(boolean z) {
        this.f14922.m1352(z);
    }

    @Override // o.oE
    /* renamed from: ʻ */
    public boolean mo9394() {
        return this.f14922.m1385();
    }

    @Override // o.oE
    /* renamed from: ॱॱ */
    public boolean mo9456() {
        return this.f14922.mo1333();
    }

    @Override // o.oE
    /* renamed from: ʽ */
    public String mo9398() {
        return this.f14922.m1342();
    }

    @Override // o.oE
    /* renamed from: ˊ */
    public void mo9409(String str, String str2) {
        this.f14922.m1336(str, str2);
    }

    @Override // o.oE
    /* renamed from: ˊ */
    public void mo9408(String str) {
        this.f14922.m1376(str);
    }

    @Override // o.oE
    /* renamed from: ˏ */
    public void mo9435(String str, String str2) {
        this.f14922.m1348(str, str2);
    }

    @Override // o.oE
    /* renamed from: ʼ */
    public EogAlert mo9396() {
        return this.f14922.m1373();
    }

    @Override // o.oE
    /* renamed from: ॱˊ */
    public Single<Status> mo9452() {
        return this.f14922.m1372();
    }

    @Override // o.oE
    /* renamed from: ˋॱ */
    public Observable<Status> mo9422() {
        return this.f14922.m1371();
    }

    @Override // o.oE
    /* renamed from: ˏॱ */
    public void mo9439() {
        this.f14922.m1363();
    }

    @Override // o.oE
    /* renamed from: ͺ */
    public UmaAlert mo9440() {
        return this.f14922.m1381();
    }

    @Override // o.oE
    /* renamed from: ˊॱ */
    public void mo9412() {
        this.f14922.m1379();
    }

    @Override // o.oE
    /* renamed from: ॱᐝ */
    public boolean mo9457() {
        return this.f14922.m1382();
    }

    @Override // o.oE
    /* renamed from: ॱˎ */
    public boolean mo9454() {
        return this.f14922.m1341();
    }

    @Override // o.oE
    /* renamed from: ॱˋ */
    public AbstractC2089qj mo9453() {
        return this.f14922.mo1383();
    }

    @Override // o.oE
    /* renamed from: ᐝॱ */
    public List<? extends AbstractC2089qj> mo9461() {
        return this.f14922.m1334();
    }

    @Override // o.oE
    /* renamed from: ॱ */
    public void mo9446(String str) {
        this.f14922.m1357(str);
    }

    @Override // o.oE
    /* renamed from: ˏ */
    public void mo9436(String str, boolean z, String str2, int i, int i2) {
        this.f14922.m1366(str, z, str2, new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ˋ */
    public void mo9417(String str, String str2, boolean z, String str3, int i, int i2) {
        this.f14922.m1337(str, str2, z, str3, new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ˋ */
    public void mo9416(String str, int i, int i2) {
        this.f14922.m1350(str, new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ॱ */
    public void mo9443(int i, int i2) {
        this.f14922.m1351(new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ʻॱ */
    public boolean mo9395() {
        return this.f14922.m1369();
    }

    @Override // o.oE
    /* renamed from: ˈ */
    public void mo9402() {
        this.f14922.m1344();
    }

    /* renamed from: o.ᴭ$IF */
    class IF implements AbstractC2021ny {

        /* renamed from: ˏ  reason: contains not printable characters */
        private final int f14961;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final int f14962;

        IF(int i, int i2) {
            this.f14962 = i;
            this.f14961 = i2;
        }

        @Override // o.AbstractC2021ny
        /* renamed from: ˏ */
        public void mo9381(Status status) {
            oL oLVar = (oL) ServiceC0966.this.f14894.get(this.f14962);
            if (oLVar == null) {
                C1283.m16865("NetflixService", "No client callback found for onLoginComplete");
                return;
            }
            C1283.m16854("NetflixService", "Notified onLoginComplete");
            oLVar.mo9549(this.f14961, status);
        }

        @Override // o.AbstractC2021ny
        /* renamed from: ˊ */
        public void mo9376(Status status) {
            oL oLVar = (oL) ServiceC0966.this.f14894.get(this.f14962);
            if (oLVar == null) {
                C1283.m16865("NetflixService", "No client callback found for onLogoutComplete");
                return;
            }
            C1283.m16854("NetflixService", "Notified onLogoutComplete");
            oLVar.mo9541(this.f14961, status);
        }

        @Override // o.AbstractC2021ny
        /* renamed from: ˊ */
        public void mo9378(boolean z, Status status) {
            oL oLVar = (oL) ServiceC0966.this.f14894.get(this.f14962);
            if (oLVar == null) {
                C1283.m16865("NetflixService", "No client callback found for onVerified");
                return;
            }
            C1283.m16854("NetflixService", "Notified onVerified");
            oLVar.mo9539(this.f14961, z, status);
        }

        @Override // o.AbstractC2021ny
        /* renamed from: ˏ */
        public void mo9384(List<AvatarInfo> list, Status status) {
            oL oLVar = (oL) ServiceC0966.this.f14894.get(this.f14962);
            if (oLVar == null) {
                C1283.m16865("NetflixService", "No client callback found for onAvailableAvatarsListFetched");
                return;
            }
            C1283.m16854("NetflixService", "Notified onAvailableAvatarsListFetched");
            oLVar.mo9555(this.f14961, list, status);
        }

        @Override // o.AbstractC2021ny
        /* renamed from: ˎ */
        public void mo9380(Status status) {
            oL oLVar = (oL) ServiceC0966.this.f14894.get(this.f14962);
            if (oLVar == null) {
                C1283.m16865("NetflixService", "No client callback found for onProfilesListUpdateResult");
                return;
            }
            C1283.m16854("NetflixService", "Notified onProfilesListUpdateResult");
            oLVar.mo9520(this.f14961, status);
        }

        @Override // o.AbstractC2021ny
        /* renamed from: ˊ */
        public void mo9377(String str, Status status) {
            oL oLVar = (oL) ServiceC0966.this.f14894.get(this.f14962);
            if (oLVar == null) {
                C1283.m16865("NetflixService", "No client callback found for onAutoLoginTokenCreated");
                return;
            }
            C1283.m16854("NetflixService", "Notified onAutoLoginTokenCreated");
            oLVar.mo9543(this.f14961, str, status);
        }

        @Override // o.AbstractC2021ny
        /* renamed from: ˋ */
        public void mo9379(CL cl, Status status) {
            oL oLVar = (oL) ServiceC0966.this.f14894.get(this.f14962);
            if (oLVar == null) {
                C1283.m16865("NetflixService", "No client callback found for onSurveyFetched");
                return;
            }
            C1283.m16854("NetflixService", "Notified onSurveyFetched");
            oLVar.mo9562(this.f14961, cl, status);
        }

        @Override // o.AbstractC2021ny
        /* renamed from: ॱ */
        public void mo9385(Status status) {
            oL oLVar = (oL) ServiceC0966.this.f14894.get(this.f14962);
            if (oLVar == null) {
                C1283.m16865("NetflixService", "No client callback found for onUpdatePlanCompleted");
                return;
            }
            C1283.m16854("NetflixService", "Notified onSurveyFetched");
            oLVar.mo9569(this.f14961, status);
        }

        @Override // o.AbstractC2021ny
        /* renamed from: ˏ */
        public void mo9383(OnRampEligibility onRampEligibility, Status status) {
            oL oLVar = (oL) ServiceC0966.this.f14894.get(this.f14962);
            if (oLVar == null) {
                C1283.m16865("NetflixService", "No client callback found for onOnRampEligibilityActionComplete");
                return;
            }
            C1283.m16854("NetflixService", "Notified onOnRampEligibilityActionComplete");
            oLVar.mo9533(this.f14961, onRampEligibility, status);
        }

        @Override // o.AbstractC2021ny
        /* renamed from: ˏ */
        public void mo9382(AccountData accountData, Status status) {
            oL oLVar = (oL) ServiceC0966.this.f14894.get(this.f14962);
            if (oLVar == null) {
                C1283.m16865("NetflixService", "No client callback found for onAccountDataFetched");
                return;
            }
            C1283.m16854("NetflixService", "Notified onAccountDataFetched");
            oLVar.mo9542(this.f14961, accountData, status);
        }
    }

    @Override // o.oE
    /* renamed from: ˎ */
    public void mo9430(String str, UserAgentInterface.PinType pinType, String str2, int i, int i2) {
        this.f14922.m1347(str, pinType, str2, new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ˏ */
    public void mo9433(int i, int i2) {
        this.f14922.m1367(new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ˋ */
    public void mo9414(int i, int i2) {
        this.f14922.m1338(new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ˊ */
    public void mo9405(int i, int i2) {
        this.f14922.m1375(new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ʼॱ */
    public void mo9397() {
        this.f14922.m1380();
    }

    @Override // o.oE
    /* renamed from: ˊ */
    public void mo9406(int i, String str, String str2, int i2, int i3) {
        this.f14922.m1365(i, str, str2, new IF(i2, i3));
    }

    @Override // o.oE
    /* renamed from: ˊ */
    public void mo9407(OnRampEligibility.Action action, int i, int i2) {
        this.f14922.m1356(action, new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ॱ */
    public void mo9447(final String str, final String str2, int i, int i2) {
        final IF r2 = new IF(i, i2);
        if (this.f14914.m16749()) {
            this.f14922.m1349(str, str2, r2);
            return;
        }
        C1283.m16865("NetflixService", "Trying to login without nrm cookies. -- fetchingNrmCookies ");
        this.f14914.m16748(new C0452() { // from class: o.ᴭ.10
            @Override // o.C0452, o.AbstractC1254
            /* renamed from: ˋ */
            public void mo1407(ConfigData configData, Status status) {
                C1283.m16854("NetflixService", String.format("onConfigDataFetched statusCode=%d", Integer.valueOf(status.mo302().m271())));
                if (configData != null) {
                    ServiceC0966.this.f14914.m16753(configData);
                }
                if (!status.mo298() || !ServiceC0966.this.f14914.m16749()) {
                    C1283.m16850("NetflixService", "fetching nrm cookies failed, proceeding without Nrm cookies");
                }
                ServiceC0966.this.f14922.m1349(str, str2, r2);
            }
        });
    }

    @Override // o.oE
    /* renamed from: ˎ */
    public void mo9427(int i, int i2) {
        this.f14922.m1331(new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ˎ */
    public void mo9428(long j, int i, int i2) {
        this.f14922.m1345(j, new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ˋ */
    public void mo9419(C0614 r3, int i, int i2) {
        this.f14922.m1332(r3, new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ᐝ */
    public void mo9459(int i, int i2) {
        this.f14922.m1358(new IF(i, i2));
    }

    @Override // o.oE
    /* renamed from: ʿ */
    public String mo9401() {
        return this.f14914.m16741();
    }

    @Override // o.oE
    /* renamed from: ʾ */
    public DeviceCategory mo9400() {
        return this.f14914.mo16541();
    }

    @Override // o.oE
    /* renamed from: ʽॱ */
    public boolean mo9399() {
        return AV.m3472();
    }

    @Override // o.oE
    /* renamed from: ˊˊ */
    public boolean mo9410() {
        return C1317As.m3772(getApplicationContext()) && this.f14914.i_();
    }

    @Override // o.oE
    /* renamed from: ˋˊ */
    public boolean mo9420() {
        return C1317As.m3746(getApplicationContext()) && this.f14914.j_();
    }

    @Override // o.oE
    /* renamed from: ˉ */
    public AbstractC2060pi mo9403() {
        return new AbstractC2060pi() { // from class: o.ᴭ.12
            @Override // o.AbstractC2060pi
            /* renamed from: ˎ */
            public boolean mo9849() {
                return ServiceC0966.this.f14914.m16744();
            }

            @Override // o.AbstractC2060pi
            /* renamed from: ˏ */
            public long mo9850() {
                return ServiceC0966.this.f14914.m16746();
            }

            @Override // o.AbstractC2060pi
            /* renamed from: ॱ */
            public String mo9851() {
                return ServiceC0966.this.f14914.m16750();
            }
        };
    }

    /* renamed from: o.ᴭ$ˊ  reason: contains not printable characters */
    public class BinderC0967 extends Binder {
        public BinderC0967() {
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public oE m15872() {
            return ServiceC0966.this;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C1283.m16854("NetflixService", "NetflixService is onBind");
        m15832();
        return this.f14923;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        C1283.m16854("NetflixService", "NetflixService is onUnbind");
        int size = this.f14894.size();
        if (size > 0) {
            C1283.m16862("NetflixService", "We still have " + size + " callbacks - not stopping service");
            return true;
        } else if (this.f14901 && this.f14890.m6178()) {
            C1283.m16862("NetflixService", "has active mdx session");
            return true;
        } else if (this.f14896 == AbstractC0367.f13238) {
            C1283.m16862("NetflixService", "Service init failed due to no connectivity - calling stopSelf()");
            stopSelf();
            return true;
        } else {
            m15797(28800000);
            return true;
        }
    }

    @Override // o.oE
    /* renamed from: ॱ */
    public void mo9448(oL oLVar) {
        C1348Bu.m4093();
        m15832();
        if (oLVar == null) {
            throw new IllegalStateException(" registerCallback - cb is null");
        }
        int r3 = this.f14894.m15871(oLVar);
        C1283.m16862("NetflixService", "registerCallback, client: " + oLVar.hashCode());
        if (this.f14897) {
            m15804(r3, this.f14896);
            if (this.f14894.size() == 1) {
                C1283.m16854("NetflixService", "UI started, notify MDX");
                m15838();
                return;
            }
            return;
        }
        this.f14895.add(new C0968(r3));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m15804(int i, Status status) {
        C1283.m16854("NetflixService", "Notifying client " + i + " that service is ready, status code: " + status.mo302());
        oL oLVar = (oL) this.f14894.get(i);
        if (oLVar != null) {
            oLVar.mo563(i, status);
        }
    }

    /* renamed from: o.ᴭ$ˋ  reason: contains not printable characters */
    class C0968 implements AbstractC2406iF {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final int f14967;

        public C0968(int i) {
            this.f14967 = i;
        }

        @Override // o.ServiceC0966.AbstractC2406iF
        /* renamed from: ˊ */
        public void mo15869() {
            ServiceC0966.this.m15804(this.f14967, ServiceC0966.this.f14896);
        }
    }

    @Override // o.oE
    /* renamed from: ˋ */
    public void mo9418(oL oLVar) {
        if (oLVar != null) {
            oL r3 = this.f14894.m15870(oLVar);
            if (r3 == null) {
                C1283.m16865("NetflixService", "Client callback was either not-registered/removed");
            } else {
                C1283.m16862("NetflixService", "unregisterCallback, client: " + r3.hashCode());
            }
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        C1339Bl.m4048(getApplicationContext(), "prefs_app_task_removed_user", true);
    }

    /* renamed from: o.ᴭ$if  reason: invalid class name */
    public static class Cif extends SparseArray<oL> {
        /* renamed from: ˎ  reason: contains not printable characters */
        public int m15871(oL oLVar) {
            C1348Bu.m4093();
            int hashCode = oLVar.hashCode();
            super.put(hashCode, oLVar);
            return hashCode;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public oL m15870(oL oLVar) {
            C1348Bu.m4093();
            int hashCode = oLVar.hashCode();
            oL oLVar2 = (oL) get(hashCode);
            super.remove(hashCode);
            return oLVar2;
        }
    }

    @Override // o.AbstractC1250
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo15844(long j) {
        m15797(j);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m15797(long j) {
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService("alarm");
        if (alarmManager == null) {
            C1283.m16865("NetflixService", "Can't access alarm manager to set shutdown alarm");
            return;
        }
        try {
            alarmManager.set(2, SystemClock.elapsedRealtime() + j, m15786());
        } catch (Exception e) {
            C1276.m16820().mo5727("SPY-8729 - Exception trying to schedule an AlarmManager: " + e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᶥ  reason: contains not printable characters */
    private void m15832() {
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService("alarm");
        if (alarmManager == null) {
            C1283.m16865("NetflixService", "Can't access alarm manager to cancel shutdown alarm");
        } else {
            alarmManager.cancel(m15786());
        }
    }

    /* renamed from: ʹ  reason: contains not printable characters */
    private PendingIntent m15786() {
        return PendingIntent.getService(this, 0, new Intent("com.netflix.mediaclient.service.ACTION_SHUTDOWN_SERVICE").setClass(getApplicationContext(), ServiceC0966.class), 134217728);
    }

    @Override // o.oE
    /* renamed from: ˊᐝ */
    public IDiagnosis mo9413() {
        return this.f14926;
    }

    @Override // o.oE
    /* renamed from: ˊˋ */
    public oG mo9411() {
        return this.f14890;
    }

    @Override // o.oE
    /* renamed from: ˋᐝ */
    public oI mo9423() {
        return this.f14892;
    }

    /* renamed from: ﾞ  reason: contains not printable characters */
    private void m15839() {
        IntentFilter intentFilter = new IntentFilter("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_PLAYBACKEND");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_PLAYBACKSTART");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_STATE");
        intentFilter.addCategory("com.netflix.mediaclient.intent.category.MDX");
        getApplicationContext().registerReceiver(this.f14924, intentFilter);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15821(AbstractC1052.If r3, AbstractC1052.AbstractC1053 r4) {
        if (this.f14890 != null && this.f14890.x_()) {
            this.f14890.mo1236();
            this.f14890 = null;
        }
        this.f14901 = !this.f14914.mo16515().mo13895();
        if (this.f14901) {
            this.f14890 = new C1698eK(this.f14914);
            m15839();
            this.f14890.m16091(r3, r4);
        }
    }

    @Override // o.oE
    /* renamed from: ˍ */
    public AbstractC0518 mo9425() {
        return this.f14914.d_();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m15812(Context context) {
        ConnectivityUtils.NetType r1 = ConnectivityUtils.m2958(context);
        if (r1 != null) {
            return r1.toString();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ﾟ  reason: contains not printable characters */
    private void m15840() {
        C1283.m16862("NetflixService", "onNetworkChange");
        this.f14893.mo5196();
        this.f14932.mo5196();
        C0721.m15050().m15052(m15812(getApplicationContext()));
        if (this.f14890 != null) {
            this.f14890.mo5196();
        }
        this.f14908.m16138();
        this.f14931.mo5196();
        this.f14914.mo5196();
        this.f14899.mo5196();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m15805(BroadcastReceiver broadcastReceiver, String str) {
        if (broadcastReceiver == null) {
            C1283.m16854("NetflixService", "Unable to unregister, receiver is null");
            return;
        }
        try {
            unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
            C1283.m16850("NetflixService", "Unregister " + str + " failed.");
        }
    }

    @Override // o.oE
    /* renamed from: ˎˎ */
    public IClientLogging mo9431() {
        return this.f14932;
    }

    @Override // o.oE
    /* renamed from: ˌ */
    public AbstractC1221 mo9424() {
        return this.f14914;
    }

    @Override // o.oE
    /* renamed from: ˋˋ */
    public AbstractC1194 mo9421() {
        return this.f14899;
    }

    @Override // o.oE
    /* renamed from: ˎˏ */
    public AbstractC2050oz mo9432() {
        return this.f14919;
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    public static Intent m15817() {
        return new Intent("com.netflix.mediaclient.service.ACTION_SHOW_CAST_PLAYER");
    }

    /* renamed from: ﹳ  reason: contains not printable characters */
    private void m15838() {
        if (this.f14901 && this.f14890 != null && !this.f14890.m6178()) {
            this.f14890.m6184();
        }
    }

    @Override // o.oE
    /* renamed from: ˏˎ */
    public void mo9437() {
        C1283.m16854("NetflixService", "UI coming from background, notify MDX");
        m15838();
    }

    @Override // o.oE
    /* renamed from: ˏˏ */
    public AbstractC1853hl mo9438() {
        return this.f14931;
    }

    @Override // o.oE
    /* renamed from: ͺॱ */
    public oH mo9441() {
        return this.f14917;
    }

    @Override // o.oE
    /* renamed from: ॱʽ */
    public AbstractC1156 mo9451() {
        return this.f14907;
    }

    @Override // o.oE
    /* renamed from: ـ */
    public IVoip mo9442() {
        return this.f14907.m9643();
    }

    @Override // o.AbstractC1250
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo15841(NetflixJob.NetflixJobId netflixJobId, AbstractC2051p pVar) {
        synchronized (this.f14911) {
            this.f14911.put(netflixJobId, pVar);
        }
    }

    @Override // o.oE
    /* renamed from: ॱ */
    public void mo9445(NetflixJob.NetflixJobId netflixJobId) {
        AbstractC2051p pVar;
        synchronized (this.f14911) {
            pVar = this.f14911.get(netflixJobId);
        }
        if (pVar != null) {
            pVar.mo7115(netflixJobId);
        }
    }

    @Override // o.oE
    /* renamed from: ˋ */
    public void mo9415(NetflixJob.NetflixJobId netflixJobId) {
        AbstractC2051p pVar;
        synchronized (this.f14911) {
            pVar = this.f14911.get(netflixJobId);
        }
        if (pVar != null) {
            pVar.mo7114(netflixJobId);
        }
    }

    @Override // o.oS
    /* renamed from: ˎ */
    public void mo9579(int i, Notification notification) {
        C1348Bu.m4093();
        if (!this.f14905.contains(Integer.valueOf(i))) {
            this.f14905.add(Integer.valueOf(i));
            startForeground(i, notification);
        }
    }

    @Override // o.oS
    /* renamed from: ˋ */
    public void mo9578(int i, boolean z) {
        C1348Bu.m4093();
        this.f14905.remove(Integer.valueOf(i));
        if (this.f14905.size() == 0) {
            if (C1317As.m3774()) {
                z = true;
            }
            stopForeground(z);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (this.f14897) {
            if (!(i == 20 || mo9431() == null)) {
                PerformanceProfiler.m651(C1330Bc.m4004(i));
            }
            if (i >= 60) {
                this.f14931.mo7286(i);
            }
            this.f14893.mo7286(i);
        }
    }

    @Override // o.oE
    /* renamed from: ॱͺ */
    public C2003ng mo9455() {
        return this.f14930;
    }

    /* renamed from: ॱʼ  reason: contains not printable characters */
    public long m15846() {
        return this.f14900;
    }

    @Override // o.oE
    /* renamed from: ॱʻ */
    public BookmarkStore mo9450() {
        return this.f14906;
    }

    @Override // o.oE
    /* renamed from: ᐝᐝ */
    public AbstractC2057pf mo9462() {
        return this.f14908;
    }

    @Override // o.oE
    /* renamed from: ॱ */
    public void mo9444(Intent intent) {
        m15798(intent);
    }

    @Override // o.oE
    /* renamed from: ᐝˊ */
    public AbstractC2056pe mo9460() {
        return this.f14893.m7426();
    }

    @Override // o.AbstractC1250
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo15845() {
        return (this.f14893 == null || this.f14893.m7426().mo7799() == null) ? false : true;
    }

    @Override // o.AbstractC1250
    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized boolean mo15842(NetflixDataRequest netflixDataRequest) {
        return C0938.f14820.m15751(netflixDataRequest);
    }

    @Override // o.AbstractC1250
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void mo15843() {
        AbstractC2047ow[] owVarArr = {this.f14927};
        int length = owVarArr.length;
        for (int i = 0; i < 1; i++) {
            AbstractC2047ow owVar = owVarArr[i];
            long elapsedRealtime = SystemClock.elapsedRealtime();
            C1283.m16851("NetflixService", "Delayed initialization of %s started...", owVar.getClass().getSimpleName());
            Status r12 = owVar.mo6783();
            if (r12 != AbstractC0367.f13235) {
                C1283.m16844("NetflixService", "Delayed initialization of %s failed!", owVar.getClass().getSimpleName());
                mo9441().mo5362(C1061.m16114().mo14162().mo1766(getApplicationContext(), r12, false));
                return;
            }
            C1283.m16851("NetflixService", "Delayed initialization of %s completed in %d ms.", owVar.getClass().getSimpleName(), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
        this.f14914.m16755();
        if (this.f14915.size() > 0) {
            C1283.m16851("NetflixService", "Crypto is initialized with delay, MSL is ready, send MSL requests: %d", Integer.valueOf(this.f14915.size()));
            for (NetflixDataRequest netflixDataRequest : this.f14915) {
                this.f14930.mo6791(netflixDataRequest);
            }
            this.f14915.clear();
        } else {
            C1283.m16854("NetflixService", "No pending MSL requests...");
        }
    }

    @Override // android.content.Context, android.content.ContextWrapper, o.oE
    public Context getApplicationContext() {
        return AbstractApplicationC1258.m16692();
    }

    /* renamed from: ꞌ  reason: contains not printable characters */
    private void m15837() {
        this.f14932.m5205(ConnectivityUtils.m2953(getApplicationContext()), NetworkRequestLogger.INSTANCE.m475());
        if (this.f14916.m14826()) {
            this.f14932.mo1512().mo5226(new C1540bO());
        }
        C1283.m16854("NetflixService", "BLOB: startup is scheduled to be sent");
    }
}
