package o;

import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.ui.player.PostPlayFactory;
import java.util.HashMap;
import o.C2275wq;
public final class wA extends wB {

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public static final C0249 f11408 = new C0249(null);

    /* renamed from: ˍ  reason: contains not printable characters */
    private HashMap f11409;

    @Override // android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        m12253();
    }

    /* renamed from: ՙ  reason: contains not printable characters */
    public void m12253() {
        if (this.f11409 != null) {
            this.f11409.clear();
        }
    }

    /* renamed from: o.wA$ˋ  reason: contains not printable characters */
    public static final class C0249 {
        private C0249() {
        }

        public /* synthetic */ C0249(C1456Fq fq) {
            this();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final PlayerFragment m12254(String str, VideoType videoType, oX oXVar, int i, int i2) {
            C1457Fr.m5025(str, "videoId");
            C1457Fr.m5025(videoType, "videoType");
            C1457Fr.m5025(oXVar, "playContext");
            wA wAVar = new wA();
            wAVar.setArguments(PlayerFragment.m2410(str, videoType, oXVar, i, i2));
            return wAVar;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.wB, com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ˏ */
    public int mo2492(PostPlayFactory.PostPlayType postPlayType) {
        return R.layout.playout_ab9426;
    }

    /* access modifiers changed from: protected */
    @Override // o.wB, com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ˋ */
    public C2275wq mo2474(C2275wq.C0256 r5, PostPlayFactory.PostPlayType postPlayType) {
        C1457Fr.m5025(r5, "listeners");
        C1457Fr.m5025(postPlayType, "postPlayType");
        View view = getView();
        if (view != null) {
            C1457Fr.m5016((Object) view, "playerView");
            return C2281ww.f11717.m12579(this, view, r5, postPlayType);
        }
        throw new IllegalStateException("Tried to instantiate PlayScreen when fragment view was null");
    }
}
