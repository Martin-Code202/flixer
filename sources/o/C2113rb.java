package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.util.ViewUtils;
@SuppressLint({"ViewConstructor"})
/* renamed from: o.rb  reason: case insensitive filesystem */
public class C2113rb extends qO {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    View.OnClickListener f9815;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected pI f9816;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    pF f9817;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected C0522 f9818;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private View.OnClickListener f9819 = new View.OnClickListener() { // from class: o.rb.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2113rb.this.f9816 != null && C2113rb.this.f9816.isAvailableToStream()) {
                C2113rb.this.m9938(C2113rb.this.f9816);
            }
        }
    };

    public C2113rb(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    @Override // o.qO
    /* renamed from: ˊ */
    public void mo9935(pI pIVar) {
        if (this.f9529 != null) {
            this.f9816 = pIVar;
            this.f9529.setVisibility(pIVar.isAvailableToStream() ? 0 : 4);
            if (this.f9818 == null || !pIVar.isAvailableToStream()) {
                this.f9529.setOnClickListener(this.f9819);
                return;
            }
            if (this.f9815 == null) {
                this.f9815 = this.f9819;
            }
            this.f9818.setOnClickListener(this.f9815);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.qO
    /* renamed from: ˋ */
    public void mo9937(pF pFVar) {
        if (this.f9537 != null) {
            NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(getContext(), NetflixActivity.class);
            AbstractC1853hl offlineAgentOrNull = NetflixActivity.getOfflineAgentOrNull(netflixActivity);
            if (offlineAgentOrNull == null || netflixActivity == null) {
                ViewUtils.m3002((View) this.f9537, false);
                return;
            }
            this.f9537.setStateFromPlayable(pFVar, netflixActivity);
            pV r4 = vO.m12029(offlineAgentOrNull).mo11976(pFVar.getPlayableId());
            if (r4 != null && vO.m12027(r4)) {
                ViewUtils.m3002((View) this.f9529, false);
            }
        }
    }

    /* renamed from: ˋ */
    public void mo10086(pI pIVar, pR pRVar) {
        this.f9817 = pIVar.getPlayable();
        super.m9941(pIVar, pRVar != null && C1349Bv.m4126(pIVar.getId(), pRVar.getCurrentEpisodeId()));
    }
}
