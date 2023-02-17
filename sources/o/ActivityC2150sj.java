package o;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.HashMap;
import java.util.Map;
import kotlin.TypeCastException;
import o.AbstractC0459;
import o.oN;
import o.qH;
/* renamed from: o.sj  reason: case insensitive filesystem */
public class ActivityC2150sj extends AbstractActivityC0360 {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0202 f10162 = new C0202(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private Map<String, String> f10163;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f10164;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f10165;

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            m10738();
        }
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.app.Activity
    public void finish() {
        if (this.f10165 || this.f10164) {
            HashMap hashMap = new HashMap();
            hashMap.put("nf_watch_history", IClientLogging.CompletionReason.canceled.name());
            m10736(hashMap);
            m10734(hashMap);
        }
        super.finish();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canShowDownloadProgressBar() {
        return !NetflixBottomNavBar.m416();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canApplyBrowseExperience() {
        return true;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldApplyPaddingToSlidingPanel() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        return new C2145sg();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˊ */
    public int mo10187() {
        return R.layout.watch_history_activity;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        C1457Fr.m5025(intent, "intent");
        super.onNewIntent(intent);
        closeAllPopupMenus();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.watchHistory;
    }

    /* renamed from: o.sj$iF  reason: case insensitive filesystem */
    public static final class C2151iF implements oV {

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ ActivityC2150sj f10167;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C2151iF(ActivityC2150sj sjVar) {
            this.f10167 = sjVar;
        }

        @Override // o.oV
        public void onManagerReady(C2059ph phVar, Status status) {
            C1457Fr.m5025(phVar, "svcManager");
            C1457Fr.m5025(status, "res");
            if (!C1317As.m3750(this.f10167)) {
                this.f10167.setupInteractiveTracking(new qH.C0167(), this.f10167.m10739());
                if (this.f10167.mo10792() instanceof C2145sg) {
                    Fragment r0 = this.f10167.mo10792();
                    if (r0 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.history.WatchHistoryFragment");
                    }
                    ((C2145sg) r0).onManagerReady(phVar, status);
                }
                this.f10167.m10740();
            }
        }

        @Override // o.oV
        public void onManagerUnavailable(C2059ph phVar, Status status) {
            C1457Fr.m5025(status, "res");
            if (!C1317As.m3750(this.f10167)) {
                C1283.m16850("nf_watch_history", "NetflixService is NOT available!");
                if (this.f10167.mo10792() instanceof C2145sg) {
                    Fragment r0 = this.f10167.mo10792();
                    if (r0 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.history.WatchHistoryFragment");
                    }
                    ((C2145sg) r0).onManagerUnavailable(phVar, status);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new C2151iF(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.sj$if  reason: invalid class name */
    public static final class Cif implements oN.AbstractC0161 {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ ActivityC2150sj f10168;

        Cif(ActivityC2150sj sjVar) {
            this.f10168 = sjVar;
        }

        @Override // o.oN.AbstractC0161
        /* renamed from: ˊ */
        public final void mo1655(IClientLogging.CompletionReason completionReason) {
            HashMap hashMap = new HashMap();
            hashMap.put("reason", completionReason.name());
            this.f10168.m10734(hashMap);
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public final oN.AbstractC0161 m10739() {
        return new Cif(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.sj$If */
    public static final class If implements AbstractC0459.AbstractC0460 {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ ActivityC2150sj f10166;

        If(ActivityC2150sj sjVar) {
            this.f10166 = sjVar;
        }

        @Override // o.AbstractC0459.AbstractC0460
        /* renamed from: ˎ */
        public final void mo1654(Status status) {
            this.f10166.m10736(null);
            this.f10166.setLoadingStatusCallback(null);
            if (!this.f10166.isFinishing()) {
                C1283.m16854("nf_watch_history", "DetailsPage is loaded, reporting navigate.ended for movieDetails");
                C1362Ch.m4388(this.f10166.getUiScreen().f4084, IClientLogging.CompletionReason.success, (UIError) null);
                Logger.INSTANCE.m133("Navigate");
                C1457Fr.m5016((Object) status, "res");
                if (status.mo301()) {
                    this.f10166.handleFalkorAgentErrors(status);
                }
            }
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public final void m10740() {
        setLoadingStatusCallback(new If(this));
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private final void m10738() {
        C1283.m16854("nf_watch_history", "WH_TTI && WH_TTR START");
        this.f10164 = true;
        this.f10165 = true;
        PerformanceProfiler.INSTANCE.m663(Sessions.WH_TTR);
        PerformanceProfiler.INSTANCE.m663(Sessions.WH_TTI);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m10734(Map<String, String> map) {
        if (!this.f10165) {
            return;
        }
        if (this.f10164) {
            C1283.m16862("InteractiveTrackerImpl", "TTR deferred... (was before TTI)");
            this.f10163 = map;
            return;
        }
        C1283.m16854("nf_watch_history", "WH_TTR ENDS");
        this.f10165 = false;
        PerformanceProfiler.INSTANCE.m665(Sessions.WH_TTR, map);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m10736(Map<String, String> map) {
        if (this.f10164) {
            C1283.m16854("nf_watch_history", "WH_TTI ENDS");
            this.f10164 = false;
            PerformanceProfiler.INSTANCE.m665(Sessions.WH_TTI, map);
            if (this.f10163 != null) {
                m10734(map);
            }
        }
    }

    /* renamed from: o.sj$ˋ  reason: contains not printable characters */
    public static final class C0202 {
        private C0202() {
        }

        public /* synthetic */ C0202(C1456Fq fq) {
            this();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final Intent m10741(Context context) {
            C1457Fr.m5025(context, "context");
            return new Intent(context, m10742());
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final Class<?> m10742() {
            return NetflixApplication.getInstance().m254() ? ActivityC2142sd.class : ActivityC2150sj.class;
        }
    }
}
