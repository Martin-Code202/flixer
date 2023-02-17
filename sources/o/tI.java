package o;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import java.util.ArrayList;
import java.util.List;
import o.C0567;
public class tI extends AbstractC0517 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final C0567.Cif f10364 = new C0567.Cif() { // from class: o.tI.3
        @Override // o.C0567.Cif
        public void N_() {
            tI.this.m10949();
            tI.this.m10947();
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    private ListView f10365;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f10366;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0616 f10367;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C0212 f10368;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.generes_layout, viewGroup, false);
        this.f10367 = new C0616(inflate.findViewById(R.id.genres_frame), this.f10364);
        this.f10365 = (ListView) inflate.findViewById(R.id.genres_list_view);
        m10947();
        return inflate;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10947() {
        if (!m10953() && !this.f10366) {
            this.f10366 = true;
            C1283.m16846("GenresListFragment", "Fetching genres list...");
            m14536().m9764().mo9493(new Cif());
        }
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        m10947();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean m10953() {
        if (m14536() != null && m14536().mo9519()) {
            return false;
        }
        C1283.m16846("GenresListFragment", "Manager is not ready - can't update");
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺ  reason: contains not printable characters */
    private void m10950() {
        this.f10367.mo14660(false);
        BQ.m3909(this.f10365, false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m10949() {
        this.f10367.mo14570(false);
        BQ.m3909(this.f10365, true);
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.tI$if  reason: invalid class name */
    public class Cif extends oP {
        Cif() {
            super("GenresListFragment");
        }

        @Override // o.oP, o.oU
        public void onGenreListsFetched(List<GenreList> list, Status status) {
            super.onGenreListsFetched(list, status);
            tI.this.f10366 = false;
            if (tI.this.m14535()) {
                if (status.mo301()) {
                    C1283.m16865("GenresListFragment", "Invalid status code for genres fetch");
                    tI.this.m10950();
                } else if (list == null || list.size() < 1) {
                    C1283.m16846("GenresListFragment", "No genres in response");
                    tI.this.m10950();
                    C1276.m16820().mo5727("SPY-7985 - GenresListAdapter got null or empty genres list: " + (list == null ? "null" : String.valueOf(list.size())));
                } else {
                    tI.this.m10945(list);
                }
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m10954(boolean z) {
        if (this.f10365 == null) {
            return;
        }
        if (z) {
            this.f10365.smoothScrollToPosition(0);
        } else if (this.f10365.getCount() > 0) {
            this.f10365.setSelection(0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m10945(List<GenreList> list) {
        this.f10367.mo14663(false);
        this.f10368 = new C0212(getActivity(), list);
        this.f10365.setAdapter((ListAdapter) this.f10368);
        this.f10365.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: o.tI.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ActivityC2153sl.m10769(tI.this.m14534(), tI.this.f10368.getItem(i - tI.this.f10365.getHeaderViewsCount()));
            }
        });
    }

    /* renamed from: o.tI$ˋ  reason: contains not printable characters */
    public static class C0212 extends BaseAdapter {

        /* renamed from: ˋ  reason: contains not printable characters */
        private Activity f10372;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final List<GenreList> f10373 = new ArrayList();

        C0212(Activity activity, List<GenreList> list) {
            this.f10372 = activity;
            this.f10373.addAll(list);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f10373.size();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public GenreList getItem(int i) {
            return this.f10373.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f10372.getLayoutInflater().inflate(R.layout.genre_row, viewGroup, false);
            }
            GenreList r3 = getItem(i);
            if (r3 != null) {
                ((TextView) view).setText(r3.getTitle());
            }
            return view;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0517
    /* renamed from: ˊ */
    public void mo2213(View view) {
        if (this.f10367 != null) {
            this.f10367.mo14659(0, this.f13649 + this.f13651, 0, this.f13650);
        }
        C1004.m15952(this.f10365, 1, this.f13649 + this.f13651);
        C1004.m15952(this.f10365, 3, this.f13650);
    }
}
