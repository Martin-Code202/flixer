package o;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.display.DisplayManager;
import android.media.UnsupportedSchemeException;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.VideoResolutionRange;
import com.netflix.mediaclient.partner.PartnerInstallType;
import com.netflix.mediaclient.repository.SecurityRepository;
import com.netflix.mediaclient.service.configuration.ImageResolutionClass;
import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import com.netflix.mediaclient.service.configuration.esn.WidevineNotSupportedException;
import com.netflix.mediaclient.service.error.crypto.ErrorSource;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.service.offline.agent.OfflineUnavailableReason;
import com.netflix.mediaclient.service.player.StreamProfileType;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.BreadcrumbLoggingSpecification;
import com.netflix.mediaclient.service.webclient.model.leafs.BwCap;
import com.netflix.mediaclient.service.webclient.model.leafs.ConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.ConsolidatedLoggingSessionSpecification;
import com.netflix.mediaclient.service.webclient.model.leafs.ErrorLoggingSpecification;
import com.netflix.mediaclient.service.webclient.model.leafs.NonMemberData;
import com.netflix.mediaclient.service.webclient.model.leafs.OfflineCodecPrefData;
import com.netflix.mediaclient.service.webclient.model.leafs.PdsAndLogblobConfig;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.StreamingCodecPrefData;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipConfiguration;
import com.netflix.mediaclient.servicemgr.AdvertiserIdLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.ui.error.CryptoErrorManager;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.DeviceCategory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import o.AbstractC0472;
import org.json.JSONArray;
@SuppressLint({"InlinedApi"})
/* renamed from: o.ｽ  reason: contains not printable characters */
public class C1260 extends AbstractC1052 implements AbstractC1221 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean f15855;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final int f15856 = ((int) (((float) Runtime.getRuntime().maxMemory()) * 0.5f));

    /* renamed from: ʻ  reason: contains not printable characters */
    private Status f15857;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean f15858;

    /* renamed from: ʼ  reason: contains not printable characters */
    private AbstractC0518 f15859;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private int f15860 = -1;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1279 f15861;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private String f15862;

    /* renamed from: ʾ  reason: contains not printable characters */
    private String f15863;

    /* renamed from: ʿ  reason: contains not printable characters */
    private String f15864;

    /* renamed from: ˈ  reason: contains not printable characters */
    private String f15865 = null;

    /* renamed from: ˉ  reason: contains not printable characters */
    private boolean f15866 = false;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final CryptoErrorManager f15867;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private boolean f15868;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private boolean f15869 = false;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C0451 f15870;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private C0351 f15871;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<Cif> f15872 = new ArrayList();

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private int f15873;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private AtomicBoolean f15874 = new AtomicBoolean(false);

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C1374Cq f15875;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private C1116 f15876;

    /* renamed from: ˌ  reason: contains not printable characters */
    private BroadcastReceiver f15877;

    /* renamed from: ˍ  reason: contains not printable characters */
    private boolean f15878;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f15879;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private VideoResolutionRange f15880;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private final AbstractC0346 f15881 = new AbstractC0346() { // from class: o.ｽ.12
        @Override // o.AbstractC0346
        /* renamed from: ˏ */
        public boolean mo13899() {
            return C1260.this.f15891.m16643();
        }

        @Override // o.AbstractC0346
        /* renamed from: ˊ */
        public boolean mo13896() {
            return C1260.this.f15891.m16638();
        }

        @Override // o.AbstractC0346
        /* renamed from: ॱ */
        public boolean mo13900() {
            return C1260.this.f15891.m16634();
        }

        @Override // o.AbstractC0346
        /* renamed from: ˋ */
        public boolean mo13897() {
            return C1260.this.f15884.m16572();
        }

        @Override // o.AbstractC0346
        /* renamed from: ˎ */
        public JSONArray mo13898() {
            return C1260.this.f15884.m16579();
        }

        @Override // o.AbstractC0346
        /* renamed from: ᐝ */
        public boolean mo13901() {
            return C1260.this.f15891.m16625();
        }

        @Override // o.AbstractC0346
        /* renamed from: ʽ */
        public boolean mo13895() {
            return C1260.this.f15891.m16657();
        }

        @Override // o.AbstractC0346
        /* renamed from: ʻ */
        public JSONArray mo13894() {
            return C1260.this.f15884.m16576();
        }
    };

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private C1240 f15882;

    /* renamed from: ˑ  reason: contains not printable characters */
    private final Runnable f15883 = new Runnable() { // from class: o.ｽ.10
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16862("nf_configurationagent", "Refreshing config via runnable");
            C1260.this.mo16534((oR) null, (AbstractC1254) null);
            C1283.m16862("nf_configurationagent", "Check if we should report ad id via runnable");
            IClientLogging r3 = C1260.this.m16086();
            if (r3 == null) {
                C1283.m16850("nf_configurationagent", "CL is not available!");
                return;
            }
            AdvertiserIdLogging r4 = r3.mo1511();
            if (r4 == null) {
                C1283.m16850("nf_configurationagent", "AD logger is not available!");
            } else {
                r4.mo1482(AdvertiserIdLogging.EventType.check_in.name());
            }
        }
    };

    /* renamed from: ͺ  reason: contains not printable characters */
    private C1231 f15884;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private final AbstractC0402 f15885 = new AbstractC0402() { // from class: o.ｽ.4
        @Override // o.AbstractC0402
        /* renamed from: ˎ */
        public boolean mo14183() {
            return !C1260.this.f15884.m16574();
        }

        @Override // o.AbstractC0402
        /* renamed from: ˊ */
        public boolean mo14182() {
            return C1260.this.f15891.m16639();
        }
    };

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C1262 f15886;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private C1255 f15887;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private PartnerInstallType.InstallType f15888;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f15889 = false;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C0365 f15890;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1252 f15891;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private C1257 f15892;

    /* renamed from: o.ｽ$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ॱ */
        void mo5204(Status status);
    }

    public C1260(Context context, CryptoErrorManager cryptoErrorManager) {
        this.f15860 = C1318At.m3778(context);
        this.f15867 = cryptoErrorManager;
        C1283.m16863("nf_configurationagent", "Current app version code=%d", Integer.valueOf(this.f15860));
        this.f15865 = C1318At.m3776(context);
        C1283.m16863("nf_configurationagent", "Current softwareVersion=%s", this.f15865);
        this.f15871 = new C0351(this.f15860, context, C1318At.m3776(context), AbstractC0488.m14431());
        this.f15891 = new C1252(context);
        this.f15884 = new C1231(context);
        this.f15870 = new C0451(context);
        this.f15882 = new C1240(context);
        this.f15890 = new C0365(context);
        this.f15886 = new C1262(context, "nrmInfo");
        this.f15892 = new C1257(context);
        this.f15875 = new C1374Cq(context);
        this.f15879 = context;
        this.f15878 = C1339Bl.m4051(context, "offline_blaclisted_device_override", false);
    }

    @Override // o.AbstractC1221
    /* renamed from: ʻᐝ */
    public ABTestConfigData mo16505() {
        C1240 r0 = this.f15882;
        return C1240.f15779;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        this.f15866 = false;
        this.f15869 = false;
        this.f15876 = new C1116(m16093(), this);
        m16738();
        m16732();
        C1283.m16851("nf_configurationagent", "Use low mem config: %b ", Boolean.valueOf(mo16548()));
        this.f15873 = C1330Bc.m4003(this.f15879);
        this.f15887 = new C1255(this.f15879, s_());
        this.f15861 = new C1279(this.f15879, m16085(), this, m16088(), m16086());
        this.f15868 = m16724();
        this.f15858 = C1317As.m3770(this.f15879);
        this.f15888 = PartnerInstallType.m481(this.f15858, C1339Bl.m4051(this.f15879, "isPostLoaded", false));
        m16733();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ـॱ  reason: contains not printable characters */
    private void m16721() {
        if (m16756()) {
            SystemClock.elapsedRealtime();
            this.f15859 = C1232.m16583(m16093());
            if (this.f15859 == null) {
                C1283.m16854("nf_configurationagent", "Unable to use pre cached ESN, calculate ESN...");
            } else {
                Logger.INSTANCE.m127(new C0899(this.f15859.mo14449()));
                m16725();
                return;
            }
        }
        C1283.m16854("nf_configurationagent", "Use calculated ESN...");
        Status r3 = m16730();
        if (r3 != null) {
            C1283.m16850("nf_configurationagent", "Failed to calculate ESN, report failure during service startup!");
            m16090(r3);
        }
    }

    /* renamed from: ߺ  reason: contains not printable characters */
    private void m16725() {
        C1283.m16854("nf_configurationagent", "Using cached ESN...");
        C0480.m14406(this.f15859.mo14530());
        this.f15874.set(true);
        s_().postDelayed(new Runnable() { // from class: o.ｽ.5
            @Override // java.lang.Runnable
            public void run() {
                C1260.this.m16730();
            }
        }, 2000);
        m16090(AbstractC0367.f13235);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˈ  reason: contains not printable characters */
    private Status m16730() {
        PerformanceProfiler.INSTANCE.m663(Sessions.DRM_LOADED);
        try {
            SystemClock.elapsedRealtime();
            this.f15859 = C0511.m14529(this.f15879, this);
            Logger.INSTANCE.m127(new C0899(this.f15859.mo14449()));
            m16729();
            return null;
        } catch (UnsupportedSchemeException e) {
            C1283.m16856("nf_configurationagent", e, "Failed to create ESN", new Object[0]);
            return AbstractC0367.f13217;
        } catch (WidevineNotSupportedException e2) {
            C1283.m16856("nf_configurationagent", e2, "WidevineNotSupportedException:", new Object[0]);
            if (AV.m3473(m16093(), this)) {
                C1283.m16865("nf_configurationagent", "Widevine not supported, but Widevine was used before, we may be able to recover");
                this.f15867.mo1737(ErrorSource.msl, StatusCode.MSL_LEGACY_CRYPTO_BUT_USED_WIDEVINE_BEFORE, null);
                m16086().mo1515().mo5714("MSL_LEGACY_CRYPTO_BUT_USED_WIDEVINE_BEFORE");
                return AbstractC0367.f13230;
            }
            C1283.m16865("nf_configurationagent", "Widevine not supported, never used before, we will not be able to recover");
            m16086().mo1515().mo5714("MSL_LEGACY_CRYPTO");
            return AbstractC0367.f13227;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱʾ  reason: contains not printable characters */
    private boolean m16728() {
        if (AV.m3463(m16093(), this.f15859)) {
            this.f15869 = true;
            mo16510();
            if (!ConnectivityUtils.m2970(m16093())) {
                C1339Bl.m4039(m16093(), "nf_drm_esn", this.f15859.mo14441());
                m16090(AbstractC0367.f13252);
                return true;
            }
        }
        C1283.m16851("nf_configurationagent", "EsnMigration needed: %b", Boolean.valueOf(this.f15869));
        return false;
    }

    /* renamed from: ॱʿ  reason: contains not printable characters */
    private void m16729() {
        final boolean r3 = mo16508();
        try {
            C1283.m16854("nf_configurationagent", "::init createCryptoInstance ");
            final long currentTimeMillis = System.currentTimeMillis();
            C0480.m14407(this.f15879, this.f15867, this, new AbstractC0472.AbstractC0473() { // from class: o.ｽ.2
                @Override // o.AbstractC0472.AbstractC0473
                /* renamed from: ॱ */
                public void mo14374() {
                    if (!C1260.this.m16728()) {
                        if (!C1260.this.m16752() || C1260.this.m16715(C1260.this.m16093())) {
                            C1260.this.m16748(new C0452() { // from class: o.ｽ.2.3
                                @Override // o.C0452, o.AbstractC1254
                                /* renamed from: ˋ */
                                public void mo1407(ConfigData configData, Status status) {
                                    C1283.m16851("nf_configurationagent", "onConfigDataFetched statusCode=%d", Integer.valueOf(status.mo302().m271()));
                                    if (status.mo298()) {
                                        if (configData != null) {
                                            C1260.this.m16753(configData);
                                        }
                                        C1260.this.m16705(status, r3);
                                        return;
                                    }
                                    C1283.m16844("nf_configurationagent", "error in fetching esnDependentConfigs status: %s", status);
                                    C1260.this.m16705(AbstractC0367.f13247, r3);
                                }
                            });
                            return;
                        }
                        C1260.this.m16705(AbstractC0367.f13235, r3);
                        C1260.this.m16751();
                    }
                }

                @Override // o.AbstractC0472.AbstractC0473
                /* renamed from: ˏ */
                public void mo14373(Status status) {
                    C1260.this.m16705(status, r3);
                }

                @Override // o.AbstractC0472.AbstractC0473
                /* renamed from: ˊ */
                public void mo14371() {
                    C1283.m16854("nf_configurationagent", "::init: drmResoureReclaimed:: NOOP");
                }

                @Override // o.AbstractC0472.AbstractC0473
                /* renamed from: ˏ */
                public void mo14372() {
                    C1283.m16854("nf_configurationagent", "::init: drmReset:: clear MSL store");
                    C1260.this.m16087().mo6789();
                }
            });
        } catch (UnsupportedSchemeException e) {
            C1283.m16856("nf_configurationagent", e, "::init: Failed to create MSL crypto registry", new Object[0]);
            m16705(AbstractC0367.f13217, r3);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m16705(Status status, boolean z) {
        if (!z) {
            C1283.m16851("nf_configurationagent", "Handling not delayed init crypto status %s", status.mo302());
            m16090(status);
            return;
        }
        C1283.m16851("nf_configurationagent", "Handling delayed init crypto status %s, ESN migration detected %b", status.mo302(), Boolean.valueOf(this.f15869));
        if (!status.mo298() || this.f15869) {
            v_().mo5362(C1061.m16114().mo14162().mo1766(m16093(), status, false));
            return;
        }
        C1283.m16854("nf_configurationagent", "Succesfully initialized crypto");
        t_().mo15843();
    }

    @Override // o.AbstractC1221
    /* renamed from: ʽˋ */
    public void mo16510() {
        this.f15886.m16759();
    }

    @Override // o.AbstractC1221
    /* renamed from: ʾॱ */
    public AbstractC1378Cu mo16512() {
        return this.f15875;
    }

    /* renamed from: ߵ  reason: contains not printable characters */
    private boolean m16724() {
        PackageManager packageManager = this.f15879.getPackageManager();
        if (packageManager != null) {
            return packageManager.hasSystemFeature("android.hardware.microphone");
        }
        C1283.m16850("nf_configurationagent", "Unable to get PackageManager! This should NOT happen!");
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16753(ConfigData configData) {
        this.f15891.m16641(configData.getDeviceConfig());
        this.f15870.m14333(configData.getStreamingConfig());
        this.f15884.m16580(configData.getAccountConfig());
        this.f15882.m16594(configData.getABTestConfigData());
        this.f15886.m16760(configData.getNrmConfigData());
        this.f15886.m16758(configData.getNrmLanguagesData());
        this.f15892.m16689(configData.getCastKeyData());
        this.f15890.m14068(configData.getSignInConfigData());
        C1272.m16802(this.f15879, this);
    }

    @Override // o.AbstractC1221
    /* renamed from: ᐝ */
    public boolean mo16548() {
        return C1337Bj.m4029();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m16747(oR oRVar, AbstractC1254 r4, Cif ifVar) {
        if (ifVar != null) {
            this.f15872.add(ifVar);
        }
        if (!this.f15889) {
            C1283.m16862("nf_configurationagent", "Starting a config refresh ");
            m16711(oRVar, r4);
        } else {
            C1283.m16862("nf_configurationagent", "Ignoring request to refreshConfig because one is on-going.");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m16743(Cif ifVar) {
        if (ifVar != null) {
            this.f15872.add(ifVar);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˑ  reason: contains not printable characters */
    private void m16734() {
        s_().post(new Runnable() { // from class: o.ｽ.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (C1260.this) {
                    C1283.m16854("nf_configurationagent", "Invoking ConfigAgentListeners.");
                    C1260.this.f15889 = false;
                    for (Cif ifVar : C1260.this.f15872) {
                        ifVar.mo5204(C1260.this.f15857);
                    }
                    C1260.this.f15872.clear();
                }
            }
        });
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ */
    public void mo1236() {
        super.mo1236();
        if (s_() != null) {
            s_().removeCallbacks(this.f15883);
        }
        if (this.f15891 != null) {
            this.f15891.m16635();
        }
        if (this.f15872 != null) {
            this.f15872.clear();
        }
        if (this.f15887 != null) {
            this.f15887.m16687();
        }
        if (this.f15877 != null) {
            AG.m3329(m16093(), this.f15877);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m16711(oR oRVar, final AbstractC1254 r4) {
        this.f15889 = true;
        m16701(oRVar, C1098.m16202(m16093()), new C0452() { // from class: o.ｽ.8
            @Override // o.C0452, o.AbstractC1254
            /* renamed from: ˋ */
            public void mo1407(ConfigData configData, Status status) {
                super.mo1407(configData, status);
                if (r4 != null) {
                    r4.mo1407(configData, status);
                }
                C1260.this.s_().postDelayed(C1260.this.f15883, 28800000);
                C1260.this.m16734();
            }
        });
    }

    /* renamed from: ˊʼ  reason: contains not printable characters */
    public boolean m16745() {
        return this.f15860 < this.f15891.m16649();
    }

    /* renamed from: ˉॱ  reason: contains not printable characters */
    public boolean m16742() {
        return this.f15860 >= this.f15891.m16653();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private ImageResolutionClass m16699(Context context) {
        if (mo16548()) {
            C1283.m16846("nf_configurationagent", "Device is low memory category - use low resolution images");
            return ImageResolutionClass.LOW;
        }
        int r5 = AD.m3308(context);
        C1283.m16848("nf_configurationagent", "computeImageResolutionClass() dpi: %d", Integer.valueOf(r5));
        if (r5 <= 160 && AD.m3290(context) == 3) {
            C1283.m16846("nf_configurationagent", "Device is a low-res, small tablet - use medium resolution images");
            return ImageResolutionClass.MEDIUM;
        } else if (AD.m3299()) {
            return ImageResolutionClass.HIGH;
        } else {
            if (r5 < 213) {
                return ImageResolutionClass.LOW;
            }
            if (r5 <= 240) {
                return ImageResolutionClass.MEDIUM;
            }
            return ImageResolutionClass.HIGH;
        }
    }

    @Override // o.AbstractC1221
    /* renamed from: ॱ */
    public DeviceCategory mo16541() {
        if (AD.m3303()) {
            return DeviceCategory.CHROME_OS;
        }
        if (AD.m3320()) {
            return DeviceCategory.ANDROID_STB;
        }
        if (AD.m3281()) {
            return DeviceCategory.ANDROID_TV;
        }
        if (AD.m3299()) {
            return DeviceCategory.TABLET;
        }
        return DeviceCategory.PHONE;
    }

    @Override // o.AbstractC1221
    /* renamed from: ˊ */
    public int mo16516() {
        int r5 = this.f15884.m16582();
        if (r5 == 0) {
            r5 = 33554432;
            if (AV.m3472() && g_()) {
                if (mo16522().getMaxHeight() >= 1080) {
                    C1283.m16854("nf_configurationagent", "Device is enabled for HD, support 1080P");
                    r5 = 96468992;
                } else {
                    C1283.m16854("nf_configurationagent", "Device is enabled for HD, support 720P");
                    r5 = 67108864;
                }
            }
        }
        C1283.m16851("nf_configurationagent", "VideoBufferSize: %d", Integer.valueOf(r5));
        return r5;
    }

    @Override // o.AbstractC1221
    @SuppressLint({"NewApi"})
    /* renamed from: ˋ */
    public VideoResolutionRange mo16522() {
        if (this.f15880 == null) {
            int r2 = mo16530();
            if (r2 > 0) {
                this.f15880 = VideoResolutionRange.getVideoResolutionRangeFromMaxHieght(r2);
            } else {
                int i = Integer.MAX_VALUE;
                Display[] displays = ((DisplayManager) this.f15879.getSystemService("display")).getDisplays();
                int length = displays.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Display display = displays[i2];
                    if (display.isValid() && display.getDisplayId() == 0) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        display.getMetrics(displayMetrics);
                        i = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels);
                        break;
                    }
                    i2++;
                }
                this.f15880 = VideoResolutionRange.getVideoResolutionRangeFromMaxHieght(i);
            }
        }
        return this.f15880;
    }

    @Override // o.AbstractC1221
    public AbstractC0518 d_() {
        return this.f15859;
    }

    /* renamed from: ˈॱ  reason: contains not printable characters */
    public String m16741() {
        return this.f15865;
    }

    /* renamed from: ˊʻ  reason: contains not printable characters */
    public boolean m16744() {
        return this.f15891.m16656();
    }

    /* renamed from: ˊʽ  reason: contains not printable characters */
    public long m16746() {
        return this.f15891.m16664();
    }

    /* renamed from: ˋʼ  reason: contains not printable characters */
    public String m16750() {
        return this.f15891.m16669();
    }

    @Override // o.AbstractC1221
    /* renamed from: ॱॱ */
    public ApiEndpointRegistry mo16547() {
        return this.f15861;
    }

    @Override // o.AbstractC1221
    /* renamed from: ـ */
    public int mo16539() {
        return mo16548() ? 2 : 4;
    }

    @Override // o.AbstractC1221
    public boolean e_() {
        return this.f15869;
    }

    @Override // o.AbstractC1221
    /* renamed from: ˋ */
    public ConsolidatedLoggingSessionSpecification mo16523(String str) {
        return this.f15891.m16654(str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m16701(oR oRVar, List<String> list, final AbstractC1254 r8) {
        C1283.m16851("nf_configurationagent", "fetchConfigData %s", list);
        this.f15889 = true;
        t_().mo15842(this.f15876.m16247(oRVar, list, new C0452() { // from class: o.ｽ.9
            @Override // o.C0452, o.AbstractC1254
            /* renamed from: ˋ */
            public void mo1407(ConfigData configData, Status status) {
                C1283.m16851("nf_configurationagent", "onConfigDataFetched statusCode=%d", Integer.valueOf(status.mo302().m271()));
                C1260.this.f15857 = status;
                if (status.mo298() && configData != null) {
                    C1260.this.f15889 = false;
                    C1260.this.m16753(configData);
                }
                if (r8 != null) {
                    r8.mo1407(configData, C1260.this.f15857);
                }
            }
        }));
    }

    @Override // o.AbstractC1221
    /* renamed from: ˋॱ */
    public void mo16526() {
        this.f15884.m16577();
        this.f15882.m16595();
        C1272.m16801(m16093());
    }

    @Override // o.AbstractC1221
    /* renamed from: ˏ */
    public void mo16534(oR oRVar, AbstractC1254 r3) {
        m16747(oRVar, r3, null);
    }

    @Override // o.AbstractC1052
    /* renamed from: ʼ */
    public void mo5196() {
        C1279 r1 = this.f15861;
        if (r1 != null) {
            r1.mo1457().mo1464();
        }
    }

    @Override // o.AbstractC1221
    public int f_() {
        return this.f15891.m16640();
    }

    @Override // o.AbstractC1221
    /* renamed from: ˈ */
    public int mo16514() {
        int r1 = this.f15891.m16631();
        if (r1 > 0) {
            return r1;
        }
        return 1800;
    }

    /* renamed from: ॱˍ  reason: contains not printable characters */
    private void m16733() {
        if (m16727(this.f15879)) {
            this.f15891.m16663();
            C1283.m16854("nf_configurationagent", "Device Config & Streaming Config in cache... proceed!");
            m16721();
            m16739();
            return;
        }
        C1283.m16854("nf_configurationagent", "Need to fetch device config on app start ");
        m16731();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m16727(Context context) {
        return C1349Bv.m4107(C1339Bl.m4045(context, "deviceConfig", (String) null));
    }

    /* renamed from: ॱˉ  reason: contains not printable characters */
    private void m16731() {
        m16701((oR) null, Arrays.asList(C1098.f15273), new C0452() { // from class: o.ｽ.7
            /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00a0: APUT  (r1v7 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r2v5 java.lang.Object) */
            @Override // o.C0452, o.AbstractC1254
            /* renamed from: ˋ */
            public void mo1407(ConfigData configData, Status status) {
                C1283.m16851("nf_configurationagent", "onConfigDataFetched statusCode=%d", Integer.valueOf(status.mo302().m271()));
                if (!status.mo298() || configData == null) {
                    C1283.m16844("nf_configurationagent", "error in fetching first config status: %s, deviceConfig: %s", status, configData);
                    if (C1260.this.f15891.m16633()) {
                        C1260.this.f15891.m16661();
                        C1283.m16865("nf_configurationagent", "recovered using pre-5.0 configs");
                        status = AbstractC0367.f13235;
                    }
                    if (ConnectivityUtils.m2954(C1260.this.f15879)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = status;
                        objArr[1] = configData != null ? configData : "";
                        C1276.m16820().mo5725(String.format("status= %s, configData= %s", objArr));
                    }
                    C1260.this.m16090(status.mo301() ? AbstractC0367.f13211 : status);
                    return;
                }
                Status r5 = C1260.this.m16713(configData);
                if (AbstractC0367.f13235 != r5) {
                    C1283.m16844("nf_configurationagent", "cannot proceed, received config is fatal. %s", configData);
                    C1260.this.m16090(r5);
                    return;
                }
                C1260.this.m16753(configData);
                boolean unused = C1260.f15855 = true;
                C1260.this.f15891.m16663();
                C1260.this.m16721();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m16715(Context context) {
        return C1349Bv.m4107(C1339Bl.m4045(context, "useragent_current_profile_id", (String) null));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private Status m16713(ConfigData configData) {
        if (configData == null || configData.deviceConfig == null) {
            return AbstractC0367.f13235;
        }
        if (configData.deviceConfig.shouldForceLegacyCrypto()) {
            return AbstractC0367.f13227;
        }
        if (configData.deviceConfig.isBlacklisted()) {
            return AbstractC0367.f13248;
        }
        return AbstractC0367.f13235;
    }

    /* renamed from: ˌॱ  reason: contains not printable characters */
    public boolean m16752() {
        return m16749() && C1262.m16757(this.f15879) && C0365.m14066(this.f15879);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m16748(AbstractC1254 r9) {
        boolean r4 = m16749();
        boolean r5 = C1262.m16757(this.f15879);
        boolean r6 = C0365.m14066(this.f15879);
        if (!r4 || !r5 || !r6) {
            ArrayList arrayList = new ArrayList();
            if (!r4) {
                arrayList.add(C1098.f15269);
            }
            if (!r5) {
                arrayList.add(C1098.f15271);
            }
            if (!r6) {
                arrayList.add(C1098.f15268);
            }
            C1283.m16851("nf_configurationagent", "fetching esnBasedConfigs pqls: %s", arrayList);
            m16701((oR) null, arrayList, r9);
            return;
        }
        C1283.m16854("nf_configurationagent", "Skipping fetch of esn dependent configs");
        r9.mo1407(null, AbstractC0367.f13235);
    }

    /* renamed from: ˋʽ  reason: contains not printable characters */
    public void m16751() {
        C1283.m16854("nf_configurationagent", "refreshing signInConfigs ");
        ArrayList arrayList = new ArrayList();
        arrayList.add(C1098.f15275);
        arrayList.add(C1098.f15273);
        m16701((oR) null, arrayList, new C0452() { // from class: o.ｽ.6
            @Override // o.C0452, o.AbstractC1254
            /* renamed from: ˋ */
            public void mo1407(ConfigData configData, Status status) {
                C1283.m16854("nf_configurationagent", String.format("on refreshSignInAndDeviceConfig statusCode=%d", Integer.valueOf(status.mo302().m271())));
                if (status.mo298() && configData != null && AbstractC0367.f13235 == C1260.this.m16713(configData)) {
                    C1260.this.m16753(configData);
                }
            }
        });
    }

    @Override // o.AbstractC1221
    /* renamed from: ˎ */
    public int mo16530() {
        return this.f15891.m16666();
    }

    @Override // o.AbstractC1221
    /* renamed from: ˊˊ */
    public BreadcrumbLoggingSpecification mo16519() {
        return this.f15891.m16630();
    }

    @Override // o.AbstractC1221
    /* renamed from: ˊᐝ */
    public ErrorLoggingSpecification mo16521() {
        return this.f15891.m16637();
    }

    @Override // o.AbstractC1221
    /* renamed from: ˑ */
    public PdsAndLogblobConfig mo16537() {
        return this.f15891.m16636();
    }

    @Override // o.AbstractC1221
    public boolean g_() {
        return this.f15891.m16672();
    }

    @Override // o.AbstractC1221
    public boolean h_() {
        if ((this.f15891.m16626() & 2) == 0 || !C1915jp.m8029()) {
            return false;
        }
        return true;
    }

    @Override // o.AbstractC1221
    public boolean i_() {
        return this.f15891.m16670();
    }

    @Override // o.AbstractC1221
    public boolean j_() {
        return this.f15891.m16629();
    }

    @Override // o.AbstractC1221
    public boolean k_() {
        return this.f15891.m16627();
    }

    @Override // o.AbstractC1221
    /* renamed from: ॱʽ */
    public boolean mo16544() {
        if ((this.f15891.m16626() & 4) == 0 || !C1915jp.m8029()) {
            return false;
        }
        return true;
    }

    @Override // o.AbstractC1221
    /* renamed from: ॱˋ */
    public int mo16545() {
        return this.f15891.m16659();
    }

    @Override // o.AbstractC1221
    /* renamed from: ॱ */
    public BwCap mo16540(StreamProfileType streamProfileType) {
        return this.f15884.m16575(streamProfileType);
    }

    @Override // o.AbstractC1221
    public StreamingCodecPrefData l_() {
        StreamingCodecPrefData r1 = this.f15884.m16568();
        if (r1 == null) {
            return this.f15891.m16632();
        }
        return r1;
    }

    @Override // o.AbstractC1221
    public OfflineCodecPrefData m_() {
        OfflineCodecPrefData r1 = this.f15884.m16569();
        if (r1 == null) {
            return this.f15891.m16628();
        }
        return r1;
    }

    @Override // o.AbstractC1221
    public int n_() {
        return this.f15891.m16645();
    }

    @Override // o.AbstractC1221
    public String o_() {
        return this.f15884.m16570();
    }

    @Override // o.AbstractC1221
    public String p_() {
        return this.f15884.m16581();
    }

    @Override // o.AbstractC1221
    /* renamed from: ˊˋ */
    public AbstractC0402 mo16520() {
        return this.f15885;
    }

    @Override // o.AbstractC1221
    /* renamed from: ˉ */
    public AbstractC0346 mo16515() {
        return this.f15881;
    }

    @Override // o.AbstractC1221
    /* renamed from: ˍ */
    public boolean mo16529() {
        return this.f15891.m16667();
    }

    @Override // o.AbstractC1221
    /* renamed from: ˋˋ */
    public String mo16525() {
        return this.f15891.m16671();
    }

    @Override // o.AbstractC1221
    public boolean q_() {
        return !this.f15868 || !this.f15891.m16647().isEnableVoip() || (this.f15891.m16648() && this.f15884.m16578());
    }

    @Override // o.AbstractC1221
    /* renamed from: ˏˎ */
    public boolean mo16535() {
        return this.f15891.m16673();
    }

    @Override // o.AbstractC1221
    /* renamed from: ॱʻ */
    public boolean mo16542() {
        return this.f15891.m16668();
    }

    @Override // o.AbstractC1221
    /* renamed from: ॱͺ */
    public Pair<String, byte[]> mo16546() {
        String r2 = this.f15892.m16690();
        String r3 = this.f15892.m16688();
        if (C1349Bv.m4113(r3) || C1349Bv.m4113(r2)) {
            C1283.m16854("nf_configurationagent", "cast sharedSecret are null");
            return null;
        }
        try {
            return Pair.create(r2, C1323Aw.m3800(r3));
        } catch (IOException e) {
            return null;
        }
    }

    @Override // o.AbstractC1221
    /* renamed from: ॱʼ */
    public boolean mo16543() {
        if (this.f15891 != null) {
            return this.f15891.m16651();
        }
        return false;
    }

    @Override // o.AbstractC1221
    /* renamed from: ˋᐝ */
    public VoipConfiguration mo16527() {
        return this.f15891.m16647();
    }

    @Override // o.AbstractC1221
    /* renamed from: ˌ */
    public SubtitleDownloadRetryPolicy mo16528() {
        return this.f15891.m16644();
    }

    @Override // o.AbstractC1221
    /* renamed from: ˎˎ */
    public NonMemberData mo16531() {
        NonMemberData r1 = m16735();
        NonMemberData nonMemberData = this.f15886.f15910;
        if (r1 != null && r1.isValid()) {
            return r1;
        }
        if (nonMemberData == null || !nonMemberData.isValid()) {
            return null;
        }
        return nonMemberData;
    }

    /* renamed from: ˋʻ  reason: contains not printable characters */
    public boolean m16749() {
        return this.f15886.f15910 != null && this.f15886.f15910.isValid();
    }

    @Override // o.AbstractC1221
    /* renamed from: ˊ */
    public void mo16517(NonMemberData nonMemberData) {
        if (nonMemberData == null || !nonMemberData.isValid()) {
            C1283.m16850("nf_configurationagent", "formerMemberData object is null - ignore overwrite");
            return;
        }
        C1339Bl.m4039(this.f15879, "formerMemberInfo", nonMemberData.toJsonString());
    }

    /* renamed from: ॱـ  reason: contains not printable characters */
    private NonMemberData m16735() {
        String r3 = C1339Bl.m4045(this.f15879, "formerMemberInfo", (String) null);
        if (C1349Bv.m4107(r3)) {
            return NonMemberData.fromJsonString(r3);
        }
        return null;
    }

    @Override // o.AbstractC1221
    /* renamed from: ˎˏ */
    public void mo16532() {
        C1339Bl.m4049(this.f15879);
    }

    @Override // o.AbstractC1221
    /* renamed from: ˏˏ */
    public void mo16536() {
        this.f15886.m16759();
    }

    @Override // o.AbstractC1221
    /* renamed from: ͺॱ */
    public SignInConfigData mo16538() {
        return this.f15890.f13194;
    }

    @Override // o.AbstractC1221
    /* renamed from: ˊ */
    public void mo16518(String str, String str2, AbstractC1254 r5) {
        t_().mo15842(this.f15876.m16251(str, str2, r5));
    }

    @Override // o.AbstractC1221
    /* renamed from: ᐧ */
    public C0351 mo16552() {
        return this.f15871;
    }

    @Override // o.AbstractC1221
    /* renamed from: ᐨ */
    public ImageResolutionClass mo16553() {
        return m16699(m16093());
    }

    @Override // o.AbstractC1221
    /* renamed from: ᐝˊ */
    public String mo16549() {
        return this.f15891.m16662();
    }

    @Override // o.AbstractC1221
    /* renamed from: ㆍ */
    public OfflineUnavailableReason mo16555() {
        if (this.f15891.m16646().isOfflineFeatureDisabled()) {
            return OfflineUnavailableReason.NA_DISABLED_FROM_END_POINT;
        }
        if (this.f15878) {
            return OfflineUnavailableReason.NA_DISABLED_BY_SYSTEM_ID_4266_FROM_SERVER;
        }
        if (this.f15859.mo14530() != CryptoProvider.WIDEVINE_L3 || !"4266".equals(this.f15859.mo14537())) {
            return null;
        }
        return OfflineUnavailableReason.NA_DISABLED_BY_SYSTEM_ID_4266;
    }

    @Override // o.AbstractC1221
    /* renamed from: ᐝᐝ */
    public int mo16551() {
        return this.f15891.m16646().getMaintenanceJobPeriodInHrs();
    }

    @Override // o.AbstractC1221
    /* renamed from: ꜟ */
    public boolean mo16558() {
        return mo16555() != null;
    }

    @Override // o.AbstractC1221
    /* renamed from: ˏ */
    public void mo16533(StatusCode statusCode) {
        if (statusCode == StatusCode.DL_BLACKLISTED_DEVICE) {
            C1283.m16854("nf_configurationagent", "Device is blacklisted, disable offline");
            C1339Bl.m4048(this.f15879, "offline_blaclisted_device_override", true);
            this.f15878 = true;
            v_().mo5362(C1061.m16114().mo14162().mo1764(this.f15879, statusCode));
        }
    }

    @Override // o.AbstractC1221
    /* renamed from: ꓸ */
    public String mo16556() {
        return this.f15891.m16660();
    }

    @Override // o.AbstractC1221
    /* renamed from: ᶥ */
    public boolean mo16554() {
        if (this.f15891 != null) {
            return this.f15891.m16658();
        }
        return false;
    }

    @Override // o.AbstractC1221
    /* renamed from: ᐝˋ */
    public boolean mo16550() {
        if (this.f15891 != null) {
            return this.f15891.m16665();
        }
        return true;
    }

    @Override // o.AbstractC1221
    /* renamed from: ꜞ */
    public boolean mo16557() {
        if (this.f15891 == null || this.f15891.m16647() == null) {
            return false;
        }
        return this.f15891.m16647().isShowHelpForNonMember();
    }

    /* renamed from: ˏͺ  reason: contains not printable characters */
    public boolean m16754() {
        return C0836.m15479() || (this.f15891 != null && this.f15891.m16652());
    }

    @Override // o.AbstractC1221
    /* renamed from: ﹳ */
    public String mo16560() {
        if (this.f15887 != null) {
            return this.f15887.m16686();
        }
        return null;
    }

    @Override // o.AbstractC1221
    /* renamed from: ʹ */
    public String mo16502() {
        if (m16086() == null || m16086().mo1511() == null) {
            return null;
        }
        return m16086().mo1511().mo1481();
    }

    @Override // o.AbstractC1221
    /* renamed from: ﾞ */
    public boolean mo16561() {
        return this.f15858;
    }

    @Override // o.AbstractC1221
    /* renamed from: ﾟ */
    public String mo16562() {
        return this.f15888.m483();
    }

    @Override // o.AbstractC1221
    /* renamed from: ꞌ */
    public String mo16559() {
        if (C1349Bv.m4113(this.f15863)) {
            this.f15863 = SecurityRepository.getSystemPropety("ro.board.platform");
        }
        return this.f15863;
    }

    @Override // o.AbstractC1221
    /* renamed from: ʼˊ */
    public String mo16506() {
        if (C1349Bv.m4113(this.f15864)) {
            this.f15864 = SecurityRepository.getSystemPropety("ro.hardware");
        }
        return this.f15864;
    }

    @Override // o.AbstractC1221
    /* renamed from: ʻˋ */
    public String mo16504() {
        if (C1349Bv.m4113(this.f15862)) {
            this.f15862 = SecurityRepository.getSystemPropety("ro.netflix.bsp_rev");
        }
        return this.f15862;
    }

    @Override // o.AbstractC1221
    /* renamed from: ʼˋ */
    public boolean mo16507() {
        return this.f15891.m16655();
    }

    @Override // o.AbstractC1221
    /* renamed from: ʻˊ */
    public String mo16503() {
        return this.f15884.m16573();
    }

    @Override // o.AbstractC1221
    /* renamed from: ʽᐝ */
    public boolean mo16511() {
        if (!C0916.m15719(m16093())) {
            return false;
        }
        C1283.m16854("nf_configurationagent", "Current user is in AB test (cell 2) to use MSL for all requests");
        return true;
    }

    /* renamed from: ॱˌ  reason: contains not printable characters */
    private void m16732() {
    }

    /* renamed from: ॱᶥ  reason: contains not printable characters */
    private void m16738() {
    }

    /* renamed from: ˎͺ  reason: contains not printable characters */
    public static int m16712() {
        return C1337Bj.m4029() ? 2 : 4;
    }

    /* renamed from: ˑॱ  reason: contains not printable characters */
    public static int m16718() {
        return 1000;
    }

    /* renamed from: ͺˏ  reason: contains not printable characters */
    public static int m16720() {
        return SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS;
    }

    /* renamed from: ͺˎ  reason: contains not printable characters */
    public static int m16719() {
        return 4;
    }

    /* renamed from: ߴ  reason: contains not printable characters */
    public static long m16723() {
        return 1209600000;
    }

    /* renamed from: ٴ  reason: contains not printable characters */
    public static int m16722() {
        return f15856;
    }

    @Override // o.AbstractC1221
    /* renamed from: ˋ */
    public void mo16524(boolean z, AbstractC1254 r3) {
        m16092(this.f15876.m16249(z, r3));
    }

    /* renamed from: ॱᐨ  reason: contains not printable characters */
    private void m16737() {
        AnonymousClass1 r3 = new C0452() { // from class: o.ｽ.1
            @Override // o.C0452, o.AbstractC1254
            /* renamed from: ˋ */
            public void mo5712(Status status) {
                super.mo5712(status);
                C1283.m16851("nf_configurationagent", "dummyCallDone status: %s", status);
            }
        };
        t_().mo15842(this.f15876.m16249(false, (AbstractC1254) r3));
        t_().mo15842(this.f15876.m16249(false, (AbstractC1254) r3));
    }

    /* renamed from: ॱꓸ  reason: contains not printable characters */
    private void m16739() {
        m16737();
    }

    @Override // o.AbstractC1221
    /* renamed from: ʽˊ */
    public void mo16509() {
        mo16532();
    }

    /* renamed from: י  reason: contains not printable characters */
    public boolean m16756() {
        return !mo16511() && !C0709.m15037(m16093());
    }

    @Override // o.AbstractC1221
    /* renamed from: ʼᐝ */
    public boolean mo16508() {
        if (mo16511()) {
            return false;
        }
        return this.f15874.get();
    }

    @Override // o.AbstractC1221
    /* renamed from: ʿॱ */
    public boolean mo16513() {
        return this.f15891.m16674();
    }

    /* renamed from: ՙ  reason: contains not printable characters */
    public void m16755() {
        this.f15874.set(false);
    }
}
