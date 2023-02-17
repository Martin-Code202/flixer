package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.UiLocation;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
import com.netflix.model.leafs.FlatGenreListOfVideosSummary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o.AbstractC0835;
import o.AbstractC0837;
import o.AbstractC0837.AbstractC0838;
import o.C1348Bu;
import o.oA;
import o.pJ;
/* renamed from: o.ty  reason: case insensitive filesystem */
public abstract class AbstractC2195ty<T extends AbstractC0837.AbstractC0838, O extends pJ> extends AbstractC0837<T> {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final List<O> f10636;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C2059ph f10637;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f10638;

    /* renamed from: ˊ  reason: contains not printable characters */
    private iF f10639;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final BroadcastReceiver f10640;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f10641;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f10642;

    /* renamed from: ͺ  reason: contains not printable characters */
    private BroadcastReceiver f10643;

    /* renamed from: ॱ  reason: contains not printable characters */
    private tU f10644;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f10645;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f10646;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final LolomoRecyclerViewAdapter f10647;

    /* renamed from: o.ty$iF */
    public interface iF {
        /* renamed from: ˊ */
        void mo2051(AbstractC2195ty tyVar);

        /* renamed from: ˊ */
        void mo2052(AbstractC2195ty tyVar, int i);

        /* renamed from: ˎ */
        void mo2056(AbstractC2195ty tyVar, int i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public abstract void mo10900(T t, int i, boolean z);

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public abstract void mo10910(T t, O o2, int i, boolean z);

    AbstractC2195ty(Context context, pC pCVar, LolomoRecyclerViewAdapter lolomoRecyclerViewAdapter, AbstractC0954 r6, int i) {
        super(context, r6, i);
        this.f10642 = false;
        this.f10641 = false;
        this.f10639 = null;
        this.f10636 = new ArrayList();
        this.f10646 = 0;
        this.f10638 = false;
        this.f10645 = false;
        this.f10643 = null;
        this.f10640 = new BroadcastReceiver() { // from class: o.ty.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, final Intent intent) {
                C1283.m16854("BaseListAdapter", "onReceive...");
                final NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(AbstractC2195ty.this.m15486(), NetflixActivity.class);
                if (netflixActivity != null && !C1322Av.m3793(netflixActivity)) {
                    netflixActivity.runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.ty.4.3
                        @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                        public void run(C2059ph phVar) {
                            AbstractC2195ty.this.m11278(netflixActivity, phVar, intent);
                        }
                    });
                }
            }
        };
        this.f10647 = lolomoRecyclerViewAdapter;
        this.f10637 = lolomoRecyclerViewAdapter.m2046();
        this.f10644 = tU.m11035().mo10880(lolomoRecyclerViewAdapter.m2048()).mo10882(pCVar).mo10884(i).mo10881(i).mo10879(lolomoRecyclerViewAdapter.m2059()).mo10883();
        m11290(this.f10647);
        setHasStableIds(true);
    }

    AbstractC2195ty(Context context, pC pCVar, C2059ph phVar, UiLocation uiLocation, AbstractC0954 r7, int i) {
        super(context, r7, i);
        this.f10642 = false;
        this.f10641 = false;
        this.f10639 = null;
        this.f10636 = new ArrayList();
        this.f10646 = 0;
        this.f10638 = false;
        this.f10645 = false;
        this.f10643 = null;
        this.f10640 = new BroadcastReceiver() { // from class: o.ty.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, final Intent intent) {
                C1283.m16854("BaseListAdapter", "onReceive...");
                final NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(AbstractC2195ty.this.m15486(), NetflixActivity.class);
                if (netflixActivity != null && !C1322Av.m3793(netflixActivity)) {
                    netflixActivity.runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.ty.4.3
                        @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                        public void run(C2059ph phVar) {
                            AbstractC2195ty.this.m11278(netflixActivity, phVar, intent);
                        }
                    });
                }
            }
        };
        this.f10647 = null;
        this.f10637 = phVar;
        this.f10644 = tU.m11035().mo10882(pCVar).mo10884(i).mo10881(0).mo10879(uiLocation).mo10883();
        setHasStableIds(true);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m11290(iF iFVar) {
        this.f10639 = iFVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        if (i < m11286().size()) {
            return mo10898((AbstractC2195ty<T, O>) m11286().get(i));
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public long mo10898(O o2) {
        return ((((1000003 ^ (o2.getId() == null ? 0 : (long) o2.getId().hashCode())) * 1000003) ^ (o2.getTitle() == null ? 0 : (long) o2.getTitle().hashCode())) * 1000003) ^ (o2.getBoxshotUrl() == null ? 0 : (long) o2.getBoxshotUrl().hashCode());
    }

    @Override // o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override // o.AbstractC0837, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʽ  reason: contains not printable characters */
    public tU m11288() {
        return this.f10644;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11296(tU tUVar) {
        this.f10644 = tUVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m11298(boolean z) {
        this.f10638 = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public final boolean m11287() {
        return this.f10638;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public pC m11301() {
        return this.f10644.mo10878();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int m11274() {
        return this.f10646;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11281(int i) {
        this.f10646 = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public List<O> m11286() {
        return this.f10636;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo11289(List<O> list) {
        this.f10636.addAll(list);
        if (this.f10642) {
            this.f10642 = false;
            m11284();
        }
    }

    @Override // o.AbstractC0837
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo11294(View view) {
        C2059ph phVar = this.f10637;
        if (phVar != null) {
            m11286().clear();
            m11281(0);
            notifyDataSetChanged();
            m11282(view.getContext(), phVar);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0837
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo11291(AbstractC0835.AbstractC2404iF iFVar) {
        C2059ph phVar;
        if (!this.f10645 && (phVar = this.f10637) != null) {
            m11282(iFVar.itemView.getContext(), phVar);
            this.f10645 = true;
        }
        if (!this.f10641) {
            if (!m11286().isEmpty()) {
                m11284();
            } else {
                this.f10642 = true;
            }
            this.f10641 = true;
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m11284() {
        C1283.m16851("BaseListAdapter", "Sending prefetch details request for %s videos in '%s' row", Integer.valueOf(m11286().size()), m11301().getTitle());
        qX.m10006(this.f10637, m11286());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ */
    public int mo10894(Context context, int i) {
        return (i + uH.m11414(context, LoMoType.STANDARD)) - 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i < m11286().size()) {
            return 0;
        }
        return 1;
    }

    @Override // o.AbstractC0837
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo11297(T t, int i) {
        boolean z = i <= m15489().mo15082();
        if (i < m11286().size()) {
            mo10910((AbstractC2195ty<T, O>) t, (T) m11286().get(i), i, z);
            return;
        }
        mo10900(t, i, z);
        C2059ph phVar = this.f10637;
        if (phVar != null) {
            m11282(((AbstractC0837.AbstractC0838) t).itemView.getContext(), phVar);
        } else {
            C1276.m16820().mo5725("serviceManager should not be null while binding new data");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11283(Context context, C2059ph phVar, int i, int i2, oU oUVar, Intent intent) {
        if (this.f10639 != null) {
            this.f10639.mo2051(this);
        }
        mo10892(context, phVar, i, i2, oUVar, intent);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo10892(Context context, C2059ph phVar, int i, int i2, oU oUVar, Intent intent) {
        phVar.m9764().mo9472(m11301(), i, i2, false, BrowseExperience.m1780(), false, oUVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public IntentFilter m11292() {
        if (m11301().getRefreshInterval() <= 0) {
            return null;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.netflix.mediaclient.intent.action.BA_LIST_REFRESH");
        intentFilter.addCategory(m11301().getListContext());
        return intentFilter;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public final oU m11295(long j, Context context, C2059ph phVar, int i, int i2) {
        return m11276(j, context, phVar, false, i, i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private oU m11276(final long j, final Context context, C2059ph phVar, final boolean z, int i, int i2) {
        return new oA("BaseListAdapter.FetchVideosHandler", new oA.Cif<O>() { // from class: o.ty.2
            @Override // o.oA.Cif
            /* renamed from: ॱ */
            public long mo9391() {
                return j;
            }

            @Override // o.oA.Cif
            /* renamed from: ˋ */
            public void mo9388(String str, int i3, int i4) {
                mo9390(Collections.emptyList(), str, i3, i4);
            }

            @Override // o.oA.Cif
            /* renamed from: ˎ */
            public void mo9389() {
                AbstractC2195ty.this.m11298(false);
                if (AbstractC2195ty.this.m11286().size() == 0 && AbstractC2195ty.this.f10639 != null) {
                    AbstractC2195ty.this.f10639.mo2052(AbstractC2195ty.this, AbstractC2195ty.this.m15482());
                }
            }

            @Override // o.oA.Cif
            /* renamed from: ˋ */
            public void mo9387(FlatGenreListOfVideosSummary flatGenreListOfVideosSummary) {
                AbstractC2195ty.this.mo10893(flatGenreListOfVideosSummary);
            }

            @Override // o.oA.Cif
            /* renamed from: ˎ */
            public void mo9390(List<O> list, String str, int i3, int i4) {
                if (list != null) {
                    if (!C1317As.m3750(context)) {
                        int size = AbstractC2195ty.this.m11286().size();
                        if (z) {
                            AbstractC2195ty.this.m11286().clear();
                        }
                        AbstractC2195ty.this.mo10902(list);
                        AbstractC2195ty.this.mo11289(list);
                        C1276.m16820().mo5728("loadData." + AbstractC2195ty.this.m11301().getType() + ".notifyDataSetChanged " + size + "," + AbstractC2195ty.this.m11286().size() + "," + AbstractC2195ty.this.mo10896());
                        AbstractC2195ty.this.notifyDataSetChanged();
                        AbstractC2195ty.this.m11281(AbstractC2195ty.this.m11286().size());
                        if (AbstractC2195ty.this.f10639 != null) {
                            AbstractC2195ty.this.f10639.mo2056(AbstractC2195ty.this, AbstractC2195ty.this.m15482());
                        }
                        if (z && AbstractC2195ty.this.m11299()) {
                            final RecyclerView r5 = AbstractC2195ty.this.m15481();
                            final LinearLayoutManager r6 = AbstractC2195ty.this.m15491();
                            if (!(r5 == null || r6 == null)) {
                                C1348Bu.If.m4098(new Runnable() { // from class: o.ty.2.5
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (!C1317As.m3750(r5.getContext())) {
                                            r6.scrollToPosition(0);
                                        }
                                    }
                                });
                            }
                        }
                        if (AbstractC2195ty.this.f10647 != null && ((AbstractC2195ty.this.mo10904() && size == 0) || AbstractC2195ty.this.m11286().size() == 0)) {
                            AbstractC2195ty.this.f10647.notifyItemChanged(AbstractC2195ty.this.m15482());
                        }
                    } else {
                        C1283.m16854("BaseListAdapter", "Ignoring callback, activity finished");
                    }
                }
                AbstractC2195ty.this.m11298(false);
            }
        }, m11301().getTitle(), i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo10893(FlatGenreListOfVideosSummary flatGenreListOfVideosSummary) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public void mo10902(List<O> list) {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11282(Context context, C2059ph phVar) {
        if (!m11287() && context != null) {
            long nanoTime = System.nanoTime();
            m11298(true);
            int r14 = m11274();
            int r15 = mo10894(context, m11274());
            m11283(context, phVar, r14, r15, m11295(nanoTime, context, phVar, r14, r15), null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m11278(final Context context, final C2059ph phVar, final Intent intent) {
        if (!m11287()) {
            m11298(true);
            phVar.m9764().mo9491(m11288().mo10876(), m15482(), m15482(), new oP("BaseListAdapter") { // from class: o.ty.1
                @Override // o.oP, o.oU
                public void onLoMosFetched(List<pC> list, Status status) {
                    super.onLoMosFetched(list, status);
                    if (status.mo298() && list.size() == 1) {
                        pC pCVar = list.get(0);
                        if (TextUtils.equals(AbstractC2195ty.this.f10644.mo10878().getListContext(), pCVar.getListContext())) {
                            AbstractC2195ty.this.m11296(AbstractC2195ty.this.f10644.m11036(list.get(0)));
                            long nanoTime = System.nanoTime();
                            int r12 = AbstractC2195ty.this.mo10894(context, 0);
                            AbstractC2195ty.this.m11283(context, phVar, 0, r12, AbstractC2195ty.this.m11276(nanoTime, context, phVar, true, 0, r12), intent);
                            return;
                        }
                        AbstractC2195ty.this.m11298(false);
                        C1283.m16851("BaseListAdapter", "Ignoring list retrieved at index %s, was expecting %s but got %s", Integer.valueOf(AbstractC2195ty.this.m15482()), AbstractC2195ty.this.f10644.mo10878().getType(), pCVar.getType());
                    }
                }
            });
        }
        return m11287();
    }

    @Override // o.AbstractC0837
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo11293(Context context) {
        super.mo11293(context);
        IntentFilter r2 = m11292();
        if (r2 != null) {
            C1283.m16854("BaseListAdapter", "Register receiver...");
            context.registerReceiver(this.f10640, r2);
            this.f10643 = this.f10640;
        }
    }

    @Override // o.AbstractC0837
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo11300(Context context) {
        if (this.f10643 != null) {
            C1283.m16854("BaseListAdapter", "Unregister receiver...");
            context.unregisterReceiver(this.f10643);
            this.f10643 = null;
        }
        super.mo11300(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ͺ */
    public int mo10896() {
        return Math.min(m15489().mo15082(), 3);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.min(this.f10644.mo10878().getNumVideos(), m11286().size() + mo10896());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public boolean m11299() {
        return true;
    }
}
