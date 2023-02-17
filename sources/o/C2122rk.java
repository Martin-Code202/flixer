package o;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.service.webclient.model.leafs.TrackableObject;
import com.netflix.mediaclient.servicemgr.UiLocation;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.VideoDetailsViewGroup;
import com.netflix.mediaclient.ui.offline.DownloadButton;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.List;
import o.AbstractC0801;
import o.vT;
/* renamed from: o.rk  reason: case insensitive filesystem */
public class C2122rk extends qW<pP> implements AbstractC2124rm, vT.AbstractC0242 {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected long f9900;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private View f9901;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected AbstractC0801 f9902;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected boolean f9903 = true;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected GridLayoutManager f9904;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected C2112ra f9905;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected RecyclerView f9906;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    protected AL f9907;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected int f9908;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private Parcelable f9909;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected String f9910;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C2122rk m10441(String str, int i) {
        C2122rk rkVar = new C2122rk();
        Bundle bundle = new Bundle();
        bundle.putString("video_id", str);
        bundle.putInt("extra_model_view_id", i);
        rkVar.setArguments(bundle);
        return rkVar;
    }

    /* renamed from: o.rk$1  reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ C2122rk f9911;

        @Override // java.lang.Runnable
        public void run() {
            this.f9911.f9906.scrollToPosition(0);
        }
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f9910 = getArguments().getString("video_id");
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10454(View view) {
        this.f9906 = (RecyclerView) this.f9556;
        if (this.f9906 == null) {
            C1276.m16820().mo5725("MovieDetails - recyclerview View is null, finishing up the activity");
            m10442();
        }
        C1004.m15952(this.f9906, 3, (int) this.f9906.getResources().getDimension(R.dimen.double_padding));
        this.f9901 = view.findViewById(R.id.listview_frag_container);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10442() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.qW
    /* renamed from: ˏॱ */
    public int mo9992() {
        return R.layout.recyclerview_frag_with_le;
    }

    /* access modifiers changed from: protected */
    @Override // o.qW
    /* renamed from: ॱॱ */
    public int mo9998() {
        return 16908298;
    }

    /* access modifiers changed from: protected */
    @Override // o.qW
    /* renamed from: ˎ */
    public void mo9989(View view) {
        if (C0881.m15597(getActivity())) {
            this.f9559 = new rA(getActivity());
        } else {
            this.f9559 = new VideoDetailsViewGroup(getActivity());
        }
        this.f9559.m1695();
        this.f9559.m1700();
        if (AD.m3307(getActivity()) && AD.m3299()) {
            this.f9559.setPadding(0, m14534().getActionBarHeight(), 0, 0);
        }
    }

    @Override // o.qW, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Parcelable parcelable;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m10454(onCreateView);
        this.f9908 = m10447();
        mo9989(onCreateView);
        if (!(bundle == null || (parcelable = bundle.getParcelable("layout_manager_state")) == null)) {
            mo10452(parcelable);
        }
        mo10433();
        this.f9559.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.rk.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewUtils.m3009(C2122rk.this.f9559, this);
                C2122rk.this.m10444();
            }
        });
        return onCreateView;
    }

    @Override // android.support.v4.app.Fragment
    public void setExitTransition(Object obj) {
        super.setExitTransition(obj);
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f9904 != null) {
            bundle.putParcelable("layout_manager_state", this.f9904.onSaveInstanceState());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    public void m10444() {
        NetflixActivity r5 = m14534();
        if (r5 != null && r5.getNetflixActionBar() != null) {
            if (AD.m3292() || AD.m3306(getActivity())) {
                C1283.m16846("MovieDetailsFrag", "Attaching parallax scroll listener to recyclerView");
                this.f9905 = C2112ra.m10316(null, this.f9906, new View[]{this.f9559.m1676()}, null, null);
                this.f9906.setOnScrollListener(this.f9905);
            }
            af_();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˈ */
    public void mo10433() {
        this.f9906.setFocusable(false);
        this.f9906.setVisibility(4);
        m10445();
        m10446();
        m10448();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʿ  reason: contains not printable characters */
    public void m10448() {
        this.f9902 = new qS(true, this.f9908, new AbstractC0801.Cif() { // from class: o.rk.2

            /* renamed from: ˊ  reason: contains not printable characters */
            private int f9913;

            /* renamed from: ॱ  reason: contains not printable characters */
            private int f9915;

            {
                m10459();
            }

            @Override // o.AbstractC0801.Cif
            /* renamed from: ˏ */
            public View mo4156(View view) {
                C1210 r2 = new C1210(view.getContext());
                r2.setAdjustViewBounds(true);
                r2.setScaleType(ImageView.ScaleType.FIT_XY);
                r2.setLayoutParams(new AbsListView.LayoutParams(this.f9913, this.f9915));
                return r2;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            private void m10459() {
                this.f9913 = (((AD.m3317(C2122rk.this.getActivity()) - C2122rk.this.f9906.getPaddingLeft()) - C2122rk.this.f9906.getPaddingRight()) - (C2122rk.this.f9908 * C2122rk.this.getActivity().getResources().getDimensionPixelOffset(R.dimen.content_padding))) / C2122rk.this.f9908;
                this.f9915 = (int) (((float) this.f9913) * 1.43f);
            }
        });
        this.f9902.m15327(this.f9559);
        this.f9906.setAdapter(this.f9902);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m10440(pT pTVar) {
        qT r2;
        if (this.f9902 != null && (r2 = qT.m9959(pTVar, getActivity())) != null && C1349Bv.m4107(pTVar.getCopyright())) {
            r2.m9964();
            this.f9902.m15319(r2.m9963());
            r2.m9963().setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼॱ  reason: contains not printable characters */
    public void m10445() {
        this.f9907 = new AL(getActivity().getResources().getDimensionPixelOffset(R.dimen.content_padding), this.f9908);
        this.f9906.addItemDecoration(this.f9907);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽॱ  reason: contains not printable characters */
    public void m10446() {
        this.f9904 = new GridLayoutManager(getActivity(), this.f9908);
        this.f9904.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: o.rk.3
            @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (((AbstractC0801) C2122rk.this.f9906.getAdapter()).m15330(i)) {
                    return C2122rk.this.f9908;
                }
                if (i == 0) {
                    return C2122rk.this.f9908;
                }
                return 1;
            }
        });
        this.f9906.setLayoutManager(this.f9904);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʾ  reason: contains not printable characters */
    public int m10447() {
        if (getActivity() instanceof ActivityC2234vd) {
            return 4;
        }
        return uH.m11417(m14534());
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        super.onManagerReady(phVar, status);
        mo10449();
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
    }

    @Override // o.qW, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        qS.m9950(this.f9906);
        if (this.f9902 != null) {
            this.f9902.notifyDataSetChanged();
        }
        this.f9559.m1678(m9996());
    }

    @Override // o.AbstractC2124rm
    /* renamed from: ˊ  reason: contains not printable characters */
    public Parcelable mo10450() {
        if (this.f9906.getLayoutManager() == null) {
            return null;
        }
        return this.f9906.getLayoutManager().onSaveInstanceState();
    }

    @Override // o.AbstractC2124rm
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo10452(Parcelable parcelable) {
        this.f9909 = parcelable;
    }

    /* access modifiers changed from: protected */
    @Override // o.qW
    /* renamed from: ᐝॱ */
    public void mo10000() {
        mo10449();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˉ  reason: contains not printable characters */
    public void mo10449() {
        C2059ph r5 = m14536();
        if (r5 == null || !r5.mo9519()) {
            C1283.m16865("MovieDetailsFrag", "Manager is null/notReady - can't reload data");
            return;
        }
        this.f9903 = true;
        this.f9900 = System.nanoTime();
        C1283.m16846("MovieDetailsFrag", "Fetching data for movie ID: " + this.f9910);
        r5.m9764().mo9513(this.f9910, (String) null, new Cif(this.f9900));
    }

    /* access modifiers changed from: protected */
    @Override // o.qW
    /* renamed from: ॱˎ */
    public String mo9997() {
        return this.f9910;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public VideoDetailsViewGroup.AbstractC0033 mo9994(final pP pPVar) {
        return new VideoDetailsViewGroup.AbstractC0033() { // from class: o.rk.4
            @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.AbstractC0033
            /* renamed from: ॱ */
            public CharSequence mo1715() {
                return BG.m3851(C2122rk.this.getActivity(), pPVar);
            }

            @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.AbstractC0033
            /* renamed from: ˎ */
            public CharSequence mo1714() {
                if (C1349Bv.m4113(pPVar.getDirectors())) {
                    return null;
                }
                return BG.m3857(C2122rk.this.getActivity(), C0403.m14185(C2122rk.this.getActivity(), R.string.label_directors_plural).m14187(pPVar.getNumDirectors()).m14188(), pPVar.getDirectors());
            }

            @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.AbstractC0033
            /* renamed from: ˋ */
            public CharSequence mo1713() {
                return BG.m3852(C2122rk.this.getActivity(), R.string.label_starring, pPVar.getActors());
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public void mo9987(pP pPVar) {
        super.mo9987((C2122rk) pPVar);
        mo10434(pPVar);
        this.f9906.setVisibility(0);
        m10440((pT) pPVar);
        m10451();
        mo9990(AbstractC0367.f13235);
        if (!ah_()) {
            ag_();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0517
    public void ag_() {
        NetflixActivity r3 = m14534();
        pT r4 = m9996();
        if (r3 != null && r4 != null) {
            r3.getTutorialHelper().m12056(this, r4, this.f9906, m14536());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo10434(pP pPVar) {
        m10455(pPVar);
        mo10458(pPVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m10453(pP pPVar) {
        C1283.m16848("MovieDetailsFrag", "Volatile data update rating: %d, inQ: %b", Integer.valueOf(pPVar.getUserThumbRating()), Boolean.valueOf(pPVar.isInQueue()));
        this.f9559.m1688(pPVar);
        m9995();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10455(pP pPVar) {
        this.f9902.m15329(new TrackableObject(pPVar.getSimilarsRequestId(), pPVar.getSimilarsTrackId(), pPVar.getSimilarsListPos()), UiLocation.MDP_SIMILARS);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void mo10458(pP pPVar) {
        if (pPVar.getSimilars().size() != 0) {
            this.f9902.m15328(pPVar.getSimilars());
            m10457(pPVar.getSimilars());
        } else if (m9999() != null) {
            m9999().m1675();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m10457(List<pJ> list) {
        qX.m10003(m14536(), list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public void m10451() {
        if (!AB.m3274("MovieDetailsFrag", "can't restore layout manager", this.f9909, this.f9906, this.f9905)) {
            C1283.m16848("MovieDetailsFrag", "Restoring layout manager state: %s", this.f9909);
            this.f9906.getLayoutManager().onRestoreInstanceState(this.f9909);
            this.f9909 = null;
            C1283.m16846("MovieDetailsFrag", "Posting message to reset parallax views");
            this.f9906.post(new Runnable() { // from class: o.rk.10
                @Override // java.lang.Runnable
                public void run() {
                    C1283.m16846("MovieDetailsFrag", "Resetting parallax views");
                    C2122rk.this.f9905.m10336();
                }
            });
        }
    }

    @Override // o.vT.AbstractC0242
    /* renamed from: ˏ */
    public C0697 mo10390(AbstractC2089qj qjVar) {
        DownloadButton r2 = m9999().mo1686();
        if (r2 == null) {
            return null;
        }
        return vT.m12047(r2.findViewById(R.id.download_button_badge), getActivity(), qjVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.rk$if  reason: invalid class name */
    public class Cif extends oP {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final long f9921;

        public Cif(long j) {
            super("MovieDetailsFrag");
            this.f9921 = j;
        }

        @Override // o.oP, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            super.onMovieDetailsFetched(pPVar, status);
            if (C1317As.m3750(C2122rk.this.m14534())) {
                C1283.m16846("MovieDetailsFrag", "Activity state is invalid");
            } else if (this.f9921 != C2122rk.this.f9900 || C2122rk.this.T_()) {
                C1283.m16846("MovieDetailsFrag", "Ignoring stale callback");
            } else {
                C2122rk.this.f9903 = false;
                if (status.mo301()) {
                    C1283.m16865("MovieDetailsFrag", "Invalid status code");
                    C2122rk.this.m9991(status);
                } else if (pPVar == null) {
                    C1283.m16846("MovieDetailsFrag", "No details in response");
                    C2122rk.this.m9991(AbstractC0367.f13245);
                } else {
                    if (pPVar.shouldRefreshVolatileData() && ConnectivityUtils.m2954(C2122rk.this.getActivity())) {
                        C2059ph r9 = C2122rk.this.m14536();
                        if (r9 == null || !r9.mo9519()) {
                            C1283.m16865("MovieDetailsFrag", "Manager is null/notReady - can't reload data");
                            return;
                        }
                        C2122rk.this.f9900 = System.nanoTime();
                        C1283.m16848("MovieDetailsFrag", "Fetching volatile data for video ID: %s", C2122rk.this.f9910);
                        r9.m9764().mo9487(new C0870(C2122rk.this.f9910, pPVar.getType() == VideoType.MOVIE), new C0184(C2122rk.this, C2122rk.this.f9910, pPVar.getUserThumbRating(), pPVar.getMatchPercentage(), pPVar.isInQueue(), null));
                    }
                    C2122rk.this.mo9987(pPVar);
                    qX.m10008(status);
                }
            }
        }
    }

    /* renamed from: o.rk$ˋ  reason: contains not printable characters */
    class C0184 extends oP {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final int f9923;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final int f9924;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final String f9925;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final boolean f9926;

        /* synthetic */ C0184(C2122rk rkVar, String str, int i, int i2, boolean z, AnonymousClass1 r6) {
            this(str, i, i2, z);
        }

        private C0184(String str, int i, int i2, boolean z) {
            super("MovieDetailsFrag");
            this.f9925 = str;
            this.f9923 = i;
            this.f9924 = i2;
            this.f9926 = z;
        }

        @Override // o.oP, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            super.onMovieDetailsFetched(pPVar, status);
            if (C1317As.m3750(C2122rk.this.m14534())) {
                C1283.m16846("MovieDetailsFrag", "Activity state is invalid");
            } else if (status.mo301()) {
                C1283.m16865("MovieDetailsFrag", "Volatile data has invalid status code");
            } else if (pPVar == null) {
                C1283.m16846("MovieDetailsFrag", "Volatile data no details in response");
            } else if (!TextUtils.equals(pPVar.getId(), this.f9925)) {
                C1283.m16865("MovieDetailsFrag", "Ignoring stale volatile data callback");
            } else if (this.f9924 != pPVar.getMatchPercentage() || this.f9923 != pPVar.getUserThumbRating() || this.f9926 != pPVar.isInQueue()) {
                C2122rk.this.m10453(pPVar);
            }
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return this.f9903;
    }

    @Override // o.AbstractC0517
    public boolean af_() {
        NetflixActionBar netflixActionBar;
        NetflixActivity r2 = m14534();
        if (r2 == null || (netflixActionBar = r2.getNetflixActionBar()) == null) {
            return false;
        }
        NetflixActionBar.iF.AbstractC0010 r4 = r2.getActionBarStateBuilder().mo396(false).mo403(true);
        if (this.f9905 != null) {
            r4.mo387(this.f9905.mo10342());
        }
        netflixActionBar.m355(r4.mo392());
        return true;
    }
}
