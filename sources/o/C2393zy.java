package o;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.cl.model.AppView;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.model.leafs.SearchCollectionEntity;
import com.netflix.model.leafs.SearchTrackableListSummary;
import java.util.ArrayList;
import java.util.List;
import o.C0567;
import o.C2387zt;
/* renamed from: o.zy  reason: case insensitive filesystem */
public class C2393zy extends AbstractC0517 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private RecyclerView f13014;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private int f13015 = 0;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f13016;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final ArrayList<SearchCollectionEntity> f13017 = new ArrayList<>();

    /* renamed from: ʾ  reason: contains not printable characters */
    private boolean f13018 = true;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private String f13019;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private String f13020;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C2059ph f13021;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f13022 = "";

    /* renamed from: ͺ  reason: contains not printable characters */
    private oX f13023;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String f13024;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private long f13025;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private int f13026 = 14;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private AppView f13027 = AppView.suggestionTitleResults;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f13028 = true;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C0616 f13029;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private Long f13030 = null;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C2393zy m13853(Intent intent) {
        Bundle extras = intent.getExtras();
        Bundle bundle = new Bundle();
        if (extras != null) {
            bundle.putString("Title", extras.getString("Title"));
            bundle.putString("EntityId", extras.getString("EntityId"));
            bundle.putString("ParentRefId", extras.getString("ParentRefId"));
            bundle.putString("SearchResultType", extras.getString("SearchResultType"));
            bundle.putString("SearchQuery", extras.getString("SearchQuery"));
            bundle.putInt("TrackId", intent.getIntExtra("TrackId", -1010));
        }
        C2393zy zyVar = new C2393zy();
        zyVar.setArguments(bundle);
        return zyVar;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m13858();
        View inflate = layoutInflater.inflate(R.layout.prequery_collection_activity, viewGroup, false);
        m13848(inflate);
        m13864(inflate);
        m14534().runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.zy.5
            @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
            public void run(C2059ph phVar) {
                C2393zy.this.f13021 = phVar;
                C2393zy.this.m13845();
            }
        });
        return inflate;
    }

    @Override // o.AbstractC0517
    public boolean af_() {
        NetflixActionBar netflixActionBar = m14534().getNetflixActionBar();
        if (netflixActionBar == null) {
            return false;
        }
        netflixActionBar.m355(m14534().getActionBarStateBuilder().mo399(false).mo394((CharSequence) this.f13016).mo392());
        return true;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13858() {
        Bundle arguments = getArguments();
        this.f13016 = arguments.getString("Title", "");
        this.f13020 = arguments.getString("EntityId", "");
        this.f13022 = arguments.getString("SearchQuery", "");
        this.f13019 = arguments.getString("ParentRefId");
        String string = arguments.getString("SearchResultType");
        if (!TextUtils.isEmpty(string)) {
            try {
                this.f13027 = AppView.valueOf(string);
            } catch (IllegalArgumentException e) {
                C1283.m16847("SrchSuggestTitlGalleryFrag", "Bad intent", e);
                this.f13027 = AppView.suggestionTitleResults;
            }
        }
        this.f13023 = new qN(null, arguments.getInt("TrackId", -1), 0, 0);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13848(View view) {
        this.f13029 = new C0616(view, new C0567.Cif() { // from class: o.zy.2
            @Override // o.C0567.Cif
            public void N_() {
                C2393zy.this.m13851();
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13864(View view) {
        this.f13014 = (RecyclerView) view.findViewById(R.id.search_collection_list);
        this.f13014.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        this.f13014.setAdapter(new RecyclerView.Adapter() { // from class: o.zy.3
            @Override // android.support.v7.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new C0340(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.presearch_collection_view_ab8274, viewGroup, false));
            }

            @Override // android.support.v7.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
                m13873((C0340) viewHolder, i);
                m13874((C0340) viewHolder, i);
                if (i == C2393zy.this.f13015 - 1) {
                    C2393zy.this.m13845();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.Adapter
            public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
                super.onViewAttachedToWindow(viewHolder);
                ((C0340) viewHolder).m13877();
            }

            @Override // android.support.v7.widget.RecyclerView.Adapter
            public int getItemCount() {
                return C2393zy.this.f13017.size();
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            private void m13873(C0340 r12, int i) {
                FragmentActivity activity = C2393zy.this.getActivity();
                if (r12.f13040 != null && activity != null) {
                    SearchCollectionEntity searchCollectionEntity = (SearchCollectionEntity) C2393zy.this.f13017.get(i);
                    if (C1349Bv.m4107(searchCollectionEntity.getImageUrl())) {
                        NetflixActivity.getImageLoader(activity).mo3063(r12.f13040, searchCollectionEntity.getImageUrl(), AssetType.boxArt, searchCollectionEntity.getTitle(), BrowseExperience.m1769(), false, 1);
                    }
                    int r10 = AD.m3317(activity) / 3;
                    r12.f13040.getLayoutParams().width = r10;
                    r12.f13040.getLayoutParams().height = (int) (((float) r10) * 1.333f);
                }
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            private void m13874(C0340 r4, final int i) {
                if (r4.f13040 != null) {
                    final SearchCollectionEntity searchCollectionEntity = (SearchCollectionEntity) C2393zy.this.f13017.get(i);
                    r4.f13040.setOnClickListener(new View.OnClickListener() { // from class: o.zy.3.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(view2.getContext(), NetflixActivity.class);
                            if (netflixActivity != null && C2393zy.this.f13023 != null && !TextUtils.isEmpty(C2393zy.this.f13024)) {
                                C1300Ac.m3531(new C1080(AppView.boxArt, new C2387zt.C2388iF(C2393zy.this.f13024, searchCollectionEntity.getEntityId(), searchCollectionEntity.getId(), C2393zy.this.f13023.getTrackId(), i % 3, i / 3)), new C0642(), true);
                                qU.m9966(netflixActivity, searchCollectionEntity.getType(), searchCollectionEntity.getId(), "", C2393zy.this.f13023, "");
                            }
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zy$ˊ  reason: contains not printable characters */
    public final class C0340 extends RecyclerView.ViewHolder {

        /* renamed from: ॱ  reason: contains not printable characters */
        private final C0522 f13040;

        C0340(View view) {
            super(view);
            this.f13040 = (C0522) view.findViewById(R.id.presearch_boxArt);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public void m13877() {
            C2393zy.this.m13859(getLayoutPosition());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m13869() {
        this.f13029.mo14663(true);
        BQ.m3914(this.f13014, true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m13867() {
        this.f13029.mo14660(true);
        BQ.m3909(this.f13014, true);
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m13863() {
        this.f13029.mo14570(true);
        BQ.m3909(this.f13014, true);
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return this.f13028;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m13851() {
        m13863();
        m13845();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m13845() {
        if (this.f13018) {
            if (this.f13021 == null || !this.f13021.mo9519()) {
                C1283.m16865("SrchSuggestTitlGalleryFrag", "Manager is null/notReady - can't load data");
                return;
            }
            this.f13028 = true;
            this.f13025 = System.nanoTime();
            if (!TextUtils.isEmpty(this.f13024)) {
                this.f13021.m9764().mo9485(this.f13024, new Cif(this.f13025), this.f13015, this.f13026);
            } else {
                this.f13021.m9764().mo9509(this.f13020, CmpTaskMode.FROM_CACHE_OR_NETWORK, this.f13015, this.f13026, AD.m3299(), new Cif(this.f13025));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13859(int i) {
        SearchCollectionEntity searchCollectionEntity;
        if (!this.f13017.isEmpty() && (searchCollectionEntity = this.f13017.get(i)) != null) {
            C2387zt.m13824(this.f13027, searchCollectionEntity, i / 3, i % 3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zy$if  reason: invalid class name */
    public class Cif extends AbstractC2061pj {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final long f13037;

        Cif(long j) {
            this.f13037 = j;
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onSearchResultsFetched(AbstractC2080qa qaVar, Status status) {
            super.onSearchResultsFetched(qaVar, status);
            C2393zy.this.f13028 = false;
            if (this.f13037 == C2393zy.this.f13025 && !C1317As.m3750(C2393zy.this.getActivity())) {
                SearchTrackableListSummary searchTrackableListSummary = (SearchTrackableListSummary) qaVar.getVideosListTrackable();
                if (searchTrackableListSummary == null || qaVar.getResultsCollection() == null || status.mo301()) {
                    C1283.m16865("SrchSuggestTitlGalleryFrag", "Empty result or bad status code");
                    C2393zy.this.m13867();
                    return;
                }
                C2393zy.this.f13024 = searchTrackableListSummary.getReferenceId();
                C2387zt.m13815(C2393zy.this.f13027, C2393zy.this.f13020, C2393zy.this.f13022, C2393zy.this.f13024, C2393zy.this.f13019);
                if (C2393zy.this.f13030 == null) {
                    C2393zy.this.f13030 = C2387zt.m13825(C2393zy.this.f13027, C2393zy.this.f13024);
                }
                m13875(qaVar.getResultsCollection());
                C2393zy.this.f13017.addAll(qaVar.getResultsCollection());
                C2393zy.this.m13869();
                C2393zy.this.f13014.getAdapter().notifyDataSetChanged();
                int min = Math.min(searchTrackableListSummary.getLength(), 75);
                C2393zy.this.f13018 = C2393zy.this.f13026 < min + -1;
                if (C2393zy.this.f13018) {
                    C2393zy.this.f13015 = C2393zy.this.f13026 + 1;
                    C2393zy.this.f13026 += 15;
                    if (C2393zy.this.f13026 >= min) {
                        C2393zy.this.f13026 = min - 1;
                    }
                }
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m13875(List<SearchCollectionEntity> list) {
            if (!(list.size() == 0 || C1322Av.m3793(C2393zy.this.getActivity()))) {
                String[] strArr = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    strArr[i] = list.get(i).getId();
                }
                C2387zt.m13822(this.f13037, C2393zy.this.getActivity(), AppView.suggestionResults, C2393zy.this.f13024, strArr, C2393zy.this.f13015, C2393zy.this.f13026, AppView.suggestionTitleResults);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0517
    /* renamed from: ˊ */
    public void mo2213(View view) {
        if (this.f13029 != null) {
            this.f13029.mo14659(0, this.f13651 + this.f13649, 0, this.f13650);
        }
        if (this.f13014 != null) {
            this.f13014.setPadding(this.f13014.getPaddingLeft(), this.f13651 + this.f13649, this.f13014.getPaddingRight(), this.f13650);
        }
    }
}
