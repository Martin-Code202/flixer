package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.PostPlayItem;
import o.xJ;
public final class wP extends wR {

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f11503;

    /* renamed from: ˊ  reason: contains not printable characters */
    private wL f11504;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f11505;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Button f11506;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Button f11507;

    /* renamed from: ॱ  reason: contains not printable characters */
    private IPlayerFragment f11508;

    public wP(Context context) {
        this(context, null);
    }

    public wP(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public wP(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11503 = false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12344() {
        if (this.f11505 == 0) {
            this.f11506.animate().alpha(0.0f);
            this.f11507.animate().alpha(0.0f);
            if (this.f11503) {
                this.f11504.m12337(true);
                return;
            }
            return;
        }
        this.f11507.setAlpha(1.0f);
        this.f11506.setAlpha(1.0f);
        this.f11506.setText(getResources().getString(R.string.label_postplay_seamless_next, Integer.valueOf(this.f11505)));
    }

    /* access modifiers changed from: protected */
    @Override // o.wR
    /* renamed from: ˏ */
    public void mo12339() {
        this.f11507 = (Button) findViewById(R.id.watch_credit);
        this.f11506 = (Button) findViewById(R.id.post_play_play_button);
        this.f11507.setOnClickListener(new View.OnClickListener() { // from class: o.wP.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == wP.this.f11507) {
                    wP.this.f11503 = true;
                    if (wP.this.f11508.mo2226() != null) {
                        wP.this.f11508.mo2226().mo12460(true);
                    }
                    if (C0910.m15708() && wP.this.f11508 != null && wP.this.f11508.mo2251() != null) {
                        wP.this.f11508.mo2251().onNext(xJ.AUx.f12011);
                    }
                }
            }
        });
    }

    @Override // o.wR
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo12347(int i) {
        this.f11505 = i;
        m12344();
    }

    /* access modifiers changed from: protected */
    @Override // o.wR
    /* renamed from: ˏ */
    public void mo12340(int i) {
        this.f11505 = i;
        if (!(this.f11504 == null || !this.f11508.m2250() || this.f11508.mo2226() == null || this.f11508.mo2226().m12508() == null)) {
            this.f11508.mo2226().m12508().m12892();
        }
        m12344();
    }

    /* access modifiers changed from: protected */
    @Override // o.wR
    /* renamed from: ˎ */
    public void mo12338() {
        this.f11507.setVisibility(4);
    }

    @Override // o.wR
    /* renamed from: ˏ */
    public void mo12341(PostPlayItem postPlayItem, NetflixActivity netflixActivity, IPlayerFragment iPlayerFragment, PlayLocationType playLocationType, View.OnClickListener onClickListener) {
        this.f11508 = iPlayerFragment;
        if (postPlayItem.getPlayAction() != null) {
            this.f11504 = new wL(netflixActivity, iPlayerFragment, postPlayItem.getPlayAction(), playLocationType, this.f11506);
        }
    }
}
