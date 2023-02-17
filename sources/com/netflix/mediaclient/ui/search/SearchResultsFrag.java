package com.netflix.mediaclient.ui.search;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.ui.search.SearchUtils;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import o.AD;
import o.AbstractC0517;
import o.AbstractC2080qa;
import o.AbstractC2083qd;
import o.AbstractC2084qe;
import o.AbstractC2086qg;
import o.C0584;
import o.C0621;
import o.C0810;
import o.C1004;
import o.C1276;
import o.C1283;
import o.C1349Bv;
import o.C2059ph;
import o.C2386zs;
import o.C2387zt;
import o.C2394zz;
import o.oP;
import o.oX;
import o.qM;
import o.qN;
import o.qX;
public class SearchResultsFrag extends AbstractC0517 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Stack<C2386zs> f3872 = new Stack<>();

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private C0584 f3873;

    /* renamed from: ʼ  reason: contains not printable characters */
    private SearchCategory f3874 = SearchCategory.VIDEOS;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private ProgressBar f3875;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1294iF f3876;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private TextView f3877;

    /* renamed from: ʾ  reason: contains not printable characters */
    private TextView f3878;

    /* renamed from: ʿ  reason: contains not printable characters */
    private AbstractC2080qa f3879;

    /* renamed from: ˈ  reason: contains not printable characters */
    private int f3880;

    /* renamed from: ˉ  reason: contains not printable characters */
    private TextView f3881;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private String f3882 = "";

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private int f3883;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C1294iF f3884;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private int f3885;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private int f3886;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C0810 f3887;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private String f3888;

    /* renamed from: ˏ  reason: contains not printable characters */
    HashMap<View, String> f3889 = new HashMap<>();

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private C0810 f3890;

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f3891 = -1;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private AbstractC2086qg f3892;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final If f3893 = new If();

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private C0621 f3894;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    HashMap<View, Long> f3895 = new HashMap<>();

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C0621 f3896;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private qM f3897;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private String f3898;

    public enum SearchCategory {
        SUGGESTIONS,
        VIDEOS
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(SearchUtils.m2911(), (ViewGroup) null);
        m2856(inflate);
        m2868();
        this.f3893.m2900(bundle);
        if (this.f3891 == -1) {
            m2870();
        }
        m2830();
        m2876();
        return inflate;
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        this.f3893.m2901(bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        m2885();
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z && this.f3879 != null) {
            m2879();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m2856(View view) {
        this.f3887 = (C0810) view.findViewById(R.id.search_results_grid_view_suggestions);
        this.f3873 = (C0584) view.findViewById(R.id.search_results_flowlayout_suggestions);
        this.f3890 = (C0810) view.findViewById(R.id.search_results_grid_view_videos);
        this.f3878 = (TextView) view.findViewById(R.id.search_results_label_suggestions);
        this.f3894 = (C0621) view.findViewById(R.id.search_results_scrollview2);
        this.f3896 = (C0621) view.findViewById(R.id.search_results_scrollview);
        this.f3877 = (TextView) view.findViewById(R.id.similar_items_grid_view_title);
        this.f3881 = (TextView) view.findViewById(R.id.search_results_label_videos);
        this.f3875 = (ProgressBar) view.findViewById(R.id.loading_view);
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m2868() {
        Locale locale = Locale.getDefault();
        if (this.f3878 != null) {
            this.f3878.setText(SearchUtils.m2929() ? getString(R.string.label_suggestions_search_title).toUpperCase(locale) : getString(R.string.label_suggestions_search_title));
        }
        if (this.f3881 != null) {
            this.f3881.setText(getString(R.string.label_movies_and_tv_search_title).toUpperCase(locale));
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m2870() {
        if (this.f3890 != null) {
            if (this.f3891 == -1) {
                this.f3890.setAdapter((ListAdapter) null);
                this.f3884 = new C1294iF(SearchCategory.VIDEOS, false);
                this.f3890.setAdapter((ListAdapter) this.f3884);
                this.f3890.setOnItemClickListener(this.f3884);
            }
            if (!SearchUtils.m2923()) {
                m2835();
            }
            m2875(this.f3890);
            this.f3890.setNumColumns(SearchUtils.m2919(getActivity()));
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m2876() {
        m2845();
        m2881();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m2845() {
        if (this.f3896 != null) {
            this.f3896.setOnTouchListener(new Cif());
        }
        if (this.f3894 != null) {
            this.f3894.setOnTouchListener(new Cif());
        }
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m2881() {
        C0046 r1 = new C0046();
        if (this.f3896 != null) {
            this.f3896.setOnScrollStopListener(r1);
        }
        if (this.f3894 != null) {
            this.f3894.setOnScrollStopListener(r1);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private void m2883() {
        Pair<Integer, Integer> r11;
        AppView appView;
        if (!(this.f3879 == null || this.f3890 == null || this.f3890.getCount() <= 0 || (r11 = ViewUtils.m3016(this.f3890, this.f3896)) == null)) {
            AbstractC2086qg videosListTrackable = this.f3879.getVideosListTrackable();
            int intValue = ((Integer) r11.first).intValue();
            int intValue2 = ((Integer) r11.second).intValue();
            switch (this.f3874) {
                case SUGGESTIONS:
                    appView = AppView.suggestionTitleResults;
                    break;
                default:
                    appView = AppView.titleResults;
                    break;
            }
            C2387zt.m13819(1, getActivity(), AppView.searchResults, m2861(this.f3874 == SearchCategory.VIDEOS ? videosListTrackable : this.f3892), null, intValue, intValue2, appView);
            if (this.f3890 != null) {
                int numColumns = this.f3890.getNumColumns();
                for (int i = intValue; i <= intValue2; i++) {
                    int i2 = i / numColumns;
                    int i3 = i % numColumns;
                    AbstractC2084qe resultsVideos = this.f3879.getResultsVideos(i);
                    if (resultsVideos != null) {
                        C2387zt.m13814(appView, videosListTrackable, null, resultsVideos.getId(), i2, i3);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m2879() {
        m2883();
        if (!(this.f3879 == null || this.f3887 == null || this.f3887.getCount() <= 0)) {
            AbstractC2086qg suggestionsListTrackable = this.f3879.getSuggestionsListTrackable();
            String r12 = m2861(suggestionsListTrackable);
            Pair<Integer, Integer> r13 = ViewUtils.m3016(this.f3887, this.f3896);
            if (r13 != null) {
                int intValue = ((Integer) r13.first).intValue();
                int intValue2 = ((Integer) r13.second).intValue();
                C2387zt.m13819(1, getActivity(), AppView.searchResults, r12, null, intValue, intValue2, AppView.suggestionResults);
                int numColumns = this.f3887.getNumColumns();
                for (int i = intValue; i <= intValue2; i++) {
                    m2839(AppView.suggestionResults, suggestionsListTrackable, i, numColumns, this.f3879.getResultsSuggestions(i).getEntityId(), null);
                }
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m2839(AppView appView, AbstractC2086qg qgVar, int i, int i2, String str, String str2) {
        if (str == null && str2 == null) {
            C1276.m16820().mo5725("CLv2 reportPresentedEvent");
        } else {
            C2387zt.m13814(appView, qgVar, str, str2, i / i2, i % i2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m2828() {
        if (this.f3879 != null) {
            if (this.f3890 == null || this.f3890.getCount() <= 0) {
                C2387zt.m13813(AppView.titleResults);
            } else {
                C2387zt.m13815(AppView.titleResults, null, this.f3882, m2861(this.f3879.getVideosListTrackable()), null);
            }
            if (this.f3887 == null || this.f3887.getCount() <= 0) {
                C2387zt.m13813(AppView.suggestionResults);
            } else {
                C2387zt.m13815(AppView.suggestionResults, null, this.f3882, m2861(this.f3879.getSuggestionsListTrackable()), null);
            }
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m2885() {
        C2387zt.m13813(AppView.titleResults);
        C2387zt.m13813(AppView.suggestionResults);
        for (Long l : this.f3895.values()) {
            if (l != null) {
                Logger.INSTANCE.m140(l);
            }
        }
        this.f3895.clear();
        this.f3889.clear();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m2862(Rect rect, View view) {
        String str;
        AppView appView;
        if (this.f3879 != null && view != null) {
            if (view == this.f3890) {
                appView = AppView.titleResults;
                str = m2861(this.f3879.getVideosListTrackable());
            } else if (view == this.f3887) {
                appView = AppView.suggestionResults;
                str = m2861(this.f3879.getSuggestionsListTrackable());
            } else {
                return;
            }
            Rect rect2 = new Rect();
            view.getGlobalVisibleRect(rect2);
            boolean z = (rect2.top >= rect.top && rect2.top < rect.bottom) || (rect2.bottom > rect.top && rect2.bottom <= rect.bottom);
            Long l = this.f3895.get(view);
            if (z) {
                if (l != null && !TextUtils.equals(str, this.f3889.get(view))) {
                    Logger.INSTANCE.m140(l);
                    l = null;
                }
                if (l == null) {
                    this.f3895.put(view, C2387zt.m13825(appView, str));
                    this.f3889.put(view, str);
                }
            } else if (l != null) {
                Logger.INSTANCE.m140(l);
                this.f3895.put(view, null);
                this.f3889.put(view, null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.ui.search.SearchResultsFrag$ˊ  reason: contains not printable characters */
    public class C0046 implements C0621.If {
        C0046() {
        }

        @Override // o.C0621.If
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo2907() {
            SearchResultsFrag.this.m2834();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʿ  reason: contains not printable characters */
    private void m2834() {
        if (this.f3896 != null) {
            Rect rect = new Rect();
            this.f3896.getGlobalVisibleRect(rect);
            m2862(rect, this.f3890);
            m2862(rect, this.f3887);
        }
        m2879();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m2861(AbstractC2086qg qgVar) {
        if (qgVar != null) {
            return qgVar.getReferenceId();
        }
        return null;
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private void m2830() {
        if (this.f3887 != null) {
            this.f3887.setAdapter((ListAdapter) null);
            this.f3876 = new C1294iF(SearchCategory.SUGGESTIONS, !SearchUtils.m2923());
            this.f3887.setAdapter((ListAdapter) this.f3876);
            if (!SearchUtils.m2923()) {
                m2835();
            }
            this.f3887.setNumColumns(SearchUtils.m2912(getActivity()));
        }
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    private void m2835() {
        if (this.f3887 != null) {
            this.f3887.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.netflix.mediaclient.ui.search.SearchResultsFrag.2
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (view != null && (view instanceof C2394zz)) {
                        SearchResultsFrag.this.m2874((C2394zz) view, i, j);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2874(C2394zz zzVar, int i, long j) {
        this.f3891 = i;
        m2852();
        m2832();
        m2871(zzVar);
        if (C1349Bv.m4107(zzVar.m13891())) {
            m2863(zzVar);
            m2866(zzVar.m13891());
            m2864(SearchCategory.SUGGESTIONS, zzVar, i, j);
            if (this.f3875 != null) {
                this.f3875.setVisibility(0);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m2864(SearchCategory searchCategory, View view, int i, long j) {
        Object tag = view.getTag(R.id.ignore_item_click_history);
        if ((tag == null || ((Boolean) tag) == Boolean.FALSE) && (this.f3872.size() == 0 || (this.f3872.size() > 0 && this.f3872.peek().f12995 != i))) {
            this.f3872.push(new C2386zs(searchCategory, i, j, ((C2394zz) view).m13887()));
        }
        view.setTag(R.id.ignore_item_click_history, Boolean.TRUE);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m2863(View view) {
        this.f3898 = ((C2394zz) view).m13887();
        if (this.f3877 != null && C1349Bv.m4107(this.f3898)) {
            this.f3877.setVisibility(0);
            this.f3877.setText(this.f3898);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private String m2871(View view) {
        C2394zz zzVar = (C2394zz) view;
        String r1 = zzVar.m13889();
        zzVar.setTitleTextWithSelectdHighlighting();
        return r1;
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private void m2832() {
        m2843();
        m2833();
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private void m2833() {
        if (this.f3873 != null) {
            for (int i = 0; i < this.f3873.getChildCount(); i++) {
                ((C2394zz) this.f3873.getChildAt(i)).m13888();
            }
        }
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private void m2843() {
        if (this.f3887 != null) {
            for (int i = 0; i < this.f3887.getCount(); i++) {
                ((C2394zz) this.f3887.getChildAt(i)).m13888();
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2875(final C0810 r3) {
        r3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.netflix.mediaclient.ui.search.SearchResultsFrag.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SearchResultsFrag.this.m2828();
                SearchResultsFrag.this.m2834();
                ViewUtils.m3009(r3, this);
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2850(final C0810 r3) {
        r3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.netflix.mediaclient.ui.search.SearchResultsFrag.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SearchResultsFrag.this.m2883();
                if (r3.getCount() > 0) {
                    ViewUtils.m3009(r3, this);
                }
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m2886(AbstractC2080qa qaVar, String str) {
        C1283.m16846("SearchResultsFrag", "Updating...");
        this.f3879 = qaVar;
        if (this.f3879 != null && getActivity() != null) {
            if (SearchUtils.m2916() == SearchUtils.SearchExperience.TABLET && AD.m3307(getActivity())) {
                ViewUtils.m3002(this.f3896, this.f3879.getNumResultsSuggestions() > 0);
            }
            this.f3874 = SearchCategory.VIDEOS;
            if (this.f3875 != null) {
                this.f3875.setVisibility(8);
            }
            if (this.f3882.compareToIgnoreCase(str) != 0) {
                this.f3882 = str;
                m2888();
            }
            if (this.f3877 != null) {
                this.f3877.setVisibility(8);
            }
            m2851();
            m2842();
            m2854();
            m2836();
            m2858(str);
            m2859();
            m2846();
            if (this.f3875 != null) {
                this.f3875.setVisibility(8);
            }
            m2889(this.f3879.getResultsVideos());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m2889(List<AbstractC2084qe> list) {
        qX.m10011(m14536(), list);
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private void m2851() {
        if (getActivity() != null && this.f3896 != null) {
            int r4 = AD.m3317(getActivity()) - ((this.f3896.getVisibility() != 0 || this.f3896.getWidth() == AD.m3317(getActivity())) ? 0 : this.f3896.getWidth());
            int r5 = SearchUtils.m2919(getActivity());
            if (r5 > 0) {
                this.f3886 = r4 / r5;
                this.f3883 = (int) ((((double) (r4 / r5)) * SearchUtils.m2918()) + 0.5d);
                C1283.m16846("SearchResultsFrag", "imgHeight: " + this.f3883);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m2858(String str) {
        if (this.f3873 != null) {
            this.f3873.removeAllViews();
            int min = Math.min(this.f3879.getNumResultsSuggestions(), SearchUtils.m2927(getActivity()));
            for (final int i = 0; i < min; i++) {
                AbstractC2086qg suggestionsListTrackable = this.f3879.getSuggestionsListTrackable();
                qN qNVar = new qN(suggestionsListTrackable, i);
                AbstractC2083qd resultsSuggestions = this.f3879.getResultsSuggestions(i);
                C2394zz zzVar = new C2394zz(getActivity(), SearchUtils.m2926(), qNVar, 0, i);
                zzVar.m13890(resultsSuggestions, qNVar, str, suggestionsListTrackable.getReferenceId());
                this.f3873.addView(zzVar, this.f3873.generateDefaultLayoutParams());
                zzVar.setOnClickListener(new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.search.SearchResultsFrag.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null && (view instanceof C2394zz)) {
                            SearchResultsFrag.this.m2874((C2394zz) view, i, 0);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m2888() {
        this.f3872.clear();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m2890() {
        this.f3891 = -1;
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private void m2836() {
        if (this.f3891 == -1) {
            m2870();
        }
        m2830();
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m2846() {
        if (this.f3896 != null) {
            this.f3896.scrollTo(0, 0);
        }
        if (this.f3894 != null) {
            this.f3894.scrollTo(0, 0);
        }
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private void m2842() {
        this.f3880 = SearchUtils.m2927(getActivity());
        this.f3885 = SearchUtils.m2921(getActivity());
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private void m2859() {
        if (this.f3884 != null) {
            this.f3884.m2906(this.f3885);
            this.f3884.notifyDataSetChanged();
        }
        if (this.f3876 != null) {
            this.f3876.m2906(this.f3880);
            this.f3876.notifyDataSetChanged();
        }
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    private void m2854() {
        ViewUtils.m3002(this.f3881, this.f3879.getNumResultsVideos() > 0);
        ViewUtils.m3002(this.f3878, this.f3879.getNumResultsSuggestions() > 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.ui.search.SearchResultsFrag$iF  reason: case insensitive filesystem */
    public class C1294iF extends BaseAdapter implements AdapterView.OnItemClickListener, ListAdapter {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final boolean f3917;

        /* renamed from: ˋ  reason: contains not printable characters */
        private int f3918;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final SearchCategory f3919;

        /* renamed from: ˏ  reason: contains not printable characters */
        private int f3920;

        public C1294iF(SearchCategory searchCategory, boolean z) {
            this.f3919 = searchCategory;
            this.f3917 = z;
            m2902();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m2902() {
            switch (this.f3919) {
                case SUGGESTIONS:
                    this.f3920 = SearchUtils.m2926();
                    return;
                default:
                    this.f3920 = R.layout.search_result_view;
                    return;
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m2906(int i) {
            this.f3918 = i;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int i;
            if (SearchResultsFrag.this.f3879 != null) {
                switch (this.f3919) {
                    case SUGGESTIONS:
                        i = SearchResultsFrag.this.f3879.getNumResultsSuggestions();
                        break;
                    case VIDEOS:
                        i = SearchResultsFrag.this.f3879.getNumResultsVideos();
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            return Math.min(i, this.f3918);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return SearchResultsFrag.m2847(SearchResultsFrag.this.f3879, this.f3919, i);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private AbstractC2086qg m2903() {
            if (SearchResultsFrag.this.f3879 == null) {
                return null;
            }
            switch (this.f3919) {
                case SUGGESTIONS:
                    return SearchResultsFrag.this.f3879.getSuggestionsListTrackable();
                case VIDEOS:
                    return SearchResultsFrag.this.f3879.getVideosListTrackable();
                default:
                    return null;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003a: APUT  (r1v4 java.lang.Object[]), (0 ??[int, short, byte, char]), (r2v3 java.lang.String) */
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            AbstractC2086qg r4 = m2903();
            qN qNVar = new qN(r4, i);
            if (view == null || !(view instanceof C2394zz)) {
                view = m2904(qNVar, i);
            }
            Object item = getItem(i);
            if (this.f3919 != SearchCategory.SUGGESTIONS || (item instanceof AbstractC2083qd)) {
                ((C2394zz) view).m13890(item, qNVar, SearchResultsFrag.this.f3882, r4.getReferenceId());
            } else {
                Object[] objArr = new Object[1];
                objArr[0] = SearchResultsFrag.this.f3882 != "" ? SearchResultsFrag.this.f3882 : "null";
                C1276.m16820().mo5725(String.format("SPY-8015 - bad search query  %s", objArr));
            }
            return view;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private View m2904(oX oXVar, int i) {
            NetflixActivity netflixActivity = (NetflixActivity) SearchResultsFrag.this.getActivity();
            int numColumns = SearchResultsFrag.this.f3890.getNumColumns();
            C2394zz zzVar = new C2394zz(netflixActivity, this.f3920, oXVar, i / numColumns, i % numColumns);
            m2905(zzVar);
            if (this.f3917) {
                zzVar.setIgnoreClicks();
            }
            return zzVar;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private void m2905(C2394zz zzVar) {
            switch (this.f3919) {
                case VIDEOS:
                    zzVar.setLayoutParams(new AbsListView.LayoutParams(SearchResultsFrag.this.f3886, SearchResultsFrag.this.f3883));
                    return;
                default:
                    return;
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (SearchResultsFrag.this.f3875 != null) {
                SearchResultsFrag.this.f3875.setVisibility(0);
            }
            view.performClick();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Object m2847(AbstractC2080qa qaVar, SearchCategory searchCategory, int i) {
        if (qaVar == null) {
            return null;
        }
        switch (searchCategory) {
            case SUGGESTIONS:
                return qaVar.getResultsSuggestions(i);
            case VIDEOS:
                return qaVar.getResultsVideos(i);
            default:
                return null;
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.ui.search.SearchResultsFrag$ˋ  reason: contains not printable characters */
    public class C0047 extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final long f3924;

        /* renamed from: ˋ  reason: contains not printable characters */
        SearchCategory f3925;

        C0047(long j, SearchCategory searchCategory) {
            super("FetchSearchSimsByEntity");
            this.f3924 = j;
            this.f3925 = searchCategory;
        }

        @Override // o.oP, o.oU
        public void onSearchResultsFetched(AbstractC2080qa qaVar, Status status) {
            super.onSearchResultsFetched(qaVar, status);
            if (status.mo301()) {
                C1283.m16865("FetchSearchSimsByEntity", "Invalid status code");
                ((SearchActivity) SearchResultsFrag.this.getActivity()).m2820();
                return;
            }
            AbstractC2086qg videosListTrackable = qaVar.getVideosListTrackable();
            if (videosListTrackable != null && qaVar.getResultsCollection() != null) {
                List<AbstractC2084qe> resultsVideos = qaVar.getResultsVideos();
                if (resultsVideos == null || resultsVideos.size() < 1) {
                    C1283.m16846("FetchSearchSimsByEntity", "No details in response");
                    ((SearchActivity) SearchResultsFrag.this.getActivity()).m2820();
                    return;
                }
                SearchResultsFrag.this.f3888 = videosListTrackable.getReferenceId();
                if (SearchResultsFrag.this.f3897 != null) {
                    SearchResultsFrag.this.f3874 = this.f3925;
                    SearchResultsFrag.this.f3892 = qaVar.getVideosListTrackable();
                    SearchResultsFrag.this.f3897.m9925(resultsVideos, SearchResultsFrag.this.f3892);
                }
                if (SearchResultsFrag.this.f3875 != null) {
                    SearchResultsFrag.this.f3875.setVisibility(8);
                }
                SearchResultsFrag.this.m2879();
                SearchResultsFrag.this.m2889(resultsVideos);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m2866(String str) {
        C2059ph r8 = m14536();
        if (r8 == null) {
            C1283.m16865("SearchResultsFrag", "Manager is null/notReady - can't load data");
            return;
        }
        this.f3897 = new qM(getActivity(), this.f3890, false);
        if (this.f3890 != null) {
            this.f3890.setAdapter((ListAdapter) this.f3897);
            m2850(this.f3890);
        }
        r8.m9764().mo9509(str, CmpTaskMode.FROM_CACHE_OR_NETWORK, 0, 38, AD.m3299(), new C0047(System.nanoTime(), SearchCategory.SUGGESTIONS));
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public boolean m2887() {
        while (!this.f3872.isEmpty()) {
            C2386zs pop = this.f3872.pop();
            if (pop.f12992 != null && this.f3898 != null && pop.f12992.compareToIgnoreCase(this.f3898) != 0) {
                View view = null;
                C0810 r5 = null;
                if (pop.f12994 != SearchCategory.SUGGESTIONS) {
                    return false;
                }
                if (this.f3887 != null) {
                    view = this.f3887.getChildAt(pop.f12995);
                    r5 = this.f3887;
                } else if (!(this.f3873 == null || (view = this.f3873.getChildAt(pop.f12995)) == null)) {
                    view.performClick();
                }
                if (r5 == null) {
                    return true;
                }
                r5.performItemClick(view, pop.f12995, pop.f12993);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.ui.search.SearchResultsFrag$if  reason: invalid class name */
    public class Cif implements View.OnTouchListener {
        Cif() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            SearchResultsFrag.this.m2852();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋˋ  reason: contains not printable characters */
    private void m2852() {
        View currentFocus;
        if (getActivity() != null && (currentFocus = getActivity().getCurrentFocus()) != null && (currentFocus instanceof EditText)) {
            AD.m3310(getActivity(), (EditText) currentFocus);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0517
    /* renamed from: ˊ */
    public void mo2213(View view) {
        m2849(view.findViewById(R.id.vertical_layout));
        m2849(view.findViewById(R.id.vertical_layout2));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2849(View view) {
        C1004.m15952(view, 1, this.f13649 + this.f13651);
        C1004.m15952(view, 3, this.f13650);
    }

    class If {
        If() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public void m2900(Bundle bundle) {
            m2896(bundle);
            m2895(bundle);
            m2891(bundle);
            m2897(bundle);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m2896(Bundle bundle) {
            if (bundle != null) {
                m2893(bundle, SearchResultsFrag.this.f3887, "instance_state_suggestions_selected_pos");
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m2895(Bundle bundle) {
            if (bundle != null) {
                m2894(bundle, SearchResultsFrag.this.f3873, "instance_state_suggestions_selected_pos");
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private void m2894(Bundle bundle, final C0584 r7, String str) {
            final int i;
            if (bundle != null && r7 != null && bundle.containsKey(str) && (i = bundle.getInt(str, -1)) != -1) {
                if (r7 == SearchResultsFrag.this.f3873) {
                    SearchResultsFrag.this.f3891 = i;
                }
                new Handler().postDelayed(new Runnable() { // from class: com.netflix.mediaclient.ui.search.SearchResultsFrag.If.3
                    @Override // java.lang.Runnable
                    public void run() {
                        View childAt = r7.getChildAt(i);
                        if (childAt != null) {
                            childAt.performClick();
                        }
                    }
                }, 300);
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private void m2897(Bundle bundle) {
            if (bundle != null && bundle.containsKey("instance_state_query")) {
                String string = bundle.getString("instance_state_query");
                if (string == null) {
                    string = "";
                }
                SearchResultsFrag.this.f3882 = string;
            }
        }

        /* renamed from: ʻ  reason: contains not printable characters */
        private void m2891(Bundle bundle) {
            Parcelable[] parcelableArray;
            if (!(bundle == null || !bundle.containsKey("instance_state__click_history") || (parcelableArray = bundle.getParcelableArray("instance_state__click_history")) == null || parcelableArray.length == 0)) {
                ArrayList arrayList = new ArrayList(parcelableArray.length);
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((C2386zs) parcelable);
                }
                if (arrayList.size() > 0 && SearchResultsFrag.this.f3872 != null) {
                    SearchResultsFrag.this.f3872.addAll(arrayList);
                }
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m2893(Bundle bundle, final C0810 r7, String str) {
            final int i;
            if (bundle != null && r7 != null && bundle.containsKey(str) && (i = bundle.getInt(str, -1)) != -1) {
                if (r7 == SearchResultsFrag.this.f3887) {
                    SearchResultsFrag.this.f3891 = i;
                }
                new Handler().postDelayed(new Runnable() { // from class: com.netflix.mediaclient.ui.search.SearchResultsFrag.If.2
                    @Override // java.lang.Runnable
                    public void run() {
                        r7.performItemClick(r7.getChildAt(i), i, r7.getAdapter().getItemId(i));
                    }
                }, 300);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public void m2901(Bundle bundle) {
            m2898(bundle);
            m2899(bundle);
            m2892(bundle);
        }

        /* renamed from: ʽ  reason: contains not printable characters */
        private void m2892(Bundle bundle) {
            if (C1349Bv.m4107(SearchResultsFrag.this.f3882)) {
                bundle.putString("instance_state_query", SearchResultsFrag.this.f3882);
            }
        }

        /* renamed from: ᐝ  reason: contains not printable characters */
        private void m2899(Bundle bundle) {
            C2386zs[] zsVarArr;
            if (SearchResultsFrag.this.f3872.size() > 0 && (zsVarArr = (C2386zs[]) SearchResultsFrag.this.f3872.toArray(new C2386zs[SearchResultsFrag.this.f3872.size()])) != null && zsVarArr.length > 0) {
                bundle.putParcelableArray("instance_state__click_history", zsVarArr);
            }
        }

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private void m2898(Bundle bundle) {
            if (SearchResultsFrag.this.f3891 != -1) {
                bundle.putInt("instance_state_suggestions_selected_pos", SearchResultsFrag.this.f3891);
            }
        }
    }
}
