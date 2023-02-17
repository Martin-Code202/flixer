package o;

import android.app.Activity;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.NetflixVideoView;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.ui.player.PlayerUiState;
import com.netflix.mediaclient.ui.player.PostPlayFactory;
import com.netflix.mediaclient.ui.player.ScaleType;
import o.C2275wq;
/* renamed from: o.wt  reason: case insensitive filesystem */
public class C2278wt extends C2275wq {

    /* renamed from: ʿ  reason: contains not printable characters */
    private static final String f11699 = C2278wt.class.getSimpleName();

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private boolean f11700 = true;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected final C0951 f11701;

    C2278wt(PlayerFragment playerFragment, View view, C2275wq.C0256 r4, PostPlayFactory.PostPlayType postPlayType) {
        super(playerFragment, view, r4, postPlayType);
        this.f11677 = r4;
        mo12459(playerFragment, view, r4);
        this.f11701 = (C0951) view.findViewById(R.id.netflix_video_view);
        if (this.f11701 != null) {
            m12543(this.f11701);
        }
        mo12453(PlayerUiState.Loading);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12543(C0951 r2) {
        r2.m15769(this.f11677.f11688);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ˊ */
    public void mo12435(boolean z) {
        super.mo12435(z);
        AbstractC1978mi r1 = this.f11701.m2343();
        if (r1 == null) {
            return;
        }
        if (!z || !this.f11654.mo2241()) {
            r1.mo9028(z);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.C2275wq
    /* renamed from: ᐝॱ */
    public synchronized void mo12536() {
        if (!(this.f11677 == null || this.f11671 == null)) {
            this.f11701.m15768(this.f11677.f11688);
        }
        if (m12508() != null) {
            m12508().mo12118();
        }
        if (this.f11675 != null) {
            this.f11675.mo12118();
        }
        if (this.f11664 != null) {
            this.f11664.m2555();
        }
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    public final NetflixVideoView m12544() {
        return this.f11701;
    }

    /* access modifiers changed from: package-private */
    @Override // o.C2275wq
    /* renamed from: ᐝ */
    public void mo12535(boolean z) {
    }

    /* access modifiers changed from: package-private */
    @Override // o.C2275wq
    /* renamed from: ʻ */
    public void mo12450(boolean z) {
        View view = this.f11652;
        if (view == null) {
            C1283.m16865(f11699, "bufferingOverlay is NULL!");
            return;
        }
        C1283.m16854(f11699, "Subtitles ARE visible");
        if (z) {
            C1283.m16854(f11699, "Display buffering overlay");
            view.setVisibility(0);
            return;
        }
        C1283.m16854(f11699, "Remove buffering overlay");
        view.setVisibility(8);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static C2278wt m12541(PlayerFragment playerFragment, C2275wq.C0256 r5, PostPlayFactory.PostPlayType postPlayType) {
        View view = playerFragment.getView();
        if (view != null) {
            return new C2278wt(playerFragment, view, r5, postPlayType);
        }
        throw new IllegalStateException("Tried to instantiate PlayScreen when fragment view was null");
    }

    @Override // o.C2275wq
    /* renamed from: ˊॱ */
    public void mo12507(boolean z) {
        if (null == this.f11701) {
            return;
        }
        if (z) {
            this.f11701.setScaleType(ScaleType.ZOOM);
        } else {
            this.f11701.setScaleType(ScaleType.CROP);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ˉ */
    public boolean mo12499() {
        return this.f11700 && this.f11701.m15767();
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ᐝ */
    public void mo12534() {
        super.mo12534();
        int color = this.f11654.getResources().getColor(R.color.transparent);
        if (this.f11701 != null) {
            this.f11701.setBackgroundColor(color);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ʼ */
    public void mo12491() {
        super.mo12491();
        int color = this.f11654.getResources().getColor(R.color.transparent);
        if (this.f11665 != null) {
            this.f11665.setBackgroundColor(color);
        }
        if (this.f11701 != null) {
            this.f11701.setBackgroundColor(color);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.C2275wq
    /* renamed from: ˊ */
    public synchronized void mo12453(PlayerUiState playerUiState) {
        super.mo12453(playerUiState);
        if (playerUiState != PlayerUiState.Loading) {
            mo12471(m12496().getActivity());
        }
        if (playerUiState == PlayerUiState.PostPlay) {
            m12542(m12496().getActivity());
        }
    }

    @Override // o.C2275wq
    /* renamed from: ॱ */
    public void mo12471(Activity activity) {
        AD.m3297(activity);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12542(Activity activity) {
        AD.m3302(activity);
    }
}
