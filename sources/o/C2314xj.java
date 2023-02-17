package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.FragmentActivity;
import android.util.TypedValue;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import o.C2275wq;
/* renamed from: o.xj  reason: case insensitive filesystem */
public final class C2314xj extends C2312xh {

    /* renamed from: ᐝ  reason: contains not printable characters */
    private ConstraintLayout f12192;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2314xj(PlayerFragment playerFragment, View view, C2275wq.C0256 r4) {
        super(playerFragment, view, r4);
        C1457Fr.m5025(playerFragment, "fragment");
        C1457Fr.m5025(view, "playerView");
    }

    /* access modifiers changed from: protected */
    @Override // o.C2312xh
    /* renamed from: ˎ */
    public void mo12934(View view) {
        C1457Fr.m5025(view, "playerView");
        super.mo12934(view);
        View findViewById = view.findViewById(R.id.background);
        C1457Fr.m5016((Object) findViewById, "playerView.findViewById(R.id.background)");
        this.f12192 = (ConstraintLayout) findViewById;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2312xh, o.C2306xb
    /* renamed from: ˊ */
    public void mo12887(boolean z) {
        super.mo12887(z);
        this.f12172.m12591(this.f12128, z, false, -1.0f, z ? null : this.f12171);
        this.f12172.m12591(this.f12173, z, false, -1.0f, null);
        this.f12172.m12591(this.f12180, z, false, -1.0f, null);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2312xh
    /* renamed from: ˏ */
    public void mo12935(PlayerFragment playerFragment) {
        C1457Fr.m5025(playerFragment, "context");
        super.mo12935(playerFragment);
        PlayerFragment playerFragment2 = this.f11438;
        C1457Fr.m5016((Object) playerFragment2, "playerFragment");
        FragmentActivity activity = playerFragment2.getActivity();
        if (activity != null) {
            C1457Fr.m5016((Object) activity, "it");
            Resources resources = activity.getResources();
            C1457Fr.m5016((Object) resources, "it.resources");
            Configuration configuration = resources.getConfiguration();
            C1457Fr.m5016((Object) configuration, "it.resources.configuration");
            m12938(configuration);
        }
    }

    @Override // o.C2306xb
    /* renamed from: ˊ */
    public void mo12885(Configuration configuration) {
        C1457Fr.m5025(configuration, "newConfig");
        super.mo12885(configuration);
        m12938(configuration);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m12938(Configuration configuration) {
        int i;
        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintLayout constraintLayout = this.f12192;
        if (constraintLayout == null) {
            C1457Fr.m5017("mainLayout");
        }
        constraintSet.clone(constraintLayout);
        constraintSet.clear(R.id.player_title_label, 3);
        constraintSet.clear(R.id.player_title_label, 4);
        constraintSet.clear(R.id.player_title_label, 6);
        constraintSet.clear(R.id.player_title_label, 7);
        switch (configuration.orientation) {
            case 2:
                i = 0;
                constraintSet.connect(R.id.player_title_label, 3, R.id.top_bar_guideline, 3);
                constraintSet.connect(R.id.player_title_label, 4, R.id.top_bar_guideline, 4);
                constraintSet.connect(R.id.player_title_label, 6, R.id.player_back_button, 7);
                constraintSet.connect(R.id.player_title_label, 7, R.id.player_cast_button_end, 6);
                break;
            default:
                C1281 r7 = C1281.f15992;
                Resources resources = ((Context) C1281.m16832(Context.class)).getResources();
                C1457Fr.m5016((Object) resources, "Lookup.get<Context>().resources");
                i = (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics());
                constraintSet.connect(R.id.player_title_label, 4, R.id.video_top, 3);
                constraintSet.connect(R.id.player_title_label, 6, 0, 6);
                constraintSet.connect(R.id.player_title_label, 7, 0, 7);
                break;
        }
        ConstraintLayout constraintLayout2 = this.f12192;
        if (constraintLayout2 == null) {
            C1457Fr.m5017("mainLayout");
        }
        constraintSet.applyTo(constraintLayout2);
        C1004.m15959(this.f12128, 3, i);
    }
}
