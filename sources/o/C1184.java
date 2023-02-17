package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.model.leafs.advisory.Advisory;
import com.netflix.model.leafs.advisory.ExpiringContentAdvisory;
@Deprecated
/* renamed from: o.ﺔ  reason: contains not printable characters */
public class C1184 extends C1245 {

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private PlayerFragment f15544;

    protected C1184(NetflixActivity netflixActivity, Advisory advisory) {
        super(netflixActivity, advisory);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m16441(PlayerFragment playerFragment) {
        this.f15544 = playerFragment;
    }

    @Override // o.C1245, o.AbstractC1180
    /* renamed from: ᐝ */
    public void mo16431() {
        super.mo16431();
        if (C2275wq.m12478(this.f15544) && this.f15544.mo2268() != null) {
            this.f15544.m14536().m9764().mo9473(this.f15544.mo2268().getPlayableId(), ExpiringContentAdvisory.ContentAction.NEVER_SHOW_AGAIN);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C1245, o.AbstractC1180
    /* renamed from: ˏॱ */
    public void mo16427() {
        super.mo16427();
        if (C2275wq.m12478(this.f15544) && this.f15544.mo2268() != null) {
            this.f15544.m14536().m9764().mo9473(this.f15544.mo2268().getPlayableId(), ExpiringContentAdvisory.ContentAction.LOG_WHEN_SHOWN);
        }
    }
}
