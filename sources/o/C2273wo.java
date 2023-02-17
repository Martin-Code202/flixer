package o;

import android.view.View;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.ui.player.PostPlayFactory;
import o.C2275wq;
/* renamed from: o.wo  reason: case insensitive filesystem */
public class C2273wo extends C2275wq {
    C2273wo(PlayerFragment playerFragment, View view, C2275wq.C0256 r3, PostPlayFactory.PostPlayType postPlayType) {
        super(playerFragment, view, r3, postPlayType);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ˊ */
    public void mo12435(boolean z) {
        super.mo12435(z);
        if (!this.f11654.mo2241()) {
            if (z) {
                mo12437();
            } else {
                mo12436();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.C2275wq
    /* renamed from: ˋˊ */
    public void mo12436() {
        if (!this.f11654.mo2241()) {
            this.f11654.m2498().getDecorView().setSystemUiVisibility(7);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.C2275wq
    /* renamed from: ˋᐝ */
    public void mo12437() {
        this.f11654.m2498().getDecorView().setSystemUiVisibility(4);
    }
}
