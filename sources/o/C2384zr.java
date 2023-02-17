package o;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.netflix.cl.model.AppView;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab8274;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.ISearchLogging;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.search.SearchUtils;
import com.netflix.model.leafs.SearchCollectionEntity;
import com.netflix.model.leafs.SearchTrackableListSummary;
import java.util.ArrayList;
import java.util.List;
import o.C0567;
/* renamed from: o.zr  reason: case insensitive filesystem */
public class C2384zr extends AbstractC0517 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private SQLiteDatabase f12930;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private String f12931 = "";

    /* renamed from: ʼ  reason: contains not printable characters */
    private Cif f12932;

    /* renamed from: ʽ  reason: contains not printable characters */
    boolean f12933 = false;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private TextView f12934;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private View f12935;

    /* renamed from: ˏ  reason: contains not printable characters */
    C0616 f12936;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f12937;

    /* renamed from: ͺ  reason: contains not printable characters */
    private RecyclerView f12938;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Cursor f12939;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private long f12940;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private int f12941 = 0;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private RecyclerView.Adapter f12942;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f12943;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private oX f12944 = new oB("SrchPreQueryFrag");

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private int f12945 = 14;

    /* renamed from: ˏ  reason: contains not printable characters */
    public IClientLogging.ModalView m13783() {
        return IClientLogging.ModalView.preQuery;
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m13786() {
        if (this.f12938 != null && (this.f12938.getAdapter() instanceof C0338)) {
            this.f12938.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f12939 != null) {
            this.f12939.close();
        }
        if (this.f12930 != null) {
            this.f12930.close();
        }
        super.onDestroy();
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        super.onManagerReady(phVar, status);
        FragmentActivity activity = getActivity();
        if (activity == null || C1317As.m3750(activity)) {
            C1283.m16865("SrchPreQueryFrag", "Activity is null or destroyed - bailing early");
            return;
        }
        if (Config_Ab8274.m504(activity) == Config_Ab8274.ListType.TRENDING) {
            this.f12937 = "2100000_merch";
        } else if (Config_Ab8274.m504(activity) == Config_Ab8274.ListType.POPULAR) {
            this.f12937 = "2000000_merch";
        }
        this.f12943 = Config_Ab8274.m506(activity);
        if (this.f12935 != null && this.f12943) {
            this.f12935.setPadding(0, AD.m3280(activity) / 2, 0, 0);
        }
        m13776();
        if (this.f12942 instanceof C0338) {
            m13782(phVar);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m13782(C2059ph phVar) {
        if (Config_Ab8274.m506(getActivity())) {
            m13773();
        }
        this.f12931 = "";
        this.f12941 = 0;
        this.f12945 = 14;
        C2387zt.m13820(this.f12940, getActivity(), m13783(), this.f12937, ISearchLogging.InputMode.keyboard, ISearchLogging.SearchType.searchEntityId, true);
        m13763();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m13763() {
        if (m14536() != null) {
            if (this.f12941 == 0) {
                this.f12936.mo14570(true);
            }
            this.f12940 = System.nanoTime();
            if (TextUtils.isEmpty(this.f12931)) {
                m14536().m9764().mo9509(this.f12937, CmpTaskMode.FROM_NETWORK, this.f12941, this.f12945, AD.m3299(), new C0337(this.f12940));
            } else {
                m14536().m9764().mo9485(this.f12931, new C0337(this.f12940), this.f12941, this.f12945);
            }
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m13773() {
        this.f12932 = new Cif();
        this.f12932.m13805();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zr$ˊ  reason: contains not printable characters */
    public class C0337 extends oP {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final long f12980;

        public C0337(long j) {
            super("SearchPreQueryFrag_Ab8274");
            this.f12980 = j;
        }

        @Override // o.oP, o.oU
        public void onSearchResultsFetched(AbstractC2080qa qaVar, Status status) {
            super.onSearchResultsFetched(qaVar, status);
            if (this.f12980 == C2384zr.this.f12940) {
                SearchTrackableListSummary searchTrackableListSummary = (SearchTrackableListSummary) qaVar.getVideosListTrackable();
                if (searchTrackableListSummary == null || qaVar.getResultsCollection() == null || status.mo301()) {
                    C2384zr.this.f12936.mo14660(true);
                    return;
                }
                C2384zr.this.f12931 = searchTrackableListSummary.getReferenceId();
                C2384zr.this.f12944 = new qN(searchTrackableListSummary, -1);
                C2384zr.this.f12936.mo14663(true);
                if (C2384zr.this.f12942 instanceof C0338) {
                    ((C0338) C2384zr.this.f12942).f12983.addAll(qaVar.getResultsCollection());
                    m13806(qaVar.getResultsCollection());
                    C2384zr.this.f12942.notifyItemChanged(C2384zr.this.f12943 ? 3 : 1);
                    int length = searchTrackableListSummary.getLength() - 1;
                    C2384zr.this.f12933 = C2384zr.this.f12945 < length;
                    if (C2384zr.this.f12933) {
                        C2384zr.this.f12941 = C2384zr.this.f12945 + 1;
                        C2384zr.this.f12945 += 15;
                        if (C2384zr.this.f12945 > length) {
                            C2384zr.this.f12945 = length;
                        }
                    }
                }
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void m13806(List<SearchCollectionEntity> list) {
            String[] strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strArr[i] = list.get(i).getId();
            }
            C2387zt.m13822(this.f12980, C2384zr.this.getActivity(), AppView.suggestionResults, C2384zr.this.f12931, strArr, C2384zr.this.f12941, C2384zr.this.f12945, AppView.suggestionResults);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.presearch_frag_ab8274, (ViewGroup) null);
        this.f12936 = new C0616(inflate, new C0567.Cif() { // from class: o.zr.3
            @Override // o.C0567.Cif
            public void N_() {
                C2384zr.this.m13782(C2384zr.this.m14536());
            }
        });
        this.f12938 = (RecyclerView) inflate.findViewById(R.id.presearch_frag_list);
        this.f12934 = (TextView) inflate.findViewById(R.id.presearch_message);
        this.f12935 = inflate.findViewById(R.id.loading_view);
        this.f12936.mo14663(false);
        return inflate;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m13776() {
        if (Config_Ab8274.m504(getActivity()) == Config_Ab8274.ListType.SEARCH_HISTORY) {
            m13784();
        } else {
            m13781();
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public boolean m13785() {
        return this.f12942 instanceof C0338;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m13781() {
        if (!(this.f12942 instanceof C0338)) {
            this.f12942 = new C0338();
            this.f12938.setAdapter(this.f12942);
            this.f12938.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.f12934.setVisibility(8);
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m13784() {
        if (!(this.f12942 instanceof C2385iF)) {
            m13758();
        }
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private List<SearchUtils.SuggestionType> m13778() {
        ArrayList arrayList = new ArrayList();
        if (Config_Ab8274.m508(getActivity())) {
            arrayList.add(SearchUtils.SuggestionType.SEARCH_HISTORY);
        }
        if (Config_Ab8274.m507(getActivity())) {
            arrayList.add(SearchUtils.SuggestionType.BROWSE_HISTORY);
        }
        return arrayList;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m13758() {
        if (Config_Ab8274.m507(getActivity()) || Config_Ab8274.m508(getActivity())) {
            if (this.f12930 == null) {
                this.f12930 = C2379zm.m13712(getActivity());
            }
            if (this.f12939 != null) {
                this.f12939.close();
            }
            this.f12939 = this.f12930.rawQuery(C2379zm.m13713(m14534(), m13778()), null);
            this.f12942 = new C2385iF(this.f12939);
            if (this.f12939.getCount() == 0) {
                this.f12934.setVisibility(0);
            } else {
                this.f12934.setVisibility(8);
            }
            this.f12938.setAdapter(this.f12942);
            this.f12938.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m13780() {
        Cursor r3;
        if (Config_Ab8274.m507(getActivity()) || Config_Ab8274.m508(getActivity())) {
            if (this.f12930 == null) {
                this.f12930 = C2379zm.m13712(getActivity());
            }
            if (this.f12939 != null) {
                this.f12939.close();
            }
            this.f12939 = this.f12930.rawQuery(C2379zm.m13713(m14534(), m13778()), null);
            if (this.f12939.getCount() == 0) {
                this.f12934.setVisibility(0);
            } else {
                this.f12934.setVisibility(8);
            }
            if ((this.f12942 instanceof C2385iF) && (r3 = ((C2385iF) this.f12942).m13799(this.f12939)) != null) {
                r3.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zr$if  reason: invalid class name */
    public class Cif extends RecyclerView.Adapter {

        /* renamed from: ʼ  reason: contains not printable characters */
        private int f12962;

        /* renamed from: ˊ  reason: contains not printable characters */
        int f12963;

        /* renamed from: ˋ  reason: contains not printable characters */
        boolean f12964;

        /* renamed from: ˎ  reason: contains not printable characters */
        List<AbstractC2074pw> f12965;

        /* renamed from: ˏ  reason: contains not printable characters */
        int f12966;

        private Cif() {
            this.f12962 = -1;
            this.f12965 = new ArrayList();
            this.f12966 = 0;
            this.f12963 = 5;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.zr$if$If */
        public class If extends RecyclerView.ViewHolder {

            /* renamed from: ˊ  reason: contains not printable characters */
            TextView f12974;

            /* renamed from: ˋ  reason: contains not printable characters */
            View f12975;

            /* renamed from: ˎ  reason: contains not printable characters */
            C0522 f12976;

            /* renamed from: ˏ  reason: contains not printable characters */
            View f12977;

            /* renamed from: ॱ  reason: contains not printable characters */
            ProgressBar f12978;

            public If(View view) {
                super(view);
                this.f12976 = (C0522) view.findViewById(R.id.presearch_CW_boxArt);
                this.f12978 = (ProgressBar) view.findViewById(R.id.cw_view_video_progress);
                this.f12975 = view.findViewById(R.id.cw_view_video_info);
                this.f12974 = (TextView) view.findViewById(R.id.cw_view_video_title);
                this.f12977 = view.findViewById(R.id.presearch_CW_boxArt_group);
                Cif.this.f12962 = (AD.m3317(C2384zr.this.getActivity()) / uH.m11417(C2384zr.this.getActivity())) - (C2384zr.this.getActivity().getResources().getDimensionPixelSize(R.dimen.content_padding) * 2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new If(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.presearch_cw_view_ab8274, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            m13804((If) viewHolder, i);
            m13800((If) viewHolder, i);
            m13803((If) viewHolder, i);
            m13802((If) viewHolder, i);
            if (i == this.f12966 - 1) {
                m13805();
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m13802(If r7, int i) {
            String str;
            if (r7.f12974 != null) {
                FragmentActivity activity = C2384zr.this.getActivity();
                AbstractC2074pw pwVar = this.f12965.get(i);
                if (pwVar != null) {
                    if (pwVar.getType() != VideoType.SHOW) {
                        str = BD.m3838(pwVar.getRuntime(), activity);
                    } else if (pwVar.isEpisodeNumberHidden()) {
                        str = "";
                    } else {
                        str = activity.getString(R.string.label_season_and_episode_abbreviated, pwVar.getSeasonAbbrSeqLabel(), Integer.valueOf(pwVar.getEpisodeNumber()));
                    }
                    r7.f12974.setText(str);
                }
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private void m13804(If r10, int i) {
            if (r10.f12976 != null) {
                AbstractC2074pw pwVar = this.f12965.get(i);
                if (C1349Bv.m4107(pwVar.getBoxshotUrl())) {
                    NetflixActivity.getImageLoader(C2384zr.this.getActivity()).mo3063(r10.f12976, pwVar.getBoxshotUrl(), AssetType.boxArt, pwVar.getTitle(), BrowseExperience.m1769(), false, 1);
                }
                r10.f12977.getLayoutParams().width = this.f12962;
                r10.f12977.getLayoutParams().height = (int) (((float) this.f12962) * 1.333f);
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m13800(If r4, int i) {
            if (r4.f12976 != null) {
                final AbstractC2074pw pwVar = this.f12965.get(i);
                r4.f12976.setOnClickListener(new View.OnClickListener() { // from class: o.zr.if.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        oX oXVar = qN.f9510;
                        oXVar.mo9594(PlayLocationType.STORY_ART);
                        PlaybackLauncher.m1605((NetflixActivity) C2384zr.this.getActivity(), pwVar, pwVar.getType(), oXVar, -1);
                    }
                });
                r4.f12975.setOnClickListener(new View.OnClickListener() { // from class: o.zr.if.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        oX oXVar = qN.f9510;
                        oXVar.mo9594(PlayLocationType.DIRECT_PLAY);
                        qU.m9975(C2384zr.this.m14534(), pwVar, oXVar, "", (Bundle) null);
                    }
                });
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m13803(If r5, int i) {
            if (r5.f12978 != null) {
                AbstractC2074pw pwVar = this.f12965.get(i);
                r5.f12978.setProgress(uC.m11326(pwVar.getRuntime(), pwVar.getPlayableBookmarkPosition()));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f12965 == null) {
                return 0;
            }
            return this.f12965.size();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m13805() {
            if (C2384zr.this.m14536() != null && !this.f12964) {
                this.f12964 = true;
                C2384zr.this.m14536().m9764().mo9489(this.f12966, this.f12963, (String) null, new oP("SearchCWAdapter") { // from class: o.zr.if.5
                    @Override // o.oP, o.oU
                    public void onCWVideosFetched(List<AbstractC2074pw> list, Status status) {
                        super.onCWVideosFetched(list, status);
                        if (status.mo298()) {
                            Cif.this.f12965.addAll(list);
                            if (Cif.this.f12965.size() == 0) {
                                C2384zr.this.f12942.notifyDataSetChanged();
                                C2384zr.this.f12943 = false;
                            } else {
                                C2384zr.this.f12943 = true;
                            }
                            Cif.this.notifyDataSetChanged();
                            Cif.this.f12964 = false;
                            Cif.this.f12966 = Cif.this.f12963 + 1;
                            Cif.this.f12963 += 6;
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zr$iF  reason: case insensitive filesystem */
    public class C2385iF extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: ॱ  reason: contains not printable characters */
        Cursor f12957;

        C2385iF(Cursor cursor) {
            this.f12957 = cursor;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new If(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.presearch_view_ab8274_recents, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int i) {
            this.f12957.moveToPosition(i);
            String string = this.f12957.getString(this.f12957.getColumnIndex("suggest_text_1"));
            String string2 = this.f12957.getString(this.f12957.getColumnIndex("falkorId"));
            String string3 = this.f12957.getString(this.f12957.getColumnIndex("entityId"));
            String string4 = this.f12957.getString(this.f12957.getColumnIndex("saveType"));
            String string5 = this.f12957.getString(this.f12957.getColumnIndex("entityType"));
            String string6 = this.f12957.getString(this.f12957.getColumnIndex("suggestionType"));
            ((If) viewHolder).m13795(string);
            ((If) viewHolder).m13793(string4);
            ((If) viewHolder).m13797(string5);
            ((If) viewHolder).m13789(string2);
            ((If) viewHolder).m13791(string3);
            ((If) viewHolder).m13798(string6);
            ((If) viewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: o.zr.iF.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C2384zr.this.m13775((If) viewHolder);
                }
            });
            ((If) viewHolder).f12950.setOnClickListener(new View.OnClickListener() { // from class: o.zr.iF.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C2384zr.this.f12930.execSQL(C2379zm.m13714(C2384zr.this.m14534(), ((If) viewHolder).m13794()));
                    C2384zr.this.m13780();
                }
            });
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f12957 == null) {
                return 0;
            }
            return this.f12957.getCount();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public Cursor m13799(Cursor cursor) {
            if (this.f12957 == cursor) {
                return null;
            }
            Cursor cursor2 = this.f12957;
            this.f12957 = cursor;
            if (cursor != null) {
                notifyDataSetChanged();
            }
            return cursor2;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13775(If r15) {
        SearchUtils.SaveType saveType;
        if (!C1349Bv.m4113(r15.m13787())) {
            SearchUtils.SuggestionType valueOf = SearchUtils.SuggestionType.valueOf(r15.m13787());
            if (valueOf == SearchUtils.SuggestionType.SEARCH_HISTORY) {
                this.f12944 = qN.f9508;
            } else if (valueOf == SearchUtils.SuggestionType.BROWSE_HISTORY) {
                this.f12944 = qN.f9502;
            }
        }
        String r9 = r15.m13796();
        char c = 65535;
        switch (r9.hashCode()) {
            case -1278045179:
                if (r9.equals("prequery")) {
                    c = 2;
                    break;
                }
                break;
            case -991716523:
                if (r9.equals("person")) {
                    c = 0;
                    break;
                }
                break;
            case -241179889:
                if (r9.equals("related_to")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                saveType = SearchUtils.SaveType.SEARCH_PERSON;
                Intent intent = new Intent(getActivity(), ActivityC2392zx.m13837());
                intent.putExtra("PersonId", r15.m13794());
                intent.putExtra("Title", r15.m13788());
                intent.putExtra("TrackId", this.f12944.getTrackId());
                intent.putExtra("SearchResultType", AppView.peopleTitleResults.name());
                C2387zt.m13820(this.f12940, getActivity(), m13783(), r15.m13794(), ISearchLogging.InputMode.keyboard, ISearchLogging.SearchType.searchEntityId, true);
                startActivity(intent);
                break;
            case 1:
                saveType = SearchUtils.SaveType.SEARCH_RELATED_TO;
                break;
            case 2:
                saveType = SearchUtils.SaveType.PRE_QUERY_ENTITY;
                Intent intent2 = new Intent(getActivity(), ActivityC2392zx.m13837());
                intent2.putExtra("EntityId", r15.m13790());
                intent2.putExtra("Title", r15.m13788());
                intent2.putExtra("TrackId", this.f12944.getTrackId());
                intent2.putExtra("SearchResultType", AppView.suggestionTitleResults.name());
                C2387zt.m13820(this.f12940, getActivity(), m13783(), r15.m13790(), ISearchLogging.InputMode.keyboard, ISearchLogging.SearchType.searchEntityId, true);
                startActivity(intent2);
                break;
            default:
                saveType = SearchUtils.SaveType.m2931(r15.m13796());
                qU.m9966(m14534(), VideoType.create(r15.m13796()), r15.m13794(), "", this.f12944, "");
                break;
        }
        SearchUtils.m2914(r15.m13790(), r15.m13794(), r15.m13792(), r15.m13788(), saveType, SearchUtils.SuggestionType.BROWSE_HISTORY, m14534());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zr$ˋ  reason: contains not printable characters */
    public class C0338 extends RecyclerView.Adapter {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final int f12982;

        /* renamed from: ˎ  reason: contains not printable characters */
        List<SearchCollectionEntity> f12983;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final int f12984;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final int f12985;

        private C0338() {
            this.f12985 = 0;
            this.f12982 = 1;
            this.f12984 = 2;
            this.f12983 = new ArrayList();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return C2384zr.this.f12943 ? this.f12983.size() + 3 : this.f12983.size() + 1;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new C0339(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.presearch_titleheader_view_ab8274, viewGroup, false));
                case 1:
                    return new If(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.presearch_view_ab8274, viewGroup, false));
                case 2:
                    iF iFVar = new iF(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.presearch_cw_view_row_ab8274, viewGroup, false));
                    m13807(iFVar);
                    return iFVar;
                default:
                    return null;
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private void m13807(iF iFVar) {
            iFVar.f12988.setAdapter(C2384zr.this.f12932);
            iFVar.f12988.setLayoutManager(new LinearLayoutManager(C2384zr.this.getActivity(), 0, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int i) {
            int i2;
            String str;
            switch (viewHolder.getItemViewType()) {
                case 0:
                    if (C2384zr.this.f12943 && i == 0) {
                        str = C2384zr.this.getResources().getString(R.string.label_continue_watching);
                    } else if (Config_Ab8274.m504(C2384zr.this.getActivity()) == Config_Ab8274.ListType.TRENDING) {
                        str = C2384zr.this.getResources().getString(R.string.search_trending_label);
                    } else {
                        str = C2384zr.this.getResources().getString(R.string.search_popular_label);
                    }
                    ((C0339) viewHolder).m13808(str);
                    return;
                case 1:
                    if (C2384zr.this.f12943) {
                        i2 = i - 3;
                    } else {
                        i2 = i - 1;
                    }
                    ((If) viewHolder).m13795(this.f12983.get(i2).getDisplayString());
                    ((If) viewHolder).m13797(this.f12983.get(i2).getEntityType());
                    ((If) viewHolder).m13789(this.f12983.get(i2).getId());
                    if (VideoType.create(this.f12983.get(i2).getVideoType()) == VideoType.UNKNOWN) {
                        ((If) viewHolder).m13793(SearchUtils.SaveType.PRE_QUERY_ENTITY.m2932());
                    } else {
                        ((If) viewHolder).m13793(this.f12983.get(i2).getVideoType());
                    }
                    ((If) viewHolder).m13791(this.f12983.get(i2).getEntityId());
                    ((If) viewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: o.zr.ˋ.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            C2384zr.this.m13775((If) viewHolder);
                        }
                    });
                    if (i == C2384zr.this.f12941 - 1 && C2384zr.this.f12933) {
                        C2387zt.m13820(C2384zr.this.f12940, C2384zr.this.getActivity(), C2384zr.this.m13783(), C2384zr.this.f12937, ISearchLogging.InputMode.keyboard, ISearchLogging.SearchType.searchEntityId, true);
                        C2384zr.this.m13763();
                        return;
                    }
                    return;
                case 2:
                    ((iF) viewHolder).f12988.getAdapter().notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return C2384zr.this.f12943 ? 2 : 1;
                case 2:
                    return C2384zr.this.f12943 ? 0 : 1;
                default:
                    return 1;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.zr$ˋ$iF */
        public class iF extends RecyclerView.ViewHolder {

            /* renamed from: ˊ  reason: contains not printable characters */
            RecyclerView f12988;

            public iF(View view) {
                super(view);
                this.f12988 = (RecyclerView) view.findViewById(R.id.presearch_CW);
            }
        }

        /* renamed from: o.zr$ˋ$ˊ  reason: contains not printable characters */
        class C0339 extends RecyclerView.ViewHolder {

            /* renamed from: ˋ  reason: contains not printable characters */
            TextView f12991;

            public C0339(View view) {
                super(view);
                this.f12991 = (TextView) view.findViewById(R.id.presearch_view_title_header);
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            public void m13808(String str) {
                if (this.f12991 != null) {
                    this.f12991.setText(str);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zr$If */
    public class If extends RecyclerView.ViewHolder {

        /* renamed from: ʻ  reason: contains not printable characters */
        private String f12947;

        /* renamed from: ʼ  reason: contains not printable characters */
        private String f12948;

        /* renamed from: ˋ  reason: contains not printable characters */
        TextView f12950;

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f12951;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f12952;

        /* renamed from: ॱ  reason: contains not printable characters */
        TextView f12953;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private String f12954;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private String f12955;

        public If(View view) {
            super(view);
            this.f12953 = (TextView) view.findViewById(R.id.presearch_view_value);
            this.f12950 = (TextView) view.findViewById(R.id.presearch_view_close);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void m13795(String str) {
            if (this.f12953 != null) {
                this.f12954 = str;
                this.f12953.setText(str);
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public String m13792() {
            return this.f12951;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public String m13790() {
            return this.f12955;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m13796() {
            return this.f12952;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public String m13788() {
            return this.f12954;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void m13797(String str) {
            this.f12951 = str;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m13793(String str) {
            this.f12952 = str;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public String m13794() {
            return this.f12948;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m13789(String str) {
            this.f12948 = str;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m13791(String str) {
            this.f12955 = str;
        }

        /* renamed from: ʻ  reason: contains not printable characters */
        public String m13787() {
            return this.f12947;
        }

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public void m13798(String str) {
            this.f12947 = str;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0517
    /* renamed from: ˊ */
    public void mo2213(View view) {
        if (this.f12936 != null) {
            this.f12936.mo14659(0, this.f13649 + this.f13651, 0, this.f13650);
        }
        C1004.m15952(this.f12938, 1, this.f13649 + this.f13651);
        C1004.m15952(this.f12938, 3, this.f13650);
    }
}
