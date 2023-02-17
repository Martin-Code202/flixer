package com.netflix.mediaclient;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.netflix.cl.Logger;
import com.netflix.falkor.cache.FalkorCache;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.ui.error.CryptoErrorManager;
import com.netflix.mediaclient.ui.error.CryptoErrorManagerImpl;
import com.netflix.mediaclient.ui.launch.LaunchActivity;
import com.netflix.mediaclient.ui.preapp.PServiceWidgetProvider;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.NotificationUtils;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import o.AD;
import o.AG;
import o.AP;
import o.AbstractApplicationC1258;
import o.AbstractC0357;
import o.AbstractC0457;
import o.AbstractC0845;
import o.AbstractC1214;
import o.AbstractC1236;
import o.AbstractC1237;
import o.AbstractC1326Az;
import o.AbstractC2096qp;
import o.AbstractC2097qq;
import o.AbstractC2101qu;
import o.AbstractC2102qv;
import o.AbstractC2104qx;
import o.AbstractC2105qy;
import o.AbstractC2228v;
import o.ActivityC2280wv;
import o.BV;
import o.C0384;
import o.C0393;
import o.C0400;
import o.C0403;
import o.C0406;
import o.C0469;
import o.C0581;
import o.C0721;
import o.C0728;
import o.C0839;
import o.C0844;
import o.C1015;
import o.C1041;
import o.C1061;
import o.C1063;
import o.C1066;
import o.C1137;
import o.C1141;
import o.C1186;
import o.C1235;
import o.C1241;
import o.C1246;
import o.C1273;
import o.C1281;
import o.C1283;
import o.C1302Ae;
import o.C1312An;
import o.C1316Ar;
import o.C1339Bl;
import o.C1348Bu;
import o.C1349Bv;
import o.C1362Ch;
import o.C1366Cl;
import o.C1368Cm;
import o.C1373Cp;
import o.C1529bE;
import o.C1532bG;
import o.C1794g;
import o.C2020nx;
import o.C2059ph;
import o.C2193tw;
import o.C2197u;
import o.C2235ve;
import o.C2277ws;
import o.oV;
import o.qA;
import o.sI;
import o.vQ;
import o.wD;
import o.yI;
import org.json.JSONObject;
public class NetflixApplication extends AbstractApplicationC1258 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final Gson f585 = new GsonBuilder().registerTypeAdapterFactory(AbstractC1214.m16500()).registerTypeAdapterFactory(AbstractC0845.m15502()).registerTypeAdapterFactory(AbstractC1237.m16592()).create();

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private static boolean f586 = true;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private static boolean f587 = false;

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f588 = false;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final long f589 = 600;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C0406 f590 = C0406.m14192();

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final BroadcastReceiver f591 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.NetflixApplication.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.netflix.mediaclient.intent.action.NETFLIX_SERVICE_DESTROYED".equals(action)) {
                C1283.m16854("NetflixApplication", "Netflix service is destroyed");
                NetflixApplication.this.f605.set(false);
                if (NetflixApplication.this.f603.getAndSet(false)) {
                    C1283.m16854("NetflixApplication", "unregister cast player");
                    NetflixApplication.this.getApplicationContext().unregisterReceiver(NetflixApplication.this.f592);
                }
            } else if ("com.netflix.mediaclient.intent.action.NETFLIX_SERVICE_INIT_COMPLETE".equals(action)) {
                if (((StatusCode) intent.getSerializableExtra("status_code")).m269()) {
                    C1283.m16854("NetflixApplication", " Netflix application is ready");
                    NetflixApplication.this.f605.set(true);
                    if (!NetflixApplication.this.f603.getAndSet(true)) {
                        C1283.m16854("NetflixApplication", "register cast player");
                        NetflixApplication.this.getApplicationContext().registerReceiver(NetflixApplication.this.f592, new IntentFilter("com.netflix.mediaclient.service.ACTION_SHOW_CAST_PLAYER"));
                    }
                } else {
                    C1283.m16854("NetflixApplication", " Netflix application is NOT ready");
                    NetflixApplication.this.f605.set(false);
                }
                Schedulers.computation().scheduleDirect(new Runnable() { // from class: com.netflix.mediaclient.NetflixApplication.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        C0403.m14184();
                    }
                });
            }
        }
    };

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final BroadcastReceiver f592 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.NetflixApplication.10
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"com.netflix.mediaclient.service.ACTION_SHOW_CAST_PLAYER".equals(intent.getAction())) {
                C1283.m16853("NetflixApplication", "Invalid intent: ", intent);
                return;
            }
            C1283.m16846("NetflixApplication", "Sending show app intent");
            NetflixApplication.this.startActivity(NetflixApplication.m219(AbstractApplicationC1258.m16692()).addFlags(268435456));
            C1348Bu.If.m4100(new Runnable() { // from class: com.netflix.mediaclient.NetflixApplication.10.1
                @Override // java.lang.Runnable
                public void run() {
                    C1283.m16846("NetflixApplication", "Sending show mini player intent");
                    NetflixApplication.this.sendBroadcast(new Intent("com.netflix.mediaclient.service.ACTION_EXPAND_CAST_PLAYER"));
                }
            }, 400);
        }
    };

    /* renamed from: ˈ  reason: contains not printable characters */
    private NetflixActivity f593;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private Timer f594;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C2059ph f595;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f596;

    /* renamed from: ˎ  reason: contains not printable characters */
    private vQ f597;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private TimerTask f598;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final C1366Cl f599 = new C1366Cl();

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC2228v f600;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f601;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f602 = false;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final AtomicBoolean f603 = new AtomicBoolean(false);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private BV f604;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final AtomicBoolean f605 = new AtomicBoolean(false);

    /* renamed from: ͺ  reason: contains not printable characters */
    public vQ m251() {
        return this.f597;
    }

    public static NetflixApplication getInstance() {
        return (NetflixApplication) f15841;
    }

    @Override // o.AbstractApplicationC1258
    /* renamed from: ᐝ  reason: contains not printable characters */
    public AbstractC2228v mo258() {
        return this.f600;
    }

    @Override // o.AbstractApplicationC1258
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public long mo256() {
        if (this.f604 != null) {
            return (long) this.f604.size();
        }
        return 0;
    }

    @Override // o.AbstractApplicationC1258
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo252(Context context, String str) {
        new C1794g(context).run();
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager != null) {
            alarmManager.set(1, System.currentTimeMillis() + 2000, PendingIntent.getActivity(context, 0, C1061.m16114().mo14163(context, str), 268435456));
        }
    }

    @Override // o.AbstractApplicationC1258
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo246(Context context) {
        new C1794g(context).run();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Intent m219(Context context) {
        return new Intent(context, LaunchActivity.class).setAction("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C1283.m16854("NetflixApplication", "onConfigurationChanged");
        if (((AbstractC2104qx) C1281.m16832(AbstractC2104qx.class)).mo10123(getApplicationContext())) {
            PServiceWidgetProvider.m2753(this);
        }
    }

    @Override // o.AbstractApplicationC1258, android.app.Application
    public void onCreate() {
        super.onCreate();
        C1283.m16854("NetflixApplication", "Application onCreate");
        C1532bG.m5744(m253());
        m225();
        this.f600 = new C2197u(getApplicationContext());
        C1061.f15211 = new C0393();
        m243();
        m227();
        NotificationUtils.m2995(this);
        this.f601 = C1339Bl.m4051(this, "enable_phone_portraitlock", false);
        C1283.m16854("NetflixApplication", "Loading native libraries");
        try {
            ((Class) C1235.m16591(getPackageName().length() - 23, getApplicationInfo().targetSdkVersion - 24, (char) (getPackageName().length() - 23))).getMethod("ˏ", null).invoke(null, null);
            Realm.init(this);
            FalkorCache.m163(this, this.f590, new AbstractC1326Az() { // from class: com.netflix.mediaclient.NetflixApplication.5
                @Override // o.AbstractC1326Az
                /* renamed from: ˎ  reason: contains not printable characters */
                public void mo262(Context context, String str, JSONObject jSONObject) {
                    C1362Ch.m4394(str, (IClientLogging.ModalView) null, jSONObject);
                }
            }, new FalkorCache.AbstractC0005() { // from class: com.netflix.mediaclient.NetflixApplication.4
                @Override // com.netflix.falkor.cache.FalkorCache.AbstractC0005
                /* renamed from: ˊ */
                public long mo192() {
                    if (C0728.m15070()) {
                        return C0728.f14271.m15071();
                    }
                    return 0;
                }
            });
            C0469.m14365(this);
            registerActivityLifecycleCallbacks(this.f590);
            m224();
            m230();
            m250();
            C0469.m14364(this, new C1141(this));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public Map<String, String> m253() {
        HashMap hashMap = new HashMap();
        hashMap.put("code", String.valueOf(27321));
        hashMap.put("name", "6.1.0 build 27321");
        hashMap.put("branch", "release/6.1");
        hashMap.put("rev", "07f644ba92ed9dfc268189cbd57873d84653daa4");
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m250() {
        C1302Ae.m3575();
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m227() {
        C1281.m16833(AbstractC1236.class, new C1529bE(new C1273()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void m243() {
        Logger.INSTANCE.m144(new C1373Cp(this));
        m226();
        C1368Cm.m4506();
        this.f599.m4487();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m248() {
        m226();
        C1368Cm.m4504();
        C1368Cm.m4506();
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    private void m226() {
        Logger.INSTANCE.m127(new C1063(AP.m3397().longValue()));
        Logger.INSTANCE.m127(new C1066(AP.m3400().longValue()));
        Logger.INSTANCE.m127(new C0581());
        Logger.INSTANCE.m127(new C0839(C1349Bv.m4110(Build.MODEL, "_")));
        Logger.INSTANCE.m127(new C0844(C2020nx.m9367().m3976()));
        Logger.INSTANCE.m127(new C1041());
        Logger.INSTANCE.m127(new C1015());
        Logger.INSTANCE.m127(new C1137());
        Logger.INSTANCE.m127(new C0400());
        Logger.INSTANCE.m127(new C0384());
        Logger.INSTANCE.m127(new C1246(AD.m3301(this)));
        Logger.INSTANCE.m142(new C1241());
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    private void m225() {
        C1281.m16833(Context.class, getApplicationContext());
        this.f597 = new vQ();
        C1281.m16833(AbstractC2102qv.class, this.f597);
        C1281.m16833(AbstractC2097qq.class, new C2235ve());
        C1281.m16833(qA.class, new C1312An());
        C1281.m16833(AbstractC2104qx.class, new yI());
        C1281.m16833(AbstractC2096qp.class, new C2193tw());
        C1281.m16833(AbstractC2101qu.class, new C2277ws());
        C1281.m16833(AbstractC2105qy.class, new sI());
        C1281.m16833(CryptoErrorManager.class, CryptoErrorManagerImpl.INSTANCE);
        C1281.m16833(AbstractC0357.class, new AbstractC0357() { // from class: com.netflix.mediaclient.NetflixApplication.2
            @Override // o.AbstractC0357
            /* renamed from: ॱ  reason: contains not printable characters */
            public double mo261() {
                return C1186.m16443().m16444();
            }

            @Override // o.AbstractC0357
            /* renamed from: ˋ  reason: contains not printable characters */
            public String mo260() {
                return C1186.m16443().m16445().name();
            }
        });
        C1281.m16833(Gson.class, f585);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        C1283.m16862("NetflixApplication", "onTrimMemory: " + i);
        if (i >= 60 && this.f604 != null) {
            C1283.m16862("NetflixApplication", "Flushing BitmapCache");
            this.f604.evictAll();
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public BV m233() {
        return this.f604;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m241(BV bv) {
        if (this.f604 != null) {
            C1283.m16865("NetflixApplication", "ImageCache is set more than once!");
        }
        this.f604 = bv;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public boolean m255() {
        return this.f602;
    }

    @Override // o.AbstractApplicationC1258
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo240() {
        this.f602 = true;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public void m257() {
        this.f588 = true;
    }

    @Override // o.AbstractApplicationC1258
    /* renamed from: ʻ  reason: contains not printable characters */
    public void mo232() {
        this.f602 = false;
        C1339Bl.m4039(this, "useragent_userprofiles_data", (String) null);
    }

    @Override // o.AbstractApplicationC1258
    /* renamed from: ʼ  reason: contains not printable characters */
    public AbstractC0457 mo234() {
        return m237();
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public boolean m254() {
        if (AD.m3320() || AD.m3281() || AD.m3303()) {
            return false;
        }
        return (!AD.m3299() && this.f601) || NetflixBottomNavBar.m416();
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private void m224() {
        C1283.m16854("NetflixApplication", "Registering application broadcast receiver");
        AG.m3334(this, this.f591, "com.netflix.mediaclient.intent.category.NETFLIX_SERVICE", "com.netflix.mediaclient.intent.action.NETFLIX_SERVICE_INIT_COMPLETE", "com.netflix.mediaclient.intent.action.NETFLIX_SERVICE_DESTROYED");
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public boolean m259() {
        return this.f605.get();
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private void m230() {
        C0721.m15050().m15055(true);
        ConnectivityUtils.NetType r2 = ConnectivityUtils.m2958(getApplicationContext());
        C0721.m15050().m15052(r2 != null ? r2.toString() : null);
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public NetflixActivity m239() {
        return this.f593;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m249(NetflixActivity netflixActivity) {
        if (netflixActivity != null && !(netflixActivity instanceof ActivityC2280wv)) {
            wD.m12274(netflixActivity);
            ActivityC2280wv.m12566(netflixActivity);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m247(NetflixActivity netflixActivity) {
        if (this.f593 != null && this.f593.equals(netflixActivity)) {
            this.f593 = null;
        }
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public static Context m217() {
        return getInstance().m239();
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public C0406 m237() {
        return this.f590;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public void m238() {
        this.f594 = new Timer();
        this.f598 = new TimerTask() { // from class: com.netflix.mediaclient.NetflixApplication.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NetflixApplication.this.f596 = true;
            }
        };
        this.f594.schedule(this.f598, 600);
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public void m235() {
        if (this.f598 != null) {
            this.f598.cancel();
        }
        if (this.f594 != null) {
            this.f594.cancel();
        }
        this.f596 = false;
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public boolean m244() {
        boolean z = this.f596;
        this.f596 = false;
        return z;
    }

    @Override // o.AbstractApplicationC1258
    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean mo236() {
        return this.f596;
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    public C1366Cl m242() {
        return this.f599;
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    public static void m218() {
        f15842 = true;
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    public static void m220() {
        f15842 = false;
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    public static Gson m222() {
        return f585;
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    public static boolean m223() {
        return f587 && !C1316Ar.m3741(getInstance());
    }

    @Override // o.AbstractApplicationC1258
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo245() {
        if (Build.VERSION.SDK_INT > 25) {
            if (this.f595 != null) {
                this.f595.m9799();
            }
            this.f595 = new C2059ph();
            this.f595.m9769(new oV() { // from class: com.netflix.mediaclient.NetflixApplication.9
                @Override // o.oV
                public void onManagerReady(C2059ph phVar, Status status) {
                }

                @Override // o.oV
                public void onManagerUnavailable(C2059ph phVar, Status status) {
                }
            });
        }
    }
}
