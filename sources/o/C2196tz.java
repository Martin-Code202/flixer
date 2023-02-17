package o;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.tT;
/* renamed from: o.tz  reason: case insensitive filesystem */
public class C2196tz extends tT<C0226, AbstractC2070ps> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private oY f10663;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f10664;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ArrayList<C0226> f10665 = new ArrayList<>(2);

    public C2196tz(Context context, pC pCVar, LolomoRecyclerViewAdapter lolomoRecyclerViewAdapter, AbstractC0954 r6, int i) {
        super(context, pCVar, lolomoRecyclerViewAdapter, r6, i);
        this.f10664 = pCVar.getNumVideos();
        m11305(context);
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2195ty
    /* renamed from: ˏ */
    public int mo10894(Context context, int i) {
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo10910(C0226 r7, AbstractC2070ps psVar, int i, boolean z) {
        r7.m11315(m11288(), psVar, m11310(), i, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo10900(C0226 r2, int i, boolean z) {
        r2.m11314(m11288(), i, z);
    }

    @Override // o.AbstractC0837
    /* renamed from: ˏ */
    public void mo10895(RecyclerView recyclerView, int i) {
        RecyclerView r4;
        if (i == 0 && (r4 = m15481()) != null && recyclerView.getLayoutManager() != null && (r4.getParent() instanceof FrameLayout)) {
            boolean isViewPartiallyVisible = recyclerView.getLayoutManager().isViewPartiallyVisible((FrameLayout) r4.getParent(), true, true);
            if (r4.getChildCount() > 0) {
                RecyclerView.ViewHolder childViewHolder = r4.getChildViewHolder(r4.getChildAt(0));
                if (childViewHolder instanceof C0226) {
                    ((C0226) childViewHolder).f10673.setIsInViewPort(isViewPartiallyVisible, m11310());
                }
            }
        }
    }

    @Override // o.AbstractC0837
    /* renamed from: ॱॱ */
    public boolean mo10904() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2195ty
    /* renamed from: ˊ */
    public void mo11289(List<AbstractC2070ps> list) {
        super.mo11289(list);
        if (list != null) {
            final NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(m15486(), NetflixActivity.class);
            if (!C1322Av.m3793(netflixActivity)) {
                C2059ph serviceManager = netflixActivity.getServiceManager();
                for (AbstractC2070ps psVar : list) {
                    if (!(psVar.getBigRowSummary() == null || psVar.getBigRowSummary().getVideo() == null)) {
                        final String motionId = psVar.getBigRowSummary().getVideo().motionId();
                        if (!C1349Bv.m4113(motionId)) {
                            serviceManager.m9764().mo9487(new C0545(), new AbstractC2061pj() { // from class: o.tz.3
                                @Override // o.AbstractC2061pj, o.oU
                                public void onBigRowYellowSquareValueFetched(boolean z, Status status) {
                                    if (!z) {
                                        C2196tz.m11304(netflixActivity, motionId, -1);
                                    }
                                }
                            });
                            serviceManager.m9764().mo9513(motionId, (String) null, new oP("BigRowListAdapter") { // from class: o.tz.4
                                @Override // o.oP, o.oU
                                public void onMovieDetailsFetched(pP pPVar, Status status) {
                                    super.onMovieDetailsFetched(pPVar, status);
                                    if (!C1322Av.m3793(netflixActivity) && pPVar != null && !pPVar.isPreRelease()) {
                                        netflixActivity.playerPrepare(pPVar.getPlayable(), PlayerPrefetchSource.BigRow, new qN(C2196tz.this.m11301().getRequestId(), C2196tz.this.m11301().getTrackId(), C2196tz.this.m11301().getListPos(), 0));
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m11304(NetflixActivity netflixActivity, String str, long j) {
        C1339Bl.m4039(netflixActivity, "shared_prefs_big_row_user", netflixActivity.getServiceManager().m9835());
        C1339Bl.m4039(netflixActivity, "shared_prefs_big_row_video_id", str);
        C1339Bl.m4043(netflixActivity, "shared_prefs_big_row_video_last_playback_time", j);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Pair<String, Long> m11302(NetflixActivity netflixActivity) {
        boolean r4 = C1349Bv.m4126(netflixActivity.getServiceManager().m9835(), C1339Bl.m4045(netflixActivity, "shared_prefs_big_row_user", ""));
        return new Pair<>(r4 ? C1339Bl.m4045(netflixActivity, "shared_prefs_big_row_video_id", "") : "", Long.valueOf(r4 ? C1339Bl.m4044(netflixActivity, "shared_prefs_big_row_video_last_playback_time", -1) : -1));
    }

    @Override // o.AbstractC0837
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo11306(Context context) {
        super.mo11306(context);
        m11305(context);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11305(Context context) {
        NetflixActivity netflixActivity;
        if (this.f10663 == null && (netflixActivity = (NetflixActivity) C1322Av.m3791(context, NetflixActivity.class)) != null) {
            netflixActivity.runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.tz.1
                @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                public void run(C2059ph phVar) {
                    AbstractC2056pe r2 = phVar.m9759();
                    if (r2 != null) {
                        C2196tz.this.f10663 = r2.mo7800();
                    }
                }
            });
        }
    }

    @Override // o.AbstractC0837
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo11308(Context context, boolean z) {
        super.mo11308(context, z);
        if (z) {
            Iterator<C0226> it = this.f10665.iterator();
            while (it.hasNext()) {
                it.next().f10673.m11411();
            }
        }
    }

    @Override // o.AbstractC0837
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo11311(Context context) {
        super.mo11311(context);
        if (this.f10663 != null) {
            Iterator<C0226> it = this.f10665.iterator();
            while (it.hasNext()) {
                it.next().f10673.m11411();
            }
            NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(m15486(), NetflixActivity.class);
            if (netflixActivity != null && netflixActivity.getServiceManager().m9759() != null) {
                netflixActivity.getServiceManager().m9759().mo7802(this.f10663);
                this.f10663 = null;
            }
        }
    }

    @Override // o.AbstractC2195ty, android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 0;
    }

    @Override // o.AbstractC2195ty, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f10664;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0226 onCreateViewHolder(ViewGroup viewGroup, int i) {
        uF uFVar = (uF) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lolomo_bigrow_view, viewGroup, false);
        C0226 r4 = new C0226(viewGroup, uFVar, m15489(), uFVar.getId());
        this.f10665.add(r4);
        return r4;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public oY m11310() {
        return this.f10663;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.tz$ˊ  reason: contains not printable characters */
    public static class C0226 extends tT.AbstractC0216 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final FrameLayout f10672 = ((FrameLayout) this.itemView);

        /* renamed from: ˏ  reason: contains not printable characters */
        private final uF f10673;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final C0489 f10674;

        C0226(ViewGroup viewGroup, uF uFVar, AbstractC0954 r8, int i) {
            super(viewGroup, new FrameLayout(viewGroup.getContext()), r8, i);
            this.f10673 = uFVar;
            this.f10674 = new C0489(viewGroup.getContext());
            this.f10672.addView(this.f10673, new FrameLayout.LayoutParams(-1, -1));
            this.f10672.addView(this.f10674, new FrameLayout.LayoutParams(-2, -2));
            ((FrameLayout.LayoutParams) this.f10674.getLayoutParams()).gravity = 17;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m11314(tU tUVar, int i, boolean z) {
            this.f10673.setVisibility(4);
            this.f10674.setVisibility(0);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m11315(tU tUVar, AbstractC2070ps psVar, oY oYVar, int i, boolean z) {
            super.mo10906(tUVar, psVar, i, z);
            this.f10674.setVisibility(8);
            this.f10673.setVisibility(0);
            this.f10673.m11412(psVar, tUVar.mo10878(), oYVar);
        }

        @Override // o.tT.AbstractC0216, o.AbstractC0837.AbstractC0838
        public void X_() {
            super.X_();
            this.f10673.m11410();
        }
    }
}
