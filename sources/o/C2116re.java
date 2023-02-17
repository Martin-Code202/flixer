package o;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.SpinnerAdapter;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.servicemgr.AddToListData;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import com.netflix.mediaclient.ui.details.VideoDetailsViewGroup;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.List;
import o.AbstractC0496;
import o.AbstractC0801;
import o.C0567;
import o.C1348Bu;
import o.C2130rs;
import o.C2134rw;
import o.vT;
/* renamed from: o.re  reason: case insensitive filesystem */
public class C2116re extends AbstractC0496 implements C0567.Cif, AbstractC2131rt, DetailsActivity.If, vT.AbstractC0242 {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected boolean f9822 = false;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected C0616 f9823;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected boolean f9824 = true;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    protected qY f9825;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected int f9826 = -1;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    protected final AbstractC0801.Cif f9827 = new AbstractC0801.Cif() { // from class: o.re.2
        @Override // o.AbstractC0801.Cif
        /* renamed from: ˏ */
        public View mo4156(View view) {
            if (!C2116re.this.f9847 || !AD.m3292()) {
                return new C2113rb(view.getContext(), R.layout.episode_row_view);
            }
            return new qZ(view.getContext(), R.layout.episode_row_view_bifs);
        }
    };

    /* renamed from: ʾ  reason: contains not printable characters */
    protected C2133rv f9828;

    /* renamed from: ʿ  reason: contains not printable characters */
    protected pT f9829;

    /* renamed from: ˈ  reason: contains not printable characters */
    private int f9830 = -1;

    /* renamed from: ˉ  reason: contains not printable characters */
    private final C0567.Cif f9831 = new C0567.Cif() { // from class: o.re.10
        @Override // o.C0567.Cif
        public void N_() {
            if (C2116re.this.f9825 != null) {
                C2116re.this.f9825.m10077();
                return;
            }
            FragmentActivity activity = C2116re.this.getActivity();
            if (activity instanceof C0567.Cif) {
                ((C0567.Cif) activity).N_();
            } else {
                C1283.m16865("EpisodesFrag", "onRetryRequested but activity doesn't implement Errors callback: " + C2116re.this.getActivity());
            }
        }
    };

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private pS f9832;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private AddToListData.Cif f9833;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected String f9834;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private boolean f9835 = false;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private vA f9836;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected long f9837;

    /* renamed from: ˏ  reason: contains not printable characters */
    public int f9838 = -1;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected C2119rh f9839;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected C2112ra f9840;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected String f9841;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    protected VideoDetailsViewGroup f9842;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected pR f9843;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected RecyclerView f9844;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected ViewGroup f9845;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected long f9846;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected boolean f9847;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C2116re m10365(String str, String str2, boolean z) {
        C2116re reVar = new C2116re();
        reVar.setStyle(1, R.style.res_2131951877_netflixdialog_notitle);
        return m10360(reVar, str, str2, z, false);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C2116re m10364(String str, String str2, boolean z) {
        C2116re reVar = new C2116re();
        reVar.setStyle(1, R.style.res_2131951876_netflixdialog_episodes);
        return m10360(reVar, str, str2, z, true);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static C2116re m10360(C2116re reVar, String str, String str2, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("extra_show_id", str);
        bundle.putString("extra_episode_id", str2);
        bundle.putBoolean("extra_show_episodes_selector", z2);
        bundle.putBoolean("extra_show_details", z);
        reVar.setArguments(bundle);
        return reVar;
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f9841 = getArguments().getString("extra_show_id");
        this.f9834 = getArguments().getString("extra_episode_id");
        this.f9847 = getArguments().getBoolean("extra_show_details");
        if (bundle != null) {
            this.f9826 = bundle.getInt("extra_season_index");
            this.f9830 = bundle.getInt("extra_episode_index");
            C1283.m16846("EpisodesFrag", "Restored season index as: " + this.f9826 + ", episode: " + this.f9830);
        }
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1283.m16846("EpisodesFrag", "onCreateView called");
        View inflate = layoutInflater.inflate(m10370(), (ViewGroup) null, false);
        this.f9823 = new C0616(inflate, this.f9831);
        mo10392(inflate);
        m10405();
        mo10384();
        mo10388();
        this.f9842.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.re.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewUtils.m3009(C2116re.this.f9842, this);
                C2116re.this.m10400();
            }
        });
        return inflate;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public int m10370() {
        return R.layout.recyclerview_frag_with_le;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo10392(View view) {
        this.f9844 = (RecyclerView) view.findViewById(16908298);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m10405() {
        if (this.f9844 != null) {
            this.f9844.setFocusable(false);
            this.f9844.setVerticalScrollBarEnabled(false);
            C1283.m16846("EpisodesFrag", "Setting recyclerView to invisible");
            this.f9844.setVisibility(4);
            mo10372();
            mo10368();
            mo10403();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void mo10403() {
    }

    @Override // o.vT.AbstractC0242
    /* renamed from: ˏ  reason: contains not printable characters */
    public C0697 mo10390(AbstractC2089qj qjVar) {
        View findViewById = this.f9844.findViewById(R.id.episode_row_download_button);
        if (findViewById == null) {
            return null;
        }
        return vT.m12047(findViewById, getActivity(), qjVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public void mo10368() {
        this.f9839 = new C2119rh((NetflixActivity) getActivity(), this, this.f9827);
        if (AD.m3299() && AD.m3307(getActivity())) {
            this.f9839.m15327(ViewUtils.m3033(m14476()));
        }
        this.f9844.setAdapter(this.f9839);
        m10378((ViewGroup) this.f9844);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        m10354();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10378(ViewGroup viewGroup) {
        m10354();
        AbstractC1853hl offlineAgentOrNull = NetflixActivity.getOfflineAgentOrNull(m14476());
        if (offlineAgentOrNull != null) {
            this.f9836 = new vA(viewGroup, false);
            offlineAgentOrNull.mo7124(this.f9836);
        }
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private void m10354() {
        AbstractC1853hl offlineAgentOrNull = NetflixActivity.getOfflineAgentOrNull(m14476());
        if (offlineAgentOrNull != null && this.f9836 != null) {
            offlineAgentOrNull.mo7135(this.f9836);
            this.f9836 = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽ  reason: contains not printable characters */
    public void mo10372() {
        this.f9844.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void mo10384() {
        mo10397();
        ((AbstractC0801) this.f9844.getAdapter()).m15327(this.f9842);
        m10391(this.f9847 ? 0 : 8);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public C2112ra m10400() {
        NetflixActivity r5 = m14476();
        if (r5 == null || this.f9844 == null || !(this.f9844.getContext() instanceof NetflixActivity) || r5.getNetflixActionBar() == null) {
            return null;
        }
        if (AD.m3292() || AD.m3306(getActivity())) {
            this.f9840 = C2112ra.m10316(this.f9828, this.f9844, new View[]{this.f9842.m1676()}, null, null);
            this.f9844.setOnScrollListener(this.f9840);
        }
        mo10383();
        return this.f9840;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m10396() {
        ViewGroup r1;
        if (this.f9842 != null && this.f9845 != null && (r1 = this.f9842.m1682()) != null) {
            r1.addView(this.f9845);
        }
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private void m10350() {
        if (this.f9844 != null) {
            ((AbstractC0801) this.f9844.getAdapter()).m15327(this.f9845);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺ  reason: contains not printable characters */
    public void mo10397() {
        this.f9842 = new VideoDetailsViewGroup(getActivity());
        this.f9842.m1695();
        this.f9842.setDetailsHelper(this.f9825);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void mo10388() {
        this.f9845 = mo10369();
        if (getArguments().getBoolean("extra_show_episodes_selector") || (AD.m3299() && AD.m3307(getActivity()))) {
            m10350();
        } else {
            m10396();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    public ViewGroup mo10369() {
        if (getActivity() == null) {
            return null;
        }
        this.f9828 = new C2133rv(getActivity());
        mo10406();
        m10404();
        this.f9845 = new FrameLayout(getActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.double_padding);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.moderate_padding);
        layoutParams.setMargins(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.f9845.setLayoutParams(layoutParams);
        this.f9845.addView(this.f9828, new FrameLayout.LayoutParams(-2, -2, 8388627));
        return this.f9845;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public void m10404() {
        this.f9828.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: o.re.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                C2116re.this.mo10386(i, j == 1);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
                C1283.m16846("EpisodesFrag", "Season spinner - Nothing selected");
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo10386(int i, boolean z) {
        m10358();
        this.f9832 = (pS) this.f9828.getItemAtPosition(i);
        this.f9826 = i;
        pS pSVar = this.f9832;
        this.f9823.mo14570(true);
        this.f9839.m10429(this.f9832);
        this.f9838 = -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public void mo10406() {
        C2130rs rsVar = new C2130rs(m14476(), new C2130rs.If() { // from class: o.re.1
            @Override // o.C2130rs.If
            /* renamed from: ॱ  reason: contains not printable characters */
            public View mo10407(ViewGroup viewGroup) {
                return View.inflate(viewGroup.getContext(), R.layout.season_spinner_row, null);
            }
        });
        rsVar.m10475(R.drawable.selectable_item_background_opaque_grey);
        this.f9828.setAdapter((SpinnerAdapter) rsVar);
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        C1283.m16846("EpisodesFrag", "onActivityCreated");
        super.onActivityCreated(bundle);
        m10356();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        C1283.m16846("EpisodesFrag", "onResume");
        super.onResume();
        if (this.f9839 != null) {
            this.f9839.notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f9828 != null) {
            int selectedItemPosition = this.f9828.getSelectedItemPosition();
            int r2 = m10355();
            bundle.putInt("extra_season_index", selectedItemPosition);
            bundle.putInt("extra_episode_index", r2);
        }
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private int m10355() {
        if (this.f9839 == null) {
            return -1;
        }
        return this.f9839.m15331();
    }

    @Override // o.AbstractC0496, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        super.onManagerReady(phVar, status);
        m10356();
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private void m10356() {
        if (getActivity() == null) {
            C1283.m16846("EpisodesFrag", "Can't complete init yet - activity is null");
        } else if (m14474() == null) {
            C1283.m16846("EpisodesFrag", "Can't complete init yet - manager is null");
        } else if (this.f9842 == null) {
            C1283.m16846("EpisodesFrag", "Can't complete init yet - details view is null");
        } else if (m10385() == null) {
            C1283.m16846("EpisodesFrag", "Can't complete init yet - showId is null");
        } else if (this.f9822) {
            C1283.m16846("EpisodesFrag", "no need to init a second time, isLoading is true");
        } else {
            C1283.m16846("EpisodesFrag", "All clear - completing init process...");
            m10357();
            m10402();
            if (this.f9824) {
                this.f9822 = true;
            }
        }
    }

    @Override // o.AbstractC0496, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C2059ph r2 = m14474();
        if (!(r2 == null || this.f9833 == null)) {
            r2.m9781(m10385(), this.f9833);
        }
        m10358();
    }

    @Override // o.C0567.Cif
    public void N_() {
        C1283.m16846("EpisodesFrag", "Retry requested");
        if (m14474() != null && ConnectivityUtils.m2954(getActivity())) {
            m10357();
            m10402();
        }
    }

    @Override // com.netflix.mediaclient.ui.details.DetailsActivity.If
    public void P_() {
        C1283.m16846("EpisodesFrag", "reload()");
        m10402();
    }

    @Override // o.AbstractC0496, o.AbstractC0459
    public boolean isLoadingData() {
        return this.f9824 || this.f9839.isLoadingData();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10391(int i) {
        this.f9842.setVisibility(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    public RecyclerView m10401() {
        return this.f9844;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10379(Status status) {
        C1283.m16846("EpisodesFrag", "Showing error view");
        C1276.m16820().mo5727("Display Page Retry Error Message");
        this.f9824 = false;
        m10366((pR) null);
        m10393(status);
        this.f9823.mo14660(false);
        this.f9844.setVisibility(4);
        if (this.f9845 != null) {
            this.f9845.setVisibility(8);
        }
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    private void m10357() {
        C1283.m16846("EpisodesFrag", "Showing loading view");
        this.f9823.mo14570(false);
        this.f9844.setVisibility(4);
        if (this.f9845 != null) {
            this.f9845.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˎ  reason: contains not printable characters */
    public void m10402() {
        C2059ph r6 = m14474();
        if (r6 == null) {
            C1283.m16865("EpisodesFrag", "Manager is null - can't get show details");
        } else if (m10385() == null) {
            C1283.m16865("EpisodesFrag", "show ID is null - can't get show details");
        } else {
            this.f9824 = true;
            this.f9846 = System.nanoTime();
            r6.m9764().mo9504(this.f9841, this.f9834, true, (oU) new Cif(this.f9846));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m10362() {
        C2059ph r9 = m14474();
        if (r9 == null) {
            C1283.m16865("EpisodesFrag", "Manager is null - can't get season details");
        } else if (m10385() == null) {
            C1283.m16865("EpisodesFrag", "show ID is null - can't get season details");
        } else if (this.f9828 == null || this.f9828.getAdapter() == null) {
            C1283.m16862("EpisodesFrag", "Spinner is null - can't get season details");
        } else {
            this.f9837 = System.nanoTime();
            int i = 0;
            if (this.f9832 != null) {
                i = this.f9832.getNumOfEpisodes();
            }
            r9.m9764().mo9511(this.f9841, CmpTaskMode.FROM_NETWORK, new iF(this.f9828.getAdapter().getCount(), i, this.f9837));
        }
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public void m10371() {
        if (this.f9830 != -1) {
            this.f9838 = this.f9830;
            this.f9830 = -1;
        }
        if (!(this.f9838 != -1 || this.f9839 == null || this.f9843 == null)) {
            String currentEpisodeId = this.f9843.getCurrentEpisodeId();
            for (int i = 0; i < this.f9839.getItemCount(); i++) {
                pJ r4 = this.f9839.m15322(i);
                if (r4 != null && C1349Bv.m4126(r4.getId(), currentEpisodeId)) {
                    this.f9838 = i;
                }
            }
        }
        if (this.f9838 == -1) {
            this.f9838 = 0;
        }
        this.f9823.mo14663(false);
        m10393(AbstractC0367.f13235);
        m10361(this.f9838 + this.f9839.m15326());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m10389(List<pI> list) {
        if (!C1317As.m3750(m14476())) {
            this.f9829 = null;
            if (list != null) {
                for (pI pIVar : list) {
                    if (pIVar.getPlayable().isAvailableOffline()) {
                        this.f9829 = pIVar;
                        if (!m14472()) {
                            S_();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0496
    public void S_() {
        NetflixActivity r3 = m14476();
        pT pTVar = this.f9829;
        if (r3 != null && pTVar != null) {
            r3.getTutorialHelper().m12056(this, pTVar, this.f9844, m14474());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10393(Status status) {
        mo10398(status);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0496
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo10398(Status status) {
        if (this.f9825 != null) {
            this.f9825.m10071(status);
        } else {
            super.mo10398(status);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m10361(int i) {
        if (this.f9844 != null && this.f9839 != null) {
            this.f9839.m15332(i);
        }
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public C2136ry m10376() {
        if (this.f9825 != null) {
            return this.f9825.m10076();
        }
        if (getActivity() instanceof DetailsActivity) {
            return ((DetailsActivity) getActivity()).m1653();
        }
        return C2136ry.f9958;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo10387(pR pRVar) {
        if (pRVar == null) {
            C1276.m16820().mo5725("details is null!");
            return;
        }
        NetflixActivity r2 = m14476();
        if (!C1317As.m3750(r2)) {
            this.f9843 = pRVar;
            this.f9839.m10427(pRVar);
            this.f9842.mo1685(pRVar, new C2134rw.C0186(r2, pRVar));
            this.f9842.setCopyright(pRVar);
            if (C1349Bv.m4113(this.f9834)) {
                this.f9834 = this.f9843.getCurrentEpisodeId();
            }
            if (this.f9842 == null) {
                return;
            }
            if ((getActivity() instanceof DetailsActivity) || this.f9825 != null) {
                C2136ry r3 = m10376();
                r3.m10497(m10385());
                this.f9833 = qW.m9984(this.f9842, r2, m14474(), r3);
                this.f9842.setupDownloadButton(this.f9843);
                m10366(pRVar);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m10366(pR pRVar) {
        NetflixActivity r2 = m14476();
        if (!C1317As.m3750(r2)) {
            C1283.m16854("EpisodesFrag", "EpisodeFrag: updateShowDetails in primary frag");
            if (r2 instanceof ActivityC2132ru) {
                ((ActivityC2132ru) r2).m10482(pRVar);
            } else if (this.f9825 != null && pRVar != null) {
                this.f9825.m10058(pRVar);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10395(qY qYVar) {
        this.f9825 = qYVar;
        if (this.f9842 != null) {
            this.f9842.setDetailsHelper(this.f9825);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10394(List<pJ> list) {
        qX.m10003(m14474(), list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10380(pR pRVar) {
        C2059ph r5 = m14474();
        if (r5 != null && r5.mo9519()) {
            C1283.m16848("EpisodesFrag", "Volatile data update rating: %d, inQ: %b", Integer.valueOf(pRVar.getUserThumbRating()), Boolean.valueOf(pRVar.isInQueue()));
            this.f9842.m1688(pRVar);
            r5.m9818(pRVar.getId(), pRVar.isInQueue());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo10399(List<pS> list) {
        this.f9828.m10484(list);
        this.f9845.setVisibility(0);
        if (list != null && list.size() > 1) {
            this.f9845.setBackgroundResource(R.drawable.season_spinner_background);
        }
        m10374();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʾ  reason: contains not printable characters */
    public void m10374() {
        C1348Bu.If.m4098(new Runnable() { // from class: o.re.5
            @Override // java.lang.Runnable
            public void run() {
                C2116re.this.mo10375();
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʿ  reason: contains not printable characters */
    public void mo10375() {
        m10373();
        if (this.f9826 < 0) {
            C1283.m16846("EpisodesFrag", "No valid season index found");
        } else {
            this.f9828.setNonTouchSelection(this.f9826);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽॱ  reason: contains not printable characters */
    public void m10373() {
        if (this.f9826 == -1 && this.f9843 != null) {
            this.f9826 = this.f9828.m10486(this.f9843.getCurrentSeasonNumber());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊˊ  reason: contains not printable characters */
    public boolean m10382() {
        return this.f9844.getVisibility() == 0;
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public String m10385() {
        return this.f9841;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.re$if  reason: invalid class name */
    public class Cif extends oP {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final long f9858;

        public Cif(long j) {
            super("EpisodesFrag");
            this.f9858 = j;
        }

        @Override // o.oP, o.oU
        public void onShowDetailsAndSeasonsFetched(pR pRVar, List<pS> list, Status status) {
            super.onShowDetailsAndSeasonsFetched(pRVar, list, status);
            if (this.f9858 != C2116re.this.f9846) {
                C1283.m16846("EpisodesFrag", "Stale response - ignoring");
                return;
            }
            C2116re.this.f9824 = false;
            if (status.mo301()) {
                C1283.m16865("EpisodesFrag", "Error status code fetching data - showing errors view");
                C1276.m16820().mo5725("EpisodesFrag - error in the response");
                C2116re.this.m10379(status);
            } else if (pRVar == null) {
                C1283.m16865("EpisodesFrag", "No details in response!");
                C1276.m16820().mo5725("EpisodesFrag - No details in response!");
                C2116re.this.m10379(AbstractC0367.f13245);
            } else if (!pRVar.isPreRelease() && !C2116re.this.m10353(list)) {
                C1283.m16865("EpisodesFrag", "No seasons in response!");
                C1276.m16820().mo5725("EpisodesFrag - No seasons in response!");
                C2116re.this.m10379(AbstractC0367.f13245);
            } else if (!C1317As.m3750(C2116re.this.getActivity())) {
                C2116re.this.mo10387(pRVar);
                qX.m10008(status);
                if (C2116re.this.m10353(list)) {
                    C2116re.this.mo10399(list);
                }
                if (!C2116re.this.m10382()) {
                    C1283.m16846("EpisodesFrag", "Showing recycler view");
                    BQ.m3914(C2116re.this.f9844, true);
                    C2116re.this.f9823.mo14663(false);
                }
                if (pRVar.shouldRefreshVolatileData() && ConnectivityUtils.m2954(C2116re.this.getActivity())) {
                    C2059ph r12 = C2116re.this.m14474();
                    if (r12 == null || !r12.mo9519()) {
                        C1283.m16865("EpisodesFrag", "Manager is null/notReady - can't reload data");
                        return;
                    }
                    String id = pRVar.getId();
                    C1283.m16848("EpisodesFrag", "Fetching volatile data for video ID: %s", id);
                    int i = 0;
                    CB currentSeasonDetail = pRVar.getCurrentSeasonDetail();
                    if (currentSeasonDetail != null) {
                        i = currentSeasonDetail.getNumOfEpisodes();
                    }
                    r12.m9764().mo9487(new C0870(id, pRVar.getType() == VideoType.MOVIE), new C0182(id, pRVar.getUserThumbRating(), pRVar.getMatchPercentage(), pRVar.isInQueue(), pRVar.getSeasonCount(), i));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.re$iF */
    public class iF extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final int f9854;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final long f9855;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final int f9857;

        public iF(int i, int i2, long j) {
            super("EpisodesFrag");
            this.f9857 = i;
            this.f9854 = i2;
            this.f9855 = j;
        }

        @Override // o.oP, o.oU
        public void onSeasonsFetched(List<pS> list, Status status) {
            super.onSeasonsFetched(list, status);
            if (C1317As.m3750(C2116re.this.m14476())) {
                C1283.m16846("EpisodesFrag", "Activity state is invalid");
            } else if (this.f9855 != C2116re.this.f9837) {
                C1283.m16846("EpisodesFrag", "Stale seasons response - ignoring");
            } else if (status.mo301()) {
                C1283.m16865("EpisodesFrag", "Seasons fetch response has invalid status code");
            } else if (C2116re.this.m10353(list)) {
                if (!(C2116re.this.f9828 == null || C2116re.this.f9828.getAdapter() == null || C2116re.this.f9828.getAdapter().getCount() == this.f9857)) {
                    C2116re.this.mo10399(list);
                }
                if (C2116re.this.f9826 < 0) {
                    C1276.m16820().mo5725("SPY-12784: negative currSeasonIndex=" + C2116re.this.f9826 + " with season count=" + list.size() + " for show " + C2116re.this.f9841);
                    if (list.size() > 0) {
                        C2116re.this.mo10386(0, false);
                    }
                } else if (C2116re.this.f9826 >= list.size()) {
                    C2116re.this.mo10386(list.size() - 1, false);
                    C1276.m16820().mo5727("SPY-12784: currSeasonIndex=" + C2116re.this.f9826 + " with season count=" + list.size() + " for show " + C2116re.this.f9841);
                } else {
                    pS pSVar = list.get(C2116re.this.f9826);
                    if (pSVar != null && pSVar.getNumOfEpisodes() != this.f9854) {
                        C2116re.this.f9839.mo10424();
                    }
                }
            }
        }
    }

    /* renamed from: o.re$ˊ  reason: contains not printable characters */
    class C0182 extends oP {

        /* renamed from: ʼ  reason: contains not printable characters */
        private final boolean f9860;

        /* renamed from: ʽ  reason: contains not printable characters */
        private final int f9861;

        /* renamed from: ˊ  reason: contains not printable characters */
        private final int f9862;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final String f9863;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final int f9865;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final int f9866;

        private C0182(String str, int i, int i2, boolean z, int i3, int i4) {
            super("EpisodesFrag");
            this.f9863 = str;
            this.f9865 = i;
            this.f9862 = i2;
            this.f9860 = z;
            this.f9861 = i3;
            this.f9866 = i4;
        }

        @Override // o.oP, o.oU
        public void onShowDetailsFetched(pR pRVar, Status status) {
            int i;
            super.onShowDetailsFetched(pRVar, status);
            if (C1317As.m3750(C2116re.this.m14476())) {
                C1283.m16846("EpisodesFrag", "Activity state is invalid");
            } else if (status.mo301()) {
                C1283.m16865("EpisodesFrag", "Volatile data has invalid status code");
            } else if (pRVar == null) {
                C1283.m16846("EpisodesFrag", "Volatile data no details in response");
            } else if (!TextUtils.equals(pRVar.getId(), this.f9863)) {
                C1283.m16865("EpisodesFrag", "Ignoring stale volatile data callback");
            } else {
                if (!(this.f9862 == pRVar.getMatchPercentage() && this.f9865 == pRVar.getUserThumbRating() && this.f9860 == pRVar.isInQueue())) {
                    C2116re.this.m10380(pRVar);
                }
                if (pRVar.getSeasonCount() > 0 && pRVar.getSeasonCount() != this.f9861) {
                    C1283.m16854("EpisodesFrag", "Season counts changed, need to update spinner");
                    C2116re.this.m10362();
                }
                if (C2116re.this.f9832 != null && C2116re.this.f9832.getNumOfEpisodes() != this.f9866) {
                    int numOfEpisodes = C2116re.this.f9832.getNumOfEpisodes() - 1;
                    if (pRVar.isNSRE()) {
                        i = 0;
                    } else {
                        i = numOfEpisodes < 10 ? 0 : numOfEpisodes - 10;
                    }
                    C2116re.this.m14474().m9764().mo9510(C2116re.this.f9832.getId(), CmpTaskMode.FROM_NETWORK, VideoType.SEASON, i, numOfEpisodes, (oU) null);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m10353(List<pS> list) {
        return list != null && list.size() > 0;
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        AbstractC0496.iF ab_;
        super.onCancel(dialogInterface);
        FragmentActivity activity = getActivity();
        if ((activity instanceof AbstractC0496.Cif) && (ab_ = ((AbstractC0496.Cif) activity).ab_()) != null) {
            ab_.mo2537(this);
        }
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    private void m10358() {
        if (this.f9835) {
            C1283.m16846("EpisodesFrag", "Show is 'Day After Broadcast' (DAB), invalidating episode cache");
            C2059ph r3 = m14474();
            if (r3 == null || !r3.mo9519()) {
                C1283.m16854("EpisodesFrag", "Manager is not ready");
            } else if (this.f9832 == null) {
                C1283.m16846("EpisodesFrag", "No season details yet");
            } else {
                String id = this.f9832.getId();
                if (C1349Bv.m4113(id)) {
                    AR.m3409(r3.m9825(), m10385(), this.f9832);
                } else if (ConnectivityUtils.m2954(r3.m9814())) {
                    r3.m9764().mo9495(id, VideoType.SEASON);
                }
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m10381(boolean z) {
        this.f9835 = z;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0496
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo10377(View view) {
        view.setPadding(view.getPaddingLeft(), this.f13610, view.getPaddingRight(), this.f13611);
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    public boolean mo10383() {
        NetflixActionBar netflixActionBar;
        NetflixActivity r2 = m14476();
        if (r2 == null || (netflixActionBar = r2.getNetflixActionBar()) == null) {
            return false;
        }
        NetflixActionBar.iF.AbstractC0010 r4 = r2.getActionBarStateBuilder().mo396(false).mo403(true);
        if (this.f9840 != null) {
            r4.mo387(this.f9840.mo10342());
        }
        netflixActionBar.m355(r4.mo392());
        return true;
    }

    @Override // android.support.v4.app.Fragment, java.lang.Object
    public String toString() {
        return super.toString() + " : " + m10385();
    }
}
