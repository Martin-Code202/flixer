package o;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
import java.util.List;
import o.C2215uo;
public class tF extends C2215uo<AbstractC2074pw> {
    public tF(Context context, pC pCVar, LolomoRecyclerViewAdapter lolomoRecyclerViewAdapter, AbstractC0954 r4, int i) {
        super(context, pCVar, lolomoRecyclerViewAdapter, r4, i);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2195ty
    /* renamed from: ˊ */
    public void mo10892(Context context, C2059ph phVar, int i, int i2, oU oUVar, Intent intent) {
        phVar.m9764().mo9489(i, i2, m11288().mo10878() == null ? null : m11288().mo10878().getId(), oUVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public long mo10898(AbstractC2074pw pwVar) {
        return (((((super.mo10898((tF) pwVar) * 1000003) ^ ((long) pwVar.getPlayableBookmarkPosition())) * 1000003) ^ (pwVar.getCurrentEpisodeTitle() == null ? 0 : (long) pwVar.getCurrentEpisodeTitle().hashCode())) * 1000003) ^ (pwVar.getInterestingUrl() == null ? 0 : (long) pwVar.getInterestingUrl().hashCode());
    }

    @Override // o.AbstractC2195ty, android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @Override // o.AbstractC2195ty
    /* renamed from: ͺ */
    public int mo10896() {
        return 1;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2215uo
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo10899(C2215uo.AbstractC0235 r2, pJ pJVar, int i, boolean z) {
        r2.mo10906(m11288(), pJVar, i, z);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2215uo
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo10900(C2215uo.AbstractC0235 r3, int i, boolean z) {
        ((C0210) r3).m10905(m11288(), i, z);
    }

    @Override // o.C2215uo
    /* renamed from: ॱ */
    public C2215uo.AbstractC0235 onCreateViewHolder(ViewGroup viewGroup, int i) {
        uC uCVar = new uC(viewGroup.getContext());
        uCVar.setId(R.id.continue_watching_view);
        return new C0210(viewGroup, uCVar, m15489());
    }

    /* access modifiers changed from: protected */
    @Override // o.C2215uo, o.AbstractC2195ty
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo10902(List<AbstractC2074pw> list) {
        super.mo10902(list);
        if (list != null) {
            NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(m15486(), NetflixActivity.class);
            if (!C1322Av.m3793(netflixActivity)) {
                int i = 0;
                while (i < list.size() && i < 3) {
                    netflixActivity.playerPrepare(list.get(i), PlayerPrefetchSource.ContinueWatching, new qN(m11288().mo10878(), i));
                    i++;
                }
            }
        }
    }

    @Override // o.AbstractC0837
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean mo10904() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.tF$ˋ  reason: contains not printable characters */
    public static class C0210 extends C2215uo.AbstractC0235 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final C0489 f10326;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final uC f10327;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final FrameLayout f10328 = ((FrameLayout) this.itemView);

        C0210(ViewGroup viewGroup, uC uCVar, AbstractC0954 r8) {
            super(viewGroup, new FrameLayout(viewGroup.getContext()), r8);
            this.f10327 = uCVar;
            this.f10326 = new C0489(viewGroup.getContext());
            this.f10328.addView(this.f10327, new FrameLayout.LayoutParams(-1, -1));
            this.f10328.addView(this.f10326, new FrameLayout.LayoutParams(-2, -2));
            ((FrameLayout.LayoutParams) this.f10326.getLayoutParams()).gravity = 17;
        }

        @Override // o.tT.AbstractC0216
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo10906(tU tUVar, AbstractC2072pu puVar, int i, boolean z) {
            super.mo10906(tUVar, puVar, i, false);
            this.f10326.setVisibility(8);
            this.f10327.setVisibility(0);
            this.f10327.mo2123((AbstractC2074pw) puVar, (AbstractC2087qh) tUVar.mo10878(), i, z, false);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m10905(tU tUVar, int i, boolean z) {
            this.f10327.setVisibility(8);
            this.f10326.setVisibility(0);
        }
    }
}
