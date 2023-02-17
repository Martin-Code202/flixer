package o;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.netflix.android.widgetry.widget.TrackedLinearLayoutManager;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.service.logging.perf.Events;
import com.netflix.mediaclient.service.logging.perf.PerformanceProfiler;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
import com.netflix.model.leafs.LoLoMoSummary;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import o.AbstractC0459;
import o.C0567;
import o.tP;
public class tQ extends AbstractC2163su implements LolomoRecyclerViewAdapter.Cif, AbstractC2124rm {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected LolomoRecyclerViewAdapter f10409;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected Long f10410;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected C0616 f10411;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private Disposable f10412;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected GenreList f10413;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private boolean f10414;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final BroadcastReceiver f10415 = new BroadcastReceiver() { // from class: o.tQ.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetflixActivity r1 = tQ.this.m14534();
            if (r1 != null && r1.getServiceManager().mo9519()) {
                tQ.this.m11007(r1);
            }
        }
    };

    /* renamed from: ʿ  reason: contains not printable characters */
    private boolean f10416;

    /* renamed from: ˈ  reason: contains not printable characters */
    private SwipeRefreshLayout f10417;

    /* renamed from: ˉ  reason: contains not printable characters */
    private Parcelable f10418;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private final BroadcastReceiver f10419 = new BroadcastReceiver() { // from class: o.tQ.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetflixActivity r1 = tQ.this.m14534();
            if (r1 != null && r1.getServiceManager().mo9519()) {
                tQ.this.m11012();
            }
        }
    };

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected boolean f10420;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected boolean f10421;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected String f10422;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected Drawable f10423;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected zW f10424;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected C1301Ad f10425;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    C2216up f10426;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private boolean f10427;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected FrameLayout f10428;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected final C0567.Cif f10429 = new C0567.Cif() { // from class: o.tQ.6
        @Override // o.C0567.Cif
        public void N_() {
            tQ.this.mo10856(1, (String) null);
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected tV f10430;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private LoLoMoSummary f10431 = null;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static tQ m11003(String str, GenreList genreList) {
        tQ tQVar = new tQ();
        Bundle bundle = new Bundle();
        bundle.putString("genre_id", str);
        bundle.putBoolean("is_genre_list", !"lolomo".equals(str));
        if (genreList != null) {
            bundle.putParcelable("genre_parcel", genreList);
        }
        tQVar.setArguments(bundle);
        return tQVar;
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments().setClassLoader(C0843.class.getClassLoader());
        this.f10422 = getArguments().getString("genre_id");
        this.f10427 = getArguments().getBoolean("is_genre_list");
        this.f10413 = (GenreList) getArguments().getParcelable("genre_parcel");
        this.f10423 = C2221uu.m11755(getActivity());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public int m11020() {
        return R.layout.lolomo_content_frag;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1283.m16846("LoLoMoFrag", "Creating frag view");
        this.f10428 = (FrameLayout) layoutInflater.inflate(m11020(), viewGroup, false);
        this.f10414 = bundle == null;
        mo11014(this.f10428);
        if (this.f10409 != null) {
            this.f10411.mo14663(false);
        }
        if (tP.Cif.m10990()) {
            this.f10426 = new C2216up(this);
        }
        m11017(this.f10428);
        m11011();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            LocalBroadcastManager.getInstance(activity).registerReceiver(this.f10415, new IntentFilter("RefreshUserMessageRequest.ACTION_UMA_MESSAGE_UPDATED"));
            LocalBroadcastManager.getInstance(activity).registerReceiver(this.f10419, new IntentFilter("RefreshUserMessageRequest.ACTION_DISMISS_UMA_MESSAGE"));
        }
        return this.f10428;
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        final NetflixActionBar netflixActionBar = m14534().getNetflixActionBar();
        if (netflixActionBar != null) {
            this.f10430.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: o.tQ.4
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    tQ.this.mo11018(netflixActionBar);
                }
            });
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public FrameLayout m11015() {
        return this.f10428;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo11014(View view) {
        if (BrowseExperience.m1780()) {
            this.f10411 = new C0527(view, this.f10429, C0527.f13715);
            this.f10411.mo14659(0, this.f13651 + this.f13649, 0, this.f13650);
            return;
        }
        this.f10411 = new C0527(view, this.f10429, C0527.f13714);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11017(View view) {
        this.f10430 = (tV) view.findViewById(R.id.lolomo);
        this.f10430.setLayoutManager(new TrackedLinearLayoutManager(view.getContext(), 1, false) { // from class: o.tQ.5
            @Override // com.netflix.android.widgetry.widget.TrackedLayoutManager
            /* renamed from: ˊ */
            public String mo104() {
                return "LolomoLinearLayoutManager";
            }

            @Override // com.netflix.android.widgetry.widget.TrackedLayoutManager
            /* renamed from: ˏ */
            public void mo105(String str) {
            }
        });
        if (BrowseExperience.m1780()) {
            this.f10430.setFlingSpeedScale(0.5f);
        }
        if (this.f10409 != null) {
            this.f10409.m2057(this.f10426);
            if (m10855() != null) {
                this.f10410 = Logger.INSTANCE.m142(new C1224(C1300Ac.m3527(m10855().getId()), AppView.browseTitles));
            }
        } else if (this.f10427) {
            this.f10409 = new LolomoRecyclerViewAdapter(m14534(), this, this.f10422, this.f10426);
        } else {
            this.f10409 = new LolomoRecyclerViewAdapter(m14534(), this, this.f10426);
        }
        this.f10430.setLolomoAdapter(this.f10409);
        this.f10430.addOnScrollListener(yO.m13227());
        if (this.f10426 != null) {
            this.f10426.m11729(this.f10430);
        }
        m11004(view);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10409 != null) {
            this.f10409.m15469(getActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f10409 != null) {
            this.f10409.m15460(getActivity());
        }
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (this.f10409 != null) {
            this.f10409.m15470(getActivity(), z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        C1283.m16846("LoLoMoFrag", "onDestroyView");
        if (this.f10409 != null) {
            this.f10409.m15471(getActivity());
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            LocalBroadcastManager.getInstance(activity).unregisterReceiver(this.f10415);
            LocalBroadcastManager.getInstance(activity).unregisterReceiver(this.f10419);
        }
        Logger.INSTANCE.m140(this.f10410);
        this.f10410 = null;
        super.onDestroyView();
    }

    @Override // o.AbstractC2163su
    /* renamed from: ˏ */
    public void mo10856(int i, String str) {
        if (i == 1) {
            m11009();
            if (this.f10425 != null) {
                this.f10425.m3568(false);
                this.f10425 = null;
            }
            if (this.f10426 != null) {
                this.f10426.m11731();
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f10409.m2061(activity, i, str);
        }
    }

    @Override // o.AbstractC2163su
    /* renamed from: ˋ */
    public void mo10854(boolean z) {
        if (this.f10430 == null) {
            return;
        }
        if (z) {
            this.f10430.smoothScrollToPosition(0);
        } else {
            this.f10430.scrollToPosition(0);
        }
    }

    @Override // com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter.Cif
    /* renamed from: ॱ */
    public void mo2067(Status status) {
        FragmentActivity activity;
        this.f10421 = true;
        if (this.f10409 == null) {
            C1276.m16820().mo5725("onDataLoaded called but adapter is null");
        } else if (status == null || status.mo298() || this.f10409.getItemCount() != 0) {
            C1283.m16846("LoLoMoFrag", "Hiding loading and error views");
            this.f10411.mo14663(false);
            BQ.m3911(this.f10430, true);
            if (!(this.f10430.m11037() == null || this.f10430.m11037().m2063() <= 0 || (activity = getActivity()) == null)) {
                m11007(activity);
            }
            this.f10420 = false;
            if (this.f10409 != null) {
                Iterator<pC> it = this.f10409.m2047().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getType() == LoMoType.BILLBOARD) {
                            this.f10420 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            m11019();
        }
        if (m11002() && this.f10417 != null) {
            this.f10417.setRefreshing(false);
            this.f10417.setEnabled(true);
        }
        View view = getView();
        if (view != null) {
            mo2213(view);
        }
        m11013();
        af_();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11004(View view) {
        this.f10417 = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
        if (this.f10417 != null) {
            this.f10417.setEnabled(false);
            if (m11002()) {
                this.f10417.setProgressViewOffset(false, this.f13651 + this.f13649, this.f13651 + this.f13649 + C1004.m15954(getContext(), 64));
                Activity activity = (Activity) C1322Av.m3791(view.getContext(), Activity.class);
                this.f10417.setColorSchemeColors(BrowseExperience.m1767(activity, 16842806));
                this.f10417.setProgressBackgroundColorSchemeColor(BrowseExperience.m1767(activity, (int) R.attr.colorPrimary));
                this.f10417.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: o.tQ.1
                    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
                    public void onRefresh() {
                        tQ.this.mo10856(2, (String) null);
                    }
                });
            }
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean m11002() {
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11007(Context context) {
        final C1301Ad ad;
        if (m14536() != null && m14536().mo9519() && this.f10430 != null && (getView() instanceof ViewGroup)) {
            final UmaAlert r3 = m14536().m9820();
            boolean z = false;
            if (r3 != null) {
                if (this.f10412 != null) {
                    this.f10412.dispose();
                }
                if (r3.suppressOnAppLaunch()) {
                    z = true;
                } else {
                    if (r3.bannerAlert()) {
                        if (this.f10425 == null) {
                            this.f10425 = new C1301Ad(context, true);
                        } else {
                            this.f10425.m3572(r3);
                        }
                        if (r3.suppressForBackgroundAction()) {
                            this.f10425.m3568(false);
                        } else if (!this.f10425.isAttachedToWindow()) {
                            this.f10425.m3570(r3, this.f10430, (ViewGroup) getView());
                        }
                    }
                    if (r3.modalAlert()) {
                        if (this.f10424 == null) {
                            this.f10424 = zW.f12754.m13575(context, r3);
                        } else {
                            this.f10424.m13571(r3);
                        }
                        if (!r3.suppressForBackgroundAction()) {
                            if (!this.f10424.isVisible()) {
                                this.f10424.m13569(m14534());
                            }
                        } else if (this.f10424.getDialog() != null && this.f10424.isVisible()) {
                            this.f10424.dismiss();
                        }
                    }
                    if (!r3.modalAlert() && !r3.bannerAlert()) {
                        C1276.m16820().mo5725("uma detected but could not be rendered, missing bannerAlert / modalAlert flag");
                    } else if (r3.suppressForBackgroundAction()) {
                        if (this.f10425 != null) {
                            ad = this.f10425;
                        } else {
                            ad = this.f10424.m13573();
                        }
                        if (ad == null) {
                            C1276.m16820().mo5725("umaView is null can't perform background action");
                        } else {
                            ad.m3565().observeOn(AndroidSchedulers.mainThread()).take(1).subscribe(new Observer<Boolean>() { // from class: o.tQ.10
                                @Override // io.reactivex.Observer
                                public void onSubscribe(Disposable disposable) {
                                    tQ.this.f10412 = disposable;
                                    ad.m3567(tQ.this.m14534(), r3.backgroundAction());
                                }

                                /* renamed from: ˏ  reason: contains not printable characters */
                                public void onNext(Boolean bool) {
                                    boolean z2 = (bool.booleanValue() && r3.showOnBackgroundActionSuccess()) || (!bool.booleanValue() && !r3.showOnBackgroundActionSuccess());
                                    if (r3.bannerAlert()) {
                                        if (!z2 || tQ.this.f10425 == null) {
                                            tQ.this.f10425 = null;
                                        } else {
                                            tQ.this.f10425.m3570(r3, tQ.this.f10430, (ViewGroup) tQ.this.getView());
                                        }
                                    }
                                    if (!r3.modalAlert()) {
                                        return;
                                    }
                                    if (!z2 || tQ.this.f10424 == null) {
                                        tQ.this.f10424 = null;
                                    } else {
                                        tQ.this.f10424.m13569(tQ.this.m14534());
                                    }
                                }

                                @Override // io.reactivex.Observer
                                public void onError(Throwable th) {
                                    if (r3.bannerAlert() && tQ.this.f10425 != null) {
                                        tQ.this.f10425.m3570(r3, tQ.this.f10430, (ViewGroup) tQ.this.getView());
                                    }
                                    if (r3.modalAlert() && tQ.this.f10424 != null) {
                                        tQ.this.f10424.m13569(tQ.this.m14534());
                                    }
                                }

                                @Override // io.reactivex.Observer
                                public void onComplete() {
                                }
                            });
                        }
                    }
                }
            }
            if ((r3 == null || !r3.bannerAlert() || z) && this.f10425 != null) {
                this.f10425.m3568(true);
                this.f10425 = null;
            }
            if ((r3 == null || !r3.modalAlert() || z) && this.f10424 != null) {
                if (this.f10424.isVisible()) {
                    this.f10424.dismiss();
                }
                this.f10424 = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m11012() {
        if (this.f10425 != null) {
            this.f10425.m3568(true);
            this.f10425 = null;
        }
        if (this.f10424 != null) {
            if (this.f10424.isVisible()) {
                this.f10424.dismiss();
            }
            this.f10424 = null;
        }
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m11010() {
        UmaAlert r2;
        if (m14536() != null && m14536().mo9519() && (r2 = m14536().m9820()) != null) {
            if (r2.isStale() || r2.isConsumed()) {
                C1283.m16846("LoLoMoFrag", "User message is stale or consumed, refreshing");
                m14534().getServiceManager().m9821();
            }
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void m11019() {
        C1283.m16846("LoLoMoFrag", "Showing error view");
        BQ.m3909(this.f10430, true);
        NetflixActivity r2 = m14534();
        if (r2 != null) {
            r2.removeNoNetworkOverlay();
            m14534().runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.tQ.8
                @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                public void run(C2059ph phVar) {
                    if (phVar.m9824() && phVar.m9832() != null && vO.m12029(phVar.m9832()).mo11972() > 0) {
                        tQ.this.f10411.m14661();
                    }
                }
            });
        }
        this.f10411.mo14660(true);
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m11009() {
        C1283.m16846("LoLoMoFrag", "Showing loading view");
        BQ.m3909(this.f10430, true);
        this.f10411.mo14570(true);
        if (m11002() && this.f10417 != null) {
            this.f10417.setEnabled(false);
        }
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        C1283.m16846("LoLoMoFrag", "onManagerReady");
        if (status.mo301()) {
            C1283.m16865("LoLoMoFrag", "Manager status code not okay");
            return;
        }
        m11011();
        m11010();
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private void m11011() {
        if (!this.f10416) {
            if (getActivity() == null) {
                C1283.m16854("LoLoMoFrag", "Activity is null - can't continue init");
            } else if (m14536() == null) {
                C1283.m16854("LoLoMoFrag", "Manager not available - can't continue init");
            } else if (this.f10430 == null) {
                C1283.m16854("LoLoMoFrag", "Views are not initialized - can't continue init");
            } else {
                this.f10409.m2050(m14534(), AbstractC0367.f13235);
                this.f10416 = true;
            }
        }
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
    }

    @Override // o.AbstractC0517, o.AbstractC0459
    public void setLoadingStatusCallback(AbstractC0459.AbstractC0460 r2) {
        this.f10409.setLoadingStatusCallback(r2);
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        if (this.f10409 == null) {
            C1283.m16846("NflxLoading", "No mAdapter yet - not loading data");
            return false;
        }
        boolean isLoadingData = this.f10409.isLoadingData();
        C1283.m16846("NflxLoading", "Class: " + getClass().getSimpleName() + ", loading: " + isLoadingData);
        return isLoadingData;
    }

    @Override // com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter.Cif
    public void W_() {
        NetflixActivity r1 = m14534();
        if (!C1317As.m3750(r1) && !isHidden() && r1.getNetflixActionBar() != null) {
            r1.getNetflixActionBar().m366();
        }
    }

    @Override // com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter.Cif
    /* renamed from: ˊ */
    public void mo2065(LoLoMoSummary loLoMoSummary) {
        C2059ph r6;
        m10853(loLoMoSummary);
        Map<String, String> r3 = m10852(new HashMap());
        Logger.INSTANCE.m127(new C0990(C1300Ac.m3522(r3)));
        NetflixActivity r4 = m14534();
        if (!(loLoMoSummary == null || r4 == null)) {
            r4.logMetadataRenderedEvent(loLoMoSummary.isFromCache());
        }
        if (m11008(loLoMoSummary) || !m10998()) {
            if (!(this.f10409 == null || r4 == null || r4.isFinishing())) {
                this.f10409.m2049(r4);
            }
            PerformanceProfiler.INSTANCE.m669(Events.LOLOMO_METADATA_FETCHED_EVENT, r3);
            if (loLoMoSummary != null) {
                this.f10410 = Logger.INSTANCE.m142(new C1224(C1300Ac.m3527(loLoMoSummary.getId()), AppView.browseTitles));
                if (C0728.m15070() && (r6 = m14536()) != null) {
                    m11005(r6, loLoMoSummary.isFromCache(), this.f10414);
                    return;
                }
                return;
            }
            return;
        }
        m11019();
        PerformanceProfiler.INSTANCE.m669(Events.LOLOMO_MISMATCH_EVENT, r3);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11005(C2059ph phVar, boolean z, boolean z2) {
        C1283.m16851("LoLoMoFrag", "Insomnia: handleInsomniaLolomoPrefetched isFromCache = %b, isFirstLaunch=%b", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z2 && z) {
            C1283.m16854("LoLoMoFrag", ": lolomo data is from cache - refresh CW row");
            phVar.m9764().mo9488(true);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m11008(LoLoMoSummary loLoMoSummary) {
        String str = null;
        C2059ph r5 = m14536();
        if (r5 != null) {
            str = r5.m9835();
        }
        String str2 = null;
        if (loLoMoSummary != null) {
            str2 = loLoMoSummary.getLolomoProfileGuid();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && TextUtils.equals(str, str2)) {
            return true;
        }
        C1283.m16850("LoLoMoFrag", String.format("Profile guid mismatch: client profile guid %s, lolomo profile guid %s", str, str2));
        return false;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean m10998() {
        AbstractC2089qj r3;
        C2059ph r2 = m14536();
        if (r2 == null || (r3 = r2.m9826()) == null || r3.isKidsProfile()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void m11013() {
        if (this.f10418 != null && this.f10430 != null) {
            C1283.m16848("LoLoMoFrag", "Restoring layout manager state: %s", this.f10418);
            this.f10430.getLayoutManager().onRestoreInstanceState(this.f10418);
            this.f10418 = null;
        }
    }

    @Override // o.AbstractC2124rm
    /* renamed from: ˊ */
    public Parcelable mo10450() {
        if (this.f10430 == null || this.f10430.getLayoutManager() == null) {
            return null;
        }
        return this.f10430.getLayoutManager().onSaveInstanceState();
    }

    @Override // o.AbstractC2124rm
    /* renamed from: ˋ */
    public void mo10452(Parcelable parcelable) {
        this.f10418 = parcelable;
    }

    @Override // o.AbstractC0517
    /* renamed from: ˊ */
    public void mo2213(View view) {
        if (this.f10430 != null) {
            this.f10430.setPadding(this.f10430.getPaddingLeft(), m11016() ? 0 : this.f13651 + this.f13649, this.f10430.getPaddingRight(), this.f13650 + this.f10430.getResources().getDimensionPixelSize(R.dimen.xlarge_padding));
        }
        if (this.f10411 != null) {
            this.f10411.mo14659(0, this.f13651 + this.f13649, 0, this.f13650);
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public boolean m11016() {
        return this.f10420 && tP.Cif.m10990();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo11018(NetflixActionBar netflixActionBar) {
        if (this.f10430 != null) {
            C2221uu.m11747(netflixActionBar, this.f10430, m11016() || (!this.f10421 && m10999() && tP.Cif.m10990()));
        }
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private boolean m10999() {
        return this.f10413 == null || this.f10413.getTitle() == null;
    }

    @Override // o.AbstractC0517
    public boolean af_() {
        NetflixActivity r1 = m14534();
        if (isHidden() || r1 == null) {
            return false;
        }
        String title = this.f10413 != null ? this.f10413.getTitle() : null;
        boolean r3 = C1349Bv.m4113(title);
        if (r3) {
            r1.setTitle((int) R.string.label_home);
        } else {
            r1.setTitle(title);
        }
        NetflixActionBar netflixActionBar = r1.getNetflixActionBar();
        if (netflixActionBar == null) {
            return false;
        }
        NetflixActionBar.iF.AbstractC0010 actionBarStateBuilder = r1.getActionBarStateBuilder();
        actionBarStateBuilder.mo387(this.f10423);
        actionBarStateBuilder.mo394((CharSequence) title);
        if (r3) {
            actionBarStateBuilder.mo396(false);
            actionBarStateBuilder.mo399(true);
            if (NetflixBottomNavBar.m416() || tP.Cif.m10990()) {
                actionBarStateBuilder.mo401(NetflixActionBar.LogoType.CENTERED);
            } else {
                actionBarStateBuilder.mo401(NetflixActionBar.LogoType.START_ALIGNED);
            }
        } else {
            actionBarStateBuilder.mo396(true);
            actionBarStateBuilder.mo399(false);
        }
        netflixActionBar.m355(actionBarStateBuilder.mo392());
        mo11018(netflixActionBar);
        return true;
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment, java.lang.Object
    public String toString() {
        return super.toString() + " - genreId: " + (this.f10413 == null ? this.f10422 : this.f10413.getId());
    }
}
