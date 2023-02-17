package o;

import android.view.View;
import android.widget.AdapterView;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.List;
import o.AbstractC0459;
import o.AbstractC0801;
/* renamed from: o.rh  reason: case insensitive filesystem */
public class C2119rh extends AbstractC0801 implements AbstractC0459, AdapterView.OnItemClickListener {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected AbstractC0459.AbstractC0460 f9881;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected boolean f9882;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected boolean f9883;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected int f9884;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final C2116re f9885;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected pS f9886;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected long f9887;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final NetflixActivity f9888;

    public C2119rh(NetflixActivity netflixActivity, C2116re reVar, AbstractC0801.Cif ifVar) {
        super(ifVar);
        C1348Bu.m4093();
        this.f9888 = netflixActivity;
        this.f9885 = reVar;
        mo10423();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return (long) i;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0801
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo10425(int i) {
        if (this.f9883 && i == getItemCount() - 20) {
            mo10424();
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return this.f9882;
    }

    @Override // o.AbstractC0459
    public void setLoadingStatusCallback(AbstractC0459.AbstractC0460 r2) {
        if (isLoadingData() || r2 == null) {
            this.f9881 = r2;
        } else {
            r2.mo1654(AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m10428(Status status) {
        if (this.f9881 != null) {
            this.f9881.mo1654(status);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m10429(pS pSVar) {
        if (pSVar != null) {
            this.f9886 = pSVar;
            mo10423();
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void mo10424() {
        C2059ph phVar = null;
        if (this.f9885 != null) {
            phVar = this.f9885.m14474();
        }
        if (phVar == null || !phVar.mo9519()) {
            C1283.m16854("EpisodesAdapter", "Manager is not ready");
        } else if (this.f9886 == null) {
            C1283.m16846("EpisodesAdapter", "No season details yet");
        } else {
            this.f9887 = System.nanoTime();
            if (this.f9884 >= this.f9886.getNumOfEpisodes()) {
                C1283.m16865("EpisodesAdapter", "nothing more to fetch");
                this.f9883 = false;
                return;
            }
            int i = (this.f9884 + 40) - 1;
            if (i >= this.f9886.getNumOfEpisodes()) {
                i = this.f9886.getNumOfEpisodes() - 1;
            }
            String id = this.f9886.getId();
            if (C1349Bv.m4113(id)) {
                m10426(this.f9886);
            } else {
                phVar.m9764().mo9510(id, CmpTaskMode.FROM_CACHE_OR_NETWORK, VideoType.SEASON, this.f9884, i, new C0183(this.f9887, this.f9884, i));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m10426(pS pSVar) {
        AR.m3409(this.f9888.getServiceManager().m9825(), this.f9885.m10385(), pSVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m10422(Status status) {
        C1283.m16854("EpisodesAdapter", "onFetchError()");
        notifyDataSetChanged();
        this.f9885.m10379(status);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public void mo10423() {
        C1283.m16846("EpisodesAdapter", "initToLoadingState");
        this.f9882 = true;
        this.f9883 = true;
        this.f9887 = -1;
        this.f9884 = 0;
        mo10424();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public void mo10349(List<pI> list, int i) {
        C1283.m16846("EpisodesAdapter", "Adding episodes, count: " + list.size());
        m15315(list, i);
        this.f9884 += list.size();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m10427(pR pRVar) {
        this.f14519 = pRVar;
    }

    /* renamed from: o.rh$ˊ  reason: contains not printable characters */
    public class C0183 extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final int f9889;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final int f9891;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final long f9892;

        public C0183(long j, int i, int i2) {
            super("EpisodesAdapter");
            this.f9892 = j;
            this.f9891 = (i2 - i) + 1;
            this.f9889 = i;
        }

        @Override // o.oP, o.oU
        public void onEpisodesFetched(List<pI> list, Status status) {
            super.onEpisodesFetched(list, status);
            if (!C1317As.m3750(C2119rh.this.f9888)) {
                if (this.f9892 != C2119rh.this.f9887) {
                    C1283.m16846("EpisodesAdapter", "Ignoring stale request");
                    return;
                }
                C2119rh.this.f9883 = true;
                C2119rh.this.f9882 = false;
                C2119rh.this.m10428(status);
                if (status.mo301()) {
                    C1283.m16865("EpisodesAdapter", "Invalid status code");
                    C2119rh.this.m10422(status);
                } else if (list == null || list.size() == 0) {
                    C1283.m16846("EpisodesAdapter", "No details in response");
                    C2119rh.this.f9883 = false;
                    C2119rh.this.notifyDataSetChanged();
                    C2119rh.this.m10422(AbstractC0367.f13245);
                } else {
                    if (list.size() < this.f9891) {
                        C2119rh.this.f9883 = false;
                    }
                    C2119rh.this.mo10349(list, this.f9889);
                    C2119rh.this.f9885.m10371();
                    C2119rh.this.f9885.m10389(list);
                    C2119rh.this.f9885.m10381(AB.m3275(list));
                }
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }
}
