package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import o.AbstractC0801;
import o.C2119rh;
import o.C2176tg;
/* renamed from: o.tc  reason: case insensitive filesystem */
public class C2172tc extends C2116re implements AbstractC2123rl {

    /* renamed from: ˈ  reason: contains not printable characters */
    protected If f10486;

    /* renamed from: ˉ  reason: contains not printable characters */
    protected boolean f10487;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    protected AbstractC0801.Cif f10488 = new AbstractC0801.Cif() { // from class: o.tc.3
        @Override // o.AbstractC0801.Cif
        /* renamed from: ˏ */
        public View mo4156(View view) {
            return new C2179ti(view.getContext(), R.layout.kids_episode_detail_view, C2172tc.this.m11101(), new AbstractC1450Fk<String, Void>() { // from class: o.tc.3.4
                /* renamed from: ˊ  reason: contains not printable characters */
                public Void invoke(String str) {
                    C2172tc.this.f9834 = str;
                    return null;
                }
            });
        }
    };

    /* renamed from: ˊˋ  reason: contains not printable characters */
    boolean f10489;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private List<pI> f10490;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    protected AL f10491;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private boolean f10492;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private boolean f10493;

    /* renamed from: ˌ  reason: contains not printable characters */
    private View f10494;

    /* renamed from: ˍ  reason: contains not printable characters */
    private boolean f10495;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private Stack<C2176tg> f10496 = new Stack<>();

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private C2176tg f10497;

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m11100(String str, String str2) {
        if (getArguments() != null) {
            getArguments().putString("extra_episode_id", str2);
            getArguments().putString("extra_show_id", str);
        }
    }

    @Override // o.C2116re, o.AbstractC0496, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10486 = new If(m14476());
        this.f10492 = bundle != null;
        if (bundle != null) {
            this.f10493 = bundle.getBoolean("saved_state_show_related", false);
            C2176tg.If.m11157(bundle, this.f10496);
            if (!this.f10496.empty()) {
                this.f10497 = this.f10496.pop();
                this.f9841 = this.f10497.f10539;
            }
        }
    }

    @Override // o.C2116re, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m11086(onCreateView);
        return onCreateView;
    }

    @Override // o.AbstractC2123rl
    public boolean V_() {
        if (this.f10496.empty()) {
            return false;
        }
        m11076();
        return true;
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private void m11076() {
        this.f10497 = this.f10496.pop();
        this.f9841 = this.f10497.f10539;
        this.f9826 = this.f10497.f10538;
        m10402();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11086(View view) {
        if (view != null && getActivity() != null && getActivity().getIntent().getBooleanExtra("extra_same_activity_type", false)) {
            view.setBackground(null);
        }
    }

    @Override // o.C2116re, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("saved_state_show_related", this.f10493);
        bundle.putString("extra_episode_id", this.f9834);
        if (!this.f10496.empty()) {
            this.f10496.push(new C2176tg(this.f9841, this.f9844.getLayoutManager().onSaveInstanceState(), this.f9826, AD.m3284((Context) getActivity()), ((DetailsActivity) getActivity()).mo1635()));
            C2176tg.C2177iF.m11158(bundle, this.f10496);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ˏ */
    public void mo10392(View view) {
        super.mo10392(view);
        this.f10494 = view.findViewById(R.id.listview_frag_container);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˉ  reason: contains not printable characters */
    public void m11094() {
        if (this.f10494 != null && getActivity() != null) {
            this.f10494.setOnClickListener(new View.OnClickListener() { // from class: o.tc.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DetailsActivity.m1631(C2172tc.this.getActivity());
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ʽ */
    public void mo10372() {
        if (!C1322Av.m3793(getActivity())) {
            final int r2 = m11101();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), r2);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: o.tc.4
                @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    if (i < C2172tc.this.f9839.m15326()) {
                        return r2;
                    }
                    return 1;
                }
            });
            this.f9844.setLayoutManager(gridLayoutManager);
            this.f9844.getLayoutParams().width = AD.m3317(getActivity());
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ʻॱ */
    public ViewGroup mo10369() {
        ViewGroup r2 = super.mo10369();
        if (r2 != null) {
            if (!(r2.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                C1276.m16820().mo5725("Something changed in EpisodesFrag? spinnerViewGroup layoutParams is cast into FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) r2.getLayoutParams();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.content_padding);
            layoutParams.setMargins(dimensionPixelSize, layoutParams.topMargin, dimensionPixelSize, dimensionPixelSize);
        }
        m11082();
        return r2;
    }

    @Override // o.C2116re
    /* renamed from: ˋ */
    public void mo10386(int i, boolean z) {
        this.f10489 = z;
        super.mo10386(i, z);
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    private void m11082() {
        if (this.f9828 != null && this.f9844 != null) {
            this.f9828.setOnItemTouchListener(new AdapterView.OnItemSelectedListener() { // from class: o.tc.5
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    final GridLayoutManager gridLayoutManager = (GridLayoutManager) C2172tc.this.f9844.getLayoutManager();
                    final int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
                    C2172tc.this.f9844.post(new Runnable() { // from class: o.tc.5.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (findFirstVisibleItemPosition != 0) {
                                gridLayoutManager.scrollToPositionWithOffset(1, C2172tc.this.m14476().getActionBarHeight());
                            }
                        }
                    });
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋˊ  reason: contains not printable characters */
    public void m11095() {
        if (this.f9844 != null && this.f10494 != null && getActivity() != null) {
            C1283.m16846("KidsBaseDetailsFrag", "animateIn()");
            if (this.f10492) {
                if (!m10382()) {
                    C1283.m16846("KidsBaseDetailsFrag", "Showing recycler view");
                    this.f9844.setVisibility(0);
                    this.f9844.setAlpha(1.0f);
                }
                NetflixActionBar netflixActionBar = m14476().getNetflixActionBar();
                if (netflixActionBar != null) {
                    netflixActionBar.m359(1.0f);
                    return;
                }
                return;
            }
            m11096();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋˋ  reason: contains not printable characters */
    public void m11096() {
        if (!m10382()) {
            C1283.m16846("KidsBaseDetailsFrag", "Showing recycler view");
            this.f9844.setVisibility(0);
        }
        NetflixActionBar netflixActionBar = m14476().getNetflixActionBar();
        this.f9844.animate().alpha(1.0f).setDuration(500);
        netflixActionBar.m360(1.0f, 500);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ˋ */
    public void mo10387(pR pRVar) {
        if (getActivity() instanceof DetailsActivity) {
            ((DetailsActivity) getActivity()).m1642(pRVar.getId(), pRVar.getCurrentEpisodeId());
        }
        super.mo10387(pRVar);
        if (!this.f10493) {
            m11097();
        } else {
            m11098();
        }
        m11080();
        m11099();
        m11094();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˍ  reason: contains not printable characters */
    public void m11099() {
        if (this.f10495) {
            this.f10495 = false;
            this.f9844.getHandler().post(new Runnable() { // from class: o.tc.2
                @Override // java.lang.Runnable
                public void run() {
                    C2172tc.this.f9844.scrollToPosition(0);
                    if (C2172tc.this.f9840 != null) {
                        C2172tc.this.f9840.mo10332(0);
                    }
                }
            });
        }
        if (this.f10497 != null && this.f10497.f10536 != null) {
            this.f9844.getLayoutManager().onRestoreInstanceState(this.f10497.f10536);
            this.f10497 = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2116re
    /* renamed from: ॱॱ */
    public void mo10403() {
        this.f9844.removeItemDecoration(this.f10491);
        this.f10491 = new AL(getActivity().getResources().getDimensionPixelOffset(R.dimen.kids_grid_spacing_size), m11101());
        this.f9844.addItemDecoration(this.f10491);
    }

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private void m11079() {
        Parcelable onSaveInstanceState = this.f9844.getLayoutManager().onSaveInstanceState();
        mo10372();
        mo10403();
        this.f9844.getLayoutManager().onRestoreInstanceState(onSaveInstanceState);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎˎ  reason: contains not printable characters */
    public int m11101() {
        int i;
        if (this.f10487) {
            i = AD.m3307(getActivity()) ? R.integer.kids_show_num_cols_landscape : R.integer.kids_show_num_cols;
        } else {
            i = AD.m3307(getActivity()) ? R.integer.kids_movie_sims_num_cols : R.integer.kids_show_num_cols_landscape;
        }
        return getActivity().getResources().getInteger(i);
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    public void m11098() {
        this.f10493 = true;
        m11079();
    }

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private void m11080() {
        if (getActivity() instanceof DetailsActivity) {
            m11087((DetailsActivity) getActivity(), this.f9843, this.f10496, this.f10497);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11087(DetailsActivity detailsActivity, pQ pQVar, Stack<C2176tg> stack, C2176tg tgVar) {
        qN qNVar = (qN) detailsActivity.mo1635();
        int i = 0;
        if (tgVar == null) {
            if (!stack.isEmpty()) {
                i = pQVar.getSimilarsTrackId();
            }
        } else if (stack.isEmpty() && tgVar.m11154() != null) {
            i = tgVar.m11154().getTrackId();
        }
        if (i > 0) {
            detailsActivity.m1648(qNVar.m9926(i));
        }
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    public void m11097() {
        this.f10493 = false;
        m11079();
        if (this.f10490 == null || this.f10490.size() <= 0) {
            this.f9839.m15318(2);
            this.f9839.m15313(this.f10488);
            this.f9839.m15314();
            m10374();
            return;
        }
        this.f9842.m1682().setVisibility(0);
        this.f9839.m15320(this.f10490, 2, this.f10488);
        mo10375();
    }

    /* renamed from: o.tc$ˊ  reason: contains not printable characters */
    public class C0222 extends C2119rh {
        C0222(NetflixActivity netflixActivity, C2172tc tcVar, AbstractC0801.Cif ifVar) {
            super(netflixActivity, tcVar, ifVar);
        }

        /* access modifiers changed from: protected */
        @Override // o.C2119rh
        /* renamed from: ॱ */
        public void mo10349(List<pI> list, int i) {
            if (C2172tc.this.f10489) {
                super.m15328(list);
                this.f9884 += list.size();
            } else if (!C2172tc.this.f10493) {
                super.mo10349(list, i);
                C2172tc.this.f10490 = list;
                m11117();
            }
            C2172tc.this.m11095();
        }

        /* renamed from: ʽ  reason: contains not printable characters */
        private void m11117() {
            if (C2172tc.this.f10490 != null && C2172tc.this.f10490.size() > 0) {
                C2172tc.this.f9845.setVisibility(0);
                C2172tc.this.f9823.mo14663(false);
                C2172tc.this.mo10398(AbstractC0367.f13235);
            }
        }

        /* access modifiers changed from: protected */
        @Override // o.C2119rh, o.AbstractC0801
        /* renamed from: ˊ */
        public void mo10425(int i) {
            super.mo10425(i);
            if (C2172tc.this.f9840 != null) {
                C2172tc.this.f9840.m10336();
            }
        }

        @Override // o.AbstractC0801, android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f14517 == null) {
                return 0;
            }
            return this.f14517.size() + m15326() + (m15324() ? 1 : 0);
        }

        /* access modifiers changed from: protected */
        @Override // o.C2119rh
        /* renamed from: ʻ */
        public void mo10423() {
            C1283.m16846("KidsBaseDetailsFrag", "initToLoadingState");
            this.f9882 = true;
            this.f9883 = true;
            this.f9887 = -1;
            this.f9884 = 0;
            mo10424();
        }

        @Override // o.C2119rh
        /* renamed from: ʼ */
        public void mo10424() {
            C2059ph phVar = null;
            if (this.f9885 instanceof AbstractC2131rt) {
                phVar = this.f9885.m14474();
            }
            if (phVar == null || !phVar.mo9519()) {
                C1283.m16854("KidsBaseDetailsFrag", "Manager is not ready");
            } else if (this.f9886 == null) {
                C1283.m16846("KidsBaseDetailsFrag", "No season details yet");
            } else {
                String id = this.f9886.getId();
                if (C1349Bv.m4113(id)) {
                    m10426(this.f9886);
                    return;
                }
                this.f9887 = System.nanoTime();
                int i = (this.f9884 + 40) - 1;
                this.f14519.getId();
                phVar.m9764().mo9510(id, CmpTaskMode.FROM_CACHE_OR_NETWORK, VideoType.SEASON, this.f9884, i, new C2119rh.C0183(this.f9887, this.f9884, i));
            }
        }
    }

    /* renamed from: o.tc$if  reason: invalid class name */
    class Cif extends C0222 {
        public Cif() {
            super(C2172tc.this.m14476(), C2172tc.this, new AbstractC0801.Cif() { // from class: o.tc.if.1
                @Override // o.AbstractC0801.Cif
                /* renamed from: ˏ */
                public View mo4156(View view) {
                    C1210 r2 = new C1210(view.getContext());
                    r2.setAdjustViewBounds(true);
                    r2.setScaleType(ImageView.ScaleType.FIT_XY);
                    r2.setLayoutParams(new AbsListView.LayoutParams(-1, m11116()));
                    r2.setIsHorizontal(C2172tc.this.f10487);
                    return r2;
                }

                /* renamed from: ˏ  reason: contains not printable characters */
                private int m11116() {
                    return (int) (((((float) AD.m3317(C2172tc.this.getActivity())) - ((((float) C2172tc.this.m11101()) + 1.0f) * ((float) C2172tc.this.getActivity().getResources().getDimensionPixelOffset(R.dimen.kids_content_padding)))) / ((float) C2172tc.this.m11101())) * (C2172tc.this.f10487 ? 0.5625f : 1.43f));
                }
            });
        }
    }

    /* renamed from: o.tc$If */
    public class If {

        /* renamed from: ʻ  reason: contains not printable characters */
        private final NetflixActivity f10508;

        /* renamed from: ʼ  reason: contains not printable characters */
        private boolean f10509;

        /* renamed from: ʽ  reason: contains not printable characters */
        private C0522 f10510;

        /* renamed from: ˊ  reason: contains not printable characters */
        private final Handler f10511;

        /* renamed from: ˋ  reason: contains not printable characters */
        private int f10512;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final List<String> f10513;

        /* renamed from: ˏ  reason: contains not printable characters */
        private boolean f10514;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private C0522 f10516;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final Runnable f10517;

        private If(NetflixActivity netflixActivity) {
            this.f10511 = new Handler();
            this.f10513 = new ArrayList();
            this.f10509 = true;
            this.f10517 = new Runnable() { // from class: o.tc.If.4
                @Override // java.lang.Runnable
                public void run() {
                    If.this.m11106();
                    If.this.f10511.postDelayed(If.this.f10517, 4000);
                }
            };
            this.f10508 = netflixActivity;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m11113() {
            if (C2172tc.this.f9843 instanceof pM) {
                this.f10510 = C2172tc.this.f9842.m1676();
                this.f10516 = ((C2181tk) C2172tc.this.f9842).m11189();
                this.f10514 = false;
                this.f10513.clear();
                pM pMVar = (pM) C2172tc.this.f9843;
                List<String> heroImages = pMVar.getHeroImages();
                if (heroImages != null && heroImages.size() > 0) {
                    this.f10513.addAll(heroImages);
                }
                String storyUrl = pMVar.getStoryUrl();
                if (!TextUtils.isEmpty(storyUrl)) {
                    this.f10513.add(storyUrl);
                }
                if (this.f10513.size() > 0) {
                    this.f10512 = 0;
                    this.f10511.removeCallbacks(this.f10517);
                    this.f10511.postDelayed(this.f10517, 3000);
                }
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m11114(boolean z) {
            if (!this.f10514) {
                this.f10514 = true;
                this.f10511.removeCallbacks(this.f10517);
                if (z) {
                    this.f10513.clear();
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˋ  reason: contains not printable characters */
        private void m11106() {
            if (this.f10510 != null && this.f10508 != null && C2172tc.this.getActivity() != null && this.f10513 != null && this.f10512 < this.f10513.size()) {
                NetflixActivity.getImageLoader(this.f10508).mo3059(this.f10513.get(this.f10512), AssetType.boxArt, this.f10510.getMeasuredWidth(), this.f10510.getMeasuredHeight(), new AbstractC0957() { // from class: o.tc.If.1
                    @Override // o.AbstractC0957
                    public void onResponse(Bitmap bitmap, String str) {
                        if (bitmap != null && !If.this.f10514) {
                            if (If.this.f10509) {
                                m11115(str, bitmap, If.this.f10516, If.this.f10510);
                            } else {
                                m11115(str, bitmap, If.this.f10510, If.this.f10516);
                            }
                        }
                    }

                    /* renamed from: ॱ  reason: contains not printable characters */
                    private void m11115(String str, Bitmap bitmap, C0522 r7, C0522 r8) {
                        Object tag = r8.getTag();
                        if (tag == null || tag != str) {
                            r7.setTag(str);
                            r7.setImageBitmap(bitmap);
                            r7.animate().alpha(1.0f).setDuration(2000);
                            r8.animate().alpha(0.0f).setDuration(2000);
                            If.this.f10509 = !If.this.f10509;
                        }
                    }

                    @Override // o.AbstractC0957
                    public void onErrorResponse(String str) {
                        If.this.f10512 = 0;
                    }
                });
                this.f10512++;
                if (this.f10512 >= this.f10513.size()) {
                    this.f10512 = 0;
                }
            }
        }
    }

    @Override // o.C2116re
    /* renamed from: ˊˋ */
    public boolean mo10383() {
        NetflixActionBar netflixActionBar;
        NetflixActivity r2 = m14476();
        if (r2 == null || (netflixActionBar = r2.getNetflixActionBar()) == null) {
            return false;
        }
        NetflixActionBar.iF.AbstractC0010 r4 = r2.getActionBarStateBuilder().mo403(true);
        if (this.f9840 != null) {
            r4.mo387(this.f9840.mo10342());
        }
        netflixActionBar.m355(r4.mo392());
        return true;
    }
}
