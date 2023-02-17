package o;

import android.annotation.TargetApi;
import android.view.View;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.ui.player.PostPlayFactory;
import o.C2275wq;
@TargetApi(16)
/* renamed from: o.wn  reason: case insensitive filesystem */
public class C2272wn extends C2275wq {
    C2272wn(PlayerFragment playerFragment, View view, C2275wq.C0256 r5, PostPlayFactory.PostPlayType postPlayType) {
        super(playerFragment, view, r5, postPlayType);
        if (!this.f11654.mo2241()) {
            playerFragment.m2498().getDecorView().setSystemUiVisibility(1792);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ˊ  reason: contains not printable characters */
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
    /* renamed from: ˋˊ  reason: contains not printable characters */
    public void mo12436() {
        C1283.m16854("screen", "hide nav JB");
        this.f11654.m2498().getDecorView().setSystemUiVisibility(1795);
        m12488();
    }

    /* access modifiers changed from: package-private */
    @Override // o.C2275wq
    /* renamed from: ˋᐝ  reason: contains not printable characters */
    public void mo12437() {
        C1283.m16854("screen", "show nav JB");
        this.f11654.m2498().getDecorView().setSystemUiVisibility(1792);
    }
}
